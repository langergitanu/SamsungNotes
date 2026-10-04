package com.samsung.android.support.senl.p148nt.model.collector.common;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.manager.task.PdfCollectTask;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectThreadPoolExecutor extends ThreadPoolExecutor implements AutoCloseable {
    private static final int KEEP_ALIVE_TIME_MS = 5000;
    private static final String TAG = CollectLogger.createTag("CollectThreadPoolExecutor");
    private final BlockingQueue<Runnable> mActiveTasks;
    private final BlockingQueue<Runnable> mPausedTasks;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CollectTask extends Runnable {
        void cancel();

        String getUuid();
    }

    public CollectThreadPoolExecutor(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, 5000L, TimeUnit.MILLISECONDS, blockingQueue, new SenlThreadFactory(TAG));
        this.mActiveTasks = new LinkedBlockingQueue();
        this.mPausedTasks = new LinkedBlockingQueue();
        setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
    }

    private void cancelTaskFromActiveTasks(@NonNull String str, @NonNull StringBuilder sb) {
        Iterator<Runnable> it = getActiveTasks().iterator();
        while (it.hasNext()) {
            CollectTask collectTask = (CollectTask) it.next();
            if (collectTask != null && str.equals(collectTask.getUuid())) {
                collectTask.cancel();
                sb.append(str);
                sb.append(" from activeTasks, ");
                return;
            }
        }
    }

    private void removeTaskFromQueue(@NonNull String str, @NonNull StringBuilder sb) {
        Iterator<Runnable> it = getQueue().iterator();
        while (it.hasNext()) {
            CollectTask collectTask = (CollectTask) it.next();
            if (collectTask != null && str.equals(collectTask.getUuid())) {
                getQueue().remove(collectTask);
                sb.append(str);
                sb.append(" from queue, ");
                return;
            }
        }
    }

    public void addPausedTask(Runnable runnable) {
        CollectTask containsPausedTasks = getContainsPausedTasks(((PdfCollectTask) runnable).getUuid());
        if (containsPausedTasks != null) {
            DataLogger.m12302d(TAG, "addPausedTask exist");
            this.mPausedTasks.remove(containsPausedTasks);
        }
        this.mPausedTasks.add(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        DataLogger.m12302d(TAG, "afterExecute r " + runnable.hashCode());
        this.mActiveTasks.remove(runnable);
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        DataLogger.m12302d(TAG, "beforeExecute r " + runnable.hashCode());
        this.mActiveTasks.add(runnable);
        super.beforeExecute(thread, runnable);
    }

    public void cancelAndRemoveTask(@NonNull String str, @NonNull StringBuilder sb) {
        cancelTaskFromActiveTasks(str, sb);
        removeTaskFromQueue(str, sb);
    }

    public void clearPausedTasks() {
        DataLogger.m12302d(TAG, "clearPausedTasks");
        this.mPausedTasks.clear();
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public BlockingQueue<Runnable> getActiveTasks() {
        return this.mActiveTasks;
    }

    public CollectTask getContainsPausedTasks(String str) {
        Iterator<Runnable> it = this.mPausedTasks.iterator();
        while (it.hasNext()) {
            CollectTask collectTask = (CollectTask) it.next();
            if (collectTask != null && collectTask.getUuid().equals(str)) {
                return collectTask;
            }
        }
        return null;
    }

    public BlockingQueue<Runnable> getPausedTasks() {
        return this.mPausedTasks;
    }
}
