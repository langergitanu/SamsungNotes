package io.grpc.internal;

import com.google.common.base.Objects;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
    private final Attributes attributes;
    private final String authority;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;

    public ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Attributes attributes, @Nullable String str) {
        this.methodDescriptor = methodDescriptor;
        this.attributes = attributes;
        this.authority = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ServerCallInfoImpl)) {
            return false;
        }
        ServerCallInfoImpl serverCallInfoImpl = (ServerCallInfoImpl) obj;
        return Objects.equal(this.methodDescriptor, serverCallInfoImpl.methodDescriptor) && Objects.equal(this.attributes, serverCallInfoImpl.attributes) && Objects.equal(this.authority, serverCallInfoImpl.authority);
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    @Nullable
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.methodDescriptor;
    }

    public int hashCode() {
        return Objects.hashCode(this.methodDescriptor, this.attributes, this.authority);
    }
}
