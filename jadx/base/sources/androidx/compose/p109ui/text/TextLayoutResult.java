package androidx.compose.p109ui.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u00101\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u00106\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0010J\u000e\u0010;\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010=\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010>\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020Aø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u000e\u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001aJ\u001b\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020\u001aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020\u001aH\u0016J\u000e\u0010N\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001aJ\b\u0010O\u001a\u00020PH\u0016R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "firstBaseline", "", "getFirstBaseline", "()F", "hasVisualOverflow", "getHasVisualOverflow", "lastBaseline", "getLastBaseline", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "lineCount", "", "getLineCount", "()I", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "getSize-YbymL2g", "()J", "J", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.Cycle.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "hashCode", "isLineEllipsized", "toString", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextLayoutResult {
    public static final int $stable = 8;
    private final float firstBaseline;
    private final float lastBaseline;

    @NotNull
    private final TextLayoutInput layoutInput;

    @NotNull
    private final MultiParagraph multiParagraph;

    @NotNull
    private final List<Rect> placeholderRects;
    private final long size;

    public /* synthetic */ TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutInput, multiParagraph, j);
    }

    /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m20426copyO0kMr_c$default(TextLayoutResult textLayoutResult, TextLayoutInput textLayoutInput, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            textLayoutInput = textLayoutResult.layoutInput;
        }
        if ((i & 2) != 0) {
            j = textLayoutResult.size;
        }
        return textLayoutResult.m20427copyO0kMr_c(textLayoutInput, j);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResult textLayoutResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResult.getLineEnd(i, z);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
    public final TextLayoutResult m20427copyO0kMr_c(@NotNull TextLayoutInput layoutInput, long size) {
        return new TextLayoutResult(layoutInput, this.multiParagraph, size, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextLayoutResult)) {
            return false;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) other;
        return Intrinsics.areEqual(this.layoutInput, textLayoutResult.layoutInput) && Intrinsics.areEqual(this.multiParagraph, textLayoutResult.multiParagraph) && IntSize.m21136equalsimpl0(this.size, textLayoutResult.size) && this.firstBaseline == textLayoutResult.firstBaseline && this.lastBaseline == textLayoutResult.lastBaseline && Intrinsics.areEqual(this.placeholderRects, textLayoutResult.placeholderRects);
    }

    @NotNull
    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        return this.multiParagraph.getBidiRunDirection(offset);
    }

    @NotNull
    public final Rect getBoundingBox(int offset) {
        return this.multiParagraph.getBoundingBox(offset);
    }

    @NotNull
    public final Rect getCursorRect(int offset) {
        return this.multiParagraph.getCursorRect(offset);
    }

    public final boolean getDidOverflowHeight() {
        return this.multiParagraph.getDidExceedMaxLines() || ((float) IntSize.m21137getHeightimpl(this.size)) < this.multiParagraph.getHeight();
    }

    public final boolean getDidOverflowWidth() {
        return ((float) IntSize.m21138getWidthimpl(this.size)) < this.multiParagraph.getWidth();
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final boolean getHasVisualOverflow() {
        return getDidOverflowWidth() || getDidOverflowHeight();
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        return this.multiParagraph.getHorizontalPosition(offset, usePrimaryDirection);
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    @NotNull
    public final TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final float getLineBaseline(int lineIndex) {
        return this.multiParagraph.getLineBaseline(lineIndex);
    }

    public final float getLineBottom(int lineIndex) {
        return this.multiParagraph.getLineBottom(lineIndex);
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.multiParagraph.getLineEnd(lineIndex, visibleEnd);
    }

    public final int getLineForOffset(int offset) {
        return this.multiParagraph.getLineForOffset(offset);
    }

    public final int getLineForVerticalPosition(float vertical) {
        return this.multiParagraph.getLineForVerticalPosition(vertical);
    }

    public final float getLineLeft(int lineIndex) {
        return this.multiParagraph.getLineLeft(lineIndex);
    }

    public final float getLineRight(int lineIndex) {
        return this.multiParagraph.getLineRight(lineIndex);
    }

    public final int getLineStart(int lineIndex) {
        return this.multiParagraph.getLineStart(lineIndex);
    }

    public final float getLineTop(int lineIndex) {
        return this.multiParagraph.getLineTop(lineIndex);
    }

    @NotNull
    public final MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m20428getOffsetForPositionk4lQ0M(long position) {
        return this.multiParagraph.m20322getOffsetForPositionk4lQ0M(position);
    }

    @NotNull
    public final ResolvedTextDirection getParagraphDirection(int offset) {
        return this.multiParagraph.getParagraphDirection(offset);
    }

    @NotNull
    public final Path getPathForRange(int start, int end) {
        return this.multiParagraph.getPathForRange(start, end);
    }

    @NotNull
    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m20430getWordBoundaryjx7JFs(int offset) {
        return this.multiParagraph.m20324getWordBoundaryjx7JFs(offset);
    }

    public int hashCode() {
        return this.placeholderRects.hashCode() + AbstractC0622a.m1156b(this.lastBaseline, AbstractC0622a.m1156b(this.firstBaseline, (IntSize.m21139hashCodeimpl(this.size) + ((this.multiParagraph.hashCode() + (this.layoutInput.hashCode() * 31)) * 31)) * 31, 31), 31);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return this.multiParagraph.isLineEllipsized(lineIndex);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("TextLayoutResult(layoutInput=");
        sb.append(this.layoutInput);
        sb.append(", multiParagraph=");
        sb.append(this.multiParagraph);
        sb.append(", size=");
        sb.append((Object) IntSize.m21141toStringimpl(this.size));
        sb.append(", firstBaseline=");
        sb.append(this.firstBaseline);
        sb.append(", lastBaseline=");
        sb.append(this.lastBaseline);
        sb.append(", placeholderRects=");
        return AbstractC1974b.m1321n(sb, this.placeholderRects, PropertyUtils.MAPPED_DELIM2);
    }

    private TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j;
        this.firstBaseline = multiParagraph.getFirstBaseline();
        this.lastBaseline = multiParagraph.getLastBaseline();
        this.placeholderRects = multiParagraph.getPlaceholderRects();
    }
}
