package cz.msebera.android.httpclient.client.cache;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HttpCacheEntrySerializer {
    HttpCacheEntry readFrom(InputStream inputStream);

    void writeTo(HttpCacheEntry httpCacheEntry, OutputStream outputStream);
}
