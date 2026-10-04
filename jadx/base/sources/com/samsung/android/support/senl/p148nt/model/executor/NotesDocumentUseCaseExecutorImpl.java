package com.samsung.android.support.senl.p148nt.model.executor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NotesDocumentUseCaseExecutorImpl implements DocumentUseCaseExecutor {
    private static final String TAG = ModelLogger.createTag("NotesDocumentUseCaseExecutorImpl");
    private final NotesDocumentInteractor mNotesDocumentInteractor;
    private final SchedulerDataSource mSchedulerDataSource;

    public NotesDocumentUseCaseExecutorImpl(@NonNull Context context, @NonNull SchedulerDataSource schedulerDataSource) {
        this.mSchedulerDataSource = schedulerDataSource;
        this.mNotesDocumentInteractor = new NotesDocumentInteractor(context, schedulerDataSource, new Handler(Looper.getMainLooper()));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        DataLogger.m12307i(TAG, "awaitTermination, timeout : " + j + ", unit : " + timeUnit);
        return this.mNotesDocumentInteractor.awaitTerminationAll(j, timeUnit);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void close(@NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "close, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.close(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void discardCache(@NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "discardCache, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.discardCache(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public SchedulerDataSource.WorkingState getState() {
        SchedulerDataSource.WorkingState currentState;
        synchronized (this.mSchedulerDataSource) {
            currentState = this.mSchedulerDataSource.getCurrentState();
        }
        return currentState;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public void init() {
        this.mNotesDocumentInteractor.init();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public boolean isIdle() {
        return this.mNotesDocumentInteractor.isIdle();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void open(@NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "open, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.open(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void openCache(@NonNull DocumentRepository documentRepository, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "openCache, documentRepository : " + documentRepository + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.openCache(documentRepository.getDocumentSubscriptionId(), documentRepository, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public void quit(boolean z) {
        AbstractC11014a.m12335t("quit#, close: ", TAG, z);
        this.mNotesDocumentInteractor.quit(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void release(@NonNull DocumentSubscriptionId documentSubscriptionId, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "release, user : " + documentSubscriptionId + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.release(documentSubscriptionId, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void reload(@NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "reload, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.reload(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void save(@NonNull DocumentDataSource documentDataSource, boolean z, boolean z2, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "save, uuid : " + documentDataSource.getUuid() + ", immediately : " + z + ", doNotShowSavedToast : " + z2 + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.save(documentDataSource.getSubscriptionId(), documentDataSource, z, z2, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void saveCache(@NonNull DocumentDataSource documentDataSource, boolean z, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "saveCache, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.saveCache(documentDataSource.getSubscriptionId(), documentDataSource, z, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public void setOnWorkingStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener) {
        synchronized (this.mSchedulerDataSource) {
            this.mSchedulerDataSource.setOnWorkingStateListener(onWorkingStateListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.ExecutorServiceUsecase
    public void setTaskProgressListener(@Nullable NotesDocumentInteractor.DocumentInteractorListener documentInteractorListener) {
        this.mNotesDocumentInteractor.setDocumentInteractorListener(documentInteractorListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor
    public void snapSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "snapSave, uuid : " + documentDataSource.getUuid() + ", listener : " + documentCompletionListener);
        this.mNotesDocumentInteractor.snapSave(documentDataSource.getSubscriptionId(), documentDataSource, z, documentCompletionListener);
    }
}
