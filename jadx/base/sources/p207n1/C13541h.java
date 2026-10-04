package p207n1;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.C6888c;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p022E1.C0077c;
import p026F1.C0097a;
import p033H0.C0112b;
import p186h1.C12020a;

/* JADX INFO: renamed from: n1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13541h {

    /* JADX INFO: renamed from: f */
    public static C13541h f9586f;

    /* JADX INFO: renamed from: g */
    public static Context f9587g;

    /* JADX INFO: renamed from: a */
    public Object f9588a;

    /* JADX INFO: renamed from: b */
    public final Object f9589b;

    /* JADX INFO: renamed from: c */
    public final Object f9590c;

    /* JADX INFO: renamed from: d */
    public final Object f9591d;

    /* JADX INFO: renamed from: e */
    public final Object f9592e;

    public C13541h() {
        if (f9587g == null) {
            f9587g = BaseUtils.getApplicationContext();
        }
        C6880g c6880g = new C6880g();
        c6880g.f4409b = null;
        c6880g.f4410c = null;
        c6880g.f4411d = null;
        c6880g.f4412e = null;
        c6880g.f4413f = false;
        c6880g.f4414g = false;
        C12020a c12020a = new C12020a(c6880g, 10);
        C6888c c6888cM5085a = C6888c.m5085a();
        c6880g.f4408a = c6888cM5085a;
        c6888cM5085a.f4428a = c12020a;
        C6904g c6904g = new C6904g();
        c6904g.f4479b = null;
        c6904g.f4478a = false;
        C0112b c0112b = new C0112b();
        c0112b.f362a = new ArrayList();
        c0112b.f363b = c6880g;
        this.f9589b = c0112b;
        this.f9590c = new C6906i(c6880g);
        this.f9591d = new C6742k(c6904g);
        if (!CommonUtils.hasSamsungAccountPackage(f9587g)) {
            this.f9592e = AccountSamsungType.WEB;
            this.f9588a = new C13540g(f9587g);
            return;
        }
        this.f9592e = AccountSamsungType.LOCAL;
        Context context = f9587g;
        C0112b c0112b2 = (C0112b) this.f9589b;
        C13540g c13540g = new C13540g(context);
        c13540g.f9584f = c0112b2;
        this.f9588a = c13540g;
    }

    /* JADX INFO: renamed from: e */
    public static synchronized C13541h m14287e() {
        try {
            if (f9586f == null) {
                f9586f = new C13541h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9586f;
    }

    /* JADX INFO: renamed from: a */
    public void m14288a() {
        try {
            ((ExecutorService) this.f9591d).awaitTermination(3600000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            if (((SyncException) this.f9588a) == null) {
                try {
                    InterfaceC6855f interfaceC6855f = (InterfaceC6855f) this.f9592e;
                    if (interfaceC6855f != null) {
                        interfaceC6855f.mo142h();
                    }
                } catch (SyncException e2) {
                    this.f9588a = e2;
                }
            }
            if (((SyncException) this.f9588a) == null) {
                this.f9588a = new SyncException(0, e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m14289b(IAuthInfoReqListener iAuthInfoReqListener) {
        C0112b c0112b = (C0112b) this.f9589b;
        synchronized (((ArrayList) c0112b.f362a)) {
            try {
                ((ArrayList) c0112b.f362a).remove(iAuthInfoReqListener);
                if (((ArrayList) c0112b.f362a).size() == 0) {
                    ((C6880g) c0112b.f363b).m5075a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m14290c() {
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        C6875b.m5062c().f4377c = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: d */
    public String m14291d() {
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        String str = C6875b.m5062c().f4378d;
        Debugger.m8615i("SAccountManager", "[SA] getAccessToken() : " + Debugger.pii(str) + ", userId = " + UserHandleCompat.getInstance().getUserId(0));
        return str;
    }

    /* JADX INFO: renamed from: f */
    public boolean m14292f() {
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        return C6875b.m5062c().f4386l;
    }

    /* JADX INFO: renamed from: g */
    public String m14293g() {
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        String str = C6875b.m5062c().f4380f;
        Debugger.m8615i("SAccountManager", "[SA] getUserId() : " + Debugger.pii(str) + ", userId = " + UserHandleCompat.getInstance().getUserId(0));
        return str;
    }

    /* JADX INFO: renamed from: h */
    public String m14294h() {
        String strGenerateSha256;
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        if (TextUtils.isEmpty(C6875b.m5062c().f4380f)) {
            ((C13540g) this.f9588a).getClass();
            strGenerateSha256 = C6875b.m5062c().f4393s.getString("UidHash", null);
        } else {
            ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
            strGenerateSha256 = HashUtils.generateSha256(C6875b.m5062c().f4380f);
        }
        Debugger.m8615i("SAccountManager", "[SA] getUserIdHash() : " + Debugger.pii(strGenerateSha256) + ", userId = " + UserHandleCompat.getInstance().getUserId(0));
        return strGenerateSha256;
    }

    /* JADX INFO: renamed from: i */
    public void m14295i(IAuthInfoReqListener iAuthInfoReqListener) {
        Debugger.m8615i("SAccountManager", "[SA] requestAuthInfo(), " + iAuthInfoReqListener);
        ((C0112b) this.f9589b).m268l(iAuthInfoReqListener);
    }

    /* JADX INFO: renamed from: j */
    public void m14296j() {
        Debugger.m8615i("SAccountManager", "[SA] setAccessTokenExpired()");
        ((C6880g) ((C0112b) this.f9589b).f363b).getClass();
        C6875b c6875bM5062c = C6875b.m5062c();
        c6875bM5062c.f4379e = c6875bM5062c.f4378d;
        c6875bM5062c.f4376b = Boolean.TRUE;
        c6875bM5062c.m5064b();
    }

    public C13541h(C0077c c0077c, C0097a c0097a, InterfaceC6855f interfaceC6855f) {
        this.f9589b = c0077c;
        this.f9590c = c0097a;
        this.f9591d = Executors.newFixedThreadPool(3, new SenlThreadFactory("SyncNote/SyncFiles"));
        this.f9592e = interfaceC6855f;
    }
}
