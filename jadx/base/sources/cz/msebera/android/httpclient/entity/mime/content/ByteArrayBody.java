package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    @Deprecated
    public ByteArrayBody(byte[] bArr, String str, String str2) {
        this(bArr, ContentType.create(str), str2);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody, cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.data.length;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public ByteArrayBody(byte[] bArr, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(bArr, "byte[]");
        this.data = bArr;
        this.filename = str;
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }
}
