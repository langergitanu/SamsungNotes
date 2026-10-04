package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
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
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m13886d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "()V", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final NavigationBarItemDefaults INSTANCE = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final NavigationBarItemColors m17225colorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-213647161);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIconColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveLabelTextColor(), composer, 6) : j2;
        long color3 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIndicatorColor(), composer, 6) : j3;
        long color4 = (i2 & 8) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveIconColor(), composer, 6) : j5;
        long color5 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveLabelTextColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-213647161, i, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:291)");
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(color, color2, color3, color4, color5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationBarItemColors;
    }
}
