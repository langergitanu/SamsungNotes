package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.oneui.OneUI;
import androidx.reflect.feature.SeslFloatingFeatureReflector;
import androidx.reflect.provider.SeslSettingsReflector;
import androidx.reflect.view.SeslSemBlurInfoReflector;
import androidx.reflect.view.SeslViewReflector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J)\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002JC\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010'JI\u0010(\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010+JI\u0010(\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u0010!\u001a\u00020\"H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Landroidx/core/view/SemBlurCompat;", "", "()V", "BLUR_BASE_OFFSET", "", "BLUR_BG_THIN_DARK", "BLUR_BG_THIN_LIGHT", "BLUR_MODE_CANVAS", "BLUR_MODE_WINDOW", "BLUR_MODE_WINDOW_CAPTURED", "BLUR_UI_HIGH_ULTRA_THICK_DARK", "BLUR_UI_HIGH_ULTRA_THICK_LIGHT", "BLUR_UI_LOW_ULTRA_THICK_DARK", "BLUR_UI_LOW_ULTRA_THICK_LIGHT", "BLUR_UI_MEDIUM_REGULAR_DARK", "BLUR_UI_MEDIUM_THICK_DARK", "BLUR_UI_MEDIUM_THICK_LIGHT", "BLUR_UI_MEDIUM_ULTRA_THICK_DARK", "BLUR_UI_MEDIUM_ULTRA_THICK_LIGHT", "CANVAS_BLUR_USE_TYPE_DYNAMIC", "CANVAS_BLUR_USE_TYPE_STATIC", "isBlurEffectPresetSupport", "", "isCanvasBlurSupport", "isNotBlurSupport", "context", "Landroid/content/Context;", "blurMode", "useTypeCanvasBlur", "(Landroid/content/Context;ILjava/lang/Integer;)Z", "isReduceTransparencySettingsEnabled", "isThemeApplied", "setBlurEffect", "view", "Landroid/view/View;", "color", "blurRadius", "cornerRadius", "", "(Landroid/view/View;IIIFLjava/lang/Integer;)Z", "setBlurEffectPreset", "curveParameter", "Landroidx/core/view/SemBlurCompat$CurveParameter;", "(Landroid/view/View;ILandroidx/core/view/SemBlurCompat$CurveParameter;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)Z", "colorCurvePreset", "(Landroid/view/View;IILjava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)Z", "setBlurInfoClear", "", "CurveParameter", "SeslBlurMode", "SeslUseTypeCanvasBlur", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemBlurCompat {
    private static final int BLUR_BASE_OFFSET = 101;
    public static final int BLUR_BG_THIN_DARK = 134;
    public static final int BLUR_BG_THIN_LIGHT = 131;
    public static final int BLUR_MODE_CANVAS = 2;
    public static final int BLUR_MODE_WINDOW = 0;
    public static final int BLUR_MODE_WINDOW_CAPTURED = 1;
    public static final int BLUR_UI_HIGH_ULTRA_THICK_DARK = 130;
    public static final int BLUR_UI_HIGH_ULTRA_THICK_LIGHT = 115;
    public static final int BLUR_UI_LOW_ULTRA_THICK_DARK = 120;
    public static final int BLUR_UI_LOW_ULTRA_THICK_LIGHT = 105;
    public static final int BLUR_UI_MEDIUM_REGULAR_DARK = 123;
    public static final int BLUR_UI_MEDIUM_THICK_DARK = 124;
    public static final int BLUR_UI_MEDIUM_THICK_LIGHT = 109;
    public static final int BLUR_UI_MEDIUM_ULTRA_THICK_DARK = 125;
    public static final int BLUR_UI_MEDIUM_ULTRA_THICK_LIGHT = 110;
    public static final int CANVAS_BLUR_USE_TYPE_DYNAMIC = 1;
    public static final int CANVAS_BLUR_USE_TYPE_STATIC = 0;

    @NotNull
    public static final SemBlurCompat INSTANCE = new SemBlurCompat();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, m13886d2 = {"Landroidx/core/view/SemBlurCompat$CurveParameter;", "", "blurRadius", "", "saturation", "", "curveLevel", "curveMinX", "curveMaxX", "curveMinY", "curveMaxY", "(IFFFFFF)V", "getBlurRadius", "()I", "getCurveLevel", "()F", "getCurveMaxX", "getCurveMaxY", "getCurveMinX", "getCurveMinY", "getSaturation", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class CurveParameter {
        private final int blurRadius;
        private final float curveLevel;
        private final float curveMaxX;
        private final float curveMaxY;
        private final float curveMinX;
        private final float curveMinY;
        private final float saturation;

        public CurveParameter(int i, float f, float f4, float f5, float f6, float f7, float f8) {
            this.blurRadius = i;
            this.saturation = f;
            this.curveLevel = f4;
            this.curveMinX = f5;
            this.curveMaxX = f6;
            this.curveMinY = f7;
            this.curveMaxY = f8;
        }

        public final int getBlurRadius() {
            return this.blurRadius;
        }

        public final float getCurveLevel() {
            return this.curveLevel;
        }

        public final float getCurveMaxX() {
            return this.curveMaxX;
        }

        public final float getCurveMaxY() {
            return this.curveMaxY;
        }

        public final float getCurveMinX() {
            return this.curveMinX;
        }

        public final float getCurveMinY() {
            return this.curveMinY;
        }

        public final float getSaturation() {
            return this.saturation;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m13886d2 = {"Landroidx/core/view/SemBlurCompat$SeslBlurMode;", "", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SeslBlurMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m13886d2 = {"Landroidx/core/view/SemBlurCompat$SeslUseTypeCanvasBlur;", "", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SeslUseTypeCanvasBlur {
    }

    private SemBlurCompat() {
    }

    private final boolean isCanvasBlurSupport() {
        return Boolean.parseBoolean(SeslFloatingFeatureReflector.getString("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG", "false")) && OneUI.isGreaterOrEqual(OneUI.Version.ONEUI_8_5);
    }

    private final boolean isNotBlurSupport(Context context, int blurMode, Integer useTypeCanvasBlur) {
        String string = SeslFloatingFeatureReflector.getString("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG", "false");
        boolean zIsGreaterOrEqual = OneUI.isGreaterOrEqual(OneUI.Version.ONEUI_8_5);
        if (isThemeApplied(context) || isReduceTransparencySettingsEnabled(context)) {
            return true;
        }
        if (blurMode != 2) {
            return !Boolean.parseBoolean(string);
        }
        if (useTypeCanvasBlur != null && useTypeCanvasBlur.intValue() == 1) {
            return (Boolean.parseBoolean(string) && zIsGreaterOrEqual) ? false : true;
        }
        return false;
    }

    public static /* synthetic */ boolean isNotBlurSupport$default(SemBlurCompat semBlurCompat, Context context, int i, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = 0;
        }
        return semBlurCompat.isNotBlurSupport(context, i, num);
    }

    private final boolean isReduceTransparencySettingsEnabled(Context context) {
        String field_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY = SeslSettingsReflector.SeslSystemReflector.getField_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY();
        return !Intrinsics.areEqual(field_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY, "not_supported") && Settings.System.getInt(context.getContentResolver(), field_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY, 0) == 1;
    }

    private final boolean isThemeApplied(Context context) {
        return Settings.System.getString(context.getContentResolver(), "current_sec_active_themepackage") != null;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean setBlurEffect(@NotNull View view, int i, @ColorInt int i2, int i4, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setBlurEffect$default(view, i, i2, i4, f, null, 32, null);
    }

    public static /* synthetic */ boolean setBlurEffect$default(View view, int i, int i2, int i4, float f, Integer num, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            num = 0;
        }
        return setBlurEffect(view, i, i2, i4, f, num);
    }

    @JvmStatic
    @JvmOverloads
    @RequiresApi(35)
    public static final boolean setBlurEffectPreset(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setBlurEffectPreset$default(view, i, i2, (Integer) null, (Float) null, (Integer) null, 56, (Object) null);
    }

    public static /* synthetic */ boolean setBlurEffectPreset$default(View view, int i, CurveParameter curveParameter, Integer num, Float f, Integer num2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        if ((i2 & 16) != 0) {
            f = null;
        }
        if ((i2 & 32) != 0) {
            num2 = 0;
        }
        return setBlurEffectPreset(view, i, curveParameter, num, f, num2);
    }

    @JvmStatic
    public static final void setBlurInfoClear(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        SeslViewReflector.semSetBlurInfo(view, null);
    }

    public final boolean isBlurEffectPresetSupport() {
        return Build.VERSION.SDK_INT >= 35;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean setBlurEffect(@NotNull View view, int blurMode, @ColorInt int color, int blurRadius, float cornerRadius, @Nullable Integer useTypeCanvasBlur) {
        Object objSemCreateBlurBuilder;
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        SemBlurCompat semBlurCompat = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (semBlurCompat.isNotBlurSupport(context, blurMode, useTypeCanvasBlur) || (objSemCreateBlurBuilder = SeslSemBlurInfoReflector.semCreateBlurBuilder(blurMode)) == null) {
            return false;
        }
        SeslSemBlurInfoReflector.semSetBuilderBlurRadius(objSemCreateBlurBuilder, blurRadius);
        SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundColor(objSemCreateBlurBuilder, color);
        SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundCornerRadius(objSemCreateBlurBuilder, cornerRadius);
        SeslSemBlurInfoReflector.semBuildSetBlurInfo(objSemCreateBlurBuilder, view);
        return true;
    }

    @JvmStatic
    @JvmOverloads
    @RequiresApi(35)
    public static final boolean setBlurEffectPreset(@NotNull View view, int i, int i2, @ColorInt @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setBlurEffectPreset$default(view, i, i2, num, (Float) null, (Integer) null, 48, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    @RequiresApi(35)
    public static final boolean setBlurEffectPreset(@NotNull View view, int i, int i2, @ColorInt @Nullable Integer num, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setBlurEffectPreset$default(view, i, i2, num, f, (Integer) null, 32, (Object) null);
    }

    public static /* synthetic */ boolean setBlurEffectPreset$default(View view, int i, int i2, Integer num, Float f, Integer num2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            num = null;
        }
        if ((i4 & 16) != 0) {
            f = null;
        }
        if ((i4 & 32) != 0) {
            num2 = 0;
        }
        return setBlurEffectPreset(view, i, i2, num, f, num2);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean setBlurEffectPreset(@NotNull View view, int blurMode, @NotNull CurveParameter curveParameter, @ColorInt @Nullable Integer color, @Nullable Float cornerRadius, @Nullable Integer useTypeCanvasBlur) {
        Object objSemCreateBlurBuilder;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(curveParameter, "curveParameter");
        Context context = view.getContext();
        SemBlurCompat semBlurCompat = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (semBlurCompat.isNotBlurSupport(context, blurMode, useTypeCanvasBlur) || (objSemCreateBlurBuilder = SeslSemBlurInfoReflector.semCreateBlurBuilder(blurMode)) == null) {
            return false;
        }
        SeslSemBlurInfoReflector.semSetBuilderBlurRadius(objSemCreateBlurBuilder, curveParameter.getBlurRadius());
        SeslSemBlurInfoReflector.semSetColorCurve(objSemCreateBlurBuilder, curveParameter.getSaturation(), curveParameter.getCurveLevel(), curveParameter.getCurveMinX(), curveParameter.getCurveMaxX(), curveParameter.getCurveMinY(), curveParameter.getCurveMaxY());
        if (color != null) {
            SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundColor(objSemCreateBlurBuilder, color.intValue());
        }
        if (cornerRadius != null) {
            SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundCornerRadius(objSemCreateBlurBuilder, cornerRadius.floatValue());
        }
        SeslSemBlurInfoReflector.semBuildSetBlurInfo(objSemCreateBlurBuilder, view);
        return true;
    }

    @JvmStatic
    @JvmOverloads
    @RequiresApi(35)
    public static final boolean setBlurEffectPreset(@NotNull View view, int blurMode, int colorCurvePreset, @ColorInt @Nullable Integer color, @Nullable Float cornerRadius, @Nullable Integer useTypeCanvasBlur) {
        Object objSemCreateBlurBuilder;
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        SemBlurCompat semBlurCompat = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (semBlurCompat.isNotBlurSupport(context, blurMode, useTypeCanvasBlur) || (objSemCreateBlurBuilder = SeslSemBlurInfoReflector.semCreateBlurBuilder(blurMode)) == null) {
            return false;
        }
        SeslSemBlurInfoReflector.semSetBuilderColorCurvePreset(objSemCreateBlurBuilder, colorCurvePreset);
        if (color != null) {
            SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundColor(objSemCreateBlurBuilder, color.intValue());
        }
        if (cornerRadius != null) {
            SeslSemBlurInfoReflector.semSetBuilderBlurBackgroundCornerRadius(objSemCreateBlurBuilder, cornerRadius.floatValue());
        }
        SeslSemBlurInfoReflector.semBuildSetBlurInfo(objSemCreateBlurBuilder, view);
        return true;
    }
}
