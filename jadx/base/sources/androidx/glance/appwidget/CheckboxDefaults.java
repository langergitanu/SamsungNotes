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
import androidx.glance.unit.FixedColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJ\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/CheckboxDefaults;", "", "()V", "checkBoxColors", "Landroidx/glance/appwidget/CheckBoxColors;", "checkedColor", "Landroidx/glance/unit/ColorProvider;", "uncheckedColor", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/appwidget/CheckBoxColors;", "Landroidx/compose/ui/graphics/Color;", "colors-RFnl5yQ", "(JJLandroidx/compose/runtime/Composer;I)Landroidx/glance/appwidget/CheckBoxColors;", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Landroidx/glance/appwidget/CheckBoxColors;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final CheckBoxColors checkBoxColors(@NotNull ColorProvider checkedColor, @NotNull ColorProvider uncheckedColor) {
        Intrinsics.checkNotNullParameter(checkedColor, "checkedColor");
        Intrinsics.checkNotNullParameter(uncheckedColor, "uncheckedColor");
        return new CheckBoxColorsImpl(CheckedUncheckedColorProvider.INSTANCE.createCheckableColorProvider("CheckBoxColors", checkedColor, uncheckedColor));
    }

    @Composable
    @NotNull
    public final CheckBoxColors colors(@NotNull ColorProvider checkedColor, @NotNull ColorProvider uncheckedColor, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(checkedColor, "checkedColor");
        Intrinsics.checkNotNullParameter(uncheckedColor, "uncheckedColor");
        composer.startReplaceableGroup(-879562141);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-879562141, i, -1, "androidx.glance.appwidget.CheckboxDefaults.colors (CheckBox.kt:188)");
        }
        CheckBoxColors checkBoxColors = checkBoxColors(checkedColor, uncheckedColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return checkBoxColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-RFnl5yQ, reason: not valid java name */
    public final CheckBoxColors m21277colorsRFnl5yQ(long j, long j2, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(837737093);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(837737093, i, -1, "androidx.glance.appwidget.CheckboxDefaults.colors (CheckBox.kt:213)");
        }
        CheckboxDefaults checkboxDefaults = INSTANCE;
        FixedColorProvider fixedColorProvider = new FixedColorProvider(j, null);
        FixedColorProvider fixedColorProvider2 = new FixedColorProvider(j2, null);
        int i2 = FixedColorProvider.$stable;
        CheckBoxColors checkBoxColorsColors = checkboxDefaults.colors(fixedColorProvider, fixedColorProvider2, composer, (i2 << 3) | i2 | 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return checkBoxColorsColors;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @NotNull
    public final CheckBoxColors colors(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2123347125);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123347125, i, -1, "androidx.glance.appwidget.CheckboxDefaults.colors (CheckBox.kt:223)");
        }
        GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
        int i2 = GlanceTheme.$stable;
        CheckBoxColorsImpl checkBoxColorsImpl = new CheckBoxColorsImpl(Intrinsics.areEqual(glanceTheme.getColors(composer, i2), DynamicThemeColorProviders.INSTANCE) ? new ResourceCheckableColorProvider(C2902R.color.glance_default_check_box) : CheckedUncheckedColorProvider.INSTANCE.createCheckableColorProvider("CheckBoxColors", glanceTheme.getColors(composer, i2).getPrimary(), glanceTheme.getColors(composer, i2).getOnSurface()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return checkBoxColorsImpl;
    }
}
