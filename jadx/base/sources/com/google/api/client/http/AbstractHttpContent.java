package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHttpContent implements HttpContent {
    private long computedLength;
    private HttpMediaType mediaType;

    public AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    public long computeLength() {
        return computeLength(this);
    }

    public final Charset getCharset() {
        HttpMediaType httpMediaType = this.mediaType;
        return (httpMediaType == null || httpMediaType.getCharsetParameter() == null) ? Charsets.UTF_8 : this.mediaType.getCharsetParameter();
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        if (this.computedLength == -1) {
            this.computedLength = computeLength();
        }
        return this.computedLength;
    }

    public final HttpMediaType getMediaType() {
        return this.mediaType;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        HttpMediaType httpMediaType = this.mediaType;
        if (httpMediaType == null) {
            return null;
        }
        return httpMediaType.build();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    public AbstractHttpContent setMediaType(HttpMediaType httpMediaType) {
        this.mediaType = httpMediaType;
        return this;
    }

    public AbstractHttpContent(HttpMediaType httpMediaType) {
        this.computedLength = -1L;
        this.mediaType = httpMediaType;
    }

    public static long computeLength(HttpContent httpContent) {
        if (httpContent.retrySupported()) {
            return IOUtils.computeLength(httpContent);
        }
        return -1L;
    }
}
