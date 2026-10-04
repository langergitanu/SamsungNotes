package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseSaveDocumentTask extends DocumentTask {
    protected SaveTaskCallback mSaveTaskCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SaveTaskCallback extends DocumentTask.TaskCallback {
        @WorkerThread
        void onEnd(@NonNull String str);
    }

    public BaseSaveDocumentTask(@NonNull Context context) {
        super(context);
    }

    public boolean checkSavedFile(@NonNull String str, @NonNull DocumentRepository<?, ?> documentRepository) {
        String savePath = documentRepository.getSavePath();
        if (!AbstractC2322a.m1607A(savePath)) {
            DataLogger.m12305f(str, "checkSavedFile, document has been saved, but does not exist: " + DataLogger.getEncode(savePath));
            return false;
        }
        if (SpenWNoteFile.isValid(savePath)) {
            return true;
        }
        DataLogger.m12305f(str, "checkSavedFile, document was saved but, invalid" + DataLogger.getEncode(savePath));
        return false;
    }

    public void notifyFailure(String str, Exception exc) {
        notifyTaskEndCallback();
        fail(str, exc, getUuid());
    }

    public void notifySuccess(String str) {
        notifyTaskEndCallback();
        success(str, this.mTarget, getUuid());
    }

    public void notifyTaskEndCallback() {
        SaveTaskCallback saveTaskCallback = this.mSaveTaskCallback;
        if (saveTaskCallback != null) {
            saveTaskCallback.onEnd(getUuid());
        }
    }

    public void setTaskCallback(SaveTaskCallback saveTaskCallback) {
        this.mSaveTaskCallback = saveTaskCallback;
    }

    public BaseSaveDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
