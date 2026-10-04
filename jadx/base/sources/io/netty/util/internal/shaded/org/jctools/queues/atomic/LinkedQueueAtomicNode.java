package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class LinkedQueueAtomicNode<E> extends AtomicReference<LinkedQueueAtomicNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueAtomicNode() {
    }

    public E getAndNullValue() {
        E eLpValue = lpValue();
        spValue(null);
        return eLpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueAtomicNode<E> lvNext() {
        return get();
    }

    public void soNext(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        lazySet(linkedQueueAtomicNode);
    }

    public void spNext(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        lazySet(linkedQueueAtomicNode);
    }

    public void spValue(E e) {
        this.value = e;
    }

    public LinkedQueueAtomicNode(E e) {
        spValue(e);
    }
}
