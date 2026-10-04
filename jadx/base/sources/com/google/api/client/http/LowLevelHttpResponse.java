package com.google.api.client.http;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class LowLevelHttpResponse {
    public abstract InputStream getContent();

    public abstract String getContentEncoding();

    public abstract long getContentLength();

    public abstract String getContentType();

    public abstract int getHeaderCount();

    public abstract String getHeaderName(int i);

    public abstract String getHeaderValue(int i);

    public abstract String getReasonPhrase();

    public abstract int getStatusCode();

    public abstract String getStatusLine();

    public void disconnect() {
    }
}
