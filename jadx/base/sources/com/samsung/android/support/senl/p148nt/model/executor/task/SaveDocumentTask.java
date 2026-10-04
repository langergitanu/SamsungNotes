package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.SaveResult;
import com.samsung.android.support.senl.p148nt.model.executor.task.BaseSaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.utils.DocumentExtraDataUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SaveDocumentTask extends BaseSaveDocumentTask {
    private static final String TAG = ModelLogger.createTag("SaveDocumentTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static SaveDocumentTask build(@NonNull Context context, @Nullable Handler handler) {
            DataLogger.m12302d(SaveDocumentTask.TAG, "build, handler : " + handler);
            return new SaveDocumentTask(context, handler);
        }
    }

    public SaveDocumentTask(@NonNull Context context) {
        super(context);
    }

    private boolean isAlreadyClosed(DocumentDataSource<?, ?> documentDataSource) {
        boolean z = documentDataSource.getDoc() == null || documentDataSource.getDoc().isClosed();
        if (z) {
            String str = TAG;
            DataLogger.m12302d(str, "save, isAlreadyClosed");
            notifyFailure(str, new RuntimeException("Fail to save - Doc was already closed."));
        }
        return z;
    }

    private void onPostSaved(@NonNull DocumentDataSource<?, ?> documentDataSource) {
        DocumentRepository<?, ?> documentRepository = documentDataSource.getDocumentRepository();
        if (checkSavedFile(TAG, documentRepository) && documentRepository.isOldNote()) {
            if (documentDataSource.isLocked()) {
                DocumentLockResolver.lock(this.mContext, getUuid());
            }
            BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
            if (companion.isWidgetNote(this.mContext, documentRepository.getOldUuid(), null)) {
                companion.notifyWidgetNoteConverted(this.mContext, documentRepository.getOldUuid(), getUuid());
            }
        }
    }

    private boolean saveDocument(DocumentDataSource<?, ?> documentDataSource) {
        SaveResult saveResultSave = documentDataSource.save(this.mContext);
        if (!saveResultSave.get()) {
            notifyFailure(TAG, saveResultSave.getException("Fail to save."));
        }
        return saveResultSave.get();
    }

    private boolean saveExtraData(DocumentDataSource<?, ?> documentDataSource) {
        if (!documentDataSource.isTagChanged() && !documentDataSource.isCoverChanged() && !documentDataSource.isStickyNoteChanged()) {
            return false;
        }
        String str = TAG;
        DataLogger.m12302d(str, "saveExtraData, only tag or cover has been changed");
        DocumentExtraDataUtils.save(this.mContext, documentDataSource, true);
        DocumentCacheUtils.deleteDocumentDat(this.mContext, getUuid());
        notifySuccess(str);
        return true;
    }

    private void saveOnlyDatabase(DocumentDataSource<?, ?> documentDataSource) {
        if (documentDataSource.isContentEmpty()) {
            if (saveExtraData(documentDataSource)) {
                return;
            }
            notifyFailure(TAG, new RuntimeException("Fail to save - content is empty"));
        } else if (!documentDataSource.isEntityChanged()) {
            if (saveExtraData(documentDataSource)) {
                return;
            }
            notifyFailure(TAG, new RuntimeException("Fail to save - entity is not changed"));
        } else {
            if (!documentDataSource.saveToDatabase(this.mContext, false)) {
                notifyFailure(TAG, new RuntimeException("Fail to save database"));
                return;
            }
            String str = TAG;
            DataLogger.m12302d(str, "save, database entity was changed.");
            DocumentExtraDataUtils.save(this.mContext, documentDataSource, true);
            DocumentCacheUtils.deleteDocumentDat(this.mContext, getUuid());
            RequestToSyncManager.INSTANCE.requestSyncByModification();
            notifySuccess(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.SAVE;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            try {
                String str = TAG;
                DataLogger.m12308p(str, "save document task - start");
                DocumentDataSource<?, ?> documentDataSource = this.mTarget;
                if (isAlreadyClosed(documentDataSource)) {
                    DataLogger.m12308p(str, "save document task - end");
                    return;
                }
                if (documentDataSource.getWritingMode() == 0) {
                    boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(getUuid());
                    boolean zIsNew = documentDataSource.isNew();
                    boolean z = true;
                    boolean z2 = zIsCoeditUuid && zIsNew;
                    boolean zIsContentEmpty = documentDataSource.isContentEmpty();
                    boolean zIsChangedOnlyThumbnail = documentDataSource.isChangedOnlyThumbnail();
                    boolean zIsEntityChanged = documentDataSource.isEntityChanged();
                    boolean zIsDiscarded = documentDataSource.isDiscarded();
                    if (documentDataSource.isContentChanged() || documentDataSource.getDoc().hasSnapSavedData()) {
                        if (zIsDiscarded) {
                            z = false;
                        }
                        DataLogger.m12305f(str, "save, isNewDocument : " + zIsNew + ", isContentEmpty : " + zIsContentEmpty + ", isContentChanged : " + z + ", isChangedOnlyThumbnail : " + zIsChangedOnlyThumbnail + ", isReservedDiscard : " + zIsDiscarded + ", isEntityChanged : " + zIsEntityChanged + ", isCoEditNote : " + zIsCoeditUuid);
                        if (!z2 && !z) {
                            DataLogger.m12302d(str, "save, no need to save document.");
                            saveOnlyDatabase(documentDataSource);
                            DataLogger.m12308p(str, "save document task - end");
                            return;
                        } else if (!saveDocument(documentDataSource)) {
                            DataLogger.m12308p(str, "save document task - end");
                            return;
                        } else {
                            DocumentExtraDataUtils.save(this.mContext, documentDataSource, false);
                            DocumentCacheUtils.deleteDocumentDat(this.mContext, getUuid());
                        }
                    }
                } else if (!saveDocument(documentDataSource)) {
                    DataLogger.m12308p(str, "save document task - end");
                    return;
                }
                onPostSaved(documentDataSource);
                notifySuccess(str);
                DataLogger.m12308p(str, "save document task - end");
            } catch (Exception e) {
                String str2 = TAG;
                DataLogger.m12304e(str2, "run failed, e : ", e);
                notifyFailure(str2, e);
                DataLogger.m12308p(str2, "save document task - end");
            }
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "save document task - end");
            throw th;
        }
    }

    public SaveDocumentTask taskListener(BaseSaveDocumentTask.SaveTaskCallback saveTaskCallback) {
        setTaskCallback(saveTaskCallback);
        return this;
    }

    public SaveDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
