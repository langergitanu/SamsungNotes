package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DelayedStream implements ClientStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @GuardedBy("this")
    private DelayedStreamListener delayedListener;

    @GuardedBy("this")
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;

    @GuardedBy("this")
    private List<Runnable> pendingCalls = new ArrayList();
    private List<Runnable> preStartPendingCalls = new ArrayList();
    private ClientStream realStream;

    @GuardedBy("this")
    private long startTimeNanos;

    @GuardedBy("this")
    private long streamSetTimeNanos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DelayedStreamListener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;

        @GuardedBy("this")
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientStreamListener realListener;

        public DelayedStreamListener(ClientStreamListener clientStreamListener) {
            this.realListener = clientStreamListener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.passThrough) {
                        runnable.run();
                    } else {
                        this.pendingCallbacks.add(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, rpcProgress, metadata);
                }
            });
        }

        public void drainPendingCallbacks() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.pendingCallbacks.isEmpty()) {
                            this.pendingCallbacks = null;
                            this.passThrough = true;
                            return;
                        } else {
                            list = this.pendingCallbacks;
                            this.pendingCallbacks = arrayList;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                arrayList = list;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(metadata);
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            if (this.passThrough) {
                this.realListener.messagesAvailable(messageProducer);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    private void delayOrExecute(Runnable runnable) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.passThrough) {
                    runnable.run();
                } else {
                    this.pendingCalls.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r0.next().run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainPendingCalls() {
        DelayedStreamListener delayedStreamListener;
        List<Runnable> list;
        List<Runnable> arrayList = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.pendingCalls.isEmpty()) {
                    break;
                }
                list = this.pendingCalls;
                this.pendingCalls = arrayList;
            }
            if (delayedStreamListener == null) {
                delayedStreamListener.drainPendingCallbacks();
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.pendingCalls = null;
        this.passThrough = true;
        delayedStreamListener = this.delayedListener;
        if (delayedStreamListener == null) {
        }
    }

    private void internalStart(ClientStreamListener clientStreamListener) {
        Iterator<Runnable> it = this.preStartPendingCalls.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.preStartPendingCalls = null;
        this.realStream.start(clientStreamListener);
    }

    @GuardedBy("this")
    private void setRealStream(ClientStream clientStream) {
        ClientStream clientStream2 = this.realStream;
        Preconditions.checkState(clientStream2 == null, "realStream already set to %s", clientStream2);
        this.realStream = clientStream;
        this.streamSetTimeNanos = System.nanoTime();
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        synchronized (this) {
            try {
                if (this.listener == null) {
                    return;
                }
                if (this.realStream != null) {
                    insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(this.streamSetTimeNanos - this.startTimeNanos));
                    this.realStream.appendTimeoutInsight(insightBuilder);
                } else {
                    insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(System.nanoTime() - this.startTimeNanos));
                    insightBuilder.append("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(final Status status) {
        boolean z = false;
        Preconditions.checkState(this.listener != null, "May only be called after start");
        Preconditions.checkNotNull(status, "reason");
        synchronized (this) {
            try {
                if (this.realStream == null) {
                    setRealStream(NoopClientStream.INSTANCE);
                    this.error = status;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.8
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.cancel(status);
                }
            });
            return;
        }
        drainPendingCalls();
        onEarlyCancellation(status);
        this.listener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.7
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        ClientStream clientStream;
        synchronized (this) {
            clientStream = this.realStream;
        }
        return clientStream != null ? clientStream.getAttributes() : Attributes.EMPTY;
    }

    @VisibleForTesting
    public ClientStream getRealStream() {
        return this.realStream;
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.9
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    public void onEarlyCancellation(Status status) {
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.11
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void request(final int i) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.request(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.10
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.request(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(final String str) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(str, "authority");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.5
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(final Compressor compressor) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(compressor, "compressor");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.12
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(final Deadline deadline) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.3
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.14
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(final boolean z) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.13
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(final int i) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.1
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxInboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(final int i) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.2
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxOutboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(final boolean z) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.15
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(z);
                }
            });
        }
    }

    @CheckReturnValue
    public final Runnable setStream(ClientStream clientStream) {
        synchronized (this) {
            try {
                if (this.realStream != null) {
                    return null;
                }
                setRealStream((ClientStream) Preconditions.checkNotNull(clientStream, "stream"));
                ClientStreamListener clientStreamListener = this.listener;
                if (clientStreamListener == null) {
                    this.pendingCalls = null;
                    this.passThrough = true;
                }
                if (clientStreamListener == null) {
                    return null;
                }
                internalStart(clientStreamListener);
                return new Runnable() { // from class: io.grpc.internal.DelayedStream.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStream.this.drainPendingCalls();
                    }
                };
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        Status status;
        boolean z;
        Preconditions.checkNotNull(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            try {
                status = this.error;
                z = this.passThrough;
                if (!z) {
                    DelayedStreamListener delayedStreamListener = new DelayedStreamListener(clientStreamListener);
                    this.delayedListener = delayedStreamListener;
                    clientStreamListener = delayedStreamListener;
                }
                this.listener = clientStreamListener;
                this.startTimeNanos = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (status != null) {
            clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
        } else if (z) {
            internalStart(clientStreamListener);
        }
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(final InputStream inputStream) {
        Preconditions.checkState(this.listener != null, "May only be called after start");
        Preconditions.checkNotNull(inputStream, "message");
        if (this.passThrough) {
            this.realStream.writeMessage(inputStream);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.writeMessage(inputStream);
                }
            });
        }
    }
}
