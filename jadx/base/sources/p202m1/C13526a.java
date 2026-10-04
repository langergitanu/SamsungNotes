package p202m1;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import p211o0.C13571e;
import p211o0.C13572f;
import p212o1.C13573a;
import p234q1.C14433b;

/* JADX INFO: renamed from: m1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13526a implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9525a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9526b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9527c;

    public /* synthetic */ C13526a(Object obj, Object obj2, int i) {
        this.f9525a = i;
        this.f9527c = obj;
        this.f9526b = obj2;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        switch (this.f9525a) {
            case 0:
                Debugger.m8609e("RegisterSmpUsingPam", "[PUSH] activatePush() : Fail to get AccessToken " + str + " " + str2);
                ((C13527b) this.f9527c).f9528a.m204j(-1);
                break;
            default:
                Debugger.m8609e("RequestEdpStateTask", "[EDP] onError() : " + str2);
                C13571e c13571e = (C13571e) this.f9527c;
                c13571e.f9627d = new C13572f(603, str2);
                c13571e.f9625b.countDown();
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        switch (this.f9525a) {
            case 0:
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    Debugger.m8609e("RegisterSmpUsingPam", "[PUSH] activatePush() : userToken or userId is empty!");
                    ((C13527b) this.f9527c).f9528a.m204j(-1);
                } else {
                    C14433b.m15033p((Context) this.f9526b).m15038n(str, str2, new C6903f(this, 12, str, str2));
                }
                break;
            default:
                Debugger.m8615i("RequestEdpStateTask", "onReceived()");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    Debugger.m8609e("RequestEdpStateTask", "[EDP] onReceived() : userToken or userId is null!");
                    C13571e c13571e = (C13571e) this.f9527c;
                    c13571e.f9627d = new C13572f(603, "userToken or userId is null!");
                    c13571e.f9625b.countDown();
                } else {
                    C14433b.m15033p(BaseUtils.getApplicationContext()).m15038n(str, str2, new C13573a(this, 13));
                }
                break;
        }
    }
}
