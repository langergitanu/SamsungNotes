package com.samsung.android.sdk.smp.marketing.customcontent;

import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import com.samsung.android.sdk.smp.marketing.customcontent.entity.CustomContentEntity;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CustomContentRequest extends NetworkJSonRequest {
    private final CustomContentEntity entity;

    public CustomContentRequest(CustomContentEntity customContentEntity) {
        this.entity = customContentEntity;
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
        Uri baseUrlWithoutCommonPostUri = NetworkRequest.getBaseUrlWithoutCommonPostUri(context);
        if (baseUrlWithoutCommonPostUri == null) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = baseUrlWithoutCommonPostUri.buildUpon().appendPath(this.entity.path.substring(1)).appendQueryParameter("mid", this.entity.mid).appendQueryParameter("uid", this.entity.uid);
        for (Map.Entry<String, String> entry : this.entity.getRequestQueries().entrySet()) {
            builderAppendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderAppendQueryParameter.toString();
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return false;
    }
}
