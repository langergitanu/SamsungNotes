package com.samsung.android.support.senl.p148nt.model.collector.common;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectParam implements Serializable {
    private static final String TAG = CollectLogger.createTag("CollectParam");
    private int mActionType;
    private final AtomicInteger mCancelType;
    private List<String> mChangedPageIdList;
    private boolean mInReadyState;
    private boolean mIsNewNote;
    private long mLastModifiedAt;
    private int mLinkWith;
    private INoteJob.INoteJobFinishCallback mNoteJobFinishCallback;
    private Class<?> mPdfActionCaller;
    private String mPdfActionKey;
    private int mPriority;
    private int mSourceType;
    private int mTriggerType;
    private String mUUid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CollectParamBuilder {
        private static final int TRANSACTION_MAX_BYTE_SIZE = 1000000;
        private final CollectParam mCollectParam = new CollectParam(0);

        private void adjustTransactionSize() {
            List<String> changedPageIdList = this.mCollectParam.getChangedPageIdList();
            if (changedPageIdList.isEmpty()) {
                return;
            }
            int size = changedPageIdList.size() * changedPageIdList.get(0).getBytes(StandardCharsets.UTF_8).length;
            if (size > 1000000) {
                DataLogger.m12302d(CollectParam.TAG, "adjustTransactionSize# " + size);
                this.mCollectParam.setChangedPageIdList(null);
                this.mCollectParam.setSourceType(ICollectParam.SourceType.OTHERS.getValue());
            }
        }

        public CollectParam build() {
            adjustTransactionSize();
            return this.mCollectParam;
        }

        public CollectParamBuilder setActionType(int i) {
            this.mCollectParam.setActionType(i);
            return this;
        }

        public CollectParamBuilder setCancelType(int i) {
            this.mCollectParam.setCancelType(i);
            return this;
        }

        public CollectParamBuilder setChangedPageIdList(List<String> list) {
            this.mCollectParam.setChangedPageIdList(list);
            return this;
        }

        public CollectParamBuilder setInReadyState(boolean z) {
            this.mCollectParam.setInReadyState(z);
            return this;
        }

        public CollectParamBuilder setIsNewNote(boolean z) {
            this.mCollectParam.setIsNewNote(z);
            return this;
        }

        public CollectParamBuilder setLastModifiedAt(long j) {
            this.mCollectParam.setLastModifiedAt(j);
            return this;
        }

        public CollectParamBuilder setLinkWith(int i) {
            this.mCollectParam.setLinkWith(i);
            return this;
        }

        public CollectParamBuilder setNoteJobFinishCallback(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
            this.mCollectParam.setNoteJobFinishCallback(iNoteJobFinishCallback);
            return this;
        }

        public CollectParamBuilder setPdfActionCaller(Class<?> cls) {
            this.mCollectParam.setPdfActionCaller(cls);
            return this;
        }

        public CollectParamBuilder setPdfActionKey(String str) {
            this.mCollectParam.setPdfActionKey(str);
            return this;
        }

        public CollectParamBuilder setPriority(int i) {
            this.mCollectParam.setPriority(i);
            return this;
        }

        public CollectParamBuilder setSourceType(int i) {
            this.mCollectParam.setSourceType(i);
            return this;
        }

        public CollectParamBuilder setTriggerType(int i) {
            this.mCollectParam.setTriggerType(i);
            return this;
        }

        public CollectParamBuilder setUuid(String str) {
            this.mCollectParam.setUuid(str);
            return this;
        }
    }

    public /* synthetic */ CollectParam(int i) {
        this();
    }

    public int getActionType() {
        return this.mActionType;
    }

    public int getCancelType() {
        return this.mCancelType.get();
    }

    @NonNull
    public List<String> getChangedPageIdList() {
        List<String> list = this.mChangedPageIdList;
        return list == null ? new ArrayList() : list;
    }

    public boolean getInReadyState() {
        return this.mInReadyState;
    }

    public boolean getIsNewNote() {
        return this.mIsNewNote;
    }

    public long getLastModifiedAt() {
        return this.mLastModifiedAt;
    }

    public int getLinkWith() {
        return this.mLinkWith;
    }

    public INoteJob.INoteJobFinishCallback getNoteJobFinishCallback() {
        return this.mNoteJobFinishCallback;
    }

    public Class<?> getPdfActionCaller() {
        return this.mPdfActionCaller;
    }

    public String getPdfActionKey() {
        return this.mPdfActionKey;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getSourceType() {
        return this.mSourceType;
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public String getUuid() {
        return this.mUUid;
    }

    public void setActionType(int i) {
        this.mActionType = i;
    }

    public void setCancelType(int i) {
        this.mCancelType.set(i);
    }

    public void setChangedPageIdList(List<String> list) {
        this.mChangedPageIdList = list;
    }

    public void setInReadyState(boolean z) {
        this.mInReadyState = z;
    }

    public void setIsNewNote(boolean z) {
        this.mIsNewNote = z;
    }

    public void setLastModifiedAt(long j) {
        this.mLastModifiedAt = j;
    }

    public void setLinkWith(int i) {
        this.mLinkWith = i;
    }

    public void setNoteJobFinishCallback(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        this.mNoteJobFinishCallback = iNoteJobFinishCallback;
    }

    public void setPdfActionCaller(Class<?> cls) {
        this.mPdfActionCaller = cls;
    }

    public void setPdfActionKey(String str) {
        this.mPdfActionKey = str;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setSourceType(int i) {
        this.mSourceType = i;
    }

    public void setTriggerType(int i) {
        this.mTriggerType = i;
    }

    public void setUuid(String str) {
        this.mUUid = str;
    }

    @NonNull
    public String toString() {
        return getActionType() + ", uuid  " + getUuid();
    }

    private CollectParam() {
        this.mTriggerType = ICollectParam.TriggerType.SAVE.getValue();
        this.mActionType = ICollectParam.ActionType.START.getValue();
        this.mSourceType = ICollectParam.SourceType.COMPOSER.getValue();
        this.mCancelType = new AtomicInteger(ICollectParam.CancelType.SAVE.getValue());
        this.mPriority = ICollectParam.Priority.FOREGROUND.getValue();
        this.mIsNewNote = false;
        this.mLinkWith = ICollectParam.LinkWith.DEFAULT.getValue();
        this.mInReadyState = false;
    }
}
