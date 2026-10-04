package androidx.appcompat.oneui.common.internal.semblurinfo;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceImpl;
import androidx.core.view.SemBlurCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(35)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/semblurinfo/ColorCurvePreset;", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceImpl;", "Landroidx/core/view/SemBlurCompat$CurveParameter;", "colorCurvePresetLight", "colorCurvePresetDark", "(Landroidx/core/view/SemBlurCompat$CurveParameter;Landroidx/core/view/SemBlurCompat$CurveParameter;)V", "getColorCurvePresetDark", "()Landroidx/core/view/SemBlurCompat$CurveParameter;", "getColorCurvePresetLight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class ColorCurvePreset extends ThemeResourceImpl<SemBlurCompat.CurveParameter> {

    @NotNull
    private final SemBlurCompat.CurveParameter colorCurvePresetDark;

    @NotNull
    private final SemBlurCompat.CurveParameter colorCurvePresetLight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorCurvePreset(@NotNull SemBlurCompat.CurveParameter colorCurvePresetLight, @NotNull SemBlurCompat.CurveParameter colorCurvePresetDark) {
        super(colorCurvePresetLight, colorCurvePresetDark);
        Intrinsics.checkNotNullParameter(colorCurvePresetLight, "colorCurvePresetLight");
        Intrinsics.checkNotNullParameter(colorCurvePresetDark, "colorCurvePresetDark");
        this.colorCurvePresetLight = colorCurvePresetLight;
        this.colorCurvePresetDark = colorCurvePresetDark;
    }

    public static /* synthetic */ ColorCurvePreset copy$default(ColorCurvePreset colorCurvePreset, SemBlurCompat.CurveParameter curveParameter, SemBlurCompat.CurveParameter curveParameter2, int i, Object obj) {
        if ((i & 1) != 0) {
            curveParameter = colorCurvePreset.colorCurvePresetLight;
        }
        if ((i & 2) != 0) {
            curveParameter2 = colorCurvePreset.colorCurvePresetDark;
        }
        return colorCurvePreset.copy(curveParameter, curveParameter2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SemBlurCompat.CurveParameter getColorCurvePresetLight() {
        return this.colorCurvePresetLight;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SemBlurCompat.CurveParameter getColorCurvePresetDark() {
        return this.colorCurvePresetDark;
    }

    @NotNull
    public final ColorCurvePreset copy(@NotNull SemBlurCompat.CurveParameter colorCurvePresetLight, @NotNull SemBlurCompat.CurveParameter colorCurvePresetDark) {
        Intrinsics.checkNotNullParameter(colorCurvePresetLight, "colorCurvePresetLight");
        Intrinsics.checkNotNullParameter(colorCurvePresetDark, "colorCurvePresetDark");
        return new ColorCurvePreset(colorCurvePresetLight, colorCurvePresetDark);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorCurvePreset)) {
            return false;
        }
        ColorCurvePreset colorCurvePreset = (ColorCurvePreset) other;
        return Intrinsics.areEqual(this.colorCurvePresetLight, colorCurvePreset.colorCurvePresetLight) && Intrinsics.areEqual(this.colorCurvePresetDark, colorCurvePreset.colorCurvePresetDark);
    }

    @NotNull
    public final SemBlurCompat.CurveParameter getColorCurvePresetDark() {
        return this.colorCurvePresetDark;
    }

    @NotNull
    public final SemBlurCompat.CurveParameter getColorCurvePresetLight() {
        return this.colorCurvePresetLight;
    }

    public int hashCode() {
        return this.colorCurvePresetDark.hashCode() + (this.colorCurvePresetLight.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "ColorCurvePreset(colorCurvePresetLight=" + this.colorCurvePresetLight + ", colorCurvePresetDark=" + this.colorCurvePresetDark + PropertyUtils.MAPPED_DELIM2;
    }
}
