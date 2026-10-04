package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "colors", "Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = C2256Dp.m20968constructorimpl(16);

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m17337colorsV1nXRL4(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, @Nullable Composer composer, int i, int i2, int i4) {
        composer.startReplaceableGroup(1937926421);
        long color = (i4 & 1) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : j;
        long color2 = (i4 & 2) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6) : j2;
        long jM18560getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long color3 = (i4 & 8) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j5;
        long color4 = (i4 & 16) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6) : j6;
        long color5 = (i4 & 32) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6) : j7;
        long color6 = (i4 & 64) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6) : j8;
        long color7 = (i4 & 128) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j9;
        long jM18570compositeOverOWjLjI = (i4 & 256) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j10;
        long jM18570compositeOverOWjLjI2 = (i4 & 512) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j11;
        long jM18560getTransparent0d7_KjU2 = (i4 & 1024) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j12;
        long jM18570compositeOverOWjLjI3 = (i4 & 2048) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j13;
        long jM18570compositeOverOWjLjI4 = (i4 & 4096) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j14;
        long jM18570compositeOverOWjLjI5 = (i4 & 8192) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j15;
        long jM18570compositeOverOWjLjI6 = (i4 & 16384) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j16;
        long jM18570compositeOverOWjLjI7 = (i4 & 32768) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j17;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i2, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:279)");
        }
        SwitchColors switchColors = new SwitchColors(color, color2, jM18560getTransparent0d7_KjU, color3, color4, color5, color6, color7, jM18570compositeOverOWjLjI, jM18570compositeOverOWjLjI2, jM18560getTransparent0d7_KjU2, jM18570compositeOverOWjLjI3, jM18570compositeOverOWjLjI4, jM18570compositeOverOWjLjI5, jM18570compositeOverOWjLjI6, jM18570compositeOverOWjLjI7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return switchColors;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17338getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
