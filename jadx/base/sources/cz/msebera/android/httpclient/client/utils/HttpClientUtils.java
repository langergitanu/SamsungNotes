package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HttpClientUtils {
    private HttpClientUtils() {
    }

    public static void closeQuietly(HttpResponse httpResponse) {
        HttpEntity entity;
        if (httpResponse == null || (entity = httpResponse.getEntity()) == null) {
            return;
        }
        try {
            EntityUtils.consume(entity);
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(CloseableHttpResponse closeableHttpResponse) {
        try {
            if (closeableHttpResponse != null) {
                try {
                    EntityUtils.consume(closeableHttpResponse.getEntity());
                } finally {
                    closeableHttpResponse.close();
                }
            }
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(HttpClient httpClient) {
        if (httpClient == null || !(httpClient instanceof Closeable)) {
            return;
        }
        try {
            ((Closeable) httpClient).close();
        } catch (IOException unused) {
        }
    }
}
