package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6804m implements ModelStartManager.OnCloseListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RunnableC6805n f4237a;

    public C6804m(RunnableC6805n runnableC6805n) {
        this.f4237a = runnableC6805n;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.startmanager.ModelStartManager.OnCloseListener
    public final void onClosed() {
        AbstractC0299q.m643n(C6835r.f4246f, "ModelStartManager onClosed");
        C6835r.m4996a(this.f4237a.f4238a);
    }
}
