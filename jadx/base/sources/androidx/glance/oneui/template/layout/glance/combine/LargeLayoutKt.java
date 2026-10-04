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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.SizeModifiersKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TertiaryContentData;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.layout.glance.ListLayoutKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"LargeLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "tertiaryData", "Landroidx/glance/oneui/template/TertiaryContentData;", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "LargeLayout-TafRHR0", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/glance/oneui/template/TertiaryContentData;IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLargeLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LargeLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/LargeLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,178:1\n74#2:179\n154#3:180\n*S KotlinDebug\n*F\n+ 1 LargeLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/LargeLayoutKt\n*L\n46#1:179\n85#1:180\n*E\n"})
public final class LargeLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: LargeLayout-TafRHR0, reason: not valid java name */
    public static final void m21866LargeLayoutTafRHR0(@Nullable GlanceModifier glanceModifier, @Nullable PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable final TertiaryContentData tertiaryContentData, final int i, int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i6;
        final PrimaryContentData primaryContentData2;
        final GlanceModifier glanceModifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(850023126);
        GlanceModifier glanceModifier3 = (i5 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 64) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 128) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i5 & 256) == 0 ? function23 : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(850023126, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout (LargeLayout.kt:43)");
        }
        Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
        CombineTemplatePercent combineTemplatePercent = CombineTemplatePercent.INSTANCE;
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = combineTemplatePercent.m21937getButtonSizeL2j3NV4(companion.m21568getLargerx25Pp4());
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, companion.m21568getLargerx25Pp4());
        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
        GlanceModifier glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion2, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composerStartRestartGroup, 196614, 0);
        final Function2<? super Composer, ? super Integer, Unit> function29 = function28;
        GlanceModifier glanceModifierM21285circle6PoWaU8 = CornerRadiusKt.m21285circle6PoWaU8(companion2, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, composerStartRestartGroup, 6, 0);
        Composer composer2 = composerStartRestartGroup;
        if (tertiaryContentData == null && function29 == null) {
            composer2.startReplaceableGroup(643231708);
            if (secondaryContentData == null && function27 == null) {
                function24 = function26;
                function25 = function27;
            } else {
                Function2<? super Composer, ? super Integer, Unit> function210 = function26;
                Function2<? super Composer, ? super Integer, Unit> function211 = function27;
                LargeLayout_TafRHR0$SecondaryContent(function210, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, primaryContentData, glanceModifierM21285circle6PoWaU8, androidx.glance.layout.SizeModifiersKt.fillMaxSize(companion2), secondaryContentData, function211, composer2, ((i4 >> 15) & 896) | 64);
                function24 = function210;
                function25 = function211;
                composer2 = composer2;
            }
            composer2.endReplaceableGroup();
            primaryContentData2 = primaryContentData;
            i6 = i2;
            glanceModifier2 = glanceModifier3;
        } else {
            function24 = function26;
            function25 = function27;
            i6 = i2;
            if (Alignment.Horizontal.m21438equalsimpl0(i6, Alignment.INSTANCE.m21432getEndPGIyAqw())) {
                composer2.startReplaceableGroup(643232040);
                primaryContentData2 = primaryContentData;
                glanceModifier2 = glanceModifier3;
                RowKt.m21502RowlMAjyxE(glanceModifier2, 0, 0, ComposableLambdaKt.composableLambda(composer2, 894011886, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$1
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
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i7) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(894011886, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.<anonymous> (LargeLayout.kt:159)");
                        }
                        GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                        MediumLayoutKt.m21867MediumLayoutfWZZ6NI(Row.defaultWeight(androidx.glance.layout.SizeModifiersKt.fillMaxHeight(companion3)), primaryContentData2, secondaryContentData, 0, null, null, composer3, Units.MASTER_DPI, 56);
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier glanceModifierDefaultWeight = Row.defaultWeight(androidx.glance.layout.SizeModifiersKt.fillMaxHeight(companion3));
                        final TertiaryContentData tertiaryContentData2 = tertiaryContentData;
                        final Function2<Composer, Integer, Unit> function212 = function29;
                        debug.debugBox(glanceModifierDefaultWeight, null, "Large6", false, ComposableLambdaKt.composableLambda(composer3, 1956177701, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$1.1
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
                            public final void invoke(@Nullable Composer composer4, int i8) {
                                if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1956177701, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.<anonymous>.<anonymous> (LargeLayout.kt:165)");
                                }
                                if (tertiaryContentData2 != null) {
                                    LargeLayoutKt.LargeLayout_TafRHR0$TertiaryContent(function212, androidx.glance.layout.SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), tertiaryContentData2, composer4, 64, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 221568, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i4 & 14) | 3072, 6);
                composer2.endReplaceableGroup();
            } else {
                primaryContentData2 = primaryContentData;
                glanceModifier2 = glanceModifier3;
                composer2.startReplaceableGroup(643232655);
                RowKt.m21502RowlMAjyxE(glanceModifier2, 0, 0, ComposableSingletons$LargeLayoutKt.INSTANCE.m21865getLambda1$glance_oneui_template_release(), composer2, (i4 & 14) | 3072, 6);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function212 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
            final int i7 = i6;
            final PrimaryContentData primaryContentData3 = primaryContentData2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$2
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

                public final void invoke(@Nullable Composer composer3, int i8) {
                    LargeLayoutKt.m21866LargeLayoutTafRHR0(glanceModifier2, primaryContentData3, secondaryContentData, tertiaryContentData, i, i7, function212, function213, function29, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    private static final void LargeLayout_TafRHR0$SecondaryContent(final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, final GlanceModifier glanceModifier2, GlanceModifier glanceModifier3, final SecondaryContentData secondaryContentData, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        composer.startReplaceableGroup(-1634939489);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1634939489, i, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent (LargeLayout.kt:81)");
        }
        if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) != null && secondaryContentData.getSecondProgressBar() != null) {
            composer.startReplaceableGroup(2046791119);
            ColumnKt.m21455ColumnK4GKKTE(PaddingKt.m21498paddingVpY3zN4$default(glanceModifier3, C2256Dp.m20968constructorimpl(14), 0.0f, 2, null), Alignment.INSTANCE.m21429getBottommnfRV0w(), 0, ComposableLambdaKt.composableLambda(composer, 711142510, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SecondaryContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(711142510, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous> (LargeLayout.kt:87)");
                    }
                    GlanceModifier glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(androidx.glance.layout.SizeModifiersKt.wrapContentHeight(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.0f, 0.0f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 24576, 247);
                    int iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                    final SecondaryContentData secondaryContentData2 = secondaryContentData;
                    final Function2<Composer, Integer, Unit> function23 = function2;
                    final GlanceModifier glanceModifier4 = glanceModifier;
                    final PrimaryContentData primaryContentData2 = primaryContentData;
                    final GlanceModifier glanceModifier5 = glanceModifier2;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21358paddings2pLCVw, 0, iM21429getBottommnfRV0w, ComposableLambdaKt.composableLambda(composer2, 385695114, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SecondaryContent$1.1
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
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(385695114, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous>.<anonymous> (LargeLayout.kt:92)");
                            }
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            GlanceModifier glanceModifierWrapContentHeight = androidx.glance.layout.SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion));
                            final SecondaryContentData secondaryContentData3 = secondaryContentData2;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer3, -1646576428, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt.LargeLayout.SecondaryContent.1.1.1
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
                                public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer4, int i5) {
                                    Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1646576428, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous>.<anonymous>.<anonymous> (LargeLayout.kt:93)");
                                    }
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierHeight = SizeModifiersKt.height(companion2, 0.1675f, composer4, 54);
                                    LinearProgressData firstProgressBar = secondaryContentData3.getFirstProgressBar();
                                    Intrinsics.checkNotNull(firstProgressBar);
                                    ProgressIndicatorKt.GlanceLinearProgressIndicator(glanceModifierHeight, firstProgressBar, composer4, 64, 0);
                                    SpacerKt.Spacer(SizeModifiersKt.height(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion2), 0.05f, composer4, 48), composer4, 0, 0);
                                    GlanceModifier glanceModifierHeight2 = SizeModifiersKt.height(companion2, 0.1675f, composer4, 54);
                                    LinearProgressData secondProgressBar = secondaryContentData3.getSecondProgressBar();
                                    Intrinsics.checkNotNull(secondProgressBar);
                                    ProgressIndicatorKt.GlanceLinearProgressIndicator(glanceModifierHeight2, secondProgressBar, composer4, 64, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 6);
                            Debug debug = Debug.INSTANCE;
                            float f = 8;
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), 0.0f, 0.0f, 12, null);
                            final Function2<Composer, Integer, Unit> function24 = function23;
                            final GlanceModifier glanceModifier6 = glanceModifier4;
                            final PrimaryContentData primaryContentData3 = primaryContentData2;
                            final GlanceModifier glanceModifier7 = glanceModifier5;
                            debug.debugBox(glanceModifierM21500paddingqDBjuR0$default, null, "Large2", false, ComposableLambdaKt.composableLambda(composer3, -30531583, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt.LargeLayout.SecondaryContent.1.1.2
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
                                public final void invoke(@Nullable Composer composer4, int i5) {
                                    if ((i5 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-30531583, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous>.<anonymous>.<anonymous> (LargeLayout.kt:109)");
                                    }
                                    LargeLayoutKt.LargeLayout_TafRHR0$SingleButtonContent(function24, glanceModifier6, primaryContentData3, glanceModifier7, composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 221568, 10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 4);
            composer.endReplaceableGroup();
        } else if (function22 != null) {
            composer.startReplaceableGroup(2046792597);
            RowKt.m21502RowlMAjyxE(PaddingModifiersKt.m21358paddings2pLCVw(glanceModifier3, 0.0f, 0.0f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (i & 14) | 24576, 247), 0, Alignment.INSTANCE.m21429getBottommnfRV0w(), ComposableLambdaKt.composableLambda(composer, 1374334135, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SecondaryContent$2
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
                        ComposerKt.traceEventStart(1374334135, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous> (LargeLayout.kt:115)");
                    }
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierDefaultWeight = Row.defaultWeight(companion);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    debug.debugBox(glanceModifierDefaultWeight, null, "Large3", false, ComposableLambdaKt.composableLambda(composer2, -256660754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SecondaryContent$2.1
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
                                ComposerKt.traceEventStart(-256660754, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous>.<anonymous> (LargeLayout.kt:116)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function23)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    float f = 10;
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(14), 0.0f, 8, null);
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final GlanceModifier glanceModifier4 = glanceModifier;
                    final PrimaryContentData primaryContentData2 = primaryContentData;
                    final GlanceModifier glanceModifier5 = glanceModifier2;
                    debug.debugBox(glanceModifierM21500paddingqDBjuR0$default, null, "Large4", false, ComposableLambdaKt.composableLambda(composer2, 1549687959, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SecondaryContent$2.2
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
                                ComposerKt.traceEventStart(1549687959, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SecondaryContent.<anonymous>.<anonymous> (LargeLayout.kt:124)");
                            }
                            LargeLayoutKt.LargeLayout_TafRHR0$SingleButtonContent(function24, glanceModifier4, primaryContentData2, glanceModifier5, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 2);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(2046793177);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void LargeLayout_TafRHR0$SingleButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, GlanceModifier glanceModifier, PrimaryContentData primaryContentData, GlanceModifier glanceModifier2, Composer composer, int i) {
        Composer composer2;
        composer.startReplaceableGroup(517602959);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(517602959, i, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SingleButtonContent (LargeLayout.kt:65)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(-1063373062);
            composer2 = composer;
            Debug.INSTANCE.debugBox(glanceModifier, null, "Large1", false, ComposableLambdaKt.composableLambda(composer, -527364405, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$SingleButtonContent$1
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
                public final void invoke(@Nullable Composer composer3, int i2) {
                    if ((i2 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-527364405, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.SingleButtonContent.<anonymous> (LargeLayout.kt:67)");
                    }
                    if (AbstractC1038a.m1196A(composer3, 0, function2)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, 221568, 10);
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            if (primaryContentData != null) {
                composer2.startReplaceableGroup(-1063372930);
                CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer2, 64);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1063372760);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void LargeLayout_TafRHR0$TertiaryContent(Function2<? super Composer, ? super Integer, Unit> function2, GlanceModifier glanceModifier, TertiaryContentData tertiaryContentData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1809293335);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1809293335, i, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.TertiaryContent (LargeLayout.kt:134)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(-1981761962);
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
        } else if (tertiaryContentData.getList() != null) {
            composer.startReplaceableGroup(-1981761884);
            LargeLayout_TafRHR0$TertiaryContent$TertiaryListContent(glanceModifier, tertiaryContentData.getList(), composer, (i & 14) | 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1981761790);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void LargeLayout_TafRHR0$TertiaryContent$TertiaryListContent(GlanceModifier glanceModifier, final ListData listData, Composer composer, int i) {
        composer.startReplaceableGroup(1009672213);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009672213, i, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.TertiaryContent.TertiaryListContent (LargeLayout.kt:136)");
        }
        Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getCenter(), "Large5", false, ComposableLambdaKt.composableLambda(composer, -1362743042, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.LargeLayoutKt$LargeLayout$TertiaryContent$TertiaryListContent$1
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
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1362743042, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.LargeLayout.TertiaryContent.TertiaryListContent.<anonymous> (LargeLayout.kt:138)");
                }
                ListLayoutKt.m21844GlanceListLayoutYlGCr2M(listData, false, false, 0.0f, 0.0f, false, false, composer2, 8, 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 221568 | (Alignment.$stable << 3), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
