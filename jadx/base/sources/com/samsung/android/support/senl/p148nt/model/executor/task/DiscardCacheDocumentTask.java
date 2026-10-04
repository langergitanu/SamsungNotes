package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiscardCacheDocumentTask extends DocumentTask {
    private static final String TAG = ModelLogger.createTag("DiscardCacheDocumentTask");
    private DiscardTaskCallback mDiscardTaskCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static DiscardCacheDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(DiscardCacheDocumentTask.TAG, "build, document : " + documentDataSource);
            return new DiscardCacheDocumentTask(context, handler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DiscardTaskCallback extends DocumentTask.TaskCallback {
        @WorkerThread
        int getUsingDocReferenceCount(@NonNull String str);
    }

    public DiscardCacheDocumentTask(@NonNull Context context) {
        super(context);
    }

    private int getUsingDocReferenceCount(@NonNull String str) {
        DiscardTaskCallback discardTaskCallback = this.mDiscardTaskCallback;
        int usingDocReferenceCount = discardTaskCallback == null ? 0 : discardTaskCallback.getUsingDocReferenceCount(str);
        DataLogger.m12302d(TAG, "getUsingDocReferenceCount, uuid : " + str + ", count : " + usingDocReferenceCount);
        return usingDocReferenceCount;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.DISCARD_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = TAG;
            DataLogger.m12302d(str, "DiscardCacheDocumentTask$run");
            DocumentDataSource<?, ?> documentDataSource = this.mTarget;
            if (documentDataSource.getDoc() == null) {
                DataLogger.m12303e(str, "DiscardCacheDocumentTask$run, can not found in doc map.");
                fail(str, new IllegalStateException("can not found in doc map."), getUuid());
            } else if (documentDataSource.getDoc().isClosed()) {
                DataLogger.m12303e(str, "DiscardCacheDocumentTask$run, the doc was already closed.");
                fail(str, new IllegalStateException("the doc was already closed."), getUuid());
            } else if (getUsingDocReferenceCount(getUuid()) > 1) {
                DataLogger.m12303e(str, "DiscardCacheDocumentTask$run, other users were using document.");
            } else {
                documentDataSource.reserveDiscard(true);
                success(str, documentDataSource, getUuid());
            }
        } catch (Exception e) {
            String str2 = TAG;
            DataLogger.m12303e(str2, "runTask failed, e : " + e.getMessage());
            fail(str2, e, getUuid());
        }
    }

    public DocumentTask taskListener(@Nullable DiscardTaskCallback discardTaskCallback) {
        this.mDiscardTaskCallback = discardTaskCallback;
        return this;
    }

    public DiscardCacheDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
