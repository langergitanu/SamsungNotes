package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.SaveResult;
import com.samsung.android.support.senl.p148nt.model.executor.task.BaseSaveDocumentTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SnapSaveDocumentTask extends BaseSaveDocumentTask {
    private static final String TAG = ModelLogger.createTag("SnapSaveDocumentTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static SnapSaveDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource<?, ?> documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(SnapSaveDocumentTask.TAG, "build, documentDataSource : " + documentDataSource);
            return new SnapSaveDocumentTask(context, handler);
        }
    }

    public SnapSaveDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.SNAP_SAVE;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String str = TAG;
                DataLogger.m12308p(str, "save cache document task - start");
                DocumentDataSource<?, ?> documentDataSource = this.mTarget;
                boolean zIsContentEmpty = documentDataSource.isContentEmpty();
                boolean zIsChangedOnlyThumbnail = documentDataSource.isChangedOnlyThumbnail();
                boolean zIsDiscarded = documentDataSource.isDiscarded();
                boolean z = documentDataSource.isContentChanged() && !zIsDiscarded;
                DataLogger.m12302d(str, "run, isContentEmpty: " + zIsContentEmpty + ", isContentChanged: " + z + ", isChangedOnlyThumbnail : " + zIsChangedOnlyThumbnail + ", isNew : " + documentDataSource.isNew() + ", isReservedDiscard : " + zIsDiscarded);
                if (!z) {
                    DataLogger.m12302d(str, "run, contents were not needed to save.");
                    notifyFailure(str, new IllegalStateException("This document is new and not changed."));
                    DataLogger.m12308p(str, "save cache document task - end");
                    return;
                }
                SaveResult saveResultSnapSave = documentDataSource.snapSave(this.mContext);
                if (!saveResultSnapSave.get()) {
                    notifyFailure(str, saveResultSnapSave.getException("Fail to snapSave."));
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

    public SnapSaveDocumentTask taskListener(BaseSaveDocumentTask.SaveTaskCallback saveTaskCallback) {
        setTaskCallback(saveTaskCallback);
        return this;
    }
}
