package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import java.util.ArrayList;
import java.util.Iterator;
import p012C1.RunnableC0045a;
import p207n1.RunnableC13536c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6879f implements ConsentDataListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4406a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4407b;

    public /* synthetic */ C6879f(Object obj, int i) {
        this.f4406a = i;
        this.f4407b = obj;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener
    public final void onError(String str, String str2) {
        switch (this.f4406a) {
            case 0:
                C6880g c6880g = (C6880g) this.f4407b;
                c6880g.f4414g = false;
                c6880g.f4412e = null;
                C6879f c6879f = c6880g.f4410c;
                if (c6879f != null) {
                    c6879f.onError(str, str2);
                    c6880g.f4410c = null;
                }
                c6880g.m5077c();
                return;
            default:
                C6906i c6906i = (C6906i) this.f4407b;
                synchronized (((ArrayList) c6906i.f4483b)) {
                    try {
                        if (((ArrayList) c6906i.f4483b).size() > 0) {
                            Iterator it = ((ArrayList) c6906i.f4483b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC13536c((ConsentDataListener) it.next(), str, 1, str2));
                            }
                        }
                        ((ArrayList) c6906i.f4483b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener
    public final void onReceived(ResultConsentData resultConsentData) {
        switch (this.f4406a) {
            case 0:
                C6880g c6880g = (C6880g) this.f4407b;
                c6880g.f4414g = false;
                c6880g.f4412e = null;
                C6879f c6879f = c6880g.f4410c;
                if (c6879f != null) {
                    c6879f.onReceived(resultConsentData);
                    c6880g.f4410c = null;
                }
                c6880g.m5077c();
                return;
            default:
                C6906i c6906i = (C6906i) this.f4407b;
                synchronized (((ArrayList) c6906i.f4483b)) {
                    try {
                        if (((ArrayList) c6906i.f4483b).size() > 0) {
                            Iterator it = ((ArrayList) c6906i.f4483b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0045a(11, (ConsentDataListener) it.next(), false, resultConsentData));
                            }
                        }
                        ((ArrayList) c6906i.f4483b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
