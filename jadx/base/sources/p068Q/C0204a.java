package p068Q;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p105a0.InterfaceC0353a;
import p260z0.C14518a;

/* JADX INFO: renamed from: Q.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0204a {

    /* JADX INFO: renamed from: a */
    public final Context f632a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC0353a f633b;

    /* JADX INFO: renamed from: c */
    public final C14518a f634c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f635d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0204a(int i, String str, int i2) {
        this(i, str);
        this.f635d = i2;
    }

    /* JADX INFO: renamed from: b */
    private final void m484b() {
    }

    /* JADX INFO: renamed from: c */
    private final void m485c() {
    }

    /* JADX INFO: renamed from: d */
    private final void m486d() {
    }

    /* JADX INFO: renamed from: a */
    public final void m487a() {
        switch (this.f635d) {
            case 0:
                break;
            case 1:
                this.f633b.addErrorTipCard(this.f632a, this.f634c);
                break;
            case 2:
                this.f633b.addErrorTipCard(this.f632a, this.f634c);
                break;
            case 3:
                C14518a c14518a = this.f634c;
                String str = c14518a.f10351c;
                if (str != null && !str.isEmpty()) {
                    Debugger.m8609e("ModelError", c14518a.f10351c);
                }
                if (DeviceInfo.isVSTModel()) {
                    Debugger.m8609e("NotAuthorizedShareModelError", "NotAuthorizedShareModelError");
                } else {
                    try {
                        if (AbstractC0299q.m648s().getAuthInfo() == null) {
                            Debugger.m8609e("NotAuthorizedShareModelError", "Not logged in the samsung account!");
                        }
                    } catch (Exception e) {
                        AbstractC4539a.m3213w(e, new StringBuilder("Exception : "), "NotAuthorizedShareModelError");
                    }
                }
                this.f633b.addErrorTipCard(this.f632a, c14518a);
                break;
            case 4:
            case 5:
                break;
            case 6:
                Debugger.m8609e("ServerShareModelError", "handle()");
                break;
            case 7:
                this.f633b.addErrorTipCard(this.f632a, this.f634c);
                break;
            case 8:
                Debugger.m8607d("UnknownShareModelError", "handle()");
                break;
            default:
                this.f633b.addErrorTipCard(this.f632a, this.f634c);
                break;
        }
    }

    public C0204a(int i, String str) {
        ModelType modelType = ModelType.SHARE;
        C14518a c14518a = new C14518a();
        c14518a.f10349a = modelType;
        c14518a.f10350b = i;
        c14518a.f10351c = str;
        this.f634c = c14518a;
        this.f632a = C0322h.m670a().f815a.getAppContext();
        C0322h.m670a().getClass();
        this.f633b = C0322h.m670a().f820f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0204a(String str, int i) {
        this(64, str);
        this.f635d = i;
        switch (i) {
            case 7:
                this(128, str);
                break;
            case 8:
                this(2048, str);
                break;
            case 9:
                this(4096, str);
                break;
            default:
                break;
        }
    }
}
