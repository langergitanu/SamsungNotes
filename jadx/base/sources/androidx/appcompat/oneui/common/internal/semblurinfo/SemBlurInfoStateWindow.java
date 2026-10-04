package androidx.appcompat.oneui.common.internal.semblurinfo;

import android.content.Context;
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
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003JF\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateWindow;", "Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "blurMode", "", "cornerRadius", "", "colorCurvePreset", "Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "blurBackgroundColor", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "nonBlurBackground", "Landroid/graphics/drawable/Drawable;", "(ILjava/lang/Float;Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;Landroid/graphics/drawable/Drawable;)V", "getBlurBackgroundColor", "()Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "getBlurMode", "()I", "getColorCurvePreset", "()Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "getCornerRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getNonBlurBackground", "()Landroid/graphics/drawable/Drawable;", "applyBlurInfo", "", "view", "Landroid/view/View;", "clearBlurInfo", "", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Float;Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;Landroid/graphics/drawable/Drawable;)Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateWindow;", "equals", "other", "", "hashCode", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(35)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nSemBlurInfoState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemBlurInfoState.kt\nandroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateWindow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final /* data */ class SemBlurInfoStateWindow extends SemBlurInfoState {

    @Nullable
    private final ThemeResourceColor blurBackgroundColor;
    private final int blurMode;

    @NotNull
    private final ColorCurvePreset colorCurvePreset;

    @Nullable
    private final Float cornerRadius;

    @Nullable
    private final Drawable nonBlurBackground;

    public /* synthetic */ SemBlurInfoStateWindow(int i, Float f, ColorCurvePreset colorCurvePreset, ThemeResourceColor themeResourceColor, Drawable drawable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, colorCurvePreset, themeResourceColor, (i2 & 16) != 0 ? null : drawable);
    }

    public static /* synthetic */ SemBlurInfoStateWindow copy$default(SemBlurInfoStateWindow semBlurInfoStateWindow, int i, Float f, ColorCurvePreset colorCurvePreset, ThemeResourceColor themeResourceColor, Drawable drawable, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = semBlurInfoStateWindow.blurMode;
        }
        if ((i2 & 2) != 0) {
            f = semBlurInfoStateWindow.cornerRadius;
        }
        if ((i2 & 4) != 0) {
            colorCurvePreset = semBlurInfoStateWindow.colorCurvePreset;
        }
        if ((i2 & 8) != 0) {
            themeResourceColor = semBlurInfoStateWindow.blurBackgroundColor;
        }
        if ((i2 & 16) != 0) {
            drawable = semBlurInfoStateWindow.nonBlurBackground;
        }
        Drawable drawable2 = drawable;
        ColorCurvePreset colorCurvePreset2 = colorCurvePreset;
        return semBlurInfoStateWindow.copy(i, f, colorCurvePreset2, themeResourceColor, drawable2);
    }

    @Override // androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState
    public boolean applyBlurInfo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        int blurMode = getBlurMode();
        ColorCurvePreset colorCurvePreset = this.colorCurvePreset;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SemBlurCompat.CurveParameter resource = colorCurvePreset.getResource(context);
        ThemeResourceColor themeResourceColor = this.blurBackgroundColor;
        boolean blurEffectPreset$default = SemBlurCompat.setBlurEffectPreset$default(view, blurMode, resource, themeResourceColor != null ? themeResourceColor.getResource(context) : null, this.cornerRadius, (Integer) null, 32, (Object) null);
        view.setClipToOutline(true);
        return blurEffectPreset$default;
    }

    @Override // androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState
    public void clearBlurInfo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        SemBlurCompat.setBlurInfoClear(view);
        Drawable drawable = this.nonBlurBackground;
        if (drawable != null) {
            view.setBackground(drawable);
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBlurMode() {
        return this.blurMode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ColorCurvePreset getColorCurvePreset() {
        return this.colorCurvePreset;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThemeResourceColor getBlurBackgroundColor() {
        return this.blurBackgroundColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Drawable getNonBlurBackground() {
        return this.nonBlurBackground;
    }

    @NotNull
    public final SemBlurInfoStateWindow copy(int blurMode, @Nullable Float cornerRadius, @NotNull ColorCurvePreset colorCurvePreset, @Nullable ThemeResourceColor blurBackgroundColor, @Nullable Drawable nonBlurBackground) {
        Intrinsics.checkNotNullParameter(colorCurvePreset, "colorCurvePreset");
        return new SemBlurInfoStateWindow(blurMode, cornerRadius, colorCurvePreset, blurBackgroundColor, nonBlurBackground);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemBlurInfoStateWindow)) {
            return false;
        }
        SemBlurInfoStateWindow semBlurInfoStateWindow = (SemBlurInfoStateWindow) other;
        return this.blurMode == semBlurInfoStateWindow.blurMode && Intrinsics.areEqual((Object) this.cornerRadius, (Object) semBlurInfoStateWindow.cornerRadius) && Intrinsics.areEqual(this.colorCurvePreset, semBlurInfoStateWindow.colorCurvePreset) && Intrinsics.areEqual(this.blurBackgroundColor, semBlurInfoStateWindow.blurBackgroundColor) && Intrinsics.areEqual(this.nonBlurBackground, semBlurInfoStateWindow.nonBlurBackground);
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
    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    public final Drawable getNonBlurBackground() {
        return this.nonBlurBackground;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.blurMode) * 31;
        Float f = this.cornerRadius;
        int iHashCode2 = (this.colorCurvePreset.hashCode() + ((iHashCode + (f == null ? 0 : f.hashCode())) * 31)) * 31;
        ThemeResourceColor themeResourceColor = this.blurBackgroundColor;
        int iHashCode3 = (iHashCode2 + (themeResourceColor == null ? 0 : themeResourceColor.hashCode())) * 31;
        Drawable drawable = this.nonBlurBackground;
        return iHashCode3 + (drawable != null ? drawable.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SemBlurInfoStateWindow(blurMode=" + this.blurMode + ", cornerRadius=" + this.cornerRadius + ", colorCurvePreset=" + this.colorCurvePreset + ", blurBackgroundColor=" + this.blurBackgroundColor + ", nonBlurBackground=" + this.nonBlurBackground + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemBlurInfoStateWindow(int i, @Nullable Float f, @NotNull ColorCurvePreset colorCurvePreset, @Nullable ThemeResourceColor themeResourceColor, @Nullable Drawable drawable) {
        super(i);
        Intrinsics.checkNotNullParameter(colorCurvePreset, "colorCurvePreset");
        this.blurMode = i;
        this.cornerRadius = f;
        this.colorCurvePreset = colorCurvePreset;
        this.blurBackgroundColor = themeResourceColor;
        this.nonBlurBackground = drawable;
    }
}
