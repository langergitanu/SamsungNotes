package org.apache.commons.collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SynchronizedPriorityQueue implements PriorityQueue {
    protected final PriorityQueue m_priorityQueue;

    public SynchronizedPriorityQueue(PriorityQueue priorityQueue) {
        this.m_priorityQueue = priorityQueue;
    }

    @Override // org.apache.commons.collections.PriorityQueue, java.util.Collection
    public synchronized void clear() {
        this.m_priorityQueue.clear();
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized void insert(Object obj) {
        this.m_priorityQueue.insert(obj);
    }

    @Override // org.apache.commons.collections.PriorityQueue, java.util.Collection
    public synchronized boolean isEmpty() {
        return this.m_priorityQueue.isEmpty();
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized Object peek() {
        return this.m_priorityQueue.peek();
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized Object pop() {
        return this.m_priorityQueue.pop();
    }

    public synchronized String toString() {
        return this.m_priorityQueue.toString();
    }
}
