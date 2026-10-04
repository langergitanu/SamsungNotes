package com.google.api.client.http;

import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpTransport {
    static final Logger LOGGER = Logger.getLogger(HttpTransport.class.getName());
    private static final String[] SUPPORTED_METHODS;

    static {
        String[] strArr = {"DELETE", "GET", "POST", "PUT"};
        SUPPORTED_METHODS = strArr;
        Arrays.sort(strArr);
    }

    public HttpRequest buildRequest() {
        return new HttpRequest(this, null);
    }

    public abstract LowLevelHttpRequest buildRequest(String str, String str2);

    public final HttpRequestFactory createRequestFactory() {
        return createRequestFactory(null);
    }

    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(SUPPORTED_METHODS, str) >= 0;
    }

    public final HttpRequestFactory createRequestFactory(HttpRequestInitializer httpRequestInitializer) {
        return new HttpRequestFactory(this, httpRequestInitializer);
    }

    public void shutdown() {
    }
}
