package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6805n implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6835r f4238a;

    public RunnableC6805n(C6835r c6835r) {
        this.f4238a = c6835r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ModelStartManager.INSTANCE.getInstance().closeAll(new C6804m(this));
    }
}
