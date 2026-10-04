package io.grpc.internal;

import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class BackoffPolicyRetryScheduler implements RetryScheduler {
    private static final Logger logger = Logger.getLogger(BackoffPolicyRetryScheduler.class.getName());
    private BackoffPolicy policy;
    private final BackoffPolicy.Provider policyProvider;
    private final ScheduledExecutorService scheduledExecutorService;
    private SynchronizationContext.ScheduledHandle scheduledHandle;
    private final SynchronizationContext syncContext;

    public BackoffPolicyRetryScheduler(BackoffPolicy.Provider provider, ScheduledExecutorService scheduledExecutorService, SynchronizationContext synchronizationContext) {
        this.policyProvider = provider;
        this.scheduledExecutorService = scheduledExecutorService;
        this.syncContext = synchronizationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reset$0() {
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduledHandle;
        if (scheduledHandle != null && scheduledHandle.isPending()) {
            this.scheduledHandle.cancel();
        }
        this.policy = null;
    }

    @Override // io.grpc.internal.RetryScheduler
    public void reset() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        this.syncContext.execute(new RunnableC12222a(this, 0));
    }

    @Override // io.grpc.internal.RetryScheduler
    public void schedule(Runnable runnable) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.policy == null) {
            this.policy = this.policyProvider.get();
        }
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduledHandle;
        if (scheduledHandle == null || !scheduledHandle.isPending()) {
            long jNextBackoffNanos = this.policy.nextBackoffNanos();
            this.scheduledHandle = this.syncContext.schedule(runnable, jNextBackoffNanos, TimeUnit.NANOSECONDS, this.scheduledExecutorService);
            logger.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jNextBackoffNanos));
        }
    }
}
