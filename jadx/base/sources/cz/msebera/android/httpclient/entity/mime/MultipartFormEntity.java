package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.ContentTooLongException;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final cz.msebera.android.httpclient.Header contentType;
    private final AbstractMultipartForm multipart;

    public MultipartFormEntity(AbstractMultipartForm abstractMultipartForm, ContentType contentType, long j) {
        this.multipart = abstractMultipartForm;
        this.contentType = new BasicHeader("Content-Type", contentType.toString());
        this.contentLength = j;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() {
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        long j = this.contentLength;
        if (j < 0) {
            throw new ContentTooLongException("Content length is unknown");
        }
        if (j > 25600) {
            throw new ContentTooLongException("Content length is too long: " + this.contentLength);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentType() {
        return this.contentType;
    }

    public AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return this.contentLength != -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.multipart.writeTo(outputStream);
    }
}
