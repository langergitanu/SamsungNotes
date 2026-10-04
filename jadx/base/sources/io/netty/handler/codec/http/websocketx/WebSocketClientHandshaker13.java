package io.netty.handler.codec.http.websocketx;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocketClientHandshaker13 extends WebSocketClientHandshaker {
    public static final String MAGIC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocketClientHandshaker13.class);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private String expectedChallengeResponseString;
    private final boolean performMasking;

    public WebSocketClientHandshaker13(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, true, false);
    }

    public boolean isAllowExtensions() {
        return this.allowExtensions;
    }

    public boolean isAllowMaskMismatch() {
        return this.allowMaskMismatch;
    }

    public boolean isPerformMasking() {
        return this.performMasking;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public FullHttpRequest newHandshakeRequest() {
        URI uri = uri();
        String strBase64 = WebSocketUtil.base64(WebSocketUtil.randomBytes(16));
        this.expectedChallengeResponseString = WebSocketUtil.base64(WebSocketUtil.sha1(AbstractC0541b.m756B(strBase64, "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("WebSocket version 13 client handshake key: {}, expected response: {}", strBase64, this.expectedChallengeResponseString);
        }
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.EMPTY_BUFFER);
        HttpHeaders httpHeadersHeaders = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            httpHeadersHeaders.add(httpHeaders);
            AsciiString asciiString = HttpHeaderNames.HOST;
            if (!httpHeadersHeaders.contains(asciiString)) {
                httpHeadersHeaders.set(asciiString, WebSocketClientHandshaker.websocketHostValue(uri));
            }
        } else {
            httpHeadersHeaders.set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue(uri));
        }
        httpHeadersHeaders.set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_KEY, strBase64);
        if (this.generateOriginHeader) {
            AsciiString asciiString2 = HttpHeaderNames.ORIGIN;
            if (!httpHeadersHeaders.contains(asciiString2)) {
                httpHeadersHeaders.set(asciiString2, WebSocketClientHandshaker.websocketOriginValue(uri));
            }
        }
        String strExpectedSubprotocol = expectedSubprotocol();
        if (strExpectedSubprotocol != null && !strExpectedSubprotocol.isEmpty()) {
            httpHeadersHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, strExpectedSubprotocol);
        }
        httpHeadersHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, version().toAsciiString());
        return defaultFullHttpRequest;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket13FrameEncoder(this.performMasking);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket13FrameDecoder(false, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus httpResponseStatusStatus = fullHttpResponse.status();
        if (!HttpResponseStatus.SWITCHING_PROTOCOLS.equals(httpResponseStatusStatus)) {
            throw new WebSocketClientHandshakeException("Invalid handshake response getStatus: " + httpResponseStatusStatus, fullHttpResponse);
        }
        HttpHeaders httpHeadersHeaders = fullHttpResponse.headers();
        String str = httpHeadersHeaders.get(HttpHeaderNames.UPGRADE);
        if (!HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
            throw new WebSocketClientHandshakeException("Invalid handshake response upgrade: " + ((Object) str), fullHttpResponse);
        }
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        if (!httpHeadersHeaders.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
            throw new WebSocketClientHandshakeException("Invalid handshake response connection: " + httpHeadersHeaders.get(asciiString), fullHttpResponse);
        }
        String str2 = httpHeadersHeaders.get(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT);
        if (str2 == null || !str2.equals(this.expectedChallengeResponseString)) {
            throw new WebSocketClientHandshakeException(AbstractC0541b.m774p("Invalid challenge. Actual: ", str2, ". Expected: ", this.expectedChallengeResponseString), fullHttpResponse);
        }
    }

    public WebSocketClientHandshaker13(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, 10000L);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketClientHandshaker13 setForceCloseTimeoutMillis(long j) {
        super.setForceCloseTimeoutMillis(j);
        return this;
    }

    public WebSocketClientHandshaker13(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, j, false);
    }

    public WebSocketClientHandshaker13(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j, boolean z4) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, j, z4, true);
    }

    public WebSocketClientHandshaker13(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j, boolean z4, boolean z5) {
        super(uri, webSocketVersion, str, httpHeaders, i, j, z4, z5);
        this.allowExtensions = z;
        this.performMasking = z2;
        this.allowMaskMismatch = z3;
    }
}
