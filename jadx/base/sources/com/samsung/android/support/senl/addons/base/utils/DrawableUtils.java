package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.addons.C7944R;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/DrawableUtils;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_CIRCLE", "TYPE_RECTANGLE", "setRippleSelected", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "type", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DrawableUtils {
    public static final int TYPE_NONE = 0;

    @NotNull
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    @JvmField
    public static final int TYPE_CIRCLE = C7944R.drawable.base_ripple_circle_pressed;

    @JvmField
    public static final int TYPE_RECTANGLE = C7944R.drawable.base_ripple_rect_pressed;

    private DrawableUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Drawable setRippleSelected(@NotNull Context context, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (type == 0) {
            return null;
        }
        return ResourcesCompat.getDrawable(context.getResources(), type, context.getTheme());
    }
}
