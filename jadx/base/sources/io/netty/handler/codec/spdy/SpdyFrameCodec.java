package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdyFrameCodec extends ByteToMessageDecoder implements SpdyFrameDecoderDelegate, ChannelOutboundHandler {
    private static final SpdyProtocolException INVALID_FRAME = new SpdyProtocolException("Received invalid frame");
    private ChannelHandlerContext ctx;
    private boolean read;
    private final SpdyFrameDecoder spdyFrameDecoder;
    private final SpdyFrameEncoder spdyFrameEncoder;
    private final SpdyHeaderBlockDecoder spdyHeaderBlockDecoder;
    private final SpdyHeaderBlockEncoder spdyHeaderBlockEncoder;
    private SpdyHeadersFrame spdyHeadersFrame;
    private SpdySettingsFrame spdySettingsFrame;
    private final boolean validateHeaders;

    public SpdyFrameCodec(SpdyVersion spdyVersion) {
        this(spdyVersion, true);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        if (!this.read && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.read = false;
        super.channelReadComplete(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        this.spdyFrameDecoder.decode(byteBuf);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        super.handlerAdded(channelHandlerContext);
        this.ctx = channelHandlerContext;
        channelHandlerContext.channel().closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdyFrameCodec.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                SpdyFrameCodec.this.spdyHeaderBlockDecoder.end();
                SpdyFrameCodec.this.spdyHeaderBlockEncoder.end();
            }
        });
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.read();
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readDataFrame(int i, boolean z, ByteBuf byteBuf) {
        this.read = true;
        DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(i, byteBuf);
        defaultSpdyDataFrame.setLast(z);
        this.ctx.fireChannelRead((Object) defaultSpdyDataFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readFrameError(String str) {
        this.ctx.fireExceptionCaught((Throwable) INVALID_FRAME);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readGoAwayFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyGoAwayFrame(i, i2));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeaderBlock(ByteBuf byteBuf) {
        try {
            this.spdyHeaderBlockDecoder.decode(this.ctx.alloc(), byteBuf, this.spdyHeadersFrame);
        } catch (Exception e) {
            this.ctx.fireExceptionCaught((Throwable) e);
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeaderBlockEnd() {
        SpdyHeadersFrame spdyHeadersFrame;
        Exception e;
        try {
            this.spdyHeaderBlockDecoder.endHeaderBlock(this.spdyHeadersFrame);
            spdyHeadersFrame = this.spdyHeadersFrame;
        } catch (Exception e2) {
            spdyHeadersFrame = null;
            e = e2;
        }
        try {
            this.spdyHeadersFrame = null;
        } catch (Exception e3) {
            e = e3;
            this.ctx.fireExceptionCaught((Throwable) e);
        }
        if (spdyHeadersFrame != null) {
            this.read = true;
            this.ctx.fireChannelRead((Object) spdyHeadersFrame);
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeadersFrame(int i, boolean z) {
        DefaultSpdyHeadersFrame defaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(i, this.validateHeaders);
        this.spdyHeadersFrame = defaultSpdyHeadersFrame;
        defaultSpdyHeadersFrame.setLast(z);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readPingFrame(int i) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyPingFrame(i));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readRstStreamFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyRstStreamFrame(i, i2));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSetting(int i, int i2, boolean z, boolean z2) {
        this.spdySettingsFrame.setValue(i, i2, z, z2);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsEnd() {
        this.read = true;
        SpdySettingsFrame spdySettingsFrame = this.spdySettingsFrame;
        this.spdySettingsFrame = null;
        this.ctx.fireChannelRead((Object) spdySettingsFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsFrame(boolean z) {
        this.read = true;
        DefaultSpdySettingsFrame defaultSpdySettingsFrame = new DefaultSpdySettingsFrame();
        this.spdySettingsFrame = defaultSpdySettingsFrame;
        defaultSpdySettingsFrame.setClearPreviouslyPersistedSettings(z);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynReplyFrame(int i, boolean z) {
        DefaultSpdySynReplyFrame defaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(i, this.validateHeaders);
        defaultSpdySynReplyFrame.setLast(z);
        this.spdyHeadersFrame = defaultSpdySynReplyFrame;
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynStreamFrame(int i, int i2, byte b, boolean z, boolean z2) {
        DefaultSpdySynStreamFrame defaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(i, i2, b, this.validateHeaders);
        defaultSpdySynStreamFrame.setLast(z);
        defaultSpdySynStreamFrame.setUnidirectional(z2);
        this.spdyHeadersFrame = defaultSpdySynStreamFrame;
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readWindowUpdateFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyWindowUpdateFrame(i, i2));
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        ByteBuf byteBufEncode;
        if (obj instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) obj;
            ByteBuf byteBufEncodeDataFrame = this.spdyFrameEncoder.encodeDataFrame(channelHandlerContext.alloc(), spdyDataFrame.streamId(), spdyDataFrame.isLast(), spdyDataFrame.content());
            spdyDataFrame.release();
            channelHandlerContext.write(byteBufEncodeDataFrame, channelPromise);
            return;
        }
        if (obj instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) obj;
            byteBufEncode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynStreamFrame);
            try {
                ByteBuf byteBufEncodeSynStreamFrame = this.spdyFrameEncoder.encodeSynStreamFrame(channelHandlerContext.alloc(), spdySynStreamFrame.streamId(), spdySynStreamFrame.associatedStreamId(), spdySynStreamFrame.priority(), spdySynStreamFrame.isLast(), spdySynStreamFrame.isUnidirectional(), byteBufEncode);
                byteBufEncode.release();
                channelHandlerContext.write(byteBufEncodeSynStreamFrame, channelPromise);
                return;
            } finally {
            }
        }
        if (obj instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) obj;
            byteBufEncode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynReplyFrame);
            try {
                ByteBuf byteBufEncodeSynReplyFrame = this.spdyFrameEncoder.encodeSynReplyFrame(channelHandlerContext.alloc(), spdySynReplyFrame.streamId(), spdySynReplyFrame.isLast(), byteBufEncode);
                byteBufEncode.release();
                channelHandlerContext.write(byteBufEncodeSynReplyFrame, channelPromise);
                return;
            } finally {
            }
        }
        if (obj instanceof SpdyRstStreamFrame) {
            SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeRstStreamFrame(channelHandlerContext.alloc(), spdyRstStreamFrame.streamId(), spdyRstStreamFrame.status().code()), channelPromise);
            return;
        }
        if (obj instanceof SpdySettingsFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodeSettingsFrame(channelHandlerContext.alloc(), (SpdySettingsFrame) obj), channelPromise);
            return;
        }
        if (obj instanceof SpdyPingFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodePingFrame(channelHandlerContext.alloc(), ((SpdyPingFrame) obj).mo13775id()), channelPromise);
            return;
        }
        if (obj instanceof SpdyGoAwayFrame) {
            SpdyGoAwayFrame spdyGoAwayFrame = (SpdyGoAwayFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeGoAwayFrame(channelHandlerContext.alloc(), spdyGoAwayFrame.lastGoodStreamId(), spdyGoAwayFrame.status().code()), channelPromise);
            return;
        }
        if (!(obj instanceof SpdyHeadersFrame)) {
            if (!(obj instanceof SpdyWindowUpdateFrame)) {
                throw new UnsupportedMessageTypeException(obj, (Class<?>[]) new Class[0]);
            }
            SpdyWindowUpdateFrame spdyWindowUpdateFrame = (SpdyWindowUpdateFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeWindowUpdateFrame(channelHandlerContext.alloc(), spdyWindowUpdateFrame.streamId(), spdyWindowUpdateFrame.deltaWindowSize()), channelPromise);
            return;
        }
        SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) obj;
        byteBufEncode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdyHeadersFrame);
        try {
            ByteBuf byteBufEncodeHeadersFrame = this.spdyFrameEncoder.encodeHeadersFrame(channelHandlerContext.alloc(), spdyHeadersFrame.streamId(), spdyHeadersFrame.isLast(), byteBufEncode);
            byteBufEncode.release();
            channelHandlerContext.write(byteBufEncodeHeadersFrame, channelPromise);
        } finally {
        }
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, boolean z) {
        this(spdyVersion, 8192, 16384, 6, 15, 8, z);
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i, int i2, int i4, int i5, int i6) {
        this(spdyVersion, i, i2, i4, i5, i6, true);
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i, int i2, int i4, int i5, int i6, boolean z) {
        this(spdyVersion, i, SpdyHeaderBlockDecoder.newInstance(spdyVersion, i2), SpdyHeaderBlockEncoder.newInstance(spdyVersion, i4, i5, i6), z);
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i, SpdyHeaderBlockDecoder spdyHeaderBlockDecoder, SpdyHeaderBlockEncoder spdyHeaderBlockEncoder, boolean z) {
        this.spdyFrameDecoder = new SpdyFrameDecoder(spdyVersion, this, i);
        this.spdyFrameEncoder = new SpdyFrameEncoder(spdyVersion);
        this.spdyHeaderBlockDecoder = spdyHeaderBlockDecoder;
        this.spdyHeaderBlockEncoder = spdyHeaderBlockEncoder;
        this.validateHeaders = z;
    }
}
