package org.apache.commons.lang3;

import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CharUtils {

    /* JADX INFO: renamed from: CR */
    public static final char f9759CR = '\r';

    /* JADX INFO: renamed from: LF */
    public static final char f9760LF = '\n';
    public static final char NUL = 0;
    private static final String[] CHAR_STRING_ARRAY = (String[]) ArrayUtils.setAll(new String[128], new C13885j());
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};

    @Deprecated
    public CharUtils() {
    }

    public static int compare(char c, char c2) {
        return c - c2;
    }

    public static boolean isAscii(char c) {
        return c < 128;
    }

    public static boolean isAsciiAlpha(char c) {
        return isAsciiAlphaUpper(c) || isAsciiAlphaLower(c);
    }

    public static boolean isAsciiAlphaLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c) {
        return isAsciiAlpha(c) || isAsciiNumeric(c);
    }

    public static boolean isAsciiControl(char c) {
        return c < ' ' || c == 127;
    }

    public static boolean isAsciiNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isAsciiPrintable(char c) {
        return c >= ' ' && c < 127;
    }

    public static boolean isHex(char c) {
        if (isAsciiNumeric(c)) {
            return true;
        }
        if (c < 'a' || c > 'f') {
            return c >= 'A' && c <= 'F';
        }
        return true;
    }

    public static boolean isOctal(char c) {
        return c >= '0' && c <= '7';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(int i) {
        return String.valueOf((char) i);
    }

    public static char toChar(Character ch) {
        Objects.requireNonNull(ch, "ch");
        return ch.charValue();
    }

    @Deprecated
    public static Character toCharacterObject(char c) {
        return Character.valueOf(c);
    }

    public static int toIntValue(char c) {
        if (isAsciiNumeric(c)) {
            return c - '0';
        }
        throw new IllegalArgumentException("The character " + c + " is not in the range '0' - '9'");
    }

    public static String toString(char c) {
        String[] strArr = CHAR_STRING_ARRAY;
        return c < strArr.length ? strArr[c] : String.valueOf(c);
    }

    public static String unicodeEscaped(char c) {
        StringBuilder sb = new StringBuilder("\\u");
        char[] cArr = HEX_DIGITS;
        sb.append(cArr[(c >> '\f') & 15]);
        sb.append(cArr[(c >> '\b') & 15]);
        sb.append(cArr[(c >> 4) & 15]);
        sb.append(cArr[c & 15]);
        return sb.toString();
    }

    public static char toChar(Character ch, char c) {
        return ch != null ? ch.charValue() : c;
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static String unicodeEscaped(Character ch) {
        if (ch != null) {
            return unicodeEscaped(ch.charValue());
        }
        return null;
    }

    public static char toChar(String str) {
        Validate.notEmpty(str, "The String must not be empty", new Object[0]);
        return str.charAt(0);
    }

    public static int toIntValue(char c, int i) {
        return isAsciiNumeric(c) ? c - '0' : i;
    }

    public static int toIntValue(Character ch) {
        return toIntValue(toChar(ch));
    }

    public static String toString(Character ch) {
        if (ch != null) {
            return toString(ch.charValue());
        }
        return null;
    }

    public static char toChar(String str, char c) {
        return StringUtils.isEmpty(str) ? c : str.charAt(0);
    }

    public static int toIntValue(Character ch, int i) {
        return ch != null ? toIntValue(ch.charValue(), i) : i;
    }
}
