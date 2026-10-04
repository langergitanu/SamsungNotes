package com.samsung.android.sdk.smp.gdpr;

import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class PostGDPRRequest extends NetworkJSonRequest {
    private final String mAppId;
    private final String mRequestId;
    private final String mSmpId;
    private final String mUid;

    public PostGDPRRequest(String str, String str2, String str3, String str4) {
        this.mAppId = str;
        this.mRequestId = str2;
        this.mSmpId = str3;
        this.mUid = str4;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() throws InternalException.InvalidDataException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("smpid", this.mSmpId);
            jSONObject.put("guid", this.mUid);
            return jSONObject;
        } catch (JSONException unused) {
            throw new InternalException.InvalidDataException();
        }
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 1;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrl = NetworkRequest.getBaseUrl(context);
        if (baseUrl == null) {
            return null;
        }
        return baseUrl.buildUpon().appendPath(this.mAppId).appendPath(NetworkConfig.PATH_GDPRS).appendPath(this.mRequestId).toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
