package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ISegmentBuilder<S extends ISegmentBuilder<S>> extends Iterable<Object> {
    public static final int F_DEFAULT;
    public static final int F_INCLUDE_ANCHORS;
    public static final int F_TRACK_FIRST256;
    public static final Options O_INCLUDE_ANCHORS;
    public static final Options O_TRACK_FIRST256;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Options {
        INCLUDE_ANCHORS,
        TRACK_FIRST256
    }

    static {
        Options options = Options.INCLUDE_ANCHORS;
        O_INCLUDE_ANCHORS = options;
        Options options2 = Options.TRACK_FIRST256;
        O_TRACK_FIRST256 = options2;
        int iIntMask = BitFieldSet.intMask(options);
        F_INCLUDE_ANCHORS = iIntMask;
        int iIntMask2 = BitFieldSet.intMask(options2);
        F_TRACK_FIRST256 = iIntMask2;
        F_DEFAULT = iIntMask | iIntMask2;
    }

    @NotNull
    S append(int i, int i2);

    @NotNull
    S append(@NotNull Range range);

    @NotNull
    S append(CharSequence charSequence);

    @NotNull
    S appendAnchor(int i);

    @Nullable
    Range getBaseSubSequenceRange();

    int getEndOffset();

    int getOptions();

    @NotNull
    Iterable<Seg> getSegments();

    int getSpan();

    int getStartOffset();

    CharSequence getText();

    int getTextFirst256Length();

    int getTextFirst256Segments();

    int getTextLength();

    int getTextSegments();

    int getTextSpaceLength();

    int getTextSpaceSegments();

    boolean haveOffsets();

    boolean isBaseSubSequenceRange();

    boolean isEmpty();

    boolean isIncludeAnchors();

    boolean isTrackTextFirst256();

    @Override // java.lang.Iterable
    @NotNull
    Iterator<Object> iterator();

    int length();

    int noAnchorsSize();

    int size();

    @NotNull
    String toString(@NotNull CharSequence charSequence);

    @NotNull
    String toStringWithRanges(@NotNull CharSequence charSequence);

    @NotNull
    String toStringWithRangesVisibleWhitespace(@NotNull CharSequence charSequence);
}
