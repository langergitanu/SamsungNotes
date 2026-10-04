package androidx.glance.oneui.template.layout.glance.combine;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
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
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.FontWeight;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001az\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "WideSmallLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "tertiaryData", "Landroidx/glance/oneui/template/TertiaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/glance/oneui/template/TertiaryContentData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWideSmallLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WideSmallLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/WideSmallLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,402:1\n74#2:403\n74#2:404\n174#3:405\n174#3:406\n*S KotlinDebug\n*F\n+ 1 WideSmallLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/WideSmallLayoutKt\n*L\n54#1:403\n55#1:404\n373#1:405\n374#1:406\n*E\n"})
public final class WideSmallLayoutKt {

    @NotNull
    private static final String TAG = "GWT:WideSmallLayout";

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void WideSmallLayout(@Nullable GlanceModifier glanceModifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable final TertiaryContentData tertiaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i, final int i2) {
        Composer composer2;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2092463158);
        GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 16) != 0 ? null : function2;
        final Function2<? super Composer, ? super Integer, Unit> function25 = (i2 & 32) != 0 ? null : function22;
        final Function2<? super Composer, ? super Integer, Unit> function26 = (i2 & 64) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2092463158, i, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout (WideSmallLayout.kt:52)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Context context = (Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_layout_start_padding));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_layout_end_padding));
        if (tertiaryContentData == null && function26 == null) {
            composerStartRestartGroup.startReplaceableGroup(-1879844196);
            if (secondaryContentData == null && function25 == null) {
                composer3 = composerStartRestartGroup;
            } else {
                WideSmallLayout$PrimaryContentWithSecondary$1(mask, context, function24, primaryContentData, PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), fM20968constructorimpl, 0.0f, fM20968constructorimpl2, 0.0f, 10, null), secondaryContentData, function25, composerStartRestartGroup, ((i >> 9) & 896) | 64, 0);
                composer3 = composerStartRestartGroup;
            }
            composer3.endReplaceableGroup();
            composer2 = composer3;
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1879843828);
            if ((secondaryContentData == null && function25 == null) || (tertiaryContentData == null && function26 == null)) {
                composer2 = composerStartRestartGroup;
            } else {
                int i4 = i >> 6;
                WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$0(mask, context, function24, primaryContentData, PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), fM20968constructorimpl, 0.0f, fM20968constructorimpl2, 0.0f, 10, null), secondaryContentData, tertiaryContentData, function25, function26, composerStartRestartGroup, (i4 & 7168) | Units.MASTER_DPI | (i4 & 57344), 0);
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt.WideSmallLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer4, int i5) {
                    WideSmallLayoutKt.WideSmallLayout(glanceModifier3, primaryContentData, secondaryContentData, tertiaryContentData, function27, function25, function26, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    private static final void WideSmallLayout$PrimaryContentWithSecondary$1(final int i, Context context, final Function2<? super Composer, ? super Integer, Unit> function2, final PrimaryContentData primaryContentData, GlanceModifier glanceModifier, final SecondaryContentData secondaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i2, int i4) {
        composer.startReplaceableGroup(338647541);
        final GlanceModifier glanceModifier2 = (i4 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        Function2<? super Composer, ? super Integer, Unit> function23 = (i4 & 4) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(338647541, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary (WideSmallLayout.kt:289)");
        }
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(i);
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, i);
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        GlanceModifier glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = androidx.glance.appwidget.percent.SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composer, 196614, 0);
        GlanceModifier glanceModifierM21285circle6PoWaU8 = CornerRadiusKt.m21285circle6PoWaU8(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, composer, 6, 0);
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        m2320xb5ec7d1(function2, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, primaryContentData, glanceModifierM21285circle6PoWaU8, glanceModifier2, ComposableLambdaKt.composableLambda(composer, -1558958816, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$1
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
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1558958816, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.<anonymous> (WideSmallLayout.kt:362)");
                }
                if (function24 != null) {
                    composer2.startReplaceableGroup(1698440182);
                    AbstractC1038a.m1198C(composer2, 0, function24);
                } else {
                    SecondaryContentData secondaryContentData2 = secondaryContentData;
                    if ((secondaryContentData2 != null ? secondaryContentData2.getTextList() : null) != null) {
                        composer2.startReplaceableGroup(1698440255);
                        WideSmallLayoutKt.m2321x3e4fad60(function2, primaryContentData, i, glanceModifier2, secondaryContentData.getTextList(), composer2, 64, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1698440435);
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
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondary$1$PrimaryContentWithSecondary */
    private static final void m2320xb5ec7d1(final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, final GlanceModifier glanceModifier2, GlanceModifier glanceModifier3, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        composer.startReplaceableGroup(1385714717);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1385714717, i, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.PrimaryContentWithSecondary (WideSmallLayout.kt:312)");
        }
        RowKt.m21502RowlMAjyxE(glanceModifier3, 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer, 405385089, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$PrimaryContentWithSecondary$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i2) {
                Composer composer3;
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(405385089, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.PrimaryContentWithSecondary.<anonymous> (WideSmallLayout.kt:314)");
                }
                if (function2 != null) {
                    composer2.startReplaceableGroup(-510400629);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifier4 = glanceModifier;
                    final Function2<Composer, Integer, Unit> function23 = function2;
                    composer3 = composer2;
                    debug.debugBox(glanceModifier4, null, "WideSmall5", false, ComposableLambdaKt.composableLambda(composer2, 683416773, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$PrimaryContentWithSecondary$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer4, int i4) {
                            if ((i4 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(683416773, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.PrimaryContentWithSecondary.<anonymous>.<anonymous> (WideSmallLayout.kt:315)");
                            }
                            if (AbstractC1038a.m1196A(composer4, 0, function23)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 221568, 10);
                    composer3.endReplaceableGroup();
                } else {
                    composer3 = composer2;
                    if (primaryContentData != null) {
                        composer3.startReplaceableGroup(-510400483);
                        CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer3, 64);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-510400279);
                        composer3.endReplaceableGroup();
                    }
                }
                if (AbstractC1038a.m1196A(composer3, 0, function22)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondary$1$SecondaryTextListContent */
    public static final void m2321x3e4fad60(final Function2<? super Composer, ? super Integer, Unit> function2, final PrimaryContentData primaryContentData, final int i, GlanceModifier glanceModifier, final TypedTextListData typedTextListData, Composer composer, int i2, int i4) {
        composer.startReplaceableGroup(-1001898123);
        if ((i4 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1001898123, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.SecondaryTextListContent (WideSmallLayout.kt:330)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
        } else {
            final TypedTextData typedTextData = typedTextListData.getItems().get(0);
            RowKt.m21502RowlMAjyxE(glanceModifier, 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer, -990092655, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$SecondaryTextListContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i5) {
                    Composer composer3 = composer2;
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-990092655, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.SecondaryTextListContent.<anonymous> (WideSmallLayout.kt:335)");
                    }
                    if (function2 != null) {
                        composer3.startReplaceableGroup(1462309465);
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), 0.0f, composer3, 54, 4);
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        debug.debugBox(glanceModifierM21387size9UTdIk, null, "WideSmall6", false, ComposableLambdaKt.composableLambda(composer3, -1276141619, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondary$SecondaryTextListContent$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i6) {
                                if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1276141619, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondary.SecondaryTextListContent.<anonymous>.<anonymous> (WideSmallLayout.kt:341)");
                                }
                                if (AbstractC1038a.m1196A(composer4, 0, function22)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 221568, 10);
                        composer3 = composer2;
                        composer3.endReplaceableGroup();
                    } else if (primaryContentData != null) {
                        composer3.startReplaceableGroup(1462309810);
                        GlanceModifier glanceModifierM21385cornerRadiusLwRUR8o = androidx.glance.appwidget.percent.SizeModifiersKt.m21385cornerRadiusLwRUR8o(androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, 0.75f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), 0.0f, composer3, 54, 4), 0.375f, 0, composer2, 48, 2);
                        composer3 = composer2;
                        CombineLayoutKt.PrimaryButtonContent(glanceModifierM21385cornerRadiusLwRUR8o, primaryContentData, composer3, 64);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1462310140);
                        composer3.endReplaceableGroup();
                    }
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    AbstractC2821a.m2232w(5, companion, composer3, 0, 0);
                    int i6 = i;
                    TypedTextData typedTextData2 = typedTextData;
                    TextType.Companion companion2 = TextType.INSTANCE;
                    CombineLayoutKt.m21861CombineText57gRyVA(null, i6, typedTextData2, companion2.m21691getDisplaygxbDmow(), 0, null, 0.0f, 0.0f, composer2, 3072, 241);
                    if (typedTextListData.getItems().size() > 1) {
                        TypedTextData typedTextData3 = typedTextListData.getItems().get(1);
                        AbstractC2821a.m2232w(6, companion, composer2, 0, 0);
                        CombineLayoutKt.m21861CombineText57gRyVA(null, i, typedTextData3, companion2.m21693getLabelgxbDmow(), 0, null, 0.0f, 0.0f, composer2, 3072, 241);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i2 & 14) | 3072, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$0(final int i, Context context, Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, GlanceModifier glanceModifier, final SecondaryContentData secondaryContentData, final TertiaryContentData tertiaryContentData, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i4) {
        TypedTextListData textList;
        List<TypedTextData> items;
        TypedTextListData textList2;
        List<TypedTextData> items2;
        composer.startReplaceableGroup(1322822269);
        GlanceModifier glanceModifier2 = (i4 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i4 & 8) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function25 = (i4 & 16) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1322822269, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary (WideSmallLayout.kt:63)");
        }
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(i);
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, i);
        final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        GlanceModifier glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = androidx.glance.appwidget.percent.SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composer, 196614, 0);
        GlanceModifier glanceModifierM21285circle6PoWaU8 = CornerRadiusKt.m21285circle6PoWaU8(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, composer, 6, 0);
        if ((secondaryContentData != null ? secondaryContentData.getTextList() : null) == null) {
            final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
            if ((function27 == null && (secondaryContentData == null || (textList2 = secondaryContentData.getTextList()) == null || (items2 = textList2.getItems()) == null || !(!items2.isEmpty()))) || (function26 == null && (tertiaryContentData == null || (textList = tertiaryContentData.getTextList()) == null || (items = textList.getItems()) == null || !(!items.isEmpty())))) {
                composer.startReplaceableGroup(1150401759);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1150397235);
                m2322x95ca64d2(function2, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, primaryContentData, glanceModifierM21285circle6PoWaU8, glanceModifier2, ComposableLambdaKt.composableLambda(composer, -1082615271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$1
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
                        if ((i5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1082615271, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous> (WideSmallLayout.kt:204)");
                        }
                        if (function27 != null) {
                            composer2.startReplaceableGroup(-211244794);
                            AbstractC1038a.m1198C(composer2, 0, function27);
                        } else {
                            composer2.startReplaceableGroup(-211244722);
                            SecondaryContentData secondaryContentData2 = secondaryContentData;
                            if (secondaryContentData2 != null && (textList3 = secondaryContentData2.getTextList()) != null && (items3 = textList3.getItems()) != null && (!items3.isEmpty())) {
                                final TypedTextListData textList4 = secondaryContentData.getTextList();
                                if (textList4.getOrientation() == Orientation.Vertical) {
                                    composer2.startReplaceableGroup(-211244482);
                                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                                    int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                                    final int i6 = i;
                                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21431getCenterVerticallymnfRV0w, 0, ComposableLambdaKt.composableLambda(composer2, 1604057865, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                            invoke(columnScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                        @Composable
                                        public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i7) {
                                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1604057865, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous> (WideSmallLayout.kt:214)");
                                            }
                                            List<TypedTextData> items4 = textList4.getItems();
                                            int i8 = i6;
                                            TypedTextListData typedTextListData = textList4;
                                            int i9 = 0;
                                            for (Object obj : items4) {
                                                int i10 = i9 + 1;
                                                if (i9 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                TypedTextData typedTextData = (TypedTextData) obj;
                                                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                                CombineLayoutKt.m21861CombineText57gRyVA(SizeModifiersKt.wrapContentSize(companion2), i8, typedTextData, typedTextData.getTextType(), TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i8, typedTextData.getTextType(), typedTextData.getMaxLines()), composer3, 0, 96);
                                                if (i9 != typedTextListData.getItems().size() - 1) {
                                                    AbstractC2821a.m2232w(2, companion2, composer3, 0, 0);
                                                }
                                                i9 = i10;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 3072, 4);
                                    composer2.endReplaceableGroup();
                                } else {
                                    composer2.startReplaceableGroup(-211242744);
                                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                                    int iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                                    final int i7 = i;
                                    RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, iM21429getBottommnfRV0w, ComposableLambdaKt.composableLambda(composer2, -1178581390, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                            invoke(rowScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                        @Composable
                                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i8) {
                                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1178581390, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous> (WideSmallLayout.kt:241)");
                                            }
                                            List<TypedTextData> items4 = textList4.getItems();
                                            int i9 = i7;
                                            TypedTextListData typedTextListData = textList4;
                                            int i10 = 0;
                                            for (Object obj : items4) {
                                                int i11 = i10 + 1;
                                                if (i10 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                TypedTextData typedTextData = (TypedTextData) obj;
                                                CombineLayoutKt.m21860CombineAutoTextBnzNfJc(TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow()) ? PaddingKt.m21500paddingqDBjuR0$default(GlanceModifier.INSTANCE, 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(2), 7, null) : GlanceModifier.INSTANCE, i9, typedTextData, typedTextData.getTextType(), null, 0.3f, 0.0f, composer3, 196608, 80);
                                                if (i10 != typedTextListData.getItems().size() - 1) {
                                                    AbstractC2821a.m2232w(2, GlanceModifier.INSTANCE, composer3, 0, 0);
                                                }
                                                i10 = i11;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 3072, 2);
                                    composer2.endReplaceableGroup();
                                }
                            }
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableLambdaKt.composableLambda(composer, -770509064, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$2
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
                        Composer composer3;
                        TypedTextListData textList3;
                        List<TypedTextData> items3;
                        if ((i5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-770509064, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous> (WideSmallLayout.kt:262)");
                        }
                        if (function26 != null) {
                            composer2.startReplaceableGroup(-211241265);
                            AbstractC1038a.m1198C(composer2, 0, function26);
                        } else {
                            composer2.startReplaceableGroup(-211241194);
                            TertiaryContentData tertiaryContentData2 = tertiaryContentData;
                            final TypedTextData typedTextData = (tertiaryContentData2 == null || (textList3 = tertiaryContentData2.getTextList()) == null || (items3 = textList3.getItems()) == null) ? null : items3.get(0);
                            if (typedTextData == null) {
                                composer3 = composer2;
                            } else {
                                final int i6 = i;
                                composer3 = composer2;
                                Debug.INSTANCE.debugBox(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.getCenterEnd(), null, false, ComposableLambdaKt.composableLambda(composer2, -1567947601, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i7) {
                                        if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1567947601, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous>.<anonymous> (WideSmallLayout.kt:270)");
                                        }
                                        GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                                        int i8 = i6;
                                        TypedTextData typedTextData2 = typedTextData;
                                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentHeight, i8, typedTextData2, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer4, 0, 240);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, (Alignment.$stable << 3) | 221184, 12);
                            }
                            composer3.endReplaceableGroup();
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
                composer.startReplaceableGroup(1150396701);
                m2323x4f78991f(function2, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, primaryContentData, glanceModifierM21285circle6PoWaU8, function24, i, glanceModifier2, secondaryContentData.getTextList(), tertiaryContentData.getFirstProgressBar(), tertiaryContentData.getSecondProgressBar(), composer, (i2 & 14) | 4672);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$0$PrimaryContentWithSecondaryAndTertiary */
    private static final void m2322x95ca64d2(final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, final GlanceModifier glanceModifier2, GlanceModifier glanceModifier3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i) {
        composer.startReplaceableGroup(1124814090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1124814090, i, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary (WideSmallLayout.kt:87)");
        }
        RowKt.m21502RowlMAjyxE(glanceModifier3, 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer, 1492062574, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiary$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1492062574, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary.<anonymous> (WideSmallLayout.kt:89)");
                }
                if (function2 != null) {
                    composer2.startReplaceableGroup(-1650681336);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifier4 = glanceModifier;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    debug.debugBox(glanceModifier4, null, "WideSmall1", false, ComposableLambdaKt.composableLambda(composer2, -1552949326, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiary$1.1
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

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i4) {
                            if ((i4 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1552949326, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous> (WideSmallLayout.kt:90)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function24)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    composer2.endReplaceableGroup();
                } else if (primaryContentData != null) {
                    composer2.startReplaceableGroup(-1650681190);
                    CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer2, 64);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1650680986);
                    composer2.endReplaceableGroup();
                }
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                AbstractC2821a.m2232w(5, companion, composer2, 0, 0);
                Debug debug2 = Debug.INSTANCE;
                GlanceModifier glanceModifierDefaultWeight = Row.defaultWeight(companion);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment center = companion2.getCenter();
                final Function2<Composer, Integer, Unit> function25 = function22;
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -951102889, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiary$1.2
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

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i4) {
                        if ((i4 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951102889, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous> (WideSmallLayout.kt:103)");
                        }
                        if (AbstractC1038a.m1196A(composer3, 0, function25)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                int i4 = Alignment.$stable;
                debug2.debugBox(glanceModifierDefaultWeight, center, "WideSmall2", false, composableLambda, composer2, (i4 << 3) | 221568, 8);
                AbstractC2821a.m2232w(6, companion, composer2, 0, 0);
                GlanceModifier glanceModifierDefaultWeight2 = Row.defaultWeight(companion);
                Alignment center2 = companion2.getCenter();
                final Function2<Composer, Integer, Unit> function26 = function23;
                debug2.debugBox(glanceModifierDefaultWeight2, center2, "WideSmall3", false, ComposableLambdaKt.composableLambda(composer2, 2036344206, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiary$1.3
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

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i5) {
                        if ((i5 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2036344206, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiary.<anonymous>.<anonymous> (WideSmallLayout.kt:111)");
                        }
                        if (AbstractC1038a.m1196A(composer3, 0, function26)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i4 << 3) | 221568, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$0$PrimaryContentWithSecondaryAndTertiaryProgress */
    private static final void m2323x4f78991f(final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, final GlanceModifier glanceModifier2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, GlanceModifier glanceModifier3, final TypedTextListData typedTextListData, final LinearProgressData linearProgressData, final LinearProgressData linearProgressData2, Composer composer, int i2) {
        composer.startReplaceableGroup(867597496);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(867597496, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress (WideSmallLayout.kt:122)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
        } else {
            Alignment.Companion companion = Alignment.INSTANCE;
            RowKt.m21502RowlMAjyxE(glanceModifier3, companion.m21430getCenterHorizontallyPGIyAqw(), companion.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer, -1127204068, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiaryProgress$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1127204068, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous> (WideSmallLayout.kt:129)");
                    }
                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion2));
                    int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                    final Function2<Composer, Integer, Unit> function23 = function2;
                    final GlanceModifier glanceModifier4 = glanceModifier;
                    final PrimaryContentData primaryContentData2 = primaryContentData;
                    final GlanceModifier glanceModifier5 = glanceModifier2;
                    final Function2<Composer, Integer, Unit> function24 = function22;
                    final TypedTextListData typedTextListData2 = typedTextListData;
                    final int i5 = i;
                    RowKt.m21502RowlMAjyxE(glanceModifierFillMaxHeight, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, -834377088, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiaryProgress$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer3, int i6) {
                            Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-834377088, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous>.<anonymous> (WideSmallLayout.kt:133)");
                            }
                            if (function23 != null) {
                                composer3.startReplaceableGroup(2144302848);
                                Debug debug = Debug.INSTANCE;
                                GlanceModifier glanceModifier6 = glanceModifier4;
                                final Function2<Composer, Integer, Unit> function25 = function23;
                                debug.debugBox(glanceModifier6, null, "WideSmall4", false, ComposableLambdaKt.composableLambda(composer3, -702805052, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i7) {
                                        if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-702805052, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous>.<anonymous>.<anonymous> (WideSmallLayout.kt:134)");
                                        }
                                        if (AbstractC1038a.m1196A(composer4, 0, function25)) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 221568, 10);
                                composer3.endReplaceableGroup();
                            } else if (primaryContentData2 != null) {
                                composer3.startReplaceableGroup(2144303002);
                                CombineLayoutKt.PrimaryButtonContent(glanceModifier4.then(glanceModifier5), primaryContentData2, composer3, 64);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(2144303226);
                                composer3.endReplaceableGroup();
                            }
                            GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                            AbstractC2821a.m2232w(5, companion3, composer3, 0, 0);
                            GlanceModifier glanceModifierDefaultWeight = Row2.defaultWeight(SizeModifiersKt.fillMaxHeight(companion3));
                            int iM21431getCenterVerticallymnfRV0w2 = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                            final Function2<Composer, Integer, Unit> function26 = function24;
                            final TypedTextListData typedTextListData3 = typedTextListData2;
                            final int i7 = i5;
                            RowKt.m21502RowlMAjyxE(glanceModifierDefaultWeight, 0, iM21431getCenterVerticallymnfRV0w2, ComposableLambdaKt.composableLambda(composer3, -982168860, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.1.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                    invoke(rowScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull RowScope Row3, @Nullable Composer composer4, int i8) {
                                    Composer composer5;
                                    Intrinsics.checkNotNullParameter(Row3, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-982168860, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous>.<anonymous>.<anonymous> (WideSmallLayout.kt:146)");
                                    }
                                    if (function26 != null) {
                                        composer4.startReplaceableGroup(1425103199);
                                        AbstractC1038a.m1198C(composer4, 0, function26);
                                    } else {
                                        composer4.startReplaceableGroup(1425103279);
                                        if (typedTextListData3.getItems().isEmpty()) {
                                            composer5 = composer4;
                                        } else {
                                            TypedTextData typedTextData = (TypedTextData) CollectionsKt.first((List) typedTextListData3.getItems());
                                            composer5 = composer4;
                                            CombineLayoutKt.m21861CombineText57gRyVA(null, i7, typedTextData, typedTextData.getTextType(), 0, null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4(), typedTextData.getTextType(), typedTextData.getMaxLines()), composer5, 0, 113);
                                        }
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    AbstractC2821a.m2232w(6, companion2, composer2, 0, 0);
                    GlanceModifier glanceModifierFillMaxHeight2 = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion2));
                    final LinearProgressData linearProgressData3 = linearProgressData;
                    final LinearProgressData linearProgressData4 = linearProgressData2;
                    RowKt.m21502RowlMAjyxE(glanceModifierFillMaxHeight2, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1679062135, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt$WideSmallLayout$PrimaryContentWithSecondaryAndTertiary$PrimaryContentWithSecondaryAndTertiaryProgress$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer3, int i6) {
                            Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1679062135, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous>.<anonymous> (WideSmallLayout.kt:168)");
                            }
                            GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            int iM21431getCenterVerticallymnfRV0w2 = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                            final LinearProgressData linearProgressData5 = linearProgressData3;
                            final LinearProgressData linearProgressData6 = linearProgressData4;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21431getCenterVerticallymnfRV0w2, 0, ComposableLambdaKt.composableLambda(composer3, -2038432659, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.WideSmallLayoutKt.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                    invoke(columnScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i7) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2038432659, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.WideSmallLayout.PrimaryContentWithSecondaryAndTertiary.PrimaryContentWithSecondaryAndTertiaryProgress.<anonymous>.<anonymous>.<anonymous> (WideSmallLayout.kt:172)");
                                    }
                                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                    ProgressIndicatorKt.GlanceLinearProgressIndicator(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion3), 0.32f, composer4, 48), linearProgressData5, composer4, 64, 0);
                                    AbstractC2821a.m2232w(4, companion3, composer4, 0, 0);
                                    ProgressIndicatorKt.GlanceLinearProgressIndicator(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion3), 0.32f, composer4, 48), linearProgressData6, composer4, 64, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
        }
    }
}
