package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializationException;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class DefaultHttpCacheEntrySerializer implements HttpCacheEntrySerializer {
    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public HttpCacheEntry readFrom(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            try {
                return (HttpCacheEntry) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                throw new HttpCacheEntrySerializationException("Class not found: " + e.getMessage(), e);
            }
        } finally {
            objectInputStream.close();
        }
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public void writeTo(HttpCacheEntry httpCacheEntry, OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        try {
            objectOutputStream.writeObject(httpCacheEntry);
        } finally {
            objectOutputStream.close();
        }
    }
}
