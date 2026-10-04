package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ListenableWorker {

    @NonNull
    private Context mAppContext;
    private volatile int mStopReason = -256;
    private boolean mUsed;

    @NonNull
    private WorkerParameters mWorkerParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Result {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Failure extends Result {
            private final Data mOutputData;

            public Failure() {
                this(Data.EMPTY);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            @Override // androidx.work.ListenableWorker.Result
            @NonNull
            public Data getOutputData() {
                return this.mOutputData;
            }

            public int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            @NonNull
            public String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }

            public Failure(@NonNull Data data) {
                this.mOutputData = data;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            @Override // androidx.work.ListenableWorker.Result
            @NonNull
            public Data getOutputData() {
                return Data.EMPTY;
            }

            public int hashCode() {
                return 25945934;
            }

            @NonNull
            public String toString() {
                return "Retry";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Success extends Result {
            private final Data mOutputData;

            public Success() {
                this(Data.EMPTY);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            @Override // androidx.work.ListenableWorker.Result
            @NonNull
            public Data getOutputData() {
                return this.mOutputData;
            }

            public int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            @NonNull
            public String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }

            public Success(@NonNull Data data) {
                this.mOutputData = data;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Result() {
        }

        @NonNull
        public static Result failure() {
            return new Failure();
        }

        @NonNull
        public static Result retry() {
            return new Retry();
        }

        @NonNull
        public static Result success() {
            return new Success();
        }

        @NonNull
        public abstract Data getOutputData();

        @NonNull
        public static Result failure(@NonNull Data data) {
            return new Failure(data);
        }

        @NonNull
        public static Result success(@NonNull Data data) {
            return new Success(data);
        }
    }

    public ListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.getBackgroundExecutor();
    }

    @NonNull
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        settableFutureCreate.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFutureCreate;
    }

    @NonNull
    public final UUID getId() {
        return this.mWorkerParams.getId();
    }

    @NonNull
    public final Data getInputData() {
        return this.mWorkerParams.getInputData();
    }

    @Nullable
    @RequiresApi(28)
    public final Network getNetwork() {
        return this.mWorkerParams.getNetwork();
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.mWorkerParams.getRunAttemptCount();
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.mStopReason;
    }

    @NonNull
    public final Set<String> getTags() {
        return this.mWorkerParams.getTags();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.getTaskExecutor();
    }

    @NonNull
    @RequiresApi(24)
    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.getTriggeredContentAuthorities();
    }

    @NonNull
    @RequiresApi(24)
    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.getTriggeredContentUris();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.getWorkerFactory();
    }

    public final boolean isStopped() {
        return this.mStopReason != -256;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsed() {
        return this.mUsed;
    }

    @NonNull
    public final ListenableFuture<Void> setForegroundAsync(@NonNull ForegroundInfo foregroundInfo) {
        return this.mWorkerParams.getForegroundUpdater().setForegroundAsync(getApplicationContext(), getId(), foregroundInfo);
    }

    @NonNull
    public ListenableFuture<Void> setProgressAsync(@NonNull Data data) {
        return this.mWorkerParams.getProgressUpdater().updateProgress(getApplicationContext(), getId(), data);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setUsed() {
        this.mUsed = true;
    }

    @NonNull
    @MainThread
    public abstract ListenableFuture<Result> startWork();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void stop(int i) {
        this.mStopReason = i;
        onStopped();
    }

    public void onStopped() {
    }
}
