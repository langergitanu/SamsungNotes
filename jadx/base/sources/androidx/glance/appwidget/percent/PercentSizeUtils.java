package androidx.glance.appwidget.percent;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentSizeUtils;", "", "()V", "getMinDpSizeFromPercentData", "Landroidx/compose/ui/unit/DpSize;", "width", "", "height", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "ratio", "getMinDpSizeFromPercentData-M_xkUdw", "(FFFFFLandroidx/compose/runtime/Composer;II)J", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPercentSizeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PercentSizeUtils.kt\nandroidx/glance/appwidget/percent/PercentSizeUtils\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,38:1\n174#2:39\n174#2:40\n154#2:41\n202#2:42\n154#2:44\n202#2:45\n71#3:43\n88#3:46\n*S KotlinDebug\n*F\n+ 1 PercentSizeUtils.kt\nandroidx/glance/appwidget/percent/PercentSizeUtils\n*L\n20#1:39\n21#1:40\n25#1:41\n25#1:42\n29#1:44\n29#1:45\n26#1:43\n30#1:46\n*E\n"})
public final class PercentSizeUtils {
    public static final int $stable = 0;

    @NotNull
    public static final PercentSizeUtils INSTANCE = new PercentSizeUtils();

    private PercentSizeUtils() {
    }

    @Composable
    /* JADX INFO: renamed from: getMinDpSizeFromPercentData-M_xkUdw, reason: not valid java name */
    public final long m21383getMinDpSizeFromPercentDataM_xkUdw(float f, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-467390088);
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 16) != 0) {
            f7 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-467390088, i, -1, "androidx.glance.appwidget.percent.PercentSizeUtils.getMinDpSizeFromPercentData (PercentSizeUtils.kt:22)");
        }
        float f8 = 0;
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(RangesKt.coerceIn(SizeModifiersKt.percentToDpByWidth(f, composer, i & 14), C2256Dp.m20968constructorimpl(f8), f5));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(fM20968constructorimpl / f7);
        float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(RangesKt.coerceIn(SizeModifiersKt.percentToDpByHeight(f4, composer, (i >> 3) & 14), C2256Dp.m20968constructorimpl(f8), f6));
        float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(f7 * fM20968constructorimpl3);
        long jM20990DpSizeYgX7TsA = (C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl, fM20968constructorimpl4) >= 0 || C2256Dp.m20967compareTo0680j_4(fM20968constructorimpl2, fM20968constructorimpl3) >= 0) ? DpKt.m20990DpSizeYgX7TsA(fM20968constructorimpl4, fM20968constructorimpl3) : DpKt.m20990DpSizeYgX7TsA(fM20968constructorimpl, fM20968constructorimpl2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM20990DpSizeYgX7TsA;
    }
}
