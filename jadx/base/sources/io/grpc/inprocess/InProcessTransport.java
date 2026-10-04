package io.grpc.inprocess;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.InsightBuilder;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
    private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    private final SocketAddress address;
    private final Attributes attributes;
    private final String authority;
    private final int clientMaxInboundMetadataSize;
    private ManagedClientTransport.Listener clientTransportListener;

    @GuardedBy("this")
    private final InUseStateAggregator<InProcessStream> inUseState;
    private final boolean includeCauseWithStatus;
    private final InternalLogId logId;
    private final Optional<ServerListener> optionalServerListener;
    private int serverMaxInboundMetadataSize;
    private ScheduledExecutorService serverScheduler;
    private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
    private Attributes serverStreamAttributes;

    @GuardedBy("this")
    private List<ServerStreamTracer.Factory> serverStreamTracerFactories;
    private ServerTransportListener serverTransportListener;

    @GuardedBy("this")
    private boolean shutdown;

    @GuardedBy("this")
    private Status shutdownStatus;

    @GuardedBy("this")
    private final Set<InProcessStream> streams;

    @GuardedBy("this")
    private boolean terminated;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final String userAgent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class InProcessStream {
        private volatile String authority;
        private final CallOptions callOptions;
        private final InProcessClientStream clientStream;
        private final Metadata headers;
        private final MethodDescriptor<?, ?> method;
        private final InProcessServerStream serverStream;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class InProcessClientStream implements ClientStream {
            final CallOptions callOptions;

            @GuardedBy("this")
            private boolean closed;

            @GuardedBy("this")
            private int outboundSeqNo;

            @GuardedBy("this")
            private boolean serverNotifyHalfClose;

            @GuardedBy("this")
            private ArrayDeque<StreamListener.MessageProducer> serverReceiveQueue = new ArrayDeque<>();

            @GuardedBy("this")
            private int serverRequested;
            private ServerStreamListener serverStreamListener;
            final StatsTraceContext statsTraceCtx;
            private final SynchronizationContext syncContext;

            public InProcessClientStream(CallOptions callOptions, StatsTraceContext statsTraceContext) {
                this.syncContext = new SynchronizationContext(InProcessTransport.this.uncaughtExceptionHandler);
                this.callOptions = callOptions;
                this.statsTraceCtx = statsTraceContext;
            }

            private boolean internalCancel(Status status, Status status2) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return false;
                        }
                        this.closed = true;
                        while (true) {
                            StreamListener.MessageProducer messageProducerPoll = this.serverReceiveQueue.poll();
                            if (messageProducerPoll == null) {
                                InProcessStream.this.serverStream.statsTraceCtx.streamClosed(status2);
                                this.syncContext.executeLater(new RunnableC12075c(this, status, 0));
                                this.syncContext.drain();
                                return true;
                            }
                            while (true) {
                                InputStream next = messageProducerPoll.next();
                                if (next != null) {
                                    try {
                                        next.close();
                                    } catch (Throwable th) {
                                        InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$halfClose$5() {
                this.serverStreamListener.halfClosed();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$internalCancel$4(Status status) {
                this.serverStreamListener.closed(status);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$request$0() {
                this.serverStreamListener.onReady();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$serverRequested$1(StreamListener.MessageProducer messageProducer) {
                this.serverStreamListener.messagesAvailable(messageProducer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$serverRequested$2() {
                this.serverStreamListener.halfClosed();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$writeMessage$3(StreamListener.MessageProducer messageProducer) {
                this.serverStreamListener.messagesAvailable(messageProducer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void serverClosed(Status status, Status status2) {
                internalCancel(status, status2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean serverRequested(int i) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return false;
                        }
                        int i2 = this.serverRequested;
                        boolean z = i2 > 0;
                        this.serverRequested = i2 + i;
                        while (this.serverRequested > 0 && !this.serverReceiveQueue.isEmpty()) {
                            this.serverRequested--;
                            this.syncContext.executeLater(new RunnableC12074b(this, this.serverReceiveQueue.poll(), 1));
                        }
                        if (this.serverReceiveQueue.isEmpty() && this.serverNotifyHalfClose) {
                            this.serverNotifyHalfClose = false;
                            this.syncContext.executeLater(new RunnableC12073a(this, 2));
                        }
                        boolean z2 = this.serverRequested > 0;
                        this.syncContext.drain();
                        return !z && z2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ServerStreamListener serverStreamListener) {
                this.serverStreamListener = serverStreamListener;
            }

            @Override // io.grpc.internal.ClientStream
            public void appendTimeoutInsight(InsightBuilder insightBuilder) {
            }

            @Override // io.grpc.internal.ClientStream
            public void cancel(Status status) {
                Status statusCleanStatus = InProcessTransport.cleanStatus(status, InProcessTransport.this.includeCauseWithStatus);
                if (internalCancel(statusCleanStatus, statusCleanStatus)) {
                    InProcessStream.this.serverStream.clientCancelled(status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.ClientStream
            public Attributes getAttributes() {
                return InProcessTransport.this.attributes;
            }

            @Override // io.grpc.internal.ClientStream
            public void halfClose() {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return;
                        }
                        if (this.serverReceiveQueue.isEmpty()) {
                            this.syncContext.executeLater(new RunnableC12073a(this, 1));
                        } else {
                            this.serverNotifyHalfClose = true;
                        }
                        this.syncContext.drain();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.serverRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void optimizeForDirectExecutor() {
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.serverStream.clientRequested(i)) {
                    synchronized (this) {
                        try {
                            if (!this.closed) {
                                this.syncContext.executeLater(new RunnableC12073a(this, 0));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    this.syncContext.drain();
                }
            }

            @Override // io.grpc.internal.ClientStream
            public void setAuthority(String str) {
                InProcessStream.this.authority = str;
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setDeadline(Deadline deadline) {
                Metadata metadata = InProcessStream.this.headers;
                Metadata.Key<Long> key = GrpcUtil.TIMEOUT_KEY;
                metadata.discardAll(key);
                InProcessStream.this.headers.put(key, Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
            }

            @Override // io.grpc.internal.ClientStream
            public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setFullStreamDecompression(boolean z) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxInboundMessageSize(int i) {
            }

            @Override // io.grpc.internal.ClientStream
            public void setMaxOutboundMessageSize(int i) {
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                InProcessStream.this.serverStream.setListener(clientStreamListener);
                synchronized (InProcessTransport.this) {
                    try {
                        this.statsTraceCtx.clientOutboundHeaders();
                        InProcessTransport.this.streams.add(InProcessStream.this);
                        if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                            InProcessTransport.this.inUseState.updateObjectInUse(InProcessStream.this, true);
                        }
                        InProcessTransport.this.serverTransportListener.streamCreated(InProcessStream.this.serverStream, InProcessStream.this.method.getFullMethodName(), InProcessStream.this.headers);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public void writeMessage(InputStream inputStream) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return;
                        }
                        this.statsTraceCtx.outboundMessage(this.outboundSeqNo);
                        this.statsTraceCtx.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                        InProcessStream.this.serverStream.statsTraceCtx.inboundMessage(this.outboundSeqNo);
                        InProcessStream.this.serverStream.statsTraceCtx.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                        this.outboundSeqNo++;
                        SingleMessageProducer singleMessageProducer = new SingleMessageProducer(inputStream);
                        int i = this.serverRequested;
                        if (i > 0) {
                            this.serverRequested = i - 1;
                            this.syncContext.executeLater(new RunnableC12074b(this, singleMessageProducer, 0));
                        } else {
                            this.serverReceiveQueue.add(singleMessageProducer);
                        }
                        this.syncContext.drain();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamClosed() {
            synchronized (InProcessTransport.this) {
                try {
                    boolean zRemove = InProcessTransport.this.streams.remove(this);
                    if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                        InProcessTransport.this.inUseState.updateObjectInUse(this, false);
                    }
                    if (InProcessTransport.this.streams.isEmpty() && zRemove && InProcessTransport.this.shutdown) {
                        InProcessTransport.this.notifyTerminated();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class InProcessServerStream implements ServerStream {

            @GuardedBy("this")
            private Status clientNotifyStatus;

            @GuardedBy("this")
            private Metadata clientNotifyTrailers;

            @GuardedBy("this")
            private ArrayDeque<StreamListener.MessageProducer> clientReceiveQueue = new ArrayDeque<>();

            @GuardedBy("this")
            private int clientRequested;
            private ClientStreamListener clientStreamListener;

            @GuardedBy("this")
            private boolean closed;

            @GuardedBy("this")
            private int outboundSeqNo;
            final StatsTraceContext statsTraceCtx;
            private final SynchronizationContext syncContext;

            public InProcessServerStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
                this.syncContext = new SynchronizationContext(InProcessTransport.this.uncaughtExceptionHandler);
                this.statsTraceCtx = StatsTraceContext.newServerContext(InProcessTransport.this.serverStreamTracerFactories, methodDescriptor.getFullMethodName(), metadata);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clientCancelled(Status status) {
                internalCancel(status);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean clientRequested(int i) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return false;
                        }
                        int i2 = this.clientRequested;
                        boolean z = i2 > 0;
                        this.clientRequested = i2 + i;
                        while (this.clientRequested > 0 && !this.clientReceiveQueue.isEmpty()) {
                            this.clientRequested--;
                            this.syncContext.executeLater(new RunnableC12076d(this, this.clientReceiveQueue.poll(), 0));
                        }
                        if (this.clientReceiveQueue.isEmpty() && this.clientNotifyStatus != null) {
                            this.closed = true;
                            InProcessStream.this.clientStream.statsTraceCtx.clientInboundTrailers(this.clientNotifyTrailers);
                            InProcessStream.this.clientStream.statsTraceCtx.streamClosed(this.clientNotifyStatus);
                            this.syncContext.executeLater(new RunnableC12077e(this, this.clientNotifyStatus, this.clientNotifyTrailers, 0));
                        }
                        boolean z2 = this.clientRequested > 0;
                        this.syncContext.drain();
                        return !z && z2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            private boolean internalCancel(Status status) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return false;
                        }
                        this.closed = true;
                        while (true) {
                            StreamListener.MessageProducer messageProducerPoll = this.clientReceiveQueue.poll();
                            if (messageProducerPoll == null) {
                                InProcessStream.this.clientStream.statsTraceCtx.streamClosed(status);
                                this.syncContext.executeLater(new RunnableC12075c(this, status, 1));
                                this.syncContext.drain();
                                return true;
                            }
                            while (true) {
                                InputStream next = messageProducerPoll.next();
                                if (next != null) {
                                    try {
                                        next.close();
                                    } catch (Throwable th) {
                                        InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$clientRequested$1(StreamListener.MessageProducer messageProducer) {
                this.clientStreamListener.messagesAvailable(messageProducer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$clientRequested$2(Status status, Metadata metadata) {
                this.clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$internalCancel$6(Status status) {
                this.clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$notifyClientClose$5(Status status, Metadata metadata) {
                this.clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$request$0() {
                this.clientStreamListener.onReady();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$writeHeaders$4(Metadata metadata) {
                this.clientStreamListener.headersRead(metadata);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$writeMessage$3(StreamListener.MessageProducer messageProducer) {
                this.clientStreamListener.messagesAvailable(messageProducer);
            }

            private void notifyClientClose(Status status, Metadata metadata) {
                Status statusCleanStatus = InProcessTransport.cleanStatus(status, InProcessTransport.this.includeCauseWithStatus);
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return;
                        }
                        if (this.clientReceiveQueue.isEmpty()) {
                            this.closed = true;
                            InProcessStream.this.clientStream.statsTraceCtx.clientInboundTrailers(metadata);
                            InProcessStream.this.clientStream.statsTraceCtx.streamClosed(statusCleanStatus);
                            this.syncContext.executeLater(new RunnableC12077e(this, statusCleanStatus, metadata, 1));
                        } else {
                            this.clientNotifyStatus = statusCleanStatus;
                            this.clientNotifyTrailers = metadata;
                        }
                        this.syncContext.drain();
                        InProcessStream.this.streamClosed();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ClientStreamListener clientStreamListener) {
                this.clientStreamListener = clientStreamListener;
            }

            @Override // io.grpc.internal.ServerStream
            public void cancel(Status status) {
                if (internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                    InProcessStream.this.clientStream.serverClosed(status, status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void close(Status status, Metadata metadata) {
                InProcessStream.this.clientStream.serverClosed(Status.f8817OK, status);
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE) {
                    int iMetadataSize = InProcessTransport.metadataSize(metadata) + (status.getDescription() == null ? 0 : status.getDescription().length());
                    if (iMetadataSize > InProcessTransport.this.clientMaxInboundMetadataSize) {
                        Status status2 = Status.RESOURCE_EXHAUSTED;
                        Locale locale = Locale.US;
                        status = status2.withDescription("Response header metadata larger than " + InProcessTransport.this.clientMaxInboundMetadataSize + ": " + iMetadataSize);
                        metadata = new Metadata();
                    }
                }
                notifyClientClose(status, metadata);
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.ServerStream
            public Attributes getAttributes() {
                return InProcessTransport.this.serverStreamAttributes;
            }

            @Override // io.grpc.internal.ServerStream
            public String getAuthority() {
                return InProcessStream.this.authority;
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.clientRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void optimizeForDirectExecutor() {
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.clientStream.serverRequested(i)) {
                    synchronized (this) {
                        try {
                            if (!this.closed) {
                                this.syncContext.executeLater(new RunnableC12073a(this, 3));
                            }
                        } finally {
                        }
                    }
                }
                this.syncContext.drain();
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.ServerStream
            public void setDecompressor(Decompressor decompressor) {
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ServerStream
            public StatsTraceContext statsTraceContext() {
                return this.statsTraceCtx;
            }

            @Override // io.grpc.internal.ServerStream
            public int streamId() {
                return -1;
            }

            @Override // io.grpc.internal.ServerStream
            public void writeHeaders(Metadata metadata) {
                int iMetadataSize;
                if (InProcessTransport.this.clientMaxInboundMetadataSize == Integer.MAX_VALUE || (iMetadataSize = InProcessTransport.metadataSize(metadata)) <= InProcessTransport.this.clientMaxInboundMetadataSize) {
                    synchronized (this) {
                        try {
                            if (this.closed) {
                                return;
                            }
                            InProcessStream.this.clientStream.statsTraceCtx.clientInboundHeaders();
                            this.syncContext.executeLater(new RunnableC12075c(this, metadata, 2));
                            this.syncContext.drain();
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                Status statusWithDescription = Status.CANCELLED.withDescription("Client cancelled the RPC");
                InProcessStream.this.clientStream.serverClosed(statusWithDescription, statusWithDescription);
                Status status = Status.RESOURCE_EXHAUSTED;
                Locale locale = Locale.US;
                notifyClientClose(status.withDescription("Response header metadata larger than " + InProcessTransport.this.clientMaxInboundMetadataSize + ": " + iMetadataSize), new Metadata());
            }

            @Override // io.grpc.internal.Stream
            public void writeMessage(InputStream inputStream) {
                synchronized (this) {
                    try {
                        if (this.closed) {
                            return;
                        }
                        this.statsTraceCtx.outboundMessage(this.outboundSeqNo);
                        this.statsTraceCtx.outboundMessageSent(this.outboundSeqNo, -1L, -1L);
                        InProcessStream.this.clientStream.statsTraceCtx.inboundMessage(this.outboundSeqNo);
                        InProcessStream.this.clientStream.statsTraceCtx.inboundMessageRead(this.outboundSeqNo, -1L, -1L);
                        this.outboundSeqNo++;
                        SingleMessageProducer singleMessageProducer = new SingleMessageProducer(inputStream);
                        int i = this.clientRequested;
                        if (i > 0) {
                            this.clientRequested = i - 1;
                            this.syncContext.executeLater(new RunnableC12076d(this, singleMessageProducer, 1));
                        } else {
                            this.clientReceiveQueue.add(singleMessageProducer);
                        }
                        this.syncContext.drain();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void setListener(ServerStreamListener serverStreamListener) {
                InProcessStream.this.clientStream.setListener(serverStreamListener);
            }
        }

        private InProcessStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, String str, StatsTraceContext statsTraceContext) {
            this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, "method");
            this.headers = (Metadata) Preconditions.checkNotNull(metadata, Contract.HEADERS);
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
            this.authority = str;
            this.clientStream = new InProcessClientStream(callOptions, statsTraceContext);
            this.serverStream = new InProcessServerStream(methodDescriptor, metadata);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        @Override // io.grpc.internal.StreamListener.MessageProducer
        @Nullable
        public InputStream next() {
            InputStream inputStream = this.message;
            this.message = null;
            return inputStream;
        }

        private SingleMessageProducer(InputStream inputStream) {
            this.message = inputStream;
        }
    }

    private InProcessTransport(SocketAddress socketAddress, int i, String str, String str2, Attributes attributes, Optional<ServerListener> optional, boolean z) {
        this.streams = Collections.newSetFromMap(new IdentityHashMap());
        this.uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() { // from class: io.grpc.inprocess.InProcessTransport.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw new Error(th);
            }
        };
        this.inUseState = new InUseStateAggregator<InProcessStream>() { // from class: io.grpc.inprocess.InProcessTransport.2
            @Override // io.grpc.internal.InUseStateAggregator
            public void handleInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(true);
            }

            @Override // io.grpc.internal.InUseStateAggregator
            public void handleNotInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(false);
            }
        };
        this.address = socketAddress;
        this.clientMaxInboundMetadataSize = i;
        this.authority = str;
        this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", str2);
        Preconditions.checkNotNull(attributes, "eagAttrs");
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socketAddress).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socketAddress).build();
        this.optionalServerListener = optional;
        this.logId = InternalLogId.allocate((Class<?>) InProcessTransport.class, socketAddress.toString());
        this.includeCauseWithStatus = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status cleanStatus(Status status, boolean z) {
        if (status == null) {
            return null;
        }
        Status statusWithDescription = Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
        return z ? statusWithDescription.withCause(status.getCause()) : statusWithDescription;
    }

    private ClientStream failedClientStream(final StatsTraceContext statsTraceContext, final Status status) {
        return new NoopClientStream() { // from class: io.grpc.inprocess.InProcessTransport.5
            @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                statsTraceContext.clientOutboundHeaders();
                statsTraceContext.streamClosed(status);
                clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int metadataSize(Metadata metadata) {
        byte[][] bArrSerialize = InternalMetadata.serialize(metadata);
        if (bArrSerialize == null) {
            return 0;
        }
        long length = 0;
        for (int i = 0; i < bArrSerialize.length; i += 2) {
            length += (long) (bArrSerialize[i].length + 32 + bArrSerialize[i + 1].length);
        }
        return (int) Math.min(length, 2147483647L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyShutdown(Status status) {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.clientTransportListener.transportShutdown(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyTerminated() {
        try {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            ScheduledExecutorService scheduledExecutorService = this.serverScheduler;
            if (scheduledExecutorService != null) {
                this.serverScheduler = this.serverSchedulerPool.returnObject(scheduledExecutorService);
            }
            this.clientTransportListener.transportTerminated();
            ServerTransportListener serverTransportListener = this.serverTransportListener;
            if (serverTransportListener != null) {
                serverTransportListener.transportTerminated();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.internal.ServerTransport
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.serverScheduler;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        settableFutureCreate.set(null);
        return settableFutureCreate;
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) throws Throwable {
        Throwable th;
        int iMetadataSize;
        int i;
        try {
            try {
                StatsTraceContext statsTraceContextNewClientContext = StatsTraceContext.newClientContext(clientStreamTracerArr, getAttributes(), metadata);
                Status status = this.shutdownStatus;
                try {
                    if (status != null) {
                        return failedClientStream(statsTraceContextNewClientContext, status);
                    }
                    metadata.put(GrpcUtil.USER_AGENT_KEY, this.userAgent);
                    if (this.serverMaxInboundMetadataSize == Integer.MAX_VALUE || (iMetadataSize = metadataSize(metadata)) <= (i = this.serverMaxInboundMetadataSize)) {
                        return new InProcessStream(methodDescriptor, metadata, callOptions, this.authority, statsTraceContextNewClientContext).clientStream;
                    }
                    Status status2 = Status.RESOURCE_EXHAUSTED;
                    Locale locale = Locale.US;
                    return failedClientStream(statsTraceContextNewClientContext, status2.withDescription("Request metadata larger than " + i + ": " + iMetadataSize));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        try {
            if (this.terminated) {
                final Status status = this.shutdownStatus;
                executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.6
                    @Override // java.lang.Runnable
                    public void run() {
                        pingCallback.onFailure(status.asRuntimeException());
                    }
                });
            } else {
                executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.7
                    @Override // java.lang.Runnable
                    public void run() {
                        pingCallback.onSuccess(0L);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public synchronized void shutdown(Status status) {
        if (this.shutdown) {
            return;
        }
        this.shutdownStatus = status;
        notifyShutdown(status);
        if (this.streams.isEmpty()) {
            notifyTerminated();
        }
    }

    @Override // io.grpc.internal.ServerTransport, io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        Preconditions.checkNotNull(status, "reason");
        synchronized (this) {
            try {
                shutdown(status);
                if (this.terminated) {
                    return;
                }
                Iterator it = new ArrayList(this.streams).iterator();
                while (it.hasNext()) {
                    ((InProcessStream) it.next()).clientStream.cancel(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    @CheckReturnValue
    public synchronized Runnable start(ManagedClientTransport.Listener listener) {
        try {
            this.clientTransportListener = listener;
            if (this.optionalServerListener.isPresent()) {
                this.serverScheduler = this.serverSchedulerPool.getObject();
                this.serverTransportListener = this.optionalServerListener.get().transportCreated(this);
            } else {
                InProcessServer inProcessServerFindServer = InProcessServer.findServer(this.address);
                if (inProcessServerFindServer != null) {
                    this.serverMaxInboundMetadataSize = inProcessServerFindServer.getMaxInboundMetadataSize();
                    ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool = inProcessServerFindServer.getScheduledExecutorServicePool();
                    this.serverSchedulerPool = scheduledExecutorServicePool;
                    this.serverScheduler = scheduledExecutorServicePool.getObject();
                    this.serverStreamTracerFactories = inProcessServerFindServer.getStreamTracerFactories();
                    this.serverTransportListener = inProcessServerFindServer.register(this);
                }
            }
            if (this.serverTransportListener != null) {
                return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.4
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (InProcessTransport.this) {
                            Attributes attributesBuild = Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, InProcessTransport.this.address).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, InProcessTransport.this.address).build();
                            InProcessTransport inProcessTransport = InProcessTransport.this;
                            inProcessTransport.serverStreamAttributes = inProcessTransport.serverTransportListener.transportReady(attributesBuild);
                            InProcessTransport.this.clientTransportListener.transportReady();
                        }
                    }
                };
            }
            final Status statusWithDescription = Status.UNAVAILABLE.withDescription("Could not find server: " + this.address);
            this.shutdownStatus = statusWithDescription;
            return new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (InProcessTransport.this) {
                        InProcessTransport.this.notifyShutdown(statusWithDescription);
                        InProcessTransport.this.notifyTerminated();
                    }
                }
            };
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("address", this.address).toString();
    }

    @Override // io.grpc.internal.ServerTransport
    public synchronized void shutdown() {
        shutdown(Status.UNAVAILABLE.withDescription("InProcessTransport shutdown by the server-side"));
    }

    public InProcessTransport(SocketAddress socketAddress, int i, String str, String str2, Attributes attributes, boolean z) {
        this(socketAddress, i, str, str2, attributes, Optional.absent(), z);
    }

    public InProcessTransport(String str, int i, String str2, String str3, Attributes attributes, ObjectPool<ScheduledExecutorService> objectPool, List<ServerStreamTracer.Factory> list, ServerListener serverListener, boolean z) {
        this(new InProcessSocketAddress(str), i, str2, str3, attributes, Optional.m4267of(serverListener), z);
        this.serverMaxInboundMetadataSize = i;
        this.serverSchedulerPool = objectPool;
        this.serverStreamTracerFactories = list;
    }
}
