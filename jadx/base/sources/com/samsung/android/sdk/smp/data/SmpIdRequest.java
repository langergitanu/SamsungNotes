package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SmpIdRequest extends NetworkJSonRequest {
    private final String appId;
    private final String did;
    private final String smpId;

    public SmpIdRequest(String str, String str2, String str3) {
        this.appId = str;
        this.did = str2;
        this.smpId = str3;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() throws InternalException.InvalidDataException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.did)) {
                jSONObject.put(NetworkConfig.SMPID_DID, this.did);
            }
            if (!TextUtils.isEmpty(this.smpId)) {
                jSONObject.put("smpid", this.smpId);
            }
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
        return baseUrl.buildUpon().appendPath(this.appId).appendPath("smpid").appendPath(NetworkConfig.PATH_SMPID_2).toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
