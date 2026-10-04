package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http2.ConnectionShutdownException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Request followUpRequest(Response response, @Nullable Route route) throws ProtocolException {
        String strHeader;
        HttpUrl httpUrlResolve;
        RequestBody requestBodyBody;
        if (response == null) {
            throw new IllegalStateException();
        }
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode == 307 || iCode == 308) {
            if (strMethod.equals("GET") || strMethod.equals("HEAD")) {
                if (this.client.followRedirects() && (strHeader = response.header("Location")) != null && (httpUrlResolve = response.request().url().resolve(strHeader)) != null && (httpUrlResolve.scheme().equals(response.request().url().scheme()) || this.client.followSslRedirects())) {
                    Request.Builder builderNewBuilder = response.request().newBuilder();
                    if (HttpMethod.permitsRequestBody(strMethod)) {
                        boolean zRedirectsWithBody = HttpMethod.redirectsWithBody(strMethod);
                        if (HttpMethod.redirectsToGet(strMethod)) {
                            builderNewBuilder.method("GET", null);
                        } else {
                            builderNewBuilder.method(strMethod, zRedirectsWithBody ? response.request().body() : null);
                        }
                        if (!zRedirectsWithBody) {
                            builderNewBuilder.removeHeader("Transfer-Encoding");
                            builderNewBuilder.removeHeader("Content-Length");
                            builderNewBuilder.removeHeader("Content-Type");
                        }
                    }
                    if (!Util.sameConnection(response.request().url(), httpUrlResolve)) {
                        builderNewBuilder.removeHeader("Authorization");
                    }
                    return builderNewBuilder.url(httpUrlResolve).build();
                }
            }
        } else {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode != 503) {
                if (iCode == 407) {
                    if ((route != null ? route.proxy() : this.client.proxy()).type() == Proxy.Type.HTTP) {
                        return this.client.proxyAuthenticator().authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iCode != 408) {
                    switch (iCode) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                        default:
                            return null;
                    }
                } else if (this.client.retryOnConnectionFailure() && (((requestBodyBody = response.request().body()) == null || !requestBodyBody.isOneShot()) && ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0))) {
                    return response.request();
                }
            } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                return response.request();
            }
        }
        return null;
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(IOException iOException, Transmitter transmitter, boolean z, Request request) {
        if (this.client.retryOnConnectionFailure()) {
            return !(z && requestIsOneShot(iOException, request)) && isRecoverable(iOException, z) && transmitter.canRetry();
        }
        return false;
    }

    private boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody requestBodyBody = request.body();
        return (requestBodyBody != null && requestBodyBody.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private int retryAfter(Response response, int i) {
        String strHeader = response.header("Retry-After");
        if (strHeader == null) {
            return i;
        }
        if (strHeader.matches("\\d+")) {
            return Integer.valueOf(strHeader).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        return r4;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Exchange exchange;
        Request requestFollowUpRequest;
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Transmitter transmitter = realInterceptorChain.transmitter();
        int i = 0;
        Response response = null;
        while (true) {
            transmitter.prepareToConnect(request);
            if (transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    Response responseProceed = realInterceptorChain.proceed(request, transmitter, null);
                    if (response != null) {
                        responseProceed = responseProceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                    response = responseProceed;
                    exchange = Internal.instance.exchange(response);
                    requestFollowUpRequest = followUpRequest(response, exchange != null ? exchange.connection().route() : null);
                } catch (IOException e) {
                    if (!recover(e, transmitter, !(e instanceof ConnectionShutdownException), request)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!recover(e2.getLastConnectException(), transmitter, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                }
                if (requestFollowUpRequest != null) {
                    RequestBody requestBodyBody = requestFollowUpRequest.body();
                    if (requestBodyBody != null && requestBodyBody.isOneShot()) {
                        break;
                    }
                    Util.closeQuietly(response.body());
                    if (transmitter.hasExchange()) {
                        exchange.detachWithViolence();
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException(AbstractC0000a.m11h(i, "Too many follow-up requests: "));
                    }
                    request = requestFollowUpRequest;
                } else if (exchange != null && exchange.isDuplex()) {
                    transmitter.timeoutEarlyExit();
                }
            } finally {
                transmitter.exchangeDoneDueToException();
            }
        }
    }
}
