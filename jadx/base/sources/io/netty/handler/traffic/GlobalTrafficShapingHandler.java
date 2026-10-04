package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues;
    long maxGlobalWriteSize;
    private final AtomicLong queuesSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        private PerChannel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long j, Object obj, long j2, ChannelPromise channelPromise) {
            this.relativeTimeAction = j;
            this.toSend = obj;
            this.size = j2;
            this.promise = channelPromise;
        }
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3, long j5) {
        super(j, j2, j3, j5);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer numValueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(numValueOf);
        if (perChannel != null) {
            return perChannel;
        }
        PerChannel perChannel2 = new PerChannel();
        perChannel2.messagesQueue = new ArrayDeque<>();
        perChannel2.queueSize = 0L;
        long jMilliSecondFromNano = TrafficCounter.milliSecondFromNano();
        perChannel2.lastReadTimestamp = jMilliSecondFromNano;
        perChannel2.lastWriteTimestamp = jMilliSecondFromNano;
        this.channelQueues.put(numValueOf, perChannel2);
        return perChannel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, PerChannel perChannel, long j) {
        synchronized (perChannel) {
            try {
                ToSend toSendPollFirst = perChannel.messagesQueue.pollFirst();
                while (true) {
                    if (toSendPollFirst != null) {
                        if (toSendPollFirst.relativeTimeAction > j) {
                            perChannel.messagesQueue.addFirst(toSendPollFirst);
                            break;
                        }
                        long j2 = toSendPollFirst.size;
                        this.trafficCounter.bytesRealWriteFlowControl(j2);
                        perChannel.queueSize -= j2;
                        this.queuesSize.addAndGet(-j2);
                        channelHandlerContext.write(toSendPollFirst.toSend, toSendPollFirst.promise);
                        perChannel.lastWriteTimestamp = j;
                        toSendPollFirst = perChannel.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (perChannel.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        return (perChannel == null || j <= this.maxTime || (j2 + j) - perChannel.lastReadTimestamp <= this.maxTime) ? j : this.maxTime;
    }

    public void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        TrafficCounter trafficCounter = new TrafficCounter(this, (ScheduledExecutorService) ObjectUtil.checkNotNull(scheduledExecutorService, "executor"), "GlobalTC", this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        getOrSetPerChannel(channelHandlerContext);
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        PerChannel perChannelRemove = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (perChannelRemove != null) {
            synchronized (perChannelRemove) {
                try {
                    if (channel.isActive()) {
                        for (ToSend toSend : perChannelRemove.messagesQueue) {
                            long jCalculateSize = calculateSize(toSend.toSend);
                            this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                            perChannelRemove.queueSize -= jCalculateSize;
                            this.queuesSize.addAndGet(-jCalculateSize);
                            channelHandlerContext.write(toSend.toSend, toSend.promise);
                        }
                    } else {
                        this.queuesSize.addAndGet(-perChannelRemove.queueSize);
                        Iterator<ToSend> it = perChannelRemove.messagesQueue.iterator();
                        while (it.hasNext()) {
                            Object obj = it.next().toSend;
                            if (obj instanceof ByteBuf) {
                                ((ByteBuf) obj).release();
                            }
                        }
                    }
                    perChannelRemove.messagesQueue.clear();
                } finally {
                }
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void informReadOperation(ChannelHandlerContext channelHandlerContext, long j) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j;
        }
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j) {
        this.maxGlobalWriteSize = j;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise) throws Throwable {
        PerChannel orSetPerChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (orSetPerChannel == null) {
            orSetPerChannel = getOrSetPerChannel(channelHandlerContext);
        }
        final PerChannel perChannel = orSetPerChannel;
        synchronized (perChannel) {
            if (j2 == 0) {
                try {
                    if (perChannel.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j);
                        channelHandlerContext.write(obj, channelPromise);
                        perChannel.lastWriteTimestamp = j3;
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            long j5 = (j2 <= this.maxTime || (j3 + j2) - perChannel.lastWriteTimestamp <= this.maxTime) ? j2 : this.maxTime;
            ToSend toSend = new ToSend(j5 + j3, obj, j, channelPromise);
            perChannel.messagesQueue.addLast(toSend);
            perChannel.queueSize += j;
            this.queuesSize.addAndGet(j);
            long j6 = j5;
            checkWriteSuspend(channelHandlerContext, j6, perChannel.queueSize);
            boolean z = this.queuesSize.get() > this.maxGlobalWriteSize;
            if (z) {
                setUserDefinedWritability(channelHandlerContext, false);
            }
            final long j7 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel, j7);
                }
            }, j6, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public int userDefinedWritabilityIndex() {
        return 2;
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3) {
        super(j, j2, j3);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2) {
        super(j, j2);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j) {
        super(j);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(eventExecutor);
    }
}
