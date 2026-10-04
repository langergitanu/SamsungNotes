package androidx.glance.oneui.template.layout.compose.combine;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.glance.AbstractC2821a;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.layout.Alignment;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ah\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m13886d2 = {"MediumLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "MediumLayout-fWZZ6NI", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMediumLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediumLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/MediumLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 7 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 8 Row.kt\nandroidx/compose/foundation/layout/RowKt\n*L\n1#1,257:1\n74#2:258\n74#2:259\n76#2:266\n76#2:299\n76#2:341\n76#2:375\n76#2:410\n76#2:449\n76#2:487\n76#2:521\n76#2:560\n76#2:593\n76#2:632\n76#2:665\n76#2:703\n68#3,5:260\n73#3:291\n67#3,6:292\n73#3:324\n77#3:329\n77#3:334\n68#3,5:335\n73#3:366\n77#3:371\n68#3,5:481\n73#3:512\n77#3:517\n67#3,6:586\n73#3:618\n77#3:623\n67#3,6:658\n73#3:690\n77#3:695\n67#3,6:696\n73#3:728\n77#3:733\n75#4:265\n76#4,11:267\n75#4:298\n76#4,11:300\n89#4:328\n89#4:333\n75#4:340\n76#4,11:342\n89#4:370\n75#4:374\n76#4,11:376\n89#4:405\n75#4:409\n76#4,11:411\n89#4:440\n75#4:448\n76#4,11:450\n89#4:479\n75#4:486\n76#4,11:488\n89#4:516\n75#4:520\n76#4,11:522\n89#4:550\n75#4:559\n76#4,11:561\n75#4:592\n76#4,11:594\n89#4:622\n89#4:627\n75#4:631\n76#4,11:633\n75#4:664\n76#4,11:666\n89#4:694\n75#4:702\n76#4,11:704\n89#4:732\n89#4:737\n460#5,13:278\n460#5,13:311\n473#5,3:325\n473#5,3:330\n460#5,13:353\n473#5,3:367\n460#5,13:387\n473#5,3:402\n460#5,13:422\n473#5,3:437\n460#5,13:461\n473#5,3:476\n460#5,13:499\n473#5,3:513\n460#5,13:533\n473#5,3:547\n460#5,13:572\n460#5,13:605\n473#5,3:619\n473#5,3:624\n460#5,13:644\n460#5,13:677\n473#5,3:691\n460#5,13:715\n473#5,3:729\n473#5,3:734\n78#6,2:372\n80#6:400\n84#6:406\n74#6,6:442\n80#6:474\n84#6:480\n78#6,2:518\n80#6:546\n84#6:551\n74#6,6:553\n80#6:585\n84#6:628\n78#6,2:629\n80#6:657\n84#6:738\n154#7:401\n154#7:436\n154#7:475\n154#7:552\n79#8,2:407\n81#8:435\n85#8:441\n*S KotlinDebug\n*F\n+ 1 MediumLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/MediumLayoutKt\n*L\n43#1:258\n44#1:259\n58#1:266\n60#1:299\n87#1:341\n102#1:375\n122#1:410\n151#1:449\n167#1:487\n171#1:521\n195#1:560\n202#1:593\n218#1:632\n228#1:665\n239#1:703\n58#1:260,5\n58#1:291\n60#1:292,6\n60#1:324\n60#1:329\n58#1:334\n87#1:335,5\n87#1:366\n87#1:371\n167#1:481,5\n167#1:512\n167#1:517\n202#1:586,6\n202#1:618\n202#1:623\n228#1:658,6\n228#1:690\n228#1:695\n239#1:696,6\n239#1:728\n239#1:733\n58#1:265\n58#1:267,11\n60#1:298\n60#1:300,11\n60#1:328\n58#1:333\n87#1:340\n87#1:342,11\n87#1:370\n102#1:374\n102#1:376,11\n102#1:405\n122#1:409\n122#1:411,11\n122#1:440\n151#1:448\n151#1:450,11\n151#1:479\n167#1:486\n167#1:488,11\n167#1:516\n171#1:520\n171#1:522,11\n171#1:550\n195#1:559\n195#1:561,11\n202#1:592\n202#1:594,11\n202#1:622\n195#1:627\n218#1:631\n218#1:633,11\n228#1:664\n228#1:666,11\n228#1:694\n239#1:702\n239#1:704,11\n239#1:732\n218#1:737\n58#1:278,13\n60#1:311,13\n60#1:325,3\n58#1:330,3\n87#1:353,13\n87#1:367,3\n102#1:387,13\n102#1:402,3\n122#1:422,13\n122#1:437,3\n151#1:461,13\n151#1:476,3\n167#1:499,13\n167#1:513,3\n171#1:533,13\n171#1:547,3\n195#1:572,13\n202#1:605,13\n202#1:619,3\n195#1:624,3\n218#1:644,13\n228#1:677,13\n228#1:691,3\n239#1:715,13\n239#1:729,3\n218#1:734,3\n102#1:372,2\n102#1:400\n102#1:406\n151#1:442,6\n151#1:474\n151#1:480\n171#1:518,2\n171#1:546\n171#1:551\n195#1:553,6\n195#1:585\n195#1:628\n218#1:629,2\n218#1:657\n218#1:738\n113#1:401\n133#1:436\n156#1:475\n197#1:552\n122#1:407,2\n122#1:435\n122#1:441\n*E\n"})
public final class MediumLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: MediumLayout-fWZZ6NI, reason: not valid java name */
    public static final void m21827MediumLayoutfWZZ6NI(@Nullable Modifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, int i2, final int i4) {
        final int i5;
        final int iM21429getBottommnfRV0w;
        int i6;
        Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(417303145);
        Modifier modifier3 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i4 & 8) != 0) {
            i5 = i2;
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
            i6 = i5 & (-7169);
        } else {
            i5 = i2;
            iM21429getBottommnfRV0w = i;
            i6 = i5;
        }
        final Function2<? super Composer, ? super Integer, Unit> function23 = (i4 & 16) != 0 ? null : function2;
        final Function2<? super Composer, ? super Integer, Unit> function24 = (i4 & 32) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(417303145, i6, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout (MediumLayout.kt:41)");
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, mask);
        long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 0);
        if (secondaryContentData == null && function24 == null) {
            composerStartRestartGroup.startReplaceableGroup(50227223);
            Modifier modifier4 = modifier3;
            MediumLayout_fWZZ6NI$OnlyPrimaryContent(function23, jM21383getMinDpSizeFromPercentDataM_xkUdw, modifier4, primaryContentData, composerStartRestartGroup, (i6 & 14) | 64, 0);
            modifier2 = modifier4;
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        } else {
            modifier2 = modifier3;
            composerStartRestartGroup.startReplaceableGroup(50227311);
            MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent(iM21429getBottommnfRV0w, function23, jM21383getMinDpSizeFromPercentDataM_xkUdw, primaryContentData, function24, mask, modifier2, secondaryContentData, composerStartRestartGroup, (i6 & 14) | 64);
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.MediumLayoutKt$MediumLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i7) {
                    MediumLayoutKt.m21827MediumLayoutfWZZ6NI(modifier5, primaryContentData, secondaryContentData, iM21429getBottommnfRV0w, function23, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void MediumLayout_fWZZ6NI$OnlyPrimaryContent(Function2<? super Composer, ? super Integer, Unit> function2, long j, Modifier modifier, PrimaryContentData primaryContentData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-623917014);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-623917014, i, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout.OnlyPrimaryContent (MediumLayout.kt:56)");
        }
        Alignment.Companion companion = androidx.compose.p109ui.Alignment.INSTANCE;
        androidx.compose.p109ui.Alignment center = companion.getCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
        Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (function2 != null) {
            composer.startReplaceableGroup(510464099);
            Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer, 0, -1323940314);
            Density density2 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15900size6HolHcs);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer.startReplaceableGroup(510464224);
            CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j), primaryContentData, composer, 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(510464400);
            composer.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent(int i, Function2<? super Composer, ? super Integer, Unit> function2, long j, PrimaryContentData primaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, int i2, Modifier modifier, SecondaryContentData secondaryContentData, Composer composer, int i4) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(693868134);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(693868134, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout.PrimaryWithSecondaryContent (MediumLayout.kt:70)");
        }
        if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) == null || secondaryContentData.getSecondProgressBar() == null) {
            composer2.startReplaceableGroup(-170848514);
            Alignment.Companion companion = androidx.glance.layout.Alignment.INSTANCE;
            Modifier modifierM21958paddings2pLCVw = ComposeModifierUtilsKt.m21958paddings2pLCVw(modifier, 0.0f, Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w()) ? 0.12f : 0.1f, 0.0f, Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w()) ? 0.1f : 0.12f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, i4 & 14, 245);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Companion companion2 = androidx.compose.p109ui.Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer2, 54);
            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM21958paddings2pLCVw);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w())) {
                composer2.startReplaceableGroup(-326068734);
                if (function2 != null) {
                    composer2.startReplaceableGroup(-326068684);
                    Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer2, 0, -1323940314);
                    Density density2 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15900size6HolHcs);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    function2.invoke(composer2, 0);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                } else if (primaryContentData != null) {
                    composer2.startReplaceableGroup(-326068543);
                    CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j), primaryContentData, composer2, 64);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-326068327);
                    composer2.endReplaceableGroup();
                }
                composer2 = composer2;
                MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(function22, secondaryContentData, i, i2, ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-326068237);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                composer2 = composer2;
                MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(function22, secondaryContentData, i, i2, ColumnScope.weight$default(columnScopeInstance, companion4, 1.0f, false, 2, null), composer2, 0);
                if (function2 != null) {
                    composer2.startReplaceableGroup(-326068121);
                    Modifier modifierM15900size6HolHcs2 = SizeKt.m15900size6HolHcs(companion4, j);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion2, false, composer2, 0, -1323940314);
                    Density density3 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15900size6HolHcs2);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
                    function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    function2.invoke(composer2, 0);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                } else if (primaryContentData != null) {
                    composer2.startReplaceableGroup(-326067980);
                    CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(companion4, j), primaryContentData, composer2, 64);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-326067764);
                    composer2.endReplaceableGroup();
                }
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-170849563);
            Modifier.Companion companion5 = Modifier.INSTANCE;
            float f = 14;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), 2, null);
            Alignment.Companion companion6 = androidx.compose.p109ui.Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally2 = companion6.getCenterHorizontally();
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor4 = companion7.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion7, composerM18018constructorimpl4, measurePolicyColumnMeasurePolicy2, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion7, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, companion5, 1.0f, false, 2, null), composer2, 0);
            if (function2 != null) {
                composer2.startReplaceableGroup(-326069918);
                Modifier modifierM15900size6HolHcs3 = SizeKt.m15900size6HolHcs(companion5, j);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion6, false, composer2, 0, -1323940314);
                Density density5 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor5 = companion7.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM15900size6HolHcs3);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion7, composerM18018constructorimpl5, measurePolicyM1210k3, composerM18018constructorimpl5, density5));
                function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion7, composerM18018constructorimpl5, viewConfiguration5, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                function2.invoke(composer2, 0);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else if (primaryContentData != null) {
                composer2.startReplaceableGroup(-326069785);
                CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(companion5, j), primaryContentData, composer2, 64);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-326069589);
                composer2.endReplaceableGroup();
            }
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, companion5, 1.0f, false, 2, null), composer2, 0);
            m2308x678638b5(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(companion5, null, false, 3, null), 0.0f, 1, null), secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer2, 582);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(Function2<? super Composer, ? super Integer, Unit> function2, SecondaryContentData secondaryContentData, int i, int i2, Modifier modifier, Composer composer, int i4) {
        composer.startReplaceableGroup(1180103324);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180103324, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout.PrimaryWithSecondaryContent.SecondContent (MediumLayout.kt:164)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(2049444944);
            androidx.compose.p109ui.Alignment center = androidx.compose.p109ui.Alignment.INSTANCE.getCenter();
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
            Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            if ((secondaryContentData != null ? secondaryContentData.getTextList() : null) != null) {
                composer.startReplaceableGroup(2049445159);
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally = androidx.compose.p109ui.Alignment.INSTANCE.getCenterHorizontally();
                composer.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer, 54);
                Density density2 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
                LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier);
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
                composer.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion3, 1.0f, false, 2, null), composer, 0);
                m2309x9f528135(i, i2, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null), secondaryContentData.getTextList(), composer, 70);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion3, 2.0f, false, 2, null), composer, 0);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) == null || secondaryContentData.getSecondProgressBar() == null) {
                    composer.startReplaceableGroup(2049446146);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(2049445880);
                    m2308x678638b5(modifier, secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer, (i4 & 14) | Units.MASTER_DPI);
                    composer.endReplaceableGroup();
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondaryProgressListContent */
    private static final void m2308x678638b5(Modifier modifier, LinearProgressData linearProgressData, LinearProgressData linearProgressData2, Composer composer, int i) {
        composer.startReplaceableGroup(2062146573);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2062146573, i, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryProgressListContent (MediumLayout.kt:149)");
        }
        composer.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(androidx.compose.p109ui.Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer, 0, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.15f, composer, 54), linearProgressData, composer, 64, 0);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(8)), composer, 6);
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.15f, composer, 54), linearProgressData2, composer, 64, 0);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondaryTextListContent */
    private static final void m2309x9f528135(int i, int i2, Modifier modifier, TypedTextListData typedTextListData, Composer composer, int i4) {
        composer.startReplaceableGroup(-1662628038);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1662628038, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryTextListContent (MediumLayout.kt:73)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        float f = 0.06f;
        if (Alignment.Vertical.m21448equalsimpl0(i, androidx.glance.layout.Alignment.INSTANCE.m21429getBottommnfRV0w())) {
            if (AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) > 0) {
                f = 0.05f;
            }
        } else if (typedTextListData.getItems().size() != 1 || !TextType.m21684equalsimpl0(typedTextListData.getItems().get(0).getTextType(), TextType.INSTANCE.m21694getTitlegxbDmow())) {
            f = 0.12f;
        }
        float f4 = f;
        if (typedTextListData.getItems().size() == 1) {
            composer.startReplaceableGroup(-695312707);
            TypedTextData typedTextData = typedTextListData.getItems().get(0);
            Modifier modifierM21956padding6PoWaU8 = ComposeModifierUtilsKt.m21956padding6PoWaU8(modifier, f4, 0.0f, 0.0f, 0.0f, composer, (i4 & 14) | 384, 12);
            androidx.compose.p109ui.Alignment center = androidx.compose.p109ui.Alignment.INSTANCE.getCenter();
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
            Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM21956padding6PoWaU8);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), i2, typedTextData, typedTextData.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-695312136);
            TypedTextData typedTextData2 = typedTextListData.getItems().get(0);
            TypedTextData typedTextData3 = typedTextListData.getItems().get(1);
            if (typedTextListData.getOrientation() == Orientation.Vertical) {
                composer.startReplaceableGroup(-695311967);
                Modifier modifierM21956padding6PoWaU82 = ComposeModifierUtilsKt.m21956padding6PoWaU8(modifier, 0.12f, 0.0f, 0.0f, 0.0f, composer, (i4 & 14) | 432, 12);
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally = androidx.compose.p109ui.Alignment.INSTANCE.getCenterHorizontally();
                composer.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer, 54);
                Density density2 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
                LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM21956padding6PoWaU82);
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
                composer.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(companion3, null, false, 3, null), i2, typedTextData2, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
                SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(1)), composer, 6);
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(companion3, null, false, 3, null), i2, typedTextData3, typedTextData3.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-695310963);
                Alignment.Vertical centerVertically = androidx.compose.p109ui.Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                composer.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center3, centerVertically, composer, 54);
                Density density3 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
                LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier);
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
                composer.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion5 = Modifier.INSTANCE;
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(companion5, null, false, 3, null), i2, typedTextData2, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
                SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion5, C2256Dp.m20968constructorimpl(1)), composer, 6);
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(companion5, null, false, 3, null), i2, typedTextData3, typedTextData3.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
