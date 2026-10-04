package io.grpc.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.p130io.ByteStreams;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.CallOptions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.MessageFramer;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractClientStream extends AbstractStream implements ClientStream, MessageFramer.Sink {
    private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
    private volatile boolean cancelled;
    private final Framer framer;
    private Metadata headers;
    private boolean shouldBeCountedForInUse;
    private final TransportTracer transportTracer;
    private boolean useGet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GetFramer implements Framer {
        private boolean closed;
        private Metadata headers;
        private byte[] payload;
        private final StatsTraceContext statsTraceCtx;

        public GetFramer(Metadata metadata, StatsTraceContext statsTraceContext) {
            this.headers = (Metadata) Preconditions.checkNotNull(metadata, Contract.HEADERS);
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        @Override // io.grpc.internal.Framer
        public void close() {
            this.closed = true;
            Preconditions.checkState(this.payload != null, "Lack of request message. GET request is only supported for unary requests");
            AbstractClientStream.this.abstractClientStreamSink().writeHeaders(this.headers, this.payload);
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public void dispose() {
            this.closed = true;
            this.payload = null;
            this.headers = null;
        }

        @Override // io.grpc.internal.Framer
        public void flush() {
        }

        @Override // io.grpc.internal.Framer
        public boolean isClosed() {
            return this.closed;
        }

        @Override // io.grpc.internal.Framer
        public Framer setCompressor(Compressor compressor) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public void setMaxOutboundMessageSize(int i) {
        }

        @Override // io.grpc.internal.Framer
        public Framer setMessageCompression(boolean z) {
            return this;
        }

        @Override // io.grpc.internal.Framer
        public void writePayload(InputStream inputStream) {
            Preconditions.checkState(this.payload == null, "writePayload should not be called multiple times");
            try {
                this.payload = ByteStreams.toByteArray(inputStream);
                this.statsTraceCtx.outboundMessage(0);
                StatsTraceContext statsTraceContext = this.statsTraceCtx;
                byte[] bArr = this.payload;
                statsTraceContext.outboundMessageSent(0, bArr.length, bArr.length);
                this.statsTraceCtx.outboundUncompressedSize(this.payload.length);
                this.statsTraceCtx.outboundWireSize(this.payload.length);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Sink {
        void cancel(Status status);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, boolean z2, int i);

        void writeHeaders(Metadata metadata, @Nullable byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TransportState extends AbstractStream.TransportState {
        private DecompressorRegistry decompressorRegistry;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean fullStreamDecompression;
        private ClientStreamListener listener;
        private boolean listenerClosed;
        private volatile boolean outboundClosed;
        private final StatsTraceContext statsTraceCtx;
        private boolean statusReported;
        private boolean statusReportedIsOk;

        public TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i, statsTraceContext, transportTracer);
            this.decompressorRegistry = DecompressorRegistry.getDefaultInstance();
            this.deframerClosed = false;
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            if (this.listenerClosed) {
                return;
            }
            this.listenerClosed = true;
            this.statsTraceCtx.streamClosed(status);
            listener().closed(status, rpcProgress, metadata);
            if (getTransportTracer() != null) {
                getTransportTracer().reportStreamClosed(status.isOk());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            Preconditions.checkState(this.listener == null, "Already called start");
            this.decompressorRegistry = (DecompressorRegistry) Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFullStreamDecompression(boolean z) {
            this.fullStreamDecompression = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setOutboundClosed() {
            this.outboundClosed = true;
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z) {
            Preconditions.checkState(this.statusReported, "status should have been reported on deframer closed");
            this.deframerClosed = true;
            if (this.statusReportedIsOk && z) {
                transportReportStatus(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame"), true, new Metadata());
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer) throws Throwable {
            Preconditions.checkNotNull(readableBuffer, TypedValues.Attributes.S_FRAME);
            boolean z = true;
            try {
                if (this.statusReported) {
                    AbstractClientStream.log.log(Level.INFO, "Received data on closed stream");
                    readableBuffer.close();
                    return;
                } else {
                    try {
                        deframe(readableBuffer);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (z) {
                readableBuffer.close();
            }
            throw th;
        }

        public void inboundHeadersReceived(Metadata metadata) {
            boolean z = true;
            Preconditions.checkState(!this.statusReported, "Received headers on closed stream");
            this.statsTraceCtx.clientInboundHeaders();
            String str = (String) metadata.get(GrpcUtil.CONTENT_ENCODING_KEY);
            if (!this.fullStreamDecompression || str == null) {
                z = false;
            } else if (str.equalsIgnoreCase("gzip")) {
                setFullStreamDecompressor(new GzipInflatingBuffer());
            } else {
                if (!str.equalsIgnoreCase("identity")) {
                    deframeFailed(Status.INTERNAL.withDescription("Can't find full stream decompressor for ".concat(str)).asRuntimeException());
                    return;
                }
                z = false;
            }
            String str2 = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
            if (str2 != null) {
                Decompressor decompressorLookupDecompressor = this.decompressorRegistry.lookupDecompressor(str2);
                if (decompressorLookupDecompressor == null) {
                    deframeFailed(Status.INTERNAL.withDescription("Can't find decompressor for ".concat(str2)).asRuntimeException());
                    return;
                } else if (decompressorLookupDecompressor != Codec.Identity.NONE) {
                    if (z) {
                        deframeFailed(Status.INTERNAL.withDescription("Full stream and gRPC message encoding cannot both be set").asRuntimeException());
                        return;
                    }
                    setDecompressor(decompressorLookupDecompressor);
                }
            }
            listener().headersRead(metadata);
        }

        public void inboundTrailersReceived(Metadata metadata, Status status) {
            Preconditions.checkNotNull(status, "status");
            Preconditions.checkNotNull(metadata, "trailers");
            if (this.statusReported) {
                AbstractClientStream.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, metadata});
            } else {
                this.statsTraceCtx.clientInboundTrailers(metadata);
                transportReportStatus(status, false, metadata);
            }
        }

        public final boolean isOutboundClosed() {
            return this.outboundClosed;
        }

        @VisibleForTesting
        public final void setListener(ClientStreamListener clientStreamListener) {
            Preconditions.checkState(this.listener == null, "Already called setListener");
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void transportReportStatus(Status status, boolean z, Metadata metadata) {
            transportReportStatus(status, ClientStreamListener.RpcProgress.PROCESSED, z, metadata);
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final ClientStreamListener listener() {
            return this.listener;
        }

        public final void transportReportStatus(final Status status, final ClientStreamListener.RpcProgress rpcProgress, boolean z, final Metadata metadata) {
            Preconditions.checkNotNull(status, "status");
            Preconditions.checkNotNull(metadata, "trailers");
            if (!this.statusReported || z) {
                this.statusReported = true;
                this.statusReportedIsOk = status.isOk();
                onStreamDeallocated();
                if (this.deframerClosed) {
                    this.deframerClosedTask = null;
                    closeListener(status, rpcProgress, metadata);
                } else {
                    this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractClientStream.TransportState.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TransportState.this.closeListener(status, rpcProgress, metadata);
                        }
                    };
                    closeDeframer(z);
                }
            }
        }
    }

    public AbstractClientStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext, TransportTracer transportTracer, Metadata metadata, CallOptions callOptions, boolean z) {
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
        this.shouldBeCountedForInUse = GrpcUtil.shouldBeCountedForInUse(callOptions);
        this.useGet = z;
        if (z) {
            this.framer = new GetFramer(metadata, statsTraceContext);
        } else {
            this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
            this.headers = metadata;
        }
    }

    public abstract Sink abstractClientStreamSink();

    @Override // io.grpc.internal.ClientStream
    public final void appendTimeoutInsight(InsightBuilder insightBuilder) {
        insightBuilder.appendKeyValue("remote_addr", getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR));
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Should not cancel with OK status");
        this.cancelled = true;
        abstractClientStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
        Preconditions.checkArgument(writableBuffer != null || z, "null frame before EOS");
        abstractClientStreamSink().writeFrame(writableBuffer, z, z2, i);
    }

    @Override // io.grpc.internal.AbstractStream
    public final Framer framer() {
        return this.framer;
    }

    public TransportTracer getTransportTracer() {
        return this.transportTracer;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        if (transportState().isOutboundClosed()) {
            return;
        }
        transportState().setOutboundClosed();
        endOfMessages();
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady() && !this.cancelled;
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        Metadata metadata = this.headers;
        Metadata.Key<Long> key = GrpcUtil.TIMEOUT_KEY;
        metadata.discardAll(key);
        this.headers.put(key, Long.valueOf(Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        transportState().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(boolean z) {
        transportState().setFullStreamDecompression(z);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int i) {
        transportState().setMaxInboundMessageSize(i);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int i) {
        this.framer.setMaxOutboundMessageSize(i);
    }

    public final boolean shouldBeCountedForInUse() {
        return this.shouldBeCountedForInUse;
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        transportState().setListener(clientStreamListener);
        if (this.useGet) {
            return;
        }
        abstractClientStreamSink().writeHeaders(this.headers, null);
        this.headers = null;
    }

    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();
}
