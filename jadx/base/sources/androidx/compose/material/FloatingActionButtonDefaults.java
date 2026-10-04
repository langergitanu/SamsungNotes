package androidx.compose.material;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m16768elevationixp7dh8(float f, float f4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-654132828);
        float fM20968constructorimpl = (i2 & 1) != 0 ? C2256Dp.m20968constructorimpl(6) : f;
        float fM20968constructorimpl2 = (i2 & 2) != 0 ? C2256Dp.m20968constructorimpl(12) : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:216)");
        }
        float f5 = 8;
        FloatingActionButtonElevation floatingActionButtonElevationM16769elevationxZ9QkE = m16769elevationxZ9QkE(fM20968constructorimpl, fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f5), composer, (i & 14) | 3456 | (i & 112) | ((i << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return floatingActionButtonElevationM16769elevationxZ9QkE;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m16769elevationxZ9QkE(float f, float f4, float f5, float f6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(380403812);
        if ((i2 & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(6);
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(12);
        }
        float f8 = f4;
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(8);
        }
        float f9 = f5;
        if ((i2 & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(8);
        }
        float f10 = f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:241)");
        }
        Object[] objArr = {C2256Dp.m20966boximpl(f7), C2256Dp.m20966boximpl(f8), C2256Dp.m20966boximpl(f9), C2256Dp.m20966boximpl(f10)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i4 = 0; i4 < 4; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = new DefaultFloatingActionButtonElevation(f7, f8, f9, f10, null);
            composer.updateRememberedValue(defaultFloatingActionButtonElevation);
            objRememberedValue = defaultFloatingActionButtonElevation;
        }
        composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation2 = (DefaultFloatingActionButtonElevation) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation2;
    }
}
