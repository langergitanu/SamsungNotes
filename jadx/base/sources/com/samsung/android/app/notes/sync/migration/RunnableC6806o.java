package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.startmanager.MainListStartManager;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6806o implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6835r f4239a;

    public RunnableC6806o(C6835r c6835r) {
        this.f4239a = c6835r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainListStartManager.INSTANCE.getInstance().closeAllNoteLists();
        AbstractC0299q.m643n(C6835r.f4246f, "MainListStartManager closeAllNoteLists");
        C6835r.m4996a(this.f4239a);
    }
}
