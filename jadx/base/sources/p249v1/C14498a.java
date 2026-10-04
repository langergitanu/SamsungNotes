package p249v1;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p211o0.C13567a;
import p211o0.C13572f;
import p211o0.InterfaceC13568b;

/* JADX INFO: renamed from: v1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14498a implements InterfaceC13568b {
    @Override // p211o0.InterfaceC13568b
    /* JADX INFO: renamed from: a */
    public final void mo4726a(int i, String str) {
        Debugger.m8609e("SyncLogic", "[EDP] onError() : fail to initEdpState, " + str);
    }

    @Override // p211o0.InterfaceC13568b
    /* JADX INFO: renamed from: b */
    public final void mo4727b(C13572f c13572f) {
        Debugger.m8615i("SyncLogic", "[EDP] onReceived() : state = " + c13572f.f9629b);
        C13567a.m14371a().m14374e(c13572f.f9629b);
    }
}
