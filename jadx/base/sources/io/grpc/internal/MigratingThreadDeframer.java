package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class MigratingThreadDeframer implements ThreadOptimizedDeframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;

    @GuardedBy("lock")
    private boolean deframerOnTransportThread;

    @GuardedBy("lock")
    private boolean messageProducerEnqueued;
    private final MigratingDeframerListener migratingListener;
    private final ApplicationThreadDeframerListener.TransportExecutor transportExecutor;
    private final MessageDeframer.Listener transportListener;
    private final DeframeMessageProducer messageProducer = new DeframeMessageProducer();
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Queue<InterfaceC12188Op> opQueue = new ArrayDeque();

    /* JADX INFO: renamed from: io.grpc.internal.MigratingThreadDeframer$1DeframeOp, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C1DeframeOp implements InterfaceC12188Op, Closeable {
        final /* synthetic */ ReadableBuffer val$data;

        public C1DeframeOp(ReadableBuffer readableBuffer) {
            this.val$data = readableBuffer;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.val$data.close();
        }

        @Override // io.grpc.internal.MigratingThreadDeframer.InterfaceC12188Op
        public void run(boolean z) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.deframe");
            try {
                if (z) {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                        return;
                    }
                    return;
                }
                try {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                } catch (Throwable th) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th);
                    MigratingThreadDeframer.this.deframer.close();
                }
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th2) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DeframeMessageProducer implements StreamListener.MessageProducer, Closeable {
        public DeframeMessageProducer() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InterfaceC12188Op interfaceC12188Op;
            while (true) {
                synchronized (MigratingThreadDeframer.this.lock) {
                    do {
                        try {
                            interfaceC12188Op = (InterfaceC12188Op) MigratingThreadDeframer.this.opQueue.poll();
                            if (interfaceC12188Op == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } while (!(interfaceC12188Op instanceof Closeable));
                    if (interfaceC12188Op == null) {
                        MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return;
                    }
                }
                GrpcUtil.closeQuietly((Closeable) interfaceC12188Op);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        
            if (r4.this$0.deframer.hasPendingDeliveries() == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        
            io.perfmark.PerfMark.event("MigratingThreadDeframer.deframerOnTransportThread");
            r4.this$0.migratingListener.setDelegate(r4.this$0.transportListener);
            r4.this$0.deframerOnTransportThread = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            r4.this$0.messageProducerEnqueued = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        
            return null;
         */
        @Override // io.grpc.internal.StreamListener.MessageProducer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InputStream next() {
            InterfaceC12188Op interfaceC12188Op;
            while (true) {
                InputStream inputStreamMessageReadQueuePoll = MigratingThreadDeframer.this.appListener.messageReadQueuePoll();
                if (inputStreamMessageReadQueuePoll != null) {
                    return inputStreamMessageReadQueuePoll;
                }
                synchronized (MigratingThreadDeframer.this.lock) {
                    try {
                        interfaceC12188Op = (InterfaceC12188Op) MigratingThreadDeframer.this.opQueue.poll();
                        if (interfaceC12188Op == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                interfaceC12188Op.run(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MigratingDeframerListener extends ForwardingDeframerListener {
        private MessageDeframer.Listener delegate;

        public MigratingDeframerListener(MessageDeframer.Listener listener) {
            setDelegate(listener);
        }

        @Override // io.grpc.internal.ForwardingDeframerListener
        public MessageDeframer.Listener delegate() {
            return this.delegate;
        }

        public void setDelegate(MessageDeframer.Listener listener) {
            this.delegate = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, "delegate");
        }
    }

    /* JADX INFO: renamed from: io.grpc.internal.MigratingThreadDeframer$Op */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InterfaceC12188Op {
        void run(boolean z);
    }

    public MigratingThreadDeframer(MessageDeframer.Listener listener, ApplicationThreadDeframerListener.TransportExecutor transportExecutor, MessageDeframer messageDeframer) {
        SquelchLateMessagesAvailableDeframerListener squelchLateMessagesAvailableDeframerListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
        this.transportListener = squelchLateMessagesAvailableDeframerListener;
        this.transportExecutor = (ApplicationThreadDeframerListener.TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
        ApplicationThreadDeframerListener applicationThreadDeframerListener = new ApplicationThreadDeframerListener(squelchLateMessagesAvailableDeframerListener, transportExecutor);
        this.appListener = applicationThreadDeframerListener;
        MigratingDeframerListener migratingDeframerListener = new MigratingDeframerListener(applicationThreadDeframerListener);
        this.migratingListener = migratingDeframerListener;
        messageDeframer.setListener(migratingDeframerListener);
        this.deframer = messageDeframer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFromTransportThread(final int i) {
        runWhereAppropriate(new InterfaceC12188Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestAgainOp
            @Override // io.grpc.internal.MigratingThreadDeframer.InterfaceC12188Op
            public void run(boolean z) {
                if (!z) {
                    MigratingThreadDeframer.this.request(i);
                    return;
                }
                try {
                    MigratingThreadDeframer.this.deframer.request(i);
                } catch (Throwable th) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th);
                    MigratingThreadDeframer.this.deframer.close();
                }
                if (MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                    return;
                }
                synchronized (MigratingThreadDeframer.this.lock) {
                    PerfMark.event("MigratingThreadDeframer.deframerOnApplicationThread");
                    MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.appListener);
                    MigratingThreadDeframer.this.deframerOnTransportThread = false;
                }
            }
        });
    }

    private boolean runWhereAppropriate(InterfaceC12188Op interfaceC12188Op) {
        return runWhereAppropriate(interfaceC12188Op, true);
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        if (runWhereAppropriate(new InterfaceC12188Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseOp
            @Override // io.grpc.internal.MigratingThreadDeframer.InterfaceC12188Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.close();
            }
        })) {
            return;
        }
        this.deframer.stopDelivery();
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        runWhereAppropriate(new InterfaceC12188Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseWhenCompleteOp
            @Override // io.grpc.internal.MigratingThreadDeframer.InterfaceC12188Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.closeWhenComplete();
            }
        });
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer readableBuffer) {
        runWhereAppropriate(new C1DeframeOp(readableBuffer));
    }

    @Override // io.grpc.internal.ThreadOptimizedDeframer, io.grpc.internal.Deframer
    public void request(final int i) {
        runWhereAppropriate(new InterfaceC12188Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp
            @Override // io.grpc.internal.MigratingThreadDeframer.InterfaceC12188Op
            public void run(boolean z) {
                if (z) {
                    final Link linkLinkOut = PerfMark.linkOut();
                    MigratingThreadDeframer.this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.request");
                            try {
                                PerfMark.linkIn(linkLinkOut);
                                C1RequestOp c1RequestOp = C1RequestOp.this;
                                MigratingThreadDeframer.this.requestFromTransportThread(i);
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
                    return;
                }
                try {
                    TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.request");
                    try {
                        MigratingThreadDeframer.this.deframer.request(i);
                        if (taskCloseableTraceTask != null) {
                            taskCloseableTraceTask.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th);
                    MigratingThreadDeframer.this.deframer.close();
                }
            }
        }, false);
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i) {
        this.deframer.setMaxInboundMessageSize(i);
    }

    private boolean runWhereAppropriate(InterfaceC12188Op interfaceC12188Op, boolean z) {
        boolean z2;
        boolean z3;
        synchronized (this.lock) {
            try {
                z2 = this.deframerOnTransportThread;
                z3 = this.messageProducerEnqueued;
                if (!z2) {
                    this.opQueue.offer(interfaceC12188Op);
                    this.messageProducerEnqueued = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            interfaceC12188Op.run(true);
            return true;
        }
        if (z3) {
            return false;
        }
        if (!z) {
            final Link linkLinkOut = PerfMark.linkOut();
            this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1
                @Override // java.lang.Runnable
                public void run() {
                    TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
                    try {
                        PerfMark.linkIn(linkLinkOut);
                        MigratingThreadDeframer.this.transportListener.messagesAvailable(MigratingThreadDeframer.this.messageProducer);
                        if (taskCloseableTraceTask != null) {
                            taskCloseableTraceTask.close();
                        }
                    } catch (Throwable th2) {
                        if (taskCloseableTraceTask != null) {
                            try {
                                taskCloseableTraceTask.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            });
            return false;
        }
        TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
        try {
            this.transportListener.messagesAvailable(this.messageProducer);
            if (taskCloseableTraceTask == null) {
                return false;
            }
            taskCloseableTraceTask.close();
            return false;
        } catch (Throwable th2) {
            if (taskCloseableTraceTask != null) {
                try {
                    taskCloseableTraceTask.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
