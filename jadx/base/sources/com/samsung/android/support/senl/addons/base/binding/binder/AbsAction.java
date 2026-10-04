package com.samsung.android.support.senl.addons.base.binding.binder;

import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "mTypeId", "", "mBindId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mResult", "", "getId", "getBindId", "setResult", "", "result", "getResult", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsAction implements IBaseViewModel.Action {

    @Nullable
    private final String mBindId;

    @Nullable
    private Object mResult;

    @Nullable
    private final String mTypeId;

    public AbsAction(@Nullable String str, @Nullable String str2) {
        this.mTypeId = str;
        this.mBindId = str2;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
    @Nullable
    /* JADX INFO: renamed from: getBindId, reason: from getter */
    public String getMBindId() {
        return this.mBindId;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
    @Nullable
    /* JADX INFO: renamed from: getId, reason: from getter */
    public String getMTypeId() {
        return this.mTypeId;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
    @Nullable
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Object getMResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
    public void setResult(@NotNull Object result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.mResult = result;
    }
}
