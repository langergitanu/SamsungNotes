package com.samsung.android.app.notes.sync.synchronization.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.synchronization.services.ForegroundSyncService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p026F1.AbstractC0100d;
import p026F1.C0099c;
import p038I1.C0137m;
import p042J1.C0145c;
import p086V.C0322h;
import p249v1.C14499b;
import p249v1.C14500c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6892c extends C6896g {

    /* JADX INFO: renamed from: o */
    public ForegroundSyncService f4440o;

    /* JADX INFO: renamed from: p */
    public boolean f4441p;

    /* JADX INFO: renamed from: q */
    public final ServiceConnection f4442q;

    /* JADX INFO: renamed from: r */
    public final C6890a f4443r;

    public C6892c(Context context) {
        super(context);
        this.f4441p = true;
        this.f4442q = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.synchronization.controllers.ForegroundSyncServiceController$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Debugger.m8615i("ForegroundSyncServiceController", "onServiceConnected() start");
                synchronized (C6896g.f4448k) {
                    C6892c c6892c = this.this$0;
                    c6892c.f4457f = true;
                    try {
                        c6892c.f4440o = ((ForegroundSyncService.LocalBinder) iBinder).getService();
                        this.this$0.f4452a = SyncOldServiceController$ServiceState.CONNECTED;
                        while (this.this$0.f4456e.peek() != null) {
                            ((C6891b) this.this$0.f4456e.poll()).m5088a(this.this$0.f4440o);
                            C6892c c6892c2 = this.this$0;
                            if (!c6892c2.f4453b) {
                                c6892c2.f4453b = true;
                            }
                        }
                    } catch (Exception e) {
                        Debugger.m8609e("ForegroundSyncServiceController", "onServiceConnected() : Exception = " + e.toString());
                    }
                    this.this$0.f4457f = false;
                }
                Debugger.m8607d("ForegroundSyncServiceController", "onServiceConnected() finish");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Debugger.m8615i("ForegroundSyncServiceController", "onServiceDisconnected()");
                this.this$0.m5098g();
            }
        };
        this.f4443r = new C6890a(this, 0);
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.C6896g, com.samsung.android.app.notes.sync.synchronization.controllers.InterfaceC6893d
    /* JADX INFO: renamed from: a */
    public final void mo5089a(int i) {
        Debugger.m8615i("ForegroundSyncServiceController", "stopSync() : " + i);
        Debugger.m8615i("ForegroundSyncServiceController", "executeAfterServiceReady() : " + this.f4452a);
        synchronized (C6896g.f4448k) {
            try {
                SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = this.f4452a;
                if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.STOPPED) {
                    Debugger.m8615i("ForegroundSyncServiceController", "already stopped!");
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTING) {
                    this.f4456e.clear();
                    this.f4454c.unbindService(this.f4442q);
                    this.f4452a = SyncOldServiceController$ServiceState.DISCONNECTING;
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTED || syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.DISCONNECTING) {
                    this.f4440o.stopSync(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.C6896g, com.samsung.android.app.notes.sync.synchronization.controllers.InterfaceC6893d
    /* JADX INFO: renamed from: b */
    public final void mo5090b(boolean z, boolean z2) {
        Context context = this.f4454c;
        if (!z) {
            Debugger.m8615i("ForegroundSyncServiceController", "set sync disabled by settings");
            C0145c.m311S(context, Boolean.valueOf(z));
            C0322h.m670a().f818d.cancelAllSyncNotification();
            C0137m.m280d().m287h();
            return;
        }
        Debugger.m8615i("ForegroundSyncServiceController", "set sync enabled by settings : " + z2);
        C0145c.m311S(context, Boolean.valueOf(z));
        C0145c.m304L("pref_sync_logging", "pref_sync_number_of_deleted_notes_reported", true);
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.C6896g
    /* JADX INFO: renamed from: c */
    public final void mo5091c() {
        Debugger.m8607d("ForegroundSyncServiceController", "connectingSyncService()");
        ForegroundSyncService.setServiceContract(this.f4443r);
        Context context = this.f4454c;
        context.bindService(new Intent(context, (Class<?>) ForegroundSyncService.class), this.f4442q, 1);
        this.f4452a = SyncOldServiceController$ServiceState.CONNECTING;
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.C6896g
    /* JADX INFO: renamed from: i */
    public final void mo5092i(C0099c c0099c) {
        C14500c c14500c = C14499b.f10311e;
        int i = c0099c.f322a;
        if (i == 1024) {
            int iM241c = AbstractC0100d.m241c();
            if (iM241c == 0) {
                m5093n(new C6891b(this, c0099c, 0));
                return;
            } else {
                AbstractC14517a.m15163w(iM241c, c0099c.f322a).mo4791d();
                return;
            }
        }
        int iM242d = AbstractC0100d.m242d(i);
        if (iM242d == 0) {
            m5093n(new C6891b(this, c0099c, 1));
        } else {
            AbstractC14517a.m15163w(iM242d, c0099c.f322a).mo4791d();
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m5093n(C6891b c6891b) {
        Debugger.m8615i("ForegroundSyncServiceController", "serviceState = " + this.f4452a);
        synchronized (C6896g.f4448k) {
            try {
                this.f4457f = true;
                SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = this.f4452a;
                if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.STOPPED) {
                    this.f4456e.offer(c6891b);
                    mo5091c();
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTING) {
                    this.f4456e.offer(c6891b);
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTED) {
                    c6891b.m5088a(this.f4440o);
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.DISCONNECTING) {
                    this.f4456e.offer(c6891b);
                }
                this.f4457f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
