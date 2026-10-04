package com.samsung.android.app.notes.sync;

import android.content.Context;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import p038I1.C0137m;
import p044K.C0158a;
import p052M.C0171a;
import p079T.C0283a;
import p086V.C0322h;
import p186h1.C12028i;
import p195k1.C12969a;
import p244u1.C14477a;
import p248v0.C14497a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6664c implements IAccountLoginListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6751f f3944a;

    public C6664c(C6751f c6751f) {
        this.f3944a = c6751f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener
    public final void onFailed(String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener
    public final void onLoginInfoReceived(boolean z) {
        C6751f c6751f = this.f3944a;
        if (z) {
            c6751f.m4892c();
            return;
        }
        Context context = c6751f.f4139a;
        Debugger.m8614f("GeneralManager", "signedOutAction()");
        if (DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
            C0322h.m670a().f818d.cancelAllSyncNotification();
            C0137m.m280d().m287h();
            C14477a.m15065b().m15076l(109);
        }
        C14497a c14497aM15078a = C14497a.m15078a();
        c14497aM15078a.getClass();
        C0158a.m407a().getClass();
        if (C0158a.m411g()) {
            c14497aM15078a.f10310a.m4894a(new C12028i(), true);
        } else {
            Debugger.m8615i("ImportManager", "stopImportForce : not supported!)");
        }
        C0171a.m429a().f543a.m4777a(new C0283a());
        C12969a.m13872b(context).m13882k();
        SCloudPamHelper.signOut(context);
    }
}
