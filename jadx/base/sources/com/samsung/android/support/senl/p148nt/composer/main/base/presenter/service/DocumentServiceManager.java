package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenDocListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ReloadDocListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentServiceManager implements OpenDocListener.Contract<SpenWordDocument>, ReloadDocListener.Contract<SpenWordDocument>, IDocumentServiceWrapper.DocumentServiceListener, IDocumentServiceWrapper.SyncListener {
    private static final String TAG = Logger.createTag("DocumentServiceManager");
    private ServiceConnection mConnection;
    protected final ServiceContract<SpenWordDocument> mContract;
    private NotesDocument<SpenWordDocument> mDocState;
    private NotesDocument<SpenWordDocument> mOldDocState;
    protected CustomSaveStrategy mSaveStrategy;
    private IDocumentServiceWrapper mService;
    private DocumentSubscriptionId mSubscriptionId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentServiceConnection implements ServiceConnection {
        public /* synthetic */ DocumentServiceConnection(DocumentServiceManager documentServiceManager, int i) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.m10999d(DocumentServiceManager.TAG, "onServiceConnected");
            if (!DocumentServiceManager.this.mContract.isAttachedToActivity()) {
                Logger.m11000e(DocumentServiceManager.TAG, "isAttachedToActivity false");
                return;
            }
            if (!(iBinder instanceof IDocumentServiceBinder)) {
                Logger.m11000e(DocumentServiceManager.TAG, "wrong type" + iBinder);
                return;
            }
            DocumentServiceManager.this.mService = ((IDocumentServiceBinder) iBinder).subscribe(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser(), DocumentServiceManager.this.mSubscriptionId);
            DocumentServiceManager documentServiceManager = DocumentServiceManager.this;
            documentServiceManager.mSubscriptionId = documentServiceManager.mService.getUser();
            DocumentServiceManager.this.mService.registerDocumentServiceListener(DocumentServiceManager.this);
            DocumentServiceManager.this.mService.registerSyncListener(DocumentServiceManager.this);
            DocumentServiceManager.this.mContract.onServiceConnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.m10999d(DocumentServiceManager.TAG, "onServiceDisconnected");
            DocumentServiceManager.this.mService = null;
        }

        private DocumentServiceConnection() {
        }
    }

    public DocumentServiceManager(ServiceContract<SpenWordDocument> serviceContract, @NonNull CustomSaveStrategy customSaveStrategy) {
        this.mContract = serviceContract;
        this.mSaveStrategy = customSaveStrategy;
    }

    private boolean closeDocument(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null || this.mService == null) {
            Logger.m10999d(TAG, "closeDocument# state is null");
            return false;
        }
        this.mSaveStrategy.onClose(notesDocument.getDocumentRepository(), notesDocument);
        this.mService.close(notesDocument, new NotesDocumentCompletionListener<SpenWordDocument>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.service.DocumentServiceManager.1
            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(@NonNull NotesDocument<SpenWordDocument> notesDocument2, @NonNull String str) {
                Logger.m10999d(DocumentServiceManager.TAG, "completed# close");
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                Logger.m10999d(DocumentServiceManager.TAG, "failed# close");
            }
        });
        return true;
    }

    public boolean changeDocument(String str, String str2) {
        if (this.mContract.getUuid().equals(str)) {
            return false;
        }
        this.mContract.setChangingUuid(str);
        openDocument(str, str2);
        return true;
    }

    public void closeDoc(NotesDocument<SpenWordDocument> notesDocument) {
        if (closeDocument(notesDocument)) {
            this.mDocState = null;
        }
    }

    public void closeOldDoc() {
        NotesDocument<SpenWordDocument> notesDocument = this.mOldDocState;
        if (notesDocument == null || !closeDocument(notesDocument)) {
            return;
        }
        this.mOldDocState = null;
    }

    public void connect(Activity activity) {
        this.mConnection = new DocumentServiceConnection(this, 0);
        activity.bindService(new Intent(activity, (Class<?>) NotesWordDocumentService.class), this.mConnection, 1);
    }

    public void discard() {
        IDocumentServiceWrapper iDocumentServiceWrapper = this.mService;
        if (iDocumentServiceWrapper != null) {
            iDocumentServiceWrapper.discardQuickSave(this.mDocState, null);
        }
    }

    public void disconnect(Context context) {
        ServiceConnection serviceConnection = this.mConnection;
        if (serviceConnection != null) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException e) {
                Logger.m11001e(TAG, "disconnect unbindService", e);
            }
            this.mConnection = null;
        }
        if (this.mService != null) {
            Logger.m10999d(TAG, "disconnect# unsubscribe service");
            this.mService.unregisterSyncListener(this);
            this.mService.unregisterDocumentServiceListener(this);
            this.mService.unsubscribe();
            this.mService = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public void onChangedDocumentByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        String str2 = TAG;
        Logger.m10999d(str2, "onChangedDocumentByUser# modifier : " + documentSubscriptionId + ", uuid : " + str);
        if (!this.mContract.getUuid().equals(str)) {
            Logger.m10999d(str2, "onChangedDocumentByUser# uuid id not matched.");
        } else {
            this.mContract.onReadyReload(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.service.DocumentServiceManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DocumentServiceManager.this.mDocState != null) {
                        DocumentServiceManager.this.mDocState.getDocumentRepository().addSaveStrategy(128);
                        DocumentServiceManager.this.mService.reload(DocumentServiceManager.this.mDocState, new ReloadDocListener(DocumentServiceManager.this));
                    }
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    @WorkerThread
    public void onChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        Logger.m10999d(TAG, "onChangedWorkingState, uuid : " + str + ", workingState : " + workingState + ", owner : " + documentSubscriptionId);
        this.mContract.onChangedWorkingState(str, workingState, documentSubscriptionId);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.service.ReloadDocListener.Contract
    public void onFailedToReload() {
        Logger.m11002f(TAG, "onFailedToReload");
        this.mContract.onReloadedDocument(null);
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public void onForceClosedDocument() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.service.OpenDocListener.Contract
    public void onLoadDocCompleted(NotesDocument<SpenWordDocument> notesDocument) {
        String str = TAG;
        Logger.endTime(str, str, "onLoadDocCompleted doc open :");
        if (!this.mContract.isInProgressNoteChange()) {
            this.mDocState = notesDocument;
            this.mContract.onLoadDocCompleted(notesDocument);
        } else {
            this.mOldDocState = this.mDocState;
            this.mDocState = notesDocument;
            this.mContract.onChangedDoc(notesDocument);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.service.OpenDocListener.Contract
    public void onLoadDocFailed(Throwable th, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("onLoadDocFailed# ");
        sb.append(th == null ? null : th.getMessage());
        Logger.m11000e(str2, sb.toString());
        boolean zIsInProgressNoteChange = this.mContract.isInProgressNoteChange();
        if (zIsInProgressNoteChange) {
            Logger.m11000e(str2, "fail to open a selected note. Restore a previous status");
            this.mOldDocState = null;
            this.mContract.clearChangingInfo();
        }
        this.mContract.onLoadDocFailed(th, zIsInProgressNoteChange);
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public void onOpenedByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.SyncListener
    public boolean onReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        return !this.mContract.needToPendingSyncForComposerBusy(str);
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.SyncListener
    public boolean onReadyToReplaceDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        return !this.mContract.needToConflictSyncForComposerEdit(str);
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public void onReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
        Logger.m11004w(TAG, "onReceiveBroadcastMessage, sender : " + documentSubscriptionId + ", intent : " + intent);
        this.mContract.onReceiveBroadcastMessage(documentSubscriptionId, intent);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.service.ReloadDocListener.Contract
    public void onReloaded(NotesDocument<SpenWordDocument> notesDocument) {
        this.mDocState = notesDocument;
        this.mContract.onReloadedDocument(notesDocument);
    }

    public void openDocument(String str, String str2) {
        Logger.startTime(TAG);
        OpenParam openParam = this.mContract.getOpenParam(UUIDUtils.isCoeditUuid(str));
        openParam.setUuid(str);
        openParam.setDocPath(str2);
        OpenDocCacheListener openDocCacheListener = new OpenDocCacheListener(this.mService, this, new OpenDocListener(this), openParam, this.mSaveStrategy);
        DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> documentRepositoryMakeDocRepository = openParam.makeDocRepository(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser() + "_DocumentServiceConnection", this.mService.getUser());
        this.mSaveStrategy.onOpen(documentRepositoryMakeDocRepository);
        this.mService.openCache(documentRepositoryMakeDocRepository, openDocCacheListener);
    }

    public void resetOldNote() {
        this.mDocState.getDocumentRepository().removeSaveStrategy(128);
        this.mOldDocState = null;
    }

    public void save(NotesDocument<SpenWordDocument> notesDocument, NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener, boolean z) {
        Logger.m10999d(TAG, "save#");
        this.mSaveStrategy.onSave(notesDocument.getDocumentRepository());
        this.mService.save(notesDocument, z, notesDocumentCompletionListener);
        this.mContract.showDebugMessageToast("save#");
    }

    public void saveCache(NotesDocument<SpenWordDocument> notesDocument, boolean z, NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener) {
        Logger.m10999d(TAG, "saveCache# ");
        this.mSaveStrategy.onSaveCache(notesDocument.getDocumentRepository());
        this.mService.saveCache(notesDocument, z, notesDocumentCompletionListener);
        this.mContract.showDebugMessageToast("saveCache#");
    }

    public void snapSave(NotesDocument<SpenWordDocument> notesDocument, boolean z, NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener) {
        Logger.m10999d(TAG, "snapSave# ");
        this.mSaveStrategy.onSaveCache(notesDocument.getDocumentRepository());
        this.mService.snapSave(notesDocument, z, notesDocumentCompletionListener);
        this.mContract.showDebugMessageToast("snapSave#");
    }
}
