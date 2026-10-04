package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
class RequestEntityProxy implements HttpEntity {
    private boolean consumed = false;
    private final HttpEntity original;

    public RequestEntityProxy(HttpEntity httpEntity) {
        this.original = httpEntity;
    }

    public static void enhance(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null || entity.isRepeatable() || isEnhanced(entity)) {
            return;
        }
        httpEntityEnclosingRequest.setEntity(new RequestEntityProxy(entity));
    }

    public static boolean isEnhanced(HttpEntity httpEntity) {
        return httpEntity instanceof RequestEntityProxy;
    }

    public static boolean isRepeatable(HttpRequest httpRequest) {
        HttpEntity entity;
        if (!(httpRequest instanceof HttpEntityEnclosingRequest) || (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) == null) {
            return true;
        }
        if (!isEnhanced(entity) || ((RequestEntityProxy) entity).isConsumed()) {
            return entity.isRepeatable();
        }
        return true;
    }

    @Override // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
        this.consumed = true;
        this.original.consumeContent();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return this.original.getContent();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.original.getContentEncoding();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.original.getContentLength();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.original.getContentType();
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.original.isChunked();
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.original.isStreaming();
    }

    public String toString() {
        return "RequestEntityProxy{" + this.original + '}';
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.consumed = true;
        this.original.writeTo(outputStream);
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.original.isRepeatable();
    }
}
