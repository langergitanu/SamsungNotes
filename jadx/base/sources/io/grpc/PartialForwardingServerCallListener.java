package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ServerCall;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class PartialForwardingServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
    public abstract ServerCall.Listener<?> delegate();

    @Override // io.grpc.ServerCall.Listener
    public void onCancel() {
        delegate().onCancel();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onComplete() {
        delegate().onComplete();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onHalfClose() {
        delegate().onHalfClose();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
