package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class HttpClients {
    private HttpClients() {
    }

    public static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }

    public static CloseableHttpClient createMinimal() {
        return new MinimalHttpClient(new PoolingHttpClientConnectionManager());
    }

    public static CloseableHttpClient createSystem() {
        return HttpClientBuilder.create().useSystemProperties().build();
    }

    public static HttpClientBuilder custom() {
        return HttpClientBuilder.create();
    }

    public static CloseableHttpClient createMinimal(HttpClientConnectionManager httpClientConnectionManager) {
        return new MinimalHttpClient(httpClientConnectionManager);
    }
}
