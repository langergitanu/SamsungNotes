package io.netty.channel.group;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;

    /* JADX INFO: renamed from: i1 */
    private final Iterator<E> f8860i1;

    /* JADX INFO: renamed from: i2 */
    private final Iterator<E> f8861i2;

    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        this.f8860i1 = (Iterator) ObjectUtil.checkNotNull(it, "i1");
        this.f8861i2 = (Iterator) ObjectUtil.checkNotNull(it2, "i2");
        this.currentIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f8860i1) {
                return false;
            }
            this.currentIterator = this.f8861i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e) {
                if (this.currentIterator != this.f8860i1) {
                    throw e;
                }
                this.currentIterator = this.f8861i2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
