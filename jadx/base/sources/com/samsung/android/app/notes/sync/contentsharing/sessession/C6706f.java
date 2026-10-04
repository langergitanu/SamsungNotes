package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6706f extends AbstractC6703c {

    /* JADX INFO: renamed from: b */
    public AbstractC6703c f4024b;

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: a */
    public final String mo4787a() {
        return ((AbstractC6714n) this.f4022a).mo4794a().concat("$PreDisConnectingState");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: b */
    public final void mo4788b(SeMobileServiceSession seMobileServiceSession) {
        synchronized (((AbstractC6714n) this.f4022a)) {
            Debugger.m8615i(mo4787a(), "[CS0-1] connect() : back to ".concat(this.f4024b.toString()));
            ((AbstractC6714n) this.f4022a).m4805n();
            ((AbstractC6714n) this.f4022a).m4807p(this.f4024b);
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: c */
    public final void mo4790c(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8609e(mo4787a(), "[CS0-1] disConnect() : already preDisconnecting");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: e */
    public final void mo4789e(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8609e(mo4787a(), "[CS0-2] reConnect() : back to ".concat(this.f4024b.toString()));
        AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
        abstractC6714n.m4805n();
        abstractC6714n.m4807p(this.f4024b);
    }

    public final String toString() {
        return "PreDisConnectingState";
    }
}
