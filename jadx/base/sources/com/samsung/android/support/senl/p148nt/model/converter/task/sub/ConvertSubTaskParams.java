package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertSubTaskParams implements IConvertSubTask.IConvertParams {
    private final boolean mIsSrcFileStoredInDB;
    private final List<String> mPathList;

    public ConvertSubTaskParams(@Nullable List<String> list, boolean z) {
        this.mPathList = list == null ? new ArrayList<>() : list;
        this.mIsSrcFileStoredInDB = z;
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.sub.IConvertSubTask.IConvertParams
    public List<String> getPathList() {
        return this.mPathList;
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.sub.IConvertSubTask.IConvertParams
    public boolean isSrcFileStoredInDB() {
        return this.mIsSrcFileStoredInDB;
    }
}
