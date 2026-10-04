package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.C6888c;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p010C.RunnableC0037b;
import p012C1.RunnableC0045a;
import p207n1.C13534a;
import p207n1.C13537d;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6880g {

    /* JADX INFO: renamed from: a */
    public C6888c f4408a;

    /* JADX INFO: renamed from: b */
    public C6878e f4409b;

    /* JADX INFO: renamed from: c */
    public C6879f f4410c;

    /* JADX INFO: renamed from: d */
    public C6883j f4411d;

    /* JADX INFO: renamed from: e */
    public C6883j f4412e;

    /* JADX INFO: renamed from: f */
    public boolean f4413f;

    /* JADX INFO: renamed from: g */
    public boolean f4414g;

    /* JADX INFO: renamed from: a */
    public final void m5075a() {
        if (this.f4409b == null) {
            Debugger.m8609e("SamsungAccountClientManager", "[SA] cancelAuthInfo() : authInfoListener is null!");
            return;
        }
        this.f4409b = null;
        this.f4413f = false;
        C6883j c6883j = this.f4411d;
        c6883j.f4419c = null;
        ((FutureC6876c) c6883j.f4420d).m5070a(null);
        C6875b.m5062c().m5063a((C6882i) c6883j.f4421e);
        this.f4411d = null;
        m5077c();
    }

    /* JADX INFO: renamed from: b */
    public final void m5076b() {
        if (this.f4410c == null) {
            Debugger.m8609e("SamsungAccountClientManager", "[SA] cancelConsentInfo() : consentInfoListener is null!");
            return;
        }
        this.f4410c = null;
        this.f4414g = false;
        C6883j c6883j = this.f4412e;
        c6883j.f4419c = null;
        ((CompletableFuture) c6883j.f4420d).complete(null);
        C6875b.m5062c().m5063a((C6885l) c6883j.f4421e);
        c6883j.f4421e = null;
        C6877d c6877dM5071a = C6877d.m5071a();
        c6877dM5071a.getClass();
        Debugger.m8615i("RequestRequiredConsentApi", "cancel()");
        c6877dM5071a.f4399c = null;
        c6877dM5071a.m5074d();
        this.f4412e = null;
        m5077c();
    }

    /* JADX INFO: renamed from: c */
    public final void m5077c() {
        if (this.f4413f) {
            Debugger.m8615i("SamsungAccountClientManager", "[SA] onPostExecute() : isRequestingAuthInfo is true!");
        } else if (this.f4414g) {
            Debugger.m8615i("SamsungAccountClientManager", "[SA] onPostExecute() : isRequestingRequiredConsent is true!");
        } else {
            this.f4408a.f4432e.mo5083c();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m5078d(C6878e c6878e) {
        this.f4409b = c6878e;
        if (this.f4413f) {
            Debugger.m8609e("SamsungAccountClientManager", "[SA] requestAuthInfo() : isRequestingAuthInfo is true!");
            return;
        }
        this.f4413f = true;
        C6878e c6878e2 = new C6878e(this, 0);
        final C6883j c6883j = new C6883j();
        c6883j.f4420d = new FutureC6876c();
        c6883j.f4419c = c6878e2;
        c6883j.f4418b = 30;
        this.f4411d = c6883j;
        Debugger.m8615i("TaskAuthInfo", "[SA] run()");
        final int i = 0;
        new SenlThreadFactory("TaskAuthInfoThread").newThread(new Runnable() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.h
            @Override // java.lang.Runnable
            public final void run() {
                C13534a c13534a;
                switch (i) {
                    case 0:
                        C6883j c6883j2 = c6883j;
                        Debugger.m8615i("TaskAuthInfo", "[SA] run() : start TaskAuthInfoThread");
                        try {
                            c13534a = (C13534a) ((FutureC6876c) c6883j2.f4420d).f4395a.get(c6883j2.f4418b, TimeUnit.SECONDS);
                        } catch (Exception e) {
                            AbstractC0000a.m22s("[SA] run() : fail to waitForAuthInfo.get(), ", e, "TaskAuthInfo");
                            c13534a = null;
                        }
                        C6878e c6878e3 = (C6878e) c6883j2.f4419c;
                        if (c6878e3 != null) {
                            if (c13534a != null) {
                                String str = c13534a.f9559d;
                                if (!c13534a.f9558c) {
                                    c6878e3.onReceived(c13534a.f9556a, c13534a.f9557b);
                                } else {
                                    Debugger.m8609e("TaskAuthInfo", "[SAE-5] run() : fail to get authInfo, errorCode = " + str);
                                    ((C6878e) c6883j2.f4419c).onError(str, c13534a.f9560e);
                                }
                            } else {
                                Debugger.m8609e("TaskAuthInfo", "[SAE-4] run() : FAIL_AUTH_INFO_TIMED_OUT");
                                ((C6878e) c6883j2.f4419c).onError("302", "FAIL_AUTH_INFO_TIMED_OUT");
                            }
                        }
                        break;
                    default:
                        C6883j c6883j3 = c6883j;
                        final FutureC6876c futureC6876c = (FutureC6876c) c6883j3.f4420d;
                        Debugger.m8615i("TaskAuthInfo", "[SA] run() : start AuthApiThread");
                        try {
                            c6883j3.m5084d();
                            Objects.requireNonNull(futureC6876c);
                            c6883j3.f4421e = new InterfaceC6874a() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.i
                                @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.InterfaceC6874a
                                /* JADX INFO: renamed from: a */
                                public final void mo5061a(C13534a c13534a2) {
                                    futureC6876c.m5070a(c13534a2);
                                }
                            };
                            C6875b.m5062c().m5066e((C6882i) c6883j3.f4421e);
                        } catch (Exception e2) {
                            if (!(e2 instanceof SAccountException)) {
                                futureC6876c.m5070a(new C13534a("900"));
                            }
                            SAccountException sAccountException = (SAccountException) e2;
                            String exceptionCode = sAccountException.getExceptionCode();
                            String message = sAccountException.getMessage();
                            Debugger.m8609e("TaskAuthInfo", "[SA] handleException() : exceptionCode = " + exceptionCode + ", exceptionMsg = " + message);
                            C13534a c13534a2 = new C13534a(exceptionCode);
                            c13534a2.f9560e = message;
                            futureC6876c.m5070a(c13534a2);
                            return;
                        }
                        break;
                }
            }
        }).start();
        final int i2 = 1;
        new SenlThreadFactory("AuthApiThread").newThread(new Runnable() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.h
            @Override // java.lang.Runnable
            public final void run() {
                C13534a c13534a;
                switch (i2) {
                    case 0:
                        C6883j c6883j2 = c6883j;
                        Debugger.m8615i("TaskAuthInfo", "[SA] run() : start TaskAuthInfoThread");
                        try {
                            c13534a = (C13534a) ((FutureC6876c) c6883j2.f4420d).f4395a.get(c6883j2.f4418b, TimeUnit.SECONDS);
                        } catch (Exception e) {
                            AbstractC0000a.m22s("[SA] run() : fail to waitForAuthInfo.get(), ", e, "TaskAuthInfo");
                            c13534a = null;
                        }
                        C6878e c6878e3 = (C6878e) c6883j2.f4419c;
                        if (c6878e3 != null) {
                            if (c13534a != null) {
                                String str = c13534a.f9559d;
                                if (!c13534a.f9558c) {
                                    c6878e3.onReceived(c13534a.f9556a, c13534a.f9557b);
                                } else {
                                    Debugger.m8609e("TaskAuthInfo", "[SAE-5] run() : fail to get authInfo, errorCode = " + str);
                                    ((C6878e) c6883j2.f4419c).onError(str, c13534a.f9560e);
                                }
                            } else {
                                Debugger.m8609e("TaskAuthInfo", "[SAE-4] run() : FAIL_AUTH_INFO_TIMED_OUT");
                                ((C6878e) c6883j2.f4419c).onError("302", "FAIL_AUTH_INFO_TIMED_OUT");
                            }
                        }
                        break;
                    default:
                        C6883j c6883j3 = c6883j;
                        final FutureC6876c futureC6876c = (FutureC6876c) c6883j3.f4420d;
                        Debugger.m8615i("TaskAuthInfo", "[SA] run() : start AuthApiThread");
                        try {
                            c6883j3.m5084d();
                            Objects.requireNonNull(futureC6876c);
                            c6883j3.f4421e = new InterfaceC6874a() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.i
                                @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.InterfaceC6874a
                                /* JADX INFO: renamed from: a */
                                public final void mo5061a(C13534a c13534a2) {
                                    futureC6876c.m5070a(c13534a2);
                                }
                            };
                            C6875b.m5062c().m5066e((C6882i) c6883j3.f4421e);
                        } catch (Exception e2) {
                            if (!(e2 instanceof SAccountException)) {
                                futureC6876c.m5070a(new C13534a("900"));
                            }
                            SAccountException sAccountException = (SAccountException) e2;
                            String exceptionCode = sAccountException.getExceptionCode();
                            String message = sAccountException.getMessage();
                            Debugger.m8609e("TaskAuthInfo", "[SA] handleException() : exceptionCode = " + exceptionCode + ", exceptionMsg = " + message);
                            C13534a c13534a2 = new C13534a(exceptionCode);
                            c13534a2.f9560e = message;
                            futureC6876c.m5070a(c13534a2);
                            return;
                        }
                        break;
                }
            }
        }).start();
    }

    /* JADX INFO: renamed from: e */
    public final void m5079e(C6879f c6879f) {
        this.f4410c = c6879f;
        if (this.f4414g) {
            Debugger.m8609e("SamsungAccountClientManager", "[SA] requestRequiredConsent() : isRequestingRequiredConsent is true!");
            return;
        }
        this.f4414g = true;
        C6879f c6879f2 = new C6879f(this, 0);
        C6883j c6883j = new C6883j();
        c6883j.f4420d = new CompletableFuture();
        c6883j.f4419c = c6879f2;
        c6883j.f4418b = 30;
        this.f4412e = c6883j;
        C13537d c13537d = new C13537d();
        Debugger.m8607d("TaskRequestRequiredConsent", "run()");
        new SenlThreadFactory("TaskRequestRequiredConsentThread").newThread(new RunnableC0037b(c6883j, 5)).start();
        new SenlThreadFactory("RequestRequiredConsentApiThread").newThread(new RunnableC0045a(c6883j, c13537d, 8)).start();
    }
}
