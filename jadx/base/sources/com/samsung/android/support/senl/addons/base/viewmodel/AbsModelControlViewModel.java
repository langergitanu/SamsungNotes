package com.samsung.android.support.senl.addons.base.viewmodel;

import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mFacade", "getMFacade", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "setMFacade", "mPropertyChangedCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getMPropertyChangedCallback", "()Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "setMPropertyChangedCallback", "(Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;)V", "onPropertyChanged", "", "propertyId", "", "(Ljava/lang/Integer;)V", "clearModels", "closeCallbacks", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsModelControlViewModel extends AbsBaseViewModel {

    @Nullable
    private IFacade mFacade;

    @Nullable
    private IBaseModel.Observer mPropertyChangedCallback;

    public AbsModelControlViewModel(@Nullable IFacade iFacade) {
        this.mFacade = iFacade;
        IBaseModel.Observer observer = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel$mPropertyChangedCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                if (info == null) {
                    return;
                }
                this.this$0.onPropertyChanged(info.getId());
            }
        };
        this.mPropertyChangedCallback = observer;
        IFacade iFacade2 = this.mFacade;
        if (iFacade2 != null) {
            Intrinsics.checkNotNull(observer);
            iFacade2.addObserver(observer);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        IFacade iFacade = this.mFacade;
        if (iFacade == null || this.mPropertyChangedCallback == null) {
            return;
        }
        Intrinsics.checkNotNull(iFacade);
        IBaseModel.Observer observer = this.mPropertyChangedCallback;
        Intrinsics.checkNotNull(observer);
        iFacade.removeObserver(observer);
        this.mFacade = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mPropertyChangedCallback = null;
    }

    @Nullable
    public final IFacade getMFacade() {
        return this.mFacade;
    }

    @Nullable
    public final IBaseModel.Observer getMPropertyChangedCallback() {
        return this.mPropertyChangedCallback;
    }

    public void onPropertyChanged(@Nullable Integer propertyId) {
    }

    public final void setMFacade(@Nullable IFacade iFacade) {
        this.mFacade = iFacade;
    }

    public final void setMPropertyChangedCallback(@Nullable IBaseModel.Observer observer) {
        this.mPropertyChangedCallback = observer;
    }
}
