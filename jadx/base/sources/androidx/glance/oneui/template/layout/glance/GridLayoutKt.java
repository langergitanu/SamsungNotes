package androidx.glance.oneui.template.layout.glance;

import android.content.Context;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.BadgeData;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.GridItem;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.ProgressGridItem;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProviderUtils;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.size.GridTemplateDp;
import androidx.glance.oneui.template.size.GridTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0016\u001ab\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a/\u0010(\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010)\u001a,\u0010*\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a9\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001401H\u0003¢\u0006\u0002\u00102\u001a-\u00103\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u00104\u001a\u000205H\u0003¢\u0006\u0002\u00106\u001a\u001d\u00107\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0003¢\u0006\u0002\u00108\u001a\u0016\u00109\u001a\u00020:*\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0016\u0010=\u001a\u00020:*\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010<\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, m13886d2 = {"EmptyGridItem", "Landroidx/glance/oneui/template/GridItem;", "getEmptyGridItem", "()Landroidx/glance/oneui/template/GridItem;", "EmptyLabelGridItem", "getEmptyLabelGridItem", "Badge", "", "badge", "Landroidx/glance/oneui/template/BadgeData;", "(Landroidx/glance/oneui/template/BadgeData;Landroidx/compose/runtime/Composer;I)V", "GlanceGridLayout", "items", "", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "GridItemContainer", "modifier", "Landroidx/glance/GlanceModifier;", "gridItem", "gridCount", "", "gridPosition", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/GridItem;IILandroidx/compose/runtime/Composer;II)V", "GridItemContent", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "imageData", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "textData", "Landroidx/glance/oneui/template/TextData;", "showLabel", "", "textOverlapped", "badgeData", "onClick", "Landroidx/glance/action/Action;", "itemDescription", "", "GridItemContent-hBwqbR0", "(IILandroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/TextData;ZZLandroidx/glance/oneui/template/BadgeData;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "GridItemIcon", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/BadgeData;ZLandroidx/compose/runtime/Composer;II)V", "GridItemText", "textType", "Landroidx/glance/oneui/template/TextType;", "GridItemText-ium9O2g", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/TextData;ILandroidx/compose/runtime/Composer;II)V", "GridMap", "map", "Lkotlin/Pair;", "(Landroidx/glance/GlanceModifier;Ljava/util/List;Lkotlin/Pair;Landroidx/compose/runtime/Composer;II)V", "GridRow", Bixby2Constants.BIXBY_PARAM_RANGE, "Lkotlin/ranges/IntRange;", "(Landroidx/glance/GlanceModifier;Ljava/util/List;Lkotlin/ranges/IntRange;Landroidx/compose/runtime/Composer;II)V", "RippleContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/action/Action;Landroidx/compose/runtime/Composer;I)V", "getGridContainerHorizontalPadding", "", "getGridContainerHorizontalPadding-R2GYfMI", "(ILandroidx/compose/runtime/Composer;I)F", "getGridContainerVerticalPadding", "getGridContainerVerticalPadding-R2GYfMI", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGridLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GridLayout.kt\nandroidx/glance/oneui/template/layout/glance/GridLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,515:1\n74#2:516\n74#2:517\n74#2:518\n74#2:519\n88#3:520\n75#3:526\n75#3:528\n75#3:531\n58#3:536\n51#3:537\n51#3:538\n174#4:521\n174#4:522\n154#4:523\n154#4:524\n164#4:525\n154#4:527\n154#4:529\n154#4:532\n154#4:533\n154#4:534\n154#4:535\n1#5:530\n*S KotlinDebug\n*F\n+ 1 GridLayout.kt\nandroidx/glance/oneui/template/layout/glance/GridLayoutKt\n*L\n125#1:516\n195#1:517\n249#1:518\n250#1:519\n269#1:520\n284#1:526\n286#1:528\n302#1:531\n320#1:536\n325#1:537\n341#1:538\n274#1:521\n275#1:522\n428#1:523\n448#1:524\n450#1:525\n284#1:527\n286#1:529\n313#1:532\n314#1:533\n316#1:534\n318#1:535\n*E\n"})
public final class GridLayoutKt {

    @NotNull
    private static final GridItem EmptyGridItem = new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C3094R.drawable.skeleton_circle), null, null, null, 0, null, null, false, JPEG.COM, null), null, null, null, null, null, false, 126, null);

    @NotNull
    private static final GridItem EmptyLabelGridItem = new GridItem(new ImageWithBackgroundData(ImageKt.ImageProvider(C3094R.drawable.skeleton_circle), null, null, null, 0, null, null, false, JPEG.COM, null), new TextData("", (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), null, null, null, null, false, 124, null);

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void Badge(final BadgeData badgeData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1483378203);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1483378203, i, -1, "androidx.glance.oneui.template.layout.glance.Badge (GridLayout.kt:420)");
        }
        final ColorProvider colorProviderOverride = ColorProvidersKt.override(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294266131L)), badgeData.getBackgroundColor());
        if (badgeData.getCollapsed()) {
            composerStartRestartGroup.startReplaceableGroup(1406985176);
            Debug.INSTANCE.debugBox(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), ColorProviderUtils.INSTANCE.getTransparent()), C2256Dp.m20968constructorimpl(0)), null, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1026470313, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.Badge.1
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
                        ComposerKt.traceEventStart(-1026470313, i2, -1, "androidx.glance.oneui.template.layout.glance.Badge.<anonymous> (GridLayout.kt:429)");
                    }
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    SpacerKt.Spacer(AppWidgetModifiersKt.keepColor(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.m21506size3ABfNKs(companion, C2256Dp.m20968constructorimpl(6)), colorProviderOverride), C2256Dp.m20968constructorimpl(3)), badgeData.getKeepColor()), composer2, 0, 0);
                    float f = 0;
                    TextKt.m21752GlanceTextFbLeKfk(new TextData("", (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(f), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), ColorProviderUtils.INSTANCE.getTransparent(), SizeModifiersKt.m21506size3ABfNKs(companion, C2256Dp.m20968constructorimpl(f)), composer2, 4152, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 221184, 14);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1406985871);
            Debug.INSTANCE.debugBox(AppWidgetModifiersKt.keepColor(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(17)), colorProviderOverride), C2256Dp.m20968constructorimpl((float) 8.5d)), badgeData.getKeepColor()), Alignment.INSTANCE.getCenter(), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1914516398, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.Badge.2
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
                        ComposerKt.traceEventStart(1914516398, i2, -1, "androidx.glance.oneui.template.layout.glance.Badge.<anonymous> (GridLayout.kt:453)");
                    }
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion, C2256Dp.m20968constructorimpl(17)), composer2, 0, 0);
                    TextKt.m21752GlanceTextFbLeKfk(new TextData(badgeData.getText(), (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(12), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), ColorProvidersKt.override(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294769916L)), badgeData.getTextColor()), AppWidgetModifiersKt.keepColor(PaddingKt.m21498paddingVpY3zN4$default(companion, C2256Dp.m20968constructorimpl((float) 1.5d), 0.0f, 2, null), badgeData.getKeepColor()), composer2, 4152, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 221184, 12);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.Badge.3
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
                    GridLayoutKt.Badge(badgeData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceGridLayout(@NotNull final List<? extends GridItem> items, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        Composer composerStartRestartGroup = composer.startRestartGroup(-982109983);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-982109983, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceGridLayout (GridLayout.kt:121)");
        }
        if (items.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GlanceGridLayout.1
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
                        GridLayoutKt.GlanceGridLayout(items, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Debug.INSTANCE.debugBox(SizeModifiersKt.fillMaxSize(PaddingModifiersKt.m21356padding6PoWaU8(GlanceModifier.INSTANCE, m21837getGridContainerHorizontalPaddingR2GYfMI(mask, composerStartRestartGroup, 0), m21838getGridContainerVerticalPaddingR2GYfMI(mask, composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 6, 12)), Alignment.INSTANCE.getCenter(), "Top", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 16080216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GlanceGridLayout.2
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
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(16080216, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceGridLayout.<anonymous> (GridLayout.kt:133)");
                }
                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                List<GridItem> list = items;
                GridLayoutKt.GridMap(glanceModifierFillMaxSize, list, GridMapManager.INSTANCE.m21839getGridMapnXd0AQQ(mask, list.size(), items.get(0), composer2, 3584), composer2, 64, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GlanceGridLayout.3
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
                    GridLayoutKt.GlanceGridLayout(items, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GridItemContainer(GlanceModifier glanceModifier, final GridItem gridItem, final int i, final int i2, Composer composer, final int i4, final int i5) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-729480669);
        final GlanceModifier glanceModifier2 = (i5 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-729480669, i4, -1, "androidx.glance.oneui.template.layout.glance.GridItemContainer (GridLayout.kt:193)");
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        final TextData text = gridItem.getText();
        final ImageWithBackgroundData image = gridItem.getImage();
        final Action onClick = gridItem.getOnClick();
        final boolean textOverlapped = gridItem.getTextOverlapped();
        final boolean z = gridItem instanceof ProgressGridItem;
        Debug.INSTANCE.debugBox(glanceModifier2, Alignment.INSTANCE.getCenter(), "Item", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -621976038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridItemContainer.1
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
            public final void invoke(@Nullable Composer composer2, int i6) {
                if ((i6 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-621976038, i6, -1, "androidx.glance.oneui.template.layout.glance.GridItemContainer.<anonymous> (GridLayout.kt:212)");
                }
                if (z) {
                    composer2.startReplaceableGroup(232623641);
                    GridItem gridItem2 = gridItem;
                    Intrinsics.checkNotNull(gridItem2, "null cannot be cast to non-null type androidx.glance.oneui.template.ProgressGridItem");
                    ProgressGridItem progressGridItem = (ProgressGridItem) gridItem2;
                    ProgressIndicatorKt.GlanceCircularProgressIndicator(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), progressGridItem.getProgress(), i2, progressGridItem.getText(), composer2, 4160, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(232623971);
                    int i7 = mask;
                    int i8 = i;
                    ImageWithBackgroundData imageWithBackgroundData = image;
                    TextData textData = text;
                    GridLayoutKt.m21833GridItemContenthBwqbR0(i7, i8, imageWithBackgroundData, textData, GridLayoutKt.GridItemContainer$isShowLabel(textData, z, i7, i8), textOverlapped, gridItem.getBadge(), onClick, gridItem.getContentDescription(), composer2, 18878976);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i4 & 14) | 221568 | (Alignment.$stable << 3), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridItemContainer.2
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
                    GridLayoutKt.GridItemContainer(glanceModifier2, gridItem, i, i2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GridItemContainer$isShowLabel(TextData textData, boolean z, int i, int i2) {
        if (textData != null) {
            if (z) {
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                return AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21568getLargerx25Pp4()) > 0 || (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4()) && i2 == 4);
            }
            if (AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GridItemContent-hBwqbR0, reason: not valid java name */
    public static final void m21833GridItemContenthBwqbR0(final int i, final int i2, final ImageWithBackgroundData imageWithBackgroundData, final TextData textData, final boolean z, final boolean z2, final BadgeData badgeData, final Action action, final String str, Composer composer, final int i4) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-68353346);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-68353346, i4, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent (GridLayout.kt:247)");
        }
        Context context = (Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
        ((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue();
        ImageType imageType = imageWithBackgroundData.getImageType();
        float fM21951getMaxIconSizexeG5q6M = GridTemplateDp.INSTANCE.m21951getMaxIconSizexeG5q6M(context, i, z, i2);
        Pair<Float, Float> pairM21952getIconSizePercentnXd0AQQ = GridTemplatePercent.INSTANCE.m21952getIconSizePercentnXd0AQQ(i, i2, z, composerStartRestartGroup, (i4 & 14) | 3072 | (i4 & 112) | ((i4 >> 6) & 896));
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21952getIconSizePercentnXd0AQQ.getFirst().floatValue(), pairM21952getIconSizePercentnXd0AQQ.getSecond().floatValue(), fM21951getMaxIconSizexeG5q6M, fM21951getMaxIconSizexeG5q6M, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 0));
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(1.2f * fM21064getHeightD9Ej5fM);
        TextType.Companion companion = TextType.INSTANCE;
        int iM21693getLabelgxbDmow = z ? companion.m21693getLabelgxbDmow() : companion.m21689getBodygxbDmow();
        int i5 = (AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) < 0 || i2 > 4) ? 1 : 2;
        float fM20968constructorimpl2 = i5 == 1 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height_over_2_line));
        BadgeData badgeData2 = badgeData == null ? new BadgeData("", true, null, ColorProviderUtils.INSTANCE.getTransparent(), false, 20, null) : badgeData;
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-1329773083);
            GridItemContent_hBwqbR0$GridItemContentWithLabel(i, i2, fM20968constructorimpl, fM21064getHeightD9Ej5fM, fM20968constructorimpl2, action, str, imageType, imageWithBackgroundData, badgeData2, textData, iM21693getLabelgxbDmow, i5, composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1329773047);
            GridItemContent_hBwqbR0$GridItemContent(fM21064getHeightD9Ej5fM, imageType, imageWithBackgroundData, badgeData2, z2, i, textData, fM20968constructorimpl2, iM21693getLabelgxbDmow, action, i5, fM20968constructorimpl, str, composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i6) {
                    GridLayoutKt.m21833GridItemContenthBwqbR0(i, i2, imageWithBackgroundData, textData, z, z2, badgeData, action, str, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GridItemContent_hBwqbR0$GridItemContent(float f, ImageType imageType, ImageWithBackgroundData imageWithBackgroundData, BadgeData badgeData, boolean z, int i, TextData textData, float f4, int i2, Action action, int i4, float f5, String str, Composer composer, int i5) {
        composer.startReplaceableGroup(2030235558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030235558, i5, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContent (GridLayout.kt:278)");
        }
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(companion, f);
        ImageType imageType2 = ImageType.AppIcon;
        boolean z2 = false;
        GlanceModifier glanceModifierM21496padding3ABfNKs = PaddingKt.m21496padding3ABfNKs(CornerRadiusKt.m21286cornerRadius3ABfNKs(glanceModifierM21506size3ABfNKs, imageType != imageType2 ? C2256Dp.m20968constructorimpl(f / 2) : C2256Dp.m20968constructorimpl(0)), imageType == ImageType.Icon ? C2256Dp.m20968constructorimpl(f / 5) : C2256Dp.m20968constructorimpl(0));
        if (z && AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            z2 = true;
        }
        GridItemIcon(glanceModifierM21496padding3ABfNKs, imageWithBackgroundData, badgeData, z2, composer, Units.MASTER_DPI, 0);
        composer.startReplaceableGroup(-1684120142);
        if (z && textData != null && imageType != imageType2) {
            GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(companion, f), f4);
            textData.setMaxLines$glance_oneui_template_release(i4);
            m21834GridItemTextium9O2g(glanceModifierM21505height3ABfNKs, textData, i2, composer, 64, 0);
        }
        composer.endReplaceableGroup();
        if (action != null) {
            RippleContent(GlanceModifierUtilsKt.contentDescription(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(companion, f5), C2256Dp.m20968constructorimpl(f5 / 2)), str), action, composer, 64);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GridItemContent_hBwqbR0$GridItemContentWithLabel(final int i, int i2, final float f, final float f4, final float f5, final Action action, final String str, final ImageType imageType, final ImageWithBackgroundData imageWithBackgroundData, final BadgeData badgeData, final TextData textData, final int i4, final int i5, Composer composer, int i6) {
        float fM20968constructorimpl;
        composer.startReplaceableGroup(1029671792);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1029671792, i6, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContentWithLabel (GridLayout.kt:309)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4())) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(2);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4())) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(i2 <= 4 ? 4 : 2);
        } else {
            fM20968constructorimpl = AppWidgetSize.m21550equalsimpl0(i, companion.m21566getExtraLargerx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21567getExtraLargeLongrx25Pp4()) ? C2256Dp.m20968constructorimpl(4) : C2256Dp.m20968constructorimpl(0);
        }
        float f6 = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(f - f4);
        Debug debug = Debug.INSTANCE;
        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
        debug.debugBox(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion2), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM20968constructorimpl2 + f4) + f6) + f5)), Alignment.INSTANCE.getTopCenter(), null, false, ComposableLambdaKt.composableLambda(composer, -1260146969, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemContent$GridItemContentWithLabel$1
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
                    ComposerKt.traceEventStart(-1260146969, i7, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContentWithLabel.<anonymous> (GridLayout.kt:327)");
                }
                Action action2 = action;
                if (action2 != null) {
                    float f7 = f;
                    GridLayoutKt.RippleContent(GlanceModifierUtilsKt.contentDescription(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, f7), C2256Dp.m20968constructorimpl(f7 / 2)), str), action2, composer2, 64);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (Alignment.$stable << 3) | 221184, 12);
        debug.debugBox(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion2), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f4 + f6) + f5)), null, null, false, ComposableLambdaKt.composableLambda(composer, -1775590576, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemContent$GridItemContentWithLabel$2
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
                    ComposerKt.traceEventStart(-1775590576, i7, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContentWithLabel.<anonymous> (GridLayout.kt:342)");
                }
                Debug debug2 = Debug.INSTANCE;
                GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(companion3);
                Alignment.Companion companion4 = Alignment.INSTANCE;
                Alignment topCenter = companion4.getTopCenter();
                final float f7 = f4;
                final ImageType imageType2 = imageType;
                final ImageWithBackgroundData imageWithBackgroundData2 = imageWithBackgroundData;
                final BadgeData badgeData2 = badgeData;
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -1291800505, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemContent$GridItemContentWithLabel$2.1
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
                    public final void invoke(@Nullable Composer composer3, int i8) {
                        if ((i8 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1291800505, i8, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContentWithLabel.<anonymous>.<anonymous> (GridLayout.kt:347)");
                        }
                        GridLayoutKt.GridItemIcon(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, f7), imageType2 != ImageType.AppIcon ? C2256Dp.m20968constructorimpl(f7 / 2) : C2256Dp.m20968constructorimpl(0)), imageWithBackgroundData2, badgeData2, false, composer3, Units.MASTER_DPI, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                int i8 = Alignment.$stable;
                debug2.debugBox(glanceModifierFillMaxSize, topCenter, "Icon", false, composableLambda, composer2, (i8 << 3) | 221568, 8);
                int i9 = i;
                AppWidgetSize.Companion companion5 = AppWidgetSize.INSTANCE;
                float f8 = AppWidgetSize.m21550equalsimpl0(i9, companion5.m21568getLargerx25Pp4()) ? 0.03f : AppWidgetSize.m21546compareToL2j3NV4(i, companion5.m21569getMediumrx25Pp4()) >= 0 ? 0.02f : 0.0f;
                GlanceModifier glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(SizeModifiersKt.fillMaxSize(companion3), f8, 0.0f, f8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 0, 250);
                Alignment bottomCenter = companion4.getBottomCenter();
                final float f9 = f5;
                final TextData textData2 = textData;
                final int i10 = i4;
                final int i11 = i5;
                debug2.debugBox(glanceModifierM21358paddings2pLCVw, bottomCenter, null, false, ComposableLambdaKt.composableLambda(composer2, -392598736, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemContent$GridItemContentWithLabel$2.2
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
                    public final void invoke(@Nullable Composer composer3, int i12) {
                        if ((i12 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-392598736, i12, -1, "androidx.glance.oneui.template.layout.glance.GridItemContent.GridItemContentWithLabel.<anonymous>.<anonymous> (GridLayout.kt:366)");
                        }
                        GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, f9);
                        TextData textData3 = textData2;
                        Intrinsics.checkNotNull(textData3);
                        textData3.setMaxLines$glance_oneui_template_release(i11);
                        GridLayoutKt.m21834GridItemTextium9O2g(glanceModifierM21505height3ABfNKs, textData3, i10, composer3, 64, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i8 << 3) | 221184, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 221184, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GridItemIcon(final GlanceModifier glanceModifier, final ImageWithBackgroundData imageWithBackgroundData, final BadgeData badgeData, boolean z, Composer composer, final int i, final int i2) {
        GlanceModifier glanceModifier2;
        GlanceModifier glanceModifierBackground;
        Composer composerStartRestartGroup = composer.startRestartGroup(-469848808);
        final boolean z2 = (i2 & 8) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-469848808, i, -1, "androidx.glance.oneui.template.layout.glance.GridItemIcon (GridLayout.kt:398)");
        }
        ImageType imageType = imageWithBackgroundData.getImageType();
        composerStartRestartGroup.startReplaceableGroup(93529421);
        if (imageType != ImageType.Icon) {
            glanceModifier2 = glanceModifier;
            glanceModifierBackground = glanceModifier2;
        } else {
            glanceModifier2 = glanceModifier;
            glanceModifierBackground = BackgroundKt.background(glanceModifier2, ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface(), imageWithBackgroundData.getBackgroundColor()));
        }
        composerStartRestartGroup.endReplaceableGroup();
        androidx.glance.oneui.template.component.glance.ImageKt.m21746GlanceImagecuCYCYk(imageWithBackgroundData, glanceModifierBackground, 0, composerStartRestartGroup, 8, 4);
        composerStartRestartGroup.startReplaceableGroup(93529617);
        if (z2 && imageType != ImageType.AppIcon) {
            androidx.glance.oneui.template.component.glance.ImageKt.m21746GlanceImagecuCYCYk(new ImageData(ImageKt.ImageProvider(C3094R.color.sesl_glance_text_overlapped_icon_dim), null, null, null, null, false, 62, null), glanceModifier2, 0, composerStartRestartGroup, ((i << 3) & 112) | 8, 4);
        }
        composerStartRestartGroup.endReplaceableGroup();
        Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getTopEnd(), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -185831537, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridItemIcon.1
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
                    ComposerKt.traceEventStart(-185831537, i4, -1, "androidx.glance.oneui.template.layout.glance.GridItemIcon.<anonymous> (GridLayout.kt:416)");
                }
                GridLayoutKt.Badge(badgeData, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 221184 | (Alignment.$stable << 3), 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridItemIcon.2
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
                    GridLayoutKt.GridItemIcon(glanceModifier, imageWithBackgroundData, badgeData, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GridItemText-ium9O2g, reason: not valid java name */
    public static final void m21834GridItemTextium9O2g(GlanceModifier glanceModifier, final TextData textData, final int i, Composer composer, final int i2, final int i4) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1129250266);
        if ((i4 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1129250266, i2, -1, "androidx.glance.oneui.template.layout.glance.GridItemText (GridLayout.kt:470)");
        }
        ColorProviders colors = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable);
        final int iGridItemText_ium9O2g$getFontStyle = GridItemText_ium9O2g$getFontStyle(i);
        final ColorProvider colorProviderOverride = TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21689getBodygxbDmow()) ? ColorProvidersKt.override(colors.getOnSurface(), textData.getTextColor()) : ColorProvidersKt.override(colors.getOnBackground(), textData.getTextColor());
        Debug.INSTANCE.debugBox(glanceModifier2, null, Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -354420323, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemText$1
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
                    ComposerKt.traceEventStart(-354420323, i5, -1, "androidx.glance.oneui.template.layout.glance.GridItemText.<anonymous> (GridLayout.kt:482)");
                }
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(1), 0.0f, 2, null);
                TextData textData2 = textData;
                textData2.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
                textData2.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig());
                TextKt.GlanceText(textData2, new TextSize((Context) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalContext()), AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composer2.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21534getDexHomemn_SBp8()) ? C3094R.dimen.sesl_glance_grid_item_text_size_dex : C3094R.dimen.sesl_glance_grid_item_text_size, ComplexUnit.f1613DP, iGridItemText_ium9O2g$getFontStyle, 0.0f, 16, (DefaultConstructorMarker) null), colorProviderOverride, glanceModifierM21498paddingVpY3zN4$default, composer2, (TextPercentData.$stable << 3) | 520, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i2 & 14) | 221568, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt$GridItemText$2
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
                    GridLayoutKt.m21834GridItemTextium9O2g(glanceModifier2, textData, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    private static final int GridItemText_ium9O2g$getFontStyle(int i) {
        return TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21693getLabelgxbDmow()) ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GridMap(GlanceModifier glanceModifier, final List<? extends GridItem> list, final Pair<Integer, Integer> pair, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1211829778);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1211829778, i, -1, "androidx.glance.oneui.template.layout.glance.GridMap (GridLayout.kt:146)");
        }
        final int iIntValue = pair.getFirst().intValue();
        final int iIntValue2 = pair.getSecond().intValue();
        ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -267049884, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridMap.1
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
                    ComposerKt.traceEventStart(-267049884, i4, -1, "androidx.glance.oneui.template.layout.glance.GridMap.<anonymous> (GridLayout.kt:151)");
                }
                int i5 = iIntValue2;
                int i6 = iIntValue;
                List<GridItem> list2 = list;
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = i7 * i6;
                    GridLayoutKt.GridRow(Column.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), list2, RangesKt.until(i8, i8 + i6), composer2, Units.MASTER_DPI, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridMap.2
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
                    GridLayoutKt.GridMap(glanceModifier2, list, pair, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GridRow(GlanceModifier glanceModifier, final List<? extends GridItem> list, final IntRange intRange, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-42736328);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-42736328, i, -1, "androidx.glance.oneui.template.layout.glance.GridRow (GridLayout.kt:167)");
        }
        final int size = list.size();
        RowKt.m21502RowlMAjyxE(glanceModifier2, 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1273757284, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridRow.1
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
                    ComposerKt.traceEventStart(-1273757284, i4, -1, "androidx.glance.oneui.template.layout.glance.GridRow.<anonymous> (GridLayout.kt:170)");
                }
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    int i5 = first;
                    while (true) {
                        Composer composer3 = composer2;
                        GridLayoutKt.GridItemContainer(Row.defaultWeight(SizeModifiersKt.fillMaxHeight(GlanceModifier.INSTANCE)), i5 < size ? list.get(i5) : list.get(0).getText() != null ? GridLayoutKt.getEmptyLabelGridItem() : GridLayoutKt.getEmptyGridItem(), size, i5, composer3, 64, 0);
                        if (i5 == last) {
                            break;
                        }
                        i5++;
                        composer2 = composer3;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.GridRow.2
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
                    GridLayoutKt.GridRow(glanceModifier2, list, intRange, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void RippleContent(final GlanceModifier glanceModifier, final Action action, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1437522699);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1437522699, i, -1, "androidx.glance.oneui.template.layout.glance.RippleContent (GridLayout.kt:382)");
        }
        Debug.INSTANCE.debugBox(ActionKt.clickable(glanceModifier, action, C3094R.drawable.sesl_glance_dim_effect), null, null, false, ComposableSingletons$GridLayoutKt.INSTANCE.m21828getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 221184, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.GridLayoutKt.RippleContent.1
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
                    GridLayoutKt.RippleContent(glanceModifier, action, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @NotNull
    public static final GridItem getEmptyGridItem() {
        return EmptyGridItem;
    }

    @NotNull
    public static final GridItem getEmptyLabelGridItem() {
        return EmptyLabelGridItem;
    }

    @Composable
    /* JADX INFO: renamed from: getGridContainerHorizontalPadding-R2GYfMI, reason: not valid java name */
    public static final float m21837getGridContainerHorizontalPaddingR2GYfMI(int i, @Nullable Composer composer, int i2) {
        float f;
        composer.startReplaceableGroup(-1151441263);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1151441263, i2, -1, "androidx.glance.oneui.template.layout.glance.getGridContainerHorizontalPadding (GridLayout.kt:99)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
            f = 0.0f;
        } else {
            f = AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? 0.04f : 0.03f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }

    @Composable
    /* JADX INFO: renamed from: getGridContainerVerticalPadding-R2GYfMI, reason: not valid java name */
    public static final float m21838getGridContainerVerticalPaddingR2GYfMI(int i, @Nullable Composer composer, int i2) {
        float f;
        composer.startReplaceableGroup(-1940593629);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1940593629, i2, -1, "androidx.glance.oneui.template.layout.glance.getGridContainerVerticalPadding (GridLayout.kt:109)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
            f = 0.0f;
        } else {
            f = AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4()) ? 0.04f : 0.025f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }
}
