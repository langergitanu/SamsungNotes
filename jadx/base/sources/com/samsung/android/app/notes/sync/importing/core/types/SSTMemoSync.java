package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import androidx.collection.AbstractC0622a;
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
import p086V.InterfaceC0319e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SSTMemoSync extends MigrationImportBaseTask {
    private static final String TAG = "SS$SSTMemoSync";

    public SSTMemoSync(Context context, ImportBaseTask.Listener listener, int i, boolean z) {
        super(context, listener, DocTypeConstants.SS_TMEMO, i, z);
    }

    private void clearTempFiles() {
        Debugger.m8607d(TAG, "clearTempFiles.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        File file = new File(C0148f.f421l);
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                AbstractC0000a.m20q(e, new StringBuilder("IOException while deleting restoreTMemoPath. "), TAG);
            }
        }
        unsetRunningFlag();
        AbstractC0147e.f419a.m366g();
    }

    private void importItems() {
        Debugger.m8607d(TAG, "importItems.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strM387b = AbstractC0155m.m387b(C0148f.f421l, "TMemo.xml");
        if (this.mSuccessfulList == null) {
            this.mSuccessfulList = new ArrayList();
        }
        try {
            Debugger.m8615i(TAG, "Start converting");
            C0322h.m670a().f823i.TMemoConvertToSDoc(C0322h.m670a().f823i.createTMemoConverter(), C0322h.m670a().f815a.getAppContext(), strM387b, new InterfaceC0319e() { // from class: com.samsung.android.app.notes.sync.importing.core.types.SSTMemoSync.1
                @Override // p086V.InterfaceC0319e
                public void onProgress(int i, int i2) {
                    Debugger.m8615i(SSTMemoSync.TAG, AbstractC0622a.m1164j(i, i2, "onProgress( ", " / ", ")"));
                    SSTMemoSync.this.updateProgress(i, i2);
                }
            });
            Debugger.m8615i(TAG, "Succeed to convert");
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Exception"), TAG);
        }
        if (!new File(strM387b).delete()) {
            Debugger.m8609e(TAG, "Failed to delete encryptedTMemo");
        }
        sendResponseEntireRestore(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i, int i2) {
        if (i <= 0 || i > i2) {
            Debugger.m8609e(TAG, "doneCnt error");
            return;
        }
        StringBuilder sb = new StringBuilder("updateProgress ");
        int i4 = i - 1;
        sb.append(i4);
        Debugger.m8615i(TAG, sb.toString());
        this.mSuccessfulList.add(this.mImportList.get(i4));
        ImportBaseTask.Listener listener = this.mListener;
        if (listener != null) {
            DocTypeConstants docTypeConstants = DocTypeConstants.SS_TMEMO;
            listener.onDownloaded(docTypeConstants, this.mImportList.get(i4), this.mSuccessfulList.size());
            this.mListener.onItemImportFinished(docTypeConstants, i, this.mSuccessfulList.size(), i2);
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() {
        if (this.mListener != null) {
            int size = this.mImportList.size();
            int i = 0;
            while (i < size) {
                ImportItem importItem = this.mImportList.get(i);
                i++;
                this.mListener.onUpdated(DocTypeConstants.SS_TMEMO, i, size, importItem);
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.MigrationImportBaseTask
    public void setRunningFlag() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f437g = true;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() {
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
        AbstractC0147e.f419a.f437g = false;
    }

    public SSTMemoSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list, boolean z) {
        super(context, listener, DocTypeConstants.SS_TMEMO, i, z);
        this.mImportList = list;
    }
}
