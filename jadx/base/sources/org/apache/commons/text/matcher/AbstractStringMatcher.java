package org.apache.commons.text.matcher;

import androidx.collection.AbstractC0622a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractStringMatcher implements StringMatcher {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharMatcher extends AbstractStringMatcher {

        /* JADX INFO: renamed from: ch */
        private final char f9999ch;

        public CharMatcher(char c) {
            this.f9999ch = c;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return this.f9999ch == cArr[i] ? 1 : 0;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            return 1;
        }

        public String toString() {
            return super.toString() + "['" + this.f9999ch + "']";
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            return this.f9999ch == charSequence.charAt(i) ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharSetMatcher extends AbstractStringMatcher {
        private final char[] chars;

        public CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return Arrays.binarySearch(this.chars, cArr[i]) >= 0 ? 1 : 0;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            return 1;
        }

        public String toString() {
            return super.toString() + Arrays.toString(this.chars);
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            return Arrays.binarySearch(this.chars, charSequence.charAt(i)) >= 0 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoneMatcher extends AbstractStringMatcher {
        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            return 0;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            return 0;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TrimMatcher extends AbstractStringMatcher {
        private static final int SPACE_INT = 32;

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            return cArr[i] <= ' ' ? 1 : 0;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            return 1;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            return charSequence.charAt(i) <= ' ' ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AndStringMatcher extends AbstractStringMatcher {
        private final StringMatcher[] stringMatchers;

        public AndStringMatcher(StringMatcher... stringMatcherArr) {
            this.stringMatchers = (StringMatcher[]) stringMatcherArr.clone();
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            int i5 = 0;
            for (StringMatcher stringMatcher : this.stringMatchers) {
                if (stringMatcher != null) {
                    int iIsMatch = stringMatcher.isMatch(cArr, i, i2, i4);
                    if (iIsMatch == 0) {
                        return 0;
                    }
                    i5 += iIsMatch;
                    i += iIsMatch;
                }
            }
            return i5;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            int size = 0;
            for (StringMatcher stringMatcher : this.stringMatchers) {
                if (stringMatcher != null) {
                    size = stringMatcher.size() + size;
                }
            }
            return size;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            int i5 = 0;
            for (StringMatcher stringMatcher : this.stringMatchers) {
                if (stringMatcher != null) {
                    int iIsMatch = stringMatcher.isMatch(charSequence, i, i2, i4);
                    if (iIsMatch == 0) {
                        return 0;
                    }
                    i5 += iIsMatch;
                    i += iIsMatch;
                }
            }
            return i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharArrayMatcher extends AbstractStringMatcher {
        private final char[] chars;
        private final String string;

        public CharArrayMatcher(char... cArr) {
            this.string = String.valueOf(cArr);
            this.chars = (char[]) cArr.clone();
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] cArr, int i, int i2, int i4) {
            int size = size();
            if (i + size > i4) {
                return 0;
            }
            int i5 = 0;
            while (i5 < size) {
                if (this.chars[i5] != cArr[i]) {
                    return 0;
                }
                i5++;
                i++;
            }
            return size;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int size() {
            return this.chars.length;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("[\"");
            return AbstractC0622a.m1170p(this.string, "\"]", sb);
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(CharSequence charSequence, int i, int i2, int i4) {
            int size = size();
            if (i + size > i4) {
                return 0;
            }
            int i5 = 0;
            while (i5 < size) {
                if (this.chars[i5] != charSequence.charAt(i)) {
                    return 0;
                }
                i5++;
                i++;
            }
            return size;
        }
    }
}
