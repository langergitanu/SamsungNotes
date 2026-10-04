package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReloadDocumentTask extends DocumentTask {
    private static final String TAG = ModelLogger.createTag("ReloadDocumentTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static ReloadDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(ReloadDocumentTask.TAG, "build, documentDataSource : " + documentDataSource);
            return new ReloadDocumentTask(context, handler);
        }
    }

    public ReloadDocumentTask(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.RELOAD;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = TAG;
        DataLogger.m12302d(str, "running... target : " + this.mTarget);
        try {
            try {
                DataLogger.m12308p(str, "reload document task - start");
                DocumentDataSource<?, ?> documentDataSource = this.mTarget;
                DataLogger.m12303e(str, "run, reload doc.");
                documentDataSource.getDoc().reload();
                DocumentCacheUtils.deleteDocumentDat(this.mContext, getUuid());
                DataLogger.m12302d(str, "run, reload done.");
                success(str, documentDataSource, getUuid());
                DataLogger.m12308p(str, "reload document task - end");
            } catch (Exception e) {
                String str2 = TAG;
                DataLogger.m12303e(str2, "run failed, e : " + e.getMessage());
                fail(str2, e, getUuid());
                DataLogger.m12308p(str2, "reload document task - end");
            }
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "reload document task - end");
            throw th;
        }
    }

    public ReloadDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
