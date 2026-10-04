package io.netty.channel.nio;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + SQLKeyword.COMMA + StringUtil.simpleClassName((Class<?>) FileRegion.class) + PropertyUtils.MAPPED_DELIM2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                if (AbstractNioByteChannel.this.inputClosedSeenErrorOnRead) {
                    return;
                }
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (!AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                close(voidPromise());
            } else {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            if (r7.lastBytesRead() >= 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        
            if (r8 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        
            r9.this$0.readPending = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        
            r2 = r9;
            r5 = r0;
            r6 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        
            r2 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        
            r2.handleReadException(r3, r4, r5, r6, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x009e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x009f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a4, code lost:
        
            if (r2.this$0.readPending == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00ac, code lost:
        
            removeReadOp();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        
            return;
         */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void read() {
            boolean z;
            Throwable th;
            boolean z2;
            NioByteUnsafe nioByteUnsafe;
            ChannelConfig channelConfigConfig = AbstractNioByteChannel.this.config();
            if (AbstractNioByteChannel.this.shouldBreakReadReady(channelConfigConfig)) {
                AbstractNioByteChannel.this.clearReadPending();
                return;
            }
            ChannelPipeline channelPipelinePipeline = AbstractNioByteChannel.this.pipeline();
            ByteBufAllocator allocator = channelConfigConfig.getAllocator();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            while (true) {
                z = false;
                ByteBuf byteBuf = null;
                try {
                    ByteBuf byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                    try {
                        handleRecvBufAllocHandle.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBufAllocate));
                        boolean z3 = true;
                        if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                            break;
                        }
                        handleRecvBufAllocHandle.incMessagesRead(1);
                        AbstractNioByteChannel.this.readPending = false;
                        channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                        if (!handleRecvBufAllocHandle.continueReading()) {
                            break;
                        }
                    } catch (Throwable th2) {
                        z2 = false;
                        byteBuf = byteBufAllocate;
                        nioByteUnsafe = this;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z;
                    nioByteUnsafe = this;
                }
            }
            handleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (z) {
                closeOnRead(channelPipelinePipeline);
            }
            if (AbstractNioByteChannel.this.readPending || channelConfigConfig.isAutoRead()) {
                return;
            }
            removeReadOp();
        }
    }

    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int iDoWriteBytes = doWriteBytes(byteBuf);
            if (iDoWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(iDoWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (!(obj instanceof FileRegion)) {
            throw new Error();
        }
        FileRegion fileRegion = (FileRegion) obj;
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long jDoWriteFileRegion = doWriteFileRegion(fileRegion);
        if (jDoWriteFileRegion <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(jDoWriteFileRegion);
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf);

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, objCurrent);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    public abstract int doWriteBytes(ByteBuf byteBuf);

    public abstract long doWriteFileRegion(FileRegion fileRegion);

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
        } else {
            clearOpWrite();
            eventLoop().execute(this.flushTask);
        }
    }

    public boolean isInputShutdown0() {
        return false;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKey.interestOps(iInterestOps | 4);
            }
        }
    }

    public final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        if (isInputShutdown0()) {
            return this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig);
        }
        return false;
    }

    public abstract ChannelFuture shutdownInput();

    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }
}
