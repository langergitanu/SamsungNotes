package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class LowLevelHttpRequest {
    private String contentEncoding;
    private long contentLength = -1;
    private String contentType;
    private StreamingContent streamingContent;

    public abstract void addHeader(String str, String str2);

    public abstract LowLevelHttpResponse execute();

    public final String getContentEncoding() {
        return this.contentEncoding;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final StreamingContent getStreamingContent() {
        return this.streamingContent;
    }

    public final void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public final void setContentLength(long j) {
        this.contentLength = j;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setStreamingContent(StreamingContent streamingContent) {
        this.streamingContent = streamingContent;
    }

    public void setTimeout(int i, int i2) {
    }
}
