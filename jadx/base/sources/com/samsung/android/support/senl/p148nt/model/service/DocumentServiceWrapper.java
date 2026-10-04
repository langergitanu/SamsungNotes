package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.constants.ModelConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentServiceWrapper extends IDocumentServiceWrapper {
    private static final String TAG = ModelLogger.createTag("DocumentServiceWrapper");
    private static final long UNSUBSCRIBED_FORCE_CLOSE_DELAY = 3000;
    private IDocumentServiceWrapper.DocumentServiceListener mDocumentServiceListener;
    private IDocumentServiceWrapper.DocumentSubscriptionListener mDocumentSubscriptionListener;
    private IDocumentService mService;
    private IDocumentServiceWrapper.SyncListener mSyncListener;
    private final DocumentSubscriptionId mUser;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class LocalServiceListener<T extends ISpenDocument> implements DocumentCompletionListener<T> {
        private static final String TAG = ModelLogger.createTag("DocumentServiceWrapper$LocalServiceListener");
        private final DocumentCompletionListener<T> mListener;

        public LocalServiceListener(DocumentCompletionListener<T> documentCompletionListener) {
            DataLogger.m12307i(TAG, "LocalServiceListener, user : " + DocumentServiceWrapper.this.getUser() + ", listener : " + documentCompletionListener + ", isSubscribed : " + DocumentServiceWrapper.this.isSubscribed());
            this.mListener = documentCompletionListener;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void completed(DocumentDataSource<T, ? extends DocumentEntityContainer> documentDataSource, String str) {
            DocumentCompletionListener<T> documentCompletionListener;
            DataLogger.m12307i(TAG, "completed, user : " + DocumentServiceWrapper.this.getUser() + ", uuid : " + str + ", isSubscribed : " + DocumentServiceWrapper.this.isSubscribed());
            if (!DocumentServiceWrapper.this.isSubscribed() || (documentCompletionListener = this.mListener) == null) {
                return;
            }
            documentCompletionListener.completed(documentDataSource, str);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DocumentCompletionListener<T> documentCompletionListener;
            if (th == null || !ModelConstants.ERROR_MSG_DOCUMENT_CACHE_NOT_EXIST.equals(th.getMessage())) {
                DataLogger.m12303e(TAG, "failed, user : " + DocumentServiceWrapper.this.getUser() + ", uuid : " + str + ", exc : " + th + ", isSubscribed : " + DocumentServiceWrapper.this.isSubscribed());
            }
            if (!DocumentServiceWrapper.this.isSubscribed() || (documentCompletionListener = this.mListener) == null) {
                return;
            }
            documentCompletionListener.failed(th, str);
        }
    }

    public DocumentServiceWrapper(@NonNull IDocumentService iDocumentService, @NonNull DocumentSubscriptionId documentSubscriptionId, @Nullable IDocumentServiceWrapper.DocumentSubscriptionListener documentSubscriptionListener) {
        String str = TAG;
        DataLogger.m12307i(str, "DocumentServiceWrapper, user : " + documentSubscriptionId);
        this.mService = iDocumentService;
        this.mUser = documentSubscriptionId;
        this.mDocumentSubscriptionListener = documentSubscriptionListener;
        if (documentSubscriptionListener != null) {
            documentSubscriptionListener.onSubscribed(this);
        }
        StringBuilder sb = new StringBuilder("subscribe, user : ");
        sb.append(documentSubscriptionId);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
    }

    private <T extends ISpenDocument> LocalServiceListener<T> createLocalServiceListener(DocumentCompletionListener<T> documentCompletionListener) {
        DataLogger.m12307i(TAG, "createLocalServiceListener, user : " + getUser() + ", listener : " + documentCompletionListener + ", isSubscribed : " + isSubscribed());
        return new LocalServiceListener<>(documentCompletionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSubscribed() {
        return this.mService != null;
    }

    private boolean isValid(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str;
        boolean z = false;
        if (!isSubscribed()) {
            str = "service is null.";
        } else if (documentDataSource == null) {
            str = "DocumentDataSource must be passed.";
        } else if (documentDataSource.getUuid() == null) {
            str = "DocUuid is null.";
        } else {
            z = true;
            str = "";
        }
        if (!z) {
            DataLogger.m12303e(TAG, "isValid, e: ".concat(str));
            if (documentCompletionListener != null) {
                documentCompletionListener.failed(new Exception(str), null);
            }
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public boolean askForReadyToDownloadDocument(@NonNull String str) {
        return askForReadyToDownloadDocument(getUser(), str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public boolean askForReadyToReplaceOriginalDocument(@NonNull String str) {
        return askForReadyToReplaceOriginalDocument(getUser(), str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void close(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("close, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.close(documentDataSource, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void discardQuickSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("discardQuickSave, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.discardQuickSave(documentDataSource, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public DocumentSubscriptionId getUser() {
        return this.mUser;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void notifyDocumentOpenedListener(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        IDocumentServiceWrapper.DocumentServiceListener documentServiceListener;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("notifyDocumentOpenedListener, user : ");
        sb.append(documentSubscriptionId);
        sb.append(", uuid : ");
        sb.append(str);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str2);
        if (isSubscribed() && (documentServiceListener = this.mDocumentServiceListener) != null) {
            documentServiceListener.onOpenedByUser(documentSubscriptionId, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void notifyForceClosedDocument() {
        IDocumentServiceWrapper.DocumentServiceListener documentServiceListener = this.mDocumentServiceListener;
        if (documentServiceListener != null) {
            documentServiceListener.onForceClosedDocument();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void notifyOnChangedDocumentListener(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        IDocumentServiceWrapper.DocumentServiceListener documentServiceListener;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("notifyOnChangedDocumentListener, user : ");
        sb.append(getUser());
        sb.append(", uuid : ");
        sb.append(str);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str2);
        if (isSubscribed() && (documentServiceListener = this.mDocumentServiceListener) != null) {
            documentServiceListener.onChangedDocumentByUser(documentSubscriptionId, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void notifyOnChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        IDocumentServiceWrapper.DocumentServiceListener documentServiceListener = this.mDocumentServiceListener;
        if (documentServiceListener != null) {
            documentServiceListener.onChangedWorkingState(str, workingState, documentSubscriptionId);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public boolean notifyOnReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        IDocumentServiceWrapper.SyncListener syncListener = this.mSyncListener;
        if (syncListener != null) {
            return syncListener.onReadyToDownloadDocument(documentSubscriptionId, str);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public boolean notifyOnReadyToReplaceDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        IDocumentServiceWrapper.SyncListener syncListener = this.mSyncListener;
        if (syncListener != null) {
            return syncListener.onReadyToReplaceDocument(documentSubscriptionId, str);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void notifyOnReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
        DataLogger.m12309w(TAG, "notifyOnReceiveBroadcastMessage, sender : " + documentSubscriptionId + ", intent : " + intent);
        IDocumentServiceWrapper.DocumentServiceListener documentServiceListener = this.mDocumentServiceListener;
        if (documentServiceListener != null) {
            documentServiceListener.onReceiveBroadcastMessage(documentSubscriptionId, intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void open(@NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("open, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isSubscribed()) {
            DocumentRepository.checkNonNullObjects(documentRepository);
            this.mService.open(documentRepository, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void openCache(@NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("openCache, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isSubscribed()) {
            DocumentRepository.checkNonNullObjects(documentRepository);
            this.mService.openCache(documentRepository, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void registerDocumentServiceListener(IDocumentServiceWrapper.DocumentServiceListener documentServiceListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("registerDocumentServiceListener, user : ");
        sb.append(getUser());
        sb.append(", listener : ");
        sb.append(documentServiceListener);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        this.mDocumentServiceListener = documentServiceListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void registerSyncListener(IDocumentServiceWrapper.SyncListener syncListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("registerSyncListener, user : ");
        sb.append(getUser());
        sb.append(", listener : ");
        sb.append(syncListener);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        this.mSyncListener = syncListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void release(@NonNull DocumentSubscriptionId documentSubscriptionId, long j, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("unsubscribe, user : ");
        sb.append(documentSubscriptionId);
        sb.append(", delay : ");
        sb.append(j);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isSubscribed()) {
            this.mService.release(documentSubscriptionId, j, documentCompletionListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void reload(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("reload, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.reload(documentDataSource, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void save(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, boolean z2, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("save, user : ");
        sb.append(getUser());
        sb.append(", sync : ");
        sb.append(z);
        sb.append(", doNotShowSavedToast : ");
        sb.append(z2);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.save(documentDataSource, z, z2, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void saveCache(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("saveCache, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.saveCache(documentDataSource, z, createLocalServiceListener(documentCompletionListener));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void sendBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
        DataLogger.m12307i(TAG, "sendBroadcastMessage, sender : " + documentSubscriptionId + ", isSubscribed : " + isSubscribed() + ", intent : " + intent);
        if (isSubscribed()) {
            this.mService.sendBroadcastMessage(documentSubscriptionId, intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public void snapSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("snapSave, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isValid(documentDataSource, documentCompletionListener)) {
            this.mService.snapSave(documentDataSource, z, createLocalServiceListener(documentCompletionListener));
        }
    }

    @NonNull
    public String toString() {
        return "{mUser : " + this.mUser + "}";
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void unregisterDocumentServiceListener(IDocumentServiceWrapper.DocumentServiceListener documentServiceListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("unregisterDocumentServiceListener, user : ");
        sb.append(getUser());
        sb.append(", listener : ");
        sb.append(documentServiceListener);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        this.mDocumentServiceListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void unregisterSyncListener(IDocumentServiceWrapper.SyncListener syncListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("unregisterSyncListener, user : ");
        sb.append(getUser());
        sb.append(", listener : ");
        sb.append(syncListener);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        this.mSyncListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void unsubscribe() {
        String str = TAG;
        StringBuilder sb = new StringBuilder("unsubscribe, user : ");
        sb.append(getUser());
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        if (isSubscribed()) {
            this.mService.release(getUser(), 3000L, null);
            IDocumentServiceWrapper.DocumentSubscriptionListener documentSubscriptionListener = this.mDocumentSubscriptionListener;
            if (documentSubscriptionListener != null) {
                documentSubscriptionListener.onUnsubscribed(this);
                this.mDocumentSubscriptionListener = null;
            }
            this.mService = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public boolean askForReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12307i(TAG, "askForReadyToDownloadDocument, user : " + documentSubscriptionId + ", isSubscribed : " + isSubscribed() + ", uuid : " + str);
        if (isSubscribed()) {
            return this.mService.askForReadyToDownloadDocument(documentSubscriptionId, str);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentService
    public boolean askForReadyToReplaceOriginalDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
        DataLogger.m12307i(TAG, "askForReadyToReplaceOriginalDocument, user : " + documentSubscriptionId + ", isSubscribed : " + isSubscribed() + ", uuid : " + str);
        if (isSubscribed()) {
            return this.mService.askForReadyToReplaceOriginalDocument(documentSubscriptionId, str);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper
    public void save(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("save, user : ");
        sb.append(getUser());
        sb.append(", sync : ");
        sb.append(z);
        sb.append(", isSubscribed : ");
        AbstractC11014a.m12340y(sb, isSubscribed(), str);
        save(documentDataSource, z, false, documentCompletionListener);
    }
}
