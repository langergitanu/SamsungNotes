package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class PickSubchannelArgsImpl extends LoadBalancer.PickSubchannelArgs {
    private final CallOptions callOptions;
    private final Metadata headers;
    private final MethodDescriptor<?, ?> method;

    public PickSubchannelArgsImpl(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, "method");
        this.headers = (Metadata) Preconditions.checkNotNull(metadata, Contract.HEADERS);
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PickSubchannelArgsImpl.class == obj.getClass()) {
            PickSubchannelArgsImpl pickSubchannelArgsImpl = (PickSubchannelArgsImpl) obj;
            if (Objects.equal(this.callOptions, pickSubchannelArgsImpl.callOptions) && Objects.equal(this.headers, pickSubchannelArgsImpl.headers) && Objects.equal(this.method, pickSubchannelArgsImpl.method)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public CallOptions getCallOptions() {
        return this.callOptions;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public Metadata getHeaders() {
        return this.headers;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public MethodDescriptor<?, ?> getMethodDescriptor() {
        return this.method;
    }

    public int hashCode() {
        return Objects.hashCode(this.callOptions, this.headers, this.method);
    }

    public final String toString() {
        return "[method=" + this.method + " headers=" + this.headers + " callOptions=" + this.callOptions + "]";
    }
}
