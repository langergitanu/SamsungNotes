package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.startmanager.CoeditStartManager;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6807p implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6835r f4240a;

    public RunnableC6807p(C6835r c6835r) {
        this.f4240a = c6835r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CoeditStartManager.INSTANCE.getInstance().stopCoeditDownload(new C6802k(this, 1));
    }
}
