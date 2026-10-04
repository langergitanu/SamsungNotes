package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.SaveResult;
import com.samsung.android.support.senl.p148nt.model.executor.task.BaseSaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.utils.DocumentExtraDataUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SaveCacheDocumentTask extends BaseSaveDocumentTask {
    private static final String TAG = ModelLogger.createTag("SaveCacheDocumentTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static SaveCacheDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource<?, ?> documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(SaveCacheDocumentTask.TAG, "build, documentDataSource : " + documentDataSource);
            return new SaveCacheDocumentTask(context, handler);
        }
    }

    public SaveCacheDocumentTask(@NonNull Context context) {
        super(context);
    }

    private boolean saveExtraData(DocumentDataSource<?, ?> documentDataSource) {
        if (!documentDataSource.isTagChanged() && !documentDataSource.isCoverChanged() && !documentDataSource.isStickyNoteChanged()) {
            return false;
        }
        DataLogger.m12302d(TAG, "saveExtraData, only tag or cover has been changed");
        DocumentExtraDataUtils.save(this.mContext, documentDataSource, true);
        return true;
    }

    private boolean saveOnlyDatabase(DocumentDataSource<?, ?> documentDataSource) {
        if (!documentDataSource.isEntityChanged()) {
            return saveExtraData(documentDataSource);
        }
        if (!documentDataSource.saveToDatabase(this.mContext, false)) {
            return false;
        }
        DataLogger.m12302d(TAG, "save, database entity was changed.");
        saveExtraData(documentDataSource);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.SAVE_CACHE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        try {
            try {
                String str = TAG;
                DataLogger.m12308p(str, "save cache document task - start");
                DocumentDataSource<?, ?> documentDataSource = this.mTarget;
                boolean zIsContentEmpty = documentDataSource.isContentEmpty();
                boolean zIsChangedOnlyThumbnail = documentDataSource.isChangedOnlyThumbnail();
                boolean zIsDiscarded = documentDataSource.isDiscarded();
                if (documentDataSource.isContentChanged() || documentDataSource.isSaveCache()) {
                    z = !zIsDiscarded;
                }
                DataLogger.m12302d(str, "run, isContentEmpty: " + zIsContentEmpty + ", isContentChanged: " + z + ", isChangedOnlyThumbnail : " + zIsChangedOnlyThumbnail + ", isNew : " + documentDataSource.isNew() + ", isReservedDiscard : " + zIsDiscarded + ", isTagChanged: " + documentDataSource.isTagChanged() + ", isCoverChanged: " + documentDataSource.isCoverChanged() + ", isStickyChanged: " + documentDataSource.isStickyNoteChanged());
                if (!z) {
                    if (saveOnlyDatabase(documentDataSource)) {
                        RequestToSyncManager.INSTANCE.requestSyncByModification();
                        notifySuccess(str);
                    } else {
                        DataLogger.m12302d(str, "run, contents were not needed to save.");
                        notifyFailure(str, new IllegalStateException("This document is new and not changed."));
                    }
                    DataLogger.m12308p(str, "save cache document task - end");
                    return;
                }
                SaveResult saveResultSaveCache = documentDataSource.saveCache(this.mContext);
                if (!saveResultSaveCache.get()) {
                    notifyFailure(str, saveResultSaveCache.getException("Fail to saveCache."));
                    DataLogger.m12308p(str, "save cache document task - end");
                } else {
                    checkSavedFile(str, documentDataSource.getDocumentRepository());
                    notifySuccess(str);
                    DataLogger.m12302d(str, "run, quickSave done");
                    DataLogger.m12308p(str, "save cache document task - end");
                }
            } catch (Exception e) {
                String str2 = TAG;
                DataLogger.m12304e(str2, "run failed, e : ", e);
                notifyFailure(str2, e);
                DataLogger.m12308p(str2, "save cache document task - end");
            }
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "save cache document task - end");
            throw th;
        }
    }

    public SaveCacheDocumentTask taskListener(BaseSaveDocumentTask.SaveTaskCallback saveTaskCallback) {
        setTaskCallback(saveTaskCallback);
        return this;
    }

    public SaveCacheDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
