package com.samsung.android.app.notes.sync.synchronization.managers;

import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import p007B0.C0026i;
import p022E1.C0077c;
import p042J1.C0145c;
import p086V.C0322h;
import p207n1.C13535b;
import p207n1.C13541h;
import p212o1.C13575c;
import p212o1.RunnableC13574b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6904g {

    /* JADX INFO: renamed from: c */
    public static C6904g f4477c;

    /* JADX INFO: renamed from: a */
    public boolean f4478a;

    /* JADX INFO: renamed from: b */
    public Object f4479b;

    /* JADX INFO: renamed from: a */
    public static synchronized C6904g m5132a() {
        try {
            if (f4477c == null) {
                C6904g c6904g = new C6904g();
                c6904g.f4478a = false;
                c6904g.f4479b = new Timer();
                f4477c = c6904g;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4477c;
    }

    /* JADX INFO: renamed from: b */
    public static void m5133b(SyncException syncException) throws SyncException {
        if (syncException.getExceptionCode() == 327) {
            Debugger.m8610e("SyncSettings", "handleSyncError: ", syncException);
            return;
        }
        if (syncException.getExceptionCode() == 326) {
            Debugger.m8610e("SyncSettings", "handleSyncError: ", syncException);
            return;
        }
        if (syncException.getExceptionCode() != 315) {
            throw syncException;
        }
        if (syncException.getStatusCode() != 400 && syncException.getStatusCode() != 405) {
            throw syncException;
        }
        Debugger.m8609e("SyncSettings", "Ignore Server error, statusCode = " + syncException.getStatusCode() + ", msg = " + syncException.getMessage());
    }

    /* JADX INFO: renamed from: c */
    public void m5134c(C13535b c13535b) {
        this.f4479b = c13535b;
        if (this.f4478a) {
            Debugger.m8609e("SamsungAccountServerManager", "[SA] requestAuthInfo() : isRequestingAuthInfo is true!");
            return;
        }
        this.f4478a = true;
        C13535b c13535b2 = new C13535b(this, 1);
        C13575c c13575c = new C13575c();
        c13575c.f9640c = new CompletableFuture();
        c13575c.f9638a = c13535b2;
        c13575c.f9639b = 30;
        Debugger.m8615i("TaskCountryPolicy", "[SA] run()");
        new SenlThreadFactory("TaskCountryPolicyThread").newThread(new RunnableC13574b(c13575c, 0)).start();
        new SenlThreadFactory("CountryPolicyThread").newThread(new RunnableC13574b(c13575c, 1)).start();
    }

    /* JADX INFO: renamed from: d */
    public void m5135d(C0026i c0026i, long j) throws SyncException {
        C0077c c0077c = (C0077c) this.f4479b;
        this.f4478a = false;
        try {
            C0322h.m670a().f826l.updateUserAuthInfo(c0077c.f262e, c0026i.f140a, c0026i.f141b);
            LockPrefUtils.setLocalPasswordOwnerGuid(c0077c.f262e, C13541h.m14287e().m14294h());
            C0145c.m308P(j, "serverPassword", "serverPasswordKey");
        } catch (Exception unused) {
            Debugger.m8609e("SyncSettings", "Failed to updateLocalPassword()");
            throw new SyncException(312, "Failed to updateLocalPassword()");
        }
    }
}
