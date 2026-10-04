package p048L;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.region.RegionUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SamsungAccountUtil;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p207n1.C13537d;

/* JADX INFO: renamed from: L.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0167e extends AbstractC0165c {

    /* JADX INFO: renamed from: h */
    public final String f509h;

    /* JADX INFO: renamed from: i */
    public final boolean f510i;

    /* JADX INFO: renamed from: j */
    public ServerResultListener f511j;

    public C0167e(boolean z) {
        if (SyncState.isCmsTest()) {
            this.f509h = "40557";
        } else {
            this.f509h = "3379";
        }
        this.f510i = z;
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: d */
    public final String mo422d() {
        StringBuilder sb = new StringBuilder();
        if (SyncState.isCmsTest()) {
            sb.append("https://apis.samsungconsentdev.com");
        } else {
            sb.append(RegionUtils.getConsentServerURL());
        }
        sb.append("/v1/consent/");
        sb.append(this.f509h);
        if (this.f510i) {
            sb.append("/agree");
        } else {
            sb.append("/withdraw");
        }
        C13537d c13537d = new C13537d();
        this.f507g = c13537d;
        c13537d.f9573g = this.f506f;
        c13537d.f9572f = SamsungAccountUtil.getApplicationRegion();
        Debugger.m8615i("ServerConsentSendDecision", "getFullUrl() : " + ((Object) sb));
        return sb.toString();
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: e */
    public final String mo423e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("applicationRegion", this.f507g.f9572f);
            jSONObject.put(IdentityApiContract.Parameter.MODEL_NAME, Build.MODEL.replaceFirst("^SAMSUNG-", ""));
            jSONObject.put(IdentityApiContract.Parameter.OS_VERSION, Build.VERSION.RELEASE);
        } catch (JSONException unused) {
            Debugger.m8609e("ServerConsentSendDecision", "getStringBody() : fail to getStringBody");
        }
        return jSONObject.toString();
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: f */
    public final void mo424f() {
        Debugger.m8615i("ServerConsentSendDecision", "handleCancel()");
        this.f511j.onCanceled();
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: g */
    public final void mo425g(int i, String str) {
        Debugger.m8609e("ServerConsentSendDecision", "handleError() : errCode = " + i + ", errMsg = " + str);
        this.f511j.onError(Integer.valueOf(i), str);
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: i */
    public final void mo427i(int i, String str) {
        AbstractC0000a.m0A(i, "handleResponse() : statusCode = ", "ServerConsentSendDecision");
        this.f511j.onSucceed();
    }
}
