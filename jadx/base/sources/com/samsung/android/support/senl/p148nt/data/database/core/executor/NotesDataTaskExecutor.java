package com.samsung.android.support.senl.p148nt.data.database.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class NotesDataTaskExecutor extends TaskExecutor {
    private static volatile NotesDataTaskExecutor sInstance;

    @NonNull
    private TaskExecutor mDefaultTaskExecutor;

    @NonNull
    private TaskExecutor mDelegate;

    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: com.samsung.android.support.senl.nt.data.database.core.executor.NotesDataTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            NotesDataTaskExecutor.getInstance().executeOnMainThread(runnable);
        }
    };

    @NonNull
    private static final Executor sIOThreadExecutor = new Executor() { // from class: com.samsung.android.support.senl.nt.data.database.core.executor.NotesDataTaskExecutor.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            NotesDataTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };

    private NotesDataTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    @NonNull
    public static NotesDataTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (NotesDataTaskExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new NotesDataTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public void executeOnMainThread(@NonNull Runnable runnable) {
        super.executeOnMainThread(runnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    public void setDelegate(@Nullable TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor;
    }
}
