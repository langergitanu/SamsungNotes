package com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import com.msc.p133sa.aidl.ISAService;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6883j;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.FutureC6876c;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import java.util.concurrent.CompletableFuture;
import p186h1.C12020a;
import p207n1.C13534a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6888c {

    /* JADX INFO: renamed from: h */
    public static C6888c f4427h;

    /* JADX INFO: renamed from: a */
    public C12020a f4428a;

    /* JADX INFO: renamed from: b */
    public final C6887b f4429b;

    /* JADX INFO: renamed from: c */
    public final C6887b f4430c;

    /* JADX INFO: renamed from: d */
    public final C6886a f4431d;

    /* JADX INFO: renamed from: e */
    public AbstractC6884k f4432e;

    /* JADX INFO: renamed from: f */
    public ISAService f4433f = null;

    /* JADX INFO: renamed from: g */
    public final ServiceConnection f4434g = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.SAccountService$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Debugger.m8615i("SAccountService", "[SA] onServiceConnected()");
            C6888c c6888c = this.this$0;
            c6888c.m5087c(c6888c.f4431d);
            this.this$0.f4433f = ISAService.Stub.asInterface(iBinder);
            if (this.this$0.f4433f != null) {
                return;
            }
            Debugger.m8609e("SAccountService", "[SA] mISAContentBinder is null");
            C12020a c12020a = this.this$0.f4428a;
            if (c12020a != null) {
                C6880g c6880g = (C6880g) c12020a.f8772b;
                C6883j c6883j = c6880g.f4411d;
                if (c6883j != null) {
                    Debugger.m8609e("TaskAuthInfo", "[SAE-3] handleConnectedServiceWrongly()");
                    ((FutureC6876c) c6883j.f4420d).m5070a(new C13534a("201"));
                    c6883j.f4422a.f4432e.mo5083c();
                }
                C6883j c6883j2 = c6880g.f4412e;
                if (c6883j2 != null) {
                    Debugger.m8609e("TaskRequestRequiredConsent", "[SAE-3] handleConnectedServiceWrongly()");
                    ((CompletableFuture) c6883j2.f4420d).complete(new ResultConsentData("201"));
                    c6883j2.f4422a.f4432e.mo5083c();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Debugger.m8615i("SAccountService", "[SA] onServiceDisconnected()");
            C6888c c6888c = this.this$0;
            c6888c.m5087c(c6888c.f4429b);
            C6888c c6888c2 = this.this$0;
            c6888c2.f4433f = null;
            C12020a c12020a = c6888c2.f4428a;
            if (c12020a != null) {
                C6880g c6880g = (C6880g) c12020a.f8772b;
                C6883j c6883j = c6880g.f4411d;
                if (c6883j != null) {
                    Debugger.m8609e("TaskAuthInfo", "[SAE-3] handleDisconnectedService()");
                    ((FutureC6876c) c6883j.f4420d).m5070a(new C13534a("202"));
                }
                C6883j c6883j2 = c6880g.f4412e;
                if (c6883j2 != null) {
                    Debugger.m8609e("TaskRequestRequiredConsent", "[SAE-3] handleDisconnectedService()");
                    ((CompletableFuture) c6883j2.f4420d).complete(new ResultConsentData("202"));
                }
            }
        }
    };

    public C6888c() {
        C6887b c6887b = new C6887b(this, 1);
        this.f4429b = c6887b;
        this.f4430c = new C6887b(this, 0);
        this.f4431d = new C6886a(this);
        this.f4432e = c6887b;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C6888c m5085a() {
        try {
            if (f4427h == null) {
                f4427h = new C6888c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4427h;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m5086b() {
        AbstractC6884k abstractC6884k = this.f4432e;
        if (abstractC6884k instanceof C6886a) {
            return true;
        }
        Debugger.m8615i("SAccountService", "[SA] isConnected() : false <- ".concat(abstractC6884k.toString()));
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final void m5087c(AbstractC6884k abstractC6884k) {
        SystemClock.elapsedRealtime();
        abstractC6884k.getClass();
        this.f4432e = abstractC6884k;
        Debugger.m8615i("SAccountService", "[SA] setCurrentState() : " + this.f4432e);
    }
}
