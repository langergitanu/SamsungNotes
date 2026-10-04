package com.samsung.android.support.senl.addons.base.binding.binder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsColorExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "convertStringToRes", "", "data", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsColorExecuteBinding extends AbsIntegerExecuteBinding {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
    @Nullable
    public Integer convertStringToRes(@Nullable String data) {
        Resources resources;
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        int resId = context == null ? 0 : AbsExecuteBinding.INSTANCE.getResId(context, "color", String.valueOf(data));
        if (resId == 0) {
            return 0;
        }
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return Integer.valueOf(resources.getColor(resId, context.getTheme()));
    }
}
