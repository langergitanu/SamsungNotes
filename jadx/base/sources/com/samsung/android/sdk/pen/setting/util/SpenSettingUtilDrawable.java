package com.samsung.android.sdk.pen.setting.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0007J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0007J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0007J8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0007J&\u0010\u0019\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilDrawable;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SUPPORT_FOREGROUND", "", "setRoundedCornerBackground", "", "view", "Landroid/view/View;", "radius", "", "bgColor", "strokeSize", "strokeColor", "getRoundedCornerDrawable", "Landroid/graphics/drawable/Drawable;", "getRoundedRectDrawable", "topLeftRadius", "", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "setForeground", "foreground", "colorStateList", "Landroid/content/res/ColorStateList;", "getDrawable", "context", "Landroid/content/Context;", "id", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilDrawable {

    @NotNull
    public static final SpenSettingUtilDrawable INSTANCE = new SpenSettingUtilDrawable();
    private static final boolean SUPPORT_FOREGROUND = true;

    @NotNull
    private static final String TAG = "SpenSettingUtilDrawable";

    private SpenSettingUtilDrawable() {
    }

    @JvmStatic
    @Nullable
    public static final Drawable getDrawable(@Nullable Context context, int id) {
        if (context == null) {
            return null;
        }
        return ResourcesCompat.getDrawable(context.getResources(), id, null);
    }

    @JvmStatic
    @NotNull
    public static final Drawable getRoundedCornerDrawable(int radius, int bgColor, int strokeSize, int strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(bgColor);
        if (strokeSize > 0) {
            gradientDrawable.setStroke(strokeSize, strokeColor);
        }
        return gradientDrawable;
    }

    @JvmStatic
    @NotNull
    public static final Drawable getRoundedRectDrawable(float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        float[] fArr = {topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    @JvmStatic
    public static final void setForeground(@Nullable View view, @Nullable Drawable foreground, @Nullable ColorStateList colorStateList) {
        if (view != null && SUPPORT_FOREGROUND) {
            view.setForeground(foreground);
            view.setForegroundTintList(colorStateList);
        }
    }

    @JvmStatic
    public static final void setRoundedCornerBackground(@Nullable View view, int radius, int bgColor, int strokeSize, int strokeColor) {
        if (view == null) {
            return;
        }
        if (!SUPPORT_FOREGROUND) {
            view.setBackground(getRoundedCornerDrawable(radius, bgColor, strokeSize, strokeColor));
        } else {
            view.setBackground(getRoundedCornerDrawable(radius, bgColor, 0, 0));
            view.setForeground(getRoundedCornerDrawable(radius, 0, strokeSize, strokeColor));
        }
    }

    @JvmStatic
    @NotNull
    public static final Drawable getRoundedRectDrawable(float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius, int strokeSize, int strokeColor) {
        Drawable roundedRectDrawable = getRoundedRectDrawable(topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
        Intrinsics.checkNotNull(roundedRectDrawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) roundedRectDrawable;
        gradientDrawable.setStroke(strokeSize, strokeColor);
        return gradientDrawable;
    }
}
