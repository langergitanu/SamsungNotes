package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BasedSequenceImpl extends IRichSequenceBase<BasedSequence> implements BasedSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public BasedSequenceImpl(int i) {
        super(i);
    }

    public static BasedSequence create(@Nullable CharSequence charSequence) {
        return charSequence == null ? BasedSequence.NULL : charSequence instanceof BasedSequence ? (BasedSequence) charSequence : SubSequence.create(charSequence);
    }

    public static BasedSequence firstNonNull(BasedSequence... basedSequenceArr) {
        for (BasedSequence basedSequence : basedSequenceArr) {
            if (basedSequence != null && basedSequence != BasedSequence.NULL) {
                return basedSequence;
            }
        }
        return BasedSequence.NULL;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        iBasedSegmentBuilder.append(getStartOffset(), getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseColumnAtEnd() {
        return baseColumnAtIndex(getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseColumnAtIndex(int i) {
        return getBaseSequence().columnAtIndex(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseColumnAtStart() {
        return baseColumnAtIndex(getStartOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseEndOfLine(int i) {
        return getBaseSequence().endOfLine(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseEndOfLineAnyEOL(int i) {
        return getBaseSequence().endOfLineAnyEOL(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Pair<Integer, Integer> baseLineColumnAtEnd() {
        return baseLineColumnAtIndex(getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Pair<Integer, Integer> baseLineColumnAtIndex(int i) {
        return getBaseSequence().lineColumnAtIndex(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Pair<Integer, Integer> baseLineColumnAtStart() {
        return baseLineColumnAtIndex(getStartOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range baseLineRangeAtEnd() {
        return baseLineRangeAtIndex(getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range baseLineRangeAtIndex(int i) {
        return getBaseSequence().lineRangeAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range baseLineRangeAtStart() {
        return baseLineRangeAtIndex(getStartOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseStartOfLine(int i) {
        return getBaseSequence().startOfLine(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseStartOfLineAnyEOL(int i) {
        return getBaseSequence().startOfLineAnyEOL(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence baseSubSequence(int i) {
        return baseSubSequence(i, getBaseSequence().getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsAllOf(@NotNull BasedSequence basedSequence) {
        return getBase() == basedSequence.getBase() && basedSequence.getStartOffset() >= getStartOffset() && basedSequence.getEndOffset() <= getEndOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsOnlyIn(@NotNull CharPredicate charPredicate) {
        return !containsSomeNotIn(charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsOnlyNotIn(@NotNull CharPredicate charPredicate) {
        return !containsSomeIn(charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsSomeIn(@NotNull CharPredicate charPredicate) {
        int length = length();
        for (int i = 0; i < length; i++) {
            if (charPredicate.test(charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsSomeNotIn(@NotNull CharPredicate charPredicate) {
        int length = length();
        for (int i = 0; i < length; i++) {
            if (!charPredicate.test(charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean containsSomeOf(@NotNull BasedSequence basedSequence) {
        return getBase() == basedSequence.getBase() && getStartOffset() < basedSequence.getEndOffset() && getEndOffset() > basedSequence.getStartOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByAny(@NotNull CharPredicate charPredicate) {
        return extendByAny(charPredicate, Integer.MAX_VALUE - getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByAnyNot(@NotNull CharPredicate charPredicate) {
        return extendByAnyNot(charPredicate, Integer.MAX_VALUE - getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByOneOfAny(@NotNull CharPredicate charPredicate) {
        return extendByAny(charPredicate, 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByOneOfAnyNot(@NotNull CharPredicate charPredicate) {
        return extendByAnyNot(charPredicate, 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToEndOfLine(@NotNull CharPredicate charPredicate) {
        return extendToEndOfLine(charPredicate, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToStartOfLine(@NotNull CharPredicate charPredicate) {
        return extendToStartOfLine(charPredicate, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence getEmptyPrefix() {
        return subSequence(0, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence getEmptySuffix() {
        return subSequence(length());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public SegmentTree getSegmentTree() {
        BasedSegmentBuilder basedSegmentBuilderEmptyBuilder = BasedSegmentBuilder.emptyBuilder(getBaseSequence());
        addSegments(basedSegmentBuilderEmptyBuilder);
        return SegmentTree.build(basedSegmentBuilderEmptyBuilder.getSegments(), basedSegmentBuilderEmptyBuilder.getText());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence intersect(@NotNull BasedSequence basedSequence) {
        return getBase() != basedSequence.getBase() ? BasedSequence.NULL : basedSequence.getEndOffset() <= getStartOffset() ? subSequence(0, 0) : basedSequence.getStartOffset() >= getEndOffset() ? subSequence(length(), length()) : baseSubSequence(Utils.max(getStartOffset(), basedSequence.getStartOffset()), Utils.min(getEndOffset(), basedSequence.getEndOffset()));
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean isBaseCharAt(int i, @NotNull CharPredicate charPredicate) {
        return charPredicate.test(safeBaseCharAt(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean isContinuationOf(@NotNull BasedSequence basedSequence) {
        return basedSequence.length() > 0 && length() > 0 && basedSequence.getBase() == getBase() && basedSequence.getEndOffset() == getStartOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public boolean isContinuedBy(@NotNull BasedSequence basedSequence) {
        return basedSequence.length() > 0 && length() > 0 && basedSequence.getBase() == getBase() && basedSequence.getStartOffset() == getEndOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence normalizeEOL(@NotNull ReplacedTextMapper replacedTextMapper) {
        return Escaping.normalizeEOL(this, replacedTextMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence normalizeEndWithEOL(@NotNull ReplacedTextMapper replacedTextMapper) {
        return Escaping.normalizeEndWithEOL(this, replacedTextMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence prefixOf(@NotNull BasedSequence basedSequence) {
        return getBase() != basedSequence.getBase() ? BasedSequence.NULL : basedSequence.getStartOffset() <= getStartOffset() ? subSequence(0, 0) : basedSequence.getStartOffset() >= getEndOffset() ? this : baseSubSequence(getStartOffset(), basedSequence.getStartOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence prefixWithIndent() {
        return prefixWithIndent(Integer.MAX_VALUE);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public char safeBaseCharAt(int i) {
        int startOffset = getStartOffset();
        return (i < startOffset || i >= length() + startOffset) ? getBaseSequence().safeCharAt(i) : charAt(i - startOffset);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequenceBase, com.vladsch.flexmark.util.sequence.IRichSequence
    public char safeCharAt(int i) {
        if (i < 0 || i >= length()) {
            return (char) 0;
        }
        return charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence spliceAtEnd(@NotNull BasedSequence basedSequence) {
        return basedSequence.isEmpty() ? this : isEmpty() ? basedSequence : baseSubSequence(getStartOffset(), basedSequence.getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence suffixOf(@NotNull BasedSequence basedSequence) {
        return getBase() != basedSequence.getBase() ? BasedSequence.NULL : basedSequence.getEndOffset() >= getEndOffset() ? subSequence(length(), length()) : basedSequence.getEndOffset() <= getStartOffset() ? this : baseSubSequence(basedSequence.getEndOffset(), getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequenceBase, com.vladsch.flexmark.util.sequence.IRichSequence
    @Nullable
    public String toStringOrNull() {
        if (isNull()) {
            return null;
        }
        return toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public String unescape() {
        return Escaping.unescapeString(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public String unescapeNoEntities() {
        return Escaping.unescapeString(this, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseEndOfLine() {
        return baseEndOfLine(getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseEndOfLineAnyEOL() {
        return baseEndOfLineAnyEOL(getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseStartOfLine() {
        return baseStartOfLine(getStartOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int baseStartOfLineAnyEOL() {
        return baseStartOfLineAnyEOL(getStartOffset());
    }

    @NotNull
    public BasedSequence baseSubSequence(int i, int i2) {
        return getBaseSequence().subSequence(i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence[] emptyArray() {
        return BasedSequence.EMPTY_ARRAY;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByAny(@NotNull CharPredicate charPredicate, int i) {
        int iCountLeading = getBaseSequence().countLeading(charPredicate, getEndOffset(), getEndOffset() + i);
        return iCountLeading == 0 ? this : baseSubSequence(getStartOffset(), getEndOffset() + iCountLeading);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendByAnyNot(@NotNull CharPredicate charPredicate, int i) {
        int iCountLeadingNot = getBaseSequence().countLeadingNot(charPredicate, getEndOffset(), getEndOffset() + i);
        return iCountLeadingNot == getBaseSequence().length() - getEndOffset() ? this : baseSubSequence(getStartOffset(), getEndOffset() + iCountLeadingNot + 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToEndOfLine(boolean z) {
        return extendToEndOfLine(CharPredicate.EOL, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToStartOfLine(boolean z) {
        return extendToStartOfLine(CharPredicate.EOL, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public SequenceBuilder getBuilder() {
        return SequenceBuilder.emptyBuilder(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence nullSequence() {
        return BasedSequence.NULL;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequenceBase, com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence prefixWith(@Nullable CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? this : PrefixedSubSequence.prefixOf(charSequence.toString(), this);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence prefixWithIndent(int i) {
        int startOffset = getStartOffset();
        int startOffset2 = getStartOffset();
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (startOffset2 < 0) {
                break;
            }
            char cCharAt = getBaseSequence().charAt(startOffset2);
            if (cCharAt != '\t') {
                if (cCharAt == '\n') {
                    startOffset2++;
                    break;
                }
            } else {
                z = true;
            }
            startOffset2--;
        }
        if (startOffset2 < 0) {
            startOffset2 = 0;
        }
        if (startOffset2 < startOffset) {
            if (!z) {
                while (i2 < i && startOffset > 0) {
                    int i4 = startOffset - 1;
                    if (getBaseSequence().charAt(i4) != ' ' && getBaseSequence().charAt(i4) != '\t') {
                        break;
                    }
                    i2++;
                    startOffset--;
                }
            } else {
                int[] iArr = new int[startOffset - startOffset2];
                int i5 = 0;
                for (int i6 = startOffset2; i6 < startOffset; i6++) {
                    if (getBaseSequence().charAt(i6) == '\t') {
                        int i7 = 4 - (i5 % 4);
                        iArr[i6 - startOffset2] = i7;
                        i5 += i7;
                    } else {
                        iArr[i6 - startOffset2] = 1;
                        i5++;
                    }
                }
                while (i2 < i && startOffset > 0) {
                    int i8 = startOffset - 1;
                    if ((getBaseSequence().charAt(i8) != ' ' && getBaseSequence().charAt(i8) != '\t') || (i2 = i2 + iArr[i8 - startOffset2]) > i) {
                        break;
                    }
                    startOffset--;
                }
            }
        }
        return startOffset == getStartOffset() ? this : baseSubSequence(startOffset, getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence sequenceOf(@Nullable CharSequence charSequence, int i, int i2) {
        return BasedSequence.m13437of(charSequence).subSequence(i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence toMapped(CharMapper charMapper) {
        return MappedBasedSequence.mappedOf(this, charMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence unescape(@NotNull ReplacedTextMapper replacedTextMapper) {
        return Escaping.unescape(this, replacedTextMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToEndOfLine() {
        return extendToEndOfLine(CharPredicate.EOL, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToStartOfLine() {
        return extendToStartOfLine(CharPredicate.EOL, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence extendToEndOfLine(@NotNull CharPredicate charPredicate, boolean z) {
        int endOffset = getEndOffset();
        if (!charPredicate.test(lastChar())) {
            BasedSequence baseSequence = getBaseSequence();
            int iEndOfLine = baseSequence.endOfLine(endOffset);
            if (z) {
                iEndOfLine = Math.min(baseSequence.length(), Math.min(baseSequence.eolStartLength(iEndOfLine), 1) + iEndOfLine);
            }
            if (iEndOfLine != endOffset) {
                return baseSequence.subSequence(getStartOffset(), iEndOfLine);
            }
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence extendToStartOfLine(@NotNull CharPredicate charPredicate, boolean z) {
        int startOffset = getStartOffset();
        if (!charPredicate.test(firstChar())) {
            BasedSequence baseSequence = getBaseSequence();
            int iStartOfLine = baseSequence.startOfLine(startOffset);
            if (z) {
                iStartOfLine = Math.max(0, iStartOfLine - Math.min(baseSequence.eolEndLength(iStartOfLine), 1));
            }
            if (iStartOfLine != startOffset) {
                return baseSequence.subSequence(iStartOfLine, getEndOffset());
            }
        }
        return this;
    }
}
