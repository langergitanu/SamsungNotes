package com.samsung.android.support.senl.p148nt.data.database.core.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultTaskExecutor extends TaskExecutor {

    @Nullable
    private volatile Handler mMainHandler;
    private final Object mLock = new Object();
    private final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new SenlThreadFactory("data_disk_io_"));

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                try {
                    if (this.mMainHandler == null) {
                        this.mMainHandler = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.mMainHandler.postAtFrontOfQueue(runnable);
    }
}
