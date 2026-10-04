package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.common.access.coedit.CoeditAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.data.DocumentUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.domain.note.DeleteNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.utils.DocumentExtraDataUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CloseDocumentTask extends DocumentTask {
    private static final String TAG = ModelLogger.createTag("CloseDocumentTask");
    private CloseTaskCallback mCloseTaskCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static CloseDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource<?, ?> documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(CloseDocumentTask.TAG, "build, documentDataSource : " + documentDataSource);
            return new CloseDocumentTask(context, handler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CloseTaskCallback extends DocumentTask.TaskCallback {
        @WorkerThread
        void countDownDocReference(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId);

        @WorkerThread
        void deleteEmptyDoc(@NonNull String str);

        @WorkerThread
        int getDocReferenceCount(@NonNull String str);

        @WorkerThread
        void onClosed(@NonNull String str, @Nullable ISpenDocument iSpenDocument);

        @WorkerThread
        void successForceSave();
    }

    public CloseDocumentTask(@NonNull Context context) {
        super(context);
    }

    private void closeCoEditNote() {
        if (UUIDUtils.isCoeditUuid(getUuid())) {
            String str = TAG;
            DataLogger.m12307i(str, "closeCoEditNote, start");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            DocumentUpdateManager.getInstance().addObserver(getUuid(), new DocumentUpdateManager.DocumentUpdateObserver() { // from class: com.samsung.android.support.senl.nt.model.executor.task.CloseDocumentTask.1
                @Override // com.samsung.android.support.senl.nt.base.common.data.DocumentUpdateManager.DocumentUpdateObserver
                public void onCoEditDocumentClosed(@NonNull String str2) {
                    AbstractC0000a.m2C("onCoEditDocumentClosed, uuid: ", str2, CloseDocumentTask.TAG);
                    countDownLatch.countDown();
                    DocumentUpdateManager.getInstance().removeObserver(str2, this);
                }
            });
            Intent intent = new Intent(this.mContext, CoeditAccessHandler.getCoeditServiceClass());
            intent.setAction(Constants.ACTION_COEDIT_DOC_CLOSE);
            intent.putExtra("document_uuid", getUuid());
            this.mContext.startService(intent);
            DataLogger.m12302d(str, "closeCoEditNote, start service");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                DataLogger.m12303e(TAG, "closeCoEditNote, e: " + e.getMessage());
            }
            DataLogger.m12307i(TAG, "closeCoEditNote, end");
        }
    }

    private void countDownDocReference(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12302d(TAG, "countDownDocReference, uuid : " + str + ", user: " + documentSubscriptionId);
        CloseTaskCallback closeTaskCallback = this.mCloseTaskCallback;
        if (closeTaskCallback != null) {
            closeTaskCallback.countDownDocReference(str, documentSubscriptionId);
        }
    }

    private void deleteTempConvertedFile(DocumentRepository<?, ?> documentRepository) {
        boolean zDeleteFile;
        if (documentRepository.isOldNote()) {
            String convertedCacheFolderPath = DocumentCacheUtils.getConvertedCacheFolderPath(this.mContext);
            if (convertedCacheFolderPath.isEmpty()) {
                return;
            }
            String loadPath = documentRepository.getLoadPath();
            if (loadPath.contains(convertedCacheFolderPath)) {
                try {
                    zDeleteFile = FileUtils.deleteFile(new File(loadPath));
                } catch (IOException e) {
                    AbstractC11014a.m12332q(e, new StringBuilder("deleteTempConvertedFile, e: "), TAG);
                    zDeleteFile = false;
                }
                DataLogger.m12307i(TAG, "deleteTempConvertedFile, path: " + DataLogger.getEncode(loadPath) + ", deleted: " + zDeleteFile);
            }
        }
    }

    private boolean existUsingDocReference(@NonNull String str) {
        return getDocReferenceCount(str) > 0;
    }

    private void forceSave(@NonNull DocumentDataSource<?, ?> documentDataSource) {
        DocumentSubscriptionId user = getUser();
        boolean zCheckSaveStrategy = documentDataSource.getDocumentRepository().checkSaveStrategy(128);
        boolean zEquals = DocumentSubscriptionId.DOCUMENT_SERVICE_ID.equals(user);
        String str = TAG;
        DataLogger.m12307i(str, "forceSave, needToForceSave : " + zCheckSaveStrategy + ", byDocService : " + zEquals);
        if (!zCheckSaveStrategy || zEquals) {
            return;
        }
        DocumentExtraDataUtils.save(this.mContext, documentDataSource, false);
        if (documentDataSource.getDoc() == null || documentDataSource.getDoc().isClosed()) {
            DataLogger.m12302d(str, "forceSave, isAlreadyClosed");
            return;
        }
        boolean zIsNewDocument = documentDataSource.getDocumentRepository().isNewDocument();
        boolean zIsChangedOnlyThumbnail = documentDataSource.isChangedOnlyThumbnail();
        boolean zIsContentEmpty = documentDataSource.isContentEmpty();
        boolean zIsEntityChanged = documentDataSource.isEntityChanged();
        boolean zIsDiscarded = documentDataSource.isDiscarded();
        boolean z = (documentDataSource.isContentChanged() || documentDataSource.getDoc().hasSnapSavedData()) && !zIsDiscarded;
        boolean z2 = documentDataSource.isSaveCache() && !zIsDiscarded;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("forceSave, isNewDocument : ", ", isContentEmpty : ", ", isContentChanged : ", zIsNewDocument, zIsContentEmpty);
        AbstractC2821a.m2208C(sbM2230u, z, ", isChangedOnlyThumbnail : ", zIsChangedOnlyThumbnail, ", isReservedDiscard : ");
        AbstractC2821a.m2208C(sbM2230u, zIsDiscarded, ", isEntityChanged : ", zIsEntityChanged, ", isSaveCache : ");
        sbM2230u.append(z2);
        DataLogger.m12305f(str, sbM2230u.toString());
        if (z) {
            DataLogger.m12302d(str, "forceSave, run, try to save - document hashCode: " + Integer.toHexString(documentDataSource.hashCode()));
            DataLogger.m12308p(str, "force save - start");
            if (!documentDataSource.isNew()) {
                documentDataSource.save(this.mContext);
            }
            DataLogger.m12308p(str, "force save - end");
            notifySuccessForceSave(getUuid(), documentDataSource.getDocumentRepository());
            return;
        }
        DataLogger.m12302d(str, "forceSave, contents were not needed to save.");
        if (!zIsContentEmpty && zIsEntityChanged) {
            if (documentDataSource.saveToDatabase(this.mContext, false)) {
                DocumentExtraDataUtils.updateExternalSharedDocuments(this.mContext, documentDataSource);
                DataLogger.m12302d(str, "forceSave, database entity was changed.");
                documentDataSource.setNewDocument(false);
                notifySuccessForceSave(getUuid(), documentDataSource.getDocumentRepository());
                return;
            }
            return;
        }
        if (z2) {
            DataLogger.m12302d(str, "forceSave, createThumbnail - CREATE_THUMBNAIL_CACHE : " + documentDataSource.getDocumentRepository().checkSaveStrategy(2048));
            documentDataSource.createThumbnail(this.mContext);
            new DocumentPostSaveOperation(this.mContext, zIsNewDocument, documentDataSource.getDocumentEntityContainer().getEntity(), null).setStrategy(2).run();
        }
        if (zIsNewDocument) {
            documentDataSource.saveAutoTitle(this.mContext);
        }
    }

    private int getDocReferenceCount(@NonNull String str) {
        AbstractC11014a.m12334s("getDocReferenceCount, uuid : ", str, TAG);
        CloseTaskCallback closeTaskCallback = this.mCloseTaskCallback;
        if (closeTaskCallback != null) {
            return closeTaskCallback.getDocReferenceCount(str);
        }
        return 0;
    }

    private boolean isClosable() {
        int docReferenceCount = getDocReferenceCount(getUuid());
        return DocumentSubscriptionId.SKIPPED_USERS.contains(getUser()) ? docReferenceCount == 0 : docReferenceCount <= 1;
    }

    private void notifyDeleteEmptyDocument(@NonNull String str, @NonNull DocumentRepository<?, ?> documentRepository) {
        AbstractC11014a.m12334s("notifyDeleteEmptyDocument, uuid : ", str, TAG);
        if (this.mCloseTaskCallback == null || !documentRepository.checkSaveStrategy(32)) {
            return;
        }
        this.mCloseTaskCallback.deleteEmptyDoc(str);
    }

    private void notifyOnClosedCallback(@NonNull String str, @Nullable ISpenDocument iSpenDocument) {
        AbstractC11014a.m12334s("notifyOnClosedCallback, uuid : ", str, TAG);
        CloseTaskCallback closeTaskCallback = this.mCloseTaskCallback;
        if (closeTaskCallback != null) {
            closeTaskCallback.onClosed(str, iSpenDocument);
        }
    }

    private void notifySuccessForceSave(@NonNull String str, @NonNull DocumentRepository<?, ?> documentRepository) {
        AbstractC11014a.m12334s("notifySuccessForceSave, uuid : ", str, TAG);
        if (this.mCloseTaskCallback == null || !documentRepository.checkSaveStrategy(16)) {
            return;
        }
        this.mCloseTaskCallback.successForceSave();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.CLOSE;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String str = TAG;
                DataLogger.m12308p(str, "close document task - start");
                DocumentDataSource<?, ?> documentDataSource = this.mTarget;
                ISpenDocument doc = documentDataSource.getDoc();
                DataLogger.m12302d(str, "close, try close doc. document.getDoc: " + doc);
                if (documentDataSource.getWritingMode() == 100) {
                    countDownDocReference(getUuid(), getUser());
                    if (!existUsingDocReference(getUuid())) {
                        DocumentCacheUtils.deletePDFWriterCacheDat(this.mContext, this.mUuid);
                        DocumentFileManager.getInstance().closeWordDocument(documentDataSource.getPath(), (SpenWordDocument) doc, true);
                        notifyOnClosedCallback(getUuid(), doc);
                    }
                } else {
                    if (isClosable()) {
                        closeCoEditNote();
                        forceSave(documentDataSource);
                    }
                    countDownDocReference(getUuid(), getUser());
                    if (!existUsingDocReference(getUuid())) {
                        boolean zCheckSaveStrategy = documentDataSource.getDocumentRepository().checkSaveStrategy(64);
                        DataLogger.m12309w(str, "close, DO_NOT_DELETE_SERVICE_CACHE : " + zCheckSaveStrategy);
                        if (!zCheckSaveStrategy) {
                            DocumentCacheUtils.deleteDocumentDat(this.mContext, getUuid());
                        }
                        if (documentDataSource.isContentEmpty() && documentDataSource.getDocumentRepository().isNewDocument() && !DocumentSubscriptionId.CONVERT_SERVICE_ID.getUser().equals(documentDataSource.getDocumentRepository().getDocumentSubscriptionId().getUser()) && !UUIDUtils.isCoeditUuid(getUuid())) {
                            if (documentDataSource.isNew()) {
                                DataLogger.m12305f(str, "#delete, new empty document, uuid: " + getUuid());
                                NotesDocumentDeleteUtils.deleteDocumentFile(this.mContext, getUuid(), documentDataSource.getPath(), null, null, 6);
                                if (WidgetAccessHandler.getWidgetAccessContract() != null) {
                                    WidgetAccessHandler.getWidgetAccessContract().sendDeleteUuidWidgetBroadcast(this.mContext, Collections.singletonList(getUuid()));
                                }
                            } else if (!documentDataSource.isDiscarded()) {
                                new DeleteNoteUseCase().invoke(new DeleteNoteUseCase.Param(this.mContext, Collections.singletonList(getUuid()), 0, 1, getUser().getUser()));
                                notifyDeleteEmptyDocument(getUuid(), documentDataSource.getDocumentRepository());
                            }
                        }
                        DocumentWriteResolver.removeDeletedPages(this.mContext, getUuid());
                        try {
                            try {
                                DocumentFileManager.getInstance().closeWordDocument(documentDataSource.getPath(), (SpenWordDocument) doc, true);
                                deleteTempConvertedFile(documentDataSource.getDocumentRepository());
                                notifyOnClosedCallback(getUuid(), doc);
                            } catch (NullPointerException e) {
                                DataLogger.printStackTrace(TAG, e);
                                throw e;
                            }
                        } catch (Throwable th) {
                            notifyOnClosedCallback(getUuid(), doc);
                            throw th;
                        }
                    }
                    if (!UUIDUtils.isCoeditUuid(getUuid()) && !PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(documentDataSource.getDocumentEntityContainer().getEntity().getCategoryUuid())) {
                        RequestToSyncManager.INSTANCE.getInstance().notifyOnDocumentClosed();
                    }
                }
                success(str, documentDataSource, getUuid());
                DataLogger.m12308p(str, "close document task - end");
            } catch (Exception e2) {
                String str2 = TAG;
                DataLogger.m12303e(str2, "close, e: " + e2.getMessage());
                fail(str2, e2, getUuid());
                DataLogger.m12308p(str2, "close document task - end");
            }
        } catch (Throwable th2) {
            DataLogger.m12308p(TAG, "close document task - end");
            throw th2;
        }
    }

    public DocumentTask taskListener(@Nullable CloseTaskCallback closeTaskCallback) {
        this.mCloseTaskCallback = closeTaskCallback;
        return this;
    }

    public CloseDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
