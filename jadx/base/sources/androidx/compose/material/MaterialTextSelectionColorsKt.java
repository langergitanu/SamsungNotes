package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, m13886d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m16779binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        int i = 0;
        float f = 0.2f;
        float f4 = 0.4f;
        float f5 = 0.4f;
        while (i < 7) {
            long j5 = j;
            long j6 = j2;
            long j7 = j3;
            float fM16781calculateContrastRationb2GgbA = (m16781calculateContrastRationb2GgbA(j5, f4, j6, j7) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= fM16781calculateContrastRationb2GgbA && fM16781calculateContrastRationb2GgbA <= 0.01f) {
                return f4;
            }
            if (fM16781calculateContrastRationb2GgbA < 0.0f) {
                f5 = f4;
            } else {
                f = f4;
            }
            f4 = (f5 + f) / 2.0f;
            i++;
            j = j5;
            j2 = j6;
            j3 = j7;
        }
        return f4;
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m16780calculateContrastRatioOWjLjI(long j, long j2) {
        float fM18577luminance8_81llA = ColorKt.m18577luminance8_81llA(j) + 0.05f;
        float fM18577luminance8_81llA2 = ColorKt.m18577luminance8_81llA(j2) + 0.05f;
        return Math.max(fM18577luminance8_81llA, fM18577luminance8_81llA2) / Math.min(fM18577luminance8_81llA, fM18577luminance8_81llA2);
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m16781calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m16780calculateContrastRatioOWjLjI(ColorKt.m18570compositeOverOWjLjI(j2, jM18570compositeOverOWjLjI), jM18570compositeOverOWjLjI);
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m16782calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        return Color.m18524copywmQWz5c$default(j, m16781calculateContrastRationb2GgbA(j, 0.4f, j2, j3) >= DesiredContrastRatio ? 0.4f : m16781calculateContrastRationb2GgbA(j, 0.2f, j2, j3) < DesiredContrastRatio ? 0.2f : m16779binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3), 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Composable
    @NotNull
    public static final TextSelectionColors rememberTextSelectionColors(@NotNull Colors colors, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long jM16676getPrimary0d7_KjU = colors.m16676getPrimary0d7_KjU();
        long jM16669getBackground0d7_KjU = colors.m16669getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long jM16693contentColorFor4WTKRHQ = ColorsKt.m16693contentColorFor4WTKRHQ(colors, jM16669getBackground0d7_KjU);
        if (jM16693contentColorFor4WTKRHQ == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
            jM16693contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
        }
        long j = jM16693contentColorFor4WTKRHQ;
        composer.endReplaceableGroup();
        long jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color colorM18515boximpl = Color.m18515boximpl(jM16676getPrimary0d7_KjU);
        Color colorM18515boximpl2 = Color.m18515boximpl(jM16669getBackground0d7_KjU);
        Color colorM18515boximpl3 = Color.m18515boximpl(jM18524copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(colorM18515boximpl) | composer.changed(colorM18515boximpl2) | composer.changed(colorM18515boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(colors.m16676getPrimary0d7_KjU(), m16782calculateSelectionBackgroundColorysEtTa8(jM16676getPrimary0d7_KjU, jM18524copywmQWz5c$default, jM16669getBackground0d7_KjU), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors2;
    }
}
