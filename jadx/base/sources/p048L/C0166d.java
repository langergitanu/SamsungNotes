package p048L;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import com.samsung.android.support.senl.p145cm.base.region.RegionUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SamsungAccountUtil;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p207n1.C13537d;

/* JADX INFO: renamed from: L.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0166d extends AbstractC0165c {

    /* JADX INFO: renamed from: h */
    public ServerConsentListener f508h;

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: d */
    public final String mo422d() {
        StringBuilder sb = new StringBuilder();
        if (SyncState.isCmsTest()) {
            sb.append("https://apis.samsungconsentdev.com");
        } else {
            sb.append(RegionUtils.getConsentServerURL());
        }
        sb.append("/v1/consent/status/latest");
        C13537d c13537d = new C13537d();
        this.f507g = c13537d;
        c13537d.f9573g = this.f506f;
        c13537d.f9572f = SamsungAccountUtil.getApplicationRegion();
        C13537d c13537d2 = this.f507g;
        String str = ((Object) sb) + "?appKey=" + c13537d2.f9568b + "&applicationRegion=" + c13537d2.f9572f + "&type=FTU_AI";
        Debugger.m8615i("ServerConsentRequest", "getFullUrl() : " + Debugger.getEncode(str));
        return str;
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: e */
    public final String mo423e() {
        return null;
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: f */
    public final void mo424f() {
        Debugger.m8615i("ServerConsentRequest", "handleCancel()");
        this.f508h.onCanceled();
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: g */
    public final void mo425g(int i, String str) {
        Debugger.m8609e("ServerConsentRequest", "handleError() : errCode = " + i + ", errMsg = " + str);
        this.f508h.onError(Integer.valueOf(i), str);
    }

    @Override // p048L.AbstractC0163a
    /* JADX INFO: renamed from: i */
    public final void mo427i(int i, String str) {
        Debugger.m8615i("ServerConsentRequest", "handleResponse() : statusCode = " + i + ", responseBody = " + str);
        if (i != 200) {
            if (i == 204) {
                this.f508h.onReceived(false);
                return;
            } else {
                mo425g(1, "Invalid statusCode!");
                return;
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            boolean z = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("consentId");
                String string2 = jSONObject.getString("status");
                String string3 = jSONObject.getString(BuddyContract.Address.REGION);
                String applicationRegion = SamsungAccountUtil.getApplicationRegion();
                if (SyncState.isCmsTest()) {
                    if ("40557".equals(string) && applicationRegion.equals(string3) && ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equals(string2)) {
                        z = true;
                    }
                } else if ("3379".equals(string) && applicationRegion.equals(string3) && ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equals(string2)) {
                    z = true;
                }
            }
            this.f508h.onReceived(z);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("handleResponse() : e = "), "ServerConsentRequest");
            mo425g(1, "Exception occurred!");
        }
    }
}
