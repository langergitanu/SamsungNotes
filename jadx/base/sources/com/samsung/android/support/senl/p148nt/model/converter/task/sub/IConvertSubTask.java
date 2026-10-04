package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertType;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IConvertSubTask extends Runnable, IConvertType {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IConvertParams {
        List<String> getPathList();

        boolean isSrcFileStoredInDB();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISubTaskCallback {
        void onPostConvert(IConvertResult iConvertResult);

        void onPreConvert(IConvertResult iConvertResult);
    }

    void setParams(IConvertParams iConvertParams);

    @NonNull
    String toString();
}
