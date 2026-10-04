package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.network.AbstractC6841f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p002A0.C0009i;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p086V.C0322h;
import p089W.C0327a;
import p089W.C0328b;
import p089W.C0329c;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteGoogleDriveSync extends SnoteBaseSync {
    private static final String TAG = "SnoteGoogleDriveSync";
    Drive mDrive;

    public SnoteGoogleDriveSync(Context context, Drive drive, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.SNOTE_GOOGLEDRIVE, i, TAG);
        this.mDrive = drive;
    }

    private void addSNBFileToImportList(File file, List<ImportItem> list, ArrayList<File> arrayList, C0328b c0328b, boolean z) {
        String title = file.getTitle();
        String downloadUrl = file.getDownloadUrl();
        long value = file.getCreatedDate().getValue();
        String strM15153m = AbstractC14517a.m15153m(file.getParents().get(0).getId(), arrayList);
        if (strM15153m == null) {
            strM15153m = "";
        }
        StringBuilder sb = new StringBuilder(strM15153m);
        if (sb.length() != 0) {
            sb.append('/');
        }
        Debugger.m8607d(TAG, "SNB fileName : " + FileUtils.logPath(title) + " , pathFromSNoteRoot : " + FileUtils.logPath(sb.toString()) + " , created time : " + file.getCreatedDate().toString());
        StringBuilder sb2 = new StringBuilder("/");
        sb2.append(title);
        String string = sb2.toString();
        c0328b.getClass();
        boolean zIsSnbAlreadyConverted = C0322h.m670a().f823i.isSnbAlreadyConverted(c0328b.f845a, string);
        if (!z) {
            list.add(new ImportItem(20, sb.toString(), title, value, downloadUrl, zIsSnbAlreadyConverted));
            Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSnbAlreadyConverted);
            return;
        }
        synchronized (list) {
            list.add(new ImportItem(20, sb.toString(), title, value, downloadUrl, zIsSnbAlreadyConverted));
            Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSnbAlreadyConverted);
        }
    }

    private void addSPDFileToImportList(File file, List<ImportItem> list, ArrayList<File> arrayList, C0329c c0329c, boolean z) {
        String title = file.getTitle();
        String downloadUrl = file.getDownloadUrl();
        long value = file.getCreatedDate().getValue();
        String strM15153m = AbstractC14517a.m15153m(file.getParents().get(0).getId(), arrayList);
        if (strM15153m == null) {
            strM15153m = "";
        }
        StringBuilder sb = new StringBuilder(strM15153m);
        if (sb.length() != 0) {
            sb.append('/');
        }
        Debugger.m8607d(TAG, "SPD fileName : " + FileUtils.logPath(title) + " , pathFromSNoteRoot : " + FileUtils.logPath(sb.toString()) + " , created time : " + file.getCreatedDate().toString());
        StringBuilder sb2 = new StringBuilder("/");
        sb2.append(title);
        String string = sb2.toString();
        c0329c.getClass();
        boolean zIsSpdAlreadyConverted = C0322h.m670a().f823i.isSpdAlreadyConverted(c0329c.f846a, string);
        if (!z) {
            list.add(new ImportItem(20, sb.toString(), title, value, downloadUrl, zIsSpdAlreadyConverted));
            Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSpdAlreadyConverted);
            return;
        }
        synchronized (list) {
            list.add(new ImportItem(20, sb.toString(), title, value, downloadUrl, zIsSpdAlreadyConverted));
            Debugger.m8607d(TAG, "isAlreadyConverted : " + zIsSpdAlreadyConverted);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getImportListFromServer$0(List list, ArrayList arrayList, C0329c c0329c, File file) {
        addSPDFileToImportList(file, list, arrayList, c0329c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getImportListFromServer$1(List list, ArrayList arrayList, C0328b c0328b, File file) {
        addSNBFileToImportList(file, list, arrayList, c0328b, true);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() {
        Debugger.m8615i(TAG, "getImportItems() start");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Debugger.m8607d(TAG, "Downloading the doc list");
        if (this.mResultList == null) {
            this.mResultList = getImportListFromServer();
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

    public List<ImportItem> getImportListFromServer() throws SyncException {
        SnoteGoogleDriveSync snoteGoogleDriveSync;
        Debugger.m8607d(TAG, "getImportListFromServer()");
        ArrayList arrayList = new ArrayList();
        if (isCancelled()) {
            return arrayList;
        }
        if (this.mDrive == null) {
            Debugger.m8609e(TAG, "getImportListFromServer() : mDrive is null");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        try {
            if (C0145c.m334s(this.mContext)) {
                AbstractC6841f.m5006b(this.mDrive, arrayList2, arrayList3, arrayList4);
                C0329c c0329c = new C0329c();
                C0328b c0328b = new C0328b();
                c0328b.f845a = C0322h.m670a().f823i.createSNBConverter();
                ArrayList arrayList5 = new ArrayList(arrayList2);
                arrayList5.parallelStream().forEach(new C6776b(0, this, arrayList, arrayList4, c0329c));
                arrayList5.clear();
                arrayList5.addAll(arrayList3);
                arrayList5.parallelStream().forEach(new C6776b(1, this, arrayList, arrayList4, c0328b));
                return arrayList;
            }
            snoteGoogleDriveSync = this;
            try {
                throw new SyncException(315, "Server Error!");
            } catch (UserRecoverableAuthIOException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
                Debugger.m8609e(TAG, "getImportListFromServer() - IOException " + e.getMessage());
                Debugger.m8608e(e);
                if (e instanceof GoogleAuthIOException) {
                    Debugger.m8609e(TAG, "getImportListFromServer() - GoogleAuthIOException ");
                    throw new SyncException(315, e.getMessage());
                }
                C0145c.m301I(snoteGoogleDriveSync.mContext);
                if (C0145c.m334s(snoteGoogleDriveSync.mContext)) {
                    throw new SyncException(315, e.getMessage());
                }
                throw new SyncException(303, e.getMessage());
            }
        } catch (UserRecoverableAuthIOException e3) {
            e = e3;
        } catch (IOException e5) {
            e = e5;
            snoteGoogleDriveSync = this;
        }
        Debugger.m8609e(TAG, "getImportListFromServer() - UserRecoverableAuthIOException " + e.getMessage());
        throw new SyncException(340, e);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws SyncException {
        int i;
        Debugger.m8615i(TAG, "startImport()[" + hashCode() + "]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.mDrive == null) {
            Debugger.m8609e(TAG, "startImport() : mDrive is null");
            return;
        }
        Debugger.m8607d(TAG, "start updating the tipcard with IMPORTING_STATE_DOWNLOADING");
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                i = 0;
                if (listener != null) {
                    listener.onDownloaded(DocTypeConstants.SNOTE_GOOGLEDRIVE, null, 0);
                }
            } finally {
            }
        }
        try {
            List<ImportItem> importListFromServer = getImportListFromServer();
            if (importListFromServer.isEmpty()) {
                Debugger.m8609e(TAG, "startImport() : There is no file?");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ImportItem importItem : importListFromServer) {
                arrayList.add(new C0009i(0, importItem.getTimeStamp(), importItem.getServerKey(), importItem.getContent()));
            }
            java.io.File file = new java.io.File(AbstractC0155m.m392g(this.mContext) + "/SnoteData");
            if (file.exists()) {
                AbstractC0155m.m389d(file);
            }
            String str = this.mContext.getFilesDir().getAbsolutePath() + "/";
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C0009i) it.next()).f38a);
            }
            this.mSuccessfulList = new ArrayList();
            C0327a c0327a = new C0327a();
            initializeConverter(c0327a);
            try {
                int size = this.mImportList.size();
                int i2 = 0;
                while (i2 < size && !isCancelled()) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (!AbstractC0155m.m401p()) {
                        throw new SyncException(323, "device storage is full!");
                    }
                    ImportItem importItem2 = this.mImportList.get(i2);
                    try {
                        if (arrayList2.contains(importItem2.getServerKey())) {
                            Debugger.m8607d(TAG, "start updating the tipcard with IMPORTING_STATE_DOWNLOADING : " + (i2 + 1) + " / " + size);
                            synchronized (this) {
                                try {
                                    ImportBaseTask.Listener listener2 = this.mListener;
                                    if (listener2 != null) {
                                        listener2.onDownloaded(DocTypeConstants.SNOTE_GOOGLEDRIVE, importItem2, i);
                                    }
                                } finally {
                                }
                            }
                            Debugger.m8607d(TAG, "finish updating the tipcard with IMPORTING_STATE_DOWNLOADING");
                            try {
                                if (!C0145c.m334s(this.mContext)) {
                                    throw new SyncException(303, "Network is unable!");
                                }
                                Drive drive = this.mDrive;
                                String content = importItem2.getContent();
                                AbstractC6841f.m5005a(drive, content, importItem2.getServerKey(), str);
                                Debugger.m8607d(TAG, "downloadedFile = " + FileUtils.logPath(content));
                                String lowerCase = content.toLowerCase(Locale.getDefault());
                                if (!lowerCase.endsWith("spd") && !lowerCase.endsWith("snb")) {
                                    content = null;
                                }
                                if (content == null) {
                                    Debugger.m8609e(TAG, "There is no completeFile!");
                                } else {
                                    importItem2.setLocalFullPath(str + content);
                                    Debugger.m8615i(TAG, "start converting spd/snb file : " + importItem2.getLocalFullPath());
                                    try {
                                        synchronized (this) {
                                            try {
                                                ImportBaseTask.Listener listener3 = this.mListener;
                                                if (listener3 != null) {
                                                    listener3.onDownloaded(DocTypeConstants.SNOTE_GOOGLEDRIVE, importItem2, 1);
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                        Debugger.m8615i(TAG, "Start converting a snote : " + importItem2.getLocalFullPath());
                                        convertingImportItem(importItem2.getLocalFullPath(), importItem2, c0327a);
                                        Debugger.m8615i(TAG, "succeed to convert note file!");
                                        this.mSuccessfulList.add(importItem2);
                                    } catch (Exception e) {
                                        Debugger.m8609e(TAG, "Failed to convert note file : " + e.getMessage());
                                    }
                                    Debugger.m8607d(TAG, "finish handling " + importItem2.getContent() + " - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                                }
                            } catch (UserRecoverableAuthIOException e2) {
                                Debugger.m8609e(TAG, "startImport() - UserRecoverableAuthIOException " + e2.getMessage());
                                throw new SyncException(340, e2);
                            } catch (IOException e3) {
                                Debugger.m8609e(TAG, "startImport() - IOException " + e3.getMessage());
                                Debugger.m8608e(e3);
                                if (e3 instanceof GoogleAuthIOException) {
                                    Debugger.m8609e(TAG, "startImport() - GoogleAuthIOException ");
                                    throw new SyncException(315, e3.getMessage());
                                }
                                C0145c.m301I(this.mContext);
                                if (!C0145c.m334s(this.mContext)) {
                                    throw new SyncException(303, e3.getMessage());
                                }
                                throw new SyncException(315, e3.getMessage());
                            }
                        }
                        i2++;
                        i = 0;
                    } catch (SyncException e5) {
                        Debugger.m8609e(TAG, "failed to downloadFile");
                        throw e5;
                    }
                }
                finalizeConverter(c0327a);
                AbstractC0155m.m389d(file);
                Debugger.m8615i(TAG, "Finish startImport()[" + hashCode() + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Throwable th2) {
                finalizeConverter(c0327a);
                throw th2;
            }
        } catch (SyncException e6) {
            throw new SyncException(e6.getExceptionCode(), e6.getMessage(), e6);
        } catch (Exception e7) {
            Debugger.m8609e(TAG, "startImport() - another Exception" + e7.getMessage());
            throw new SyncException(TypedValues.Attributes.TYPE_PATH_ROTATE, e7.getMessage());
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() throws SyncException {
        getImportItems();
        this.mImportList = this.mResultList;
        startImport();
        return 0;
    }

    public SnoteGoogleDriveSync(Context context, Drive drive, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.SNOTE_GOOGLEDRIVE, i, TAG);
        this.mDrive = drive;
        this.mImportList = list;
    }
}
