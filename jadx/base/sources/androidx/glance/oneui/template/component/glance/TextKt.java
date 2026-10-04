package androidx.glance.oneui.template.component.glance;

import android.content.Context;
import androidx.annotation.DimenRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.util.FontUtils;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextCategory;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextStyle;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a<\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a<\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aF\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u001a\u001aP\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"GlanceAutoText", "", "modifier", "Landroidx/glance/GlanceModifier;", "textData", "Landroidx/glance/oneui/template/TextData;", "percentData", "Landroidx/glance/text/TextPercentData;", "fontWeight", "Landroidx/glance/text/FontWeight;", "textColor", "Landroidx/glance/unit/ColorProvider;", "GlanceAutoText-2T94tj4", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/TextData;Landroidx/glance/text/TextPercentData;ILandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "GlanceText", "GlanceText-2T94tj4", "textSize", "Landroidx/compose/ui/unit/Dp;", "GlanceText-FbLeKfk", "(Landroidx/glance/oneui/template/TextData;FILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/TextUnit;", "maxFontScale", "", "GlanceText-KuOwvYU", "(Landroidx/glance/oneui/template/TextData;JILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;FLandroidx/compose/runtime/Composer;II)V", "Landroidx/glance/oneui/template/layout/TextSize;", "(Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/layout/TextSize;Landroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "textSizeId", "", BilouCodec.UNIT, "Landroidx/glance/text/ComplexUnit;", "GlanceText-4QGO3ko", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/text/ComplexUnit;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;FLandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/glance/TextKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,244:1\n74#2:245\n74#2:246\n74#2:247\n74#2:251\n74#2:252\n74#2:253\n74#2:259\n74#2:260\n88#3:248\n88#3:249\n88#3:254\n88#3:255\n75#3:257\n92#3:258\n154#4:250\n154#4:256\n*S KotlinDebug\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/glance/TextKt\n*L\n43#1:245\n44#1:246\n49#1:247\n78#1:251\n79#1:252\n84#1:253\n174#1:259\n190#1:260\n50#1:248\n51#1:249\n85#1:254\n86#1:255\n106#1:257\n106#1:258\n53#1:250\n103#1:256\n*E\n"})
public final class TextKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceAutoText-2T94tj4, reason: not valid java name */
    public static final void m21749GlanceAutoText2T94tj4(@Nullable GlanceModifier glanceModifier, @NotNull final TextData textData, @NotNull final TextPercentData percentData, final int i, @NotNull final ColorProvider textColor, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        String text;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(percentData, "percentData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(921450962);
        GlanceModifier glanceModifier2 = (i4 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(921450962, i5, -1, "androidx.glance.oneui.template.component.glance.GlanceAutoText (Text.kt:41)");
        } else {
            i5 = i2;
        }
        Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
        ((Boolean) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).getClass();
        if (textData.getTextResId() != 0) {
            text = context.getResources().getString(textData.getTextResId());
        } else {
            text = textData.getText();
            if (text == null) {
                text = "";
            }
        }
        String str = text;
        Intrinsics.checkNotNull(str);
        long packedValue = ((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(percentData.getWidthPercent() * DpSize.m21066getWidthD9Ej5fM(packedValue));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(percentData.getHeightPercent() * DpSize.m21064getHeightD9Ej5fM(packedValue));
        float f = 0;
        GlanceText(textData, new TextSize(C2256Dp.m20973equalsimpl0(fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f)) ? C2256Dp.m20968constructorimpl(f) : FontUtils.m21405autoTextSizeByDpYusz2Y$default(FontUtils.INSTANCE, context, str, fM20968constructorimpl, fM20968constructorimpl2, 1.0f, percentData.getMaxSize(), null, 0, false, 0, 960, null), ComplexUnit.f1613DP, i, 0.0f, 8, (DefaultConstructorMarker) null), textColor, null, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt$GlanceAutoText$1
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
                    TextKt.m21749GlanceAutoText2T94tj4(glanceModifier3, textData, percentData, i, textColor, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceText(@NotNull final TextData textData, @NotNull final TextSize textSize, @NotNull final ColorProvider textColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textSize, "textSize");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1484664416);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(1484664416, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceText (Text.kt:185)");
        } else {
            i4 = i;
        }
        composerStartRestartGroup.startReplaceableGroup(668459642);
        ColorProvider onPrimary = (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) || textData.getKeepColor()) ? textColor : GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimary();
        composerStartRestartGroup.endReplaceableGroup();
        long sp = TextUnitKt.getSp(textSize.getSize());
        int fontWeight = textSize.getFontWeight();
        FontFamily fontFamily = textData.getFontFamily();
        int textAlign = textData.getTextAlign();
        TextStyle textStyle = new TextStyle(onPrimary, TextUnit.m21151boximpl(sp), FontWeight.m21989boximpl(fontWeight), null, TextAlign.m22000boximpl(textAlign), textData.getTextDecoration(), fontFamily, textData.getTextDirection(), textData.getHasShadow(), null, textSize.getUnit(), textSize.getSizeResId(), textSize.getPercentData(), TextVerticalAlign.m22045boximpl(textData.getTextVerticalAlign()), textData.getTextAppearanceResource(), 520, null);
        float maxFontScale = textSize.getUnit() == ComplexUnit.f1613DP ? 0.0f : textSize.getMaxFontScale();
        GlanceModifier glanceModifierKeepColor = AppWidgetModifiersKt.keepColor(AppWidgetModifiersKt.alpha(GlanceModifierUtilsKt.maybeAnimation(GlanceModifierUtilsKt.contentDescription(glanceModifier2, textData.getContentDescription()), textData.getAnimation()), textData.getEnabled() ? 1.0f : 0.6f), textData.getKeepColor());
        if (textData.getTextResId() != 0) {
            composerStartRestartGroup.startReplaceableGroup(668461076);
            androidx.glance.text.TextKt.Text(textData.getTextResId(), glanceModifierKeepColor, textStyle, textData.getMaxLines(), maxFontScale, composerStartRestartGroup, 0, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (textData.getText() != null) {
            composerStartRestartGroup.startReplaceableGroup(668461417);
            androidx.glance.text.TextKt.Text(textData.getText(), glanceModifierKeepColor, textStyle, textData.getMaxLines(), maxFontScale, composerStartRestartGroup, 0, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(668461715);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final int i5 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt.GlanceText.5
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
                    TextKt.GlanceText(textData, textSize, textColor, glanceModifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceText-2T94tj4, reason: not valid java name */
    public static final void m21750GlanceText2T94tj4(@Nullable GlanceModifier glanceModifier, @NotNull final TextData textData, @NotNull final TextPercentData percentData, final int i, @NotNull final ColorProvider textColor, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        String text;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(percentData, "percentData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772626433);
        GlanceModifier glanceModifier2 = (i4 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(1772626433, i5, -1, "androidx.glance.oneui.template.component.glance.GlanceText (Text.kt:76)");
        } else {
            i5 = i2;
        }
        Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
        ((Boolean) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).getClass();
        if (textData.getTextResId() != 0) {
            text = context.getResources().getString(textData.getTextResId());
        } else {
            text = textData.getText();
            if (text == null) {
                text = "";
            }
        }
        String str = text;
        Intrinsics.checkNotNull(str);
        long packedValue = ((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(percentData.getWidthPercent() * DpSize.m21066getWidthD9Ej5fM(packedValue));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(percentData.getHeightPercent() * DpSize.m21064getHeightD9Ej5fM(packedValue));
        TextCategory textCategory = percentData.getTextCategory();
        float f = 0;
        GlanceText(textData, new TextSize(C2256Dp.m20973equalsimpl0(fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f)) ? C2256Dp.m20968constructorimpl(f) : FontUtils.INSTANCE.m21409autoTextSizeAndLineCountByDpgjw_jeY(context, str, fM20968constructorimpl, fM20968constructorimpl2, 1.0f, textCategory != null ? textCategory.getMaxSize() : percentData.getMaxSize(), textData.getFontFamily(), i, percentData.getAutoResize(), textData.getMaxLines()).getFirst().m20982unboximpl(), ComplexUnit.f1613DP, i, 0.0f, percentData.getAutoResize() ? percentData : null, 8, (DefaultConstructorMarker) null), textColor, (!percentData.getAutoResize() || percentData.getWidthPercent() >= 1.0f) ? percentData.getAutoResize() ? SizeModifiersKt.m21505height3ABfNKs(glanceModifier2, fM20968constructorimpl2) : SizeModifiersKt.wrapContentSize(glanceModifier2) : SizeModifiersKt.m21508width3ABfNKs(SizeModifiersKt.m21505height3ABfNKs(glanceModifier2, percentData.getWidthPercent() < 1.0f ? C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM20968constructorimpl2 / textData.getMaxLines()) * r0.getSecond().intValue()) : fM20968constructorimpl2), fM20968constructorimpl), composerStartRestartGroup, (TextPercentData.$stable << 3) | 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt.GlanceText.1
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
                    TextKt.m21750GlanceText2T94tj4(glanceModifier3, textData, percentData, i, textColor, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceText-4QGO3ko, reason: not valid java name */
    public static final void m21751GlanceText4QGO3ko(@NotNull final TextData textData, @DimenRes final int i, @NotNull final ComplexUnit unit, final int i2, @NotNull final ColorProvider textColor, @Nullable GlanceModifier glanceModifier, float f, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(2030188834);
        GlanceModifier glanceModifier2 = (i5 & 32) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        float f4 = (i5 & 64) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030188834, i4, -1, "androidx.glance.oneui.template.component.glance.GlanceText (Text.kt:170)");
        }
        final float f5 = f4;
        final GlanceModifier glanceModifier3 = glanceModifier2;
        GlanceText(textData, new TextSize((Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext()), i, unit, i2, f5, (DefaultConstructorMarker) null), textColor, glanceModifier3, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i4 >> 6) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt.GlanceText.4
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
                    TextKt.m21751GlanceText4QGO3ko(textData, i, unit, i2, textColor, glanceModifier3, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceText-FbLeKfk, reason: not valid java name */
    public static final void m21752GlanceTextFbLeKfk(@NotNull final TextData textData, final float f, final int i, @NotNull final ColorProvider textColor, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1548649249);
        GlanceModifier glanceModifier2 = (i4 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1548649249, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceText (Text.kt:135)");
        }
        GlanceText(textData, new TextSize(f, ComplexUnit.f1613DP, i, 0.0f, 8, (DefaultConstructorMarker) null), textColor, glanceModifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 >> 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt.GlanceText.2
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
                    TextKt.m21752GlanceTextFbLeKfk(textData, f, i, textColor, glanceModifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceText-KuOwvYU, reason: not valid java name */
    public static final void m21753GlanceTextKuOwvYU(@NotNull final TextData textData, final long j, final int i, @NotNull final ColorProvider textColor, @Nullable GlanceModifier glanceModifier, float f, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1465993804);
        GlanceModifier glanceModifier2 = (i4 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        float f4 = (i4 & 32) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1465993804, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceText (Text.kt:152)");
        }
        final float f5 = f4;
        final GlanceModifier glanceModifier3 = glanceModifier2;
        GlanceText(textData, new TextSize(TextUnit.m21161getValueimpl(j), ComplexUnit.f1614SP, i, f5, (DefaultConstructorMarker) null), textColor, glanceModifier3, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 >> 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.TextKt.GlanceText.3
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
                    TextKt.m21753GlanceTextKuOwvYU(textData, j, i, textColor, glanceModifier3, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
