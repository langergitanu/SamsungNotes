package p079T;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p012C1.RunnableC0045a;
import p024F.InterfaceC0085b;
import p207n1.C13541h;

/* JADX INFO: renamed from: T.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0283a implements InterfaceC0085b, InterfaceC6683a {

    /* JADX INFO: renamed from: a */
    public static C0283a f739a;

    /* JADX INFO: renamed from: a */
    public static void m560a(C0283a c0283a, Bundle bundle) {
        if (bundle.containsKey("result_message")) {
            Debugger.m8609e("AccountManagerProvider", "[SA] result_message = " + bundle.getString("result_message"));
        } else {
            Debugger.m8615i("AccountManagerProvider", "[SA] No result_message");
        }
        if (!bundle.containsKey("result_value")) {
            Debugger.m8615i("AccountManagerProvider", "[SA] No result_value");
            return;
        }
        Debugger.m8609e("AccountManagerProvider", "[SA] result_value = " + bundle.getInt("result_value"));
    }

    /* JADX INFO: renamed from: c */
    public static String m561c() {
        return C13541h.m14287e().m14293g();
    }

    /* JADX INFO: renamed from: d */
    public static synchronized C0283a m562d() {
        try {
            if (f739a == null) {
                f739a = new C0283a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f739a;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady() for request delete local all");
        shareOldService.requestDeleteLocalAll();
    }

    /* JADX INFO: renamed from: e */
    public void m563e() {
        Debugger.m8615i("AccountManagerProvider", "[SA] setVisability()");
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            new SenlThreadFactory("AccountManagerProviderThread").newThread(new RunnableC0045a(this, applicationContext, 7)).start();
        }
    }

    @Override // p024F.InterfaceC0085b
    public void onDeleteLocalSharedSdocFinished() {
    }
}
