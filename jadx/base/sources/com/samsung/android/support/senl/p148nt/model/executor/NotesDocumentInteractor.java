package com.samsung.android.support.senl.p148nt.model.executor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.constants.ModelConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.NotesDocumentThreadPool;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.BaseSaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.CloseDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DiscardCacheDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.LoadCacheDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.LoadDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.ReloadDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.SaveCacheDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.SaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.SnapSaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.repository.cache.DocumentCacheRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.scheduler.DocumentSchedulerRepository;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NotesDocumentInteractor {
    private static final String TAG = ModelLogger.createTag("NotesDocumentInteractor");
    private final Context mContext;
    private DocumentInteractorListener mDocumentInteractorListener;
    private final DocumentUserManager mDocumentUserManager;
    private final Handler mHandler;
    private boolean mIsClosing;
    private final Map<String, Object> mLocks = new ConcurrentHashMap();
    private final Map<String, SpenSDocDataSource> mSDocMap = new ConcurrentHashMap();
    private final SchedulerDataSource mSchedulerDataSource;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BaseSaveTaskCallback implements BaseSaveDocumentTask.SaveTaskCallback {
        private final boolean mIsSyncTask;
        private final String mLockId;
        private final AtomicBoolean mLocker;
        private final String mTaskTag;

        public BaseSaveTaskCallback(String str, boolean z, String str2, AtomicBoolean atomicBoolean) {
            this.mTaskTag = str;
            this.mIsSyncTask = z;
            this.mLockId = str2;
            this.mLocker = atomicBoolean;
        }

        public String getTag() {
            return this.mTaskTag;
        }

        @Override // com.samsung.android.support.senl.nt.model.executor.task.BaseSaveDocumentTask.SaveTaskCallback
        public void onEnd(@NonNull String str) {
            String str2 = NotesDocumentInteractor.TAG;
            StringBuilder sb = new StringBuilder();
            AbstractC2821a.m2207B(sb, this.mTaskTag, "$onEnd, uuid : ", str, ", isSyncTask : ");
            sb.append(this.mIsSyncTask);
            DataLogger.m12302d(str2, sb.toString());
            if (this.mIsSyncTask) {
                Object obj = NotesDocumentInteractor.this.mLocks.get(this.mLockId);
                Objects.requireNonNull(obj);
                synchronized (obj) {
                    Object obj2 = NotesDocumentInteractor.this.mLocks.get(this.mLockId);
                    Objects.requireNonNull(obj2);
                    obj2.notify();
                    this.mLocker.set(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CompletionCallback<T extends ISpenDocument> implements DocumentCompletionListener<T> {
        private final DocumentCompletionListener<T> mCallback;
        private final Runnable mFailPostRunnable;
        private boolean mNeedToCountUpReference;
        private final Runnable mSuccessPostRunnable;
        private final DocumentSubscriptionId mUser;

        public CompletionCallback(@Nullable NotesDocumentInteractor notesDocumentInteractor, DocumentCompletionListener<T> documentCompletionListener, DocumentSubscriptionId documentSubscriptionId) {
            this(documentCompletionListener, null, null, documentSubscriptionId);
        }

        private void countUpDocReference(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId) {
            DataLogger.m12309w(NotesDocumentInteractor.TAG, "countUpDocReference, uuid : " + str + ", user : " + documentSubscriptionId);
            synchronized (NotesDocumentInteractor.this.mDocumentUserManager) {
                try {
                    if (NotesDocumentInteractor.this.mDocumentUserManager.isSkipped(documentSubscriptionId)) {
                        DataLogger.m12309w(NotesDocumentInteractor.TAG, "countUpDocReference skipped, uuid : " + str + ", user : " + documentSubscriptionId);
                    } else {
                        NotesDocumentInteractor.this.mDocumentUserManager.use(str, documentSubscriptionId);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void fail(@Nullable Throwable th, String str, @Nullable DocumentCompletionListener<T> documentCompletionListener, @Nullable Runnable runnable) {
            if (th == null || !ModelConstants.ERROR_MSG_DOCUMENT_CACHE_NOT_EXIST.equals(th.getMessage())) {
                String str2 = NotesDocumentInteractor.TAG;
                StringBuilder sb = new StringBuilder("fail, uuid : ");
                sb.append(str);
                sb.append(", exc : ");
                sb.append(th);
                sb.append(", callback : ");
                sb.append(documentCompletionListener == null ? null : Integer.valueOf(documentCompletionListener.hashCode()));
                DataLogger.m12303e(str2, sb.toString());
            }
            if (NotesDocumentInteractor.this.getSpenSDocDataSource(str) == null) {
                NotesDocumentInteractor.this.removeSchedulerDataSource(str);
            }
            RunnableC11457b runnableC11457b = new RunnableC11457b(this, documentCompletionListener, th, str, runnable, 1);
            if (DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID.equals(this.mUser)) {
                runnableC11457b.run();
            } else {
                NotesDocumentInteractor.this.mHandler.postAtFrontOfQueue(runnableC11457b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fail$1(DocumentCompletionListener documentCompletionListener, Throwable th, String str, Runnable runnable) {
            if (documentCompletionListener != null) {
                documentCompletionListener.failed(th, str);
            }
            if (runnable != null) {
                runnable.run();
            }
            NotesDocumentInteractor.this.printInformations();
            NotesDocumentInteractor.this.notifyTaskEndedListener();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$success$0(DocumentCompletionListener documentCompletionListener, DocumentDataSource documentDataSource, String str, Runnable runnable) {
            if (documentCompletionListener != null) {
                documentCompletionListener.completed(documentDataSource, str);
            }
            if (runnable != null) {
                runnable.run();
            }
            NotesDocumentInteractor.this.printInformations();
            NotesDocumentInteractor.this.notifyTaskEndedListener();
        }

        private void success(DocumentDataSource<T, ? extends DocumentEntityContainer> documentDataSource, String str, @Nullable DocumentCompletionListener<T> documentCompletionListener, @Nullable Runnable runnable) {
            String str2 = NotesDocumentInteractor.TAG;
            StringBuilder sb = new StringBuilder("success, uuid : ");
            sb.append(str);
            sb.append(", result : ");
            sb.append(documentDataSource);
            sb.append(", callback : ");
            sb.append(documentCompletionListener == null ? null : Integer.valueOf(documentCompletionListener.hashCode()));
            DataLogger.m12307i(str2, sb.toString());
            RunnableC11457b runnableC11457b = new RunnableC11457b(this, documentCompletionListener, documentDataSource, str, runnable, 0);
            if (DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID.equals(this.mUser)) {
                runnableC11457b.run();
            } else {
                NotesDocumentInteractor.this.mHandler.postAtFrontOfQueue(runnableC11457b);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        @WorkerThread
        public void completed(@NonNull DocumentDataSource<T, ? extends DocumentEntityContainer> documentDataSource, @NonNull String str) {
            if (this.mNeedToCountUpReference) {
                countUpDocReference(str, documentDataSource.getSubscriptionId());
            }
            NotesDocumentInteractor.this.injectSchedulerDataSource(str, documentDataSource);
            success(documentDataSource, str, getCallback(), getSuccessPost());
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        @WorkerThread
        public void failed(@Nullable Throwable th, @NonNull String str) {
            fail(th, str, getCallback(), getFailPost());
        }

        public DocumentCompletionListener<T> getCallback() {
            return this.mCallback;
        }

        public Runnable getFailPost() {
            return this.mFailPostRunnable;
        }

        public Runnable getSuccessPost() {
            return this.mSuccessPostRunnable;
        }

        public CompletionCallback<T> needToCountUpDocReference(boolean z) {
            this.mNeedToCountUpReference = z;
            return this;
        }

        public CompletionCallback(@Nullable NotesDocumentInteractor notesDocumentInteractor, @Nullable DocumentCompletionListener<T> documentCompletionListener, Runnable runnable, DocumentSubscriptionId documentSubscriptionId) {
            this(documentCompletionListener, runnable, null, documentSubscriptionId);
        }

        public CompletionCallback(@Nullable DocumentCompletionListener<T> documentCompletionListener, @Nullable Runnable runnable, @Nullable Runnable runnable2, DocumentSubscriptionId documentSubscriptionId) {
            this.mCallback = documentCompletionListener;
            this.mSuccessPostRunnable = runnable;
            this.mFailPostRunnable = runnable2;
            this.mUser = documentSubscriptionId;
            needToCountUpDocReference(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentInteractorListener {
        void onEnd();

        void onSaved(@Nullable DocumentSubscriptionId documentSubscriptionId, boolean z);

        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaveTaskSubmitListener implements TaskSubmitListener {
        private final BaseSaveTaskCallback mSaveTaskCallback;

        public SaveTaskSubmitListener(@NonNull BaseSaveTaskCallback baseSaveTaskCallback) {
            this.mSaveTaskCallback = baseSaveTaskCallback;
        }

        @Override // com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.TaskSubmitListener
        public void onFailed(DocumentTask documentTask) {
            DocumentCompletionListener documentCompletionListenerCallback = documentTask.callback();
            String str = NotesDocumentInteractor.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mSaveTaskCallback.getTag());
            sb.append("$enqueue, already closed, listener exists : ");
            AbstractC11014a.m12340y(sb, documentCompletionListenerCallback != null, str);
            this.mSaveTaskCallback.onEnd(documentTask.getUuid());
            if (documentCompletionListenerCallback != null) {
                documentCompletionListenerCallback.failed(new DocumentServiceConstants.DocumentServiceAlreadyClosedException("Document service is already closed"), documentTask.getUuid());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TaskSubmitListener {
        void onFailed(DocumentTask documentTask);
    }

    public NotesDocumentInteractor(@NonNull Context context, @NonNull SchedulerDataSource schedulerDataSource, @Nullable Handler handler) {
        this.mContext = context;
        this.mSchedulerDataSource = schedulerDataSource;
        this.mHandler = handler == null ? new Handler(Looper.getMainLooper()) : handler;
        this.mDocumentUserManager = new DocumentUserManager();
    }

    private void forceClose() {
        String str = TAG;
        DataLogger.m12302d(str, "forceClose, start");
        synchronized (this.mSDocMap) {
            try {
                if (this.mSDocMap.isEmpty()) {
                    DataLogger.m12302d(str, "forceClose, remains are not exist.");
                    return;
                }
                for (SpenSDocDataSource spenSDocDataSource : this.mSDocMap.values()) {
                    DataLogger.m12302d(TAG, "forceClose, remained document : " + spenSDocDataSource);
                    close(spenSDocDataSource.getDocument().getSubscriptionId(), spenSDocDataSource.getDocument(), null);
                }
                DataLogger.m12302d(TAG, "forceClose, end");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void injectSchedulerDataSource(@NonNull String str, @NonNull DocumentDataSource documentDataSource) {
        AbstractC0000a.m2C("injectSchedulerDataSource, uuid : ", str, TAG);
        synchronized (this.mSchedulerDataSource) {
            try {
                if (this.mSchedulerDataSource.existExecutorService(str)) {
                    documentDataSource.setScheduler(DocumentSchedulerRepository.create(this.mSchedulerDataSource.getExecutorService(str)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enqueue$0(DocumentTask documentTask) {
        DocumentCompletionListener documentCompletionListenerCallback = documentTask.callback();
        AbstractC11014a.m12340y(new StringBuilder("enqueue, already closed, listener exists : "), documentCompletionListenerCallback != null, TAG);
        if (documentCompletionListenerCallback != null) {
            documentCompletionListenerCallback.failed(new DocumentServiceConstants.DocumentServiceAlreadyClosedException("Document service is already closed"), documentTask.getUuid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printInformations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void putSpenSDocDataSource(@NonNull String str, @NonNull SpenSDocDataSource spenSDocDataSource) {
        DataLogger.m12307i(TAG, "putSpenSDocDataSource, uuid : " + str + ", sdoc : " + spenSDocDataSource);
        synchronized (this.mSDocMap) {
            this.mSDocMap.put(str, spenSDocDataSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void removeSchedulerDataSource(@NonNull String str) {
        AbstractC0000a.m2C("removeSchedulerDataSource, uuid : ", str, TAG);
        synchronized (this.mSchedulerDataSource) {
            try {
                if (this.mSchedulerDataSource.getExecutorService(str).getQueue().isEmpty()) {
                    this.mSchedulerDataSource.shutdownExecutorService(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void removeSpenSDocDataSource(@NonNull String str) {
        AbstractC0000a.m2C("removeSpenSDocDataSource, uuid : ", str, TAG);
        synchronized (this.mSDocMap) {
            try {
                SpenSDocDataSource spenSDocDataSourceRemove = this.mSDocMap.remove(str);
                if (spenSDocDataSourceRemove != null) {
                    spenSDocDataSourceRemove.getDocument().setScheduler(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        removeSchedulerDataSource(str);
    }

    public boolean awaitTerminationAll(long j, TimeUnit timeUnit) {
        DataLogger.m12302d(TAG, "awaitTerminationAll, timeout : " + j + ", unit : " + timeUnit);
        forceClose();
        return this.mSchedulerDataSource.awaitTerminationAll(j, timeUnit);
    }

    public void close(@NonNull final DocumentSubscriptionId documentSubscriptionId, @NonNull final DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        enqueue(CloseDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).taskListener(new CloseDocumentTask.CloseTaskCallback() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.4
            @Override // com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.CloseTaskCallback
            @WorkerThread
            public void countDownDocReference(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId2) {
                DataLogger.m12307i(NotesDocumentInteractor.TAG, "countDownDocReference, uuid : " + str + ", user : " + documentSubscriptionId2);
                DocumentCacheRepository.unsubscribe(NotesDocumentInteractor.this.getSpenSDocDataSource(str), documentSubscriptionId2);
                synchronized (NotesDocumentInteractor.this.mDocumentUserManager) {
                    NotesDocumentInteractor.this.mDocumentUserManager.disuse(documentDataSource.getUuid(), documentSubscriptionId2);
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.CloseTaskCallback
            public void deleteEmptyDoc(@NonNull String str) {
                NotesDocumentInteractor.this.mHandler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastHandler.show(NotesDocumentInteractor.this.mContext, NotesDocumentInteractor.this.mContext.getResources().getString(C11397R.string.base_string_no_content_to_save_note_discarded), 1, true);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.CloseTaskCallback
            public int getDocReferenceCount(@NonNull String str) {
                int usingCount;
                synchronized (NotesDocumentInteractor.this.mDocumentUserManager) {
                    usingCount = NotesDocumentInteractor.this.mDocumentUserManager.getUsingCount(documentDataSource.getUuid());
                }
                return usingCount;
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.CloseTaskCallback
            @WorkerThread
            public void onClosed(@NonNull String str, @Nullable ISpenDocument iSpenDocument) {
                DataLogger.m12307i(NotesDocumentInteractor.TAG, "onClosed, uuid : " + str + ", spenSDoc : " + iSpenDocument);
                NotesDocumentInteractor.this.removeSpenSDocDataSource(str);
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.CloseTaskCallback
            @WorkerThread
            public void successForceSave() {
                NotesDocumentInteractor.this.mHandler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C114554 c114554 = C114554.this;
                        NotesDocumentInteractor.this.notifyTaskSavedListener(documentSubscriptionId, false);
                    }
                });
            }
        }).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId)));
    }

    public void discardCache(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        enqueue(DiscardCacheDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId)));
    }

    public void enqueue(@NonNull DocumentTask documentTask) {
        enqueue(documentTask, new C11456a());
    }

    @WorkerThread
    public SpenSDocDataSource getSpenSDocDataSource(@NonNull String str) {
        SpenSDocDataSource spenSDocDataSource;
        String str2 = TAG;
        DataLogger.m12307i(str2, "getSpenSDocDataSource, uuid");
        synchronized (this.mSDocMap) {
            spenSDocDataSource = this.mSDocMap.get(str);
            DataLogger.m12307i(str2, "getSpenSDocDataSource, uuid : " + str + ", result : " + spenSDocDataSource);
        }
        return spenSDocDataSource;
    }

    public void init() {
        synchronized (this.mSchedulerDataSource) {
            this.mIsClosing = false;
            DataLogger.m12307i(TAG, "init, isClosing: " + this.mIsClosing);
        }
    }

    public boolean isIdle() {
        boolean z;
        String str = TAG;
        DataLogger.m12307i(str, "isIdle");
        synchronized (this.mSDocMap) {
            synchronized (this.mSchedulerDataSource) {
                try {
                    DataLogger.m12307i(str, "isIdle, sDocMap: " + this.mSDocMap.isEmpty() + ", detail: " + this.mSDocMap);
                    DataLogger.m12307i(str, "isIdle, scheduler: " + this.mSchedulerDataSource.isIdle() + ", detail: " + this.mSchedulerDataSource);
                    z = this.mSDocMap.isEmpty() && this.mSchedulerDataSource.isIdle();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public void notifyTaskEndedListener() {
        DocumentInteractorListener documentInteractorListener = this.mDocumentInteractorListener;
        if (documentInteractorListener != null) {
            documentInteractorListener.onEnd();
        }
    }

    public void notifyTaskSavedListener(@Nullable DocumentSubscriptionId documentSubscriptionId, boolean z) {
        DocumentInteractorListener documentInteractorListener = this.mDocumentInteractorListener;
        if (documentInteractorListener != null) {
            documentInteractorListener.onSaved(documentSubscriptionId, z);
        }
    }

    public void notifyTaskStartedListener() {
        DocumentInteractorListener documentInteractorListener = this.mDocumentInteractorListener;
        if (documentInteractorListener != null) {
            documentInteractorListener.onStart();
        }
    }

    public void open(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        int mode = documentDataSource.getDocumentRepository().getMode();
        enqueue(LoadDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).mode(mode).taskListener(new LoadDocumentTask.LoadTaskCallback() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.1
            @Override // com.samsung.android.support.senl.nt.model.executor.task.LoadDocumentTask.LoadTaskCallback
            @WorkerThread
            public SpenSDocDataSource getCache(@NonNull String str) {
                return NotesDocumentInteractor.this.getSpenSDocDataSource(str);
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.LoadDocumentTask.LoadTaskCallback
            @WorkerThread
            public void onLoaded(@NonNull String str, @NonNull SpenSDocDataSource spenSDocDataSource) {
                NotesDocumentInteractor.this.putSpenSDocDataSource(str, spenSDocDataSource);
            }
        }).cacheStrategy(mode != 0 ? DocumentTask.CacheStrategy.CACHE_NONE : DocumentTask.CacheStrategy.CACHE_MEMORY).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId).needToCountUpDocReference(mode == 0)));
    }

    public void openCache(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentRepository documentRepository, @Nullable DocumentCompletionListener documentCompletionListener) {
        enqueue(LoadCacheDocumentTask.Builder.build(this.mContext, this.mHandler).lockConfirm(documentRepository.getLockConfirm()).caller(documentRepository.getCaller()).taskListener(new LoadCacheDocumentTask.LoadCacheTaskCallback() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.2
            @Override // com.samsung.android.support.senl.nt.model.executor.task.LoadCacheDocumentTask.LoadCacheTaskCallback
            @WorkerThread
            public SpenSDocDataSource getCache(@NonNull String str) {
                return NotesDocumentInteractor.this.getSpenSDocDataSource(str);
            }

            @Override // com.samsung.android.support.senl.nt.model.executor.task.LoadCacheDocumentTask.LoadCacheTaskCallback
            public void onLoaded(@NonNull String str, @NonNull SpenSDocDataSource spenSDocDataSource) {
                NotesDocumentInteractor.this.putSpenSDocDataSource(str, spenSDocDataSource);
            }
        }).documentRepository(documentRepository).uuid(documentRepository.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId).needToCountUpDocReference(true)));
    }

    public void quit(boolean z) {
        synchronized (this.mSchedulerDataSource) {
            try {
                DataLogger.m12302d(TAG, "quit, remains : { [SchedulerDataSource - " + this.mSchedulerDataSource + "] }");
                if (z) {
                    this.mIsClosing = true;
                    this.mSchedulerDataSource.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void release(@NonNull DocumentSubscriptionId documentSubscriptionId, @Nullable DocumentCompletionListener documentCompletionListener) {
        DataLogger.m12307i(TAG, "release, user : " + documentSubscriptionId);
        synchronized (this.mSDocMap) {
            try {
                for (SpenSDocDataSource spenSDocDataSource : this.mSDocMap.values()) {
                    if (spenSDocDataSource.isUsed(documentSubscriptionId)) {
                        DataLogger.m12309w(TAG, "release, exist using cache : " + spenSDocDataSource);
                        close(documentSubscriptionId, spenSDocDataSource.getDocument(), documentCompletionListener);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reload(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, @Nullable DocumentCompletionListener documentCompletionListener) {
        enqueue(ReloadDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId)));
    }

    public void save(@NonNull final DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, boolean z, final boolean z2, @Nullable DocumentCompletionListener documentCompletionListener) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String strNewUUID = UUIDUtils.newUUID(this.mContext);
        if (z) {
            this.mLocks.put(strNewUUID, new Object());
            atomicBoolean.set(true);
        }
        BaseSaveTaskCallback baseSaveTaskCallback = new BaseSaveTaskCallback("save", z, strNewUUID, atomicBoolean);
        enqueue(SaveDocumentTask.Builder.build(this.mContext, this.mHandler).taskListener(baseSaveTaskCallback).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, new Runnable() { // from class: com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.3
            @Override // java.lang.Runnable
            public void run() {
                NotesDocumentInteractor.this.notifyTaskSavedListener(documentSubscriptionId, z2);
            }
        }, documentSubscriptionId)), new SaveTaskSubmitListener(baseSaveTaskCallback));
        try {
            if (z) {
                try {
                    String str = TAG;
                    DataLogger.m12309w(str, "save, thread locked.");
                    Object obj = this.mLocks.get(strNewUUID);
                    Objects.requireNonNull(obj);
                    synchronized (obj) {
                        try {
                            if (atomicBoolean.get()) {
                                Object obj2 = this.mLocks.get(strNewUUID);
                                Objects.requireNonNull(obj2);
                                obj2.wait();
                            }
                        } finally {
                        }
                    }
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str, "save, thread unlocked.");
                } catch (InterruptedException e) {
                    String str2 = TAG;
                    DataLogger.m12303e(str2, "save, e : " + e.getMessage());
                    Thread.currentThread().interrupt();
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str2, "save, thread unlocked.");
                }
                this.mLocks.remove(strNewUUID);
            }
        } catch (Throwable th) {
            atomicBoolean.set(false);
            DataLogger.m12309w(TAG, "save, thread unlocked.");
            throw th;
        }
    }

    public void saveCache(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, boolean z, @Nullable DocumentCompletionListener documentCompletionListener) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String strNewUUID = UUIDUtils.newUUID(this.mContext);
        if (z) {
            this.mLocks.put(strNewUUID, new Object());
            atomicBoolean.set(true);
        }
        BaseSaveTaskCallback baseSaveTaskCallback = new BaseSaveTaskCallback("saveCache", z, strNewUUID, atomicBoolean);
        enqueue(SaveCacheDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).taskListener(baseSaveTaskCallback).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId)), new SaveTaskSubmitListener(baseSaveTaskCallback));
        try {
            if (z) {
                try {
                    String str = TAG;
                    DataLogger.m12309w(str, "saveCache, thread locked.");
                    Object obj = this.mLocks.get(strNewUUID);
                    Objects.requireNonNull(obj);
                    synchronized (obj) {
                        try {
                            if (atomicBoolean.get()) {
                                Object obj2 = this.mLocks.get(strNewUUID);
                                Objects.requireNonNull(obj2);
                                obj2.wait();
                            }
                        } finally {
                        }
                    }
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str, "saveCache, thread unlocked.");
                } catch (InterruptedException e) {
                    String str2 = TAG;
                    DataLogger.m12303e(str2, "saveCache, e : " + e.getMessage());
                    Thread.currentThread().interrupt();
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str2, "saveCache, thread unlocked.");
                }
                this.mLocks.remove(strNewUUID);
            }
        } catch (Throwable th) {
            atomicBoolean.set(false);
            DataLogger.m12309w(TAG, "saveCache, thread unlocked.");
            throw th;
        }
    }

    public void setDocumentInteractorListener(@Nullable DocumentInteractorListener documentInteractorListener) {
        this.mDocumentInteractorListener = documentInteractorListener;
    }

    public void snapSave(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull DocumentDataSource documentDataSource, boolean z, @Nullable DocumentCompletionListener documentCompletionListener) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String strNewUUID = UUIDUtils.newUUID(this.mContext);
        if (z) {
            this.mLocks.put(strNewUUID, new Object());
            atomicBoolean.set(true);
        }
        BaseSaveTaskCallback baseSaveTaskCallback = new BaseSaveTaskCallback("snapSave", z, strNewUUID, atomicBoolean);
        enqueue(SnapSaveDocumentTask.Builder.build(this.mContext, documentDataSource, this.mHandler).taskListener(baseSaveTaskCallback).target(documentDataSource).uuid(documentDataSource.getUuid()).user(documentSubscriptionId).listener(new CompletionCallback(this, documentCompletionListener, documentSubscriptionId)), new SaveTaskSubmitListener(baseSaveTaskCallback));
        try {
            if (z) {
                try {
                    String str = TAG;
                    DataLogger.m12309w(str, "snapSave, thread locked.");
                    Object obj = this.mLocks.get(strNewUUID);
                    Objects.requireNonNull(obj);
                    synchronized (obj) {
                        try {
                            if (atomicBoolean.get()) {
                                Object obj2 = this.mLocks.get(strNewUUID);
                                Objects.requireNonNull(obj2);
                                obj2.wait();
                            }
                        } finally {
                        }
                    }
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str, "snapSave, thread unlocked.");
                } catch (InterruptedException e) {
                    String str2 = TAG;
                    DataLogger.m12303e(str2, "snapSave, e : " + e.getMessage());
                    Thread.currentThread().interrupt();
                    atomicBoolean.set(false);
                    DataLogger.m12309w(str2, "snapSave, thread unlocked.");
                }
                this.mLocks.remove(strNewUUID);
            }
        } catch (Throwable th) {
            atomicBoolean.set(false);
            DataLogger.m12309w(TAG, "snapSave, thread unlocked.");
            throw th;
        }
    }

    public void enqueue(@NonNull DocumentTask documentTask, @NonNull TaskSubmitListener taskSubmitListener) {
        synchronized (this.mSchedulerDataSource) {
            try {
                String str = TAG;
                DataLogger.m12308p(str, "enqueue, request : " + documentTask);
                if (this.mIsClosing) {
                    taskSubmitListener.onFailed(documentTask);
                    return;
                }
                NotesDocumentThreadPool executorService = this.mSchedulerDataSource.getExecutorService(documentTask.getUuid());
                if (executorService.isTerminated()) {
                    DataLogger.m12307i(str, "enqueue, ThreadPool: " + executorService);
                    executorService = this.mSchedulerDataSource.replaceExecutorService(documentTask.getUuid());
                } else if (executorService.isShutdown()) {
                    taskSubmitListener.onFailed(documentTask);
                    return;
                }
                executorService.submit(documentTask);
                notifyTaskStartedListener();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
