package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class RetriableStream<ReqT> implements ClientStream {
    private static final Status CANCELLED_BECAUSE_COMMITTED;

    @VisibleForTesting
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS;

    @VisibleForTesting
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS;
    private static Random random;
    private final Executor callExecutor;
    private Status cancellationStatus;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;

    @Nullable
    private final HedgingPolicy hedgingPolicy;
    private boolean isClosed;
    private final boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;

    @GuardedBy("lock")
    private long perRpcBufferUsed;

    @Nullable
    private final RetryPolicy retryPolicy;
    private SavedCloseMasterListenerReason savedCloseMasterListenerReason;
    private final ScheduledExecutorService scheduledExecutorService;

    @GuardedBy("lock")
    private FutureCanceller scheduledHedging;

    @GuardedBy("lock")
    private FutureCanceller scheduledRetry;

    @Nullable
    private final Throttle throttle;
    private final Executor listenerSerializeExecutor = new SynchronizationContext(new Thread.UncaughtExceptionHandler() { // from class: io.grpc.internal.RetriableStream.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw Status.fromThrowable(th).withDescription("Uncaught exception in the SynchronizationContext. Re-thrown.").asRuntimeException();
        }
    });
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private volatile State state = new State(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();
    private final AtomicInteger localOnlyTransparentRetries = new AtomicInteger();
    private final AtomicInteger inFlightSubStreams = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BufferEntry {
        void runWith(Substream substream);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BufferSizeTracer extends ClientStreamTracer {

        @GuardedBy("lock")
        long bufferNeeded;
        private final Substream substream;

        public BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j) {
            if (RetriableStream.this.state.winningSubstream != null) {
                return;
            }
            synchronized (RetriableStream.this.lock) {
                try {
                    if (RetriableStream.this.state.winningSubstream == null && !this.substream.closed) {
                        long j2 = this.bufferNeeded + j;
                        this.bufferNeeded = j2;
                        if (j2 <= RetriableStream.this.perRpcBufferUsed) {
                            return;
                        }
                        if (this.bufferNeeded > RetriableStream.this.perRpcBufferLimit) {
                            this.substream.bufferLimitExceeded = true;
                        } else {
                            long jAddAndGet = RetriableStream.this.channelBufferUsed.addAndGet(this.bufferNeeded - RetriableStream.this.perRpcBufferUsed);
                            RetriableStream.this.perRpcBufferUsed = this.bufferNeeded;
                            if (jAddAndGet > RetriableStream.this.channelBufferLimit) {
                                this.substream.bufferLimitExceeded = true;
                            }
                        }
                        Substream substream = this.substream;
                        Runnable runnableCommit = substream.bufferLimitExceeded ? RetriableStream.this.commit(substream) : null;
                        if (runnableCommit != null) {
                            runnableCommit.run();
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        @VisibleForTesting
        public long addAndGet(long j) {
            return this.bufferUsed.addAndGet(j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FutureCanceller {

        @GuardedBy("lock")
        boolean cancelled;

        @GuardedBy("lock")
        Future<?> future;
        final Object lock;

        public FutureCanceller(Object obj) {
            this.lock = obj;
        }

        @GuardedBy("lock")
        public boolean isCancelled() {
            return this.cancelled;
        }

        @CheckForNull
        @GuardedBy("lock")
        public Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        public void setFuture(Future<?> future) {
            synchronized (this.lock) {
                try {
                    if (!this.cancelled) {
                        this.future = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HedgingPlan {

        @Nullable
        final Integer hedgingPushbackMillis;
        final boolean isHedgeable;

        public HedgingPlan(boolean z, @Nullable Integer num) {
            this.isHedgeable = z;
            this.hedgingPushbackMillis = num;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class HedgingRunnable implements Runnable {
        final FutureCanceller scheduledHedgingRef;

        public HedgingRunnable(FutureCanceller futureCanceller) {
            this.scheduledHedgingRef = futureCanceller;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream retriableStream = RetriableStream.this;
            final Substream substreamCreateSubstream = retriableStream.createSubstream(retriableStream.state.hedgingAttemptCount, false);
            if (substreamCreateSubstream == null) {
                return;
            }
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    FutureCanceller futureCanceller;
                    boolean z;
                    synchronized (RetriableStream.this.lock) {
                        try {
                            futureCanceller = null;
                            if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                                z = true;
                            } else {
                                RetriableStream retriableStream2 = RetriableStream.this;
                                retriableStream2.state = retriableStream2.state.addActiveHedge(substreamCreateSubstream);
                                RetriableStream retriableStream3 = RetriableStream.this;
                                if (retriableStream3.hasPotentialHedging(retriableStream3.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.isAboveThreshold())) {
                                    RetriableStream retriableStream4 = RetriableStream.this;
                                    futureCanceller = new FutureCanceller(retriableStream4.lock);
                                    retriableStream4.scheduledHedging = futureCanceller;
                                } else {
                                    RetriableStream retriableStream5 = RetriableStream.this;
                                    retriableStream5.state = retriableStream5.state.freezeHedging();
                                    RetriableStream.this.scheduledHedging = null;
                                }
                                z = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (z) {
                        Substream substream = substreamCreateSubstream;
                        substream.stream.start(new Sublistener(substream));
                        substreamCreateSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                    } else {
                        if (futureCanceller != null) {
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                        }
                        RetriableStream.this.drain(substreamCreateSubstream);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RetryPlan {
        final long backoffNanos;
        final boolean shouldRetry;

        public RetryPlan(boolean z, long j) {
            this.shouldRetry = z;
            this.backoffNanos = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SavedCloseMasterListenerReason {
        private final Metadata metadata;
        private final ClientStreamListener.RpcProgress progress;
        private final Status status;

        public SavedCloseMasterListenerReason(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            this.status = status;
            this.progress = rpcProgress;
            this.metadata = metadata;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class StartEntry implements BufferEntry {
        public StartEntry() {
        }

        @Override // io.grpc.internal.RetriableStream.BufferEntry
        public void runWith(Substream substream) {
            substream.stream.start(new Sublistener(substream));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class State {
        final Collection<Substream> activeHedges;

        @Nullable
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;

        @Nullable
        final Substream winningSubstream;

        public State(@Nullable List<BufferEntry> list, Collection<Substream> collection, Collection<Substream> collection2, @Nullable Substream substream, boolean z, boolean z2, boolean z3, int i) {
            this.buffer = list;
            this.drainedSubstreams = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.winningSubstream = substream;
            this.activeHedges = collection2;
            this.cancelled = z;
            this.passThrough = z2;
            this.hedgingFrozen = z3;
            this.hedgingAttemptCount = i;
            Preconditions.checkState(!z2 || list == null, "passThrough should imply buffer is null");
            Preconditions.checkState((z2 && substream == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!z2 || (collection.size() == 1 && collection.contains(substream)) || (collection.size() == 0 && substream.closed), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((z && substream == null) ? false : true, "cancelled should imply committed");
        }

        @CheckReturnValue
        public State addActiveHedge(Substream substream) {
            Collection collectionUnmodifiableCollection;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                collectionUnmodifiableCollection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.activeHedges);
                arrayList.add(substream);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.buffer, this.drainedSubstreams, collectionUnmodifiableCollection, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount + 1);
        }

        @CheckReturnValue
        public State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State committed(Substream substream) {
            List<BufferEntry> list;
            boolean z;
            Collection collectionSingleton;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            List<BufferEntry> list2 = this.buffer;
            if (this.drainedSubstreams.contains(substream)) {
                collectionSingleton = Collections.singleton(substream);
                list = null;
                z = true;
            } else {
                list = list2;
                z = false;
                collectionSingleton = Collections.EMPTY_LIST;
            }
            return new State(list, collectionSingleton, this.activeHedges, substream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State freezeHedging() {
            return this.hedgingFrozen ? this : new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State removeActiveHedge(Substream substream) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State replaceActiveHedge(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State substreamClosed(Substream substream) {
            substream.closed = true;
            if (!this.drainedSubstreams.contains(substream)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.drainedSubstreams);
            arrayList.remove(substream);
            return new State(this.buffer, Collections.unmodifiableCollection(arrayList), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        @CheckReturnValue
        public State substreamDrained(Substream substream) {
            Collection collectionUnmodifiableCollection;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                collectionUnmodifiableCollection = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            Substream substream2 = this.winningSubstream;
            boolean z = substream2 != null;
            List<BufferEntry> list = this.buffer;
            if (z) {
                Preconditions.checkState(substream2 == substream, "Another RPC attempt has already committed");
                list = null;
            }
            return new State(list, collection, this.activeHedges, this.winningSubstream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Sublistener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final Substream substream;

        public Sublistener(Substream substream) {
            this.substream = substream;
        }

        @Nullable
        private Integer getPushbackMills(Metadata metadata) {
            String str = (String) metadata.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata metadata) {
            Integer pushbackMills = getPushbackMills(metadata);
            boolean zContains = RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            boolean z = (RetriableStream.this.throttle == null || (!zContains && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            if (zContains && !z && !status.isOk() && pushbackMills != null && pushbackMills.intValue() > 0) {
                pushbackMills = 0;
            }
            return new HedgingPlan(zContains && !z, pushbackMills);
        }

        private RetryPlan makeRetryDecision(Status status, Metadata metadata) {
            long nanos = 0;
            boolean z = false;
            if (RetriableStream.this.retryPolicy == null) {
                return new RetryPlan(false, 0L);
            }
            boolean zContains = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z2 = (RetriableStream.this.throttle == null || (!zContains && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !z2) {
                if (pushbackMills == null) {
                    if (zContains) {
                        nanos = (long) (RetriableStream.random.nextDouble() * RetriableStream.this.nextBackoffIntervalNanos);
                        RetriableStream.this.nextBackoffIntervalNanos = Math.min((long) (r10.nextBackoffIntervalNanos * RetriableStream.this.retryPolicy.backoffMultiplier), RetriableStream.this.retryPolicy.maxBackoffNanos);
                        z = true;
                    }
                } else if (pushbackMills.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(pushbackMills.intValue());
                    RetriableStream retriableStream = RetriableStream.this;
                    retriableStream.nextBackoffIntervalNanos = retriableStream.retryPolicy.initialBackoffNanos;
                    z = true;
                }
            }
            return new RetryPlan(z, nanos);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            FutureCanceller futureCanceller;
            synchronized (RetriableStream.this.lock) {
                RetriableStream retriableStream = RetriableStream.this;
                retriableStream.state = retriableStream.state.substreamClosed(this.substream);
                RetriableStream.this.closedSubstreamsInsight.append(status.getCode());
            }
            if (RetriableStream.this.inFlightSubStreams.decrementAndGet() == Integer.MIN_VALUE) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.isClosed = true;
                        RetriableStream.this.masterListener.closed(RetriableStream.this.savedCloseMasterListenerReason.status, RetriableStream.this.savedCloseMasterListenerReason.progress, RetriableStream.this.savedCloseMasterListenerReason.metadata);
                    }
                });
                return;
            }
            Substream substream = this.substream;
            if (substream.bufferLimitExceeded) {
                RetriableStream.this.commitAndRun(substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.safeCloseMasterListener(status, rpcProgress, metadata);
                    return;
                }
                return;
            }
            ClientStreamListener.RpcProgress rpcProgress2 = ClientStreamListener.RpcProgress.MISCARRIED;
            if (rpcProgress == rpcProgress2 && RetriableStream.this.localOnlyTransparentRetries.incrementAndGet() > 1000) {
                RetriableStream.this.commitAndRun(this.substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.safeCloseMasterListener(Status.INTERNAL.withDescription("Too many transparent retries. Might be a bug in gRPC").withCause(status.asRuntimeException()), rpcProgress, metadata);
                    return;
                }
                return;
            }
            if (RetriableStream.this.state.winningSubstream == null) {
                if (rpcProgress == rpcProgress2 || (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && RetriableStream.this.noMoreTransparentRetry.compareAndSet(false, true))) {
                    final Substream substreamCreateSubstream = RetriableStream.this.createSubstream(this.substream.previousAttemptCount, true);
                    if (substreamCreateSubstream == null) {
                        return;
                    }
                    if (RetriableStream.this.isHedging) {
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream retriableStream2 = RetriableStream.this;
                            retriableStream2.state = retriableStream2.state.replaceActiveHedge(this.substream, substreamCreateSubstream);
                        }
                    }
                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.drain(substreamCreateSubstream);
                        }
                    });
                    return;
                }
                if (rpcProgress != ClientStreamListener.RpcProgress.DROPPED) {
                    RetriableStream.this.noMoreTransparentRetry.set(true);
                    if (RetriableStream.this.isHedging) {
                        HedgingPlan hedgingPlanMakeHedgingDecision = makeHedgingDecision(status, metadata);
                        if (hedgingPlanMakeHedgingDecision.isHedgeable) {
                            RetriableStream.this.pushbackHedging(hedgingPlanMakeHedgingDecision.hedgingPushbackMillis);
                        }
                        synchronized (RetriableStream.this.lock) {
                            try {
                                RetriableStream retriableStream3 = RetriableStream.this;
                                retriableStream3.state = retriableStream3.state.removeActiveHedge(this.substream);
                                if (hedgingPlanMakeHedgingDecision.isHedgeable) {
                                    RetriableStream retriableStream4 = RetriableStream.this;
                                    if (!retriableStream4.hasPotentialHedging(retriableStream4.state)) {
                                        if (!RetriableStream.this.state.activeHedges.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } finally {
                            }
                        }
                    } else {
                        RetryPlan retryPlanMakeRetryDecision = makeRetryDecision(status, metadata);
                        if (retryPlanMakeRetryDecision.shouldRetry) {
                            final Substream substreamCreateSubstream2 = RetriableStream.this.createSubstream(this.substream.previousAttemptCount + 1, false);
                            if (substreamCreateSubstream2 == null) {
                                return;
                            }
                            synchronized (RetriableStream.this.lock) {
                                RetriableStream retriableStream5 = RetriableStream.this;
                                futureCanceller = new FutureCanceller(retriableStream5.lock);
                                retriableStream5.scheduledRetry = futureCanceller;
                            }
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable
                                @Override // java.lang.Runnable
                                public void run() {
                                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            C1RetryBackoffRunnable c1RetryBackoffRunnable = C1RetryBackoffRunnable.this;
                                            RetriableStream.this.drain(substreamCreateSubstream2);
                                        }
                                    });
                                }
                            }, retryPlanMakeRetryDecision.backoffNanos, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (RetriableStream.this.isHedging) {
                    RetriableStream.this.freezeHedging();
                }
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.safeCloseMasterListener(status, rpcProgress, metadata);
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            if (this.substream.previousAttemptCount > 0) {
                Metadata.Key<String> key = RetriableStream.GRPC_PREVIOUS_RPC_ATTEMPTS;
                metadata.discardAll(key);
                metadata.put(key, String.valueOf(this.substream.previousAttemptCount));
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.masterListener.headersRead(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            State state = RetriableStream.this.state;
            Preconditions.checkState(state.winningSubstream != null, "Headers should be received prior to messages.");
            if (state.winningSubstream != this.substream) {
                GrpcUtil.closeQuietly(messageProducer);
            } else {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.masterListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (RetriableStream.this.isReady()) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RetriableStream.this.isClosed) {
                            return;
                        }
                        RetriableStream.this.masterListener.onReady();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Substream {
        boolean bufferLimitExceeded;
        boolean closed;
        final int previousAttemptCount;
        ClientStream stream;

        public Substream(int i) {
            this.previousAttemptCount = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        final int maxTokens;
        final int threshold;
        final AtomicInteger tokenCount;
        final int tokenRatio;

        public Throttle(float f, float f4) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.tokenCount = atomicInteger;
            this.tokenRatio = (int) (f4 * 1000.0f);
            int i = (int) (f * 1000.0f);
            this.maxTokens = i;
            this.threshold = i / 2;
            atomicInteger.set(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Throttle)) {
                return false;
            }
            Throttle throttle = (Throttle) obj;
            return this.maxTokens == throttle.maxTokens && this.tokenRatio == throttle.tokenRatio;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
        }

        @VisibleForTesting
        public boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        @VisibleForTesting
        public boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int i;
            int i2;
            do {
                i = this.tokenCount.get();
                if (i == 0) {
                    return false;
                }
                i2 = i - 1000;
            } while (!this.tokenCount.compareAndSet(i, Math.max(i2, 0)));
            return i2 > this.threshold;
        }

        @VisibleForTesting
        public void onSuccess() {
            int i;
            int i2;
            do {
                i = this.tokenCount.get();
                i2 = this.maxTokens;
                if (i == i2) {
                    return;
                }
            } while (!this.tokenCount.compareAndSet(i, Math.min(this.tokenRatio + i, i2)));
        }
    }

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.m13734of("grpc-previous-rpc-attempts", asciiMarshaller);
        GRPC_RETRY_PUSHBACK_MS = Metadata.Key.m13734of("grpc-retry-pushback-ms", asciiMarshaller);
        CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
        random = new Random();
    }

    public RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable RetryPolicy retryPolicy, @Nullable HedgingPolicy hedgingPolicy, @Nullable Throttle throttle) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j;
        this.channelBufferLimit = j2;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = metadata;
        this.retryPolicy = retryPolicy;
        if (retryPolicy != null) {
            this.nextBackoffIntervalNanos = retryPolicy.initialBackoffNanos;
        }
        this.hedgingPolicy = hedgingPolicy;
        Preconditions.checkArgument(retryPolicy == null || hedgingPolicy == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.isHedging = hedgingPolicy != null;
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(final Substream substream) {
        final Future<?> future;
        final Future<?> future2;
        synchronized (this.lock) {
            try {
                if (this.state.winningSubstream != null) {
                    return null;
                }
                final Collection<Substream> collection = this.state.drainedSubstreams;
                this.state = this.state.committed(substream);
                this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
                FutureCanceller futureCanceller = this.scheduledRetry;
                if (futureCanceller != null) {
                    Future<?> futureMarkCancelled = futureCanceller.markCancelled();
                    this.scheduledRetry = null;
                    future = futureMarkCancelled;
                } else {
                    future = null;
                }
                FutureCanceller futureCanceller2 = this.scheduledHedging;
                if (futureCanceller2 != null) {
                    Future<?> futureMarkCancelled2 = futureCanceller2.markCancelled();
                    this.scheduledHedging = null;
                    future2 = futureMarkCancelled2;
                } else {
                    future2 = null;
                }
                return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Substream substream2 : collection) {
                            if (substream2 != substream) {
                                substream2.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                            }
                        }
                        Future future3 = future;
                        if (future3 != null) {
                            future3.cancel(false);
                        }
                        Future future4 = future2;
                        if (future4 != null) {
                            future4.cancel(false);
                        }
                        RetriableStream.this.postCommit();
                    }
                };
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable runnableCommit = commit(substream);
        if (runnableCommit != null) {
            runnableCommit.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Substream createSubstream(int i, boolean z) {
        int i2;
        do {
            i2 = this.inFlightSubStreams.get();
            if (i2 < 0) {
                return null;
            }
        } while (!this.inFlightSubStreams.compareAndSet(i2, i2 + 1));
        Substream substream = new Substream(i);
        final BufferSizeTracer bufferSizeTracer = new BufferSizeTracer(substream);
        substream.stream = newSubstream(updateHeaders(this.headers, i), new ClientStreamTracer.Factory() { // from class: io.grpc.internal.RetriableStream.2
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return bufferSizeTracer;
            }
        }, i, z);
        return substream;
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            try {
                if (!this.state.passThrough) {
                    this.state.buffer.add(bufferEntry);
                }
                collection = this.state.drainedSubstreams;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<Substream> it = collection.iterator();
        while (it.hasNext()) {
            bufferEntry.runWith(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        r8.listenerSerializeExecutor.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r2 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r9.stream.start(new io.grpc.internal.RetriableStream.Sublistener(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        r0 = r9.stream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r8.state.winningSubstream != r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r9 = r8.cancellationStatus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r9 = io.grpc.internal.RetriableStream.CANCELLED_BECAUSE_COMMITTED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        r0.cancel(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if (r0.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        r4 = (io.grpc.internal.RetriableStream.BufferEntry) r0.next();
        r4.runWith(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
    
        if ((r4 instanceof io.grpc.internal.RetriableStream.StartEntry) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        r4 = r8.state;
        r5 = r4.winningSubstream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r4.cancelled == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain(Substream substream) {
        int iMin;
        int i = 0;
        Runnable runnable = null;
        boolean z = false;
        ArrayList arrayList = null;
        while (true) {
            synchronized (this.lock) {
                try {
                    State state = this.state;
                    Substream substream2 = state.winningSubstream;
                    if (substream2 == null || substream2 == substream) {
                        if (!state.cancelled) {
                            if (i == state.buffer.size()) {
                                this.state = state.substreamDrained(substream);
                                if (!isReady()) {
                                    return;
                                } else {
                                    runnable = new Runnable() { // from class: io.grpc.internal.RetriableStream.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (RetriableStream.this.isClosed) {
                                                return;
                                            }
                                            RetriableStream.this.masterListener.onReady();
                                        }
                                    };
                                }
                            } else {
                                if (substream.closed) {
                                    return;
                                }
                                iMin = Math.min(i + 128, state.buffer.size());
                                if (arrayList == null) {
                                    arrayList = new ArrayList(state.buffer.subList(i, iMin));
                                } else {
                                    arrayList.clear();
                                    arrayList.addAll(state.buffer.subList(i, iMin));
                                }
                            }
                        }
                    }
                } finally {
                }
            }
            i = iMin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> future;
        synchronized (this.lock) {
            try {
                FutureCanceller futureCanceller = this.scheduledHedging;
                future = null;
                if (futureCanceller != null) {
                    Future<?> futureMarkCancelled = futureCanceller.markCancelled();
                    this.scheduledHedging = null;
                    future = futureMarkCancelled;
                }
                this.state = this.state.freezeHedging();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean hasPotentialHedging(State state) {
        return state.winningSubstream == null && state.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state.hedgingFrozen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(@Nullable Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            try {
                FutureCanceller futureCanceller = this.scheduledHedging;
                if (futureCanceller == null) {
                    return;
                }
                Future<?> futureMarkCancelled = futureCanceller.markCancelled();
                FutureCanceller futureCanceller2 = new FutureCanceller(this.lock);
                this.scheduledHedging = futureCanceller2;
                if (futureMarkCancelled != null) {
                    futureMarkCancelled.cancel(false);
                }
                futureCanceller2.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCloseMasterListener(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
        this.savedCloseMasterListenerReason = new SavedCloseMasterListenerReason(status, rpcProgress, metadata);
        if (this.inFlightSubStreams.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.4
                @Override // java.lang.Runnable
                public void run() {
                    RetriableStream.this.isClosed = true;
                    RetriableStream.this.masterListener.closed(status, rpcProgress, metadata);
                }
            });
        }
    }

    @VisibleForTesting
    public static void setRandom(Random random2) {
        random = random2;
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        State state;
        synchronized (this.lock) {
            insightBuilder.appendKeyValue("closed", this.closedSubstreamsInsight);
            state = this.state;
        }
        if (state.winningSubstream != null) {
            InsightBuilder insightBuilder2 = new InsightBuilder();
            state.winningSubstream.stream.appendTimeoutInsight(insightBuilder2);
            insightBuilder.appendKeyValue("committed", insightBuilder2);
            return;
        }
        InsightBuilder insightBuilder3 = new InsightBuilder();
        for (Substream substream : state.drainedSubstreams) {
            InsightBuilder insightBuilder4 = new InsightBuilder();
            substream.stream.appendTimeoutInsight(insightBuilder4);
            insightBuilder3.append(insightBuilder4);
        }
        insightBuilder.appendKeyValue(AbstractCircuitBreaker.PROPERTY_NAME, insightBuilder3);
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        Substream substream;
        Substream substream2 = new Substream(0);
        substream2.stream = new NoopClientStream();
        Runnable runnableCommit = commit(substream2);
        if (runnableCommit != null) {
            synchronized (this.lock) {
                this.state = this.state.substreamDrained(substream2);
            }
            runnableCommit.run();
            safeCloseMasterListener(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.state.drainedSubstreams.contains(this.state.winningSubstream)) {
                    substream = this.state.winningSubstream;
                } else {
                    this.cancellationStatus = status;
                    substream = null;
                }
                this.state = this.state.cancelled();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (substream != null) {
            substream.stream.cancel(status);
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final Attributes getAttributes() {
        return this.state.winningSubstream != null ? this.state.winningSubstream.stream.getAttributes() : Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        Iterator<Substream> it = this.state.drainedSubstreams.iterator();
        while (it.hasNext()) {
            if (it.next().stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    public abstract ClientStream newSubstream(Metadata metadata, ClientStreamTracer.Factory factory, int i, boolean z);

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1OptimizeDirectEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    public abstract void postCommit();

    @CheckReturnValue
    @Nullable
    public abstract Status prestart();

    @Override // io.grpc.internal.Stream
    public final void request(final int i) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.request(i);
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.request(i);
                }
            });
        }
    }

    public final void sendMessage(final ReqT reqt) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(reqt));
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String str) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(final boolean z) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MessageCompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMessageCompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        FutureCanceller futureCanceller;
        Throttle throttle;
        this.masterListener = clientStreamListener;
        Status statusPrestart = prestart();
        if (statusPrestart != null) {
            cancel(statusPrestart);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new StartEntry());
        }
        Substream substreamCreateSubstream = createSubstream(0, false);
        if (substreamCreateSubstream == null) {
            return;
        }
        if (this.isHedging) {
            synchronized (this.lock) {
                try {
                    this.state = this.state.addActiveHedge(substreamCreateSubstream);
                    if (hasPotentialHedging(this.state) && ((throttle = this.throttle) == null || throttle.isAboveThreshold())) {
                        futureCanceller = new FutureCanceller(this.lock);
                        this.scheduledHedging = futureCanceller;
                    } else {
                        futureCanceller = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (futureCanceller != null) {
                futureCanceller.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
            }
        }
        drain(substreamCreateSubstream);
    }

    @VisibleForTesting
    public final Metadata updateHeaders(Metadata metadata, int i) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i > 0) {
            metadata2.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i));
        }
        return metadata2;
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
