package com.samsung.android.mcf.continuity.common;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ExecutorUtil {
    private static final int NUM_CALLBACK_THREAD = 1;
    private static final int NUM_IO_THREAD = 64;
    private static final int NUM_MAIN_THREAD = 1;
    private static final String TAG = "ExecutorUtil";

    @Nullable
    private static ThreadPoolExecutor sExecutorCallback;

    @Nullable
    private static ThreadPoolExecutor sExecutorIO;

    @NonNull
    private static final ThreadPoolExecutor sExecutorMain = getThreadPoolExecutor("ExecutorMain: ", 1, false);
    private static boolean sIsStarted = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ThrowExceptionRunnable implements Runnable {

        @NonNull
        private final Runnable mTask;

        @Override // java.lang.Runnable
        @SuppressLint({"GenericThrowableCatch"})
        public void run() {
            try {
                this.mTask.run();
            } catch (Throwable th) {
                DLog.m5611w(ExecutorUtil.TAG, ExecutorUtil.TAG, "Error in running " + this.mTask.toString() + " on " + Thread.currentThread().getName() + SQLKeyword.COMMA + th.getMessage());
                th.printStackTrace();
            }
        }

        private ThrowExceptionRunnable(@NonNull Runnable runnable) {
            this.mTask = runnable;
        }
    }

    private static boolean execute(@NonNull ThreadPoolExecutor threadPoolExecutor, @NonNull Runnable runnable) {
        try {
            threadPoolExecutor.execute(new ThrowExceptionRunnable(runnable));
            return true;
        } catch (RejectedExecutionException e) {
            DLog.m5611w(TAG, "execute", e.getMessage());
            return false;
        }
    }

    public static boolean executeOnCallback(@NonNull Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (sIsStarted && (threadPoolExecutor = sExecutorCallback) != null) {
            return execute(threadPoolExecutor, runnable);
        }
        StringBuilder sb = new StringBuilder("fail to execute : ");
        sb.append(sIsStarted);
        sb.append(SQLKeyword.COMMA);
        sb.append(sExecutorCallback != null);
        DLog.m5611w(TAG, "executeOnCallback", sb.toString());
        return false;
    }

    public static boolean executeOnIO(@NonNull Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (sIsStarted && (threadPoolExecutor = sExecutorIO) != null) {
            return execute(threadPoolExecutor, runnable);
        }
        StringBuilder sb = new StringBuilder("fail to execute : ");
        sb.append(sIsStarted);
        sb.append(SQLKeyword.COMMA);
        sb.append(sExecutorIO != null);
        DLog.m5611w(TAG, "executeOnIO", sb.toString());
        return false;
    }

    public static boolean executeOnMain(@NonNull Runnable runnable) {
        return execute(sExecutorMain, runnable);
    }

    @NonNull
    private static ThreadPoolExecutor getThreadPoolExecutor(@NonNull final String str, int i, boolean z) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: a2.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ExecutorUtil.lambda$getThreadPoolExecutor$0(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(z);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$getThreadPoolExecutor$0(String str, Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(4);
        thread.setDaemon(true);
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(thread.getId());
        thread.setName(sbM1324q.toString());
        return thread;
    }

    public static void shutdown() {
        DLog.m5610i(TAG, "shutdown", "sIsStarted = " + sIsStarted);
        if (sIsStarted) {
            ThreadPoolExecutor threadPoolExecutor = sExecutorCallback;
            if (threadPoolExecutor != null) {
                shutdownNow(threadPoolExecutor);
            }
            ThreadPoolExecutor threadPoolExecutor2 = sExecutorIO;
            if (threadPoolExecutor2 != null) {
                shutdownNow(threadPoolExecutor2);
            }
            sIsStarted = false;
        }
    }

    private static void shutdownNow(@NonNull ThreadPoolExecutor threadPoolExecutor) {
        List<Runnable> listShutdownNow = threadPoolExecutor.shutdownNow();
        if (listShutdownNow != null) {
            Iterator<Runnable> it = listShutdownNow.iterator();
            while (it.hasNext()) {
                DLog.m5607d(TAG, "shutdown", "shutdown, but not executed" + it.next());
            }
        }
    }

    public static void start() {
        DLog.m5610i(TAG, "start", "sIsStarted = " + sIsStarted);
        if (sIsStarted) {
            return;
        }
        sExecutorCallback = getThreadPoolExecutor("ExecutorCallback: ", 1, true);
        sExecutorIO = getThreadPoolExecutor("ExecutorIO: ", 64, true);
        sIsStarted = true;
    }
}
