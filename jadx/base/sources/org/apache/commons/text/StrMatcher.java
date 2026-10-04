package org.apache.commons.text;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER;
    private static final StrMatcher DOUBLE_QUOTE_MATCHER;
    private static final StrMatcher NONE_MATCHER;
    private static final StrMatcher QUOTE_MATCHER;
    private static final StrMatcher SINGLE_QUOTE_MATCHER;
    private static final StrMatcher SPACE_MATCHER;
    private static final StrMatcher SPLIT_MATCHER;
    private static final StrMatcher TAB_MATCHER;
    private static final StrMatcher TRIM_MATCHER;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharMatcher extends StrMatcher {

        /* JADX INFO: renamed from: ch */
        private final char f9992ch;

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return this.f9992ch == cArr[i] ? 1 : 0;
        }

        private CharMatcher(char c) {
            this.f9992ch = c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return Arrays.binarySearch(this.chars, cArr[i]) >= 0 ? 1 : 0;
        }

        private CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoMatcher extends StrMatcher {
        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return 0;
        }

        private NoMatcher() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            int length = this.chars.length;
            if (i + length > i4) {
                return 0;
            }
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i5 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i5] != cArr[i]) {
                    return 0;
                }
                i5++;
                i++;
            }
        }

        public String toString() {
            return super.toString() + ' ' + Arrays.toString(this.chars);
        }

        private StringMatcher(String str) {
            this.chars = str.toCharArray();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TrimMatcher extends StrMatcher {
        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return cArr[i] <= ' ' ? 1 : 0;
        }

        private TrimMatcher() {
        }
    }

    static {
        COMMA_MATCHER = new CharMatcher(',');
        TAB_MATCHER = new CharMatcher('\t');
        SPACE_MATCHER = new CharMatcher(' ');
        SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
        TRIM_MATCHER = new TrimMatcher();
        SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
        DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
        QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
        NONE_MATCHER = new NoMatcher();
    }

    public static StrMatcher charMatcher(char c) {
        return new CharMatcher(c);
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        if (ArrayUtils.isEmpty(cArr)) {
            return NONE_MATCHER;
        }
        return cArr.length == 1 ? new CharMatcher(cArr[0]) : new CharSetMatcher(cArr);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        return (str == null || str.isEmpty()) ? NONE_MATCHER : new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i, int i2, int i4);

    public static StrMatcher charSetMatcher(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.length() == 1) {
                return new CharMatcher(str.charAt(0));
            }
            return new CharSetMatcher(str.toCharArray());
        }
        return NONE_MATCHER;
    }
}
