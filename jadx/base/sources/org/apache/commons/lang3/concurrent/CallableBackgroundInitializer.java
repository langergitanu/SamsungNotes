package org.apache.commons.lang3.concurrent;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {
    private final Callable<T> callable;

    public CallableBackgroundInitializer(Callable<T> callable) {
        checkCallable(callable);
        this.callable = callable;
    }

    private void checkCallable(Callable<T> callable) {
        Objects.requireNonNull(callable, "callable");
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer, org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public Exception getTypedException(Exception exc) {
        return new Exception(exc);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public T initialize() {
        return this.callable.call();
    }

    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        checkCallable(callable);
        this.callable = callable;
    }
}
