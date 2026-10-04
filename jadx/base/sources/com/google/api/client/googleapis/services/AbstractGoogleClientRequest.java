package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final AbstractGoogleClient abstractGoogleClient;
    private boolean disableGZipContent;
    private MediaHttpDownloader downloader;
    private final HttpContent httpContent;
    private HttpHeaders lastResponseHeaders;
    private String lastStatusMessage;
    private final String requestMethod;
    private Class<T> responseClass;
    private MediaHttpUploader uploader;
    private final String uriTemplate;
    private HttpHeaders requestHeaders = new HttpHeaders();
    private int lastStatusCode = -1;

    public AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        this.responseClass = (Class) Preconditions.checkNotNull(cls);
        this.abstractGoogleClient = (AbstractGoogleClient) Preconditions.checkNotNull(abstractGoogleClient);
        this.requestMethod = (String) Preconditions.checkNotNull(str);
        this.uriTemplate = (String) Preconditions.checkNotNull(str2);
        this.httpContent = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            this.requestHeaders.setUserAgent(applicationName.concat(" Google-API-Java-Client"));
        } else {
            this.requestHeaders.setUserAgent(USER_AGENT_SUFFIX);
        }
    }

    public HttpRequest buildHttpRequest() {
        return buildHttpRequest(false);
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.expand(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, this, true));
    }

    public HttpRequest buildHttpRequestUsingHead() {
        return buildHttpRequest(true);
    }

    public final void checkRequiredParameter(Object obj, String str) {
        Preconditions.checkArgument(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }

    public T execute() {
        return (T) executeUnparsed().parseAs((Class) this.responseClass);
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().download(outputStream);
    }

    public InputStream executeAsInputStream() {
        return executeUnparsed().getContent();
    }

    public HttpResponse executeMedia() {
        set("alt", (Object) "media");
        return executeUnparsed();
    }

    public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
        MediaHttpDownloader mediaHttpDownloader = this.downloader;
        if (mediaHttpDownloader == null) {
            executeMedia().download(outputStream);
        } else {
            mediaHttpDownloader.download(buildHttpRequestUrl(), this.requestHeaders, outputStream);
        }
    }

    public InputStream executeMediaAsInputStream() {
        return executeMedia().getContent();
    }

    public HttpResponse executeUnparsed() {
        return executeUnparsed(false);
    }

    public HttpResponse executeUsingHead() throws IOException {
        Preconditions.checkArgument(this.uploader == null);
        HttpResponse httpResponseExecuteUnparsed = executeUnparsed(true);
        httpResponseExecuteUnparsed.ignore();
        return httpResponseExecuteUnparsed;
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.abstractGoogleClient;
    }

    public final boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public final HttpContent getHttpContent() {
        return this.httpContent;
    }

    public final HttpHeaders getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final int getLastStatusCode() {
        return this.lastStatusCode;
    }

    public final String getLastStatusMessage() {
        return this.lastStatusMessage;
    }

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.downloader;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.uploader;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    public final void initializeMediaDownload() {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.downloader = new MediaHttpDownloader(requestFactory.getTransport(), requestFactory.getInitializer());
    }

    public final void initializeMediaUpload(AbstractInputStreamContent abstractInputStreamContent) {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        MediaHttpUploader mediaHttpUploader = new MediaHttpUploader(abstractInputStreamContent, requestFactory.getTransport(), requestFactory.getInitializer());
        this.uploader = mediaHttpUploader;
        mediaHttpUploader.setInitiationRequestMethod(this.requestMethod);
        HttpContent httpContent = this.httpContent;
        if (httpContent != null) {
            this.uploader.setMetadata(httpContent);
        }
    }

    public IOException newExceptionOnError(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) {
        Preconditions.checkArgument(this.uploader == null, "Batching media requests is not supported");
        batchRequest.queue(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.requestHeaders = httpHeaders;
        return this;
    }

    private HttpRequest buildHttpRequest(boolean z) {
        Preconditions.checkArgument(this.uploader == null);
        Preconditions.checkArgument(!z || this.requestMethod.equals("GET"));
        final HttpRequest httpRequestBuildRequest = getAbstractGoogleClient().getRequestFactory().buildRequest(z ? "HEAD" : this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new MethodOverride().intercept(httpRequestBuildRequest);
        httpRequestBuildRequest.setParser(getAbstractGoogleClient().getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
            httpRequestBuildRequest.setContent(new EmptyContent());
        }
        httpRequestBuildRequest.getHeaders().putAll(this.requestHeaders);
        if (!this.disableGZipContent) {
            httpRequestBuildRequest.setEncoding(new GZipEncoding());
        }
        final HttpResponseInterceptor responseInterceptor = httpRequestBuildRequest.getResponseInterceptor();
        httpRequestBuildRequest.setResponseInterceptor(new HttpResponseInterceptor() { // from class: com.google.api.client.googleapis.services.AbstractGoogleClientRequest.1
            @Override // com.google.api.client.http.HttpResponseInterceptor
            public void interceptResponse(HttpResponse httpResponse) throws IOException {
                HttpResponseInterceptor httpResponseInterceptor = responseInterceptor;
                if (httpResponseInterceptor != null) {
                    httpResponseInterceptor.interceptResponse(httpResponse);
                }
                if (!httpResponse.isSuccessStatusCode() && httpRequestBuildRequest.getThrowExceptionOnExecuteError()) {
                    throw AbstractGoogleClientRequest.this.newExceptionOnError(httpResponse);
                }
            }
        });
        return httpRequestBuildRequest;
    }

    private HttpResponse executeUnparsed(boolean z) throws IOException {
        HttpResponse httpResponseUpload;
        if (this.uploader == null) {
            httpResponseUpload = buildHttpRequest(z).execute();
        } else {
            GenericUrl genericUrlBuildHttpRequestUrl = buildHttpRequestUrl();
            boolean throwExceptionOnExecuteError = getAbstractGoogleClient().getRequestFactory().buildRequest(this.requestMethod, genericUrlBuildHttpRequestUrl, this.httpContent).getThrowExceptionOnExecuteError();
            httpResponseUpload = this.uploader.setInitiationHeaders(this.requestHeaders).setDisableGZipContent(this.disableGZipContent).upload(genericUrlBuildHttpRequestUrl);
            httpResponseUpload.getRequest().setParser(getAbstractGoogleClient().getObjectParser());
            if (throwExceptionOnExecuteError && !httpResponseUpload.isSuccessStatusCode()) {
                throw newExceptionOnError(httpResponseUpload);
            }
        }
        this.lastResponseHeaders = httpResponseUpload.getHeaders();
        this.lastStatusCode = httpResponseUpload.getStatusCode();
        this.lastStatusMessage = httpResponseUpload.getStatusMessage();
        return httpResponseUpload;
    }

    @Override // com.google.api.client.util.GenericData
    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleClientRequest) super.set(str, obj);
    }
}
