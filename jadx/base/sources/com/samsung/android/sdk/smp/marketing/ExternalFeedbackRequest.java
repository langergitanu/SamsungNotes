package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ExternalFeedbackRequest extends NetworkJSonRequest {
    private final String mUrl;

    public ExternalFeedbackRequest(String str) {
        this.mUrl = str;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 1;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrlWithoutCommonPostUri = NetworkRequest.getBaseUrlWithoutCommonPostUri(context);
        if (baseUrlWithoutCommonPostUri == null) {
            return null;
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(baseUrlWithoutCommonPostUri.buildUpon().toString());
        sbM1324q.append(this.mUrl);
        return sbM1324q.toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
