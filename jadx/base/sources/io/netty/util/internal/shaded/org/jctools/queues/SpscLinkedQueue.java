package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode();
        spProducerNode(linkedQueueNodeNewNode);
        spConsumerNode(linkedQueueNodeNewNode);
        linkedQueueNodeNewNode.soNext(null);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillUnbounded(this, supplier);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode(e);
        LinkedQueueNode<E> linkedQueueNodeLpProducerNode = lpProducerNode();
        soProducerNode(linkedQueueNodeNewNode);
        linkedQueueNodeLpProducerNode.soNext(linkedQueueNodeNewNode);
        return true;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "limit is negative:"));
        }
        if (i == 0) {
            return 0;
        }
        LinkedQueueNode<E> linkedQueueNodeNewNode = newNode(supplier.get());
        int i2 = 1;
        LinkedQueueNode<E> linkedQueueNode = linkedQueueNodeNewNode;
        while (i2 < i) {
            LinkedQueueNode<E> linkedQueueNodeNewNode2 = newNode(supplier.get());
            linkedQueueNode.spNext(linkedQueueNodeNewNode2);
            i2++;
            linkedQueueNode = linkedQueueNodeNewNode2;
        }
        LinkedQueueNode<E> linkedQueueNodeLpProducerNode = lpProducerNode();
        soProducerNode(linkedQueueNode);
        linkedQueueNodeLpProducerNode.soNext(linkedQueueNodeNewNode);
        return i;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
