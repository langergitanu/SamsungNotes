package okhttp3.internal.http;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.exchange();
        Request request = realInterceptorChain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        Response.Builder responseHeaders = null;
        if (!HttpMethod.permitsRequestBody(request.method()) || request.body() == null) {
            exchange.noRequestBody();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                responseHeaders = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (responseHeaders != null) {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (request.body().isDuplex()) {
                exchange.flushRequest();
                request.body().writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
            } else {
                BufferedSink bufferedSinkBuffer = Okio.buffer(exchange.createRequestBody(request, false));
                request.body().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        }
        if (request.body() == null || !request.body().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange.readResponseHeaders(false);
        }
        Response responseBuild = responseHeaders.request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild.code();
        if (iCode == 100) {
            responseBuild = exchange.readResponseHeaders(false).request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild.code();
        }
        exchange.responseHeadersEnd(responseBuild);
        Response responseBuild2 = (this.forWebSocket && iCode == 101) ? responseBuild.newBuilder().body(Util.EMPTY_RESPONSE).build() : responseBuild.newBuilder().body(exchange.openResponseBody(responseBuild)).build();
        if ("close".equalsIgnoreCase(responseBuild2.request().header("Connection")) || "close".equalsIgnoreCase(responseBuild2.header("Connection"))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((iCode != 204 && iCode != 205) || responseBuild2.body().contentLength() <= 0) {
            return responseBuild2;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(iCode, "HTTP ", " had non-zero Content-Length: ");
        sbM778t.append(responseBuild2.body().contentLength());
        throw new ProtocolException(sbM778t.toString());
    }
}
