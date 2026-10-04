package androidx.glance.oneui.template.component.compose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.core.view.ViewGroupKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.translators.TextTranslatorKt;
import androidx.glance.appwidget.util.FontUtils;
import androidx.glance.appwidget.util.FontUtilsKt;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextCategory;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextDirection;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a<\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a<\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aF\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u001a\u001aP\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aO\u0010!\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0#2\b\b\u0002\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\u0010,\u001a\u0016\u0010-\u001a\u00020\u001c*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a.\u00101\u001a\u00020\u0001*\u0002022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020'H\u0003ø\u0001\u0000¢\u0006\u0004\b3\u00104\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m13886d2 = {"ComposeAutoText", "", "modifier", "Landroidx/compose/ui/Modifier;", "textData", "Landroidx/glance/oneui/template/TextData;", "percentData", "Landroidx/glance/text/TextPercentData;", "fontWeight", "Landroidx/glance/text/FontWeight;", "textColor", "Landroidx/glance/unit/ColorProvider;", "ComposeAutoText-2T94tj4", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/TextData;Landroidx/glance/text/TextPercentData;ILandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "ComposeText", "ComposeText-2T94tj4", "textSize", "Landroidx/compose/ui/unit/Dp;", "ComposeText-FbLeKfk", "(Landroidx/glance/oneui/template/TextData;FILandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/TextUnit;", "maxFontScale", "", "ComposeText-KuOwvYU", "(Landroidx/glance/oneui/template/TextData;JILandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "Landroidx/glance/oneui/template/layout/TextSize;", "(Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/layout/TextSize;Landroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "textSizeId", "", BilouCodec.UNIT, "Landroidx/glance/text/ComplexUnit;", "ComposeText-4QGO3ko", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/text/ComplexUnit;ILandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "ComposeTextList", "textList", "", "Landroidx/glance/oneui/template/TypedTextData;", "textSizes", "textColors", "Landroidx/compose/ui/graphics/Color;", "paddings", "Landroidx/compose/ui/unit/DpRect;", "equalDivision", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLandroidx/compose/runtime/Composer;II)V", MarkdownConverter.PREFIX_NAME, "Landroidx/glance/text/TextAlign;", "convert-b1p-sNo", "(I)I", Constants.ARG_UPDATE, "Landroid/widget/TextView;", "update-g2O1Hgs", "(Landroid/widget/TextView;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/layout/TextSize;J)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/compose/TextKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,396:1\n74#2:397\n74#2:398\n74#2:402\n74#2:403\n74#2:409\n74#2:410\n88#3:399\n88#3:400\n88#3:404\n88#3:405\n75#3:407\n92#3:408\n154#4:401\n154#4:406\n174#4:412\n174#4:413\n1#5:411\n*S KotlinDebug\n*F\n+ 1 Text.kt\nandroidx/glance/oneui/template/component/compose/TextKt\n*L\n57#1:397\n62#1:398\n91#1:402\n96#1:403\n187#1:409\n217#1:410\n63#1:399\n64#1:400\n97#1:404\n98#1:405\n118#1:407\n118#1:408\n66#1:401\n115#1:406\n362#1:412\n363#1:413\n*E\n"})
public final class TextKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeAutoText-2T94tj4, reason: not valid java name */
    public static final void m21727ComposeAutoText2T94tj4(@Nullable Modifier modifier, @NotNull final TextData textData, @NotNull final TextPercentData percentData, final int i, @NotNull final ColorProvider textColor, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        String text;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(percentData, "percentData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1289044238);
        Modifier modifier2 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(1289044238, i5, -1, "androidx.glance.oneui.template.component.compose.ComposeAutoText (Text.kt:55)");
        } else {
            i5 = i2;
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
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
        ComposeText(textData, new TextSize(C2256Dp.m20973equalsimpl0(fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f)) ? C2256Dp.m20968constructorimpl(f) : FontUtils.m21405autoTextSizeByDpYusz2Y$default(FontUtils.INSTANCE, context, str, fM20968constructorimpl, fM20968constructorimpl2, 1.0f, percentData.getMaxSize(), null, 0, false, 0, 960, null), ComplexUnit.f1613DP, i, 0.0f, 8, (DefaultConstructorMarker) null), textColor, null, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt$ComposeAutoText$1
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
                    TextKt.m21727ComposeAutoText2T94tj4(modifier3, textData, percentData, i, textColor, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeText(@NotNull final TextData textData, @NotNull final TextSize textSize, @NotNull final ColorProvider textColor, @Nullable Modifier modifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textSize, "textSize");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1192241984);
        if ((i2 & 8) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1192241984, i, -1, "androidx.glance.oneui.template.component.compose.ComposeText (Text.kt:198)");
        }
        final long jConvert = ComposeUtilsKt.convert(textColor, composerStartRestartGroup, 8);
        AndroidView_androidKt.AndroidView(new Function1<Context, TextView>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final TextView invoke(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                TextView textView = new TextView(context);
                TextKt.m21734updateg2O1Hgs(textView, textData, textSize, jConvert);
                return textView;
            }
        }, modifier2, new Function1<TextView, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                invoke2(textView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                TextKt.m21734updateg2O1Hgs(textView, textData, textSize, jConvert);
            }
        }, composerStartRestartGroup, (i >> 6) & 112, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.7
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
                    TextKt.ComposeText(textData, textSize, textColor, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeText-2T94tj4, reason: not valid java name */
    public static final void m21728ComposeText2T94tj4(@Nullable Modifier modifier, @NotNull final TextData textData, @NotNull final TextPercentData percentData, final int i, @NotNull final ColorProvider textColor, @Nullable Composer composer, int i2, final int i4) {
        int i5;
        String text;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(percentData, "percentData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1228499071);
        Modifier modifier2 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(1228499071, i5, -1, "androidx.glance.oneui.template.component.compose.ComposeText (Text.kt:89)");
        } else {
            i5 = i2;
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
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
        ComposeText(textData, new TextSize(C2256Dp.m20973equalsimpl0(fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f)) ? C2256Dp.m20968constructorimpl(f) : FontUtils.INSTANCE.m21409autoTextSizeAndLineCountByDpgjw_jeY(context, str, fM20968constructorimpl, fM20968constructorimpl2, 1.0f, textCategory != null ? textCategory.getMaxSize() : percentData.getMaxSize(), textData.getFontFamily(), i, percentData.getAutoResize(), textData.getMaxLines()).getFirst().m20982unboximpl(), ComplexUnit.f1613DP, i, 0.0f, percentData.getAutoResize() ? percentData : null, 8, (DefaultConstructorMarker) null), textColor, (!percentData.getAutoResize() || percentData.getWidthPercent() >= 1.0f) ? percentData.getAutoResize() ? SizeKt.m15885height3ABfNKs(modifier2, fM20968constructorimpl2) : SizeKt.wrapContentSize$default(modifier2, null, false, 3, null) : SizeKt.m15904width3ABfNKs(SizeKt.m15885height3ABfNKs(modifier2, percentData.getWidthPercent() < 1.0f ? C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM20968constructorimpl2 / textData.getMaxLines()) * r0.getSecond().intValue()) : fM20968constructorimpl2), fM20968constructorimpl), composerStartRestartGroup, (TextPercentData.$stable << 3) | 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.1
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
                    TextKt.m21728ComposeText2T94tj4(modifier3, textData, percentData, i, textColor, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeText-4QGO3ko, reason: not valid java name */
    public static final void m21729ComposeText4QGO3ko(@NotNull final TextData textData, @DimenRes final int i, @NotNull final ComplexUnit unit, final int i2, @NotNull final ColorProvider textColor, @Nullable Modifier modifier, float f, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1640046526);
        Modifier modifier2 = (i5 & 32) != 0 ? Modifier.INSTANCE : modifier;
        float f4 = (i5 & 64) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1640046526, i4, -1, "androidx.glance.oneui.template.component.compose.ComposeText (Text.kt:183)");
        }
        final float f5 = f4;
        final Modifier modifier3 = modifier2;
        ComposeText(textData, new TextSize((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i, unit, i2, f5, (DefaultConstructorMarker) null), textColor, modifier3, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i4 >> 6) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.4
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
                    TextKt.m21729ComposeText4QGO3ko(textData, i, unit, i2, textColor, modifier3, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeText-FbLeKfk, reason: not valid java name */
    public static final void m21730ComposeTextFbLeKfk(@NotNull final TextData textData, final float f, final int i, @NotNull final ColorProvider textColor, @Nullable Modifier modifier, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1662308253);
        Modifier modifier2 = (i4 & 16) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1662308253, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeText (Text.kt:148)");
        }
        ComposeText(textData, new TextSize(f, ComplexUnit.f1613DP, i, 0.0f, 8, (DefaultConstructorMarker) null), textColor, modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 >> 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.2
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
                    TextKt.m21730ComposeTextFbLeKfk(textData, f, i, textColor, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeText-KuOwvYU, reason: not valid java name */
    public static final void m21731ComposeTextKuOwvYU(@NotNull final TextData textData, final long j, final int i, @NotNull final ColorProvider textColor, @Nullable Modifier modifier, float f, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1188480424);
        Modifier modifier2 = (i4 & 16) != 0 ? Modifier.INSTANCE : modifier;
        float f4 = (i4 & 32) != 0 ? 0.0f : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1188480424, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeText (Text.kt:165)");
        }
        final float f5 = f4;
        final Modifier modifier3 = modifier2;
        ComposeText(textData, new TextSize(TextUnit.m21161getValueimpl(j), ComplexUnit.f1614SP, i, f5, (DefaultConstructorMarker) null), textColor, modifier3, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 >> 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeText.3
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
                    TextKt.m21731ComposeTextKuOwvYU(textData, j, i, textColor, modifier3, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeTextList(@NotNull final List<? extends TypedTextData> textList, @NotNull final List<TextSize> textSizes, @NotNull final List<Color> textColors, @NotNull final List<DpRect> paddings, boolean z, @Nullable Composer composer, int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(textList, "textList");
        Intrinsics.checkNotNullParameter(textSizes, "textSizes");
        Intrinsics.checkNotNullParameter(textColors, "textColors");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Composer composerStartRestartGroup = composer.startRestartGroup(-443035968);
        boolean z2 = (i2 & 16) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(-443035968, i4, -1, "androidx.glance.oneui.template.component.compose.ComposeTextList (Text.kt:214)");
        } else {
            i4 = i;
        }
        final int size = textList.size() - 1;
        final float f = ((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getDisplayMetrics().density;
        final boolean z3 = z2;
        AndroidView_androidKt.AndroidView(new Function1<Context, LinearLayout>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeTextList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final LinearLayout invoke(@NotNull Context context) {
                LinearLayout linearLayout;
                Intrinsics.checkNotNullParameter(context, "context");
                View viewInflate = LayoutInflater.from(context).inflate(z3 ? C3094R.layout.horizontal_text_list_layout_equal_division : C3094R.layout.horizontal_text_list_layout, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                int i5 = size;
                List<TypedTextData> list = textList;
                List<TextSize> list2 = textSizes;
                List<Color> list3 = textColors;
                List<DpRect> list4 = paddings;
                float f4 = f;
                int i6 = 0;
                for (View view : ViewGroupKt.getChildren(linearLayout2)) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    View view2 = view;
                    if (!(view2 instanceof TextView) || i6 > i5) {
                        linearLayout = linearLayout2;
                        view2.setVisibility(8);
                    } else {
                        TextView textView = (TextView) view2;
                        linearLayout = linearLayout2;
                        TextKt.m21734updateg2O1Hgs(textView, list.get(i6), list2.get(i6), list3.get(i6).m18535unboximpl());
                        DpRect dpRect = list4.get(i6);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.setMarginStart((int) (dpRect.m21051getLeftD9Ej5fM() * f4));
                        layoutParams2.setMarginEnd((int) (dpRect.m21052getRightD9Ej5fM() * f4));
                        textView.setLayoutParams(layoutParams2);
                        textView.setVisibility(0);
                    }
                    linearLayout2 = linearLayout;
                    i6 = i7;
                }
                return linearLayout2;
            }
        }, z2 ? SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null) : Modifier.INSTANCE, new Function1<LinearLayout, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeTextList.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout linearLayout) {
                invoke2(linearLayout);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LinearLayout linearLayout) {
                Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
                int i5 = size;
                List<TypedTextData> list = textList;
                List<TextSize> list2 = textSizes;
                List<Color> list3 = textColors;
                List<DpRect> list4 = paddings;
                float f4 = f;
                int i6 = 0;
                for (View view : ViewGroupKt.getChildren(linearLayout)) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    View view2 = view;
                    if (!(view2 instanceof TextView) || i6 > i5) {
                        view2.setVisibility(8);
                    } else {
                        TextView textView = (TextView) view2;
                        TextKt.m21734updateg2O1Hgs(textView, list.get(i6), list2.get(i6), list3.get(i6).m18535unboximpl());
                        DpRect dpRect = list4.get(i6);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.setMarginStart((int) (dpRect.m21051getLeftD9Ej5fM() * f4));
                        layoutParams2.setMarginEnd((int) (dpRect.m21052getRightD9Ej5fM() * f4));
                        textView.setLayoutParams(layoutParams2);
                        textView.setVisibility(0);
                    }
                    i6 = i7;
                }
            }
        }, composerStartRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i5 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TextKt.ComposeTextList.3
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TextKt.ComposeTextList(textList, textSizes, textColors, paddings, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: convert-b1p-sNo, reason: not valid java name */
    private static final int m21733convertb1psNo(int i) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m22003equalsimpl0(i, companion.m22009getLeftROrN78o())) {
            return 2;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22010getRightROrN78o())) {
            return 3;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22007getCenterROrN78o())) {
            return 4;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22011getStartROrN78o())) {
            return 5;
        }
        return TextAlign.m22003equalsimpl0(i, companion.m22008getEndROrN78o()) ? 6 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01eb  */
    @SuppressLint({WarningType.NewApi})
    /* JADX INFO: renamed from: update-g2O1Hgs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21734updateg2O1Hgs(TextView textView, TextData textData, TextSize textSize, long j) {
        float size;
        float maxFontScale;
        int i;
        if (textData.getTextResId() != 0) {
            textView.setText(textData.getTextResId());
        } else if (textData.getText() != null) {
            textView.setText(textData.getText());
        }
        textView.setTextColor(ColorKt.m18579toArgb8_81llA(j));
        textView.setAlpha(textData.getEnabled() ? 1.0f : 0.6f);
        if (textSize.getUnit() == ComplexUnit.f1613DP) {
            textView.setTextSize(1, textSize.getSizeResId() != 0 ? textView.getContext().getResources().getFloat(textSize.getSizeResId()) : textSize.getSize());
        } else if (textSize.getMaxFontScale() != 0.0f && textView.getContext().getResources().getConfiguration().fontScale > textSize.getMaxFontScale()) {
            if (textSize.getSizeResId() != 0) {
                size = textView.getContext().getResources().getFloat(textSize.getSizeResId());
                maxFontScale = textSize.getMaxFontScale();
            } else {
                size = textSize.getSize();
                maxFontScale = textSize.getMaxFontScale();
            }
            textView.setTextSize(1, maxFontScale * size);
        } else {
            textView.setTextSize(2, textSize.getSizeResId() != 0 ? textView.getContext().getResources().getFloat(textSize.getSizeResId()) : textSize.getSize());
        }
        textView.setTextDirection(TextDirection.m22028equalsimpl0(textData.getTextDirection(), TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs()) ? 1 : 5);
        int fontWeight = textSize.getFontWeight();
        FontWeight.Companion companion = FontWeight.INSTANCE;
        textView.setTextAppearance(FontWeight.m21992equalsimpl0(fontWeight, companion.m21998getNormalWjrlUT0()) ? C2902R.style.Glance_AppWidget_TextAppearance_Normal : FontWeight.m21992equalsimpl0(fontWeight, companion.m21999getSemiBoldWjrlUT0()) ? TextTranslatorKt.getProperFontFamilyWhenSemiBold(textData.getFontFamily()) : FontWeight.m21992equalsimpl0(fontWeight, companion.m21996getBoldWjrlUT0()) ? C2902R.style.Glance_AppWidget_TextAppearance_Bold : C2902R.style.Glance_AppWidget_TextAppearance_Medium);
        textData.getTextAlign();
        textView.setTextAlignment(m21733convertb1psNo(textData.getTextAlign()));
        TextDecoration textDecoration = textData.getTextDecoration();
        if (textDecoration != null) {
            textDecoration.getMask();
            TextDecoration textDecoration2 = textData.getTextDecoration();
            TextDecoration.Companion companion2 = TextDecoration.INSTANCE;
            if (textDecoration2 == null ? false : TextDecoration.m22016equalsimpl0(textDecoration2.getMask(), companion2.m22022getLineThroughObZ5V_A())) {
                textView.setPaintFlags(textView.getPaintFlags() | 16);
            } else {
                if (textDecoration2 == null ? false : TextDecoration.m22016equalsimpl0(textDecoration2.getMask(), companion2.m22024getUnderlineObZ5V_A())) {
                    textView.setPaintFlags(textView.getPaintFlags() | 8);
                }
            }
        }
        textView.setMaxLines(textData.getMaxLines());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (textData.getHasShadow()) {
            textView.setShadowLayer(textData.getTextShadowStyle().getRadius(), textData.getTextShadowStyle().getDx(), textData.getTextShadowStyle().getDy(), ColorKt.m18579toArgb8_81llA(textData.getTextShadowStyle().getColor()));
        }
        TextPercentData percentData = textSize.getPercentData();
        if (percentData != null) {
            TextCategory textCategory = percentData.getTextCategory();
            float maxSize = textCategory != null ? textCategory.getMaxSize() : percentData.getMaxSize();
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int iM21413dpToPxlG28NQ4$default = FontUtilsKt.m21413dpToPxlG28NQ4$default(context, C2256Dp.m20968constructorimpl(1.0f), 0.0f, 4, null);
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView.setAutoSizeTextTypeUniformWithConfiguration(iM21413dpToPxlG28NQ4$default, FontUtilsKt.m21413dpToPxlG28NQ4$default(context2, C2256Dp.m20968constructorimpl(maxSize), 0.0f, 4, null), 1, 0);
        }
        int textVerticalAlign = textData.getTextVerticalAlign();
        TextVerticalAlign.Companion companion3 = TextVerticalAlign.INSTANCE;
        if (!TextVerticalAlign.m22048equalsimpl0(textVerticalAlign, companion3.m22054getTopJ86Ipig())) {
            i = TextVerticalAlign.m22048equalsimpl0(textVerticalAlign, companion3.m22053getCenterJ86Ipig()) ? 16 : TextVerticalAlign.m22048equalsimpl0(textVerticalAlign, companion3.m22052getBottomJ86Ipig()) ? 80 : 48;
        }
        textView.setGravity(i);
    }
}
