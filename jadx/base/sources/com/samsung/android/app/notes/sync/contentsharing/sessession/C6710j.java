package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6710j implements SeMobileServiceSession.ServiceConnectionListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC6714n f4030a;

    public C6710j(AbstractC6714n abstractC6714n) {
        this.f4030a = abstractC6714n;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession.ServiceConnectionListener
    public final void onChanged(int i, String str) {
        AbstractC6714n abstractC6714n = this.f4030a;
        if (i == -1) {
            String strMo4794a = abstractC6714n.mo4794a();
            StringBuilder sbM15l = AbstractC0000a.m15l("[CS0] onChanged() : MobileService is disconnected and reconnected with ", str, " from the previous ");
            sbM15l.append(abstractC6714n.f4048j.toString());
            Debugger.m8612ef(strMo4794a, sbM15l.toString());
            abstractC6714n.m4807p(abstractC6714n.f4045g);
            abstractC6714n.f4048j.mo4789e(abstractC6714n.f4049k);
            return;
        }
        if (i != 1) {
            Debugger.m8609e(abstractC6714n.mo4794a(), "[CS0] onChanged() : invalid status " + i + " with " + str);
            return;
        }
        Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0] onChanged() : MobileService is connected with " + str);
        AbstractC6703c abstractC6703c = abstractC6714n.f4048j;
        if ((abstractC6703c instanceof C6701a) || (abstractC6703c instanceof C6706f)) {
            return;
        }
        Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0] onChanged() : mConnectionState is connected again from the previous ".concat(abstractC6714n.f4048j.toString()));
        abstractC6714n.m4807p(abstractC6714n.f4041c);
    }
}
