package androidx.glance.oneui.template.component.glance;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ActionButtonData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.TitleBarTextSizes;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"TitleBarText", "", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "modifier", "Landroidx/glance/GlanceModifier;", "TitleBarText-2FzTWkw", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "isSmallTablet", "", "(Landroidx/compose/runtime/Composer;I)Z", "GlanceContent", "Landroidx/glance/oneui/template/ActionButtonData;", "(Landroidx/glance/oneui/template/ActionButtonData;Landroidx/compose/runtime/Composer;I)V", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionContent", "(Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TitleBar.kt\nandroidx/glance/oneui/template/component/glance/TitleBarKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,182:1\n74#2:183\n74#2:184\n154#3:185\n154#3:186\n154#3:187\n154#3:188\n154#3:189\n*S KotlinDebug\n*F\n+ 1 TitleBar.kt\nandroidx/glance/oneui/template/component/glance/TitleBarKt\n*L\n47#1:183\n59#1:184\n63#1:185\n66#1:186\n68#1:187\n70#1:188\n133#1:189\n*E\n"})
public final class TitleBarKt {
    /* JADX WARN: Type inference failed for: r0v16, types: [T, androidx.glance.GlanceModifier] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    public static final void GlanceContent(@NotNull final TitleBarData titleBarData, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(titleBarData, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1932693101);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1932693101, i, -1, "androidx.glance.oneui.template.component.glance.GlanceContent (TitleBar.kt:55)");
        }
        if (!titleBarData.getShowTitleBar(composerStartRestartGroup, 8)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.1
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
                        TitleBarKt.GlanceContent(titleBarData, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        final boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        float f = 16;
        objectRef.element = MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f), 0.0f, function22 != null ? C2256Dp.m20968constructorimpl(0) : (titleBarData.getActionButton1() == null && titleBarData.getActionButton2() == null) ? C2256Dp.m20968constructorimpl(f) : C2256Dp.m20968constructorimpl(10), 0.0f, 10, null);
        Debug.INSTANCE.debugBox(null, null, "TitleBar", true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -350460086, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.2
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
                    ComposerKt.traceEventStart(-350460086, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceContent.<anonymous> (TitleBar.kt:74)");
                }
                GlanceModifier glanceModifierFillMaxHeight = zM21550equalsimpl0 ? SizeModifiersKt.fillMaxHeight(objectRef.element) : SizeModifiersKt.wrapContentHeight(objectRef.element);
                int iM21431getCenterVerticallymnfRV0w = zM21550equalsimpl0 ? Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w() : Alignment.INSTANCE.m21434getTopmnfRV0w();
                final boolean z = zM21550equalsimpl0;
                final Function2<Composer, Integer, Unit> function23 = function22;
                final TitleBarData titleBarData2 = titleBarData;
                final Function2<Composer, Integer, Unit> function24 = function2;
                RowKt.m21502RowlMAjyxE(glanceModifierFillMaxHeight, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, 1293107558, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.2.1
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
                            ComposerKt.traceEventStart(1293107558, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceContent.<anonymous>.<anonymous> (TitleBar.kt:79)");
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(Row.defaultWeight(companion));
                        composer3.startReplaceableGroup(-595914132);
                        float fM20968constructorimpl = z ? C2256Dp.m20968constructorimpl(0) : TitleBarKt.isSmallTablet(composer3, 0) ? C2256Dp.m20968constructorimpl(8) : CommonDimensions.INSTANCE.m21776getLayoutVerticalPaddingD9Ej5fM();
                        composer3.endReplaceableGroup();
                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(glanceModifierWrapContentHeight, 0.0f, fM20968constructorimpl, 0.0f, 0.0f, 13, null);
                        final TitleBarData titleBarData3 = titleBarData2;
                        final Function2<Composer, Integer, Unit> function25 = function24;
                        final boolean z2 = z;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer3, 638617136, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i5) {
                                float fM20968constructorimpl2;
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(638617136, i5, -1, "androidx.glance.oneui.template.component.glance.GlanceContent.<anonymous>.<anonymous>.<anonymous> (TitleBar.kt:91)");
                                }
                                TextData title = titleBarData3.getTitle();
                                TextType.Companion companion2 = TextType.INSTANCE;
                                int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                                GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                if (titleBarData3.getSubtitle() == null && function25 == null && !z2) {
                                    fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(titleBarData3.getTitle().getMaxLines() > 1 ? 2 : 12);
                                } else {
                                    fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(0);
                                }
                                TitleBarKt.m21754TitleBarText2FzTWkw(title, iM21694getTitlegxbDmow, MarginKt.m21310marginqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, fM20968constructorimpl2, 7, null), composer4, 56, 0);
                                if (function25 != null) {
                                    composer4.startReplaceableGroup(212199166);
                                    AbstractC1038a.m1198C(composer4, 0, function25);
                                } else {
                                    composer4.startReplaceableGroup(212199229);
                                    TextData subtitle = titleBarData3.getSubtitle();
                                    if (subtitle != null) {
                                        TitleBarKt.m21754TitleBarText2FzTWkw(subtitle, companion2.m21689getBodygxbDmow(), PaddingKt.m21498paddingVpY3zN4$default(companion3, 0.0f, C2256Dp.m20968constructorimpl(2), 1, null), composer4, 56, 0);
                                    }
                                    composer4.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 6);
                        if (function23 != null) {
                            composer3.startReplaceableGroup(-595913087);
                            SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion, C2256Dp.m20968constructorimpl(6)), composer3, 0, 0);
                            AbstractC1038a.m1198C(composer3, 0, function23);
                        } else if (titleBarData2.getActionButton1() == null && titleBarData2.getActionButton2() == null) {
                            composer3.startReplaceableGroup(-595912611);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-595912890);
                            SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion, C2256Dp.m20968constructorimpl(2)), composer3, 0, 0);
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(companion, 0.0f, C2256Dp.m20968constructorimpl(10), 0.0f, 0.0f, 13, null);
                            final TitleBarData titleBarData4 = titleBarData2;
                            RowKt.m21502RowlMAjyxE(glanceModifierM21500paddingqDBjuR0$default2, 0, 0, ComposableLambdaKt.composableLambda(composer3, 1994389118, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.2.1.2
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
                                public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer4, int i5) {
                                    Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1994389118, i5, -1, "androidx.glance.oneui.template.component.glance.GlanceContent.<anonymous>.<anonymous>.<anonymous> (TitleBar.kt:121)");
                                    }
                                    ActionButtonData actionButton1 = titleBarData4.getActionButton1();
                                    composer4.startReplaceableGroup(212199836);
                                    if (actionButton1 != null) {
                                        TitleBarKt.GlanceContent(actionButton1, composer4, 0);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer4.endReplaceableGroup();
                                    ActionButtonData actionButton2 = titleBarData4.getActionButton2();
                                    if (actionButton2 != null) {
                                        TitleBarKt.GlanceContent(actionButton2, composer4, 0);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 3072, 6);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 2);
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
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.3
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
                    TitleBarKt.GlanceContent(titleBarData, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TitleBarText-2FzTWkw, reason: not valid java name */
    public static final void m21754TitleBarText2FzTWkw(final TextData textData, final int i, GlanceModifier glanceModifier, Composer composer, final int i2, final int i4) {
        TextSize textSize;
        ColorProvider onSurfaceVariant;
        Composer composerStartRestartGroup = composer.startRestartGroup(904584954);
        final GlanceModifier glanceModifier2 = (i4 & 4) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(904584954, i2, -1, "androidx.glance.oneui.template.component.glance.TitleBarText (TitleBar.kt:163)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1940417483);
            textSize = isSmallTablet(composerStartRestartGroup, 0) ? new TextSize(12.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null) : TitleBarTextSizes.INSTANCE.getTitleText();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1940417602);
            textSize = isSmallTablet(composerStartRestartGroup, 0) ? new TextSize(8.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null) : TitleBarTextSizes.INSTANCE.getBodyText();
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextSize textSize2 = textSize;
        if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1940417777);
            onSurfaceVariant = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1940417846);
            onSurfaceVariant = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurfaceVariant();
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.GlanceText(textData, textSize2, onSurfaceVariant, glanceModifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt$TitleBarText$1
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
                    TitleBarKt.m21754TitleBarText2FzTWkw(textData, i, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isSmallTablet(Composer composer, int i) {
        boolean z;
        composer.startReplaceableGroup(1098352488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1098352488, i, -1, "androidx.glance.oneui.template.component.glance.isSmallTablet (TitleBar.kt:45)");
        }
        if (((Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext())).getResources().getConfiguration().smallestScreenWidthDp < 500) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            z = StringsKt.m14162r(MODEL, "SM-X");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceContent(final ActionButtonData actionButtonData, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1473020222);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(actionButtonData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1473020222, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceContent (TitleBar.kt:130)");
            }
            Debug.INSTANCE.debugBox(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(30)), Alignment.INSTANCE.getCenter(), "Title1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1659745383, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.4
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
                        ComposerKt.traceEventStart(1659745383, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceContent.<anonymous> (TitleBar.kt:136)");
                    }
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(companion, C2256Dp.m20968constructorimpl(22));
                    GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                    int i5 = GlanceTheme.$stable;
                    debug.debugBox(AppWidgetModifiersKt.alpha(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(glanceModifierM21506size3ABfNKs, ColorProvidersKt.override(glanceTheme.getColors(composer2, i5).getSurface(), actionButtonData.getBackgroundColor())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()), actionButtonData.getEnabled() ? 1.0f : 0.6f), null, "Title2", false, ComposableSingletons$TitleBarKt.INSTANCE.m21738getLambda1$glance_oneui_template_release(), composer2, 221568, 10);
                    ImageProvider imageProvider = actionButtonData.getImageProvider();
                    String contentDescription = actionButtonData.getContentDescription();
                    Action onClick = actionButtonData.getOnClick();
                    composer2.startReplaceableGroup(483631078);
                    if (onClick == null) {
                        onClick = LambdaActionKt.action(null, new Function0<Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.4.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 48, 1);
                    }
                    composer2.endReplaceableGroup();
                    androidx.glance.appwidget.ImageButtonKt.m21297ImageButtonaCxP0qg(imageProvider, contentDescription, onClick, BackgroundKt.background(AppWidgetModifiersKt.alpha(PaddingKt.m21496padding3ABfNKs(SizeModifiersKt.fillMaxSize(companion), C2256Dp.m20968constructorimpl(6)), actionButtonData.getEnabled() ? 1.0f : 0.6f), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU())), actionButtonData.getEnabled(), 0, ColorFilter.INSTANCE.tint(glanceTheme.getColors(composer2, i5).getOnSurface()), composer2, (ColorFilter.$stable << 18) | 520, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TitleBarKt.GlanceContent.5
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
                    TitleBarKt.GlanceContent(actionButtonData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
