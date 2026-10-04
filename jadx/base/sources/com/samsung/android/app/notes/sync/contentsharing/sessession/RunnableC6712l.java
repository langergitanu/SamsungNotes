package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;
import p211o0.InterfaceC13568b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6712l implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4032a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4033b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4034c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4035d;

    public RunnableC6712l(int i, String str, InterfaceC13568b interfaceC13568b) {
        this.f4033b = i;
        this.f4034c = str;
        this.f4035d = interfaceC13568b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4032a) {
            case 0:
                try {
                    ((C6708h) this.f4034c).f4027c.onDisConnected(this.f4033b);
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("[CS0-2] Exception : "), ((AbstractC6714n) this.f4035d).mo4794a());
                    return;
                }
                break;
            default:
                StringBuilder sb = new StringBuilder("[EDP] notifyErrorToStateListeners() : , errCode = ");
                int i = this.f4033b;
                sb.append(i);
                sb.append(", errMsg = ");
                String str = (String) this.f4034c;
                sb.append(str);
                Debugger.m8615i("EdpInfoManager", sb.toString());
                ((InterfaceC13568b) this.f4035d).mo4726a(i, str);
                break;
        }
    }

    public RunnableC6712l(AbstractC6714n abstractC6714n, C6708h c6708h, int i) {
        this.f4035d = abstractC6714n;
        this.f4034c = c6708h;
        this.f4033b = i;
    }
}
