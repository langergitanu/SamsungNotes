package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractFuture<V> implements Future<V> {
    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException {
        await();
        Throwable thCause = cause();
        if (thCause == null) {
            return getNow();
        }
        if (thCause instanceof CancellationException) {
            throw ((CancellationException) thCause);
        }
        throw new ExecutionException(thCause);
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (await(j, timeUnit)) {
            Throwable thCause = cause();
            if (thCause == null) {
                return getNow();
            }
            if (thCause instanceof CancellationException) {
                throw ((CancellationException) thCause);
            }
            throw new ExecutionException(thCause);
        }
        throw new TimeoutException();
    }
}
