package androidx.glance.oneui.template.layout.compose.combine;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
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
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.text.FontWeight;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"SmallLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSmallLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmallLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/SmallLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,193:1\n74#2:194\n76#2:202\n76#2:235\n76#2:278\n76#2:312\n76#2:350\n75#3,6:195\n81#3:227\n85#3:270\n75#4:201\n76#4,11:203\n75#4:234\n76#4,11:236\n89#4:264\n89#4:269\n75#4:277\n76#4,11:279\n89#4:307\n75#4:311\n76#4,11:313\n89#4:345\n75#4:349\n76#4,11:351\n89#4:380\n460#5,13:214\n460#5,13:247\n473#5,3:261\n473#5,3:266\n460#5,13:290\n473#5,3:304\n460#5,13:324\n473#5,3:342\n460#5,13:362\n473#5,3:377\n67#6,6:228\n73#6:260\n77#6:265\n67#6,6:271\n73#6:303\n77#6:308\n78#7,2:309\n80#7:337\n84#7:346\n78#7,2:347\n80#7:375\n84#7:381\n154#8:338\n154#8:339\n154#8:340\n154#8:341\n154#8:376\n154#8:382\n154#8:383\n*S KotlinDebug\n*F\n+ 1 SmallLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/SmallLayoutKt\n*L\n40#1:194\n175#1:202\n187#1:235\n45#1:278\n67#1:312\n142#1:350\n175#1:195,6\n175#1:227\n175#1:270\n175#1:201\n175#1:203,11\n187#1:234\n187#1:236,11\n187#1:264\n175#1:269\n45#1:277\n45#1:279,11\n45#1:307\n67#1:311\n67#1:313,11\n67#1:345\n142#1:349\n142#1:351,11\n142#1:380\n175#1:214,13\n187#1:247,13\n187#1:261,3\n175#1:266,3\n45#1:290,13\n45#1:304,3\n67#1:324,13\n67#1:342,3\n142#1:362,13\n142#1:377,3\n187#1:228,6\n187#1:260\n187#1:265\n45#1:271,6\n45#1:303\n45#1:308\n67#1:309,2\n67#1:337\n67#1:346\n142#1:347,2\n142#1:375\n142#1:381\n90#1:338\n92#1:339\n113#1:340\n115#1:341\n151#1:376\n161#1:382\n168#1:383\n*E\n"})
public final class SmallLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SmallLayout(@Nullable Modifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(392442765);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        Function2<? super Composer, ? super Integer, Unit> function23 = (i2 & 8) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 16) == 0 ? function22 : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(392442765, i, -1, "androidx.glance.oneui.template.layout.compose.combine.SmallLayout (SmallLayout.kt:38)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion.getCenterVertically();
        composerStartRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
        final Modifier modifier3 = modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        SmallLayout$PrimaryContent(function26, primaryContentData, SizeKt.m15900size6HolHcs(companion3, PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, PercentSizeUtils.$stable << 15, 28)), composerStartRestartGroup, 0, 0);
        if (function25 != null) {
            composerStartRestartGroup.startReplaceableGroup(271578434);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function25.invoke(composerStartRestartGroup, Integer.valueOf((i >> 12) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else if (secondaryContentData != null) {
            composerStartRestartGroup.startReplaceableGroup(271578549);
            SmallLayout$SecondaryContent(mask, secondaryContentData, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(271578620);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.SmallLayoutKt.SmallLayout.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    SmallLayoutKt.SmallLayout(modifier3, primaryContentData, secondaryContentData, function26, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void SmallLayout$PrimaryContent(Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, Modifier modifier, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(613557393);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(613557393, i, -1, "androidx.glance.oneui.template.layout.compose.combine.SmallLayout.PrimaryContent (SmallLayout.kt:42)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(-1820176341);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer, 0, -1323940314);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer.startReplaceableGroup(-1820176241);
            CombineLayoutKt.PrimaryButtonContent(modifier, primaryContentData, composer, (i & 14) | 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1820176149);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void SmallLayout$SecondaryContent(int i, SecondaryContentData secondaryContentData, Composer composer, int i2) {
        composer.startReplaceableGroup(-585641337);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-585641337, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.SmallLayout.SecondaryContent (SmallLayout.kt:51)");
        }
        if (secondaryContentData.getTextList() != null) {
            composer.startReplaceableGroup(-700464687);
            SmallLayout$SecondaryContent$SecondaryTextListContent(secondaryContentData, i, PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(5), 0.0f, 0.0f, 0.0f, 14, null), secondaryContentData.getTextList(), composer, 70);
            composer.endReplaceableGroup();
        } else if (secondaryContentData.getFirstProgressBar() == null || secondaryContentData.getSecondProgressBar() == null) {
            composer.startReplaceableGroup(-700464107);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-700464385);
            SmallLayout$SecondaryContent$SecondaryProgressListContent(PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(3), 0.0f, 0.0f, 0.0f, 14, null), secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer, 582);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void SmallLayout$SecondaryContent$SecondaryProgressListContent(Modifier modifier, LinearProgressData linearProgressData, LinearProgressData linearProgressData2, Composer composer, int i) {
        composer.startReplaceableGroup(190145984);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(190145984, i, -1, "androidx.glance.oneui.template.layout.compose.combine.SmallLayout.SecondaryContent.SecondaryProgressListContent (SmallLayout.kt:140)");
        }
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        composer.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.32f, composer, 54), linearProgressData, composer, 64, 0);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(4)), composer, 6);
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.32f, composer, 54), linearProgressData2, composer, 64, 0);
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
    private static final void SmallLayout$SecondaryContent$SecondaryTextListContent(SecondaryContentData secondaryContentData, int i, Modifier modifier, TypedTextListData typedTextListData, Composer composer, int i2) {
        composer.startReplaceableGroup(-227154893);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-227154893, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.SmallLayout.SecondaryContent.SecondaryTextListContent (SmallLayout.kt:55)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        if (secondaryContentData.getTextList() != null && !secondaryContentData.getTextList().getItems().isEmpty()) {
            List<TypedTextData> items = secondaryContentData.getTextList().getItems();
            TypedTextData typedTextData = items.get(0);
            String text = typedTextData.getText();
            if ((text != null ? text.length() : 0) <= 8) {
                typedTextData.setMaxLines$glance_oneui_template_release(1);
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, start, composer, 54);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int textType = typedTextData.getTextType();
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType, companion2.m21694getTitlegxbDmow())) {
                composer.startReplaceableGroup(1548475467);
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(null, i, typedTextData, companion2.m21694getTitlegxbDmow(), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i, companion2.m21694getTitlegxbDmow(), typedTextData.getMaxLines()), composer, 3072, 97);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1548476077);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierM15815offsetVpY3zN4$default = OffsetKt.m15815offsetVpY3zN4$default(PaddingKt.m15858paddingqDBjuR0$default(SizeKt.wrapContentSize$default(companion3, null, false, 3, null), C2256Dp.m20968constructorimpl(!TextType.m21684equalsimpl0(typedTextData.getTextType(), companion2.m21691getDisplaygxbDmow()) ? 2 : 0), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, C2256Dp.m20968constructorimpl(1), 1, null);
                int textType2 = typedTextData.getTextType();
                int iM21999getSemiBoldWjrlUT0 = TextType.m21684equalsimpl0(typedTextData.getTextType(), companion2.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0();
                CombineTemplatePercent combineTemplatePercent = CombineTemplatePercent.INSTANCE;
                AppWidgetSize.Companion companion4 = AppWidgetSize.INSTANCE;
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(modifierM15815offsetVpY3zN4$default, i, typedTextData, textType2, iM21999getSemiBoldWjrlUT0, null, 0.0f, combineTemplatePercent.m21939getTextViewHeightPercenttZlUyYw(companion4.m21570getSmallrx25Pp4(), typedTextData.getTextType(), typedTextData.getMaxLines()), composer, 0, 96);
                if (items.size() > 1) {
                    TypedTextData typedTextData2 = items.get(1);
                    CombineLayoutKt.m21825ComposeCombineText57gRyVA(OffsetKt.m15815offsetVpY3zN4$default(PaddingKt.m15858paddingqDBjuR0$default(SizeKt.wrapContentSize$default(companion3, null, false, 3, null), C2256Dp.m20968constructorimpl(!TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion2.m21691getDisplaygxbDmow()) ? 2 : 0), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, C2256Dp.m20968constructorimpl(-1), 1, null), i, typedTextData2, typedTextData2.getTextType(), TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion2.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21996getBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, combineTemplatePercent.m21939getTextViewHeightPercenttZlUyYw(companion4.m21570getSmallrx25Pp4(), typedTextData2.getTextType(), typedTextData2.getMaxLines()), composer, 0, 96);
                }
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
