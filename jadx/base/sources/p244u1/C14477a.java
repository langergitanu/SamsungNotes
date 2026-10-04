package p244u1;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.app.notes.sync.synchronization.controllers.C6892c;
import com.samsung.android.app.notes.sync.synchronization.controllers.C6896g;
import com.samsung.android.app.notes.sync.synchronization.managers.AbstractC6905h;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncProgressManager$SyncProgressStep;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p010C.C0042g;
import p011C0.InterfaceC0044a;
import p026F1.C0099c;
import p042J1.C0145c;
import p044K.AbstractC0159b;
import p044K.C0158a;
import p086V.C0322h;
import p207n1.C13541h;
import p239s1.C14464b;
import p239s1.C14465c;
import p249v1.C14499b;

/* JADX INFO: renamed from: u1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14477a {

    /* JADX INFO: renamed from: c */
    public static C14477a f10282c;

    /* JADX INFO: renamed from: a */
    public final C6896g f10283a;

    /* JADX INFO: renamed from: b */
    public long f10284b = 0;

    public C14477a() {
        if (UserManagerCompat.getInstance().isDigitalLegacyMode(C0322h.m670a().f815a.getAppContext())) {
            this.f10283a = new C6892c(C0322h.m670a().f815a.getAppContext());
        } else {
            this.f10283a = new C6896g(C0322h.m670a().f815a.getAppContext());
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized C14477a m15065b() {
        try {
            if (f10282c == null) {
                f10282c = new C14477a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10282c;
    }

    /* JADX INFO: renamed from: c */
    public static int m15066c() {
        int i = AbstractC6905h.f4480a[((SyncStateManager$SyncFailState) C6906i.m5136c().f4484c).ordinal()];
        if (i == 1) {
            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : WIFI_ONLY");
            return 103;
        }
        if (i == 2) {
            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : POWER_SAVING");
            return 126;
        }
        if (i == 3) {
            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : MASTER_SYNC");
            return 115;
        }
        if (i == 4) {
            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : PHONE_PERMISSION");
            return 102;
        }
        if (i != 5) {
            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : UNKNOWN");
            return 1;
        }
        Debugger.m8615i("SyncStateManager", "convertSyncFailStateForSync() : NETWORK");
        return 101;
    }

    /* JADX INFO: renamed from: f */
    public static void m15067f(String str, IServerNoteInfoListener iServerNoteInfoListener) {
        int i;
        C14465c c14465c = new C14465c();
        Debugger.m8615i("SyncServerNoteInfoHelper", "start requestNoteInfo()");
        if (SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
            Debugger.m8615i("SyncServerNoteInfoHelper", "checkValidRequestState() : National disaster net!");
            i = 109;
        } else if (C0145c.m334s(BaseUtils.getApplicationContext())) {
            i = 0;
        } else {
            Debugger.m8615i("SyncServerNoteInfoHelper", "checkValidRequestState() : Not available data network!");
            i = 101;
        }
        if (i != 0) {
            c14465c.m15052a(i);
            return;
        }
        c14465c.f10260a = iServerNoteInfoListener;
        C13541h.m14287e().m14295i(new C14464b(c14465c, BaseUtils.getApplicationContext(), str));
    }

    /* JADX INFO: renamed from: a */
    public final void m15068a(InterfaceC0044a interfaceC0044a) {
        this.f10283a.getClass();
        ArrayList arrayList = C14499b.f10314h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC0044a) it.next()).equals(interfaceC0044a)) {
                        return;
                    }
                }
                ArrayList arrayList2 = C14499b.f10314h;
                arrayList2.add(interfaceC0044a);
                Debugger.m8607d("SyncLogic", "Added SyncEnableMode listener - size : " + arrayList2.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m15069d(boolean z, boolean z2) {
        Debugger.m8615i("SyncManager", "Network : onNetworkConnected() : " + z);
        C6896g c6896g = this.f10283a;
        c6896g.m5097f(c6896g.f4454c, z, Boolean.valueOf(z2));
    }

    /* JADX INFO: renamed from: e */
    public final void m15070e(InterfaceC0044a interfaceC0044a) {
        this.f10283a.getClass();
        ArrayList arrayList = C14499b.f10314h;
        synchronized (arrayList) {
            arrayList.remove(interfaceC0044a);
            Debugger.m8607d("SyncLogic", "Removed SyncEnableMode listener - size : " + arrayList.size());
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m15071g(String str) {
        if (TextUtils.isEmpty(str)) {
            Debugger.m8615i("SyncManager", "requestSyncBackground() : callee = " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        } else {
            Debugger.m8615i("SyncManager", "requestSyncBackground() : " + str);
        }
        this.f10283a.m5100j(new C0099c(8));
    }

    /* JADX INFO: renamed from: h */
    public final void m15072h() {
        Debugger.m8615i("SyncManager", "requestSyncByForce()");
        this.f10283a.m5100j(new C0099c(192));
    }

    /* JADX INFO: renamed from: i */
    public final void m15073i() {
        Debugger.m8615i("SyncManager", "requestSyncByModification() : callee = " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        this.f10283a.m5100j(new C0099c(1));
    }

    /* JADX INFO: renamed from: j */
    public final void m15074j(String str, SyncProgressListener syncProgressListener) {
        Debugger.m8615i("SyncManager", "requestSyncDownImmediately() : " + str + ", listener = " + syncProgressListener);
        C0099c c0099c = new C0099c(64);
        ((HashMap) C6903f.m5119c().f4476d).put(str, syncProgressListener);
        if (((SyncProgressManager$SyncProgressStep) C6903f.m5119c().f4474b) != SyncProgressManager$SyncProgressStep.SyncDownImmediately) {
            this.f10283a.m5100j(c0099c);
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m15075k(boolean z) {
        C6896g c6896g = this.f10283a;
        c6896g.m5102l(z, true, true);
        C0042g c0042gM78a = C0042g.m78a(c6896g.f4454c);
        if (c0042gM78a.m79b()) {
            c0042gM78a.f186b.mo68e(z);
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifyAutoSyncChanged() : fail!");
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m15076l(int i) {
        this.f10283a.mo5089a(i);
    }

    /* JADX INFO: renamed from: m */
    public final void m15077m(Context context) {
        Debugger.m8615i("SyncManager", "triggerSyncPended() : callee = " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        if (AbstractC0159b.f493a != SyncInitState$InitState.initialized) {
            Debugger.m8615i("SyncManager", "triggerSyncPended() : fail to sync due to no initialization!");
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f10284b;
        if (jElapsedRealtime < 60000) {
            Debugger.m8615i("SyncManager", "triggerSyncPended() : fail to sync due to the min elapsed time = " + jElapsedRealtime);
        } else {
            if (!this.f10283a.m5099h()) {
                Debugger.m8615i("SyncManager", "triggerSyncPended() : fail to sync due to the ongoing sync");
                return;
            }
            if (!C0158a.m407a().m413c()) {
                Debugger.m8615i("SyncManager", "triggerSyncPended() : fail to sync due to impossible auto sync");
            } else if (!C0145c.m323h("SyncService", "SyncCompletedStatus", true) || C0145c.m338w(context)) {
                this.f10284b = SystemClock.elapsedRealtime();
                m15071g(null);
            }
        }
    }
}
