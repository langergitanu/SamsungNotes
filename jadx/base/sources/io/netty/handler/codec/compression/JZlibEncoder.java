package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class JZlibEncoder extends ZlibEncoder {
    private static final int THREAD_POOL_DELAY_SECONDS = 10;
    private volatile ChannelHandlerContext ctx;
    private volatile boolean finished;
    private final int wrapperOverhead;

    /* JADX INFO: renamed from: z */
    private final Deflater f8884z;

    public JZlibEncoder() {
        this(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        try {
            this.f8884z.next_in = EmptyArrays.EMPTY_BYTES;
            this.f8884z.next_in_index = 0;
            this.f8884z.avail_in = 0;
            byte[] bArr = new byte[32];
            this.f8884z.next_out = bArr;
            this.f8884z.next_out_index = 0;
            this.f8884z.avail_out = 32;
            int iDeflate = this.f8884z.deflate(4);
            if (iDeflate != 0 && iDeflate != 1) {
                channelPromise.setFailure((Throwable) ZlibUtil.deflaterException(this.f8884z, "compression failure", iDeflate));
                return channelPromise;
            }
            ByteBuf byteBufWrappedBuffer = this.f8884z.next_out_index != 0 ? Unpooled.wrappedBuffer(bArr, 0, this.f8884z.next_out_index) : Unpooled.EMPTY_BUFFER;
            this.f8884z.deflateEnd();
            this.f8884z.next_in = null;
            this.f8884z.next_out = null;
            return channelHandlerContext.writeAndFlush(byteBufWrappedBuffer, channelPromise);
        } finally {
            this.f8884z.deflateEnd();
            this.f8884z.next_in = null;
            this.f8884z.next_out = null;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close() {
        return close(ctx().channel().newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibEncoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContextCtx = ctx();
        EventExecutor eventExecutorExecutor = channelHandlerContextCtx.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            return finishEncode(channelHandlerContextCtx, channelPromise);
        }
        final ChannelPromise channelPromiseNewPromise = channelHandlerContextCtx.newPromise();
        eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.JZlibEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                JZlibEncoder jZlibEncoder = JZlibEncoder.this;
                PromiseNotifier.cascade(jZlibEncoder.finishEncode(jZlibEncoder.ctx(), channelPromiseNewPromise), channelPromise);
            }
        });
        return channelPromiseNewPromise;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int i = byteBuf.readableBytes();
        if (i == 0) {
            return;
        }
        try {
            boolean zHasArray = byteBuf.hasArray();
            this.f8884z.avail_in = i;
            if (zHasArray) {
                this.f8884z.next_in = byteBuf.array();
                this.f8884z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[i];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.f8884z.next_in = bArr;
                this.f8884z.next_in_index = 0;
            }
            int i2 = this.f8884z.next_in_index;
            int iCeil = ((int) Math.ceil(((double) i) * 1.001d)) + 12 + this.wrapperOverhead;
            byteBuf2.ensureWritable(iCeil);
            this.f8884z.avail_out = iCeil;
            this.f8884z.next_out = byteBuf2.array();
            this.f8884z.next_out_index = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
            int i4 = this.f8884z.next_out_index;
            try {
                int iDeflate = this.f8884z.deflate(2);
                if (iDeflate != 0) {
                    ZlibUtil.fail(this.f8884z, "compression failure", iDeflate);
                }
                int i5 = this.f8884z.next_out_index - i4;
                if (i5 > 0) {
                    byteBuf2.writerIndex(byteBuf2.writerIndex() + i5);
                }
                this.f8884z.next_in = null;
                this.f8884z.next_out = null;
            } finally {
                byteBuf.skipBytes(this.f8884z.next_in_index - i2);
            }
        } catch (Throwable th) {
            this.f8884z.next_in = null;
            this.f8884z.next_out = null;
            throw th;
        }
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        this(zlibWrapper, i, 15, 8);
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper, int i, int i2, int i4) {
        Deflater deflater = new Deflater();
        this.f8884z = deflater;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        ObjectUtil.checkInRange(i4, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        ZlibWrapper zlibWrapper2 = ZlibWrapper.ZLIB_OR_NONE;
        if (zlibWrapper != zlibWrapper2) {
            int iInit = deflater.init(i, i2, i4, ZlibUtil.convertWrapperType(zlibWrapper));
            if (iInit != 0) {
                ZlibUtil.fail(deflater, "initialization failure", iInit);
            }
            this.wrapperOverhead = ZlibUtil.wrapperOverhead(zlibWrapper);
            return;
        }
        throw new IllegalArgumentException("wrapper '" + zlibWrapper2 + "' is not allowed for compression.");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureFinishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        if (!channelFutureFinishEncode.isDone()) {
            final ScheduledFuture<?> scheduledFutureSchedule = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.JZlibEncoder.2
                @Override // java.lang.Runnable
                public void run() {
                    if (channelPromise.isDone()) {
                        return;
                    }
                    channelHandlerContext.close(channelPromise);
                }
            }, 10L, TimeUnit.SECONDS);
            channelFutureFinishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.JZlibEncoder.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    scheduledFutureSchedule.cancel(true);
                    if (channelPromise.isDone()) {
                        return;
                    }
                    channelHandlerContext.close(channelPromise);
                }
            });
        } else {
            channelHandlerContext.close(channelPromise);
        }
    }

    public JZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public JZlibEncoder(int i, byte[] bArr) {
        this(i, 15, 8, bArr);
    }

    public JZlibEncoder(int i, int i2, int i4, byte[] bArr) {
        Deflater deflater = new Deflater();
        this.f8884z = deflater;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        ObjectUtil.checkInRange(i4, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(bArr, "dictionary");
        int iDeflateInit = deflater.deflateInit(i, i2, i4, JZlib.W_ZLIB);
        if (iDeflateInit != 0) {
            ZlibUtil.fail(deflater, "initialization failure", iDeflateInit);
        } else {
            int iDeflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
            if (iDeflateSetDictionary != 0) {
                ZlibUtil.fail(deflater, "failed to set the dictionary", iDeflateSetDictionary);
            }
        }
        this.wrapperOverhead = ZlibUtil.wrapperOverhead(ZlibWrapper.ZLIB);
    }
}
