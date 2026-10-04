package com.vladsch.flexmark.util.sequence;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SegmentedSequenceFull extends SegmentedSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int[] baseOffsets;
    private final int baseStartOffset;
    private final boolean nonBaseChars;

    private SegmentedSequenceFull(BasedSequence basedSequence, int i, int i2, int i4, boolean z, int[] iArr, int i5) {
        super(basedSequence, i, i2, i4);
        this.nonBaseChars = z;
        this.baseOffsets = iArr;
        this.baseStartOffset = i5;
    }

    public static SegmentedSequenceFull create(@NotNull BasedSequence basedSequence, ISegmentBuilder<?> iSegmentBuilder) {
        SegmentedSequenceStats segmentedSequenceStats;
        BasedSequence baseSequence = basedSequence.getBaseSequence();
        int length = iSegmentBuilder.length();
        int i = length + 1;
        int[] iArr = new int[i];
        int i2 = 0;
        for (Object obj : iSegmentBuilder) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                if (!range.isEmpty()) {
                    int end = range.getEnd();
                    int start = range.getStart();
                    while (start < end) {
                        iArr[i2] = start;
                        start++;
                        i2++;
                    }
                }
            } else if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                int length2 = charSequence.length();
                int i4 = 0;
                while (i4 < length2) {
                    iArr[i2] = (-charSequence.charAt(i4)) - 1;
                    i4++;
                    i2++;
                }
            } else if (obj != null) {
                throw new IllegalStateException(AbstractC2322a.m1621k("Invalid part type ", obj.getClass()));
            }
        }
        int i5 = iArr[length - 1];
        iArr[length] = i5 < 0 ? i5 - 1 : i5 + 1;
        int startOffset = iSegmentBuilder.getStartOffset();
        int endOffset = iSegmentBuilder.getEndOffset();
        boolean z = iSegmentBuilder.getTextLength() > 0;
        if (baseSequence.anyOptions(BasedOptionsHolder.F_COLLECT_SEGMENTED_STATS) && (segmentedSequenceStats = (SegmentedSequenceStats) baseSequence.getOption(BasedOptionsHolder.SEGMENTED_STATS)) != null) {
            segmentedSequenceStats.addStats(iSegmentBuilder.noAnchorsSize(), length, i * 4);
        }
        return new SegmentedSequenceFull(baseSequence, startOffset, endOffset, length, z, iArr, 0);
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13463of(BasedSequence basedSequence, @NotNull Iterable<? extends BasedSequence> iterable) {
        return SegmentedSequence.create(basedSequence, iterable);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        BasedUtils.generateSegments(iBasedSegmentBuilder, this);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        SequenceUtils.validateIndex(i, length());
        int i2 = this.baseOffsets[this.baseStartOffset + i];
        return i2 < 0 ? (char) ((-i2) - 1) : this.baseSeq.charAt(i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        SequenceUtils.validateIndexInclusiveEnd(i, length());
        int i2 = this.baseOffsets[this.baseStartOffset + i];
        if (i2 < 0) {
            return -1;
        }
        return i2;
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13464of(BasedSequence... basedSequenceArr) {
        return SegmentedSequence.create(basedSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public BasedSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        return (i == 0 && i2 == this.length) ? this : subSequence(this.baseSeq, this.baseOffsets, this.baseStartOffset + i, this.nonBaseChars, i2 - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SegmentedSequenceFull subSequence(BasedSequence basedSequence, int[] iArr, int i, boolean z, int i2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int endOffset;
        int i8;
        boolean z2 = true;
        int length = iArr.length - 1;
        if (z) {
            int i9 = i;
            while (true) {
                i4 = 0;
                if (i9 >= length) {
                    i5 = 0;
                    z2 = false;
                    break;
                }
                int i10 = iArr[i9];
                if (i10 < 0) {
                    i9++;
                } else if (i2 != 0) {
                    int i11 = i + i2;
                    while (true) {
                        int i12 = i11 - 1;
                        if (i11 <= i9) {
                            break;
                        }
                        int i13 = iArr[i12];
                        if (i13 >= 0) {
                            i8 = i13 + 1;
                            i4 = 1;
                            break;
                        }
                        i11 = i12;
                    }
                    if (i4 == 0) {
                        i8 = i10;
                    }
                    i4 = i8;
                    i5 = i10;
                } else {
                    i8 = 0;
                    if (i4 == 0) {
                    }
                    i4 = i8;
                    i5 = i10;
                }
            }
            if (z2) {
                i6 = i4;
                i7 = i5;
            } else {
                endOffset = basedSequence.getEndOffset();
                i7 = endOffset;
                i6 = i7;
            }
        } else {
            if (i < length) {
                endOffset = iArr[i];
            } else {
                endOffset = basedSequence.getEndOffset();
            }
            if (i2 == 0) {
                i7 = endOffset;
                i6 = i7;
            } else {
                i7 = endOffset;
                i6 = iArr[(i + i2) - 1] + 1;
            }
        }
        return new SegmentedSequenceFull(basedSequence, i7, i6, i2, z, iArr, i);
    }
}
