package androidx.glance.appwidget.percent;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.PaddingKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001af\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"padding", "Landroidx/glance/GlanceModifier;", "all", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "padding-LwRUR8o", "(Landroidx/glance/GlanceModifier;FILandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "horizontal", "vertical", "maxHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "maxVerticalPadding", "padding-6PoWaU8", "(Landroidx/glance/GlanceModifier;FFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "start", "top", "end", "bottom", "maxStartPadding", "maxTopPadding", "maxEndPadding", "maxBottomPadding", "padding-s2pLCVw", "(Landroidx/glance/GlanceModifier;FFFFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPaddingModifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaddingModifiers.kt\nandroidx/glance/appwidget/percent/PaddingModifiersKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,84:1\n174#2:85\n174#2:86\n174#2:87\n174#2:88\n189#2:90\n189#2:91\n189#2:92\n189#2:93\n174#2:94\n174#2:95\n189#2:97\n189#2:98\n74#3:89\n74#3:96\n74#3:99\n*S KotlinDebug\n*F\n+ 1 PaddingModifiers.kt\nandroidx/glance/appwidget/percent/PaddingModifiersKt\n*L\n17#1:85\n18#1:86\n19#1:87\n20#1:88\n24#1:90\n25#1:91\n26#1:92\n27#1:93\n41#1:94\n42#1:95\n47#1:97\n48#1:98\n22#1:89\n44#1:96\n66#1:99\n*E\n"})
public final class PaddingModifiersKt {
    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-6PoWaU8, reason: not valid java name */
    public static final GlanceModifier m21356padding6PoWaU8(@NotNull GlanceModifier padding, @PercentRange float f, @PercentRange float f4, float f5, float f6, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(300958655);
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(300958655, i, -1, "androidx.glance.appwidget.percent.padding (PaddingModifiers.kt:42)");
        }
        GlanceModifier glanceModifierM21497paddingVpY3zN4 = !((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? PaddingKt.m21497paddingVpY3zN4(padding, C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByWidth(f, composer, (i >> 3) & 14), f5)), C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByHeight(f4, composer, (i >> 6) & 14), f6))) : padding.then(new PercentPaddingModifier(f, f4, f, f4, 0, 16, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21497paddingVpY3zN4;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-LwRUR8o, reason: not valid java name */
    public static final GlanceModifier m21357paddingLwRUR8o(@NotNull GlanceModifier padding, @PercentRange float f, int i, @Nullable Composer composer, int i2, int i4) {
        GlanceModifier glanceModifierM21358paddings2pLCVw;
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(2090150939);
        int iM21380getAll3SpTkPA = (i4 & 2) != 0 ? PercentSizePolicy.INSTANCE.m21380getAll3SpTkPA() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2090150939, i2, -1, "androidx.glance.appwidget.percent.padding (PaddingModifiers.kt:64)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            GlanceModifier glanceModifierThen = padding.then(new PercentPaddingModifier(f, f, f, f, iM21380getAll3SpTkPA, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return glanceModifierThen;
        }
        PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
        if (PercentSizePolicy.m21375equalsimpl0(iM21380getAll3SpTkPA, companion.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(-133333078);
            glanceModifierM21358paddings2pLCVw = PaddingKt.m21496padding3ABfNKs(padding, SizeModifiersKt.percentToDpByWidth(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else if (PercentSizePolicy.m21375equalsimpl0(iM21380getAll3SpTkPA, companion.m21381getHeight3SpTkPA())) {
            composer.startReplaceableGroup(-133332993);
            glanceModifierM21358paddings2pLCVw = PaddingKt.m21496padding3ABfNKs(padding, SizeModifiersKt.percentToDpByHeight(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-133332927);
            glanceModifierM21358paddings2pLCVw = m21358paddings2pLCVw(padding, f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i2 & 126) | ((i2 << 3) & 896) | ((i2 << 6) & 7168) | ((i2 << 9) & 57344), 240);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21358paddings2pLCVw;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-s2pLCVw, reason: not valid java name */
    public static final GlanceModifier m21358paddings2pLCVw(@NotNull GlanceModifier padding, @PercentRange float f, @PercentRange float f4, @PercentRange float f5, @PercentRange float f6, float f7, float f8, float f9, float f10, @Nullable Composer composer, int i, int i2) {
        GlanceModifier glanceModifierThen;
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(-1460210721);
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f6 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            f7 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 32) != 0) {
            f8 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 64) != 0) {
            f9 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 128) != 0) {
            f10 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1460210721, i, -1, "androidx.glance.appwidget.percent.padding (PaddingModifiers.kt:20)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            float f11 = f6;
            glanceModifierThen = padding.then(new PercentPaddingModifier(f, f4, f5, f11, 0, 16, null));
        } else {
            glanceModifierThen = PaddingKt.m21499paddingqDBjuR0(padding, C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByWidth(f, composer, (i >> 3) & 14), f7)), C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByHeight(f4, composer, (i >> 6) & 14), f8)), C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByWidth(f5, composer, (i >> 9) & 14), f9)), C2256Dp.m20968constructorimpl(Math.min(SizeModifiersKt.percentToDpByHeight(f6, composer, (i >> 12) & 14), f10)));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }
}
