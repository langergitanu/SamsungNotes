package androidx.glance.appwidget;

import androidx.annotation.DimenRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.percent.PercentRange;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"circle", "Landroidx/glance/GlanceModifier;", "width", "", "height", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "circle-6PoWaU8", "(Landroidx/glance/GlanceModifier;FFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "cornerRadius", "radius", "cornerRadius-3ABfNKs", "(Landroidx/glance/GlanceModifier;F)Landroidx/glance/GlanceModifier;", "", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCornerRadius.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CornerRadius.kt\nandroidx/glance/appwidget/CornerRadiusKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,74:1\n174#2:75\n174#2:76\n154#2:78\n74#3:77\n*S KotlinDebug\n*F\n+ 1 CornerRadius.kt\nandroidx/glance/appwidget/CornerRadiusKt\n*L\n62#1:75\n63#1:76\n67#1:78\n65#1:77\n*E\n"})
public final class CornerRadiusKt {
    @Composable
    @NotNull
    /* JADX INFO: renamed from: circle-6PoWaU8, reason: not valid java name */
    public static final GlanceModifier m21285circle6PoWaU8(@NotNull GlanceModifier circle, @PercentRange float f, @PercentRange float f4, float f5, float f6, @Nullable Composer composer, int i, int i2) {
        GlanceModifier glanceModifierThen;
        Intrinsics.checkNotNullParameter(circle, "$this$circle");
        composer.startReplaceableGroup(1868590307);
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        float f7 = f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1868590307, i, -1, "androidx.glance.appwidget.circle (CornerRadius.kt:63)");
        }
        if (((Boolean) composer.consume(androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            glanceModifierThen = circle.then(new CornerRadiusModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(50), null)));
        } else {
            int i4 = i >> 3;
            glanceModifierThen = circle.then(new CornerRadiusModifier(new Dimension.C3532Dp(DpSize.m21064getHeightD9Ej5fM(DpSize.m21061divGh9hcWk(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(f, f4, f5, f7, 1.0f, composer, (i4 & 14) | 221184 | (i4 & 112) | (i4 & 896) | (i4 & 7168), 0), 2)), null)));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @NotNull
    public static final GlanceModifier cornerRadius(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new CornerRadiusModifier(new Dimension.Resource(i)));
    }

    @NotNull
    /* JADX INFO: renamed from: cornerRadius-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21286cornerRadius3ABfNKs(@NotNull GlanceModifier cornerRadius, float f) {
        Intrinsics.checkNotNullParameter(cornerRadius, "$this$cornerRadius");
        return cornerRadius.then(new CornerRadiusModifier(new Dimension.C3532Dp(f, null)));
    }
}
