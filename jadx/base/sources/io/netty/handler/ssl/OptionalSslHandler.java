package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class OptionalSslHandler extends ByteToMessageDecoder {
    private final SslContext sslContext;

    public OptionalSslHandler(SslContext sslContext) {
        this.sslContext = (SslContext) ObjectUtil.checkNotNull(sslContext, "sslContext");
    }

    private void handleNonSsl(ChannelHandlerContext channelHandlerContext) {
        ChannelHandler channelHandlerNewNonSslHandler = newNonSslHandler(channelHandlerContext);
        if (channelHandlerNewNonSslHandler != null) {
            channelHandlerContext.pipeline().replace(this, newNonSslHandlerName(), channelHandlerNewNonSslHandler);
        } else {
            channelHandlerContext.pipeline().remove(this);
        }
    }

    private void handleSsl(ChannelHandlerContext channelHandlerContext) {
        SslHandler sslHandlerNewSslHandler = null;
        try {
            sslHandlerNewSslHandler = newSslHandler(channelHandlerContext, this.sslContext);
            channelHandlerContext.pipeline().replace(this, newSslHandlerName(), sslHandlerNewSslHandler);
        } catch (Throwable th) {
            if (sslHandlerNewSslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandlerNewSslHandler.engine());
            }
            throw th;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.readableBytes() < 5) {
            return;
        }
        if (SslHandler.isEncrypted(byteBuf)) {
            handleSsl(channelHandlerContext);
        } else {
            handleNonSsl(channelHandlerContext);
        }
    }

    public ChannelHandler newNonSslHandler(ChannelHandlerContext channelHandlerContext) {
        return null;
    }

    public String newNonSslHandlerName() {
        return null;
    }

    public SslHandler newSslHandler(ChannelHandlerContext channelHandlerContext, SslContext sslContext) {
        return sslContext.newHandler(channelHandlerContext.alloc());
    }

    public String newSslHandlerName() {
        return null;
    }
}
