package androidx.compose.material3.tokens;

import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.GenericFontFamily;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, m13886d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TypographyTokens {

    @NotNull
    private static final TextStyle BodyLarge;

    @NotNull
    private static final TextStyle BodyMedium;

    @NotNull
    private static final TextStyle BodySmall;

    @NotNull
    private static final TextStyle DisplayLarge;

    @NotNull
    private static final TextStyle DisplayMedium;

    @NotNull
    private static final TextStyle DisplaySmall;

    @NotNull
    private static final TextStyle HeadlineLarge;

    @NotNull
    private static final TextStyle HeadlineMedium;

    @NotNull
    private static final TextStyle HeadlineSmall;

    @NotNull
    public static final TypographyTokens INSTANCE = new TypographyTokens();

    @NotNull
    private static final TextStyle LabelLarge;

    @NotNull
    private static final TextStyle LabelMedium;

    @NotNull
    private static final TextStyle LabelSmall;

    @NotNull
    private static final TextStyle TitleLarge;

    @NotNull
    private static final TextStyle TitleMedium;

    @NotNull
    private static final TextStyle TitleSmall;

    static {
        TypeScaleTokens typeScaleTokens = TypeScaleTokens.INSTANCE;
        GenericFontFamily bodyLargeFont = typeScaleTokens.getBodyLargeFont();
        BodyLarge = new TextStyle(0L, typeScaleTokens.m17937getBodyLargeSizeXSAIIZE(), typeScaleTokens.getBodyLargeWeight(), (FontStyle) null, (FontSynthesis) null, bodyLargeFont, (String) null, typeScaleTokens.m17938getBodyLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17936getBodyLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodyMediumFont = typeScaleTokens.getBodyMediumFont();
        BodyMedium = new TextStyle(0L, typeScaleTokens.m17940getBodyMediumSizeXSAIIZE(), typeScaleTokens.getBodyMediumWeight(), (FontStyle) null, (FontSynthesis) null, bodyMediumFont, (String) null, typeScaleTokens.m17941getBodyMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17939getBodyMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodySmallFont = typeScaleTokens.getBodySmallFont();
        BodySmall = new TextStyle(0L, typeScaleTokens.m17943getBodySmallSizeXSAIIZE(), typeScaleTokens.getBodySmallWeight(), (FontStyle) null, (FontSynthesis) null, bodySmallFont, (String) null, typeScaleTokens.m17944getBodySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17942getBodySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayLargeFont = typeScaleTokens.getDisplayLargeFont();
        DisplayLarge = new TextStyle(0L, typeScaleTokens.m17946getDisplayLargeSizeXSAIIZE(), typeScaleTokens.getDisplayLargeWeight(), (FontStyle) null, (FontSynthesis) null, displayLargeFont, (String) null, typeScaleTokens.m17947getDisplayLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17945getDisplayLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayMediumFont = typeScaleTokens.getDisplayMediumFont();
        DisplayMedium = new TextStyle(0L, typeScaleTokens.m17949getDisplayMediumSizeXSAIIZE(), typeScaleTokens.getDisplayMediumWeight(), (FontStyle) null, (FontSynthesis) null, displayMediumFont, (String) null, typeScaleTokens.m17950getDisplayMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17948getDisplayMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displaySmallFont = typeScaleTokens.getDisplaySmallFont();
        DisplaySmall = new TextStyle(0L, typeScaleTokens.m17952getDisplaySmallSizeXSAIIZE(), typeScaleTokens.getDisplaySmallWeight(), (FontStyle) null, (FontSynthesis) null, displaySmallFont, (String) null, typeScaleTokens.m17953getDisplaySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17951getDisplaySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineLargeFont = typeScaleTokens.getHeadlineLargeFont();
        HeadlineLarge = new TextStyle(0L, typeScaleTokens.m17955getHeadlineLargeSizeXSAIIZE(), typeScaleTokens.getHeadlineLargeWeight(), (FontStyle) null, (FontSynthesis) null, headlineLargeFont, (String) null, typeScaleTokens.m17956getHeadlineLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17954getHeadlineLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineMediumFont = typeScaleTokens.getHeadlineMediumFont();
        HeadlineMedium = new TextStyle(0L, typeScaleTokens.m17958getHeadlineMediumSizeXSAIIZE(), typeScaleTokens.getHeadlineMediumWeight(), (FontStyle) null, (FontSynthesis) null, headlineMediumFont, (String) null, typeScaleTokens.m17959getHeadlineMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17957getHeadlineMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineSmallFont = typeScaleTokens.getHeadlineSmallFont();
        HeadlineSmall = new TextStyle(0L, typeScaleTokens.m17961getHeadlineSmallSizeXSAIIZE(), typeScaleTokens.getHeadlineSmallWeight(), (FontStyle) null, (FontSynthesis) null, headlineSmallFont, (String) null, typeScaleTokens.m17962getHeadlineSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17960getHeadlineSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelLargeFont = typeScaleTokens.getLabelLargeFont();
        LabelLarge = new TextStyle(0L, typeScaleTokens.m17964getLabelLargeSizeXSAIIZE(), typeScaleTokens.getLabelLargeWeight(), (FontStyle) null, (FontSynthesis) null, labelLargeFont, (String) null, typeScaleTokens.m17965getLabelLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17963getLabelLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelMediumFont = typeScaleTokens.getLabelMediumFont();
        LabelMedium = new TextStyle(0L, typeScaleTokens.m17967getLabelMediumSizeXSAIIZE(), typeScaleTokens.getLabelMediumWeight(), (FontStyle) null, (FontSynthesis) null, labelMediumFont, (String) null, typeScaleTokens.m17968getLabelMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17966getLabelMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelSmallFont = typeScaleTokens.getLabelSmallFont();
        LabelSmall = new TextStyle(0L, typeScaleTokens.m17970getLabelSmallSizeXSAIIZE(), typeScaleTokens.getLabelSmallWeight(), (FontStyle) null, (FontSynthesis) null, labelSmallFont, (String) null, typeScaleTokens.m17971getLabelSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17969getLabelSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleLargeFont = typeScaleTokens.getTitleLargeFont();
        TitleLarge = new TextStyle(0L, typeScaleTokens.m17973getTitleLargeSizeXSAIIZE(), typeScaleTokens.getTitleLargeWeight(), (FontStyle) null, (FontSynthesis) null, titleLargeFont, (String) null, typeScaleTokens.m17974getTitleLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17972getTitleLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleMediumFont = typeScaleTokens.getTitleMediumFont();
        TitleMedium = new TextStyle(0L, typeScaleTokens.m17976getTitleMediumSizeXSAIIZE(), typeScaleTokens.getTitleMediumWeight(), (FontStyle) null, (FontSynthesis) null, titleMediumFont, (String) null, typeScaleTokens.m17977getTitleMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17975getTitleMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleSmallFont = typeScaleTokens.getTitleSmallFont();
        TitleSmall = new TextStyle(0L, typeScaleTokens.m17979getTitleSmallSizeXSAIIZE(), typeScaleTokens.getTitleSmallWeight(), (FontStyle) null, (FontSynthesis) null, titleSmallFont, (String) null, typeScaleTokens.m17980getTitleSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m17978getTitleSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
    }

    private TypographyTokens() {
    }

    @NotNull
    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    @NotNull
    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    @NotNull
    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    @NotNull
    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    @NotNull
    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    @NotNull
    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    @NotNull
    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    @NotNull
    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    @NotNull
    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    @NotNull
    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    @NotNull
    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    @NotNull
    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    @NotNull
    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    @NotNull
    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    @NotNull
    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
