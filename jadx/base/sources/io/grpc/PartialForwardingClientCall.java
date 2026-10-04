package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String str, @Nullable Throwable th) {
        delegate().cancel(str, th);
    }

    public abstract ClientCall<?, ?> delegate();

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
