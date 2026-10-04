package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertStatus;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IConvertResult extends IConvertStatus {
    int getDstType();

    int getFailedCount();

    @Nullable
    List<String> getPathList();

    int getProgressCount();

    int getSrcType();

    int getState();

    int getStorageFailedCount();

    int getSuccessCount();

    int getTotalCount();

    String getUuid();

    List<String> getUuidList();

    boolean hasMultipleUuids();
}
