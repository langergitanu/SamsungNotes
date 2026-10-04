package com.google.api.client.http;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequestFactory {
    private final HttpRequestInitializer initializer;
    private final HttpTransport transport;

    public HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.transport = httpTransport;
        this.initializer = httpRequestInitializer;
    }

    public HttpRequest buildDeleteRequest(GenericUrl genericUrl) {
        return buildRequest("DELETE", genericUrl, null);
    }

    public HttpRequest buildGetRequest(GenericUrl genericUrl) {
        return buildRequest("GET", genericUrl, null);
    }

    public HttpRequest buildHeadRequest(GenericUrl genericUrl) {
        return buildRequest("HEAD", genericUrl, null);
    }

    public HttpRequest buildPatchRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest("PATCH", genericUrl, httpContent);
    }

    public HttpRequest buildPostRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest("POST", genericUrl, httpContent);
    }

    public HttpRequest buildPutRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest("PUT", genericUrl, httpContent);
    }

    public HttpRequest buildRequest(String str, GenericUrl genericUrl, HttpContent httpContent) {
        HttpRequest httpRequestBuildRequest = this.transport.buildRequest();
        HttpRequestInitializer httpRequestInitializer = this.initializer;
        if (httpRequestInitializer != null) {
            httpRequestInitializer.initialize(httpRequestBuildRequest);
        }
        httpRequestBuildRequest.setRequestMethod(str);
        if (genericUrl != null) {
            httpRequestBuildRequest.setUrl(genericUrl);
        }
        if (httpContent != null) {
            httpRequestBuildRequest.setContent(httpContent);
        }
        return httpRequestBuildRequest;
    }

    public HttpRequestInitializer getInitializer() {
        return this.initializer;
    }

    public HttpTransport getTransport() {
        return this.transport;
    }
}
