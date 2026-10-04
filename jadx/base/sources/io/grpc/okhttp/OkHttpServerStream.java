package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractServerStream;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.OkHttpServerTransport;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpServerStream extends AbstractServerStream {
    private final Attributes attributes;
    private final String authority;
    private final Sink sink;
    private final TransportState state;
    private final TransportTracer transportTracer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Sink implements AbstractServerStream.Sink {
        public Sink() {
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void cancel(Status status) {
            PerfMark.startTask("OkHttpServerStream$Sink.cancel");
            try {
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.cancel(ErrorCode.CANCEL, status);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.cancel");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z, int i) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeFrame");
            Buffer buffer = ((OkHttpWritableBuffer) writableBuffer).buffer();
            int size = (int) buffer.size();
            if (size > 0) {
                OkHttpServerStream.this.onSendingBytes(size);
            }
            try {
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendBuffer(buffer, z);
                    OkHttpServerStream.this.transportTracer.reportMessageSent(i);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeFrame");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeHeaders(Metadata metadata) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeHeaders");
            try {
                List<Header> listCreateResponseHeaders = Headers.createResponseHeaders(metadata);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendHeaders(listCreateResponseHeaders);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeHeaders");
            }
        }

        @Override // io.grpc.internal.AbstractServerStream.Sink
        public void writeTrailers(Metadata metadata, boolean z, Status status) {
            PerfMark.startTask("OkHttpServerStream$Sink.writeTrailers");
            try {
                List<Header> listCreateResponseTrailers = Headers.createResponseTrailers(metadata, z);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendTrailers(listCreateResponseTrailers);
                }
            } finally {
                PerfMark.stopTask("OkHttpServerStream$Sink.writeTrailers");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TransportState extends AbstractServerStream.TransportState implements OutboundFlowController.Stream, OkHttpServerTransport.StreamState {

        @GuardedBy("lock")
        private boolean cancelSent;

        @GuardedBy("lock")
        private final ExceptionHandlingFrameWriter frameWriter;
        private final int initialWindowSize;
        private final Object lock;

        @GuardedBy("lock")
        private final OutboundFlowController outboundFlow;
        private final OutboundFlowController.StreamState outboundFlowState;

        @GuardedBy("lock")
        private int processedWindow;

        @GuardedBy("lock")
        private boolean receivedEndOfStream;
        private final int streamId;
        private final Tag tag;

        @GuardedBy("lock")
        private final OkHttpServerTransport transport;

        @GuardedBy("lock")
        private int window;

        public TransportState(OkHttpServerTransport okHttpServerTransport, int i, int i2, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, int i4, TransportTracer transportTracer, String str) {
            super(i2, statsTraceContext, transportTracer);
            this.cancelSent = false;
            this.transport = (OkHttpServerTransport) Preconditions.checkNotNull(okHttpServerTransport, NotificationCompat.CATEGORY_TRANSPORT);
            this.streamId = i;
            this.lock = Preconditions.checkNotNull(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.window = i4;
            this.processedWindow = i4;
            this.initialWindowSize = i4;
            this.tag = PerfMark.createTag(str);
            this.outboundFlowState = outboundFlowController.createState(this, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void cancel(ErrorCode errorCode, Status status) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            this.frameWriter.rstStream(this.streamId, errorCode);
            transportReportStatus(status);
            this.transport.streamClosed(this.streamId, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void sendBuffer(Buffer buffer, boolean z) {
            if (this.cancelSent) {
                return;
            }
            this.outboundFlow.data(false, this.outboundFlowState, buffer, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void sendHeaders(List<Header> list) {
            this.frameWriter.synReply(false, this.streamId, list);
            this.frameWriter.flush();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void sendTrailers(List<Header> list) {
            this.outboundFlow.notifyWhenNoPendingData(this.outboundFlowState, new RunnableC12291b(this, list, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: sendTrailersAfterFlowControlled, reason: merged with bridge method [inline-methods] */
        public void lambda$sendTrailers$0(List<Header> list) {
            synchronized (this.lock) {
                try {
                    this.frameWriter.synReply(true, this.streamId, list);
                    if (!this.receivedEndOfStream) {
                        this.frameWriter.rstStream(this.streamId, ErrorCode.NO_ERROR);
                    }
                    this.transport.streamClosed(this.streamId, true);
                    complete();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void bytesRead(int i) {
            int i2 = this.processedWindow - i;
            this.processedWindow = i2;
            float f = i2;
            int i4 = this.initialWindowSize;
            if (f <= i4 * 0.5f) {
                int i5 = i4 - i2;
                this.window += i5;
                this.processedWindow = i2 + i5;
                this.frameWriter.windowUpdate(this.streamId, i5);
                this.frameWriter.flush();
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void deframeFailed(Throwable th) {
            cancel(ErrorCode.INTERNAL_ERROR, Status.fromThrowable(th));
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public OutboundFlowController.StreamState getOutboundFlowState() {
            return this.outboundFlowState;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public boolean hasReceivedEndOfStream() {
            boolean z;
            synchronized (this.lock) {
                z = this.receivedEndOfStream;
            }
            return z;
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundDataReceived(Buffer buffer, int i, boolean z) {
            synchronized (this.lock) {
                try {
                    PerfMark.event("OkHttpServerTransport$FrameHandler.data", this.tag);
                    if (z) {
                        this.receivedEndOfStream = true;
                    }
                    this.window -= i;
                    super.inboundDataReceived(new OkHttpReadableBuffer(buffer), z);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public void inboundRstReceived(Status status) {
            PerfMark.event("OkHttpServerTransport$FrameHandler.rstStream", this.tag);
            transportReportStatus(status);
        }

        @Override // io.grpc.okhttp.OkHttpServerTransport.StreamState
        public int inboundWindowAvailable() {
            int i;
            synchronized (this.lock) {
                i = this.window;
            }
            return i;
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        @GuardedBy("lock")
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }
    }

    public OkHttpServerStream(TransportState transportState, Attributes attributes, String str, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(new OkHttpWritableBufferAllocator(), statsTraceContext);
        this.sink = new Sink();
        this.state = (TransportState) Preconditions.checkNotNull(transportState, "state");
        this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "transportAttrs");
        this.authority = str;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
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
        return this.state.streamId;
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
