package com.samsung.android.app.notes.sync.synchronization.controllers;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p101Z.InterfaceC0349a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6890a implements InterfaceC0349a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4435a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C6896g f4436b;

    public /* synthetic */ C6890a(C6896g c6896g, int i) {
        this.f4435a = i;
        this.f4436b = c6896g;
    }

    @Override // p101Z.InterfaceC0349a
    /* JADX INFO: renamed from: a */
    public final void mo672a() {
        switch (this.f4435a) {
            case 0:
                if (!((C6892c) this.f4436b).f4441p) {
                    Debugger.m8615i("ForegroundSyncServiceController", "cancel to unbindService()");
                    return;
                }
                synchronized (C6896g.f4448k) {
                    try {
                        C6892c c6892c = (C6892c) this.f4436b;
                        if (c6892c.f4457f || !c6892c.m5099h()) {
                            Debugger.m8615i("ForegroundSyncServiceController", "cancel to unbindService()");
                            return;
                        }
                        Debugger.m8615i("ForegroundSyncServiceController", "unbindService()");
                        C6892c c6892c2 = (C6892c) this.f4436b;
                        SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = c6892c2.f4452a;
                        if (syncOldServiceController$ServiceState != SyncOldServiceController$ServiceState.STOPPED) {
                            if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTING || syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTED) {
                                try {
                                    c6892c2.f4454c.unbindService(c6892c2.f4442q);
                                    ((C6892c) this.f4436b).f4452a = SyncOldServiceController$ServiceState.DISCONNECTING;
                                } catch (IllegalArgumentException e) {
                                    Debugger.m8609e("ForegroundSyncServiceController", "unbindService() : IllegalArgumentException = " + e);
                                    ((C6892c) this.f4436b).f4452a = SyncOldServiceController$ServiceState.STOPPED;
                                } catch (Exception e2) {
                                    Debugger.m8609e("ForegroundSyncServiceController", "unbindService() : Exception = " + e2);
                                }
                            } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.DISCONNECTING) {
                                Debugger.m8615i("ForegroundSyncServiceController", "unbindService() : disconnecting!");
                            }
                            break;
                        } else {
                            Debugger.m8615i("ForegroundSyncServiceController", "unbindService() : already stopped!");
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                if (!this.f4436b.f4459h) {
                    Debugger.m8615i("SyncOldServiceController", "cancel to unbindService()");
                    return;
                }
                synchronized (C6896g.f4448k) {
                    try {
                        C6896g c6896g = this.f4436b;
                        if (c6896g.f4457f || !c6896g.m5099h()) {
                            Debugger.m8615i("SyncOldServiceController", "cancel to unbindService()");
                            return;
                        }
                        Debugger.m8615i("SyncOldServiceController", "unbindService()");
                        C6896g c6896g2 = this.f4436b;
                        SyncOldServiceController$ServiceState syncOldServiceController$ServiceState2 = c6896g2.f4452a;
                        if (syncOldServiceController$ServiceState2 != SyncOldServiceController$ServiceState.STOPPED) {
                            if (syncOldServiceController$ServiceState2 == SyncOldServiceController$ServiceState.CONNECTING || syncOldServiceController$ServiceState2 == SyncOldServiceController$ServiceState.CONNECTED) {
                                try {
                                    try {
                                        c6896g2.f4454c.unbindService(c6896g2.f4460i);
                                        this.f4436b.f4452a = SyncOldServiceController$ServiceState.DISCONNECTING;
                                    } catch (IllegalArgumentException e3) {
                                        Debugger.m8609e("SyncOldServiceController", "unbindService() : IllegalArgumentException = " + e3);
                                        this.f4436b.f4452a = SyncOldServiceController$ServiceState.STOPPED;
                                    }
                                } catch (Exception e5) {
                                    Debugger.m8609e("SyncOldServiceController", "unbindService() : Exception = " + e5);
                                }
                            } else if (syncOldServiceController$ServiceState2 == SyncOldServiceController$ServiceState.DISCONNECTING) {
                                Debugger.m8615i("SyncOldServiceController", "unbindService() : disconnecting!");
                            }
                            break;
                        } else {
                            Debugger.m8615i("SyncOldServiceController", "unbindService() : already stopped!");
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
        }
    }

    @Override // p101Z.InterfaceC0349a
    public final void onDestroy() {
        switch (this.f4435a) {
            case 0:
                Debugger.m8615i("ForegroundSyncServiceController", "onDestroy()");
                ((C6892c) this.f4436b).m5098g();
                break;
            default:
                Debugger.m8615i("SyncOldServiceController", "onDestroy()");
                this.f4436b.m5098g();
                break;
        }
    }
}
