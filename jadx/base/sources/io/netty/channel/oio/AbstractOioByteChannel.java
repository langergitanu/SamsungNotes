package io.netty.channel.oio;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + SQLKeyword.COMMA + StringUtil.simpleClassName((Class<?>) FileRegion.class) + PropertyUtils.MAPPED_DELIM2;

    public AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
            channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                this.readPending = false;
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

    public abstract int available();

    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r5.isReadable() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        r5.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r8.lastBytesRead() >= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r9 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        r11.readPending = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        r5 = r3;
        r2 = r6;
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r7 = false;
        r5 = null;
        r2 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2 A[DONT_GENERATE] */
    @Override // io.netty.channel.oio.AbstractOioChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doRead() {
        Throwable th;
        boolean z;
        ByteBuf byteBufAllocate;
        AbstractOioByteChannel abstractOioByteChannel;
        boolean z2;
        ChannelConfig channelConfigConfig = config();
        if (!isInputShutdown() && this.readPending) {
            boolean z3 = false;
            this.readPending = false;
            ChannelPipeline channelPipelinePipeline = pipeline();
            ByteBufAllocator allocator = channelConfigConfig.getAllocator();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            ByteBuf byteBuf = null;
            try {
                byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                boolean z4 = false;
                while (true) {
                    try {
                        handleRecvBufAllocHandle.lastBytesRead(doReadBytes(byteBufAllocate));
                        z2 = true;
                        if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                            break;
                        }
                        try {
                            int iAvailable = available();
                            if (iAvailable <= 0) {
                                break;
                            }
                            if (!byteBufAllocate.isWritable()) {
                                int iCapacity = byteBufAllocate.capacity();
                                int iMaxCapacity = byteBufAllocate.maxCapacity();
                                if (iCapacity == iMaxCapacity) {
                                    handleRecvBufAllocHandle.incMessagesRead(1);
                                    this.readPending = false;
                                    channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                                    byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                                } else if (byteBufAllocate.writerIndex() + iAvailable > iMaxCapacity) {
                                    byteBufAllocate.capacity(iMaxCapacity);
                                } else {
                                    byteBufAllocate.ensureWritable(iAvailable);
                                }
                            }
                            if (!handleRecvBufAllocHandle.continueReading()) {
                                break;
                            } else {
                                z4 = true;
                            }
                        } catch (Throwable th2) {
                            abstractOioByteChannel = this;
                            th = th2;
                            z = false;
                            z3 = true;
                            try {
                                abstractOioByteChannel.handleReadException(channelPipelinePipeline, byteBufAllocate, th, z, handleRecvBufAllocHandle);
                                return;
                            } finally {
                                if (abstractOioByteChannel.readPending || channelConfigConfig.isAutoRead() || (!z3 && isActive())) {
                                    read();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        abstractOioByteChannel = this;
                        z = false;
                        z3 = z4;
                    }
                }
                z4 = true;
                z2 = false;
                if (byteBufAllocate != null) {
                    try {
                        if (byteBufAllocate.isReadable()) {
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                        } else {
                            byteBufAllocate.release();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        abstractOioByteChannel = this;
                        z3 = z4;
                        z = z2;
                        th = th;
                        abstractOioByteChannel.handleReadException(channelPipelinePipeline, byteBufAllocate, th, z, handleRecvBufAllocHandle);
                        return;
                    }
                } else {
                    byteBuf = byteBufAllocate;
                }
                if (z4) {
                    handleRecvBufAllocHandle.readComplete();
                    channelPipelinePipeline.fireChannelReadComplete();
                }
                if (z2) {
                    closeOnRead(channelPipelinePipeline);
                }
                if (this.readPending || channelConfigConfig.isAutoRead() || (!z4 && isActive())) {
                    read();
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
                byteBufAllocate = null;
                abstractOioByteChannel = this;
            }
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf);

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                return;
            }
            if (objCurrent instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) objCurrent;
                int i = byteBuf.readableBytes();
                while (i > 0) {
                    doWriteBytes(byteBuf);
                    int i2 = byteBuf.readableBytes();
                    channelOutboundBuffer.progress(i - i2);
                    i = i2;
                }
                channelOutboundBuffer.remove();
            } else if (objCurrent instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) objCurrent;
                long jTransferred = fileRegion.transferred();
                doWriteFileRegion(fileRegion);
                channelOutboundBuffer.progress(fileRegion.transferred() - jTransferred);
                channelOutboundBuffer.remove();
            } else {
                channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(objCurrent)));
            }
        }
    }

    public abstract void doWriteBytes(ByteBuf byteBuf);

    public abstract void doWriteFileRegion(FileRegion fileRegion);

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if ((obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public abstract boolean isInputShutdown();

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public abstract ChannelFuture shutdownInput();
}
