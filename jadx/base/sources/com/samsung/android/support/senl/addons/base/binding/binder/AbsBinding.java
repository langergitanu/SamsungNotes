package com.samsung.android.support.senl.addons.base.binding.binder;

import android.view.View;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0017\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0002\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "T", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "<init>", "()V", "mViewId", "", "mViewKey", "mViewModelId", "", "mBindId", "mVMHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "mExecuteType", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "setExecuteType", "executeType", "getViewKey", "getViewModelId", "getBindId", "getExecuteType", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewModel", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "getViewModel", "()Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "getData", "id", "(Ljava/lang/String;)Ljava/lang/Object;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBinding<T> implements IBinding {

    @Nullable
    private String mBindId;
    private int mExecuteType;

    @Nullable
    private IViewModelHolder mVMHolder;
    private int mViewId;
    private int mViewKey;

    @Nullable
    private String mViewModelId;

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    @Nullable
    /* JADX INFO: renamed from: getBindId, reason: from getter */
    public String getMBindId() {
        return this.mBindId;
    }

    @Nullable
    public T getData(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        IBaseViewModel viewModel = getViewModel();
        if (viewModel != null) {
            return (T) viewModel.getData(id);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    /* JADX INFO: renamed from: getExecuteType, reason: from getter */
    public int getMExecuteType() {
        return this.mExecuteType;
    }

    @Nullable
    public final View getView() {
        IViewModelHolder iViewModelHolder = this.mVMHolder;
        if (iViewModelHolder != null) {
            return iViewModelHolder.getView(this.mViewKey);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    /* JADX INFO: renamed from: getViewKey, reason: from getter */
    public int getMViewKey() {
        return this.mViewKey;
    }

    @Nullable
    public final IBaseViewModel getViewModel() {
        IViewModelHolder iViewModelHolder = this.mVMHolder;
        if (iViewModelHolder != null) {
            return iViewModelHolder.getViewModel(this.mViewModelId);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    @Nullable
    /* JADX INFO: renamed from: getViewModelId, reason: from getter */
    public String getMViewModelId() {
        return this.mViewModelId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    public void setExecuteType(int executeType) {
        this.mExecuteType = executeType;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
        Intrinsics.checkNotNullParameter(bind, "bind");
        this.mViewId = bind.getMViewId();
        this.mViewKey = bind.getMViewKey();
        this.mViewModelId = bind.getMViewModelId();
        this.mBindId = bind.getMBindingId();
        this.mVMHolder = vmHolder;
    }
}
