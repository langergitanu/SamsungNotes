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
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;

    @NotNull
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m16847colorsq0g_0yA(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, @Nullable Composer composer, int i, int i2, int i4) {
        long jM18570compositeOverOWjLjI;
        composer.startReplaceableGroup(436017687);
        long jM16676getPrimary0d7_KjU = (i4 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j;
        if ((i4 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI = j2;
        }
        long jM16676getPrimary0d7_KjU2 = (i4 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i4 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM16676getPrimary0d7_KjU2, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM18524copywmQWz5c$default2 = (i4 & 16) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default3 = (i4 & 32) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default4 = (i4 & 64) != 0 ? Color.m18524copywmQWz5c$default(ColorsKt.m16694contentColorForek8zF_U(jM16676getPrimary0d7_KjU2, composer, (i >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM18524copywmQWz5c$default5 = (i4 & 128) != 0 ? Color.m18524copywmQWz5c$default(jM16676getPrimary0d7_KjU2, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long jM18524copywmQWz5c$default6 = (i4 & 256) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default4, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM18524copywmQWz5c$default7 = (i4 & 512) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default3, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, i, i2, "androidx.compose.material.SliderDefaults.colors (Slider.kt:478)");
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(jM16676getPrimary0d7_KjU, jM18570compositeOverOWjLjI, jM16676getPrimary0d7_KjU2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, jM18524copywmQWz5c$default7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
