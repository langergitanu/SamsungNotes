package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    public SucceededFuture(EventExecutor eventExecutor, V v) {
        super(eventExecutor);
        this.result = v;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        return this.result;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }
}
