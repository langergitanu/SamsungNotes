package org.apache.http.entity.mime;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.ContentBody;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final MultipartEntityBuilder builder;
    private volatile MultipartFormEntity entity;

    public MultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        this.builder = new MultipartEntityBuilder().setMode(httpMultipartMode).setCharset(charset).setBoundary(str);
        this.entity = null;
    }

    private MultipartFormEntity getEntity() {
        if (this.entity == null) {
            this.entity = this.builder.buildEntity();
        }
        return this.entity;
    }

    public void addPart(FormBodyPart formBodyPart) {
        this.builder.addPart(formBodyPart);
        this.entity = null;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int iNextInt = random.nextInt(11) + 30;
        for (int i = 0; i < iNextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public String generateContentType(String str, Charset charset) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j("multipart/form-data; boundary=", str);
        if (charset != null) {
            sbM12325j.append(HTTP.CHARSET_PARAM);
            sbM12325j.append(charset.name());
        }
        return sbM12325j.toString();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    @Override // org.apache.http.HttpEntity
    public org.apache.http.Header getContentEncoding() {
        return getEntity().getContentEncoding();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return getEntity().getContentLength();
    }

    @Override // org.apache.http.HttpEntity
    public org.apache.http.Header getContentType() {
        return getEntity().getContentType();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return getEntity().isChunked();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return getEntity().isRepeatable();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return getEntity().isStreaming();
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        getEntity().writeTo(outputStream);
    }

    public void addPart(String str, ContentBody contentBody) {
        addPart(new FormBodyPart(str, contentBody));
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode) {
        this(httpMultipartMode, null, null);
    }

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }
}
