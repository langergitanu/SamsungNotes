package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6711k implements SeMobileServiceSession.OnAgentUpdatedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC6714n f4031a;

    public C6711k(AbstractC6714n abstractC6714n) {
        this.f4031a = abstractC6714n;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession.OnAgentUpdatedListener
    public final void onAgentUpdated() {
        AbstractC6714n abstractC6714n = this.f4031a;
        Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0] onAgentUpdated() : ".concat(abstractC6714n.f4048j.toString()));
        AbstractC6703c abstractC6703c = abstractC6714n.f4048j;
        if (!(abstractC6703c instanceof C6701a) && !(abstractC6703c instanceof C6702b) && !(abstractC6703c instanceof C6707g)) {
            Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0] onAgentUpdated() : Do nothing?");
        } else {
            abstractC6714n.f4049k.disconnect();
            abstractC6714n.f4049k.connect();
        }
    }
}
