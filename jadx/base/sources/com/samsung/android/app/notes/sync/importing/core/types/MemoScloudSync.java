package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.SystemClock;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.network.C6840e;
import com.samsung.android.app.notes.sync.p135db.AbstractC6740i;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0005e;
import p002A0.C0006f;
import p042J1.AbstractC0155m;
import p086V.C0322h;
import p087V0.CallableC0323a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MemoScloudSync extends ImportBaseTask {
    private static final String TAG = "MemoScloudSync";
    private static ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(5, 1000, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new SenlThreadFactory(TAG));
    private List<Future<?>> futures;
    private String mAuthorization;
    private ArrayList<C0006f> mCategoryItems;
    private ArrayList<C0006f> mDataItems;
    private C6840e mMemoServiceHelper;
    private boolean mUseConcurrentRequest;
    private ThreadPoolExecutor threadPool;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CategoryItem {
        public String categoryName;
        public String categoryOrder;
        public String serverUUID;

        public CategoryItem(String str, String str2, String str3) {
            this.categoryName = str;
            this.serverUUID = str2;
            this.categoryOrder = str3;
        }
    }

    public MemoScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.MEMO_SCLOUD, i);
        this.mDataItems = new ArrayList<>();
        this.mCategoryItems = new ArrayList<>();
        this.mUseConcurrentRequest = true;
        this.threadPool = null;
        this.futures = null;
        this.mAuthorization = str;
    }

    private void applyCategoryToData(List<ImportItem> list, List<CategoryItem> list2) {
        String string;
        String str;
        String str2;
        Debugger.m8607d(TAG, "applyCategoryToData : Update category name and order in itemList");
        int size = list.size();
        for (int i = 0; i < size && !isCancelled(); i++) {
            ImportItem importItem = list.get(i);
            try {
                string = ((JSONObject) importItem.getExtraObject()).getString("categoryUUID");
            } catch (JSONException e) {
                Debugger.m8609e(TAG, "applyCategoryToData : Exception = " + e.toString());
                string = "";
            }
            Iterator<CategoryItem> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    CategoryItem next = it.next();
                    if (next.serverUUID.equals(string)) {
                        str2 = next.categoryName;
                        str = next.categoryOrder;
                        break;
                    }
                } else {
                    str = null;
                    str2 = "";
                    break;
                }
            }
            importItem.setContainerName(str2);
            importItem.setCategoryOrder(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadAttachedFiles(C6840e c6840e, String str, ImportItem importItem, C0006f c0006f) throws SyncException {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(importItem.getServerKey());
        File file = new File(sbM1324q.toString());
        try {
            Debugger.m8616s(TAG, "downloadAttachedFiles : localRoot = " + str + importItem.getServerKey());
            c0006f.m33a(c6840e.m5004b(importItem.getServerKey()));
        } catch (SyncException e) {
            int exceptionCode = e.getExceptionCode();
            if (exceptionCode == 303 || exceptionCode == 315 || exceptionCode == 321) {
                Debugger.m8609e(TAG, "downloadAttachedFiles : fail to get the list info for the attached file");
                throw new RuntimeException("Server Error!");
            }
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new SyncException(312, "contentRootFile.mkdirs failed");
        }
        int size = c0006f.f24b.size();
        for (int i = 0; i < size && !isCancelled(); i++) {
            String str2 = ((C0005e) c0006f.f24b.get(i)).f22b;
            String strM757C = AbstractC0541b.m757C(str, "/", str2);
            try {
                Debugger.m8607d(TAG, "downloadAttachedFiles : download a attached file [" + Thread.currentThread().getId() + "] : " + str2);
                c6840e.m5003a(str2, strM757C);
            } catch (SyncException e2) {
                int exceptionCode2 = e2.getExceptionCode();
                if (exceptionCode2 == 303 || exceptionCode2 == 315 || exceptionCode2 == 321) {
                    Debugger.m8609e(TAG, "downloadAttachedFiles : fail to Download a attached file [" + Thread.currentThread().getId() + "] : " + str2);
                    throw new RuntimeException("Server Error!");
                }
            }
        }
    }

    private boolean downloadContentForData(String str) throws SyncException {
        JSONObject jSONObjectM5004b;
        Debugger.m8607d(TAG, "downloadContentForData start");
        try {
            Debugger.m8607d(TAG, "downloadContentForData : Download data folders");
            jSONObjectM5004b = this.mMemoServiceHelper.m5004b("/MEMO_DATA");
        } catch (SyncException e) {
            int exceptionCode = e.getExceptionCode();
            if (exceptionCode == 303 || exceptionCode == 315 || exceptionCode == 321) {
                Debugger.m8609e(TAG, "downloadContentForData: fail to Download data folders");
                throw new SyncException(315, "Server Error!");
            }
            jSONObjectM5004b = null;
        }
        if (jSONObjectM5004b != null) {
            try {
                JSONArray jSONArray = jSONObjectM5004b.getJSONArray("children");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("path");
                    String string2 = jSONObject.getString("type");
                    if (!"/MEMO_DATA".equals(string) && !jSONObject.getBoolean("deleted") && "folder".equals(string2)) {
                        C0006f c0006f = new C0006f();
                        c0006f.f23a = string;
                        this.mDataItems.add(c0006f);
                    }
                }
            } catch (JSONException e2) {
                Debugger.m8611e(TAG, e2);
                throw new SyncException(304, "Error while loading memo json");
            }
        }
        Debugger.m8607d(TAG, "downloadContentForData : size of the content folder : " + this.mDataItems.size());
        if (this.mUseConcurrentRequest) {
            this.threadPool = getThreadPool();
            this.futures = new ArrayList();
        }
        int size = this.mDataItems.size();
        for (int i2 = 0; i2 < size && !isCancelled(); i2++) {
            final C0006f c0006f2 = this.mDataItems.get(i2);
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(c0006f2.f23a);
            File file = new File(sbM1324q.toString());
            if (!file.exists() && !file.mkdirs()) {
                Debugger.m8609e(TAG, file.getAbsolutePath() + " mkdirs returned false");
            }
            final String strM1170p = AbstractC0622a.m1170p(c0006f2.f23a, "/content.sync", new StringBuilder());
            final String strM756B = AbstractC0541b.m756B(str, strM1170p);
            Runnable runnable = new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.3
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
                
                    if (r2 != 321) goto L53;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    if (MemoScloudSync.this.isCancelled()) {
                        return;
                    }
                    C6840e c6840e = new C6840e(MemoScloudSync.this.mAuthorization, "w8wcqZo4Uk");
                    boolean z = true;
                    int i4 = 0;
                    try {
                        Debugger.m8607d(MemoScloudSync.TAG, "downloadContentForData : download a content.sync [" + Thread.currentThread().getId() + "] : " + strM1170p);
                        c6840e.m5003a(strM1170p, strM756B);
                    } catch (SyncException e3) {
                        int exceptionCode2 = e3.getExceptionCode();
                        if (exceptionCode2 != 303) {
                            if (exceptionCode2 == 315) {
                                try {
                                    String message = e3.getMessage();
                                    int iIndexOf = message.indexOf(58, message.indexOf("rcode")) + 1;
                                    i4 = Integer.parseInt(message.substring(iIndexOf, message.indexOf(44, iIndexOf)));
                                } catch (Exception unused) {
                                    Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForData : can't parse the error!");
                                }
                                if (i4 == 32006) {
                                    Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForData : no content.sync in server [" + Thread.currentThread().getId() + "] : " + strM1170p);
                                    return;
                                }
                            }
                        }
                        Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForData: fail to Download a content.sync [" + Thread.currentThread().getId() + "] : " + strM1170p);
                        throw new RuntimeException("Server Error!");
                    }
                    try {
                        JSONObject jSONObject2 = AbstractC0155m.m393h(strM756B).getJSONObject("MEMO");
                        if (jSONObject2 == null) {
                            Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForData : memoJSON == null");
                            throw new RuntimeException("Server Error!");
                        }
                        String string3 = jSONObject2.getString("strippedContent");
                        String string4 = jSONObject2.getString("title");
                        ImportItem importItem = new ImportItem(10, "", string3, jSONObject2.getLong("lastModifiedAt"), c0006f2.f23a);
                        StringBuilder sb = new StringBuilder("is strippedContent empty ");
                        sb.append(string3 == null);
                        sb.append(" title empty ");
                        if (string4 != null) {
                            z = false;
                        }
                        sb.append(z);
                        Debugger.m8607d(MemoScloudSync.TAG, sb.toString());
                        importItem.setTitle(string4);
                        importItem.setExtraObject(jSONObject2);
                        synchronized (((ImportBaseTask) MemoScloudSync.this).mResultList) {
                            ((ImportBaseTask) MemoScloudSync.this).mResultList.add(importItem);
                        }
                    } catch (JSONException e5) {
                        Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForData : Fail to add ImportItem : " + e5.toString());
                    }
                }
            };
            if (this.mUseConcurrentRequest) {
                this.futures.add(this.threadPool.submit(runnable));
            } else {
                runnable.run();
            }
        }
        if (this.mUseConcurrentRequest) {
            int size2 = this.futures.size();
            for (int i4 = 0; i4 < size2 && !isCancelled(); i4++) {
                Future<?> future = this.futures.get(i4);
                try {
                    future.get();
                    future.cancel(false);
                } catch (InterruptedException e3) {
                    Debugger.m8609e(TAG, e3.toString());
                } catch (RuntimeException e5) {
                    Debugger.m8609e(TAG, e5.toString());
                    Debugger.m8609e(TAG, "Handle the RuntimeException as SyncException!");
                    throw new SyncException(315, e5.toString());
                } catch (ExecutionException e6) {
                    Debugger.m8609e(TAG, e6.toString());
                    Debugger.m8609e(TAG, "Handle the ExecutionException as SyncException!");
                    throw new SyncException(315, e6.toString());
                }
            }
            this.futures.clear();
        }
        Debugger.m8607d(TAG, "downloadContentForData finish");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadContentForDataV1(C6840e c6840e, String str, ImportItem importItem, C0006f c0006f, List<CategoryItem> list) {
        int i;
        String string;
        String str2;
        String str3 = c0006f.f23a.replace("MEMO_DATA/", "MEMO_DATA_V_1/") + "/content.sync";
        String strM757C = AbstractC0541b.m757C(str, "/", str3);
        try {
            Debugger.m8607d(TAG, "downloadContentForDataV1 : download a content.sync [" + Thread.currentThread().getId() + "] : " + str3);
            c6840e.m5003a(str3, strM757C);
        } catch (SyncException e) {
            try {
                String message = e.getMessage();
                int iIndexOf = message.indexOf(58, message.indexOf("rcode")) + 1;
                i = Integer.parseInt(message.substring(iIndexOf, message.indexOf(44, iIndexOf)));
            } catch (Exception unused) {
                Debugger.m8609e(TAG, "downloadContentForDataV1 : can't parse the error!");
                i = 0;
            }
            if (i == 32006) {
                Debugger.m8615i(TAG, "downloadContentForDataV1 : no content.sync [" + Thread.currentThread().getId() + "] : " + str3);
                return;
            }
            Debugger.m8609e(TAG, "downloadContentForDataV1 : SyncException = " + e.toString());
        } catch (Exception e2) {
            AbstractC4539a.m3213w(e2, new StringBuilder("downloadContentForDataV1 : Exception = "), TAG);
        }
        try {
            string = AbstractC0155m.m393h(strM757C).getJSONObject("MEMO").getString("categoryUUID");
        } catch (JSONException e3) {
            Debugger.m8609e(TAG, e3.toString());
            string = null;
        }
        Iterator<CategoryItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = "";
                break;
            }
            CategoryItem next = it.next();
            if (next.serverUUID.equals(string)) {
                str2 = next.categoryName;
                break;
            }
        }
        if (str2.isEmpty()) {
            return;
        }
        importItem.setContainerName(str2);
    }

    public static ThreadPoolExecutor getThreadPool() {
        return mThreadPool;
    }

    private void initializeImportDataForList(String str) {
        List<ImportItem> list = this.mResultList;
        if (list == null) {
            this.mResultList = new ArrayList();
        } else {
            list.clear();
        }
        this.mDataItems.clear();
        File file = new File(AbstractC0541b.m756B(str, "/MEMO_DATA"));
        if (file.exists()) {
            AbstractC0155m.m389d(file);
        }
        if (file.exists()) {
            Debugger.m8615i(TAG, "getImportItems : try again to delete memoDataRoot!");
            AbstractC0155m.m389d(file);
        }
        if (!file.mkdirs()) {
            Debugger.m8609e(TAG, file.getAbsolutePath() + " mkdirs returned false");
        }
        File file2 = new File(AbstractC0541b.m756B(str, "/MEMO_DATA_V_1"));
        if (file2.exists()) {
            AbstractC0155m.m389d(file2);
        }
        if (file2.mkdirs()) {
            return;
        }
        Debugger.m8609e(TAG, file2.getAbsolutePath() + " mkdirs returned false");
    }

    public void downloadContentForCategory(String str, final List<CategoryItem> list) throws SyncException {
        JSONObject jSONObjectM5004b;
        ArrayList arrayList;
        Debugger.m8615i(TAG, "downloadContentForCategory() start");
        this.mCategoryItems.clear();
        ThreadPoolExecutor threadPool = null;
        try {
            Debugger.m8607d(TAG, "downloadContentForCategory : Download category folders");
            jSONObjectM5004b = this.mMemoServiceHelper.m5004b("/MEMO_CATE");
        } catch (SyncException e) {
            Debugger.m8609e(TAG, e.getMessage());
            int exceptionCode = e.getExceptionCode();
            if (exceptionCode == 303 || exceptionCode == 315 || exceptionCode == 321) {
                Debugger.m8609e(TAG, "downloadContentForCategory : fail to Download category folders");
                throw new SyncException(315, e.toString());
            }
            jSONObjectM5004b = null;
        }
        if (jSONObjectM5004b != null) {
            try {
                JSONArray jSONArray = jSONObjectM5004b.getJSONArray("children");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("path");
                    String string2 = jSONObject.getString("type");
                    if (!"/MEMO_CATE".equals(string) && !jSONObject.getBoolean("deleted") && "folder".equals(string2)) {
                        C0006f c0006f = new C0006f();
                        c0006f.f23a = string;
                        this.mCategoryItems.add(c0006f);
                    }
                }
            } catch (JSONException e2) {
                Debugger.m8609e(TAG, e2.getMessage());
            }
        }
        Debugger.m8607d(TAG, "downloadContentForCategory : size of the category folder : " + this.mCategoryItems.size());
        if (this.mUseConcurrentRequest) {
            threadPool = getThreadPool();
            arrayList = new ArrayList();
        } else {
            arrayList = null;
        }
        int size = this.mCategoryItems.size();
        for (int i2 = 0; i2 < size && !isCancelled(); i2++) {
            C0006f c0006f2 = this.mCategoryItems.get(i2);
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(c0006f2.f23a);
            File file = new File(sbM1324q.toString());
            if (!file.exists() && !file.mkdirs()) {
                Debugger.m8609e(TAG, file.getAbsolutePath() + " mkdir returned failed in downloadContentForCategory");
            }
            final String strM1170p = AbstractC0622a.m1170p(c0006f2.f23a, "/content.sync", new StringBuilder());
            final String strM756B = AbstractC0541b.m756B(str, strM1170p);
            Runnable runnable = new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.4
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
                
                    if (r4 != 321) goto L40;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i4;
                    String string3;
                    String string4;
                    String string5 = "";
                    if (MemoScloudSync.this.isCancelled()) {
                        return;
                    }
                    C6840e c6840e = new C6840e(MemoScloudSync.this.mAuthorization, "w8wcqZo4Uk");
                    try {
                        Debugger.m8607d(MemoScloudSync.TAG, "downloadContentForCategory : download a content.sync [" + Thread.currentThread().getId() + "] : " + strM1170p);
                        c6840e.m5003a(strM1170p, strM756B);
                    } catch (SyncException e3) {
                        int exceptionCode2 = e3.getExceptionCode();
                        if (exceptionCode2 != 303) {
                            if (exceptionCode2 == 315) {
                                try {
                                    String message = e3.getMessage();
                                    int iIndexOf = message.indexOf(58, message.indexOf("rcode")) + 1;
                                    i4 = Integer.parseInt(message.substring(iIndexOf, message.indexOf(44, iIndexOf)));
                                } catch (Exception unused) {
                                    Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForCategory : can't parse the error!");
                                    i4 = 0;
                                }
                                if (i4 == 32006) {
                                    Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForCategory : no content.sync in server [" + Thread.currentThread().getId() + "] : " + strM1170p);
                                    return;
                                }
                            }
                        }
                        Debugger.m8609e(MemoScloudSync.TAG, "downloadContentForCategory : fail to Download a content.sync [" + Thread.currentThread().getId() + "] : " + strM1170p);
                        throw new RuntimeException("Server Error!");
                    }
                    try {
                        JSONObject jSONObject2 = AbstractC0155m.m393h(strM756B).getJSONObject("CATEGORY");
                        string3 = jSONObject2.getString("_display_name");
                        try {
                            string5 = jSONObject2.getString("UUID");
                            string4 = jSONObject2.getString("orderBy");
                        } catch (JSONException e5) {
                            e = e5;
                            Debugger.m8609e(MemoScloudSync.TAG, "applyCategoryToData : Exception = " + e.toString());
                            string4 = null;
                        }
                    } catch (JSONException e6) {
                        e = e6;
                        string3 = "";
                    }
                    list.add(new CategoryItem(string3, string5, string4));
                }
            };
            if (this.mUseConcurrentRequest) {
                arrayList.add(threadPool.submit(runnable));
            } else {
                runnable.run();
            }
        }
        if (this.mUseConcurrentRequest) {
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2 && !isCancelled(); i4++) {
                Future future = (Future) arrayList.get(i4);
                try {
                    future.get();
                    future.cancel(false);
                } catch (InterruptedException e3) {
                    Debugger.m8609e(TAG, e3.toString());
                } catch (RuntimeException e5) {
                    Debugger.m8609e(TAG, e5.toString());
                    Debugger.m8609e(TAG, "Handle the RuntimeException as SyncException!");
                    throw new SyncException(315, e5.toString());
                } catch (ExecutionException e6) {
                    Debugger.m8609e(TAG, e6.toString());
                    Debugger.m8609e(TAG, "Handle the ExecutionException as SyncException!");
                    throw new SyncException(315, e6.toString());
                }
            }
            arrayList.clear();
        }
        Debugger.m8615i(TAG, "downloadContentForCategory finished");
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() throws SyncException {
        MemoScloudSync memoScloudSync;
        Debugger.m8615i(TAG, "getImportItems() start");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mMemoServiceHelper = new C6840e(this.mAuthorization, "w8wcqZo4Uk");
        final String str = AbstractC0155m.m392g(this.mContext) + "/MemoData";
        initializeImportDataForList(str);
        downloadContentForData(str);
        final int size = this.mResultList.size();
        if (size > 0) {
            final ArrayList arrayList = new ArrayList();
            downloadContentForCategory(str, arrayList);
            applyCategoryToData(this.mResultList, arrayList);
            Collections.sort(this.mResultList, new Comparator<ImportItem>() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.1
                @Override // java.util.Comparator
                public int compare(ImportItem importItem, ImportItem importItem2) {
                    String categoryOrder = importItem.getCategoryOrder();
                    String categoryOrder2 = importItem2.getCategoryOrder();
                    return Integer.compare(categoryOrder == null ? 65535 : Integer.parseInt(categoryOrder), categoryOrder2 != null ? Integer.parseInt(categoryOrder2) : 65535);
                }
            });
            if (this.mListener != null) {
                int i = 0;
                while (i < size && !isCancelled()) {
                    ImportItem importItem = this.mResultList.get(i);
                    synchronized (this.mListener) {
                        i++;
                        this.mListener.onUpdated(this.mTaskType, i, size, importItem);
                    }
                }
            }
            for (final int i2 = 0; i2 < size && !isCancelled(); i2++) {
                final ImportItem importItem2 = this.mResultList.get(i2);
                Runnable runnable = new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MemoScloudSync.this.isCancelled()) {
                            return;
                        }
                        C6840e c6840e = new C6840e(MemoScloudSync.this.mAuthorization, "w8wcqZo4Uk");
                        C0006f c0006f = new C0006f();
                        try {
                            MemoScloudSync.this.downloadAttachedFiles(c6840e, str, importItem2, c0006f);
                            if (MemoScloudSync.this.isCancelled()) {
                                return;
                            }
                            MemoScloudSync.this.downloadContentForDataV1(c6840e, str, importItem2, c0006f, arrayList);
                            try {
                                importItem2.setLocalFullPath(str + c0006f.f23a);
                                importItem2.setDownloadCompleted(true);
                                if (((ImportBaseTask) MemoScloudSync.this).mListener != null) {
                                    synchronized (((ImportBaseTask) MemoScloudSync.this).mListener) {
                                        Debugger.m8615i(MemoScloudSync.TAG, "call mListener.onUpdated() : " + (i2 + 1));
                                        ((ImportBaseTask) MemoScloudSync.this).mListener.onUpdated(MemoScloudSync.this.mTaskType, i2 + 1, size, importItem2);
                                    }
                                }
                            } catch (Exception e) {
                                Debugger.m8609e(MemoScloudSync.TAG, "getImportItems : " + e.getMessage());
                            }
                        } catch (SyncException e2) {
                            AbstractC6670b.m4752m(e2, new StringBuilder("getImportItems : "), MemoScloudSync.TAG);
                        }
                    }
                };
                if (this.mUseConcurrentRequest) {
                    this.futures.add(this.threadPool.submit(runnable));
                } else {
                    runnable.run();
                }
            }
            memoScloudSync = this;
            if (memoScloudSync.mUseConcurrentRequest) {
                int size2 = memoScloudSync.futures.size();
                for (int i4 = 0; i4 < size2 && !isCancelled(); i4++) {
                    Future<?> future = memoScloudSync.futures.get(i4);
                    try {
                        future.get();
                        future.cancel(false);
                    } catch (InterruptedException e) {
                        Debugger.m8609e(TAG, e.getMessage());
                    } catch (RuntimeException e2) {
                        Debugger.m8609e(TAG, e2.toString());
                        Debugger.m8609e(TAG, "Handle the RuntimeException as SyncException!");
                        memoScloudSync.futures.clear();
                        throw new SyncException(315, e2.toString());
                    } catch (ExecutionException e3) {
                        Debugger.m8609e(TAG, e3.getMessage());
                        Debugger.m8609e(TAG, "Handle the ExecutionException as SyncException!");
                        memoScloudSync.futures.clear();
                        throw new SyncException(315, e3.toString());
                    }
                }
                memoScloudSync.futures.clear();
            }
        } else {
            memoScloudSync = this;
        }
        Debugger.m8615i(TAG, "getImportItems finish(" + memoScloudSync.mResultList.size() + ") - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws SyncException {
        boolean z;
        Debugger.m8615i(TAG, "startImport()[" + hashCode() + "]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mMemoServiceHelper = new C6840e(this.mAuthorization, "w8wcqZo4Uk");
        final String str = this.mContext.getFilesDir().getAbsolutePath() + "/MemoData";
        ImportBaseTask.Listener listener = this.mListener;
        if (listener != null) {
            listener.onDownloaded(DocTypeConstants.MEMO_SCLOUD, null, 0);
        }
        Iterator<ImportItem> it = this.mImportList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().getDownloadCompleted()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        final ArrayList arrayList = new ArrayList();
        if (z) {
            downloadContentForCategory(str, arrayList);
            applyCategoryToData(this.mImportList, arrayList);
        }
        this.mSuccessfulList = new ArrayList();
        final Boolean[] boolArr = {Boolean.FALSE};
        final SyncException[] syncExceptionArr = new SyncException[1];
        final Object obj = new Object();
        int size = this.mImportList.size();
        for (int i = 0; i < size && !isCancelled(); i++) {
            if (!AbstractC0155m.m401p()) {
                Debugger.m8607d(TAG, "Not Enough Storage!");
                AbstractC0155m.m389d(new File(str));
                for (int i2 = 0; i2 < size; i2++) {
                    this.mImportList.get(i2).setDownloadCompleted(false);
                }
                throw new SyncException(323, "device storage is full!");
            }
            final ImportItem importItem = this.mImportList.get(i);
            try {
                new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MemoScloudSync.this.isCancelled()) {
                            return;
                        }
                        if (((ImportBaseTask) MemoScloudSync.this).mListener != null) {
                            synchronized (((ImportBaseTask) MemoScloudSync.this).mListener) {
                                ((ImportBaseTask) MemoScloudSync.this).mListener.onDownloaded(DocTypeConstants.MEMO_SCLOUD, importItem, 0);
                            }
                        }
                        if (!importItem.getDownloadCompleted()) {
                            C6840e c6840e = new C6840e(MemoScloudSync.this.mAuthorization, "w8wcqZo4Uk");
                            C0006f c0006f = new C0006f();
                            try {
                                MemoScloudSync.this.downloadAttachedFiles(c6840e, str, importItem, c0006f);
                                if (MemoScloudSync.this.isCancelled()) {
                                    return;
                                } else {
                                    MemoScloudSync.this.downloadContentForDataV1(c6840e, str, importItem, c0006f, arrayList);
                                }
                            } catch (SyncException e) {
                                Debugger.m8609e(MemoScloudSync.TAG, "startImport() : SyncException0 : " + e.toString());
                                synchronized (syncExceptionArr) {
                                    boolArr[0] = Boolean.TRUE;
                                    syncExceptionArr[0] = e;
                                }
                            }
                        }
                        if (((ImportBaseTask) MemoScloudSync.this).mListener != null) {
                            synchronized (((ImportBaseTask) MemoScloudSync.this).mListener) {
                                ((ImportBaseTask) MemoScloudSync.this).mListener.onDownloaded(DocTypeConstants.MEMO_SCLOUD, importItem, 1);
                            }
                        }
                        final String[] strArr = {"1"};
                        synchronized (obj) {
                            try {
                                final String containerName = importItem.getContainerName();
                                if (!containerName.isEmpty()) {
                                    Context unused = ((ImportBaseTask) MemoScloudSync.this).mContext;
                                    String strM4838a = AbstractC6740i.m4838a(containerName, false);
                                    strArr[0] = strM4838a;
                                    if ("1".equals(strM4838a) || !"1".equals(strArr[0])) {
                                        FolderManager.getInstance().executeOperation(new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.MemoScloudSync.5.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (C0322h.m670a().f829o.getCategoryDeleted(strArr[0]) == 1) {
                                                    String[] strArr2 = strArr;
                                                    Context unused2 = ((ImportBaseTask) MemoScloudSync.this).mContext;
                                                    strArr2[0] = (String) FolderManager.getInstance().executeOperation(new CallableC0323a(containerName, 1));
                                                }
                                            }
                                        });
                                    }
                                }
                                String strReplace = (str + importItem.getServerKey()).replace("/MEMO_DATA/", "/MEMO_DATA_V_1/");
                                try {
                                    Debugger.m8615i(MemoScloudSync.TAG, "try to convertToSDoc : " + importItem.getServerKey());
                                    C0322h.m670a().f823i.jsonConverterConvertToSDoc(((ImportBaseTask) MemoScloudSync.this).mContext, str + importItem.getServerKey(), strReplace, strArr[0]);
                                    StringBuilder sb = new StringBuilder("succeed to convert");
                                    sb.append(importItem.getServerKey());
                                    Debugger.m8615i(MemoScloudSync.TAG, sb.toString());
                                    ((ImportBaseTask) MemoScloudSync.this).mSuccessfulList.add(importItem);
                                } catch (Exception unused2) {
                                    Debugger.m8609e(MemoScloudSync.TAG, "startImport() : Failed to convert memo!");
                                }
                            } catch (Exception e2) {
                                Debugger.m8609e(MemoScloudSync.TAG, "startImport() : SyncException1 : " + e2.getMessage());
                            } finally {
                            }
                        }
                    }
                }.run();
                synchronized (syncExceptionArr) {
                    try {
                        if (boolArr[0].booleanValue()) {
                            Debugger.m8609e(TAG, "startImport() : SyncException2 : " + syncExceptionArr[0].toString());
                            throw syncExceptionArr[0];
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (RuntimeException e) {
                String message = e.getMessage();
                if (message != null && message.equals("Server Error!")) {
                    throw new SyncException(303, "Server Error!");
                }
                throw e;
            }
        }
        AbstractC0155m.m389d(new File(str));
        synchronized (syncExceptionArr) {
        }
        Debugger.m8615i(TAG, "finish startImport()[" + hashCode() + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    public MemoScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.MEMO_SCLOUD, i);
        this.mDataItems = new ArrayList<>();
        this.mCategoryItems = new ArrayList<>();
        this.mUseConcurrentRequest = true;
        this.threadPool = null;
        this.futures = null;
        this.mImportList = list;
        this.mAuthorization = str;
    }
}
