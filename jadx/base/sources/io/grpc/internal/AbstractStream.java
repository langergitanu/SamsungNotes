package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframer;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractStream implements Stream {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TransportState implements ApplicationThreadDeframer.TransportExecutor, MessageDeframer.Listener {

        @VisibleForTesting
        public static final int DEFAULT_ONREADY_THRESHOLD = 32768;

        @GuardedBy("onReadyLock")
        private boolean allocated;

        @GuardedBy("onReadyLock")
        private boolean deallocated;
        private Deframer deframer;

        @GuardedBy("onReadyLock")
        private int numSentBytesQueued;
        private final Object onReadyLock = new Object();
        private final MessageDeframer rawDeframer;
        private final StatsTraceContext statsTraceCtx;
        private final TransportTracer transportTracer;

        public TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
            this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
            MessageDeframer messageDeframer = new MessageDeframer(this, Codec.Identity.NONE, i, statsTraceContext, transportTracer);
            this.rawDeframer = messageDeframer;
            this.deframer = messageDeframer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isReady() {
            boolean z;
            synchronized (this.onReadyLock) {
                try {
                    z = this.allocated && this.numSentBytesQueued < 32768 && !this.deallocated;
                } finally {
                }
            }
            return z;
        }

        private void notifyIfReady() {
            boolean zIsReady;
            synchronized (this.onReadyLock) {
                zIsReady = isReady();
            }
            if (zIsReady) {
                listener().onReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendingBytes(int i) {
            synchronized (this.onReadyLock) {
                this.numSentBytesQueued += i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestMessagesFromDeframer(final int i) {
            if (!(this.deframer instanceof ThreadOptimizedDeframer)) {
                final Link linkLinkOut = PerfMark.linkOut();
                runOnTransportThread(new Runnable() { // from class: io.grpc.internal.AbstractStream.TransportState.1RequestRunnable
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("AbstractStream.request");
                            try {
                                PerfMark.linkIn(linkLinkOut);
                                TransportState.this.deframer.request(i);
                                if (taskCloseableTraceTask != null) {
                                    taskCloseableTraceTask.close();
                                }
                            } finally {
                            }
                        } catch (Throwable th) {
                            TransportState.this.deframeFailed(th);
                        }
                    }
                });
                return;
            }
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("AbstractStream.request");
            try {
                this.deframer.request(i);
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

        public final void closeDeframer(boolean z) {
            if (z) {
                this.deframer.close();
            } else {
                this.deframer.closeWhenComplete();
            }
        }

        public final void deframe(ReadableBuffer readableBuffer) {
            try {
                this.deframer.deframe(readableBuffer);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }

        public final StatsTraceContext getStatsTraceContext() {
            return this.statsTraceCtx;
        }

        public TransportTracer getTransportTracer() {
            return this.transportTracer;
        }

        public abstract StreamListener listener();

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            listener().messagesAvailable(messageProducer);
        }

        public final void onSentBytes(int i) {
            boolean z;
            synchronized (this.onReadyLock) {
                Preconditions.checkState(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
                int i2 = this.numSentBytesQueued;
                z = false;
                boolean z2 = i2 < 32768;
                int i4 = i2 - i;
                this.numSentBytesQueued = i4;
                boolean z3 = i4 < 32768;
                if (!z2 && z3) {
                    z = true;
                }
            }
            if (z) {
                notifyIfReady();
            }
        }

        public void onStreamAllocated() {
            Preconditions.checkState(listener() != null);
            synchronized (this.onReadyLock) {
                Preconditions.checkState(!this.allocated, "Already allocated");
                this.allocated = true;
            }
            notifyIfReady();
        }

        public final void onStreamDeallocated() {
            synchronized (this.onReadyLock) {
                this.deallocated = true;
            }
        }

        public final void optimizeForDirectExecutor() {
            this.rawDeframer.setListener(this);
            this.deframer = this.rawDeframer;
        }

        @VisibleForTesting
        public final void requestMessagesFromDeframerForTesting(int i) {
            requestMessagesFromDeframer(i);
        }

        public final void setDecompressor(Decompressor decompressor) {
            this.deframer.setDecompressor(decompressor);
        }

        public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
            this.rawDeframer.setFullStreamDecompressor(gzipInflatingBuffer);
            this.deframer = new ApplicationThreadDeframer(this, this, this.rawDeframer);
        }

        public final void setMaxInboundMessageSize(int i) {
            this.deframer.setMaxInboundMessageSize(i);
        }
    }

    public final void endOfMessages() {
        framer().close();
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        if (framer().isClosed()) {
            return;
        }
        framer().flush();
    }

    public abstract Framer framer();

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return transportState().isReady();
    }

    public final void onSendingBytes(int i) {
        transportState().onSendingBytes(i);
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        transportState().optimizeForDirectExecutor();
    }

    @Override // io.grpc.internal.Stream
    public final void request(int i) {
        transportState().requestMessagesFromDeframer(i);
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(Compressor compressor) {
        framer().setCompressor((Compressor) Preconditions.checkNotNull(compressor, "compressor"));
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(boolean z) {
        framer().setMessageCompression(z);
    }

    public abstract TransportState transportState();

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, "message");
        try {
            if (!framer().isClosed()) {
                framer().writePayload(inputStream);
            }
        } finally {
            GrpcUtil.closeQuietly(inputStream);
        }
    }
}
