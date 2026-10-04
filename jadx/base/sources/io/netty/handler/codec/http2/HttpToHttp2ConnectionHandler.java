package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.ReferenceCountUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private HttpScheme httpScheme;
    private final boolean validateHeaders;

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z;
    }

    private int getStreamId(HttpHeaders httpHeaders) {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    private static void writeHeaders(ChannelHandlerContext channelHandlerContext, Http2ConnectionEncoder http2ConnectionEncoder, int i, HttpHeaders httpHeaders, Http2Headers http2Headers, boolean z, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        http2ConnectionEncoder.writeHeaders(channelHandlerContext, i, http2Headers, httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), httpHeaders.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16), false, 0, z, simpleChannelPromiseAggregator.newPromise());
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e6  */
    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContext2;
        boolean z;
        Http2Headers http2Headers;
        boolean z2;
        if (!(obj instanceof HttpMessage) && !(obj instanceof HttpContent)) {
            channelHandlerContext.write(obj, channelPromise);
            return;
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        boolean z3 = true;
        try {
            Http2ConnectionEncoder http2ConnectionEncoderEncoder = encoder();
            boolean z4 = false;
            if (obj instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) obj;
                this.currentStreamId = getStreamId(httpMessage.headers());
                if (this.httpScheme != null) {
                    HttpHeaders httpHeadersHeaders = httpMessage.headers();
                    HttpConversionUtil.ExtensionHeaderNames extensionHeaderNames = HttpConversionUtil.ExtensionHeaderNames.SCHEME;
                    if (!httpHeadersHeaders.contains(extensionHeaderNames.text())) {
                        httpMessage.headers().set(extensionHeaderNames.text(), this.httpScheme.name());
                    }
                }
                Http2Headers http2Headers2 = HttpConversionUtil.toHttp2Headers(httpMessage, this.validateHeaders);
                z = (obj instanceof FullHttpMessage) && !((FullHttpMessage) obj).content().isReadable();
                channelHandlerContext2 = channelHandlerContext;
                try {
                    writeHeaders(channelHandlerContext2, http2ConnectionEncoderEncoder, this.currentStreamId, httpMessage.headers(), http2Headers2, z, simpleChannelPromiseAggregator);
                } catch (Throwable th) {
                    th = th;
                    z4 = true;
                    try {
                        onError(channelHandlerContext2, true, th);
                        simpleChannelPromiseAggregator.setFailure(th);
                        if (z4) {
                            ReferenceCountUtil.release(obj);
                        }
                        simpleChannelPromiseAggregator.doneAllocatingPromises();
                        return;
                    } catch (Throwable th2) {
                        if (z4) {
                            ReferenceCountUtil.release(obj);
                        }
                        simpleChannelPromiseAggregator.doneAllocatingPromises();
                        throw th2;
                    }
                }
            } else {
                channelHandlerContext2 = channelHandlerContext;
                z = false;
            }
            if (!z && (obj instanceof HttpContent)) {
                HttpHeaders httpHeadersTrailingHeaders = EmptyHttpHeaders.INSTANCE;
                EmptyHttp2Headers emptyHttp2Headers = EmptyHttp2Headers.INSTANCE;
                if (obj instanceof LastHttpContent) {
                    httpHeadersTrailingHeaders = ((LastHttpContent) obj).trailingHeaders();
                    http2Headers = HttpConversionUtil.toHttp2Headers(httpHeadersTrailingHeaders, this.validateHeaders);
                    z2 = true;
                } else {
                    http2Headers = emptyHttp2Headers;
                    z2 = false;
                }
                http2ConnectionEncoderEncoder.writeData(channelHandlerContext2, this.currentStreamId, ((HttpContent) obj).content(), 0, z2 && httpHeadersTrailingHeaders.isEmpty(), simpleChannelPromiseAggregator.newPromise());
                try {
                    if (!httpHeadersTrailingHeaders.isEmpty()) {
                        writeHeaders(channelHandlerContext2, http2ConnectionEncoderEncoder, this.currentStreamId, httpHeadersTrailingHeaders, http2Headers, true, simpleChannelPromiseAggregator);
                    }
                    z3 = false;
                } catch (Throwable th3) {
                    th = th3;
                    onError(channelHandlerContext2, true, th);
                    simpleChannelPromiseAggregator.setFailure(th);
                    if (z4) {
                    }
                    simpleChannelPromiseAggregator.doneAllocatingPromises();
                    return;
                }
            }
            if (z3) {
                ReferenceCountUtil.release(obj);
            }
            simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th4) {
            th = th4;
            channelHandlerContext2 = channelHandlerContext;
        }
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z, z2, null);
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2, HttpScheme httpScheme) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z2);
        this.validateHeaders = z;
        this.httpScheme = httpScheme;
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2, boolean z3, HttpScheme httpScheme) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z2, z3);
        this.validateHeaders = z;
        this.httpScheme = httpScheme;
    }
}
