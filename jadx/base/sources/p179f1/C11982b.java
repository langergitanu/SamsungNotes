package p179f1;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.smartswitchfileshare.FileShareHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p076S0.C0275a;
import p076S0.C0276b;
import p079T.AbstractC0299q;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p186h1.AbstractC12031l;

/* JADX INFO: renamed from: f1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11982b extends AbstractC11983c {

    /* JADX INFO: renamed from: w */
    public static final String f8587w = "SS$".concat("InstantRestoreDocTask");

    /* JADX INFO: renamed from: v */
    public File f8588v;

    /* JADX INFO: renamed from: E */
    public final void m13562E() throws Exception {
        AbstractC0299q.m643n(f8587w, "createSnapShot");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(31);
        C11972a c11972a = this.f8551a;
        List listSingletonList = Collections.singletonList(new C0276b(c11972a.f8537b));
        new C0275a().m559a(AbstractC11975a.m13543f(), new C6903f(Type$Interface.NONE, Type$Process.NONE, Type$Flow.RESTORE), c11972a.f8547l, WDocUtils.getNoteFilePath(AbstractC11975a.m13543f(), true) + "SDocBnR/", this.f8588v, listSingletonList);
        C0148f.m355k(41);
    }

    /* JADX INFO: renamed from: F */
    public final void m13563F() throws Exception {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m355k(51);
        Context contextM13543f = AbstractC11975a.m13543f();
        File file = this.f8588v;
        C11972a c11972a = this.f8551a;
        Intent intent = c11972a.f8544i;
        String str2 = AbstractC12031l.f8796a;
        int iCopy = new FileShareHelper(contextM13543f.getApplicationContext(), AbstractC12031l.f8796a).copy(file, intent);
        Locale locale = Locale.ENGLISH;
        AbstractC0299q.m603M(f8587w, "transferSnapshot ".concat(AbstractC1974b.m1319l("Intent[", iCopy, c11972a.f8544i.getAction(), "] copyCount[", "]")));
        if (iCopy <= 0) {
            throw new Exception("transferSnapshot failed to copy");
        }
        C0148f.m355k(61);
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: e */
    public final void mo13546e() throws Throwable {
        String str;
        str = f8587w;
        AbstractC0299q.m643n(str, "InstantRestoreDocTask start");
        String str2 = this.f8562l;
        str2.getClass();
        switch (str2) {
            case "com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT":
                AbstractC0299q.m643n(str, "executeRequestInstantSnapshot");
                try {
                    m13562E();
                    m13563F();
                    break;
                } catch (Exception e) {
                    AbstractC6670b.m4762w(e, new StringBuilder("executeRequestInstantSnapshot exception "), str);
                    break;
                }
                break;
            case "com.samsung.android.intent.action.REQUEST_INSTANT_RESTORE":
                AbstractC0299q.m643n(str, "executeRequestInstantRestore");
                try {
                    mo13549i();
                    mo13552l();
                    mo13544a();
                    break;
                } catch (Exception e2) {
                    AbstractC6670b.m4762w(e2, new StringBuilder("executeRequestInstantRestore exception "), str);
                    break;
                }
                break;
            case "com.samsung.android.intent.action.NOTICE_INSTANT_TASK_CANCELED":
                boolean booleanExtra = this.f8551a.f8544i.getBooleanExtra(OpenSessionApi.ITEM_LIMIT_DELETE, false);
                AbstractC0299q.m643n(str, "executeNoticeTaskCanceled needToClear " + booleanExtra);
                if (booleanExtra) {
                    mo13544a();
                    break;
                } else {
                    String str3 = C0148f.f420k;
                    AbstractC0147e.f419a.f434d = false;
                    if (this.f8559i == 0 && this.f8561k.isEmpty()) {
                        m13551k(0, this.f8558h);
                    }
                    break;
                }
                break;
            default:
                AbstractC0299q.m646q(str, "InstantRestoreDocTask invalid intent action");
                break;
        }
        AbstractC0299q.m643n(str, "InstantRestoreDocTask end");
    }
}
