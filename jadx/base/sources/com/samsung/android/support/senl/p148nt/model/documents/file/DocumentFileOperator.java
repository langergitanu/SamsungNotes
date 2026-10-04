package com.samsung.android.support.senl.p148nt.model.documents.file;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DocumentFileOperator {
    private static final String TAG = ModelLogger.createTag("DocumentFileOperator");
    private final String mFilePath;
    private final Object mLock = new Object();
    private final Map<Long, OperationInfo> mOperations = new ConcurrentHashMap();

    @Nullable
    private OperationInfo mProgressingInfo = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OperationInfo {
        private final DocumentFileOperation mOperation;
        private final String mThreadName;

        public OperationInfo(String str, DocumentFileOperation documentFileOperation) {
            this.mThreadName = str;
            this.mOperation = documentFileOperation;
        }

        @NonNull
        public String toString() {
            return "Name: " + this.mThreadName + ", op: " + this.mOperation;
        }
    }

    public DocumentFileOperator(String str) {
        this.mFilePath = str;
    }

    public void addOperation(DocumentFileOperation documentFileOperation) {
        Thread threadCurrentThread = Thread.currentThread();
        this.mOperations.put(Long.valueOf(threadCurrentThread.getId()), new OperationInfo(threadCurrentThread.getName(), documentFileOperation));
    }

    public Object getLock() {
        return this.mLock;
    }

    public boolean isIdle() {
        return this.mProgressingInfo == null && this.mOperations.isEmpty();
    }

    public void onEnd() {
        DataLogger.m12302d(TAG, "onEnd, p: " + Logger.getEncode(this.mFilePath) + ", info: " + this.mProgressingInfo);
        this.mProgressingInfo = null;
    }

    public void onStart() {
        this.mProgressingInfo = this.mOperations.remove(Long.valueOf(Thread.currentThread().getId()));
        DataLogger.m12302d(TAG, "onStart, p: " + Logger.getEncode(this.mFilePath) + ", info: " + this.mProgressingInfo);
    }
}
