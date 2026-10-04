package org.jsoup.parser;

import java.util.Arrays;
import java.util.Locale;
import org.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class CharacterReader {
    static final char EOF = 65535;
    private static final int maxCacheLen = 12;
    private final char[] input;
    private final int length;
    private int pos = 0;
    private int mark = 0;
    private final String[] stringCache = new String[512];

    public CharacterReader(String str) {
        Validate.notNull(str);
        char[] charArray = str.toCharArray();
        this.input = charArray;
        this.length = charArray.length;
    }

    private String cacheString(int i, int i2) {
        char[] cArr = this.input;
        String[] strArr = this.stringCache;
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        while (i4 < i2) {
            i6 = (i6 * 31) + cArr[i5];
            i4++;
            i5++;
        }
        int length = (strArr.length - 1) & i6;
        String str = strArr[length];
        if (str != null) {
            return rangeEquals(i, i2, str) ? str : new String(cArr, i, i2);
        }
        String str2 = new String(cArr, i, i2);
        strArr[length] = str2;
        return str2;
    }

    public void advance() {
        this.pos++;
    }

    public char consume() {
        int i = this.pos;
        char c = i >= this.length ? (char) 65535 : this.input[i];
        this.pos = i + 1;
        return c;
    }

    public String consumeAsString() {
        char[] cArr = this.input;
        int i = this.pos;
        this.pos = i + 1;
        return new String(cArr, i, 1);
    }

    public String consumeData() {
        int i;
        char c;
        int i2 = this.pos;
        int i4 = this.length;
        char[] cArr = this.input;
        while (true) {
            i = this.pos;
            if (i >= i4 || (c = cArr[i]) == '&' || c == '<' || c == 0) {
                break;
            }
            this.pos = i + 1;
        }
        return i > i2 ? cacheString(i2, i - i2) : "";
    }

    public String consumeDigitSequence() {
        int i;
        char c;
        int i2 = this.pos;
        while (true) {
            i = this.pos;
            if (i >= this.length || (c = this.input[i]) < '0' || c > '9') {
                break;
            }
            this.pos = i + 1;
        }
        return cacheString(i2, i - i2);
    }

    public String consumeHexSequence() {
        int i;
        char c;
        int i2 = this.pos;
        while (true) {
            i = this.pos;
            if (i >= this.length || (((c = this.input[i]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.pos = i + 1;
        }
        return cacheString(i2, i - i2);
    }

    public String consumeLetterSequence() {
        int i;
        char c;
        int i2 = this.pos;
        while (true) {
            i = this.pos;
            if (i >= this.length || (((c = this.input[i]) < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                break;
            }
            this.pos = i + 1;
        }
        return cacheString(i2, i - i2);
    }

    public String consumeLetterThenDigitSequence() {
        char c;
        int i = this.pos;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length || (((c = this.input[i2]) < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                break;
            }
            this.pos = i2 + 1;
        }
        while (!isEmpty()) {
            char[] cArr = this.input;
            int i4 = this.pos;
            char c2 = cArr[i4];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.pos = i4 + 1;
        }
        return cacheString(i, this.pos - i);
    }

    public String consumeTagName() {
        int i;
        char c;
        int i2 = this.pos;
        int i4 = this.length;
        char[] cArr = this.input;
        while (true) {
            i = this.pos;
            if (i >= i4 || (c = cArr[i]) == '\t' || c == '\n' || c == '\r' || c == '\f' || c == ' ' || c == '/' || c == '>' || c == 0) {
                break;
            }
            this.pos = i + 1;
        }
        return i > i2 ? cacheString(i2, i - i2) : "";
    }

    public String consumeTo(char c) {
        int iNextIndexOf = nextIndexOf(c);
        if (iNextIndexOf == -1) {
            return consumeToEnd();
        }
        String strCacheString = cacheString(this.pos, iNextIndexOf);
        this.pos += iNextIndexOf;
        return strCacheString;
    }

    public String consumeToAny(char... cArr) {
        int i = this.pos;
        int i2 = this.length;
        loop0: while (this.pos < i2) {
            for (char c : cArr) {
                if (this.input[this.pos] == c) {
                    break loop0;
                }
            }
            this.pos++;
        }
        int i4 = this.pos;
        return i4 > i ? cacheString(i, i4 - i) : "";
    }

    public String consumeToAnySorted(char... cArr) {
        int i = this.pos;
        int i2 = this.length;
        char[] cArr2 = this.input;
        while (true) {
            int i4 = this.pos;
            if (i4 >= i2 || Arrays.binarySearch(cArr, cArr2[i4]) >= 0) {
                break;
            }
            this.pos++;
        }
        int i5 = this.pos;
        return i5 > i ? cacheString(i, i5 - i) : "";
    }

    public String consumeToEnd() {
        int i = this.pos;
        String strCacheString = cacheString(i, this.length - i);
        this.pos = this.length;
        return strCacheString;
    }

    public boolean containsIgnoreCase(String str) {
        Locale locale = Locale.ENGLISH;
        return nextIndexOf(str.toLowerCase(locale)) > -1 || nextIndexOf(str.toUpperCase(locale)) > -1;
    }

    public char current() {
        int i = this.pos;
        if (i >= this.length) {
            return (char) 65535;
        }
        return this.input[i];
    }

    public boolean isEmpty() {
        return this.pos >= this.length;
    }

    public void mark() {
        this.mark = this.pos;
    }

    public boolean matchConsume(String str) {
        if (!matches(str)) {
            return false;
        }
        this.pos = str.length() + this.pos;
        return true;
    }

    public boolean matchConsumeIgnoreCase(String str) {
        if (!matchesIgnoreCase(str)) {
            return false;
        }
        this.pos = str.length() + this.pos;
        return true;
    }

    public boolean matches(char c) {
        return !isEmpty() && this.input[this.pos] == c;
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        char c = this.input[this.pos];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesAnySorted(char[] cArr) {
        return !isEmpty() && Arrays.binarySearch(cArr, this.input[this.pos]) >= 0;
    }

    public boolean matchesDigit() {
        char c;
        return !isEmpty() && (c = this.input[this.pos]) >= '0' && c <= '9';
    }

    public boolean matchesIgnoreCase(String str) {
        int length = str.length();
        if (length > this.length - this.pos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.input[this.pos + i])) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c = this.input[this.pos];
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public int nextIndexOf(char c) {
        for (int i = this.pos; i < this.length; i++) {
            if (c == this.input[i]) {
                return i - this.pos;
            }
        }
        return -1;
    }

    public int pos() {
        return this.pos;
    }

    public boolean rangeEquals(int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        char[] cArr = this.input;
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i4 + 1;
            if (cArr[i] != str.charAt(i4)) {
                return false;
            }
            i = i6;
            i2 = i5;
            i4 = i7;
        }
    }

    public void rewindToMark() {
        this.pos = this.mark;
    }

    public String toString() {
        char[] cArr = this.input;
        int i = this.pos;
        return new String(cArr, i, this.length - i);
    }

    public void unconsume() {
        this.pos--;
    }

    public boolean matches(String str) {
        int length = str.length();
        if (length > this.length - this.pos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.input[this.pos + i]) {
                return false;
            }
        }
        return true;
    }

    public int nextIndexOf(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        int i = this.pos;
        while (i < this.length) {
            if (cCharAt != this.input[i]) {
                do {
                    i++;
                    if (i >= this.length) {
                        break;
                    }
                } while (cCharAt != this.input[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i4 = this.length;
            if (i < i4 && length <= i4) {
                int i5 = i2;
                for (int i6 = 1; i5 < length && charSequence.charAt(i6) == this.input[i5]; i6++) {
                    i5++;
                }
                if (i5 == length) {
                    return i - this.pos;
                }
            }
            i = i2;
        }
        return -1;
    }

    public String consumeTo(String str) {
        int iNextIndexOf = nextIndexOf(str);
        if (iNextIndexOf != -1) {
            String strCacheString = cacheString(this.pos, iNextIndexOf);
            this.pos += iNextIndexOf;
            return strCacheString;
        }
        return consumeToEnd();
    }
}
