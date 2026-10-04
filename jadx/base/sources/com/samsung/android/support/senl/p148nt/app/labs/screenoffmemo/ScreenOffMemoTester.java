package com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.task.Task;
import com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.task.TaskFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ScreenOffMemoTester {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_TIME = 1000;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "ScreenOffMemoTester";
    private static ScreenOffMemoTester sInstance;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public ScreenOffMemoTester() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mThreadPoolExecutor = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory(TAG));
    }

    public static synchronized ScreenOffMemoTester getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new ScreenOffMemoTester();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public void execute(String str) {
        Task taskCreateTask = new TaskFactory().createTask(str);
        if (taskCreateTask == null) {
            return;
        }
        this.mThreadPoolExecutor.execute(taskCreateTask);
    }
}
