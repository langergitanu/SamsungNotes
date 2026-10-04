package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskResult implements IConvertResult {
    private final int mDstType;

    @Nullable
    private List<String> mPathList;
    private final int mSrcType;
    private int mState = 0;
    private List<String> mUuidList;

    public ConvertTaskResult(int i, int i2) {
        this.mSrcType = i;
        this.mDstType = i2;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getDstType() {
        return this.mDstType;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getFailedCount() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    @Nullable
    public List<String> getPathList() {
        return this.mPathList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getProgressCount() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getSrcType() {
        return this.mSrcType;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getState() {
        return this.mState;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getStorageFailedCount() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getSuccessCount() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getTotalCount() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public String getUuid() {
        return this.mUuidList.isEmpty() ? "" : this.mUuidList.get(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public List<String> getUuidList() {
        return this.mUuidList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public boolean hasMultipleUuids() {
        List<String> list = this.mUuidList;
        return list != null && list.size() > 1;
    }

    public ConvertTaskResult setPathList(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            this.mState = 1;
            return this;
        }
        if (TextUtils.isEmpty(list.get(0))) {
            this.mState = 2;
            return this;
        }
        this.mPathList = list;
        return this;
    }

    public ConvertTaskResult setState(int i) {
        this.mState = i;
        return this;
    }

    public ConvertTaskResult setUuidList(List<String> list) {
        if (this.mState == 0 && (list == null || list.isEmpty())) {
            this.mState = 1;
            return this;
        }
        this.mUuidList = list;
        return this;
    }

    @NonNull
    public String toString() {
        return "dstType : " + this.mDstType + ", path : " + this.mPathList + " / uuid : " + this.mUuidList;
    }
}
