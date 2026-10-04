package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedQueue<E> extends PredicatedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 2307609000539943581L;

    public PredicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        super(queue, predicate);
    }

    public static <E> PredicatedQueue<E> predicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        return new PredicatedQueue<>(queue, predicate);
    }

    @Override // java.util.Queue
    public E element() {
        return decorated().element();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        validate(e);
        return decorated().offer(e);
    }

    @Override // java.util.Queue
    public E peek() {
        return decorated().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return decorated().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return decorated().remove();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }
}
