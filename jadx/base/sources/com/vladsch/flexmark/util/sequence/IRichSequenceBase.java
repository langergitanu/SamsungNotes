package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.collection.iteration.ArrayIterable;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.IRichSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.mappers.ChangeCase;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class IRichSequenceBase<T extends IRichSequence<T>> implements IRichSequence<T> {
    private int hash;

    public IRichSequenceBase(int i) {
        this.hash = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$nullIf$0(Predicate predicate, IRichSequence iRichSequence, CharSequence charSequence) {
        return predicate.test(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$nullIfNot$1(Predicate predicate, IRichSequence iRichSequence, CharSequence charSequence) {
        return predicate.test(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T append(CharSequence... charSequenceArr) {
        return (T) append(new ArrayIterable(charSequenceArr));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendEOL() {
        return (T) suffixWith("\n");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendRangesTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, Range... rangeArr) {
        return (T) appendRangesTo(sb, charMapper, new ArrayIterable(rangeArr));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendSpace() {
        return (T) suffixWith(" ");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendSpaces(int i) {
        return (T) suffixWith(RepeatedSequence.ofSpaces(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper) {
        return (T) appendTo(sb, charMapper, 0, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<Range> blankLinesRemovedRanges() {
        return SequenceUtils.blankLinesRemovedRanges(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int columnAtIndex(int i) {
        return SequenceUtils.columnAtIndex(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeading(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countLeading(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingColumns(int i, @NotNull CharPredicate charPredicate) {
        return SequenceUtils.countLeadingColumns(this, i, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNot(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countLeadingNot(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpace() {
        return SequenceUtils.countLeadingNotSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpaceTab() {
        return SequenceUtils.countLeadingNotSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotWhitespace() {
        return SequenceUtils.countLeadingNotWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpace() {
        return SequenceUtils.countLeadingSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpaceTab() {
        return SequenceUtils.countLeadingSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingWhitespace() {
        return SequenceUtils.countLeadingWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAny(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countOfAny(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAnyNot(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countOfAnyNot(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfNotSpaceTab() {
        return SequenceUtils.countOfNotSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfNotWhitespace() {
        return SequenceUtils.countOfNotWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfSpaceTab() {
        return SequenceUtils.countOfSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfWhitespace() {
        return SequenceUtils.countOfWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailing(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countTrailing(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNot(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countTrailingNot(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpace() {
        return SequenceUtils.countTrailingNotSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpaceTab() {
        return SequenceUtils.countTrailingNotSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotWhitespace() {
        return SequenceUtils.countTrailingNotWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpace() {
        return SequenceUtils.countTrailingSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpaceTab() {
        return SequenceUtils.countTrailingSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingWhitespace() {
        return SequenceUtils.countTrailingWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T delete(int i, int i2) {
        int iMax = Math.max(0, Math.min(length(), i2));
        int iMin = Math.min(iMax, Math.max(0, i));
        return iMin == iMax ? this : iMin == 0 ? (T) subSequence(iMax) : iMax == length() ? subSequence(0, iMin) : (T) getBuilder().add(subSequence(0, iMin)).add(subSequence(iMax)).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final char endCharAt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return (char) 0;
        }
        return charAt(length - i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int endOfDelimitedBy(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.endOfDelimitedBy(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int endOfDelimitedByAny(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.endOfDelimitedByAny(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int endOfDelimitedByAnyNot(@NotNull CharPredicate charPredicate, int i) {
        return endOfDelimitedByAny(charPredicate.negate(), i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int endOfLine(int i) {
        return SequenceUtils.endOfLine(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int endOfLineAnyEOL(int i) {
        return SequenceUtils.endOfLineAnyEOL(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T endSequence(int i, int i2) {
        int length = length();
        int iRangeLimit = Utils.rangeLimit(length - i2, 0, length);
        return subSequence(Utils.rangeLimit(length - i, 0, iRangeLimit), iRangeLimit);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWith(@NotNull CharSequence charSequence) {
        return SequenceUtils.endsWith(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithAnyEOL() {
        return SequenceUtils.endsWithAnyEOL(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithEOL() {
        return SequenceUtils.endsWithEOL(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithIgnoreCase(@NotNull CharSequence charSequence) {
        return length() > 0 && matchCharsReversed(charSequence, length() - 1, true);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithSpace() {
        return SequenceUtils.endsWithSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithSpaceTab() {
        return SequenceUtils.endsWithSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWithWhitespace() {
        return SequenceUtils.endsWithWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int eolEndLength() {
        return SequenceUtils.eolEndLength(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range eolEndRange(int i) {
        return SequenceUtils.eolEndRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int eolStartLength(int i) {
        return SequenceUtils.eolStartLength(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public Range eolStartRange(int i) {
        return SequenceUtils.eolStartRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @Contract(pure = true, value = "null -> false")
    public final boolean equals(Object obj) {
        return SequenceUtils.equals(this, obj);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @Contract(pure = true, value = "null -> false")
    public final boolean equalsIgnoreCase(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (charSequence.length() != length() || !matchChars(charSequence, 0, true)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T extractRanges(Range... rangeArr) {
        return (T) extractRanges(new ArrayIterable(rangeArr));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final char firstChar() {
        if (isEmpty()) {
            return (char) 0;
        }
        return charAt(0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @Contract(pure = true)
    public final int hashCode() {
        int i = this.hash;
        if (i != 0 || length() <= 0) {
            return i;
        }
        int iHashCode = SequenceUtils.hashCode(this);
        this.hash = iHashCode;
        return iHashCode;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T ifNull(@NotNull T t) {
        return isNull() ? t : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T ifNullEmptyAfter(@NotNull T t) {
        return isNull() ? (T) t.subSequence(t.length(), t.length()) : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T ifNullEmptyBefore(@NotNull T t) {
        return isNull() ? (T) t.subSequence(0, 0) : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(@NotNull CharSequence charSequence) {
        return SequenceUtils.indexOf(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final int[] indexOfAll(@NotNull CharSequence charSequence) {
        return SequenceUtils.indexOfAll(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAny(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.indexOfAny(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAnyNot(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.indexOfAnyNot(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfNot(char c) {
        return SequenceUtils.indexOfNot(this, c);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T insert(int i, @NotNull CharSequence charSequence) {
        int iMax = Math.max(0, Math.min(length(), i));
        return charSequence.length() == 0 ? this : iMax == 0 ? (T) prefixWith(charSequence) : iMax == length() ? (T) suffixWith(charSequence) : (T) getBuilder().add(subSequence(0, iMax)).add(charSequence).add(subSequence(iMax)).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isBlank() {
        return SequenceUtils.isBlank(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public boolean isCharAt(int i, @NotNull CharPredicate charPredicate) {
        return charPredicate.test(safeCharAt(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isEmpty() {
        return SequenceUtils.isEmpty(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public boolean isIn(@NotNull String[] strArr) {
        return SequenceUtils.containedBy(strArr, this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isNotBlank() {
        return SequenceUtils.isNotBlank(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isNotEmpty() {
        return SequenceUtils.isNotEmpty(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isNotNull() {
        return this != nullSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean isNull() {
        return this == nullSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final char lastChar() {
        if (isEmpty()) {
            return (char) 0;
        }
        return charAt(length() - 1);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(char c) {
        return SequenceUtils.lastIndexOf(this, c);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAny(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.lastIndexOfAny(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.lastIndexOfAnyNot(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfNot(char c) {
        return SequenceUtils.lastIndexOfNot(this, c);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range leadingBlankLinesRange() {
        return SequenceUtils.leadingBlankLinesRange(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T lineAt(int i) {
        return (T) subSequence(lineRangeAt(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T lineAtAnyEOL(int i) {
        return (T) subSequence(lineRangeAtAnyEOL(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Pair<Integer, Integer> lineColumnAtIndex(int i) {
        return SequenceUtils.lineColumnAtIndex(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range lineRangeAt(int i) {
        return SequenceUtils.lineRangeAt(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range lineRangeAtAnyEOL(int i) {
        return SequenceUtils.lineRangeAtAnyEOL(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchChars(@NotNull CharSequence charSequence, int i, boolean z) {
        return SequenceUtils.matchChars(this, charSequence, i, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchCharsIgnoreCase(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchCharsReversed(@NotNull CharSequence charSequence, int i, boolean z) {
        return SequenceUtils.matchCharsReversed(this, charSequence, i, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchCharsReversedIgnoreCase(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchCharsReversedIgnoreCase(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2, boolean z) {
        return SequenceUtils.matchedCharCount(this, charSequence, i, i2, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchedCharCountIgnoreCase(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.matchedCharCountReversed(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.matchedCharCountReversedIgnoreCase(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matches(@NotNull CharSequence charSequence, boolean z) {
        return SequenceUtils.matches(this, charSequence, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchesIgnoreCase(@NotNull CharSequence charSequence) {
        return SequenceUtils.matchesIgnoreCase(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final char midCharAt(int i) {
        int length = length();
        if (i < (-length) || i >= length) {
            return (char) 0;
        }
        if (i < 0) {
            i += length;
        }
        return charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T midSequence(int i, int i2) {
        int length = length();
        if (i < 0) {
            i += length;
        }
        if (i2 < 0) {
            i2 += length;
        }
        int iRangeLimit = Utils.rangeLimit(i2, 0, length);
        return subSequence(Utils.rangeLimit(i, 0, iRangeLimit), iRangeLimit);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final String normalizeEOL() {
        return Escaping.normalizeEOL(toString());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final String normalizeEndWithEOL() {
        return Escaping.normalizeEndWithEOL(toString());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIf(boolean z) {
        return z ? nullSequence() : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfBlank() {
        return isBlank() ? nullSequence() : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfEmpty() {
        return isEmpty() ? nullSequence() : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfEndsWith(CharSequence... charSequenceArr) {
        return (T) nullIf(new C11881b(this, 3), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfEndsWithIgnoreCase(CharSequence... charSequenceArr) {
        return (T) nullIf(new C11881b(this, 2), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNot(@NotNull BiPredicate<? super T, ? super CharSequence> biPredicate, CharSequence... charSequenceArr) {
        return (T) nullIf(biPredicate.negate(), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotEndsWith(CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11881b(this, 3), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotEndsWithIgnoreCase(CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11881b(this, 2), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotStartsWith(CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11881b(this, 4), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotStartsWithIgnoreCase(CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11881b(this, 1), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfStartsWith(CharSequence... charSequenceArr) {
        return (T) nullIf(new C11881b(this, 4), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfStartsWithIgnoreCase(CharSequence... charSequenceArr) {
        return (T) nullIf(new C11881b(this, 1), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T padEnd(int i, char c) {
        IRichSequence iRichSequencePadding = padding(i, c);
        return iRichSequencePadding.isEmpty() ? this : (T) getBuilder().append((CharSequence) this).append((CharSequence) iRichSequencePadding).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T padStart(int i, char c) {
        IRichSequence iRichSequencePadding = padding(i, c);
        return iRichSequencePadding.isEmpty() ? this : (T) getBuilder().append((CharSequence) iRichSequencePadding).append((CharSequence) this).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T padding(int i, char c) {
        return i <= length() ? nullSequence() : (T) sequenceOf(RepeatedSequence.repeatOf(c, i - length()));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixOnceWith(@Nullable CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0 || startsWith(charSequence)) ? this : (T) prefixWith(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixOnceWithEOL() {
        return (T) prefixOnceWith("\n");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixOnceWithSpace() {
        return (T) prefixOnceWith(" ");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T prefixWith(@Nullable CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? this : (T) getBuilder().add(charSequence).add(this).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixWithEOL() {
        return (T) prefixWith("\n");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixWithSpace() {
        return (T) prefixWith(" ");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T prefixWithSpaces(int i) {
        return (T) prefixWith(RepeatedSequence.ofSpaces(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removePrefix(@NotNull CharSequence charSequence) {
        return !startsWith(charSequence) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removePrefixIgnoreCase(@NotNull CharSequence charSequence) {
        return !startsWithIgnoreCase(charSequence) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperPrefix(@NotNull CharSequence charSequence) {
        return (length() <= charSequence.length() || !startsWith(charSequence)) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperPrefixIgnoreCase(@NotNull CharSequence charSequence) {
        return (length() <= charSequence.length() || !startsWithIgnoreCase(charSequence)) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperSuffix(@NotNull CharSequence charSequence) {
        return (length() <= charSequence.length() || !endsWith(charSequence)) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperSuffixIgnoreCase(@NotNull CharSequence charSequence) {
        return (length() <= charSequence.length() || !endsWithIgnoreCase(charSequence)) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeSuffix(@NotNull CharSequence charSequence) {
        return !endsWith(charSequence) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeSuffixIgnoreCase(@NotNull CharSequence charSequence) {
        return !endsWithIgnoreCase(charSequence) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T replace(int i, int i2, @NotNull CharSequence charSequence) {
        int length = length();
        return (T) getBuilder().add(subSequence(0, Math.max(i, 0))).add(charSequence).add(subSequence(Math.min(i2, length))).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public char safeCharAt(int i) {
        if (i < 0 || i >= length()) {
            return (char) 0;
        }
        return charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T safeSubSequence(int i, int i2) {
        int length = length();
        int iMax = Math.max(0, Math.min(length, i));
        return subSequence(iMax, Math.max(iMax, Math.min(length, i2)));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T sequenceOf(@Nullable CharSequence charSequence) {
        return charSequence == null ? nullSequence() : sequenceOf(charSequence, 0, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] split(@NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate) {
        return (T[]) split(charSequence, 0, z ? 1 : 0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] splitEOL() {
        return (T[]) split("\n", 0, 1, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitList(@NotNull CharSequence charSequence) {
        return SequenceUtils.splitList(this, charSequence, 0, 0, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitListEOL() {
        return SequenceUtils.splitList(this, "\n", 0, 1, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int startOfDelimitedBy(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.startOfDelimitedBy(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int startOfDelimitedByAny(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.startOfDelimitedByAny(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int startOfDelimitedByAnyNot(@NotNull CharPredicate charPredicate, int i) {
        return startOfDelimitedByAny(charPredicate.negate(), i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int startOfLine(int i) {
        return SequenceUtils.startOfLine(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int startOfLineAnyEOL(int i) {
        return SequenceUtils.startOfLineAnyEOL(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWith(@NotNull CharSequence charSequence) {
        return SequenceUtils.startsWith(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithAnyEOL() {
        return SequenceUtils.startsWithAnyEOL(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithEOL() {
        return SequenceUtils.startsWithEOL(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithIgnoreCase(@NotNull CharSequence charSequence) {
        return length() > 0 && matchChars(charSequence, 0, true);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithSpace() {
        return SequenceUtils.startsWithSpace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithSpaceTab() {
        return SequenceUtils.startsWithSpaceTab(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWithWhitespace() {
        return SequenceUtils.startsWithWhitespace(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T subSequence(int i) {
        return subSequence(i, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T subSequenceAfter(@NotNull Range range) {
        return range.isNull() ? nullSequence() : (T) subSequence(range.getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T subSequenceBefore(@NotNull Range range) {
        return range.isNull() ? nullSequence() : subSequence(0, range.getStart());
    }

    public final Pair<T, T> subSequenceBeforeAfter(Range range) {
        return Pair.m13429of(subSequenceBefore(range), subSequenceAfter(range));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixOnceWith(@Nullable CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0 || endsWith(charSequence)) ? this : (T) suffixWith(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixOnceWithEOL() {
        return (T) suffixOnceWith("\n");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixOnceWithSpace() {
        return (T) suffixOnceWith(" ");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T suffixWith(@Nullable CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? this : (T) getBuilder().add(this).add(charSequence).toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixWithEOL() {
        return (T) suffixWith("\n");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixWithSpace() {
        return (T) suffixWith(" ");
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T suffixWithSpaces(int i) {
        return (T) suffixWith(RepeatedSequence.ofSpaces(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T toLowerCase() {
        return toMapped(ChangeCase.toLowerCase);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T toNbSp() {
        return toMapped(SpaceMapper.toNonBreakSpace);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T toSpc() {
        return toMapped(SpaceMapper.fromNonBreakSpace);
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        int length = length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(charAt(i));
        }
        return sb.toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @Nullable
    public String toStringOrNull() {
        if (isNull()) {
            return null;
        }
        return toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T toUpperCase() {
        return toMapped(ChangeCase.toUpperCase);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final String toVisibleWhitespaceString() {
        return SequenceUtils.toVisibleWhitespaceString(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trailingBlankLinesRange() {
        return SequenceUtils.trailingBlankLinesRange(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trim(@NotNull CharPredicate charPredicate) {
        return (T) trim(0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimEOL() {
        int iEolEndLength = eolEndLength();
        return iEolEndLength > 0 ? subSequence(0, length() - iEolEndLength) : this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimEnd(@NotNull CharPredicate charPredicate) {
        return (T) trimEnd(0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimEndRange(int i, @NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimEndRange(this, i, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimLeadBlankLines() {
        Range rangeLeadingBlankLinesRange = leadingBlankLinesRange();
        return rangeLeadingBlankLinesRange.isNull() ? this : (T) subSequenceAfter(rangeLeadingBlankLinesRange);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimRange(int i, @NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimRange(this, i, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimStart(@NotNull CharPredicate charPredicate) {
        return (T) subSequence(trimStartRange(0, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimStartRange(int i, @NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimStartRange(this, i, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimTailBlankLines() {
        Range rangeTrailingBlankLinesRange = trailingBlankLinesRange();
        return rangeTrailingBlankLinesRange.isNull() ? this : (T) subSequenceBefore(rangeTrailingBlankLinesRange);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToEndOfLine(boolean z) {
        return (T) trimToEndOfLine(CharPredicate.EOL, z, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToStartOfLine(boolean z) {
        return (T) trimToStartOfLine(CharPredicate.EOL, z, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Pair<T, T> trimmed(@NotNull CharPredicate charPredicate) {
        return trimmed(0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedEOL() {
        int iEolEndLength = eolEndLength();
        return iEolEndLength > 0 ? (T) subSequence(length() - iEolEndLength) : nullSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedEnd(@NotNull CharPredicate charPredicate) {
        return (T) trimmedEnd(0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedStart(@NotNull CharPredicate charPredicate) {
        return (T) trimmedStart(0, charPredicate);
    }

    public final void validateIndex(int i) {
        SequenceUtils.validateIndex(i, length());
    }

    public final void validateIndexInclusiveEnd(int i) {
        SequenceUtils.validateIndexInclusiveEnd(i, length());
    }

    public final void validateStartEnd(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T append(Iterable<? extends CharSequence> iterable) {
        ISequenceBuilder builder = getBuilder();
        builder.add(this);
        Iterator<? extends CharSequence> it = iterable.iterator();
        while (it.hasNext()) {
            builder.add(it.next());
        }
        return (T) builder.toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendRangesTo(@NotNull StringBuilder sb, Range... rangeArr) {
        return (T) appendRangesTo(sb, (CharMapper) null, new ArrayIterable(rangeArr));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, int i) {
        return (T) appendTo(sb, charMapper, i, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<Range> blankLinesRemovedRanges(int i) {
        return SequenceUtils.blankLinesRemovedRanges(this, i);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull CharSequence charSequence) {
        return SequenceUtils.compare(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeading(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countLeading(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNot(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countLeadingNot(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpace(int i) {
        return SequenceUtils.countLeadingNotSpace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpaceTab(int i) {
        return SequenceUtils.countLeadingNotSpaceTab(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotWhitespace(int i) {
        return SequenceUtils.countLeadingNotWhitespace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpace(int i) {
        return SequenceUtils.countLeadingSpace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpaceTab(int i) {
        return SequenceUtils.countLeadingSpaceTab(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingWhitespace(int i) {
        return SequenceUtils.countLeadingWhitespace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAny(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countOfAny(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAnyNot(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.countOfAnyNot(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailing(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countTrailing(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNot(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.countTrailingNot(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpace(int i) {
        return SequenceUtils.countTrailingNotSpace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpaceTab(int i) {
        return SequenceUtils.countTrailingNotSpaceTab(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotWhitespace(int i) {
        return SequenceUtils.countTrailingNotWhitespace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpace(int i) {
        return SequenceUtils.countTrailingSpace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpaceTab(int i) {
        return SequenceUtils.countTrailingSpaceTab(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingWhitespace(int i) {
        return SequenceUtils.countTrailingWhitespace(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    /* JADX INFO: renamed from: endsWith, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final boolean lambda$nullIfNotEndsWith$5(@NotNull CharSequence charSequence, boolean z) {
        return SequenceUtils.endsWith(this, charSequence, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int eolEndLength(int i) {
        return SequenceUtils.eolEndLength(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @Contract(pure = true, value = "null, _ ->false")
    public final boolean equals(@Nullable Object obj, boolean z) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.length() == length() && matchChars(charSequence, 0, z)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T extractRanges(Iterable<Range> iterable) {
        ISequenceBuilder builder = getBuilder();
        for (Range range : iterable) {
            if (range != null && !range.isNull()) {
                builder.add(range.safeSubSequence(this));
            }
        }
        return (T) builder.toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.indexOf(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAny(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.indexOfAny(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAnyNot(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.indexOfAnyNot(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfNot(char c, int i) {
        return SequenceUtils.indexOfNot(this, c, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public boolean isIn(@NotNull Collection<? extends CharSequence> collection) {
        return SequenceUtils.containedBy(collection, this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(char c, int i) {
        return SequenceUtils.lastIndexOf(this, c, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAny(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.lastIndexOfAny(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate, int i) {
        return SequenceUtils.lastIndexOfAnyNot(this, charPredicate, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfNot(char c, int i) {
        return SequenceUtils.lastIndexOfNot(this, c, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range leadingBlankLinesRange(int i) {
        return SequenceUtils.leadingBlankLinesRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchChars(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchChars(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence) {
        return SequenceUtils.matchCharsIgnoreCase(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchCharsReversed(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchCharsReversed(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCount(@NotNull CharSequence charSequence, int i, boolean z) {
        return SequenceUtils.matchedCharCount(this, charSequence, i, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.matchedCharCountIgnoreCase(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, boolean z) {
        return SequenceUtils.matchedCharCountReversed(this, charSequence, i, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchedCharCountReversedIgnoreCase(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matches(@NotNull CharSequence charSequence) {
        return SequenceUtils.matches(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIf(@NotNull Predicate<? super CharSequence> predicate, CharSequence... charSequenceArr) {
        return (T) nullIf(new C11884c(predicate, 0), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfEndsWith(boolean z, CharSequence... charSequenceArr) {
        return (T) nullIf(new C11880a(this, z, 2), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNot(@NotNull Predicate<? super CharSequence> predicate, CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11884c(predicate, 1), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotEndsWith(boolean z, CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11880a(this, z, 3), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNotStartsWith(boolean z, CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11880a(this, z, 1), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfStartsWith(boolean z, CharSequence... charSequenceArr) {
        return (T) nullIf(new C11880a(this, z, 0), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T padding(int i) {
        return (T) padStart(i, ' ');
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removePrefix(@NotNull CharSequence charSequence, boolean z) {
        return !lambda$nullIfStartsWith$2(charSequence, z) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperPrefix(@NotNull CharSequence charSequence, boolean z) {
        return (length() <= charSequence.length() || !lambda$nullIfStartsWith$2(charSequence, z)) ? this : subSequence(charSequence.length(), length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeProperSuffix(@NotNull CharSequence charSequence, boolean z) {
        return (length() <= charSequence.length() || !lambda$nullIfNotEndsWith$5(charSequence, z)) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T removeSuffix(@NotNull CharSequence charSequence, boolean z) {
        return !lambda$nullIfNotEndsWith$5(charSequence, z) ? this : subSequence(0, length() - charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T sequenceOf(@Nullable CharSequence charSequence, int i) {
        return charSequence == null ? nullSequence() : sequenceOf(charSequence, i, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] split(@NotNull CharSequence charSequence) {
        return (T[]) split(charSequence, 0, 0, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] splitEOL(boolean z) {
        return (T[]) split("\n", 0, z ? 1 : 0, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitList(@NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate) {
        return SequenceUtils.splitList(this, charSequence, i, z ? 1 : 0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitListEOL(boolean z) {
        return SequenceUtils.splitList(this, "\n", 0, z ? 1 : 0, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    /* JADX INFO: renamed from: startsWith, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final boolean lambda$nullIfStartsWith$2(@NotNull CharSequence charSequence, boolean z) {
        return SequenceUtils.startsWith(this, charSequence, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T subSequence(@NotNull Range range) {
        return range.isNull() ? this : subSequence(range.getStart(), range.getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trailingBlankLinesRange(int i) {
        return SequenceUtils.trailingBlankLinesRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trim(int i) {
        return (T) trim(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimEnd(int i) {
        return (T) trimEnd(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimEndRange(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimEndRange(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimRange(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimRange(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimStart(int i) {
        return (T) trimStart(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimStartRange(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.trimStartRange(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToEndOfLine(int i) {
        return (T) trimToEndOfLine(CharPredicate.EOL, false, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToStartOfLine(int i) {
        return (T) trimToStartOfLine(CharPredicate.EOL, false, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Pair<T, T> trimmed(int i) {
        return trimmed(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedEnd(int i) {
        return (T) trimmedEnd(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedStart(int i) {
        return (T) trimmedStart(i, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendRangesTo(@NotNull StringBuilder sb, Iterable<? extends Range> iterable) {
        return (T) appendRangesTo(sb, (CharMapper) null, iterable);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb) {
        return (T) appendTo(sb, null, 0, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<Range> blankLinesRemovedRanges(int i, int i2) {
        return SequenceUtils.blankLinesRemovedRanges(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeading(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countLeading(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNot(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countLeadingNot(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpace(int i, int i2) {
        return SequenceUtils.countLeadingNotSpace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotSpaceTab(int i, int i2) {
        return SequenceUtils.countLeadingNotSpaceTab(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingNotWhitespace(int i, int i2) {
        return SequenceUtils.countLeadingNotWhitespace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpace(int i, int i2) {
        return SequenceUtils.countLeadingSpace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingSpaceTab(int i, int i2) {
        return SequenceUtils.countLeadingSpaceTab(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countLeadingWhitespace(int i, int i2) {
        return SequenceUtils.countLeadingWhitespace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAny(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countOfAny(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countOfAnyNot(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailing(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countTrailing(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNot(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.countTrailingNot(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpace(int i, int i2) {
        return SequenceUtils.countTrailingNotSpace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotSpaceTab(int i, int i2) {
        return SequenceUtils.countTrailingNotSpaceTab(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingNotWhitespace(int i, int i2) {
        return SequenceUtils.countTrailingNotWhitespace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpace(int i, int i2) {
        return SequenceUtils.countTrailingSpace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingSpaceTab(int i, int i2) {
        return SequenceUtils.countTrailingSpaceTab(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int countTrailingWhitespace(int i, int i2) {
        return SequenceUtils.countTrailingWhitespace(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean endsWith(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.endsWith(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.indexOf(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAny(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.indexOfAny(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.indexOfAnyNot(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOfNot(char c, int i, int i2) {
        return SequenceUtils.indexOfNot(this, c, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(@NotNull CharSequence charSequence) {
        return SequenceUtils.lastIndexOf(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAny(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.lastIndexOfAny(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.lastIndexOfAnyNot(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOfNot(char c, int i, int i2) {
        return SequenceUtils.lastIndexOfNot(this, c, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range leadingBlankLinesRange(int i, int i2) {
        return SequenceUtils.leadingBlankLinesRange(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchChars(@NotNull CharSequence charSequence, boolean z) {
        return SequenceUtils.matchChars(this, charSequence, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.matchedCharCount(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversed(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchedCharCountReversed(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIf(CharSequence... charSequenceArr) {
        return (T) nullIf(new C11881b(this, 0), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIfNot(CharSequence... charSequenceArr) {
        return (T) nullIfNot(new C11881b(this, 0), charSequenceArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T padEnd(int i) {
        return (T) padEnd(i, ' ');
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T padStart(int i) {
        return (T) padStart(i, ' ');
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] split(@NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate) {
        return (T[]) split(charSequence, i, z ? 1 : 0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitList(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.splitList(this, charSequence, i, i2, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitListEOL(boolean z, @Nullable CharPredicate charPredicate) {
        return SequenceUtils.splitList(this, "\n", 0, z ? 1 : 0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean startsWith(@NotNull CharPredicate charPredicate) {
        return SequenceUtils.startsWith(this, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trailingBlankLinesRange(int i, int i2) {
        return SequenceUtils.trailingBlankLinesRange(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trim() {
        return (T) trim(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimEnd() {
        return (T) trimEnd(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimEndRange(int i) {
        return SequenceUtils.trimEndRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimRange(int i) {
        return SequenceUtils.trimRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimStart() {
        return (T) trimStart(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimStartRange(int i) {
        return SequenceUtils.trimStartRange(this, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToEndOfLine() {
        return (T) trimToEndOfLine(CharPredicate.EOL, false, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToStartOfLine() {
        return (T) trimToStartOfLine(CharPredicate.EOL, false, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Pair<T, T> trimmed() {
        return trimmed(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedEnd() {
        return (T) trimmedEnd(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedStart() {
        return (T) trimmedStart(0, CharPredicate.WHITESPACE);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendRangesTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, Iterable<? extends Range> iterable) {
        T mapped = charMapper == null ? this : toMapped(charMapper);
        for (Range range : iterable) {
            if (range != null && range.isNotNull()) {
                sb.append((CharSequence) mapped, range.getStart(), range.getEnd());
            }
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb, int i) {
        return (T) appendTo(sb, null, i, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<Range> blankLinesRemovedRanges(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.blankLinesRemovedRanges(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(char c) {
        return SequenceUtils.indexOf(this, c);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.lastIndexOf(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range leadingBlankLinesRange(@NotNull CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.leadingBlankLinesRange(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final boolean matchChars(@NotNull CharSequence charSequence) {
        return SequenceUtils.matchChars(this, charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCount(@NotNull CharSequence charSequence, int i) {
        return SequenceUtils.matchedCharCount(this, charSequence, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, int i2, boolean z) {
        return SequenceUtils.matchedCharCountReversed(this, charSequence, i, i2, z);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T nullIf(@NotNull BiPredicate<? super T, ? super CharSequence> biPredicate, CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            if (biPredicate.test(this, charSequence)) {
                return nullSequence();
            }
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] split(@NotNull CharSequence charSequence, int i, int i2) {
        return (T[]) split(charSequence, i, i2, (CharPredicate) null);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitList(@NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate) {
        return SequenceUtils.splitList(this, charSequence, 0, z ? 1 : 0, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trailingBlankLinesRange(CharPredicate charPredicate, int i, int i2) {
        return SequenceUtils.trailingBlankLinesRange(this, charPredicate, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trim(int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(trimRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimEnd(int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(trimEndRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimEndRange() {
        return SequenceUtils.trimEndRange(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimRange() {
        return SequenceUtils.trimRange(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimStart(int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(trimStartRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Range trimStartRange() {
        return SequenceUtils.trimStartRange(this);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToEndOfLine(boolean z, int i) {
        return (T) trimToEndOfLine(CharPredicate.EOL, z, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToStartOfLine(boolean z, int i) {
        return (T) trimToStartOfLine(CharPredicate.EOL, z, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final Pair<T, T> trimmed(int i, @NotNull CharPredicate charPredicate) {
        return subSequenceBeforeAfter(trimRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedEnd(int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequenceAfter(trimEndRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T trimmedStart(int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequenceBefore(trimStartRange(i, charPredicate));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb, int i, int i2) {
        return (T) appendTo(sb, null, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T endSequence(int i) {
        return (T) endSequence(i, 0);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(char c, int i) {
        return SequenceUtils.indexOf(this, c, i);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(@NotNull CharSequence charSequence, int i, int i2) {
        return SequenceUtils.lastIndexOf(this, charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2, boolean z, boolean z2) {
        return SequenceUtils.matchedCharCount(this, charSequence, i, i2, z, z2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T midSequence(int i) {
        return (T) midSequence(i, length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T safeSubSequence(int i) {
        int length = length();
        return subSequence(Math.max(0, Math.min(length, i)), length);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T[] split(@NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate) {
        return (T[]) ((IRichSequence[]) SequenceUtils.splitList(this, charSequence, i, i2, charPredicate).toArray(emptyArray()));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final List<T> splitList(@NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate) {
        return SequenceUtils.splitList(this, charSequence, i, i2, charPredicate);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToEndOfLine(@NotNull CharPredicate charPredicate, boolean z, int i) {
        int iEndOfDelimitedByAny = endOfDelimitedByAny(charPredicate, i);
        if (iEndOfDelimitedByAny >= length()) {
            return this;
        }
        if (z) {
            iEndOfDelimitedByAny += eolStartLength(iEndOfDelimitedByAny);
        }
        return subSequence(0, iEndOfDelimitedByAny);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public T trimToStartOfLine(@NotNull CharPredicate charPredicate, boolean z, int i) {
        int iStartOfDelimitedByAny = startOfDelimitedByAny(charPredicate, i);
        if (iStartOfDelimitedByAny <= 0) {
            return this;
        }
        if (z) {
            iStartOfDelimitedByAny -= eolEndLength(iStartOfDelimitedByAny - 1);
        }
        return (T) subSequence(iStartOfDelimitedByAny);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, int i, int i2) {
        sb.append((CharSequence) (charMapper == null ? this : toMapped(charMapper)), i, i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int indexOf(char c, int i, int i2) {
        return SequenceUtils.indexOf(this, c, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    public final int lastIndexOf(char c, int i, int i2) {
        return SequenceUtils.lastIndexOf(this, c, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public final T replace(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        int[] iArrIndexOfAll = indexOfAll(charSequence);
        if (iArrIndexOfAll.length == 0) {
            return this;
        }
        ISequenceBuilder builder = getBuilder();
        int length = iArrIndexOfAll.length;
        int length2 = length();
        int i = 0;
        int length3 = 0;
        while (i < length) {
            int i2 = i + 1;
            int i4 = iArrIndexOfAll[i];
            if (length3 < i4) {
                builder.add(subSequence(length3, i4));
            }
            length3 = charSequence.length() + i4;
            builder.add(charSequence2);
            i = i2;
        }
        if (length3 < length2) {
            builder.add(subSequence(length3, length2));
        }
        return (T) builder.toSequence();
    }
}
