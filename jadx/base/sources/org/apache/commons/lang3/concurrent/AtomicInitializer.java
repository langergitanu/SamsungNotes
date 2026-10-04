package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AtomicInitializer<T> extends AbstractConcurrentInitializer<T, ConcurrentException> {
    private static final Object NO_INIT = new Object();
    private final AtomicReference<T> reference;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<I extends AtomicInitializer<T>, T> extends AbstractConcurrentInitializer.AbstractBuilder<I, T, Builder<I, T>, ConcurrentException> {
        @Override // org.apache.commons.lang3.function.FailableSupplier
        public I get() {
            return (I) new AtomicInitializer(getInitializer(), getCloser());
        }
    }

    public static <T> Builder<AtomicInitializer<T>, T> builder() {
        return new Builder<>();
    }

    private T getNoInit() {
        return (T) NO_INIT;
    }

    @Override // org.apache.commons.lang3.function.FailableSupplier
    public T get() throws Exception {
        T t = this.reference.get();
        if (t != getNoInit()) {
            return t;
        }
        T tInitialize = initialize();
        AtomicReference<T> atomicReference = this.reference;
        T noInit = getNoInit();
        while (!atomicReference.compareAndSet(noInit, tInitialize)) {
            if (atomicReference.get() != noInit) {
                return this.reference.get();
            }
        }
        return tInitialize;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        return this.reference.get() != NO_INIT;
    }

    public AtomicInitializer() {
        this.reference = new AtomicReference<>(getNoInit());
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public ConcurrentException getTypedException(Exception exc) {
        return new ConcurrentException(exc);
    }

    private AtomicInitializer(FailableSupplier<T, ConcurrentException> failableSupplier, FailableConsumer<T, ConcurrentException> failableConsumer) {
        super(failableSupplier, failableConsumer);
        this.reference = new AtomicReference<>(getNoInit());
    }
}
