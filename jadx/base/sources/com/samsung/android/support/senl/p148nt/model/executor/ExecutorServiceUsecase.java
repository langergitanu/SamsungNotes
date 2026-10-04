package com.samsung.android.support.senl.p148nt.model.executor;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ExecutorServiceUsecase {
    boolean awaitTermination(long j, TimeUnit timeUnit);

    SchedulerDataSource.WorkingState getState();

    void init();

    boolean isIdle();

    void quit(boolean z);

    void setOnWorkingStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener);

    void setTaskProgressListener(@Nullable NotesDocumentInteractor.DocumentInteractorListener documentInteractorListener);
}
