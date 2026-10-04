package com.vladsch.flexmark.util.sequence.builder;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedOptionsHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SequenceBuilder implements ISequenceBuilder<SequenceBuilder, BasedSequence> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NotNull
    private final BasedSequence altBase;

    @NotNull
    private final BasedSequence baseSeq;

    @NotNull
    private final HashMap<BasedSequence, Boolean> equivalentBases;

    @Nullable
    private BasedSequence resultSeq;
    private final BasedSegmentBuilder segments;

    private SequenceBuilder(@NotNull BasedSequence basedSequence, @Nullable SegmentOptimizer segmentOptimizer) {
        this(basedSequence, segmentOptimizer, new HashMap());
    }

    @NotNull
    public static SequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence) {
        return new SequenceBuilder(basedSequence, null);
    }

    @NotNull
    public SequenceBuilder addByLength(int i, int i2) {
        return add(this.baseSeq.subSequence(i, i2 + i));
    }

    @NotNull
    public SequenceBuilder addByOffsets(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.baseSeq.length()) {
            throw new IllegalArgumentException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(this.baseSeq.length(), i, "addByOffsets start/end must be a valid range in [0, ", "], got: [", SQLKeyword.COMMA), "]", i2));
        }
        this.segments.append(Range.m13451of(i, i2));
        this.resultSeq = null;
        return this;
    }

    @NotNull
    public SequenceBuilder addRange(@NotNull Range range) {
        this.segments.append(range);
        this.resultSeq = null;
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public char charAt(int i) {
        return toSequence().charAt(i);
    }

    @NotNull
    public BasedSequence getBaseSequence() {
        return this.baseSeq;
    }

    @Nullable
    public Range getLastRangeOrNull() {
        BasedSegmentBuilder basedSegmentBuilder = this.segments;
        Object part = basedSegmentBuilder.getPart(basedSegmentBuilder.size());
        if (!(part instanceof Range)) {
            return null;
        }
        Range range = (Range) part;
        if (range.isNotNull()) {
            return range;
        }
        return null;
    }

    @NotNull
    public BasedSegmentBuilder getSegmentBuilder() {
        return this.segments;
    }

    public boolean isCommonBaseSequence(@NotNull BasedSequence basedSequence) {
        if (basedSequence.isNull()) {
            return false;
        }
        BasedSequence baseSequence = basedSequence.getBaseSequence();
        if (baseSequence == this.baseSeq) {
            return true;
        }
        Boolean bool = this.equivalentBases.get(baseSequence);
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zEquals = this.baseSeq.equals(baseSequence);
        this.equivalentBases.put(baseSequence, Boolean.valueOf(zEquals));
        return zEquals;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public int length() {
        return this.segments.length();
    }

    @NotNull
    public BasedSequence toSequenceByIndex(@NotNull BasedSequence basedSequence, @Nullable CharPredicate charPredicate, @Nullable CharPredicate charPredicate2) {
        int span;
        if (basedSequence == this.altBase) {
            return toSequence();
        }
        BasedSegmentBuilder basedSegmentBuilder = this.segments;
        SequenceBuilder sequenceBuilder = new SequenceBuilder(basedSequence, basedSegmentBuilder.options, basedSegmentBuilder.optimizer, new HashMap());
        int i = 0;
        int i2 = 0;
        for (Object obj : this.segments) {
            if (obj instanceof Range) {
                int i4 = i + i2;
                Range range = (Range) obj;
                BasedSequence basedSequenceSubSequence = basedSequence.subSequence(i4, range.getSpan() + i4);
                int iCountLeading = charPredicate == null ? 0 : basedSequenceSubSequence.countLeading(charPredicate);
                if (iCountLeading > 0) {
                    i2 += iCountLeading;
                    int i5 = i + i2;
                    basedSequenceSubSequence = basedSequence.subSequence(i5, range.getSpan() + i5);
                }
                sequenceBuilder.append((CharSequence) basedSequenceSubSequence);
                span = range.getSpan();
            } else if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                sequenceBuilder.append(charSequence);
                span = charSequence.length();
            } else if (obj != null) {
                throw new IllegalStateException(AbstractC2322a.m1621k("Invalid part type ", obj.getClass()));
            }
            i += span;
        }
        BasedSequence basedSequenceCreate = SegmentedSequence.create(sequenceBuilder);
        toSequence();
        return basedSequenceCreate;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.segments) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                BasedSequence basedSequenceSubSequence = this.baseSeq.subSequence(range.getStart(), range.getEnd());
                if (basedSequenceSubSequence.isNotEmpty()) {
                    basedSequenceSubSequence.appendTo(sb);
                }
            } else if (obj instanceof CharSequence) {
                sb.append(obj);
            } else if (obj != null) {
                throw new IllegalStateException(AbstractC2322a.m1621k("Invalid part type ", obj.getClass()));
            }
        }
        return sb.toString();
    }

    @NotNull
    public String toStringNoAddedSpaces() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.segments) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                sb.append((CharSequence) this.baseSeq.subSequence(range.getStart(), range.getEnd()));
            } else if (obj instanceof CharSequence) {
                sb.append(obj);
            } else if (obj != null) {
                throw new IllegalStateException(AbstractC2322a.m1621k("Invalid part type ", obj.getClass()));
            }
        }
        return sb.toString();
    }

    @NotNull
    public String toStringWithRanges() {
        return this.segments.toStringWithRangesVisibleWhitespace(this.baseSeq);
    }

    private SequenceBuilder(@NotNull BasedSequence basedSequence, @Nullable SegmentOptimizer segmentOptimizer, @NotNull HashMap<BasedSequence, Boolean> map) {
        this.altBase = basedSequence;
        BasedSequence baseSequence = basedSequence.getBaseSequence();
        this.baseSeq = baseSequence;
        this.equivalentBases = map;
        int i = ISegmentBuilder.F_DEFAULT;
        i = (!baseSequence.anyOptions(BasedOptionsHolder.F_FULL_SEGMENTED_SEQUENCES) || baseSequence.anyOptions(BasedOptionsHolder.F_COLLECT_FIRST256_STATS)) ? i | ISegmentBuilder.F_TRACK_FIRST256 : i;
        i = baseSequence.anyOptions(BasedOptionsHolder.F_NO_ANCHORS) ? i & (~ISegmentBuilder.F_INCLUDE_ANCHORS) : i;
        this.segments = segmentOptimizer == null ? BasedSegmentBuilder.emptyBuilder(baseSequence, i) : BasedSegmentBuilder.emptyBuilder(baseSequence, segmentOptimizer, i);
    }

    @NotNull
    public static SequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer) {
        return new SequenceBuilder(basedSequence, segmentOptimizer);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SequenceBuilder getBuilder() {
        BasedSequence basedSequence = this.altBase;
        BasedSegmentBuilder basedSegmentBuilder = this.segments;
        return new SequenceBuilder(basedSequence, basedSegmentBuilder.options, basedSegmentBuilder.optimizer, this.equivalentBases);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @Nullable
    public BasedSequence getSingleBasedSequence() {
        Range baseSubSequenceRange = this.segments.getBaseSubSequenceRange();
        if (baseSubSequenceRange == null) {
            return null;
        }
        return this.baseSeq.subSequence(baseSubSequenceRange.getStart(), baseSubSequenceRange.getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public BasedSequence toSequence() {
        if (this.resultSeq == null) {
            this.resultSeq = SegmentedSequence.create(this);
        }
        return this.resultSeq;
    }

    @NotNull
    public String toStringWithRanges(boolean z) {
        return z ? this.segments.toStringWithRangesVisibleWhitespace(this.baseSeq) : this.segments.toStringWithRanges(this.baseSeq);
    }

    @NotNull
    public static SequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, int i) {
        return new SequenceBuilder(basedSequence, i, null, new HashMap());
    }

    @NotNull
    public static SequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, int i, @NotNull SegmentOptimizer segmentOptimizer) {
        return new SequenceBuilder(basedSequence, i, segmentOptimizer, new HashMap());
    }

    @NotNull
    public BasedSequence toSequence(@NotNull BasedSequence basedSequence) {
        return toSequence(basedSequence, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SequenceBuilder append(@Nullable CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof BasedSequence) {
            BasedSequence basedSequence = (BasedSequence) charSequence;
            if (isCommonBaseSequence(basedSequence)) {
                if (basedSequence.isNotNull()) {
                    if (i == 0 && i2 == charSequence.length()) {
                        basedSequence.addSegments(this.segments);
                    } else {
                        basedSequence.subSequence(i, i2).addSegments(this.segments);
                    }
                    this.resultSeq = null;
                    return this;
                }
            } else if (charSequence != null && i < i2) {
                if (i == 0 && i2 == charSequence.length()) {
                    this.segments.append(charSequence);
                } else {
                    this.segments.append(charSequence.subSequence(i, i2));
                }
                this.resultSeq = null;
            }
        }
        return this;
    }

    @NotNull
    public BasedSequence toSequence(@NotNull BasedSequence basedSequence, @Nullable CharPredicate charPredicate, @Nullable CharPredicate charPredicate2) {
        if (basedSequence == this.altBase) {
            return toSequence();
        }
        BasedSegmentBuilder basedSegmentBuilder = this.segments;
        SequenceBuilder sequenceBuilder = new SequenceBuilder(basedSequence, basedSegmentBuilder.options, basedSegmentBuilder.optimizer, new HashMap());
        int i = 0;
        for (Object obj : this.segments) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                BasedSequence basedSequenceSubSequence = basedSequence.subSequence(range.getStart() + i, range.getEnd() + i);
                int iCountLeading = charPredicate == null ? 0 : basedSequenceSubSequence.countLeading(charPredicate);
                if (iCountLeading > 0) {
                    i += iCountLeading;
                    basedSequenceSubSequence = basedSequence.subSequence(range.getStart() + i, range.getEnd() + i);
                }
                sequenceBuilder.append((CharSequence) basedSequenceSubSequence);
            } else if (obj instanceof CharSequence) {
                sequenceBuilder.append((CharSequence) obj);
            } else if (obj != null) {
                throw new IllegalStateException(AbstractC2322a.m1621k("Invalid part type ", obj.getClass()));
            }
        }
        BasedSequence basedSequenceCreate = SegmentedSequence.create(sequenceBuilder);
        toSequence();
        return basedSequenceCreate;
    }

    private SequenceBuilder(@NotNull BasedSequence basedSequence, int i, @Nullable SegmentOptimizer segmentOptimizer, @NotNull HashMap<BasedSequence, Boolean> map) {
        this.altBase = basedSequence;
        BasedSequence baseSequence = basedSequence.getBaseSequence();
        this.baseSeq = baseSequence;
        this.equivalentBases = map;
        i = (!baseSequence.anyOptions(BasedOptionsHolder.F_FULL_SEGMENTED_SEQUENCES) || baseSequence.anyOptions(BasedOptionsHolder.F_COLLECT_FIRST256_STATS)) ? i | ISegmentBuilder.F_TRACK_FIRST256 : i;
        i = baseSequence.anyOptions(BasedOptionsHolder.F_NO_ANCHORS) ? i & (~ISegmentBuilder.F_INCLUDE_ANCHORS) : i;
        this.segments = segmentOptimizer == null ? BasedSegmentBuilder.emptyBuilder(baseSequence, i) : BasedSegmentBuilder.emptyBuilder(baseSequence, segmentOptimizer, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public SequenceBuilder append(char c) {
        this.segments.append(c);
        this.resultSeq = null;
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SequenceBuilder append(char c, int i) {
        if (i > 0) {
            this.segments.append(c, i);
            this.resultSeq = null;
        }
        return this;
    }

    @NotNull
    public SequenceBuilder append(int i, int i2) {
        return addByOffsets(i, i2);
    }

    @NotNull
    public SequenceBuilder append(@NotNull Range range) {
        return addRange(range);
    }
}
