package androidx.compose.p109ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0001j\u0002`\u0002H\u0000¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\b\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\b\u0010\u0018\u001a\u00020\u0017H\u0000\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u001a*\u00020\u0001*\f\b\u0000\u0010\u001c\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"actualColorMatrixColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "actualColorMatrixColorFilter-jHG-Opc", "([F)Landroid/graphics/ColorFilter;", "actualColorMatrixFromFilter", "filter", "(Landroid/graphics/ColorFilter;)[F", "actualLightingColorFilter", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "actualLightingColorFilter--OWjLjI", "(JJ)Landroid/graphics/ColorFilter;", "actualTintColorFilter", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "actualTintColorFilter-xETnrds", "(JI)Landroid/graphics/ColorFilter;", "supportsColorMatrixQuery", "", "supportsLightingColorFilterQuery", "asAndroidColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "asComposeColorFilter", "NativeColorFilter", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidColorFilter_androidKt {
    @NotNull
    /* JADX INFO: renamed from: actualColorMatrixColorFilter-jHG-Opc, reason: not valid java name */
    public static final ColorFilter m18389actualColorMatrixColorFilterjHGOpc(@NotNull float[] fArr) {
        return new ColorMatrixColorFilter(fArr);
    }

    @NotNull
    public static final float[] actualColorMatrixFromFilter(@NotNull ColorFilter colorFilter) {
        if ((colorFilter instanceof ColorMatrixColorFilter) && supportsColorMatrixQuery()) {
            return ColorMatrixFilterHelper.INSTANCE.m18605getColorMatrix8unuwjk((ColorMatrixColorFilter) colorFilter);
        }
        throw new IllegalArgumentException("Unable to obtain ColorMatrix from Android ColorMatrixColorFilter. This method was invoked on an unsupported Android version");
    }

    @NotNull
    /* JADX INFO: renamed from: actualLightingColorFilter--OWjLjI, reason: not valid java name */
    public static final ColorFilter m18390actualLightingColorFilterOWjLjI(long j, long j2) {
        return new LightingColorFilter(ColorKt.m18579toArgb8_81llA(j), ColorKt.m18579toArgb8_81llA(j2));
    }

    @NotNull
    /* JADX INFO: renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final ColorFilter m18391actualTintColorFilterxETnrds(long j, int i) {
        return Build.VERSION.SDK_INT >= 29 ? BlendModeColorFilterHelper.INSTANCE.m18471BlendModeColorFilterxETnrds(j, i) : new PorterDuffColorFilter(ColorKt.m18579toArgb8_81llA(j), AndroidBlendMode_androidKt.m18377toPorterDuffModes9anfk8(i));
    }

    @NotNull
    public static final ColorFilter asAndroidColorFilter(@NotNull ColorFilter colorFilter) {
        return colorFilter.getNativeColorFilter();
    }

    @NotNull
    public static final ColorFilter asComposeColorFilter(@NotNull ColorFilter colorFilter) {
        if (29 <= Build.VERSION.SDK_INT && AbstractC2050b.m1419j(colorFilter)) {
            return BlendModeColorFilterHelper.INSTANCE.createBlendModeColorFilter(AbstractC2050b.m1415f(colorFilter));
        }
        if (!(colorFilter instanceof LightingColorFilter) || !supportsLightingColorFilterQuery()) {
            return ((colorFilter instanceof ColorMatrixColorFilter) && supportsColorMatrixQuery()) ? new ColorMatrixColorFilter(null, colorFilter, null) : new ColorFilter(colorFilter);
        }
        LightingColorFilter lightingColorFilter = (LightingColorFilter) colorFilter;
        return new LightingColorFilter(ColorKt.Color(lightingColorFilter.getColorMultiply()), ColorKt.Color(lightingColorFilter.getColorAdd()), colorFilter, null);
    }

    public static final boolean supportsColorMatrixQuery() {
        return true;
    }

    public static final boolean supportsLightingColorFilterQuery() {
        return true;
    }
}
