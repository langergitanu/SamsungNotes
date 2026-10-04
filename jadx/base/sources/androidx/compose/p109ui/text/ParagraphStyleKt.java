package androidx.compose.p109ui.text;

import androidx.compose.p109ui.text.style.Hyphens;
import androidx.compose.p109ui.text.style.LineBreak;
import androidx.compose.p109ui.text.style.LineHeightStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.text.style.TextIndentKt;
import androidx.compose.p109ui.text.style.TextMotion;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nParagraphStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParagraphStyle.kt\nandroidx/compose/ui/text/ParagraphStyleKt\n+ 2 TextUnit.kt\nandroidx/compose/ui/unit/TextUnitKt\n*L\n1#1,539:1\n251#2:540\n*S KotlinDebug\n*F\n+ 1 ParagraphStyle.kt\nandroidx/compose/ui/text/ParagraphStyleKt\n*L\n501#1:540\n*E\n"})
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();

    @NotNull
    /* JADX INFO: renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m20365fastMergej5T8yCg(@NotNull ParagraphStyle paragraphStyle, int i, int i2, long j, @Nullable TextIndent textIndent, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle, int i4, int i5, @Nullable TextMotion textMotion) {
        long j2;
        int textAlign = i;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m20853equalsimpl0(textAlign, companion.m20863getUnspecifiede0LSkKk()) || TextAlign.m20853equalsimpl0(textAlign, paragraphStyle.getTextAlign())) {
            if (TextUnitKt.m21179isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
                if (TextUnit.m21158equalsimpl0(j2, paragraphStyle.getLineHeight())) {
                }
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m20867equalsimpl0(i2, TextDirection.INSTANCE.m20876getUnspecifieds_7Xco()) || TextDirection.m20867equalsimpl0(i2, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m20776equalsimpl0(i4, LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k()) || LineBreak.m20776equalsimpl0(i4, paragraphStyle.getLineBreak())) && ((Hyphens.m20763equalsimpl0(i5, Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8()) || Hyphens.m20763equalsimpl0(i5, paragraphStyle.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long lineHeight = TextUnitKt.m21179isUnspecifiedR2X_6o(j2) ? paragraphStyle.getLineHeight() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m20853equalsimpl0(textAlign, companion.m20863getUnspecifiede0LSkKk())) {
            textAlign = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(textAlign, !TextDirection.m20867equalsimpl0(i2, TextDirection.INSTANCE.m20876getUnspecifieds_7Xco()) ? i2 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m20776equalsimpl0(i4, LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k()) ? i4 : paragraphStyle.getLineBreak(), !Hyphens.m20763equalsimpl0(i5, Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8()) ? i5 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    @Stable
    @NotNull
    public static final ParagraphStyle lerp(@NotNull ParagraphStyle paragraphStyle, @NotNull ParagraphStyle paragraphStyle2, float f) {
        int value = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m20850boximpl(paragraphStyle.getTextAlign()), TextAlign.m20850boximpl(paragraphStyle2.getTextAlign()), f)).getValue();
        int value2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m20864boximpl(paragraphStyle.getTextDirection()), TextDirection.m20864boximpl(paragraphStyle2.getTextDirection()), f)).getValue();
        long jM20412lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m20412lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight(), paragraphStyle2.getLineHeight(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(value, value2, jM20412lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m20770boximpl(paragraphStyle.getLineBreak()), LineBreak.m20770boximpl(paragraphStyle2.getLineBreak()), f)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m20760boximpl(paragraphStyle.getHyphens()), Hyphens.m20760boximpl(paragraphStyle2.getHyphens()), f)).getValue(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        return paragraphStyle.getPlatformStyle() == null ? platformParagraphStyle : platformParagraphStyle == null ? paragraphStyle.getPlatformStyle() : paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }

    @NotNull
    public static final ParagraphStyle resolveParagraphStyleDefaults(@NotNull ParagraphStyle paragraphStyle, @NotNull LayoutDirection layoutDirection) {
        int textAlign = paragraphStyle.getTextAlign();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        int iM20862getStarte0LSkKk = TextAlign.m20853equalsimpl0(textAlign, companion.m20863getUnspecifiede0LSkKk()) ? companion.m20862getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int iM20502resolveTextDirectionIhaHGbI = TextStyleKt.m20502resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnitKt.m21179isUnspecifiedR2X_6o(paragraphStyle.getLineHeight()) ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int lineBreak = paragraphStyle.getLineBreak();
        LineBreak.Companion companion2 = LineBreak.INSTANCE;
        int iM20789getSimplerAG3T2k = LineBreak.m20776equalsimpl0(lineBreak, companion2.m20790getUnspecifiedrAG3T2k()) ? companion2.m20789getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int hyphens = paragraphStyle.getHyphens();
        Hyphens.Companion companion3 = Hyphens.INSTANCE;
        int iM20768getNonevmbZdU8 = Hyphens.m20763equalsimpl0(hyphens, companion3.m20769getUnspecifiedvmbZdU8()) ? companion3.m20768getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(iM20862getStarte0LSkKk, iM20502resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, iM20789getSimplerAG3T2k, iM20768getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }
}
