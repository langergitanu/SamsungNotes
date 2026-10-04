package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6800i implements ComposerManager.IClosedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RunnableC6801j f4232a;

    public C6800i(RunnableC6801j runnableC6801j) {
        this.f4232a = runnableC6801j;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IClosedListener
    public final boolean onClosedAllComposer() {
        AbstractC0299q.m643n(C6835r.f4246f, "ComposerStartManager onClosedAllComposer");
        C6835r.m4996a(this.f4232a.f4233a);
        return false;
    }
}
