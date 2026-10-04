package org.apache.xmlbeans.impl.regex;

import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.PrintStream;
import java.text.CharacterIterator;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class REUtil {
    static final int CACHESIZE = 20;
    static final RegularExpression[] regexCache = new RegularExpression[20];

    private REUtil() {
    }

    public static final int composeFromSurrogates(int i, int i2) {
        return ((((i - 55296) << 10) + 65536) + i2) - Utf8.LOG_SURROGATE_HEADER;
    }

    public static final String createOptionString(int i) {
        StringBuffer stringBuffer = new StringBuffer(9);
        if ((i & 256) != 0) {
            stringBuffer.append('F');
        }
        if ((i & 128) != 0) {
            stringBuffer.append('H');
        }
        if ((i & 512) != 0) {
            stringBuffer.append('X');
        }
        if ((i & 2) != 0) {
            stringBuffer.append('i');
        }
        if ((i & 8) != 0) {
            stringBuffer.append('m');
        }
        if ((i & 4) != 0) {
            stringBuffer.append('s');
        }
        if ((i & 32) != 0) {
            stringBuffer.append('u');
        }
        if ((i & 64) != 0) {
            stringBuffer.append('w');
        }
        if ((i & 16) != 0) {
            stringBuffer.append('x');
        }
        if ((i & 1024) != 0) {
            stringBuffer.append(',');
        }
        return stringBuffer.toString().intern();
    }

    public static RegularExpression createRegex(String str, String str2) {
        RegularExpression regularExpression;
        int options = parseOptions(str2);
        synchronized (regexCache) {
            int i = 0;
            while (true) {
                regularExpression = null;
                if (i >= 20) {
                    break;
                }
                try {
                    RegularExpression regularExpression2 = regexCache[i];
                    if (regularExpression2 == null) {
                        i = -1;
                        break;
                    }
                    if (regularExpression2.equals(str, options)) {
                        regularExpression = regularExpression2;
                        break;
                    }
                    i++;
                } finally {
                }
            }
            if (regularExpression == null) {
                regularExpression = new RegularExpression(str, str2);
                RegularExpression[] regularExpressionArr = regexCache;
                System.arraycopy(regularExpressionArr, 0, regularExpressionArr, 1, 19);
                regularExpressionArr[0] = regularExpression;
            } else if (i != 0) {
                RegularExpression[] regularExpressionArr2 = regexCache;
                System.arraycopy(regularExpressionArr2, 0, regularExpressionArr2, 1, i);
                regularExpressionArr2[0] = regularExpression;
            }
        }
        return regularExpression;
    }

    public static final String decomposeToSurrogates(int i) {
        int i2 = i - 65536;
        return new String(new char[]{(char) ((i2 >> 10) + 55296), (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER)});
    }

    public static void dumpString(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(Integer.toHexString(str.charAt(i)));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static final int getOptionValue(int i) {
        if (i == 44) {
            return 1024;
        }
        if (i == 70) {
            return 256;
        }
        if (i == 72) {
            return 128;
        }
        if (i == 88) {
            return 512;
        }
        if (i == 105) {
            return 2;
        }
        if (i == 109) {
            return 8;
        }
        if (i == 115) {
            return 4;
        }
        if (i == 117) {
            return 32;
        }
        if (i != 119) {
            return i != 120 ? 0 : 16;
        }
        return 64;
    }

    public static final boolean isHighSurrogate(int i) {
        return (i & 64512) == 55296;
    }

    public static final boolean isLowSurrogate(int i) {
        return (i & 64512) == 56320;
    }

    public static void main(String[] strArr) {
        String str = null;
        try {
            if (strArr.length == 0) {
                System.out.println("Error:Usage: java REUtil -i|-m|-s|-u|-w|-X regularExpression String");
                System.exit(0);
            }
            String string = "";
            String str2 = null;
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].length() == 0 || strArr[i].charAt(0) != '-') {
                    if (str == null) {
                        str = strArr[i];
                    } else if (str2 == null) {
                        str2 = strArr[i];
                    } else {
                        PrintStream printStream = System.err;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unnecessary: ");
                        stringBuffer.append(strArr[i]);
                        printStream.println(stringBuffer.toString());
                    }
                } else if (strArr[i].equals("-i")) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(string);
                    stringBuffer2.append("i");
                    string = stringBuffer2.toString();
                } else if (strArr[i].equals("-m")) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(string);
                    stringBuffer3.append("m");
                    string = stringBuffer3.toString();
                } else if (strArr[i].equals("-s")) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(string);
                    stringBuffer4.append("s");
                    string = stringBuffer4.toString();
                } else if (strArr[i].equals("-u")) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(string);
                    stringBuffer5.append(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                    string = stringBuffer5.toString();
                } else if (strArr[i].equals("-w")) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append(string);
                    stringBuffer6.append("w");
                    string = stringBuffer6.toString();
                } else if (strArr[i].equals("-X")) {
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append(string);
                    stringBuffer7.append("X");
                    string = stringBuffer7.toString();
                } else {
                    PrintStream printStream2 = System.err;
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append("Unknown option: ");
                    stringBuffer8.append(strArr[i]);
                    printStream2.println(stringBuffer8.toString());
                }
            }
            RegularExpression regularExpression = new RegularExpression(str, string);
            PrintStream printStream3 = System.out;
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append("RegularExpression: ");
            stringBuffer9.append(regularExpression);
            printStream3.println(stringBuffer9.toString());
            Match match = new Match();
            regularExpression.matches(str2, match);
            for (int i2 = 0; i2 < match.getNumberOfGroups(); i2++) {
                if (i2 == 0) {
                    System.out.print("Matched range for the whole pattern: ");
                } else {
                    PrintStream printStream4 = System.out;
                    StringBuffer stringBuffer10 = new StringBuffer();
                    stringBuffer10.append("[");
                    stringBuffer10.append(i2);
                    stringBuffer10.append("]: ");
                    printStream4.print(stringBuffer10.toString());
                }
                if (match.getBeginning(i2) < 0) {
                    System.out.println("-1");
                } else {
                    PrintStream printStream5 = System.out;
                    StringBuffer stringBuffer11 = new StringBuffer();
                    stringBuffer11.append(match.getBeginning(i2));
                    stringBuffer11.append(SQLKeyword.COMMA);
                    stringBuffer11.append(match.getEnd(i2));
                    stringBuffer11.append(SQLKeyword.COMMA);
                    printStream5.print(stringBuffer11.toString());
                    PrintStream printStream6 = System.out;
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append("\"");
                    stringBuffer12.append(match.getCapturedText(i2));
                    stringBuffer12.append("\"");
                    printStream6.println(stringBuffer12.toString());
                }
            }
        } catch (ParseException e) {
            if (str == null) {
                e.printStackTrace();
                return;
            }
            PrintStream printStream7 = System.err;
            StringBuffer stringBuffer13 = new StringBuffer("org.apache.xerces.utils.regex.ParseException: ");
            stringBuffer13.append(e.getMessage());
            printStream7.println(stringBuffer13.toString());
            System.err.println("        ".concat(str));
            int location = e.getLocation();
            if (location >= 0) {
                System.err.print("        ");
                for (int i4 = 0; i4 < location; i4++) {
                    System.err.print(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                }
                System.err.println("^");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean matches(String str, String str2) {
        return createRegex(str, null).matches(str2);
    }

    public static final int parseOptions(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int optionValue = getOptionValue(str.charAt(i2));
            if (optionValue == 0) {
                StringBuffer stringBuffer = new StringBuffer("Unknown Option: ");
                stringBuffer.append(str.substring(i2));
                throw new ParseException(stringBuffer.toString(), -1);
            }
            i |= optionValue;
        }
        return i;
    }

    public static String quoteMeta(String str) {
        int length = str.length();
        StringBuffer stringBuffer = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (".*+?{[()|\\^$".indexOf(cCharAt) >= 0) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(AbstractC1974b.m1304A(length, i, 2, i));
                    if (i > 0) {
                        stringBuffer.append(str.substring(0, i));
                    }
                }
                stringBuffer.append('\\');
                stringBuffer.append(cCharAt);
            } else if (stringBuffer != null) {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    public static String stripExtendedComment(String str) {
        char cCharAt;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '\f' && cCharAt2 != '\r' && cCharAt2 != ' ') {
                if (cCharAt2 == '#') {
                    do {
                        i = i2;
                        if (i < length) {
                            i2 = i + 1;
                            cCharAt = str.charAt(i);
                            if (cCharAt == '\r') {
                                break;
                            }
                        }
                    } while (cCharAt != '\n');
                } else if (cCharAt2 != '\\' || i2 >= length) {
                    stringBuffer.append(cCharAt2);
                } else {
                    char cCharAt3 = str.charAt(i2);
                    if (cCharAt3 == '#' || cCharAt3 == '\t' || cCharAt3 == '\n' || cCharAt3 == '\f' || cCharAt3 == '\r' || cCharAt3 == ' ') {
                        stringBuffer.append(cCharAt3);
                    } else {
                        stringBuffer.append('\\');
                        stringBuffer.append(cCharAt3);
                    }
                    i += 2;
                }
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    public static final String substring(CharacterIterator characterIterator, int i, int i2) {
        int i4 = i2 - i;
        char[] cArr = new char[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            cArr[i5] = characterIterator.setIndex(i5 + i);
        }
        return new String(cArr);
    }

    public static boolean matches(String str, String str2, String str3) {
        return createRegex(str, str2).matches(str3);
    }
}
