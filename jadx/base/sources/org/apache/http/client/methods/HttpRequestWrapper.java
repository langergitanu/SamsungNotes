package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
            super(httpEntityEnclosingRequest, null);
            this.entity = httpEntityEnclosingRequest.getEntity();
        }

        @Override // org.apache.http.HttpEntityEnclosingRequest
        public boolean expectContinue() {
            Header firstHeader = getFirstHeader("Expect");
            return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
        }

        @Override // org.apache.http.HttpEntityEnclosingRequest
        public HttpEntity getEntity() {
            return this.entity;
        }

        @Override // org.apache.http.HttpEntityEnclosingRequest
        public void setEntity(HttpEntity httpEntity) {
            this.entity = httpEntity;
        }
    }

    public /* synthetic */ HttpRequestWrapper(HttpRequest httpRequest, HttpRequestWrapper httpRequestWrapper) {
        this(httpRequest);
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return null;
        }
        return httpRequest instanceof HttpEntityEnclosingRequest ? new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest) : new HttpRequestWrapper(httpRequest);
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public void abort() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    @Override // org.apache.http.message.AbstractHttpMessage, org.apache.http.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (((AbstractHttpMessage) this).params == null) {
            ((AbstractHttpMessage) this).params = this.original.getParams().copy();
        }
        return ((AbstractHttpMessage) this).params;
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : this.original.getProtocolVersion();
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        URI uri = this.uri;
        String aSCIIString = uri != null ? uri.toASCIIString() : this.original.getRequestLine().getUri();
        if (aSCIIString == null || aSCIIString.length() == 0) {
            aSCIIString = "/";
        }
        return new BasicRequestLine(this.method, aSCIIString, getProtocolVersion());
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        return false;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public String toString() {
        return getRequestLine() + " " + ((AbstractHttpMessage) this).headergroup;
    }

    private HttpRequestWrapper(HttpRequest httpRequest) {
        this.original = httpRequest;
        this.version = httpRequest.getRequestLine().getProtocolVersion();
        this.method = httpRequest.getRequestLine().getMethod();
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.uri = null;
        }
        setHeaders(httpRequest.getAllHeaders());
    }
}
