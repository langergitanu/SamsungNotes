package androidx.glance.oneui.template.utils;

import androidx.annotation.IntegerRes;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.appwidget.percent.PercentRange;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0000\u001a\u00020\u00022\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b*\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0000\u001a\u001b\u0010\n\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a*\u0010\r\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a>\u0010\r\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001af\u0010\r\u001a\u00020\b*\u00020\b2\b\b\u0003\u0010\u001b\u001a\u00020\u000b2\b\b\u0003\u0010\u001c\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u000b2\b\b\u0003\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\"\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020\u0017*\u00020\u000bH\u0003¢\u0006\u0002\u0010&\u001a\u0011\u0010'\u001a\u00020\u0017*\u00020\u000bH\u0003¢\u0006\u0002\u0010&\u001a*\u0010(\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u0013\u001a%\u0010(\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010+\u001aH\u0010,\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u00172\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001b\u0010*\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, m13886d2 = {"visibility", "", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "contentDescription", "Landroidx/compose/ui/Modifier;", "", "height", "", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "padding", "Landroidx/compose/ui/unit/DpRect;", "all", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "padding-LwRUR8o", "(Landroidx/compose/ui/Modifier;FILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "maxHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "maxVerticalPadding", "padding-6PoWaU8", "(Landroidx/compose/ui/Modifier;FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "start", "top", "end", "bottom", "maxStartPadding", "maxTopPadding", "maxEndPadding", "maxBottomPadding", "padding-s2pLCVw", "(Landroidx/compose/ui/Modifier;FFFFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "percentToDpByHeight", "(FLandroidx/compose/runtime/Composer;I)F", "percentToDpByWidth", "size", "size-LwRUR8o", "width", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sizeBySmallerPercentWithRatio", "maxWidth", "maxHeight", "ratio", "sizeBySmallerPercentWithRatio-nSlTg7c", "(Landroidx/compose/ui/Modifier;FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposeModifierUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeModifierUtils.kt\nandroidx/glance/oneui/template/utils/ComposeModifierUtilsKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,138:1\n174#2:139\n174#2:140\n174#2:141\n174#2:142\n174#2:143\n174#2:144\n189#2:145\n189#2:146\n189#2:147\n189#2:148\n174#2:149\n174#2:150\n189#2:151\n189#2:152\n74#3:153\n74#3:155\n88#4:154\n88#4:156\n*S KotlinDebug\n*F\n+ 1 ComposeModifierUtils.kt\nandroidx/glance/oneui/template/utils/ComposeModifierUtilsKt\n*L\n80#1:139\n81#1:140\n95#1:141\n96#1:142\n97#1:143\n98#1:144\n101#1:145\n102#1:146\n103#1:147\n104#1:148\n112#1:149\n113#1:150\n116#1:151\n117#1:152\n135#1:153\n137#1:155\n135#1:154\n137#1:156\n*E\n"})
public final class ComposeModifierUtilsKt {
    @NotNull
    public static final Modifier contentDescription(@NotNull Modifier modifier, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.oneui.template.utils.ComposeModifierUtilsKt.contentDescription.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, str);
            }
        }, 1, null) : modifier;
    }

    @Composable
    @NotNull
    public static final Modifier height(@NotNull Modifier modifier, @PercentRange float f, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceableGroup(171670803);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(171670803, i, -1, "androidx.glance.oneui.template.utils.height (ComposeModifierUtils.kt:52)");
        }
        Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(modifier, percentToDpByHeight(f, composer, (i >> 3) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM15885height3ABfNKs;
    }

    @NotNull
    public static final Modifier padding(@NotNull Modifier modifier, @NotNull DpRect padding) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return PaddingKt.m15857paddingqDBjuR0(modifier, padding.m21051getLeftD9Ej5fM(), padding.m21053getTopD9Ej5fM(), padding.m21052getRightD9Ej5fM(), padding.m21050getBottomD9Ej5fM());
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-6PoWaU8, reason: not valid java name */
    public static final Modifier m21956padding6PoWaU8(@NotNull Modifier padding, @PercentRange float f, @PercentRange float f4, float f5, float f6, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(742700683);
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if ((i2 & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(742700683, i, -1, "androidx.glance.oneui.template.utils.padding (ComposeModifierUtils.kt:113)");
        }
        Modifier modifierM15855paddingVpY3zN4 = PaddingKt.m15855paddingVpY3zN4(padding, C2256Dp.m20968constructorimpl(Math.min(percentToDpByWidth(f, composer, (i >> 3) & 14), f5)), C2256Dp.m20968constructorimpl(Math.min(percentToDpByHeight(f4, composer, (i >> 6) & 14), f6)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM15855paddingVpY3zN4;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-LwRUR8o, reason: not valid java name */
    public static final Modifier m21957paddingLwRUR8o(@NotNull Modifier padding, @PercentRange float f, int i, @Nullable Composer composer, int i2, int i4) {
        Modifier modifierM21958paddings2pLCVw;
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(-1891997009);
        int iM21380getAll3SpTkPA = (i4 & 2) != 0 ? PercentSizePolicy.INSTANCE.m21380getAll3SpTkPA() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1891997009, i2, -1, "androidx.glance.oneui.template.utils.padding (ComposeModifierUtils.kt:124)");
        }
        PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
        if (PercentSizePolicy.m21375equalsimpl0(iM21380getAll3SpTkPA, companion.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(-2099995156);
            modifierM21958paddings2pLCVw = PaddingKt.m15854padding3ABfNKs(padding, percentToDpByWidth(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else if (PercentSizePolicy.m21375equalsimpl0(iM21380getAll3SpTkPA, companion.m21381getHeight3SpTkPA())) {
            composer.startReplaceableGroup(-2099995074);
            modifierM21958paddings2pLCVw = PaddingKt.m15854padding3ABfNKs(padding, percentToDpByHeight(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2099995011);
            modifierM21958paddings2pLCVw = m21958paddings2pLCVw(padding, f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i2 & 126) | ((i2 << 3) & 896) | ((i2 << 6) & 7168) | ((i2 << 9) & 57344), 240);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM21958paddings2pLCVw;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: padding-s2pLCVw, reason: not valid java name */
    public static final Modifier m21958paddings2pLCVw(@NotNull Modifier padding, @PercentRange float f, @PercentRange float f4, @PercentRange float f5, @PercentRange float f6, float f7, float f8, float f9, float f10, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        composer.startReplaceableGroup(2047507819);
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
            ComposerKt.traceEventStart(2047507819, i, -1, "androidx.glance.oneui.template.utils.padding (ComposeModifierUtils.kt:98)");
        }
        Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(padding, C2256Dp.m20968constructorimpl(Math.min(percentToDpByWidth(f, composer, (i >> 3) & 14), f7)), C2256Dp.m20968constructorimpl(Math.min(percentToDpByHeight(f4, composer, (i >> 6) & 14), f8)), C2256Dp.m20968constructorimpl(Math.min(percentToDpByWidth(f5, composer, (i >> 9) & 14), f9)), C2256Dp.m20968constructorimpl(Math.min(percentToDpByHeight(f6, composer, (i >> 12) & 14), f10)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM15857paddingqDBjuR0;
    }

    @Composable
    private static final float percentToDpByHeight(float f, Composer composer, int i) {
        composer.startReplaceableGroup(1106234030);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1106234030, i, -1, "androidx.glance.oneui.template.utils.percentToDpByHeight (ComposeModifierUtils.kt:136)");
        }
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    private static final float percentToDpByWidth(float f, Composer composer, int i) {
        composer.startReplaceableGroup(-1908659353);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1908659353, i, -1, "androidx.glance.oneui.template.utils.percentToDpByWidth (ComposeModifierUtils.kt:134)");
        }
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    @NotNull
    public static final Modifier size(@NotNull Modifier modifier, @PercentRange float f, @PercentRange float f4, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceableGroup(-873901271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873901271, i, -1, "androidx.glance.oneui.template.utils.size (ComposeModifierUtils.kt:57)");
        }
        Modifier modifierHeight = height(width(modifier, f, composer, i & 126), f4, composer, (i >> 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierHeight;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: size-LwRUR8o, reason: not valid java name */
    public static final Modifier m21959sizeLwRUR8o(@NotNull Modifier size, @PercentRange float f, int i, @Nullable Composer composer, int i2, int i4) {
        Modifier modifierHeight;
        Intrinsics.checkNotNullParameter(size, "$this$size");
        composer.startReplaceableGroup(-112369075);
        if ((i4 & 2) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-112369075, i2, -1, "androidx.glance.oneui.template.utils.size (ComposeModifierUtils.kt:65)");
        }
        PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
        if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(790562103);
            modifierHeight = SizeKt.m15885height3ABfNKs(width(size, f, composer, i2 & 126), percentToDpByWidth(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21381getHeight3SpTkPA())) {
            composer.startReplaceableGroup(790562213);
            modifierHeight = height(SizeKt.m15904width3ABfNKs(size, percentToDpByHeight(f, composer, (i2 >> 3) & 14)), f, composer, i2 & 112);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(790562277);
            modifierHeight = height(width(size, f, composer, i2 & 126), f, composer, i2 & 112);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierHeight;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: sizeBySmallerPercentWithRatio-nSlTg7c, reason: not valid java name */
    public static final Modifier m21960sizeBySmallerPercentWithRationSlTg7c(@NotNull Modifier sizeBySmallerPercentWithRatio, @PercentRange float f, @PercentRange float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(sizeBySmallerPercentWithRatio, "$this$sizeBySmallerPercentWithRatio");
        composer.startReplaceableGroup(968646672);
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
        }
        float f8 = f5;
        float fM20968constructorimpl = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(Float.MAX_VALUE) : f6;
        float f9 = (i2 & 16) != 0 ? 1.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(968646672, i, -1, "androidx.glance.oneui.template.utils.sizeBySmallerPercentWithRatio (ComposeModifierUtils.kt:82)");
        }
        Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(sizeBySmallerPercentWithRatio, PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(f, f4, f8, fM20968constructorimpl, f9, composer, ((i >> 3) & 65534) | (PercentSizeUtils.$stable << 15), 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM15900size6HolHcs;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void visibility(@IntegerRes final int i, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-4895407);
        if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4895407, i4, -1, "androidx.glance.oneui.template.utils.visibility (ComposeModifierUtils.kt:40)");
            }
            if (PrimitiveResources_androidKt.integerResource(i, composerStartRestartGroup, i4 & 14) != 8) {
                content.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.ComposeModifierUtilsKt.visibility.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    ComposeModifierUtilsKt.visibility(i, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @Composable
    @NotNull
    public static final Modifier width(@NotNull Modifier modifier, @PercentRange float f, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceableGroup(2043766982);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2043766982, i, -1, "androidx.glance.oneui.template.utils.width (ComposeModifierUtils.kt:47)");
        }
        Modifier modifierM15904width3ABfNKs = SizeKt.m15904width3ABfNKs(modifier, percentToDpByWidth(f, composer, (i >> 3) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierM15904width3ABfNKs;
    }
}
