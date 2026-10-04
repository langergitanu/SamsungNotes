package io.grpc.stub;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ClientCallStreamObserver<ReqT> extends CallStreamObserver<ReqT> {
    public abstract void cancel(@Nullable String str, @Nullable Throwable th);

    public void disableAutoRequestWithInitial(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.stub.CallStreamObserver
    public abstract boolean isReady();

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void request(int i);

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setMessageCompression(boolean z);

    @Override // io.grpc.stub.CallStreamObserver
    public abstract void setOnReadyHandler(Runnable runnable);
}
