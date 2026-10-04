package com.samsung.android.support.senl.p148nt.model.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceMaintainer;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.collector.updater.CollectUpdateTrigger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.injector.NotesDocumentInjector;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class NotesDocumentService extends Service implements IDocumentService {
    private static final String TAG = ModelLogger.createTag("NotesDocumentService");
    private static final long THREAD_TIME_OUT_SECONDS = 5;
    protected Context mContext;
    private NotesDocumentHandlerWrapper mNotesDocumentHandler;
    private final BlockingQueue<DelayedRunnable> mDelayedRunnableQueue = new LinkedBlockingQueue();
    private ServiceMaintainer mServiceMaintainer = new ServiceMaintainer(TAG);
    private final DocumentServiceWrapperManager mServiceWrapperManager = new DocumentServiceWrapperManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DelayedRunnable implements Runnable {
        private static final String TAG = ModelLogger.createTag("DelayedRunnable");
        BlockingQueue<DelayedRunnable> sharedQueue;
        DocumentSubscriptionId user;
        String uuid;

        public DelayedRunnable(DocumentSubscriptionId documentSubscriptionId, @NonNull BlockingQueue<DelayedRunnable> blockingQueue) {
            this(documentSubscriptionId, null, blockingQueue);
        }

        public static void cancelDelayedRunnable(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str, @NonNull BlockingQueue<DelayedRunnable> blockingQueue, @NonNull Handler handler) {
            LinkedBlockingQueue<DelayedRunnable> linkedBlockingQueue = new LinkedBlockingQueue(blockingQueue);
            DataLogger.m12307i(TAG, "cancelDelayedRunnable, user : " + documentSubscriptionId + ", uuid : " + str + ", size : " + linkedBlockingQueue.size());
            for (DelayedRunnable delayedRunnable : linkedBlockingQueue) {
                if (!documentSubscriptionId.equals(DocumentSubscriptionId.DOCUMENT_SERVICE_ID) && documentSubscriptionId.equals(delayedRunnable.getUser())) {
                    handler.removeCallbacks(delayedRunnable);
                    blockingQueue.remove(delayedRunnable);
                }
            }
        }

        private void enqueueDelayedRunnable(@NonNull DelayedRunnable delayedRunnable) {
            String str = TAG;
            DataLogger.m12307i(str, "enqueueDelayedRunnable, runnable : " + delayedRunnable);
            if (getQueue().offer(delayedRunnable)) {
                return;
            }
            DataLogger.m12303e(str, "enqueueDelayedRunnable, the element was not added to this queue");
        }

        public static void executeDelayedRunnables(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str, @NonNull BlockingQueue<DelayedRunnable> blockingQueue, @NonNull Handler handler) {
            LinkedBlockingQueue<DelayedRunnable> linkedBlockingQueue = new LinkedBlockingQueue(blockingQueue);
            DataLogger.m12307i(TAG, "executeDelayedRunnables, user : " + documentSubscriptionId + ", uuid : " + str + ", size : " + linkedBlockingQueue.size());
            for (DelayedRunnable delayedRunnable : linkedBlockingQueue) {
                if (str.equals(delayedRunnable.getUuid())) {
                    handler.removeCallbacks(delayedRunnable);
                    delayedRunnable.run();
                }
            }
        }

        public BlockingQueue<DelayedRunnable> getQueue() {
            return this.sharedQueue;
        }

        public DocumentSubscriptionId getUser() {
            return this.user;
        }

        public String getUuid() {
            return this.uuid;
        }

        public void removeDelayedRunnable(@NonNull DelayedRunnable delayedRunnable) {
            String str = TAG;
            DataLogger.m12307i(str, "removeDelayedRunnable, runnable : " + delayedRunnable);
            if (getQueue().remove(delayedRunnable)) {
                return;
            }
            DataLogger.m12303e(str, "removeDelayedRunnable, failed to remove element.");
        }

        @NonNull
        public String toString() {
            return "uuid : " + getUuid() + SQLKeyword.COMMA + super.toString();
        }

        public DelayedRunnable(DocumentSubscriptionId documentSubscriptionId, @Nullable String str, @NonNull BlockingQueue<DelayedRunnable> blockingQueue) {
            this.uuid = str;
            this.user = documentSubscriptionId;
            this.sharedQueue = blockingQueue;
            enqueueDelayedRunnable(this);
        }

        public static void executeDelayedRunnables(@NonNull BlockingQueue<DelayedRunnable> blockingQueue, @NonNull Handler handler) {
            LinkedBlockingQueue<DelayedRunnable> linkedBlockingQueue = new LinkedBlockingQueue(blockingQueue);
            DataLogger.m12307i(TAG, "executeDelayedRunnables, size : " + linkedBlockingQueue.size());
            for (DelayedRunnable delayedRunnable : linkedBlockingQueue) {
                handler.removeCallbacks(delayedRunnable);
                delayedRunnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder implements IDocumentServiceBinder {
        public /* synthetic */ LocalBinder(NotesDocumentService notesDocumentService, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder
        public IDocumentServiceWrapper subscribe(@NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId) {
            return subscribe(str, documentSubscriptionId, false);
        }

        private LocalBinder() {
        }

        @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder
        public IDocumentServiceWrapper subscribe(@NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId, boolean z) {
            String str2 = NotesDocumentService.TAG;
            StringBuilder sb = new StringBuilder("subscribe, userName : ");
            sb.append(str);
            sb.append(", restoredId : ");
            sb.append(documentSubscriptionId);
            sb.append(", skipReferenceCount : ");
            AbstractC11014a.m12340y(sb, z, str2);
            if (z) {
                documentSubscriptionId = DocumentSubscriptionId.REFERENCE_SKIP_ID;
            }
            return new DocumentServiceWrapperFactory().create(NotesDocumentService.this, str, documentSubscriptionId, new IDocumentServiceWrapper.DocumentSubscriptionListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.LocalBinder.1
                @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentSubscriptionListener
                public void onSubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
                    DataLogger.m12309w(NotesDocumentService.TAG, "onSubscribed, wrapper : " + iDocumentServiceWrapper);
                    synchronized (NotesDocumentService.this.getServiceWrapperManager()) {
                        NotesDocumentService.this.getServiceWrapperManager().subscribe(iDocumentServiceWrapper);
                    }
                    NotesDocumentService.this.onSubscribed(iDocumentServiceWrapper);
                }

                @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentSubscriptionListener
                public void onUnsubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
                    DataLogger.m12309w(NotesDocumentService.TAG, "onUnsubscribed, wrapper : " + iDocumentServiceWrapper);
                    synchronized (NotesDocumentService.this.getServiceWrapperManager()) {
                        NotesDocumentService.this.getServiceWrapperManager().unsubscribe(iDocumentServiceWrapper);
                    }
                    NotesDocumentService.this.onUnsubscribed(iDocumentServiceWrapper);
                }
            });
        }
    }

    private void onDocumentServiceStarted() {
        TaskState.INSTANCE.getInstance().setIsRunning("DOC_SERVICE", true);
        getNotesDocumentHandler().setOnWorkingStateListener(new SchedulerDataSource.OnWorkingStateListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.1
            @Override // com.samsung.android.support.senl.nt.model.executor.scheduler.SchedulerDataSource.OnWorkingStateListener
            @WorkerThread
            public void onState(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
                DataLogger.m12302d(NotesDocumentService.TAG, "setOnWorkingStateListener - onState, uuid : " + str + ", state : " + workingState + ", owner : " + documentSubscriptionId);
                NotesDocumentService.this.notifyOnChangedWorkingState(str, workingState, documentSubscriptionId);
            }
        });
        getNotesDocumentHandler().getDocumentUsecaseExecutor().init();
    }

    private void printRemainedTasks() {
        String str = TAG;
        DataLogger.m12309w(str, "printRemainedTasks");
        if (getNotesDocumentHandler().isIdle()) {
            return;
        }
        DataLogger.m12307i(str, "printRemainedTasks, tasks exist.");
    }

    private void setTaskProgressListener() {
        NotesDocumentHandlerWrapper notesDocumentHandlerWrapper = this.mNotesDocumentHandler;
        if (notesDocumentHandlerWrapper != null) {
            notesDocumentHandlerWrapper.getDocumentHandler().setTaskProgressListener(new NotesDocumentInteractor.DocumentInteractorListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.5
                @Override // com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.DocumentInteractorListener
                public void onEnd() {
                    DataLogger.m12307i(NotesDocumentService.TAG, "TaskProgressListener$onEnd");
                    NotesDocumentService.this.stopSelfIfNoLongerUsed();
                }

                @Override // com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.DocumentInteractorListener
                public void onSaved(@Nullable DocumentSubscriptionId documentSubscriptionId, boolean z) {
                    DataLogger.m12307i(NotesDocumentService.TAG, "TaskProgressListener$onSaved, subscriptionId : " + documentSubscriptionId + ", doNotShowSavedToast : " + z);
                    synchronized (NotesDocumentService.this.getServiceWrapperManager()) {
                        if (!z) {
                            try {
                                if (!NotesDocumentService.this.getServiceWrapperManager().exist(documentSubscriptionId)) {
                                    DataLogger.m12307i(NotesDocumentService.TAG, "showSavedToast, subscriptionId : " + documentSubscriptionId);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }

                @Override // com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.DocumentInteractorListener
                public void onStart() {
                    DataLogger.m12307i(NotesDocumentService.TAG, "TaskProgressListener$onStart");
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public boolean askForReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12309w(TAG, "askForReadyToDownloadDocument, inquirer : " + documentSubscriptionId + ", uuid : " + str);
        synchronized (getServiceWrapperManager()) {
            try {
                for (IDocumentServiceWrapper iDocumentServiceWrapper : getServiceWrapperManager().getWrappers()) {
                    if (!documentSubscriptionId.equals(iDocumentServiceWrapper.getUser()) && !iDocumentServiceWrapper.notifyOnReadyToDownloadDocument(documentSubscriptionId, str)) {
                        DataLogger.m12309w(TAG, "askForReadyToDownloadDocument, editor : " + iDocumentServiceWrapper.getUser() + ", uuid : " + str);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public boolean askForReadyToReplaceOriginalDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12309w(TAG, "askForReadyToReplaceOriginalDocument, inquirer : " + documentSubscriptionId + ", uuid : " + str);
        synchronized (getServiceWrapperManager()) {
            try {
                for (IDocumentServiceWrapper iDocumentServiceWrapper : getServiceWrapperManager().getWrappers()) {
                    if (!documentSubscriptionId.equals(iDocumentServiceWrapper.getUser()) && !iDocumentServiceWrapper.notifyOnReadyToReplaceDocument(documentSubscriptionId, str)) {
                        DataLogger.m12309w(TAG, "askForReadyToReplaceOriginalDocument, editor : " + iDocumentServiceWrapper.getUser() + ", uuid : " + str);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void awaitTermination() {
        String str = TAG;
        DataLogger.m12307i(str, "awaitTermination, ");
        printRemainedTasks();
        DelayedRunnable.executeDelayedRunnables(this.mDelayedRunnableQueue, getNotesDocumentHandler());
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (!getNotesDocumentHandler().awaitTermination(5L, TimeUnit.SECONDS)) {
                    DataLogger.m12303e(str, "awaitTermination, running tasks exist.");
                }
            } catch (InterruptedException e) {
                DataLogger.m12303e(TAG, "awaitTermination, e : " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            DataLogger.m12302d(TAG, "awaitTermination, done, duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            printRemainedTasks();
        } finally {
            getNotesDocumentHandler().quit(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void close(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - close, uuid : " + documentDataSource.getUuid() + ", user : " + documentDataSource.getSubscriptionId());
        getNotesDocumentHandler().close(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void discardQuickSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - discardQuickSave, documentDataSource : " + documentDataSource + ", user : " + documentDataSource.getSubscriptionId() + ", listener : " + documentCompletionListener);
        documentDataSource.getDocumentRepository().removeSaveStrategy(64);
        getNotesDocumentHandler().discardCache(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
        DelayedRunnable.executeDelayedRunnables(documentDataSource.getSubscriptionId(), documentDataSource.getUuid(), this.mDelayedRunnableQueue, getNotesDocumentHandler());
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public ServiceMaintainer getDocumentServiceMaintainer() {
        this.mServiceMaintainer.setServiceMaintainerListener(new ServiceMaintainer.ServiceMaintainerListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.6
            @Override // com.samsung.android.support.senl.nt.base.common.service.ServiceMaintainer.ServiceMaintainerListener
            public void onBind() {
                DataLogger.m12309w(NotesDocumentService.TAG, "maintainConnection$onBind()");
            }

            @Override // com.samsung.android.support.senl.nt.base.common.service.ServiceMaintainer.ServiceMaintainerListener
            public void onUnbind() {
                DataLogger.m12309w(NotesDocumentService.TAG, "maintainConnection$onUnbind()");
                NotesDocumentService.this.stopSelfIfNoLongerUsed();
            }
        });
        return this.mServiceMaintainer;
    }

    @NonNull
    public NotesDocumentHandler getNotesDocumentHandler() {
        if (this.mNotesDocumentHandler == null) {
            this.mNotesDocumentHandler = new NotesDocumentHandlerWrapper(getContext());
            setTaskProgressListener();
        }
        return this.mNotesDocumentHandler.getDocumentHandler();
    }

    @NonNull
    public DocumentServiceWrapperManager getServiceWrapperManager() {
        return this.mServiceWrapperManager;
    }

    public abstract void handleStartCommand(Intent intent, int i, int i2);

    public void maintainConnection(boolean z, Class<?> cls) {
        String str = TAG;
        DataLogger.m12309w(str, "maintainConnection, maintain : " + z + ", bindService : " + cls);
        if (z) {
            getDocumentServiceMaintainer().bind(getContext(), cls);
            return;
        }
        synchronized (getServiceWrapperManager()) {
            try {
                DataLogger.m12309w(str, "maintainConnection, wrappers isEmpty : " + getServiceWrapperManager().isEmpty());
                if (getServiceWrapperManager().isEmpty()) {
                    getDocumentServiceMaintainer().unbind(getContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyDocumentOpenedListeners(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12307i(TAG, "notifyDocumentOpenedListeners, uuid : " + str + ", requestUser : " + documentSubscriptionId);
        synchronized (getServiceWrapperManager()) {
            try {
                for (IDocumentServiceWrapper iDocumentServiceWrapper : getServiceWrapperManager().getWrappers()) {
                    if (iDocumentServiceWrapper != null && !iDocumentServiceWrapper.getUser().equals(documentSubscriptionId)) {
                        iDocumentServiceWrapper.notifyDocumentOpenedListener(documentSubscriptionId, str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyForceClosedDocument() {
        synchronized (getServiceWrapperManager()) {
            try {
                Iterator<IDocumentServiceWrapper> it = getServiceWrapperManager().getWrappers().iterator();
                while (it.hasNext()) {
                    it.next().notifyForceClosedDocument();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyOnChangedDocumentListeners(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12307i(TAG, "notifyOnChangedDocumentListeners, modifier : " + documentSubscriptionId + ", uuid : " + str);
        synchronized (getServiceWrapperManager()) {
            try {
                for (IDocumentServiceWrapper iDocumentServiceWrapper : getServiceWrapperManager().getWrappers()) {
                    if (iDocumentServiceWrapper != null && !iDocumentServiceWrapper.getUser().equals(documentSubscriptionId)) {
                        iDocumentServiceWrapper.notifyOnChangedDocumentListener(documentSubscriptionId, str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public void notifyOnChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        synchronized (getServiceWrapperManager()) {
            try {
                Iterator<IDocumentServiceWrapper> it = getServiceWrapperManager().getWrappers().iterator();
                while (it.hasNext()) {
                    it.next().notifyOnChangedWorkingState(str, workingState, documentSubscriptionId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        DataLogger.m12309w(TAG, "onBind");
        return new LocalBinder(this, 0);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DataLogger.m12309w(TAG, "onCreate: " + hashCode());
        setContext(getApplicationContext());
        TaskState.INSTANCE.getInstance().setIsRunning("DOC_SERVICE", true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DataLogger.m12309w(TAG, "onDestroy: " + hashCode());
        this.mServiceMaintainer = null;
        awaitTermination();
        CollectUpdateTrigger.INSTANCE.getInstance().onTriggerCollect();
        getNotesDocumentHandler().setOnWorkingStateListener(null);
        TaskState companion = TaskState.INSTANCE.getInstance();
        TaskState.Type.Companion companion2 = TaskState.Type.INSTANCE;
        companion.setIsRunning("DOC_SERVICE", !getNotesDocumentHandler().isIdle());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        DataLogger.m12305f(TAG, "ModelRefactoring - onStartCommand, intent : " + intent);
        onDocumentServiceStarted();
        handleStartCommand(intent, i, i2);
        return super.onStartCommand(intent, i, i2);
    }

    public void onSubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
        onDocumentServiceStarted();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        DataLogger.m12309w(TAG, "onTaskRemoved");
        notifyForceClosedDocument();
        awaitTermination();
    }

    public abstract void onUnsubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper);

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void open(@NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - open, documentRepository : " + documentRepository + ", user : " + documentRepository.getDocumentSubscriptionId());
        getNotesDocumentHandler().open(documentRepository.getDocumentSubscriptionId(), NotesDocumentInjector.provide(this.mContext, documentRepository), documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void openCache(@NonNull final DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, final DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - openCache, documentRepository : " + documentRepository + ", listener : " + documentCompletionListener);
        DelayedRunnable.cancelDelayedRunnable(documentRepository.getDocumentSubscriptionId(), documentRepository.getUuid(), this.mDelayedRunnableQueue, getNotesDocumentHandler());
        getNotesDocumentHandler().openCache(documentRepository.getDocumentSubscriptionId(), documentRepository, new DocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.2
            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void completed(DocumentDataSource<ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, String str) {
                DocumentCompletionListener documentCompletionListener2 = documentCompletionListener;
                if (documentCompletionListener2 != null) {
                    documentCompletionListener2.completed(documentDataSource, str);
                }
                NotesDocumentService.this.notifyDocumentOpenedListeners(documentRepository.getDocumentSubscriptionId(), str);
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                DocumentCompletionListener documentCompletionListener2 = documentCompletionListener;
                if (documentCompletionListener2 != null) {
                    documentCompletionListener2.failed(th, str);
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void release(@NonNull DocumentSubscriptionId documentSubscriptionId, final long j, final DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - release, user : " + documentSubscriptionId + ", delay : " + j);
        getNotesDocumentHandler().postDelayed(new DelayedRunnable(documentSubscriptionId, this.mDelayedRunnableQueue) { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.3
            @Override // java.lang.Runnable
            public void run() {
                DataLogger.m12309w(NotesDocumentService.TAG, "ModelRefactoring$delayed - release, user : " + this.user + ", delay : " + j);
                removeDelayedRunnable(this);
                NotesDocumentService.this.getNotesDocumentHandler().release(this.user, documentCompletionListener);
            }
        }, j);
    }

    @VisibleForTesting
    public void releaseDocumentHandler() {
        this.mNotesDocumentHandler = null;
        setTaskProgressListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void reload(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - reload, uuid : " + documentDataSource.getUuid() + ", user : " + documentDataSource.getSubscriptionId());
        getNotesDocumentHandler().reload(documentDataSource.getSubscriptionId(), documentDataSource, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void save(@NonNull final DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, boolean z2, final DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - save, uuid : " + documentDataSource.getUuid() + ", user : " + documentDataSource.getSubscriptionId() + ", sync : " + z + ", doNotShowSavedToast : " + z2);
        documentDataSource.getDocumentRepository().removeSaveStrategy(64);
        getNotesDocumentHandler().save(documentDataSource.getSubscriptionId(), documentDataSource, z, z2, new DocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentService.4
            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void completed(DocumentDataSource<ISpenDocument, ? extends DocumentEntityContainer> documentDataSource2, String str) {
                DocumentCompletionListener documentCompletionListener2 = documentCompletionListener;
                if (documentCompletionListener2 != null) {
                    documentCompletionListener2.completed(documentDataSource2, str);
                }
                boolean zCheckSaveStrategy = documentDataSource2.getDocumentRepository().checkSaveStrategy(2);
                DataLogger.m12309w(NotesDocumentService.TAG, "save#completed, uuid : " + documentDataSource.getUuid() + ", modifier : " + documentDataSource.getSubscriptionId() + ", BROADCAST_RELOAD_AFTER_SAVE : " + zCheckSaveStrategy);
                if (zCheckSaveStrategy) {
                    NotesDocumentService.this.notifyOnChangedDocumentListeners(documentDataSource.getSubscriptionId(), str);
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                DocumentCompletionListener documentCompletionListener2 = documentCompletionListener;
                if (documentCompletionListener2 != null) {
                    documentCompletionListener2.failed(th, str);
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void saveCache(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - saveCache, uuid : " + documentDataSource.getUuid() + ", user : " + documentDataSource.getSubscriptionId());
        getNotesDocumentHandler().saveCache(documentDataSource, z, documentCompletionListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void sendBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
        DataLogger.m12309w(TAG, "sendBroadcastMessage, sender : " + documentSubscriptionId + ", intent : " + intent);
        synchronized (getServiceWrapperManager()) {
            try {
                for (IDocumentServiceWrapper iDocumentServiceWrapper : getServiceWrapperManager().getWrappers()) {
                    if (!documentSubscriptionId.equals(iDocumentServiceWrapper.getUser())) {
                        iDocumentServiceWrapper.notifyOnReceiveBroadcastMessage(documentSubscriptionId, intent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setContext(@NonNull Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void snapSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        DataLogger.m12305f(TAG, "ModelRefactoring - snapSave, uuid : " + documentDataSource.getUuid() + ", user : " + documentDataSource.getSubscriptionId());
        getNotesDocumentHandler().snapSave(documentDataSource, z, documentCompletionListener);
    }

    public void stopSelfIfNoLongerUsed() {
        boolean zIsEmpty;
        boolean zIsIdle = getNotesDocumentHandler().isIdle();
        synchronized (getServiceWrapperManager()) {
            zIsEmpty = getServiceWrapperManager().isEmpty();
        }
        String str = TAG;
        DataLogger.m12309w(str, "stopSelfIfNoLongerUsed, wrappers is empty : " + zIsEmpty + ", isIdle : " + zIsIdle);
        if (zIsIdle && zIsEmpty) {
            getNotesDocumentHandler().quit(true);
            DataLogger.m12309w(str, "stopSelfIfNoLongerUsed, There are no wrappers. so try to stop self.");
            stopSelf();
            TaskState.INSTANCE.getInstance().setIsRunning("DOC_SERVICE", false);
        }
    }
}
