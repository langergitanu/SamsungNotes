package androidx.glance.oneui.template.layout.glance;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.StackedProgressIndicatorKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.util.FontUtils;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.LinearGraph;
import androidx.glance.oneui.template.LinearGraphData;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.StackedGraphData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.component.glance.TitleBarKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.GraphLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.size.GraphTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001as\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0001¢\u0006\u0002\u0010 \u001a\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\u0010#\u001a}\u0010$\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aS\u0010+\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010,\u001a4\u0010-\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a\u001f\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 \u001as\u00100\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u001d\u001a*\u00101\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u00102\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, m13886d2 = {"GlanceGraphText", "", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "modifier", "Landroidx/glance/GlanceModifier;", "GlanceGraphText-lL68QWg", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "GlanceGraphTextList", "textListData", "Landroidx/glance/oneui/template/TypedTextListData;", "isVertical", "", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/TypedTextListData;ZLandroidx/compose/runtime/Composer;II)V", "GlanceLinearGraphLayout", "data", "Landroidx/glance/oneui/template/LinearGraphData;", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "descriptionContent", "detailGraphContent", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "(Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "GlanceStackedGraph", "Landroidx/glance/oneui/template/StackedGraphData;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/StackedGraphData;Landroidx/compose/runtime/Composer;II)V", "linearGraphSizeResId", "", "(Landroidx/glance/oneui/template/StackedGraphData;ILandroidx/compose/runtime/Composer;II)V", "LargeLayoutContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/LinearGraphData;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LinearGraphText", "textSize", "Landroidx/compose/ui/unit/Dp;", "LinearGraphText--jt2gSs", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;FLandroidx/compose/runtime/Composer;II)V", "MediumLayoutContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/LinearGraphData;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SmallLayoutContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StackedGraph", "WidgetLayoutMediumAndLarge", "WidgetLayoutSmall", "(Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLinearGraphLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearGraphLayout.kt\nandroidx/glance/oneui/template/layout/glance/LinearGraphLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,541:1\n74#2:542\n74#2:543\n74#2:547\n74#2:548\n74#2:549\n74#2:550\n154#3:544\n154#3:545\n154#3:546\n1855#4,2:551\n88#5:553\n*S KotlinDebug\n*F\n+ 1 LinearGraphLayout.kt\nandroidx/glance/oneui/template/layout/glance/LinearGraphLayoutKt\n*L\n65#1:542\n144#1:543\n336#1:547\n427#1:548\n428#1:549\n429#1:550\n148#1:544\n158#1:545\n325#1:546\n99#1:551,2\n442#1:553\n*E\n"})
public final class LinearGraphLayoutKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceGraphText-lL68QWg, reason: not valid java name */
    public static final void m21840GlanceGraphTextlL68QWg(@NotNull final TextData textData, final int i, @NotNull final ColorProvider defaultTextColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i2, final int i4) {
        TextSize labelText;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(729371960);
        GlanceModifier glanceModifier2 = (i4 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(729371960, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceGraphText (LinearGraphLayout.kt:525)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21691getDisplaygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-2140032405);
            labelText = GraphLayoutTextSizes.INSTANCE.getDisplayText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-2140032338);
            labelText = GraphLayoutTextSizes.INSTANCE.getTitleText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-2140032274);
            labelText = GraphLayoutTextSizes.INSTANCE.getBodyText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21690getDescriptiongxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-2140032204);
            labelText = GraphLayoutTextSizes.INSTANCE.getDescriptionText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-2140032143);
            labelText = GraphLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.GlanceText(textData, labelText, ColorProvidersKt.override(defaultTextColor, textData.getTextColor()), glanceModifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$GlanceGraphText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LinearGraphLayoutKt.m21840GlanceGraphTextlL68QWg(textData, i, defaultTextColor, glanceModifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceGraphTextList(@Nullable GlanceModifier glanceModifier, @NotNull final TypedTextListData textListData, final boolean z, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Intrinsics.checkNotNullParameter(textListData, "textListData");
        Composer composerStartRestartGroup = composer.startRestartGroup(1235741601);
        final GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(1235741601, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceGraphTextList (LinearGraphLayout.kt:421)");
        } else {
            i4 = i;
        }
        final List<TypedTextData> items = textListData.getItems();
        if (items.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceGraphTextList.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i5) {
                        LinearGraphLayoutKt.GlanceGraphTextList(glanceModifier2, textListData, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        final Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
        final long packedValue = ((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        final ColorProvider onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        final GlanceModifier glanceModifier3 = glanceModifier2;
        Debug.INSTANCE.debugBox(null, null, "Graph4", true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -649994280, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceGraphTextList.2
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
                    ComposerKt.traceEventStart(-649994280, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceGraphTextList.<anonymous> (LinearGraphLayout.kt:453)");
                }
                if (z) {
                    composer2.startReplaceableGroup(1168258557);
                    GlanceModifier glanceModifier4 = glanceModifier3;
                    int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                    final List<TypedTextData> list = items;
                    final ColorProvider colorProvider = onBackground;
                    final int i6 = mask;
                    final long j = packedValue;
                    final Context context2 = context;
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifier4, 0, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer2, 504344871, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceGraphTextList.2.1
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
                        public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i7) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(504344871, i7, -1, "androidx.glance.oneui.template.layout.glance.GlanceGraphTextList.<anonymous>.<anonymous> (LinearGraphLayout.kt:455)");
                            }
                            TypedTextData typedTextData = list.get(0);
                            LinearGraphLayoutKt.m21841LinearGraphTextjt2gSs(null, typedTextData, colorProvider, LinearGraphLayoutKt.GlanceGraphTextList$getTextSize(i6, j, context2, typedTextData), composer3, 512, 1);
                            if (list.size() > 1) {
                                TypedTextData typedTextData2 = list.get(1);
                                LinearGraphLayoutKt.m21841LinearGraphTextjt2gSs(null, typedTextData2, colorProvider, LinearGraphLayoutKt.GlanceGraphTextList$getTextSize(i6, j, context2, typedTextData2), composer3, 512, 1);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1168259372);
                    GlanceModifier glanceModifier5 = glanceModifier3;
                    int iM21430getCenterHorizontallyPGIyAqw2 = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                    final List<TypedTextData> list2 = items;
                    final ColorProvider colorProvider2 = onBackground;
                    final int i7 = mask;
                    final long j2 = packedValue;
                    final Context context3 = context;
                    RowKt.m21502RowlMAjyxE(glanceModifier5, iM21430getCenterHorizontallyPGIyAqw2, 0, ComposableLambdaKt.composableLambda(composer2, -1763366448, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceGraphTextList.2.2
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
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i8) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1763366448, i8, -1, "androidx.glance.oneui.template.layout.glance.GlanceGraphTextList.<anonymous>.<anonymous> (LinearGraphLayout.kt:475)");
                            }
                            TypedTextData typedTextData = list2.get(0);
                            LinearGraphLayoutKt.m21841LinearGraphTextjt2gSs(null, typedTextData, colorProvider2, LinearGraphLayoutKt.GlanceGraphTextList$getTextSize(i7, j2, context3, typedTextData), composer3, 512, 1);
                            if (list2.size() > 1) {
                                TypedTextData typedTextData2 = list2.get(1);
                                float fGlanceGraphTextList$getTextSize = LinearGraphLayoutKt.GlanceGraphTextList$getTextSize(i7, j2, context3, typedTextData2);
                                composer3.startReplaceableGroup(-2013656577);
                                if (AppWidgetSize.m21546compareToL2j3NV4(i7, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) >= 0) {
                                    AbstractC2821a.m2232w(2, GlanceModifier.INSTANCE, composer3, 0, 0);
                                }
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(-2013656345);
                                GlanceModifier glanceModifierM21358paddings2pLCVw = TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow()) ? PaddingModifiersKt.m21358paddings2pLCVw(GlanceModifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.05f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 24582, 247) : GlanceModifier.INSTANCE;
                                composer3.endReplaceableGroup();
                                LinearGraphLayoutKt.m21841LinearGraphTextjt2gSs(glanceModifierM21358paddings2pLCVw, typedTextData2, colorProvider2, fGlanceGraphTextList$getTextSize, composer3, 512, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 4);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 224640, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceGraphTextList.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LinearGraphLayoutKt.GlanceGraphTextList(glanceModifier3, textListData, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float GlanceGraphTextList$getTextSize(int i, long j, Context context, TypedTextData typedTextData) {
        GraphTemplatePercent.LinearGraphText linearGraphText = GraphTemplatePercent.LinearGraphText.INSTANCE;
        float fM21948getTextViewSizetZlUyYw = linearGraphText.m21948getTextViewSizetZlUyYw(i, typedTextData.getTextType(), typedTextData.getMaxLines());
        Pair<Float, Float> pairM21947getMinMaxTextSizetEsvO4U = linearGraphText.m21947getMinMaxTextSizetEsvO4U(i, typedTextData.getTextType());
        float fM21066getWidthD9Ej5fM = DpSize.m21066getWidthD9Ej5fM(j);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(j) * fM21948getTextViewSizetZlUyYw);
        FontUtils fontUtils = FontUtils.INSTANCE;
        String text = typedTextData.getText();
        if (text == null) {
            text = "";
        }
        return FontUtils.m21405autoTextSizeByDpYusz2Y$default(fontUtils, context, text, fM21066getWidthD9Ej5fM, fM20968constructorimpl, pairM21947getMinMaxTextSizetEsvO4U.getFirst().floatValue(), pairM21947getMinMaxTextSizetEsvO4U.getSecond().floatValue(), null, 0, false, 0, 960, null);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void GlanceLinearGraphLayout(@NotNull final LinearGraphData data, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @Nullable final TitleBarData titleBarData, @Nullable final Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1591297171);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1591297171, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceLinearGraphLayout (LinearGraphLayout.kt:63)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            composerStartRestartGroup.startReplaceableGroup(-1213948939);
            WidgetLayoutSmall(data, function2, composerStartRestartGroup, (i & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1213948877);
            WidgetLayoutMediumAndLarge(data, function2, function22, function23, titleBarData, function24, composerStartRestartGroup, 32776 | (i & 112) | (i & 896) | (i & 7168) | (458752 & i));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceLinearGraphLayout.1
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

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LinearGraphLayoutKt.GlanceLinearGraphLayout(data, function2, function22, function23, titleBarData, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceStackedGraph(@Nullable final GlanceModifier glanceModifier, @NotNull final StackedGraphData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1316844201);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1316844201, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceStackedGraph (LinearGraphLayout.kt:314)");
        }
        StackedGraph(glanceModifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceStackedGraph.1
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
                    LinearGraphLayoutKt.GlanceStackedGraph(glanceModifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void LargeLayoutContent(GlanceModifier glanceModifier, final LinearGraphData linearGraphData, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-813028737);
        final GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-813028737, i, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent (LinearGraphLayout.kt:223)");
        }
        final float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21568getLargerx25Pp4());
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, 0, Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -507062327, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.LargeLayoutContent.1
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
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-507062327, i4, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.<anonymous> (LinearGraphLayout.kt:271)");
                }
                composer2.startReplaceableGroup(652989263);
                if (titleBarData != null && function23 != null) {
                    GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                    final TitleBarData titleBarData2 = titleBarData;
                    final Function2<Composer, Integer, Unit> function25 = function22;
                    RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -26021142, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.LargeLayoutContent.1.1
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
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-26021142, i5, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:273)");
                            }
                            TitleBarKt.GlanceContent(titleBarData2, function25, ComposableSingletons$LinearGraphLayoutKt.INSTANCE.m21830getLambda2$glance_oneui_template_release(), composer3, 392);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 6);
                }
                composer2.endReplaceableGroup();
                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                int iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                final Function2<Composer, Integer, Unit> function26 = function24;
                final Function2<Composer, Integer, Unit> function27 = function2;
                final Function2<Composer, Integer, Unit> function28 = function23;
                final LinearGraphData linearGraphData2 = linearGraphData;
                final float f = fM21946getGraphSizeL2j3NV4;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21429getBottommnfRV0w, 0, ComposableLambdaKt.composableLambda(composer2, 183391251, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.LargeLayoutContent.1.2
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
                    public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(183391251, i5, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:280)");
                        }
                        if (function26 != null) {
                            composer3.startReplaceableGroup(233121031);
                            LinearGraphLayoutKt.LargeLayoutContent$DetailGraphContent(linearGraphData2, Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), function26, function27, composer3, 0, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(233121281);
                            LinearGraphLayoutKt.LargeLayoutContent$DescriptionGraphContent(linearGraphData2, Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), function28, function27, composer3, 0, 0);
                            composer3.endReplaceableGroup();
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        AbstractC2821a.m2232w(4, companion, composer3, 0, 0);
                        LinearGraph linearGraph = linearGraphData2.getLinearGraph();
                        if (linearGraph instanceof StackedGraphData) {
                            composer3.startReplaceableGroup(233121690);
                            LinearGraphLayoutKt.GlanceStackedGraph(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion), f, composer3, 0), (StackedGraphData) linearGraphData2.getLinearGraph(), composer3, 64, 0);
                            composer3.endReplaceableGroup();
                        } else if (linearGraph instanceof LinearProgressData) {
                            composer3.startReplaceableGroup(233121973);
                            ProgressIndicatorKt.GlanceLinearProgressIndicator(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion), f, composer3, 0), (LinearProgressData) linearGraphData2.getLinearGraph(), composer3, 64, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(233122218);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 4);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.LargeLayoutContent.2
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
                    LinearGraphLayoutKt.LargeLayoutContent(glanceModifier2, linearGraphData, titleBarData, function2, function22, function23, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void LargeLayoutContent$DescriptionGraphContent(final LinearGraphData linearGraphData, GlanceModifier glanceModifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-439771533);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-439771533, i, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DescriptionGraphContent (LinearGraphLayout.kt:255)");
        }
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, 0, 0, ComposableLambdaKt.composableLambda(composer, 2039695037, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LargeLayoutContent$DescriptionGraphContent$1
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
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039695037, i4, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DescriptionGraphContent.<anonymous> (LinearGraphLayout.kt:257)");
                }
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                GlanceModifier glanceModifierDefaultWeight = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion));
                final Function2<Composer, Integer, Unit> function23 = function2;
                RowKt.m21502RowlMAjyxE(glanceModifierDefaultWeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1414141657, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LargeLayoutContent$DescriptionGraphContent$1.1
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
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1414141657, i5, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DescriptionGraphContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:258)");
                        }
                        Function2<Composer, Integer, Unit> function24 = function23;
                        if (function24 != null) {
                            function24.invoke(composer3, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion));
                final Function2<Composer, Integer, Unit> function24 = function22;
                final LinearGraphData linearGraphData2 = linearGraphData;
                RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -2111503614, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LargeLayoutContent$DescriptionGraphContent$1.2
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
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2111503614, i5, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DescriptionGraphContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:261)");
                        }
                        if (function24 != null) {
                            composer3.startReplaceableGroup(1306754580);
                            AbstractC1038a.m1198C(composer3, 0, function24);
                        } else {
                            composer3.startReplaceableGroup(1306754636);
                            LinearGraphLayoutKt.GlanceGraphTextList(null, linearGraphData2.getTextList(), false, composer3, 448, 1);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
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
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void LargeLayoutContent$DetailGraphContent(final LinearGraphData linearGraphData, GlanceModifier glanceModifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1101150818);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1101150818, i, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DetailGraphContent (LinearGraphLayout.kt:232)");
        }
        RowKt.m21502RowlMAjyxE(glanceModifier2, 0, Alignment.INSTANCE.m21429getBottommnfRV0w(), ComposableLambdaKt.composableLambda(composer, 1178038982, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LargeLayoutContent$DetailGraphContent$1
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
                    ComposerKt.traceEventStart(1178038982, i4, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DetailGraphContent.<anonymous> (LinearGraphLayout.kt:234)");
                }
                if (function22 != null) {
                    composer2.startReplaceableGroup(1028425161);
                    AbstractC1038a.m1198C(composer2, 0, function22);
                } else {
                    composer2.startReplaceableGroup(1028425209);
                    LinearGraphLayoutKt.GlanceGraphTextList(Row.defaultWeight(SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE)), linearGraphData.getTextList(), true, composer2, 448, 0);
                    composer2.endReplaceableGroup();
                }
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                AbstractC2821a.m2232w(6, companion, composer2, 0, 0);
                Debug debug = Debug.INSTANCE;
                GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(companion, C2256Dp.m20968constructorimpl(150)), C2256Dp.m20968constructorimpl(62));
                final Function2<Composer, Integer, Unit> function23 = function2;
                debug.debugBox(glanceModifierM21505height3ABfNKs, null, "Graph1", false, ComposableLambdaKt.composableLambda(composer2, 318316719, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LargeLayoutContent$DetailGraphContent$1.1
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
                            ComposerKt.traceEventStart(318316719, i5, -1, "androidx.glance.oneui.template.layout.glance.LargeLayoutContent.DetailGraphContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:245)");
                        }
                        if (AbstractC1038a.m1196A(composer3, 0, function23)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 221568, 10);
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

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: LinearGraphText--jt2gSs, reason: not valid java name */
    public static final void m21841LinearGraphTextjt2gSs(GlanceModifier glanceModifier, final TextData textData, final ColorProvider colorProvider, final float f, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2125049778);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2125049778, i, -1, "androidx.glance.oneui.template.layout.glance.LinearGraphText (LinearGraphLayout.kt:509)");
        }
        TextKt.m21752GlanceTextFbLeKfk(textData, f, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), ColorProvidersKt.override(colorProvider, textData.getTextColor()), glanceModifier2, composerStartRestartGroup, ((i >> 6) & 112) | 4104 | ((i << 12) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$LinearGraphText$1
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
                    LinearGraphLayoutKt.m21841LinearGraphTextjt2gSs(glanceModifier2, textData, colorProvider, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void MediumLayoutContent(GlanceModifier glanceModifier, final LinearGraphData linearGraphData, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1033058385);
        final GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1033058385, i, -1, "androidx.glance.oneui.template.layout.glance.MediumLayoutContent (LinearGraphLayout.kt:176)");
        }
        final float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4());
        Alignment.Companion companion = Alignment.INSTANCE;
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, companion.m21429getBottommnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1481815225, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.MediumLayoutContent.1
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
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1481815225, i4, -1, "androidx.glance.oneui.template.layout.glance.MediumLayoutContent.<anonymous> (LinearGraphLayout.kt:184)");
                }
                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion2));
                final TitleBarData titleBarData2 = titleBarData;
                final Function2<Composer, Integer, Unit> function23 = function22;
                RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -666072405, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.MediumLayoutContent.1.1
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
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-666072405, i5, -1, "androidx.glance.oneui.template.layout.glance.MediumLayoutContent.<anonymous>.<anonymous> (LinearGraphLayout.kt:185)");
                        }
                        TitleBarData titleBarData3 = titleBarData2;
                        if (titleBarData3 != null) {
                            TitleBarKt.GlanceContent(titleBarData3, function23, ComposableSingletons$LinearGraphLayoutKt.INSTANCE.m21829getLambda1$glance_oneui_template_release(), composer3, 392);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
                SpacerKt.Spacer(Column.defaultWeight(companion2), composer2, 0, 0);
                if (function2 != null) {
                    composer2.startReplaceableGroup(-1978592294);
                    AbstractC1038a.m1198C(composer2, 0, function2);
                } else {
                    composer2.startReplaceableGroup(-1978592247);
                    LinearGraphLayoutKt.GlanceGraphTextList(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion2)), linearGraphData.getTextList(), true, composer2, 448, 0);
                    composer2.endReplaceableGroup();
                }
                AbstractC2821a.m2232w(4, companion2, composer2, 0, 0);
                LinearGraph linearGraph = linearGraphData.getLinearGraph();
                if (linearGraph instanceof StackedGraphData) {
                    composer2.startReplaceableGroup(-1978591891);
                    LinearGraphLayoutKt.GlanceStackedGraph(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion2), fM21946getGraphSizeL2j3NV4, composer2, 0), (StackedGraphData) linearGraphData.getLinearGraph(), composer2, 64, 0);
                    composer2.endReplaceableGroup();
                } else if (linearGraph instanceof LinearProgressData) {
                    composer2.startReplaceableGroup(-1978591656);
                    ProgressIndicatorKt.GlanceLinearProgressIndicator(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion2), fM21946getGraphSizeL2j3NV4, composer2, 0), (LinearProgressData) linearGraphData.getLinearGraph(), composer2, 64, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1978591455);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.MediumLayoutContent.2
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
                    LinearGraphLayoutKt.MediumLayoutContent(glanceModifier2, linearGraphData, titleBarData, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    public static final void SmallLayoutContent(GlanceModifier glanceModifier, final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-976859674);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-976859674, i, -1, "androidx.glance.oneui.template.layout.glance.SmallLayoutContent (LinearGraphLayout.kt:92)");
        }
        final float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4());
        Alignment.Companion companion = Alignment.INSTANCE;
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1485675812, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.SmallLayoutContent.1
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
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Composer composer3;
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1485675812, i4, -1, "androidx.glance.oneui.template.layout.glance.SmallLayoutContent.<anonymous> (LinearGraphLayout.kt:106)");
                }
                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                LinearGraphLayoutKt.SmallLayoutContent$MultiSpacer(Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion2)), 1, composer2, 48);
                if (function2 != null) {
                    composer2.startReplaceableGroup(1214230372);
                    AbstractC1038a.m1198C(composer2, 0, function2);
                    composer3 = composer2;
                } else {
                    composer2.startReplaceableGroup(1214230419);
                    composer3 = composer2;
                    LinearGraphLayoutKt.GlanceGraphTextList(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion2)), linearGraphData.getTextList(), false, composer3, 448, 0);
                    composer3.endReplaceableGroup();
                }
                AbstractC2821a.m2232w(2, companion2, composer3, 0, 0);
                LinearGraph linearGraph = linearGraphData.getLinearGraph();
                if (linearGraph instanceof StackedGraphData) {
                    composer3.startReplaceableGroup(1214230776);
                    LinearGraphLayoutKt.GlanceStackedGraph(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion2), fM21946getGraphSizeL2j3NV4, composer3, 0), (StackedGraphData) linearGraphData.getLinearGraph(), composer3, 64, 0);
                    composer3.endReplaceableGroup();
                } else if (linearGraph instanceof LinearProgressData) {
                    composer3.startReplaceableGroup(1214231011);
                    ProgressIndicatorKt.GlanceLinearProgressIndicator(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(companion2), fM21946getGraphSizeL2j3NV4, composer3, 0), (LinearProgressData) linearGraphData.getLinearGraph(), composer3, 64, 0);
                    composer3.endReplaceableGroup();
                } else {
                    composer3.startReplaceableGroup(1214231212);
                    composer3.endReplaceableGroup();
                }
                LinearGraphLayoutKt.SmallLayoutContent$MultiSpacer(Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion2)), 2, composer3, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.SmallLayoutContent.2
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
                    LinearGraphLayoutKt.SmallLayoutContent(glanceModifier2, linearGraphData, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void SmallLayoutContent$MultiSpacer(GlanceModifier glanceModifier, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(1706037157);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1706037157, i2, -1, "androidx.glance.oneui.template.layout.glance.SmallLayoutContent.MultiSpacer (LinearGraphLayout.kt:97)");
        }
        Iterator<Integer> it = RangesKt.until(0, i).iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            SpacerKt.Spacer(glanceModifier, composer, i2 & 14, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void StackedGraph(final GlanceModifier glanceModifier, final StackedGraphData stackedGraphData, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1799342933);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1799342933, i, -1, "androidx.glance.oneui.template.layout.glance.StackedGraph (LinearGraphLayout.kt:330)");
        }
        Debug debug = Debug.INSTANCE;
        GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(glanceModifier, CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM());
        composerStartRestartGroup.startReplaceableGroup(-820819282);
        ColorProvider colorProviderOverride = AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) ? ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground(), stackedGraphData.getBackgroundColor()) : ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
        composerStartRestartGroup.endReplaceableGroup();
        debug.debugBox(BackgroundKt.background(glanceModifierM21286cornerRadius3ABfNKs, colorProviderOverride), null, "Graph2", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2032078220, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.StackedGraph.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v18, types: [T, java.math.BigDecimal] */
            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                Composer composer3 = composer2;
                if ((i4 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2032078220, i4, -1, "androidx.glance.oneui.template.layout.glance.StackedGraph.<anonymous> (LinearGraphLayout.kt:343)");
                }
                int i5 = 0;
                if (stackedGraphData.getStacked()) {
                    composer3.startReplaceableGroup(779872778);
                    final List<StackedGraphData.StackedGraphValue> values = stackedGraphData.getValues();
                    final List listReversed = CollectionsKt.reversed(ColorProvidersKt.getMonotoneGraphColorArray());
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = new BigDecimal("1.0");
                    final Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = values.size() - 1;
                    int size = values.size() / 10;
                    if (size >= 0) {
                        int i6 = size;
                        while (true) {
                            Debug debug2 = Debug.INSTANCE;
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                            final StackedGraphData stackedGraphData2 = stackedGraphData;
                            int i7 = i6;
                            int i8 = i5;
                            debug2.debugBox(glanceModifierWrapContentHeight, null, "Graph3", false, ComposableLambdaKt.composableLambda(composer3, 250492006, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.StackedGraph.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Type inference failed for: r11v19, types: [T, java.lang.Object, java.math.BigDecimal] */
                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer4, int i9) {
                                    long jM21672getColor0d7_KjU;
                                    if ((i9 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(250492006, i9, -1, "androidx.glance.oneui.template.layout.glance.StackedGraph.<anonymous>.<anonymous> (LinearGraphLayout.kt:353)");
                                    }
                                    while (intRef.element >= 0) {
                                        float fFloatValue = objectRef.element.floatValue();
                                        GlanceModifier glanceModifierKeepColor = AppWidgetModifiersKt.keepColor(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), stackedGraphData2.getKeepColor());
                                        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer4.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) || stackedGraphData2.getKeepColor()) {
                                            jM21672getColor0d7_KjU = values.get(intRef.element).m21672getColor0d7_KjU();
                                        } else {
                                            jM21672getColor0d7_KjU = ColorKt.Color(intRef.element < listReversed.size() ? listReversed.get(intRef.element).intValue() : ((Number) AbstractC0000a.m10g(listReversed, 1)).intValue());
                                        }
                                        Composer composer5 = composer4;
                                        StackedProgressIndicatorKt.StackedProgressIndicator(fFloatValue, glanceModifierKeepColor, ColorProviderKt.m22055ColorProvider8_81llA(jM21672getColor0d7_KjU), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()), composer5, 4608, 0);
                                        Ref.ObjectRef<BigDecimal> objectRef2 = objectRef;
                                        ?? Subtract = objectRef2.element.subtract(new BigDecimal(String.valueOf(values.get(intRef.element).getValue())));
                                        Intrinsics.checkNotNullExpressionValue(Subtract, "subtract(...)");
                                        objectRef2.element = Subtract;
                                        Ref.IntRef intRef2 = intRef;
                                        int i10 = intRef2.element - 1;
                                        intRef2.element = i10;
                                        if (i10 % 10 == 9) {
                                            break;
                                        } else {
                                            composer4 = composer5;
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 221568, 10);
                            composer3 = composer2;
                            if (i8 == i7) {
                                break;
                            }
                            i5 = i8 + 1;
                            i6 = i7;
                        }
                    }
                    if (((BigDecimal) objectRef.element).compareTo(BigDecimal.ZERO) != 0) {
                        GlanceLog.INSTANCE.m2305w("StackedGraph", "GraphTemplate: The rest of the section is " + objectRef.element + ", the sum is not 1.0!!");
                    }
                    composer3.endReplaceableGroup();
                } else {
                    composer3.startReplaceableGroup(779874973);
                    List listSortedWith = CollectionsKt.sortedWith(stackedGraphData.getValues(), new Comparator() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt$StackedGraph$1$invoke$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Float.valueOf(((StackedGraphData.StackedGraphValue) t2).getValue()), Float.valueOf(((StackedGraphData.StackedGraphValue) t).getValue()));
                        }
                    });
                    List<Integer> monotoneGraphColorArray = ColorProvidersKt.getMonotoneGraphColorArray();
                    StackedGraphData stackedGraphData3 = stackedGraphData;
                    for (Object obj : listSortedWith) {
                        int i9 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        StackedGraphData.StackedGraphValue stackedGraphValue = (StackedGraphData.StackedGraphValue) obj;
                        StackedProgressIndicatorKt.StackedProgressIndicator(stackedGraphValue.getValue(), AppWidgetModifiersKt.keepColor(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), stackedGraphData3.getKeepColor()), ColorProviderKt.m22055ColorProvider8_81llA(AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer3.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) ? stackedGraphValue.m21672getColor0d7_KjU() : ColorKt.Color(i5 < monotoneGraphColorArray.size() ? monotoneGraphColorArray.get(i5).intValue() : ((Number) AbstractC0000a.m10g(monotoneGraphColorArray, 1)).intValue())), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()), composer3, 4608, 0);
                        composer3 = composer2;
                        i5 = i9;
                    }
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 221568, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.StackedGraph.2
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
                    LinearGraphLayoutKt.StackedGraph(glanceModifier, stackedGraphData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void WidgetLayoutMediumAndLarge(final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1035351919);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1035351919, i, -1, "androidx.glance.oneui.template.layout.glance.WidgetLayoutMediumAndLarge (LinearGraphLayout.kt:142)");
        }
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1994869142);
            float f = 14;
            MediumLayoutContent(SizeModifiersKt.fillMaxSize(PaddingKt.m21499paddingqDBjuR0(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(0), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f))), linearGraphData, titleBarData, function2, function24, composerStartRestartGroup, ((i << 6) & 7168) | Units.MASTER_DPI | (57344 & (i >> 3)), 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1994869500);
            float f4 = 14;
            int i2 = i << 9;
            LargeLayoutContent(SizeModifiersKt.fillMaxSize(PaddingKt.m21499paddingqDBjuR0(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4))), linearGraphData, titleBarData, function2, function24, function22, function23, composerStartRestartGroup, ((i << 6) & 7168) | Units.MASTER_DPI | (57344 & (i >> 3)) | (458752 & i2) | (i2 & 3670016), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.WidgetLayoutMediumAndLarge.1
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
                    LinearGraphLayoutKt.WidgetLayoutMediumAndLarge(linearGraphData, function2, function22, function23, titleBarData, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    public static final void WidgetLayoutSmall(final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(348163896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(348163896, i, -1, "androidx.glance.oneui.template.layout.glance.WidgetLayoutSmall (LinearGraphLayout.kt:79)");
        }
        SmallLayoutContent(SizeModifiersKt.fillMaxSize(PaddingModifiersKt.m21356padding6PoWaU8(GlanceModifier.INSTANCE, 0.105f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 438, 12)), linearGraphData, function2, composerStartRestartGroup, ((i << 3) & 896) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.WidgetLayoutSmall.1
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

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LinearGraphLayoutKt.WidgetLayoutSmall(linearGraphData, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceStackedGraph(@NotNull final StackedGraphData data, final int i, @Nullable Composer composer, final int i2, final int i4) {
        GlanceModifier glanceModifierM21505height3ABfNKs;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-843701335);
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-843701335, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceStackedGraph (LinearGraphLayout.kt:319)");
        }
        if (i != 0) {
            glanceModifierM21505height3ABfNKs = SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), i);
        } else {
            glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(26));
        }
        StackedGraph(glanceModifierM21505height3ABfNKs, data, composerStartRestartGroup, 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt.GlanceStackedGraph.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LinearGraphLayoutKt.GlanceStackedGraph(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
