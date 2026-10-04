package p048L;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.concurrent.Future;
import org.apache.http.client.methods.HttpRequestBase;
import p042J1.C0145c;
import p207n1.C13537d;
import p207n1.C13541h;

/* JADX INFO: renamed from: L.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0165c extends AbstractC0163a {

    /* JADX INFO: renamed from: f */
    public String f506f;

    /* JADX INFO: renamed from: g */
    public C13537d f507g;

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: a */
    public final void mo419a(HttpRequestBase httpRequestBase) {
        httpRequestBase.addHeader("Authorization", IdentityApiContract.Token.BEARER_ + this.f507g.f9573g);
        httpRequestBase.addHeader("x-os-version", Build.VERSION.RELEASE);
        httpRequestBase.addHeader("x-package-name", this.f507g.f9567a);
        httpRequestBase.addHeader("x-package-version", this.f507g.f9569c);
        httpRequestBase.addHeader("x-model-name", Build.MODEL.replaceFirst("^SAMSUNG-", ""));
        httpRequestBase.addHeader("x-started", Long.toString(System.currentTimeMillis()));
        httpRequestBase.addHeader("x-requested", Long.toString(System.currentTimeMillis()));
        httpRequestBase.addHeader("x-app-id", this.f507g.f9568b);
        httpRequestBase.addHeader("x-device-id", C0145c.m325j(BaseUtils.getApplicationContext()));
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: h */
    public final void mo426h(int i, String str) {
        Debugger.m8609e("ServerConsentBase", "handleHttpError() : statusCode = " + i + ", response = " + str);
        if (i == 401) {
            C13541h.m14287e().m14296j();
        }
        mo425g(4, str);
    }

    /* JADX INFO: renamed from: j */
    public final void m428j(boolean z) {
        Debugger.m8615i("ServerConsentBase", "request()");
        Future future = this.f501a;
        if (future != null && !future.isDone()) {
            this.f501a.cancel(true);
        }
        new SenlThreadFactory("CancelableHttpRequest").newThread(new RunnableC0164b(0, this, z)).start();
    }
}
