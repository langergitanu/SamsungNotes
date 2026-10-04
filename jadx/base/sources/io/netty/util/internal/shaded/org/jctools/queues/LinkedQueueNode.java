package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class LinkedQueueNode<E> {
    private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(LinkedQueueNode.class, "next");
    private volatile LinkedQueueNode<E> next;
    private E value;

    public LinkedQueueNode() {
        this(null);
    }

    public E getAndNullValue() {
        E eLpValue = lpValue();
        spValue(null);
        return eLpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueNode<E> lvNext() {
        return this.next;
    }

    public void soNext(LinkedQueueNode<E> linkedQueueNode) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, linkedQueueNode);
    }

    public void spNext(LinkedQueueNode<E> linkedQueueNode) {
        UnsafeAccess.UNSAFE.putObject(this, NEXT_OFFSET, linkedQueueNode);
    }

    public void spValue(E e) {
        this.value = e;
    }

    public LinkedQueueNode(E e) {
        spValue(e);
    }
}
