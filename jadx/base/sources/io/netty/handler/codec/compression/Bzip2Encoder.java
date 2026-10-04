package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.PromiseNotifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Bzip2Encoder extends MessageToByteEncoder<ByteBuf> {
    private Bzip2BlockCompressor blockCompressor;
    private volatile ChannelHandlerContext ctx;
    private State currentState;
    private volatile boolean finished;
    private final int streamBlockSize;
    private int streamCRC;
    private final Bzip2BitWriter writer;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Bzip2Encoder$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125012 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.WRITE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.CLOSE_BLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT,
        INIT_BLOCK,
        WRITE_DATA,
        CLOSE_BLOCK
    }

    public Bzip2Encoder() {
        this(9);
    }

    private void closeBlock(ByteBuf byteBuf) {
        Bzip2BlockCompressor bzip2BlockCompressor = this.blockCompressor;
        if (bzip2BlockCompressor.isEmpty()) {
            return;
        }
        bzip2BlockCompressor.close(byteBuf);
        int iCrc = bzip2BlockCompressor.crc();
        int i = this.streamCRC;
        this.streamCRC = iCrc ^ ((i >>> 31) | (i << 1));
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
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        closeBlock(byteBufBuffer);
        int i = this.streamCRC;
        Bzip2BitWriter bzip2BitWriter = this.writer;
        try {
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 1536581L);
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 3690640L);
            bzip2BitWriter.writeInt(byteBufBuffer, i);
            bzip2BitWriter.flush(byteBufBuffer);
            this.blockCompressor = null;
            return channelHandlerContext.writeAndFlush(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            this.blockCompressor = null;
            throw th;
        }
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public Bzip2Encoder(int i) {
        this.currentState = State.INIT;
        this.writer = new Bzip2BitWriter();
        if (i < 1 || i > 9) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "blockSizeMultiplier: ", " (expected: 1-9)"));
        }
        this.streamBlockSize = i * 100000;
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContextCtx = ctx();
        EventExecutor eventExecutorExecutor = channelHandlerContextCtx.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            return finishEncode(channelHandlerContextCtx, channelPromise);
        }
        eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.1
            @Override // java.lang.Runnable
            public void run() {
                Bzip2Encoder bzip2Encoder = Bzip2Encoder.this;
                PromiseNotifier.cascade(bzip2Encoder.finishEncode(bzip2Encoder.ctx(), channelPromise), channelPromise);
            }
        });
        return channelPromise;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        while (true) {
            int i = C125012.$SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[this.currentState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                    }
                    closeBlock(byteBuf2);
                    this.currentState = State.INIT_BLOCK;
                }
                if (byteBuf.isReadable()) {
                    return;
                }
                Bzip2BlockCompressor bzip2BlockCompressor = this.blockCompressor;
                byteBuf.skipBytes(bzip2BlockCompressor.write(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), bzip2BlockCompressor.availableSize())));
                if (bzip2BlockCompressor.isFull()) {
                    this.currentState = State.CLOSE_BLOCK;
                    closeBlock(byteBuf2);
                    this.currentState = State.INIT_BLOCK;
                } else if (!byteBuf.isReadable()) {
                    return;
                }
            } else {
                byteBuf2.ensureWritable(4);
                byteBuf2.writeMedium(4348520);
                byteBuf2.writeByte((this.streamBlockSize / 100000) + 48);
                this.currentState = State.INIT_BLOCK;
            }
            this.blockCompressor = new Bzip2BlockCompressor(this.writer, this.streamBlockSize);
            this.currentState = State.WRITE_DATA;
            if (byteBuf.isReadable()) {
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        EncoderUtil.closeAfterFinishEncode(channelHandlerContext, finishEncode(channelHandlerContext, channelHandlerContext.newPromise()), channelPromise);
    }
}
