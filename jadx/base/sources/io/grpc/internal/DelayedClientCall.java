package io.grpc.internal;

import androidx.compose.runtime.AbstractC1974b;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import io.grpc.Attributes;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DelayedClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Executor callExecutor;
    private final Context context;

    @GuardedBy("this")
    private DelayedListener<RespT> delayedListener;

    @GuardedBy("this")
    private Status error;

    @Nullable
    private final ScheduledFuture<?> initialDeadlineMonitor;
    private ClientCall.Listener<RespT> listener;
    private volatile boolean passThrough;

    @GuardedBy("this")
    private List<Runnable> pendingRunnables = new ArrayList();
    private ClientCall<ReqT, RespT> realCall;
    private static final Logger logger = Logger.getLogger(DelayedClientCall.class.getName());
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.internal.DelayedClientCall.8
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class CloseListenerRunnable extends ContextRunnable {
        final ClientCall.Listener<RespT> listener;
        final Status status;

        public CloseListenerRunnable(ClientCall.Listener<RespT> listener, Status status) {
            super(DelayedClientCall.this.context);
            this.listener = listener;
            this.status = status;
        }

        @Override // io.grpc.internal.ContextRunnable
        public void runInContext() {
            this.listener.onClose(this.status, new Metadata());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DelayedListener<RespT> extends ClientCall.Listener<RespT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;

        @GuardedBy("this")
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientCall.Listener<RespT> realListener;

        public DelayedListener(ClientCall.Listener<RespT> listener) {
            this.realListener = listener;
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

        @Override // io.grpc.ClientCall.Listener
        public void onClose(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedListener.this.realListener.onClose(status, metadata);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(final Metadata metadata) {
            if (this.passThrough) {
                this.realListener.onHeaders(metadata);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onHeaders(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(final RespT respt) {
            if (this.passThrough) {
                this.realListener.onMessage(respt);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onMessage(respt);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    public DelayedClientCall(Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable Deadline deadline) {
        this.callExecutor = (Executor) Preconditions.checkNotNull(executor, "callExecutor");
        Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.context = Context.current();
        this.initialDeadlineMonitor = scheduleDeadlineIfNeeded(scheduledExecutorService, deadline);
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.passThrough) {
                    runnable.run();
                } else {
                    this.pendingRunnables.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r0.next().run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainPendingCalls() {
        final DelayedListener<RespT> delayedListener;
        List<Runnable> list;
        List<Runnable> arrayList = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.pendingRunnables.isEmpty()) {
                    break;
                }
                list = this.pendingRunnables;
                this.pendingRunnables = arrayList;
            }
            if (delayedListener == null) {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.DelayedClientCall.1DrainListenerRunnable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(DelayedClientCall.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        delayedListener.drainPendingCallbacks();
                    }
                });
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.pendingRunnables = null;
        this.passThrough = true;
        delayedListener = this.delayedListener;
        if (delayedListener == null) {
        }
    }

    private boolean isAbeforeB(@Nullable Deadline deadline, @Nullable Deadline deadline2) {
        if (deadline2 == null) {
            return true;
        }
        if (deadline == null) {
            return false;
        }
        return deadline.isBefore(deadline2);
    }

    @Nullable
    private ScheduledFuture<?> scheduleDeadlineIfNeeded(ScheduledExecutorService scheduledExecutorService, @Nullable Deadline deadline) {
        Deadline deadline2 = this.context.getDeadline();
        if (deadline == null && deadline2 == null) {
            return null;
        }
        long jTimeRemaining = deadline != null ? deadline.timeRemaining(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (deadline2 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (deadline2.timeRemaining(timeUnit) < jTimeRemaining) {
                jTimeRemaining = deadline2.timeRemaining(timeUnit);
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(AbstractC1974b.m1317j(jTimeRemaining, "Call timeout set to '", "' ns, due to context deadline."));
                    if (deadline == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(" Explicit call timeout was '" + deadline.timeRemaining(timeUnit) + "' ns.");
                    }
                    logger2.fine(sb.toString());
                }
            }
        }
        long jAbs = Math.abs(jTimeRemaining);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jTimeRemaining) % timeUnit2.toNanos(1L);
        final StringBuilder sb2 = new StringBuilder();
        String str = isAbeforeB(deadline2, deadline) ? AuthenticationConstants.Broker.CHALLENGE_RESPONSE_CONTEXT : "CallOptions";
        if (jTimeRemaining < 0) {
            AbstractC1974b.m1332y(sb2, "ClientCall started after ", str, " deadline was exceeded. Deadline has been exceeded for ");
        } else {
            AbstractC1974b.m1332y(sb2, "Deadline ", str, " will be exceeded in ");
        }
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1DeadlineExceededRunnable
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.cancel(Status.DEADLINE_EXCEEDED.withDescription(sb2.toString()), true);
            }
        }, jTimeRemaining, TimeUnit.NANOSECONDS);
    }

    @GuardedBy("this")
    private void setRealCall(ClientCall<ReqT, RespT> clientCall) {
        ClientCall<ReqT, RespT> clientCall2 = this.realCall;
        Preconditions.checkState(clientCall2 == null, "realCall already set to %s", clientCall2);
        ScheduledFuture<?> scheduledFuture = this.initialDeadlineMonitor;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.realCall = clientCall;
    }

    public void callCancelled() {
    }

    @Override // io.grpc.ClientCall
    public final void cancel(@Nullable String str, @Nullable Throwable th) {
        Status status = Status.CANCELLED;
        Status statusWithDescription = str != null ? status.withDescription(str) : status.withDescription("Call cancelled without message");
        if (th != null) {
            statusWithDescription = statusWithDescription.withCause(th);
        }
        cancel(statusWithDescription, false);
    }

    @Override // io.grpc.ClientCall
    public final Attributes getAttributes() {
        ClientCall<ReqT, RespT> clientCall;
        synchronized (this) {
            clientCall = this.realCall;
        }
        return clientCall != null ? clientCall.getAttributes() : Attributes.EMPTY;
    }

    @VisibleForTesting
    public final ClientCall<ReqT, RespT> getRealCall() {
        return this.realCall;
    }

    @Override // io.grpc.ClientCall
    public final void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.7
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.realCall.halfClose();
            }
        });
    }

    @Override // io.grpc.ClientCall
    public final boolean isReady() {
        if (this.passThrough) {
            return this.realCall.isReady();
        }
        return false;
    }

    @Override // io.grpc.ClientCall
    public final void request(final int i) {
        if (this.passThrough) {
            this.realCall.request(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.request(i);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void sendMessage(final ReqT reqt) {
        if (this.passThrough) {
            this.realCall.sendMessage(reqt);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.sendMessage(reqt);
                }
            });
        }
    }

    public final Runnable setCall(ClientCall<ReqT, RespT> clientCall) {
        synchronized (this) {
            try {
                if (this.realCall != null) {
                    return null;
                }
                setRealCall((ClientCall) Preconditions.checkNotNull(clientCall, NotificationCompat.CATEGORY_CALL));
                return new ContextRunnable(this.context) { // from class: io.grpc.internal.DelayedClientCall.1
                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        DelayedClientCall.this.drainPendingCalls();
                    }
                };
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.ClientCall
    public final void setMessageCompression(final boolean z) {
        if (this.passThrough) {
            this.realCall.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.setMessageCompression(z);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void start(final ClientCall.Listener<RespT> listener, final Metadata metadata) {
        Status status;
        boolean z;
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            try {
                this.listener = (ClientCall.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                status = this.error;
                z = this.passThrough;
                if (!z) {
                    DelayedListener<RespT> delayedListener = new DelayedListener<>(listener);
                    this.delayedListener = delayedListener;
                    listener = delayedListener;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (status != null) {
            this.callExecutor.execute(new CloseListenerRunnable(listener, status));
        } else if (z) {
            this.realCall.start(listener, metadata);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.2
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.start(listener, metadata);
                }
            });
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("realCall", this.realCall).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cancel(final Status status, boolean z) {
        boolean z2;
        ClientCall.Listener<RespT> listener;
        synchronized (this) {
            try {
                if (this.realCall == null) {
                    setRealCall(NOOP_CALL);
                    listener = this.listener;
                    this.error = status;
                    z2 = false;
                } else {
                    if (z) {
                        return;
                    }
                    z2 = true;
                    listener = null;
                }
                if (z2) {
                    delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DelayedClientCall.this.realCall.cancel(status.getDescription(), status.getCause());
                        }
                    });
                } else {
                    if (listener != null) {
                        this.callExecutor.execute(new CloseListenerRunnable(listener, status));
                    }
                    drainPendingCalls();
                }
                callCancelled();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
