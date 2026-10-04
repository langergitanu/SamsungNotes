package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class EmptyContent implements HttpContent {
    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return 0L;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return null;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }
}
