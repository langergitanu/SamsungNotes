package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface HttpContent extends StreamingContent {
    long getLength();

    String getType();

    boolean retrySupported();

    @Override // com.google.api.client.util.StreamingContent
    void writeTo(OutputStream outputStream);
}
