package androidx.compose.material;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m16885colorsSQMK_m0(long j, long j2, float f, long j3, long j5, float f4, long j6, long j7, long j8, long j9, @Nullable Composer composer, int i, int i2, int i4) {
        float f5;
        long j10;
        long jM18570compositeOverOWjLjI;
        long j11;
        long jM18570compositeOverOWjLjI2;
        long j12;
        long jM18570compositeOverOWjLjI3;
        long j13;
        composer.startReplaceableGroup(-1032127534);
        long jM16679getSecondaryVariant0d7_KjU = (i4 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16679getSecondaryVariant0d7_KjU() : j;
        long j14 = (i4 & 2) != 0 ? jM16679getSecondaryVariant0d7_KjU : j2;
        float f6 = (i4 & 4) != 0 ? 0.54f : f;
        long jM16680getSurface0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j3;
        long jM16675getOnSurface0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU() : j5;
        float f7 = (i4 & 32) != 0 ? 0.38f : f4;
        if ((i4 & 64) != 0) {
            long j15 = jM16679getSecondaryVariant0d7_KjU;
            j10 = j15;
            f5 = f6;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            f5 = f6;
            j10 = jM16679getSecondaryVariant0d7_KjU;
            jM18570compositeOverOWjLjI = j6;
        }
        if ((i4 & 128) != 0) {
            j11 = jM18570compositeOverOWjLjI;
            jM18570compositeOverOWjLjI2 = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            j11 = jM18570compositeOverOWjLjI;
            jM18570compositeOverOWjLjI2 = j7;
        }
        if ((i4 & 256) != 0) {
            j12 = jM18570compositeOverOWjLjI2;
            jM18570compositeOverOWjLjI3 = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(jM16680getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            j12 = jM18570compositeOverOWjLjI2;
            jM18570compositeOverOWjLjI3 = j8;
        }
        long jM18570compositeOverOWjLjI4 = (i4 & 512) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(jM16675getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU()) : j9;
        if (ComposerKt.isTraceInProgress()) {
            j13 = jM18570compositeOverOWjLjI4;
            ComposerKt.traceEventStart(-1032127534, i, i2, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:278)");
        } else {
            j13 = jM18570compositeOverOWjLjI4;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j10, Color.m18524copywmQWz5c$default(j14, f5, 0.0f, 0.0f, 0.0f, 14, null), jM16680getSurface0d7_KjU, Color.m18524copywmQWz5c$default(jM16675getOnSurface0d7_KjU, f7, 0.0f, 0.0f, 0.0f, 14, null), j11, Color.m18524copywmQWz5c$default(j12, f5, 0.0f, 0.0f, 0.0f, 14, null), jM18570compositeOverOWjLjI3, Color.m18524copywmQWz5c$default(j13, f7, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
