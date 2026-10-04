package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class HeapResource implements Resource {
    private static final long serialVersionUID = -2078599905620463394L;

    /* JADX INFO: renamed from: b */
    private final byte[] f8498b;

    public HeapResource(byte[] bArr) {
        this.f8498b = bArr;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public void dispose() {
    }

    public byte[] getByteArray() {
        return this.f8498b;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f8498b);
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public long length() {
        return this.f8498b.length;
    }
}
