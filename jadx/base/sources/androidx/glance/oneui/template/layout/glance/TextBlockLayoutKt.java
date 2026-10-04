package androidx.glance.oneui.template.layout.glance;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.VisibilityKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.color.DayNightColorProvidersKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomTypedTextData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.TextBlockItem;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.layout.CombineLayoutDimensions;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.MultiTextBlockLayoutTextSizes;
import androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextBlockLayoutDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
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
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001aQ\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a%\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001e\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010&\u001a(\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\t2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, m13886d2 = {"GlanceDivider", "", "isVertical", "", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "(ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "GlanceTextBlockLayout", "mainItem", "Landroidx/glance/oneui/template/TextBlockItem;", "mainContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "subItem", "subContent", "(Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "GlanceTextBlockText", "textData", "Landroidx/glance/oneui/template/TypedTextData;", "fromSingleBlock", "defaultTextColor", "modifier", "Landroidx/glance/GlanceModifier;", "visibleTextCountInSmall", "", "(Landroidx/glance/oneui/template/TypedTextData;ZLandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;ILandroidx/compose/runtime/Composer;II)V", "GlanceTextBlockTextList", "textListData", "Landroidx/glance/oneui/template/TypedTextListData;", "(Landroidx/glance/oneui/template/TypedTextListData;ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "LayoutHorizontal", "textList", "", "defaultTextAlign", "Landroidx/glance/text/TextAlign;", "LayoutHorizontal-RTYL8B8", "(Ljava/util/List;ZLandroidx/glance/unit/ColorProvider;ILandroidx/compose/runtime/Composer;I)V", "LayoutVertical", "(Ljava/util/List;ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "TextBlockItemLayout", "item", "content", "(Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextBlockLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextBlockLayout.kt\nandroidx/glance/oneui/template/layout/glance/TextBlockLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,711:1\n74#2:712\n74#2:714\n74#2:715\n74#2:716\n74#2:717\n74#2:718\n1#3:713\n154#4:719\n154#4:720\n154#4:721\n154#4:722\n154#4:723\n154#4:724\n*S KotlinDebug\n*F\n+ 1 TextBlockLayout.kt\nandroidx/glance/oneui/template/layout/glance/TextBlockLayoutKt\n*L\n66#1:712\n107#1:714\n164#1:715\n215#1:716\n434#1:717\n681#1:718\n240#1:719\n242#1:720\n245#1:721\n246#1:722\n247#1:723\n291#1:724\n*E\n"})
public final class TextBlockLayoutKt {
    @Composable
    public static final void GlanceDivider(final boolean z, @Nullable final ColorProvider colorProvider, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1856395554);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 16;
        }
        if (i5 == 2 && (i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                colorProvider = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1856395554, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceDivider (TextBlockLayout.kt:620)");
            }
            ColorProvider colorProviderM21426ColorProviderOWjLjI = colorProvider == null ? DayNightColorProvidersKt.m21426ColorProviderOWjLjI(ColorKt.Color(637534208), ColorKt.Color(654311423)) : colorProvider;
            SpacerKt.Spacer(z ? BackgroundKt.background(SizeModifiersKt.fillMaxHeight(SizeModifiersKt.width(GlanceModifier.INSTANCE, C3094R.dimen.sesl_glance_list_item_divider_size)), colorProviderM21426ColorProviderOWjLjI) : BackgroundKt.background(SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C3094R.dimen.sesl_glance_list_item_divider_size), colorProviderM21426ColorProviderOWjLjI), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceDivider.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TextBlockLayoutKt.GlanceDivider(z, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0155  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GlanceTextBlockLayout(@NotNull final TextBlockItem mainItem, @NotNull Function2<? super Composer, ? super Integer, Unit> mainContent, @Nullable final TextBlockItem textBlockItem, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final ColorProvider colorProvider, @Nullable Composer composer, final int i) {
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Intrinsics.checkNotNullParameter(mainItem, "mainItem");
        Intrinsics.checkNotNullParameter(mainContent, "mainContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2014853959);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2014853959, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout (TextBlockLayout.kt:64)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1052319716);
            mainItem.setMode$glance_oneui_template_release(0);
            TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
            function22 = mainContent;
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1052319909);
            if (textBlockItem == null || function2 == null) {
                function22 = mainContent;
                composerStartRestartGroup.startReplaceableGroup(1052319966);
                TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1052320046);
                function22 = mainContent;
                ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1477068108, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.2
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

                    /* JADX WARN: Removed duplicated region for block: B:9:0x008c  */
                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1477068108, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous> (TextBlockLayout.kt:77)");
                        }
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierDefaultWeight = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion2));
                        final TextBlockItem textBlockItem2 = mainItem;
                        final Function2<Composer, Integer, Unit> function23 = function22;
                        debug.debugBox(glanceModifierDefaultWeight, null, "TextBlock1", false, ComposableLambdaKt.composableLambda(composer2, -1684064355, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.2.1
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
                                    ComposerKt.traceEventStart(-1684064355, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous>.<anonymous> (TextBlockLayout.kt:81)");
                                }
                                TextBlockLayoutKt.TextBlockItemLayout(textBlockItem2, function23, composer3, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 221568, 10);
                        composer2.startReplaceableGroup(-1255080918);
                        if (mainItem.getApplyInverseColor() != textBlockItem.getApplyInverseColor()) {
                            GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                            int i4 = GlanceTheme.$stable;
                            if (ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composer2, i4).getBackground().mo21422getColorvNxB06k((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext()))) == ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composer2, i4).getInverseSurface().mo21422getColorvNxB06k((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext())))) {
                                TextBlockLayoutKt.GlanceDivider(false, colorProvider, composer2, 70, 0);
                            }
                        }
                        composer2.endReplaceableGroup();
                        GlanceModifier glanceModifierDefaultWeight2 = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion2));
                        final TextBlockItem textBlockItem3 = textBlockItem;
                        final Function2<Composer, Integer, Unit> function24 = function2;
                        debug.debugBox(glanceModifierDefaultWeight2, null, "TextBlock2", false, ComposableLambdaKt.composableLambda(composer2, 80891604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.2.2
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
                                    ComposerKt.traceEventStart(80891604, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous>.<anonymous> (TextBlockLayout.kt:96)");
                                }
                                TextBlockLayoutKt.TextBlockItemLayout(textBlockItem3, function24, composer3, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 221568, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 6);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            function22 = mainContent;
            composerStartRestartGroup.startReplaceableGroup(1052321206);
            if (textBlockItem == null || function2 == null) {
                composerStartRestartGroup.startReplaceableGroup(1052321263);
                TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1052321343);
                if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion.m21573getWideSmallrx25Pp4())) {
                    List<TypedTextData> items = mainItem.getTextList().getItems();
                    List<TypedTextData> items2 = textBlockItem.getTextList().getItems();
                    if (items.size() == 1) {
                        int textType = items.get(0).getTextType();
                        TextType.Companion companion2 = TextType.INSTANCE;
                        if (TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) && items2.size() == 1 && TextType.m21684equalsimpl0(items2.get(0).getTextType(), companion2.m21693getLabelgxbDmow()) && TextAlign.m22003equalsimpl0(items2.get(0).getTextAlign(), TextAlign.INSTANCE.m22008getEndROrN78o())) {
                            composerStartRestartGroup.startReplaceableGroup(1052321954);
                            mainItem.setMode$glance_oneui_template_release(0);
                            TextBlockItemLayout(mainItem, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -977607103, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.4
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
                                public final void invoke(@Nullable Composer composer2, int i2) {
                                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-977607103, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous> (TextBlockLayout.kt:118)");
                                    }
                                    TextBlockLayoutKt.m21852LayoutHorizontalRTYL8B8(CollectionsKt.listOf((Object[]) new TypedTextData[]{mainItem.getTextList().getItems().get(0), textBlockItem.getTextList().getItems().get(0)}), true, mainItem.getDefaultTextColor(composer2, 8), TextAlign.INSTANCE.m22011getStartROrN78o(), composer2, 560);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 56);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(1052322411);
                            RowKt.m21502RowlMAjyxE(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 314325341, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.5
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

                                /* JADX WARN: Removed duplicated region for block: B:9:0x008c  */
                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i2) {
                                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(314325341, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous> (TextBlockLayout.kt:127)");
                                    }
                                    Debug debug = Debug.INSTANCE;
                                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                    GlanceModifier glanceModifierFillMaxHeight = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion3));
                                    final TextBlockItem textBlockItem2 = mainItem;
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    debug.debugBox(glanceModifierFillMaxHeight, null, "TextBlock3", false, ComposableLambdaKt.composableLambda(composer2, 107329094, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.5.1
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
                                                ComposerKt.traceEventStart(107329094, i4, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous>.<anonymous> (TextBlockLayout.kt:131)");
                                            }
                                            TextBlockLayoutKt.TextBlockItemLayout(textBlockItem2, function23, composer3, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 221568, 10);
                                    composer2.startReplaceableGroup(-1255078523);
                                    if (mainItem.getApplyInverseColor() != textBlockItem.getApplyInverseColor()) {
                                        GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                                        int i4 = GlanceTheme.$stable;
                                        if (ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composer2, i4).getBackground().mo21422getColorvNxB06k((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext()))) == ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composer2, i4).getInverseSurface().mo21422getColorvNxB06k((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext())))) {
                                            TextBlockLayoutKt.GlanceDivider(true, colorProvider, composer2, 70, 0);
                                        }
                                    }
                                    composer2.endReplaceableGroup();
                                    GlanceModifier glanceModifierFillMaxHeight2 = SizeModifiersKt.fillMaxHeight(Row.defaultWeight(companion3));
                                    final TextBlockItem textBlockItem3 = textBlockItem;
                                    final Function2<Composer, Integer, Unit> function24 = function2;
                                    debug.debugBox(glanceModifierFillMaxHeight2, null, "TextBlock4", false, ComposableLambdaKt.composableLambda(composer2, 1872285053, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.5.2
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
                                                ComposerKt.traceEventStart(1872285053, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockLayout.<anonymous>.<anonymous> (TextBlockLayout.kt:148)");
                                            }
                                            TextBlockLayoutKt.TextBlockItemLayout(textBlockItem3, function24, composer3, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 221568, 10);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 3072, 6);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockLayout.6
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
                    TextBlockLayoutKt.GlanceTextBlockLayout(mainItem, function23, textBlockItem, function2, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceTextBlockText(@NotNull final TypedTextData textData, final boolean z, @NotNull final ColorProvider defaultTextColor, @Nullable GlanceModifier glanceModifier, int i, @Nullable Composer composer, final int i2, final int i4) {
        TextSize labelText;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-979977551);
        GlanceModifier glanceModifier2 = (i4 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        int i5 = (i4 & 16) != 0 ? 1 : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-979977551, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockText (TextBlockLayout.kt:678)");
        }
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
            textData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
        }
        int textType = textData.getTextType();
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(446617401);
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(446617422);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.displayText(textData.getTextLength(composerStartRestartGroup, i2 & 14), i5, composerStartRestartGroup, ((i2 >> 9) & 112) | 384);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(446617682);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getDisplayText(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(446617828);
            labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getTitleText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21689getBodygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(446617882);
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(446617934);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getBodyText(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(446617998);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getBodyText(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21690getDescriptiongxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(446618069);
            labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getDescriptionText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(446618129);
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(446618181);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(446618246);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.GlanceText(textData, labelText, ColorProvidersKt.override(defaultTextColor, textData.getTextColor()), glanceModifier2, composerStartRestartGroup, (i2 & 14) | 512 | (TextPercentData.$stable << 3) | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockText.2
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
                    TextBlockLayoutKt.GlanceTextBlockText(textData, z, defaultTextColor, glanceModifier3, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceTextBlockTextList(@NotNull final TypedTextListData textListData, boolean z, @NotNull ColorProvider defaultTextColor, @Nullable Composer composer, final int i) {
        Composer composer2;
        final boolean z2;
        final ColorProvider colorProvider;
        Intrinsics.checkNotNullParameter(textListData, "textListData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-233368093);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-233368093, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceTextBlockTextList (TextBlockLayout.kt:646)");
        }
        if (textListData.getItems().size() == 1) {
            composerStartRestartGroup.startReplaceableGroup(-2016911058);
            TypedTextData typedTextData = (TypedTextData) CollectionsKt.first((List) textListData.getItems());
            z2 = z;
            composer2 = composerStartRestartGroup;
            GlanceTextBlockText(typedTextData, z2, defaultTextColor, MarginKt.margin(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), TextBlockLayoutDimensions.INSTANCE.m21787textPadding58yVOK4(z2, typedTextData.getTextType(), null, null, null, 0, null, composerStartRestartGroup, ((i >> 3) & 14) | 12582912, 124)), 0, composer2, (i & 112) | 512, 16);
            composer2.endReplaceableGroup();
            colorProvider = defaultTextColor;
        } else {
            composer2 = composerStartRestartGroup;
            if (textListData.getOrientation() == Orientation.Horizontal) {
                composer2.startReplaceableGroup(-2016910580);
                colorProvider = defaultTextColor;
                z2 = z;
                m21852LayoutHorizontalRTYL8B8(textListData.getItems(), z2, colorProvider, textListData.getTextAlign(), composer2, (i & 112) | 520);
                composer2 = composer2;
                composer2.endReplaceableGroup();
            } else {
                z2 = z;
                colorProvider = defaultTextColor;
                composer2.startReplaceableGroup(-2016910404);
                LayoutVertical(textListData.getItems(), z2, colorProvider, composer2, (i & 112) | 520);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.GlanceTextBlockTextList.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i2) {
                    TextBlockLayoutKt.GlanceTextBlockTextList(textListData, z2, colorProvider, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018d  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: LayoutHorizontal-RTYL8B8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21852LayoutHorizontalRTYL8B8(final List<? extends TypedTextData> list, final boolean z, final ColorProvider colorProvider, final int i, Composer composer, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1894134617);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1894134617, i2, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal (TextBlockLayout.kt:432)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) >= 0 && list.size() == 3) {
            int textType = list.get(0).getTextType();
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list.get(1).getTextType(), companion2.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(list.get(2).getTextType(), companion2.m21693getLabelgxbDmow())) {
                composerStartRestartGroup.startReplaceableGroup(-1761445862);
                RowKt.m21502RowlMAjyxE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21429getBottommnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1426136920, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$1
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
                            ComposerKt.traceEventStart(1426136920, i4, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal.<anonymous> (TextBlockLayout.kt:445)");
                        }
                        TypedTextData typedTextData = list.get(0);
                        boolean z2 = z;
                        ColorProvider colorProvider2 = colorProvider;
                        GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                        TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                        TextType.Companion companion4 = TextType.INSTANCE;
                        TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z2, colorProvider2, MarginKt.margin(companion3, textBlockLayoutDimensions.m21787textPadding58yVOK4(z2, companion4.m21691getDisplaygxbDmow(), TextType.m21680boximpl(companion4.m21693getLabelgxbDmow()), null, null, 0, Orientation.Horizontal, composer2, 14156208, 56)), 0, composer2, 512, 16);
                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(8), 7, null);
                        final List<TypedTextData> list2 = list;
                        final boolean z3 = z;
                        final ColorProvider colorProvider3 = colorProvider;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer2, -51433394, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$1.1
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i5) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-51433394, i5, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal.<anonymous>.<anonymous> (TextBlockLayout.kt:460)");
                                }
                                TypedTextData typedTextData2 = list2.get(1);
                                boolean z4 = z3;
                                ColorProvider colorProvider4 = colorProvider3;
                                GlanceModifier.Companion companion5 = GlanceModifier.INSTANCE;
                                TextBlockLayoutDimensions textBlockLayoutDimensions2 = TextBlockLayoutDimensions.INSTANCE;
                                TextType.Companion companion6 = TextType.INSTANCE;
                                int iM21693getLabelgxbDmow = companion6.m21693getLabelgxbDmow();
                                TextType textTypeM21680boximpl = TextType.m21680boximpl(companion6.m21693getLabelgxbDmow());
                                TextType textTypeM21680boximpl2 = TextType.m21680boximpl(companion6.m21691getDisplaygxbDmow());
                                Orientation orientation = Orientation.Horizontal;
                                TextBlockLayoutKt.GlanceTextBlockText(typedTextData2, z4, colorProvider4, MarginKt.margin(companion5, textBlockLayoutDimensions2.m21787textPadding58yVOK4(z4, iM21693getLabelgxbDmow, textTypeM21680boximpl, textTypeM21680boximpl2, null, 0, orientation, composer3, 14159280, 48)), 0, composer3, 512, 16);
                                TypedTextData typedTextData3 = list2.get(2);
                                boolean z5 = z3;
                                TextBlockLayoutKt.GlanceTextBlockText(typedTextData3, z5, colorProvider3, MarginKt.margin(companion5, textBlockLayoutDimensions2.m21787textPadding58yVOK4(z5, companion6.m21693getLabelgxbDmow(), null, TextType.m21680boximpl(companion6.m21693getLabelgxbDmow()), TextType.m21680boximpl(companion6.m21691getDisplaygxbDmow()), 0, orientation, composer3, 14183472, 36)), 0, composer3, 512, 16);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 2);
                composerStartRestartGroup.endReplaceableGroup();
            }
        } else if ((AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) || AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) && list.size() == 2) {
            int textType2 = list.get(0).getTextType();
            TextType.Companion companion3 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType2, companion3.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list.get(1).getTextType(), companion3.m21690getDescriptiongxbDmow())) {
                composerStartRestartGroup.startReplaceableGroup(-1761443406);
                RowKt.m21502RowlMAjyxE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2100582209, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$2
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
                            ComposerKt.traceEventStart(2100582209, i4, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal.<anonymous> (TextBlockLayout.kt:502)");
                        }
                        TypedTextData typedTextData = list.get(0);
                        boolean z2 = z;
                        ColorProvider colorProvider2 = colorProvider;
                        GlanceModifier.Companion companion4 = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.size(companion4, CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composer2, 6).getSize()), GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getSurface()), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM());
                        TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                        boolean z3 = z;
                        TextType.Companion companion5 = TextType.INSTANCE;
                        int iM21691getDisplaygxbDmow = companion5.m21691getDisplaygxbDmow();
                        TextType textTypeM21680boximpl = TextType.m21680boximpl(companion5.m21690getDescriptiongxbDmow());
                        Orientation orientation = Orientation.Horizontal;
                        TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z2, colorProvider2, MarginKt.margin(glanceModifierM21286cornerRadius3ABfNKs, textBlockLayoutDimensions.m21787textPadding58yVOK4(z3, iM21691getDisplaygxbDmow, textTypeM21680boximpl, null, null, 0, orientation, composer2, 14156208, 56)), 0, composer2, 512, 16);
                        TextBlockLayoutKt.GlanceTextBlockText(list.get(1), z, colorProvider, MarginKt.margin(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion4)), textBlockLayoutDimensions.m21787textPadding58yVOK4(z, companion5.m21690getDescriptiongxbDmow(), null, TextType.m21680boximpl(companion5.m21691getDisplaygxbDmow()), null, 0, orientation, composer2, 14158896, 52)), 0, composer2, 512, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 3072, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) && list.size() == 2) {
                int textType3 = list.get(0).getTextType();
                TextType.Companion companion4 = TextType.INSTANCE;
                if (TextType.m21684equalsimpl0(textType3, companion4.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list.get(1).getTextType(), companion4.m21693getLabelgxbDmow()) && TextAlign.m22003equalsimpl0(list.get(1).getTextAlign(), TextAlign.INSTANCE.m22008getEndROrN78o())) {
                    composerStartRestartGroup.startReplaceableGroup(-1761441674);
                    RowKt.m21502RowlMAjyxE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 158403744, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$3
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
                                ComposerKt.traceEventStart(158403744, i4, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal.<anonymous> (TextBlockLayout.kt:542)");
                            }
                            TypedTextData typedTextData = list.get(0);
                            boolean z2 = z;
                            ColorProvider colorProvider2 = colorProvider;
                            GlanceModifier.Companion companion5 = GlanceModifier.INSTANCE;
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion5));
                            TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                            boolean z3 = z;
                            TextType.Companion companion6 = TextType.INSTANCE;
                            int iM21691getDisplaygxbDmow = companion6.m21691getDisplaygxbDmow();
                            TextType textTypeM21680boximpl = TextType.m21680boximpl(companion6.m21693getLabelgxbDmow());
                            Orientation orientation = Orientation.Horizontal;
                            TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z2, colorProvider2, MarginKt.margin(glanceModifierWrapContentHeight, textBlockLayoutDimensions.m21787textPadding58yVOK4(z3, iM21691getDisplaygxbDmow, textTypeM21680boximpl, null, null, 0, orientation, composer2, 14156208, 56)), 0, composer2, 512, 16);
                            TextBlockLayoutKt.GlanceTextBlockText(list.get(1), z, colorProvider, MarginKt.margin(SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion5)), textBlockLayoutDimensions.m21787textPadding58yVOK4(z, companion6.m21693getLabelgxbDmow(), null, TextType.m21680boximpl(companion6.m21691getDisplaygxbDmow()), null, TextAlign.INSTANCE.m22008getEndROrN78o(), orientation, composer2, 14158896, 20)), 0, composer2, 512, 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 3072, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1761440346);
                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                TextAlign.Companion companion5 = TextAlign.INSTANCE;
                RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, TextAlign.m22003equalsimpl0(i, companion5.m22011getStartROrN78o()) ? true : TextAlign.m22003equalsimpl0(i, companion5.m22009getLeftROrN78o()) ? Alignment.INSTANCE.m21433getStartPGIyAqw() : TextAlign.m22003equalsimpl0(i, companion5.m22007getCenterROrN78o()) ? Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw() : Alignment.INSTANCE.m21432getEndPGIyAqw(), 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1622598559, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$4
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
                        List<TypedTextData> list2;
                        int i5;
                        boolean z2;
                        ColorProvider colorProvider2;
                        Composer composer3 = composer2;
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1622598559, i4, -1, "androidx.glance.oneui.template.layout.glance.LayoutHorizontal.<anonymous> (TextBlockLayout.kt:585)");
                        }
                        int size = list.size() - 1;
                        List<TypedTextData> list3 = list;
                        boolean z3 = z;
                        ColorProvider colorProvider3 = colorProvider;
                        int i6 = i;
                        int i7 = 0;
                        int i8 = 0;
                        for (Object obj : list3) {
                            int i9 = i8 + 1;
                            if (i8 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            TypedTextData typedTextData = (TypedTextData) obj;
                            if (typedTextData instanceof CustomTypedTextData) {
                                composer3.startReplaceableGroup(759818162);
                                CustomTypedTextData customTypedTextData = (CustomTypedTextData) typedTextData;
                                customTypedTextData.CustomContent(customTypedTextData, composer3, i7);
                                composer3.endReplaceableGroup();
                            } else if (typedTextData instanceof TypedTextListData) {
                                composer3.startReplaceableGroup(759818230);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(759818319);
                                if (i8 == 0 || i8 == size) {
                                    typedTextData.m21678setTextAlignb1psNo$glance_oneui_template_release(i6);
                                }
                                GlanceModifier.Companion companion6 = GlanceModifier.INSTANCE;
                                DpRect dpRectTextPadding = TextBlockLayoutDimensions.INSTANCE.textPadding(list3, i8, size, z3, Orientation.Horizontal, composer2, 221192, 0);
                                list2 = list3;
                                i5 = size;
                                z2 = z3;
                                colorProvider2 = colorProvider3;
                                TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z2, colorProvider2, MarginKt.margin(companion6, dpRectTextPadding), 0, composer2, 512, 16);
                                composer2.endReplaceableGroup();
                                composer3 = composer2;
                                z3 = z2;
                                colorProvider3 = colorProvider2;
                                size = i5;
                                i8 = i9;
                                list3 = list2;
                                i7 = 0;
                            }
                            list2 = list3;
                            i5 = size;
                            z2 = z3;
                            colorProvider2 = colorProvider3;
                            composer3 = composer2;
                            z3 = z2;
                            colorProvider3 = colorProvider2;
                            size = i5;
                            i8 = i9;
                            list3 = list2;
                            i7 = 0;
                        }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutHorizontal$5
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
                    TextBlockLayoutKt.m21852LayoutHorizontalRTYL8B8(list, z, colorProvider, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void LayoutVertical(final List<? extends TypedTextData> list, final boolean z, final ColorProvider colorProvider, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1944619589);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1944619589, i, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical (TextBlockLayout.kt:213)");
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        final int iVisibleTextCount = TextBlockLayoutDimensions.INSTANCE.visibleTextCount(list.size(), z, composerStartRestartGroup, (i & 112) | 384);
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        final GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion));
        ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion)), 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1045111217, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.LayoutVertical.1
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
                int i4;
                Composer composer3 = composer2;
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1045111217, i2, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.<anonymous> (TextBlockLayout.kt:359)");
                }
                int i5 = iVisibleTextCount - 1;
                int i6 = 0;
                while (i6 < iVisibleTextCount) {
                    TypedTextData typedTextData = list.get(i6);
                    if (typedTextData instanceof CustomTypedTextData) {
                        composer3.startReplaceableGroup(-321820567);
                        CustomTypedTextData customTypedTextData = (CustomTypedTextData) typedTextData;
                        customTypedTextData.CustomContent(customTypedTextData, composer3, 0);
                        i6++;
                        composer3.endReplaceableGroup();
                    } else if (typedTextData instanceof TypedTextListData) {
                        composer3.startReplaceableGroup(-321820430);
                        TextBlockLayoutKt.m21852LayoutHorizontalRTYL8B8(((TypedTextListData) typedTextData).getItems(), z, colorProvider, typedTextData.getTextAlign(), composer2, 520);
                        composer3 = composer2;
                        i6++;
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-321820135);
                        TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                        int i7 = i6;
                        int numberToGroup = textBlockLayoutDimensions.getNumberToGroup(list, i7, z, iVisibleTextCount, composer3, 24584);
                        if (numberToGroup > 0) {
                            composer3.startReplaceableGroup(-321820001);
                            TextBlockLayoutKt.LayoutVertical$TextGroup(iVisibleTextCount, list, mask, z, colorProvider, glanceModifierWrapContentHeight, i7, numberToGroup, composer2, 0);
                            i6 = i7 + numberToGroup;
                            composer2.endReplaceableGroup();
                            i4 = i5;
                        } else {
                            composer3.startReplaceableGroup(-321819893);
                            composer3.startReplaceableGroup(-321819867);
                            int textType = typedTextData.getTextType();
                            TextType.Companion companion2 = TextType.INSTANCE;
                            if (TextType.m21684equalsimpl0(textType, companion2.m21689getBodygxbDmow()) && i7 > 0 && TextType.m21684equalsimpl0(list.get(i7 - 1).getTextType(), companion2.m21694getTitlegxbDmow()) && AppWidgetSize.m21546compareToL2j3NV4(mask, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                                SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(2)), composer3, 0, 0);
                            }
                            composer3.endReplaceableGroup();
                            int i8 = i5;
                            i4 = i8;
                            GlanceModifier glanceModifierMargin = MarginKt.margin(glanceModifierWrapContentHeight, textBlockLayoutDimensions.textPadding(list, i7, i8, z, null, composer2, 196616, 16));
                            if (!z) {
                                int i9 = mask;
                                AppWidgetSize.Companion companion3 = AppWidgetSize.INSTANCE;
                                if ((AppWidgetSize.m21550equalsimpl0(i9, companion3.m21570getSmallrx25Pp4()) || AppWidgetSize.m21550equalsimpl0(mask, companion3.m21573getWideSmallrx25Pp4())) && i7 == 2) {
                                    glanceModifierMargin = VisibilityKt.visibility(glanceModifierMargin, C3094R.integer.sesl_glance_multi_textblock_small_3rd_text_visibility);
                                }
                            }
                            TextBlockLayoutKt.GlanceTextBlockText(typedTextData, z, colorProvider, glanceModifierMargin, iVisibleTextCount, composer2, 512, 0);
                            i6 = i7 + 1;
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                        composer3 = composer2;
                        i5 = i4;
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.LayoutVertical.2
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
                    TextBlockLayoutKt.LayoutVertical(list, z, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void LayoutVertical$TextGroup(final int i, final List<? extends TypedTextData> list, final int i2, final boolean z, final ColorProvider colorProvider, final GlanceModifier glanceModifier, final int i4, int i5, Composer composer, int i6) {
        float fM20968constructorimpl;
        composer.startReplaceableGroup(1737865227);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1737865227, i6, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup (TextBlockLayout.kt:219)");
        }
        if (i4 + i5 > i) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        final TypedTextData typedTextData = list.get(i4);
        final TypedTextData typedTextData2 = list.get(i4 + 1);
        final TypedTextData typedTextData3 = i5 == 3 ? list.get(i4 + 2) : null;
        if (typedTextData3 == null) {
            composer.startReplaceableGroup(1359354837);
            Debug debug = Debug.INSTANCE;
            GlanceModifier glanceModifierFillMaxWidth = SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE);
            composer.startReplaceableGroup(1359354994);
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i2, companion.m21571getTinyrx25Pp4())) {
                int textType = typedTextData.getTextType();
                TextType.Companion companion2 = TextType.INSTANCE;
                fM20968constructorimpl = ((!TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) || typedTextData.getTextLength(composer, 0) > 3) && (!TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion2.m21691getDisplaygxbDmow()) || typedTextData2.getTextLength(composer, 0) > 3)) ? C2256Dp.m20968constructorimpl(29) : C2256Dp.m20968constructorimpl(38);
            } else {
                if (AppWidgetSize.m21550equalsimpl0(i2, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i2, companion.m21573getWideSmallrx25Pp4())) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(42);
                } else if (AppWidgetSize.m21550equalsimpl0(i2, companion.m21569getMediumrx25Pp4())) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(z ? 66 : 57);
                } else {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(66);
                }
            }
            composer.endReplaceableGroup();
            debug.debugBox(SizeModifiersKt.m21505height3ABfNKs(glanceModifierFillMaxWidth, fM20968constructorimpl), null, "TextBlock7", false, ComposableLambdaKt.composableLambda(composer, -1663741712, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutVertical$TextGroup$1
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
                public final void invoke(@Nullable Composer composer2, int i7) {
                    if ((i7 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1663741712, i7, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous> (TextBlockLayout.kt:251)");
                    }
                    TypedTextData typedTextData4 = typedTextData;
                    boolean z2 = z;
                    TextBlockLayoutKt.GlanceTextBlockText(typedTextData4, z2, colorProvider, MarginKt.margin(glanceModifier, TextBlockLayoutDimensions.INSTANCE.textPadding(list, i4, i - 1, z2, null, composer2, 196616, 16)), i, composer2, 512, 0);
                    Debug debug2 = Debug.INSTANCE;
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                    final TypedTextData typedTextData5 = typedTextData2;
                    final boolean z3 = z;
                    final ColorProvider colorProvider2 = colorProvider;
                    final GlanceModifier glanceModifier2 = glanceModifier;
                    final List<TypedTextData> list2 = list;
                    final int i8 = i4;
                    final int i9 = i;
                    debug2.debugBox(glanceModifierFillMaxSize, bottomStart, "TextBlock8", false, ComposableLambdaKt.composableLambda(composer2, -986791769, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutVertical$TextGroup$1.1
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
                        public final void invoke(@Nullable Composer composer3, int i10) {
                            if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-986791769, i10, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous>.<anonymous> (TextBlockLayout.kt:270)");
                            }
                            TypedTextData typedTextData6 = typedTextData5;
                            boolean z4 = z3;
                            TextBlockLayoutKt.GlanceTextBlockText(typedTextData6, z4, colorProvider2, MarginKt.margin(glanceModifier2, TextBlockLayoutDimensions.INSTANCE.textPadding(list2, i8, i9 - 1, z4, null, composer3, 196616, 16)), i9, composer3, 512, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (Alignment.$stable << 3) | 221568, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 221568, 10);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1359357351);
            Debug.INSTANCE.debugBox(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) < 0 ? 79 : 96)), null, "TextBlock9", false, ComposableLambdaKt.composableLambda(composer, 1747796423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutVertical$TextGroup$2
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
                public final void invoke(@Nullable Composer composer2, int i7) {
                    if ((i7 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1747796423, i7, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous> (TextBlockLayout.kt:293)");
                    }
                    Debug debug2 = Debug.INSTANCE;
                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) < 0 ? 66 : 69));
                    final TypedTextData typedTextData4 = typedTextData;
                    final boolean z2 = z;
                    final ColorProvider colorProvider2 = colorProvider;
                    final GlanceModifier glanceModifier2 = glanceModifier;
                    final List<TypedTextData> list2 = list;
                    final int i8 = i4;
                    final int i9 = i;
                    final TypedTextData typedTextData5 = typedTextData2;
                    debug2.debugBox(glanceModifierM21505height3ABfNKs, null, "TextBlock10", false, ComposableLambdaKt.composableLambda(composer2, 1958556478, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutVertical$TextGroup$2.1
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
                        public final void invoke(@Nullable Composer composer3, int i10) {
                            if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1958556478, i10, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous>.<anonymous> (TextBlockLayout.kt:299)");
                            }
                            TypedTextData typedTextData6 = typedTextData4;
                            boolean z3 = z2;
                            TextBlockLayoutKt.GlanceTextBlockText(typedTextData6, z3, colorProvider2, MarginKt.margin(glanceModifier2, TextBlockLayoutDimensions.INSTANCE.textPadding(list2, i8, i9 - 1, z3, null, composer3, 196616, 16)), i9, composer3, 512, 0);
                            Debug debug3 = Debug.INSTANCE;
                            GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                            final TypedTextData typedTextData7 = typedTextData5;
                            final boolean z4 = z2;
                            final ColorProvider colorProvider3 = colorProvider2;
                            final GlanceModifier glanceModifier3 = glanceModifier2;
                            final List<TypedTextData> list3 = list2;
                            final int i11 = i8;
                            final int i12 = i9;
                            debug3.debugBox(glanceModifierFillMaxSize, bottomStart, "TextBlock11", false, ComposableLambdaKt.composableLambda(composer3, -1992663051, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.LayoutVertical.TextGroup.2.1.1
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
                                public final void invoke(@Nullable Composer composer4, int i13) {
                                    if ((i13 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1992663051, i13, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous>.<anonymous>.<anonymous> (TextBlockLayout.kt:318)");
                                    }
                                    TypedTextData typedTextData8 = typedTextData7;
                                    boolean z5 = z4;
                                    TextBlockLayoutKt.GlanceTextBlockText(typedTextData8, z5, colorProvider3, MarginKt.margin(glanceModifier3, TextBlockLayoutDimensions.INSTANCE.textPadding(list3, i11, i12 - 1, z5, null, composer4, 196616, 16)), i12, composer4, 512, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, (Alignment.$stable << 3) | 221568, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 221568, 10);
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(companion3);
                    Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                    final TypedTextData typedTextData6 = typedTextData3;
                    final boolean z3 = z;
                    final ColorProvider colorProvider3 = colorProvider;
                    final GlanceModifier glanceModifier3 = glanceModifier;
                    final List<TypedTextData> list3 = list;
                    final int i10 = i4;
                    final int i11 = i;
                    debug2.debugBox(glanceModifierFillMaxSize, bottomStart, "TextBlock12", false, ComposableLambdaKt.composableLambda(composer2, -1360782937, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt$LayoutVertical$TextGroup$2.2
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
                        public final void invoke(@Nullable Composer composer3, int i12) {
                            if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1360782937, i12, -1, "androidx.glance.oneui.template.layout.glance.LayoutVertical.TextGroup.<anonymous>.<anonymous> (TextBlockLayout.kt:339)");
                            }
                            TypedTextData typedTextData7 = typedTextData6;
                            boolean z4 = z3;
                            TextBlockLayoutKt.GlanceTextBlockText(typedTextData7, z4, colorProvider3, MarginKt.margin(glanceModifier3, TextBlockLayoutDimensions.INSTANCE.textPadding(list3, i10, i11 - 1, z4, null, composer3, 196616, 16)), i11, composer3, 512, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (Alignment.$stable << 3) | 221568, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, 221568, 10);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    public static final void TextBlockItemLayout(final TextBlockItem textBlockItem, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(855207877);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(855207877, i, -1, "androidx.glance.oneui.template.layout.glance.TextBlockItemLayout (TextBlockLayout.kt:158)");
        }
        if (textBlockItem.getTextList().getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.TextBlockItemLayout.1
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
                        TextBlockLayoutKt.TextBlockItemLayout(textBlockItem, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Debug debug = Debug.INSTANCE;
        GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
        composerStartRestartGroup.startReplaceableGroup(-999674175);
        ColorProvider inverseSurface = textBlockItem.getApplyInverseColor() ? GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getInverseSurface() : ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
        composerStartRestartGroup.endReplaceableGroup();
        debug.debugBox(GlanceModifierUtilsKt.contentDescription(GlanceModifierUtilsKt.maybeClickable$default(BackgroundKt.background(glanceModifierFillMaxSize, inverseSurface), textBlockItem.getOnClick(), false, false, 0, 14, null), textBlockItem.getContentDescription()), null, "TextBlock5", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1635176210, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.TextBlockItemLayout.2
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
            public final void invoke(@Nullable Composer composer2, int i2) {
                Alignment topStart;
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1635176210, i2, -1, "androidx.glance.oneui.template.layout.glance.TextBlockItemLayout.<anonymous> (TextBlockLayout.kt:178)");
                }
                composer2.startReplaceableGroup(-580973455);
                int i4 = mask;
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                GlanceModifier glanceModifierMargin = (!AppWidgetSize.m21550equalsimpl0(i4, companion.m21569getMediumrx25Pp4()) || textBlockItem.getFromSingleBlock$glance_oneui_template_release()) ? MarginKt.margin(GlanceModifier.INSTANCE, TextBlockLayoutDimensions.INSTANCE.itemPadding(textBlockItem, composer2, 56)) : PaddingKt.absolutePadding$default(MarginKt.margin$default(GlanceModifier.INSTANCE, C3094R.dimen.sesl_glance_multi_textblock_medium_horizontal_padding, 0, 2, null), 0, C3094R.dimen.sesl_glance_multi_textblock_medium_top_padding, 0, 0, 13, null);
                composer2.endReplaceableGroup();
                Debug debug2 = Debug.INSTANCE;
                GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(glanceModifierMargin);
                if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0) {
                    topStart = Alignment.INSTANCE.getCenterStart();
                } else {
                    int contentAlign = textBlockItem.getContentAlign();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    topStart = Alignment.Vertical.m21448equalsimpl0(contentAlign, companion2.m21434getTopmnfRV0w()) ? companion2.getTopStart() : Alignment.Vertical.m21448equalsimpl0(contentAlign, companion2.m21429getBottommnfRV0w()) ? companion2.getBottomStart() : companion2.getCenterStart();
                }
                Alignment alignment = topStart;
                final Function2<Composer, Integer, Unit> function22 = function2;
                debug2.debugBox(glanceModifierFillMaxSize2, alignment, "TextBlock6", false, ComposableLambdaKt.composableLambda(composer2, 861040343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.TextBlockItemLayout.2.1
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
                            ComposerKt.traceEventStart(861040343, i5, -1, "androidx.glance.oneui.template.layout.glance.TextBlockItemLayout.<anonymous>.<anonymous> (TextBlockLayout.kt:203)");
                        }
                        if (AbstractC1038a.m1196A(composer3, 0, function22)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (Alignment.$stable << 3) | 221568, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 221568, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt.TextBlockItemLayout.3
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
                    TextBlockLayoutKt.TextBlockItemLayout(textBlockItem, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
