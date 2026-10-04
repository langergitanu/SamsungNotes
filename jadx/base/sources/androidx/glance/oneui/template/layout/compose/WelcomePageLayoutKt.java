package androidx.glance.oneui.template.layout.compose;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.PainterModifierKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.res.PainterResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CombineTemplateKt;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.WelcomePageData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.ImageButtonKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.size.WelcomePageTemplateDp;
import androidx.glance.oneui.template.size.WelcomePageTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a,\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aJ\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"ComposeWelcomePageLayout", "", "data", "Landroidx/glance/oneui/template/WelcomePageData;", "(Landroidx/glance/oneui/template/WelcomePageData;Landroidx/compose/runtime/Composer;I)V", "WelcomeTextLayout", "modifier", "Landroidx/compose/ui/Modifier;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "WelcomeTextLayout-pt7MXqQ", "(Landroidx/compose/ui/Modifier;ILandroidx/glance/oneui/template/WelcomePageData;Landroidx/compose/runtime/Composer;II)V", "WelcomePageText", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "textAlign", "Landroidx/glance/text/TextAlign;", "maxLines", "", "fontWeight", "Landroidx/glance/text/FontWeight;", "autoResize", "", "WelcomePageText-B_d6Kxw", "(Landroidx/glance/oneui/template/TextData;IIIIZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWelcomePageLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WelcomePageLayout.kt\nandroidx/glance/oneui/template/layout/compose/WelcomePageLayoutKt\n+ 2 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,242:1\n67#2,6:243\n73#2:275\n77#2:280\n68#2,5:331\n73#2:362\n77#2:367\n68#2,5:368\n73#2:399\n77#2:443\n68#2,5:444\n73#2:475\n77#2:520\n75#3:249\n76#3,11:251\n89#3:279\n75#3:297\n76#3,11:299\n89#3:328\n75#3:336\n76#3,11:338\n89#3:366\n75#3:373\n76#3,11:375\n75#3:406\n76#3,11:408\n89#3:437\n89#3:442\n75#3:449\n76#3,11:451\n75#3:483\n76#3,11:485\n89#3:514\n89#3:519\n76#4:250\n74#4:281\n74#4:282\n74#4:283\n74#4:285\n74#4:287\n74#4:288\n76#4:298\n74#4:324\n74#4:330\n76#4:337\n76#4:374\n76#4:407\n76#4:450\n76#4:484\n460#5,13:262\n473#5,3:276\n460#5,13:310\n473#5,3:325\n460#5,13:349\n473#5,3:363\n460#5,13:386\n460#5,13:419\n473#5,3:434\n473#5,3:439\n460#5,13:462\n460#5,13:496\n473#5,3:511\n473#5,3:516\n88#6:284\n88#6:286\n88#6:289\n88#6:290\n88#6:521\n74#7,6:291\n80#7:323\n84#7:329\n74#7,6:400\n80#7:432\n84#7:438\n74#7,6:477\n80#7:509\n84#7:515\n154#8:433\n154#8:476\n154#8:510\n154#8:522\n*S KotlinDebug\n*F\n+ 1 WelcomePageLayout.kt\nandroidx/glance/oneui/template/layout/compose/WelcomePageLayoutKt\n*L\n71#1:243,6\n71#1:275\n71#1:280\n182#1:331,5\n182#1:362\n182#1:367\n195#1:368,5\n195#1:399\n195#1:443\n215#1:444,5\n215#1:475\n215#1:520\n71#1:249\n71#1:251,11\n71#1:279\n120#1:297\n120#1:299,11\n120#1:328\n182#1:336\n182#1:338,11\n182#1:366\n195#1:373\n195#1:375,11\n196#1:406\n196#1:408,11\n196#1:437\n195#1:442\n215#1:449\n215#1:451,11\n219#1:483\n219#1:485,11\n219#1:514\n215#1:519\n71#1:250\n82#1:281\n106#1:282\n107#1:283\n108#1:285\n112#1:287\n119#1:288\n120#1:298\n133#1:324\n156#1:330\n182#1:337\n195#1:374\n196#1:407\n215#1:450\n219#1:484\n71#1:262,13\n71#1:276,3\n120#1:310,13\n120#1:325,3\n182#1:349,13\n182#1:363,3\n195#1:386,13\n196#1:419,13\n196#1:434,3\n195#1:439,3\n215#1:462,13\n219#1:496,13\n219#1:511,3\n215#1:516,3\n107#1:284\n108#1:286\n127#1:289\n128#1:290\n59#1:521\n120#1:291,6\n120#1:323\n120#1:329\n196#1:400,6\n196#1:432\n196#1:438\n219#1:477,6\n219#1:509\n219#1:515\n208#1:433\n221#1:476\n228#1:510\n59#1:522\n*E\n"})
public final class WelcomePageLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeWelcomePageLayout(@NotNull WelcomePageData welcomePageData, @Nullable Composer composer, final int i) {
        Composer composer2;
        float fM20968constructorimpl;
        final WelcomePageData data = welcomePageData;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2057648406);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2057648406, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeWelcomePageLayout (WelcomePageLayout.kt:44)");
        }
        composerStartRestartGroup.startReplaceableGroup(212615536);
        if (data.getIllustrationBg() != 0) {
            Modifier modifierDebugBox = Debug.INSTANCE.debugBox(PainterModifierKt.paint$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), PainterResources_androidKt.painterResource(data.getIllustrationBg(), composerStartRestartGroup, 0), false, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 54, null), "Welcome1");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierDebugBox);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion2.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(212615952);
            composer2 = composerStartRestartGroup;
            m21819WelcomeTextLayoutpt7MXqQ(ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.1f, 0.0f, 0.0f, 0.0f, composer2, 438, 12), companion2.m21571getTinyrx25Pp4(), data, composer2, 512, 0);
            composer2.endReplaceableGroup();
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion2.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion2.m21573getWideSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(212616225);
                if (data.getIcon() != null) {
                    composerStartRestartGroup.startReplaceableGroup(212616262);
                    CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(data.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1703450194, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.WelcomePageLayoutKt.ComposeWelcomePageLayout.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i2) {
                            if ((i2 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1703450194, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeWelcomePageLayout.<anonymous> (WelcomePageLayout.kt:96)");
                            }
                            WelcomePageLayoutKt.m21819WelcomeTextLayoutpt7MXqQ(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(6), 0.0f, 2, null), ((AppWidgetSize) composer3.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), data, composer3, 518, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 0, null, 0, composerStartRestartGroup, 392, 58);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceableGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(212616735);
                    if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion2.m21570getSmallrx25Pp4())) {
                        composer2.startReplaceableGroup(212616882);
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * 0.115f);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(212616940);
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * 0.055f);
                        composer2.endReplaceableGroup();
                    }
                    m21819WelcomeTextLayoutpt7MXqQ(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM20968constructorimpl, 0.0f, 2, null), ((AppWidgetSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), data, composer2, 512, 0);
                    composer2.endReplaceableGroup();
                }
                composer2.endReplaceableGroup();
                data = welcomePageData;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(212617286);
                float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null);
                WelcomePageTemplateDp welcomePageTemplateDp = WelcomePageTemplateDp.INSTANCE;
                float horizontal_padding_over_medium = welcomePageTemplateDp.getHORIZONTAL_PADDING_OVER_MEDIUM(composer2, 6);
                float horizontal_padding_over_medium2 = welcomePageTemplateDp.getHORIZONTAL_PADDING_OVER_MEDIUM(composer2, 6);
                WelcomePageTemplatePercent welcomePageTemplatePercent = WelcomePageTemplatePercent.INSTANCE;
                Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(modifierWrapContentHeight$default, horizontal_padding_over_medium, C2256Dp.m20968constructorimpl(welcomePageTemplatePercent.getMEDIUM_TOP_PADDING() * fM21064getHeightD9Ej5fM), horizontal_padding_over_medium2, C2256Dp.m20968constructorimpl(welcomePageTemplatePercent.getMEDIUM_BOTTOM_PADDING() * fM21064getHeightD9Ej5fM));
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15857paddingqDBjuR0);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(853928445);
                if (welcomePageData.getIcon() != null) {
                    ComposeWelcomePageLayout$Icon(welcomePageData.getIcon(), composer2, 8);
                }
                composer2.endReplaceableGroup();
                data = welcomePageData;
                m21819WelcomeTextLayoutpt7MXqQ(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), ((AppWidgetSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), data, composer2, 518, 0);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.WelcomePageLayoutKt.ComposeWelcomePageLayout.4
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
                    WelcomePageLayoutKt.ComposeWelcomePageLayout(data, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void ComposeWelcomePageLayout$Icon(ImageWithBackgroundData imageWithBackgroundData, Composer composer, int i) {
        long jConvert;
        composer.startReplaceableGroup(339257264);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(339257264, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeWelcomePageLayout.Icon (WelcomePageLayout.kt:46)");
        }
        Pair<Float, Float> icon_size_percent = WelcomePageTemplatePercent.INSTANCE.getICON_SIZE_PERCENT();
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(icon_size_percent.getFirst().floatValue(), icon_size_percent.getSecond().floatValue(), 0.0f, 0.0f, 1.0f, composer, (PercentSizeUtils.$stable << 15) | 24576, 12));
        float fM20968constructorimpl = imageWithBackgroundData.getImageType() == ImageType.Icon ? C2256Dp.m20968constructorimpl(0.2f * fM21064getHeightD9Ej5fM) : C2256Dp.m20968constructorimpl(0);
        if (imageWithBackgroundData.getImageType() == ImageType.AppIcon) {
            composer.startReplaceableGroup(-690988676);
            jConvert = ComposeUtilsKt.convert(ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()), composer, 8);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-690988588);
            ColorProvider backgroundColor = imageWithBackgroundData.getBackgroundColor();
            composer.startReplaceableGroup(-690988565);
            if (backgroundColor == null) {
                backgroundColor = GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getSurface();
            }
            composer.endReplaceableGroup();
            jConvert = ComposeUtilsKt.convert(backgroundColor, composer, 8);
            composer.endReplaceableGroup();
        }
        ImageButtonKt.m21712ComposeImageButtonLFFoFBE(imageWithBackgroundData, fM21064getHeightD9Ej5fM, fM20968constructorimpl, jConvert, imageWithBackgroundData.getBackgroundResId(), null, composer, 8, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: WelcomePageText-B_d6Kxw, reason: not valid java name */
    public static final void m21818WelcomePageTextB_d6Kxw(final TextData textData, final int i, final int i2, final int i4, final int i5, boolean z, Modifier modifier, Composer composer, final int i6, final int i7) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1481020503);
        boolean z2 = (i7 & 16) != 0 ? false : z;
        Modifier modifier2 = (i7 & 32) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1481020503, i6, -1, "androidx.glance.oneui.template.layout.compose.WelcomePageText (WelcomePageLayout.kt:149)");
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        textData.m21678setTextAlignb1psNo$glance_oneui_template_release(i2);
        textData.setMaxLines$glance_oneui_template_release(i4);
        final boolean z3 = z2;
        final Modifier modifier3 = modifier2;
        TextKt.m21728ComposeText2T94tj4(modifier3, textData, new TextPercentData(0.0f, 0.0f, 0.0f, WelcomePageTemplatePercent.INSTANCE.m21955getTextViewHeightPercenttZlUyYw(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), i, i4), TextType.m21682covertToCategoryimpl(i), z3, 7, null), i5, ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground(), textData.getTextColor()), composerStartRestartGroup, ((i6 >> 3) & 7168) | ((i6 >> 18) & 14) | 32832 | (TextPercentData.$stable << 6), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.WelcomePageLayoutKt$WelcomePageText$1
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
                    WelcomePageLayoutKt.m21818WelcomePageTextB_d6Kxw(textData, i, i2, i4, i5, z3, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: WelcomeTextLayout-pt7MXqQ, reason: not valid java name */
    public static final void m21819WelcomeTextLayoutpt7MXqQ(Modifier modifier, final int i, final WelcomePageData welcomePageData, Composer composer, int i2, final int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1471069271);
        Modifier modifier2 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(1471069271, i5, -1, "androidx.glance.oneui.template.layout.compose.WelcomeTextLayout (WelcomePageLayout.kt:178)");
        } else {
            i5 = i2;
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1206250539);
            Modifier modifierDebugBox = Debug.INSTANCE.debugBox(modifier2, "Welcome2");
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierDebugBox);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            m21818WelcomePageTextB_d6Kxw(welcomePageData.getTitleText(), TextType.INSTANCE.m21693getLabelgxbDmow(), TextAlign.INSTANCE.m22007getCenterROrN78o(), 1, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), true, null, composerStartRestartGroup, 199736, 32);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(-1206250084);
                Modifier modifierDebugBox2 = Debug.INSTANCE.debugBox(modifier2, "Welcome2");
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment center2 = companion3.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierDebugBox2);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion5 = Modifier.INSTANCE;
                Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null), null, false, 3, null);
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion3, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyM1209j, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                TextData titleText = welcomePageData.getTitleText();
                TextType.Companion companion6 = TextType.INSTANCE;
                int iM21694getTitlegxbDmow = companion6.m21694getTitlegxbDmow();
                TextAlign.Companion companion7 = TextAlign.INSTANCE;
                int iM22011getStartROrN78o = companion7.m22011getStartROrN78o();
                int maxLines = welcomePageData.getTitleText().getMaxLines();
                FontWeight.Companion companion8 = FontWeight.INSTANCE;
                m21818WelcomePageTextB_d6Kxw(titleText, iM21694getTitlegxbDmow, iM22011getStartROrN78o, maxLines, companion8.m21999getSemiBoldWjrlUT0(), false, null, composerStartRestartGroup, 56, 48);
                TextData bodyText = welcomePageData.getBodyText();
                composerStartRestartGroup.startReplaceableGroup(-1690808435);
                if (bodyText != null) {
                    m21818WelcomePageTextB_d6Kxw(bodyText, companion6.m21689getBodygxbDmow(), companion7.m22011getStartROrN78o(), 1, companion8.m21998getNormalWjrlUT0(), false, PaddingKt.m15858paddingqDBjuR0$default(companion5, 0.0f, C2256Dp.m20968constructorimpl(3), 0.0f, 0.0f, 13, null), composerStartRestartGroup, 1575992, 16);
                    Unit unit = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1206249307);
                Debug debug = Debug.INSTANCE;
                Modifier.Companion companion9 = Modifier.INSTANCE;
                Modifier modifierDebugBox3 = debug.debugBox(SizeKt.fillMaxSize$default(companion9, 0.0f, 1, null), "Welcome3");
                Alignment.Companion companion10 = Alignment.INSTANCE;
                Alignment bottomStart = companion10.getBottomStart();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(bottomStart, false, composerStartRestartGroup, 6);
                Density density4 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor4 = companion11.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierDebugBox3);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion11, composerM18018constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, composerM18018constructorimpl4, density4));
                function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion11, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                float f = 2;
                Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion9, 0.0f, 1, null), null, false, 3, null), C2256Dp.m20968constructorimpl(f), 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j2 = AbstractC1038a.m1209j(companion10, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor5 = companion11.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion11, composerM18018constructorimpl5, measurePolicyM1209j2, composerM18018constructorimpl5, density5));
                function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion11, composerM18018constructorimpl5, viewConfiguration5, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                TextData titleText2 = welcomePageData.getTitleText();
                TextType.Companion companion12 = TextType.INSTANCE;
                int iM21694getTitlegxbDmow2 = companion12.m21694getTitlegxbDmow();
                TextAlign.Companion companion13 = TextAlign.INSTANCE;
                int iM22011getStartROrN78o2 = companion13.m22011getStartROrN78o();
                FontWeight.Companion companion14 = FontWeight.INSTANCE;
                m21818WelcomePageTextB_d6Kxw(titleText2, iM21694getTitlegxbDmow2, iM22011getStartROrN78o2, 1, companion14.m21999getSemiBoldWjrlUT0(), false, PaddingKt.m15856paddingVpY3zN4$default(SizeKt.wrapContentHeight$default(companion9, null, false, 3, null), 0.0f, C2256Dp.m20968constructorimpl(f), 1, null), composerStartRestartGroup, 1575992, 16);
                TextData bodyText2 = welcomePageData.getBodyText();
                composerStartRestartGroup.startReplaceableGroup(-1690807435);
                if (bodyText2 != null) {
                    m21818WelcomePageTextB_d6Kxw(bodyText2, companion12.m21689getBodygxbDmow(), companion13.m22011getStartROrN78o(), welcomePageData.getBodyText().getMaxLines(), companion14.m21998getNormalWjrlUT0(), false, SizeKt.wrapContentHeight$default(companion9, null, false, 3, null), composerStartRestartGroup, 1572920, 16);
                    Unit unit2 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.WelcomePageLayoutKt$WelcomeTextLayout$4
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
                    WelcomePageLayoutKt.m21819WelcomeTextLayoutpt7MXqQ(modifier3, i, welcomePageData, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }
}
