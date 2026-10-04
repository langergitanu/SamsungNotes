package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractServerStream;
import io.grpc.internal.ReadableBuffer;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.netty.WriteQueue;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyServerStream extends AbstractServerStream {
    private static final Logger log = Logger.getLogger(NettyServerStream.class.getName());
    private final Attributes attributes;
    private final String authority;
    private final Sink sink;
    private final TransportState state;
    private final int streamId;
    private final TransportTracer transportTracer;
    private final WriteQueue writeQueue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Sink implements AbstractServerStream.Sink {
        private Sink() {
        }

        private void writeFrameInternal(WritableBuffer writableBuffer, boolean z, final int i) {
            Preconditions.checkArgument(i >= 0);
            ByteBuf byteBuf = ((NettyWritableBuffer) writableBuffer).bytebuf().touch();
            final int i2 = byteBuf.readableBytes();
            NettyServerStream.this.onSendingBytes(i2);
            NettyServerStream.this.writeQueue.enqueue(new SendGrpcFrameCommand(NettyServerStream.this.transportState(), byteBuf, false), z).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyServerStream.Sink.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    NettyServerStream.this.transportState().onSentBytes(i2);
                    if (channelFuture.isSuccess()) {
                        NettyServerStream.this.transportTracer.reportMessageSent(i);
                    }
                }
            });
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void cancel(Status status) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerStream$Sink.cancel");
            try {
                NettyServerStream.this.writeQueue.enqueue((WriteQueue.QueuedCommand) new CancelServerStreamCommand(NettyServerStream.this.transportState(), status), true);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z, int i) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerStream$Sink.writeFrame");
            try {
                writeFrameInternal(writableBuffer, z, i);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeHeaders(Metadata metadata) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerStream$Sink.writeHeaders");
            try {
                NettyServerStream.this.writeQueue.enqueue((WriteQueue.QueuedCommand) SendResponseHeadersCommand.createHeaders(NettyServerStream.this.transportState(), Utils.convertServerHeaders(metadata)), true);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeTrailers(Metadata metadata, boolean z, Status status) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerStream$Sink.writeTrailers");
            try {
                NettyServerStream.this.writeQueue.enqueue((WriteQueue.QueuedCommand) SendResponseHeadersCommand.createTrailers(NettyServerStream.this.transportState(), Utils.convertTrailers(metadata, z), status), true);
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TransportState extends AbstractServerStream.TransportState implements StreamIdHolder {
        private final EventLoop eventLoop;
        private final NettyServerHandler handler;
        private final Http2Stream http2Stream;
        private final Tag tag;

        public TransportState(NettyServerHandler nettyServerHandler, EventLoop eventLoop, Http2Stream http2Stream, int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer, String str) {
            super(i, statsTraceContext, transportTracer);
            this.http2Stream = (Http2Stream) Preconditions.checkNotNull(http2Stream, "http2Stream");
            this.handler = (NettyServerHandler) Preconditions.checkNotNull(nettyServerHandler, "handler");
            this.eventLoop = eventLoop;
            this.tag = PerfMark.createTag(str, http2Stream.mo13773id());
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void bytesRead(int i) {
            this.handler.returnProcessedBytes(this.http2Stream, i);
            this.handler.getWriteQueue().scheduleFlush();
        }

        @Override // io.grpc.internal.AbstractServerStream.TransportState
        public /* bridge */ /* synthetic */ void complete() {
            super.complete();
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframeFailed(Throwable th) {
            NettyServerStream.log.log(Level.WARNING, "Exception processing message", th);
            Status statusFromThrowable = Status.fromThrowable(th);
            transportReportStatus(statusFromThrowable);
            this.handler.getWriteQueue().enqueue((WriteQueue.QueuedCommand) new CancelServerStreamCommand(this, statusFromThrowable), true);
        }

        @Override // io.grpc.internal.AbstractServerStream.TransportState, io.grpc.internal.MessageDeframer.Listener
        public /* bridge */ /* synthetic */ void deframerClosed(boolean z) {
            super.deframerClosed(z);
        }

        @Override // io.grpc.netty.StreamIdHolder
        /* JADX INFO: renamed from: id */
        public int mo13754id() {
            return this.http2Stream.mo13773id();
        }

        @Override // io.grpc.internal.AbstractServerStream.TransportState
        public /* bridge */ /* synthetic */ void inboundDataReceived(ReadableBuffer readableBuffer, boolean z) {
            super.inboundDataReceived(readableBuffer, z);
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        public void runOnTransportThread(final Runnable runnable) {
            if (this.eventLoop.inEventLoop()) {
                runnable.run();
            } else {
                final Link linkLinkOut = PerfMark.linkOut();
                this.eventLoop.execute(new Runnable() { // from class: io.grpc.netty.NettyServerStream.TransportState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyServerStream$TransportState.runOnTransportThread");
                        try {
                            PerfMark.attachTag(TransportState.this.tag);
                            PerfMark.linkIn(linkLinkOut);
                            runnable.run();
                            if (taskCloseableTraceTask != null) {
                                taskCloseableTraceTask.close();
                            }
                        } catch (Throwable th) {
                            if (taskCloseableTraceTask != null) {
                                try {
                                    taskCloseableTraceTask.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                });
            }
        }

        @Override // io.grpc.netty.StreamIdHolder
        public Tag tag() {
            return this.tag;
        }

        public void inboundDataReceived(ByteBuf byteBuf, boolean z) {
            super.inboundDataReceived(new NettyReadableBuffer(byteBuf.retain()), z);
        }
    }

    public NettyServerStream(Channel channel, TransportState transportState, Attributes attributes, String str, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(new NettyWritableBufferAllocator(channel.alloc()), statsTraceContext);
        this.sink = new Sink();
        this.state = (TransportState) Preconditions.checkNotNull(transportState, "transportState");
        this.writeQueue = transportState.handler.getWriteQueue();
        this.attributes = (Attributes) Preconditions.checkNotNull(attributes);
        this.authority = str;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
        this.streamId = transportState().mo13754id();
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.ServerStream
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.internal.ServerStream
    public int streamId() {
        return this.streamId;
    }

    @Override // io.grpc.internal.AbstractServerStream
    public Sink abstractServerStreamSink() {
        return this.sink;
    }

    @Override // io.grpc.internal.AbstractServerStream, io.grpc.internal.AbstractStream
    public TransportState transportState() {
        return this.state;
    }
}
