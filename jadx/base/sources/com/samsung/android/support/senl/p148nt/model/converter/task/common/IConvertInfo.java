package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IConvertInfo extends IConvertItem {
    public static final int GROUP_ID_NONE = -1;

    int getCallerId();

    @Nullable
    ISDocXConverter getConverter();

    String getDstFilePrefix();

    String getDstPath();

    int getDstType();

    String getDstUuid();

    String getFolderName();

    int getGroupId();

    boolean getIsAuthenticated();

    boolean getIsWidgetMemo();

    int getLockType();

    long getReqFileSize();

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    String getSrcPath();

    int getSrcType();

    String getUuid();

    boolean isImported();

    boolean isIndividualPage();

    ConvertInfo setConverter(@Nullable ISDocXConverter iSDocXConverter);

    ConvertInfo setDstFilePrefix(String str);

    ConvertInfo setDstPath(String str);

    ConvertInfo setDstType(int i);

    ConvertInfo setDstUuid(String str);

    ConvertInfo setFolderName(String str);

    ConvertInfo setIsAuthenticated(boolean z);

    ConvertInfo setIsIndividualPage(boolean z);

    ConvertInfo setIsWidgetMemo(boolean z);

    ConvertInfo setIsWrappingWhenLocked(boolean z);

    ConvertInfo setLockType(int i);

    ConvertInfo setReqFileSize(long j);

    ConvertInfo setSrcType(int i);

    ConvertInfo setWriteMode(int i);
}
