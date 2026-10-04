package io.grpc.netty;

import com.google.common.base.Preconditions;
import com.google.common.p130io.BaseEncoding;
import com.microsoft.identity.client.internal.MsalUtils;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.InternalKnownTransport;
import io.grpc.InternalMethodDescriptor;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.netty.WriteQueue;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyClientStream extends AbstractClientStream {
    private static final InternalMethodDescriptor methodDescriptorAccessor;
    private AsciiString authority;
    private final MethodDescriptor<?, ?> method;
    private final AsciiString scheme;
    private final Sink sink;
    private final TransportState state;
    private final AsciiString userAgent;
    private final WriteQueue writeQueue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Sink implements AbstractClientStream.Sink {
        private Sink() {
        }

        private void writeFrameInternal(WritableBuffer writableBuffer, boolean z, boolean z2, final int i) {
            Preconditions.checkArgument(i >= 0);
            ByteBuf byteBuf = writableBuffer == null ? Unpooled.EMPTY_BUFFER : ((NettyWritableBuffer) writableBuffer).bytebuf().touch();
            final int i2 = byteBuf.readableBytes();
            if (i2 <= 0) {
                NettyClientStream.this.writeQueue.enqueue(new SendGrpcFrameCommand(NettyClientStream.this.transportState(), byteBuf, z), z2);
            } else {
                NettyClientStream.this.onSendingBytes(i2);
                NettyClientStream.this.writeQueue.enqueue(new SendGrpcFrameCommand(NettyClientStream.this.transportState(), byteBuf, z), z2).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyClientStream.Sink.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (!channelFuture.isSuccess() || NettyClientStream.this.transportState().http2Stream() == null) {
                            return;
                        }
                        NettyClientStream.this.transportState().onSentBytes(i2);
                        NettyClientStream.this.getTransportTracer().reportMessageSent(i);
                    }
                });
            }
        }

        private void writeHeadersInternal(Metadata metadata, byte[] bArr) {
            AsciiString asciiString;
            AsciiString asciiString2;
            AsciiString asciiString3 = (AsciiString) NettyClientStream.methodDescriptorAccessor.geRawMethodName(NettyClientStream.this.method);
            if (asciiString3 == null) {
                asciiString3 = new AsciiString("/" + NettyClientStream.this.method.getFullMethodName());
                NettyClientStream.methodDescriptorAccessor.setRawMethodName(NettyClientStream.this.method, asciiString3);
            }
            boolean z = bArr != null;
            if (z) {
                AsciiString asciiString4 = new AsciiString(((Object) asciiString3) + MsalUtils.QUERY_STRING_SYMBOL + BaseEncoding.base64().encode(bArr));
                asciiString = Utils.HTTP_GET_METHOD;
                asciiString2 = asciiString4;
            } else {
                asciiString = Utils.HTTP_METHOD;
                asciiString2 = asciiString3;
            }
            NettyClientStream.this.writeQueue.enqueue(new CreateStreamCommand(Utils.convertClientHeaders(metadata, NettyClientStream.this.scheme, asciiString2, NettyClientStream.this.authority, asciiString, NettyClientStream.this.userAgent), NettyClientStream.this.transportState(), NettyClientStream.this.shouldBeCountedForInUse(), z), !NettyClientStream.this.method.getType().clientSendsOneMessage() || z).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.grpc.netty.NettyClientStream.Sink.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        return;
                    }
                    Status shutdownStatus = NettyClientStream.this.transportState().handler.getLifecycleManager().getShutdownStatus();
                    if (shutdownStatus == null) {
                        shutdownStatus = NettyClientStream.this.transportState().statusFromFailedFuture(channelFuture);
                    }
                    if (NettyClientStream.this.transportState().isNonExistent()) {
                        NettyClientStream.this.transportState().transportReportStatus(shutdownStatus, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                    } else {
                        NettyClientStream.this.transportState().transportReportStatus(shutdownStatus, ClientStreamListener.RpcProgress.PROCESSED, true, new Metadata());
                    }
                }
            });
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void cancel(Status status) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientStream$Sink.cancel");
            try {
                NettyClientStream.this.writeQueue.enqueue((WriteQueue.QueuedCommand) new CancelClientStreamCommand(NettyClientStream.this.transportState(), status), true);
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

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientStream$Sink.writeFrame");
            try {
                writeFrameInternal(writableBuffer, z, z2, i);
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

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeHeaders(Metadata metadata, byte[] bArr) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("NettyClientStream$Sink.writeHeaders");
            try {
                writeHeadersInternal(metadata, bArr);
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
    public static abstract class TransportState extends Http2ClientStreamTransportState implements StreamIdHolder {
        private static final int NON_EXISTENT_ID = -1;
        private final EventLoop eventLoop;
        private final NettyClientHandler handler;
        private Http2Stream http2Stream;

        /* JADX INFO: renamed from: id */
        private int f8840id;
        private final String methodName;
        private Tag tag;

        public TransportState(NettyClientHandler nettyClientHandler, EventLoop eventLoop, int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer, String str) {
            super(i, statsTraceContext, transportTracer);
            this.methodName = (String) Preconditions.checkNotNull(str, "methodName");
            this.handler = (NettyClientHandler) Preconditions.checkNotNull(nettyClientHandler, "handler");
            this.eventLoop = (EventLoop) Preconditions.checkNotNull(eventLoop, "eventLoop");
            this.tag = PerfMark.createTag(str);
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void bytesRead(int i) {
            this.handler.returnProcessedBytes(this.http2Stream, i);
            this.handler.getWriteQueue().scheduleFlush();
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframeFailed(Throwable th) {
            http2ProcessingFailed(Status.fromThrowable(th), true, new Metadata());
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState
        public void http2ProcessingFailed(Status status, boolean z, Metadata metadata) {
            transportReportStatus(status, z, metadata);
            this.handler.getWriteQueue().enqueue((WriteQueue.QueuedCommand) new CancelClientStreamCommand(this, status), true);
        }

        @Nullable
        public Http2Stream http2Stream() {
            return this.http2Stream;
        }

        @Override // io.grpc.netty.StreamIdHolder
        /* JADX INFO: renamed from: id */
        public int mo13754id() {
            return this.f8840id;
        }

        public boolean isNonExistent() {
            int i = this.f8840id;
            return i == -1 || i == 0;
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        public void runOnTransportThread(Runnable runnable) {
            if (this.eventLoop.inEventLoop()) {
                runnable.run();
            } else {
                this.eventLoop.execute(runnable);
            }
        }

        public void setHttp2Stream(Http2Stream http2Stream) {
            Preconditions.checkNotNull(http2Stream, "http2Stream");
            Preconditions.checkState(this.http2Stream == null, "Can only set http2Stream once");
            this.http2Stream = http2Stream;
            onStreamAllocated();
            getTransportTracer().reportLocalStreamStarted();
        }

        public void setId(int i) {
            Preconditions.checkArgument(i > 0, "id must be positive %s", i);
            int i2 = this.f8840id;
            Preconditions.checkState(i2 == 0, "id has been previously set: %s", i2);
            this.f8840id = i;
            this.tag = PerfMark.createTag(this.methodName, i);
        }

        public void setNonExistent() {
            int i = this.f8840id;
            Preconditions.checkState(i == 0, "Id has been previously set: %s", i);
            this.f8840id = -1;
        }

        public abstract Status statusFromFailedFuture(ChannelFuture channelFuture);

        @Override // io.grpc.netty.StreamIdHolder
        public final Tag tag() {
            return this.tag;
        }

        public void transportDataReceived(ByteBuf byteBuf, boolean z) {
            transportDataReceived(new NettyReadableBuffer(byteBuf.retain()), z);
        }

        public void transportHeadersReceived(Http2Headers http2Headers, boolean z) {
            if (!z) {
                transportHeadersReceived(Utils.convertHeaders(http2Headers));
                return;
            }
            if (!isOutboundClosed()) {
                this.handler.getWriteQueue().enqueue((WriteQueue.QueuedCommand) new CancelClientStreamCommand(this, null), true);
            }
            transportTrailersReceived(Utils.convertTrailers(http2Headers));
        }
    }

    static {
        methodDescriptorAccessor = new InternalMethodDescriptor(NettyClientTransport.class.getName().contains("grpc.netty.shaded") ? InternalKnownTransport.NETTY_SHADED : InternalKnownTransport.NETTY);
    }

    public NettyClientStream(TransportState transportState, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, Channel channel, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, StatsTraceContext statsTraceContext, TransportTracer transportTracer, CallOptions callOptions, boolean z) {
        super(new NettyWritableBufferAllocator(channel.alloc()), statsTraceContext, transportTracer, metadata, callOptions, z && methodDescriptor.isSafe());
        this.sink = new Sink();
        this.state = (TransportState) Preconditions.checkNotNull(transportState, "transportState");
        this.writeQueue = transportState.handler.getWriteQueue();
        this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, "method");
        this.authority = (AsciiString) Preconditions.checkNotNull(asciiString, "authority");
        this.scheme = (AsciiString) Preconditions.checkNotNull(asciiString2, "scheme");
        this.userAgent = asciiString3;
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return this.state.handler.getAttributes();
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        this.authority = AsciiString.m13777of((CharSequence) Preconditions.checkNotNull(str, "authority"));
    }

    @Override // io.grpc.internal.AbstractClientStream
    public Sink abstractClientStreamSink() {
        return this.sink;
    }

    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.AbstractStream
    public TransportState transportState() {
        return this.state;
    }
}
