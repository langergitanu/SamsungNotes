package io.grpc.stub;

import io.grpc.ExperimentalApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8499")
public abstract class CallStreamObserver<V> implements StreamObserver<V> {
    public abstract void disableAutoInboundFlowControl();

    public abstract boolean isReady();

    public abstract void request(int i);

    public abstract void setMessageCompression(boolean z);

    public abstract void setOnReadyHandler(Runnable runnable);
}
