package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class ApacheHttpRequest extends LowLevelHttpRequest {
    private final HttpClient httpClient;
    private final HttpRequestBase request;

    public ApacheHttpRequest(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.httpClient = httpClient;
        this.request = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        this.request.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() {
        if (getStreamingContent() != null) {
            HttpRequestBase httpRequestBase = this.request;
            Preconditions.checkArgument(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            ContentEntity contentEntity = new ContentEntity(getContentLength(), getStreamingContent());
            contentEntity.setContentEncoding(getContentEncoding());
            contentEntity.setContentType(getContentType());
            ((HttpEntityEnclosingRequest) this.request).setEntity(contentEntity);
        }
        HttpRequestBase httpRequestBase2 = this.request;
        return new ApacheHttpResponse(httpRequestBase2, this.httpClient.execute(httpRequestBase2));
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void setTimeout(int i, int i2) {
        HttpParams params = this.request.getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i2);
    }
}
