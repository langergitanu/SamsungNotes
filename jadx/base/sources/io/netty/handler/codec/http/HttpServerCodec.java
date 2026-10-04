package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {
    private final Queue<HttpMethod> queue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class HttpServerResponseEncoder extends HttpResponseEncoder {
        private HttpMethod method;

        private HttpServerResponseEncoder() {
        }

        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
            HttpMethod httpMethod = (HttpMethod) HttpServerCodec.this.queue.poll();
            this.method = httpMethod;
            return HttpMethod.HEAD.equals(httpMethod) || super.isContentAlwaysEmpty(httpResponse);
        }

        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z) {
            if (!z && HttpMethod.CONNECT.equals(this.method) && httpResponse.status().codeClass() == HttpStatusClass.SUCCESS) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else {
                super.sanitizeHeadersBeforeEncode(httpResponse, z);
            }
        }
    }

    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class HttpServerRequestDecoder extends HttpRequestDecoder {
        public HttpServerRequestDecoder(int i, int i2, int i4) {
            super(i, i2, i4);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
            super.decode(channelHandlerContext, byteBuf, list);
            int size = list.size();
            for (int size2 = list.size(); size2 < size; size2++) {
                Object obj = list.get(size2);
                if (obj instanceof HttpRequest) {
                    HttpServerCodec.this.queue.add(((HttpRequest) obj).method());
                }
            }
        }

        public HttpServerRequestDecoder(int i, int i2, int i4, boolean z) {
            super(i, i2, i4, z);
        }

        public HttpServerRequestDecoder(int i, int i2, int i4, boolean z, int i5) {
            super(i, i2, i4, z, i5);
        }

        public HttpServerRequestDecoder(int i, int i2, int i4, boolean z, int i5, boolean z2) {
            super(i, i2, i4, z, i5, z2);
        }

        public HttpServerRequestDecoder(int i, int i2, int i4, boolean z, int i5, boolean z2, boolean z3) {
            super(i, i2, i4, z, i5, z2, z3);
        }
    }

    public HttpServerCodec(int i, int i2, int i4) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i4), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i4, boolean z) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i4, z), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i4, boolean z, int i5) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i4, z, i5), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i4, boolean z, int i5, boolean z2) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i4, z, i5, z2), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i4, boolean z, int i5, boolean z2, boolean z3) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i4, z, i5, z2, z3), new HttpServerResponseEncoder());
    }
}
