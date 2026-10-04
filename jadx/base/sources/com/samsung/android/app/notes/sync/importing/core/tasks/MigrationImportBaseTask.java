package com.samsung.android.app.notes.sync.importing.core.tasks;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;
import p042J1.AbstractC0147e;
import p042J1.C0148f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MigrationImportBaseTask extends ImportBaseTask {
    protected boolean mFromSmartSwitch;

    public MigrationImportBaseTask(Context context, ImportBaseTask.Listener listener, DocTypeConstants docTypeConstants, int i, boolean z) {
        super(context, listener, docTypeConstants, i);
        this.mFromSmartSwitch = z;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onCancelled() {
        unsetRunningFlag();
        super.onCancelled();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        setRunningFlag();
    }

    public void sendProgressEntireRestore(int i) {
        if (this.mFromSmartSwitch) {
            String str = C0148f.f420k;
            AbstractC0147e.f419a.m367j(i);
        }
    }

    public void sendResponseEntireRestore(int i, int i2) {
        if (this.mFromSmartSwitch) {
            String str = C0148f.f420k;
            C0148f c0148f = AbstractC0147e.f419a;
            C0148f.m358n(i, i2, c0148f.f431a, c0148f.f432b);
        }
    }

    public abstract void setRunningFlag();

    public abstract void unsetRunningFlag();

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onPostExecute(List<ImportItem> list) {
        unsetRunningFlag();
        super.onPostExecute(list);
    }
}
