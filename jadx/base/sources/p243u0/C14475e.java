package p243u0;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p038I1.C0132h;
import p038I1.C0137m;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p188i3.RunnableC12034a;

/* JADX INFO: renamed from: u0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14475e extends AbstractC14471a {

    /* JADX INFO: renamed from: c */
    public int f10278c;

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: f */
    public final void mo15053f() {
        m15063j();
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: g */
    public final void mo15054g() {
        m15063j();
        C0132h c0132h = new C0132h();
        C0322h.m670a().f815a.getAppContext();
        C0137m c0137mM280d = C0137m.m280d();
        NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
        if (c0137mM280d.m283a(c0132h)) {
            c0137mM280d.m284b(c0132h);
            return;
        }
        Debugger.m8607d("HandleSyncTipCard", "Do not added tipCard " + C0137m.m282j(c0132h.getType()) + ". already exist");
    }

    /* JADX INFO: renamed from: j */
    public final void m15063j() {
        int i = this.f10278c;
        if ((i & 64) == 64 && (i & 8192) != 8192) {
            new Handler(Looper.getMainLooper()).post(new RunnableC12034a(this, 11));
        }
        m15056i();
        C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.NETWORK);
        m15055h();
        AbstractC0299q.m625e("5034");
    }
}
