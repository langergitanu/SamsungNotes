package io.netty.util.internal.shaded.org.jctools.queues;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class IndexedQueueSizeUtil {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IndexedQueue {
        int capacity();

        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        return indexedQueue.lvConsumerIndex() >= indexedQueue.lvProducerIndex();
    }

    public static int size(IndexedQueue indexedQueue) {
        long jLvProducerIndex;
        long jLvConsumerIndex;
        long jLvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            jLvProducerIndex = indexedQueue.lvProducerIndex();
            jLvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (jLvConsumerIndex2 == jLvConsumerIndex) {
                break;
            }
            jLvConsumerIndex2 = jLvConsumerIndex;
        }
        long j = jLvProducerIndex - jLvConsumerIndex;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < 0) {
            return 0;
        }
        return (indexedQueue.capacity() == -1 || j <= ((long) indexedQueue.capacity())) ? (int) j : indexedQueue.capacity();
    }
}
