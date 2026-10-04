package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.os.SystemClock;
import com.samsung.android.app.notes.MemoApplication;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import p042J1.C0145c;
import p044K.C0158a;
import p086V.C0322h;
import p186h1.C12028i;
import p195k1.C12969a;
import p211o0.C13567a;
import p249v1.C14498a;
import p249v1.C14499b;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.B */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9675B implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6912a;

    public /* synthetic */ RunnableC9675B(int i) {
        this.f6912a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6912a) {
            case 0:
                AiMenuResultViewSTT.lambda$initTopMenu$11();
                break;
            case 1:
                new C12028i().m13709d(2);
                C0158a.m407a().getClass();
                if (SyncState.isEdpMode()) {
                    C13567a.m14371a().m14373d(new C14498a());
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (C12969a.m13872b(C14499b.m15083b()).m13874c()) {
                    C12969a.m13872b(C14499b.m15083b()).m13880i();
                } else {
                    Debugger.m8607d("SyncLogic", "initSyncLogic() : ignore registering push!");
                }
                C0145c.m301I(C14499b.m15083b());
                Debugger.m8607d("SyncLogic", "onCreateSyncThread Finish - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                break;
            case 2:
                C0322h.m670a().f828n.setSyncEnable(false, false);
                break;
            case 3:
                MemoApplication.lambda$onCreate$0();
                break;
            case 4:
                MemoApplication.lambda$onCreate$3();
                break;
            default:
                MemoApplication.lambda$onCreate$4();
                break;
        }
    }

    public /* synthetic */ RunnableC9675B(C14499b c14499b) {
        this.f6912a = 1;
    }
}
