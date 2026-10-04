package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AtomicSafeInitializer<T> extends AbstractConcurrentInitializer<T, ConcurrentException> {
    private static final Object NO_INIT = new Object();
    private final AtomicReference<AtomicSafeInitializer<T>> factory;
    private final AtomicReference<T> reference;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<I extends AtomicSafeInitializer<T>, T> extends AbstractConcurrentInitializer.AbstractBuilder<I, T, Builder<I, T>, ConcurrentException> {
        @Override // org.apache.commons.lang3.function.FailableSupplier
        public I get() {
            return (I) new AtomicSafeInitializer(getInitializer(), getCloser());
        }
    }

    public static <T> Builder<AtomicSafeInitializer<T>, T> builder() {
        return new Builder<>();
    }

    private T getNoInit() {
        return (T) NO_INIT;
    }

    @Override // org.apache.commons.lang3.function.FailableSupplier
    public final T get() {
        while (true) {
            T t = this.reference.get();
            if (t != getNoInit()) {
                return t;
            }
            AtomicReference<AtomicSafeInitializer<T>> atomicReference = this.factory;
            while (true) {
                if (atomicReference.compareAndSet(null, this)) {
                    this.reference.set(initialize());
                    break;
                }
                if (atomicReference.get() != null) {
                    break;
                }
            }
        }
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        return this.reference.get() != NO_INIT;
    }

    public AtomicSafeInitializer() {
        this.factory = new AtomicReference<>();
        this.reference = new AtomicReference<>(getNoInit());
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public ConcurrentException getTypedException(Exception exc) {
        return new ConcurrentException(exc);
    }

    private AtomicSafeInitializer(FailableSupplier<T, ConcurrentException> failableSupplier, FailableConsumer<T, ConcurrentException> failableConsumer) {
        super(failableSupplier, failableConsumer);
        this.factory = new AtomicReference<>();
        this.reference = new AtomicReference<>(getNoInit());
    }
}
