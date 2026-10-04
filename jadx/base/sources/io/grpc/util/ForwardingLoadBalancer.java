package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ConnectivityStateInfo;
import io.grpc.ExperimentalApi;
import io.grpc.LoadBalancer;
import io.grpc.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public abstract class ForwardingLoadBalancer extends LoadBalancer {
    @Override // io.grpc.LoadBalancer
    public boolean canHandleEmptyAddressListFromNameResolution() {
        return delegate().canHandleEmptyAddressListFromNameResolution();
    }

    public abstract LoadBalancer delegate();

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        delegate().handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        delegate().handleResolvedAddresses(resolvedAddresses);
    }

    @Override // io.grpc.LoadBalancer
    @Deprecated
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        delegate().handleSubchannelState(subchannel, connectivityStateInfo);
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        delegate().requestConnection();
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        delegate().shutdown();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
