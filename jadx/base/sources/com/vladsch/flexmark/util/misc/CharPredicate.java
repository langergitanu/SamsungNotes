package com.vladsch.flexmark.util.misc;

import com.vladsch.flexmark.util.format.C11862h;
import com.vladsch.flexmark.util.sequence.C11885d;
import java.util.BitSet;
import java.util.Objects;
import java.util.function.IntPredicate;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CharPredicate extends IntPredicate {
    public static final CharPredicate ALL;
    public static final CharPredicate ANY_EOL;
    public static final CharPredicate ANY_EOL_NUL;
    public static final CharPredicate BACKSLASH;
    public static final CharPredicate BINARY_DIGITS;
    public static final CharPredicate BLANKSPACE;
    public static final CharPredicate DECIMAL_DIGITS;
    public static final CharPredicate EOL;

    @Deprecated
    public static final CharPredicate FALSE;
    public static final CharPredicate HASH;
    public static final CharPredicate HEXADECIMAL_DIGITS;
    public static final CharPredicate LINE_SEP;
    public static final CharPredicate NONE;
    public static final CharPredicate OCTAL_DIGITS;
    public static final CharPredicate SLASH;
    public static final CharPredicate SPACE;
    public static final CharPredicate SPACE_ANY_EOL;
    public static final CharPredicate SPACE_EOL;
    public static final CharPredicate SPACE_TAB;
    public static final CharPredicate SPACE_TAB_EOL;
    public static final CharPredicate SPACE_TAB_LINE_SEP;
    public static final CharPredicate SPACE_TAB_NBSP;
    public static final CharPredicate SPACE_TAB_NBSP_EOL;
    public static final CharPredicate SPACE_TAB_NBSP_LINE_SEP;
    public static final CharPredicate SPACE_TAB_NUL;

    @Deprecated
    public static final CharPredicate SPACE_TAB_OR_NUL;
    public static final CharPredicate TAB;

    @Deprecated
    public static final CharPredicate TRUE;
    public static final CharPredicate WHITESPACE;
    public static final CharPredicate WHITESPACE_NBSP;
    public static final CharPredicate WHITESPACE_NBSP_OR_NUL;
    public static final CharPredicate WHITESPACE_OR_NUL;

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.misc.CharPredicate$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118641 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
    }

    static {
        C11862h c11862h = new C11862h(21);
        NONE = c11862h;
        C11862h c11862h2 = new C11862h(4);
        ALL = c11862h2;
        SPACE = new C11862h(14);
        TAB = new C11862h(15);
        EOL = new C11862h(16);
        ANY_EOL = new C11862h(17);
        ANY_EOL_NUL = new C11862h(18);
        BACKSLASH = new C11862h(19);
        SLASH = new C11862h(20);
        LINE_SEP = new C11862h(22);
        HASH = new C11862h(23);
        SPACE_TAB = new C11862h(24);
        C11862h c11862h3 = new C11862h(25);
        SPACE_TAB_NUL = c11862h3;
        SPACE_TAB_LINE_SEP = new C11862h(26);
        SPACE_TAB_NBSP_LINE_SEP = new C11862h(27);
        SPACE_EOL = new C11862h(28);
        int i = 1;
        SPACE_ANY_EOL = new C11885d(i);
        SPACE_TAB_NBSP = new C11862h(i);
        SPACE_TAB_EOL = new C11862h(2);
        SPACE_TAB_NBSP_EOL = new C11862h(3);
        WHITESPACE = new C11862h(5);
        WHITESPACE_OR_NUL = new C11862h(6);
        WHITESPACE_NBSP = new C11862h(7);
        WHITESPACE_NBSP_OR_NUL = new C11862h(8);
        BLANKSPACE = new C11862h(9);
        HEXADECIMAL_DIGITS = new C11862h(10);
        DECIMAL_DIGITS = new C11862h(11);
        OCTAL_DIGITS = new C11862h(12);
        BINARY_DIGITS = new C11862h(13);
        FALSE = c11862h;
        TRUE = c11862h2;
        SPACE_TAB_OR_NUL = c11862h3;
    }

    @NotNull
    static CharPredicate anyOf(char... cArr) {
        int length = cArr.length;
        return length != 0 ? length != 1 ? length != 2 ? length != 3 ? length != 4 ? anyOf(String.valueOf(cArr)) : standardOrAnyOf(cArr[0], cArr[1], cArr[2], cArr[3]) : standardOrAnyOf(cArr[0], cArr[1], cArr[2]) : standardOrAnyOf(cArr[0], cArr[1]) : standardOrAnyOf(cArr[0]) : NONE;
    }

    static int indexOf(@NotNull CharSequence charSequence, char c) {
        return indexOf(charSequence, c, 0, charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$29(CharPredicate charPredicate, int i) {
        return test(i) && charPredicate.test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$anyOf$36(String str, int i) {
        return indexOf(str, (char) i) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$30(int i) {
        return !test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$31(CharPredicate charPredicate, int i) {
        return test(i) || charPredicate.test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$standardOrAnyOf$32(char c, int i) {
        return i == c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$standardOrAnyOf$33(char c, char c2, int i) {
        return i == c || i == c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$standardOrAnyOf$34(char c, char c2, char c4, int i) {
        return i == c || i == c2 || i == c4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$standardOrAnyOf$35(char c, char c2, char c4, char c5, int i) {
        return i == c || i == c2 || i == c4 || i == c5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(int i) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$10(int i) {
        return i == 35;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$11(int i) {
        return i == 32 || i == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$12(int i) {
        return i == 32 || i == 9 || i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$13(int i) {
        return i == 32 || i == 9 || i == 8232;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$14(int i) {
        return i == 32 || i == 9 || i == 160 || i == 8232;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$15(int i) {
        return i == 32 || i == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$16(int i) {
        return i == 32 || i == 13 || i == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$17(int i) {
        return i == 32 || i == 9 || i == 160;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$18(int i) {
        return i == 32 || i == 9 || i == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$19(int i) {
        return i == 32 || i == 9 || i == 10 || i == 160;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$2(int i) {
        return i == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$20(int i) {
        return i == 32 || i == 9 || i == 10 || i == 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$21(int i) {
        return i == 32 || i == 9 || i == 10 || i == 13 || i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$22(int i) {
        return i == 32 || i == 9 || i == 10 || i == 13 || i == 160;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$23(int i) {
        return i == 32 || i == 9 || i == 10 || i == 13 || i == 160 || i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$24(int i) {
        return i == 32 || i == 9 || i == 10 || i == 13 || i == 11 || i == 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$25(int i) {
        if (i >= 48 && i <= 57) {
            return true;
        }
        if (i < 97 || i > 102) {
            return i >= 65 && i <= 70;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$26(int i) {
        return i >= 48 && i <= 57;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$27(int i) {
        return i >= 48 && i <= 55;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$28(int i) {
        return i >= 48 && i <= 49;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$3(int i) {
        return i == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$4(int i) {
        return i == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$5(int i) {
        return i == 10 || i == 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$6(int i) {
        return i == 10 || i == 13 || i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$7(int i) {
        return i == 92;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$8(int i) {
        return i == 47;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$9(int i) {
        return i == 8232;
    }

    @NotNull
    static CharPredicate standardOrAnyOf(final char c) {
        CharPredicate charPredicate = SPACE;
        if (charPredicate.test(c)) {
            return charPredicate;
        }
        CharPredicate charPredicate2 = EOL;
        if (charPredicate2.test(c)) {
            return charPredicate2;
        }
        CharPredicate charPredicate3 = TAB;
        return charPredicate3.test(c) ? charPredicate3 : new CharPredicate() { // from class: com.vladsch.flexmark.util.misc.e
            @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
            public final boolean test(int i) {
                return CharPredicate.lambda$standardOrAnyOf$32(c, i);
            }
        };
    }

    @NotNull
    default CharPredicate and(@NotNull CharPredicate charPredicate) {
        Objects.requireNonNull(charPredicate);
        CharPredicate charPredicate2 = NONE;
        if (this == charPredicate2 || charPredicate == charPredicate2) {
            return charPredicate2;
        }
        CharPredicate charPredicate3 = ALL;
        return this == charPredicate3 ? charPredicate : charPredicate == charPredicate3 ? this : new C11866a(this, charPredicate, 0);
    }

    @NotNull
    /* JADX INFO: renamed from: or */
    default CharPredicate m13428or(@NotNull CharPredicate charPredicate) {
        Objects.requireNonNull(charPredicate);
        CharPredicate charPredicate2 = ALL;
        if (this == charPredicate2 || charPredicate == charPredicate2) {
            return charPredicate2;
        }
        CharPredicate charPredicate3 = NONE;
        return this == charPredicate3 ? charPredicate : charPredicate == charPredicate3 ? this : new C11866a(this, charPredicate, 1);
    }

    default boolean test(char c) {
        return test((int) c);
    }

    @Override // java.util.function.IntPredicate
    boolean test(int i);

    static int indexOf(@NotNull CharSequence charSequence, char c, int i, int i2) {
        int iMin = Math.min(charSequence.length(), i2);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (c == charSequence.charAt(iMax)) {
                return iMax;
            }
        }
        return -1;
    }

    @Override // java.util.function.IntPredicate
    @NotNull
    default CharPredicate negate() {
        CharPredicate charPredicate = NONE;
        return this == charPredicate ? ALL : this == ALL ? charPredicate : new C11868c(this, 2);
    }

    @NotNull
    static CharPredicate standardOrAnyOf(final char c, final char c2) {
        if (c == c2) {
            return standardOrAnyOf(c);
        }
        CharPredicate charPredicate = SPACE_TAB;
        if (charPredicate.test(c) && charPredicate.test(c2)) {
            return charPredicate;
        }
        CharPredicate charPredicate2 = ANY_EOL;
        return (charPredicate2.test(c) && charPredicate2.test(c2)) ? charPredicate2 : new CharPredicate() { // from class: com.vladsch.flexmark.util.misc.b
            @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
            public final boolean test(int i) {
                return CharPredicate.lambda$standardOrAnyOf$33(c, c2, i);
            }
        };
    }

    @NotNull
    static CharPredicate anyOf(@NotNull CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return NONE;
        }
        if (length == 1) {
            return standardOrAnyOf(charSequence.charAt(0));
        }
        if (length == 2) {
            return standardOrAnyOf(charSequence.charAt(0), charSequence.charAt(1));
        }
        if (length == 3) {
            return standardOrAnyOf(charSequence.charAt(0), charSequence.charAt(1), charSequence.charAt(2));
        }
        if (length != 4) {
            int length2 = charSequence.length();
            C11868c c11868c = null;
            StringBuilder sb = null;
            BitSet bitSet = null;
            for (int i = 0; i < length2; i++) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt <= 127) {
                    if (bitSet == null) {
                        bitSet = new BitSet();
                    }
                    bitSet.set(cCharAt);
                } else {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (indexOf(sb, cCharAt) == -1) {
                        sb.append(cCharAt);
                    }
                }
            }
            String string = sb == null ? null : sb.toString();
            CharPredicate charPredicateAnyOf = (string == null || string.isEmpty()) ? null : string.length() <= 4 ? anyOf(sb) : new C11868c(string, 0);
            if (bitSet != null && bitSet.cardinality() != 0) {
                c11868c = new C11868c(bitSet, 1);
            }
            if (!C118641.$assertionsDisabled && c11868c == null && charPredicateAnyOf == null) {
                throw new AssertionError();
            }
            if (c11868c == null || charPredicateAnyOf == null) {
                return c11868c != null ? c11868c : charPredicateAnyOf;
            }
            return c11868c.m13428or(charPredicateAnyOf);
        }
        return standardOrAnyOf(charSequence.charAt(0), charSequence.charAt(1), charSequence.charAt(2), charSequence.charAt(3));
    }

    @NotNull
    static CharPredicate standardOrAnyOf(final char c, final char c2, final char c4) {
        if (c == c2 && c2 == c4) {
            return standardOrAnyOf(c);
        }
        if (c == c2 || c == c4) {
            return standardOrAnyOf(c2, c4);
        }
        if (c2 == c4) {
            return standardOrAnyOf(c, c4);
        }
        return new CharPredicate() { // from class: com.vladsch.flexmark.util.misc.d
            @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
            public final boolean test(int i) {
                return CharPredicate.lambda$standardOrAnyOf$34(c, c2, c4, i);
            }
        };
    }

    @NotNull
    static CharPredicate standardOrAnyOf(final char c, final char c2, final char c4, final char c5) {
        if (c == c2 && c2 == c4 && c4 == c5) {
            return standardOrAnyOf(c);
        }
        if (c == c2 || c == c4 || c == c5) {
            return standardOrAnyOf(c2, c4, c5);
        }
        if (c2 == c4 || c2 == c5) {
            return standardOrAnyOf(c, c4, c5);
        }
        if (c4 == c5) {
            return standardOrAnyOf(c, c2, c4);
        }
        CharPredicate charPredicate = WHITESPACE;
        return (charPredicate.test(c) && charPredicate.test(c2) && charPredicate.test(c4) && charPredicate.test(c5)) ? charPredicate : new CharPredicate() { // from class: com.vladsch.flexmark.util.misc.f
            @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
            public final boolean test(int i) {
                return CharPredicate.lambda$standardOrAnyOf$35(c, c2, c4, c5, i);
            }
        };
    }
}
