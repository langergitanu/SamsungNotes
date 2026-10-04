package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6703c {

    /* JADX INFO: renamed from: a */
    public final Object f4022a;

    public AbstractC6703c(AbstractC6714n abstractC6714n) {
        this.f4022a = abstractC6714n;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo4787a();

    /* JADX INFO: renamed from: b */
    public void mo4788b(SeMobileServiceSession seMobileServiceSession) {
        synchronized (((AbstractC6714n) this.f4022a)) {
            Debugger.m8615i(mo4787a(), "[CS0] call connect()");
            AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
            abstractC6714n.m4807p(abstractC6714n.f4042d);
            seMobileServiceSession.connect();
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo4790c(SeMobileServiceSession seMobileServiceSession) {
        synchronized (((AbstractC6714n) this.f4022a)) {
            Debugger.m8615i(mo4787a(), "[CS0] call disconnect()");
            AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
            C6706f c6706f = abstractC6714n.f4047i;
            c6706f.f4024b = this;
            abstractC6714n.m4807p(c6706f);
            ((AbstractC6714n) this.f4022a).m4806o(false);
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo4791d();

    /* JADX INFO: renamed from: e */
    public void mo4789e(SeMobileServiceSession seMobileServiceSession) {
        synchronized (((AbstractC6714n) this.f4022a)) {
            Debugger.m8615i(mo4787a(), "[CS0] call reconnect()");
            AbstractC6714n abstractC6714n = (AbstractC6714n) this.f4022a;
            abstractC6714n.m4807p(abstractC6714n.f4043e);
            seMobileServiceSession.reconnect();
        }
    }

    public AbstractC6703c() {
        this.f4022a = C0322h.m670a().f815a.getAppContext();
    }
}
