package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class DeleteRequest extends NetworkJSonRequest {
    private final String mAppId;
    private final String mSmpId;
    private final String mTestDeviceName;
    private final String mUid;

    public DeleteRequest(String str, String str2, String str3, String str4) {
        this.mAppId = str;
        this.mSmpId = str2;
        this.mUid = str3;
        this.mTestDeviceName = str4;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 3;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrl = NetworkRequest.getBaseUrl(context);
        if (baseUrl == null) {
            return null;
        }
        Uri.Builder builderAppendPath = baseUrl.buildUpon().appendPath(this.mAppId);
        builderAppendPath.appendPath(NetworkConfig.PATH_CLIENTS).appendPath(this.mSmpId);
        if (!TextUtils.isEmpty(this.mTestDeviceName)) {
            builderAppendPath.appendQueryParameter("deviceName", this.mTestDeviceName);
        }
        return builderAppendPath.toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
