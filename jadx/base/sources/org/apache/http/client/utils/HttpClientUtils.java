package org.apache.http.client.utils;

import java.io.Closeable;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HttpClientUtils {
    private HttpClientUtils() {
    }

    public static void closeQuietly(HttpResponse httpResponse) {
        HttpEntity entity;
        if (httpResponse == null || (entity = httpResponse.getEntity()) == null) {
            return;
        }
        try {
            EntityUtilsHC4.consume(entity);
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(CloseableHttpResponse closeableHttpResponse) {
        try {
            if (closeableHttpResponse != null) {
                try {
                    EntityUtilsHC4.consume(closeableHttpResponse.getEntity());
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
