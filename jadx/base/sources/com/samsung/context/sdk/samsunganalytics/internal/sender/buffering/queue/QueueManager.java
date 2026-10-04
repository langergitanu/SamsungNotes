package com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.queue;

import com.samsung.context.sdk.samsunganalytics.internal.sender.SimpleLog;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class QueueManager {
    private static final int DEFAULT_QUEUE_SIZE = 25;
    protected LinkedBlockingQueue<SimpleLog> logQueue = new LinkedBlockingQueue<>(25);

    public Queue<SimpleLog> getAll() {
        return this.logQueue;
    }

    public long getDataSize() {
        return this.logQueue.size();
    }

    public void insert(SimpleLog simpleLog) {
        if (this.logQueue.offer(simpleLog)) {
            return;
        }
        Debug.LogD("QueueManager", "queue size over. remove oldest log");
        this.logQueue.poll();
        this.logQueue.offer(simpleLog);
    }

    public boolean isEmpty() {
        return this.logQueue.isEmpty();
    }
}
