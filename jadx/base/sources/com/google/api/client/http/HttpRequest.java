package com.google.api.client.http;

import androidx.compose.runtime.AbstractC1974b;
import com.google.api.client.util.Beta;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.22.0 (gzip)";
    public static final String VERSION = "1.22.0";

    @Beta
    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;

    @Beta
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = 20000;
    private int readTimeout = 20000;
    private boolean followRedirects = true;
    private boolean throwExceptionOnExecuteError = true;

    @Beta
    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;

    public HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:(1:11)|12|(1:14)|15|(1:20)(1:19)|(21:22|(2:24|(1:26))|29|(1:(1:32)(1:33))|34|(1:36)|37|(1:43)(1:42)|44|(7:46|(1:48)(1:49)|50|(1:52)(3:53|(1:55)(1:56)|57)|(5:59|(2:61|(1:63))(1:64)|(2:66|(1:68))|69|(1:71))(1:72)|(1:74)|75)(1:76)|(2:78|(3:80|(1:82)|83))|(1:87)(1:86)|88|167|89|165|90|91|(3:169|109|(5:111|(1:113)(1:116)|(2:118|(1:(3:126|127|(3:163|129|120)))(1:120))|131|(1:133))(2:(1:138)(1:139)|140))(0)|141|(2:174|(4:144|(1:146)|147|(1:157)(3:161|152|153))(1:158))(1:159))(1:28)|27|29|(0)|34|(0)|37|(2:39|43)(0)|44|(0)(0)|(0)|(1:87)(0)|88|167|89|165|90|91|(0)(0)|141|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
    
        if (r20.retryOnExecuteIOException != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f4, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01f5, code lost:
    
        r7.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r0);
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0279 A[LOOP:0: B:10:0x0021->B:159:0x0279, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse execute() throws IOException {
        StringBuilder sbM1324q;
        StringBuilder sb;
        HttpContent httpContent;
        int i;
        boolean z;
        long j;
        StreamingContent streamingContent;
        HttpResponse httpResponse;
        boolean z2;
        BackOffPolicy backOffPolicy;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        StreamingContent loggingStreamingContent;
        String name;
        long jComputeLength;
        StreamingContent streamingContent2;
        Preconditions.checkArgument(this.numRetries >= 0);
        int i2 = this.numRetries;
        BackOffPolicy backOffPolicy2 = this.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(this.requestMethod);
        Preconditions.checkNotNull(this.url);
        int i4 = i2;
        HttpResponse httpResponse2 = null;
        while (true) {
            if (httpResponse2 != null) {
                httpResponse2.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = this.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(this);
            }
            String strBuild = this.url.build();
            LowLevelHttpRequest lowLevelHttpRequestBuildRequest = this.transport.buildRequest(this.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z3 = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                if (z3) {
                    sbM1324q = AbstractC1974b.m1324q("-------------- REQUEST  --------------");
                    String str = StringUtils.LINE_SEPARATOR;
                    sbM1324q.append(str);
                    sbM1324q.append(this.requestMethod);
                    sbM1324q.append(' ');
                    sbM1324q.append(strBuild);
                    sbM1324q.append(str);
                    if (this.curlLoggingEnabled) {
                        sb = new StringBuilder("curl -v --compressed");
                        if (!this.requestMethod.equals("GET")) {
                            sb.append(" -X ");
                            sb.append(this.requestMethod);
                        }
                    }
                    String userAgent = this.headers.getUserAgent();
                    if (!this.suppressUserAgentSuffix) {
                        if (userAgent == null) {
                            this.headers.setUserAgent(USER_AGENT_SUFFIX);
                        } else {
                            this.headers.setUserAgent(userAgent.concat(" Google-HTTP-Java-Client/1.22.0 (gzip)"));
                        }
                    }
                    HttpHeaders.serializeHeaders(this.headers, sbM1324q, sb, logger, lowLevelHttpRequestBuildRequest);
                    if (!this.suppressUserAgentSuffix) {
                        this.headers.setUserAgent(userAgent);
                    }
                    httpContent = this.content;
                    boolean z4 = httpContent != null || httpContent.retrySupported();
                    if (httpContent == null) {
                        String type = this.content.getType();
                        if (z3) {
                            j = -1;
                            loggingStreamingContent = new LoggingStreamingContent(httpContent, logger, Level.CONFIG, this.contentLoggingLimit);
                        } else {
                            j = -1;
                            loggingStreamingContent = httpContent;
                        }
                        HttpEncoding httpEncoding = this.encoding;
                        if (httpEncoding == null) {
                            jComputeLength = this.content.getLength();
                            name = null;
                            streamingContent2 = loggingStreamingContent;
                        } else {
                            name = httpEncoding.getName();
                            HttpEncodingStreamingContent httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                            jComputeLength = z4 ? IOUtils.computeLength(httpEncodingStreamingContent) : j;
                            streamingContent2 = httpEncodingStreamingContent;
                        }
                        if (z3) {
                            i = i4;
                            if (type != null) {
                                String strConcat = "Content-Type: ".concat(type);
                                sbM1324q.append(strConcat);
                                z = z3;
                                sbM1324q.append(StringUtils.LINE_SEPARATOR);
                                if (sb != null) {
                                    sb.append(" -H '" + strConcat + "'");
                                }
                            } else {
                                z = z3;
                            }
                            if (name != null) {
                                String strConcat2 = "Content-Encoding: ".concat(name);
                                sbM1324q.append(strConcat2);
                                sbM1324q.append(StringUtils.LINE_SEPARATOR);
                                if (sb != null) {
                                    sb.append(" -H '" + strConcat2 + "'");
                                }
                            }
                            if (jComputeLength >= 0) {
                                sbM1324q.append("Content-Length: " + jComputeLength);
                                sbM1324q.append(StringUtils.LINE_SEPARATOR);
                            }
                        } else {
                            i = i4;
                            z = z3;
                        }
                        if (sb != null) {
                            sb.append(" -d '@-'");
                        }
                        lowLevelHttpRequestBuildRequest.setContentType(type);
                        lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                        lowLevelHttpRequestBuildRequest.setContentLength(jComputeLength);
                        lowLevelHttpRequestBuildRequest.setStreamingContent(streamingContent2);
                        streamingContent = streamingContent2;
                    } else {
                        i = i4;
                        z = z3;
                        j = -1;
                        streamingContent = httpContent;
                    }
                    if (z) {
                        logger.config(sbM1324q.toString());
                        if (sb != null) {
                            sb.append(" -- '");
                            sb.append(strBuild.replaceAll("'", "'\"'\"'"));
                            sb.append("'");
                            if (streamingContent != null) {
                                sb.append(" << $$$");
                            }
                            logger.config(sb.toString());
                        }
                    }
                    boolean z5 = !z4 && i > 0;
                    lowLevelHttpRequestBuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
                    lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
                    httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                    e = null;
                    if (httpResponse == null) {
                        try {
                            if (httpResponse.isSuccessStatusCode()) {
                                z2 = z5 & (httpResponse == null);
                            } else {
                                HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler = this.unsuccessfulResponseHandler;
                                boolean zHandleResponse = httpUnsuccessfulResponseHandler != null ? httpUnsuccessfulResponseHandler.handleResponse(this, httpResponse, z5) : false;
                                if (!zHandleResponse) {
                                    if (handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                        zHandleResponse = true;
                                    } else if (z5 && (backOffPolicy = this.backOffPolicy) != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                                        long nextBackOffMillis = this.backOffPolicy.getNextBackOffMillis();
                                        if (nextBackOffMillis != j) {
                                            try {
                                                this.sleeper.sleep(nextBackOffMillis);
                                            } catch (InterruptedException unused) {
                                            }
                                            zHandleResponse = true;
                                        }
                                    }
                                }
                                z2 = z5 & zHandleResponse;
                                if (z2) {
                                    httpResponse.ignore();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    i4 = i - 1;
                    if (z2) {
                        if (httpResponse == null) {
                            throw e;
                        }
                        HttpResponseInterceptor httpResponseInterceptor = this.responseInterceptor;
                        if (httpResponseInterceptor != null) {
                            httpResponseInterceptor.interceptResponse(httpResponse);
                        }
                        if (!this.throwExceptionOnExecuteError || httpResponse.isSuccessStatusCode()) {
                            return httpResponse;
                        }
                        try {
                            throw new HttpResponseException(httpResponse);
                        } finally {
                            httpResponse.disconnect();
                        }
                    }
                    httpResponse2 = httpResponse;
                } else {
                    sbM1324q = null;
                }
                httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                e = null;
                if (httpResponse == null) {
                }
                i4 = i - 1;
                if (z2) {
                }
            } catch (Throwable th2) {
                InputStream content = lowLevelHttpResponseExecute.getContent();
                if (content != null) {
                    content.close();
                }
                throw th2;
            }
            sb = null;
            String userAgent2 = this.headers.getUserAgent();
            if (!this.suppressUserAgentSuffix) {
            }
            HttpHeaders.serializeHeaders(this.headers, sbM1324q, sb, logger, lowLevelHttpRequestBuildRequest);
            if (!this.suppressUserAgentSuffix) {
            }
            httpContent = this.content;
            if (httpContent != null) {
            }
            if (httpContent == null) {
            }
            if (z) {
            }
            if (z4) {
            }
            lowLevelHttpRequestBuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
            lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
        }
    }

    @Beta
    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    @Beta
    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    @Beta
    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    @Beta
    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location)));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    @Beta
    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    @Beta
    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    @Beta
    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    @Beta
    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }
}
