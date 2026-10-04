package androidx.glance.oneui.template.component.glance;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.compose.p109ui.graphics.Color;
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
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.CornerRadiusModifier;
import androidx.glance.appwidget.percent.PercentPaddingModifier;
import androidx.glance.appwidget.percent.PercentRange;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000f\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0012\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0017\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a<\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u001f2\b\b\u0001\u0010\u0006\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a-\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, m13886d2 = {"GlanceImageButton", "", "data", "Landroidx/glance/oneui/template/ImageData;", "size", "Landroidx/compose/ui/unit/Dp;", "padding", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "modifier", "Landroidx/glance/GlanceModifier;", "GlanceImageButton-o3XDK20", "(Landroidx/glance/oneui/template/ImageData;FFLandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "background", "", "(Landroidx/glance/oneui/template/ImageData;FFILandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "GlanceImageButton-DzVHIIc", "(Landroidx/glance/oneui/template/ImageData;FLandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/oneui/template/ImageData;IILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/oneui/template/ImageData;IIILandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "GlanceImageButton-djqs-MU", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;FFLandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;IILandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "ImageButtonInternal", "backgroundResId", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/unit/ColorProvider;ILandroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;I)V", "withSizeAndPadding", "withSizeAndPadding-T43hY1o", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/ImageData;FFLandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "withSizeAndPadding-ZbchW5Y", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/ImageData;FFILandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/ImageData;IILandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/glance/ImageButtonKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 Utils.kt\nandroidx/glance/UtilsKt\n*L\n1#1,266:1\n88#2:267\n58#2:268\n75#2:269\n88#2:273\n88#2:275\n88#2:276\n154#3:270\n154#3:271\n154#3:277\n74#4:272\n74#4:274\n74#4:278\n36#5,11:279\n*S KotlinDebug\n*F\n+ 1 ImageButton.kt\nandroidx/glance/oneui/template/component/glance/ImageButtonKt\n*L\n54#1:267\n54#1:268\n54#1:269\n126#1:273\n127#1:275\n129#1:276\n66#1:270\n78#1:271\n152#1:277\n126#1:272\n127#1:274\n199#1:278\n201#1:279,11\n*E\n"})
public final class ImageButtonKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceImageButton(@NotNull final ImageData data, @DimenRes final int i, @DimenRes final int i2, @NotNull final ColorProvider backgroundColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1989501720);
        final GlanceModifier glanceModifier2 = (i5 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1989501720, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:164)");
        }
        int i6 = i4 << 3;
        ImageButtonInternal(data, backgroundColor, 0, withSizeAndPadding(glanceModifier2, data, i, i2, composerStartRestartGroup, ((i4 >> 12) & 14) | 64 | (i6 & 896) | (i6 & 7168)), composerStartRestartGroup, 456);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.5
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
                    ImageButtonKt.GlanceImageButton(data, i, i2, backgroundColor, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "GlanceImageButton(data, size, padding, backgroundColor, modifier)", imports = {}))
    @Composable
    /* JADX INFO: renamed from: GlanceImageButton-DzVHIIc, reason: not valid java name */
    public static final void m21739GlanceImageButtonDzVHIIc(@NotNull final ImageData data, final float f, @NotNull final ColorProvider backgroundColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1435254554);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1435254554, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:52)");
        }
        m21742GlanceImageButtono3XDK20(data, f, C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f - C2256Dp.m20968constructorimpl(0.6667f * f)) / 2), backgroundColor, glanceModifier2, composerStartRestartGroup, (i & 112) | 4104 | ((i << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.1
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
                    ImageButtonKt.m21739GlanceImageButtonDzVHIIc(data, f, backgroundColor, glanceModifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceImageButton-djqs-MU, reason: not valid java name */
    public static final void m21740GlanceImageButtondjqsMU(@NotNull final ImageWithBackgroundData data, final float f, final float f4, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1578628702);
        if ((i2 & 8) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1578628702, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:109)");
        }
        int i4 = i << 3;
        ImageButtonInternal(data, data.getBackgroundColor(), data.getBackgroundResId(), m21743withSizeAndPaddingT43hY1o(glanceModifier2, data, f, f4, composerStartRestartGroup, ((i >> 9) & 14) | 64 | (i4 & 896) | (i4 & 7168)), composerStartRestartGroup, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.4
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
                    ImageButtonKt.m21740GlanceImageButtondjqsMU(data, f, f4, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceImageButton-o3XDK20, reason: not valid java name */
    public static final void m21742GlanceImageButtono3XDK20(@NotNull final ImageData data, final float f, final float f4, @NotNull final ColorProvider backgroundColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-101902638);
        final GlanceModifier glanceModifier2 = (i2 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-101902638, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:90)");
        }
        int i4 = i << 3;
        ImageButtonInternal(data, backgroundColor, 0, m21743withSizeAndPaddingT43hY1o(glanceModifier2, data, f, f4, composerStartRestartGroup, ((i >> 12) & 14) | 64 | (i4 & 896) | (i4 & 7168)), composerStartRestartGroup, 456);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.2
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
                    ImageButtonKt.m21742GlanceImageButtono3XDK20(data, f, f4, backgroundColor, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ImageButtonInternal(@NotNull final ImageData data, @Nullable final ColorProvider colorProvider, @DrawableRes final int i, @NotNull final GlanceModifier modifier, @Nullable Composer composer, int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-66539482);
        if (ComposerKt.isTraceInProgress()) {
            i4 = i2;
            ComposerKt.traceEventStart(-66539482, i4, -1, "androidx.glance.oneui.template.component.glance.ImageButtonInternal (ImageButton.kt:197)");
        } else {
            i4 = i2;
        }
        final boolean zM21578equalsimpl0 = AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM());
        GlanceModifier glanceModifier = (GlanceModifier) (modifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$$inlined$extractModifier$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof PaddingModifier);
            }
        }) ? (Pair) modifier.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends PaddingModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends PaddingModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$$inlined$extractModifier$2
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Pair<PaddingModifier, GlanceModifier> invoke(@NotNull Pair<? extends PaddingModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof PaddingModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
            }
        }) : TuplesKt.m13893to(null, modifier)).getSecond();
        GlanceModifier glanceModifierM21250background4WTKRHQ = (GlanceModifier) (glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$$inlined$extractModifier$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof PercentPaddingModifier);
            }
        }) ? (Pair) glanceModifier.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends PercentPaddingModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends PercentPaddingModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$$inlined$extractModifier$4
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Pair<PercentPaddingModifier, GlanceModifier> invoke(@NotNull Pair<? extends PercentPaddingModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof PercentPaddingModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
            }
        }) : TuplesKt.m13893to(null, glanceModifier)).component2();
        Debug debug = Debug.INSTANCE;
        if (!zM21578equalsimpl0 || i == 0) {
            glanceModifierM21250background4WTKRHQ = BackgroundKt.m21250background4WTKRHQ(glanceModifierM21250background4WTKRHQ, Color.INSTANCE.m18560getTransparent0d7_KjU());
        }
        debug.debugBox(glanceModifierM21250background4WTKRHQ, null, "ImageButton", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1512842993, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.ImageButtonInternal.1
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
                ColorProvider colorProviderM22055ColorProvider8_81llA;
                ColorProvider imageTintColor;
                int i6;
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1512842993, i5, -1, "androidx.glance.oneui.template.component.glance.ImageButtonInternal.<anonymous> (ImageButton.kt:207)");
                }
                composer2.startReplaceableGroup(528180565);
                if (zM21578equalsimpl0 && (i6 = i) != 0) {
                    androidx.glance.ImageKt.m21259ImageGCr5PR4(androidx.glance.ImageKt.ImageProvider(i6), "BackgroundImage", SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0, null, composer2, 56, 24);
                }
                composer2.endReplaceableGroup();
                GlanceModifier glanceModifier2 = modifier;
                ColorFilter colorFilterTint = null;
                GlanceModifier glanceModifier3 = (GlanceModifier) (glanceModifier2.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$1$invoke$$inlined$extractModifier$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it instanceof CornerRadiusModifier);
                    }
                }) ? (Pair) glanceModifier2.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends CornerRadiusModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends CornerRadiusModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt$ImageButtonInternal$1$invoke$$inlined$extractModifier$2
                    @Override // kotlin.jvm.functions.Function2
                    @NotNull
                    public final Pair<CornerRadiusModifier, GlanceModifier> invoke(@NotNull Pair<? extends CornerRadiusModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                        Intrinsics.checkNotNullParameter(acc, "acc");
                        Intrinsics.checkNotNullParameter(cur, "cur");
                        return cur instanceof CornerRadiusModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
                    }
                }) : TuplesKt.m13893to(null, glanceModifier2)).component2();
                ImageProvider imageProvider = data.getImageProvider();
                String contentDescription = data.getContentDescription();
                ImageData imageData = data;
                Action onClick = imageData instanceof ImageButtonData ? ((ImageButtonData) imageData).getOnClick() : null;
                if (zM21578equalsimpl0 && (imageTintColor = data.getImageTintColor()) != null) {
                    colorFilterTint = ColorFilter.INSTANCE.tint(imageTintColor);
                }
                ColorFilter colorFilter = colorFilterTint;
                int iM21465getCropAe3V0ko = data.getImageType() == ImageType.Image ? ContentScale.INSTANCE.m21465getCropAe3V0ko() : ContentScale.INSTANCE.m21467getFitAe3V0ko();
                ImageData imageData2 = data;
                boolean enabled = imageData2 instanceof ImageButtonData ? ((ImageButtonData) imageData2).getEnabled() : true;
                GlanceModifier glanceModifierMaybeAnimation = GlanceModifierUtilsKt.maybeAnimation(GlanceModifierUtilsKt.contentDescription(glanceModifier3, data.getContentDescription()), data.getAnimation());
                composer2.startReplaceableGroup(528181863);
                if (i != 0 || colorProvider == null || data.getImageType() == ImageType.AppIcon) {
                    colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                } else if (zM21578equalsimpl0) {
                    colorProviderM22055ColorProvider8_81llA = colorProvider;
                } else {
                    composer2.startReplaceableGroup(528182208);
                    boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4()) > 0;
                    composer2.endReplaceableGroup();
                    if (z) {
                        composer2.startReplaceableGroup(528182254);
                        colorProviderM22055ColorProvider8_81llA = GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getSurface();
                        composer2.endReplaceableGroup();
                    } else {
                        colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                    }
                }
                composer2.endReplaceableGroup();
                androidx.glance.appwidget.ImageButtonKt.m21297ImageButtonaCxP0qg(imageProvider, contentDescription, onClick, AppWidgetModifiersKt.keepColor(BackgroundKt.background(glanceModifierMaybeAnimation, colorProviderM22055ColorProvider8_81llA), data.getKeepColor()), enabled, iM21465getCropAe3V0ko, colorFilter, composer2, (ColorFilter.$stable << 18) | 520, 0);
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
            final int i5 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.ImageButtonInternal.2
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
                    ImageButtonKt.ImageButtonInternal(data, colorProvider, i, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    @Composable
    private static final GlanceModifier withSizeAndPadding(GlanceModifier glanceModifier, ImageData imageData, @DimenRes int i, @DimenRes int i2, Composer composer, int i4) {
        composer.startReplaceableGroup(2141090407);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2141090407, i4, -1, "androidx.glance.oneui.template.component.glance.withSizeAndPadding (ImageButton.kt:136)");
        }
        GlanceModifier glanceModifierFillMaxSize = i == 0 ? SizeModifiersKt.fillMaxSize(glanceModifier) : SizeModifiersKt.size(glanceModifier, i);
        if (imageData.getImageType() != ImageType.AppIcon) {
            glanceModifierFillMaxSize = CornerRadiusKt.cornerRadius(glanceModifierFillMaxSize, i);
        }
        GlanceModifier glanceModifierPadding = imageData.getImageType() == ImageType.Icon ? PaddingKt.padding(glanceModifierFillMaxSize, i2) : PaddingKt.m21496padding3ABfNKs(glanceModifierFillMaxSize, C2256Dp.m20968constructorimpl(0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierPadding;
    }

    @Composable
    /* JADX INFO: renamed from: withSizeAndPadding-T43hY1o, reason: not valid java name */
    private static final GlanceModifier m21743withSizeAndPaddingT43hY1o(GlanceModifier glanceModifier, ImageData imageData, float f, float f4, Composer composer, int i) {
        composer.startReplaceableGroup(-944445907);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-944445907, i, -1, "androidx.glance.oneui.template.component.glance.withSizeAndPadding (ImageButton.kt:62)");
        }
        float f5 = 0;
        GlanceModifier glanceModifierFillMaxSize = C2256Dp.m20973equalsimpl0(f, C2256Dp.m20968constructorimpl(f5)) ? SizeModifiersKt.fillMaxSize(glanceModifier) : SizeModifiersKt.m21506size3ABfNKs(glanceModifier, f);
        if (imageData.getImageType() != ImageType.AppIcon) {
            glanceModifierFillMaxSize = CornerRadiusKt.m21286cornerRadius3ABfNKs(glanceModifierFillMaxSize, f);
        }
        GlanceModifier glanceModifierM21496padding3ABfNKs = imageData.getImageType() == ImageType.Icon ? PaddingKt.m21496padding3ABfNKs(glanceModifierFillMaxSize, f4) : PaddingKt.m21496padding3ABfNKs(glanceModifierFillMaxSize, C2256Dp.m20968constructorimpl(f5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21496padding3ABfNKs;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: withSizeAndPadding-ZbchW5Y, reason: not valid java name */
    public static final GlanceModifier m21744withSizeAndPaddingZbchW5Y(@NotNull GlanceModifier withSizeAndPadding, @NotNull ImageData data, @PercentRange float f, @PercentRange float f4, int i, @Nullable Composer composer, int i2, int i4) {
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(withSizeAndPadding, "$this$withSizeAndPadding");
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceableGroup(1843090337);
        if ((i4 & 8) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1843090337, i2, -1, "androidx.glance.oneui.template.component.glance.withSizeAndPadding (ImageButton.kt:122)");
        }
        if (PercentSizePolicy.m21375equalsimpl0(i, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(-730337146);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-730337095);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
            composer.endReplaceableGroup();
        }
        float f5 = fM20968constructorimpl;
        GlanceModifier glanceModifierM21743withSizeAndPaddingT43hY1o = m21743withSizeAndPaddingT43hY1o(withSizeAndPadding, data, f5, C2256Dp.m20968constructorimpl(f4 * f5), composer, (i2 & 14) | 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21743withSizeAndPaddingT43hY1o;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceImageButton(@NotNull final ImageData data, @DimenRes final int i, @DimenRes final int i2, @DrawableRes final int i4, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1760857965);
        final GlanceModifier glanceModifier2 = (i6 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1760857965, i5, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:174)");
        }
        int i7 = i5 << 3;
        ImageButtonInternal(data, null, i4, withSizeAndPadding(glanceModifier2, data, i, i2, composerStartRestartGroup, ((i5 >> 12) & 14) | 64 | (i7 & 896) | (i7 & 7168)), composerStartRestartGroup, ((i5 >> 3) & 896) | 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.6
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
                    ImageButtonKt.GlanceImageButton(data, i, i2, i4, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceImageButton-o3XDK20, reason: not valid java name */
    public static final void m21741GlanceImageButtono3XDK20(@NotNull final ImageData data, final float f, final float f4, @DrawableRes final int i, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(272868557);
        final GlanceModifier glanceModifier2 = (i4 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(272868557, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:100)");
        }
        int i5 = i2 << 3;
        ImageButtonInternal(data, null, i, m21743withSizeAndPaddingT43hY1o(glanceModifier2, data, f, f4, composerStartRestartGroup, ((i2 >> 12) & 14) | 64 | (i5 & 896) | (i5 & 7168)), composerStartRestartGroup, ((i2 >> 3) & 896) | 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.3
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
                    ImageButtonKt.m21741GlanceImageButtono3XDK20(data, f, f4, i, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceImageButton(@NotNull final ImageWithBackgroundData data, @DimenRes final int i, @DimenRes final int i2, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2140628956);
        if ((i5 & 8) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2140628956, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:182)");
        }
        int i6 = i4 << 3;
        ImageButtonInternal(data, data.getBackgroundColor(), data.getBackgroundResId(), withSizeAndPadding(glanceModifier2, data, i, i2, composerStartRestartGroup, ((i4 >> 9) & 14) | 64 | (i6 & 896) | (i6 & 7168)), composerStartRestartGroup, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.7
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
                    ImageButtonKt.GlanceImageButton(data, i, i2, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceImageButton(@NotNull final ImageWithBackgroundData data, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-708685218);
        if ((i2 & 2) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-708685218, i, -1, "androidx.glance.oneui.template.component.glance.GlanceImageButton (ImageButton.kt:262)");
        }
        ImageButtonInternal(data, data.getBackgroundColor(), data.getBackgroundResId(), glanceModifier2, composerStartRestartGroup, ((i << 6) & 7168) | 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ImageButtonKt.GlanceImageButton.8
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
                    ImageButtonKt.GlanceImageButton(data, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
