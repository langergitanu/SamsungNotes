package androidx.glance.oneui.template.legacy;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
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
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.appwidget.AppWidgetBackgroundKt;
import androidx.glance.appwidget.ArcProgressIndicatorKt;
import androidx.glance.appwidget.CircularProgressIndicatorKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.LinearProgressIndicatorKt;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ProgressType;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.component.ErrorKt;
import androidx.glance.oneui.template.legacy.IconSize;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontStyle;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextKt;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u00012\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a>\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001af\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a%\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u00107\u001a\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u00108\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m13886d2 = {"TemplateIcon", "", "provider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "width", "Landroidx/compose/ui/unit/Dp;", "height", "TemplateIcon-T43hY1o", "(Landroidx/glance/ImageProvider;Ljava/lang/String;FFLandroidx/compose/runtime/Composer;I)V", "iconSize", "Landroidx/glance/oneui/template/legacy/IconSize;", "TemplateIcon-6kce1gU", "(Landroidx/glance/ImageProvider;Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)V", "icon", "Landroidx/glance/oneui/template/ImageData;", "TemplateIcon-73KfpEQ", "(Landroidx/glance/oneui/template/ImageData;FFLandroidx/compose/runtime/Composer;I)V", "TemplateIcon-3-Tup6A", "(Landroidx/glance/oneui/template/ImageData;ILandroidx/compose/runtime/Composer;I)V", "TemplateProgressIndicator", "progress", "", "progressType", "Landroidx/glance/oneui/template/ProgressType;", "(FLandroidx/glance/oneui/template/ProgressType;Landroidx/compose/runtime/Composer;II)V", "TemplateText", "text", "textType", "Landroidx/glance/oneui/template/TextType;", "textColor", "Landroidx/glance/unit/ColorProvider;", "fontFamily", "Landroidx/glance/text/FontFamily;", "maxLines", "", "TemplateText-e4lg5Cc", "(Ljava/lang/String;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/text/FontFamily;ILandroidx/compose/runtime/Composer;II)V", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "textAlign", "Landroidx/glance/text/TextAlign;", "textDecoration", "Landroidx/glance/text/TextDecoration;", "fontStyle", "Landroidx/glance/text/FontStyle;", "fontWeight", "Landroidx/glance/text/FontWeight;", "TemplateText-5OKhOMc", "(Ljava/lang/String;Landroidx/glance/unit/ColorProvider;JIIIILandroidx/glance/text/FontFamily;ILandroidx/compose/runtime/Composer;II)V", "createTopLevelModifier", "Landroidx/glance/GlanceModifier;", "action", "Landroidx/glance/action/Action;", "(Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "iconClass", "iconSize-c00ojQ0", "(I)F", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidgetTemplates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetTemplates.kt\nandroidx/glance/oneui/template/legacy/GlanceAppWidgetTemplatesKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,294:1\n154#2:295\n154#2:296\n154#2:297\n154#2:298\n154#2:299\n154#2:300\n154#2:301\n154#2:302\n154#2:303\n154#2:304\n154#2:306\n154#2:307\n154#2:308\n74#3:305\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetTemplates.kt\nandroidx/glance/oneui/template/legacy/GlanceAppWidgetTemplatesKt\n*L\n90#1:295\n91#1:296\n92#1:297\n93#1:298\n94#1:299\n95#1:300\n240#1:301\n248#1:302\n256#1:303\n280#1:304\n283#1:306\n285#1:307\n287#1:308\n282#1:305\n*E\n"})
public final class GlanceAppWidgetTemplatesKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProgressType.values().length];
            try {
                iArr[ProgressType.Linear.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProgressType.Circular.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProgressType.Arc.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    /* JADX INFO: renamed from: TemplateIcon-3-Tup6A, reason: not valid java name */
    public static final void m21888TemplateIcon3Tup6A(@NotNull final ImageData icon, final int i, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(592568068);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(592568068, i2, -1, "androidx.glance.oneui.template.legacy.TemplateIcon (GlanceAppWidgetTemplates.kt:196)");
        }
        float fM21894iconSizec00ojQ0 = m21894iconSizec00ojQ0(i);
        m21890TemplateIcon73KfpEQ(icon, fM21894iconSizec00ojQ0, fM21894iconSizec00ojQ0, composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$3
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
                    GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.")
    @Composable
    /* JADX INFO: renamed from: TemplateIcon-6kce1gU, reason: not valid java name */
    public static final void m21889TemplateIcon6kce1gU(@NotNull final ImageProvider provider, @NotNull final String contentDescription, final int i, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Composer composerStartRestartGroup = composer.startRestartGroup(1181362826);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1181362826, i2, -1, "androidx.glance.oneui.template.legacy.TemplateIcon (GlanceAppWidgetTemplates.kt:175)");
        }
        float fM21894iconSizec00ojQ0 = m21894iconSizec00ojQ0(i);
        m21890TemplateIcon73KfpEQ(new ImageData(provider, contentDescription, null, null, null, false, 60, null), fM21894iconSizec00ojQ0, fM21894iconSizec00ojQ0, composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$1
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
                    GlanceAppWidgetTemplatesKt.m21889TemplateIcon6kce1gU(provider, contentDescription, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @Composable
    /* JADX INFO: renamed from: TemplateIcon-73KfpEQ, reason: not valid java name */
    public static final void m21890TemplateIcon73KfpEQ(@NotNull final ImageData icon, final float f, final float f4, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1181914854);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1181914854, i, -1, "androidx.glance.oneui.template.legacy.TemplateIcon (GlanceAppWidgetTemplates.kt:202)");
        }
        BoxKt.Box(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, f), f4), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -291481092, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-291481092, i2, -1, "androidx.glance.oneui.template.legacy.TemplateIcon.<anonymous> (GlanceAppWidgetTemplates.kt:204)");
                }
                composer2.startReplaceableGroup(-1804089317);
                if (((TemplateState) composer2.consume(CompositionLocalsKt.getLocalTemplateState())).getShowShadow()) {
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), 0.0f, C2256Dp.m20968constructorimpl((float) 0.5d), 0.0f, 0.0f, 13, null);
                    final ImageData imageData = icon;
                    final float f5 = f;
                    final float f6 = f4;
                    BoxKt.Box(glanceModifierM21500paddingqDBjuR0$default, null, ComposableLambdaKt.composableLambda(composer2, -1273051851, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i4) {
                            if ((i4 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1273051851, i4, -1, "androidx.glance.oneui.template.legacy.TemplateIcon.<anonymous>.<anonymous> (GlanceAppWidgetTemplates.kt:207)");
                            }
                            ImageKt.m21259ImageGCr5PR4(imageData.getImageProvider(), "", SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, f5), f6), 0, ColorFilter.INSTANCE.tint(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(436207616))), composer3, (ColorFilter.$stable << 12) | 56, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 384, 2);
                }
                composer2.endReplaceableGroup();
                ImageKt.m21259ImageGCr5PR4(icon.getImageProvider(), icon.getContentDescription(), SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, f), f4), 0, null, composer2, 8, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 384, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$5
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
                    GlanceAppWidgetTemplatesKt.m21890TemplateIcon73KfpEQ(icon, f, f4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.", replaceWith = @ReplaceWith(expression = "TemplateIcon(ImageData(provider, contentDescription), width, height)", imports = {"androidx.glance.oneui.template.ImageData"}))
    @Composable
    /* JADX INFO: renamed from: TemplateIcon-T43hY1o, reason: not valid java name */
    public static final void m21891TemplateIconT43hY1o(@NotNull final ImageProvider provider, @NotNull final String contentDescription, final float f, final float f4, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Composer composerStartRestartGroup = composer.startRestartGroup(-486130860);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486130860, i, -1, "androidx.glance.oneui.template.legacy.TemplateIcon (GlanceAppWidgetTemplates.kt:191)");
        }
        int i2 = i >> 3;
        m21890TemplateIcon73KfpEQ(new ImageData(provider, contentDescription, null, null, null, false, 60, null), f, f4, composerStartRestartGroup, (i2 & 896) | (i2 & 112) | 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateIcon$2
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
                    GlanceAppWidgetTemplatesKt.m21891TemplateIconT43hY1o(provider, contentDescription, f, f4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.")
    @Composable
    public static final void TemplateProgressIndicator(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @Nullable final ProgressType progressType, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final float f4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-818037215);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(progressType) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f4 = f;
        } else {
            if (i5 != 0) {
                progressType = ProgressType.Circular;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818037215, i4, -1, "androidx.glance.oneui.template.legacy.TemplateProgressIndicator (GlanceAppWidgetTemplates.kt:232)");
            }
            GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
            int i6 = GlanceTheme.$stable;
            ColorProvider onPrimary = glanceTheme.getColors(composerStartRestartGroup, i6).getOnPrimary();
            ColorProvider primary = glanceTheme.getColors(composerStartRestartGroup, i6).getPrimary();
            int i7 = WhenMappings.$EnumSwitchMapping$0[progressType.ordinal()];
            if (i7 == 1) {
                f4 = f;
                composerStartRestartGroup.startReplaceableGroup(-1832975701);
                LinearProgressIndicatorKt.LinearProgressIndicator(f4, SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(6)), onPrimary, primary, null, composerStartRestartGroup, (i4 & 14) | 4608, 16);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
            } else if (i7 == 2) {
                f4 = f;
                composerStartRestartGroup.startReplaceableGroup(-1832975407);
                CircularProgressIndicatorKt.CircularProgressIndicator(f4, SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(48)), onPrimary, primary, null, null, composerStartRestartGroup, (i4 & 14) | 4608, 48);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (i7 != 3) {
                composerStartRestartGroup.startReplaceableGroup(-1832974874);
                ErrorKt.ErrorBox("ProgressType=" + progressType, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                f4 = f;
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1832975132);
                f4 = f;
                ArcProgressIndicatorKt.ArcProgressIndicator(f4, SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(46)), onPrimary, primary, null, null, composerStartRestartGroup, (i4 & 14) | 4608, 48);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt.TemplateProgressIndicator.1
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
                    GlanceAppWidgetTemplatesKt.TemplateProgressIndicator(f4, progressType, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.")
    @Composable
    /* JADX INFO: renamed from: TemplateText-5OKhOMc, reason: not valid java name */
    public static final void m21892TemplateText5OKhOMc(@NotNull final String text, @NotNull final ColorProvider textColor, final long j, int i, int i2, int i4, int i5, @Nullable FontFamily fontFamily, int i6, @Nullable Composer composer, int i7, final int i8) {
        final int i9;
        int iM22009getLeftROrN78o;
        int i10;
        int iM22023getNoneObZ5V_A;
        int iM21988getNormalzT8OX4g;
        int iM21999getSemiBoldWjrlUT0;
        FontFamily sec;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(738187181);
        if ((i8 & 8) != 0) {
            i9 = i7;
            i10 = i9 & (-7169);
            iM22009getLeftROrN78o = TextAlign.INSTANCE.m22009getLeftROrN78o();
        } else {
            i9 = i7;
            iM22009getLeftROrN78o = i;
            i10 = i9;
        }
        if ((i8 & 16) != 0) {
            i10 &= -57345;
            iM22023getNoneObZ5V_A = TextDecoration.INSTANCE.m22023getNoneObZ5V_A();
        } else {
            iM22023getNoneObZ5V_A = i2;
        }
        if ((i8 & 32) != 0) {
            i10 &= -458753;
            iM21988getNormalzT8OX4g = FontStyle.INSTANCE.m21988getNormalzT8OX4g();
        } else {
            iM21988getNormalzT8OX4g = i4;
        }
        if ((i8 & 64) != 0) {
            i10 &= -3670017;
            iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
        } else {
            iM21999getSemiBoldWjrlUT0 = i5;
        }
        if ((i8 & 128) != 0) {
            i10 &= -29360129;
            sec = FontFamily.INSTANCE.getSec();
        } else {
            sec = fontFamily;
        }
        int i11 = (i8 & 256) != 0 ? 1 : i6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(738187181, i10, -1, "androidx.glance.oneui.template.legacy.TemplateText (GlanceAppWidgetTemplates.kt:154)");
        }
        TextKt.Text(text, (GlanceModifier) null, new TextStyle(textColor, TextUnit.m21151boximpl(TextUnitKt.getSp(TextUnit.m21161getValueimpl(j))), FontWeight.m21989boximpl(iM21999getSemiBoldWjrlUT0), FontStyle.m21980boximpl(iM21988getNormalzT8OX4g), TextAlign.m22000boximpl(iM22009getLeftROrN78o), TextDecoration.m22012boximpl(iM22023getNoneObZ5V_A), sec, 0, false, null, ComplexUnit.f1613DP, 0, null, null, 0, 31616, null), i11, 0.0f, composerStartRestartGroup, (i10 & 14) | ((i10 >> 15) & 7168), 18);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i12 = iM22009getLeftROrN78o;
            final int i13 = iM22023getNoneObZ5V_A;
            final FontFamily fontFamily2 = sec;
            final int i14 = iM21988getNormalzT8OX4g;
            final int i15 = iM21999getSemiBoldWjrlUT0;
            final int i16 = i11;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateText$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i17) {
                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(text, textColor, j, i12, i13, i14, i15, fontFamily2, i16, composer2, RecomposeScopeImplKt.updateChangedFlags(i9 | 1), i8);
                }
            });
        }
    }

    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.")
    @Composable
    /* JADX INFO: renamed from: TemplateText-e4lg5Cc, reason: not valid java name */
    public static final void m21893TemplateTexte4lg5Cc(@NotNull final String text, final int i, @NotNull final ColorProvider textColor, @Nullable FontFamily fontFamily, int i2, @Nullable Composer composer, final int i4, final int i5) {
        FontFamily sec;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-884573849);
        if ((i5 & 8) != 0) {
            i6 = i4 & (-7169);
            sec = FontFamily.INSTANCE.getSec();
        } else {
            sec = fontFamily;
            i6 = i4;
        }
        int i7 = (i5 & 16) != 0 ? 1 : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-884573849, i6, -1, "androidx.glance.oneui.template.legacy.TemplateText (GlanceAppWidgetTemplates.kt:109)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        long sp = TextType.m21684equalsimpl0(i, companion.m21691getDisplaygxbDmow()) ? TextUnitKt.getSp(16) : TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow()) ? TextUnitKt.getSp(15) : TextType.m21684equalsimpl0(i, companion.m21692getHeadlinegxbDmow()) ? TextUnitKt.getSp(13) : (!TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow()) && TextType.m21684equalsimpl0(i, companion.m21693getLabelgxbDmow())) ? TextUnitKt.getSp(12) : TextUnitKt.getSp(12);
        int i8 = i6 << 12;
        m21892TemplateText5OKhOMc(text, textColor, sp, 0, 0, 0, TextType.m21684equalsimpl0(i, companion.m21693getLabelgxbDmow()) ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), sec, i7, composerStartRestartGroup, (i6 & 14) | 64 | (FontFamily.$stable << 21) | (29360128 & i8) | (i8 & 234881024), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final FontFamily fontFamily2 = sec;
            final int i9 = i7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.GlanceAppWidgetTemplatesKt$TemplateText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i10) {
                    GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text, i, textColor, fontFamily2, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @NotNull
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x.", replaceWith = @ReplaceWith(expression = "androidx.glance.oneui.template.layout.TopLevelLayout", imports = {}))
    @Composable
    public static final GlanceModifier createTopLevelModifier(@Nullable Action action, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-175101404);
        Action action2 = (i2 & 1) != 0 ? null : action;
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-175101404, i, -1, "androidx.glance.oneui.template.legacy.createTopLevelModifier (GlanceAppWidgetTemplates.kt:276)");
        }
        GlanceModifier glanceModifierMaybeClickable$default = GlanceModifierUtilsKt.maybeClickable$default(GlanceModifierUtilsKt.contentDescription(SizeModifiersKt.m21507sizeVpY3zN4(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(AppWidgetBackgroundKt.appWidgetBackground(GlanceModifier.INSTANCE), GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getBackground()), C2256Dp.m20968constructorimpl(12)), AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4()) ? C2256Dp.m20968constructorimpl(56) : C2256Dp.m20968constructorimpl(124), C2256Dp.m20968constructorimpl(56)), str), action2, false, false, 0, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierMaybeClickable$default;
    }

    /* JADX INFO: renamed from: iconSize-c00ojQ0, reason: not valid java name */
    private static final float m21894iconSizec00ojQ0(int i) {
        IconSize.Companion companion = IconSize.INSTANCE;
        return IconSize.m21898equalsimpl0(i, companion.m21902getExtraLargeAKcXBXg()) ? C2256Dp.m20968constructorimpl(40) : IconSize.m21898equalsimpl0(i, companion.m21904getLargeAKcXBXg()) ? C2256Dp.m20968constructorimpl(30) : IconSize.m21898equalsimpl0(i, companion.m21905getMediumAKcXBXg()) ? C2256Dp.m20968constructorimpl(25) : IconSize.m21898equalsimpl0(i, companion.m21906getSmallAKcXBXg()) ? C2256Dp.m20968constructorimpl(21) : IconSize.m21898equalsimpl0(i, companion.m21903getExtraSmallAKcXBXg()) ? C2256Dp.m20968constructorimpl(19) : C2256Dp.m20968constructorimpl(16);
    }
}
