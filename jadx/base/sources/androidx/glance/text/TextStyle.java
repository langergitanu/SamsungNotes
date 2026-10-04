package androidx.glance.text;

import androidx.annotation.DimenRes;
import androidx.annotation.StyleRes;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.runtime.Immutable;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B«\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0003\u0010\u001e\u001a\u00020\u0019¢\u0006\u0002\u0010\u001fJ¶\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010>\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0013\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010C\u001a\u00020\u0019H\u0016J\b\u0010D\u001a\u00020EH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0019\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0019\u0010\f\u001a\u0004\u0018\u00010\rø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00107\u001a\u0004\b6\u00103R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, m13886d2 = {"Landroidx/glance/text/TextStyle;", "", "color", "Landroidx/glance/unit/ColorProvider;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/glance/text/FontWeight;", "fontStyle", "Landroidx/glance/text/FontStyle;", "textAlign", "Landroidx/glance/text/TextAlign;", "textDecoration", "Landroidx/glance/text/TextDecoration;", "fontFamily", "Landroidx/glance/text/FontFamily;", "textDirection", "Landroidx/glance/text/TextDirection;", "hasShadow", "", "textShadowStyle", "Landroidx/glance/text/TextShadowStyle;", "complexUnit", "Landroidx/glance/text/ComplexUnit;", "textSizeDimenResource", "", "percentData", "Landroidx/glance/text/TextPercentData;", "textVerticalAlign", "Landroidx/glance/text/TextVerticalAlign;", "textAppearanceResource", "(Landroidx/glance/unit/ColorProvider;Landroidx/compose/ui/unit/TextUnit;Landroidx/glance/text/FontWeight;Landroidx/glance/text/FontStyle;Landroidx/glance/text/TextAlign;Landroidx/glance/text/TextDecoration;Landroidx/glance/text/FontFamily;IZLandroidx/glance/text/TextShadowStyle;Landroidx/glance/text/ComplexUnit;ILandroidx/glance/text/TextPercentData;Landroidx/glance/text/TextVerticalAlign;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor", "()Landroidx/glance/unit/ColorProvider;", "getComplexUnit", "()Landroidx/glance/text/ComplexUnit;", "getFontFamily", "()Landroidx/glance/text/FontFamily;", "getFontSize-U3a4LBI", "()Landroidx/compose/ui/unit/TextUnit;", "getFontStyle-xuO1esU", "()Landroidx/glance/text/FontStyle;", "getFontWeight-pJbD0qI", "()Landroidx/glance/text/FontWeight;", "getHasShadow", "()Z", "getPercentData", "()Landroidx/glance/text/TextPercentData;", "getTextAlign-B6tg0O8", "()Landroidx/glance/text/TextAlign;", "getTextAppearanceResource", "()I", "getTextDecoration-W4vNVHs", "()Landroidx/glance/text/TextDecoration;", "getTextDirection-yyWj0Bs", "I", "getTextShadowStyle", "()Landroidx/glance/text/TextShadowStyle;", "getTextSizeDimenResource", "getTextVerticalAlign-83RENfk", "()Landroidx/glance/text/TextVerticalAlign;", "copy", "textSizeResId", "copy-fnGRNro", "(Landroidx/glance/unit/ColorProvider;Landroidx/compose/ui/unit/TextUnit;Landroidx/glance/text/FontWeight;Landroidx/glance/text/FontStyle;Landroidx/glance/text/TextAlign;Landroidx/glance/text/TextDecoration;Landroidx/glance/text/FontFamily;IZLandroidx/glance/text/TextShadowStyle;Landroidx/glance/text/ComplexUnit;ILandroidx/glance/text/TextPercentData;Landroidx/glance/text/TextVerticalAlign;I)Landroidx/glance/text/TextStyle;", "equals", "other", "hashCode", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextStyle {
    public static final int $stable = 0;

    @NotNull
    private final ColorProvider color;

    @NotNull
    private final ComplexUnit complexUnit;

    @Nullable
    private final FontFamily fontFamily;

    @Nullable
    private final TextUnit fontSize;

    @Nullable
    private final FontStyle fontStyle;

    @Nullable
    private final FontWeight fontWeight;
    private final boolean hasShadow;

    @Nullable
    private final TextPercentData percentData;

    @Nullable
    private final TextAlign textAlign;
    private final int textAppearanceResource;

    @Nullable
    private final TextDecoration textDecoration;
    private final int textDirection;

    @NotNull
    private final TextShadowStyle textShadowStyle;
    private final int textSizeDimenResource;

    @Nullable
    private final TextVerticalAlign textVerticalAlign;

    public /* synthetic */ TextStyle(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, int i, boolean z, TextShadowStyle textShadowStyle, ComplexUnit complexUnit, @DimenRes int i2, TextPercentData textPercentData, TextVerticalAlign textVerticalAlign, @StyleRes int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, textUnit, fontWeight, fontStyle, textAlign, textDecoration, fontFamily, i, z, textShadowStyle, complexUnit, i2, textPercentData, textVerticalAlign, i4);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-fnGRNro, reason: not valid java name */
    public final TextStyle m22037copyfnGRNro(@NotNull ColorProvider color, @Nullable TextUnit fontSize, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable TextAlign textAlign, @Nullable TextDecoration textDecoration, @Nullable FontFamily fontFamily, int textDirection, boolean hasShadow, @NotNull TextShadowStyle textShadowStyle, @NotNull ComplexUnit complexUnit, int textSizeResId, @Nullable TextPercentData percentData, @Nullable TextVerticalAlign textVerticalAlign, int textAppearanceResource) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
        Intrinsics.checkNotNullParameter(complexUnit, "complexUnit");
        return new TextStyle(color, fontSize, fontWeight, fontStyle, textAlign, textDecoration, fontFamily, textDirection, hasShadow, textShadowStyle, complexUnit, textSizeResId, percentData, textVerticalAlign, textAppearanceResource, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) other;
        return Intrinsics.areEqual(this.color, textStyle.color) && Intrinsics.areEqual(this.fontSize, textStyle.fontSize) && Intrinsics.areEqual(this.fontWeight, textStyle.fontWeight) && Intrinsics.areEqual(this.fontStyle, textStyle.fontStyle) && Intrinsics.areEqual(this.textDecoration, textStyle.textDecoration) && Intrinsics.areEqual(this.textAlign, textStyle.textAlign) && Intrinsics.areEqual(this.fontFamily, textStyle.fontFamily) && TextDirection.m22028equalsimpl0(this.textDirection, textStyle.textDirection) && this.hasShadow == textStyle.hasShadow && Intrinsics.areEqual(this.textShadowStyle, textStyle.textShadowStyle) && this.complexUnit == textStyle.complexUnit && this.textSizeDimenResource == textStyle.textSizeDimenResource && Intrinsics.areEqual(this.percentData, textStyle.percentData) && Intrinsics.areEqual(this.textVerticalAlign, textStyle.textVerticalAlign) && this.textAppearanceResource == textStyle.textAppearanceResource;
    }

    @NotNull
    public final ColorProvider getColor() {
        return this.color;
    }

    @NotNull
    public final ComplexUnit getComplexUnit() {
        return this.complexUnit;
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    /* JADX INFO: renamed from: getFontSize-U3a4LBI, reason: not valid java name and from getter */
    public final TextUnit getFontSize() {
        return this.fontSize;
    }

    @Nullable
    /* JADX INFO: renamed from: getFontStyle-xuO1esU, reason: not valid java name and from getter */
    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    @Nullable
    /* JADX INFO: renamed from: getFontWeight-pJbD0qI, reason: not valid java name and from getter */
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final boolean getHasShadow() {
        return this.hasShadow;
    }

    @Nullable
    public final TextPercentData getPercentData() {
        return this.percentData;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextAlign-B6tg0O8, reason: not valid java name and from getter */
    public final TextAlign getTextAlign() {
        return this.textAlign;
    }

    public final int getTextAppearanceResource() {
        return this.textAppearanceResource;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextDecoration-W4vNVHs, reason: not valid java name and from getter */
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    /* JADX INFO: renamed from: getTextDirection-yyWj0Bs, reason: not valid java name and from getter */
    public final int getTextDirection() {
        return this.textDirection;
    }

    @NotNull
    public final TextShadowStyle getTextShadowStyle() {
        return this.textShadowStyle;
    }

    public final int getTextSizeDimenResource() {
        return this.textSizeDimenResource;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextVerticalAlign-83RENfk, reason: not valid java name and from getter */
    public final TextVerticalAlign getTextVerticalAlign() {
        return this.textVerticalAlign;
    }

    public int hashCode() {
        int iHashCode = this.color.hashCode() * 31;
        TextUnit textUnit = this.fontSize;
        int iHashCode2 = (iHashCode + (textUnit != null ? textUnit.hashCode() : 0)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode3 = (iHashCode2 + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int iHashCode4 = (iHashCode3 + (fontStyle != null ? fontStyle.hashCode() : 0)) * 31;
        TextDecoration textDecoration = this.textDecoration;
        int iHashCode5 = (iHashCode4 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        TextAlign textAlign = this.textAlign;
        int iHashCode6 = (iHashCode5 + (textAlign != null ? textAlign.hashCode() : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int iM1157c = AbstractC0622a.m1157c(this.textSizeDimenResource, (this.complexUnit.hashCode() + ((this.textShadowStyle.hashCode() + AbstractC0622a.m1160f(this.hasShadow, (TextDirection.m22029hashCodeimpl(this.textDirection) + ((iHashCode6 + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31)) * 31, 31)) * 31)) * 31, 31);
        TextPercentData textPercentData = this.percentData;
        int iHashCode7 = (iM1157c + (textPercentData != null ? textPercentData.hashCode() : 0)) * 31;
        TextVerticalAlign textVerticalAlign = this.textVerticalAlign;
        return Integer.hashCode(this.textAppearanceResource) + ((iHashCode7 + (textVerticalAlign != null ? textVerticalAlign.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        return "TextStyle(color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", textDecoration=" + this.textDecoration + ", textAlign=" + this.textAlign + ", fontFamily=" + this.fontFamily + ", hasShadow=" + this.hasShadow + " textShadowStyle=" + this.textShadowStyle + "textSizeResId=" + this.textSizeDimenResource + ", useDp=" + this.complexUnit + ", textVerticalAlign=" + this.textVerticalAlign + "), textAppearanceResource=" + this.textAppearanceResource;
    }

    private TextStyle(ColorProvider color, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, int i, boolean z, TextShadowStyle textShadowStyle, ComplexUnit complexUnit, int i2, TextPercentData textPercentData, TextVerticalAlign textVerticalAlign, int i4) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
        Intrinsics.checkNotNullParameter(complexUnit, "complexUnit");
        this.color = color;
        this.fontSize = textUnit;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.textAlign = textAlign;
        this.textDecoration = textDecoration;
        this.fontFamily = fontFamily;
        this.textDirection = i;
        this.hasShadow = z;
        this.textShadowStyle = textShadowStyle;
        this.complexUnit = complexUnit;
        this.textSizeDimenResource = i2;
        this.percentData = textPercentData;
        this.textVerticalAlign = textVerticalAlign;
        this.textAppearanceResource = i4;
    }

    public /* synthetic */ TextStyle(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, int i, boolean z, TextShadowStyle textShadowStyle, ComplexUnit complexUnit, int i2, TextPercentData textPercentData, TextVerticalAlign textVerticalAlign, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? TextDefaults.INSTANCE.getDefaultTextColor() : colorProvider, (i5 & 2) != 0 ? null : textUnit, (i5 & 4) != 0 ? null : fontWeight, (i5 & 8) != 0 ? null : fontStyle, (i5 & 16) != 0 ? null : textAlign, (i5 & 32) != 0 ? null : textDecoration, (i5 & 64) != 0 ? null : fontFamily, (i5 & 128) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i, (i5 & 256) != 0 ? false : z, (i5 & 512) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i5 & 1024) != 0 ? ComplexUnit.f1614SP : complexUnit, (i5 & 2048) != 0 ? 0 : i2, (i5 & 4096) != 0 ? null : textPercentData, (i5 & 8192) != 0 ? null : textVerticalAlign, (i5 & 16384) == 0 ? i4 : 0, null);
    }
}
