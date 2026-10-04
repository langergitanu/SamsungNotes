package com.vladsch.flexmark.util.sequence;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SequenceUtils {
    public static final String ANY_EOL = "\r\n";

    @Deprecated
    public static final CharPredicate ANY_EOL_SET;

    @Deprecated
    public static final CharPredicate BACKSLASH_SET;

    @Deprecated
    public static final CharPredicate DECIMAL_DIGITS;
    public static final int[] EMPTY_INDICES;
    public static final char ENC_NUL = 65533;
    public static final String EOL = "\n";

    @Deprecated
    public static final String EOL_CHARS = "\r\n";

    @Deprecated
    public static final CharPredicate HASH_SET;

    @Deprecated
    public static final CharPredicate HEXADECIMAL_DIGITS;

    /* JADX INFO: renamed from: LS */
    public static final char f8408LS = 8232;

    @Deprecated
    public static final char LSEP = 8232;
    public static final char NBSP = 160;
    public static final char NUL = 0;

    @Deprecated
    public static final CharPredicate OCTAL_DIGITS;
    public static final String SPACE = " ";
    public static final String SPACE_EOL = " \n";

    @Deprecated
    public static final CharPredicate SPACE_EOL_SET;
    public static final String SPACE_TAB = " \t";
    public static final char SPC = ' ';
    public static final int SPLIT_INCLUDE_DELIMS = 1;
    public static final int SPLIT_INCLUDE_DELIM_PARTS = 8;
    public static final int SPLIT_SKIP_EMPTY = 4;
    public static final int SPLIT_TRIM_PARTS = 2;
    public static final int SPLIT_TRIM_SKIP_EMPTY = 6;

    /* JADX INFO: renamed from: US */
    public static final char f8409US = 31;

    @Deprecated
    public static final CharPredicate US_SET;
    public static final String WHITESPACE = " \t\r\n";

    @Deprecated
    public static final String WHITESPACE_CHARS = " \t\r\n";
    public static final String WHITESPACE_NBSP = " \t\r\n ";

    @Deprecated
    public static final String WHITESPACE_NBSP_CHARS = " \t\r\n ";

    @Deprecated
    public static final CharPredicate WHITESPACE_NBSP_SET;

    @Deprecated
    public static final String WHITESPACE_NO_EOL_CHARS = " \t";

    @Deprecated
    public static final CharPredicate WHITESPACE_SET;
    public static final Map<Character, String> visibleSpacesMap;
    public static final char EOL_CHAR = "\r\n".charAt(1);
    public static final char EOL_CHAR1 = "\r\n".charAt(0);
    public static final char EOL_CHAR2 = "\r\n".charAt(1);
    public static final String LINE_SEP = Character.toString(8232);
    public static final String US_CHARS = Character.toString(31);
    public static final String NBSP_CHARS = Character.toString(160);

    @Deprecated
    public static final CharPredicate SPACE_SET = CharPredicate.SPACE;

    @Deprecated
    public static final CharPredicate TAB_SET = CharPredicate.TAB;

    @Deprecated
    public static final CharPredicate EOL_SET = CharPredicate.EOL;

    @Deprecated
    public static final CharPredicate SPACE_TAB_SET = CharPredicate.SPACE_TAB;

    @Deprecated
    public static final CharPredicate SPACE_TAB_NBSP_SET = CharPredicate.SPACE_TAB_NBSP;

    @Deprecated
    public static final CharPredicate SPACE_TAB_EOL_SET = CharPredicate.SPACE_TAB_EOL;

    static {
        CharPredicate charPredicate = CharPredicate.WHITESPACE;
        SPACE_EOL_SET = charPredicate;
        ANY_EOL_SET = CharPredicate.ANY_EOL;
        WHITESPACE_SET = charPredicate;
        WHITESPACE_NBSP_SET = CharPredicate.WHITESPACE_NBSP;
        BACKSLASH_SET = CharPredicate.BACKSLASH;
        US_SET = new C11885d(0);
        CharPredicate charPredicate2 = CharPredicate.HASH;
        HASH_SET = charPredicate2;
        DECIMAL_DIGITS = charPredicate2;
        HEXADECIMAL_DIGITS = charPredicate2;
        OCTAL_DIGITS = charPredicate2;
        visibleSpacesMap = getVisibleSpacesMap();
        EMPTY_INDICES = new int[0];
    }

    @NotNull
    static List<Range> blankLinesRemovedRanges(@NotNull CharSequence charSequence) {
        return blankLinesRemovedRanges(charSequence, CharPredicate.EOL, 0, Integer.MAX_VALUE);
    }

    static int columnAtIndex(@NotNull CharSequence charSequence, int i) {
        int iLastIndexOfAny = lastIndexOfAny(charSequence, CharPredicate.ANY_EOL, i);
        return i - (iLastIndexOfAny == -1 ? 0 : eolStartLength(charSequence, iLastIndexOfAny) + iLastIndexOfAny);
    }

    static int columnsToNextTabStop(int i) {
        return 4 - (i % 4);
    }

    static int compare(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return compare(charSequence, charSequence2, false);
    }

    static int compareReversed(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return compare(charSequence2, charSequence);
    }

    static <T extends CharSequence> boolean containedBy(@NotNull T[] tArr, @NotNull CharSequence charSequence) {
        for (T t : tArr) {
            if (equals(charSequence, t)) {
                return true;
            }
        }
        return false;
    }

    static boolean containsAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return indexOfAny(charSequence, charPredicate, 0, Integer.MAX_VALUE) != -1;
    }

    static boolean containsAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return indexOfAny(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE) != -1;
    }

    static int countLeading(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countLeading(charSequence, charPredicate, 0, Integer.MAX_VALUE);
    }

    static int countLeadingColumns(@NotNull CharSequence charSequence, int i, @NotNull CharPredicate charPredicate) {
        int length = charSequence.length();
        int iIndexOfAnyNot = indexOfAnyNot(charSequence, charPredicate, 0, length);
        int i2 = iIndexOfAnyNot == -1 ? length : iIndexOfAnyNot;
        if (iIndexOfAnyNot == -1) {
            iIndexOfAnyNot = length;
        }
        int iIndexOf = indexOf(charSequence, '\t', 0, i2);
        if (iIndexOf == -1) {
            return iIndexOfAnyNot;
        }
        do {
            i += columnsToNextTabStop(iIndexOf + i) + iIndexOf;
            iIndexOf = indexOf(charSequence, '\t', iIndexOf + 1);
            if (iIndexOf < 0) {
                break;
            }
        } while (iIndexOf < length);
        return iIndexOfAnyNot + i;
    }

    static int countLeadingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countLeading(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE);
    }

    static int countLeadingNotSpace(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.SPACE.negate(), 0, Integer.MAX_VALUE);
    }

    static int countLeadingNotSpaceTab(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB.negate(), 0, Integer.MAX_VALUE);
    }

    static int countLeadingNotWhitespace(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.WHITESPACE.negate(), 0, Integer.MAX_VALUE);
    }

    static int countLeadingSpace(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.SPACE, 0, Integer.MAX_VALUE);
    }

    static int countLeadingSpaceTab(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB, 0, Integer.MAX_VALUE);
    }

    static int countLeadingWhitespace(@NotNull CharSequence charSequence) {
        return countLeading(charSequence, CharPredicate.WHITESPACE, 0, Integer.MAX_VALUE);
    }

    static int countOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countOfAny(charSequence, charPredicate, i, Integer.MAX_VALUE);
    }

    static int countOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return countOfAny(charSequence, charPredicate.negate(), i, i2);
    }

    static int countOfNotSpaceTab(@NotNull CharSequence charSequence) {
        return countOfAny(charSequence, CharPredicate.SPACE_TAB.negate(), 0, Integer.MAX_VALUE);
    }

    static int countOfNotWhitespace(@NotNull CharSequence charSequence) {
        return countOfAny(charSequence, CharPredicate.WHITESPACE.negate(), 0, Integer.MAX_VALUE);
    }

    static int countOfSpaceTab(@NotNull CharSequence charSequence) {
        return countOfAny(charSequence, CharPredicate.SPACE_TAB, 0, Integer.MAX_VALUE);
    }

    static int countOfWhitespace(@NotNull CharSequence charSequence) {
        return countOfAny(charSequence, CharPredicate.WHITESPACE, Integer.MAX_VALUE);
    }

    static int countTrailing(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countTrailing(charSequence, charPredicate, 0, Integer.MAX_VALUE);
    }

    static int countTrailingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countTrailing(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE);
    }

    static int countTrailingNotSpace(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.SPACE.negate(), 0, Integer.MAX_VALUE);
    }

    static int countTrailingNotSpaceTab(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB.negate(), 0, Integer.MAX_VALUE);
    }

    static int countTrailingNotWhitespace(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE.negate(), 0, Integer.MAX_VALUE);
    }

    static int countTrailingSpace(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.SPACE, 0, Integer.MAX_VALUE);
    }

    static int countTrailingSpaceTab(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB, 0, Integer.MAX_VALUE);
    }

    static int countTrailingWhitespace(@NotNull CharSequence charSequence) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE, 0, Integer.MAX_VALUE);
    }

    static int endOfDelimitedBy(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        int length = charSequence.length();
        int iIndexOf = indexOf(charSequence, charSequence2, Utils.rangeLimit(i, 0, length));
        return iIndexOf == -1 ? length : iIndexOf;
    }

    static int endOfDelimitedByAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        int length = charSequence.length();
        int iIndexOfAny = indexOfAny(charSequence, charPredicate, Utils.rangeLimit(i, 0, length));
        return iIndexOfAny == -1 ? length : iIndexOfAny;
    }

    static int endOfDelimitedByAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return endOfDelimitedByAny(charSequence, charPredicate.negate(), i);
    }

    static int endOfLine(@NotNull CharSequence charSequence, int i) {
        return endOfDelimitedBy(charSequence, "\n", i);
    }

    static int endOfLineAnyEOL(@NotNull CharSequence charSequence, int i) {
        return endOfDelimitedByAny(charSequence, CharPredicate.ANY_EOL, i);
    }

    static boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return charSequence.length() > 0 && matchCharsReversed(charSequence, charSequence2, charSequence.length() - 1, false);
    }

    static boolean endsWithAnyEOL(@NotNull CharSequence charSequence) {
        return endsWith(charSequence, CharPredicate.ANY_EOL);
    }

    static boolean endsWithEOL(@NotNull CharSequence charSequence) {
        return endsWith(charSequence, CharPredicate.EOL);
    }

    static boolean endsWithSpace(@NotNull CharSequence charSequence) {
        return endsWith(charSequence, CharPredicate.SPACE);
    }

    static boolean endsWithSpaceTab(@NotNull CharSequence charSequence) {
        return endsWith(charSequence, CharPredicate.SPACE_TAB);
    }

    static boolean endsWithWhitespace(@NotNull CharSequence charSequence) {
        return endsWith(charSequence, CharPredicate.WHITESPACE);
    }

    static int eolEndLength(@NotNull CharSequence charSequence) {
        return eolEndLength(charSequence, charSequence.length());
    }

    @NotNull
    static Range eolEndRange(@NotNull CharSequence charSequence, int i) {
        int iEolEndLength = eolEndLength(charSequence, i);
        return iEolEndLength == 0 ? Range.NULL : Range.m13451of(i - iEolEndLength, i);
    }

    static int eolStartLength(@NotNull CharSequence charSequence, int i) {
        int length = charSequence.length();
        int iMin = Math.min(i, length);
        if (iMin < 0 || iMin >= length) {
            return 0;
        }
        char cCharAt = charSequence.charAt(iMin);
        return cCharAt == '\r' ? safeCharAt(charSequence, iMin + 1) == '\n' ? 2 : 1 : (cCharAt != '\n' || safeCharAt(charSequence, iMin - 1) == '\r') ? 0 : 1;
    }

    @NotNull
    static Range eolStartRange(@NotNull CharSequence charSequence, int i) {
        int iEolStartLength = eolStartLength(charSequence, i);
        return iEolStartLength == 0 ? Range.NULL : Range.m13451of(i, iEolStartLength + i);
    }

    @Contract(pure = true, value = "_, null -> false")
    static boolean equals(@NotNull CharSequence charSequence, Object obj) {
        if (obj == charSequence) {
            return true;
        }
        if (!(obj instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence2 = (CharSequence) obj;
        if (charSequence2.length() != charSequence.length()) {
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).hashCode() != charSequence.hashCode()) {
                return false;
            }
        } else if ((obj instanceof IRichSequence) && ((IRichSequence) obj).hashCode() != charSequence.hashCode()) {
            return false;
        }
        return matchChars(charSequence, charSequence2, 0, false);
    }

    @NotNull
    static int[] expandTo(@NotNull int[] iArr, int i, int i2) {
        if ((i & i2) == 0) {
            i2 = 0;
        }
        int i4 = i + i2;
        if (iArr.length >= i4) {
            return iArr;
        }
        int[] iArr2 = new int[i4];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    static char firstChar(@NotNull CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return (char) 0;
        }
        return charSequence.charAt(0);
    }

    static Map<Character, String> getVisibleSpacesMap() {
        HashMap map = new HashMap();
        map.put('\n', "\\n");
        map.put('\r', "\\r");
        map.put('\f', "\\f");
        map.put('\t', "\\u2192");
        map.put((char) 8232, "➥");
        return map;
    }

    @Contract(pure = true)
    static int hashCode(@NotNull CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 0) {
            return 0;
        }
        int iCharAt = 0;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt * 31) + charSequence.charAt(i);
        }
        return iCharAt;
    }

    static int indexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return indexOf(charSequence, charSequence2, 0, Integer.MAX_VALUE);
    }

    @NotNull
    static int[] indexOfAll(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return EMPTY_INDICES;
        }
        int iIndexOf = indexOf(charSequence, charSequence2);
        if (iIndexOf == -1) {
            return EMPTY_INDICES;
        }
        int[] iArrExpandTo = new int[32];
        iArrExpandTo[0] = iIndexOf;
        int i = 1;
        while (true) {
            iIndexOf = indexOf(charSequence, charSequence2, iIndexOf + length);
            if (iIndexOf == -1) {
                return truncateTo(iArrExpandTo, i);
            }
            if (iArrExpandTo.length <= i) {
                iArrExpandTo = expandTo(iArrExpandTo, i + 1, 32);
            }
            iArrExpandTo[i] = iIndexOf;
            i++;
        }
    }

    static int indexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return indexOfAny(charSequence, charPredicate, 0, Integer.MAX_VALUE);
    }

    static int indexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return indexOfAny(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE);
    }

    static int indexOfNot(@NotNull CharSequence charSequence, char c) {
        return indexOfNot(charSequence, c, 0, Integer.MAX_VALUE);
    }

    static boolean isBlank(@NotNull CharSequence charSequence) {
        return isEmpty(charSequence) || countLeading(charSequence, CharPredicate.WHITESPACE, 0, Integer.MAX_VALUE) == charSequence.length();
    }

    static boolean isEmpty(@NotNull CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    static boolean isNotBlank(@NotNull CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    static boolean isNotEmpty(@NotNull CharSequence charSequence) {
        return charSequence.length() != 0;
    }

    static boolean isVisibleWhitespace(char c) {
        return visibleSpacesMap.containsKey(Character.valueOf(c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(int i) {
        return i == 31;
    }

    static char lastChar(@NotNull CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return (char) 0;
        }
        return charSequence.charAt(charSequence.length() - 1);
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return lastIndexOf(charSequence, charSequence2, 0, Integer.MAX_VALUE);
    }

    static int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return lastIndexOfAny(charSequence, charPredicate, 0, Integer.MAX_VALUE);
    }

    static int lastIndexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return lastIndexOfAny(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE);
    }

    static int lastIndexOfNot(@NotNull CharSequence charSequence, char c) {
        return lastIndexOfNot(charSequence, c, 0, Integer.MAX_VALUE);
    }

    @NotNull
    static Range leadingBlankLinesRange(@NotNull CharSequence charSequence) {
        return leadingBlankLinesRange(charSequence, CharPredicate.EOL, 0, Integer.MAX_VALUE);
    }

    @NotNull
    static Pair<Integer, Integer> lineColumnAtIndex(@NotNull CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i, length, "Index: ", " out of range [0, ", "]"));
        }
        int i2 = 0;
        int i4 = 0;
        boolean z = false;
        for (int i5 = 0; i5 < i; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt == '\r') {
                i2++;
                z = true;
                i4 = 0;
            } else if (cCharAt == '\n') {
                if (!z) {
                    i2++;
                }
                i4 = 0;
                z = false;
            } else {
                i4++;
            }
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i4));
    }

    @NotNull
    static Range lineRangeAt(@NotNull CharSequence charSequence, int i) {
        return Range.m13451of(startOfLine(charSequence, i), endOfLine(charSequence, i));
    }

    @NotNull
    static Range lineRangeAtAnyEOL(@NotNull CharSequence charSequence, int i) {
        return Range.m13451of(startOfLineAnyEOL(charSequence, i), endOfLineAnyEOL(charSequence, i));
    }

    static boolean matchChars(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, true, z) == charSequence2.length();
    }

    static boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchChars(charSequence, charSequence2, i, true);
    }

    static boolean matchCharsReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        int i2 = i + 1;
        return i2 >= charSequence2.length() && matchChars(charSequence, charSequence2, i2 - charSequence2.length(), z);
    }

    static boolean matchCharsReversedIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        int i2 = i + 1;
        return i2 >= charSequence2.length() && matchChars(charSequence, charSequence2, i2 - charSequence2.length(), true);
    }

    static int matchedCharCount(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2, boolean z) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, z);
    }

    static int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, true);
    }

    static int matchedCharCountReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        return matchedCharCountReversed(charSequence, charSequence2, i, i2, false);
    }

    static int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        return matchedCharCountReversed(charSequence, charSequence2, i, i2, true);
    }

    static boolean matches(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        return charSequence2.length() == charSequence.length() && matchChars(charSequence, charSequence2, 0, z);
    }

    static boolean matchesIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return charSequence2.length() == charSequence.length() && matchChars(charSequence, charSequence2, 0, true);
    }

    @NotNull
    static String padEnd(@NotNull CharSequence charSequence, int i, char c) {
        return i <= charSequence.length() ? "" : RepeatedSequence.repeatOf(c, i - charSequence.length()).toString();
    }

    @NotNull
    static String padStart(@NotNull CharSequence charSequence, int i, char c) {
        return i <= charSequence.length() ? "" : RepeatedSequence.repeatOf(c, i - charSequence.length()).toString();
    }

    static int parseIntOrDefault(String str, int i) {
        return parseIntOrDefault(str, i, 10);
    }

    static Integer parseIntOrNull(String str) {
        return parseIntOrNull(str, 10);
    }

    static Long parseLongOrNull(String str) {
        return parseLongOrNull(str, 10);
    }

    @Nullable
    static Number parseNumberOrNull(@Nullable String str) {
        Long longOrNull;
        if (str == null) {
            return null;
        }
        if (str.startsWith("0x")) {
            return parseLongOrNull(str.substring(2), 16);
        }
        if (str.startsWith("0b")) {
            return parseLongOrNull(str.substring(2), 2);
        }
        if (str.startsWith("0") && (longOrNull = parseLongOrNull(str.substring(1), 8)) != null) {
            return longOrNull;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = numberFormat.parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return number;
        }
        return null;
    }

    @Nullable
    static Pair<Number, String> parseNumberPrefixOrNull(@Nullable String str, @Nullable Predicate<String> predicate) {
        int iCountLeading;
        if (str == null) {
            return null;
        }
        if (str.startsWith("0x")) {
            int iCountLeading2 = countLeading(str.substring(2), CharPredicate.HEXADECIMAL_DIGITS);
            int i = iCountLeading2 + 2;
            String strSubstring = str.substring(i);
            if (iCountLeading2 > 0 && (strSubstring.isEmpty() || predicate == null || predicate.test(strSubstring))) {
                return Pair.m13429of(parseLongOrNull(str.substring(2, i), 16), strSubstring);
            }
        } else if (str.startsWith("0b")) {
            int iCountLeading3 = countLeading(str.substring(2), CharPredicate.BINARY_DIGITS);
            int i2 = iCountLeading3 + 2;
            String strSubstring2 = str.substring(i2);
            if (iCountLeading3 > 0 && (strSubstring2.isEmpty() || predicate == null || predicate.test(strSubstring2))) {
                return Pair.m13429of(parseLongOrNull(str.substring(2, i2), 2), strSubstring2);
            }
        } else if (str.startsWith("0") && (iCountLeading = countLeading(str.substring(1), CharPredicate.OCTAL_DIGITS)) == countLeading(str.substring(1), CharPredicate.DECIMAL_DIGITS)) {
            int i4 = iCountLeading + 1;
            String strSubstring3 = str.substring(i4);
            if (iCountLeading > 0 && (strSubstring3.isEmpty() || predicate == null || predicate.test(strSubstring3))) {
                return Pair.m13429of(parseLongOrNull(str.substring(1, i4), 8), strSubstring3);
            }
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = numberFormat.parse(str, parsePosition);
        String strSubstring4 = str.substring(parsePosition.getIndex());
        if (parsePosition.getIndex() <= 0 || !(strSubstring4.isEmpty() || predicate == null || predicate.test(strSubstring4))) {
            return null;
        }
        return Pair.m13429of(number, strSubstring4);
    }

    static int parseUnsignedIntOrDefault(String str, int i) {
        return parseUnsignedIntOrDefault(str, i, 10);
    }

    static Integer parseUnsignedIntOrNull(String str) {
        return parseUnsignedIntOrNull(str, 10);
    }

    static char safeCharAt(@NotNull CharSequence charSequence, int i) {
        if (i < 0 || i >= charSequence.length()) {
            return (char) 0;
        }
        return charSequence.charAt(i);
    }

    @NotNull
    static <T extends CharSequence> T[] split(@NotNull T t, T[] tArr, @NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate) {
        return (T[]) split(t, tArr, "\n", 0, z ? 1 : 0, charPredicate);
    }

    @NotNull
    static <T extends CharSequence> T[] splitEOL(@NotNull T t, T[] tArr) {
        return (T[]) split(t, tArr, "\n", 0, 1, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitList(@NotNull T t, @NotNull CharSequence charSequence) {
        return splitList(t, charSequence, 0, 0, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitListEOL(@NotNull T t) {
        return splitList(t, "\n", 0, 1, (CharPredicate) null);
    }

    static int startOfDelimitedBy(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        int iLastIndexOf = lastIndexOf(charSequence, charSequence2, Utils.rangeLimit(i, 0, charSequence.length()) - 1);
        if (iLastIndexOf == -1) {
            return 0;
        }
        return iLastIndexOf + 1;
    }

    static int startOfDelimitedByAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        int iLastIndexOfAny = lastIndexOfAny(charSequence, charPredicate, Utils.rangeLimit(i, 0, charSequence.length()) - 1);
        if (iLastIndexOfAny == -1) {
            return 0;
        }
        return iLastIndexOfAny + 1;
    }

    static int startOfDelimitedByAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return startOfDelimitedByAny(charSequence, charPredicate.negate(), i);
    }

    static int startOfLine(@NotNull CharSequence charSequence, int i) {
        return startOfDelimitedBy(charSequence, "\n", i);
    }

    static int startOfLineAnyEOL(@NotNull CharSequence charSequence, int i) {
        return startOfDelimitedByAny(charSequence, CharPredicate.ANY_EOL, i);
    }

    static boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return charSequence.length() > 0 && matchChars(charSequence, charSequence2, 0, false);
    }

    static boolean startsWithAnyEOL(@NotNull CharSequence charSequence) {
        return startsWith(charSequence, CharPredicate.ANY_EOL);
    }

    static boolean startsWithEOL(@NotNull CharSequence charSequence) {
        return startsWith(charSequence, CharPredicate.EOL);
    }

    static boolean startsWithSpace(@NotNull CharSequence charSequence) {
        return startsWith(charSequence, CharPredicate.SPACE);
    }

    static boolean startsWithSpaceTab(@NotNull CharSequence charSequence) {
        return startsWith(charSequence, CharPredicate.SPACE_TAB);
    }

    static boolean startsWithWhitespace(@NotNull CharSequence charSequence) {
        return startsWith(charSequence, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> T subSequence(@NotNull T t, int i) {
        return (T) t.subSequence(i, t.length());
    }

    @Nullable
    static <T extends CharSequence> T subSequenceAfter(@NotNull T t, @NotNull Range range) {
        if (range.isNull()) {
            return null;
        }
        return (T) t.subSequence(range.getEnd(), t.length());
    }

    @Nullable
    static <T extends CharSequence> T subSequenceBefore(@NotNull T t, @NotNull Range range) {
        if (range.isNull()) {
            return null;
        }
        return (T) t.subSequence(0, range.getStart());
    }

    @NotNull
    static <T extends CharSequence> Pair<T, T> subSequenceBeforeAfter(@NotNull T t, Range range) {
        return Pair.m13429of(subSequenceBefore(t, range), subSequenceAfter(t, range));
    }

    @NotNull
    static String[] toStringArray(CharSequence... charSequenceArr) {
        String[] strArr = new String[charSequenceArr.length];
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            CharSequence charSequence2 = charSequenceArr[i];
            strArr[i] = charSequence2 == null ? null : charSequence2.toString();
            i++;
        }
        return strArr;
    }

    @NotNull
    static String toVisibleWhitespaceString(@NotNull CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            String str = visibleSpacesMap.get(Character.valueOf(cCharAt));
            if (str != null) {
                sb.append(str);
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    @NotNull
    static Range trailingBlankLinesRange(@NotNull CharSequence charSequence) {
        return trailingBlankLinesRange(charSequence, CharPredicate.EOL, 0, Integer.MAX_VALUE);
    }

    @NotNull
    static <T extends CharSequence> T trim(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return (T) trim(t, 0, charPredicate);
    }

    @NotNull
    static <T extends CharSequence> T trimEOL(@NotNull T t) {
        int iEolEndLength = eolEndLength(t);
        return iEolEndLength > 0 ? (T) t.subSequence(0, t.length() - iEolEndLength) : t;
    }

    @NotNull
    static <T extends CharSequence> T trimEnd(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return (T) trimEnd(t, 0, charPredicate);
    }

    static Range trimEndRange(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return trimEndRange(charSequence, 0, charPredicate);
    }

    @Nullable
    static <T extends CharSequence> T trimLeadBlankLines(@NotNull T t) {
        Range rangeLeadingBlankLinesRange = leadingBlankLinesRange(t);
        return rangeLeadingBlankLinesRange.isNull() ? t : (T) subSequenceAfter(t, rangeLeadingBlankLinesRange);
    }

    static Range trimRange(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return trimRange(charSequence, 0, charPredicate);
    }

    @NotNull
    static <T extends CharSequence> T trimStart(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(t, trimStartRange(t, 0, charPredicate));
    }

    static Range trimStartRange(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return trimStartRange(charSequence, 0, charPredicate);
    }

    @Nullable
    static <T extends CharSequence> T trimTailBlankLines(@NotNull T t) {
        Range rangeTrailingBlankLinesRange = trailingBlankLinesRange(t);
        return rangeTrailingBlankLinesRange.isNull() ? t : (T) subSequenceBefore(t, rangeTrailingBlankLinesRange);
    }

    @NotNull
    static <T extends CharSequence> Pair<T, T> trimmed(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return trimmed(t, 0, charPredicate);
    }

    @Nullable
    static <T extends CharSequence> T trimmedEOL(@NotNull T t) {
        int iEolEndLength = eolEndLength(t);
        if (iEolEndLength > 0) {
            return (T) t.subSequence(t.length() - iEolEndLength, t.length());
        }
        return null;
    }

    @Nullable
    static <T extends CharSequence> T trimmedEnd(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return (T) trimmedEnd(t, 0, charPredicate);
    }

    @Nullable
    static <T extends CharSequence> T trimmedStart(@NotNull T t, @NotNull CharPredicate charPredicate) {
        return (T) trimmedStart(t, 0, charPredicate);
    }

    @NotNull
    static int[] truncateTo(@NotNull int[] iArr, int i) {
        if (iArr.length <= i) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    static void validateIndex(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new StringIndexOutOfBoundsException(AbstractC0622a.m1164j(i, i2, "String index: ", " out of range: [0, ", ")"));
        }
    }

    static void validateIndexInclusiveEnd(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new StringIndexOutOfBoundsException(AbstractC0622a.m1164j(i, i2, "index: ", " out of range: [0, ", "]"));
        }
    }

    static void validateStartEnd(int i, int i2, int i4) {
        if (i < 0 || i > i4) {
            throw new StringIndexOutOfBoundsException(AbstractC0622a.m1164j(i, i4, "startIndex: ", " out of range: [0, ", ")"));
        }
        if (i2 < i || i2 > i4) {
            throw new StringIndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i2, i, "endIndex: ", " out of range: [", SQLKeyword.COMMA), "]", i4));
        }
    }

    @NotNull
    static List<Range> blankLinesRemovedRanges(@NotNull CharSequence charSequence, int i) {
        return blankLinesRemovedRanges(charSequence, CharPredicate.EOL, i, Integer.MAX_VALUE);
    }

    static int compare(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        return compare(charSequence, charSequence2, z, null);
    }

    static boolean containsAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return indexOfAny(charSequence, charPredicate, i, Integer.MAX_VALUE) != -1;
    }

    static boolean containsAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return indexOfAny(charSequence, charPredicate.negate(), i, Integer.MAX_VALUE) != -1;
    }

    static int countLeading(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countLeading(charSequence, charPredicate, i, Integer.MAX_VALUE);
    }

    static int countLeadingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countLeading(charSequence, charPredicate.negate(), i, Integer.MAX_VALUE);
    }

    static int countLeadingNotSpace(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.SPACE.negate(), i, Integer.MAX_VALUE);
    }

    static int countLeadingNotSpaceTab(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB.negate(), i, Integer.MAX_VALUE);
    }

    static int countLeadingNotWhitespace(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.WHITESPACE.negate(), i, Integer.MAX_VALUE);
    }

    static int countLeadingSpace(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.SPACE, i, Integer.MAX_VALUE);
    }

    static int countLeadingSpaceTab(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB, i, Integer.MAX_VALUE);
    }

    static int countLeadingWhitespace(@NotNull CharSequence charSequence, int i) {
        return countLeading(charSequence, CharPredicate.WHITESPACE, i, Integer.MAX_VALUE);
    }

    static int countOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countOfAny(charSequence, charPredicate, 0, Integer.MAX_VALUE);
    }

    static int countOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countOfAny(charSequence, charPredicate.negate(), i, Integer.MAX_VALUE);
    }

    static int countTrailing(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countTrailing(charSequence, charPredicate, 0, i);
    }

    static int countTrailingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return countTrailing(charSequence, charPredicate.negate(), 0, i);
    }

    static int countTrailingNotSpace(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.SPACE.negate(), 0, i);
    }

    static int countTrailingNotSpaceTab(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB.negate(), 0, i);
    }

    static int countTrailingNotWhitespace(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE.negate(), 0, i);
    }

    static int countTrailingSpace(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.SPACE, 0, i);
    }

    static int countTrailingSpaceTab(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB, 0, i);
    }

    static int countTrailingWhitespace(@NotNull CharSequence charSequence, int i) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE, 0, i);
    }

    static boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        return charSequence.length() > 0 && matchCharsReversed(charSequence, charSequence2, charSequence.length() - 1, z);
    }

    static int eolEndLength(@NotNull CharSequence charSequence, int i) {
        int iMin = Math.min(i - 1, charSequence.length() - 1);
        if (iMin < 0) {
            return 0;
        }
        char cCharAt = charSequence.charAt(iMin);
        if (cCharAt == '\r') {
            if (safeCharAt(charSequence, iMin + 1) != '\n') {
                return 1;
            }
        } else if (cCharAt == '\n') {
            return safeCharAt(charSequence, iMin - 1) == '\r' ? 2 : 1;
        }
        return 0;
    }

    static int indexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return indexOf(charSequence, charSequence2, i, Integer.MAX_VALUE);
    }

    static int indexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return indexOfAny(charSequence, charPredicate, i, Integer.MAX_VALUE);
    }

    static int indexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return indexOfAny(charSequence, charPredicate.negate(), i, Integer.MAX_VALUE);
    }

    static int indexOfNot(@NotNull CharSequence charSequence, char c, int i) {
        return indexOfNot(charSequence, c, i, Integer.MAX_VALUE);
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return lastIndexOf(charSequence, charSequence2, 0, i);
    }

    static int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return lastIndexOfAny(charSequence, charPredicate, 0, i);
    }

    static int lastIndexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i) {
        return lastIndexOfAny(charSequence, charPredicate.negate(), 0, i);
    }

    static int lastIndexOfNot(@NotNull CharSequence charSequence, char c, int i) {
        return lastIndexOfNot(charSequence, c, 0, i);
    }

    @NotNull
    static Range leadingBlankLinesRange(@NotNull CharSequence charSequence, int i) {
        return leadingBlankLinesRange(charSequence, CharPredicate.EOL, i, Integer.MAX_VALUE);
    }

    static boolean matchChars(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchChars(charSequence, charSequence2, i, false);
    }

    static boolean matchCharsIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return matchChars(charSequence, charSequence2, 0, true);
    }

    static boolean matchCharsReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        int i2 = i + 1;
        return i2 >= charSequence2.length() && matchChars(charSequence, charSequence2, i2 - charSequence2.length(), false);
    }

    static int matchedCharCount(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, z);
    }

    static int matchedCharCountIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, true);
    }

    static int matchedCharCountReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        return matchedCharCountReversed(charSequence, charSequence2, 0, i, z);
    }

    static int matchedCharCountReversedIgnoreCase(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchedCharCountReversed(charSequence, charSequence2, 0, i, true);
    }

    static boolean matches(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return charSequence2.length() == charSequence.length() && matchChars(charSequence, charSequence2, 0, false);
    }

    @NotNull
    static String padEnd(@NotNull CharSequence charSequence, int i) {
        return padEnd(charSequence, i, ' ');
    }

    @NotNull
    static String padStart(@NotNull CharSequence charSequence, int i) {
        return padStart(charSequence, i, ' ');
    }

    static int parseIntOrDefault(String str, int i, int i2) {
        try {
            return Integer.parseInt(str, i2);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    static Integer parseIntOrNull(String str, int i) {
        try {
            return Integer.valueOf(Integer.parseInt(str, i));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Long parseLongOrNull(String str, int i) {
        try {
            return Long.valueOf(Long.parseLong(str, i));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static int parseUnsignedIntOrDefault(String str, int i, int i2) {
        int i4;
        try {
            i4 = Integer.parseInt(str, i2);
        } catch (NumberFormatException unused) {
        }
        return i4 >= 0 ? i4 : i;
    }

    static Integer parseUnsignedIntOrNull(String str, int i) {
        try {
            int i2 = Integer.parseInt(str, i);
            if (i2 >= 0) {
                return Integer.valueOf(i2);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    @NotNull
    static <T extends CharSequence> T[] split(@NotNull T t, T[] tArr, @NotNull CharSequence charSequence) {
        return (T[]) split(t, tArr, charSequence, 0, 0, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> T[] splitEOL(@NotNull T t, T[] tArr, boolean z) {
        return (T[]) split(t, tArr, "\n", 0, z ? 1 : 0, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitList(@NotNull T t, @NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate) {
        return splitList(t, charSequence, i, z ? 1 : 0, charPredicate);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitListEOL(@NotNull T t, boolean z) {
        return splitList(t, "\n", 0, z ? 1 : 0, (CharPredicate) null);
    }

    static boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        return charSequence.length() > 0 && matchChars(charSequence, charSequence2, 0, z);
    }

    @NotNull
    static <T extends CharSequence> T subSequence(@NotNull T t, @NotNull Range range) {
        return range.isNull() ? t : (T) t.subSequence(range.getStart(), range.getEnd());
    }

    @NotNull
    static Range trailingBlankLinesRange(@NotNull CharSequence charSequence, int i) {
        return trailingBlankLinesRange(charSequence, CharPredicate.EOL, i, Integer.MAX_VALUE);
    }

    @NotNull
    static <T extends CharSequence> T trim(@NotNull T t, int i) {
        return (T) trim(t, i, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> T trimEnd(@NotNull T t, int i) {
        return (T) trimEnd(t, i, CharPredicate.WHITESPACE);
    }

    static Range trimEndRange(@NotNull CharSequence charSequence, int i) {
        return trimEndRange(charSequence, i, CharPredicate.WHITESPACE);
    }

    static Range trimRange(@NotNull CharSequence charSequence, int i) {
        return trimRange(charSequence, i, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> T trimStart(@NotNull T t, int i) {
        return (T) trimStart(t, i, CharPredicate.WHITESPACE);
    }

    static Range trimStartRange(@NotNull CharSequence charSequence, int i) {
        return trimStartRange(charSequence, i, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> Pair<T, T> trimmed(@NotNull T t, int i) {
        return trimmed(t, i, CharPredicate.WHITESPACE);
    }

    @Nullable
    static <T extends CharSequence> T trimmedEnd(@NotNull T t, int i) {
        return (T) trimmedEnd(t, i, CharPredicate.WHITESPACE);
    }

    @Nullable
    static <T extends CharSequence> T trimmedStart(@NotNull T t, int i) {
        return (T) trimmedStart(t, i, CharPredicate.WHITESPACE);
    }

    @NotNull
    static List<Range> blankLinesRemovedRanges(@NotNull CharSequence charSequence, int i, int i2) {
        return blankLinesRemovedRanges(charSequence, CharPredicate.EOL, i, i2);
    }

    static int compare(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z, @Nullable CharPredicate charPredicate) {
        char upperCase;
        char upperCase2;
        int i = 0;
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return 0;
            }
            return charSequence == null ? -1 : 1;
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int iMin = Math.min(length, length2);
        if (z) {
            while (i < iMin) {
                char cCharAt = charSequence.charAt(i);
                char cCharAt2 = charSequence2.charAt(i);
                if (cCharAt != cCharAt2 && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(cCharAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2) && (charPredicate == null || !charPredicate.test(cCharAt) || !charPredicate.test(cCharAt2))) {
                    return cCharAt - cCharAt2;
                }
                i++;
            }
        } else {
            while (i < iMin) {
                char cCharAt3 = charSequence.charAt(i);
                char cCharAt4 = charSequence2.charAt(i);
                if (cCharAt3 != cCharAt4 && (charPredicate == null || !charPredicate.test(cCharAt3) || !charPredicate.test(cCharAt4))) {
                    return cCharAt3 - cCharAt4;
                }
                i++;
            }
        }
        return length - length2;
    }

    static boolean containedBy(@NotNull Collection<? extends CharSequence> collection, @NotNull CharSequence charSequence) {
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            if (equals(charSequence, it.next())) {
                return true;
            }
        }
        return false;
    }

    static boolean containsAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return indexOfAny(charSequence, charPredicate.negate(), i, i2) != -1;
    }

    static int countLeading(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        int iRangeLimit = Utils.rangeLimit(i, 0, iMin);
        int iIndexOfAnyNot = indexOfAnyNot(charSequence, charPredicate, iRangeLimit, iMin);
        return iIndexOfAnyNot == -1 ? iMin - iRangeLimit : iIndexOfAnyNot - iRangeLimit;
    }

    static int countLeadingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return countLeading(charSequence, charPredicate.negate(), i, i2);
    }

    static int countLeadingNotSpace(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.SPACE.negate(), i, i2);
    }

    static int countLeadingNotSpaceTab(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB.negate(), i, i2);
    }

    static int countLeadingNotWhitespace(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.WHITESPACE.negate(), i, i2);
    }

    static int countLeadingSpace(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.SPACE, i, i2);
    }

    static int countLeadingSpaceTab(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.SPACE_TAB, i, i2);
    }

    static int countLeadingWhitespace(@NotNull CharSequence charSequence, int i, int i2) {
        return countLeading(charSequence, CharPredicate.WHITESPACE, i, i2);
    }

    static int countOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int i4 = 0;
        int iMin = Math.min(i2, charSequence.length());
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (charPredicate.test(charSequence.charAt(iMax))) {
                i4++;
            }
        }
        return i4;
    }

    static int countOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countOfAny(charSequence, charPredicate.negate(), 0, Integer.MAX_VALUE);
    }

    static int countTrailing(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        int iRangeLimit = Utils.rangeLimit(i, 0, iMin);
        int iLastIndexOfAnyNot = lastIndexOfAnyNot(charSequence, charPredicate, iRangeLimit, iMin - 1);
        if (iLastIndexOfAnyNot == -1) {
            return iMin - iRangeLimit;
        }
        if (iMin <= iLastIndexOfAnyNot) {
            return 0;
        }
        return (iMin - iLastIndexOfAnyNot) - 1;
    }

    static int countTrailingNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return countTrailing(charSequence, charPredicate.negate(), i, i2);
    }

    static int countTrailingNotSpace(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.SPACE.negate(), i, i2);
    }

    static int countTrailingNotSpaceTab(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB.negate(), i, i2);
    }

    static int countTrailingNotWhitespace(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE.negate(), i, i2);
    }

    static int countTrailingSpace(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.SPACE, i, i2);
    }

    static int countTrailingSpaceTab(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.SPACE_TAB, i, i2);
    }

    static int countTrailingWhitespace(@NotNull CharSequence charSequence, int i, int i2) {
        return countTrailing(charSequence, CharPredicate.WHITESPACE, i, i2);
    }

    static boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countTrailing(charSequence, charPredicate) > 0;
    }

    static int indexOf(@NotNull CharSequence charSequence, char c) {
        return indexOf(charSequence, c, 0, Integer.MAX_VALUE);
    }

    static int indexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (charPredicate.test(charSequence.charAt(iMax))) {
                return iMax;
            }
        }
        return -1;
    }

    static int indexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return indexOfAny(charSequence, charPredicate.negate(), i, i2);
    }

    static int indexOfNot(@NotNull CharSequence charSequence, char c, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (charSequence.charAt(iMax) != c) {
                return iMax;
            }
        }
        return -1;
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, char c) {
        return lastIndexOf(charSequence, c, 0, Integer.MAX_VALUE);
    }

    static int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length() - 1) + 1;
        int iMax = Math.max(i, 0);
        while (true) {
            int i4 = iMin - 1;
            if (iMin <= iMax) {
                return -1;
            }
            if (charPredicate.test(charSequence.charAt(i4))) {
                return i4;
            }
            iMin = i4;
        }
    }

    static int lastIndexOfAnyNot(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        return lastIndexOfAny(charSequence, charPredicate.negate(), i, i2);
    }

    static int lastIndexOfNot(@NotNull CharSequence charSequence, char c, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length() - 1) + 1;
        int iMax = Math.max(i, 0);
        while (true) {
            int i4 = iMin - 1;
            if (iMin <= iMax) {
                return -1;
            }
            if (charSequence.charAt(i4) != c) {
                return i4;
            }
            iMin = i4;
        }
    }

    @NotNull
    static Range leadingBlankLinesRange(@NotNull CharSequence charSequence, int i, int i2) {
        return leadingBlankLinesRange(charSequence, CharPredicate.EOL, i, i2);
    }

    static boolean matchChars(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        return matchChars(charSequence, charSequence2, 0, z);
    }

    static int matchedCharCount(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, false);
    }

    static int matchedCharCountReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchedCharCountReversed(charSequence, charSequence2, 0, i, false);
    }

    @NotNull
    static <T extends CharSequence> T[] split(@NotNull T t, T[] tArr, @NotNull CharSequence charSequence, int i, boolean z, @Nullable CharPredicate charPredicate) {
        return (T[]) split(t, tArr, charSequence, i, z ? 1 : 0, charPredicate);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitList(@NotNull T t, @NotNull CharSequence charSequence, int i, int i2) {
        return splitList(t, charSequence, i, i2, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitListEOL(@NotNull T t, boolean z, @Nullable CharPredicate charPredicate) {
        return splitList(t, "\n", 0, z ? 1 : 0, charPredicate);
    }

    static boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        return countLeading(charSequence, charPredicate) > 0;
    }

    @NotNull
    static Range trailingBlankLinesRange(@NotNull CharSequence charSequence, int i, int i2) {
        return trailingBlankLinesRange(charSequence, CharPredicate.EOL, i, i2);
    }

    @NotNull
    static <T extends CharSequence> T trim(@NotNull T t) {
        return (T) trim(t, 0, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> T trimEnd(@NotNull T t) {
        return (T) trimEnd(t, 0, CharPredicate.WHITESPACE);
    }

    static Range trimEndRange(@NotNull CharSequence charSequence) {
        return trimEndRange(charSequence, 0, CharPredicate.WHITESPACE);
    }

    static Range trimRange(@NotNull CharSequence charSequence) {
        return trimRange(charSequence, 0, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> T trimStart(@NotNull T t) {
        return (T) trimStart(t, 0, CharPredicate.WHITESPACE);
    }

    static Range trimStartRange(@NotNull CharSequence charSequence) {
        return trimStartRange(charSequence, 0, CharPredicate.WHITESPACE);
    }

    @NotNull
    static <T extends CharSequence> Pair<T, T> trimmed(@NotNull T t) {
        return trimmed(t, 0, CharPredicate.WHITESPACE);
    }

    @Nullable
    static <T extends CharSequence> T trimmedEnd(@NotNull T t) {
        return (T) trimmedEnd(t, 0, CharPredicate.WHITESPACE);
    }

    @Nullable
    static <T extends CharSequence> T trimmedStart(@NotNull T t) {
        return (T) trimmedStart(t, 0, CharPredicate.WHITESPACE);
    }

    @NotNull
    static List<Range> blankLinesRemovedRanges(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        int iRangeLimit = Utils.rangeLimit(i, 0, iMin);
        ArrayList arrayList = new ArrayList();
        while (iRangeLimit < iMin) {
            Range rangeLeadingBlankLinesRange = leadingBlankLinesRange(charSequence, charPredicate, iRangeLimit, iMin);
            if (rangeLeadingBlankLinesRange.isNull()) {
                int iMin2 = Math.min(endOfLine(charSequence, iRangeLimit) + 1, iMin);
                if (iRangeLimit < iMin2) {
                    arrayList.add(Range.m13451of(iRangeLimit, iMin2));
                }
                iRangeLimit = iMin2;
            } else {
                if (iRangeLimit < rangeLeadingBlankLinesRange.getStart()) {
                    arrayList.add(Range.m13451of(iRangeLimit, rangeLeadingBlankLinesRange.getStart()));
                }
                iRangeLimit = rangeLeadingBlankLinesRange.getEnd();
            }
        }
        return arrayList;
    }

    static int indexOf(@NotNull CharSequence charSequence, char c, int i) {
        return indexOf(charSequence, c, i, Integer.MAX_VALUE);
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, char c, int i) {
        return lastIndexOf(charSequence, c, 0, i);
    }

    @NotNull
    static Range leadingBlankLinesRange(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length());
        int iRangeLimit = Utils.rangeLimit(i, 0, iMin);
        int i4 = -1;
        int i5 = iRangeLimit;
        while (i5 < iMin) {
            char cCharAt = charSequence.charAt(i5);
            if (!charPredicate.test(cCharAt)) {
                if (cCharAt != ' ' && cCharAt != '\t') {
                    break;
                }
            } else {
                i4 = i5;
            }
            i5++;
        }
        if (i5 == iMin) {
            return Range.m13451of(iRangeLimit, iMin);
        }
        if (i4 >= 0) {
            return Range.m13451of(iRangeLimit, Math.min(Math.min(eolStartLength(charSequence, i4), 1) + i4, iMin));
        }
        return Range.NULL;
    }

    static boolean matchChars(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return matchChars(charSequence, charSequence2, 0, false);
    }

    static int matchedCharCount(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i) {
        return matchedCharCount(charSequence, charSequence2, i, Integer.MAX_VALUE, false, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int matchedCharCountReversed(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2, boolean z) {
        int i4;
        char upperCase;
        char upperCase2;
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, Math.min(charSequence.length(), i2));
        int iMin = Math.min(iMax2 - iMax, charSequence2.length());
        int i5 = iMax2 - iMin;
        if (!z) {
            int i6 = iMin;
            while (true) {
                i4 = i6 - 1;
                if (i6 <= 0) {
                    break;
                }
                if (charSequence2.charAt(i4) != charSequence.charAt(i5 + i4)) {
                    break;
                }
                i6 = i4;
            }
            return (iMin - i4) - 1;
        }
        int i7 = iMin;
        while (true) {
            i4 = i7 - 1;
            if (i7 <= 0) {
                break;
            }
            char cCharAt = charSequence2.charAt(i4);
            char cCharAt2 = charSequence.charAt(i5 + i4);
            if (cCharAt != cCharAt2 && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(cCharAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                break;
            }
            i7 = i4;
        }
        return (iMin - i4) - 1;
    }

    @NotNull
    static <T extends CharSequence> T[] split(@NotNull T t, T[] tArr, @NotNull CharSequence charSequence, int i, int i2) {
        return (T[]) split(t, tArr, charSequence, i, i2, (CharPredicate) null);
    }

    @NotNull
    static <T extends CharSequence> List<T> splitList(@NotNull T t, @NotNull CharSequence charSequence, boolean z, @Nullable CharPredicate charPredicate) {
        return splitList(t, charSequence, 0, z ? 1 : 0, charPredicate);
    }

    @NotNull
    static Range trailingBlankLinesRange(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate, int i, int i2) {
        int i4;
        int iMin = Math.min(i2, charSequence.length());
        int iRangeLimit = Utils.rangeLimit(i, 0, iMin);
        int i5 = iMin;
        int iMin2 = i5;
        while (true) {
            i4 = i5 - 1;
            if (i5 <= iRangeLimit) {
                break;
            }
            char cCharAt = charSequence.charAt(i4);
            if (!charPredicate.test(cCharAt)) {
                if (cCharAt != ' ' && cCharAt != '\t') {
                    break;
                }
            } else {
                iMin2 = Math.min(Math.min(eolStartLength(charSequence, i4), 1) + i4, iMin);
            }
            i5 = i4;
        }
        if (i4 < iRangeLimit) {
            return Range.m13451of(iRangeLimit, iMin);
        }
        if (iMin2 != iMin) {
            return Range.m13451of(iMin2, iMin);
        }
        return Range.NULL;
    }

    @NotNull
    static <T extends CharSequence> T trim(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(t, trimRange(t, i, charPredicate));
    }

    @NotNull
    static <T extends CharSequence> T trimEnd(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(t, trimEndRange(t, i, charPredicate));
    }

    @NotNull
    static Range trimEndRange(@NotNull CharSequence charSequence, int i, @NotNull CharPredicate charPredicate) {
        int length = charSequence.length();
        int iCountTrailing = countTrailing(charSequence, charPredicate, 0, length);
        return iCountTrailing > i ? Range.m13451of(0, (length - iCountTrailing) + i) : Range.NULL;
    }

    @NotNull
    static Range trimRange(@NotNull CharSequence charSequence, int i, @NotNull CharPredicate charPredicate) {
        int length = charSequence.length();
        if (i >= length) {
            return Range.NULL;
        }
        int iCountLeading = countLeading(charSequence, charPredicate, 0, length);
        if (iCountLeading > i) {
            int i2 = iCountLeading - i;
            int iCountTrailing = countTrailing(charSequence, charPredicate, i2, length);
            return iCountTrailing > i ? Range.m13451of(i2, (length - iCountTrailing) + i) : Range.m13451of(i2, length);
        }
        int iCountTrailing2 = countTrailing(charSequence, charPredicate, iCountLeading, length);
        return iCountTrailing2 > i ? Range.m13451of(0, (length - iCountTrailing2) + i) : Range.NULL;
    }

    @NotNull
    static <T extends CharSequence> T trimStart(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequence(t, trimStartRange(t, i, charPredicate));
    }

    @NotNull
    static Range trimStartRange(@NotNull CharSequence charSequence, int i, @NotNull CharPredicate charPredicate) {
        int length = charSequence.length();
        int iCountLeading = countLeading(charSequence, charPredicate, 0, length);
        return iCountLeading > i ? Range.m13451of(iCountLeading - i, length) : Range.NULL;
    }

    @NotNull
    static <T extends CharSequence> Pair<T, T> trimmed(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return subSequenceBeforeAfter(t, trimRange(t, i, charPredicate));
    }

    @Nullable
    static <T extends CharSequence> T trimmedEnd(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequenceAfter(t, trimEndRange(t, i, charPredicate));
    }

    @Nullable
    static <T extends CharSequence> T trimmedStart(@NotNull T t, int i, @NotNull CharPredicate charPredicate) {
        return (T) subSequenceBefore(t, trimStartRange(t, i, charPredicate));
    }

    static int indexOf(@NotNull CharSequence charSequence, char c, int i, int i2) {
        int iMin = Math.min(charSequence.length(), i2);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (c == charSequence.charAt(iMax)) {
                return iMax;
            }
        }
        return -1;
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, char c, int i, int i2) {
        int iMin = Math.min(i2, charSequence.length() - 1) + 1;
        int iMax = Math.max(i, 0);
        while (true) {
            int i4 = iMin - 1;
            if (iMin <= iMax) {
                return -1;
            }
            if (c == charSequence.charAt(i4)) {
                return i4;
            }
            iMin = i4;
        }
    }

    static int matchedCharCount(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        char upperCase;
        char upperCase2;
        int length = charSequence2.length();
        int iMin = Math.min(Math.min(charSequence.length(), i2) - i, length);
        int i4 = 0;
        if (z && iMin < length) {
            return 0;
        }
        if (z2) {
            while (i4 < iMin) {
                char cCharAt = charSequence2.charAt(i4);
                char cCharAt2 = charSequence.charAt(i4 + i);
                if (cCharAt != cCharAt2 && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(cCharAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return i4;
                }
                i4++;
            }
        } else {
            while (i4 < iMin) {
                if (charSequence2.charAt(i4) != charSequence.charAt(i4 + i)) {
                    return i4;
                }
                i4++;
            }
        }
        return iMin;
    }

    @NotNull
    static <T extends CharSequence> T[] split(@NotNull T t, T[] tArr, @NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate) {
        return (T[]) ((CharSequence[]) splitList(t, charSequence, i, i2, charPredicate).toArray(tArr));
    }

    @NotNull
    static <T extends CharSequence> List<T> splitList(@NotNull T t, @NotNull CharSequence charSequence, int i, int i2, @Nullable CharPredicate charPredicate) {
        if (charPredicate == null) {
            charPredicate = CharPredicate.WHITESPACE;
        } else {
            i2 |= 2;
        }
        if (i < 1) {
            i = Integer.MAX_VALUE;
        }
        int i4 = 0;
        boolean z = (i2 & 8) != 0;
        int length = (z || (i2 & 1) == 0) ? 0 : charSequence.length();
        boolean z2 = (i2 & 2) != 0;
        boolean z3 = (i2 & 4) != 0;
        ArrayList arrayList = new ArrayList();
        int length2 = t.length();
        if (i > 1) {
            while (true) {
                if (i4 < length2) {
                    int iIndexOf = indexOf(t, charSequence, i4);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if (i4 < iIndexOf || !z3) {
                        CharSequence charSequenceSubSequence = t.subSequence(i4, iIndexOf + length);
                        if (z2) {
                            charSequenceSubSequence = trim(charSequenceSubSequence, charPredicate);
                        }
                        if (!isEmpty(charSequenceSubSequence) || !z3) {
                            arrayList.add(charSequenceSubSequence);
                            if (z) {
                                arrayList.add(t.subSequence(iIndexOf, charSequence.length() + iIndexOf));
                            }
                            if (arrayList.size() >= i - 1) {
                                i4 = iIndexOf + 1;
                                break;
                            }
                        }
                    }
                    i4 = iIndexOf + 1;
                } else {
                    break;
                }
            }
        }
        if (i4 < length2) {
            CharSequence charSequenceSubSequence2 = t.subSequence(i4, length2);
            if (z2) {
                charSequenceSubSequence2 = trim(charSequenceSubSequence2, charPredicate);
            }
            if (!isEmpty(charSequenceSubSequence2) || !z3) {
                arrayList.add(charSequenceSubSequence2);
            }
        }
        return arrayList;
    }

    static int indexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        int iMax = Math.max(i, 0);
        int length = charSequence2.length();
        if (length == 0) {
            return iMax;
        }
        int iMin = Math.min(charSequence.length(), i2);
        if (iMax >= iMin) {
            return -1;
        }
        char cCharAt = charSequence2.charAt(0);
        do {
            int iIndexOf = indexOf(charSequence, cCharAt, iMax);
            if (iIndexOf < 0 || iIndexOf + length > iMin) {
                return -1;
            }
            if (matchChars(charSequence, charSequence2, iIndexOf)) {
                return iIndexOf;
            }
            iMax = iIndexOf + 1;
        } while (iMax + length < iMin);
        return -1;
    }

    static int lastIndexOf(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, int i2) {
        int iMax = Math.max(i, 0);
        int length = charSequence2.length();
        if (length == 0) {
            return iMax;
        }
        int iMin = Math.min(i2, charSequence.length());
        if (iMax >= iMin) {
            return -1;
        }
        char cCharAt = charSequence2.charAt(length - 1);
        while (true) {
            int iLastIndexOf = lastIndexOf(charSequence, cCharAt, iMin);
            int i4 = iLastIndexOf + 1;
            int i5 = iMax + length;
            if (i4 < i5) {
                return -1;
            }
            if (matchCharsReversed(charSequence, charSequence2, iLastIndexOf)) {
                return i4 - length;
            }
            int i6 = iLastIndexOf - 1;
            if (iLastIndexOf < i5) {
                return -1;
            }
            iMin = i6;
        }
    }
}
