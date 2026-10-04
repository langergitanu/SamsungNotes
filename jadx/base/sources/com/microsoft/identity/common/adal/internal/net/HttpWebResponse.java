package com.microsoft.identity.common.adal.internal.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HttpWebResponse {
    private final String mResponseBody;
    private final Map<String, List<String>> mResponseHeaders;
    private final int mStatusCode;

    public HttpWebResponse(int i, String str, Map<String, List<String>> map) {
        this.mStatusCode = i;
        this.mResponseBody = str;
        this.mResponseHeaders = map;
    }

    public String getBody() {
        return this.mResponseBody;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
