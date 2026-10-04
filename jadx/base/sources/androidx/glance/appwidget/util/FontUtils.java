package androidx.glance.appwidget.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.widget.TextViewCompat;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jt\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJh\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJh\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0080\u0001\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, m13886d2 = {"Landroidx/glance/appwidget/util/FontUtils;", "", "()V", "TEXT_OVERFLOW_GUARD", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "autoTextSizeAndLineCountByDp", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "text", "", "viewWidth", "viewHeight", "minFontSize", "", "maxFontSize", "fontFamily", "Landroidx/glance/text/FontFamily;", "fontWeight", "Landroidx/glance/text/FontWeight;", "autoResize", "", "maxLines", "autoTextSizeAndLineCountByDp-gjw_jeY", "(Landroid/content/Context;Ljava/lang/String;FFFFLandroidx/glance/text/FontFamily;IZI)Lkotlin/Pair;", "autoTextSizeByDp", "autoTextSizeByDp-Yu-sz2Y", "(Landroid/content/Context;Ljava/lang/String;FFFFLandroidx/glance/text/FontFamily;IZI)F", "autoTextSizeBySp", "Landroidx/compose/ui/unit/TextUnit;", "autoTextSizeBySp-KnH1Zvs", "(Landroid/content/Context;Ljava/lang/String;FFFFLandroidx/glance/text/FontFamily;IZI)J", "calculateFontSizeAndLineCount", "availableWidth", "availableHeight", "fontType", "density", "calculateFontSizeAndLineCount-nQwSwfs", "(Landroid/content/Context;Ljava/lang/String;FFFFILandroidx/glance/text/FontFamily;IZIF)Lkotlin/Pair;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontUtils.kt\nandroidx/glance/appwidget/util/FontUtils\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,205:1\n174#2:206\n174#2:207\n174#2:209\n174#2:210\n154#2:211\n58#3:208\n*S KotlinDebug\n*F\n+ 1 FontUtils.kt\nandroidx/glance/appwidget/util/FontUtils\n*L\n53#1:206\n81#1:207\n144#1:209\n147#1:210\n112#1:211\n128#1:208\n*E\n"})
public final class FontUtils {
    public static final int $stable = 0;

    @NotNull
    public static final FontUtils INSTANCE = new FontUtils();
    private static final float TEXT_OVERFLOW_GUARD = C2256Dp.m20968constructorimpl(2);

    private FontUtils() {
    }

    /* JADX INFO: renamed from: autoTextSizeAndLineCountByDp-gjw_jeY$default, reason: not valid java name */
    public static /* synthetic */ Pair m21404autoTextSizeAndLineCountByDpgjw_jeY$default(FontUtils fontUtils, Context context, String str, float f, float f4, float f5, float f6, FontFamily fontFamily, int i, boolean z, int i2, int i4, Object obj) {
        int i5;
        FontUtils fontUtils2;
        Context context2;
        String str2;
        float f7;
        float f8;
        float f9;
        float f10;
        FontFamily sec = (i4 & 64) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily;
        int iM21998getNormalWjrlUT0 = (i4 & 128) != 0 ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : i;
        boolean z2 = (i4 & 256) != 0 ? true : z;
        if ((i4 & 512) != 0) {
            i5 = 1;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
            fontUtils2 = fontUtils;
        } else {
            i5 = i2;
            fontUtils2 = fontUtils;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
        }
        return fontUtils2.m21409autoTextSizeAndLineCountByDpgjw_jeY(context2, str2, f7, f8, f9, f10, sec, iM21998getNormalWjrlUT0, z2, i5);
    }

    /* JADX INFO: renamed from: autoTextSizeByDp-Yu-sz2Y$default, reason: not valid java name */
    public static /* synthetic */ float m21405autoTextSizeByDpYusz2Y$default(FontUtils fontUtils, Context context, String str, float f, float f4, float f5, float f6, FontFamily fontFamily, int i, boolean z, int i2, int i4, Object obj) {
        int i5;
        FontUtils fontUtils2;
        Context context2;
        String str2;
        float f7;
        float f8;
        float f9;
        float f10;
        FontFamily sec = (i4 & 64) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily;
        int iM21998getNormalWjrlUT0 = (i4 & 128) != 0 ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : i;
        boolean z2 = (i4 & 256) != 0 ? true : z;
        if ((i4 & 512) != 0) {
            i5 = 1;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
            fontUtils2 = fontUtils;
        } else {
            i5 = i2;
            fontUtils2 = fontUtils;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
        }
        return fontUtils2.m21410autoTextSizeByDpYusz2Y(context2, str2, f7, f8, f9, f10, sec, iM21998getNormalWjrlUT0, z2, i5);
    }

    /* JADX INFO: renamed from: autoTextSizeBySp-KnH1Zvs$default, reason: not valid java name */
    public static /* synthetic */ long m21406autoTextSizeBySpKnH1Zvs$default(FontUtils fontUtils, Context context, String str, float f, float f4, float f5, float f6, FontFamily fontFamily, int i, boolean z, int i2, int i4, Object obj) {
        int i5;
        FontUtils fontUtils2;
        Context context2;
        String str2;
        float f7;
        float f8;
        float f9;
        float f10;
        FontFamily sec = (i4 & 64) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily;
        int iM21998getNormalWjrlUT0 = (i4 & 128) != 0 ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : i;
        boolean z2 = (i4 & 256) != 0 ? true : z;
        if ((i4 & 512) != 0) {
            i5 = 1;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
            fontUtils2 = fontUtils;
        } else {
            i5 = i2;
            fontUtils2 = fontUtils;
            context2 = context;
            str2 = str;
            f7 = f;
            f8 = f4;
            f9 = f5;
            f10 = f6;
        }
        return fontUtils2.m21411autoTextSizeBySpKnH1Zvs(context2, str2, f7, f8, f9, f10, sec, iM21998getNormalWjrlUT0, z2, i5);
    }

    /* JADX INFO: renamed from: calculateFontSizeAndLineCount-nQwSwfs, reason: not valid java name */
    private final Pair<Float, Integer> m21407calculateFontSizeAndLineCountnQwSwfs(Context context, String text, float availableWidth, float availableHeight, float minFontSize, float maxFontSize, int fontType, FontFamily fontFamily, int fontWeight, boolean autoResize, int maxLines, float density) {
        int iM21412dpToPxlG28NQ4 = autoResize ? FontUtilsKt.m21412dpToPxlG28NQ4(context, C2256Dp.m20968constructorimpl(availableWidth - TEXT_OVERFLOW_GUARD), density) * maxLines : 1073741823;
        int iM21412dpToPxlG28NQ42 = FontUtilsKt.m21412dpToPxlG28NQ4(context, availableHeight, density) / maxLines;
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(fontType, maxFontSize);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setTypeface(Typeface.create(fontFamily.getFamily(), fontWeight));
        textView.setMaxLines(1);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, fontType == 1 ? FontUtilsKt.m21412dpToPxlG28NQ4(context, C2256Dp.m20968constructorimpl(minFontSize), density) : FontUtilsKt.m21414spToPxmpE4wyQ(context, TextUnitKt.getSp(minFontSize)), fontType == 1 ? FontUtilsKt.m21412dpToPxlG28NQ4(context, C2256Dp.m20968constructorimpl(maxFontSize), density) : FontUtilsKt.m21414spToPxmpE4wyQ(context, TextUnitKt.getSp(maxFontSize)), 1, 0);
        textView.measure(View.MeasureSpec.makeMeasureSpec(iM21412dpToPxlG28NQ4, 1073741824), View.MeasureSpec.makeMeasureSpec(iM21412dpToPxlG28NQ42, 1073741824));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        return TuplesKt.m13893to(Float.valueOf(fontType == 1 ? FontUtilsKt.pxToDp(context, textView.getTextSize(), density) : FontUtilsKt.pxToSp(context, textView.getTextSize())), Integer.valueOf(RangesKt.coerceAtMost((int) Math.ceil(textView.getLayout().getLineWidth(0) / r5), maxLines)));
    }

    /* JADX INFO: renamed from: calculateFontSizeAndLineCount-nQwSwfs$default, reason: not valid java name */
    public static /* synthetic */ Pair m21408calculateFontSizeAndLineCountnQwSwfs$default(FontUtils fontUtils, Context context, String str, float f, float f4, float f5, float f6, int i, FontFamily fontFamily, int i2, boolean z, int i4, float f7, int i5, Object obj) {
        return fontUtils.m21407calculateFontSizeAndLineCountnQwSwfs(context, str, f, f4, f5, f6, i, fontFamily, i2, z, i4, (i5 & 2048) != 0 ? -1.0f : f7);
    }

    @NotNull
    /* JADX INFO: renamed from: autoTextSizeAndLineCountByDp-gjw_jeY, reason: not valid java name */
    public final Pair<C2256Dp, Integer> m21409autoTextSizeAndLineCountByDpgjw_jeY(@NotNull Context context, @NotNull String text, float viewWidth, float viewHeight, float minFontSize, float maxFontSize, @NotNull FontFamily fontFamily, int fontWeight, boolean autoResize, int maxLines) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Pair pairM21408calculateFontSizeAndLineCountnQwSwfs$default = m21408calculateFontSizeAndLineCountnQwSwfs$default(this, context, text, viewWidth, viewHeight, minFontSize, maxFontSize, 1, fontFamily, fontWeight, autoResize, maxLines, 0.0f, 2048, null);
        return TuplesKt.m13893to(C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component1()).floatValue())), Integer.valueOf(((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component2()).intValue()));
    }

    /* JADX INFO: renamed from: autoTextSizeByDp-Yu-sz2Y, reason: not valid java name */
    public final float m21410autoTextSizeByDpYusz2Y(@NotNull Context context, @NotNull String text, float viewWidth, float viewHeight, float minFontSize, float maxFontSize, @NotNull FontFamily fontFamily, int fontWeight, boolean autoResize, int maxLines) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Pair pairM21408calculateFontSizeAndLineCountnQwSwfs$default = m21408calculateFontSizeAndLineCountnQwSwfs$default(this, context, text, viewWidth, viewHeight, minFontSize, maxFontSize, 1, fontFamily, fontWeight, autoResize, maxLines, 0.0f, 2048, null);
        float fFloatValue = ((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component1()).floatValue();
        ((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component2()).intValue();
        return C2256Dp.m20968constructorimpl(fFloatValue);
    }

    /* JADX INFO: renamed from: autoTextSizeBySp-KnH1Zvs, reason: not valid java name */
    public final long m21411autoTextSizeBySpKnH1Zvs(@NotNull Context context, @NotNull String text, float viewWidth, float viewHeight, float minFontSize, float maxFontSize, @NotNull FontFamily fontFamily, int fontWeight, boolean autoResize, int maxLines) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Pair pairM21408calculateFontSizeAndLineCountnQwSwfs$default = m21408calculateFontSizeAndLineCountnQwSwfs$default(this, context, text, viewWidth, viewHeight, minFontSize, maxFontSize, 2, fontFamily, fontWeight, autoResize, maxLines, 0.0f, 2048, null);
        float fFloatValue = ((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component1()).floatValue();
        ((Number) pairM21408calculateFontSizeAndLineCountnQwSwfs$default.component2()).intValue();
        return TextUnitKt.getSp(fFloatValue);
    }
}
