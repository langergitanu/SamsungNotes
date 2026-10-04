package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.MessageFramer;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;
    private final StatsTraceContext statsTraceCtx;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Sink {
        void cancel(Status status);

        void writeFrame(WritableBuffer writableBuffer, boolean z, int i);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z, Status status);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TransportState extends AbstractStream.TransportState {

        @Nullable
        private Status closedStatus;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean endOfStream;
        private boolean immediateCloseRequested;
        private ServerStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;

        public TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i, statsTraceContext, (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer"));
            this.endOfStream = false;
            this.deframerClosed = false;
            this.immediateCloseRequested = false;
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status) {
            Preconditions.checkState((status.isOk() && this.closedStatus == null) ? false : true);
            if (this.listenerClosed) {
                return;
            }
            if (status.isOk()) {
                this.statsTraceCtx.streamClosed(this.closedStatus);
                getTransportTracer().reportStreamClosed(this.closedStatus.isOk());
            } else {
                this.statsTraceCtx.streamClosed(status);
                getTransportTracer().reportStreamClosed(false);
            }
            this.listenerClosed = true;
            onStreamDeallocated();
            listener().closed(status);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClosedStatus(Status status) {
            Preconditions.checkState(this.closedStatus == null, "closedStatus can only be set once");
            this.closedStatus = status;
        }

        public void complete() {
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(Status.f8817OK);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(Status.f8817OK);
                    }
                };
                this.immediateCloseRequested = true;
                closeDeframer(true);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z) {
            this.deframerClosed = true;
            if (this.endOfStream && !this.immediateCloseRequested) {
                if (z) {
                    deframeFailed(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
                    this.deframerClosedTask = null;
                    return;
                }
                this.listener.halfClosed();
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer, boolean z) {
            Preconditions.checkState(!this.endOfStream, "Past end of stream");
            deframe(readableBuffer);
            if (z) {
                this.endOfStream = true;
                closeDeframer(false);
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportRemoteStreamStarted();
        }

        public final void setListener(ServerStreamListener serverStreamListener) {
            Preconditions.checkState(this.listener == null, "setListener should be called only once");
            this.listener = (ServerStreamListener) Preconditions.checkNotNull(serverStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void transportReportStatus(final Status status) {
            Preconditions.checkArgument(!status.isOk(), "status must not be OK");
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(status);
                    }
                };
                this.immediateCloseRequested = true;
                closeDeframer(true);
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public ServerStreamListener listener() {
            return this.listener;
        }
    }

    public AbstractServerStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext) {
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
    }

    private void addStatusToTrailers(Metadata metadata, Status status) {
        Metadata.Key<Status> key = InternalStatus.CODE_KEY;
        metadata.discardAll(key);
        Metadata.Key<String> key2 = InternalStatus.MESSAGE_KEY;
        metadata.discardAll(key2);
        metadata.put(key, status);
        if (status.getDescription() != null) {
            metadata.put(key2, status.getDescription());
        }
    }

    public abstract Sink abstractServerStreamSink();

    @Override // io.grpc.internal.ServerStream
    public final void cancel(Status status) {
        abstractServerStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.ServerStream
    public final void close(Status status, Metadata metadata) {
        Preconditions.checkNotNull(status, "status");
        Preconditions.checkNotNull(metadata, "trailers");
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        endOfMessages();
        addStatusToTrailers(metadata, status);
        transportState().setClosedStatus(status);
        abstractServerStreamSink().writeTrailers(metadata, this.headersSent, status);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
        if (writableBuffer == null) {
            return;
        }
        if (z) {
            z2 = false;
        }
        abstractServerStreamSink().writeFrame(writableBuffer, z2, i);
    }

    @Override // io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ServerStream
    public String getAuthority() {
        return null;
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.internal.ServerStream
    public final void setDecompressor(Decompressor decompressor) {
        transportState().setDecompressor((Decompressor) Preconditions.checkNotNull(decompressor, "decompressor"));
    }

    @Override // io.grpc.internal.ServerStream
    public final void setListener(ServerStreamListener serverStreamListener) {
        transportState().setListener(serverStreamListener);
    }

    @Override // io.grpc.internal.ServerStream
    public StatsTraceContext statsTraceContext() {
        return this.statsTraceCtx;
    }

    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState transportState();

    @Override // io.grpc.internal.ServerStream
    public final void writeHeaders(Metadata metadata) {
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        this.headersSent = true;
        abstractServerStreamSink().writeHeaders(metadata);
    }

    @Override // io.grpc.internal.AbstractStream
    public final MessageFramer framer() {
        return this.framer;
    }
}
