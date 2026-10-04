package com.samsung.android.support.senl.p148nt.model.contextawareness.worker;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task.TaskFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessWorker {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_TIME = 1000;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = CALogger.createTag("ContextAwarenessWorker");
    private static ContextAwarenessWorker sInstance;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    private ContextAwarenessWorker() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mThreadPoolExecutor = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory(TAG));
    }

    public static synchronized ContextAwarenessWorker getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new ContextAwarenessWorker();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public void runContextAwareness(@NonNull ContextAwarenessParam contextAwarenessParam) {
        DataLogger.m12302d(TAG, "runContextAwareness activeCount " + this.mThreadPoolExecutor.getActiveCount());
        this.mThreadPoolExecutor.execute(new TaskFactory().createTask(contextAwarenessParam));
    }
}
