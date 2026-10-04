package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractCoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractCoalescingBufferQueue.class);
    private final ArrayDeque<Object> bufAndListenerPairs;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    public AbstractCoalescingBufferQueue(Channel channel, int i) {
        this.bufAndListenerPairs = new ArrayDeque<>(i);
        this.tracker = channel == null ? null : PendingBytesTracker.newTracker(channel);
    }

    private void decrementReadableBytes(int i) {
        this.readableBytes -= i;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.decrementPendingOutboundBytes(i);
        }
    }

    private void incrementReadableBytes(int i) {
        int i2 = this.readableBytes;
        int i4 = i2 + i;
        if (i4 < i2) {
            throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + i);
        }
        this.readableBytes = i4;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.incrementPendingOutboundBytes(i);
        }
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        Throwable th = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    ByteBuf byteBuf = (ByteBuf) objPoll;
                    decrementReadableBytes(byteBuf.readableBytes());
                    ReferenceCountUtil.safeRelease(byteBuf);
                } else {
                    ((ChannelFutureListener) objPoll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
                }
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise) {
        if (channelPromise.isVoid()) {
            return null;
        }
        return new DelegatingChannelPromiseNotifier(channelPromise);
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public final void addFirst(ByteBuf byteBuf, ChannelPromise channelPromise) {
        addFirst(byteBuf, toChannelFutureListener(channelPromise));
    }

    public abstract ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);

    public final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        CompositeByteBuf compositeByteBufCompositeBuffer = byteBufAllocator.compositeBuffer(size() + 2);
        try {
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf);
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf2);
            return compositeByteBufCompositeBuffer;
        } catch (Throwable th) {
            compositeByteBufCompositeBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
            return compositeByteBufCompositeBuffer;
        }
    }

    public final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        ByteBuf byteBufIoBuffer = byteBufAllocator.ioBuffer(byteBuf2.readableBytes() + byteBuf.readableBytes());
        try {
            byteBufIoBuffer.writeBytes(byteBuf).writeBytes(byteBuf2);
        } catch (Throwable th) {
            byteBufIoBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        byteBuf.release();
        byteBuf2.release();
        return byteBufIoBuffer;
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue) {
        abstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker, Throwable th) {
        releaseAndCompleteAll(channelOutboundInvoker.newFailedFuture(th));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r5.bufAndListenerPairs.addFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r1 <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r0 = r3.readRetainedSlice(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (r2 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r6 = composeFirst(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        r6 = compose(r6, r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ByteBuf remove(ByteBufAllocator byteBufAllocator, int i, ChannelPromise channelPromise) throws Throwable {
        ObjectUtil.checkPositiveOrZero(i, "bytes");
        ObjectUtil.checkNotNull(channelPromise, "aggregatePromise");
        if (this.bufAndListenerPairs.isEmpty()) {
            return removeEmptyValue();
        }
        int iMin = Math.min(i, this.readableBytes);
        ByteBuf byteBuf = null;
        int i2 = iMin;
        ByteBuf byteBufComposeFirst = null;
        while (true) {
            try {
                Object objPoll = this.bufAndListenerPairs.poll();
                if (objPoll == null) {
                    break;
                }
                if (objPoll instanceof ChannelFutureListener) {
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) objPoll);
                } else {
                    ByteBuf byteBuf2 = (ByteBuf) objPoll;
                    try {
                        if (byteBuf2.readableBytes() > i2) {
                            break;
                        }
                        i2 -= byteBuf2.readableBytes();
                        byteBufComposeFirst = byteBufComposeFirst == null ? composeFirst(byteBufAllocator, byteBuf2) : compose(byteBufAllocator, byteBufComposeFirst, byteBuf2);
                    } catch (Throwable th) {
                        th = th;
                        byteBuf = byteBuf2;
                        ReferenceCountUtil.safeRelease(byteBuf);
                        ReferenceCountUtil.safeRelease(byteBufComposeFirst);
                        channelPromise.setFailure(th);
                        PlatformDependent.throwException(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        decrementReadableBytes(iMin - i2);
        return byteBufComposeFirst;
    }

    public abstract ByteBuf removeEmptyValue();

    public final ByteBuf removeFirst(ChannelPromise channelPromise) {
        Object objPoll = this.bufAndListenerPairs.poll();
        if (objPoll == null) {
            return null;
        }
        ByteBuf byteBuf = (ByteBuf) objPoll;
        decrementReadableBytes(byteBuf.readableBytes());
        Object objPeek = this.bufAndListenerPairs.peek();
        if (objPeek instanceof ChannelFutureListener) {
            channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) objPeek);
            this.bufAndListenerPairs.poll();
        }
        return byteBuf;
    }

    public final int size() {
        return this.bufAndListenerPairs.size();
    }

    public String toString() {
        return "bytes: " + this.readableBytes + " buffers: " + (size() >> 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void writeAndRemoveAll(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = null;
        Throwable th = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                if (byteBuf == null) {
                    break;
                }
                decrementReadableBytes(byteBuf.readableBytes());
                channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    if (byteBuf != null) {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                    }
                    byteBuf = (ByteBuf) objPoll;
                } else {
                    if (objPoll instanceof ChannelPromise) {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf, (ChannelPromise) objPoll);
                    } else {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf).addListener((GenericFutureListener<? extends Future<? super Void>>) objPoll);
                    }
                    byteBuf = null;
                }
            } catch (Throwable th2) {
                if (th != null) {
                }
            }
            if (th != null) {
                th = th2;
            } else {
                logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    private void addFirst(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener);
        }
        this.bufAndListenerPairs.addFirst(byteBuf);
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        add(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        return byteBuf;
    }
}
