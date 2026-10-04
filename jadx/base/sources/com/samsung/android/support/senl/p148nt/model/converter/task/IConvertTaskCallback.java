package com.samsung.android.support.senl.p148nt.model.converter.task;

import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IConvertTaskCallback {
    void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult);

    void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult);
}
