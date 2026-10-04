package com.vladsch.flexmark.util.sequence;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Range {
    private final int end;
    private final int start;
    public static final Range NULL = new Range(Integer.MAX_VALUE, Integer.MIN_VALUE);
    public static final Range EMPTY = new Range(0, 0);

    public Range(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @NotNull
    public static Range emptyOf(int i) {
        return new Range(i, i);
    }

    @NotNull
    /* JADX INFO: renamed from: of */
    public static Range m13451of(int i, int i2) {
        Range range = NULL;
        return (i == range.start && i2 == range.end) ? range : new Range(i, i2);
    }

    @NotNull
    public static Range ofLength(int i, int i2) {
        return new Range(i, i2 + i);
    }

    @NotNull
    public BasedSequence basedSafeSubSequence(@NotNull CharSequence charSequence) {
        int iMin = Math.min(charSequence.length(), this.end);
        return isNull() ? BasedSequence.NULL : BasedSequence.m13437of(charSequence).subSequence(Math.min(iMin, Math.max(0, this.start)), iMin);
    }

    @NotNull
    public BasedSequence basedSubSequence(@NotNull CharSequence charSequence) {
        return BasedSequence.m13437of(charSequence).subSequence(this.start, this.end);
    }

    @NotNull
    public CharSequence charSubSequence(@NotNull CharSequence charSequence) {
        return charSequence.subSequence(this.start, this.end);
    }

    public int compare(@NotNull Range range) {
        int i = this.start;
        int i2 = range.start;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i4 = this.end;
        int i5 = range.end;
        if (i4 > i5) {
            return -1;
        }
        return i4 < i5 ? 1 : 0;
    }

    public int component1() {
        return this.start;
    }

    public int component2() {
        return this.end;
    }

    public boolean contains(@NotNull Range range) {
        return this.end >= range.end && this.start <= range.start;
    }

    public boolean doesContain(@NotNull Range range) {
        return this.end >= range.end && this.start <= range.start;
    }

    public boolean doesNotOverlap(@NotNull Range range) {
        return range.end <= this.start || range.start >= this.end;
    }

    public boolean doesNotOverlapNorAdjacent(@NotNull Range range) {
        return range.end < this.start || range.start > this.end;
    }

    public boolean doesNotOverlapOrAdjacent(@NotNull Range range) {
        return range.end < this.start || range.start > this.end;
    }

    public boolean doesOverlap(@NotNull Range range) {
        return range.end > this.start && range.start < this.end;
    }

    public boolean doesOverlapOrAdjacent(@NotNull Range range) {
        return range.end >= this.start && range.start <= this.end;
    }

    public boolean doesProperlyContain(@NotNull Range range) {
        return this.end > range.end && this.start < range.start;
    }

    public Range endMinus(int i) {
        return i == 0 ? this : m13451of(this.start, this.end - i);
    }

    public Range endPlus(int i) {
        return i == 0 ? this : m13451of(this.start, this.end + i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.start == range.start && this.end == range.end;
    }

    @NotNull
    public Range exclude(@NotNull Range range) {
        int i;
        int i2 = this.start;
        int i4 = range.start;
        if (i2 >= i4 && i2 < (i = range.end)) {
            i2 = i;
        }
        int i5 = this.end;
        if (i5 > range.end || i5 <= i4) {
            i4 = i5;
        }
        if (i2 >= i4) {
            i2 = 0;
            i4 = 0;
        }
        return withRange(i2, i4);
    }

    @NotNull
    public Range expandToInclude(@NotNull Range range) {
        return expandToInclude(range.start, range.end);
    }

    public int getEnd() {
        return this.end;
    }

    public int getEndOffset() {
        return this.end;
    }

    public int getSpan() {
        if (isNull()) {
            return 0;
        }
        return this.end - this.start;
    }

    public int getStart() {
        return this.start;
    }

    public int getStartOffset() {
        return this.start;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    @NotNull
    public Range include(@NotNull Range range) {
        return range.isNull() ? isNull() ? NULL : this : expandToInclude(range);
    }

    @NotNull
    public Range intersect(@NotNull Range range) {
        int iMax = Math.max(this.start, range.start);
        int iMin = Math.min(this.end, range.end);
        if (iMax >= iMin) {
            iMax = iMin;
        }
        return withRange(iMax, iMin);
    }

    public boolean isAdjacent(int i) {
        return i == this.start - 1 || i == this.end;
    }

    public boolean isAdjacentAfter(int i) {
        return this.start - 1 == i;
    }

    public boolean isAdjacentBefore(int i) {
        return this.end == i;
    }

    public boolean isContainedBy(@NotNull Range range) {
        return range.end >= this.end && range.start <= this.start;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public boolean isEnd(int i) {
        return i == this.end;
    }

    public boolean isEqual(@NotNull Range range) {
        return this.end == range.end && this.start == range.start;
    }

    public boolean isLast(int i) {
        return i >= this.start && i == this.end - 1;
    }

    public boolean isNotEmpty() {
        return this.start < this.end;
    }

    public boolean isNotNull() {
        return !isNull();
    }

    public boolean isNull() {
        int i = this.start;
        Range range = NULL;
        return i == range.start && this.end == range.end;
    }

    public boolean isProperlyContainedBy(@NotNull Range range) {
        return range.end > this.end && range.start < this.start;
    }

    public boolean isStart(int i) {
        return i == this.start;
    }

    public boolean isValidIndex(int i) {
        return i >= this.start && i <= this.end;
    }

    public boolean leadBy(int i) {
        return i <= this.start;
    }

    public boolean leads(int i) {
        return this.end <= i;
    }

    public boolean overlaps(@NotNull Range range) {
        return range.end > this.start && range.start < this.end;
    }

    public boolean overlapsOrAdjacent(@NotNull Range range) {
        return range.end >= this.start && range.start <= this.end;
    }

    public boolean properlyContains(@NotNull Range range) {
        return this.end > range.end && this.start < range.start;
    }

    @NotNull
    public RichSequence richSafeSubSequence(@NotNull CharSequence charSequence) {
        int iMin = Math.min(charSequence.length(), this.end);
        return isNull() ? RichSequence.NULL : RichSequence.m13457of(charSequence, Math.min(iMin, Math.max(0, this.start)), iMin);
    }

    @NotNull
    public RichSequence richSubSequence(@NotNull CharSequence charSequence) {
        return RichSequence.m13455of(charSequence.subSequence(this.start, this.end));
    }

    @NotNull
    public CharSequence safeSubSequence(@NotNull CharSequence charSequence) {
        int iMin = Math.min(charSequence.length(), this.end);
        return isNull() ? charSequence.subSequence(0, 0) : charSequence.subSequence(Math.min(iMin, Math.max(0, this.start)), iMin);
    }

    public Range shiftLeft(int i) {
        return i == 0 ? this : m13451of(this.start - i, this.end - i);
    }

    public Range shiftRight(int i) {
        return i == 0 ? this : m13451of(this.start + i, this.end + i);
    }

    public Range startMinus(int i) {
        return i == 0 ? this : m13451of(this.start - i, this.end);
    }

    public Range startPlus(int i) {
        return i == 0 ? this : m13451of(this.start + i, this.end);
    }

    @Deprecated
    @NotNull
    public BasedSequence subSequence(@NotNull CharSequence charSequence) {
        return basedSubSequence(charSequence);
    }

    public String toString() {
        return AbstractC0622a.m1164j(this.start, this.end, "[", SQLKeyword.COMMA, ")");
    }

    public boolean trailedBy(int i) {
        return this.end <= i;
    }

    public boolean trails(int i) {
        return i <= this.start;
    }

    public Range withEnd(int i) {
        return i == this.end ? this : m13451of(this.start, i);
    }

    public Range withRange(int i, int i2) {
        return (i == this.start && i2 == this.end) ? this : m13451of(i, i2);
    }

    public Range withStart(int i) {
        return i == this.start ? this : m13451of(i, this.end);
    }

    public boolean contains(int i) {
        return this.start <= i && i < this.end;
    }

    public boolean doesContain(int i) {
        return this.start <= i && i < this.end;
    }

    @NotNull
    public Range expandToInclude(int i, int i2) {
        return withRange(Math.min(this.start, i), Math.max(this.end, i2));
    }

    @NotNull
    public Range include(int i) {
        return include(i, i);
    }

    public boolean isAdjacent(@NotNull Range range) {
        return this.start == range.end || this.end == range.start;
    }

    public boolean isAdjacentAfter(@NotNull Range range) {
        return this.start == range.end;
    }

    public boolean isAdjacentBefore(@NotNull Range range) {
        return this.end == range.start;
    }

    public boolean isContainedBy(int i, int i2) {
        return i2 >= this.end && i <= this.start;
    }

    public boolean isProperlyContainedBy(int i, int i2) {
        return i2 > this.end && i < this.start;
    }

    public boolean contains(int i, int i2) {
        return this.start <= i && i2 <= this.end;
    }

    public boolean doesContain(int i, int i2) {
        return this.start <= i && i2 <= this.end;
    }

    @NotNull
    public Range include(int i, int i2) {
        return isNull() ? m13451of(i, i2) : expandToInclude(i, i2);
    }

    public Range(@NotNull Range range) {
        this.start = range.start;
        this.end = range.end;
    }
}
