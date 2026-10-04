package androidx.compose.p109ui.text;

import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008a\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, m13886d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextMeasurer {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int cacheSize;

    @NotNull
    private final Density defaultDensity;

    @NotNull
    private final FontFamily.Resolver defaultFontFamilyResolver;

    @NotNull
    private final LayoutDirection defaultLayoutDirection;

    @Nullable
    private final TextLayoutCache textLayoutCache;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(textLayoutInput.getConstraints());
            int iM20921getMaxWidthimpl = ((textLayoutInput.getSoftWrap() || TextOverflow.m20899equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m20907getEllipsisgIe3tQ8())) && Constraints.m20917getHasBoundedWidthimpl(textLayoutInput.getConstraints())) ? Constraints.m20921getMaxWidthimpl(textLayoutInput.getConstraints()) : Integer.MAX_VALUE;
            int maxLines = (textLayoutInput.getSoftWrap() || !TextOverflow.m20899equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m20907getEllipsisgIe3tQ8())) ? textLayoutInput.getMaxLines() : 1;
            if (iM20923getMinWidthimpl != iM20921getMaxWidthimpl) {
                iM20921getMaxWidthimpl = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), iM20923getMinWidthimpl, iM20921getMaxWidthimpl);
            }
            return new TextLayoutResult(textLayoutInput, new MultiParagraph(multiParagraphIntrinsics, Constraints.INSTANCE.m20930fitPrioritizingWidthZbe2FdA(0, iM20921getMaxWidthimpl, 0, Constraints.m20920getMaxHeightimpl(textLayoutInput.getConstraints())), maxLines, TextOverflow.m20899equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m20907getEllipsisgIe3tQ8()), null), ConstraintsKt.m20935constrain4WqzIAM(textLayoutInput.getConstraints(), IntSizeKt.IntSize((int) Math.ceil(r5.getWidth()), (int) Math.ceil(r5.getHeight()))), null);
        }

        private Companion() {
        }
    }

    public TextMeasurer(@NotNull FontFamily.Resolver resolver, @NotNull Density density, @NotNull LayoutDirection layoutDirection, int i) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    /* JADX INFO: renamed from: measure-wNUYSr0$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m20431measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            textStyle = TextStyle.INSTANCE.getDefault();
        }
        TextStyle textStyle2 = textStyle;
        if ((i4 & 4) != 0) {
            i = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
        }
        return textMeasurer.m20433measurewNUYSr0(str, textStyle2, i, (i4 & 8) != 0 ? true : z, (i4 & 16) != 0 ? Integer.MAX_VALUE : i2, (i4 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i4 & 64) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i4 & 128) != 0 ? textMeasurer.defaultDensity : density, (i4 & 256) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i4 & 512) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: measure-xDpz5zY$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m20432measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            textStyle = TextStyle.INSTANCE.getDefault();
        }
        return textMeasurer.m20434measurexDpz5zY(annotatedString, textStyle, (i4 & 4) != 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i, (i4 & 8) != 0 ? true : z, (i4 & 16) != 0 ? Integer.MAX_VALUE : i2, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list, (i4 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i4 & 128) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i4 & 256) != 0 ? textMeasurer.defaultDensity : density, (i4 & 512) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i4 & 1024) != 0 ? false : z2);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: measure-wNUYSr0, reason: not valid java name */
    public final TextLayoutResult m20433measurewNUYSr0(@NotNull String text, @NotNull TextStyle style, int overflow, boolean softWrap, int maxLines, long constraints, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        return m20432measurexDpz5zY$default(this, new AnnotatedString(text, null, null, 6, null), style, overflow, softWrap, maxLines, null, constraints, layoutDirection, density, fontFamilyResolver, skipCache, 32, null);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: measure-xDpz5zY, reason: not valid java name */
    public final TextLayoutResult m20434measurexDpz5zY(@NotNull AnnotatedString text, @NotNull TextStyle style, int overflow, boolean softWrap, int maxLines, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, long constraints, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        TextLayoutCache textLayoutCache;
        TextLayoutInput textLayoutInput = new TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints, (DefaultConstructorMarker) null);
        TextLayoutResult textLayoutResult = (skipCache || (textLayoutCache = this.textLayoutCache) == null) ? null : textLayoutCache.get(textLayoutInput);
        if (textLayoutResult != null) {
            return textLayoutResult.m20427copyO0kMr_c(textLayoutInput, ConstraintsKt.m20935constrain4WqzIAM(constraints, IntSizeKt.IntSize(ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getWidth()), ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getHeight()))));
        }
        TextLayoutResult textLayoutResultLayout = INSTANCE.layout(textLayoutInput);
        TextLayoutCache textLayoutCache2 = this.textLayoutCache;
        if (textLayoutCache2 != null) {
            textLayoutCache2.put(textLayoutInput, textLayoutResultLayout);
        }
        return textLayoutResultLayout;
    }

    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }
}
