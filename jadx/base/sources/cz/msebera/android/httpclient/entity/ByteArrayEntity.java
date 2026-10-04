package cz.msebera.android.httpclient.entity;

import androidx.collection.AbstractC0622a;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* JADX INFO: renamed from: b */
    private final byte[] f8488b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f8488b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public Object clone() {
        return super.clone();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f8488b, this.off, this.len);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.f8488b, this.off, this.len);
        outputStream.flush();
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType) {
        int i4;
        Args.notNull(bArr, "Source byte array");
        if (i >= 0 && i <= bArr.length && i2 >= 0 && (i4 = i + i2) >= 0 && i4 <= bArr.length) {
            this.content = bArr;
            this.f8488b = bArr;
            this.off = i;
            this.len = i2;
            if (contentType != null) {
                setContentType(contentType.toString());
                return;
            }
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "off: ", " len: ", " b.length: ");
        sbM1173s.append(bArr.length);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, null);
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }
}
