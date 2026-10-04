package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedQueue<E> extends TransformedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = -7901091318986132033L;

    public TransformedQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        super(queue, transformer);
    }

    public static <E> TransformedQueue<E> transformedQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        TransformedQueue<E> transformedQueue = new TransformedQueue<>(queue, transformer);
        if (!queue.isEmpty()) {
            Object[] array = queue.toArray();
            queue.clear();
            for (Object obj : array) {
                transformedQueue.decorated().add(transformer.apply(obj));
            }
        }
        return transformedQueue;
    }

    public static <E> TransformedQueue<E> transformingQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        return new TransformedQueue<>(queue, transformer);
    }

    @Override // java.util.Queue
    public E element() {
        return getQueue().element();
    }

    public Queue<E> getQueue() {
        return (Queue) decorated();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return getQueue().offer(transform(e));
    }

    @Override // java.util.Queue
    public E peek() {
        return getQueue().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return getQueue().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return getQueue().remove();
    }
}
