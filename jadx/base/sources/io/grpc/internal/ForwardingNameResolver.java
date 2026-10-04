package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ForwardingNameResolver extends NameResolver {
    private final NameResolver delegate;

    public ForwardingNameResolver(NameResolver nameResolver) {
        Preconditions.checkNotNull(nameResolver, "delegate can not be null");
        this.delegate = nameResolver;
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.delegate.getServiceAuthority();
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        this.delegate.refresh();
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // io.grpc.NameResolver
    @Deprecated
    public void start(NameResolver.Listener listener) {
        this.delegate.start(listener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        this.delegate.start(listener2);
    }
}
