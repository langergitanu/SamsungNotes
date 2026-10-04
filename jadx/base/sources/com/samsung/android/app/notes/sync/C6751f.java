package com.samsung.android.app.notes.sync;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6728f;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6898a;
import com.samsung.android.app.notes.sync.synchronization.managers.C6902e;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.Iterator;
import p010C.RunnableC0037b;
import p020E.C0073a;
import p042J1.AbstractC0146d;
import p042J1.C0145c;
import p044K.C0158a;
import p052M.C0171a;
import p079T.C0283a;
import p086V.C0322h;
import p186h1.C12028i;
import p192j1.C12936a;
import p195k1.C12969a;
import p207n1.C13540g;
import p207n1.C13541h;
import p211o0.C13567a;
import p244u1.C14477a;
import p248v0.C14497a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6751f {

    /* JADX INFO: renamed from: h */
    public static C6751f f4138h;

    /* JADX INFO: renamed from: a */
    public final Context f4139a;

    /* JADX INFO: renamed from: b */
    public ConnectivityManager f4140b = null;

    /* JADX INFO: renamed from: c */
    public final ConnectivityManager.NetworkCallback f4141c = new ConnectivityManager.NetworkCallback() { // from class: com.samsung.android.app.notes.sync.GeneralManager$4
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.this$0.f4139a == null) {
                Debugger.m8615i("GeneralManager", "[Network] onAvailable() : mContext == null");
                return;
            }
            if (C0322h.m670a().f815a == null || C0322h.m670a().f815a.getAppContext() == null) {
                Debugger.m8615i("GeneralManager", "[Network] onAvailable() : context == null!");
                return;
            }
            Debugger.m8615i("GeneralManager", "[Network] onAvailable()");
            Context context = this.this$0.f4139a;
            if (context == null) {
                Debugger.m8609e("SC/NetworkUtils", "[Network] printSimpleCurrentStates() : context is null");
            } else {
                Debugger.m8615i("SC/NetworkUtils", "[Network] isDataNetworkAvailable : " + C0145c.m334s(context));
                Debugger.m8615i("SC/NetworkUtils", "[Network] isMobileAvailable : " + C0145c.m336u(context));
                Debugger.m8615i("SC/NetworkUtils", "[Network] isWiFiAvailable : " + C0145c.m297E(context));
            }
            C12936a.m13839c().getClass();
            if (C12936a.m13841f()) {
                C14497a.m15078a().m15079b(true, C0145c.m298F(this.this$0.f4139a));
            }
            if (C0158a.m407a().m418l()) {
                C14477a.m15065b().m15069d(true, C0145c.m298F(this.this$0.f4139a));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (this.this$0.f4139a == null) {
                Debugger.m8615i("GeneralManager", "[Network] onLost() : mContext == null");
                return;
            }
            if (C0322h.m670a().f815a == null || C0322h.m670a().f815a.getAppContext() == null) {
                Debugger.m8615i("GeneralManager", "[Network] onLost() : mContext == null!");
            }
            Debugger.m8615i("GeneralManager", "[Network] onLost()");
            C12936a.m13839c().getClass();
            if (C12936a.m13841f()) {
                C14497a.m15078a().m15079b(false, C0145c.m298F(this.this$0.f4139a));
            }
            if (C0158a.m407a().m418l()) {
                C14477a.m15065b().m15069d(false, C0145c.m298F(this.this$0.f4139a));
            }
        }
    };

    /* JADX INFO: renamed from: d */
    public final C6664c f4142d = new C6664c(this);

    /* JADX INFO: renamed from: e */
    public final C0073a f4143e = new C0073a(this, 5);

    /* JADX INFO: renamed from: f */
    public final C6750e f4144f = new C6750e();

    /* JADX INFO: renamed from: g */
    public final C6731d f4145g = new C6731d(this);

    public C6751f(Context context) {
        this.f4139a = null;
        this.f4139a = context;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C6751f m4890a(Context context) {
        try {
            if (f4138h == null) {
                f4138h = new C6751f(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4138h;
    }

    /* JADX INFO: renamed from: b */
    public final void m4891b() {
        C6898a c6898a;
        Debugger.m8615i("GeneralManager", "lazyInitSyncSystem() start");
        new C0283a().m563e();
        C13541h c13541hM14287e = C13541h.m14287e();
        C6664c c6664c = this.f4142d;
        C13540g c13540g = (C13540g) c13541hM14287e.f9588a;
        if (c6664c == null) {
            c13540g.getClass();
            Debugger.m8609e("SamsungAccountLogInController", "[SA] addAccountLoginListener() : listener is null!");
        } else {
            synchronized (c13540g.f9580b) {
                try {
                    Iterator it = c13540g.f9580b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            c13540g.f9580b.add(c6664c);
                            Debugger.m8607d("SamsungAccountLogInController", "[SA] Added account login listener - size : " + c13540g.f9580b.size());
                            break;
                        }
                        if (((IAccountLoginListener) it.next()).equals(c6664c)) {
                            break;
                        }
                    }
                } finally {
                }
            }
        }
        C13541h c13541hM14287e2 = C13541h.m14287e();
        if (((AccountSamsungType) c13541hM14287e2.f9592e) == AccountSamsungType.LOCAL) {
            ((C13540g) c13541hM14287e2.f9588a).m14285a();
        } else {
            Debugger.m8609e("SAccountManager", "[SA] updateLoginState() : Not supported yet!");
        }
        C12969a.m13872b(this.f4139a).f9311e = this.f4143e;
        this.f4140b = (ConnectivityManager) this.f4139a.getSystemService("connectivity");
        this.f4140b.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addCapability(12).build(), this.f4141c);
        synchronized (C6898a.class) {
            try {
                if (C6898a.f4462d == null) {
                    C6898a.f4462d = new C6898a();
                }
                c6898a = C6898a.f4462d;
            } finally {
            }
        }
        c6898a.f4464b = ContentResolver.addStatusChangeListener(1, c6898a.f4465c);
        c6898a.f4463a = 0;
        new C12028i().m13709d(2);
        this.f4139a.getSharedPreferences("PasswordSyncingStatus", 0).edit().putBoolean("PasswordSyncing", false).apply();
        Context context = this.f4139a;
        if (C0158a.m408b(context)) {
            C0171a c0171aM429a = C0171a.m429a();
            C6750e c6750e = this.f4144f;
            c0171aM429a.f543a.getClass();
            C6728f.m4820b(c6750e);
            Debugger.m8607d("GeneralManager", "SES Agent v." + SeMobileService.getAgentVersion(context) + ", SES SDK v." + SeMobileService.getSdkVersionName());
        }
        TaskState companion = TaskState.INSTANCE.getInstance();
        TaskState.Type.Companion companion2 = TaskState.Type.INSTANCE;
        companion.addListener("COEDIT_SERVICE", this.f4145g);
        final Handler handler = null;
        this.f4139a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new ContentObserver(handler) { // from class: com.samsung.android.app.notes.sync.GeneralManager$2
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                String path = uri.getPath();
                String strSubstring = path.substring(path.lastIndexOf("/") + 1, path.length());
                if (strSubstring.equals("user_powersaver_enable") || strSubstring.equals("psm_switch")) {
                    Debugger.m8615i("GeneralManager", "batterySaverEnabled = " + Settings.System.getString(this.this$0.f4139a.getContentResolver(), strSubstring).equals("1"));
                }
            }
        });
        if (C12969a.m13872b(this.f4139a).m13874c()) {
            C12969a.m13872b(this.f4139a).m13880i();
        }
        Debugger.m8615i("GeneralManager", "lazyInitSyncSystem() finish");
    }

    /* JADX INFO: renamed from: c */
    public final void m4892c() {
        Debugger.m8614f("GeneralManager", "signedInAction()");
        Boolean bool = Boolean.FALSE;
        Context context = this.f4139a;
        C0145c.m312T(context, bool);
        if (!DeviceInfo.isOtherCorpDevice() && (CommonUtils.hasCloudSetting(context) || AbstractC0146d.m344c(context))) {
            C0145c.m311S(context, Boolean.valueOf(AbstractC0146d.m345d(context)));
        }
        Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync()");
        if (context == null) {
            Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync() : mContext == null");
        } else {
            try {
                C12936a.m13839c().getClass();
                if (C12936a.m13842g()) {
                    if (C0158a.m407a().m413c()) {
                        C6902e.m5116a().f4471a = true;
                        new SenlThreadFactory("GeneralManagerThread").newThread(new RunnableC0037b(this, 2)).start();
                    } else {
                        Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync() : AutoSync is not possible!");
                    }
                } else if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                    Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync() : is not logged in!");
                } else if (C0158a.m407a().m417k()) {
                    Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync() : show the permission allow tipcard!");
                    AbstractC14517a.m15163w(102, 8).mo4791d();
                } else {
                    Debugger.m8615i("GeneralManager", "checkPermissionAndAutoSync() : Sync is not enable!");
                }
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("checkPermissionAndAutoSync() : "), "GeneralManager");
            }
        }
        SCloudPamHelper.signIn();
        if (C12969a.m13872b(context).m13874c()) {
            C12969a.m13872b(context).m13880i();
        }
        if (AbstractC4539a.m3210t()) {
            C13567a.m14371a().m14373d(new C6662a(this, 0));
        }
    }
}
