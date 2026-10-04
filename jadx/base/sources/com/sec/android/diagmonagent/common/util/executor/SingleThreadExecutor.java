package com.sec.android.diagmonagent.common.util.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SingleThreadExecutor implements Executor {
    private static ExecutorService executorService;
    private static SingleThreadExecutor singleThreadExecutor;

    public SingleThreadExecutor() {
        executorService = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setPriority(1);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public static Executor getInstance() {
        if (singleThreadExecutor == null) {
            singleThreadExecutor = new SingleThreadExecutor();
        }
        return singleThreadExecutor;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.Executor
    public void execute(final AsyncTaskClient asyncTaskClient) {
        executorService.submit(new Runnable() { // from class: com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                asyncTaskClient.run();
                asyncTaskClient.onFinish();
            }
        });
    }
}
