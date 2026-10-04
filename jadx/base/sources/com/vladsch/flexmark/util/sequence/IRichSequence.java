package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.IRichSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IRichSequence<T extends IRichSequence<T>> extends CharSequence, Comparable<CharSequence>, SequenceUtils {
    @NotNull
    T append(Iterable<? extends CharSequence> iterable);

    @NotNull
    T append(CharSequence... charSequenceArr);

    @NotNull
    T appendEOL();

    @NotNull
    T appendRangesTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, Iterable<? extends Range> iterable);

    @NotNull
    T appendRangesTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, Range... rangeArr);

    @NotNull
    T appendRangesTo(@NotNull StringBuilder sb, Iterable<? extends Range> iterable);

    @NotNull
    T appendRangesTo(@NotNull StringBuilder sb, Range... rangeArr);

    @NotNull
    T appendSpace();

    @NotNull
    T appendSpaces(int i);

    @NotNull
    T appendTo(@NotNull StringBuilder sb);

    @NotNull
    T appendTo(@NotNull StringBuilder sb, int i);

    @NotNull
    T appendTo(@NotNull StringBuilder sb, int i, int i2);

    @NotNull
    T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper);

    @NotNull
    T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, int i);

    @NotNull
    T appendTo(@NotNull StringBuilder sb, @Nullable CharMapper charMapper, int i, int i2);

    @NotNull
    List<Range> blankLinesRemovedRanges();

    @NotNull
    List<Range> blankLinesRemovedRanges(int i);

    @NotNull
    List<Range> blankLinesRemovedRanges(int i, int i2);

    @NotNull
    List<Range> blankLinesRemovedRanges(@NotNull CharPredicate charPredicate, int i, int i2);

    int columnAtIndex(int i);

    @Deprecated
    default int countLeading(char c) {
        return countLeading(CharPredicate.anyOf(c));
    }

    int countLeading(@NotNull CharPredicate charPredicate);

    int countLeading(@NotNull CharPredicate charPredicate, int i);

    int countLeading(@NotNull CharPredicate charPredicate, int i, int i2);

    int countLeadingColumns(int i, @NotNull CharPredicate charPredicate);

    int countLeadingNot(@NotNull CharPredicate charPredicate);

    int countLeadingNot(@NotNull CharPredicate charPredicate, int i);

    int countLeadingNot(@NotNull CharPredicate charPredicate, int i, int i2);

    int countLeadingNotSpace();

    int countLeadingNotSpace(int i);

    int countLeadingNotSpace(int i, int i2);

    int countLeadingNotSpaceTab();

    int countLeadingNotSpaceTab(int i);

    int countLeadingNotSpaceTab(int i, int i2);

    int countLeadingNotWhitespace();

    int countLeadingNotWhitespace(int i);

    int countLeadingNotWhitespace(int i, int i2);

    int countLeadingSpace();

    int countLeadingSpace(int i);

    int countLeadingSpace(int i, int i2);

    int countLeadingSpaceTab();

    int countLeadingSpaceTab(int i);

    int countLeadingSpaceTab(int i, int i2);

    int countLeadingWhitespace();

    int countLeadingWhitespace(int i);

    int countLeadingWhitespace(int i, int i2);

    @Deprecated
    default int countOf(char c) {
        return countOfAny(CharPredicate.anyOf(c));
    }

    int countOfAny(@NotNull CharPredicate charPredicate);

    int countOfAny(@NotNull CharPredicate charPredicate, int i);

    int countOfAny(@NotNull CharPredicate charPredicate, int i, int i2);

    int countOfAnyNot(@NotNull CharPredicate charPredicate);

    int countOfAnyNot(@NotNull CharPredicate charPredicate, int i);

    int countOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2);

    int countOfNotSpaceTab();

    int countOfNotWhitespace();

    int countOfSpaceTab();

    int countOfWhitespace();

    @Deprecated
    default int countTrailing() {
        return countLeadingSpaceTab();
    }

    int countTrailing(@NotNull CharPredicate charPredicate);

    int countTrailing(@NotNull CharPredicate charPredicate, int i);

    int countTrailing(@NotNull CharPredicate charPredicate, int i, int i2);

    int countTrailingNot(@NotNull CharPredicate charPredicate);

    int countTrailingNot(@NotNull CharPredicate charPredicate, int i);

    int countTrailingNot(@NotNull CharPredicate charPredicate, int i, int i2);

    int countTrailingNotSpace();

    int countTrailingNotSpace(int i);

    int countTrailingNotSpace(int i, int i2);

    int countTrailingNotSpaceTab();

    int countTrailingNotSpaceTab(int i);

    int countTrailingNotSpaceTab(int i, int i2);

    int countTrailingNotWhitespace();

    int countTrailingNotWhitespace(int i);

    int countTrailingNotWhitespace(int i, int i2);

    int countTrailingSpace();

    int countTrailingSpace(int i);

    int countTrailingSpace(int i, int i2);

    int countTrailingSpaceTab();

    int countTrailingSpaceTab(int i);

    int countTrailingSpaceTab(int i, int i2);

    int countTrailingWhitespace();

    int countTrailingWhitespace(int i);

    int countTrailingWhitespace(int i, int i2);

    @NotNull
    T delete(int i, int i2);

    @NotNull
    T[] emptyArray();

    char endCharAt(int i);

    int endOfDelimitedBy(@NotNull CharSequence charSequence, int i);

    int endOfDelimitedByAny(@NotNull CharPredicate charPredicate, int i);

    int endOfDelimitedByAnyNot(@NotNull CharPredicate charPredicate, int i);

    int endOfLine(int i);

    int endOfLineAnyEOL(int i);

    @NotNull
    T endSequence(int i);

    @NotNull
    T endSequence(int i, int i2);

    boolean endsWith(@NotNull CharPredicate charPredicate);

    boolean endsWith(@NotNull CharSequence charSequence);

    /* JADX INFO: renamed from: endsWith */
    boolean lambda$nullIfNotEndsWith$5(@NotNull CharSequence charSequence, boolean z);

    boolean endsWithAnyEOL();

    boolean endsWithEOL();

    boolean endsWithIgnoreCase(@NotNull CharSequence charSequence);

    boolean endsWithSpace();

    boolean endsWithSpaceTab();

    boolean endsWithWhitespace();

    int eolEndLength();

    int eolEndLength(int i);

    @NotNull
    Range eolEndRange(int i);

    @Deprecated
    default int eolLength(int i) {
        return eolStartLength(i);
    }

    @Deprecated
    default int eolStartLength() {
        return eolEndLength();
    }

    int eolStartLength(int i);

    @NotNull
    Range eolStartRange(int i);

    boolean equals(@Nullable Object obj);

    boolean equals(@Nullable Object obj, boolean z);

    boolean equalsIgnoreCase(@Nullable Object obj);

    @NotNull
    T extractRanges(Iterable<Range> iterable);

    @NotNull
    T extractRanges(Range... rangeArr);

    char firstChar();

    @NotNull
    <B extends ISequenceBuilder<B, T>> B getBuilder();

    @Deprecated
    default int getColumnAtIndex(int i) {
        return columnAtIndex(i);
    }

    @Deprecated
    @NotNull
    default Pair<Integer, Integer> getLineColumnAtIndex(int i) {
        return lineColumnAtIndex(i);
    }

    int hashCode();

    @NotNull
    T ifNull(@NotNull T t);

    @NotNull
    T ifNullEmptyAfter(@NotNull T t);

    @NotNull
    T ifNullEmptyBefore(@NotNull T t);

    int indexOf(char c);

    int indexOf(char c, int i);

    int indexOf(char c, int i, int i2);

    int indexOf(@NotNull CharSequence charSequence);

    int indexOf(@NotNull CharSequence charSequence, int i);

    int indexOf(@NotNull CharSequence charSequence, int i, int i2);

    @NotNull
    int[] indexOfAll(@NotNull CharSequence charSequence);

    int indexOfAny(@NotNull CharPredicate charPredicate);

    int indexOfAny(@NotNull CharPredicate charPredicate, int i);

    int indexOfAny(@NotNull CharPredicate charPredicate, int i, int i2);

    int indexOfAnyNot(@NotNull CharPredicate charPredicate);

    int indexOfAnyNot(@NotNull CharPredicate charPredicate, int i);

    int indexOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2);

    int indexOfNot(char c);

    int indexOfNot(char c, int i);

    int indexOfNot(char c, int i, int i2);

    @NotNull
    T insert(int i, @NotNull CharSequence charSequence);

    @Deprecated
    @NotNull
    default T insert(@NotNull CharSequence charSequence, int i) {
        return (T) insert(i, charSequence);
    }

    boolean isBlank();

    boolean isCharAt(int i, @NotNull CharPredicate charPredicate);

    boolean isEmpty();

    boolean isIn(@NotNull Collection<? extends CharSequence> collection);

    boolean isIn(@NotNull String[] strArr);

    boolean isNotBlank();

    boolean isNotEmpty();

    boolean isNotNull();

    boolean isNull();

    char lastChar();

    int lastIndexOf(char c);

    int lastIndexOf(char c, int i);

    int lastIndexOf(char c, int i, int i2);

    int lastIndexOf(@NotNull CharSequence charSequence);

    int lastIndexOf(@NotNull CharSequence charSequence, int i);

    int lastIndexOf(@NotNull CharSequence charSequence, int i, int i2);

    int lastIndexOfAny(@NotNull CharPredicate charPredicate);

    int lastIndexOfAny(@NotNull CharPredicate charPredicate, int i);

    int lastIndexOfAny(@NotNull CharPredicate charPredicate, int i, int i2);

    int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate);

    int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate, int i);

    int lastIndexOfAnyNot(@NotNull CharPredicate charPredicate, int i, int i2);

    int lastIndexOfNot(char c);

    int lastIndexOfNot(char c, int i);

    int lastIndexOfNot(char c, int i, int i2);

    @NotNull
    Range leadingBlankLinesRange();

    @NotNull
    Range leadingBlankLinesRange(int i);

    @NotNull
    Range leadingBlankLinesRange(int i, int i2);

    @NotNull
    Range leadingBlankLinesRange(@NotNull CharPredicate charPredicate, int i, int i2);

    @NotNull
    T lineAt(int i);

    @NotNull
    T lineAtAnyEOL(int i);

    @NotNull
    Pair<Integer, Integer> lineColumnAtIndex(int i);

    @NotNull
    Range lineRangeAt(int i);

    @NotNull
    Range lineRangeAtAnyEOL(int i);

    boolean matchChars(@NotNull CharSequence charSequence);

    boolean matchChars(@NotNull CharSequence charSequence, int i);

    boolean matchChars(@NotNull CharSequence charSequence, int i, boolean z);

    boolean matchChars(@NotNull CharSequence charSequence, boolean z);

    boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence);

    boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence, int i);

    boolean matchCharsReversed(@NotNull CharSequence charSequence, int i);

    boolean matchCharsReversed(@NotNull CharSequence charSequence, int i, boolean z);

    boolean matchCharsReversedIgnoreCase(@NotNull CharSequence charSequence, int i);

    int matchedCharCount(@NotNull CharSequence charSequence, int i);

    int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2);

    int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2, boolean z);

    int matchedCharCount(@NotNull CharSequence charSequence, int i, int i2, boolean z, boolean z2);

    int matchedCharCount(@NotNull CharSequence charSequence, int i, boolean z);

    int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, int i);

    int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, int i, int i2);

    int matchedCharCountReversed(@NotNull CharSequence charSequence, int i);

    int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, int i2);

    int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, int i2, boolean z);

    int matchedCharCountReversed(@NotNull CharSequence charSequence, int i, boolean z);

    int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, int i);

    int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, int i, int i2);

    boolean matches(@NotNull CharSequence charSequence);

    boolean matches(@NotNull CharSequence charSequence, boolean z);

    boolean matchesIgnoreCase(@NotNull CharSequence charSequence);

    char midCharAt(int i);

    @NotNull
    T midSequence(int i);

    @NotNull
    T midSequence(int i, int i2);

    @NotNull
    String normalizeEOL();

    @NotNull
    String normalizeEndWithEOL();

    @NotNull
    T nullIf(@NotNull BiPredicate<? super T, ? super CharSequence> biPredicate, CharSequence... charSequenceArr);

    @NotNull
    T nullIf(@NotNull Predicate<? super CharSequence> predicate, CharSequence... charSequenceArr);

    @NotNull
    T nullIf(boolean z);

    @NotNull
    T nullIf(CharSequence... charSequenceArr);

    @NotNull
    T nullIfBlank();

    @NotNull
    T nullIfEmpty();

    @NotNull
    T nullIfEndsWith(boolean z, CharSequence... charSequenceArr);

    @NotNull
    T nullIfEndsWith(CharSequence... charSequenceArr);

    @NotNull
    T nullIfEndsWithIgnoreCase(CharSequence... charSequenceArr);

    @Deprecated
    @NotNull
    default T nullIfEndsWithNot(CharSequence... charSequenceArr) {
        return (T) nullIfNotEndsWith(charSequenceArr);
    }

    @NotNull
    T nullIfNot(@NotNull BiPredicate<? super T, ? super CharSequence> biPredicate, CharSequence... charSequenceArr);

    @NotNull
    T nullIfNot(@NotNull Predicate<? super CharSequence> predicate, CharSequence... charSequenceArr);

    @NotNull
    T nullIfNot(CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotEndsWith(boolean z, CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotEndsWith(CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotEndsWithIgnoreCase(CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotStartsWith(boolean z, CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotStartsWith(CharSequence... charSequenceArr);

    @NotNull
    T nullIfNotStartsWithIgnoreCase(CharSequence... charSequenceArr);

    @NotNull
    T nullIfStartsWith(boolean z, CharSequence... charSequenceArr);

    @NotNull
    T nullIfStartsWith(CharSequence... charSequenceArr);

    @NotNull
    T nullIfStartsWithIgnoreCase(CharSequence... charSequenceArr);

    @Deprecated
    @NotNull
    default T nullIfStartsWithNot(CharSequence... charSequenceArr) {
        return (T) nullIfNotStartsWith(charSequenceArr);
    }

    @NotNull
    T nullSequence();

    @NotNull
    T padEnd(int i);

    @NotNull
    T padEnd(int i, char c);

    @NotNull
    T padStart(int i);

    @NotNull
    T padStart(int i, char c);

    @NotNull
    T padding(int i);

    @NotNull
    T padding(int i, char c);

    @NotNull
    T prefixOnceWith(@Nullable CharSequence charSequence);

    @NotNull
    T prefixOnceWithEOL();

    @NotNull
    T prefixOnceWithSpace();

    @NotNull
    T prefixWith(@Nullable CharSequence charSequence);

    @NotNull
    T prefixWithEOL();

    @NotNull
    T prefixWithSpace();

    @NotNull
    T prefixWithSpaces(int i);

    @NotNull
    T removePrefix(@NotNull CharSequence charSequence);

    @NotNull
    T removePrefix(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    T removePrefixIgnoreCase(@NotNull CharSequence charSequence);

    @NotNull
    T removeProperPrefix(@NotNull CharSequence charSequence);

    @NotNull
    T removeProperPrefix(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    T removeProperPrefixIgnoreCase(@NotNull CharSequence charSequence);

    @NotNull
    T removeProperSuffix(@NotNull CharSequence charSequence);

    @NotNull
    T removeProperSuffix(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    T removeProperSuffixIgnoreCase(@NotNull CharSequence charSequence);

    @NotNull
    T removeSuffix(@NotNull CharSequence charSequence);

    @NotNull
    T removeSuffix(@NotNull CharSequence charSequence, boolean z);

    @NotNull
    T removeSuffixIgnoreCase(@NotNull CharSequence charSequence);

    @NotNull
    T replace(int i, int i2, @NotNull CharSequence charSequence);

    @NotNull
    T replace(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2);

    char safeCharAt(int i);

    @NotNull
    T safeSubSequence(int i);

    @NotNull
    T safeSubSequence(int i, int i2);

    @NotNull
    T sequenceOf(@Nullable CharSequence charSequence);

    @NotNull
    T sequenceOf(@Nullable CharSequence charSequence, int i);

    @NotNull
    T sequenceOf(@Nullable CharSequence charSequence, int i, int i2);

    @Deprecated
    @NotNull
    default T[] split(char c, int i, int i2) {
        return (T[]) split(Character.toString(c), i, i2, (CharPredicate) null);
    }

    @NotNull
    T[] split(@NotNull CharSequence charSequence);

    @NotNull
    T[] split(@NotNull CharSequence charSequence, int i, int i2);

    @NotNull
    T[] split(@NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate);

    @NotNull
    T[] split(@NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate);

    @NotNull
    T[] split(@NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate);

    @NotNull
    T[] splitEOL();

    @NotNull
    T[] splitEOL(boolean z);

    @NotNull
    List<T> splitList(@NotNull CharSequence charSequence);

    @NotNull
    List<T> splitList(@NotNull CharSequence charSequence, int i, int i2);

    @NotNull
    List<T> splitList(@NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate);

    @NotNull
    List<T> splitList(@NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate);

    @NotNull
    List<T> splitList(@NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate);

    @NotNull
    List<T> splitListEOL();

    @NotNull
    List<T> splitListEOL(boolean z);

    @NotNull
    List<T> splitListEOL(boolean z, @Nullable CharPredicate charPredicate);

    int startOfDelimitedBy(@NotNull CharSequence charSequence, int i);

    int startOfDelimitedByAny(@NotNull CharPredicate charPredicate, int i);

    int startOfDelimitedByAnyNot(@NotNull CharPredicate charPredicate, int i);

    int startOfLine(int i);

    int startOfLineAnyEOL(int i);

    boolean startsWith(@NotNull CharPredicate charPredicate);

    boolean startsWith(@NotNull CharSequence charSequence);

    /* JADX INFO: renamed from: startsWith */
    boolean lambda$nullIfStartsWith$2(@NotNull CharSequence charSequence, boolean z);

    boolean startsWithAnyEOL();

    boolean startsWithEOL();

    boolean startsWithIgnoreCase(@NotNull CharSequence charSequence);

    boolean startsWithSpace();

    boolean startsWithSpaceTab();

    boolean startsWithWhitespace();

    @NotNull
    T subSequence(int i);

    @Override // java.lang.CharSequence
    @NotNull
    T subSequence(int i, int i2);

    @NotNull
    T subSequence(@NotNull Range range);

    @NotNull
    T subSequenceAfter(@NotNull Range range);

    @NotNull
    T subSequenceBefore(@NotNull Range range);

    @NotNull
    T suffixOnceWith(@Nullable CharSequence charSequence);

    @NotNull
    T suffixOnceWithEOL();

    @NotNull
    T suffixOnceWithSpace();

    @NotNull
    T suffixWith(@Nullable CharSequence charSequence);

    @NotNull
    T suffixWithEOL();

    @NotNull
    T suffixWithSpace();

    @NotNull
    T suffixWithSpaces(int i);

    @NotNull
    T toLowerCase();

    @NotNull
    T toMapped(CharMapper charMapper);

    @NotNull
    T toNbSp();

    @NotNull
    T toSpc();

    @Nullable
    String toStringOrNull();

    @NotNull
    T toUpperCase();

    @NotNull
    String toVisibleWhitespaceString();

    @NotNull
    Range trailingBlankLinesRange();

    @NotNull
    Range trailingBlankLinesRange(int i);

    @NotNull
    Range trailingBlankLinesRange(int i, int i2);

    @NotNull
    Range trailingBlankLinesRange(CharPredicate charPredicate, int i, int i2);

    @NotNull
    T trim();

    @NotNull
    T trim(int i);

    @NotNull
    T trim(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    T trim(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimEOL();

    @NotNull
    T trimEnd();

    @NotNull
    T trimEnd(int i);

    @NotNull
    T trimEnd(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    T trimEnd(@NotNull CharPredicate charPredicate);

    @NotNull
    Range trimEndRange();

    @NotNull
    Range trimEndRange(int i);

    @NotNull
    Range trimEndRange(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    Range trimEndRange(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimLeadBlankLines();

    @NotNull
    Range trimRange();

    @NotNull
    Range trimRange(int i);

    @NotNull
    Range trimRange(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    Range trimRange(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimStart();

    @NotNull
    T trimStart(int i);

    @NotNull
    T trimStart(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    T trimStart(@NotNull CharPredicate charPredicate);

    @NotNull
    Range trimStartRange();

    @NotNull
    Range trimStartRange(int i);

    @NotNull
    Range trimStartRange(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    Range trimStartRange(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimTailBlankLines();

    @NotNull
    T trimToEndOfLine();

    @NotNull
    T trimToEndOfLine(int i);

    @NotNull
    T trimToEndOfLine(@NotNull CharPredicate charPredicate, boolean z, int i);

    @NotNull
    T trimToEndOfLine(boolean z);

    @NotNull
    T trimToEndOfLine(boolean z, int i);

    @NotNull
    T trimToStartOfLine();

    @NotNull
    T trimToStartOfLine(int i);

    @NotNull
    T trimToStartOfLine(@NotNull CharPredicate charPredicate, boolean z, int i);

    @NotNull
    T trimToStartOfLine(boolean z);

    @NotNull
    T trimToStartOfLine(boolean z, int i);

    @NotNull
    Pair<T, T> trimmed();

    @NotNull
    Pair<T, T> trimmed(int i);

    @NotNull
    Pair<T, T> trimmed(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    Pair<T, T> trimmed(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimmedEOL();

    @NotNull
    T trimmedEnd();

    @NotNull
    T trimmedEnd(int i);

    @NotNull
    T trimmedEnd(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    T trimmedEnd(@NotNull CharPredicate charPredicate);

    @NotNull
    T trimmedStart();

    @NotNull
    T trimmedStart(int i);

    @NotNull
    T trimmedStart(int i, @NotNull CharPredicate charPredicate);

    @NotNull
    T trimmedStart(@NotNull CharPredicate charPredicate);

    @Deprecated
    default int countLeading() {
        return countLeadingSpaceTab();
    }

    @Deprecated
    @NotNull
    default T[] split(char c, int i) {
        return (T[]) split(Character.toString(c), i, 0, (CharPredicate) null);
    }

    @Deprecated
    @NotNull
    default T[] split(char c) {
        return (T[]) split(Character.toString(c), 0, 0, (CharPredicate) null);
    }
}
