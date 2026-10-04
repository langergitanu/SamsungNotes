package com.samsung.android.support.senl.addons.base.model.save;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/save/AbsSaveModel;", "T", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/ISDocSaveModel;", "<init>", "()V", "mProcessListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/ISDocSaveModel$OnProcessListener;", "setOnProcessListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCompleteAllProcess", "isSave", "", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSaveModel<T> extends AbsBaseModel implements ISDocSaveModel<T> {

    @Nullable
    private ISDocSaveModel.OnProcessListener mProcessListener;

    public void close() {
        this.mProcessListener = null;
    }

    public void onCompleteAllProcess(boolean isSave) {
        ISDocSaveModel.OnProcessListener onProcessListener = this.mProcessListener;
        if (onProcessListener != null) {
            onProcessListener.onCompleteAllProcess(isSave);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel
    public void setOnProcessListener(@Nullable ISDocSaveModel.OnProcessListener listener) {
        this.mProcessListener = listener;
    }
}
