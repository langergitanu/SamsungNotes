package p243u0;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.RunnableC9675B;
import java.util.ArrayList;
import p011C0.InterfaceC0044a;

/* JADX INFO: renamed from: u0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14476f extends AbstractC14471a {

    /* JADX INFO: renamed from: c */
    public ArrayList f10279c;

    /* JADX INFO: renamed from: d */
    public int f10280d;

    /* JADX INFO: renamed from: e */
    public RunnableC9675B f10281e;

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: f */
    public final void mo15053f() {
        m15064j();
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: g */
    public final void mo15054g() {
        m15064j();
    }

    /* JADX INFO: renamed from: j */
    public final void m15064j() {
        Debugger.m8609e("SyncErrorSyncServerBlocking", "Fail to sync due to server blocking!");
        if (!this.f10279c.isEmpty()) {
            for (InterfaceC0044a interfaceC0044a : this.f10279c) {
                if ((this.f10280d & 512) == 512) {
                    interfaceC0044a.onUpdate(false, true);
                } else {
                    interfaceC0044a.onUpdate(false, false);
                }
            }
        }
        RunnableC9675B runnableC9675B = this.f10281e;
        if (runnableC9675B != null) {
            runnableC9675B.run();
        }
        m15056i();
        m15055h();
    }
}
