package androidx.compose.p109ui.text;

import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.ShadowKt;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.font.FontWeightKt;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.BaselineShiftKt;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDrawStyleKt;
import androidx.compose.p109ui.text.style.TextForegroundStyle;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextGeometricTransformKt;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e\u001a+\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0013\u001a&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a*\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0000\u001aÀ\u0001\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00152\b\u00109\u001a\u0004\u0018\u00010:H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0015*\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, m13886d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpanStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpanStyle.kt\nandroidx/compose/ui/text/SpanStyleKt\n+ 2 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n+ 3 TextUnit.kt\nandroidx/compose/ui/unit/TextUnitKt\n*L\n1#1,950:1\n708#2:951\n696#2:952\n696#2:954\n696#2:956\n708#2:957\n696#2:958\n251#3:953\n251#3:955\n*S KotlinDebug\n*F\n+ 1 SpanStyle.kt\nandroidx/compose/ui/text/SpanStyleKt\n*L\n848#1:951\n848#1:952\n890#1:954\n905#1:956\n937#1:957\n937#1:958\n889#1:953\n895#1:955\n*E\n"})
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;

    @NotNull
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    static {
        Color.Companion companion = Color.INSTANCE;
        DefaultBackgroundColor = companion.m18560getTransparent0d7_KjU();
        long jM18551getBlack0d7_KjU = companion.m18551getBlack0d7_KjU();
        DefaultColor = jM18551getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.INSTANCE.m20878from8_81llA(jM18551getBlack0d7_KjU);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b A[PHI: r11
      0x002b: PHI (r11v7 long) = 
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v8 long)
     binds: [B:35:0x0096, B:47:0x00c8, B:44:0x00bc, B:41:0x00b0, B:38:0x00a4, B:33:0x0088, B:28:0x0079, B:24:0x0067, B:21:0x005f, B:18:0x0053, B:15:0x0047, B:5:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0171  */
    @NotNull
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle m20411fastMergedSHsh3o(@NotNull SpanStyle spanStyle, long j, @Nullable Brush brush, float f, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j5, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle, @Nullable DrawStyle drawStyle) {
        long fontSize;
        TextGeometricTransform textGeometricTransform2;
        long background;
        DrawStyle drawStyle2;
        String fontFeatureSettings = str;
        BaselineShift baselineShift2 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (!TextUnitKt.m21179isUnspecifiedR2X_6o(j2)) {
            fontSize = j2;
            if (!TextUnit.m21158equalsimpl0(fontSize, spanStyle.getFontSize())) {
                textGeometricTransform2 = textGeometricTransform;
                background = j5;
                drawStyle2 = drawStyle;
            }
            TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle().merge(brush == null ? TextForegroundStyle.INSTANCE.from(brush, f) : TextForegroundStyle.INSTANCE.m20878from8_81llA(j));
            FontFamily fontFamily2 = fontFamily != null ? spanStyle.getFontFamily() : fontFamily;
            if (TextUnitKt.m21179isUnspecifiedR2X_6o(fontSize)) {
                fontSize = spanStyle.getFontSize();
            }
            FontWeight fontWeight2 = fontWeight != null ? spanStyle.getFontWeight() : fontWeight;
            FontStyle fontStyle2 = fontStyle != null ? spanStyle.getFontStyle() : fontStyle;
            FontSynthesis fontSynthesis2 = fontSynthesis != null ? spanStyle.getFontSynthesis() : fontSynthesis;
            if (fontFeatureSettings == null) {
                fontFeatureSettings = spanStyle.getFontFeatureSettings();
            }
            long letterSpacing = TextUnitKt.m21179isUnspecifiedR2X_6o(j3) ? j3 : spanStyle.getLetterSpacing();
            if (baselineShift2 == null) {
                baselineShift2 = spanStyle.getBaselineShift();
            }
            if (textGeometricTransform2 == null) {
                textGeometricTransform2 = spanStyle.getTextGeometricTransform();
            }
            LocaleList localeList2 = localeList != null ? spanStyle.getLocaleList() : localeList;
            if (background == 16) {
                background = spanStyle.getBackground();
            }
            if (textDecoration2 == null) {
                textDecoration2 = spanStyle.getTextDecoration();
            }
            if (shadow2 == null) {
                shadow2 = spanStyle.getShadow();
            }
            return new SpanStyle(textForegroundStyleMerge, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 != null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
        }
        fontSize = j2;
        if ((brush != null || j == 16 || Color.m18526equalsimpl0(j, spanStyle.getTextForegroundStyle().mo20755getColor0d7_KjU())) && ((fontStyle == null || Intrinsics.areEqual(fontStyle, spanStyle.getFontStyle())) && ((fontWeight == null || Intrinsics.areEqual(fontWeight, spanStyle.getFontWeight())) && ((fontFamily == null || fontFamily == spanStyle.getFontFamily()) && (TextUnitKt.m21179isUnspecifiedR2X_6o(j3) || TextUnit.m21158equalsimpl0(j3, spanStyle.getLetterSpacing())))))) {
            if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.getFontSynthesis())) && ((fontFeatureSettings == null || Intrinsics.areEqual(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.getBaselineShift())))))) {
                if (textGeometricTransform != null) {
                    textGeometricTransform2 = textGeometricTransform;
                    if (Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) {
                    }
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                if (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList())) {
                    if (j5 != 16) {
                        background = j5;
                        if (Color.m18526equalsimpl0(background, spanStyle.getBackground())) {
                        }
                    } else {
                        background = j5;
                    }
                    if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                        drawStyle2 = drawStyle;
                        if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                            return spanStyle;
                        }
                    }
                }
                drawStyle2 = drawStyle;
            }
            background = j5;
            drawStyle2 = drawStyle;
        }
        TextForegroundStyle textForegroundStyleMerge2 = spanStyle.getTextForegroundStyle().merge(brush == null ? TextForegroundStyle.INSTANCE.from(brush, f) : TextForegroundStyle.INSTANCE.m20878from8_81llA(j));
        if (fontFamily != null) {
        }
        if (TextUnitKt.m21179isUnspecifiedR2X_6o(fontSize)) {
        }
        if (fontWeight != null) {
        }
        if (fontStyle != null) {
        }
        if (fontSynthesis != null) {
        }
        if (fontFeatureSettings == null) {
        }
        if (TextUnitKt.m21179isUnspecifiedR2X_6o(j3)) {
        }
        if (baselineShift2 == null) {
        }
        if (textGeometricTransform2 == null) {
        }
        if (localeList != null) {
        }
        if (background == 16) {
        }
        if (textDecoration2 == null) {
        }
        if (shadow2 == null) {
        }
        return new SpanStyle(textForegroundStyleMerge2, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 != null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final SpanStyle lerp(@NotNull SpanStyle spanStyle, @NotNull SpanStyle spanStyle2, float f) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM20412lerpTextUnitInheritableC3pnCVY = m20412lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM20412lerpTextUnitInheritableC3pnCVY2 = m20412lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM20747unboximpl = baselineShift != null ? baselineShift.m20747unboximpl() : BaselineShift.m20742constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float fM20754lerpjWV1Mfo = BaselineShiftKt.m20754lerpjWV1Mfo(fM20747unboximpl, baselineShift2 != null ? baselineShift2.m20747unboximpl() : BaselineShift.m20742constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM18576lerpjxsXWHM = ColorKt.m18576lerpjxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM20412lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM20412lerpTextUnitInheritableC3pnCVY2, BaselineShift.m20741boximpl(fM20754lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM18576lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m20412lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        return (TextUnitKt.m21179isUnspecifiedR2X_6o(j) || TextUnitKt.m21179isUnspecifiedR2X_6o(j2)) ? ((TextUnit) lerpDiscrete(TextUnit.m21151boximpl(j), TextUnit.m21151boximpl(j2), f)).getPackedValue() : TextUnitKt.m21181lerpC3pnCVY(j, j2, f);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        return spanStyle.getPlatformStyle() == null ? platformSpanStyle : platformSpanStyle == null ? spanStyle.getPlatformStyle() : spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    @NotNull
    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle spanStyle) {
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt.resolveSpanStyleDefaults.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextForegroundStyle invoke() {
                return SpanStyleKt.DefaultColorForegroundStyle;
            }
        });
        long fontSize = TextUnitKt.m21179isUnspecifiedR2X_6o(spanStyle.getFontSize()) ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM20562boximpl = FontStyle.m20562boximpl(fontStyle != null ? fontStyle.m20568unboximpl() : FontStyle.INSTANCE.m20572getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis fontSynthesisM20573boximpl = FontSynthesis.m20573boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m20582getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long letterSpacing = TextUnitKt.m21179isUnspecifiedR2X_6o(spanStyle.getLetterSpacing()) ? DefaultLetterSpacing : spanStyle.getLetterSpacing();
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        BaselineShift baselineShiftM20741boximpl = BaselineShift.m20741boximpl(baselineShift != null ? baselineShift.m20747unboximpl() : BaselineShift.INSTANCE.m20751getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        if (background == 16) {
            background = DefaultBackgroundColor;
        }
        long j = background;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, fontSize, fontWeight2, fontStyleM20562boximpl, fontSynthesisM20573boximpl, fontFamily2, str, letterSpacing, baselineShiftM20741boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
