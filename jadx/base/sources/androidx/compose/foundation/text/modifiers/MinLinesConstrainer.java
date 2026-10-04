package androidx.compose.foundation.text.modifiers;

import androidx.compose.p109ui.text.ParagraphKt;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.TextStyleKt;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DensityKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "inputTextStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getInputTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lineHeightCache", "", "oneLineHeightCache", "resolvedStyle", "coerceMinLines", "Landroidx/compose/ui/unit/Constraints;", "inConstraints", "minLines", "", "coerceMinLines-Oh53vG4$foundation_release", "(JI)J", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMinLinesConstrainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MinLinesConstrainer.kt\nandroidx/compose/foundation/text/modifiers/MinLinesConstrainer\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,142:1\n26#2:143\n*S KotlinDebug\n*F\n+ 1 MinLinesConstrainer.kt\nandroidx/compose/foundation/text/modifiers/MinLinesConstrainer\n*L\n124#1:143\n*E\n"})
public final class MinLinesConstrainer {

    @Nullable
    private static MinLinesConstrainer last;

    @NotNull
    private final Density density;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private final TextStyle inputTextStyle;

    @NotNull
    private final LayoutDirection layoutDirection;
    private float lineHeightCache;
    private float oneLineHeightCache;

    @NotNull
    private final TextStyle resolvedStyle;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer$Companion;", "", "()V", BilouCodec.LAST, "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", Constants.MessagePayloadKeys.FROM, "minMaxUtil", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "paramStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MinLinesConstrainer from(@Nullable MinLinesConstrainer minMaxUtil, @NotNull LayoutDirection layoutDirection, @NotNull TextStyle paramStyle, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
            if (minMaxUtil != null && layoutDirection == minMaxUtil.getLayoutDirection() && Intrinsics.areEqual(paramStyle, minMaxUtil.getInputTextStyle()) && density.getDensity() == minMaxUtil.getDensity().getDensity() && fontFamilyResolver == minMaxUtil.getFontFamilyResolver()) {
                return minMaxUtil;
            }
            MinLinesConstrainer minLinesConstrainer = MinLinesConstrainer.last;
            if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.getLayoutDirection() && Intrinsics.areEqual(paramStyle, minLinesConstrainer.getInputTextStyle()) && density.getDensity() == minLinesConstrainer.getDensity().getDensity() && fontFamilyResolver == minLinesConstrainer.getFontFamilyResolver()) {
                return minLinesConstrainer;
            }
            MinLinesConstrainer minLinesConstrainer2 = new MinLinesConstrainer(layoutDirection, TextStyleKt.resolveDefaults(paramStyle, layoutDirection), DensityKt.Density(density.getDensity(), density.getFontScale()), fontFamilyResolver, null);
            MinLinesConstrainer.last = minLinesConstrainer2;
            return minLinesConstrainer2;
        }

        private Companion() {
        }
    }

    public /* synthetic */ MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily.Resolver resolver, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutDirection, textStyle, density, resolver);
    }

    /* JADX INFO: renamed from: coerceMinLines-Oh53vG4$foundation_release, reason: not valid java name */
    public final long m16471coerceMinLinesOh53vG4$foundation_release(long inConstraints, int minLines) {
        float height = this.oneLineHeightCache;
        float height2 = this.lineHeightCache;
        if (Float.isNaN(height) || Float.isNaN(height2)) {
            height = ParagraphKt.m20338ParagraphUdtVg6A(MinLinesConstrainerKt.EmptyTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.density, this.fontFamilyResolver, (64 & 32) != 0 ? CollectionsKt.emptyList() : null, (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : 1, (64 & 256) != 0 ? false : false).getHeight();
            height2 = ParagraphKt.m20338ParagraphUdtVg6A(MinLinesConstrainerKt.TwoLineTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.density, this.fontFamilyResolver, (64 & 32) != 0 ? CollectionsKt.emptyList() : null, (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : 2, (64 & 256) != 0 ? false : false).getHeight() - height;
            this.oneLineHeightCache = height;
            this.lineHeightCache = height2;
        }
        return ConstraintsKt.Constraints(Constraints.m20923getMinWidthimpl(inConstraints), Constraints.m20921getMaxWidthimpl(inConstraints), minLines != 1 ? RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.round((height2 * (minLines - 1)) + height), 0), Constraints.m20920getMaxHeightimpl(inConstraints)) : Constraints.m20922getMinHeightimpl(inConstraints), Constraints.m20920getMaxHeightimpl(inConstraints));
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @NotNull
    public final TextStyle getInputTextStyle() {
        return this.inputTextStyle;
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    private MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily.Resolver resolver) {
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = textStyle;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
        this.lineHeightCache = Float.NaN;
        this.oneLineHeightCache = Float.NaN;
    }
}
