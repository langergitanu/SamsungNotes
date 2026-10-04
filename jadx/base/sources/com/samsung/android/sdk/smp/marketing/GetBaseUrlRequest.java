package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GetBaseUrlRequest extends NetworkJSonRequest {
    private final String mDcc;

    public GetBaseUrlRequest(String str) {
        this.mDcc = str;
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
        return getBDomain(context).buildUpon().appendQueryParameter("dcc", this.mDcc).toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
