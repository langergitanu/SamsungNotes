package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6802k implements SyncProgressListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4234a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Runnable f4235b;

    public /* synthetic */ C6802k(Runnable runnable, int i) {
        this.f4234a = i;
        this.f4235b = runnable;
    }

    /* JADX INFO: renamed from: a */
    private final void m4972a() {
    }

    /* JADX INFO: renamed from: b */
    private final void m4973b() {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
    public final void onEnded(int i) {
        switch (this.f4234a) {
            case 0:
                AbstractC0299q.m643n(C6835r.f4246f, "SyncStartManager onEnded");
                C6835r.m4996a(((RunnableC6803l) this.f4235b).f4236a);
                break;
            default:
                AbstractC0299q.m643n(C6835r.f4246f, "CoeditStartManager onEnded");
                C6835r.m4996a(((RunnableC6807p) this.f4235b).f4240a);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
    public final void onStarted() {
        int i = this.f4234a;
    }
}
