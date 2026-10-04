package io.grpc;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        delegate().close(status, metadata);
    }

    public abstract ServerCall<?, ?> delegate();

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return delegate().getAuthority();
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
    public SecurityLevel getSecurityLevel() {
        return delegate().getSecurityLevel();
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        delegate().sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setCompression(String str) {
        delegate().setCompression(str);
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
