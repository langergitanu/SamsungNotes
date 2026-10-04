package com.samsung.android.app.notes.sync;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.contentsharing.sessession.RunnableC6712l;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import p010C.RunnableC0037b;
import p012C1.RunnableC0045a;
import p211o0.C13567a;
import p211o0.C13569c;
import p211o0.C13572f;
import p211o0.InterfaceC13568b;
import p244u1.C14477a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6662a implements InterfaceC13568b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3941a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3942b;

    public /* synthetic */ C6662a(Object obj, int i) {
        this.f3941a = i;
        this.f3942b = obj;
    }

    @Override // p211o0.InterfaceC13568b
    /* JADX INFO: renamed from: a */
    public final void mo4726a(int i, String str) {
        switch (this.f3941a) {
            case 0:
                Debugger.m8609e("GeneralManager", "[EDP] onError() : fail to initEdpState, " + str);
                return;
            case 1:
                Debugger.m8609e("GeneralManager", "[EDP] onError() : fail to initEdpState, " + str);
                return;
            default:
                C6742k c6742k = (C6742k) this.f3942b;
                synchronized (((ArrayList) c6742k.f4110b)) {
                    try {
                        if (((ArrayList) c6742k.f4110b).size() > 0) {
                            Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC6712l(i, str, (InterfaceC13568b) it.next()));
                            }
                        }
                        ((ArrayList) c6742k.f4110b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    @Override // p211o0.InterfaceC13568b
    /* JADX INFO: renamed from: b */
    public final void mo4727b(C13572f c13572f) {
        switch (this.f3941a) {
            case 0:
                Debugger.m8615i("GeneralManager", "[EDP] initEdpState(), onReceived() : state = " + c13572f.f9629b);
                C13567a.m14371a().m14374e(c13572f.f9629b);
                if (UserManagerCompat.getInstance().isDigitalLegacyMode(((C6751f) this.f3942b).f4139a)) {
                    return;
                }
                C13569c c13569cM14375c = C13569c.m14375c();
                c13569cM14375c.getClass();
                Debugger.m8615i("KmxSdkManager", "[EDP] reInitialize()");
                KmxSdk.initialize(c13569cM14375c.f9618a, c13569cM14375c.f9621d);
                return;
            case 1:
                Debugger.m8615i("GeneralManager", "[EDP] checkPermissionAndAutoSync(), onReceived() : state = " + c13572f.f9629b);
                C13567a.m14371a().m14374e(c13572f.f9629b);
                if (UserManagerCompat.getInstance().isDigitalLegacyMode(((C6751f) ((RunnableC0037b) this.f3942b).f177b).f4139a)) {
                    return;
                }
                C14477a.m15065b().m15071g("after signed in!");
                return;
            default:
                C6742k c6742k = (C6742k) this.f3942b;
                synchronized (((ArrayList) c6742k.f4110b)) {
                    try {
                        if (((ArrayList) c6742k.f4110b).size() > 0) {
                            Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0045a(12, (InterfaceC13568b) it.next(), false, c13572f));
                            }
                        }
                        ((ArrayList) c6742k.f4110b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
