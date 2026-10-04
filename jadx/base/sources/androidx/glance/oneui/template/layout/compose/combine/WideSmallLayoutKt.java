package androidx.glance.oneui.template.layout.compose.combine;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TertiaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.FontWeight;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001az\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"WideSmallLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "tertiaryData", "Landroidx/glance/oneui/template/TertiaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/glance/oneui/template/TertiaryContentData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWideSmallLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WideSmallLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/WideSmallLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,373:1\n74#2:374\n74#2:375\n74#2:378\n76#2:386\n76#2:419\n76#2:457\n76#2:495\n76#2:534\n76#2:567\n76#2:600\n76#2:639\n76#2:683\n76#2:715\n76#2:764\n76#2:797\n76#2:840\n76#2:873\n174#3:376\n174#3:377\n154#3:450\n154#3:488\n154#3:631\n154#3:675\n154#3:741\n154#3:904\n154#3:905\n75#4,6:379\n81#4:411\n85#4:530\n79#4,2:531\n81#4:559\n75#4,6:560\n81#4:592\n75#4,6:632\n81#4:664\n85#4:669\n85#4:674\n75#4,6:676\n81#4:708\n85#4:751\n85#4:756\n75#4,6:757\n81#4:789\n85#4:832\n75#4,6:833\n81#4:865\n85#4:910\n75#5:385\n76#5,11:387\n75#5:418\n76#5,11:420\n89#5:448\n75#5:456\n76#5,11:458\n89#5:486\n75#5:494\n76#5,11:496\n89#5:524\n89#5:529\n75#5:533\n76#5,11:535\n75#5:566\n76#5,11:568\n75#5:599\n76#5,11:601\n89#5:629\n75#5:638\n76#5,11:640\n89#5:668\n89#5:673\n75#5:682\n76#5,11:684\n75#5:714\n76#5,11:716\n89#5:745\n89#5:750\n89#5:755\n75#5:763\n76#5,11:765\n75#5:796\n76#5,11:798\n89#5:826\n89#5:831\n75#5:839\n76#5,11:841\n75#5:872\n76#5,11:874\n89#5:902\n89#5:909\n460#6,13:398\n460#6,13:431\n473#6,3:445\n460#6,13:469\n473#6,3:483\n460#6,13:507\n473#6,3:521\n473#6,3:526\n460#6,13:546\n460#6,13:579\n460#6,13:612\n473#6,3:626\n460#6,13:651\n473#6,3:665\n473#6,3:670\n460#6,13:695\n460#6,13:727\n473#6,3:742\n473#6,3:747\n473#6,3:752\n460#6,13:776\n460#6,13:809\n473#6,3:823\n473#6,3:828\n460#6,13:852\n460#6,13:885\n473#6,3:899\n473#6,3:906\n67#7,6:412\n73#7:444\n77#7:449\n68#7,5:451\n73#7:482\n77#7:487\n68#7,5:489\n73#7:520\n77#7:525\n67#7,6:593\n73#7:625\n77#7:630\n67#7,6:790\n73#7:822\n77#7:827\n67#7,6:866\n73#7:898\n77#7:903\n75#8,5:709\n80#8:740\n84#8:746\n*S KotlinDebug\n*F\n+ 1 WideSmallLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/WideSmallLayoutKt\n*L\n52#1:374\n347#1:375\n68#1:378\n79#1:386\n81#1:419\n89#1:457\n93#1:495\n107#1:534\n112#1:567\n117#1:600\n128#1:639\n153#1:683\n154#1:715\n284#1:764\n286#1:797\n308#1:840\n310#1:873\n348#1:376\n349#1:377\n88#1:450\n92#1:488\n127#1:631\n152#1:675\n162#1:741\n319#1:904\n326#1:905\n79#1:379,6\n79#1:411\n79#1:530\n107#1:531,2\n107#1:559\n112#1:560,6\n112#1:592\n128#1:632,6\n128#1:664\n128#1:669\n112#1:674\n153#1:676,6\n153#1:708\n153#1:751\n107#1:756\n284#1:757,6\n284#1:789\n284#1:832\n308#1:833,6\n308#1:865\n308#1:910\n79#1:385\n79#1:387,11\n81#1:418\n81#1:420,11\n81#1:448\n89#1:456\n89#1:458,11\n89#1:486\n93#1:494\n93#1:496,11\n93#1:524\n79#1:529\n107#1:533\n107#1:535,11\n112#1:566\n112#1:568,11\n117#1:599\n117#1:601,11\n117#1:629\n128#1:638\n128#1:640,11\n128#1:668\n112#1:673\n153#1:682\n153#1:684,11\n154#1:714\n154#1:716,11\n154#1:745\n153#1:750\n107#1:755\n284#1:763\n284#1:765,11\n286#1:796\n286#1:798,11\n286#1:826\n284#1:831\n308#1:839\n308#1:841,11\n310#1:872\n310#1:874,11\n310#1:902\n308#1:909\n79#1:398,13\n81#1:431,13\n81#1:445,3\n89#1:469,13\n89#1:483,3\n93#1:507,13\n93#1:521,3\n79#1:526,3\n107#1:546,13\n112#1:579,13\n117#1:612,13\n117#1:626,3\n128#1:651,13\n128#1:665,3\n112#1:670,3\n153#1:695,13\n154#1:727,13\n154#1:742,3\n153#1:747,3\n107#1:752,3\n284#1:776,13\n286#1:809,13\n286#1:823,3\n284#1:828,3\n308#1:852,13\n310#1:885,13\n310#1:899,3\n308#1:906,3\n81#1:412,6\n81#1:444\n81#1:449\n89#1:451,5\n89#1:482\n89#1:487\n93#1:489,5\n93#1:520\n93#1:525\n117#1:593,6\n117#1:625\n117#1:630\n286#1:790,6\n286#1:822\n286#1:827\n310#1:866,6\n310#1:898\n310#1:903\n154#1:709,5\n154#1:740\n154#1:746\n*E\n"})
public final class WideSmallLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void WideSmallLayout(@Nullable Modifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable final TertiaryContentData tertiaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(171410428);
        final Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 16) != 0 ? null : function2;
        final Function2<? super Composer, ? super Integer, Unit> function25 = (i2 & 32) != 0 ? null : function22;
        final Function2<? super Composer, ? super Integer, Unit> function26 = (i2 & 64) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(171410428, i, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout (WideSmallLayout.kt:50)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_layout_start_padding));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_layout_end_padding));
        if (tertiaryContentData == null && function26 == null) {
            composerStartRestartGroup.startReplaceableGroup(-1934388155);
            if (secondaryContentData != null || function25 != null) {
                WideSmallLayout$PrimaryContentWithSecondary$15(function24, primaryContentData, mask, PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM20968constructorimpl, 0.0f, fM20968constructorimpl2, 0.0f, 10, null), secondaryContentData, function25, composerStartRestartGroup, ((i >> 9) & 896) | 64, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1934387813);
            if ((secondaryContentData != null || function25 != null) && (tertiaryContentData != null || function26 != null)) {
                int i4 = i >> 6;
                WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$10(function24, primaryContentData, mask, PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM20968constructorimpl, 0.0f, fM20968constructorimpl2, 0.0f, 10, null), secondaryContentData, tertiaryContentData, function25, function26, composerStartRestartGroup, (i4 & 7168) | Units.MASTER_DPI | (i4 & 57344), 0);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.WideSmallLayoutKt.WideSmallLayout.1
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
                    WideSmallLayoutKt.WideSmallLayout(modifier2, primaryContentData, secondaryContentData, tertiaryContentData, function27, function25, function26, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    private static final void WideSmallLayout$PrimaryContentWithSecondary$15(final Function2<? super Composer, ? super Integer, Unit> function2, final PrimaryContentData primaryContentData, final int i, Modifier modifier, final SecondaryContentData secondaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i2, int i4) {
        composer.startReplaceableGroup(1736961865);
        if ((i4 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        final Function2<? super Composer, ? super Integer, Unit> function23 = (i4 & 4) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1736961865, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondary (WideSmallLayout.kt:277)");
        }
        m2310x79ea560a(function2, primaryContentData, modifier2, ComposableLambdaKt.composableLambda(composer, 1795647742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$1
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

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1795647742, i5, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondary.<anonymous> (WideSmallLayout.kt:336)");
                }
                if (function23 != null) {
                    composer2.startReplaceableGroup(523819384);
                    AbstractC1038a.m1198C(composer2, 0, function23);
                } else {
                    SecondaryContentData secondaryContentData2 = secondaryContentData;
                    if ((secondaryContentData2 != null ? secondaryContentData2.getTextList() : null) != null) {
                        composer2.startReplaceableGroup(523819457);
                        WideSmallLayoutKt.m2311xcf8c71c7(function2, primaryContentData, i, modifier2, secondaryContentData.getTextList(), composer2, 64, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(523819637);
                        composer2.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i2 & 14) | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondary$15$PrimaryContentWithSecondary */
    private static final void m2310x79ea560a(Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1223444851);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1223444851, i, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondary.PrimaryContentWithSecondary (WideSmallLayout.kt:282)");
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion.getCenterVertically();
        composer2.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer2, 48, -1323940314);
        Density density = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (function2 != null) {
            composer2.startReplaceableGroup(-705534226);
            Modifier modifierM21959sizeLwRUR8o = ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer2, 54, 0);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer2, 0, -1323940314);
            Density density2 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM21959sizeLwRUR8o);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer2, 0);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer2.startReplaceableGroup(-705534012);
            Modifier modifierM21959sizeLwRUR8o2 = ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer2, 54, 0);
            composer2 = composer2;
            CombineLayoutKt.PrimaryButtonContent(modifierM21959sizeLwRUR8o2, primaryContentData, composer2, 64);
            composer2.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-705533779);
            composer2.endReplaceableGroup();
        }
        function22.invoke(composer2, Integer.valueOf((i >> 3) & 14));
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondary$15$SecondaryTextListContent */
    public static final void m2311xcf8c71c7(Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, int i, Modifier modifier, TypedTextListData typedTextListData, Composer composer, int i2, int i4) {
        composer.startReplaceableGroup(993651445);
        Modifier modifier2 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(993651445, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondary.SecondaryTextListContent (WideSmallLayout.kt:302)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        TypedTextData typedTextData = typedTextListData.getItems().get(0);
        TypedTextData typedTextData2 = typedTextListData.getItems().get(1);
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion.getCenterVertically();
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer, 48, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (function2 != null) {
            composer.startReplaceableGroup(-2020699935);
            Modifier modifierM21959sizeLwRUR8o = ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer, 54, 0);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer, 0, -1323940314);
            Density density2 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM21959sizeLwRUR8o);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer.startReplaceableGroup(-2020699721);
            CombineLayoutKt.PrimaryButtonContent(ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer, 54, 0), primaryContentData, composer, 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2020699488);
            composer.endReplaceableGroup();
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(5)), composer, 6);
        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
        TextType.Companion companion4 = TextType.INSTANCE;
        CombineLayoutKt.m21825ComposeCombineText57gRyVA(modifierWeight$default, i, typedTextData, companion4.m21691getDisplaygxbDmow(), 0, null, 0.0f, 0.0f, composer, 3072, 240);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(6)), composer, 6);
        CombineLayoutKt.m21825ComposeCombineText57gRyVA(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), i, typedTextData2, companion4.m21693getLabelgxbDmow(), 0, null, 0.0f, 0.0f, composer, 3072, 240);
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.glance.GlanceComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$10(Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, final int i, Modifier modifier, final SecondaryContentData secondaryContentData, final TertiaryContentData tertiaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i4) {
        TypedTextListData textList;
        List<TypedTextData> items;
        TypedTextListData textList2;
        List<TypedTextData> items2;
        composer.startReplaceableGroup(609490817);
        if ((i4 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i4 & 8) != 0 ? null : function22;
        final Function2<? super Composer, ? super Integer, Unit> function25 = (i4 & 16) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(609490817, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary (WideSmallLayout.kt:60)");
        }
        if ((secondaryContentData != null ? secondaryContentData.getTextList() : null) == null) {
            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
            if ((function26 == null && (secondaryContentData == null || (textList2 = secondaryContentData.getTextList()) == null || (items2 = textList2.getItems()) == null || !(!items2.isEmpty()))) || (function25 == null && (tertiaryContentData == null || (textList = tertiaryContentData.getTextList()) == null || (items = textList.getItems()) == null || !(!items.isEmpty())))) {
                composer.startReplaceableGroup(-2074078087);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-2074082774);
                m2312x9be31eab(i, function2, primaryContentData, modifier2, ComposableLambdaKt.composableLambda(composer, -1731341979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$1
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

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i5) {
                        TypedTextListData textList3;
                        List<TypedTextData> items3;
                        Composer composer3 = composer2;
                        boolean z = false;
                        if ((i5 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1731341979, i5, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous> (WideSmallLayout.kt:189)");
                        }
                        if (function26 != null) {
                            composer3.startReplaceableGroup(1746570749);
                            function26.invoke(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(1746570821);
                            SecondaryContentData secondaryContentData2 = secondaryContentData;
                            if (secondaryContentData2 != null && (textList3 = secondaryContentData2.getTextList()) != null && (items3 = textList3.getItems()) != null && (!items3.isEmpty())) {
                                TypedTextListData textList4 = secondaryContentData.getTextList();
                                int i6 = 3;
                                Alignment alignment = null;
                                if (textList4.getOrientation() == Orientation.Vertical) {
                                    composer3.startReplaceableGroup(1746571061);
                                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    int i7 = i;
                                    composer3.startReplaceableGroup(-483455358);
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(1746571195);
                                    Iterator it = textList4.getItems().iterator();
                                    int i8 = 0;
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        int i9 = i8 + 1;
                                        if (i8 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        TypedTextData typedTextData = (TypedTextData) next;
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(companion2, alignment, z, i6, alignment);
                                        int i10 = i7;
                                        Iterator it2 = it;
                                        CombineLayoutKt.m21825ComposeCombineText57gRyVA(modifierWrapContentSize$default, i10, typedTextData, typedTextData.getTextType(), TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i7, typedTextData.getTextType(), typedTextData.getMaxLines()), composer2, 6, 96);
                                        composer3 = composer2;
                                        if (i8 != textList4.getItems().size() - 1) {
                                            SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(2)), composer3, 6);
                                        }
                                        it = it2;
                                        i7 = i10;
                                        i8 = i9;
                                        i6 = 3;
                                        alignment = null;
                                        z = false;
                                    }
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(1746572633);
                                    Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
                                    Alignment.Vertical bottom = Alignment.INSTANCE.getBottom();
                                    int i11 = i;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, bottom, composer3, 48, -1323940314);
                                    Density density2 = (Density) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1207h, composerM18018constructorimpl2, density2));
                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(1746572930);
                                    int i12 = 0;
                                    for (Object obj : textList4.getItems()) {
                                        int i13 = i12 + 1;
                                        if (i12 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        TypedTextData typedTextData2 = (TypedTextData) obj;
                                        int i14 = i11;
                                        CombineLayoutKt.m21822ComposeCombineAutoTextBnzNfJc(TextType.m21684equalsimpl0(typedTextData2.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow()) ? PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(2), 7, null) : Modifier.INSTANCE, i14, typedTextData2, typedTextData2.getTextType(), null, 0.3f, 0.0f, composer3, 196608, 80);
                                        if (i12 != textList4.getItems().size() - 1) {
                                            SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(2)), composer3, 6);
                                        }
                                        i11 = i14;
                                        i12 = i13;
                                    }
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                            }
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableLambdaKt.composableLambda(composer, -668153370, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$2
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i5) {
                        TypedTextListData textList3;
                        List<TypedTextData> items3;
                        if ((i5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-668153370, i5, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous> (WideSmallLayout.kt:244)");
                        }
                        if (function25 != null) {
                            composer2.startReplaceableGroup(1746574095);
                            function25.invoke(composer2, 0);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(1746574166);
                            TertiaryContentData tertiaryContentData2 = tertiaryContentData;
                            TypedTextData typedTextData = (tertiaryContentData2 == null || (textList3 = tertiaryContentData2.getTextList()) == null || (items3 = textList3.getItems()) == null) ? null : items3.get(0);
                            if (typedTextData != null) {
                                int i6 = i;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                                Alignment centerEnd = Alignment.INSTANCE.getCenterEnd();
                                composer2.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerEnd, false, composer2, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null), i6, typedTextData, typedTextData.getTextType(), 0, null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i6, typedTextData.getTextType(), typedTextData.getMaxLines()), composer2, 6, 112);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, (i2 & 14) | 432);
                composer.endReplaceableGroup();
            }
        } else {
            if ((tertiaryContentData != null ? tertiaryContentData.getFirstProgressBar() : null) != null && tertiaryContentData.getSecondProgressBar() != null) {
                composer.startReplaceableGroup(-2074083308);
                m2313xdfca69f8(function2, primaryContentData, function24, i, modifier2, secondaryContentData.getTextList(), tertiaryContentData.getFirstProgressBar(), tertiaryContentData.getSecondProgressBar(), composer, (i2 & 14) | 4672);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$10$PrimaryContentWithSecondaryAndTertiary */
    private static final void m2312x9be31eab(int i, Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2) {
        composer.startReplaceableGroup(1016592488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1016592488, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary (WideSmallLayout.kt:66)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(i);
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, i);
        long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composer, (PercentSizeUtils.$stable << 15) | 24576, 0);
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion.getCenterVertically();
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer, 48, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (function2 != null) {
            composer.startReplaceableGroup(-1097618114);
            Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(Modifier.INSTANCE, jM21383getMinDpSizeFromPercentDataM_xkUdw);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer.startReplaceableGroup(-1097617981);
            CombineLayoutKt.PrimaryButtonContent(SizeKt.m15900size6HolHcs(Modifier.INSTANCE, jM21383getMinDpSizeFromPercentDataM_xkUdw), primaryContentData, composer, 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1097617785);
            composer.endReplaceableGroup();
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(5)), composer, 6);
        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
        Alignment center = companion.getCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
        Density density3 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWeight$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl3, density3));
        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        function22.invoke(composer, Integer.valueOf((i2 >> 3) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(6)), composer, 6);
        Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
        Alignment center2 = companion.getCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer, 6);
        Density density4 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection4 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWeight$default2);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl4, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl4, density4));
        function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl4, viewConfiguration4, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function23.invoke(composer, Integer.valueOf((i2 >> 6) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
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
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$10$PrimaryContentWithSecondaryAndTertiaryProgress */
    private static final void m2313xdfca69f8(Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, int i, Modifier modifier, TypedTextListData typedTextListData, LinearProgressData linearProgressData, LinearProgressData linearProgressData2, Composer composer, int i2) {
        ComposeUiNode.Companion companion;
        Object obj;
        int i4;
        Modifier.Companion companion2;
        Modifier.Companion companion3;
        ComposeUiNode.Companion companion4;
        int i5;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1052824262);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1052824262, i2, -1, "androidx.glance.oneui.template.layout.compose.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress (WideSmallLayout.kt:104)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceableGroup();
            return;
        }
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.HorizontalOrVertical center = arrangement.getCenter();
        Alignment.Companion companion5 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion5.getCenterVertically();
        composer2.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
        Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion6.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier.Companion companion7 = Modifier.INSTANCE;
        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion7, 1.0f, false, 2, null), 0.0f, 1, null);
        Alignment.Vertical centerVertically2 = companion5.getCenterVertically();
        composer2.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(arrangement, centerVertically2, composer2, 48, -1323940314);
        Density density2 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion6.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl2, measurePolicyM1207h, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        if (function2 != null) {
            composer2.startReplaceableGroup(-615971052);
            companion = companion6;
            Modifier modifierM21959sizeLwRUR8o = ComposeModifierUtilsKt.m21959sizeLwRUR8o(companion7, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer2, 54, 0);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion5, false, composer2, 0, -1323940314);
            Density density3 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM21959sizeLwRUR8o);
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
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl3, measurePolicyM1210k, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer2, 0);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            companion2 = companion7;
            obj = null;
            i4 = 1;
        } else {
            companion = companion6;
            obj = null;
            if (primaryContentData != null) {
                composer2.startReplaceableGroup(-615970829);
                i4 = 1;
                companion2 = companion7;
                CombineLayoutKt.PrimaryButtonContent(ComposeModifierUtilsKt.m21959sizeLwRUR8o(companion2, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composer2, 54, 0), primaryContentData, composer2, 64);
                composer2.endReplaceableGroup();
            } else {
                i4 = 1;
                companion2 = companion7;
                composer2.startReplaceableGroup(-615970544);
                composer2.endReplaceableGroup();
            }
        }
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(5)), composer2, 6);
        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(companion2, 0.0f, i4, obj), 1.0f, false, 2, null);
        Alignment.Vertical centerVertically3 = companion5.getCenterVertically();
        composer2.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(arrangement, centerVertically3, composer2, 48, -1323940314);
        Density density4 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor4 = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWeight$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl4, measurePolicyM1207h2, composerM18018constructorimpl4, density4));
        function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        if (function22 != null) {
            composer2.startReplaceableGroup(-830759964);
            function22.invoke(composer2, 0);
            composer2.endReplaceableGroup();
            companion3 = companion2;
            companion4 = companion;
            i5 = 6;
        } else {
            composer2.startReplaceableGroup(-830759884);
            if (typedTextListData.getItems().isEmpty()) {
                companion3 = companion2;
                companion4 = companion;
                i5 = 6;
            } else {
                TypedTextData typedTextData = (TypedTextData) CollectionsKt.first((List) typedTextListData.getItems());
                companion4 = companion;
                companion3 = companion2;
                i5 = 6;
                CombineLayoutKt.m21825ComposeCombineText57gRyVA(null, i, typedTextData, typedTextData.getTextType(), 0, null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4(), typedTextData.getTextType(), typedTextData.getMaxLines()), composer, 0, 113);
                composer2 = composer;
            }
            composer2.endReplaceableGroup();
        }
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(i5)), composer2, i5);
        Modifier.Companion companion8 = companion3;
        Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion8, 1.0f, false, 2, null), 0.0f, 1, null);
        composer2.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion5, arrangement.getStart(), composer2, 0, -1323940314);
        Density density5 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection5 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor5 = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierFillMaxHeight$default2);
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
        ComposeUiNode.Companion companion9 = companion4;
        Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl5, measurePolicyM1208i, composerM18018constructorimpl5, density5));
        function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl5, viewConfiguration5, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion8, 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center2 = arrangement.getCenter();
        composer2.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, companion5.getStart(), composer2, i5);
        composer2.startReplaceableGroup(-1323940314);
        Density density6 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection6 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor6 = companion9.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl6, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl6, density6));
        function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl6, viewConfiguration6, composer2, composer2), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion8, 0.0f, 1, null), 0.32f, composer2, 54), linearProgressData, composer2, 64, 0);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion8, C2256Dp.m20968constructorimpl(4)), composer2, i5);
        ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion8, 0.0f, 1, null), 0.32f, composer2, 54), linearProgressData2, composer2, 64, 0);
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }
}
