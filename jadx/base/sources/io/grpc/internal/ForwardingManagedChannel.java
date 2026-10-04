package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    public ForwardingManagedChannel(ManagedChannel managedChannel) {
        this.delegate = managedChannel;
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.delegate.authority();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.delegate.enterIdle();
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z) {
        return this.delegate.getState(z);
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
        this.delegate.notifyWhenStateChanged(connectivityState, runnable);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.delegate.resetConnectBackoff();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        return this.delegate.shutdown();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}
