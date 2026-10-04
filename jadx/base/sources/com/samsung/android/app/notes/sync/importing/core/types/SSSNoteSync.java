package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SSSNoteSync extends MigrationImportBaseTask {
    private static final String TAG = "SS$SSSNoteSync";

    public SSSNoteSync(Context context, ImportBaseTask.Listener listener, int i, boolean z) {
        super(context, listener, DocTypeConstants.SNOTE_LOCAL, i, z);
    }

    private void clearTempFiles() {
        Debugger.m8607d(TAG, "clearTempFiles.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        File file = new File(C0148f.f422m);
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                AbstractC0000a.m20q(e, new StringBuilder("restorePath_TMemo2"), TAG);
            }
        }
        AbstractC0147e.f419a.getClass();
        File file2 = new File(C0148f.f423n);
        if (file2.exists()) {
            try {
                FileUtils.deleteFile(file2);
            } catch (IOException e2) {
                AbstractC0000a.m20q(e2, new StringBuilder("restorePath_SMemo"), TAG);
            }
        }
        AbstractC0147e.f419a.getClass();
        File file3 = new File(C0148f.f424o);
        if (file3.exists()) {
            try {
                FileUtils.deleteFile(file3);
            } catch (IOException e3) {
                AbstractC0000a.m20q(e3, new StringBuilder("restorePath_SMemo2"), TAG);
            }
        }
        AbstractC0147e.f419a.getClass();
        File file4 = new File(C0148f.f425p);
        if (file4.exists()) {
            try {
                FileUtils.deleteFile(file4);
            } catch (IOException e5) {
                AbstractC0000a.m20q(e5, new StringBuilder("restorePath_SNote"), TAG);
            }
        }
        AbstractC0147e.f419a.getClass();
        File file5 = new File(C0148f.f426q);
        if (file5.exists()) {
            try {
                FileUtils.deleteFile(file5);
            } catch (IOException e6) {
                AbstractC0000a.m20q(e6, new StringBuilder("restorePath_SNote3"), TAG);
            }
        }
        unsetRunningFlag();
        AbstractC0147e.f419a.m366g();
    }

    private void deleteFromMediaScanner(String str, File file) throws Throwable {
        Cursor cursorQuery;
        if (str == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                String path = Uri.parse(str).getPath();
                cursorQuery = C0322h.m670a().f815a.getAppContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_data='" + path + "'", null, null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery == null) {
                Debugger.m8607d(TAG, "deleteFromMediaScanner c == null");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (file != null && !file.delete()) {
                    Debugger.m8609e(TAG, "deleteFromMediaScanner delete fail");
                }
            } else {
                cursorQuery.moveToFirst();
                Debugger.m8614f(TAG, "deleteFromMediaScanner result " + C0322h.m670a().f815a.getAppContext().getContentResolver().delete(MediaStore.Files.getContentUri("external", cursorQuery.getInt(0)), null, null));
                cursorQuery.close();
                if (file != null && !file.delete()) {
                    Debugger.m8609e(TAG, "deleteFromMediaScanner delete fail");
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = cursorQuery;
            Debugger.m8609e(TAG, "deleteFromMediaScanner : " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            if (file == null || file.delete()) {
                return;
            }
            Debugger.m8609e(TAG, "deleteFromMediaScanner delete fail");
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            if (file != null && !file.delete()) {
                Debugger.m8609e(TAG, "deleteFromMediaScanner delete fail");
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(4:12|65|13|17)(2:18|(4:20|61|21|25)(2:69|58))|63|27|(1:29)(2:30|(1:32))|33|(1:35)|41|(2:43|(2:45|72)(1:71))(1:70)|58) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0199, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b0, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e(com.samsung.android.app.notes.sync.importing.core.types.SSSNoteSync.TAG, "Exception Failed to convert : " + com.samsung.android.support.senl.p148nt.base.common.util.FileUtils.logPath(r6) + " " + r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01d8, code lost:
    
        if (r5.getRemoveOnConverted() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01da, code lost:
    
        r5 = new java.io.File(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01e3, code lost:
    
        if (r5.exists() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void importItems() throws Throwable {
        String strReplace;
        Debugger.m8607d(TAG, "Start importItems.");
        Object objCreateSPDConverter = C0322h.m670a().f823i.createSPDConverter();
        Object objCreateSNBConverter = C0322h.m670a().f823i.createSNBConverter();
        if (this.mSuccessfulList == null) {
            this.mSuccessfulList = new ArrayList();
        }
        int size = this.mImportList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (!AbstractC0155m.m401p()) {
                Debugger.m8609e(TAG, "Not enough free space.");
                break;
            }
            ImportItem importItem = this.mImportList.get(i);
            Debugger.m8615i(TAG, "Start to convert file : " + importItem.getLocalFullPath());
            try {
                if (importItem.getLocalFullPath().endsWith("spd")) {
                    strReplace = importItem.getLocalFullPath().replace(".spd", ".spdbak");
                    try {
                        FileUtils.forceRenameTo(importItem.getLocalFullPath(), strReplace);
                    } catch (IOException e) {
                        AbstractC0000a.m20q(e, new StringBuilder("rename spd IOException : "), TAG);
                    }
                    C0322h.m670a().f815a.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + new File(strReplace).getAbsolutePath())));
                } else if (importItem.getLocalFullPath().endsWith("snb")) {
                    strReplace = importItem.getLocalFullPath().replace(".snb", ".snbbak");
                    try {
                        FileUtils.forceRenameTo(importItem.getLocalFullPath(), strReplace);
                    } catch (IOException e2) {
                        AbstractC0000a.m20q(e2, new StringBuilder("rename snb IOException : "), TAG);
                    }
                    C0322h.m670a().f815a.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + new File(strReplace).getAbsolutePath())));
                } else {
                    i++;
                }
                if (strReplace.endsWith("spdbak")) {
                    C0322h.m670a().f823i.spdConvertToSDoc(objCreateSPDConverter, strReplace, C0322h.m670a().f823i.getSpdConvertModeNormal());
                } else if (strReplace.endsWith("snbbak")) {
                    C0322h.m670a().f823i.snbConvertToSDoc(objCreateSNBConverter, strReplace, C0322h.m670a().f823i.getSnbConvertModeNormal());
                }
                Debugger.m8615i(TAG, "Succeed to convert spd file : " + FileUtils.logPath(strReplace));
                this.mSuccessfulList.add(importItem);
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    DocTypeConstants docTypeConstants = DocTypeConstants.SNOTE_LOCAL;
                    listener.onDownloaded(docTypeConstants, importItem, this.mSuccessfulList.size());
                    this.mListener.onItemImportFinished(docTypeConstants, i + 1, this.mSuccessfulList.size(), size);
                }
                if (importItem.getRemoveOnConverted()) {
                    File file = new File(strReplace);
                    if (file.exists()) {
                        deleteFromMediaScanner(strReplace, file);
                    }
                }
                i++;
            } catch (Throwable th) {
                if (importItem.getRemoveOnConverted()) {
                    File file2 = new File(strReplace);
                    if (file2.exists()) {
                        deleteFromMediaScanner(strReplace, file2);
                    }
                }
                throw th;
            }
            Debugger.m8615i(TAG, "start to convert file : " + FileUtils.logPath(strReplace));
        }
        Debugger.m8607d(TAG, "End importItems.");
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() {
        if (this.mListener != null) {
            int size = this.mImportList.size();
            int i = 0;
            while (i < size) {
                ImportItem importItem = this.mImportList.get(i);
                i++;
                this.mListener.onUpdated(DocTypeConstants.SNOTE_LOCAL, i, size, importItem);
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void setRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f438h = true;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws Throwable {
        importItems();
        clearTempFiles();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void unsetRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f438h = false;
    }

    public SSSNoteSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list, boolean z) {
        super(context, listener, DocTypeConstants.SNOTE_LOCAL, i, z);
        this.mImportList = list;
    }
}
