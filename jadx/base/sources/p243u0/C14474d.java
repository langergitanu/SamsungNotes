package p243u0;

import android.content.Context;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p038I1.C0132h;
import p038I1.C0137m;
import p042J1.C0145c;
import p086V.C0322h;

/* JADX INFO: renamed from: u0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14474d extends AbstractC14471a {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f10276c;

    /* JADX INFO: renamed from: d */
    public int f10277d;

    public /* synthetic */ C14474d(int i) {
        this.f10276c = i;
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: f */
    public final void mo15053f() {
        switch (this.f10276c) {
            case 0:
                Context context = (Context) this.f4022a;
                if (!C0145c.m338w(context)) {
                    C0145c.m309Q(context, Boolean.TRUE);
                }
                Debugger.m8609e("SyncErrorSyncDataNetworkNotAvailable", "Fail to sync due to DataNetworkNotAvailable");
                m15056i();
                m15055h();
                break;
            default:
                m15062j();
                break;
        }
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: g */
    public final void mo15054g() {
        switch (this.f10276c) {
            case 0:
                Context context = (Context) this.f4022a;
                if (!C0145c.m338w(context)) {
                    C0145c.m309Q(context, Boolean.TRUE);
                }
                Debugger.m8609e("SyncErrorSyncDataNetworkNotAvailable", "Fail to sync due to DataNetworkNotAvailable");
                m15056i();
                m15055h();
                if ((this.f10277d & 64) == 64) {
                    C0132h c0132h = new C0132h();
                    C0322h.m670a().f815a.getAppContext();
                    C0137m c0137mM280d = C0137m.m280d();
                    NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
                    if (!c0137mM280d.m283a(c0132h)) {
                        Debugger.m8607d("HandleSyncTipCard", "Do not added tipCard " + C0137m.m282j(c0132h.getType()) + ". already exist");
                    } else {
                        c0137mM280d.m284b(c0132h);
                    }
                }
                break;
            default:
                m15062j();
                break;
        }
    }

    /* JADX INFO: renamed from: j */
    public void m15062j() {
        int i = this.f10277d;
        if ((i & 256) == 256) {
            Debugger.m8609e("SyncErrorSyncWifiOnly", "fail to handle MESSAGE_CODE_IGNOREWIFIONLY!");
        } else if ((i & 64) != 64) {
            C0145c.m309Q((Context) this.f4022a, Boolean.TRUE);
        }
        C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.WIFI_ONLY);
        m15055h();
    }
}
