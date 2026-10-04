package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.app.notes.sync.network.C6845j;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0009i;
import p042J1.AbstractC0155m;
import p086V.C0322h;
import p089W.C0327a;
import p089W.C0329c;
import p186h1.C12020a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteScloudSync extends SnoteBaseSync {
    private static final String TAG = "SnoteScloudSync";
    private final String mAuthorization;
    protected C6845j mConnectionInfo;

    public SnoteScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.SNOTE_SCLOUD, i, TAG);
        this.mAuthorization = str;
    }

    private void addSNoteItemToImportList(JSONArray jSONArray, int i, List<ImportItem> list, C0329c c0329c, boolean z) {
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (!jSONObject.has("filepath") || jSONObject.getBoolean("deleted")) {
                return;
            }
            String string = jSONObject.getString("filepath");
            int iLastIndexOf = string.lastIndexOf(47);
            String strSubstring = string.substring(iLastIndexOf + 1);
            String strSubstring2 = string.substring(0, iLastIndexOf);
            String strSubstring3 = strSubstring2.concat("/").substring(strSubstring2.toLowerCase(Locale.getDefault()).indexOf("snotedata") + 10);
            c0329c.getClass();
            boolean zIsSpdAlreadyConverted = C0322h.m670a().f823i.isSpdAlreadyConverted(c0329c.f846a, string);
            if (!z) {
                list.add(new ImportItem(20, strSubstring3, strSubstring, jSONObject.getLong("clientTimestamp"), jSONObject.getString("datakey"), zIsSpdAlreadyConverted));
                Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSpdAlreadyConverted);
                return;
            }
            synchronized (SnoteScloudSync.class) {
                list.add(new ImportItem(20, strSubstring3, strSubstring, jSONObject.getLong("clientTimestamp"), jSONObject.getString("datakey"), zIsSpdAlreadyConverted));
                Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSpdAlreadyConverted);
            }
        } catch (JSONException e) {
            Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
        }
    }

    private ArrayList<C0009i> downloadImportDataForList() throws SyncException {
        ArrayList<C0009i> arrayList = new ArrayList<>();
        try {
            try {
                Iterator it = AbstractC6848m.m5010c(this.mConnectionInfo, null, false).iterator();
                while (it.hasNext()) {
                    JSONArray jSONArray = ((JSONObject) it.next()).getJSONArray("snote_list");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject.has("filepath")) {
                                arrayList.add(new C0009i(0, jSONObject.getLong("clientTimestamp"), jSONObject.getString("datakey"), ""));
                            }
                        } catch (JSONException e) {
                            Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                Debugger.m8609e(TAG, "JSONException - " + e2.getMessage());
                throw new SyncException(304, "Getting snote_list failed");
            }
        } catch (SyncException e3) {
            AbstractC6670b.m4752m(e3, new StringBuilder("fail to downloadList : "), TAG);
            throw e3;
        } catch (Exception e5) {
            throw new SyncException(303, e5.getMessage());
        }
    }

    private void getConnectionInfo() {
        this.mConnectionInfo = new C6845j(this.mAuthorization, "PM3HWwUYhP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSPDImportListFromServer$0(JSONArray jSONArray, List list, C0329c c0329c, int i) {
        addSNoteItemToImportList(jSONArray, i, list, c0329c, true);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() throws SyncException {
        Debugger.m8615i(TAG, "getImportItems() start");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        getConnectionInfo();
        if (this.mResultList == null) {
            this.mResultList = new ArrayList();
        }
        Debugger.m8607d(TAG, "Downloading the doc list");
        try {
            this.mResultList = getSPDImportListFromServer();
        } catch (SyncException e) {
            int exceptionCode = e.getExceptionCode();
            if (exceptionCode == 303 || exceptionCode == 315 || exceptionCode == 321) {
                Debugger.m8609e(TAG, "getImportItems : fail to Download SPDImportList");
                throw new SyncException(315, e.toString());
            }
            Debugger.m8615i(TAG, "Getting SPD file list failed > skipped this step");
        }
        try {
            this.mResultList.addAll(getSNBImportListFromServer());
        } catch (SyncException e2) {
            int exceptionCode2 = e2.getExceptionCode();
            if (exceptionCode2 == 303 || exceptionCode2 == 315 || exceptionCode2 == 321) {
                Debugger.m8609e(TAG, "getImportItems : fail to Download SNBImportList");
                throw new SyncException(315, e2.toString());
            }
            Debugger.m8615i(TAG, "Getting SNB file list failed > skipped this step");
        }
        Debugger.m8607d(TAG, "Updating the doc list");
        synchronized (this) {
            try {
                if (this.mListener != null) {
                    int size = this.mResultList.size();
                    int i = 0;
                    while (i < size) {
                        ImportItem importItem = this.mResultList.get(i);
                        i++;
                        this.mListener.onUpdated(this.mTaskType, i, size, importItem);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8615i(TAG, "getImportItems finish(" + this.mResultList.size() + ") - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    public List<ImportItem> getSNBImportListFromServer() {
        C12020a c12020a = new C12020a(this.mAuthorization, 9);
        ArrayList arrayList = new ArrayList();
        String lowerCase = "/storage/sdcard0/S Note/".toLowerCase(Locale.getDefault());
        Object objCreateSNBConverter = C0322h.m670a().f823i.createSNBConverter();
        try {
            for (JSONObject jSONObject : c12020a.m13634M()) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("value")).getJSONObject("FILES");
                    String string = jSONObject2.getString("path");
                    Debugger.m8616s(TAG, "SNB File : " + string);
                    if (string.toLowerCase(Locale.getDefault()).endsWith(".snb") && string.toLowerCase(Locale.getDefault()).startsWith(lowerCase)) {
                        long j = jSONObject2.getLong("ModifiedTime");
                        if (j >= 1000000000000L) {
                            String strSubstring = string.substring(string.lastIndexOf(47) + 1);
                            String strSubstring2 = string.substring(24);
                            ImportItem importItem = new ImportItem(12, strSubstring2.contains("/") ? strSubstring2.substring(0, strSubstring2.length() - strSubstring.length()) : "", strSubstring, j, jSONObject.getString("key"), C0322h.m670a().f823i.isSnbAlreadyConverted(objCreateSNBConverter, string));
                            Debugger.m8607d(TAG, "isAlreadyConverted : " + C0322h.m670a().f823i.isSnbAlreadyConverted(objCreateSNBConverter, string));
                            importItem.setExtraObject(jSONObject);
                            arrayList.add(importItem);
                        }
                    }
                } catch (JSONException e) {
                    Debugger.m8609e(TAG, "JSONException - " + e.getMessage());
                }
            }
        } catch (JSONException e2) {
            Debugger.m8609e(TAG, "JSONException - " + e2.getMessage());
        }
        return arrayList;
    }

    public List<ImportItem> getSPDImportListFromServer() throws SyncException {
        ArrayList arrayList = new ArrayList();
        if (!isCancelled()) {
            try {
                ArrayList arrayListM5010c = AbstractC6848m.m5010c(this.mConnectionInfo, null, false);
                C0329c c0329c = new C0329c();
                try {
                    Iterator it = arrayListM5010c.iterator();
                    while (it.hasNext()) {
                        JSONArray jSONArray = ((JSONObject) it.next()).getJSONArray("snote_list");
                        IntStream.range(0, jSONArray.length()).parallel().forEach(new C6775a(this, jSONArray, arrayList, c0329c));
                    }
                } catch (JSONException unused) {
                    throw new SyncException(304, "Getting snote_list failed");
                }
            } catch (Exception e) {
                throw new SyncException(303, e.getMessage());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0164, code lost:
    
        r4 = (r6 + "SnoteData/" + r0.getContainerName() + "/" + r5).replace("//", "/");
        r14 = new java.lang.StringBuilder();
        r14.append("Start converting a snote : ");
        r14.append(r4);
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8615i(com.samsung.android.app.notes.sync.importing.core.types.SnoteScloudSync.TAG, r14.toString());
        convertingImportItem(r4, r0, r9);
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8615i(com.samsung.android.app.notes.sync.importing.core.types.SnoteScloudSync.TAG, "succeed to convert");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ad, code lost:
    
        r18 = r2;
        r17 = r7;
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x025f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startImport() throws SyncException {
        int i;
        C12020a c12020a;
        JSONObject jSONObject;
        long j;
        File file;
        int i2;
        String string;
        String strSubstring;
        String str;
        String str2;
        Debugger.m8615i(TAG, "startImport()[" + hashCode() + "]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        getConnectionInfo();
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                i = 0;
                if (listener != null) {
                    listener.onDownloaded(DocTypeConstants.SNOTE_SCLOUD, null, 0);
                }
            } finally {
            }
        }
        ArrayList<C0009i> arrayListDownloadImportDataForList = downloadImportDataForList();
        File file2 = new File(AbstractC0155m.m392g(this.mContext) + "/SnoteData/");
        if (file2.exists()) {
            AbstractC0155m.m389d(file2);
        }
        String str3 = this.mContext.getFilesDir().getAbsolutePath() + "/";
        ArrayList arrayList = new ArrayList();
        Iterator<C0009i> it = arrayListDownloadImportDataForList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f38a);
        }
        this.mSuccessfulList = new ArrayList();
        C0327a c0327a = new C0327a();
        initializeConverter(c0327a);
        try {
            int size = this.mImportList.size();
            int i4 = 0;
            while (i4 < size && !isCancelled()) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (!AbstractC0155m.m401p()) {
                    throw new SyncException(323, "device storage is full!");
                }
                ImportItem importItem = this.mImportList.get(i4);
                try {
                    if (importItem.getItemType() != 20) {
                        c12020a = new C12020a(this.mAuthorization, 9);
                        Object extraObject = importItem.getExtraObject();
                        if (extraObject instanceof JSONObject) {
                            jSONObject = (JSONObject) extraObject;
                            try {
                                string = new JSONObject(jSONObject.getString("value")).getJSONObject("FILES").getString("path");
                                j = jElapsedRealtime;
                            } catch (JSONException e) {
                                e = e;
                                j = jElapsedRealtime;
                            }
                            try {
                                strSubstring = string.substring(string.lastIndexOf(47) + 1, string.length() - 4);
                                str = str3 + strSubstring + ".snb";
                                synchronized (this) {
                                    try {
                                        ImportBaseTask.Listener listener2 = this.mListener;
                                        if (listener2 != null) {
                                            file = file2;
                                            i2 = 0;
                                            try {
                                                listener2.onDownloaded(DocTypeConstants.SNOTE_SCLOUD, importItem, 0);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        } else {
                                            file = file2;
                                            i2 = 0;
                                        }
                                        c12020a.m13633L(jSONObject, str3 + strSubstring);
                                        synchronized (this) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        file = file2;
                                        i2 = 0;
                                    }
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                file = file2;
                                i2 = 0;
                                Debugger.m8609e(TAG, e.toString());
                                Debugger.m8609e(TAG, "fail to download a Snote - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                                i4++;
                                i = i2;
                                file2 = file;
                                jElapsedRealtime = j;
                            }
                        } else {
                            j = jElapsedRealtime;
                            file = file2;
                            i2 = 0;
                        }
                        Debugger.m8609e(TAG, "fail to download a Snote - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                    } else if (arrayList.contains(importItem.getServerKey())) {
                        synchronized (this) {
                            try {
                                ImportBaseTask.Listener listener3 = this.mListener;
                                if (listener3 != null) {
                                    listener3.onDownloaded(DocTypeConstants.SNOTE_SCLOUD, importItem, i);
                                }
                            } finally {
                            }
                        }
                        Iterator it2 = AbstractC6848m.m5009b(this.mConnectionInfo, importItem.getServerKey(), str3 + "/SnoteData/" + importItem.getContainerName() + "/").iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                str2 = null;
                                break;
                            } else {
                                str2 = (String) it2.next();
                                if (str2.toLowerCase(Locale.getDefault()).endsWith("spd")) {
                                }
                            }
                        }
                        if (str2 == null) {
                            Debugger.m8609e(TAG, "There is no completeFile!");
                            j = jElapsedRealtime;
                            file = file2;
                            i2 = 0;
                        } else {
                            try {
                                synchronized (this) {
                                    try {
                                        ImportBaseTask.Listener listener4 = this.mListener;
                                        if (listener4 != null) {
                                            listener4.onDownloaded(DocTypeConstants.SNOTE_SCLOUD, importItem, 1);
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                                try {
                                    c12020a.m13633L(jSONObject, str3 + strSubstring);
                                    try {
                                        synchronized (this) {
                                            try {
                                                ImportBaseTask.Listener listener5 = this.mListener;
                                                if (listener5 != null) {
                                                    listener5.onDownloaded(DocTypeConstants.SNOTE_SCLOUD, importItem, 1);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        C0322h.m670a().f816b.oldZip(str3 + strSubstring + "/", str);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Start converting a snb : ");
                                        sb.append(str);
                                        Debugger.m8615i(TAG, sb.toString());
                                        convertingImportItem(str.replace("//", "/"), importItem, c0327a);
                                        Debugger.m8615i(TAG, "finish converting");
                                        this.mSuccessfulList.add(importItem);
                                        Debugger.m8607d(TAG, "succeed to download a Snote [" + this.mSuccessfulList.size() + " / " + size + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                                    } catch (Exception e3) {
                                        Debugger.m8609e(TAG, "Failed to convert snb file : " + e3.getMessage());
                                        Debugger.m8609e(TAG, "fail to download a Snote - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    Debugger.m8609e(TAG, e.toString());
                                }
                            } catch (Exception e6) {
                                Debugger.m8609e(TAG, "Failed to convert spd file : " + e6.getMessage());
                                j = jElapsedRealtime;
                                file = file2;
                                i2 = 0;
                                Debugger.m8609e(TAG, "fail to download a Snote - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                            }
                        }
                    } else {
                        Debugger.m8609e(TAG, "There is no server key.");
                        j = jElapsedRealtime;
                        file = file2;
                        i2 = i;
                    }
                    i4++;
                    i = i2;
                    file2 = file;
                    jElapsedRealtime = j;
                } catch (SyncException e7) {
                    Debugger.m8607d(TAG, e7.toString());
                    throw e7;
                }
            }
            finalizeConverter(c0327a);
            AbstractC0155m.m389d(file2);
            Debugger.m8615i(TAG, "Finish startImport()[" + hashCode() + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        } catch (Throwable th5) {
            finalizeConverter(c0327a);
            throw th5;
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    public SnoteScloudSync(Context context, String str, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.SNOTE_SCLOUD, i, TAG);
        this.mImportList = list;
        this.mAuthorization = str;
    }
}
