package p052M;

import com.samsung.android.app.notes.sync.contentsharing.controllers.C6684b;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6721d;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6727e;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6728f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import p029G0.C0105b;
import p042J1.C0145c;
import p063P.InterfaceC0192a;
import p086V.C0322h;

/* JADX INFO: renamed from: M.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0171a {

    /* JADX INFO: renamed from: f */
    public static C0171a f542f;

    /* JADX INFO: renamed from: a */
    public final C6684b f543a;

    /* JADX INFO: renamed from: c */
    public WeakReference f545c;

    /* JADX INFO: renamed from: b */
    public InterfaceC0172b f544b = null;

    /* JADX INFO: renamed from: d */
    public long f546d = 0;

    /* JADX INFO: renamed from: e */
    public final Object f547e = new Object();

    public C0171a() {
        C6684b c6684b = new C6684b();
        c6684b.f3986a = C0322h.m670a().f815a.getAppContext();
        this.f543a = c6684b;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0171a m429a() {
        try {
            if (f542f == null) {
                f542f = new C0171a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f542f;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m430b() {
        this.f543a.getClass();
        C6721d c6721d = C6728f.f4085g;
        if (c6721d != null) {
            z = c6721d.f4053a != 1;
            Debugger.m8615i("MdeImportLogic", "mSdocCloudSyncHelper is not null");
        }
        Debugger.m8615i("MdeImportLogic", "isMdeImporting : " + z);
        return z;
    }

    /* JADX INFO: renamed from: c */
    public final void m431c(InterfaceC0192a interfaceC0192a) {
        this.f543a.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = C6727e.f4080g;
        copyOnWriteArrayList.remove(interfaceC0192a);
        Debugger.m8607d("MdeDeleteLogic", "Removed progress listener - size : " + copyOnWriteArrayList.size());
    }

    /* JADX INFO: renamed from: d */
    public final void m432d(String str) {
        C6684b c6684b = this.f543a;
        c6684b.getClass();
        Debugger.m8607d("ShareOldServiceController", "requestShare()");
        if (C6727e.m4819c()) {
            Debugger.m8607d("ShareOldServiceController", "Cancel share because of deletion.");
        } else {
            c6684b.m4777a(new C0105b(str));
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m433e(String str, boolean z) {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            return;
        }
        this.f543a.m4778b(str, z);
    }

    /* JADX INFO: renamed from: f */
    public final void m434f() {
        synchronized (this.f547e) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f546d > 500) {
                    this.f546d = jCurrentTimeMillis;
                    this.f544b.showGoToSettingsDialog(this.f545c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
