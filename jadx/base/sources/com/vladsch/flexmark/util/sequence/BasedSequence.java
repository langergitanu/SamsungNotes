package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BasedSequence extends IRichSequence<BasedSequence>, BasedOptionsHolder {
    public static final BasedSequence NULL = new EmptyBasedSequence();
    public static final BasedSequence EMPTY = new EmptyBasedSequence();
    public static final BasedSequence EOL = CharSubSequence.m13438of((CharSequence) "\n");
    public static final BasedSequence SPACE = CharSubSequence.m13438of((CharSequence) " ");
    public static final List<BasedSequence> EMPTY_LIST = new ArrayList();
    public static final BasedSequence[] EMPTY_ARRAY = new BasedSequence[0];
    public static final BasedSequence[] EMPTY_SEGMENTS = new BasedSequence[0];
    public static final BasedSequence LINE_SEP = CharSubSequence.m13438of((CharSequence) SequenceUtils.LINE_SEP);

    @NotNull
    /* JADX INFO: renamed from: of */
    static BasedSequence m13437of(@Nullable CharSequence charSequence) {
        return BasedSequenceImpl.create(charSequence);
    }

    @NotNull
    static BasedSequence ofSpaces(int i) {
        return m13437of(RepeatedSequence.ofSpaces(i));
    }

    @NotNull
    static BasedSequence repeatOf(char c, int i) {
        return m13437of(RepeatedSequence.repeatOf(String.valueOf(c), 0, i));
    }

    void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder);

    int baseColumnAtEnd();

    int baseColumnAtIndex(int i);

    int baseColumnAtStart();

    int baseEndOfLine();

    int baseEndOfLine(int i);

    int baseEndOfLineAnyEOL();

    int baseEndOfLineAnyEOL(int i);

    @NotNull
    Pair<Integer, Integer> baseLineColumnAtEnd();

    @NotNull
    Pair<Integer, Integer> baseLineColumnAtIndex(int i);

    @NotNull
    Pair<Integer, Integer> baseLineColumnAtStart();

    @NotNull
    Range baseLineRangeAtEnd();

    @NotNull
    Range baseLineRangeAtIndex(int i);

    @NotNull
    Range baseLineRangeAtStart();

    int baseStartOfLine();

    int baseStartOfLine(int i);

    int baseStartOfLineAnyEOL();

    int baseStartOfLineAnyEOL(int i);

    @NotNull
    BasedSequence baseSubSequence(int i);

    @NotNull
    BasedSequence baseSubSequence(int i, int i2);

    boolean containsAllOf(@NotNull BasedSequence basedSequence);

    boolean containsOnlyIn(@NotNull CharPredicate charPredicate);

    boolean containsOnlyNotIn(@NotNull CharPredicate charPredicate);

    boolean containsSomeIn(@NotNull CharPredicate charPredicate);

    boolean containsSomeNotIn(@NotNull CharPredicate charPredicate);

    boolean containsSomeOf(@NotNull BasedSequence basedSequence);

    @NotNull
    BasedSequence extendByAny(@NotNull CharPredicate charPredicate);

    @NotNull
    BasedSequence extendByAny(@NotNull CharPredicate charPredicate, int i);

    @NotNull
    BasedSequence extendByAnyNot(@NotNull CharPredicate charPredicate);

    @NotNull
    BasedSequence extendByAnyNot(@NotNull CharPredicate charPredicate, int i);

    @NotNull
    BasedSequence extendByOneOfAny(@NotNull CharPredicate charPredicate);

    @NotNull
    BasedSequence extendByOneOfAnyNot(@NotNull CharPredicate charPredicate);

    @Deprecated
    @NotNull
    default BasedSequence extendToAny(@NotNull CharPredicate charPredicate, int i) {
        return extendByAnyNot(charPredicate, i);
    }

    @NotNull
    BasedSequence extendToEndOfLine();

    @NotNull
    BasedSequence extendToEndOfLine(@NotNull CharPredicate charPredicate);

    @NotNull
    BasedSequence extendToEndOfLine(@NotNull CharPredicate charPredicate, boolean z);

    @NotNull
    BasedSequence extendToEndOfLine(boolean z);

    @NotNull
    BasedSequence extendToStartOfLine();

    @NotNull
    BasedSequence extendToStartOfLine(@NotNull CharPredicate charPredicate);

    @NotNull
    BasedSequence extendToStartOfLine(@NotNull CharPredicate charPredicate, boolean z);

    @NotNull
    BasedSequence extendToStartOfLine(boolean z);

    @NotNull
    Object getBase();

    @NotNull
    BasedSequence getBaseSequence();

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    SequenceBuilder getBuilder();

    @NotNull
    BasedSequence getEmptyPrefix();

    @NotNull
    BasedSequence getEmptySuffix();

    int getEndOffset();

    int getIndexOffset(int i);

    @NotNull
    SegmentTree getSegmentTree();

    @NotNull
    Range getSourceRange();

    int getStartOffset();

    @NotNull
    BasedSequence intersect(@NotNull BasedSequence basedSequence);

    boolean isBaseCharAt(int i, @NotNull CharPredicate charPredicate);

    boolean isContinuationOf(@NotNull BasedSequence basedSequence);

    boolean isContinuedBy(@NotNull BasedSequence basedSequence);

    @NotNull
    BasedSequence normalizeEOL(@NotNull ReplacedTextMapper replacedTextMapper);

    @NotNull
    BasedSequence normalizeEndWithEOL(@NotNull ReplacedTextMapper replacedTextMapper);

    @NotNull
    BasedSequence prefixOf(@NotNull BasedSequence basedSequence);

    @NotNull
    BasedSequence prefixWithIndent();

    @NotNull
    BasedSequence prefixWithIndent(int i);

    char safeBaseCharAt(int i);

    @NotNull
    BasedSequence spliceAtEnd(@NotNull BasedSequence basedSequence);

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    BasedSequence subSequence(int i, int i2);

    @NotNull
    BasedSequence suffixOf(@NotNull BasedSequence basedSequence);

    @NotNull
    BasedSequence unescape(@NotNull ReplacedTextMapper replacedTextMapper);

    @NotNull
    String unescape();

    @NotNull
    String unescapeNoEntities();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmptyBasedSequence extends BasedSequenceImpl {
        public EmptyBasedSequence() {
            super(0);
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
        public boolean allOptions(int i) {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
        public boolean anyOptions(int i) {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
        @NotNull
        public BasedSequence baseSubSequence(int i, int i2) {
            return subSequence(i, i2);
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            throw new StringIndexOutOfBoundsException("EMPTY sequence has no characters");
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        @NotNull
        public BasedSequence getBase() {
            return this;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        @NotNull
        public BasedSequence getBaseSequence() {
            return this;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        public int getEndOffset() {
            return 0;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        public int getIndexOffset(int i) {
            SequenceUtils.validateIndexInclusiveEnd(i, length());
            return 0;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
        public <T> T getOption(DataKeyBase<T> dataKeyBase) {
            return dataKeyBase.get(null);
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
        public int getOptionFlags() {
            return 0;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
        @Nullable
        public DataHolder getOptions() {
            return null;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        @NotNull
        public Range getSourceRange() {
            return Range.NULL;
        }

        @Override // com.vladsch.flexmark.util.sequence.BasedSequence
        public int getStartOffset() {
            return 0;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return 0;
        }

        @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
        @NotNull
        public BasedSequence subSequence(int i, int i2) {
            SequenceUtils.validateStartEnd(i, i2, length());
            return this;
        }
    }

    @NotNull
    static BasedSequence repeatOf(@NotNull CharSequence charSequence, int i) {
        return m13437of(RepeatedSequence.repeatOf(charSequence, 0, charSequence.length() * i));
    }

    @Deprecated
    @NotNull
    default BasedSequence extendToAny(@NotNull CharPredicate charPredicate) {
        return extendByAnyNot(charPredicate);
    }

    @NotNull
    static BasedSequence repeatOf(@NotNull CharSequence charSequence, int i, int i2) {
        return m13437of(RepeatedSequence.repeatOf(charSequence, i, i2));
    }
}
