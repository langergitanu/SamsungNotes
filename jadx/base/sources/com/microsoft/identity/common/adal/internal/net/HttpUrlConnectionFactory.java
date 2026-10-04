package com.microsoft.identity.common.adal.internal.net;

import androidx.annotation.VisibleForTesting;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class HttpUrlConnectionFactory {
    private static HttpURLConnection sMockedConnection;
    private static URL sMockedConnectionOpenUrl;

    private HttpUrlConnectionFactory() {
    }

    public static HttpURLConnection createHttpUrlConnection(URL url) {
        HttpURLConnection httpURLConnection = sMockedConnection;
        if (httpURLConnection == null) {
            return (HttpURLConnection) url.openConnection();
        }
        sMockedConnectionOpenUrl = url;
        return httpURLConnection;
    }

    @VisibleForTesting
    public static URL getMockedConnectionOpenUrl() {
        return sMockedConnectionOpenUrl;
    }

    public static void setMockedHttpUrlConnection(HttpURLConnection httpURLConnection) {
        sMockedConnection = httpURLConnection;
        if (httpURLConnection == null) {
            sMockedConnectionOpenUrl = null;
        }
    }
}
