package com.samsung.android.support.senl.p148nt.model.executor.scheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SchedulerDataSource {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnWorkingStateListener {
        void onState(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum WorkingState {
        IDLE,
        LOADING,
        SAVING,
        CLOSING,
        SAVING_CACHE,
        SNAP_SAVE,
        LOADING_CACHE,
        DISCARD_CACHE,
        RELOADING,
        UNDEFINED
    }

    boolean awaitTerminationAll(long j, TimeUnit timeUnit);

    void clearQueue(@NonNull String str);

    void close();

    boolean existExecutorService(@NonNull String str);

    WorkingState getCurrentState();

    @NonNull
    NotesDocumentThreadPool getExecutorService(@NonNull String str);

    @NonNull
    BlockingQueue<Runnable> getQueue(@NonNull String str);

    boolean isIdle();

    NotesDocumentThreadPool replaceExecutorService(String str);

    void setOnWorkingStateListener(@Nullable OnWorkingStateListener onWorkingStateListener);

    void shutdownExecutorService(@NonNull String str);
}
