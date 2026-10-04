package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ClientCredentialsTokenRequest extends TokenRequest {
    public ClientCredentialsTokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl) {
        super(httpTransport, jsonFactory, genericUrl, TokenRequest.GrantTypes.CLIENT_CREDENTIALS);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (ClientCredentialsTokenRequest) super.setClientAuthentication(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest setGrantType(String str) {
        return (ClientCredentialsTokenRequest) super.setGrantType(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        return (ClientCredentialsTokenRequest) super.setRequestInitializer(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest setScopes(Collection<String> collection) {
        return (ClientCredentialsTokenRequest) super.setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        return (ClientCredentialsTokenRequest) super.setTokenServerUrl(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public ClientCredentialsTokenRequest set(String str, Object obj) {
        return (ClientCredentialsTokenRequest) super.set(str, obj);
    }
}
