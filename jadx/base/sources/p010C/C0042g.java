package p010C;

import android.content.Context;
import com.samsung.android.scloud.lib.setting.SamsungCloudRPCSettingV2Std;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import p001A.AbstractC0000a;
import p042J1.AbstractC0146d;

/* JADX INFO: renamed from: C.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0042g {

    /* JADX INFO: renamed from: c */
    public static C0042g f184c;

    /* JADX INFO: renamed from: a */
    public Context f185a;

    /* JADX INFO: renamed from: b */
    public AbstractC0036a f186b;

    /* JADX INFO: renamed from: a */
    public static synchronized C0042g m78a(Context context) {
        try {
            if (f184c == null) {
                C0042g c0042g = new C0042g();
                c0042g.f185a = null;
                c0042g.f185a = context.getApplicationContext();
                f184c = c0042g;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f184c;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m79b() {
        if (this.f185a == null) {
            Context applicationContext = BaseUtils.getApplicationContext();
            this.f185a = applicationContext;
            if (applicationContext == null) {
                Debugger.m8609e("SCRPCSettingManager", "getSCRPCSetting() : context is null!");
                return false;
            }
        }
        try {
            if (AbstractC0146d.m347f(this.f185a)) {
                AbstractC0036a abstractC0036a = this.f186b;
                if (abstractC0036a == null || !(abstractC0036a instanceof C0040e)) {
                    Context context = this.f185a;
                    C0040e c0040e = new C0040e();
                    c0040e.f175c = context;
                    c0040e.f182d = new SamsungCloudRPCSettingV2Std(context, "com.samsung.android.app.notes.sync", "com.samsung.android.app.notes.syncv2");
                    this.f186b = c0040e;
                }
            } else if (CommonUtils.isSamsungCloudUpper505(this.f185a)) {
                AbstractC0036a abstractC0036a2 = this.f186b;
                if (abstractC0036a2 == null || !(abstractC0036a2 instanceof C0039d)) {
                    Context context2 = this.f185a;
                    C0039d c0039d = new C0039d();
                    c0039d.f179d = 0;
                    c0039d.f181f = 0L;
                    c0039d.f175c = context2;
                    this.f186b = c0039d;
                }
            } else if (AbstractC0146d.m344c(this.f185a)) {
                Context context3 = this.f185a;
                C0041f c0041f = new C0041f(0);
                c0041f.f175c = context3;
                this.f186b = c0041f;
            } else {
                Context context4 = this.f185a;
                C0041f c0041f2 = new C0041f(1);
                c0041f2.f175c = context4;
                this.f186b = c0041f2;
            }
        } catch (Exception e) {
            AbstractC0000a.m22s("getSCRPCSetting() : fail to get SCSetting, e = ", e, "SCRPCSettingManager");
        }
        return this.f186b != null;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m80c() {
        m79b();
        int iMo65b = this.f186b.mo65b();
        return iMo65b != -1 && iMo65b == 256;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m81d() {
        m79b();
        int iMo65b = this.f186b.mo65b();
        return iMo65b != -1 && iMo65b == 512;
    }

    /* JADX INFO: renamed from: e */
    public final void m82e() {
        if (m79b()) {
            this.f186b.mo71h();
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifySyncComplete() : fail!");
        }
    }
}
