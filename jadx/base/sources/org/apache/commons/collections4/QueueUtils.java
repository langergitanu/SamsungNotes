package org.apache.commons.collections4;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.SynchronizedQueue;
import org.apache.commons.collections4.queue.TransformedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QueueUtils {
    public static final Queue EMPTY_QUEUE = UnmodifiableQueue.unmodifiableQueue(new LinkedList());

    private QueueUtils() {
    }

    public static <E> Queue<E> emptyQueue() {
        return EMPTY_QUEUE;
    }

    public static <E> Queue<E> predicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        return PredicatedQueue.predicatedQueue(queue, predicate);
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> queue) {
        return SynchronizedQueue.synchronizedQueue(queue);
    }

    public static <E> Queue<E> transformingQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        return TransformedQueue.transformingQueue(queue, transformer);
    }

    public static <E> Queue<E> unmodifiableQueue(Queue<? extends E> queue) {
        return UnmodifiableQueue.unmodifiableQueue(queue);
    }
}
