package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.constants.ModelConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.task.exceptions.AccountGuidNotMatchedException;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DocumentTask implements Runnable {
    private static final String TAG = ModelLogger.createTag("DocumentTask");
    protected CacheStrategy mCacheStrategy;
    protected DocumentCompletionListener mCallback;
    protected Context mContext;
    protected Handler mHandler;
    protected DocumentDataSource<?, ?> mTarget;
    protected DocumentSubscriptionId mUser;
    protected String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CacheStrategy {
        CACHE_NONE,
        CACHE_MEMORY
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TaskCallback {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Type {
        NONE,
        CLOSE,
        DISCARD_CACHE,
        LOAD_CACHE,
        LOAD,
        RELOAD,
        SAVE_CACHE,
        SAVE,
        SNAP_SAVE
    }

    public DocumentTask(@NonNull Context context) {
        this(context, null);
    }

    public DocumentTask cacheStrategy(CacheStrategy cacheStrategy) {
        this.mCacheStrategy = cacheStrategy;
        return this;
    }

    @Nullable
    public DocumentCompletionListener callback() {
        return this.mCallback;
    }

    @WorkerThread
    public void fail(String str, Throwable th, String str2) {
        if (th == null || !ModelConstants.ERROR_MSG_DOCUMENT_CACHE_NOT_EXIST.equals(th.getMessage())) {
            AbstractC0000a.m2C("fail, uuid : ", str2, TAG.concat("$" + str));
        }
        DocumentCompletionListener documentCompletionListener = this.mCallback;
        if (documentCompletionListener != null) {
            documentCompletionListener.failed(th, str2);
        }
    }

    public CacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    public abstract Type getType();

    public DocumentSubscriptionId getUser() {
        DataLogger.m12302d(TAG, "getUser : " + this.mUser);
        return this.mUser;
    }

    public String getUuid() {
        DataLogger.m12302d(TAG, "getUuid : " + this.mUuid);
        return this.mUuid;
    }

    public DocumentTask listener(@Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener) {
        this.mCallback = documentCompletionListener;
        return this;
    }

    @WorkerThread
    public void success(String str, DocumentDataSource<?, ?> documentDataSource, String str2) {
        AbstractC0000a.m2C("success, uuid : ", str2, TAG.concat("$" + str));
        DocumentCompletionListener documentCompletionListener = this.mCallback;
        if (documentCompletionListener != null) {
            documentCompletionListener.completed(documentDataSource, str2);
        }
    }

    public DocumentTask target(@NonNull DocumentDataSource<?, ?> documentDataSource) {
        this.mTarget = documentDataSource;
        return this;
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + "{mUser=" + this.mUser + ", mCacheStrategy=" + this.mCacheStrategy + ", mUuid='" + this.mUuid + "', mTarget=" + this.mTarget + '}';
    }

    public DocumentTask user(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        this.mUser = documentSubscriptionId;
        return this;
    }

    public DocumentTask uuid(@NonNull String str) {
        this.mUuid = str;
        return this;
    }

    public boolean verifyLockAccountGuid(@NonNull ISpenDocument iSpenDocument, @Nullable String str) throws AccountGuidNotMatchedException {
        String ownerId = iSpenDocument.getOwnerId();
        if (ownerId != null) {
            ownerId = ownerId.toUpperCase();
        }
        boolean zEquals = HashUtils.getEmptyHashedString().equals(ownerId);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("verifyLockAccountGuid, isLocked : ");
        sb.append(iSpenDocument.isLocked());
        sb.append(", documentAccountGuid : ");
        sb.append(DataLogger.pii(zEquals ? "" : ownerId));
        sb.append(", requestAccountGuid : ");
        sb.append(DataLogger.pii(str));
        DataLogger.m12307i(str2, sb.toString());
        if (!iSpenDocument.isLocked() || DocumentServiceConstants.LockGuid.FROM_SHARED_NOTES_GUID.equals(str) || zEquals || Objects.equals(ownerId, str)) {
            return true;
        }
        throw new AccountGuidNotMatchedException(ownerId, str);
    }

    public DocumentTask(@NonNull Context context, @Nullable Handler handler) {
        this.mCacheStrategy = CacheStrategy.CACHE_MEMORY;
        this.mContext = context;
        this.mHandler = handler;
        if (handler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }
}
