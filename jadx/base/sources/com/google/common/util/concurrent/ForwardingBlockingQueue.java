package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingQueue<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    @CanIgnoreReturnValue
    public int drainTo(Collection<? super E> collection, int i) {
        return delegate().drainTo(collection, i);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CanIgnoreReturnValue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return delegate().offer(e, j, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll(long j, TimeUnit timeUnit) {
        return delegate().poll(j, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        delegate().put(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    @CanIgnoreReturnValue
    public E take() {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingQueue
    @CanIgnoreReturnValue
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }
}
