package androidx.appcompat.oneui.common.internal.semblurinfo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceColor;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.view.SemBlurCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JF\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateCanvas;", "Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "blurMode", "", "colorCurvePreset", "Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "blurBackgroundColor", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "nonBlurBackground", "Landroid/graphics/drawable/Drawable;", "useTypeCanvasBlur", "(ILandroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V", "getBlurBackgroundColor", "()Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "getBlurMode", "()I", "getColorCurvePreset", "()Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "getNonBlurBackground", "()Landroid/graphics/drawable/Drawable;", "getUseTypeCanvasBlur", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "applyBlurInfo", "", "view", "Landroid/view/View;", "clearBlurInfo", "", "component1", "component2", "component3", "component4", "component5", "copy", "(ILandroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateCanvas;", "equals", "other", "", "hashCode", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(35)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nSemBlurInfoState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemBlurInfoState.kt\nandroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateCanvas\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final /* data */ class SemBlurInfoStateCanvas extends SemBlurInfoState {

    @Nullable
    private final ThemeResourceColor blurBackgroundColor;
    private final int blurMode;

    @NotNull
    private final ColorCurvePreset colorCurvePreset;

    @Nullable
    private final Drawable nonBlurBackground;

    @Nullable
    private final Integer useTypeCanvasBlur;

    public /* synthetic */ SemBlurInfoStateCanvas(int i, ColorCurvePreset colorCurvePreset, ThemeResourceColor themeResourceColor, Drawable drawable, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, colorCurvePreset, themeResourceColor, (i2 & 8) != 0 ? null : drawable, (i2 & 16) != 0 ? 0 : num);
    }

    public static /* synthetic */ SemBlurInfoStateCanvas copy$default(SemBlurInfoStateCanvas semBlurInfoStateCanvas, int i, ColorCurvePreset colorCurvePreset, ThemeResourceColor themeResourceColor, Drawable drawable, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = semBlurInfoStateCanvas.blurMode;
        }
        if ((i2 & 2) != 0) {
            colorCurvePreset = semBlurInfoStateCanvas.colorCurvePreset;
        }
        if ((i2 & 4) != 0) {
            themeResourceColor = semBlurInfoStateCanvas.blurBackgroundColor;
        }
        if ((i2 & 8) != 0) {
            drawable = semBlurInfoStateCanvas.nonBlurBackground;
        }
        if ((i2 & 16) != 0) {
            num = semBlurInfoStateCanvas.useTypeCanvasBlur;
        }
        Integer num2 = num;
        ThemeResourceColor themeResourceColor2 = themeResourceColor;
        return semBlurInfoStateCanvas.copy(i, colorCurvePreset, themeResourceColor2, drawable, num2);
    }

    @Override // androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState
    public boolean applyBlurInfo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        int blurMode = getBlurMode();
        ColorCurvePreset colorCurvePreset = this.colorCurvePreset;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!SemBlurCompat.setBlurEffectPreset(view, blurMode, colorCurvePreset.getResource(context), (Integer) null, (Float) null, this.useTypeCanvasBlur)) {
            return false;
        }
        view.setClipToOutline(true);
        ThemeResourceColor themeResourceColor = this.blurBackgroundColor;
        if (themeResourceColor != null) {
            view.setBackgroundTintList(ColorStateList.valueOf(themeResourceColor.getResource(context).intValue()));
        }
        return true;
    }

    @Override // androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState
    public void clearBlurInfo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        SemBlurCompat.setBlurInfoClear(view);
        view.setBackgroundTintList(null);
        Drawable drawable = this.nonBlurBackground;
        if (drawable != null) {
            view.setBackground(drawable);
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBlurMode() {
        return this.blurMode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorCurvePreset getColorCurvePreset() {
        return this.colorCurvePreset;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ThemeResourceColor getBlurBackgroundColor() {
        return this.blurBackgroundColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Drawable getNonBlurBackground() {
        return this.nonBlurBackground;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getUseTypeCanvasBlur() {
        return this.useTypeCanvasBlur;
    }

    @NotNull
    public final SemBlurInfoStateCanvas copy(int blurMode, @NotNull ColorCurvePreset colorCurvePreset, @Nullable ThemeResourceColor blurBackgroundColor, @Nullable Drawable nonBlurBackground, @Nullable Integer useTypeCanvasBlur) {
        Intrinsics.checkNotNullParameter(colorCurvePreset, "colorCurvePreset");
        return new SemBlurInfoStateCanvas(blurMode, colorCurvePreset, blurBackgroundColor, nonBlurBackground, useTypeCanvasBlur);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemBlurInfoStateCanvas)) {
            return false;
        }
        SemBlurInfoStateCanvas semBlurInfoStateCanvas = (SemBlurInfoStateCanvas) other;
        return this.blurMode == semBlurInfoStateCanvas.blurMode && Intrinsics.areEqual(this.colorCurvePreset, semBlurInfoStateCanvas.colorCurvePreset) && Intrinsics.areEqual(this.blurBackgroundColor, semBlurInfoStateCanvas.blurBackgroundColor) && Intrinsics.areEqual(this.nonBlurBackground, semBlurInfoStateCanvas.nonBlurBackground) && Intrinsics.areEqual(this.useTypeCanvasBlur, semBlurInfoStateCanvas.useTypeCanvasBlur);
    }

    @Nullable
    public final ThemeResourceColor getBlurBackgroundColor() {
        return this.blurBackgroundColor;
    }

    @Override // androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState
    public int getBlurMode() {
        return this.blurMode;
    }

    @NotNull
    public final ColorCurvePreset getColorCurvePreset() {
        return this.colorCurvePreset;
    }

    @Nullable
    public final Drawable getNonBlurBackground() {
        return this.nonBlurBackground;
    }

    @Nullable
    public final Integer getUseTypeCanvasBlur() {
        return this.useTypeCanvasBlur;
    }

    public int hashCode() {
        int iHashCode = (this.colorCurvePreset.hashCode() + (Integer.hashCode(this.blurMode) * 31)) * 31;
        ThemeResourceColor themeResourceColor = this.blurBackgroundColor;
        int iHashCode2 = (iHashCode + (themeResourceColor == null ? 0 : themeResourceColor.hashCode())) * 31;
        Drawable drawable = this.nonBlurBackground;
        int iHashCode3 = (iHashCode2 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Integer num = this.useTypeCanvasBlur;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SemBlurInfoStateCanvas(blurMode=" + this.blurMode + ", colorCurvePreset=" + this.colorCurvePreset + ", blurBackgroundColor=" + this.blurBackgroundColor + ", nonBlurBackground=" + this.nonBlurBackground + ", useTypeCanvasBlur=" + this.useTypeCanvasBlur + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemBlurInfoStateCanvas(int i, @NotNull ColorCurvePreset colorCurvePreset, @Nullable ThemeResourceColor themeResourceColor, @Nullable Drawable drawable, @Nullable Integer num) {
        super(i);
        Intrinsics.checkNotNullParameter(colorCurvePreset, "colorCurvePreset");
        this.blurMode = i;
        this.colorCurvePreset = colorCurvePreset;
        this.blurBackgroundColor = themeResourceColor;
        this.nonBlurBackground = drawable;
        this.useTypeCanvasBlur = num;
    }
}
