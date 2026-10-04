package io.netty.handler.proxy;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpProxyHandler extends ProxyHandler {
    private static final String AUTH_BASIC = "basic";
    private static final String PROTOCOL = "http";
    private final CharSequence authorization;
    private final HttpClientCodecWrapper codecWrapper;
    private final boolean ignoreDefaultPortsInConnectHostHeader;
    private HttpHeaders inboundHeaders;
    private final HttpHeaders outboundHeaders;
    private final String password;
    private HttpResponseStatus status;
    private final String username;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HttpClientCodecWrapper implements ChannelInboundHandler, ChannelOutboundHandler {
        final HttpClientCodec codec;

        private HttpClientCodecWrapper() {
            this.codec = new HttpClientCodec();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
            this.codec.bind(channelHandlerContext, socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelActive(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelInactive(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            this.codec.channelRead(channelHandlerContext, obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelReadComplete(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelRegistered(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelUnregistered(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
            this.codec.channelWritabilityChanged(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.codec.close(channelHandlerContext, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            this.codec.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.codec.deregister(channelHandlerContext, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.codec.disconnect(channelHandlerContext, channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            this.codec.exceptionCaught(channelHandlerContext, th);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void flush(ChannelHandlerContext channelHandlerContext) {
            this.codec.flush(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
            this.codec.handlerAdded(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
            this.codec.handlerRemoved(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void read(ChannelHandlerContext channelHandlerContext) {
            this.codec.read(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            this.codec.userEventTriggered(channelHandlerContext, obj);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
            this.codec.write(channelHandlerContext, obj, channelPromise);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HttpProxyConnectException extends ProxyConnectException {
        private static final long serialVersionUID = -8824334609292146066L;
        private final HttpHeaders headers;

        public HttpProxyConnectException(String str, HttpHeaders httpHeaders) {
            super(str);
            this.headers = httpHeaders;
        }

        public HttpHeaders headers() {
            return this.headers;
        }
    }

    public HttpProxyHandler(SocketAddress socketAddress) {
        this(socketAddress, null);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void addCodec(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.codecWrapper);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String authScheme() {
        return this.authorization != null ? "basic" : "none";
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws HttpProxyConnectException {
        if (obj instanceof HttpResponse) {
            if (this.status != null) {
                throw new HttpProxyConnectException(exceptionMessage("too many responses"), null);
            }
            HttpResponse httpResponse = (HttpResponse) obj;
            this.status = httpResponse.status();
            this.inboundHeaders = httpResponse.headers();
        }
        boolean z = obj instanceof LastHttpContent;
        if (z) {
            HttpResponseStatus httpResponseStatus = this.status;
            if (httpResponseStatus == null) {
                throw new HttpProxyConnectException(exceptionMessage("missing response"), this.inboundHeaders);
            }
            if (httpResponseStatus.code() != 200) {
                throw new HttpProxyConnectException(exceptionMessage("status: " + this.status), this.inboundHeaders);
            }
        }
        return z;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public Object newInitialMessage(ChannelHandlerContext channelHandlerContext) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) destinationAddress();
        String hostnameForHttp = HttpUtil.formatHostnameForHttp(inetSocketAddress);
        int port = inetSocketAddress.getPort();
        String strM2218i = AbstractC2821a.m2218i(port, hostnameForHttp, ":");
        if (!this.ignoreDefaultPortsInConnectHostHeader || (port != 80 && port != 443)) {
            hostnameForHttp = strM2218i;
        }
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.CONNECT, strM2218i, Unpooled.EMPTY_BUFFER, false);
        defaultFullHttpRequest.headers().set(HttpHeaderNames.HOST, hostnameForHttp);
        if (this.authorization != null) {
            defaultFullHttpRequest.headers().set(HttpHeaderNames.PROXY_AUTHORIZATION, this.authorization);
        }
        if (this.outboundHeaders != null) {
            defaultFullHttpRequest.headers().add(this.outboundHeaders);
        }
        return defaultFullHttpRequest;
    }

    public String password() {
        return this.password;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String protocol() {
        return "http";
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeDecoder(ChannelHandlerContext channelHandlerContext) {
        this.codecWrapper.codec.removeInboundHandler();
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeEncoder(ChannelHandlerContext channelHandlerContext) {
        this.codecWrapper.codec.removeOutboundHandler();
    }

    public String username() {
        return this.username;
    }

    public HttpProxyHandler(SocketAddress socketAddress, HttpHeaders httpHeaders) {
        this(socketAddress, httpHeaders, false);
    }

    public HttpProxyHandler(SocketAddress socketAddress, HttpHeaders httpHeaders, boolean z) {
        super(socketAddress);
        this.codecWrapper = new HttpClientCodecWrapper();
        this.username = null;
        this.password = null;
        this.authorization = null;
        this.outboundHeaders = httpHeaders;
        this.ignoreDefaultPortsInConnectHostHeader = z;
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2) {
        this(socketAddress, str, str2, null);
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2, HttpHeaders httpHeaders) {
        this(socketAddress, str, str2, httpHeaders, false);
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2, HttpHeaders httpHeaders, boolean z) {
        super(socketAddress);
        this.codecWrapper = new HttpClientCodecWrapper();
        this.username = (String) ObjectUtil.checkNotNull(str, "username");
        this.password = (String) ObjectUtil.checkNotNull(str2, "password");
        ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(AbstractC1038a.m1212m(':', str, str2), CharsetUtil.UTF_8);
        try {
            ByteBuf byteBufEncode = Base64.encode(byteBufCopiedBuffer, false);
            try {
                this.authorization = new AsciiString("Basic " + byteBufEncode.toString(CharsetUtil.US_ASCII));
                byteBufEncode.release();
                this.outboundHeaders = httpHeaders;
                this.ignoreDefaultPortsInConnectHostHeader = z;
            } catch (Throwable th) {
                byteBufEncode.release();
                throw th;
            }
        } finally {
            byteBufCopiedBuffer.release();
        }
    }
}
