package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.interfaces.IHttpClientWrapper;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultHttpClientWrapper implements IHttpClientWrapper {
    @Override // com.microsoft.identity.common.java.interfaces.IHttpClientWrapper
    @NonNull
    public HttpClient wrap(@NonNull HttpClient httpClient) {
        if (httpClient != null) {
            return httpClient;
        }
        throw new NullPointerException("client is marked non-null but is null");
    }
}
