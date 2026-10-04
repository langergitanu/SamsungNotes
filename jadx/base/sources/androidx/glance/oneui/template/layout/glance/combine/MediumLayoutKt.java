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
import androidx.glance.AbstractC2821a;
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
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
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
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ah\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m13886d2 = {"MediumLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "MediumLayout-fWZZ6NI", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMediumLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediumLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/MediumLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,288:1\n74#2:289\n74#2:290\n154#3:291\n*S KotlinDebug\n*F\n+ 1 MediumLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/MediumLayoutKt\n*L\n43#1:289\n44#1:290\n224#1:291\n*E\n"})
public final class MediumLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: MediumLayout-fWZZ6NI, reason: not valid java name */
    public static final void m21867MediumLayoutfWZZ6NI(@Nullable GlanceModifier glanceModifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, int i2, final int i4) {
        final int i5;
        final int iM21429getBottommnfRV0w;
        int i6;
        final GlanceModifier glanceModifier2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-460518545);
        GlanceModifier glanceModifier3 = (i4 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if ((i4 & 8) != 0) {
            i5 = i2;
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
            i6 = i5 & (-7169);
        } else {
            i5 = i2;
            iM21429getBottommnfRV0w = i;
            i6 = i5;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = (i4 & 16) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i4 & 32) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-460518545, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout (MediumLayout.kt:41)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Context context = (Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
        Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
        float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, mask);
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        GlanceModifier glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composerStartRestartGroup, 196614, 0);
        GlanceModifier glanceModifierM21285circle6PoWaU8 = CornerRadiusKt.m21285circle6PoWaU8(companion, pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, composerStartRestartGroup, 6, 0);
        if (secondaryContentData == null && function26 == null) {
            composerStartRestartGroup.startReplaceableGroup(-1629494290);
            GlanceModifier glanceModifier4 = glanceModifier3;
            function23 = function25;
            MediumLayout_fWZZ6NI$OnlyPrimaryContent(function23, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, glanceModifierM21285circle6PoWaU8, glanceModifier4, primaryContentData, composerStartRestartGroup, (i6 & 14) | 64, 0);
            glanceModifier2 = glanceModifier4;
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
            function24 = function26;
        } else {
            glanceModifier2 = glanceModifier3;
            Function2<? super Composer, ? super Integer, Unit> function27 = function25;
            composerStartRestartGroup.startReplaceableGroup(-1629494202);
            Function2<? super Composer, ? super Integer, Unit> function28 = function26;
            int i7 = iM21429getBottommnfRV0w;
            MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent(i7, function27, glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, primaryContentData, glanceModifierM21285circle6PoWaU8, function28, mask, glanceModifier2, secondaryContentData, composerStartRestartGroup, (i6 & 14) | 64);
            iM21429getBottommnfRV0w = i7;
            function23 = function27;
            function24 = function28;
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$1
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
                    MediumLayoutKt.m21867MediumLayoutfWZZ6NI(glanceModifier2, primaryContentData, secondaryContentData, iM21429getBottommnfRV0w, function29, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void MediumLayout_fWZZ6NI$OnlyPrimaryContent(final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final GlanceModifier glanceModifier2, GlanceModifier glanceModifier3, final PrimaryContentData primaryContentData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(496000226);
        GlanceModifier glanceModifier4 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(496000226, i, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.OnlyPrimaryContent (MediumLayout.kt:66)");
        }
        Debug.INSTANCE.debugBox(glanceModifier4, Alignment.INSTANCE.getCenter(), "Medium1", false, ComposableLambdaKt.composableLambda(composer, -1732720885, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$OnlyPrimaryContent$1
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
                    ComposerKt.traceEventStart(-1732720885, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.OnlyPrimaryContent.<anonymous> (MediumLayout.kt:68)");
                }
                if (function2 != null) {
                    composer2.startReplaceableGroup(-1707505148);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier glanceModifier5 = glanceModifier;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    debug.debugBox(glanceModifier5, null, "Medium2", false, ComposableLambdaKt.composableLambda(composer2, -1241977521, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$OnlyPrimaryContent$1.1
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
                                ComposerKt.traceEventStart(-1241977521, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.OnlyPrimaryContent.<anonymous>.<anonymous> (MediumLayout.kt:69)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function22)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    composer2.endReplaceableGroup();
                } else if (primaryContentData != null) {
                    composer2.startReplaceableGroup(-1707505007);
                    CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer2, 64);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1707504812);
                    composer2.endReplaceableGroup();
                }
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

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, final GlanceModifier glanceModifier2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i2, GlanceModifier glanceModifier3, final SecondaryContentData secondaryContentData, Composer composer, int i4) {
        float f;
        composer.startReplaceableGroup(1714764198);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1714764198, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent (MediumLayout.kt:83)");
        }
        if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) == null || secondaryContentData.getSecondProgressBar() == null) {
            composer.startReplaceableGroup(293737503);
            Alignment.Companion companion = Alignment.INSTANCE;
            float f4 = 0.1f;
            if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w())) {
                f = 0.1f;
                f4 = 0.12f;
            } else {
                f = 0.1f;
            }
            ColumnKt.m21455ColumnK4GKKTE(PaddingModifiersKt.m21358paddings2pLCVw(glanceModifier3, 0.0f, f4, 0.0f, Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w()) ? f : 0.12f, 0.0f, 0.0f, 0.0f, 0.0f, composer, i4 & 14, 245), companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, -1246737844, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$2
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
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1246737844, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.<anonymous> (MediumLayout.kt:252)");
                    }
                    if (Alignment.Vertical.m21448equalsimpl0(i, Alignment.INSTANCE.m21429getBottommnfRV0w())) {
                        composer2.startReplaceableGroup(539856149);
                        if (function2 != null) {
                            composer2.startReplaceableGroup(539856199);
                            Debug debug = Debug.INSTANCE;
                            GlanceModifier glanceModifier4 = glanceModifier;
                            final Function2<Composer, Integer, Unit> function23 = function2;
                            debug.debugBox(glanceModifier4, null, "Medium6", false, ComposableLambdaKt.composableLambda(composer2, 369736397, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$2.1
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
                                public final void invoke(@Nullable Composer composer3, int i6) {
                                    if ((i6 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(369736397, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.<anonymous>.<anonymous> (MediumLayout.kt:255)");
                                    }
                                    if (AbstractC1038a.m1196A(composer3, 0, function23)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 221568, 10);
                            composer2.endReplaceableGroup();
                        } else if (primaryContentData != null) {
                            composer2.startReplaceableGroup(539856408);
                            CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer2, 64);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(539856643);
                            composer2.endReplaceableGroup();
                        }
                        MediumLayoutKt.MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(function22, secondaryContentData, i, i2, Column.defaultWeight(GlanceModifier.INSTANCE), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(539856744);
                        MediumLayoutKt.MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(function22, secondaryContentData, i, i2, Column.defaultWeight(GlanceModifier.INSTANCE), composer2, 0);
                        if (function2 != null) {
                            composer2.startReplaceableGroup(539856871);
                            Debug debug2 = Debug.INSTANCE;
                            GlanceModifier glanceModifier5 = glanceModifier;
                            final Function2<Composer, Integer, Unit> function24 = function2;
                            debug2.debugBox(glanceModifier5, null, "Medium7", false, ComposableLambdaKt.composableLambda(composer2, -1013110428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$2.2
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
                                public final void invoke(@Nullable Composer composer3, int i6) {
                                    if ((i6 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1013110428, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.<anonymous>.<anonymous> (MediumLayout.kt:268)");
                                    }
                                    if (AbstractC1038a.m1196A(composer3, 0, function24)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 221568, 10);
                            composer2.endReplaceableGroup();
                        } else if (primaryContentData != null) {
                            composer2.startReplaceableGroup(539857080);
                            CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer2, 64);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(539857315);
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(293736380);
            float f5 = 14;
            ColumnKt.m21455ColumnK4GKKTE(PaddingKt.m21500paddingqDBjuR0$default(androidx.glance.layout.SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f5), 0.0f, C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f5), 2, null), 0, Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, -48849995, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$1
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
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i5) {
                    Composer composer3;
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-48849995, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.<anonymous> (MediumLayout.kt:226)");
                    }
                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                    SpacerKt.Spacer(Column.defaultWeight(companion2), composer2, 0, 0);
                    if (function2 != null) {
                        composer2.startReplaceableGroup(539854927);
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier glanceModifier4 = glanceModifier;
                        final Function2<Composer, Integer, Unit> function23 = function2;
                        composer3 = composer2;
                        debug.debugBox(glanceModifier4, null, "Medium5", false, ComposableLambdaKt.composableLambda(composer2, -1910330127, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$1.1
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
                                    ComposerKt.traceEventStart(-1910330127, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.<anonymous>.<anonymous> (MediumLayout.kt:228)");
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
                            composer3.startReplaceableGroup(539855076);
                            CombineLayoutKt.PrimaryButtonContent(glanceModifier.then(glanceModifier2), primaryContentData, composer3, 64);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(539855291);
                            composer3.endReplaceableGroup();
                        }
                    }
                    SpacerKt.Spacer(Column.defaultWeight(companion2), composer3, 0, 0);
                    MediumLayoutKt.m2315x678638b5(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(androidx.glance.layout.SizeModifiersKt.wrapContentHeight(companion2)), secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer3, Units.MASTER_DPI);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 3072, 2);
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
    public static final void MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondContent(final Function2<? super Composer, ? super Integer, Unit> function2, final SecondaryContentData secondaryContentData, final int i, final int i2, GlanceModifier glanceModifier, Composer composer, int i4) {
        composer.startReplaceableGroup(953048004);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(953048004, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondContent (MediumLayout.kt:178)");
        }
        if (function2 != null) {
            composer.startReplaceableGroup(978957503);
            Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getCenter(), "Medium4", false, ComposableLambdaKt.composableLambda(composer, -1207475968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondContent$1
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
                        ComposerKt.traceEventStart(-1207475968, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondContent.<anonymous> (MediumLayout.kt:185)");
                    }
                    if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i4 & 14) | 221568 | (Alignment.$stable << 3), 8);
            composer.endReplaceableGroup();
        } else {
            if ((secondaryContentData != null ? secondaryContentData.getTextList() : null) != null) {
                composer.startReplaceableGroup(978957800);
                Alignment.Companion companion = Alignment.INSTANCE;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifier, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, -634232310, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondContent$2
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-634232310, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondContent.<anonymous> (MediumLayout.kt:193)");
                        }
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        CombineLayoutKt.MultiSpacer(androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2), 1, true, composer2, 432, 0);
                        MediumLayoutKt.m2316x9f528135(i, i2, androidx.glance.layout.SizeModifiersKt.wrapContentHeight(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion2)), secondaryContentData.getTextList(), composer2, 64);
                        CombineLayoutKt.MultiSpacer(androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2), 2, true, composer2, 432, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, (i4 & 14) | 3072, 0);
                composer.endReplaceableGroup();
            } else {
                if ((secondaryContentData != null ? secondaryContentData.getFirstProgressBar() : null) == null || secondaryContentData.getSecondProgressBar() == null) {
                    composer.startReplaceableGroup(978959065);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(978958799);
                    m2315x678638b5(glanceModifier, secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), composer, (i4 & 14) | Units.MASTER_DPI);
                    composer.endReplaceableGroup();
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondaryProgressListContent */
    public static final void m2315x678638b5(GlanceModifier glanceModifier, final LinearProgressData linearProgressData, final LinearProgressData linearProgressData2, Composer composer, int i) {
        composer.startReplaceableGroup(-892374157);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-892374157, i, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryProgressListContent (MediumLayout.kt:163)");
        }
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier, 0, 0, ComposableLambdaKt.composableLambda(composer, -820660375, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondaryProgressListContent$1
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
                    ComposerKt.traceEventStart(-820660375, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryProgressListContent.<anonymous> (MediumLayout.kt:165)");
                }
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.height(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion), 0.15f, composer2, 48), linearProgressData, composer2, 64, 0);
                AbstractC2821a.m2232w(8, companion, composer2, 0, 0);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.height(androidx.glance.layout.SizeModifiersKt.fillMaxWidth(companion), 0.15f, composer2, 48), linearProgressData2, composer2, 64, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: MediumLayout_fWZZ6NI$PrimaryWithSecondaryContent$SecondaryTextListContent */
    public static final void m2316x9f528135(int i, final int i2, GlanceModifier glanceModifier, TypedTextListData typedTextListData, Composer composer, int i4) {
        composer.startReplaceableGroup(-36903898);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-36903898, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryTextListContent (MediumLayout.kt:86)");
        }
        if (typedTextListData.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        float f = 0.06f;
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w())) {
            if (AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) > 0) {
                f = 0.05f;
            }
        } else if (typedTextListData.getItems().size() != 1 || !TextType.m21684equalsimpl0(typedTextListData.getItems().get(0).getTextType(), TextType.INSTANCE.m21694getTitlegxbDmow())) {
            f = 0.12f;
        }
        if (typedTextListData.getItems().size() == 1) {
            composer.startReplaceableGroup(488458148);
            final TypedTextData typedTextData = typedTextListData.getItems().get(0);
            Debug.INSTANCE.debugBox(PaddingModifiersKt.m21356padding6PoWaU8(glanceModifier, f, 0.0f, 0.0f, 0.0f, composer, (i4 & 14) | 384, 12), companion.getCenter(), "Medium3", false, ComposableLambdaKt.composableLambda(composer, -1148761247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondaryTextListContent$1
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
                public final void invoke(@Nullable Composer composer2, int i5) {
                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1148761247, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryTextListContent.<anonymous> (MediumLayout.kt:104)");
                    }
                    GlanceModifier glanceModifierWrapContentSize = androidx.glance.layout.SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                    int i6 = i2;
                    TypedTextData typedTextData2 = typedTextData;
                    CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentSize, i6, typedTextData2, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer2, 0, 240);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (Alignment.$stable << 3) | 221568, 8);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(488458741);
            final TypedTextData typedTextData2 = typedTextListData.getItems().get(0);
            final TypedTextData typedTextData3 = typedTextListData.getItems().get(1);
            if (typedTextListData.getOrientation() == Orientation.Vertical) {
                composer.startReplaceableGroup(488458910);
                ColumnKt.m21455ColumnK4GKKTE(PaddingModifiersKt.m21356padding6PoWaU8(glanceModifier, 0.12f, 0.0f, 0.0f, 0.0f, composer, (i4 & 14) | 432, 12), companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, 1560570642, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondaryTextListContent$2
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1560570642, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryTextListContent.<anonymous> (MediumLayout.kt:120)");
                        }
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierWrapContentSize = androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2);
                        int i6 = i2;
                        TypedTextData typedTextData4 = typedTextData2;
                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentSize, i6, typedTextData4, typedTextData4.getTextType(), 0, null, 0.0f, 0.0f, composer2, 0, 240);
                        AbstractC2821a.m2232w(1, companion2, composer2, 0, 0);
                        GlanceModifier glanceModifierWrapContentSize2 = androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2);
                        int i7 = i2;
                        TypedTextData typedTextData5 = typedTextData3;
                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentSize2, i7, typedTextData5, typedTextData5.getTextType(), 0, null, 0.0f, 0.0f, composer2, 0, 240);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, 3072, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(488459904);
                RowKt.m21502RowlMAjyxE(glanceModifier, companion.m21430getCenterHorizontallyPGIyAqw(), companion.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer, -383776823, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.MediumLayoutKt$MediumLayout$PrimaryWithSecondaryContent$SecondaryTextListContent$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-383776823, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MediumLayout.PrimaryWithSecondaryContent.SecondaryTextListContent.<anonymous> (MediumLayout.kt:140)");
                        }
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierWrapContentSize = androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2);
                        int i6 = i2;
                        TypedTextData typedTextData4 = typedTextData2;
                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentSize, i6, typedTextData4, typedTextData4.getTextType(), 0, null, 0.0f, 0.0f, composer2, 0, 240);
                        AbstractC2821a.m2232w(1, companion2, composer2, 0, 0);
                        GlanceModifier glanceModifierWrapContentSize2 = androidx.glance.layout.SizeModifiersKt.wrapContentSize(companion2);
                        int i7 = i2;
                        TypedTextData typedTextData5 = typedTextData3;
                        CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentSize2, i7, typedTextData5, typedTextData5.getTextType(), 0, null, 0.0f, 0.0f, composer2, 0, 240);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, (i4 & 14) | 3072, 0);
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
