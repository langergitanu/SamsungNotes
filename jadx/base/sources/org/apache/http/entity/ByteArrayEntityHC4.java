package org.apache.http.entity;

import androidx.collection.AbstractC0622a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class ByteArrayEntityHC4 extends AbstractHttpEntityHC4 implements Cloneable {

    /* JADX INFO: renamed from: b */
    private final byte[] f10015b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntityHC4(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f10015b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public Object clone() {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f10015b, this.off, this.len);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.f10015b, this.off, this.len);
        outputStream.flush();
    }

    public ByteArrayEntityHC4(byte[] bArr, int i, int i2, ContentType contentType) {
        int i4;
        Args.notNull(bArr, "Source byte array");
        if (i >= 0 && i <= bArr.length && i2 >= 0 && (i4 = i + i2) >= 0 && i4 <= bArr.length) {
            this.content = bArr;
            this.f10015b = bArr;
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

    public ByteArrayEntityHC4(byte[] bArr) {
        this(bArr, null);
    }

    public ByteArrayEntityHC4(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }
}
