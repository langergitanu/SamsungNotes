package com.samsung.android.support.senl.p148nt.model.converter.task.service.listener;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IServiceRequestor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IServiceListener {
        void onFailed(int i, ServiceMsg serviceMsg);

        void onSuccess(int i, ServiceMsg serviceMsg);
    }

    void convertDocument(@NonNull IConvertInfo iConvertInfo, List<String> list, IServiceListener iServiceListener);
}
