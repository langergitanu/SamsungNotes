package androidx.glance.oneui.template.layout.glance;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CombineTemplateKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.WelcomePageData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.size.WelcomePageTemplateDp;
import androidx.glance.oneui.template.size.WelcomePageTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.semantics.SemanticsModifierKt;
import androidx.glance.semantics.SemanticsPropertiesKt;
import androidx.glance.semantics.SemanticsPropertyReceiver;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aJ\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"GlanceWelcomePageLayout", "", "data", "Landroidx/glance/oneui/template/WelcomePageData;", "(Landroidx/glance/oneui/template/WelcomePageData;Landroidx/compose/runtime/Composer;I)V", "WelcomeIcon", "size", "Landroidx/compose/ui/unit/Dp;", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "WelcomeIcon-kHDZbjc", "(FLandroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/compose/runtime/Composer;I)V", "WelcomeTextLayout", "modifier", "Landroidx/glance/GlanceModifier;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "WelcomeTextLayout-pt7MXqQ", "(Landroidx/glance/GlanceModifier;ILandroidx/glance/oneui/template/WelcomePageData;Landroidx/compose/runtime/Composer;II)V", "WelcomePageText", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "textAlign", "Landroidx/glance/text/TextAlign;", "maxLines", "", "fontWeight", "Landroidx/glance/text/FontWeight;", "autoResize", "", "WelcomePageText-B_d6Kxw", "(Landroidx/glance/oneui/template/TextData;IIIIZLandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWelcomePageLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WelcomePageLayout.kt\nandroidx/glance/oneui/template/layout/glance/WelcomePageLayoutKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,274:1\n154#2:275\n75#3:276\n88#3:280\n88#3:282\n88#3:284\n88#3:285\n74#4:277\n74#4:278\n74#4:279\n74#4:281\n74#4:283\n74#4:286\n*S KotlinDebug\n*F\n+ 1 WelcomePageLayout.kt\nandroidx/glance/oneui/template/layout/glance/WelcomePageLayoutKt\n*L\n69#1:275\n69#1:276\n127#1:280\n128#1:282\n146#1:284\n147#1:285\n88#1:277\n102#1:278\n127#1:279\n128#1:281\n140#1:283\n187#1:286\n*E\n"})
public final class WelcomePageLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GlanceWelcomePageLayout(@NotNull final WelcomePageData data, @Nullable Composer composer, final int i) {
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-193214246);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-193214246, i, -1, "androidx.glance.oneui.template.layout.glance.GlanceWelcomePageLayout (WelcomePageLayout.kt:86)");
        }
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        WelcomePageTemplatePercent welcomePageTemplatePercent = WelcomePageTemplatePercent.INSTANCE;
        final Pair<Float, Float> pairM21954getButtonSizeL2j3NV4 = welcomePageTemplatePercent.m21954getButtonSizeL2j3NV4(mask);
        composerStartRestartGroup.startReplaceableGroup(-731944355);
        if (data.getIllustrationBg() != 0) {
            Debug.INSTANCE.debugBox(BackgroundKt.m21252backgroundPLcKuY0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ImageKt.ImageProvider(data.getIllustrationBg()), ContentScale.INSTANCE.m21465getCropAe3V0ko(), null, 4, null), null, "Welcome2", false, ComposableSingletons$WelcomePageLayoutKt.INSTANCE.m21832getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 221568, 10);
        }
        composerStartRestartGroup.endReplaceableGroup();
        int mask2 = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask2, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-731943953);
            GlanceModifier glanceModifierM21356padding6PoWaU8 = PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.1f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 432, 12);
            composerStartRestartGroup = composerStartRestartGroup;
            m21856WelcomeTextLayoutpt7MXqQ(glanceModifierM21356padding6PoWaU8, companion.m21571getTinyrx25Pp4(), data, composerStartRestartGroup, 512, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask2, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask2, companion.m21573getWideSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(-731943685);
                if (data.getIcon() != null) {
                    composerStartRestartGroup.startReplaceableGroup(-731943648);
                    CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(data.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1428574786, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt.GlanceWelcomePageLayout.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        public final void invoke(@Nullable Composer composer2, int i2) {
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1428574786, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceWelcomePageLayout.<anonymous> (WelcomePageLayout.kt:116)");
                            }
                            WelcomePageLayoutKt.m21856WelcomeTextLayoutpt7MXqQ(MarginKt.m21308marginVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(6), 0.0f, 2, null), mask, data, composer2, 512, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 0, null, 0, composerStartRestartGroup, 392, 58);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-731943183);
                    if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
                        composerStartRestartGroup.startReplaceableGroup(-731942996);
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * 0.115f);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-731942938);
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * 0.055f);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    m21856WelcomeTextLayoutpt7MXqQ(MarginKt.m21308marginVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), fM20968constructorimpl, 0.0f, 2, null), mask, data, composerStartRestartGroup, 512, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-731942571);
                float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
                Debug debug = Debug.INSTANCE;
                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                WelcomePageTemplateDp welcomePageTemplateDp = WelcomePageTemplateDp.INSTANCE;
                debug.debugBox(PaddingKt.m21499paddingqDBjuR0(glanceModifierFillMaxSize, welcomePageTemplateDp.getHORIZONTAL_PADDING_OVER_MEDIUM(composerStartRestartGroup, 6), C2256Dp.m20968constructorimpl(welcomePageTemplatePercent.getMEDIUM_TOP_PADDING() * fM21064getHeightD9Ej5fM), welcomePageTemplateDp.getHORIZONTAL_PADDING_OVER_MEDIUM(composerStartRestartGroup, 6), C2256Dp.m20968constructorimpl(welcomePageTemplatePercent.getMEDIUM_BOTTOM_PADDING() * fM21064getHeightD9Ej5fM)), null, "Welcome3", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1282806212, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt.GlanceWelcomePageLayout.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    public final void invoke(@Nullable Composer composer2, int i2) {
                        if ((i2 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1282806212, i2, -1, "androidx.glance.oneui.template.layout.glance.GlanceWelcomePageLayout.<anonymous> (WelcomePageLayout.kt:150)");
                        }
                        GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        final WelcomePageData welcomePageData = data;
                        final Pair<Float, Float> pair = pairM21954getButtonSizeL2j3NV4;
                        final int i4 = mask;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize2, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1176555194, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt.GlanceWelcomePageLayout.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i5) {
                                Composer composer4;
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1176555194, i5, -1, "androidx.glance.oneui.template.layout.glance.GlanceWelcomePageLayout.<anonymous>.<anonymous> (WelcomePageLayout.kt:151)");
                                }
                                composer3.startReplaceableGroup(-1809080134);
                                if (welcomePageData.getIcon() != null) {
                                    composer4 = composer3;
                                    WelcomePageLayoutKt.m21854WelcomeIconkHDZbjc(DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pair.getFirst().floatValue(), pair.getSecond().floatValue(), 0.0f, 0.0f, 1.0f, composer3, (PercentSizeUtils.$stable << 15) | 24576, 12)), welcomePageData.getIcon(), composer4, 64);
                                } else {
                                    composer4 = composer3;
                                }
                                composer4.endReplaceableGroup();
                                WelcomePageLayoutKt.m21856WelcomeTextLayoutpt7MXqQ(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), i4, welcomePageData, composer4, 512, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 221568, 10);
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt.GlanceWelcomePageLayout.3
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
                    WelcomePageLayoutKt.GlanceWelcomePageLayout(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WelcomeIcon-kHDZbjc, reason: not valid java name */
    public static final void m21854WelcomeIconkHDZbjc(final float f, final ImageWithBackgroundData imageWithBackgroundData, Composer composer, final int i) {
        GlanceModifier glanceModifierBackground;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1409144222);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1409144222, i, -1, "androidx.glance.oneui.template.layout.glance.WelcomeIcon (WelcomePageLayout.kt:51)");
        }
        if (imageWithBackgroundData.getBackgroundResId() != 0) {
            glanceModifierBackground = BackgroundKt.m21252backgroundPLcKuY0$default(GlanceModifier.INSTANCE, ImageKt.ImageProvider(imageWithBackgroundData.getBackgroundResId()), 0, null, 6, null);
        } else if (imageWithBackgroundData.getBackgroundColor() != null) {
            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
            ColorProvider backgroundColor = imageWithBackgroundData.getBackgroundColor();
            Intrinsics.checkNotNull(backgroundColor);
            glanceModifierBackground = BackgroundKt.background(companion, backgroundColor);
        } else {
            glanceModifierBackground = GlanceModifier.INSTANCE;
        }
        if (imageWithBackgroundData instanceof ImageButtonData) {
            ImageButtonData imageButtonData = (ImageButtonData) imageWithBackgroundData;
            if (imageButtonData.getOnClick() != null) {
                glanceModifierBackground = SemanticsModifierKt.semantics(ActionKt.clickable(glanceModifierBackground, imageButtonData.getOnClick()), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeIcon$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        String contentDescription = imageWithBackgroundData.getContentDescription();
                        if (contentDescription == null) {
                            contentDescription = "";
                        }
                        SemanticsPropertiesKt.setContentDescription(semantics, contentDescription);
                    }
                });
            }
        }
        Debug.INSTANCE.debugBox(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(glanceModifierBackground, f), imageWithBackgroundData.getImageType() == ImageType.AppIcon ? C2256Dp.m20968constructorimpl(0) : C2256Dp.m20968constructorimpl(f / 2)), Alignment.INSTANCE.getCenter(), "Welcome1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -634314279, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeIcon$2
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
                    ComposerKt.traceEventStart(-634314279, i2, -1, "androidx.glance.oneui.template.layout.glance.WelcomeIcon.<anonymous> (WelcomePageLayout.kt:72)");
                }
                ImageKt.m21259ImageGCr5PR4(imageWithBackgroundData.getImageProvider(), imageWithBackgroundData.getContentDescription(), AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(GlanceModifierUtilsKt.contentDescription(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, imageWithBackgroundData.getImageType() == ImageType.Icon ? C2256Dp.m20968constructorimpl(f * 0.6f) : f), imageWithBackgroundData.getContentDescription()), imageWithBackgroundData.getAnimation()), imageWithBackgroundData.getKeepColor()), ContentScale.INSTANCE.m21467getFitAe3V0ko(), null, composer2, 8, 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeIcon$3
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
                    WelcomePageLayoutKt.m21854WelcomeIconkHDZbjc(f, imageWithBackgroundData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WelcomePageText-B_d6Kxw, reason: not valid java name */
    public static final void m21855WelcomePageTextB_d6Kxw(final TextData textData, final int i, final int i2, final int i4, final int i5, boolean z, GlanceModifier glanceModifier, Composer composer, final int i6, final int i7) {
        Composer composerStartRestartGroup = composer.startRestartGroup(363819551);
        boolean z2 = (i7 & 16) != 0 ? false : z;
        GlanceModifier glanceModifier2 = (i7 & 32) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(363819551, i6, -1, "androidx.glance.oneui.template.layout.glance.WelcomePageText (WelcomePageLayout.kt:180)");
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        textData.m21678setTextAlignb1psNo$glance_oneui_template_release(i2);
        textData.setMaxLines$glance_oneui_template_release(i4);
        final boolean z3 = z2;
        final GlanceModifier glanceModifier3 = glanceModifier2;
        TextKt.m21750GlanceText2T94tj4(glanceModifier3, textData, new TextPercentData(0.0f, 0.0f, 0.0f, WelcomePageTemplatePercent.INSTANCE.m21955getTextViewHeightPercenttZlUyYw(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), i, i4), TextType.m21682covertToCategoryimpl(i), z3, 7, null), i5, ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground(), textData.getTextColor()), composerStartRestartGroup, ((i6 >> 3) & 7168) | ((i6 >> 18) & 14) | 32832 | (TextPercentData.$stable << 6), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomePageText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(textData, i, i2, i4, i5, z3, glanceModifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WelcomeTextLayout-pt7MXqQ, reason: not valid java name */
    public static final void m21856WelcomeTextLayoutpt7MXqQ(GlanceModifier glanceModifier, final int i, final WelcomePageData welcomePageData, Composer composer, final int i2, final int i4) {
        GlanceModifier glanceModifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-702385697);
        if ((i4 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        GlanceModifier glanceModifier3 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-702385697, i2, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout (WelcomePageLayout.kt:209)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(895259853);
            Debug.INSTANCE.debugBox(glanceModifier3, Alignment.INSTANCE.getCenter(), "Welcome2", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1792789854, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$1
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
                        ComposerKt.traceEventStart(1792789854, i5, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout.<anonymous> (WelcomePageLayout.kt:213)");
                    }
                    WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(welcomePageData.getTitleText(), TextType.INSTANCE.m21693getLabelgxbDmow(), TextAlign.INSTANCE.m22007getCenterROrN78o(), 1, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), true, null, composer2, 199736, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (i2 & 14) | 221568 | (Alignment.$stable << 3), 8);
            composerStartRestartGroup.endReplaceableGroup();
            glanceModifier2 = glanceModifier3;
        } else {
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(895260287);
                Debug.INSTANCE.debugBox(glanceModifier3, Alignment.INSTANCE.getCenter(), "Welcome5", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2105971371, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$2
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
                            ComposerKt.traceEventStart(-2105971371, i5, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout.<anonymous> (WelcomePageLayout.kt:226)");
                        }
                        GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                        final WelcomePageData welcomePageData2 = welcomePageData;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1193916769, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$2.1
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i6) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1193916769, i6, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout.<anonymous>.<anonymous> (WelcomePageLayout.kt:227)");
                                }
                                TextData titleText = welcomePageData2.getTitleText();
                                TextType.Companion companion2 = TextType.INSTANCE;
                                int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                                int iM22011getStartROrN78o = companion3.m22011getStartROrN78o();
                                int maxLines = welcomePageData2.getTitleText().getMaxLines();
                                FontWeight.Companion companion4 = FontWeight.INSTANCE;
                                WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(titleText, iM21694getTitlegxbDmow, iM22011getStartROrN78o, maxLines, companion4.m21999getSemiBoldWjrlUT0(), false, null, composer3, 56, 48);
                                TextData bodyText = welcomePageData2.getBodyText();
                                if (bodyText != null) {
                                    WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(bodyText, companion2.m21689getBodygxbDmow(), companion3.m22011getStartROrN78o(), 1, companion4.m21998getNormalWjrlUT0(), false, PaddingKt.m21500paddingqDBjuR0$default(GlanceModifier.INSTANCE, 0.0f, C2256Dp.m20968constructorimpl(3), 0.0f, 0.0f, 13, null), composer3, 3128, 16);
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
                }), composerStartRestartGroup, (i2 & 14) | 221568 | (Alignment.$stable << 3), 8);
                glanceModifier2 = glanceModifier3;
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                glanceModifier2 = glanceModifier3;
                composerStartRestartGroup.startReplaceableGroup(895261079);
                Debug.INSTANCE.debugBox(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.getBottomStart(), "Welcome6", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -293355083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$3
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
                            ComposerKt.traceEventStart(-293355083, i5, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout.<anonymous> (WelcomePageLayout.kt:250)");
                        }
                        GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(2), 0.0f, 2, null);
                        final WelcomePageData welcomePageData2 = welcomePageData;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21498paddingVpY3zN4$default, 0, 0, ComposableLambdaKt.composableLambda(composer2, 67424255, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$3.1
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i6) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(67424255, i6, -1, "androidx.glance.oneui.template.layout.glance.WelcomeTextLayout.<anonymous>.<anonymous> (WelcomePageLayout.kt:254)");
                                }
                                TextData titleText = welcomePageData2.getTitleText();
                                TextType.Companion companion2 = TextType.INSTANCE;
                                int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                                int iM22011getStartROrN78o = companion3.m22011getStartROrN78o();
                                FontWeight.Companion companion4 = FontWeight.INSTANCE;
                                int iM21999getSemiBoldWjrlUT0 = companion4.m21999getSemiBoldWjrlUT0();
                                GlanceModifier.Companion companion5 = GlanceModifier.INSTANCE;
                                WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(titleText, iM21694getTitlegxbDmow, iM22011getStartROrN78o, 1, iM21999getSemiBoldWjrlUT0, false, MarginKt.m21308marginVpY3zN4$default(SizeModifiersKt.wrapContentHeight(companion5), 0.0f, C2256Dp.m20968constructorimpl(2), 1, null), composer3, 3128, 16);
                                TextData bodyText = welcomePageData2.getBodyText();
                                if (bodyText != null) {
                                    WelcomePageLayoutKt.m21855WelcomePageTextB_d6Kxw(bodyText, companion2.m21689getBodygxbDmow(), companion3.m22011getStartROrN78o(), welcomePageData2.getBodyText().getMaxLines(), companion4.m21998getNormalWjrlUT0(), false, SizeModifiersKt.wrapContentHeight(companion5), composer3, 56, 16);
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
                }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier4 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.WelcomePageLayoutKt$WelcomeTextLayout$4
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
                    WelcomePageLayoutKt.m21856WelcomeTextLayoutpt7MXqQ(glanceModifier4, i, welcomePageData, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
