package androidx.glance.oneui.template.layout.glance.combine.legacy;

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
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.VisibilityKt;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomTypedTextData;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.StackedGraphData;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.ImageButtonKt;
import androidx.glance.oneui.template.component.glance.ImageKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.layout.CombineLayoutDimensions;
import androidx.glance.oneui.template.layout.CombineLayoutTextSizes;
import androidx.glance.oneui.template.layout.ListLayoutDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt;
import androidx.glance.oneui.template.layout.glance.ListLayoutKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a6\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0002\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001ag\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u000100¢\u0006\u0002\b12\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u000100¢\u0006\u0002\b12\u0006\u0010\u000b\u001a\u00020\f2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u000100¢\u0006\u0002\b12\u0006\u0010\u0012\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\r\u00106\u001a\u00020\u0003H\u0001¢\u0006\u0002\u00107\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00068"}, m13886d2 = {"GlanceCombineList", "", "isSecondary", "", "listData", "Landroidx/glance/oneui/template/ListData;", "(ZLandroidx/glance/oneui/template/ListData;Landroidx/compose/runtime/Composer;I)V", "GlanceCombineProgressBars", "first", "Landroidx/glance/oneui/template/LinearProgressData;", "second", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "GlanceCombineProgressBars-RJlTeC8", "(ZLandroidx/glance/oneui/template/LinearProgressData;Landroidx/glance/oneui/template/LinearProgressData;ILandroidx/compose/runtime/Composer;II)V", "GlanceCombineStackedGraph", "stackedGraph", "Landroidx/glance/oneui/template/StackedGraphData;", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "GlanceCombineStackedGraph-ZURPRg8", "(Landroidx/glance/oneui/template/StackedGraphData;ILandroidx/compose/runtime/Composer;I)V", "GlanceCombineText", "textData", "Landroidx/glance/oneui/template/TypedTextData;", "modifier", "Landroidx/glance/GlanceModifier;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "GlanceCombineTexts", "secondaryTexts", "Landroidx/glance/oneui/template/TypedTextListData;", "tertiaryTexts", "(Landroidx/glance/oneui/template/TypedTextListData;Landroidx/glance/oneui/template/TypedTextListData;Landroidx/compose/runtime/Composer;II)V", "GlancePrimaryIcon", "icon", "Landroidx/glance/oneui/template/ImageData;", "textList", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/oneui/template/TypedTextListData;Landroidx/compose/runtime/Composer;I)V", "GlancePrimaryImageButton", MarketingConstants.BUTTON, "Landroidx/glance/oneui/template/ImageButtonData;", "(Landroidx/glance/oneui/template/ImageButtonData;Landroidx/compose/runtime/Composer;I)V", "Legacy70PreviewCombineLayout", "data", "Landroidx/glance/oneui/template/CombineData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "Legacy70PreviewCombineLayout-K-p2Snc", "(Landroidx/glance/oneui/template/CombineData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;ILandroidx/compose/runtime/Composer;I)V", "isPreview", "(Landroidx/compose/runtime/Composer;I)Z", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLegacyCombineLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyCombineLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/legacy/LegacyCombineLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,865:1\n74#2:866\n74#2:867\n74#2:868\n74#2:869\n74#2:873\n74#2:876\n74#2:877\n74#2:879\n74#2:884\n154#3:870\n154#3:871\n154#3:872\n154#3:874\n154#3:875\n154#3:878\n154#3:880\n154#3:881\n154#3:882\n154#3:883\n*S KotlinDebug\n*F\n+ 1 LegacyCombineLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/legacy/LegacyCombineLayoutKt\n*L\n67#1:866\n182#1:867\n268#1:868\n296#1:869\n381#1:873\n444#1:876\n756#1:877\n788#1:879\n108#1:884\n367#1:870\n371#1:871\n374#1:872\n389#1:874\n390#1:875\n758#1:878\n790#1:880\n797#1:881\n821#1:882\n823#1:883\n*E\n"})
public final class LegacyCombineLayoutKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCombineList(final boolean z, @NotNull ListData listData, @Nullable Composer composer, final int i) {
        final ListData listData2;
        Intrinsics.checkNotNullParameter(listData, "listData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1036251274);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1036251274, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineList (LegacyCombineLayout.kt:831)");
        }
        if (z) {
            listData2 = listData;
        } else {
            ListLayoutDimensions listLayoutDimensions = ListLayoutDimensions.INSTANCE;
            listData2 = listData;
            ListLayoutKt.m21844GlanceListLayoutYlGCr2M(listData2, false, false, listLayoutDimensions.m21784listTopPadding6r0uhjY(listData.getContentAlign(), composerStartRestartGroup, 48), listLayoutDimensions.m21783listBottomPaddinglQh0xVc(listData.getContentAlign()), false, true, composerStartRestartGroup, 1769480, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineList.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LegacyCombineLayoutKt.GlanceCombineList(z, listData2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceCombineProgressBars-RJlTeC8, reason: not valid java name */
    public static final void m21868GlanceCombineProgressBarsRJlTeC8(final boolean z, @NotNull final LinearProgressData first, @Nullable final LinearProgressData linearProgressData, int i, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        int iM21429getBottommnfRV0w;
        int i6;
        Intrinsics.checkNotNullParameter(first, "first");
        Composer composerStartRestartGroup = composer.startRestartGroup(2019795415);
        if ((i4 & 8) != 0) {
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
            i5 = i2;
            i6 = i5 & (-7169);
        } else {
            i5 = i2;
            iM21429getBottommnfRV0w = i;
            i6 = i5;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2019795415, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars (LegacyCombineLayout.kt:710)");
        }
        composerStartRestartGroup.startReplaceableGroup(-481769817);
        boolean z2 = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0;
        composerStartRestartGroup.endReplaceableGroup();
        if (z2) {
            composerStartRestartGroup.startReplaceableGroup(-481769769);
            GlanceModifier glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(z ? 6 : 3), 0.0f, C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
            if (linearProgressData != null) {
                composerStartRestartGroup.startReplaceableGroup(-481769615);
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21310marginqDBjuR0$default, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1617662531, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineProgressBars$1
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1617662531, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars.<anonymous> (LegacyCombineLayout.kt:760)");
                        }
                        if (LegacyCombineLayoutKt.isPreview(composer2, 0)) {
                            composer2.startReplaceableGroup(-1922546044);
                            ProgressIndicatorKt.GlanceLinearProgressIndicator(first, 0, composer2, 8, 2);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1922545986);
                            ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.fillMaxWidth(androidx.glance.appwidget.percent.SizeModifiersKt.height(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getMULTIPLE_PROGRESS_HEIGHT(composer2, 6), composer2, 6)), first, composer2, 64, 0);
                            composer2.endReplaceableGroup();
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion, C2256Dp.m20968constructorimpl(4)), composer2, 0, 0);
                        if (LegacyCombineLayoutKt.isPreview(composer2, 0)) {
                            composer2.startReplaceableGroup(-1922545508);
                            ProgressIndicatorKt.GlanceLinearProgressIndicator(linearProgressData, 0, composer2, 8, 2);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1922545449);
                            ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.fillMaxWidth(androidx.glance.appwidget.percent.SizeModifiersKt.height(companion, CombineTemplatePercent.INSTANCE.getMULTIPLE_PROGRESS_HEIGHT(composer2, 6), composer2, 6)), linearProgressData, composer2, 64, 0);
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 4);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-481768483);
                BoxKt.Box(glanceModifierM21310marginqDBjuR0$default, Alignment.INSTANCE.getCenterStart(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 434602676, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineProgressBars$2
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
                    public final void invoke(@Nullable Composer composer2, int i7) {
                        if ((i7 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(434602676, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars.<anonymous> (LegacyCombineLayout.kt:785)");
                        }
                        ProgressIndicatorKt.m21748GlanceLinearProgressIndicatorziNgDLE(first, C2256Dp.m20968constructorimpl(26), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-481768332);
            boolean hasTitleBar = ((TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState())).getHasTitleBar();
            composerStartRestartGroup.endReplaceableGroup();
            if (hasTitleBar) {
                composerStartRestartGroup.startReplaceableGroup(-481768319);
                ColumnKt.m21455ColumnK4GKKTE(MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(14), 0.0f, C2256Dp.m20968constructorimpl(10), 0.0f, 10, null), Alignment.INSTANCE.m21429getBottommnfRV0w(), 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1331635921, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineProgressBars$3
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1331635921, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars.<anonymous> (LegacyCombineLayout.kt:792)");
                        }
                        LegacyCombineLayoutKt.GlanceCombineProgressBars_RJlTeC8$GlanceProgressList(linearProgressData, first, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 4);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-481768108);
                Alignment.Companion companion = Alignment.INSTANCE;
                boolean zM21448equalsimpl0 = Alignment.Vertical.m21448equalsimpl0(iM21429getBottommnfRV0w, companion.m21429getBottommnfRV0w());
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(16), 0.0f, 2, null);
                ColumnKt.m21455ColumnK4GKKTE(zM21448equalsimpl0 ? PaddingKt.padding$default(glanceModifierM21498paddingVpY3zN4$default, 0, 0, 0, C3094R.dimen.sesl_glance_combine_primary_medium_default_padding, 7, null) : PaddingKt.padding$default(glanceModifierM21498paddingVpY3zN4$default, 0, C3094R.dimen.sesl_glance_combine_primary_medium_default_padding, 0, 0, 13, null), zM21448equalsimpl0 ? companion.m21429getBottommnfRV0w() : companion.m21434getTopmnfRV0w(), 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 970083569, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineProgressBars$4
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(970083569, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars.<anonymous> (LegacyCombineLayout.kt:807)");
                        }
                        LegacyCombineLayoutKt.GlanceCombineProgressBars_RJlTeC8$GlanceProgressList(linearProgressData, first, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 4);
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i7 = iM21429getBottommnfRV0w;
            final int i8 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineProgressBars$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    LegacyCombineLayoutKt.m21868GlanceCombineProgressBarsRJlTeC8(z, first, linearProgressData, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCombineProgressBars_RJlTeC8$GlanceProgressList(LinearProgressData linearProgressData, LinearProgressData linearProgressData2, Composer composer, int i) {
        composer.startReplaceableGroup(419241306);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(419241306, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineProgressBars.GlanceProgressList (LegacyCombineLayout.kt:712)");
        }
        if (linearProgressData != null) {
            composer.startReplaceableGroup(-976118517);
            if (isPreview(composer, 0)) {
                composer.startReplaceableGroup(-976118437);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(linearProgressData2, C3094R.dimen.sesl_glance_combine_body_medium_linear_progress_height, composer, 8, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-976118240);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.fillMaxWidth(androidx.glance.appwidget.percent.SizeModifiersKt.height(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getMULTIPLE_PROGRESS_HEIGHT(composer, 6), composer, 6)), linearProgressData2, composer, 64, 0);
                composer.endReplaceableGroup();
            }
            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
            SpacerKt.Spacer(SizeModifiersKt.height(companion, C3094R.dimen.sesl_glance_combine_body_medium_linear_progress_vertical_margin), composer, 0, 0);
            if (isPreview(composer, 0)) {
                composer.startReplaceableGroup(-976117671);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(linearProgressData, C3094R.dimen.sesl_glance_combine_body_medium_linear_progress_height, composer, 8, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-976117473);
                ProgressIndicatorKt.GlanceLinearProgressIndicator(SizeModifiersKt.fillMaxWidth(androidx.glance.appwidget.percent.SizeModifiersKt.height(companion, CombineTemplatePercent.INSTANCE.getMULTIPLE_PROGRESS_HEIGHT(composer, 6), composer, 6)), linearProgressData, composer, 64, 0);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-976117100);
            ProgressIndicatorKt.GlanceLinearProgressIndicator(linearProgressData2, 0, composer, 8, 2);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceCombineStackedGraph-ZURPRg8, reason: not valid java name */
    public static final void m21869GlanceCombineStackedGraphZURPRg8(@NotNull final StackedGraphData stackedGraph, final int i, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(stackedGraph, "stackedGraph");
        Composer composerStartRestartGroup = composer.startRestartGroup(1993465300);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1993465300, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineStackedGraph (LegacyCombineLayout.kt:816)");
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        BoxKt.Box(Alignment.Horizontal.m21438equalsimpl0(i, companion.m21432getEndPGIyAqw()) ? MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(4), 0.0f, C2256Dp.m20968constructorimpl(14), 0.0f, 10, null) : MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(14), 0.0f, C2256Dp.m20968constructorimpl(4), 0.0f, 10, null), companion.getCenterStart(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -251882442, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineStackedGraph$1
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
                    ComposerKt.traceEventStart(-251882442, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineStackedGraph.<anonymous> (LegacyCombineLayout.kt:826)");
                }
                LinearGraphLayoutKt.GlanceStackedGraph(stackedGraph, 0, composer2, 8, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineStackedGraph$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LegacyCombineLayoutKt.m21869GlanceCombineStackedGraphZURPRg8(stackedGraph, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011c  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GlanceCombineText(@NotNull final TypedTextData textData, @Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        GlanceModifier glanceModifier2;
        ColorProvider onBackground;
        int textType;
        TextType.Companion companion;
        TextSize labelText;
        final GlanceModifier glanceModifier3;
        final ColorProvider colorProvider2;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2101233005);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 128;
        }
        if (i6 == 4 && (i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            glanceModifier3 = glanceModifier;
            colorProvider2 = colorProvider;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                glanceModifier2 = i5 != 0 ? GlanceModifier.INSTANCE : glanceModifier;
                if (i6 != 0) {
                    i4 &= -897;
                    onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2101233005, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineText (LegacyCombineLayout.kt:850)");
                }
                textType = textData.getTextType();
                companion = TextType.INSTANCE;
                if (!TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
                    composerStartRestartGroup.startReplaceableGroup(-320410545);
                    labelText = CombineLayoutTextSizes.INSTANCE.getDisplayText(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (TextType.m21684equalsimpl0(textType, companion.m21694getTitlegxbDmow())) {
                    composerStartRestartGroup.startReplaceableGroup(-320410485);
                    labelText = CombineLayoutTextSizes.INSTANCE.getTitleText(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (TextType.m21684equalsimpl0(textType, companion.m21689getBodygxbDmow())) {
                    composerStartRestartGroup.startReplaceableGroup(-320410428);
                    labelText = CombineLayoutTextSizes.INSTANCE.getBodyText(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-320410372);
                    labelText = CombineLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                TextKt.GlanceText(textData, labelText, ColorProvidersKt.override(onBackground, textData.getTextColor()), glanceModifier2, composerStartRestartGroup, ((i4 << 6) & 7168) | (i4 & 14) | 512 | (TextPercentData.$stable << 3), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                glanceModifier3 = glanceModifier2;
                colorProvider2 = onBackground;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if (i6 != 0) {
                    i4 &= -897;
                }
                glanceModifier2 = glanceModifier;
            }
            onBackground = colorProvider;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            textType = textData.getTextType();
            companion = TextType.INSTANCE;
            if (!TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
            }
            TextKt.GlanceText(textData, labelText, ColorProvidersKt.override(onBackground, textData.getTextColor()), glanceModifier2, composerStartRestartGroup, ((i4 << 6) & 7168) | (i4 & 14) | 512 | (TextPercentData.$stable << 3), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            glanceModifier3 = glanceModifier2;
            colorProvider2 = onBackground;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    LegacyCombineLayoutKt.GlanceCombineText(textData, glanceModifier3, colorProvider2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCombineTexts(@Nullable final TypedTextListData typedTextListData, @Nullable final TypedTextListData typedTextListData2, @Nullable Composer composer, final int i, final int i2) {
        TypedTextListData typedTextListData3;
        List<TypedTextData> items;
        Composer composerStartRestartGroup = composer.startRestartGroup(-93338212);
        int i4 = i2 & 1;
        int i5 = i4 != 0 ? i | 2 : i;
        int i6 = i2 & 2;
        if (i6 != 0) {
            i5 |= 16;
        }
        if ((i2 & 3) == 3 && (i5 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                typedTextListData = null;
            }
            if (i6 != 0) {
                typedTextListData2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-93338212, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts (LegacyCombineLayout.kt:438)");
            }
            if (typedTextListData == null && typedTextListData2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineTexts.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i7) {
                            LegacyCombineLayoutKt.GlanceCombineTexts(typedTextListData, typedTextListData2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            final boolean z = AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) && typedTextListData2 != null;
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-1343882259);
                if (typedTextListData != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1343882221);
                    if (typedTextListData.getItems().size() != 1 || typedTextListData2 == null || (items = typedTextListData2.getItems()) == null || items.size() != 1) {
                        composerStartRestartGroup.startReplaceableGroup(-1343880617);
                        RowKt.m21502RowlMAjyxE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1410398063, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineTexts.3
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
                            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i7) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1410398063, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.<anonymous> (LegacyCombineLayout.kt:680)");
                                }
                                TypedTextListData typedTextListData4 = typedTextListData;
                                int i8 = mask;
                                boolean z2 = z;
                                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                LegacyCombineLayoutKt.GlanceCombineTexts$SecondaryTexts(typedTextListData4, i8, z2, SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2)), composer2, 0);
                                LegacyCombineLayoutKt.GlanceCombineTexts$TertiaryTexts(typedTextListData2, mask, z, SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2)), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, 3072, 2);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1343882136);
                        RowKt.m21502RowlMAjyxE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1889953480, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineTexts.2
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
                            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i7) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1889953480, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.<anonymous> (LegacyCombineLayout.kt:646)");
                                }
                                composer2.startReplaceableGroup(-1867798768);
                                TypedTextData typedTextData = (TypedTextData) CollectionsKt.first((List) typedTextListData.getItems());
                                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2));
                                CombineLayoutDimensions combineLayoutDimensions = CombineLayoutDimensions.INSTANCE;
                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData, MarginKt.margin(glanceModifierWrapContentHeight, combineLayoutDimensions.m21772textPaddingAS5t1TI(typedTextData.getTextType(), null, null, true, true, null, composer2, 1600512, 38)), null, composer2, 0, 4);
                                composer2.endReplaceableGroup();
                                TypedTextData typedTextData2 = (TypedTextData) CollectionsKt.first((List) typedTextListData2.getItems());
                                typedTextData2.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData2, MarginKt.margin(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2)), combineLayoutDimensions.m21772textPaddingAS5t1TI(typedTextData2.getTextType(), null, null, false, true, null, composer2, 1600512, 38)), null, composer2, 0, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, 3072, 6);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1343880204);
                    GlanceCombineTexts$TertiaryTexts(typedTextListData2, mask, z, SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                typedTextListData3 = typedTextListData;
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1343880076);
                if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                    composerStartRestartGroup.startReplaceableGroup(-1343880026);
                    BoxKt.Box(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.getCenterStart(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 292431472, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineTexts.4
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
                        public final void invoke(@Nullable Composer composer2, int i7) {
                            if ((i7 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(292431472, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.<anonymous> (LegacyCombineLayout.kt:696)");
                            }
                            LegacyCombineLayoutKt.GlanceCombineTexts$SecondaryTexts(typedTextListData, mask, z, SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    typedTextListData3 = typedTextListData;
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1343879613);
                    typedTextListData3 = typedTextListData;
                    GlanceCombineTexts$SecondaryTexts(typedTextListData3, mask, z, SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typedTextListData = typedTextListData3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlanceCombineTexts.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    LegacyCombineLayoutKt.GlanceCombineTexts(typedTextListData, typedTextListData2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCombineTexts$LayoutHorizontal$4(int i, final boolean z, final List<? extends TypedTextData> list, int i2, final boolean z2, GlanceModifier glanceModifier, Composer composer, int i4) {
        int iM21433getStartPGIyAqw;
        composer.startReplaceableGroup(1570086005);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1570086005, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutHorizontal (LegacyCombineLayout.kt:453)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            Alignment.Companion companion = Alignment.INSTANCE;
            iM21433getStartPGIyAqw = z2 ? companion.m21433getStartPGIyAqw() : companion.m21432getEndPGIyAqw();
        } else {
            TextAlign.Companion companion2 = TextAlign.INSTANCE;
            iM21433getStartPGIyAqw = TextAlign.m22003equalsimpl0(i2, companion2.m22011getStartROrN78o()) ? true : TextAlign.m22003equalsimpl0(i2, companion2.m22009getLeftROrN78o()) ? Alignment.INSTANCE.m21433getStartPGIyAqw() : TextAlign.m22003equalsimpl0(i2, companion2.m22007getCenterROrN78o()) ? Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw() : Alignment.INSTANCE.m21432getEndPGIyAqw();
        }
        RowKt.m21502RowlMAjyxE(glanceModifier, iM21433getStartPGIyAqw, 0, ComposableLambdaKt.composableLambda(composer, -1909138471, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutHorizontal$1
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
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1909138471, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutHorizontal.<anonymous> (LegacyCombineLayout.kt:468)");
                }
                List<TypedTextData> list2 = list;
                boolean z3 = z2;
                boolean z4 = z;
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    LegacyCombineLayoutKt.GlanceCombineText((TypedTextData) obj, MarginKt.margin(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.textPadding(list2, i6, z3, z4, Orientation.Horizontal, composer2, 221192, 0)), null, composer2, 0, 4);
                    i6 = i7;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, ((i4 >> 9) & 14) | 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void GlanceCombineTexts$LayoutVertical$5(final int i, final boolean z, final List<? extends TypedTextData> list, final boolean z2, GlanceModifier glanceModifier, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(1545004503);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1545004503, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical (LegacyCombineLayout.kt:491)");
        }
        final GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21569getMediumrx25Pp4()) < 0 && list.size() == 2) {
            int textType = list.get(0).getTextType();
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) && (TextType.m21684equalsimpl0(list.get(1).getTextType(), companion2.m21689getBodygxbDmow()) || TextType.m21684equalsimpl0(list.get(1).getTextType(), companion2.m21693getLabelgxbDmow()))) {
                composer.startReplaceableGroup(1946223673);
                composer2 = composer;
                BoxKt.Box(SizeModifiersKt.wrapContentHeight(glanceModifier), null, ComposableLambdaKt.composableLambda(composer, 1562650576, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutVertical$1
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
                            ComposerKt.traceEventStart(1562650576, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical.<anonymous> (LegacyCombineLayout.kt:500)");
                        }
                        TypedTextData typedTextData = list.get(0);
                        if (!z2) {
                            typedTextData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                        }
                        LegacyCombineLayoutKt.GlanceCombineText(typedTextData, MarginKt.margin(glanceModifierWrapContentHeight, CombineLayoutDimensions.INSTANCE.m21772textPaddingAS5t1TI(list.get(0).getTextType(), null, null, z2, z, null, composer3, 1572864, 38)), null, composer3, 0, 4);
                        GlanceModifier glanceModifierVisibility = VisibilityKt.visibility(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), CombineTemplateDp.INSTANCE.getMULTIPLE_TEXT_HEIGHT(composer3, 6)), C3094R.integer.sesl_glance_combine_body_small_2nd_text__visibility);
                        Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                        final List<TypedTextData> list2 = list;
                        final GlanceModifier glanceModifier2 = glanceModifierWrapContentHeight;
                        final boolean z3 = z2;
                        final boolean z4 = z;
                        BoxKt.Box(glanceModifierVisibility, bottomStart, ComposableLambdaKt.composableLambda(composer3, 1481557298, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutVertical$1.2
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
                                    ComposerKt.traceEventStart(1481557298, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:519)");
                                }
                                TypedTextData typedTextData2 = list2.get(1);
                                if (!z3) {
                                    typedTextData2.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                                }
                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData2, MarginKt.margin(glanceModifier2, CombineLayoutDimensions.INSTANCE.m21772textPaddingAS5t1TI(list2.get(1).getTextType(), null, null, z3, z4, null, composer4, 1572864, 38)), null, composer4, 0, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (Alignment.$stable << 3) | 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 384, 2);
                composer2.endReplaceableGroup();
            }
        } else if (AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21569getMediumrx25Pp4()) >= 0 || list.size() != 2) {
            composer.startReplaceableGroup(1946227128);
            ColumnKt.m21455ColumnK4GKKTE(glanceModifier, 0, 0, ComposableLambdaKt.composableLambda(composer, 141657201, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutVertical$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i4) {
                    int i5;
                    boolean z3;
                    boolean z4;
                    Composer composer4 = composer3;
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(141657201, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical.<anonymous> (LegacyCombineLayout.kt:572)");
                    }
                    List<TypedTextData> list2 = list;
                    boolean z5 = z2;
                    int i6 = i;
                    GlanceModifier glanceModifier2 = glanceModifierWrapContentHeight;
                    boolean z6 = z;
                    int i7 = 0;
                    for (Object obj : list2) {
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        TypedTextData typedTextData = (TypedTextData) obj;
                        if (typedTextData instanceof CustomTypedTextData) {
                            composer4.startReplaceableGroup(-874469570);
                            CustomTypedTextData customTypedTextData = (CustomTypedTextData) typedTextData;
                            customTypedTextData.CustomContent(customTypedTextData, composer4, 0);
                            composer4.endReplaceableGroup();
                        } else if (typedTextData instanceof TypedTextListData) {
                            composer4.startReplaceableGroup(-874469469);
                            boolean z7 = z6;
                            LegacyCombineLayoutKt.GlanceCombineTexts$LayoutHorizontal$4(i6, z7, ((TypedTextListData) typedTextData).getItems(), typedTextData.getTextAlign(), z5, SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), composer3, 8);
                            z6 = z7;
                            composer3.endReplaceableGroup();
                        } else {
                            composer4.startReplaceableGroup(-874469153);
                            composer4.startReplaceableGroup(-874469123);
                            if (AppWidgetSize.m21546compareToL2j3NV4(i6, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                                TypedTextData typedTextData2 = i7 > 0 ? list2.get(i7 - 1) : null;
                                if (typedTextData2 != null) {
                                    int textType2 = typedTextData2.getTextType();
                                    TextType.Companion companion3 = TextType.INSTANCE;
                                    if (TextType.m21684equalsimpl0(textType2, companion3.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(typedTextData.getTextType(), companion3.m21693getLabelgxbDmow())) {
                                        composer4.startReplaceableGroup(-874468763);
                                        SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(1)), composer4, 0, 0);
                                        composer4.endReplaceableGroup();
                                    } else if (TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion3.m21694getTitlegxbDmow()) && TextType.m21684equalsimpl0(typedTextData.getTextType(), companion3.m21689getBodygxbDmow())) {
                                        composer4.startReplaceableGroup(-874468503);
                                        SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(2)), composer4, 0, 0);
                                        composer4.endReplaceableGroup();
                                    } else {
                                        composer4.startReplaceableGroup(-874468388);
                                        composer4.endReplaceableGroup();
                                    }
                                }
                            }
                            composer4.endReplaceableGroup();
                            if (!z5) {
                                typedTextData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                            }
                            i5 = i6;
                            z3 = z5;
                            z4 = z6;
                            LegacyCombineLayoutKt.GlanceCombineText(typedTextData, MarginKt.margin(glanceModifier2, CombineLayoutDimensions.INSTANCE.m21772textPaddingAS5t1TI(typedTextData.getTextType(), null, null, z5, z6, null, composer3, 1572864, 38)), null, composer3, 0, 4);
                            composer3.endReplaceableGroup();
                            composer4 = composer3;
                            z5 = z3;
                            z6 = z4;
                            i7 = i8;
                            i6 = i5;
                        }
                        i5 = i6;
                        z3 = z5;
                        z4 = z6;
                        composer4 = composer3;
                        z5 = z3;
                        z6 = z4;
                        i7 = i8;
                        i6 = i5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, ((i2 >> 6) & 14) | 3072, 6);
            composer2 = composer;
            composer2.endReplaceableGroup();
        } else {
            int textType2 = list.get(1).getTextType();
            TextType.Companion companion3 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType2, companion3.m21691getDisplaygxbDmow()) && (TextType.m21684equalsimpl0(list.get(0).getTextType(), companion3.m21689getBodygxbDmow()) || TextType.m21684equalsimpl0(list.get(0).getTextType(), companion3.m21693getLabelgxbDmow()))) {
                composer.startReplaceableGroup(1946225505);
                BoxKt.Box(SizeModifiersKt.wrapContentHeight(glanceModifier), null, ComposableLambdaKt.composableLambda(composer, 691161145, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutVertical$2
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
                            ComposerKt.traceEventStart(691161145, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical.<anonymous> (LegacyCombineLayout.kt:538)");
                        }
                        GlanceModifier glanceModifierVisibility = VisibilityKt.visibility(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), CombineTemplateDp.INSTANCE.getMULTIPLE_TEXT_HEIGHT(composer3, 6)), C3094R.integer.sesl_glance_combine_body_small_2nd_text__visibility);
                        Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                        final List<TypedTextData> list2 = list;
                        final GlanceModifier glanceModifier2 = glanceModifierWrapContentHeight;
                        final boolean z3 = z2;
                        final boolean z4 = z;
                        BoxKt.Box(glanceModifierVisibility, bottomStart, ComposableLambdaKt.composableLambda(composer3, 69932315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$GlanceCombineTexts$LayoutVertical$2.1
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
                                    ComposerKt.traceEventStart(69932315, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:547)");
                                }
                                TypedTextData typedTextData = list2.get(1);
                                if (!z3) {
                                    typedTextData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                                }
                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData, MarginKt.margin(glanceModifier2, CombineLayoutDimensions.INSTANCE.m21772textPaddingAS5t1TI(list2.get(1).getTextType(), null, null, z3, z4, null, composer4, 1572864, 38)), null, composer4, 0, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (Alignment.$stable << 3) | 384, 0);
                        TypedTextData typedTextData = list.get(0);
                        if (!z2) {
                            typedTextData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22008getEndROrN78o());
                        }
                        LegacyCombineLayoutKt.GlanceCombineText(typedTextData, MarginKt.margin(glanceModifierWrapContentHeight, CombineLayoutDimensions.INSTANCE.m21772textPaddingAS5t1TI(list.get(0).getTextType(), null, null, z2, z, null, composer3, 1572864, 38)), null, composer3, 0, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, 384, 2);
                composer.endReplaceableGroup();
                composer2 = composer;
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
    public static final void GlanceCombineTexts$SecondaryTexts(TypedTextListData typedTextListData, int i, boolean z, GlanceModifier glanceModifier, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-138551481);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-138551481, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.SecondaryTexts (LegacyCombineLayout.kt:619)");
        }
        List<TypedTextData> items = typedTextListData != null ? typedTextListData.getItems() : null;
        List<TypedTextData> list = items;
        if (list == null || list.isEmpty()) {
            composer2 = composer;
        } else if (typedTextListData.getOrientation() == Orientation.Horizontal) {
            composer.startReplaceableGroup(2067772031);
            GlanceCombineTexts$LayoutHorizontal$4(i, z, items, typedTextListData.getTextAlign(), true, glanceModifier, composer, ((i2 << 9) & 7168) | 392);
            composer2 = composer;
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(2067772146);
            GlanceCombineTexts$LayoutVertical$5(i, z, items, true, glanceModifier, composer2, ((i2 << 6) & 896) | 56);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCombineTexts$TertiaryTexts(TypedTextListData typedTextListData, int i, boolean z, GlanceModifier glanceModifier, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-577608435);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-577608435, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlanceCombineTexts.TertiaryTexts (LegacyCombineLayout.kt:631)");
        }
        List<TypedTextData> items = typedTextListData != null ? typedTextListData.getItems() : null;
        List<TypedTextData> list = items;
        if (list == null || list.isEmpty()) {
            composer2 = composer;
        } else if (typedTextListData.getOrientation() == Orientation.Horizontal) {
            composer.startReplaceableGroup(879152532);
            GlanceCombineTexts$LayoutHorizontal$4(i, z, items, typedTextListData.getTextAlign(), false, glanceModifier, composer, ((i2 << 9) & 7168) | 392);
            composer2 = composer;
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(879152647);
            GlanceCombineTexts$LayoutVertical$5(i, z, items, false, glanceModifier, composer2, ((i2 << 6) & 896) | 56);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlancePrimaryIcon(@NotNull final ImageData icon, @Nullable final TypedTextListData typedTextListData, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1502268410);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1502268410, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon (LegacyCombineLayout.kt:294)");
        }
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1400468917);
            if (typedTextListData != null && !typedTextListData.getItems().isEmpty()) {
                composerStartRestartGroup.startReplaceableGroup(1400468980);
                final TypedTextData typedTextData = typedTextListData.getItems().get(0);
                final TypedTextData typedTextData2 = typedTextListData.getItems().size() > 1 ? typedTextListData.getItems().get(1) : null;
                ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1697756390, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1
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
                        GlanceModifier glanceModifierM21387size9UTdIk;
                        Composer composer3;
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1697756390, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous> (LegacyCombineLayout.kt:303)");
                        }
                        if (LegacyCombineLayoutKt.isPreview(composer2, 0)) {
                            composer2.startReplaceableGroup(310998184);
                            glanceModifierM21387size9UTdIk = SizeModifiersKt.size(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.primaryIconSizeResId(typedTextData2 != null, composer2, 48));
                            composer2.endReplaceableGroup();
                            composer3 = composer2;
                        } else {
                            composer2.startReplaceableGroup(310998295);
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            composer2.startReplaceableGroup(310998368);
                            float tiny_icon_size_with_multiple_text = typedTextData2 != null ? CombineTemplatePercent.INSTANCE.getTINY_ICON_SIZE_WITH_MULTIPLE_TEXT() : CombineTemplatePercent.INSTANCE.getTINY_ICON_SIZE_WITH_TEXT(composer2, 6);
                            composer2.endReplaceableGroup();
                            glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(companion, tiny_icon_size_with_multiple_text, 0, 0.0f, composer2, 6, 6);
                            composer3 = composer2;
                            composer3.endReplaceableGroup();
                        }
                        ImageKt.m21746GlanceImagecuCYCYk(icon, glanceModifierM21387size9UTdIk, 0, composer3, 8, 4);
                        if (typedTextData2 == null) {
                            composer3.startReplaceableGroup(310998702);
                            GlanceModifier glanceModifierWrapContentWidth = SizeModifiersKt.wrapContentWidth(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(20)));
                            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                            final TypedTextData typedTextData3 = typedTextData;
                            BoxKt.Box(glanceModifierWrapContentWidth, centerStart, ComposableLambdaKt.composableLambda(composer3, -160939135, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1.1
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
                                        ComposerKt.traceEventStart(-160939135, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous>.<anonymous> (LegacyCombineLayout.kt:318)");
                                    }
                                    LegacyCombineLayoutKt.GlanceCombineText(typedTextData3, PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(6), 0.0f, 2, null), null, composer4, 0, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, (Alignment.$stable << 3) | 384, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            int textType = typedTextData.getTextType();
                            TextType.Companion companion2 = TextType.INSTANCE;
                            if (!TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) || TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion2.m21691getDisplaygxbDmow())) {
                                composer3.startReplaceableGroup(311000326);
                                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                                Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                                final TypedTextData typedTextData4 = typedTextData2;
                                final TypedTextData typedTextData5 = typedTextData;
                                BoxKt.Box(glanceModifierWrapContentHeight, bottomCenter, ComposableLambdaKt.composableLambda(composer3, -696422056, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1.3
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
                                    public final void invoke(@Nullable Composer composer4, int i4) {
                                        if ((i4 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-696422056, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous>.<anonymous> (LegacyCombineLayout.kt:348)");
                                        }
                                        GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                        GlanceModifier glanceModifierVisibility = VisibilityKt.visibility(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), CombineTemplateDp.INSTANCE.getTINY_MULTIPLE_TEXT_HEIGHT(composer4, 6)), C3094R.integer.sesl_glance_combine_body_tiny_2nd_text_visibility);
                                        Alignment topCenter = Alignment.INSTANCE.getTopCenter();
                                        final TypedTextData typedTextData6 = typedTextData5;
                                        BoxKt.Box(glanceModifierVisibility, topCenter, ComposableLambdaKt.composableLambda(composer4, 1494270518, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1.3.1
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
                                            public final void invoke(@Nullable Composer composer5, int i5) {
                                                if ((i5 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1494270518, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous>.<anonymous>.<anonymous> (LegacyCombineLayout.kt:358)");
                                                }
                                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData6, PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(5), 0.0f, 2, null), null, composer5, 0, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, (Alignment.$stable << 3) | 384, 0);
                                        LegacyCombineLayoutKt.GlanceCombineText(typedTextData4, PaddingKt.m21498paddingVpY3zN4$default(companion3, C2256Dp.m20968constructorimpl(5), 0.0f, 2, null), null, composer4, 0, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, (Alignment.$stable << 3) | 384, 0);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(310999113);
                                GlanceModifier glanceModifierWrapContentHeight2 = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                                Alignment topCenter = Alignment.INSTANCE.getTopCenter();
                                final TypedTextData typedTextData6 = typedTextData;
                                final TypedTextData typedTextData7 = typedTextData2;
                                BoxKt.Box(glanceModifierWrapContentHeight2, topCenter, ComposableLambdaKt.composableLambda(composer3, 304281464, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1.2
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
                                    public final void invoke(@Nullable Composer composer4, int i4) {
                                        if ((i4 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(304281464, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous>.<anonymous> (LegacyCombineLayout.kt:326)");
                                        }
                                        TypedTextData typedTextData8 = typedTextData6;
                                        GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                        LegacyCombineLayoutKt.GlanceCombineText(typedTextData8, PaddingKt.m21498paddingVpY3zN4$default(companion3, C2256Dp.m20968constructorimpl(5), 0.0f, 2, null), null, composer4, 0, 4);
                                        GlanceModifier glanceModifierVisibility = VisibilityKt.visibility(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), CombineTemplateDp.INSTANCE.getTINY_MULTIPLE_TEXT_HEIGHT(composer4, 6)), C3094R.integer.sesl_glance_combine_body_tiny_2nd_text_visibility);
                                        Alignment bottomCenter2 = Alignment.INSTANCE.getBottomCenter();
                                        final TypedTextData typedTextData9 = typedTextData7;
                                        BoxKt.Box(glanceModifierVisibility, bottomCenter2, ComposableLambdaKt.composableLambda(composer4, -2033800874, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.1.2.1
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
                                            public final void invoke(@Nullable Composer composer5, int i5) {
                                                if ((i5 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2033800874, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous>.<anonymous>.<anonymous> (LegacyCombineLayout.kt:337)");
                                                }
                                                LegacyCombineLayoutKt.GlanceCombineText(typedTextData9, PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(12), 0.0f, 2, null), null, composer5, 0, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, (Alignment.$stable << 3) | 384, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, (Alignment.$stable << 3) | 384, 0);
                                composer3.endReplaceableGroup();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 2);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
            } else if (icon.getImageType() == ImageType.Icon) {
                composerStartRestartGroup.startReplaceableGroup(1400472634);
                BoxKt.Box(PaddingKt.m21496padding3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(12)), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -196177303, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.2
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
                            ComposerKt.traceEventStart(-196177303, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryIcon.<anonymous> (LegacyCombineLayout.kt:367)");
                        }
                        ImageKt.m21747GlanceImageziNgDLE(icon, C2256Dp.m20968constructorimpl(0), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 384, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1400472797);
                ImageKt.m21747GlanceImageziNgDLE(icon, C2256Dp.m20968constructorimpl(0), composerStartRestartGroup, 56);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1400472874);
            ImageKt.m21747GlanceImageziNgDLE(icon, C2256Dp.m20968constructorimpl(0), composerStartRestartGroup, 56);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryIcon.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LegacyCombineLayoutKt.GlancePrimaryIcon(icon, typedTextListData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlancePrimaryImageButton(@NotNull ImageButtonData button, @Nullable Composer composer, final int i) {
        final ImageButtonData imageButtonData;
        Intrinsics.checkNotNullParameter(button, "button");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1660801069);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1660801069, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.GlancePrimaryImageButton (LegacyCombineLayout.kt:378)");
        }
        float primary_content_size_percent = CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composerStartRestartGroup, 6);
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(185744279);
            if (isPreview(composerStartRestartGroup, 0)) {
                composerStartRestartGroup.startReplaceableGroup(185744306);
                composerStartRestartGroup.startReplaceableGroup(185744362);
                if (button.getBackgroundColor() == null) {
                    button.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.m21740GlanceImageButtondjqsMU(button, C2256Dp.m20968constructorimpl(0), C2256Dp.m20968constructorimpl(12), null, composerStartRestartGroup, 440, 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(185744642);
                GlanceModifier glanceModifierM21357paddingLwRUR8o = PaddingModifiersKt.m21357paddingLwRUR8o(androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, primary_content_size_percent, 0, 0.0f, composerStartRestartGroup, 6, 6), primary_content_size_percent * 0.2f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceableGroup(185744909);
                if (button.getBackgroundColor() == null) {
                    button.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.GlanceImageButton(button, glanceModifierM21357paddingLwRUR8o, composerStartRestartGroup, 8, 0);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            imageButtonData = button;
        } else {
            composerStartRestartGroup.startReplaceableGroup(185745134);
            if (isPreview(composerStartRestartGroup, 0)) {
                composerStartRestartGroup.startReplaceableGroup(185745161);
                composerStartRestartGroup.startReplaceableGroup(185745217);
                if (button.getBackgroundColor() == null) {
                    button.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                CombineLayoutDimensions combineLayoutDimensions = CombineLayoutDimensions.INSTANCE;
                imageButtonData = button;
                ImageButtonKt.GlanceImageButton(imageButtonData, combineLayoutDimensions.getPrimaryContentResIds(composerStartRestartGroup, 6).getSize(), combineLayoutDimensions.getPrimaryContentResIds(composerStartRestartGroup, 6).getPadding(), null, composerStartRestartGroup, 8, 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(185745526);
                GlanceModifier glanceModifierM21744withSizeAndPaddingZbchW5Y = ImageButtonKt.m21744withSizeAndPaddingZbchW5Y(GlanceModifier.INSTANCE, button, primary_content_size_percent, 0.2f, 0, composerStartRestartGroup, 3142, 8);
                imageButtonData = button;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceableGroup(185745841);
                if (imageButtonData.getBackgroundColor() == null) {
                    imageButtonData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.GlanceImageButton(imageButtonData, glanceModifierM21744withSizeAndPaddingZbchW5Y, composerStartRestartGroup, 8, 0);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.GlancePrimaryImageButton.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LegacyCombineLayoutKt.GlancePrimaryImageButton(imageButtonData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0][0]]")
    /* JADX INFO: renamed from: Legacy70PreviewCombineLayout-K-p2Snc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21870Legacy70PreviewCombineLayoutKp2Snc(@Nullable final CombineData combineData, @NotNull final Function2<? super Composer, ? super Integer, Unit> primaryContent, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, final int i, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, final int i2, @Nullable Composer composer, int i4) {
        int i5;
        Composer composer2;
        int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SecondaryContentData secondaryContentData;
        final Function2<? super Composer, ? super Integer, Unit> secondaryContent = function2;
        Intrinsics.checkNotNullParameter(primaryContent, "primaryContent");
        Intrinsics.checkNotNullParameter(secondaryContent, "secondaryContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1618263037);
        if (ComposerKt.isTraceInProgress()) {
            i5 = i4;
            ComposerKt.traceEventStart(-1618263037, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout (LegacyCombineLayout.kt:76)");
        } else {
            i5 = i4;
        }
        boolean z = (((combineData == null || (secondaryContentData = combineData.getSecondaryContentData()) == null) ? null : secondaryContentData.getFirstProgressBar()) == null || combineData.getSecondaryContentData().getSecondProgressBar() == null) ? false : true;
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(947945573);
            BoxKt.Box(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 97283929, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$1
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

                @Composable
                public final void invoke(@Nullable Composer composer3, int i7) {
                    if ((i7 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(97283929, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous> (LegacyCombineLayout.kt:184)");
                    }
                    if (AbstractC1038a.m1196A(composer3, 0, primaryContent)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(947945748);
            GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
            CombineTemplateDp combineTemplateDp = CombineTemplateDp.INSTANCE;
            Legacy70PreviewCombineLayout_K_p2Snc$LayoutHorizontal(primaryContent, secondaryContent, MarginKt.m21310marginqDBjuR0$default(glanceModifierFillMaxSize, combineTemplateDp.getSMALL_START_PADDING(composerStartRestartGroup, 6), 0.0f, combineTemplateDp.getSMALL_END_PADDING(composerStartRestartGroup, 6), 0.0f, 10, null), Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(947946174);
                if (function22 != null) {
                    composerStartRestartGroup.startReplaceableGroup(947946203);
                    GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    CombineTemplateDp combineTemplateDp2 = CombineTemplateDp.INSTANCE;
                    RowKt.m21502RowlMAjyxE(MarginKt.m21310marginqDBjuR0$default(glanceModifierFillMaxSize2, combineTemplateDp2.getSMALL_START_PADDING(composerStartRestartGroup, 6), 0.0f, combineTemplateDp2.getSMALL_END_PADDING(composerStartRestartGroup, 6), 0.0f, 10, null), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1640197502, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$2
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

                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i7) {
                            Composer composer4;
                            GlanceModifier glanceModifierM21387size9UTdIk;
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1640197502, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous> (LegacyCombineLayout.kt:209)");
                            }
                            if (LegacyCombineLayoutKt.isPreview(composer3, 0)) {
                                composer3.startReplaceableGroup(-639382768);
                                glanceModifierM21387size9UTdIk = SizeModifiersKt.size(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer3, 6).getSize());
                                composer3.endReplaceableGroup();
                                composer4 = composer3;
                            } else {
                                composer3.startReplaceableGroup(-639382664);
                                composer4 = composer3;
                                glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composer3, 6), 0, 0.0f, composer4, 6, 6);
                                composer4.endReplaceableGroup();
                            }
                            GlanceModifier glanceModifier = glanceModifierM21387size9UTdIk;
                            final Function2<Composer, Integer, Unit> function23 = primaryContent;
                            Composer composer5 = composer4;
                            BoxKt.Box(glanceModifier, null, ComposableLambdaKt.composableLambda(composer4, 2089452256, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@Nullable Composer composer6, int i8) {
                                    if ((i8 & 11) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2089452256, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:213)");
                                    }
                                    if (AbstractC1038a.m1196A(composer6, 0, function23)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer5, 384, 2);
                            GlanceModifier glanceModifierFillMaxSize3 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                            final Function2<Composer, Integer, Unit> function24 = secondaryContent;
                            final Function2<Composer, Integer, Unit> function25 = function22;
                            RowKt.m21502RowlMAjyxE(glanceModifierFillMaxSize3, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer5, 1072452838, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer6, Integer num) {
                                    invoke(rowScope, composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer6, int i8) {
                                    Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1072452838, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:218)");
                                    }
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(Row2.defaultWeight(companion2)), 0.0f, 0.0f, CombineTemplateDp.INSTANCE.getSMALL_TEXT_PADDING(composer6, 6), 0.0f, 11, null);
                                    final Function2<Composer, Integer, Unit> function26 = function24;
                                    BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, null, ComposableLambdaKt.composableLambda(composer6, -969912124, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.Legacy70PreviewCombineLayout.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                            invoke(composer7, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        public final void invoke(@Nullable Composer composer7, int i9) {
                                            if ((i9 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-969912124, i9, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous>.<anonymous> (LegacyCombineLayout.kt:224)");
                                            }
                                            if (AbstractC1038a.m1196A(composer7, 0, function26)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer6, 384, 2);
                                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row2.defaultWeight(companion2));
                                    final Function2<Composer, Integer, Unit> function27 = function25;
                                    BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.composableLambda(composer6, 1319285563, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt.Legacy70PreviewCombineLayout.2.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                            invoke(composer7, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        public final void invoke(@Nullable Composer composer7, int i9) {
                                            if ((i9 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1319285563, i9, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous>.<anonymous> (LegacyCombineLayout.kt:227)");
                                            }
                                            if (AbstractC1038a.m1196A(composer7, 0, function27)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer6, 384, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer5, 3072, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 3072, 2);
                    composerStartRestartGroup.endReplaceableGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceableGroup(947947744);
                    GlanceModifier glanceModifierFillMaxSize3 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    CombineTemplateDp combineTemplateDp3 = CombineTemplateDp.INSTANCE;
                    Legacy70PreviewCombineLayout_K_p2Snc$LayoutHorizontal(primaryContent, secondaryContent, MarginKt.m21310marginqDBjuR0$default(glanceModifierFillMaxSize3, combineTemplateDp3.getSMALL_START_PADDING(composerStartRestartGroup, 6), 0.0f, combineTemplateDp3.getSMALL_END_PADDING(composerStartRestartGroup, 6), 0.0f, 10, null), Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), composerStartRestartGroup, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceableGroup();
                }
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                    composer2.startReplaceableGroup(947948325);
                    if (function22 != null) {
                        composer2.startReplaceableGroup(947948368);
                        GlanceModifier glanceModifierFillMaxSize4 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        final boolean z2 = z;
                        Function3<RowScope, Composer, Integer, Unit> function3 = new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$3
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

                            @Composable
                            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i7) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1277385597, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous> (LegacyCombineLayout.kt:249)");
                                }
                                if (Alignment.Horizontal.m21438equalsimpl0(i2, Alignment.INSTANCE.m21433getStartPGIyAqw())) {
                                    composer3.startReplaceableGroup(-639381016);
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion2));
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    BoxKt.Box(glanceModifierFillMaxHeight, null, ComposableLambdaKt.composableLambda(composer3, -58223044, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$3.1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i8) {
                                            if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-58223044, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:251)");
                                            }
                                            if (AbstractC1038a.m1196A(composer4, 0, function23)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    GlanceModifier glanceModifierFillMaxHeight2 = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion2));
                                    final boolean z3 = z2;
                                    final int i8 = i;
                                    final Function2<Composer, Integer, Unit> function24 = primaryContent;
                                    final Function2<Composer, Integer, Unit> function25 = secondaryContent;
                                    BoxKt.Box(glanceModifierFillMaxHeight2, null, ComposableLambdaKt.composableLambda(composer3, -930153549, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$3.2
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i9) {
                                            if ((i9 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-930153549, i9, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:254)");
                                            }
                                            if (z3) {
                                                composer4.startReplaceableGroup(292679614);
                                                LegacyCombineLayoutKt.Legacy70PreviewCombineLayout_K_p2Snc$progressListInSecondary(i8, function24, function25, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            } else {
                                                composer4.startReplaceableGroup(292679673);
                                                LegacyCombineLayoutKt.Legacy70PreviewCombineLayout_K_p2Snc$LayoutVertical(i8, function24, function25, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-639380578);
                                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierFillMaxHeight3 = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion3));
                                    final boolean z4 = z2;
                                    final int i9 = i;
                                    final Function2<Composer, Integer, Unit> function26 = primaryContent;
                                    final Function2<Composer, Integer, Unit> function27 = secondaryContent;
                                    BoxKt.Box(glanceModifierFillMaxHeight3, null, ComposableLambdaKt.composableLambda(composer3, 1280251013, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$3.3
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i10) {
                                            if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1280251013, i10, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:259)");
                                            }
                                            if (z4) {
                                                composer4.startReplaceableGroup(292679891);
                                                LegacyCombineLayoutKt.Legacy70PreviewCombineLayout_K_p2Snc$progressListInSecondary(i9, function26, function27, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            } else {
                                                composer4.startReplaceableGroup(292679950);
                                                LegacyCombineLayoutKt.Legacy70PreviewCombineLayout_K_p2Snc$LayoutVertical(i9, function26, function27, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    GlanceModifier glanceModifierFillMaxHeight4 = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion3));
                                    final Function2<Composer, Integer, Unit> function28 = function22;
                                    BoxKt.Box(glanceModifierFillMaxHeight4, null, ComposableLambdaKt.composableLambda(composer3, -955290692, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$3.4
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i10) {
                                            if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-955290692, i10, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:263)");
                                            }
                                            if (AbstractC1038a.m1196A(composer4, 0, function28)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    composer3.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        i6 = i;
                        secondaryContent = secondaryContent;
                        RowKt.m21502RowlMAjyxE(glanceModifierFillMaxSize4, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1277385597, true, function3), composer2, 3072, 6);
                        composerStartRestartGroup = composer2;
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        i6 = i;
                        composerStartRestartGroup = composer2;
                        composerStartRestartGroup.startReplaceableGroup(947949426);
                        boolean hasTitleBar = ((TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState())).getHasTitleBar();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (hasTitleBar) {
                            composerStartRestartGroup.startReplaceableGroup(947949439);
                            GlanceModifier glanceModifierFillMaxSize5 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            CombineTemplateDp combineTemplateDp4 = CombineTemplateDp.INSTANCE;
                            RowKt.m21502RowlMAjyxE(MarginKt.m21310marginqDBjuR0$default(glanceModifierFillMaxSize5, 0.0f, 0.0f, combineTemplateDp4.m21935getLARGE_PRIMARY_ICON_END_PADDINGD9Ej5fM(), combineTemplateDp4.m21934getLARGE_PRIMARY_ICON_BOTTOM_PADDINGD9Ej5fM(), 3, null), 0, Alignment.INSTANCE.m21429getBottommnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 402636332, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$4
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

                                @Composable
                                public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i7) {
                                    GlanceModifier glanceModifierM21387size9UTdIk;
                                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(402636332, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous> (LegacyCombineLayout.kt:277)");
                                    }
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion2));
                                    final Function2<Composer, Integer, Unit> function23 = secondaryContent;
                                    BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.composableLambda(composer3, 388640266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$4.1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i8) {
                                            if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(388640266, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:278)");
                                            }
                                            if (AbstractC1038a.m1196A(composer4, 0, function23)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    if (LegacyCombineLayoutKt.isPreview(composer3, 0)) {
                                        composer3.startReplaceableGroup(-639379380);
                                        glanceModifierM21387size9UTdIk = SizeModifiersKt.size(companion2, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer3, 6).getSize());
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(-639379276);
                                        glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(companion2, CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composer3, 6), 0, 0.0f, composer3, 6, 6);
                                        composer3.endReplaceableGroup();
                                    }
                                    final Function2<Composer, Integer, Unit> function24 = primaryContent;
                                    BoxKt.Box(glanceModifierM21387size9UTdIk, null, ComposableLambdaKt.composableLambda(composer3, -504497535, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$4.2
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i8) {
                                            if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-504497535, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.<anonymous>.<anonymous> (LegacyCombineLayout.kt:284)");
                                            }
                                            if (AbstractC1038a.m1196A(composer4, 0, function24)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 384, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 3072, 2);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(947950392);
                            Legacy70PreviewCombineLayout_K_p2Snc$LayoutVertical(i6, primaryContent, secondaryContent, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function2<? super Composer, ? super Integer, Unit> function23 = secondaryContent;
                        final int i7 = i6;
                        final int i8 = i5;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$5
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

                            public final void invoke(@Nullable Composer composer3, int i9) {
                                LegacyCombineLayoutKt.m21870Legacy70PreviewCombineLayoutKp2Snc(combineData, primaryContent, function23, i7, function22, i2, composer3, RecomposeScopeImplKt.updateChangedFlags(i8 | 1));
                            }
                        });
                        return;
                    }
                    return;
                }
                composer2.startReplaceableGroup(947948231);
                if (z) {
                    composer2.startReplaceableGroup(947948260);
                    Legacy70PreviewCombineLayout_K_p2Snc$progressListInSecondary(i, primaryContent, secondaryContent, composer2, 0);
                } else {
                    composer2.startReplaceableGroup(947948291);
                    Legacy70PreviewCombineLayout_K_p2Snc$LayoutVertical(i, primaryContent, secondaryContent, composer2, 0);
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            i6 = i;
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i6 = i;
        if (ComposerKt.isTraceInProgress()) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    private static final void Legacy70PreviewCombineLayout_K_p2Snc$LayoutHorizontal(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, GlanceModifier glanceModifier, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(577744982);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(577744982, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutHorizontal (LegacyCombineLayout.kt:83)");
        }
        RowKt.m21502RowlMAjyxE(glanceModifier, 0, i, ComposableLambdaKt.composableLambda(composer, -1310356294, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutHorizontal$1
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

            @Composable
            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i4) {
                GlanceModifier glanceModifierM21387size9UTdIk;
                Composer composer3;
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1310356294, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutHorizontal.<anonymous> (LegacyCombineLayout.kt:85)");
                }
                if (LegacyCombineLayoutKt.isPreview(composer2, 0)) {
                    composer2.startReplaceableGroup(-434842231);
                    glanceModifierM21387size9UTdIk = SizeModifiersKt.size(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer2, 6).getSize());
                    composer2.endReplaceableGroup();
                    composer3 = composer2;
                } else {
                    composer2.startReplaceableGroup(-434842104);
                    glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composer2, 6), 0, 0.0f, composer2, 6, 6);
                    composer3 = composer2;
                    composer3.endReplaceableGroup();
                }
                GlanceModifier glanceModifier2 = glanceModifierM21387size9UTdIk;
                final Function2<Composer, Integer, Unit> function23 = function2;
                BoxKt.Box(glanceModifier2, null, ComposableLambdaKt.composableLambda(composer3, 627811224, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutHorizontal$1.1
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

                    @Composable
                    public final void invoke(@Nullable Composer composer4, int i5) {
                        if ((i5 & 11) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(627811224, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutHorizontal.<anonymous>.<anonymous> (LegacyCombineLayout.kt:90)");
                        }
                        if (AbstractC1038a.m1196A(composer4, 0, function23)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer3, 384, 2);
                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row.defaultWeight(GlanceModifier.INSTANCE));
                final Function2<Composer, Integer, Unit> function24 = function22;
                BoxKt.Box(glanceModifierWrapContentHeight, null, ComposableLambdaKt.composableLambda(composer3, -605509745, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutHorizontal$1.2
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

                    @Composable
                    public final void invoke(@Nullable Composer composer4, int i5) {
                        if ((i5 & 11) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-605509745, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutHorizontal.<anonymous>.<anonymous> (LegacyCombineLayout.kt:92)");
                        }
                        if (AbstractC1038a.m1196A(composer4, 0, function24)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer3, 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i2 & 14) | 3072 | ((i2 << 3) & 896), 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void Legacy70PreviewCombineLayout_K_p2Snc$LayoutVertical(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i2) {
        GlanceModifier glanceModifierM21358paddings2pLCVw;
        composer.startReplaceableGroup(-2012906361);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012906361, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical (LegacyCombineLayout.kt:99)");
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21429getBottommnfRV0w())) {
            composer.startReplaceableGroup(836009661);
            glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(GlanceModifier.INSTANCE, 0.0f, 0.09f, 0.0f, 0.07f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 24966, 245);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(836009884);
            if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4())) {
                composer.startReplaceableGroup(836009990);
                glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(GlanceModifier.INSTANCE, 0.0f, 0.07f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 24966, 245);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(836010249);
                glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(GlanceModifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.09f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 24582, 247);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        }
        ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.fillMaxSize(glanceModifierM21358paddings2pLCVw), 0, companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, 1675578449, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutVertical$1
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

            @Composable
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                GlanceModifier glanceModifierM21387size9UTdIk;
                GlanceModifier glanceModifierM21387size9UTdIk2;
                Composer composer3;
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1675578449, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical.<anonymous> (LegacyCombineLayout.kt:119)");
                }
                int i5 = i;
                Alignment.Companion companion2 = Alignment.INSTANCE;
                if (Alignment.Vertical.m21448equalsimpl0(i5, companion2.m21429getBottommnfRV0w())) {
                    composer2.startReplaceableGroup(589595926);
                    if (LegacyCombineLayoutKt.isPreview(composer2, 0)) {
                        composer2.startReplaceableGroup(589596015);
                        glanceModifierM21387size9UTdIk2 = SizeModifiersKt.size(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer2, 6).getSize());
                        composer2.endReplaceableGroup();
                        composer3 = composer2;
                    } else {
                        composer2.startReplaceableGroup(589596087);
                        glanceModifierM21387size9UTdIk2 = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composer2, 6), 0, 0.0f, composer2, 6, 6);
                        composer3 = composer2;
                        composer3.endReplaceableGroup();
                    }
                    GlanceModifier glanceModifier = glanceModifierM21387size9UTdIk2;
                    final Function2<Composer, Integer, Unit> function23 = function2;
                    BoxKt.Box(glanceModifier, null, ComposableLambdaKt.composableLambda(composer3, -1190904584, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutVertical$1.1
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

                        @Composable
                        public final void invoke(@Nullable Composer composer4, int i6) {
                            if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1190904584, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:123)");
                            }
                            if (AbstractC1038a.m1196A(composer4, 0, function23)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 384, 2);
                    GlanceModifier glanceModifierDefaultWeight = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                    Alignment centerStart = companion2.getCenterStart();
                    final Function2<Composer, Integer, Unit> function24 = function22;
                    BoxKt.Box(glanceModifierDefaultWeight, centerStart, ComposableLambdaKt.composableLambda(composer3, -1670408415, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutVertical$1.2
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

                        @Composable
                        public final void invoke(@Nullable Composer composer4, int i6) {
                            if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1670408415, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:128)");
                            }
                            if (AbstractC1038a.m1196A(composer4, 0, function24)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, (Alignment.$stable << 3) | 384, 0);
                    composer3.endReplaceableGroup();
                } else {
                    Composer composer4 = composer2;
                    composer4.startReplaceableGroup(589596457);
                    if (LegacyCombineLayoutKt.isPreview(composer4, 0)) {
                        composer4.startReplaceableGroup(589596546);
                        glanceModifierM21387size9UTdIk = SizeModifiersKt.size(GlanceModifier.INSTANCE, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer4, 6).getSize());
                        composer4.endReplaceableGroup();
                    } else {
                        composer4.startReplaceableGroup(589596618);
                        glanceModifierM21387size9UTdIk = androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, CombineTemplatePercent.INSTANCE.getPRIMARY_CONTENT_SIZE_PERCENT(composer4, 6), 0, 0.0f, composer4, 6, 6);
                        composer4 = composer4;
                        composer4.endReplaceableGroup();
                    }
                    GlanceModifier glanceModifierDefaultWeight2 = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                    Alignment centerStart2 = companion2.getCenterStart();
                    final Function2<Composer, Integer, Unit> function25 = function22;
                    BoxKt.Box(glanceModifierDefaultWeight2, centerStart2, ComposableLambdaKt.composableLambda(composer4, 938092303, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutVertical$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer5, int i6) {
                            if ((i6 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(938092303, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:138)");
                            }
                            if (AbstractC1038a.m1196A(composer5, 0, function25)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer4, (Alignment.$stable << 3) | 384, 0);
                    final Function2<Composer, Integer, Unit> function26 = function2;
                    BoxKt.Box(glanceModifierM21387size9UTdIk, null, ComposableLambdaKt.composableLambda(composer4, -1954023560, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$LayoutVertical$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer5, int i6) {
                            if ((i6 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1954023560, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.LayoutVertical.<anonymous>.<anonymous> (LegacyCombineLayout.kt:140)");
                            }
                            if (AbstractC1038a.m1196A(composer5, 0, function26)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer4, 384, 2);
                    composer4.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void Legacy70PreviewCombineLayout_K_p2Snc$progressListInSecondary(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i2) {
        composer.startReplaceableGroup(-1835106897);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1835106897, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary (LegacyCombineLayout.kt:146)");
        }
        ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0, Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, 525390117, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$progressListInSecondary$1
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

            @Composable
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(525390117, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary.<anonymous> (LegacyCombineLayout.kt:151)");
                }
                int i5 = i;
                Alignment.Companion companion = Alignment.INSTANCE;
                if (Alignment.Vertical.m21448equalsimpl0(i5, companion.m21429getBottommnfRV0w())) {
                    composer2.startReplaceableGroup(-1590603344);
                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierDefaultWeight = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion2));
                    Alignment center = companion.getCenter();
                    final Function2<Composer, Integer, Unit> function23 = function2;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -2002604962, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$progressListInSecondary$1.1
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

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i6) {
                            if ((i6 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2002604962, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary.<anonymous>.<anonymous> (LegacyCombineLayout.kt:156)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function23)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i6 = Alignment.$stable;
                    BoxKt.Box(glanceModifierDefaultWeight, center, composableLambda, composer2, (i6 << 3) | 384, 0);
                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion2));
                    Alignment bottomCenter = companion.getBottomCenter();
                    final Function2<Composer, Integer, Unit> function24 = function22;
                    BoxKt.Box(glanceModifierWrapContentHeight, bottomCenter, ComposableLambdaKt.composableLambda(composer2, 1059041365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$progressListInSecondary$1.2
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

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i7) {
                            if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1059041365, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary.<anonymous>.<anonymous> (LegacyCombineLayout.kt:162)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function24)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i6 << 3) | 384, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1590602860);
                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierWrapContentHeight2 = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3));
                    Alignment topCenter = companion.getTopCenter();
                    final Function2<Composer, Integer, Unit> function25 = function22;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, 257764391, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$progressListInSecondary$1.3
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

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i7) {
                            if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(257764391, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary.<anonymous>.<anonymous> (LegacyCombineLayout.kt:169)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function25)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i7 = Alignment.$stable;
                    BoxKt.Box(glanceModifierWrapContentHeight2, topCenter, composableLambda2, composer2, (i7 << 3) | 384, 0);
                    GlanceModifier glanceModifierDefaultWeight2 = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion3));
                    Alignment center2 = companion.getCenter();
                    final Function2<Composer, Integer, Unit> function26 = function2;
                    BoxKt.Box(glanceModifierDefaultWeight2, center2, ComposableLambdaKt.composableLambda(composer2, 1516814814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineLayoutKt$Legacy70PreviewCombineLayout$progressListInSecondary$1.4
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

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i8) {
                            if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1516814814, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineLayout.progressListInSecondary.<anonymous>.<anonymous> (LegacyCombineLayout.kt:175)");
                            }
                            if (AbstractC1038a.m1196A(composer3, 0, function26)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i7 << 3) | 384, 0);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final boolean isPreview(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1912926329);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1912926329, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.isPreview (LegacyCombineLayout.kt:66)");
        }
        Object objConsume = composer.consume(androidx.glance.CompositionLocalsKt.getLocalGlanceId());
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetId");
        boolean z = ((AppWidgetId) objConsume).getAppWidgetId() == -1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }
}
