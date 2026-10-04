package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CachingHttpClients {
    private CachingHttpClients() {
    }

    public static CloseableHttpClient createFileBound(File file) {
        return CachingHttpClientBuilder.create().setCacheDir(file).build();
    }

    public static CloseableHttpClient createMemoryBound() {
        return CachingHttpClientBuilder.create().build();
    }

    public static CachingHttpClientBuilder custom() {
        return CachingHttpClientBuilder.create();
    }
}
