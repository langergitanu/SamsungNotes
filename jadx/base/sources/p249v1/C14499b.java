package p249v1;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncBaseTask;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.AppInfoContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncErrorCode;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.RunnableC9675B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p010C.C0042g;
import p026F1.AbstractC0100d;
import p026F1.C0099c;
import p030G1.InterfaceC0107a;
import p038I1.C0137m;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p101Z.InterfaceC0349a;
import p186h1.C12020a;
import p207n1.C13541h;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: v1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14499b {

    /* JADX INFO: renamed from: e */
    public static C14500c f10311e;

    /* JADX INFO: renamed from: f */
    public static final ArrayList f10312f = new ArrayList();

    /* JADX INFO: renamed from: g */
    public static final ArrayList f10313g = new ArrayList();

    /* JADX INFO: renamed from: h */
    public static final ArrayList f10314h = new ArrayList();

    /* JADX INFO: renamed from: i */
    public static long f10315i = 0;

    /* JADX INFO: renamed from: j */
    public static final ExecutorService f10316j = AbstractC4539a.m3201k("SyncLogic");

    /* JADX INFO: renamed from: k */
    public static InterfaceC0349a f10317k;

    /* JADX INFO: renamed from: b */
    public int f10319b = 0;

    /* JADX INFO: renamed from: c */
    public long f10320c = 0;

    /* JADX INFO: renamed from: d */
    public final C12020a f10321d = new C12020a(this, 14);

    /* JADX INFO: renamed from: a */
    public final C0137m f10318a = C0137m.m280d();

    /* JADX INFO: renamed from: a */
    public static void m15082a() {
        synchronized (C14499b.class) {
            try {
                C14500c c14500c = f10311e;
                if (c14500c != null) {
                    synchronized (c14500c) {
                        c14500c.f10327f = null;
                    }
                    C14500c c14500c2 = f10311e;
                    c14500c2.f10328g = null;
                    if (c14500c2.f10322a != 1) {
                        c14500c2.m15090f(108);
                    }
                    f10311e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static Context m15083b() {
        return C0322h.m670a().f815a.getAppContext();
    }

    /* JADX INFO: renamed from: c */
    public static void m15084c(int i) {
        ArrayList arrayList = f10313g;
        synchronized (arrayList) {
            if (arrayList.isEmpty()) {
                f10313g.clear();
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((SyncProgressListener) it.next()).onEnded(i);
                    } catch (Exception e) {
                        Debugger.m8609e("SyncLogic", "handleSyncProgressListeners() : " + e.getMessage());
                    }
                }
                f10313g.clear();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m15085e() {
        Context appContext;
        C14500c c14500c = f10311e;
        if (c14500c == null) {
            Debugger.m8615i("SyncLogic", "isCurrentSyncPossible() : mWDocCloudSyncHelper is null!");
            return true;
        }
        int i = c14500c.f10329h.f322a;
        AppInfoContractImpl appInfoContractImpl = C0322h.m670a().f815a;
        if (appInfoContractImpl == null || (appContext = appInfoContractImpl.getAppContext()) == null || (C0158a.m407a().m418l() && C0145c.m334s(appContext) && (!C0145c.m299G(appContext) || C0145c.m298F(appContext) || (i & 256) == 256))) {
            return true;
        }
        Debugger.m8615i("SyncStateInfo", "Current sync is not possible");
        return false;
    }

    /* JADX INFO: renamed from: f */
    public static void m15086f(int i) {
        if (i == 0) {
            Debugger.m8615i("SyncLogic", "onPostSync() : success");
            try {
                if (AbstractC0299q.f771d) {
                    AbstractC0299q.m604N("5044", "a");
                }
            } catch (Exception e) {
                Logger.m8698e("SyncSALoggingHelper", e.toString());
            }
        } else {
            Debugger.m8609e("SyncLogic", "onPostSync() : " + SyncErrorCode.getErrorCodesString(i));
        }
        AbstractC0299q.f771d = false;
        C0145c.m304L("SyncService", "SyncCompletedStatus", true);
        AbstractC0100d.m243e(m15083b(), i);
        AbstractC0100d.m244f(m15083b(), i);
        SyncProgressListener syncProgressListener = (SyncProgressListener) C6903f.m5119c().f4475c;
        if (syncProgressListener != null) {
            try {
                syncProgressListener.onEnded(i);
            } catch (Exception e2) {
                AbstractC0000a.m22s("onPostSync() : onEnded, e = ", e2, "SyncLogic");
            }
            C6903f.m5119c().f4475c = null;
        }
        AbstractC0000a.m17n(i, "[UiSyncProgress] onEnded() : ", "SyncLogic");
        ArrayList arrayList = f10312f;
        synchronized (arrayList) {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((InterfaceC0107a) it.next()).onEnded(i);
                    } catch (Exception e3) {
                        Debugger.m8609e("SyncLogic", "handleUiSyncProgressListeners() : " + e3.getMessage());
                    }
                }
            }
        }
        m15084c(i);
        AbstractC0153k.m374c("SyncLogic", "Sync(E)");
    }

    /* JADX INFO: renamed from: h */
    public static void m15087h(int i) {
        AbstractC0000a.m0A(i, "stopSync() : ", "SyncLogic");
        if (i == 111) {
            if (!C0145c.m338w(m15083b())) {
                C0145c.m309Q(m15083b(), Boolean.TRUE);
            }
        } else if (C0145c.m338w(m15083b())) {
            C0145c.m309Q(m15083b(), Boolean.FALSE);
        }
        if (f10311e == null) {
            Debugger.m8615i("SyncLogic", "stopSync() : mWDocCloudSyncHelper is null!");
            m15084c(0);
            return;
        }
        C6907j c6907jM5142c = C6907j.m5142c();
        int i2 = f10311e.f10329h.f322a;
        c6907jM5142c.getClass();
        if (i != 104) {
            if (i == 105 && (i2 & 256) == 256) {
                return;
            }
        } else if ((i2 & 64) == 64) {
            return;
        }
        f10311e.m15090f(i);
        if (C0322h.m670a().f833s.isBackgroundDownloading()) {
            C0322h.m670a().f833s.stopBackgroundDownload();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m15088d() {
        Debugger.m8615i("SyncLogic", "initSyncLogic() : v." + AbstractC0155m.m399n(m15083b()));
        synchronized (C14499b.class) {
            try {
                if (f10311e == null) {
                    Context contextM15083b = m15083b();
                    DocTypeConstants docTypeConstants = DocTypeConstants.NONE;
                    C14500c c14500c = new C14500c(contextM15083b);
                    c14500c.f10328g = c14500c;
                    f10311e = c14500c;
                }
                C14500c c14500c2 = f10311e;
                C12020a c12020a = this.f10321d;
                synchronized (c14500c2) {
                    c14500c2.f10327f = c12020a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        new SenlThreadFactory("onCreateSyncThread").newThread(new RunnableC9675B(this)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x016d A[Catch: all -> 0x016b, TryCatch #2 {all -> 0x016b, blocks: (B:48:0x0153, B:63:0x019f, B:54:0x0163, B:57:0x016d, B:59:0x0171, B:61:0x0179, B:62:0x018d), top: B:75:0x0153 }] */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m15089g(C0099c c0099c) {
        Debugger.m8615i("SyncLogic", "requestSync() : " + c0099c.f322a);
        if (f10311e == null) {
            Debugger.m8609e("SyncLogic", "requestSync() : mWDocCloudSyncHelper is null!");
            return;
        }
        f10315i = System.currentTimeMillis();
        f10311e.f10329h = c0099c;
        if (c0099c.f322a != 1024) {
            Debugger.m8607d("SyncLogic", "onPreStartedSync()");
            C0145c.m309Q(m15083b(), Boolean.FALSE);
            C0145c.m304L("SyncService", "SyncCompletedStatus", false);
            if (AbstractC0100d.m239a(m15083b()) != 0) {
                Debugger.m8615i("SyncLogic", "onPreStartedSync() : ExternalLastSyncError = " + SyncErrorCode.getErrorCodesString(AbstractC0100d.m239a(m15083b())));
                AbstractC0100d.m243e(m15083b(), 0);
            }
            if (AbstractC0100d.m240b(m15083b()) != 0) {
                Debugger.m8615i("SyncLogic", "onPreStartedSync() : InternalLastSyncError = " + SyncErrorCode.getErrorCodesString(AbstractC0100d.m240b(m15083b())));
                AbstractC0100d.m244f(m15083b(), 0);
            }
            Debugger.m8607d("SyncLogic", "[UiSyncProgress] onStartedSync()");
            C0322h.m670a().f818d.cancelAllSyncNotification();
            this.f10318a.m287h();
            ArrayList arrayList = f10312f;
            synchronized (arrayList) {
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            ((InterfaceC0107a) it.next()).onStarted();
                        } catch (Exception e) {
                            Debugger.m8609e("SyncLogic", "onStartedSync() : Exception - " + e.getMessage());
                        }
                    }
                }
            }
            C0042g c0042gM78a = C0042g.m78a(m15083b());
            if (c0042gM78a.m79b()) {
                c0042gM78a.f186b.mo74k();
            } else {
                Debugger.m8609e("SCRPCSettingManager", "notifySyncStart() : fail!");
            }
            TemporalServerNoteInfo temporalServerNoteInfo = c0099c.f326e;
            if (temporalServerNoteInfo != null) {
                AbstractC14517a.f10347b = temporalServerNoteInfo;
            }
            if (!TextUtils.isEmpty(c0099c.f323b)) {
                AbstractC14517a.f10346a = c0099c.f323b;
            }
        }
        C14500c c14500c = f10311e;
        ExecutorService executorService = f10316j;
        if (!c14500c.f10331j) {
            if (!C0145c.m338w(c14500c.f10324c) && !c14500c.f10332k) {
                C0145c.m309Q(c14500c.f10324c, Boolean.TRUE);
            }
            Debugger.m8615i("SyncHelper", "request() : cancel request due to the ending process!");
            return;
        }
        Debugger.m8615i("SyncHelper", "request() : ready to requestToken!");
        synchronized (c14500c.f10330i) {
            try {
                c14500c.f10326e = executorService;
                c14500c.f10323b = 1;
                int i = c14500c.f10322a;
                if (i == 1) {
                    SyncBaseTask syncBaseTask = c14500c.f10325d;
                    if (syncBaseTask != null && syncBaseTask.getStatus() == AsyncTask.Status.RUNNING) {
                        Debugger.m8615i("SyncHelper", "cancel SyncTask");
                        c14500c.f10325d.setListener(null);
                        c14500c.m15090f(107);
                        c14500c.f10323b = 1;
                    }
                    c14500c.f10322a = 2;
                    AbstractC0153k.m374c("SyncHelper", "Request SA Auth");
                    C13541h.m14287e().m14295i(c14500c.f10328g);
                } else if (i == 2) {
                    Debugger.m8615i("SyncHelper", "mState is REQUEST_TOKEN");
                } else if (i != 3) {
                }
            } finally {
            }
        }
    }
}
