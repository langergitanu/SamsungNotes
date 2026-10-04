package androidx.compose.material;

import androidx.compose.p109ui.graphics.Color;
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
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m13886d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m16641colorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(469524104);
        long jM16678getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16678getSecondary0d7_KjU() : j;
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM16680getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM18524copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(jM16678getSecondary0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, i, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:220)");
        }
        Object[] objArr = {Color.m18515boximpl(jM16678getSecondary0d7_KjU), Color.m18515boximpl(jM18524copywmQWz5c$default), Color.m18515boximpl(jM16680getSurface0d7_KjU), Color.m18515boximpl(jM18524copywmQWz5c$default2), Color.m18515boximpl(jM18524copywmQWz5c$default3)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i4 = 0; i4 < 5; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultCheckboxColors defaultCheckboxColors = new DefaultCheckboxColors(jM16680getSurface0d7_KjU, Color.m18524copywmQWz5c$default(jM16680getSurface0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM16678getSecondary0d7_KjU, Color.m18524copywmQWz5c$default(jM16678getSecondary0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default2, Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default3, jM16678getSecondary0d7_KjU, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, null);
            composer.updateRememberedValue(defaultCheckboxColors);
            objRememberedValue = defaultCheckboxColors;
        }
        composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors2 = (DefaultCheckboxColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCheckboxColors2;
    }
}
