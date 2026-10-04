package com.vladsch.flexmark.util.format;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RomanNumeral {
    private final int num;
    private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] letters = {"M", "CM", DiagMonUtil.AGREE_TYPE_DIAGNOSTIC, "CD", FeedbackDetailConstants.PREFIX_CLIENT_ERROR, "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
    public static final Pattern ROMAN_NUMERAL = Pattern.compile("M{0,3}(?:CM|DC{0,3}|CD|C{1,3})?(?:XC|LX{0,3}|XL|X{1,3})?(?:IX|VI{0,3}|IV|I{1,3})?");
    public static final Pattern LOWERCASE_ROMAN_NUMERAL = Pattern.compile("m{0,3}(?:cm|dc{0,3}|cd|c{1,3})?(?:xc|lx{0,3}|xl|x{1,3})?(?:ix|vi{0,3}|iv|i{1,3})?");
    public static final Pattern LIMITED_ROMAN_NUMERAL = Pattern.compile("(?:X{1,3})?(?:IX|VI{0,3}|IV|I{1,3})?");
    public static final Pattern LIMITED_LOWERCASE_ROMAN_NUMERAL = Pattern.compile("(?:x{1,3})?(?:ix|vi{0,3}|iv|i{1,3})?");

    public RomanNumeral(int i) {
        if (i < 1) {
            throw new NumberFormatException("Value of RomanNumeral must be positive.");
        }
        if (i > 3999) {
            throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
        }
        this.num = i;
    }

    private int letterToNumber(char c) {
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c != 'L') {
            return c != 'M' ? -1 : 1000;
        }
        return 50;
    }

    public int toInt() {
        return this.num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.num;
        for (int i2 = 0; i2 < numbers.length; i2++) {
            while (true) {
                int[] iArr = numbers;
                if (i >= iArr[i2]) {
                    sb.append(letters[i2]);
                    i -= iArr[i2];
                }
            }
        }
        return sb.toString();
    }

    public RomanNumeral(String str) {
        int iLetterToNumber;
        if (str.length() != 0) {
            String upperCase = str.toUpperCase();
            int i = 0;
            int i2 = 0;
            while (i < upperCase.length()) {
                char cCharAt = upperCase.charAt(i);
                int iLetterToNumber2 = letterToNumber(cCharAt);
                if (iLetterToNumber2 >= 0) {
                    int i4 = i + 1;
                    if (i4 != upperCase.length() && (iLetterToNumber = letterToNumber(upperCase.charAt(i4))) > iLetterToNumber2) {
                        i += 2;
                        i2 = (iLetterToNumber - iLetterToNumber2) + i2;
                    } else {
                        i2 += iLetterToNumber2;
                        i = i4;
                    }
                } else {
                    throw new NumberFormatException("Illegal character \"" + cCharAt + "\" in roman numeral.");
                }
            }
            if (i2 <= 3999) {
                this.num = i2;
                return;
            }
            throw new NumberFormatException("Roman numeral must have value 3999 or less.");
        }
        throw new NumberFormatException("An empty string does not define a Roman numeral.");
    }
}
