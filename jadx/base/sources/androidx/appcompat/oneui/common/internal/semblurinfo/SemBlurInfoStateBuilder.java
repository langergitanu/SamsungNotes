package androidx.appcompat.oneui.common.internal.semblurinfo;

import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceColor;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateBuilder;", "", "blurMode", "", "colorCurvePreset", "Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "blurBackgroundColor", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;", "useTypeCanvasBlur", "(ILandroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceColor;Ljava/lang/Integer;)V", "cornerRadius", "", "Ljava/lang/Float;", "nonBlurBackground", "Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "build", "Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "radius", "background", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(35)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nSemBlurInfoStateBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemBlurInfoStateBuilder.kt\nandroidx/appcompat/oneui/common/internal/semblurinfo/SemBlurInfoStateBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public final class SemBlurInfoStateBuilder {

    @Nullable
    private final ThemeResourceColor blurBackgroundColor;
    private final int blurMode;

    @NotNull
    private final ColorCurvePreset colorCurvePreset;

    @Nullable
    private Float cornerRadius;

    @Nullable
    private Drawable nonBlurBackground;

    @Nullable
    private final Integer useTypeCanvasBlur;

    public SemBlurInfoStateBuilder(int i, @NotNull ColorCurvePreset colorCurvePreset, @Nullable ThemeResourceColor themeResourceColor, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(colorCurvePreset, "colorCurvePreset");
        this.blurMode = i;
        this.colorCurvePreset = colorCurvePreset;
        this.blurBackgroundColor = themeResourceColor;
        this.useTypeCanvasBlur = num;
    }

    @NotNull
    public final SemBlurInfoState build() {
        int i = this.blurMode;
        if (i == 0) {
            Float f = this.cornerRadius;
            ColorCurvePreset colorCurvePreset = this.colorCurvePreset;
            ThemeResourceColor themeResourceColor = this.blurBackgroundColor;
            Intrinsics.checkNotNull(themeResourceColor);
            return new SemBlurInfoStateWindow(i, f, colorCurvePreset, themeResourceColor, this.nonBlurBackground);
        }
        if (i != 2) {
            throw new IllegalStateException(AbstractC2821a.m2223n(new StringBuilder("blurMode("), ") is not supported. support mode: BLUR_MODE_CANVAS, BLUR_MODE_WINDOW", this.blurMode));
        }
        ColorCurvePreset colorCurvePreset2 = this.colorCurvePreset;
        ThemeResourceColor themeResourceColor2 = this.blurBackgroundColor;
        Intrinsics.checkNotNull(themeResourceColor2);
        return new SemBlurInfoStateCanvas(i, colorCurvePreset2, themeResourceColor2, this.nonBlurBackground, this.useTypeCanvasBlur);
    }

    @NotNull
    public final SemBlurInfoStateBuilder cornerRadius(float radius) {
        this.cornerRadius = Float.valueOf(radius);
        return this;
    }

    @NotNull
    public final SemBlurInfoStateBuilder nonBlurBackground(@NotNull Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        this.nonBlurBackground = background;
        return this;
    }

    public /* synthetic */ SemBlurInfoStateBuilder(int i, ColorCurvePreset colorCurvePreset, ThemeResourceColor themeResourceColor, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i, colorCurvePreset, (i2 & 4) != 0 ? null : themeResourceColor, (i2 & 8) != 0 ? 0 : num);
    }
}
