package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.ForegroundUpdater;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RemoteWorkManagerInfo {
    private static volatile RemoteWorkManagerInfo sInstance;
    private static final Object sLock = new Object();
    private final Configuration mConfiguration;
    private final ForegroundUpdater mForegroundUpdater;
    private final ProgressUpdater mProgressUpdater;
    private final TaskExecutor mTaskExecutor;

    /* JADX WARN: Multi-variable type inference failed */
    private RemoteWorkManagerInfo(@NonNull Context context) {
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance();
        if (workManagerImpl != null) {
            this.mConfiguration = workManagerImpl.getConfiguration();
            this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Configuration.Provider) {
                this.mConfiguration = ((Configuration.Provider) applicationContext).getWorkManagerConfiguration();
            } else {
                this.mConfiguration = new Configuration.Builder().setDefaultProcessName(applicationContext.getPackageName()).build();
            }
            this.mTaskExecutor = new WorkManagerTaskExecutor(this.mConfiguration.getTaskExecutor());
        }
        this.mProgressUpdater = new RemoteProgressUpdater();
        this.mForegroundUpdater = new RemoteForegroundUpdater();
    }

    @VisibleForTesting
    public static void clearInstance() {
        synchronized (sLock) {
            sInstance = null;
        }
    }

    @NonNull
    public static RemoteWorkManagerInfo getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new RemoteWorkManagerInfo(context);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    @NonNull
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @NonNull
    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }

    @NonNull
    public ProgressUpdater getProgressUpdater() {
        return this.mProgressUpdater;
    }

    @NonNull
    public TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }
}
