package com.vladsch.flexmark.util.sequence.builder;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.misc.DelimitedBuilder;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.builder.SegmentBuilderBase;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import opennlp.tools.parser.Parse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentBuilderBase<S extends SegmentBuilderBase<S>> implements ISegmentBuilder<S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int[] EMPTY_PARTS = new int[0];
    public static final int MIN_PART_CAPACITY = 8;
    protected int anchorsSize;
    protected int endOffset;
    protected int immutableOffset;
    protected int length;
    protected final int options;

    @NotNull
    protected int[] parts;
    protected int partsSize;
    protected int startOffset;
    protected final SegmentStats stats;
    protected final StringBuilder text;
    protected final SegmentStats textStats;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PartsIterator implements Iterator<Object> {
        final SegmentBuilderBase<?> builder;
        int nextIndex;

        public PartsIterator(SegmentBuilderBase<?> segmentBuilderBase) {
            this.builder = segmentBuilderBase;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.builder.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            SegmentBuilderBase<?> segmentBuilderBase = this.builder;
            int i = this.nextIndex;
            this.nextIndex = i + 1;
            return segmentBuilderBase.getPart(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SegIterable implements Iterable<Seg> {
        final SegmentBuilderBase<?> builder;

        public SegIterable(SegmentBuilderBase<?> segmentBuilderBase) {
            this.builder = segmentBuilderBase;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<Seg> iterator() {
            return new SegIterator(this.builder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SegIterator implements Iterator<Seg> {
        final SegmentBuilderBase<?> builder;
        int nextIndex;

        public SegIterator(SegmentBuilderBase<?> segmentBuilderBase) {
            this.builder = segmentBuilderBase;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.builder.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Seg next() {
            SegmentBuilderBase<?> segmentBuilderBase = this.builder;
            int i = this.nextIndex;
            this.nextIndex = i + 1;
            return segmentBuilderBase.getSegPart(i);
        }
    }

    public SegmentBuilderBase() {
        this(ISegmentBuilder.F_INCLUDE_ANCHORS);
    }

    private void addSeg(int i, int i2) {
        ensureCapacity(this.partsSize);
        int i4 = this.partsSize;
        int i5 = i4 * 2;
        int[] iArr = this.parts;
        iArr[i5] = i;
        iArr[i5 + 1] = i2;
        this.partsSize = i4 + 1;
        if (i == i2) {
            this.anchorsSize++;
        }
    }

    private void addText(CharSequence charSequence) {
        this.length = charSequence.length() + this.length;
        this.text.append(charSequence);
        this.stats.addText(charSequence);
        this.textStats.addText(charSequence);
    }

    private void commitText() {
        addSeg(Seg.getTextStart(this.immutableOffset, this.textStats.isTextFirst256()), Seg.getTextEnd(this.text.length(), this.textStats.isRepeatedText()));
        this.immutableOffset = this.text.length();
        this.stats.commitText();
        this.textStats.clear();
    }

    private int computeLength() {
        int i = this.partsSize;
        int length = 0;
        for (int i2 = 0; i2 < i; i2++) {
            length += getSeg(i2).length();
        }
        return haveDanglingText() ? (this.text.length() - this.immutableOffset) + length : length;
    }

    private static int[] ensureCapacity(@NotNull int[] iArr, int i) {
        int length = iArr.length / 2;
        return length <= i ? Arrays.copyOf(iArr, Math.max(8, Math.max((length + length) >> 1, i)) * 2) : iArr;
    }

    @NotNull
    private Seg getSeg(int i) {
        int i2 = i * 2;
        int i4 = i2 + 1;
        int[] iArr = this.parts;
        return i4 >= iArr.length ? Seg.NULL : Seg.segOf(iArr[i2], iArr[i4]);
    }

    @Nullable
    private Seg getSegOrNull(int i) {
        int i2 = i * 2;
        int i4 = i2 + 1;
        int[] iArr = this.parts;
        if (i4 >= iArr.length) {
            return null;
        }
        return Seg.segOf(iArr[i2], iArr[i4]);
    }

    @Nullable
    private Seg lastSegOrNull() {
        int i = this.partsSize;
        if (i == 0) {
            return null;
        }
        return getSegOrNull(i - 1);
    }

    private void processParts(int i, int i2, boolean z, boolean z2, @NotNull Function<Object[], Object[]> function) {
        StringBuilder sb = this.text;
        CharSequence charSequenceSubSequence = sb.subSequence(this.immutableOffset, sb.length());
        Seg segLastSegOrNull = lastSegOrNull();
        Range range = (segLastSegOrNull == null || !segLastSegOrNull.isBase()) ? Range.NULL : segLastSegOrNull.getRange();
        if (!isIncludeAnchors() && haveOffsets() && (range.isNull() || range.getEnd() < this.endOffset)) {
            range = Range.emptyOf(this.endOffset);
        }
        if (!haveOffsets()) {
            this.startOffset = i;
        }
        if (!z) {
            this.endOffset = Math.max(this.endOffset, i2);
        }
        Object[] objArr = {range, charSequenceSubSequence, z2 ? Range.NULL : Range.m13451of(i, i2)};
        Object[] objArr2 = (Object[]) objArr.clone();
        Object[] objArrApply = function.apply(objArr);
        if (!Arrays.equals(objArrApply, objArr2)) {
            this.textStats.commitText();
            this.stats.commitText();
            this.stats.remove(this.textStats);
            this.textStats.clear();
            this.length -= charSequenceSubSequence.length();
            StringBuilder sb2 = this.text;
            sb2.delete(this.immutableOffset, sb2.length());
            if (segLastSegOrNull != null && segLastSegOrNull.isBase()) {
                this.length -= segLastSegOrNull.length();
                this.partsSize--;
                if (segLastSegOrNull.length() == 0) {
                    this.anchorsSize--;
                }
            }
            int length = objArrApply.length;
            int iMax = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < length; i5++) {
                Object obj = objArrApply[i5];
                if (obj instanceof CharSequence) {
                    CharSequence charSequence = (CharSequence) obj;
                    if (charSequence.length() > 0) {
                        addText(charSequence);
                    }
                } else {
                    if (obj instanceof Range) {
                        Range range2 = (Range) obj;
                        if (range2.isNotNull()) {
                            int start = range2.getStart();
                            int end = range2.getEnd();
                            if (i4 == Integer.MAX_VALUE) {
                                i4 = start;
                            }
                            if (start < iMax) {
                                throw new IllegalStateException(String.format("Accumulated range [%d, %d) overlaps Transformed Range[%d]: [%d, %d)", Integer.valueOf(i4), Integer.valueOf(iMax), Integer.valueOf(i5), Integer.valueOf(start), Integer.valueOf(end)));
                            }
                            iMax = Math.max(iMax, end);
                            boolean zHaveDanglingText = haveDanglingText();
                            if (zHaveDanglingText && z) {
                                processParts(start, end, false, false, new C11883a(this, 0));
                            } else {
                                this.startOffset = Math.min(this.startOffset, start);
                                this.endOffset = Math.max(this.endOffset, end);
                                if (start != end || isIncludeAnchors()) {
                                    if (zHaveDanglingText) {
                                        commitText();
                                    }
                                    this.length = (end - start) + this.length;
                                    addSeg(start, end);
                                }
                            }
                        }
                    } else if (obj != null) {
                        throw new IllegalStateException(AbstractC2322a.m1621k("Invalid optimized part type ", obj.getClass()));
                    }
                }
            }
        } else if (i2 > i || isIncludeAnchors()) {
            if (charSequenceSubSequence.length() > 0) {
                commitText();
            }
            this.length = (i2 - i) + this.length;
            addSeg(i, i2);
        }
    }

    private void setSegEnd(int i, int i2) {
        int i4 = i * 2;
        int[] iArr = this.parts;
        int i5 = iArr[i4];
        if (i5 == i2) {
            if (i5 != iArr[i4 + 1]) {
                this.anchorsSize++;
            }
        } else if (i5 == iArr[i4 + 1]) {
            this.anchorsSize--;
        }
        iArr[i4 + 1] = i2;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @Nullable
    public Range getBaseSubSequenceRange() {
        if (this.partsSize != 1 || haveDanglingText()) {
            return null;
        }
        Seg seg = getSeg(this.partsSize - 1);
        if (seg.length() != 0 && this.anchorsSize == 1) {
            seg = getSeg(this.partsSize - 2);
        }
        if (seg.isBase() && seg.getStart() == this.startOffset && seg.getEnd() == this.endOffset) {
            return seg.getRange();
        }
        return null;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getEndOffset() {
        int i = this.endOffset;
        if (i >= this.startOffset) {
            return i;
        }
        return -1;
    }

    public int getEndOffsetIfNeeded() {
        int endOffset = getEndOffset();
        Seg segOrNull = getSegOrNull(this.partsSize - 1);
        if (endOffset == -1 || segOrNull == null || !segOrNull.isBase() || endOffset == segOrNull.getEnd()) {
            return -1;
        }
        return endOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getOptions() {
        return this.options;
    }

    @NotNull
    public Object getPart(int i) {
        if (i == this.partsSize && haveDanglingText()) {
            StringBuilder sb = this.text;
            return sb.subSequence(this.immutableOffset, sb.length());
        }
        int i2 = i * 2;
        int i4 = i2 + 1;
        int[] iArr = this.parts;
        Seg segSegOf = i4 >= iArr.length ? Seg.NULL : Seg.segOf(iArr[i2], iArr[i4]);
        return segSegOf.isBase() ? segSegOf.getRange() : segSegOf.isText() ? this.text.subSequence(segSegOf.getTextStart(), segSegOf.getTextEnd()) : Range.NULL;
    }

    @NotNull
    public Seg getSegPart(int i) {
        if (i == this.partsSize && haveDanglingText()) {
            return Seg.textOf(this.immutableOffset, this.text.length(), this.textStats.isTextFirst256(), this.textStats.isRepeatedText());
        }
        int i2 = i * 2;
        int i4 = i2 + 1;
        int[] iArr = this.parts;
        return i4 >= iArr.length ? Seg.NULL : Seg.segOf(iArr[i2], iArr[i4]);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public Iterable<Seg> getSegments() {
        return new SegIterable(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getSpan() {
        int i = this.startOffset;
        int i2 = this.endOffset;
        if (i > i2) {
            return -1;
        }
        return i2 - i;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getStartOffset() {
        int i = this.startOffset;
        if (i <= this.endOffset) {
            return i;
        }
        return -1;
    }

    public int getStartOffsetIfNeeded() {
        int startOffset = getStartOffset();
        Seg segOrNull = getSegOrNull(0);
        if (startOffset == -1 || segOrNull == null || !segOrNull.isBase() || startOffset == segOrNull.getStart()) {
            return -1;
        }
        return startOffset;
    }

    public SegmentStats getStats() {
        return this.stats;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public CharSequence getText() {
        return this.text;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextFirst256Length() {
        return this.stats.getTextFirst256Length();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextFirst256Segments() {
        return this.stats.getTextFirst256Segments();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextLength() {
        return this.stats.getTextLength();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextSegments() {
        return this.stats.getTextSegments();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextSpaceLength() {
        return this.stats.getTextSpaceLength();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int getTextSpaceSegments() {
        return this.stats.getTextSpaceSegments();
    }

    public Object[] handleOverlap(@NotNull Object[] objArr) {
        Range range = (Range) objArr[0];
        CharSequence charSequence = (CharSequence) objArr[1];
        Range range2 = (Range) objArr[2];
        if (range.getEnd() >= range2.getEnd()) {
            objArr[2] = Range.NULL;
            return objArr;
        }
        if (charSequence.length() > 0) {
            objArr[2] = Range.m13451of(range.getEnd(), range2.getEnd());
            return objArr;
        }
        objArr[0] = range.withEnd(range2.getEnd());
        objArr[2] = Range.NULL;
        return objArr;
    }

    public boolean haveDanglingText() {
        return this.text.length() > this.immutableOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public boolean haveOffsets() {
        return this.startOffset <= this.endOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public boolean isBaseSubSequenceRange() {
        return getBaseSubSequenceRange() != null;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public boolean isIncludeAnchors() {
        return (this.options & ISegmentBuilder.F_INCLUDE_ANCHORS) != 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public boolean isTrackTextFirst256() {
        return this.stats.isTrackTextFirst256();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder, java.lang.Iterable
    @NotNull
    public Iterator<Object> iterator() {
        return new PartsIterator(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int length() {
        return this.length;
    }

    public boolean needEndOffset() {
        return getEndOffsetIfNeeded() != -1;
    }

    public boolean needStartOffset() {
        return getStartOffsetIfNeeded() != -1;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int noAnchorsSize() {
        return size() - this.anchorsSize;
    }

    public Object[] optimizeText(@NotNull Object[] objArr) {
        return objArr;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    public int size() {
        return (haveDanglingText() ? 1 : 0) + this.partsSize;
    }

    @NotNull
    public String toString(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, @NotNull Function<CharSequence, CharSequence> function) {
        SegmentBuilderBase<S> segmentBuilderBase;
        if (this.endOffset > charSequence.length()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(this.endOffset, charSequence.length(), "baseSequence length() must be at least ", ", got: "));
        }
        if (haveDanglingText() && haveOffsets()) {
            int i = this.endOffset;
            segmentBuilderBase = this;
            segmentBuilderBase.processParts(i, i, false, true, new C11883a(this, 0));
        } else {
            segmentBuilderBase = this;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = segmentBuilderBase.partsSize;
        for (int i4 = 0; i4 < i2; i4++) {
            Seg seg = getSeg(i4);
            if (seg.isBase()) {
                sb.append(charSequence2);
                sb.append(function.apply(charSequence.subSequence(seg.getStart(), seg.getEnd())));
                sb.append(charSequence3);
            } else {
                sb.append(function.apply(segmentBuilderBase.text.subSequence(seg.getTextStart(), seg.getTextEnd())));
            }
        }
        if (haveDanglingText()) {
            StringBuilder sb2 = segmentBuilderBase.text;
            sb.append(function.apply(sb2.subSequence(segmentBuilderBase.immutableOffset, sb2.length())));
        }
        return sb.toString();
    }

    public String toStringPrep() {
        if (haveDanglingText() && haveOffsets()) {
            int i = this.endOffset;
            processParts(i, i, false, true, new C11883a(this, 0));
        }
        return toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public String toStringWithRanges(@NotNull CharSequence charSequence) {
        return toString(charSequence, "⟦", "⟧", Function.identity());
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public String toStringWithRangesVisibleWhitespace(@NotNull CharSequence charSequence) {
        return toString(charSequence, "⟦", "⟧", new C11419a(15));
    }

    public void trimToSize() {
        int[] iArr = this.parts;
        int length = iArr.length;
        int i = this.partsSize;
        if (length > i) {
            this.parts = Arrays.copyOf(iArr, i * 2);
        }
    }

    public SegmentBuilderBase(int i) {
        this.parts = EMPTY_PARTS;
        this.partsSize = 0;
        this.anchorsSize = 0;
        Range range = Range.NULL;
        this.startOffset = range.getStart();
        this.endOffset = range.getEnd();
        this.length = 0;
        this.text = new StringBuilder();
        this.immutableOffset = 0;
        int i2 = ISegmentBuilder.F_INCLUDE_ANCHORS;
        int i4 = ISegmentBuilder.F_TRACK_FIRST256;
        this.options = (i2 | i4) & i;
        this.stats = new SegmentStats((i & i4) != 0);
        this.textStats = new SegmentStats((i & i4) != 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public S appendAnchor(int i) {
        return (S) append(i, i);
    }

    private void ensureCapacity(int i) {
        this.parts = ensureCapacity(this.parts, i + 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public S append(@NotNull Range range) {
        return (S) append(range.getStart(), range.getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public S append(int i, int i2) {
        if (i2 >= 0 && i <= i2) {
            int i4 = i2 - i;
            if (i4 == 0 && (!isIncludeAnchors() || i < this.endOffset)) {
                if (i >= this.endOffset) {
                    if (haveDanglingText()) {
                        processParts(i, i2, false, false, new C11883a(this, 0));
                        return this;
                    }
                    if (!haveOffsets()) {
                        this.startOffset = i;
                    }
                    this.endOffset = i;
                    return this;
                }
            } else {
                int i5 = this.endOffset;
                if (i5 > i) {
                    processParts(i, i2, true, false, new C11883a(this, 1));
                    return this;
                }
                if (i5 == i) {
                    if (haveDanglingText()) {
                        processParts(i, i2, false, false, new C11883a(this, 0));
                        return this;
                    }
                    this.endOffset = i2;
                    this.length += i4;
                    int i6 = this.partsSize;
                    if (i6 == 0) {
                        addSeg(i, i2);
                        return this;
                    }
                    setSegEnd(i6 - 1, i2);
                    return this;
                }
                if (haveDanglingText()) {
                    processParts(i, i2, false, false, new C11883a(this, 0));
                    return this;
                }
                if (!haveOffsets()) {
                    this.startOffset = i;
                }
                this.endOffset = i2;
                this.length += i4;
                addSeg(i, i2);
                return this;
            }
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public String toString(@NotNull CharSequence charSequence) {
        return toString(charSequence, "", "", Function.identity());
    }

    public String toString() {
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
        delimitedBuilder.append(getClass().getSimpleName()).append(Parse.BRACKET_LCB);
        if (haveOffsets()) {
            delimitedBuilder.append("[").append(this.startOffset).mark().append(this.endOffset).unmark().append(")").mark();
        } else {
            delimitedBuilder.append("NULL").mark();
        }
        delimitedBuilder.append(this.stats.committedCopy()).mark().append("l=").append(this.length).mark().append("sz=").append(size()).mark().append("na=").append(noAnchorsSize());
        if (size() > 0) {
            delimitedBuilder.append(": ");
        }
        int i = this.partsSize;
        for (int i2 = 0; i2 < i; i2++) {
            delimitedBuilder.append(getSeg(i2).toString(this.text)).mark();
        }
        if (haveDanglingText()) {
            delimitedBuilder.append(Seg.textOf(this.immutableOffset, this.text.length(), this.textStats.isTextFirst256(), this.textStats.isRepeatedText()).toString(this.text)).mark();
        }
        delimitedBuilder.unmark().append(" }");
        return delimitedBuilder.toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder
    @NotNull
    public S append(@NotNull CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            this.stats.addText(charSequence);
            this.textStats.addText(charSequence);
            this.text.append(charSequence);
            this.length += length;
        }
        return this;
    }

    @NotNull
    public S append(char c) {
        this.stats.addText(c);
        this.textStats.addText(c);
        this.text.append(c);
        this.length++;
        return this;
    }

    @NotNull
    public S append(char c, int i) {
        if (i > 0) {
            this.stats.addText(c, i);
            this.textStats.addText(c, i);
            this.length += i;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                this.text.append(c);
                i = i2;
            }
        }
        return this;
    }
}
