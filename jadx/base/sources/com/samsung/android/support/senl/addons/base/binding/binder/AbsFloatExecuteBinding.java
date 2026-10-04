package com.samsung.android.support.senl.addons.base.binding.binder;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsFloatExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "", "<init>", "()V", "convertStringToData", "data", "", "(Ljava/lang/String;)Ljava/lang/Float;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsFloatExecuteBinding extends AbsExecuteBinding<Float> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
    @Nullable
    public Float convertStringToData(@Nullable String data) {
        return Float.valueOf(String.valueOf(data));
    }
}
