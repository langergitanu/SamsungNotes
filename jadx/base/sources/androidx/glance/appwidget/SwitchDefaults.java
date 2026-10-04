package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import androidx.glance.color.DynamicThemeColorProviders;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/SwitchDefaults;", "", "()V", "colors", "Landroidx/glance/appwidget/SwitchColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/appwidget/SwitchColors;", "checkedThumbColor", "Landroidx/glance/unit/ColorProvider;", "uncheckedThumbColor", "checkedTrackColor", "uncheckedTrackColor", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Landroidx/glance/appwidget/SwitchColors;", "switchColors", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    public final SwitchColors colors(@NotNull ColorProvider checkedThumbColor, @NotNull ColorProvider uncheckedThumbColor, @NotNull ColorProvider checkedTrackColor, @NotNull ColorProvider uncheckedTrackColor, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(checkedThumbColor, "checkedThumbColor");
        Intrinsics.checkNotNullParameter(uncheckedThumbColor, "uncheckedThumbColor");
        Intrinsics.checkNotNullParameter(checkedTrackColor, "checkedTrackColor");
        Intrinsics.checkNotNullParameter(uncheckedTrackColor, "uncheckedTrackColor");
        composer.startReplaceableGroup(-1578571870);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1578571870, i, -1, "androidx.glance.appwidget.SwitchDefaults.colors (Switch.kt:166)");
        }
        SwitchColors switchColors = switchColors(checkedThumbColor, uncheckedThumbColor, checkedTrackColor, uncheckedTrackColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return switchColors;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final SwitchColors switchColors(@NotNull ColorProvider checkedThumbColor, @NotNull ColorProvider uncheckedThumbColor, @NotNull ColorProvider checkedTrackColor, @NotNull ColorProvider uncheckedTrackColor) {
        Intrinsics.checkNotNullParameter(checkedThumbColor, "checkedThumbColor");
        Intrinsics.checkNotNullParameter(uncheckedThumbColor, "uncheckedThumbColor");
        Intrinsics.checkNotNullParameter(checkedTrackColor, "checkedTrackColor");
        Intrinsics.checkNotNullParameter(uncheckedTrackColor, "uncheckedTrackColor");
        CheckedUncheckedColorProvider.Companion companion = CheckedUncheckedColorProvider.INSTANCE;
        return new SwitchColorsImpl(companion.createCheckableColorProvider("SwitchColors", checkedThumbColor, uncheckedThumbColor), companion.createCheckableColorProvider("SwitchColors", checkedTrackColor, uncheckedTrackColor));
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @NotNull
    public final SwitchColors colors(@Nullable Composer composer, int i) {
        Composer composer2;
        SwitchColors switchColorsColors;
        composer.startReplaceableGroup(494460634);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(494460634, i, -1, "androidx.glance.appwidget.SwitchDefaults.colors (Switch.kt:200)");
        }
        GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
        int i2 = GlanceTheme.$stable;
        if (Intrinsics.areEqual(glanceTheme.getColors(composer, i2), DynamicThemeColorProviders.INSTANCE)) {
            switchColorsColors = new SwitchColorsImpl(new ResourceCheckableColorProvider(C2902R.color.glance_default_switch_thumb), new ResourceCheckableColorProvider(C2902R.color.glance_default_switch_track));
            composer2 = composer;
        } else {
            composer2 = composer;
            switchColorsColors = colors(glanceTheme.getColors(composer, i2).getOnPrimary(), glanceTheme.getColors(composer, i2).getOutline(), glanceTheme.getColors(composer, i2).getPrimary(), glanceTheme.getColors(composer, i2).getSurfaceVariant(), composer2, ((i << 12) & 57344) | 4680);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return switchColorsColors;
    }
}
