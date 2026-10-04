package com.microsoft.identity.common.java.net;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.api.client.googleapis.MethodOverride;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpConstants;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.events.HttpEndEvent;
import com.microsoft.identity.common.java.telemetry.events.HttpStartEvent;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Consumer;
import com.microsoft.identity.common.java.util.ported.Function;
import com.microsoft.identity.common.java.util.ported.Supplier;
import io.opentelemetry.api.trace.Span;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import lombok.NonNull;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class UrlConnectionHttpClient extends AbstractHttpClient {
    protected static final int DEFAULT_CONNECT_TIME_OUT_MS = 30000;
    protected static final int DEFAULT_READ_TIME_OUT_MS = 30000;
    protected static final int DEFAULT_STREAM_BUFFER_SIZE_BYTE = 1024;
    protected static final int RETRY_TIME_WAITING_PERIOD_MSEC = 1000;
    private static final String TAG = "UrlConnectionHttpClient";
    private static final transient AtomicReference<UrlConnectionHttpClient> defaultReference = new AtomicReference<>(null);
    private final int connectTimeoutMs;
    private final Supplier<Integer> connectTimeoutMsSupplier;
    private final int readTimeoutMs;
    private final Supplier<Integer> readTimeoutMsSupplier;
    private final IRetryPolicy<HttpResponse> retryPolicy;
    private final SSLSocketFactoryWrapper sslSocketFactory;
    private final int streamBufferSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UrlConnectionHttpClientBuilder {
        private Integer connectTimeoutMs;
        private Supplier<Integer> connectTimeoutMsSupplier;
        private Integer readTimeoutMs;
        private Supplier<Integer> readTimeoutMsSupplier;
        private IRetryPolicy<HttpResponse> retryPolicy;
        private SSLContext sslContext;
        private Integer streamBufferSize;
        private List<String> supportedSslProtocols;

        public UrlConnectionHttpClient build() {
            return new UrlConnectionHttpClient(this.retryPolicy, this.streamBufferSize, this.connectTimeoutMs, this.readTimeoutMs, this.connectTimeoutMsSupplier, this.readTimeoutMsSupplier, this.supportedSslProtocols, this.sslContext);
        }

        public UrlConnectionHttpClientBuilder connectTimeoutMs(@Nullable Integer num) {
            this.connectTimeoutMs = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder connectTimeoutMsSupplier(@Nullable Supplier<Integer> supplier) {
            this.connectTimeoutMsSupplier = supplier;
            return this;
        }

        public UrlConnectionHttpClientBuilder readTimeoutMs(@Nullable Integer num) {
            this.readTimeoutMs = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder readTimeoutMsSupplier(@Nullable Supplier<Integer> supplier) {
            this.readTimeoutMsSupplier = supplier;
            return this;
        }

        public UrlConnectionHttpClientBuilder retryPolicy(@Nullable IRetryPolicy<HttpResponse> iRetryPolicy) {
            this.retryPolicy = iRetryPolicy;
            return this;
        }

        public UrlConnectionHttpClientBuilder sslContext(@Nullable SSLContext sSLContext) {
            this.sslContext = sSLContext;
            return this;
        }

        public UrlConnectionHttpClientBuilder streamBufferSize(@Nullable Integer num) {
            this.streamBufferSize = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder supportedSslProtocols(@Nullable List<String> list) {
            this.supportedSslProtocols = list;
            return this;
        }

        public String toString() {
            return "UrlConnectionHttpClient.UrlConnectionHttpClientBuilder(retryPolicy=" + this.retryPolicy + ", streamBufferSize=" + this.streamBufferSize + ", connectTimeoutMs=" + this.connectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", connectTimeoutMsSupplier=" + this.connectTimeoutMsSupplier + ", readTimeoutMsSupplier=" + this.readTimeoutMsSupplier + ", supportedSslProtocols=" + this.supportedSslProtocols + ", sslContext=" + this.sslContext + ")";
        }
    }

    public UrlConnectionHttpClient(IRetryPolicy<HttpResponse> iRetryPolicy, int i, int i2, int i4, Supplier<Integer> supplier, Supplier<Integer> supplier2, SSLSocketFactoryWrapper sSLSocketFactoryWrapper) {
        this.retryPolicy = iRetryPolicy;
        this.streamBufferSize = i;
        this.connectTimeoutMs = i2;
        this.readTimeoutMs = i4;
        this.connectTimeoutMsSupplier = supplier;
        this.readTimeoutMsSupplier = supplier2;
        this.sslSocketFactory = sSLSocketFactoryWrapper;
    }

    public static UrlConnectionHttpClientBuilder builder() {
        return new UrlConnectionHttpClientBuilder();
    }

    private static HttpRequest constructHttpRequest(@NonNull HttpClient.HttpMethod httpMethod, @NonNull URL url, @NonNull Map<String, String> map, byte[] bArr) {
        Map map2;
        if (httpMethod == null) {
            throw new NullPointerException("httpMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        HttpClient.HttpMethod httpMethod2 = HttpClient.HttpMethod.PATCH;
        if (httpMethod2 == httpMethod) {
            httpMethod = HttpClient.HttpMethod.POST;
            HashMap map3 = new HashMap(map);
            map3.put(MethodOverride.HEADER, httpMethod2.name());
            map2 = map3;
        } else {
            map2 = map;
        }
        return new HttpRequest(url, map2, httpMethod.name(), bArr, null);
    }

    private String convertStreamToString(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, AuthenticationConstants.CHARSET_UTF8));
            char[] cArr = new char[this.streamBufferSize];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= -1) {
                    String string = sb.toString();
                    safeCloseStream(inputStream);
                    return string;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Throwable th) {
            safeCloseStream(inputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpResponse executeHttpSend(HttpRequest httpRequest, Consumer<HttpResponse> consumer) throws Throwable {
        InputStream errorStream;
        HttpResponse httpResponse;
        HttpURLConnection httpURLConnection = setupConnection(httpRequest);
        sendRequest(httpURLConnection, httpRequest.getRequestContent(), httpRequest.getRequestHeaders().get("Content-Type"));
        HttpResponse httpResponse2 = null;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (SocketTimeoutException e) {
                throw e;
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                httpResponse = new HttpResponse(new Date(httpURLConnection.getDate()), responseCode, errorStream == null ? "" : convertStreamToString(errorStream), httpURLConnection.getHeaderFields());
            } catch (Throwable th) {
                th = th;
            }
            try {
                Span spanCurrent = SpanExtension.current();
                if (httpResponse.getHeaders() != null && httpResponse.getHeaders().size() > 0) {
                    spanCurrent.setAttribute(AttributeName.response_content_type.name(), httpResponse.getHeaderValue("Content-Type", 0));
                    spanCurrent.setAttribute(AttributeName.ccs_request_id.name(), httpResponse.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_ID, 0));
                    spanCurrent.setAttribute(AttributeName.ccs_request_sequence.name(), httpResponse.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_SEQUENCE, 0));
                }
                spanCurrent.setAttribute(AttributeName.response_body_length.name(), r5.length());
                spanCurrent.setAttribute(AttributeName.http_status_code.name(), httpResponse.getStatusCode());
                consumer.accept(httpResponse);
                safeCloseStream(errorStream);
                return httpResponse;
            } catch (Throwable th2) {
                th = th2;
                httpResponse2 = httpResponse;
                consumer.accept(httpResponse2);
                safeCloseStream(errorStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            consumer.accept(httpResponse2);
            safeCloseStream(errorStream);
            throw th;
        }
    }

    private int getConnectTimeoutMs() {
        Supplier<Integer> supplier = this.connectTimeoutMsSupplier;
        return supplier == null ? this.connectTimeoutMs : supplier.get().intValue();
    }

    public static synchronized UrlConnectionHttpClient getDefaultInstance() {
        UrlConnectionHttpClient urlConnectionHttpClient;
        AtomicReference<UrlConnectionHttpClient> atomicReference = defaultReference;
        urlConnectionHttpClient = atomicReference.get();
        if (urlConnectionHttpClient == null) {
            UrlConnectionHttpClient urlConnectionHttpClientBuild = builder().retryPolicy(StatusCodeAndExceptionRetry.builder().number(1).extensionFactor(2).isAcceptable(new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.3
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(HttpResponse httpResponse) {
                    return Boolean.valueOf(httpResponse != null && httpResponse.getStatusCode() < 400);
                }
            }).initialDelay(1000).isRetryable(new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.2
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(HttpResponse httpResponse) {
                    return Boolean.valueOf(httpResponse != null && UrlConnectionHttpClient.isRetryableError(httpResponse.getStatusCode()));
                }
            }).isRetryableException(new Function<Exception, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.1
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(Exception exc) {
                    return Boolean.valueOf(exc instanceof SocketTimeoutException);
                }
            }).build()).build();
            while (!atomicReference.compareAndSet(null, urlConnectionHttpClientBuild) && atomicReference.get() == null) {
            }
            urlConnectionHttpClient = defaultReference.get();
        }
        return urlConnectionHttpClient;
    }

    private int getReadTimeoutMs() {
        Supplier<Integer> supplier = this.readTimeoutMsSupplier;
        return supplier == null ? this.readTimeoutMs : supplier.get().intValue();
    }

    public static boolean isRetryableError(int i) {
        return i == 500 || i == 504 || i == 503;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordHttpTelemetryEventEnd(HttpResponse httpResponse) {
        HttpEndEvent httpEndEvent = new HttpEndEvent();
        if (httpResponse != null) {
            httpEndEvent.putStatusCode(httpResponse.getStatusCode());
        }
        Telemetry.emit(httpEndEvent);
    }

    private static void recordHttpTelemetryEventStart(@NonNull String str, @NonNull URL url, String str2) {
        if (str == null) {
            throw new NullPointerException("requestMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        Telemetry.emit(new HttpStartEvent().putMethod(str).putPath(url).putRequestIdHeader(str2));
    }

    private static void safeCloseStream(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            Logger.error(TAG + ":safeCloseStream", "Encountered IO exception when trying to close the stream", e);
        }
    }

    private static void sendRequest(@NonNull HttpURLConnection httpURLConnection, byte[] bArr, String str) throws Throwable {
        OutputStream outputStream;
        if (httpURLConnection == null) {
            throw new NullPointerException("connection is marked non-null but is null");
        }
        if (bArr == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!StringUtil.isNullOrEmpty(str)) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                safeCloseStream(outputStream);
            } catch (Throwable th) {
                th = th;
                safeCloseStream(outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    private HttpURLConnection setupConnection(HttpRequest httpRequest) throws ProtocolException {
        HttpURLConnection httpURLConnectionCreateHttpURLConnection = HttpUrlConnectionFactory.createHttpURLConnection(httpRequest.getRequestUrl());
        for (Map.Entry<String, String> entry : httpRequest.getRequestHeaders().entrySet()) {
            httpURLConnectionCreateHttpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (httpURLConnectionCreateHttpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnectionCreateHttpURLConnection).setSSLSocketFactory(this.sslSocketFactory);
        } else {
            if (AuthenticationConstants.HTTPS_PROTOCOL_STRING.equalsIgnoreCase(httpRequest.getRequestUrl().getProtocol())) {
                throw new IllegalStateException("Trying to initiate a HTTPS request, but didn't get back HttpsURLConnection");
            }
            if ("http".equalsIgnoreCase(httpRequest.getRequestUrl().getProtocol())) {
                AbstractC4539a.m3189C(new StringBuilder(), TAG, ":setupConnection", "Making a request for non-https URL.");
            } else {
                Logger.warn(AbstractC0622a.m1170p(TAG, ":setupConnection", new StringBuilder()), "gets a request from an unexpected protocol: " + httpRequest.getRequestUrl().getProtocol());
            }
        }
        httpURLConnectionCreateHttpURLConnection.setRequestMethod(httpRequest.getRequestMethod());
        httpURLConnectionCreateHttpURLConnection.setConnectTimeout(getConnectTimeoutMs());
        httpURLConnectionCreateHttpURLConnection.setReadTimeout(getReadTimeoutMs());
        httpURLConnectionCreateHttpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnectionCreateHttpURLConnection.setUseCaches(true);
        httpURLConnectionCreateHttpURLConnection.setDoInput(true);
        return httpURLConnectionCreateHttpURLConnection;
    }

    @Override // com.microsoft.identity.common.java.net.AbstractHttpClient, com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse method(@NonNull HttpClient.HttpMethod httpMethod, @NonNull URL url, @NonNull Map<String, String> map, byte[] bArr) {
        if (httpMethod == null) {
            throw new NullPointerException("httpMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        recordHttpTelemetryEventStart(httpMethod.name(), url, map.get("client-request-id"));
        final HttpRequest httpRequestConstructHttpRequest = constructHttpRequest(httpMethod, url, map, bArr);
        return this.retryPolicy.attempt(new Callable<HttpResponse>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() {
                return UrlConnectionHttpClient.this.executeHttpSend(httpRequestConstructHttpRequest, new Consumer<HttpResponse>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.4.1
                    @Override // com.microsoft.identity.common.java.util.ported.Consumer
                    public void accept(HttpResponse httpResponse) {
                        UrlConnectionHttpClient.recordHttpTelemetryEventEnd(httpResponse);
                    }
                });
            }
        });
    }

    private UrlConnectionHttpClient(@Nullable IRetryPolicy<HttpResponse> iRetryPolicy, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Supplier<Integer> supplier, @Nullable Supplier<Integer> supplier2, @Nullable List<String> list, @Nullable SSLContext sSLContext) {
        this.retryPolicy = iRetryPolicy == null ? new NoRetryPolicy() : iRetryPolicy;
        this.streamBufferSize = num != null ? num.intValue() : 1024;
        this.connectTimeoutMs = num2 != null ? num2.intValue() : 30000;
        this.readTimeoutMs = num3 != null ? num3.intValue() : 30000;
        this.connectTimeoutMsSupplier = supplier;
        this.readTimeoutMsSupplier = supplier2;
        list = list == null ? SSLSocketFactoryWrapper.SUPPORTED_SSL_PROTOCOLS : list;
        if (sSLContext == null) {
            this.sslSocketFactory = new SSLSocketFactoryWrapper((SSLSocketFactory) SSLSocketFactory.getDefault(), list);
        } else {
            this.sslSocketFactory = new SSLSocketFactoryWrapper(sSLContext.getSocketFactory(), list);
        }
    }
}
