package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.SynchronizationContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class RetryingNameResolver extends ForwardingNameResolver {
    static final Attributes.Key<ResolutionResultListener> RESOLUTION_RESULT_LISTENER_KEY = Attributes.Key.create("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");
    private final NameResolver retriedNameResolver;
    private final RetryScheduler retryScheduler;
    private final SynchronizationContext syncContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public class DelayedNameResolverRefresh implements Runnable {
        public DelayedNameResolverRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RetryingNameResolver.this.refresh();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ResolutionResultListener {
        public ResolutionResultListener() {
        }

        public void resolutionAttempted(boolean z) {
            if (z) {
                RetryingNameResolver.this.retryScheduler.reset();
            } else {
                RetryingNameResolver.this.retryScheduler.schedule(RetryingNameResolver.this.new DelayedNameResolverRefresh());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RetryingListener extends NameResolver.Listener2 {
        private NameResolver.Listener2 delegateListener;

        public RetryingListener(NameResolver.Listener2 listener2) {
            this.delegateListener = listener2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0() {
            RetryingNameResolver.this.retryScheduler.schedule(RetryingNameResolver.this.new DelayedNameResolverRefresh());
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(Status status) {
            this.delegateListener.onError(status);
            RetryingNameResolver.this.syncContext.execute(new RunnableC12222a(this, 1));
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(NameResolver.ResolutionResult resolutionResult) {
            Attributes attributes = resolutionResult.getAttributes();
            Attributes.Key<ResolutionResultListener> key = RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY;
            if (attributes.get(key) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.delegateListener.onResult(resolutionResult.toBuilder().setAttributes(resolutionResult.getAttributes().toBuilder().set(key, RetryingNameResolver.this.new ResolutionResultListener()).build()).build());
        }
    }

    public RetryingNameResolver(NameResolver nameResolver, RetryScheduler retryScheduler, SynchronizationContext synchronizationContext) {
        super(nameResolver);
        this.retriedNameResolver = nameResolver;
        this.retryScheduler = retryScheduler;
        this.syncContext = synchronizationContext;
    }

    @VisibleForTesting
    public NameResolver getRetriedNameResolver() {
        return this.retriedNameResolver;
    }

    @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
    public void shutdown() {
        super.shutdown();
        this.retryScheduler.reset();
    }

    @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        super.start((NameResolver.Listener2) new RetryingListener(listener2));
    }
}
