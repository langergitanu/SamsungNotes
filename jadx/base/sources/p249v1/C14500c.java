package p249v1;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncBaseTask;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import java.util.concurrent.Executor;
import p026F1.C0098b;
import p026F1.C0099c;
import p207n1.C13541h;
import p212o1.C13573a;
import p234q1.C14433b;

/* JADX INFO: renamed from: v1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14500c implements IAuthInfoReqListener, InterfaceC6897a {

    /* JADX INFO: renamed from: c */
    public final Context f10324c;

    /* JADX INFO: renamed from: a */
    public int f10322a = 1;

    /* JADX INFO: renamed from: b */
    public int f10323b = 0;

    /* JADX INFO: renamed from: d */
    public SyncBaseTask f10325d = null;

    /* JADX INFO: renamed from: e */
    public Executor f10326e = null;

    /* JADX INFO: renamed from: f */
    public InterfaceC6897a f10327f = null;

    /* JADX INFO: renamed from: g */
    public C14500c f10328g = null;

    /* JADX INFO: renamed from: i */
    public final Object f10330i = new Object();

    /* JADX INFO: renamed from: j */
    public boolean f10331j = true;

    /* JADX INFO: renamed from: k */
    public boolean f10332k = false;

    /* JADX INFO: renamed from: h */
    public C0099c f10329h = new C0099c(0);

    public C14500c(Context context) {
        this.f10324c = context;
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: a */
    public final void mo5104a(int i, String str) {
        synchronized (this.f10330i) {
            try {
                this.f10322a = 1;
                this.f10323b = 0;
                InterfaceC6897a interfaceC6897a = this.f10327f;
                if (interfaceC6897a != null) {
                    this.f10331j = false;
                    interfaceC6897a.mo5104a(i, str);
                    this.f10331j = true;
                }
                C0099c c0099c = this.f10329h;
                c0099c.f322a = 0;
                c0099c.f323b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: b */
    public final void mo5105b(C0098b c0098b) {
        synchronized (this) {
            try {
                InterfaceC6897a interfaceC6897a = this.f10327f;
                if (interfaceC6897a != null) {
                    interfaceC6897a.mo5105b(c0098b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: c */
    public final void mo5106c() {
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: d */
    public final void mo5107d(int i) {
        synchronized (this.f10330i) {
            try {
                this.f10322a = 1;
                this.f10323b = 0;
                InterfaceC6897a interfaceC6897a = this.f10327f;
                if (interfaceC6897a != null) {
                    this.f10331j = false;
                    interfaceC6897a.mo5107d(i);
                    this.f10331j = true;
                }
                C0099c c0099c = this.f10329h;
                c0099c.f322a = 0;
                c0099c.f323b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: e */
    public final void mo5108e(int i) {
        synchronized (this.f10330i) {
            try {
                this.f10322a = 1;
                this.f10323b = 0;
                InterfaceC6897a interfaceC6897a = this.f10327f;
                if (interfaceC6897a != null) {
                    this.f10331j = false;
                    interfaceC6897a.mo5108e(i);
                    this.f10331j = true;
                }
                C0099c c0099c = this.f10329h;
                c0099c.f322a = 0;
                c0099c.f323b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m15090f(int i) {
        if (!this.f10331j) {
            Debugger.m8615i("AbsSyncHelper", "cancel stop due to the ending process!");
            return;
        }
        synchronized (this.f10330i) {
            try {
                SyncBaseTask syncBaseTask = this.f10325d;
                if (syncBaseTask == null || syncBaseTask.getStatus() != AsyncTask.Status.RUNNING) {
                    Debugger.m8615i("AbsSyncHelper", "stop() : mSyncTask is null or mSyncTask is stop!");
                    this.f10322a = 1;
                    C0099c c0099c = this.f10329h;
                    c0099c.f322a = 0;
                    c0099c.f323b = null;
                    this.f10323b = 0;
                    C13541h.m14287e().m14289b(this.f10328g);
                    InterfaceC6897a interfaceC6897a = this.f10327f;
                    if (interfaceC6897a != null) {
                        this.f10331j = false;
                        this.f10332k = true;
                        C6907j.m5142c().getClass();
                        interfaceC6897a.mo5107d(C6907j.m5141b(i));
                        this.f10331j = true;
                        this.f10332k = false;
                    }
                } else {
                    Debugger.m8607d("AbsSyncHelper", "stop() : mSyncTask is running!");
                    this.f10325d.stop(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        synchronized (this) {
            try {
                switch (str.hashCode()) {
                    case -1810065010:
                        if (!str.equals(ErrorCodeConvertor.NETWORK_NOT_AVAILABLE)) {
                            mo5104a(106, "errCode = " + str + " errMsg = " + str2);
                        }
                        break;
                    case -1810065009:
                        if (str.equals(ErrorCodeConvertor.SSL_CONNECTION_ERROR)) {
                        }
                        mo5104a(106, "errCode = " + str + " errMsg = " + str2);
                        break;
                    default:
                        mo5104a(106, "errCode = " + str + " errMsg = " + str2);
                        break;
                }
                mo5104a(101, "errCode = " + str + " errMsg = " + str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        Debugger.m8615i("WDocCloudSyncHelper", "onReceived() : token received");
        if (this.f10322a == 1) {
            Debugger.m8615i("WDocCloudSyncHelper", "onReceived() : Don't use this token due to stopping!");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C14433b.m15033p(this.f10324c).m15038n(str, str2, new C13573a(this, 14));
        } else {
            Debugger.m8609e("WDocCloudSyncHelper", "onReceived() : userToken or userId is null!");
            mo5104a(106, "userToken or userId is null");
        }
    }
}
