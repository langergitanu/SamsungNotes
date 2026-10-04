package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyInitializer<T> extends AbstractConcurrentInitializer<T, ConcurrentException> {
    private static final Object NO_INIT = new Object();
    private volatile T object;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<I extends LazyInitializer<T>, T> extends AbstractConcurrentInitializer.AbstractBuilder<I, T, Builder<I, T>, ConcurrentException> {
        @Override // org.apache.commons.lang3.function.FailableSupplier
        public I get() {
            return (I) new LazyInitializer(getInitializer(), getCloser());
        }
    }

    public static <T> Builder<LazyInitializer<T>, T> builder() {
        return new Builder<>();
    }

    @Override // org.apache.commons.lang3.function.FailableSupplier
    public T get() {
        T tInitialize;
        T t = this.object;
        Object obj = NO_INIT;
        if (t != obj) {
            return t;
        }
        synchronized (this) {
            try {
                tInitialize = this.object;
                if (tInitialize == obj) {
                    tInitialize = initialize();
                    this.object = tInitialize;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tInitialize;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        return this.object != NO_INIT;
    }

    public LazyInitializer() {
        this.object = (T) NO_INIT;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public ConcurrentException getTypedException(Exception exc) {
        return new ConcurrentException(exc);
    }

    private LazyInitializer(FailableSupplier<T, ConcurrentException> failableSupplier, FailableConsumer<T, ConcurrentException> failableConsumer) {
        super(failableSupplier, failableConsumer);
        this.object = (T) NO_INIT;
    }
}
