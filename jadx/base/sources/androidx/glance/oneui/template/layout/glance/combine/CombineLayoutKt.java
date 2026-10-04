package androidx.glance.oneui.template.layout.glance.combine;

import android.content.Context;
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
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.action.ActionKt;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.component.TextKt;
import androidx.glance.oneui.template.component.glance.ImageKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\\\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001ai\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001d2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001d2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aq\u0010\u0016\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001d2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001d2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aL\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020'2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a'\u0010*\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\u0010/\u001a\u001d\u00100\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, m13886d2 = {"CombineAutoText", "", "modifier", "Landroidx/glance/GlanceModifier;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "textData", "Landroidx/glance/oneui/template/TextData;", "type", "Landroidx/glance/oneui/template/TextType;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "viewWidth", "", "viewHeight", "CombineAutoText-BnzNfJc", "(Landroidx/glance/GlanceModifier;ILandroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "CombineText", "fontWeight", "Landroidx/glance/text/FontWeight;", "CombineText-57gRyVA", "(Landroidx/glance/GlanceModifier;ILandroidx/glance/oneui/template/TextData;IILandroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "GlanceCombineLayout", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "GlanceCombineLayout-wXoZbBE", "(IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "data", "Landroidx/glance/oneui/template/CombineData;", "GlanceCombineLayout-Vekbxm4", "(Landroidx/glance/oneui/template/CombineData;IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "GlanceCombineText", "Landroidx/glance/oneui/template/TypedTextData;", "GlanceCombineText-IxUqPG8", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/GlanceModifier;ILandroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "MultiSpacer", "count", "", "isVertical", "", "(Landroidx/glance/GlanceModifier;IZLandroidx/compose/runtime/Composer;II)V", "PrimaryButtonContent", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/CombineLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,418:1\n74#2:419\n74#2:420\n74#2:423\n74#2:427\n74#2:428\n74#2:429\n74#2:430\n174#3:421\n154#3:422\n154#3:424\n154#3:425\n1#4:426\n*S KotlinDebug\n*F\n+ 1 CombineLayout.kt\nandroidx/glance/oneui/template/layout/glance/combine/CombineLayoutKt\n*L\n62#1:419\n77#1:420\n132#1:423\n409#1:427\n208#1:428\n209#1:429\n210#1:430\n79#1:421\n89#1:422\n143#1:424\n152#1:425\n*E\n"})
public final class CombineLayoutKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: CombineAutoText-BnzNfJc, reason: not valid java name */
    public static final void m21860CombineAutoTextBnzNfJc(@Nullable GlanceModifier glanceModifier, final int i, @NotNull final TextData textData, final int i2, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i4, final int i5) {
        ColorProvider onBackground;
        int i6;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(1854726345);
        final GlanceModifier glanceModifier2 = (i5 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if ((i5 & 16) != 0) {
            onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            i6 = i4 & (-57345);
        } else {
            onBackground = colorProvider;
            i6 = i4;
        }
        float f5 = (i5 & 32) != 0 ? 0.0f : f;
        float f6 = (i5 & 64) != 0 ? 0.0f : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1854726345, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.CombineAutoText (CombineLayout.kt:368)");
        }
        if (textData.getMaxLines() >= 2) {
            String text = textData.getText();
            textData.setMaxLines$glance_oneui_template_release((text != null ? text.length() : 0) <= 8 ? 1 : 2);
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        final int iM21998getNormalWjrlUT0 = TextType.m21684equalsimpl0(i2, TextType.INSTANCE.m21689getBodygxbDmow()) ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
        final float fM21939getTextViewHeightPercenttZlUyYw = f6 == 0.0f ? CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i, i2, textData.getMaxLines()) : f6;
        Debug.INSTANCE.debugBox(SizeModifiersKt.wrapContentSize(glanceModifier2), Alignment.INSTANCE.getCenterStart(), "Combine5", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 45103360, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$CombineAutoText$1
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
                    ComposerKt.traceEventStart(45103360, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.CombineAutoText.<anonymous> (CombineLayout.kt:385)");
                }
                TextKt.m21707AutoTemplateTextRbqdM5c(textData, new TextPercentData(0.0f, 0.0f, 0.0f, fM21939getTextViewHeightPercenttZlUyYw, TextType.m21682covertToCategoryimpl(i2), false, 39, null), iM21998getNormalWjrlUT0, composer2, (TextPercentData.$stable << 3) | 8);
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
            final ColorProvider colorProvider2 = onBackground;
            final float f7 = f5;
            final float f8 = f6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$CombineAutoText$2
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
                    CombineLayoutKt.m21860CombineAutoTextBnzNfJc(glanceModifier2, i, textData, i2, colorProvider2, f7, f8, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: CombineText-57gRyVA, reason: not valid java name */
    public static final void m21861CombineText57gRyVA(@Nullable GlanceModifier glanceModifier, final int i, @NotNull final TextData textData, final int i2, int i4, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i5, final int i6) {
        final int iM21999getSemiBoldWjrlUT0;
        int i7;
        final ColorProvider onBackground;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1319134771);
        GlanceModifier glanceModifier2 = (i6 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if ((i6 & 16) != 0) {
            i7 = i5 & (-57345);
            iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
        } else {
            iM21999getSemiBoldWjrlUT0 = i4;
            i7 = i5;
        }
        if ((i6 & 32) != 0) {
            i7 &= -458753;
            onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        } else {
            onBackground = colorProvider;
        }
        float f5 = (i6 & 64) != 0 ? 0.0f : f;
        float f6 = (i6 & 128) != 0 ? 0.0f : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1319134771, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.CombineText (CombineLayout.kt:313)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (!TextType.m21684equalsimpl0(i2, companion.m21694getTitlegxbDmow())) {
            textData.setMaxLines$glance_oneui_template_release(1);
        } else if (textData.getMaxLines() >= 2) {
            textData.setMaxLines$glance_oneui_template_release(2);
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        float fM21939getTextViewHeightPercenttZlUyYw = f6 == 0.0f ? CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i, i2, textData.getMaxLines()) : f6;
        final TextPercentData textPercentData = (AppWidgetSize.m21550equalsimpl0(i, AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4()) && TextType.m21684equalsimpl0(i2, companion.m21693getLabelgxbDmow())) ? new TextPercentData(0.0f, TextType.m21682covertToCategoryimpl(i2).getMaxSize(), 0.0f, fM21939getTextViewHeightPercenttZlUyYw, null, false, 21, null) : new TextPercentData(0.0f, 0.0f, 0.0f, fM21939getTextViewHeightPercenttZlUyYw, TextType.m21682covertToCategoryimpl(i2), false, 7, null);
        final float f7 = f5;
        final int i8 = iM21999getSemiBoldWjrlUT0;
        Debug.INSTANCE.debugBox(SizeModifiersKt.wrapContentSize(glanceModifier2), Alignment.INSTANCE.getCenterStart(), "Combine4", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2024400310, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$CombineText$1
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
            public final void invoke(@Nullable Composer composer2, int i9) {
                if ((i9 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2024400310, i9, -1, "androidx.glance.oneui.template.layout.glance.combine.CombineText.<anonymous> (CombineLayout.kt:347)");
                }
                composer2.startReplaceableGroup(-1784844741);
                float f8 = f7;
                GlanceModifier glanceModifierFillMaxWidth = f8 == 0.0f ? SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE) : androidx.glance.appwidget.percent.SizeModifiersKt.width(GlanceModifier.INSTANCE, f8, composer2, 6);
                composer2.endReplaceableGroup();
                ColorProvider textColor = textData.getTextColor();
                if (textColor == null) {
                    textColor = onBackground;
                }
                androidx.glance.oneui.template.component.glance.TextKt.m21750GlanceText2T94tj4(glanceModifierFillMaxWidth, textData, textPercentData, iM21999getSemiBoldWjrlUT0, textColor, composer2, (TextPercentData.$stable << 6) | 32832, 0);
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
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final float f8 = f6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$CombineText$2
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
                    CombineLayoutKt.m21861CombineText57gRyVA(glanceModifier3, i, textData, i2, i8, onBackground, f7, f8, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: GlanceCombineLayout-Vekbxm4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21862GlanceCombineLayoutVekbxm4(@NotNull final CombineData data, int i, final int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        int iM21429getBottommnfRV0w;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(680920811);
        if ((i5 & 2) != 0) {
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
            i6 = i4 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
        } else {
            iM21429getBottommnfRV0w = i;
            i6 = i4;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 8) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 16) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i5 & 32) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(680920811, i6, -1, "androidx.glance.oneui.template.layout.glance.combine.GlanceCombineLayout (CombineLayout.kt:60)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1027627421);
            TinyLayoutKt.TinyLayout(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), data.getPrimaryContentData(), data.getSecondaryContentData(), function26, composerStartRestartGroup, (i6 & 7168) | Units.MASTER_DPI, 0);
            composerStartRestartGroup.endReplaceableGroup();
            function25 = function26;
            function24 = function27;
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1027627711);
            Function2<? super Composer, ? super Integer, Unit> function29 = function27;
            SmallLayoutKt.SmallLayout(PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat((Context) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalContext()), C3094R.dimen.sesl_glance_combine_layout_start_padding)), 0.0f, 2, null), data.getPrimaryContentData(), data.getSecondaryContentData(), function26, function29, composerStartRestartGroup, (i6 & 7168) | Units.MASTER_DPI | (i6 & 57344), 0);
            function24 = function29;
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
            function25 = function26;
        } else {
            function24 = function27;
            if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                    composerStartRestartGroup.startReplaceableGroup(1027628853);
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    PrimaryContentData primaryContentData = data.getPrimaryContentData();
                    SecondaryContentData secondaryContentData = data.getSecondaryContentData();
                    int i8 = ((i6 << 6) & 7168) | Units.MASTER_DPI;
                    int i9 = i6 << 3;
                    Function2<? super Composer, ? super Integer, Unit> function211 = function26;
                    i7 = iM21429getBottommnfRV0w;
                    MediumLayoutKt.m21867MediumLayoutfWZZ6NI(glanceModifierFillMaxSize, primaryContentData, secondaryContentData, i7, function211, function24, composerStartRestartGroup, i8 | (i9 & 57344) | (i9 & 458752), 0);
                    function25 = function211;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    function28 = function210;
                } else {
                    function25 = function26;
                    int i10 = iM21429getBottommnfRV0w;
                    composerStartRestartGroup.startReplaceableGroup(1027629234);
                    int i11 = i6 << 9;
                    function28 = function210;
                    LargeLayoutKt.m21866LargeLayoutTafRHR0(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), data.getPrimaryContentData(), data.getSecondaryContentData(), data.getTertiaryContentData(), i10, i2, function25, function24, function28, composerStartRestartGroup, (i11 & 234881024) | (i11 & 57344) | 4672 | (i11 & 458752) | (i11 & 3670016) | (29360128 & i11), 0);
                    i7 = i10;
                    function24 = function24;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    final int i12 = i7;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
                    final Function2<? super Composer, ? super Integer, Unit> function214 = function28;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$GlanceCombineLayout$1
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

                        public final void invoke(@Nullable Composer composer2, int i13) {
                            CombineLayoutKt.m21862GlanceCombineLayoutVekbxm4(data, i12, i2, function213, function212, function214, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.startReplaceableGroup(1027628369);
            Function2<? super Composer, ? super Integer, Unit> function215 = function26;
            int i13 = i6 << 3;
            Function2<? super Composer, ? super Integer, Unit> function216 = function28;
            WideSmallLayoutKt.WideSmallLayout(PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), data.getPrimaryContentData(), data.getSecondaryContentData(), data.getTertiaryContentData(), function215, function24, function216, composerStartRestartGroup, (i13 & 3670016) | (i13 & 57344) | 4672 | (i13 & 458752), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
            function25 = function215;
            function28 = function216;
        }
        i7 = iM21429getBottommnfRV0w;
        if (ComposerKt.isTraceInProgress()) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0129  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: GlanceCombineLayout-wXoZbBE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21863GlanceCombineLayoutwXoZbBE(int i, final int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        final int iM21429getBottommnfRV0w;
        int i6;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int mask;
        AppWidgetSize.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-985795730);
        if ((i4 & 14) == 0) {
            if ((i5 & 1) == 0) {
                iM21429getBottommnfRV0w = i;
                if (composerStartRestartGroup.changed(iM21429getBottommnfRV0w)) {
                    i11 = 4;
                }
                i6 = i11 | i4;
            } else {
                iM21429getBottommnfRV0w = i;
            }
            i11 = 2;
            i6 = i11 | i4;
        } else {
            iM21429getBottommnfRV0w = i;
            i6 = i4;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 112) == 0) {
                i7 = i2;
                i6 |= composerStartRestartGroup.changed(i7) ? 32 : 16;
            }
            i8 = i5 & 4;
            if (i8 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 896) == 0) {
                    function24 = function2;
                    i6 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i9 = i5 & 8;
                if (i9 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 7168) == 0) {
                        function25 = function22;
                        i6 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    i10 = i5 & 16;
                    if (i10 != 0) {
                        if ((i4 & 57344) == 0) {
                            function26 = function23;
                            i6 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                        }
                        if ((46811 & i6) == 9362 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function214 = function24;
                            function213 = function25;
                            function212 = function26;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if ((i5 & 1) != 0) {
                                    iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                                    i6 &= -15;
                                }
                                if (i8 != 0) {
                                    function24 = null;
                                }
                                if (i9 != 0) {
                                    function25 = null;
                                }
                                if (i10 == 0) {
                                    function27 = function24;
                                    function28 = null;
                                }
                                int i12 = i6;
                                Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-985795730, i12, -1, "androidx.glance.oneui.template.layout.glance.combine.GlanceCombineLayout (CombineLayout.kt:130)");
                                }
                                mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
                                companion = AppWidgetSize.INSTANCE;
                                if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
                                    composerStartRestartGroup.startReplaceableGroup(1027630207);
                                    TinyLayoutKt.TinyLayout(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), null, null, function27, composerStartRestartGroup, ((i12 << 3) & 7168) | 432, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                    function29 = function28;
                                } else {
                                    if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
                                        composerStartRestartGroup.startReplaceableGroup(1027630457);
                                        int i13 = i12 << 3;
                                        SmallLayoutKt.SmallLayout(PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), null, null, function27, function215, composerStartRestartGroup, (i13 & 7168) | 432 | (i13 & 57344), 0);
                                        function211 = function215;
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceableGroup();
                                        function29 = function28;
                                    } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                                        composerStartRestartGroup.startReplaceableGroup(1027630792);
                                        int i14 = i12 << 6;
                                        Function2<? super Composer, ? super Integer, Unit> function216 = function27;
                                        Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                        WideSmallLayoutKt.WideSmallLayout(PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), null, null, null, function216, function215, function217, composerStartRestartGroup, (i14 & 57344) | 3504 | (i14 & 458752) | (i14 & 3670016), 0);
                                        function27 = function216;
                                        function211 = function215;
                                        function29 = function217;
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceableGroup();
                                    } else {
                                        function29 = function28;
                                        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                                            composerStartRestartGroup.startReplaceableGroup(1027631216);
                                            int i15 = i12 << 6;
                                            Function2<? super Composer, ? super Integer, Unit> function218 = function27;
                                            MediumLayoutKt.m21867MediumLayoutfWZZ6NI(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), null, null, 0, function218, function215, composerStartRestartGroup, (i15 & 57344) | 432 | (i15 & 458752), 8);
                                            function210 = function218;
                                            function215 = function215;
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            composerStartRestartGroup.endReplaceableGroup();
                                        } else {
                                            function215 = function215;
                                            function210 = function27;
                                            composerStartRestartGroup.startReplaceableGroup(1027631494);
                                            int i16 = i12 << 12;
                                            LargeLayoutKt.m21866LargeLayoutTafRHR0(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), null, null, null, iM21429getBottommnfRV0w, i7, null, null, null, composerStartRestartGroup, (i16 & 57344) | 3504 | (i16 & 458752), 448);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            composerStartRestartGroup.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function212 = function29;
                                        function213 = function215;
                                        function214 = function210;
                                    }
                                    function215 = function211;
                                }
                                function210 = function27;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function212 = function29;
                                function213 = function215;
                                function214 = function210;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 1) != 0) {
                                    i6 &= -15;
                                }
                            }
                            function27 = function24;
                            function28 = function26;
                            int i122 = i6;
                            Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
                            companion = AppWidgetSize.INSTANCE;
                            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
                            }
                            function210 = function27;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function212 = function29;
                            function213 = function2152;
                            function214 = function210;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$GlanceCombineLayout$2
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

                                public final void invoke(@Nullable Composer composer2, int i17) {
                                    CombineLayoutKt.m21863GlanceCombineLayoutwXoZbBE(iM21429getBottommnfRV0w, i2, function214, function213, function212, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    function26 = function23;
                    if ((46811 & i6) == 9362) {
                        composerStartRestartGroup.startDefaults();
                        if ((i4 & 1) != 0) {
                            if ((i5 & 1) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 == 0) {
                                function27 = function24;
                                function28 = function26;
                            }
                            int i1222 = i6;
                            Function2<? super Composer, ? super Integer, Unit> function21522 = function25;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
                            companion = AppWidgetSize.INSTANCE;
                            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
                            }
                            function210 = function27;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function212 = function29;
                            function213 = function21522;
                            function214 = function210;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                i10 = i5 & 16;
                if (i10 != 0) {
                }
                function26 = function23;
                if ((46811 & i6) == 9362) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function24 = function2;
            i9 = i5 & 8;
            if (i9 != 0) {
            }
            function25 = function22;
            i10 = i5 & 16;
            if (i10 != 0) {
            }
            function26 = function23;
            if ((46811 & i6) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i7 = i2;
        i8 = i5 & 4;
        if (i8 == 0) {
        }
        function24 = function2;
        i9 = i5 & 8;
        if (i9 != 0) {
        }
        function25 = function22;
        i10 = i5 & 16;
        if (i10 != 0) {
        }
        function26 = function23;
        if ((46811 & i6) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceCombineText-IxUqPG8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21864GlanceCombineTextIxUqPG8(@NotNull final TypedTextData textData, @Nullable GlanceModifier glanceModifier, int i, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        int i7;
        int i8;
        float f5;
        int i9;
        float f6;
        GlanceModifier glanceModifier3;
        int iM21999getSemiBoldWjrlUT0;
        ColorProvider onBackground;
        float f7;
        float f8;
        final GlanceModifier glanceModifier4;
        final int i10;
        final ColorProvider colorProvider2;
        final float f9;
        final float f10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(690119800);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i11 = i4 & 2;
        if (i11 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 32 : 16;
            }
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    i6 = i;
                    int i12 = composerStartRestartGroup.changed(i6) ? 256 : 128;
                    i5 |= i12;
                } else {
                    i6 = i;
                }
                i5 |= i12;
            } else {
                i6 = i;
            }
            i7 = i4 & 8;
            if (i7 != 0) {
                i5 |= 1024;
            }
            i8 = i4 & 16;
            if (i8 == 0) {
                i5 |= 24576;
            } else {
                if ((i2 & 57344) == 0) {
                    f5 = f;
                    i5 |= composerStartRestartGroup.changed(f5) ? 16384 : 8192;
                }
                i9 = i4 & 32;
                if (i9 == 0) {
                    if ((458752 & i2) == 0) {
                        f6 = f4;
                        i5 |= composerStartRestartGroup.changed(f6) ? 131072 : 65536;
                    }
                    if (i7 != 8 && (374491 & i5) == 74898 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        glanceModifier4 = glanceModifier2;
                        i10 = i6;
                        f9 = f5;
                        f10 = f6;
                        colorProvider2 = colorProvider;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            glanceModifier3 = i11 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                            if ((i4 & 4) == 0) {
                                iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
                                i5 &= -897;
                            } else {
                                iM21999getSemiBoldWjrlUT0 = i6;
                            }
                            if (i7 == 0) {
                                onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
                                i5 &= -7169;
                            } else {
                                onBackground = colorProvider;
                            }
                            if (i8 != 0) {
                                f5 = 0.0f;
                            }
                            if (i9 == 0) {
                                f8 = 0.0f;
                                f7 = f5;
                            } else {
                                f7 = f5;
                                f8 = f6;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if (i7 != 0) {
                                i5 &= -7169;
                            }
                            glanceModifier3 = glanceModifier2;
                            iM21999getSemiBoldWjrlUT0 = i6;
                            f7 = f5;
                            f8 = f6;
                            onBackground = colorProvider;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(690119800, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.GlanceCombineText (CombineLayout.kt:405)");
                        }
                        GlanceModifier glanceModifier5 = glanceModifier3;
                        int i13 = ((i5 >> 3) & 14) | 262144;
                        int i14 = i5 << 6;
                        m21861CombineText57gRyVA(glanceModifier5, ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), textData, textData.getTextType(), iM21999getSemiBoldWjrlUT0, onBackground, f7, f8, composerStartRestartGroup, (57344 & i14) | i13 | (i14 & 896) | (3670016 & i14) | (i14 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        glanceModifier4 = glanceModifier5;
                        i10 = iM21999getSemiBoldWjrlUT0;
                        colorProvider2 = onBackground;
                        f9 = f7;
                        f10 = f8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$GlanceCombineText$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i15) {
                                CombineLayoutKt.m21864GlanceCombineTextIxUqPG8(textData, glanceModifier4, i10, colorProvider2, f9, f10, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 196608;
                f6 = f4;
                if (i7 != 8) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i11 == 0) {
                        }
                        if ((i4 & 4) == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        GlanceModifier glanceModifier52 = glanceModifier3;
                        int i132 = ((i5 >> 3) & 14) | 262144;
                        int i142 = i5 << 6;
                        m21861CombineText57gRyVA(glanceModifier52, ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), textData, textData.getTextType(), iM21999getSemiBoldWjrlUT0, onBackground, f7, f8, composerStartRestartGroup, (57344 & i142) | i132 | (i142 & 896) | (3670016 & i142) | (i142 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        glanceModifier4 = glanceModifier52;
                        i10 = iM21999getSemiBoldWjrlUT0;
                        colorProvider2 = onBackground;
                        f9 = f7;
                        f10 = f8;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f5 = f;
            i9 = i4 & 32;
            if (i9 == 0) {
            }
            f6 = f4;
            if (i7 != 8) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        glanceModifier2 = glanceModifier;
        if ((i2 & 896) != 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        f5 = f;
        i9 = i4 & 32;
        if (i9 == 0) {
        }
        f6 = f4;
        if (i7 != 8) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Composable
    public static final void MultiSpacer(@Nullable GlanceModifier glanceModifier, final int i, final boolean z, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        final GlanceModifier glanceModifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2066572852);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i5 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            glanceModifier2 = glanceModifier;
        } else {
            if (i6 != 0) {
                glanceModifier = GlanceModifier.INSTANCE;
            }
            GlanceModifier glanceModifier3 = glanceModifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2066572852, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.MultiSpacer (CombineLayout.kt:187)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-944198483);
                ColumnKt.m21455ColumnK4GKKTE(glanceModifier3, 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 731849627, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.MultiSpacer.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(731849627, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.MultiSpacer.<anonymous> (CombineLayout.kt:190)");
                        }
                        Iterator<Integer> it = RangesKt.until(0, i).iterator();
                        while (it.hasNext()) {
                            ((IntIterator) it).nextInt();
                            SpacerKt.Spacer(Column.defaultWeight(GlanceModifier.INSTANCE), composer2, 0, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (i5 & 14) | 3072, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-944198343);
                RowKt.m21502RowlMAjyxE(glanceModifier3, 0, 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1430526012, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.MultiSpacer.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1430526012, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.MultiSpacer.<anonymous> (CombineLayout.kt:194)");
                        }
                        Iterator<Integer> it = RangesKt.until(0, i).iterator();
                        while (it.hasNext()) {
                            ((IntIterator) it).nextInt();
                            SpacerKt.Spacer(Row.defaultWeight(GlanceModifier.INSTANCE), composer2, 0, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (i5 & 14) | 3072, 6);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            glanceModifier2 = glanceModifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.MultiSpacer.3
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
                    CombineLayoutKt.MultiSpacer(glanceModifier2, i, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void PrimaryButtonContent(@NotNull final GlanceModifier modifier, @NotNull final PrimaryContentData primaryData, @Nullable Composer composer, final int i) {
        Composer composer2;
        final GlanceModifier glanceModifier;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(primaryData, "primaryData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-607783586);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-607783586, i, -1, "androidx.glance.oneui.template.layout.glance.combine.PrimaryButtonContent (CombineLayout.kt:200)");
        }
        if (primaryData.getImage() != null) {
            composerStartRestartGroup.startReplaceableGroup(-1067950122);
            if (primaryData.getImage() instanceof ImageButtonData) {
                composerStartRestartGroup.startReplaceableGroup(-1067950070);
                composerStartRestartGroup.startReplaceableGroup(-1067949935);
                ImageButtonData imageButtonData = (ImageButtonData) primaryData.getImage();
                if (imageButtonData.getBackgroundColor() == null) {
                    imageButtonData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                PrimaryButtonContent$SingleButtonIcon(modifier, imageButtonData, composerStartRestartGroup, (i & 14) | 64);
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1067949716);
                composer2 = composerStartRestartGroup;
                Debug.INSTANCE.debugBox(null, null, "Combine3", true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -449957770, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.PrimaryButtonContent.2
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
                    public final void invoke(@Nullable Composer composer3, int i2) {
                        if ((i2 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-449957770, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.PrimaryButtonContent.<anonymous> (CombineLayout.kt:295)");
                        }
                        ImageKt.m21746GlanceImagecuCYCYk(primaryData.getImage(), modifier, 0, composer3, 8, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 224640, 3);
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            glanceModifier = modifier;
        } else {
            composer2 = composerStartRestartGroup;
            if (primaryData.getProgressIndicator() != null) {
                composer2.startReplaceableGroup(-1067949501);
                glanceModifier = modifier;
                ProgressIndicatorKt.GlanceCircularProgressIndicator(glanceModifier, primaryData.getProgressIndicator(), 0, null, composer2, (i & 14) | 64, 12);
                composer2 = composer2;
                composer2.endReplaceableGroup();
            } else {
                glanceModifier = modifier;
                composer2.startReplaceableGroup(-1067949395);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.PrimaryButtonContent.3
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
                    CombineLayoutKt.PrimaryButtonContent(glanceModifier, primaryData, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void PrimaryButtonContent$SingleButtonIcon(final GlanceModifier glanceModifier, final ImageButtonData imageButtonData, Composer composer, int i) {
        composer.startReplaceableGroup(-1646536515);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1646536515, i, -1, "androidx.glance.oneui.template.layout.glance.combine.PrimaryButtonContent.SingleButtonIcon (CombineLayout.kt:203)");
        }
        final int backgroundResId = imageButtonData.getBackgroundResId();
        final ColorProvider backgroundColor = imageButtonData.getBackgroundColor();
        final ImageType imageType = imageButtonData.getImageType();
        final boolean zM21578equalsimpl0 = AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM());
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Context context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
        final Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
        final float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, mask);
        Debug.INSTANCE.debugBox(glanceModifier, null, "Combine1", false, ComposableLambdaKt.composableLambda(composer, -1077202266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$PrimaryButtonContent$SingleButtonIcon$1
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
                ColorProvider colorProviderM22055ColorProvider8_81llA;
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1077202266, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.PrimaryButtonContent.SingleButtonIcon.<anonymous> (CombineLayout.kt:214)");
                }
                composer2.startReplaceableGroup(1029850217);
                int i4 = backgroundResId;
                if (i4 != 0) {
                    androidx.glance.ImageKt.m21259ImageGCr5PR4(androidx.glance.ImageKt.ImageProvider(i4), "BackgroundImage", glanceModifier, 0, null, composer2, 56, 24);
                }
                composer2.endReplaceableGroup();
                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                composer2.startReplaceableGroup(1029850568);
                if (backgroundResId != 0 || (colorProviderM22055ColorProvider8_81llA = backgroundColor) == null || imageType == ImageType.AppIcon) {
                    colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                } else if (!zM21578equalsimpl0) {
                    composer2.startReplaceableGroup(1029850908);
                    boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4()) > 0;
                    composer2.endReplaceableGroup();
                    if (z) {
                        composer2.startReplaceableGroup(1029850954);
                        colorProviderM22055ColorProvider8_81llA = GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getSurface();
                        composer2.endReplaceableGroup();
                    } else {
                        colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                    }
                }
                composer2.endReplaceableGroup();
                GlanceModifier glanceModifierBackground = BackgroundKt.background(companion, colorProviderM22055ColorProvider8_81llA);
                float fFloatValue = pairM21937getButtonSizeL2j3NV4.getFirst().floatValue();
                float fFloatValue2 = pairM21937getButtonSizeL2j3NV4.getSecond().floatValue();
                float f = fM21936getMaxButtonSizemDIpwz4;
                GlanceModifier glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = androidx.glance.appwidget.percent.SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(glanceModifierBackground, fFloatValue, fFloatValue2, f, f, 1.0f, composer2, 196608, 0);
                composer2.startReplaceableGroup(1029851562);
                if (imageButtonData.getOnClick() != null) {
                    glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c = imageButtonData.getEnabled() ? ActionKt.clickable(glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, imageButtonData.getOnClick()) : ActionKt.clickable(glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c, LambdaActionKt.action(null, new Function0<Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$PrimaryButtonContent$SingleButtonIcon$1.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, composer2, 48, 1), false, true);
                }
                GlanceModifier glanceModifier2 = glanceModifierM21388sizeBySmallerPercentWithRationSlTg7c;
                composer2.endReplaceableGroup();
                Debug debug = Debug.INSTANCE;
                Alignment center = Alignment.INSTANCE.getCenter();
                final Pair<Float, Float> pair = pairM21937getButtonSizeL2j3NV4;
                final ImageType imageType2 = imageType;
                final float f4 = fM21936getMaxButtonSizemDIpwz4;
                final ImageButtonData imageButtonData2 = imageButtonData;
                debug.debugBox(glanceModifier2, center, "Combine2", false, ComposableLambdaKt.composableLambda(composer2, 1862867279, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt$PrimaryButtonContent$SingleButtonIcon$1.2
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
                    public final void invoke(@Nullable Composer composer3, int i5) {
                        if ((i5 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1862867279, i5, -1, "androidx.glance.oneui.template.layout.glance.combine.PrimaryButtonContent.SingleButtonIcon.<anonymous>.<anonymous> (CombineLayout.kt:260)");
                        }
                        GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                        float fFloatValue3 = pair.getFirst().floatValue();
                        ImageType imageType3 = imageType2;
                        ImageType imageType4 = ImageType.Icon;
                        float f5 = fFloatValue3 * (imageType3 == imageType4 ? 0.6f : 1.0f);
                        float fFloatValue4 = pair.getSecond().floatValue();
                        ImageType imageType5 = imageType2;
                        androidx.glance.ImageKt.m21259ImageGCr5PR4(imageButtonData2.getImageProvider(), imageButtonData2.getContentDescription(), AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(GlanceModifierUtilsKt.contentDescription(androidx.glance.appwidget.percent.SizeModifiersKt.m21388sizeBySmallerPercentWithRationSlTg7c(companion2, f5, fFloatValue4 * (imageType5 == imageType4 ? 0.6f : 1.0f), C2256Dp.m20968constructorimpl(f4 * (imageType5 == imageType4 ? 0.6f : 1.0f)), C2256Dp.m20968constructorimpl(f4 * (imageType2 == imageType4 ? 0.6f : 1.0f)), 1.0f, composer3, 196614, 0), imageButtonData2.getContentDescription()), imageButtonData2.getAnimation()), imageButtonData2.getKeepColor()), ContentScale.INSTANCE.m21467getFitAe3V0ko(), null, composer3, 8, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (Alignment.$stable << 3) | 221568, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 221568, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
