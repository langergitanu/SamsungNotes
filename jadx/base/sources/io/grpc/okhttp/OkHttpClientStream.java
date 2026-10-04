package io.grpc.okhttp;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Preconditions;
import com.google.common.p130io.BaseEncoding;
import com.microsoft.identity.client.internal.MsalUtils;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.EOFException;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpClientStream extends AbstractClientStream {
    public static final int ABSENT_ID = -1;
    private static final Buffer EMPTY_BUFFER = new Buffer();
    private final Attributes attributes;
    private String authority;
    private final MethodDescriptor<?, ?> method;
    private final Sink sink;
    private final TransportState state;
    private final StatsTraceContext statsTraceCtx;
    private boolean useGet;
    private final String userAgent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Sink implements AbstractClientStream.Sink {
        public Sink() {
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void cancel(Status status) {
            PerfMark.startTask("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.cancel(status, true, null);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.cancel");
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
            Buffer buffer;
            PerfMark.startTask("OkHttpClientStream$Sink.writeFrame");
            if (writableBuffer == null) {
                buffer = OkHttpClientStream.EMPTY_BUFFER;
            } else {
                buffer = ((OkHttpWritableBuffer) writableBuffer).buffer();
                int size = (int) buffer.size();
                if (size > 0) {
                    OkHttpClientStream.this.onSendingBytes(size);
                }
            }
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.sendBuffer(buffer, z, z2);
                    OkHttpClientStream.this.getTransportTracer().reportMessageSent(i);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.writeFrame");
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeHeaders(Metadata metadata, byte[] bArr) {
            PerfMark.startTask("OkHttpClientStream$Sink.writeHeaders");
            String string = "/" + OkHttpClientStream.this.method.getFullMethodName();
            if (bArr != null) {
                OkHttpClientStream.this.useGet = true;
                StringBuilder sbM781w = AbstractC0541b.m781w(string, MsalUtils.QUERY_STRING_SYMBOL);
                sbM781w.append(BaseEncoding.base64().encode(bArr));
                string = sbM781w.toString();
            }
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    OkHttpClientStream.this.state.streamReady(metadata, string);
                }
            } finally {
                PerfMark.stopTask("OkHttpClientStream$Sink.writeHeaders");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TransportState extends Http2ClientStreamTransportState implements OutboundFlowController.Stream {

        @GuardedBy("lock")
        private boolean canStart;

        @GuardedBy("lock")
        private boolean cancelSent;
        private boolean flushPendingData;

        @GuardedBy("lock")
        private final ExceptionHandlingFrameWriter frameWriter;

        /* JADX INFO: renamed from: id */
        private int f8843id;
        private final int initialWindowSize;
        private final Object lock;

        @GuardedBy("lock")
        private final OutboundFlowController outboundFlow;

        @GuardedBy("lock")
        private OutboundFlowController.StreamState outboundFlowState;

        @GuardedBy("lock")
        private Buffer pendingData;
        private boolean pendingDataHasEndOfStream;

        @GuardedBy("lock")
        private int processedWindow;

        @GuardedBy("lock")
        private List<Header> requestHeaders;
        private final Tag tag;

        @GuardedBy("lock")
        private final OkHttpClientTransport transport;

        @GuardedBy("lock")
        private int window;

        public TransportState(int i, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, OkHttpClientTransport okHttpClientTransport, int i2, String str) {
            super(i, statsTraceContext, OkHttpClientStream.this.getTransportTracer());
            this.pendingData = new Buffer();
            this.pendingDataHasEndOfStream = false;
            this.flushPendingData = false;
            this.cancelSent = false;
            this.canStart = true;
            this.f8843id = -1;
            this.lock = Preconditions.checkNotNull(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.transport = okHttpClientTransport;
            this.window = i2;
            this.processedWindow = i2;
            this.initialWindowSize = i2;
            this.tag = PerfMark.createTag(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void cancel(Status status, boolean z, Metadata metadata) throws EOFException {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            if (!this.canStart) {
                this.transport.finishStream(m13755id(), status, ClientStreamListener.RpcProgress.PROCESSED, z, ErrorCode.CANCEL, metadata);
                return;
            }
            this.transport.removePendingStream(OkHttpClientStream.this);
            this.requestHeaders = null;
            this.pendingData.clear();
            this.canStart = false;
            if (metadata == null) {
                metadata = new Metadata();
            }
            transportReportStatus(status, true, metadata);
        }

        @GuardedBy("lock")
        private void onEndOfStream() {
            if (isOutboundClosed()) {
                this.transport.finishStream(m13755id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            } else {
                this.transport.finishStream(m13755id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void sendBuffer(Buffer buffer, boolean z, boolean z2) {
            if (this.cancelSent) {
                return;
            }
            if (!this.canStart) {
                Preconditions.checkState(m13755id() != -1, "streamId should be set");
                this.outboundFlow.data(z, this.outboundFlowState, buffer, z2);
            } else {
                this.pendingData.write(buffer, (int) buffer.size());
                this.pendingDataHasEndOfStream |= z;
                this.flushPendingData |= z2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void streamReady(Metadata metadata, String str) {
            this.requestHeaders = Headers.createRequestHeaders(metadata, str, OkHttpClientStream.this.authority, OkHttpClientStream.this.userAgent, OkHttpClientStream.this.useGet, this.transport.isUsingPlaintext());
            this.transport.streamReadyToStart(OkHttpClientStream.this);
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
                this.frameWriter.windowUpdate(m13755id(), i5);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void deframeFailed(Throwable th) throws EOFException {
            http2ProcessingFailed(Status.fromThrowable(th), true, new Metadata());
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState, io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void deframerClosed(boolean z) {
            onEndOfStream();
            super.deframerClosed(z);
        }

        public OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState
        @GuardedBy("lock")
        public void http2ProcessingFailed(Status status, boolean z, Metadata metadata) throws EOFException {
            cancel(status, z, metadata);
        }

        /* JADX INFO: renamed from: id */
        public int m13755id() {
            return this.f8843id;
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        @GuardedBy("lock")
        public void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportLocalStreamStarted();
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        @GuardedBy("lock")
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }

        @GuardedBy("lock")
        public void start(int i) {
            Preconditions.checkState(this.f8843id == -1, "the stream has been started with id %s", i);
            this.f8843id = i;
            this.outboundFlowState = this.outboundFlow.createState(this, i);
            OkHttpClientStream.this.state.onStreamAllocated();
            if (this.canStart) {
                this.frameWriter.synStream(OkHttpClientStream.this.useGet, false, this.f8843id, 0, this.requestHeaders);
                OkHttpClientStream.this.statsTraceCtx.clientOutboundHeaders();
                this.requestHeaders = null;
                if (this.pendingData.size() > 0) {
                    this.outboundFlow.data(this.pendingDataHasEndOfStream, this.outboundFlowState, this.pendingData, this.flushPendingData);
                }
                this.canStart = false;
            }
        }

        public Tag tag() {
            return this.tag;
        }

        @GuardedBy("lock")
        public void transportDataReceived(Buffer buffer, boolean z) throws Throwable {
            int size = this.window - ((int) buffer.size());
            this.window = size;
            if (size >= 0) {
                super.transportDataReceived(new OkHttpReadableBuffer(buffer), z);
            } else {
                this.frameWriter.rstStream(m13755id(), ErrorCode.FLOW_CONTROL_ERROR);
                this.transport.finishStream(m13755id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            }
        }

        @GuardedBy("lock")
        public void transportHeadersReceived(List<Header> list, boolean z) {
            if (z) {
                transportTrailersReceived(Utils.convertTrailers(list));
            } else {
                transportHeadersReceived(Utils.convertHeaders(list));
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public OkHttpClientStream(io.grpc.MethodDescriptor<?, ?> r11, io.grpc.Metadata r12, io.grpc.okhttp.ExceptionHandlingFrameWriter r13, io.grpc.okhttp.OkHttpClientTransport r14, io.grpc.okhttp.OutboundFlowController r15, java.lang.Object r16, int r17, int r18, java.lang.String r19, java.lang.String r20, io.grpc.internal.StatsTraceContext r21, io.grpc.internal.TransportTracer r22, io.grpc.CallOptions r23, boolean r24) {
        /*
            r10 = this;
            io.grpc.okhttp.OkHttpWritableBufferAllocator r1 = new io.grpc.okhttp.OkHttpWritableBufferAllocator
            r1.<init>()
            r7 = 0
            if (r24 == 0) goto L19
            boolean r0 = r11.isSafe()
            if (r0 == 0) goto L19
            r0 = 1
            r6 = r0
            r4 = r12
            r2 = r21
            r3 = r22
            r5 = r23
            r0 = r10
            goto L22
        L19:
            r6 = r7
            r0 = r10
            r4 = r12
            r2 = r21
            r3 = r22
            r5 = r23
        L22:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            io.grpc.okhttp.OkHttpClientStream$Sink r0 = new io.grpc.okhttp.OkHttpClientStream$Sink
            r0.<init>()
            r10.sink = r0
            r10.useGet = r7
            java.lang.String r0 = "statsTraceCtx"
            r2 = r21
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r2, r0)
            io.grpc.internal.StatsTraceContext r0 = (io.grpc.internal.StatsTraceContext) r0
            r10.statsTraceCtx = r0
            r10.method = r11
            r3 = r19
            r10.authority = r3
            r3 = r20
            r10.userAgent = r3
            io.grpc.Attributes r3 = r14.getAttributes()
            r10.attributes = r3
            io.grpc.okhttp.OkHttpClientStream$TransportState r0 = new io.grpc.okhttp.OkHttpClientStream$TransportState
            java.lang.String r9 = r11.getFullMethodName()
            r1 = r10
            r5 = r13
            r7 = r14
            r6 = r15
            r4 = r16
            r8 = r18
            r3 = r2
            r2 = r17
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.state = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientStream.<init>(io.grpc.MethodDescriptor, io.grpc.Metadata, io.grpc.okhttp.ExceptionHandlingFrameWriter, io.grpc.okhttp.OkHttpClientTransport, io.grpc.okhttp.OutboundFlowController, java.lang.Object, int, int, java.lang.String, java.lang.String, io.grpc.internal.StatsTraceContext, io.grpc.internal.TransportTracer, io.grpc.CallOptions, boolean):void");
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    public MethodDescriptor.MethodType getType() {
        return this.method.getType();
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        this.authority = (String) Preconditions.checkNotNull(str, "authority");
    }

    public boolean useGet() {
        return this.useGet;
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
