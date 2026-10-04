package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import java.util.ArrayList;
import java.util.Iterator;
import p033H0.C0112b;
import p207n1.RunnableC13538e;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6878e implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4404a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4405b;

    public /* synthetic */ C6878e(Object obj, int i) {
        this.f4404a = i;
        this.f4405b = obj;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        switch (this.f4404a) {
            case 0:
                C6880g c6880g = (C6880g) this.f4405b;
                c6880g.f4413f = false;
                c6880g.f4411d = null;
                C6878e c6878e = c6880g.f4409b;
                if (c6878e != null) {
                    c6878e.onError(str, str2);
                    c6880g.f4409b = null;
                }
                c6880g.m5077c();
                return;
            default:
                C0112b c0112b = (C0112b) this.f4405b;
                synchronized (((ArrayList) c0112b.f362a)) {
                    try {
                        if (((ArrayList) c0112b.f362a).size() > 0) {
                            Iterator it = ((ArrayList) c0112b.f362a).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC13538e(str, str2, (IAuthInfoReqListener) it.next()));
                            }
                        }
                        ((ArrayList) c0112b.f362a).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        switch (this.f4404a) {
            case 0:
                C6880g c6880g = (C6880g) this.f4405b;
                c6880g.f4413f = false;
                c6880g.f4411d = null;
                C6878e c6878e = c6880g.f4409b;
                if (c6878e != null) {
                    c6878e.onReceived(str, str2);
                    c6880g.f4409b = null;
                }
                c6880g.m5077c();
                return;
            default:
                C0112b c0112b = (C0112b) this.f4405b;
                synchronized (((ArrayList) c0112b.f362a)) {
                    try {
                        if (((ArrayList) c0112b.f362a).size() > 0) {
                            Iterator it = ((ArrayList) c0112b.f362a).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC13538e((IAuthInfoReqListener) it.next(), str, str2));
                            }
                        }
                        ((ArrayList) c0112b.f362a).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
