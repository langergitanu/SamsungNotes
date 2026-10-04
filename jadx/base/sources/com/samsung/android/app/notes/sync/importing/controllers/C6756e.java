package com.samsung.android.app.notes.sync.importing.controllers;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.importing.core.HelperClassRegistry;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.controllers.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6756e {

    /* JADX INFO: renamed from: a */
    public final AbstractImportType f4150a;

    /* JADX INFO: renamed from: b */
    public final HelperClassRegistry f4151b = new HelperClassRegistry();

    /* JADX INFO: renamed from: c */
    public BasicImportHelperAdapter f4152c;

    public C6756e(AbstractImportType abstractImportType) {
        this.f4150a = abstractImportType;
    }

    /* JADX INFO: renamed from: a */
    public final void m4895a(Context context, ImportBaseTask.Listener listener) {
        HelperClassRegistry helperClassRegistry = this.f4151b;
        AbstractImportType abstractImportType = this.f4150a;
        BasicImportHelperAdapter basicImportHelperAdapterCreateImportHelperAdapter = helperClassRegistry.createImportHelperAdapter(context, abstractImportType);
        this.f4152c = basicImportHelperAdapterCreateImportHelperAdapter;
        if (basicImportHelperAdapterCreateImportHelperAdapter != null) {
            basicImportHelperAdapterCreateImportHelperAdapter.configureImportHelper(abstractImportType);
            this.f4152c.getImportHelper().setImportListener(listener);
            this.f4152c.getImportHelper().requestGetLists(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }
}
