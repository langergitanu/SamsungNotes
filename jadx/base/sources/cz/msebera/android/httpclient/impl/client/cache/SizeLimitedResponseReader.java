package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class SizeLimitedResponseReader {
    private boolean consumed;
    private InputStream inStream;
    private InputLimit limit;
    private final long maxResponseSizeBytes;
    private final HttpRequest request;
    private Resource resource;
    private final ResourceFactory resourceFactory;
    private final CloseableHttpResponse response;

    public SizeLimitedResponseReader(ResourceFactory resourceFactory, long j, HttpRequest httpRequest, CloseableHttpResponse closeableHttpResponse) {
        this.resourceFactory = resourceFactory;
        this.maxResponseSizeBytes = j;
        this.request = httpRequest;
        this.response = closeableHttpResponse;
    }

    private void doConsume() throws IOException {
        ensureNotConsumed();
        this.consumed = true;
        this.limit = new InputLimit(this.maxResponseSizeBytes);
        HttpEntity entity = this.response.getEntity();
        if (entity == null) {
            return;
        }
        String uri = this.request.getRequestLine().getUri();
        InputStream content = entity.getContent();
        this.inStream = content;
        try {
            this.resource = this.resourceFactory.generate(uri, content, this.limit);
        } finally {
            if (!this.limit.isReached()) {
                this.inStream.close();
            }
        }
    }

    private void ensureConsumed() {
        if (!this.consumed) {
            throw new IllegalStateException("Response has not been consumed");
        }
    }

    private void ensureNotConsumed() {
        if (this.consumed) {
            throw new IllegalStateException("Response has already been consumed");
        }
    }

    public CloseableHttpResponse getReconstructedResponse() {
        ensureConsumed();
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(this.response.getStatusLine());
        basicHttpResponse.setHeaders(this.response.getAllHeaders());
        CombinedEntity combinedEntity = new CombinedEntity(this.resource, this.inStream);
        HttpEntity entity = this.response.getEntity();
        if (entity != null) {
            combinedEntity.setContentType(entity.getContentType());
            combinedEntity.setContentEncoding(entity.getContentEncoding());
            combinedEntity.setChunked(entity.isChunked());
        }
        basicHttpResponse.setEntity(combinedEntity);
        return (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new ResponseProxyHandler(basicHttpResponse) { // from class: cz.msebera.android.httpclient.impl.client.cache.SizeLimitedResponseReader.1
            @Override // cz.msebera.android.httpclient.impl.client.cache.ResponseProxyHandler
            public void close() throws IOException {
                SizeLimitedResponseReader.this.response.close();
            }
        });
    }

    public Resource getResource() {
        ensureConsumed();
        return this.resource;
    }

    public boolean isLimitReached() {
        ensureConsumed();
        return this.limit.isReached();
    }

    public void readResponse() throws IOException {
        if (this.consumed) {
            return;
        }
        doConsume();
    }
}
