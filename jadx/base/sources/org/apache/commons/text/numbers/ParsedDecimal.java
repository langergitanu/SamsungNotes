package org.apache.commons.text.numbers;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ParsedDecimal {
    private static final int DECIMAL_RADIX = 10;
    private static final char DECIMAL_SEP_CHAR = '.';
    private static final int ENG_EXPONENT_MOD = 3;
    private static final char EXPONENT_CHAR = 'E';
    private static final char MINUS_CHAR = '-';
    private static final int ROUND_CENTER = 5;
    private static final int THOUSANDS_GROUP_SIZE = 3;
    private static final char ZERO_CHAR = '0';
    int digitCount;
    final int[] digits;
    int exponent;
    final boolean negative;
    private char[] outputChars;
    private int outputIdx;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FormatOptions {
        char getDecimalSeparator();

        char[] getDigits();

        char[] getExponentSeparatorChars();

        char getGroupingSeparator();

        char getMinusSign();

        boolean isAlwaysIncludeExponent();

        boolean isGroupThousands();

        boolean isIncludeFractionPlaceholder();

        boolean isSignedZero();
    }

    private ParsedDecimal(boolean z, int[] iArr, int i, int i2) {
        this.negative = z;
        this.digits = iArr;
        this.digitCount = i;
        this.exponent = i2;
    }

    private void append(char c) {
        char[] cArr = this.outputChars;
        int i = this.outputIdx;
        this.outputIdx = i + 1;
        cArr[i] = c;
    }

    private void appendFraction(int i, int i2, FormatOptions formatOptions) {
        char[] digits = formatOptions.getDigits();
        char c = digits[0];
        if (i2 >= this.digitCount) {
            if (formatOptions.isIncludeFractionPlaceholder()) {
                append(formatOptions.getDecimalSeparator());
                append(c);
                return;
            }
            return;
        }
        append(formatOptions.getDecimalSeparator());
        for (int i4 = 0; i4 < i; i4++) {
            append(c);
        }
        while (i2 < this.digitCount) {
            appendLocalizedDigit(this.digits[i2], digits);
            i2++;
        }
    }

    private void appendLocalizedDigit(int i, char[] cArr) {
        append(cArr[i]);
    }

    private int appendWhole(int i, FormatOptions formatOptions) {
        if (shouldIncludeMinus(formatOptions)) {
            append(formatOptions.getMinusSign());
        }
        char[] digits = formatOptions.getDigits();
        int i2 = 0;
        char c = digits[0];
        int iMax = Math.max(0, Math.min(i, this.digitCount));
        if (iMax <= 0) {
            append(c);
            return iMax;
        }
        while (i2 < iMax) {
            appendLocalizedDigit(this.digits[i2], digits);
            i2++;
        }
        while (i2 < i) {
            append(c);
            i2++;
        }
        return iMax;
    }

    private int appendWholeGrouped(int i, FormatOptions formatOptions) {
        if (shouldIncludeMinus(formatOptions)) {
            append(formatOptions.getMinusSign());
        }
        char[] digits = formatOptions.getDigits();
        int i2 = 0;
        char c = digits[0];
        char groupingSeparator = formatOptions.getGroupingSeparator();
        int iMax = Math.max(0, Math.min(i, this.digitCount));
        if (iMax <= 0) {
            append(c);
            return iMax;
        }
        int i4 = i;
        while (i2 < iMax) {
            appendLocalizedDigit(this.digits[i2], digits);
            if (requiresGroupingSeparatorAfterPosition(i4)) {
                append(groupingSeparator);
            }
            i2++;
            i4--;
        }
        while (i2 < i) {
            append(c);
            if (requiresGroupingSeparatorAfterPosition(i4)) {
                append(groupingSeparator);
            }
            i2++;
            i4--;
        }
        return iMax;
    }

    private static int digitValue(char c) {
        return c - '0';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public static ParsedDecimal from(double d) {
        if (!Double.isFinite(d)) {
            throw new IllegalArgumentException("Double is not finite");
        }
        char[] charArray = Double.toString(d).toCharArray();
        ?? r02 = charArray[0] == '-' ? 1 : 0;
        int[] iArr = new int[(charArray.length - r02) - 1];
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        boolean z = false;
        ?? r32 = r02;
        while (r32 < charArray.length) {
            char c = charArray[r32];
            if (c == '.') {
                z = true;
                i2 = i;
            } else {
                if (c == 'E') {
                    break;
                }
                if (c != '0' || i > 0) {
                    int iDigitValue = digitValue(c);
                    int i5 = i + 1;
                    iArr[i] = iDigitValue;
                    if (iDigitValue > 0) {
                        i4 = i5;
                    }
                    i = i5;
                } else if (z) {
                    i2--;
                }
            }
            r32++;
        }
        if (i > 0) {
            return new ParsedDecimal(r02, iArr, i4, ((r32 < charArray.length ? parseExponent(charArray, r32 + 1) : 0) + i2) - i4);
        }
        return new ParsedDecimal(r02, new int[]{0}, 1, 0);
    }

    private int getDigitStringSize(int i, FormatOptions formatOptions) {
        int i2 = this.digitCount;
        if (shouldIncludeMinus(formatOptions)) {
            i2++;
        }
        if (i < 1) {
            return Math.abs(i) + 2 + i2;
        }
        int i4 = this.digitCount;
        if (i < i4) {
            return i2 + 1;
        }
        int i5 = (i - i4) + i2;
        return formatOptions.isIncludeFractionPlaceholder() ? i5 + 2 : i5;
    }

    private int getPlainStringSize(int i, FormatOptions formatOptions) {
        int digitStringSize = getDigitStringSize(i, formatOptions);
        return (!formatOptions.isGroupThousands() || i <= 0) ? digitStringSize : AbstractC0000a.m7d(i, 1, 3, digitStringSize);
    }

    private String outputString() {
        String strValueOf = String.valueOf(this.outputChars);
        this.outputChars = null;
        return strValueOf;
    }

    private static int parseExponent(char[] cArr, int i) {
        int i2;
        int iDigitValue = 0;
        boolean z = cArr[i] == '-';
        if (!z) {
            i2 = i + 1;
            while (i2 < cArr.length) {
                iDigitValue = (iDigitValue * 10) + digitValue(cArr[i2]);
            }
            return z ? -iDigitValue : iDigitValue;
        }
        i2++;
    }

    private void prepareOutput(int i) {
        this.outputChars = new char[i];
        this.outputIdx = 0;
    }

    private boolean requiresGroupingSeparatorAfterPosition(int i) {
        return i > 1 && i % 3 == 1;
    }

    private void roundUp(int i) {
        int i2 = this.digitCount - i;
        int i4 = i - 1;
        while (true) {
            if (i4 < 0) {
                break;
            }
            int[] iArr = this.digits;
            int i5 = iArr[i4] + 1;
            if (i5 < 10) {
                iArr[i4] = i5;
                break;
            } else {
                i2++;
                i4--;
            }
        }
        if (i4 < 0) {
            setSingleDigitValue(1, this.exponent + i2);
        } else {
            truncate(this.digitCount - i2);
        }
    }

    private void setSingleDigitValue(int i, int i2) {
        this.digits[0] = i;
        this.digitCount = 1;
        this.exponent = i2;
    }

    private boolean shouldIncludeExponent(int i, FormatOptions formatOptions) {
        return i != 0 || formatOptions.isAlwaysIncludeExponent();
    }

    private boolean shouldIncludeMinus(FormatOptions formatOptions) {
        if (this.negative) {
            return formatOptions.isSignedZero() || !isZero();
        }
        return false;
    }

    private boolean shouldRoundUp(int i) {
        int[] iArr = this.digits;
        int i2 = iArr[i];
        if (i2 <= 5) {
            if (i2 != 5) {
                return false;
            }
            if (i >= this.digitCount - 1 && iArr[i - 1] % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private void truncate(int i) {
        for (int i2 = i - 1; i2 > 0 && this.digits[i2] == 0; i2--) {
            i--;
        }
        this.exponent = (this.digitCount - i) + this.exponent;
        this.digitCount = i;
    }

    public int getExponent() {
        return this.exponent;
    }

    public int getScientificExponent() {
        return (this.digitCount + this.exponent) - 1;
    }

    public boolean isZero() {
        return this.digits[0] == 0;
    }

    public void maxPrecision(int i) {
        if (i <= 0 || i >= this.digitCount) {
            return;
        }
        if (shouldRoundUp(i)) {
            roundUp(i);
        } else {
            truncate(i);
        }
    }

    public void round(int i) {
        int i2 = this.exponent;
        if (i > i2) {
            int i4 = this.digitCount + i2;
            if (i < i4) {
                maxPrecision(i4 - i);
            } else if (i == i4 && shouldRoundUp(0)) {
                setSingleDigitValue(1, i);
            } else {
                setSingleDigitValue(0, 0);
            }
        }
    }

    public String toEngineeringString(FormatOptions formatOptions) {
        return toScientificString(Math.floorMod(getScientificExponent(), 3) + 1, formatOptions);
    }

    public String toPlainString(FormatOptions formatOptions) {
        int i = this.digitCount + this.exponent;
        int iAbs = i < 1 ? Math.abs(i) : 0;
        prepareOutput(getPlainStringSize(i, formatOptions));
        appendFraction(iAbs, formatOptions.isGroupThousands() ? appendWholeGrouped(i, formatOptions) : appendWhole(i, formatOptions), formatOptions);
        return outputString();
    }

    public String toScientificString(FormatOptions formatOptions) {
        return toScientificString(1, formatOptions);
    }

    private void append(char[] cArr) {
        for (char c : cArr) {
            append(c);
        }
    }

    private String toScientificString(int i, FormatOptions formatOptions) {
        int i2 = (this.digitCount + this.exponent) - i;
        int iAbs = Math.abs(i2);
        boolean zShouldIncludeExponent = shouldIncludeExponent(i2, formatOptions);
        boolean z = i2 < 0;
        int digitStringSize = getDigitStringSize(i, formatOptions);
        if (zShouldIncludeExponent) {
            digitStringSize += formatOptions.getExponentSeparatorChars().length + (iAbs > 0 ? 1 + ((int) Math.floor(Math.log10(iAbs))) : 1);
            if (z) {
                digitStringSize++;
            }
        }
        prepareOutput(digitStringSize);
        appendFraction(0, appendWhole(i, formatOptions), formatOptions);
        if (zShouldIncludeExponent) {
            append(formatOptions.getExponentSeparatorChars());
            if (z) {
                append(formatOptions.getMinusSign());
            }
            char[] digits = formatOptions.getDigits();
            for (int i4 = digitStringSize - 1; i4 >= this.outputIdx; i4--) {
                this.outputChars[i4] = digits[iAbs % 10];
                iAbs /= 10;
            }
            this.outputIdx = digitStringSize;
        }
        return outputString();
    }
}
