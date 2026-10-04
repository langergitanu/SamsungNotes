package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6704d extends AbstractC6703c {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4023b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C6704d(AbstractC6714n abstractC6714n, int i) {
        super(abstractC6714n);
        this.f4023b = i;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: a */
    public final String mo4787a() {
        switch (this.f4023b) {
            case 0:
                return ((AbstractC6714n) this.f4022a).mo4794a().concat("$DisConnectedBySocialState");
            default:
                return ((AbstractC6714n) this.f4022a).mo4794a().concat("$DisconnectedPartiallyState");
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: b */
    public final void mo4788b(SeMobileServiceSession seMobileServiceSession) {
        switch (this.f4023b) {
            case 0:
                synchronized (((AbstractC6714n) this.f4022a)) {
                    Debugger.m8615i(mo4787a(), "[CS0] connect() : call reconnect()");
                    AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
                    abstractC6714n.m4807p(abstractC6714n.f4043e);
                    seMobileServiceSession.reconnect();
                    break;
                }
                return;
            default:
                synchronized (((AbstractC6714n) this.f4022a)) {
                    Debugger.m8615i(mo4787a(), "[CS0] connect() : call reconnect()");
                    AbstractC6714n abstractC6714n2 = (AbstractC6714n) this.f4022a;
                    abstractC6714n2.m4807p(abstractC6714n2.f4043e);
                    seMobileServiceSession.reconnect();
                    break;
                }
                return;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: c */
    public final void mo4790c(SeMobileServiceSession seMobileServiceSession) {
        switch (this.f4023b) {
            case 0:
                synchronized (((AbstractC6714n) this.f4022a)) {
                    Debugger.m8615i(mo4787a(), "[CS0] call disconnect()");
                    AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
                    abstractC6714n.m4807p(abstractC6714n.f4044f);
                    seMobileServiceSession.disconnect();
                    break;
                }
                return;
            default:
                synchronized (((AbstractC6714n) this.f4022a)) {
                    Debugger.m8615i(mo4787a(), "[CS0] call disconnect()");
                    AbstractC6714n abstractC6714n2 = (AbstractC6714n) this.f4022a;
                    abstractC6714n2.m4807p(abstractC6714n2.f4044f);
                    seMobileServiceSession.disconnect();
                    break;
                }
                return;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: e */
    public void mo4789e(SeMobileServiceSession seMobileServiceSession) {
        switch (this.f4023b) {
            case 1:
                synchronized (((AbstractC6714n) this.f4022a)) {
                    Debugger.m8615i(mo4787a(), "[CS0] reconnect() : call reconnect()");
                    AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
                    abstractC6714n.m4807p(abstractC6714n.f4043e);
                    seMobileServiceSession.reconnect();
                    break;
                }
                return;
            default:
                super.mo4789e(seMobileServiceSession);
                return;
        }
    }

    public final String toString() {
        switch (this.f4023b) {
            case 0:
                return "DisConnectedBySocialState";
            default:
                return "DisconnectedPartiallyState";
        }
    }
}
