package androidx.glance.oneui.template.layout.compose.combine;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
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
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.TertiaryContentData;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.layout.glance.ListLayoutKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"LargeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "tertiaryData", "Landroidx/glance/oneui/template/TertiaryContentData;", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "LargeLayout-TafRHR0", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/glance/oneui/template/TertiaryContentData;IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLargeLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LargeLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/LargeLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 7 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,160:1\n74#2:161\n76#2:169\n76#2:202\n76#2:245\n76#2:283\n76#2:321\n76#2:354\n76#2:387\n76#2:426\n76#2:474\n76#2:507\n76#2:546\n76#2:588\n74#2:614\n75#3,6:162\n81#3:194\n85#3:237\n75#3,6:238\n81#3:270\n85#3:275\n75#3,6:347\n81#3:379\n85#3:461\n75#3,6:467\n81#3:499\n85#3:581\n75#4:168\n76#4,11:170\n75#4:201\n76#4,11:203\n89#4:231\n89#4:236\n75#4:244\n76#4,11:246\n89#4:274\n75#4:282\n76#4,11:284\n89#4:312\n75#4:320\n76#4,11:322\n75#4:353\n76#4,11:355\n75#4:386\n76#4,11:388\n89#4:416\n75#4:425\n76#4,11:427\n89#4:455\n89#4:460\n89#4:465\n75#4:473\n76#4,11:475\n75#4:506\n76#4,11:508\n89#4:536\n75#4:545\n76#4,11:547\n89#4:575\n89#4:580\n75#4:587\n76#4,11:589\n89#4:618\n460#5,13:181\n460#5,13:214\n473#5,3:228\n473#5,3:233\n460#5,13:257\n473#5,3:271\n460#5,13:295\n473#5,3:309\n460#5,13:333\n460#5,13:366\n460#5,13:399\n473#5,3:413\n460#5,13:438\n473#5,3:452\n473#5,3:457\n473#5,3:462\n460#5,13:486\n460#5,13:519\n473#5,3:533\n460#5,13:558\n473#5,3:572\n473#5,3:577\n460#5,13:600\n473#5,3:615\n67#6,6:195\n73#6:227\n77#6:232\n67#6,6:276\n73#6:308\n77#6:313\n67#6,6:419\n73#6:451\n77#6:456\n67#6,6:500\n73#6:532\n77#6:537\n67#6,6:539\n73#6:571\n77#6:576\n68#6,5:582\n73#6:613\n77#6:619\n154#7:314\n154#7:418\n154#7:538\n75#8,5:315\n80#8:346\n74#8,6:380\n80#8:412\n84#8:417\n84#8:466\n*S KotlinDebug\n*F\n+ 1 LargeLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/LargeLayoutKt\n*L\n50#1:161\n144#1:169\n150#1:202\n157#1:245\n65#1:283\n78#1:321\n82#1:354\n86#1:387\n97#1:426\n103#1:474\n104#1:507\n105#1:546\n119#1:588\n120#1:614\n144#1:162,6\n144#1:194\n144#1:237\n157#1:238,6\n157#1:270\n157#1:275\n82#1:347,6\n82#1:379\n82#1:461\n103#1:467,6\n103#1:499\n103#1:581\n144#1:168\n144#1:170,11\n150#1:201\n150#1:203,11\n150#1:231\n144#1:236\n157#1:244\n157#1:246,11\n157#1:274\n65#1:282\n65#1:284,11\n65#1:312\n78#1:320\n78#1:322,11\n82#1:353\n82#1:355,11\n86#1:386\n86#1:388,11\n86#1:416\n97#1:425\n97#1:427,11\n97#1:455\n82#1:460\n78#1:465\n103#1:473\n103#1:475,11\n104#1:506\n104#1:508,11\n104#1:536\n105#1:545\n105#1:547,11\n105#1:575\n103#1:580\n119#1:587\n119#1:589,11\n119#1:618\n144#1:181,13\n150#1:214,13\n150#1:228,3\n144#1:233,3\n157#1:257,13\n157#1:271,3\n65#1:295,13\n65#1:309,3\n78#1:333,13\n82#1:366,13\n86#1:399,13\n86#1:413,3\n97#1:438,13\n97#1:452,3\n82#1:457,3\n78#1:462,3\n103#1:486,13\n104#1:519,13\n104#1:533,3\n105#1:558,13\n105#1:572,3\n103#1:577,3\n119#1:600,13\n119#1:615,3\n150#1:195,6\n150#1:227\n150#1:232\n65#1:276,6\n65#1:308\n65#1:313\n97#1:419,6\n97#1:451\n97#1:456\n104#1:500,6\n104#1:532\n104#1:537\n105#1:539,6\n105#1:571\n105#1:576\n119#1:582,5\n119#1:613\n119#1:619\n79#1:314\n97#1:418\n107#1:538\n78#1:315,5\n78#1:346\n86#1:380,6\n86#1:412\n86#1:417\n78#1:466\n*E\n"})
public final class LargeLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LargeLayout-TafRHR0, reason: not valid java name */
    public static final void m21826LargeLayoutTafRHR0(@Nullable Modifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable final TertiaryContentData tertiaryContentData, final int i, final int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-48659794);
        Modifier modifier2 = (i5 & 1) != 0 ? Modifier.INSTANCE : modifier;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 64) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 128) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i5 & 256) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-48659794, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.LargeLayout (LargeLayout.kt:48)");
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        CombineTemplatePercent combineTemplatePercent = CombineTemplatePercent.INSTANCE;
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = combineTemplatePercent.m21937getButtonSizeL2j3NV4(companion.m21568getLargerx25Pp4());
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, companion.m21568getLargerx25Pp4());
        long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 0);
        if (tertiaryContentData == null && function28 == null) {
            composerStartRestartGroup.startReplaceableGroup(-272415217);
            if (secondaryContentData == null && function27 == null) {
                function24 = function26;
                function25 = function27;
            } else {
                Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                LargeLayout_TafRHR0$SecondaryContent(function29, jM21383getMinDpSizeFromPercentDataM_xkUdw, primaryContentData, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), secondaryContentData, function210, composerStartRestartGroup, ((i4 >> 15) & 896) | 70);
                function24 = function29;
                function25 = function210;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
        } else {
            function24 = function26;
            function25 = function27;
            if (Alignment.Horizontal.m21438equalsimpl0(i2, Alignment.INSTANCE.m21432getEndPGIyAqw())) {
                composerStartRestartGroup.startReplaceableGroup(-272414868);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment.Companion companion2 = androidx.compose.p109ui.Alignment.INSTANCE;
                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion2, start, composerStartRestartGroup, 0, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1208i, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MediumLayoutKt.m21827MediumLayoutfWZZ6NI(RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null), primaryContentData, secondaryContentData, 0, null, null, composerStartRestartGroup, Units.MASTER_DPI, 56);
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(206148678);
                if (tertiaryContentData != null) {
                    LargeLayout_TafRHR0$TertiaryContent(function28, SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), tertiaryContentData, composerStartRestartGroup, 70, 0);
                    composer2 = composerStartRestartGroup;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(-272414374);
                composer2.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(androidx.compose.p109ui.Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composer2, 0, -1323940314);
                Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier2);
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
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function211 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function212 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function213 = function28;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.LargeLayoutKt$LargeLayout$3
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

                public final void invoke(@Nullable Composer composer3, int i6) {
                    LargeLayoutKt.m21826LargeLayoutTafRHR0(modifier3, primaryContentData, secondaryContentData, tertiaryContentData, i, i2, function211, function212, function213, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    private static final void LargeLayout_TafRHR0$SecondaryContent(Function2<? super Composer, ? super Integer, Unit> function2, long j, PrimaryContentData primaryContentData, Modifier modifier, SecondaryContentData secondaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1092421327);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1092421327, i, -1, "androidx.glance.oneui.template.layout.compose.combine.LargeLayout.SecondaryContent (LargeLayout.kt:75)");
        }
        if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) != null && secondaryContentData.getSecondProgressBar() != null) {
            composer2.startReplaceableGroup(-1827308084);
            Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(modifier, C2256Dp.m20968constructorimpl(14), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical bottom = arrangement.getBottom();
            composer2.startReplaceableGroup(-483455358);
            Alignment.Companion companion = androidx.compose.p109ui.Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion, bottom, composer2, 6, -1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierM21958paddings2pLCVw = ComposeModifierUtilsKt.m21958paddings2pLCVw(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null), 0.0f, 0.0f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 24582, 247);
            Alignment.Vertical bottom2 = companion.getBottom();
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(arrangement, bottom2, composer, 48, -1323940314);
            Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM21958paddings2pLCVw);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1207h, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(RowScope.weight$default(RowScopeInstance.INSTANCE, companion3, 1.0f, false, 2, null), null, false, 3, null);
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyM1209j2 = AbstractC1038a.m1209j(companion, arrangement.getTop(), composer, 0, -1323940314);
            Density density3 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1209j2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            Modifier modifierHeight = ComposeModifierUtilsKt.height(companion3, 0.1675f, composer, 54);
            LinearProgressData firstProgressBar = secondaryContentData.getFirstProgressBar();
            Intrinsics.checkNotNull(firstProgressBar);
            ProgressIndicatorKt.ComposeLinearProgressIndicator(modifierHeight, firstProgressBar, composer, 64, 0);
            composer2 = composer;
            SpacerKt.Spacer(ComposeModifierUtilsKt.m21959sizeLwRUR8o(companion3, 0.05f, 0, composer, 54, 2), composer2, 0);
            Modifier modifierHeight2 = ComposeModifierUtilsKt.height(companion3, 0.1675f, composer2, 54);
            LinearProgressData secondProgressBar = secondaryContentData.getSecondProgressBar();
            Intrinsics.checkNotNull(secondProgressBar);
            ProgressIndicatorKt.ComposeLinearProgressIndicator(modifierHeight2, secondProgressBar, composer2, 64, 0);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(companion3, null, false, 3, null);
            float f = 8;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(modifierWrapContentSize$default, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), 0.0f, 0.0f, 12, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer2, 0, -1323940314);
            Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
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
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl4, measurePolicyM1210k, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LargeLayout_TafRHR0$SingleButtonContent(function2, j, primaryContentData, composer2, 0);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else if (function22 != null) {
            composer2.startReplaceableGroup(-1827306880);
            Modifier modifierM21958paddings2pLCVw2 = ComposeModifierUtilsKt.m21958paddings2pLCVw(modifier, 0.0f, 0.0f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i & 14) | 24576, 247);
            composer2 = composer;
            Alignment.Companion companion4 = androidx.compose.p109ui.Alignment.INSTANCE;
            Alignment.Vertical bottom3 = companion4.getBottom();
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, bottom3, composer2, 48, -1323940314);
            Density density5 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor5 = companion5.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM21958paddings2pLCVw2);
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
            Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl5, measurePolicyM1207h2, composerM18018constructorimpl5, density5));
            function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl5, viewConfiguration5, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion6 = Modifier.INSTANCE;
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion6, 1.0f, false, 2, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion4, false, composer2, 0, -1323940314);
            Density density6 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor6 = companion5.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierWeight$default);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor6);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl6, measurePolicyM1210k2, composerM18018constructorimpl6, density6));
            function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl6, viewConfiguration6, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            function22.invoke(composer2, Integer.valueOf((i >> 6) & 14));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            float f4 = 10;
            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.wrapContentSize$default(companion6, null, false, 3, null), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(14), 0.0f, 8, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion4, false, composer2, 0, -1323940314);
            Density density7 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection7 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration7 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor7 = companion5.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor7);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl7 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl7, layoutDirection7, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl7, measurePolicyM1210k3, composerM18018constructorimpl7, density7));
            function3MaterializerOf7.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl7, viewConfiguration7, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            LargeLayout_TafRHR0$SingleButtonContent(function2, j, primaryContentData, composer2, 0);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-1827306447);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void LargeLayout_TafRHR0$SingleButtonContent(Function2<? super Composer, ? super Integer, Unit> function2, long j, PrimaryContentData primaryContentData, Composer composer, int i) {
        composer.startReplaceableGroup(609855317);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(609855317, i, -1, "androidx.glance.oneui.template.layout.compose.combine.LargeLayout.SingleButtonContent (LargeLayout.kt:62)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(5082289);
            Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(androidx.compose.p109ui.Alignment.INSTANCE, false, composer, 0, -1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15900size6HolHcs);
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
            composer.startReplaceableGroup(5082406);
            CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(Modifier.INSTANCE, j), primaryContentData, composer, 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(5082515);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void LargeLayout_TafRHR0$TertiaryContent(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, TertiaryContentData tertiaryContentData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1566412257);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1566412257, i, -1, "androidx.glance.oneui.template.layout.compose.combine.LargeLayout.TertiaryContent (LargeLayout.kt:115)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(-305617783);
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
        } else if (tertiaryContentData.getList() != null) {
            composer.startReplaceableGroup(-305617705);
            LargeLayout_TafRHR0$TertiaryContent$TertiaryListContent(modifier, tertiaryContentData.getList(), composer, (i & 14) | 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-305617611);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void LargeLayout_TafRHR0$TertiaryContent$TertiaryListContent(Modifier modifier, ListData listData, Composer composer, int i) {
        composer.startReplaceableGroup(35931535);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(35931535, i, -1, "androidx.glance.oneui.template.layout.compose.combine.LargeLayout.TertiaryContent.TertiaryListContent (LargeLayout.kt:117)");
        }
        androidx.compose.p109ui.Alignment center = androidx.compose.p109ui.Alignment.INSTANCE.getCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
        Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
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
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (Intrinsics.areEqual(composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-1846431113);
            ListLayoutKt.m21844GlanceListLayoutYlGCr2M(listData, false, false, 0.0f, 0.0f, false, false, composer, 8, 126);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1846431034);
            androidx.glance.oneui.template.layout.compose.ListLayoutKt.m21804ComposeListLayoutYlGCr2M(listData, false, false, 0.0f, 0.0f, false, false, composer, 8, 126);
            composer.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
