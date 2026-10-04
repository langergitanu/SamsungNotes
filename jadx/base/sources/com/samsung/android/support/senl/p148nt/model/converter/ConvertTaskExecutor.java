package com.samsung.android.support.senl.p148nt.model.converter;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTask;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class ConvertTaskExecutor {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_TIME = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = ModelLogger.createConverterTag("ConvertTaskExecutor");
    private final ThreadPoolExecutor mConvertThreadPool;

    public ConvertTaskExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 50L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mConvertThreadPool = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory(TAG));
    }

    public void cancel(int i) {
        Iterator<Runnable> it = this.mConvertThreadPool.getQueue().iterator();
        while (it.hasNext()) {
            if (((ConvertTask) it.next()).getInfo().getCallerId() == i) {
                it.remove();
            }
        }
    }

    public void cancelAll() {
        this.mConvertThreadPool.getQueue().clear();
    }

    public void runConvert(Runnable runnable) {
        this.mConvertThreadPool.execute(runnable);
    }

    public void shutdownAndAwaitTermination() {
        String str = TAG;
        DataLogger.m12302d(str, "shutdownAndAwaitTermination, disable new tasks from being submitted.");
        this.mConvertThreadPool.shutdown();
        try {
            DataLogger.m12302d(str, "shutdownAndAwaitTermination, wait a while for existing tasks to terminate.");
            ThreadPoolExecutor threadPoolExecutor = this.mConvertThreadPool;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!threadPoolExecutor.awaitTermination(1L, timeUnit)) {
                DataLogger.m12302d(str, "shutdownAndAwaitTermination, cancel currently executing tasks.");
                this.mConvertThreadPool.shutdownNow();
                DataLogger.m12302d(str, "shutdownAndAwaitTermination, wait a while for tasks to respond to being cancelled.");
                if (!this.mConvertThreadPool.awaitTermination(1L, timeUnit)) {
                    DataLogger.m12302d(str, "shutdownAndAwaitTermination, pool did not terminate.");
                }
            }
        } catch (InterruptedException unused) {
            DataLogger.m12302d(TAG, "shutdownAndAwaitTermination, cancel if current thread also interrupted");
            this.mConvertThreadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        DataLogger.m12302d(TAG, "shutdownAndAwaitTermination, done.");
    }
}
