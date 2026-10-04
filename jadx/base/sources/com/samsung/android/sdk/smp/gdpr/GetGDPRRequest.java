package com.samsung.android.sdk.smp.gdpr;

import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class GetGDPRRequest extends NetworkJSonRequest {
    private final String mAppId;
    private final String mGdprRequestId;
    private final String mSmpId;
    private final String mUid;

    public GetGDPRRequest(String str, String str2, String str3, String str4) {
        this.mAppId = str;
        this.mGdprRequestId = str2;
        this.mSmpId = str3;
        this.mUid = str4;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 0;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrl = NetworkRequest.getBaseUrl(context);
        if (baseUrl == null) {
            return null;
        }
        return baseUrl.buildUpon().appendPath(this.mAppId).appendPath(NetworkConfig.PATH_GDPRS).appendPath(this.mGdprRequestId).appendQueryParameter("smpid", this.mSmpId).appendQueryParameter("guid", this.mUid).toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
