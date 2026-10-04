package com.samsung.android.sdk.smp.common.network;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class NetworkJSonRequest extends NetworkRequest {
    public abstract JSONObject getJsonRequestBody();

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public final String getRequestBody() {
        JSONObject jsonRequestBody = getJsonRequestBody();
        if (jsonRequestBody == null) {
            return null;
        }
        return jsonRequestBody.toString();
    }

    public abstract boolean isGzipEnabled();
}
