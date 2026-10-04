package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadPoolManager {
    private static final int KEEP_ALIVE_TIME = 10;
    private static final String TAG = "ThreadPoolManager";
    private static int THREAD_COUNTER = 1;
    private int corePoolSize;
    private final ExecutorService mExecutorService;
    private final BlockingQueue<Runnable> mTaskQueue;
    private static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static ThreadPoolManager mInstance = new ThreadPoolManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BackgroundThreadFactory implements ThreadFactory {
        public /* synthetic */ BackgroundThreadFactory(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$newThread$0(Thread thread, Throwable th) {
            Logger.m11000e(ThreadPoolManager.TAG, thread.getName() + " encountered an error: " + th.getMessage());
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Logger.m10999d(ThreadPoolManager.TAG, "BackgroundThreadFactory #" + ThreadPoolManager.THREAD_COUNTER);
            thread.setName("BackgroundThreadFactory #" + ThreadPoolManager.THREAD_COUNTER);
            thread.setPriority(10);
            ThreadPoolManager.THREAD_COUNTER = ThreadPoolManager.THREAD_COUNTER + 1;
            thread.setUncaughtExceptionHandler(new C9481f());
            return thread;
        }

        private BackgroundThreadFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CallBack {
        void completed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MediaProviderSyncCallback extends CallBack {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SearchCallback extends CallBack {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SecTrashUpdateCallback extends CallBack {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SmartSwitchRestoreCallback extends CallBack {
    }

    private ThreadPoolManager() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.mTaskQueue = linkedBlockingQueue;
        StringBuilder sb = new StringBuilder("Core pool size: ");
        int i = MAX_POOL_SIZE;
        int i2 = i / 2;
        sb.append(i2);
        Logger.m11000e(TAG, sb.toString());
        if (i == 1) {
            this.corePoolSize = i;
        } else {
            this.corePoolSize = i2;
        }
        this.mExecutorService = new ThreadPoolExecutor(this.corePoolSize, i, 10L, KEEP_ALIVE_TIME_UNIT, linkedBlockingQueue, new BackgroundThreadFactory(0));
    }

    public static ThreadPoolManager getsInstance() {
        return mInstance;
    }

    public void addCallable(Callable<?> callable) {
        Logger.m10999d(TAG, "add Callable");
        this.mExecutorService.submit(callable);
    }

    public void execute(Runnable runnable) {
        this.mExecutorService.execute(runnable);
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public void invokeToExecutor(CallBack callBack, List<Callable<Object>> list) {
        try {
            if (this.mExecutorService.invokeAll(list).size() == list.size()) {
                callBack.completed();
            }
        } catch (InterruptedException e) {
            Logger.m11000e(TAG, "InterruptedException: " + e.toString());
        }
    }
}
