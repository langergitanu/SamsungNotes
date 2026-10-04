package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.content.Context;
import android.view.View;
import com.samsung.android.support.senl.addons.base.utils.DrawableUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewRipple;", "", "<init>", "()V", "setBackgroundRipple", "", "view", "Landroid/view/View;", "type", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewRipple {

    @NotNull
    public static final BAViewRipple INSTANCE = new BAViewRipple();

    private BAViewRipple() {
    }

    public final void setBackgroundRipple(@NotNull View view, int type) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNull(context);
        view.setBackground(DrawableUtils.setRippleSelected(context, type));
    }
}
