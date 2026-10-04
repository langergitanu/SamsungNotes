package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesDocumentHandler extends Handler {
    private static final String TAG = ModelLogger.createTag("NotesDocumentHandler");
    protected final Context mContext;
    private SchedulerDataSource.OnWorkingStateListener mDocumentHandlerStateListener;
    private final NotesDocumentServiceIntentHandler mDocumentIntentHandler;
    private final DocumentUseCaseExecutor mDocumentUsecaseExecutor;
    private SchedulerDataSource.OnWorkingStateListener mOnWorkingStateListener;
    private SchedulerDataSource.WorkingState mState;

    private NotesDocumentHandler(@NonNull Context context, @NonNull DocumentUseCaseExecutor documentUseCaseExecutor, @NonNull NotesDocumentServiceIntentHandler notesDocumentServiceIntentHandler) {
        super(Looper.getMainLooper());
        this.mState = SchedulerDataSource.WorkingState.IDLE;
        this.mContext = context;
        this.mDocumentUsecaseExecutor = documentUseCaseExecutor;
        this.mDocumentIntentHandler = notesDocumentServiceIntentHandler;
    }

    private String getListenerLog(DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        StringBuilder sb = new StringBuilder(", listener: ");
        sb.append(documentCompletionListener == null ? "" : Integer.valueOf(documentCompletionListener.hashCode()));
        return sb.toString();
    }

    private void notifyOnDocumentHandlerStateListener(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        SchedulerDataSource.OnWorkingStateListener onWorkingStateListener = this.mDocumentHandlerStateListener;
        if (onWorkingStateListener != null) {
            onWorkingStateListener.onState(null, str, workingState, documentSubscriptionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnWorkingStateListener(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        SchedulerDataSource.OnWorkingStateListener onWorkingStateListener = this.mOnWorkingStateListener;
        if (onWorkingStateListener != null) {
            onWorkingStateListener.onState(threadPoolExecutor, str, workingState, documentSubscriptionId);
        }
    }

    @NonNull
    public static NotesDocumentHandler provideNotesDocumentHandler(@NonNull Context context, @NonNull DocumentUseCaseExecutor documentUseCaseExecutor, @NonNull NotesDocumentServiceIntentHandler notesDocumentServiceIntentHandler) {
        return new NotesDocumentHandler(context, documentUseCaseExecutor, notesDocumentServiceIntentHandler);
    }

    private void setState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        SchedulerDataSource.WorkingState workingState2 = this.mState;
        DataLogger.m12302d(TAG, "setState, uuid : " + str + ", previousState : " + workingState2 + ", state : " + workingState + ", owner : " + documentSubscriptionId);
        if (workingState == SchedulerDataSource.WorkingState.CLOSING && workingState2 == SchedulerDataSource.WorkingState.SAVING) {
            return;
        }
        this.mState = workingState;
        notifyOnDocumentHandlerStateListener(str, workingState, documentSubscriptionId);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        DataLogger.m12307i(TAG, "awaitTermination, timeout : " + j + ", unit : " + timeUnit);
        setState("All Documents", SchedulerDataSource.WorkingState.CLOSING, DocumentSubscriptionId.DOCUMENT_SERVICE_ID);
        return getDocumentUsecaseExecutor().awaitTermination(j, timeUnit);
    }

    @UiThread
    public void close(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "close, documentDataSource : " + documentDataSource + getListenerLog(documentCompletionListener));
        setState(documentDataSource.getUuid(), SchedulerDataSource.WorkingState.CLOSING, documentSubscriptionId);
        getDocumentUsecaseExecutor().close(documentDataSource, documentCompletionListener);
    }

    @UiThread
    public void discardCache(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "discardCache, documentDataSource : " + documentDataSource + getListenerLog(documentCompletionListener));
        setState(documentDataSource.getUuid(), SchedulerDataSource.WorkingState.CLOSING, documentSubscriptionId);
        getDocumentUsecaseExecutor().discardCache(documentDataSource, documentCompletionListener);
    }

    @NonNull
    public NotesDocumentServiceIntentHandler getDocumentIntentHandler() {
        return this.mDocumentIntentHandler;
    }

    @NonNull
    public DocumentUseCaseExecutor getDocumentUsecaseExecutor() {
        return this.mDocumentUsecaseExecutor;
    }

    public SchedulerDataSource.WorkingState getState() {
        DataLogger.m12302d(TAG, "getState, state : " + this.mState);
        return this.mState;
    }

    public SchedulerDataSource.WorkingState getTaskState() {
        return getDocumentUsecaseExecutor().getState();
    }

    public boolean isIdle() {
        return getDocumentUsecaseExecutor().isIdle();
    }

    @UiThread
    public void open(@NonNull DocumentSubscriptionId documentSubscriptionId, DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        setState(documentDataSource.getUuid(), SchedulerDataSource.WorkingState.LOADING, documentSubscriptionId);
        getDocumentUsecaseExecutor().open(documentDataSource, documentCompletionListener);
    }

    @UiThread
    public void openCache(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "openCache, documentRepository : " + documentRepository + getListenerLog(documentCompletionListener));
        setState(documentRepository.getUuid(), SchedulerDataSource.WorkingState.LOADING, documentSubscriptionId);
        getDocumentUsecaseExecutor().openCache(documentRepository, documentCompletionListener);
    }

    public void quit(boolean z) {
        DataLogger.m12307i(TAG, "quit#");
        setState("All Documents", SchedulerDataSource.WorkingState.CLOSING, DocumentSubscriptionId.DOCUMENT_SERVICE_ID);
        getDocumentUsecaseExecutor().quit(z);
    }

    @UiThread
    public void release(@NonNull DocumentSubscriptionId documentSubscriptionId, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "release, user : " + documentSubscriptionId + getListenerLog(documentCompletionListener));
        setState("All Documents", SchedulerDataSource.WorkingState.CLOSING, documentSubscriptionId);
        getDocumentUsecaseExecutor().release(documentSubscriptionId, documentCompletionListener);
    }

    @UiThread
    public void reload(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "reload, documentDataSource : " + documentDataSource + getListenerLog(documentCompletionListener));
        setState(documentDataSource.getUuid(), SchedulerDataSource.WorkingState.RELOADING, documentSubscriptionId);
        getDocumentUsecaseExecutor().reload(documentDataSource, documentCompletionListener);
    }

    @UiThread
    public void save(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, boolean z2, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "save, documentDataSource : " + documentDataSource + ", immediately : " + z + ", doNotShowSavedToast : " + z2 + getListenerLog(documentCompletionListener));
        setState(documentDataSource.getUuid(), SchedulerDataSource.WorkingState.SAVING, documentSubscriptionId);
        getDocumentUsecaseExecutor().save(documentDataSource, z, z2, documentCompletionListener);
    }

    @UiThread
    public void saveCache(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "saveCache, documentDataSource : " + documentDataSource + ", immediately : " + z + getListenerLog(documentCompletionListener));
        getDocumentUsecaseExecutor().saveCache(documentDataSource, z, documentCompletionListener);
    }

    public void setOnDocumentHandlerStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener) {
        this.mDocumentHandlerStateListener = onWorkingStateListener;
    }

    public void setOnWorkingStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener) {
        this.mOnWorkingStateListener = onWorkingStateListener;
        getDocumentUsecaseExecutor().setOnWorkingStateListener(new SchedulerDataSource.OnWorkingStateListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentHandler.1
            @Override // com.samsung.android.support.senl.nt.model.executor.scheduler.SchedulerDataSource.OnWorkingStateListener
            @WorkerThread
            public void onState(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
                DataLogger.m12302d(NotesDocumentHandler.TAG, "onState, uuid : " + str + ", state : " + workingState + ", owner : " + documentSubscriptionId);
                NotesDocumentHandler.this.mState = workingState;
                NotesDocumentHandler.this.notifyOnWorkingStateListener(threadPoolExecutor, str, workingState, documentSubscriptionId);
            }
        });
    }

    public void setTaskProgressListener(@Nullable NotesDocumentInteractor.DocumentInteractorListener documentInteractorListener) {
        getDocumentUsecaseExecutor().setTaskProgressListener(documentInteractorListener);
    }

    @UiThread
    public void snapSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12307i(TAG, "snapSave, documentDataSource : " + documentDataSource + ", immediately : " + z + getListenerLog(documentCompletionListener));
        getDocumentUsecaseExecutor().snapSave(documentDataSource, z, documentCompletionListener);
    }
}
