package androidx.glance.oneui.template.layout.glance.combine;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
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
import androidx.glance.appwidget.percent.SizeModifiersKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.FontWeight;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"SmallLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSmallLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmallLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/SmallLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,247:1\n74#2:248\n154#3:249\n154#3:250\n154#3:251\n*S KotlinDebug\n*F\n+ 1 SmallLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/SmallLayoutKt\n*L\n43#1:248\n60#1:249\n218#1:250\n225#1:251\n*E\n"})
public final class SmallLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void SmallLayout(@Nullable GlanceModifier glanceModifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(871251455);
        final GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final Function2<? super Composer, ? super Integer, Unit> function23 = (i2 & 8) != 0 ? null : function2;
        final Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 16) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(871251455, i, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout (SmallLayout.kt:41)");
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        RowKt.m21502RowlMAjyxE(glanceModifier2, 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1660415205, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.1
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
                    ComposerKt.traceEventStart(-1660415205, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.<anonymous> (SmallLayout.kt:232)");
                }
                Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
                Function2<Composer, Integer, Unit> function25 = function23;
                PrimaryContentData primaryContentData2 = primaryContentData;
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                SmallLayoutKt.SmallLayout$PrimaryContent(function25, primaryContentData2, CornerRadiusKt.m21285circle6PoWaU8(SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), 0.0f, 0.0f, 0.0f, composer2, 6, 28), pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), 0.0f, 0.0f, composer2, 0, 12), composer2, 0, 0);
                if (function24 != null) {
                    composer2.startReplaceableGroup(-1347258633);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifierDefaultWeight = Row.defaultWeight(companion);
                    final Function2<Composer, Integer, Unit> function26 = function24;
                    debug.debugBox(glanceModifierDefaultWeight, null, "Small3", false, ComposableLambdaKt.composableLambda(composer2, -1121324457, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.1.1
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
                                ComposerKt.traceEventStart(-1121324457, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.<anonymous>.<anonymous> (SmallLayout.kt:239)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function26)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    composer2.endReplaceableGroup();
                } else if (secondaryContentData != null) {
                    composer2.startReplaceableGroup(-1347258457);
                    SmallLayoutKt.SmallLayout$SecondaryContent(mask, secondaryContentData, composer2, 8);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1347258386);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function23;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.2
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
                    SmallLayoutKt.SmallLayout(glanceModifier2, primaryContentData, secondaryContentData, function26, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void SmallLayout$PrimaryContent(final Function2<? super Composer, ? super Integer, Unit> function2, PrimaryContentData primaryContentData, GlanceModifier glanceModifier, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-837107697);
        GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-837107697, i, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.PrimaryContent (SmallLayout.kt:45)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(-488772083);
            Debug.INSTANCE.debugBox(glanceModifier2, null, "Small1", false, ComposableLambdaKt.composableLambda(composer, -1689039789, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt$SmallLayout$PrimaryContent$1
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
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1689039789, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.PrimaryContent.<anonymous> (SmallLayout.kt:47)");
                    }
                    if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i & 14) | 221568, 10);
            composer.endReplaceableGroup();
        } else if (primaryContentData != null) {
            composer.startReplaceableGroup(-488771961);
            CombineLayoutKt.PrimaryButtonContent(glanceModifier2, primaryContentData, composer, (i & 14) | 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-488771869);
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
    public static final void SmallLayout$SecondaryContent(int i, SecondaryContentData secondaryContentData, Composer composer, int i2) {
        composer.startReplaceableGroup(1315498821);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1315498821, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent (SmallLayout.kt:54)");
        }
        if (secondaryContentData.getTextList() != null) {
            composer.startReplaceableGroup(-1121329839);
            SmallLayout$SecondaryContent$SecondaryTextListContent(secondaryContentData, i, PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(5), 0.0f, 0.0f, 0.0f, 14, null), secondaryContentData.getTextList(), composer, 64);
            composer.endReplaceableGroup();
        } else if (secondaryContentData.getFirstProgressBar() == null || secondaryContentData.getSecondProgressBar() == null) {
            composer.startReplaceableGroup(-1121329247);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1121329531);
            SmallLayout$SecondaryContent$SecondaryProgressListContent(PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(3), 0.0f, 0.0f, 0.0f, 14, null), secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer, Units.MASTER_DPI);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void SmallLayout$SecondaryContent$MultiLineOverlap(final int i, final TypedTextData typedTextData, final TypedTextData typedTextData2, Composer composer, int i2) {
        composer.startReplaceableGroup(-231039827);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-231039827, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap (SmallLayout.kt:57)");
        }
        Debug.INSTANCE.debugBox(PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(5), 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart(), "Small2", false, ComposableLambdaKt.composableLambda(composer, 1405853526, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt$SmallLayout$SecondaryContent$MultiLineOverlap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1405853526, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap.<anonymous> (SmallLayout.kt:63)");
                }
                final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
                CombineTemplatePercent combineTemplatePercent = CombineTemplatePercent.INSTANCE;
                final float fM21939getTextViewHeightPercenttZlUyYw = combineTemplatePercent.m21939getTextViewHeightPercenttZlUyYw(i, typedTextData.getTextType(), 1);
                final float fM21939getTextViewHeightPercenttZlUyYw2 = combineTemplatePercent.m21939getTextViewHeightPercenttZlUyYw(i, typedTextData2.getTextType(), 1);
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl((fM21939getTextViewHeightPercenttZlUyYw + fM21939getTextViewHeightPercenttZlUyYw2) * fM21064getHeightD9Ej5fM) - C2256Dp.m20968constructorimpl(2));
                Debug debug = Debug.INSTANCE;
                GlanceModifier glanceModifierM21505height3ABfNKs = androidx.glance.layout.SizeModifiersKt.m21505height3ABfNKs(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), fM20968constructorimpl);
                Alignment topStart = Alignment.INSTANCE.getTopStart();
                final TypedTextData typedTextData3 = typedTextData;
                final int i5 = i;
                final TypedTextData typedTextData4 = typedTextData2;
                debug.debugBox(glanceModifierM21505height3ABfNKs, topStart, null, false, ComposableLambdaKt.composableLambda(composer2, 187449023, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt$SmallLayout$SecondaryContent$MultiLineOverlap$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    public final void invoke(@Nullable Composer composer3, int i6) {
                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(187449023, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap.<anonymous>.<anonymous> (SmallLayout.kt:71)");
                        }
                        Debug debug2 = Debug.INSTANCE;
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierM21505height3ABfNKs2 = androidx.glance.layout.SizeModifiersKt.m21505height3ABfNKs(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion), C2256Dp.m20968constructorimpl(fM21064getHeightD9Ej5fM * fM21939getTextViewHeightPercenttZlUyYw));
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        Alignment centerStart = companion2.getCenterStart();
                        final TypedTextData typedTextData5 = typedTextData3;
                        final int i7 = i5;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 908888808, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.SecondaryContent.MultiLineOverlap.1.1.1
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
                            public final void invoke(@Nullable Composer composer4, int i8) {
                                if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(908888808, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap.<anonymous>.<anonymous>.<anonymous> (SmallLayout.kt:76)");
                                }
                                GlanceModifier glanceModifierWrapContentSize = androidx.glance.layout.SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                                int textType = typedTextData5.getTextType();
                                TextType.Companion companion3 = TextType.INSTANCE;
                                GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(glanceModifierWrapContentSize, C2256Dp.m20968constructorimpl(!TextType.m21684equalsimpl0(textType, companion3.m21691getDisplaygxbDmow()) ? 2 : 0), 0.0f, 0.0f, 0.0f, 14, null);
                                int i9 = i7;
                                TypedTextData typedTextData6 = typedTextData5;
                                CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierM21500paddingqDBjuR0$default, i9, typedTextData6, typedTextData6.getTextType(), TextType.m21684equalsimpl0(typedTextData5.getTextType(), companion3.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4(), typedTextData5.getTextType(), typedTextData5.getMaxLines()), composer4, 0, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i8 = Alignment.$stable;
                        debug2.debugBox(glanceModifierM21505height3ABfNKs2, centerStart, null, false, composableLambda, composer3, (i8 << 3) | 221184, 12);
                        GlanceModifier glanceModifierFillMaxSize = androidx.glance.layout.SizeModifiersKt.fillMaxSize(companion);
                        Alignment bottomStart = companion2.getBottomStart();
                        final float f = fM21064getHeightD9Ej5fM;
                        final float f4 = fM21939getTextViewHeightPercenttZlUyYw2;
                        final TypedTextData typedTextData6 = typedTextData4;
                        final int i9 = i5;
                        debug2.debugBox(glanceModifierFillMaxSize, bottomStart, null, false, ComposableLambdaKt.composableLambda(composer3, -1360299297, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.SecondaryContent.MultiLineOverlap.1.1.2
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
                            public final void invoke(@Nullable Composer composer4, int i10) {
                                if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1360299297, i10, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap.<anonymous>.<anonymous>.<anonymous> (SmallLayout.kt:100)");
                                }
                                Debug debug3 = Debug.INSTANCE;
                                GlanceModifier glanceModifierM21505height3ABfNKs3 = androidx.glance.layout.SizeModifiersKt.m21505height3ABfNKs(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f * f4));
                                Alignment centerStart2 = Alignment.INSTANCE.getCenterStart();
                                final TypedTextData typedTextData7 = typedTextData6;
                                final int i11 = i9;
                                debug3.debugBox(glanceModifierM21505height3ABfNKs3, centerStart2, null, false, ComposableLambdaKt.composableLambda(composer4, -680989304, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt.SmallLayout.SecondaryContent.MultiLineOverlap.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i12) {
                                        if ((i12 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-680989304, i12, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.MultiLineOverlap.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SmallLayout.kt:106)");
                                        }
                                        GlanceModifier glanceModifierWrapContentSize = androidx.glance.layout.SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                                        int textType = typedTextData7.getTextType();
                                        TextType.Companion companion3 = TextType.INSTANCE;
                                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(glanceModifierWrapContentSize, C2256Dp.m20968constructorimpl(!TextType.m21684equalsimpl0(textType, companion3.m21691getDisplaygxbDmow()) ? 2 : 0), 0.0f, 0.0f, 0.0f, 14, null);
                                        int i13 = i11;
                                        TypedTextData typedTextData8 = typedTextData7;
                                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierM21500paddingqDBjuR0$default, i13, typedTextData8, typedTextData8.getTextType(), TextType.m21684equalsimpl0(typedTextData7.getTextType(), companion3.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21996getBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4(), typedTextData7.getTextType(), typedTextData7.getMaxLines()), composer5, 0, 96);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer4, (Alignment.$stable << 3) | 221184, 12);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (i8 << 3) | 221184, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (Alignment.$stable << 3) | 221184, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void SmallLayout$SecondaryContent$SecondaryProgressListContent(GlanceModifier glanceModifier, final LinearProgressData linearProgressData, final LinearProgressData linearProgressData2, Composer composer, int i) {
        composer.startReplaceableGroup(-1030745768);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030745768, i, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.SecondaryProgressListContent (SmallLayout.kt:197)");
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, 1779192738, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt$SmallLayout$SecondaryContent$SecondaryProgressListContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.traceEventStart(1779192738, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.SecondaryProgressListContent.<anonymous> (SmallLayout.kt:203)");
                }
                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.height(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion2), 0.32f, composer2, 48), linearProgressData, composer2, 64, 0);
                AbstractC2821a.m2232w(4, companion2, composer2, 0, 0);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.height(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion2), 0.32f, composer2, 48), linearProgressData2, composer2, 64, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void SmallLayout$SecondaryContent$SecondaryTextListContent(SecondaryContentData secondaryContentData, final int i, GlanceModifier glanceModifier, TypedTextListData typedTextListData, Composer composer, int i2) {
        composer.startReplaceableGroup(415674565);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(415674565, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.SecondaryTextListContent (SmallLayout.kt:134)");
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
            final TypedTextData typedTextData = items.get(0);
            String text = typedTextData.getText();
            if ((text != null ? text.length() : 0) <= 8) {
                typedTextData.setMaxLines$glance_oneui_template_release(1);
            }
            if (items.size() > 1 && !TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21694getTitlegxbDmow())) {
                composer.startReplaceableGroup(-1487179735);
                SmallLayout$SecondaryContent$MultiLineOverlap(i, typedTextData, items.get(1), composer, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1487179648);
                Alignment.Companion companion = Alignment.INSTANCE;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifier, companion.m21431getCenterVerticallymnfRV0w(), companion.m21433getStartPGIyAqw(), ComposableLambdaKt.composableLambda(composer, -785774503, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.SmallLayoutKt$SmallLayout$SecondaryContent$SecondaryTextListContent$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-785774503, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.SmallLayout.SecondaryContent.SecondaryTextListContent.<anonymous> (SmallLayout.kt:155)");
                        }
                        int textType = typedTextData.getTextType();
                        TextType.Companion companion2 = TextType.INSTANCE;
                        if (TextType.m21684equalsimpl0(textType, companion2.m21694getTitlegxbDmow())) {
                            composer2.startReplaceableGroup(-1562716988);
                            CombineLayoutKt.m21861CombineText57gRyVA(null, i, typedTextData, companion2.m21694getTitlegxbDmow(), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i, companion2.m21694getTitlegxbDmow(), typedTextData.getMaxLines()), composer2, 3072, 97);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1562716515);
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(!TextType.m21684equalsimpl0(typedTextData.getTextType(), companion2.m21691getDisplaygxbDmow()) ? 1 : 0), 0.0f, 0.0f, 0.0f, 14, null);
                            int i5 = i;
                            TypedTextData typedTextData2 = typedTextData;
                            CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierM21500paddingqDBjuR0$default, i5, typedTextData2, typedTextData2.getTextType(), TextType.m21684equalsimpl0(typedTextData.getTextType(), companion2.m21691getDisplaygxbDmow()) ? FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0() : FontWeight.INSTANCE.m21998getNormalWjrlUT0(), null, 0.0f, CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4(), typedTextData.getTextType(), typedTextData.getMaxLines()), composer2, 0, 96);
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, (i2 & 14) | 3072, 0);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
