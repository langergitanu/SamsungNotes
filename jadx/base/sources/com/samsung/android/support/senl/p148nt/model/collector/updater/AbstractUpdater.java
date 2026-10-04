package com.samsung.android.support.senl.p148nt.model.collector.updater;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AbstractUpdater {
    private static final int BLOCKING_QUEUE_CAPACITY = 50;
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_TIME_MS = 5000;
    private static final int MAX_POOL_SIZE = 2;
    protected final ThreadPoolExecutor mThreadPoolExecutor;

    public AbstractUpdater(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 5000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(50));
        this.mThreadPoolExecutor = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory(str));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
    }
}
