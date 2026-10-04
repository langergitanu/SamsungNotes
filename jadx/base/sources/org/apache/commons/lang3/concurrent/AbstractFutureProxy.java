package org.apache.commons.lang3.concurrent;

import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractFutureProxy<V> implements Future<V> {
    private final Future<V> future;

    public AbstractFutureProxy(Future<V> future) {
        Objects.requireNonNull(future, "future");
        this.future = future;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.future.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.future.get();
    }

    public Future<V> getFuture() {
        return this.future;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.future.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return this.future.get(j, timeUnit);
    }
}
