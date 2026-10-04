package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
    public MpscAtomicArrayQueue(int i) {
        super(i);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == 0) {
            throw new IllegalArgumentException("c is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "limit is negative: "));
        }
        if (i == 0) {
            return 0;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i2 = this.mask;
        long jLpConsumerIndex = lpConsumerIndex();
        for (int i4 = 0; i4 < i; i4++) {
            long j = ((long) i4) + jLpConsumerIndex;
            int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, i2);
            Object objLvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
            if (objLvRefElement == null) {
                return i4;
            }
            AtomicQueueUtil.spRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
            soConsumerIndex(j + 1);
            consumer.accept(objLvRefElement);
        }
        return i;
    }

    public final int failFastOffer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.mask;
        long j = i + 1;
        long jLvProducerIndex = lvProducerIndex();
        if (jLvProducerIndex >= lvProducerLimit()) {
            long jLvConsumerIndex = lvConsumerIndex() + j;
            if (jLvProducerIndex >= jLvConsumerIndex) {
                return 1;
            }
            soProducerLimit(jLvConsumerIndex);
        }
        if (!casProducerIndex(jLvProducerIndex, 1 + jLvProducerIndex)) {
            return -1;
        }
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i), e);
        return 0;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long jLvProducerIndex;
        int iMin;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "limit is negative:"));
        }
        if (i == 0) {
            return 0;
        }
        int i2 = this.mask;
        long j = i2 + 1;
        long jLvProducerLimit = lvProducerLimit();
        do {
            jLvProducerIndex = lvProducerIndex();
            long j2 = jLvProducerLimit - jLvProducerIndex;
            if (j2 <= 0) {
                jLvProducerLimit = lvConsumerIndex() + j;
                j2 = jLvProducerLimit - jLvProducerIndex;
                if (j2 <= 0) {
                    return 0;
                }
                soProducerLimit(jLvProducerLimit);
            }
            iMin = Math.min((int) j2, i);
        } while (!casProducerIndex(jLvProducerIndex, ((long) iMin) + jLvProducerIndex));
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        for (int i4 = 0; i4 < iMin; i4++) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(((long) i4) + jLvProducerIndex, i2), supplier.get());
        }
        return iMin;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        long jLvProducerIndex;
        if (e == null) {
            throw null;
        }
        int i = this.mask;
        long jLvProducerLimit = lvProducerLimit();
        do {
            jLvProducerIndex = lvProducerIndex();
            if (jLvProducerIndex >= jLvProducerLimit) {
                jLvProducerLimit = lvConsumerIndex() + ((long) i) + 1;
                if (jLvProducerIndex >= jLvProducerLimit) {
                    return false;
                }
                soProducerLimit(jLvProducerLimit);
            }
        } while (!casProducerIndex(jLvProducerIndex, 1 + jLvProducerIndex));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i), e);
        return true;
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        long jLvProducerIndex;
        if (e == null) {
            throw null;
        }
        int i2 = this.mask;
        long j = i2 + 1;
        long jLvProducerLimit = lvProducerLimit();
        do {
            jLvProducerIndex = lvProducerIndex();
            long j2 = i;
            if (j - (jLvProducerLimit - jLvProducerIndex) >= j2) {
                long jLvConsumerIndex = lvConsumerIndex();
                if (jLvProducerIndex - jLvConsumerIndex >= j2) {
                    return false;
                }
                jLvProducerLimit = jLvConsumerIndex + j;
                soProducerLimit(jLvProducerLimit);
            }
        } while (!casProducerIndex(jLvProducerIndex, 1 + jLvProducerIndex));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i2), e);
        return true;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E e;
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long jLpConsumerIndex = lpConsumerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.mask);
        E e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        if (e2 != null) {
            return e2;
        }
        if (jLpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        } while (e == null);
        return e;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long jLpConsumerIndex = lpConsumerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.mask);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        if (e == null) {
            if (jLpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
            } while (e == null);
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return e;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long jLpConsumerIndex = lpConsumerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.mask);
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        if (e == null) {
            return null;
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return e;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(E e) {
        return failFastOffer(e);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
