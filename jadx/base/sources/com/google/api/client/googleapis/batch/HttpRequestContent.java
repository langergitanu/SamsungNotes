package com.google.api.client.googleapis.batch;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class HttpRequestContent extends AbstractHttpContent {
    static final String NEWLINE = "\r\n";
    private final HttpRequest request;

    public HttpRequestContent(HttpRequest httpRequest) {
        super("application/http");
        this.request = httpRequest;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, getCharset());
        outputStreamWriter.write(this.request.getRequestMethod());
        outputStreamWriter.write(" ");
        outputStreamWriter.write(this.request.getUrl().build());
        outputStreamWriter.write("\r\n");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.fromHttpHeaders(this.request.getHeaders());
        httpHeaders.setAcceptEncoding(null).setUserAgent(null).setContentEncoding(null).setContentType(null).setContentLength(null);
        HttpContent content = this.request.getContent();
        if (content != null) {
            httpHeaders.setContentType(content.getType());
            long length = content.getLength();
            if (length != -1) {
                httpHeaders.setContentLength(Long.valueOf(length));
            }
        }
        HttpHeaders.serializeHeadersForMultipartRequests(httpHeaders, null, null, outputStreamWriter);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
        if (content != null) {
            content.writeTo(outputStream);
        }
    }
}
