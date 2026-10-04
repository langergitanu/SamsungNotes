package io.grpc.stub;

import io.grpc.ExperimentalApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ServerCallStreamObserver<RespT> extends CallStreamObserver<RespT> {
    public void disableAutoRequest() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isCancelled();

    @Override // io.grpc.stub.CallStreamObserver
    public abstract boolean isReady();

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void request(int i);

    public abstract void setCompression(String str);

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setMessageCompression(boolean z);

    public abstract void setOnCancelHandler(Runnable runnable);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/8467")
    public void setOnCloseHandler(Runnable runnable) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setOnReadyHandler(Runnable runnable);
}
