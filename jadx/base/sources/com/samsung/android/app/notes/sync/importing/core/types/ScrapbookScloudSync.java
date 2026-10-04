package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.SystemClock;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.network.C6840e;
import com.samsung.android.app.notes.sync.network.C6849n;
import com.samsung.android.app.notes.sync.p135db.AbstractC6740i;
import com.samsung.android.support.senl.document.memoconverter.ScrapBookConverter;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p042J1.AbstractC0155m;
import p086V.C0322h;
import p087V0.CallableC0323a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ScrapbookScloudSync extends ImportBaseTask {
    private static final String TAG = "ScrapbookScloudSync";
    private static ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(5, 1000, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new SenlThreadFactory(TAG));
    List<Future<?>> futures;
    private String mAuthorization;
    private ArrayList<CategoryItem> mCategoryItems;
    private C6849n mScrapbookServiceHelper;
    private boolean mUseConcurrentRequest;
    ThreadPoolExecutor threadPool;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CategoryItem {
        public String key;
        public String name;
        public int priority;

        public CategoryItem(String str, String str2, int i) {
            this.key = str;
            this.name = str2;
            this.priority = i;
        }
    }

    public ScrapbookScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.SCRAPBOOK_SCLOUD, i);
        this.mCategoryItems = new ArrayList<>();
        this.mUseConcurrentRequest = true;
        this.threadPool = null;
        this.futures = null;
        this.mAuthorization = str;
    }

    private boolean downloadContentFiles(String str) throws SyncException {
        Debugger.m8615i(TAG, "downloadContentFiles()");
        final int size = this.mResultList.size();
        if (size > 0) {
            Collections.sort(this.mResultList, new Comparator<ImportItem>() { // from class: com.samsung.android.app.notes.sync.importing.core.types.ScrapbookScloudSync.1
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
            Debugger.m8607d(TAG, "getImportItems : Download attached files");
            final int i2 = 0;
            while (i2 < size && !isCancelled()) {
                final ImportItem importItem2 = this.mResultList.get(i2);
                final String str2 = str;
                Runnable runnable = new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.ScrapbookScloudSync.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ScrapbookScloudSync.this.isCancelled()) {
                            return;
                        }
                        C6840e c6840e = new C6840e(ScrapbookScloudSync.this.mAuthorization, "gr3k9outd1");
                        if (importItem2.getServerKey() != null && !importItem2.getServerKey().isEmpty()) {
                            File file = new File(str2 + importItem2.getServerKey());
                            Debugger.m8616s(ScrapbookScloudSync.TAG, "getImportItems : cropImageFile [" + Thread.currentThread().getId() + "] = " + file.getAbsolutePath());
                            try {
                                Debugger.m8607d(ScrapbookScloudSync.TAG, "getImportItems : download a crop image file [" + Thread.currentThread().getId() + "]");
                                c6840e.m5003a(importItem2.getServerKey(), file.getAbsolutePath());
                            } catch (SyncException e) {
                                int exceptionCode = e.getExceptionCode();
                                if (exceptionCode == 303 || exceptionCode == 315 || exceptionCode == 321) {
                                    Debugger.m8609e(ScrapbookScloudSync.TAG, "getImportItems : fail to Download a crop image file [" + Thread.currentThread().getId() + "]");
                                    throw new RuntimeException("Server Error!");
                                }
                            }
                        }
                        if (!(importItem2.getExtraObject() instanceof JSONObject)) {
                            Debugger.m8609e(ScrapbookScloudSync.TAG, "getImportItems : item.getExtraObject() is not JSONObject!");
                            return;
                        }
                        try {
                            JSONArray jSONArray = ((JSONObject) importItem2.getExtraObject()).getJSONArray(ScrapBookConverter.SCC_META_JSONKEY);
                            int length = jSONArray.length();
                            Debugger.m8615i(ScrapbookScloudSync.TAG, "getImportItems : size of metaObjs = " + length);
                            for (int i4 = 0; i4 < length; i4++) {
                                try {
                                    try {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                        String string = jSONObject.has("server_file_path") ? jSONObject.getString("server_file_path") : null;
                                        if (string != null && !string.isEmpty()) {
                                            String str3 = str2 + string;
                                            try {
                                                Debugger.m8616s(ScrapbookScloudSync.TAG, "getImportItems : download a meta object file = " + string);
                                                c6840e.m5003a(string, str3);
                                            } catch (SyncException e2) {
                                                int exceptionCode2 = e2.getExceptionCode();
                                                if (exceptionCode2 == 303 || exceptionCode2 == 315 || exceptionCode2 == 321) {
                                                    Debugger.m8609e(ScrapbookScloudSync.TAG, "getImportItems : fail to Download a attached file for Scrapbook");
                                                    throw new RuntimeException("Server Error!");
                                                }
                                            }
                                        }
                                    } catch (JSONException e3) {
                                        Debugger.m8609e(ScrapbookScloudSync.TAG, "JSONException - " + e3.getMessage());
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                            if (ScrapbookScloudSync.this.isCancelled()) {
                                return;
                            }
                            try {
                                importItem2.setLocalFullPath(str2);
                                importItem2.setDownloadCompleted(true);
                                if (((ImportBaseTask) ScrapbookScloudSync.this).mListener != null) {
                                    synchronized (((ImportBaseTask) ScrapbookScloudSync.this).mListener) {
                                        Debugger.m8615i(ScrapbookScloudSync.TAG, "call mListener.onUpdated() : " + (i2 + 1));
                                        ((ImportBaseTask) ScrapbookScloudSync.this).mListener.onUpdated(ScrapbookScloudSync.this.mTaskType, i2 + 1, size, importItem2);
                                    }
                                }
                            } catch (Exception e5) {
                                Debugger.m8609e(ScrapbookScloudSync.TAG, e5.getMessage());
                            }
                        } catch (JSONException e6) {
                            Debugger.m8609e(ScrapbookScloudSync.TAG, "JSONException - " + e6.getMessage());
                        }
                    }
                };
                if (this.mUseConcurrentRequest) {
                    this.futures.add(this.threadPool.submit(runnable));
                } else {
                    runnable.run();
                }
                i2++;
                str = str2;
            }
            if (this.mUseConcurrentRequest) {
                int size2 = this.futures.size();
                for (int i4 = 0; i4 < size2 && !isCancelled(); i4++) {
                    Future<?> future = this.futures.get(i4);
                    try {
                        future.get();
                        future.cancel(false);
                    } catch (InterruptedException e) {
                        Debugger.m8609e(TAG, e.getMessage() == null ? "InterruptedException" : e.getMessage());
                    } catch (RuntimeException e2) {
                        Debugger.m8609e(TAG, e2.toString());
                        Debugger.m8609e(TAG, "Handle the RuntimeException as SyncException!");
                        throw new SyncException(315, e2.toString());
                    } catch (ExecutionException e3) {
                        Debugger.m8609e(TAG, e3.getMessage() == null ? "ExecutionException" : e3.getMessage());
                        Debugger.m8609e(TAG, "Handle the ExecutionException as SyncException!");
                        throw new SyncException(315, e3.toString());
                    }
                }
                this.futures.clear();
            }
        }
        Debugger.m8615i(TAG, "downloadContentFiles() finishes");
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:69|138|70|71|(3:73|(2:75|(0)(9:140|78|(1:80)|152|91|(1:93)|97|98|105))(8:83|(1:85)|152|91|(0)|97|98|105)|171)(2:86|(2:88|89))|90|152|91|(0)|97|98|105) */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01bf, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c0, code lost:
    
        r12 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b1 A[Catch: JSONException -> 0x01bf, TRY_LEAVE, TryCatch #8 {JSONException -> 0x01bf, blocks: (B:91:0x01ab, B:93:0x01b1), top: B:152:0x01ab }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean downloadContentInfo() throws JSONException {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Iterator it;
        String string;
        String str6;
        int i;
        String string2;
        String str7;
        String str8;
        JSONArray jSONArray;
        int length;
        StringBuilder sb;
        int i2;
        JSONObject jSONObject;
        String string3;
        int iHashCode;
        String str9;
        String string4;
        String str10 = "meta_key";
        String str11 = "crop_image_path";
        String str12 = "crop_time";
        String str13 = "category_id";
        String str14 = "type";
        Debugger.m8615i(TAG, "downloadContentInfo()");
        List<ImportItem> list = this.mResultList;
        if (list == null) {
            this.mResultList = new ArrayList();
        } else {
            list.clear();
        }
        try {
            Iterator it2 = this.mScrapbookServiceHelper.m5015a().iterator();
            int i4 = 1;
            while (it2.hasNext()) {
                JSONObject jSONObject2 = (JSONObject) it2.next();
                try {
                    string = jSONObject2.getString("key");
                    z = true;
                    try {
                    } catch (JSONException e) {
                        e = e;
                        str = str10;
                        str2 = str11;
                        str3 = str12;
                        str4 = str13;
                        str5 = str14;
                        it = it2;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str = str10;
                    str2 = str11;
                    str3 = str12;
                    str4 = str13;
                    str5 = str14;
                    it = it2;
                    z = true;
                }
                if (string.toLowerCase(Locale.getDefault()).contains("_content_")) {
                    String string5 = jSONObject2.getString("value");
                    JSONObject jSONObject3 = new JSONObject(string5);
                    StringBuilder sb2 = new StringBuilder();
                    it = it2;
                    try {
                        sb2.append("Content ");
                        sb2.append(i4);
                        sb2.append(" : key = ");
                        sb2.append(string);
                        sb2.append(" , Value =  ");
                        sb2.append(string5);
                        Debugger.m8616s(TAG, sb2.toString());
                        i4++;
                    } catch (JSONException e3) {
                        e = e3;
                        str = str10;
                        str2 = str11;
                    }
                    if (jSONObject3.has(str14) && ComposerSAConstants.DETAIL_VIDEO.equals(jSONObject3.getString(str14))) {
                        Debugger.m8607d(TAG, "Do not support video type. Skip!!");
                        it2 = it;
                    } else {
                        String str15 = "";
                        String string6 = jSONObject3.has(str13) ? jSONObject3.getString(str13) : "";
                        long j = jSONObject3.has(str12) ? jSONObject3.getLong(str12) : 0L;
                        String string7 = jSONObject3.has(str11) ? jSONObject3.getString(str11) : "";
                        Iterator<CategoryItem> it3 = this.mCategoryItems.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                str2 = str11;
                                str6 = "";
                                i = 0;
                                break;
                            }
                            try {
                                CategoryItem next = it3.next();
                                str2 = str11;
                                try {
                                    if (next.key.equals(string6)) {
                                        String str16 = next.name;
                                        i = next.priority;
                                        str6 = str16;
                                        break;
                                    }
                                    str11 = str2;
                                } catch (JSONException e5) {
                                    e = e5;
                                    str = str10;
                                    str3 = str12;
                                    str4 = str13;
                                    str5 = str14;
                                    try {
                                        Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                                        it2 = it;
                                        str11 = str2;
                                        str12 = str3;
                                        str13 = str4;
                                        str10 = str;
                                        str14 = str5;
                                    } catch (JSONException e6) {
                                        e = e6;
                                        Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                                        Debugger.m8615i(TAG, "downloadContentInfo() finishes");
                                        return z;
                                    }
                                }
                            } catch (JSONException e7) {
                                e = e7;
                                str2 = str11;
                            }
                        }
                        try {
                            jSONArray = jSONObject3.getJSONArray(ScrapBookConverter.SCC_META_JSONKEY);
                            length = jSONArray.length();
                            sb = new StringBuilder();
                            str3 = str12;
                        } catch (JSONException e8) {
                            e = e8;
                            str = str10;
                            str3 = str12;
                        }
                        try {
                            sb.append("getImportItems : size of metaObjs = ");
                            sb.append(length);
                            Debugger.m8615i(TAG, sb.toString());
                            str8 = "";
                            i2 = 0;
                        } catch (JSONException e9) {
                            e = e9;
                            str = str10;
                            str4 = str13;
                            str5 = str14;
                            string2 = "";
                            try {
                                Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                                str7 = str15;
                                str8 = string2;
                                ImportItem importItem = new ImportItem(33, str6, str7, j, string7);
                                importItem.setTitle(str8);
                                importItem.setCategoryOrder(String.valueOf(i));
                                importItem.setExtraObject(jSONObject3);
                                Debugger.m8616s(TAG, "categoryName = " + str6 + " , categoryOrder = " + i);
                                this.mResultList.add(importItem);
                            } catch (JSONException e10) {
                                e = e10;
                                Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                            }
                            it2 = it;
                            str11 = str2;
                            str12 = str3;
                            str13 = str4;
                            str10 = str;
                            str14 = str5;
                        }
                        while (i2 < length) {
                            string2 = str8;
                            try {
                                jSONObject = jSONArray.getJSONObject(i2);
                            } catch (JSONException e11) {
                                e = e11;
                                str = str10;
                                str4 = str13;
                            }
                            if (jSONObject.has(str10)) {
                                str4 = str13;
                                try {
                                    string3 = jSONObject.getString(str10);
                                } catch (JSONException e12) {
                                    e = e12;
                                    str = str10;
                                }
                                if (string3 == null || string3.isEmpty()) {
                                    str = str10;
                                } else {
                                    str = str10;
                                    try {
                                        iHashCode = string3.hashCode();
                                        str5 = str14;
                                        str9 = str15;
                                    } catch (JSONException e13) {
                                        e = e13;
                                        str5 = str14;
                                        Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                                        str7 = str15;
                                        str8 = string2;
                                        ImportItem importItem2 = new ImportItem(33, str6, str7, j, string7);
                                        importItem2.setTitle(str8);
                                        importItem2.setCategoryOrder(String.valueOf(i));
                                        importItem2.setExtraObject(jSONObject3);
                                        Debugger.m8616s(TAG, "categoryName = " + str6 + " , categoryOrder = " + i);
                                        this.mResultList.add(importItem2);
                                        it2 = it;
                                        str11 = str2;
                                        str12 = str3;
                                        str13 = str4;
                                        str10 = str;
                                        str14 = str5;
                                    }
                                    if (iHashCode != 110371416) {
                                        if (iHashCode == 339314990) {
                                            if (string3.equals("user_memo")) {
                                                string4 = jSONObject.getString("meta_value");
                                            }
                                            if (jSONObject.has("server_file_path")) {
                                            }
                                            str15 = string4;
                                            str8 = string2;
                                            i2++;
                                            str13 = str4;
                                            str10 = str;
                                            str14 = str5;
                                        } else if (iHashCode == 1021751938) {
                                            try {
                                                if (string3.equals("plain_text")) {
                                                    string4 = jSONObject.getString("meta_value");
                                                }
                                                if (jSONObject.has("server_file_path")) {
                                                    jSONObject.put("meta_value", jSONObject.getString("server_file_path"));
                                                    jSONArray.put(i2, jSONObject);
                                                    jSONObject3.put(ScrapBookConverter.SCC_META_JSONKEY, jSONArray);
                                                }
                                                str15 = string4;
                                                str8 = string2;
                                                i2++;
                                                str13 = str4;
                                                str10 = str;
                                                str14 = str5;
                                            } catch (JSONException e14) {
                                                e = e14;
                                                str15 = str9;
                                                Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                                                str7 = str15;
                                                str8 = string2;
                                                ImportItem importItem22 = new ImportItem(33, str6, str7, j, string7);
                                                importItem22.setTitle(str8);
                                                importItem22.setCategoryOrder(String.valueOf(i));
                                                importItem22.setExtraObject(jSONObject3);
                                                Debugger.m8616s(TAG, "categoryName = " + str6 + " , categoryOrder = " + i);
                                                this.mResultList.add(importItem22);
                                                it2 = it;
                                                str11 = str2;
                                                str12 = str3;
                                                str13 = str4;
                                                str10 = str;
                                                str14 = str5;
                                            }
                                        }
                                    } else if (string3.equals("title")) {
                                        string2 = jSONObject.getString("meta_value");
                                    }
                                    string4 = str9;
                                    if (jSONObject.has("server_file_path")) {
                                    }
                                    str15 = string4;
                                    str8 = string2;
                                    i2++;
                                    str13 = str4;
                                    str10 = str;
                                    str14 = str5;
                                }
                            } else {
                                str = str10;
                                str4 = str13;
                            }
                            str5 = str14;
                            str15 = str15;
                            str8 = string2;
                            i2++;
                            str13 = str4;
                            str10 = str;
                            str14 = str5;
                        }
                        str = str10;
                        str4 = str13;
                        str5 = str14;
                        str7 = str15;
                        ImportItem importItem222 = new ImportItem(33, str6, str7, j, string7);
                        importItem222.setTitle(str8);
                        importItem222.setCategoryOrder(String.valueOf(i));
                        importItem222.setExtraObject(jSONObject3);
                        Debugger.m8616s(TAG, "categoryName = " + str6 + " , categoryOrder = " + i);
                        this.mResultList.add(importItem222);
                    }
                } else {
                    str = str10;
                    str2 = str11;
                    str3 = str12;
                    str4 = str13;
                    str5 = str14;
                    it = it2;
                    if (!string.toLowerCase(Locale.getDefault()).contains("category")) {
                        Debugger.m8609e(TAG, "invalid key!" + string);
                    }
                }
                it2 = it;
                str11 = str2;
                str12 = str3;
                str13 = str4;
                str10 = str;
                str14 = str5;
            }
            z = true;
        } catch (JSONException e15) {
            e = e15;
            z = true;
        }
        Debugger.m8615i(TAG, "downloadContentInfo() finishes");
        return z;
    }

    private void eraseLocalTempFiles(String str) {
        Debugger.m8615i(TAG, "eraseLocalTempFiles()");
        File file = new File(AbstractC0541b.m756B(str, "/SCRAPBOOK01"));
        if (file.exists()) {
            AbstractC0155m.m389d(file);
        }
        if (file.exists()) {
            Debugger.m8615i(TAG, "getImportItems : scrapbookDataRootFile is not deleted yet!");
            AbstractC0155m.m389d(file);
        }
        if (file.mkdirs()) {
            return;
        }
        Debugger.m8609e(TAG, Logger.getEncode(file.getAbsolutePath()) + " mkdirs returned false");
    }

    public static ThreadPoolExecutor getThreadPool() {
        return mThreadPool;
    }

    public void downloadCategoryInfo() {
        Debugger.m8615i(TAG, "downloadCategoryInfo()");
        this.mCategoryItems.clear();
        try {
            int i = 1;
            for (JSONObject jSONObject : this.mScrapbookServiceHelper.m5015a()) {
                try {
                    String string = jSONObject.getString("key");
                    if (string.toLowerCase(Locale.getDefault()).contains("_category_")) {
                        String string2 = jSONObject.getString("value");
                        JSONObject jSONObject2 = new JSONObject(string2);
                        String string3 = "";
                        Debugger.m8616s(TAG, "Category " + i + " : key = " + string + " , Value =  " + string2);
                        i++;
                        if (!string.toLowerCase(Locale.getDefault()).contains("_category_default") && jSONObject2.has("name")) {
                            string3 = jSONObject2.getString("name");
                        }
                        this.mCategoryItems.add(new CategoryItem(string, string3, jSONObject2.has("priority") ? jSONObject2.getInt("priority") : 0));
                    }
                } catch (JSONException e) {
                    Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                } catch (Exception e2) {
                    Debugger.m8609e(TAG, "Exception - " + e2.getMessage());
                }
            }
        } catch (JSONException e3) {
            Debugger.m8609e(TAG, "JSONException - " + e3.getMessage());
        }
        Debugger.m8615i(TAG, "downloadCategoryInfo finishes");
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() throws JSONException, SyncException {
        Debugger.m8615i(TAG, "getImportItems()[" + hashCode() + "], concurrentrequest : " + this.mUseConcurrentRequest);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mScrapbookServiceHelper = new C6849n(this.mAuthorization);
        String str = AbstractC0155m.m392g(this.mContext) + "/ScrapbookData";
        eraseLocalTempFiles(str);
        downloadCategoryInfo();
        if (this.mUseConcurrentRequest) {
            this.threadPool = getThreadPool();
            this.futures = new ArrayList();
        }
        downloadContentInfo();
        downloadContentFiles(str);
        Debugger.m8615i(TAG, "getImportItems() finishes [" + hashCode() + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws SyncException {
        Debugger.m8615i(TAG, "startImport()[" + hashCode() + "]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mScrapbookServiceHelper = new C6849n(this.mAuthorization);
        final String str = AbstractC0155m.m392g(this.mContext) + "/ScrapbookData";
        ImportBaseTask.Listener listener = this.mListener;
        if (listener != null) {
            listener.onDownloaded(DocTypeConstants.SCRAPBOOK_SCLOUD, null, 0);
        }
        this.mSuccessfulList = new ArrayList();
        final Boolean[] boolArr = {Boolean.FALSE};
        final SyncException[] syncExceptionArr = new SyncException[1];
        final Object obj = new Object();
        int size = this.mImportList.size();
        Debugger.m8607d(TAG, "startImport : Download attached files and category info");
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
                new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.ScrapbookScloudSync.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ScrapbookScloudSync.this.isCancelled()) {
                            return;
                        }
                        if (((ImportBaseTask) ScrapbookScloudSync.this).mListener != null) {
                            synchronized (((ImportBaseTask) ScrapbookScloudSync.this).mListener) {
                                ((ImportBaseTask) ScrapbookScloudSync.this).mListener.onDownloaded(DocTypeConstants.SCRAPBOOK_SCLOUD, importItem, 0);
                            }
                        }
                        if (!importItem.getDownloadCompleted()) {
                            C6840e c6840e = new C6840e(ScrapbookScloudSync.this.mAuthorization, "gr3k9outd1");
                            if (importItem.getServerKey() != null && !importItem.getServerKey().isEmpty()) {
                                File file = new File(str + importItem.getServerKey());
                                StringBuilder sb = new StringBuilder("startImport : cropImageFile = ");
                                sb.append(file.getAbsolutePath());
                                Debugger.m8616s(ScrapbookScloudSync.TAG, sb.toString());
                                try {
                                    Debugger.m8607d(ScrapbookScloudSync.TAG, "startImport : download a crop image file [" + Thread.currentThread().getId() + "]");
                                    c6840e.m5003a(importItem.getServerKey(), file.getAbsolutePath());
                                } catch (SyncException e) {
                                    Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : SyncException 1 : " + e.toString());
                                    synchronized (syncExceptionArr) {
                                        boolArr[0] = Boolean.TRUE;
                                        syncExceptionArr[0] = e;
                                    }
                                }
                            }
                            if (importItem.getExtraObject() instanceof JSONObject) {
                                try {
                                    JSONArray jSONArray = ((JSONObject) importItem.getExtraObject()).getJSONArray(ScrapBookConverter.SCC_META_JSONKEY);
                                    int length = jSONArray.length();
                                    Debugger.m8615i(ScrapbookScloudSync.TAG, "startImport : size of metaObjs =  " + length);
                                    for (int i4 = 0; i4 < length; i4++) {
                                        try {
                                            try {
                                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                                String string = jSONObject.has("server_file_path") ? jSONObject.getString("server_file_path") : null;
                                                if (string != null && !string.isEmpty()) {
                                                    String str2 = str + string;
                                                    try {
                                                        Debugger.m8616s(ScrapbookScloudSync.TAG, "startImport : download a meta object file [" + string + "]");
                                                        c6840e.m5003a(string, str2);
                                                    } catch (SyncException e2) {
                                                        Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : SyncException 2 : " + e2.toString());
                                                        synchronized (syncExceptionArr) {
                                                            boolArr[0] = Boolean.TRUE;
                                                            syncExceptionArr[0] = e2;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable unused) {
                                            }
                                        } catch (JSONException e3) {
                                            Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : JSONException - " + e3.getMessage());
                                        }
                                    }
                                } catch (JSONException e5) {
                                    Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : JSONException - " + e5.getMessage());
                                }
                            }
                        }
                        if (((ImportBaseTask) ScrapbookScloudSync.this).mListener != null) {
                            synchronized (((ImportBaseTask) ScrapbookScloudSync.this).mListener) {
                                ((ImportBaseTask) ScrapbookScloudSync.this).mListener.onDownloaded(DocTypeConstants.SCRAPBOOK_SCLOUD, importItem, 1);
                            }
                        }
                        final String[] strArr = {"1"};
                        synchronized (obj) {
                            try {
                                final String containerName = importItem.getContainerName();
                                if (!containerName.isEmpty()) {
                                    Context unused2 = ((ImportBaseTask) ScrapbookScloudSync.this).mContext;
                                    String strM4838a = AbstractC6740i.m4838a(containerName, false);
                                    strArr[0] = strM4838a;
                                    if ("1".equals(strM4838a) || !"1".equals(strArr[0])) {
                                        FolderManager.getInstance().executeOperation(new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.ScrapbookScloudSync.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (C0322h.m670a().f829o.getCategoryDeleted(strArr[0]) == 1) {
                                                    String[] strArr2 = strArr;
                                                    Context unused3 = ((ImportBaseTask) ScrapbookScloudSync.this).mContext;
                                                    strArr2[0] = (String) FolderManager.getInstance().executeOperation(new CallableC0323a(containerName, 1));
                                                }
                                            }
                                        });
                                    }
                                }
                                Debugger.m8615i(ScrapbookScloudSync.TAG, "localCategoryUuid = " + strArr[0]);
                                try {
                                    Debugger.m8615i(ScrapbookScloudSync.TAG, "convertToSDoc : " + importItem.getServerKey());
                                    C0322h.m670a().f823i.scrapBookConverterConvertToSDoc(C0322h.m670a().f823i.createScrapBookConverter(), (JSONObject) importItem.getExtraObject(), str, strArr[0]);
                                    Debugger.m8615i(ScrapbookScloudSync.TAG, "succeed to convert!");
                                    ((ImportBaseTask) ScrapbookScloudSync.this).mSuccessfulList.add(importItem);
                                } catch (Exception unused3) {
                                    Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : Failed to convert!");
                                }
                            } catch (Exception e6) {
                                Debugger.m8609e(ScrapbookScloudSync.TAG, "startImport : Exception 3 : " + e6.getMessage());
                            } finally {
                            }
                        }
                    }
                }.run();
                synchronized (syncExceptionArr) {
                    try {
                        if (boolArr[0].booleanValue()) {
                            Debugger.m8609e(TAG, "startImport : Exception 4 : " + syncExceptionArr[0].toString());
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

    public ScrapbookScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.SCRAPBOOK_SCLOUD, i);
        this.mCategoryItems = new ArrayList<>();
        this.mUseConcurrentRequest = true;
        this.threadPool = null;
        this.futures = null;
        this.mImportList = list;
        this.mAuthorization = str;
    }
}
