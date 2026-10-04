package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewBackground;", "", "<init>", "()V", "setViewBackground", "", "view", "Landroid/view/View;", "drawable", "Landroid/graphics/drawable/Drawable;", "setViewBackgroundColor", "color", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "setViewBackgroundColorAlpha", "alpha", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewBackground {

    @NotNull
    public static final BAViewBackground INSTANCE = new BAViewBackground();

    private BAViewBackground() {
    }

    public final void setViewBackground(@Nullable View view, @Nullable Drawable drawable) {
        if (drawable == null || view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public final void setViewBackgroundColor(@NotNull View view, @Nullable Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (color != null) {
            view.setBackgroundColor(color.intValue());
        }
    }

    public final void setViewBackgroundColorAlpha(@Nullable View view, @Nullable Integer alpha) {
        Drawable background = view != null ? view.getBackground() : null;
        if (!(background instanceof ColorDrawable) || alpha == null) {
            return;
        }
        view.setBackgroundColor(ColorUtils.setAlphaComponent(((ColorDrawable) background).getColor(), alpha.intValue()));
    }
}
