package androidx.compose.p109ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.text.android.selection.WordIterator;
import androidx.compose.p109ui.text.android.style.BaselineShiftSpan;
import androidx.compose.p109ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.p109ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ&\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\tJ\u001d\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b_J\u000e\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\tJ\u0010\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tH\u0002J\u000e\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010l\u001a\u00020\t2\u0006\u0010b\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010p\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010q\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010s\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010t\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010u\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u0016\u0010v\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u0005J\u000e\u0010x\u001a\u00020\t2\u0006\u0010d\u001a\u00020\tJ\u0018\u0010y\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\b\b\u0002\u0010z\u001a\u00020\u0010J2\u0010{\u001a\u0004\u0018\u00010\u00192\u0006\u0010H\u001a\u00020a2\u0006\u0010|\u001a\u00020\t2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u00100~J\u0018\u0010\u007f\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\b\b\u0002\u0010z\u001a\u00020\u0010J#\u0010\u0080\u0001\u001a\u00020W2\u0007\u0010\u0081\u0001\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\tJ\u000f\u0010\u0088\u0001\u001a\u00020\u00102\u0006\u0010b\u001a\u00020\tJ\u0011\u0010\u0089\u0001\u001a\u00020W2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u000e\u0010.\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010$\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u0011\u0010C\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bG\u0010ER\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001c\u0010P\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010$\u001a\u0004\bR\u0010&R\u0011\u0010S\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006\u008c\u0001"}, m13886d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "lastLineExtra", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "leftPadding", "lineCount", "getLineCount", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "rect", "Landroid/graphics/Rect;", "rightPadding", "text", "getText", "()Ljava/lang/CharSequence;", "getTextPaint", "()Landroid/text/TextPaint;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "wordIterator", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "fillLineHorizontalBounds", "lineIndex", "fillLineHorizontalBounds$ui_text_release", "getBoundingBox", "Landroid/graphics/RectF;", TypedValues.Cycle.S_WAVE_OFFSET, "getHorizontalPadding", "line", "getLineAscent", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getRangeForRect", "granularity", "inclusionStrategy", "Lkotlin/Function2;", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextLayout.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextLayout.android.kt\nandroidx/compose/ui/text/android/TextLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1155:1\n1#2:1156\n*E\n"})
public final class TextLayout {
    public static final int $stable = 8;

    @Nullable
    private LayoutHelper backingLayoutHelper;

    @Nullable
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;

    @Nullable
    private final Paint.FontMetricsInt lastLineFontMetrics;

    @NotNull
    private final Layout layout;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;

    @Nullable
    private final LineHeightStyleSpan[] lineHeightSpans;

    @NotNull
    private final Rect rect;
    private final float rightPadding;

    @NotNull
    private final TextPaint textPaint;
    private final int topPadding;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    public TextLayout(@NotNull CharSequence charSequence, float f, @NotNull TextPaint textPaint, int i, @Nullable TextUtils.TruncateAt truncateAt, int i2, float f4, @Px float f5, boolean z, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, @Nullable int[] iArr, @Nullable int[] iArr2, @NotNull LayoutIntrinsics layoutIntrinsics) {
        TextPaint textPaint2;
        int i10;
        boolean z3;
        TextDirectionHeuristic textDirectionHeuristic;
        boolean z4;
        Layout layoutCreate;
        this.textPaint = textPaint;
        this.includePadding = z;
        this.fallbackLineSpacing = z2;
        this.layoutIntrinsics = layoutIntrinsics;
        this.rect = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayout_androidKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i);
        boolean z5 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
            double d = f;
            int iCeil = (int) Math.ceil(d);
            if (boringMetrics == null || layoutIntrinsics.getMaxIntrinsicWidth() > f || z5) {
                this.isBoringLayout = false;
                int iCeil2 = (int) Math.ceil(d);
                textPaint2 = textPaint;
                i10 = i4;
                z3 = false;
                textDirectionHeuristic = textDirectionHeuristic2;
                z4 = true;
                layoutCreate = StaticLayoutFactory.INSTANCE.create(charSequence, textPaint2, iCeil, 0, charSequence.length(), textDirectionHeuristic, alignment, i10, truncateAt, iCeil2, f4, f5, i9, z, z2, i5, i6, i7, i8, iArr, iArr2);
            } else {
                this.isBoringLayout = true;
                textPaint2 = textPaint;
                i10 = i4;
                layoutCreate = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, iCeil, boringMetrics, alignment, z, z2, truncateAt, iCeil);
                textDirectionHeuristic = textDirectionHeuristic2;
                z4 = true;
                z3 = false;
            }
            this.layout = layoutCreate;
            Trace.endSection();
            int iMin = Math.min(layoutCreate.getLineCount(), i10);
            this.lineCount = iMin;
            int i11 = iMin - 1;
            this.didExceedMaxLines = (iMin >= i10 && (layoutCreate.getEllipsisCount(i11) > 0 || layoutCreate.getLineEnd(i11) != charSequence.length())) ? z4 : z3;
            long verticalPaddings = TextLayout_androidKt.getVerticalPaddings(this);
            LineHeightStyleSpan[] lineHeightSpans = TextLayout_androidKt.getLineHeightSpans(this);
            this.lineHeightSpans = lineHeightSpans;
            long lineHeightPaddings = lineHeightSpans != null ? TextLayout_androidKt.getLineHeightPaddings(lineHeightSpans) : TextLayout_androidKt.ZeroVerticalPadding;
            this.topPadding = Math.max(VerticalPaddings.m20508getTopPaddingimpl(verticalPaddings), VerticalPaddings.m20508getTopPaddingimpl(lineHeightPaddings));
            this.bottomPadding = Math.max(VerticalPaddings.m20507getBottomPaddingimpl(verticalPaddings), VerticalPaddings.m20507getBottomPaddingimpl(lineHeightPaddings));
            Paint.FontMetricsInt lastLineMetrics = TextLayout_androidKt.getLastLineMetrics(this, textPaint2, textDirectionHeuristic, lineHeightSpans);
            this.lastLineExtra = lastLineMetrics != null ? lastLineMetrics.bottom - ((int) getLineHeight(i11)) : z3;
            this.lastLineFontMetrics = lastLineMetrics;
            this.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(layoutCreate, i11, null, 2, null);
            this.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(layoutCreate, i11, null, 2, null);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final float getHorizontalPadding(int line) {
        if (line == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    private final LayoutHelper getLayoutHelper() {
        LayoutHelper layoutHelper = this.backingLayoutHelper;
        if (layoutHelper != null) {
            Intrinsics.checkNotNull(layoutHelper);
            return layoutHelper;
        }
        LayoutHelper layoutHelper2 = new LayoutHelper(this.layout);
        this.backingLayoutHelper = layoutHelper2;
        return layoutHelper2;
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getPrimaryHorizontal(i, z);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getSecondaryHorizontal(i, z);
    }

    public final void fillBoundingBoxes(int startOffset, int endOffset, @NotNull float[] array, int arrayStart) {
        float secondaryDownstream;
        float secondaryUpstream;
        int length = getText().length();
        if (startOffset < 0) {
            throw new IllegalArgumentException("startOffset must be > 0");
        }
        if (startOffset >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length");
        }
        if (endOffset <= startOffset) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset");
        }
        if (endOffset > length) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length");
        }
        if (array.length - arrayStart < (endOffset - startOffset) * 4) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }
        int lineForOffset = getLineForOffset(startOffset);
        int lineForOffset2 = getLineForOffset(endOffset - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        while (true) {
            int lineStart = getLineStart(lineForOffset);
            int lineEnd = getLineEnd(lineForOffset);
            int iMin = Math.min(endOffset, lineEnd);
            float lineTop = getLineTop(lineForOffset);
            float lineBottom = getLineBottom(lineForOffset);
            boolean z = getParagraphDirection(lineForOffset) == 1;
            for (int iMax = Math.max(startOffset, lineStart); iMax < iMin; iMax++) {
                boolean zIsRtlCharAt = isRtlCharAt(iMax);
                if (z && !zIsRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                } else if (z && zIsRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                } else if (z || !zIsRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                } else {
                    secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                }
                array[arrayStart] = secondaryDownstream;
                array[arrayStart + 1] = lineTop;
                array[arrayStart + 2] = secondaryUpstream;
                array[arrayStart + 3] = lineBottom;
                arrayStart += 4;
            }
            if (lineForOffset == lineForOffset2) {
                return;
            } else {
                lineForOffset++;
            }
        }
    }

    public final void fillLineHorizontalBounds$ui_text_release(int lineIndex, @NotNull float[] array) {
        float secondaryDownstream;
        float secondaryUpstream;
        int lineStart = getLineStart(lineIndex);
        int lineEnd = getLineEnd(lineIndex);
        if (array.length < (lineEnd - lineStart) * 2) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        int i = 0;
        boolean z = getParagraphDirection(lineIndex) == 1;
        while (lineStart < lineEnd) {
            boolean zIsRtlCharAt = isRtlCharAt(lineStart);
            if (z && !zIsRtlCharAt) {
                secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(lineStart);
                secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
            } else if (z && zIsRtlCharAt) {
                secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(lineStart);
                secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
            } else if (zIsRtlCharAt) {
                secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(lineStart);
                secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
            } else {
                secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(lineStart);
                secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
            }
            array[i] = secondaryDownstream;
            array[i + 1] = secondaryUpstream;
            i += 2;
            lineStart++;
        }
    }

    /* JADX INFO: renamed from: getBottomPadding$ui_text_release, reason: from getter */
    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    @NotNull
    public final RectF getBoundingBox(int offset) {
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        int lineForOffset = getLineForOffset(offset);
        float lineTop = getLineTop(lineForOffset);
        float lineBottom = getLineBottom(lineForOffset);
        boolean z = getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = this.layout.isRtlCharAt(offset);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                primaryHorizontal = getSecondaryHorizontal(offset, false);
                primaryHorizontal2 = getSecondaryHorizontal(offset + 1, true);
            } else if (zIsRtlCharAt) {
                primaryHorizontal = getPrimaryHorizontal(offset, false);
                primaryHorizontal2 = getPrimaryHorizontal(offset + 1, true);
            } else {
                secondaryHorizontal = getSecondaryHorizontal(offset, false);
                secondaryHorizontal2 = getSecondaryHorizontal(offset + 1, true);
            }
            float f = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f;
        } else {
            secondaryHorizontal = getPrimaryHorizontal(offset, false);
            secondaryHorizontal2 = getPrimaryHorizontal(offset + 1, true);
        }
        return new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        return (this.didExceedMaxLines ? this.layout.getLineBottom(this.lineCount - 1) : this.layout.getHeight()) + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int line) {
        Paint.FontMetricsInt fontMetricsInt;
        return (line != this.lineCount + (-1) || (fontMetricsInt = this.lastLineFontMetrics) == null) ? this.layout.getLineAscent(line) : fontMetricsInt.ascent;
    }

    public final float getLineBaseline(int line) {
        return this.topPadding + ((line != this.lineCount + (-1) || this.lastLineFontMetrics == null) ? this.layout.getLineBaseline(line) : getLineTop(line) - this.lastLineFontMetrics.ascent);
    }

    public final float getLineBottom(int line) {
        if (line != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            return this.topPadding + this.layout.getLineBottom(line) + (line == this.lineCount + (-1) ? this.bottomPadding : 0);
        }
        return this.layout.getLineBottom(line - 1) + this.lastLineFontMetrics.bottom;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int line) {
        Paint.FontMetricsInt fontMetricsInt;
        return (line != this.lineCount + (-1) || (fontMetricsInt = this.lastLineFontMetrics) == null) ? this.layout.getLineDescent(line) : fontMetricsInt.descent;
    }

    public final int getLineEllipsisCount(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex);
    }

    public final int getLineEllipsisOffset(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex);
    }

    public final int getLineEnd(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex) == 0 ? this.layout.getLineEnd(lineIndex) : this.layout.getText().length();
    }

    public final int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public final int getLineForVertical(int vertical) {
        return this.layout.getLineForVertical(vertical - this.topPadding);
    }

    public final float getLineHeight(int lineIndex) {
        return getLineBottom(lineIndex) - getLineTop(lineIndex);
    }

    public final float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex) + (lineIndex == this.lineCount + (-1) ? this.leftPadding : 0.0f);
    }

    public final float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex) + (lineIndex == this.lineCount + (-1) ? this.rightPadding : 0.0f);
    }

    public final int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public final float getLineTop(int line) {
        return this.layout.getLineTop(line) + (line == 0 ? 0 : this.topPadding);
    }

    public final int getLineVisibleEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return getLayoutHelper().getLineVisibleEnd(lineIndex);
        }
        return this.layout.getEllipsisStart(lineIndex) + this.layout.getLineStart(lineIndex);
    }

    public final float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int line, float horizontal) {
        return this.layout.getOffsetForHorizontal(line, ((-1) * getHorizontalPadding(line)) + horizontal);
    }

    public final int getParagraphDirection(int line) {
        return this.layout.getParagraphDirection(line);
    }

    public final float getPrimaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, true, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    @Nullable
    public final int[] getRangeForRect(@NotNull RectF rect, int granularity, @NotNull Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        return Build.VERSION.SDK_INT >= 34 ? AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text_release(this, rect, granularity, inclusionStrategy) : TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, getLayoutHelper(), rect, granularity, inclusionStrategy);
    }

    public final float getSecondaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, false, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    public final void getSelectionPath(int start, int end, @NotNull Path dest) {
        this.layout.getSelectionPath(start, end, dest);
        if (this.topPadding == 0 || dest.isEmpty()) {
            return;
        }
        dest.offset(0.0f, this.topPadding);
    }

    @NotNull
    public final CharSequence getText() {
        return this.layout.getText();
    }

    @NotNull
    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    /* JADX INFO: renamed from: getTopPadding$ui_text_release, reason: from getter */
    public final int getTopPadding() {
        return this.topPadding;
    }

    @NotNull
    public final WordIterator getWordIterator() {
        WordIterator wordIterator = this.backingWordIterator;
        if (wordIterator != null) {
            return wordIterator;
        }
        WordIterator wordIterator2 = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = wordIterator2;
        return wordIterator2;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout = this.layout;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout2 = this.layout;
        Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout2, this.fallbackLineSpacing);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return TextLayout_androidKt.isLineEllipsized(this.layout, lineIndex);
    }

    public final boolean isRtlCharAt(int offset) {
        return this.layout.isRtlCharAt(offset);
    }

    public final void paint(@NotNull Canvas canvas) {
        if (canvas.getClipBounds(this.rect)) {
            int i = this.topPadding;
            if (i != 0) {
                canvas.translate(0.0f, i);
            }
            TextAndroidCanvas textAndroidCanvas = TextLayout_androidKt.SharedTextAndroidCanvas;
            textAndroidCanvas.setCanvas(canvas);
            this.layout.draw(textAndroidCanvas);
            int i2 = this.topPadding;
            if (i2 != 0) {
                canvas.translate(0.0f, (-1) * i2);
            }
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLayout$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    public /* synthetic */ TextLayout(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, float f4, float f5, boolean z, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        CharSequence charSequence2;
        TextPaint textPaint2;
        LayoutIntrinsics layoutIntrinsics2;
        int i11 = (i10 & 8) != 0 ? 0 : i;
        TextUtils.TruncateAt truncateAt2 = (i10 & 16) != 0 ? null : truncateAt;
        int i12 = (i10 & 32) != 0 ? 2 : i2;
        float f6 = (i10 & 64) != 0 ? 1.0f : f4;
        float f7 = (i10 & 128) != 0 ? 0.0f : f5;
        boolean z3 = (i10 & 256) != 0 ? false : z;
        boolean z4 = (i10 & 512) != 0 ? true : z2;
        int i13 = (i10 & 1024) != 0 ? Integer.MAX_VALUE : i4;
        int i14 = (i10 & 2048) != 0 ? 0 : i5;
        int i15 = (i10 & 4096) != 0 ? 0 : i6;
        int i16 = (i10 & 8192) != 0 ? 0 : i7;
        int i17 = (i10 & 16384) != 0 ? 0 : i8;
        int i18 = (32768 & i10) != 0 ? 0 : i9;
        int[] iArr3 = (65536 & i10) != 0 ? null : iArr;
        int[] iArr4 = (131072 & i10) != 0 ? null : iArr2;
        if ((i10 & 262144) != 0) {
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            layoutIntrinsics2 = new LayoutIntrinsics(charSequence2, textPaint2, i12);
        } else {
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            layoutIntrinsics2 = layoutIntrinsics;
        }
        this(charSequence2, f, textPaint2, i11, truncateAt2, i12, f6, f7, z3, z4, i13, i14, i15, i16, i17, i18, iArr3, iArr4, layoutIntrinsics2);
    }
}
