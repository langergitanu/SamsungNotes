package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskGroupResult implements IConvertResult {
    private final CountInfo mCountInfo;
    private final IConvertResult mResult;

    public ConvertTaskGroupResult(@NonNull IConvertResult iConvertResult, @NonNull CountInfo countInfo) {
        this.mResult = iConvertResult;
        this.mCountInfo = countInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getDstType() {
        return this.mResult.getDstType();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getFailedCount() {
        return this.mCountInfo.getFailedCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    @Nullable
    public List<String> getPathList() {
        return this.mResult.getPathList();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getProgressCount() {
        return this.mCountInfo.getProgressCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getSrcType() {
        return this.mResult.getSrcType();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getState() {
        return this.mResult.getState();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getStorageFailedCount() {
        return this.mCountInfo.getStorageFailedCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getSuccessCount() {
        return this.mCountInfo.getSuccessCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public int getTotalCount() {
        return this.mCountInfo.getTotalCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public String getUuid() {
        return this.mResult.getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public List<String> getUuidList() {
        return this.mResult.getUuidList();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult
    public boolean hasMultipleUuids() {
        return this.mResult.hasMultipleUuids();
    }
}
