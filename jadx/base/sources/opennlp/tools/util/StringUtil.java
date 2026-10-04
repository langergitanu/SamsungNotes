package opennlp.tools.util;

import java.lang.reflect.Array;
import java.nio.CharBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringUtil {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) StringUtil.class);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void computeShortestEditScript(String str, String str2, int[][] iArr, StringBuffer stringBuffer) {
        int length = iArr.length - 1;
        int length2 = iArr[0].length - 1;
        while (true) {
            int[] iArr2 = iArr[length];
            int i = iArr2[length2];
            if (i == 0) {
                return;
            }
            if (length2 > 0 && length > 0) {
                int i2 = length - 1;
                int i4 = length2 - 1;
                if (iArr[i2][i4] < i) {
                    stringBuffer.append('R');
                    stringBuffer.append(i2);
                    stringBuffer.append(str.charAt(i2));
                    stringBuffer.append(str2.charAt(i4));
                    length2--;
                }
                length--;
            } else if (length2 > 0) {
                int i5 = length2 - 1;
                if (iArr2[i5] < i) {
                    stringBuffer.append('I');
                    stringBuffer.append(length);
                    stringBuffer.append(str2.charAt(i5));
                } else if (length > 0) {
                    int i6 = length - 1;
                    if (iArr[i6][length2] < i) {
                        stringBuffer.append('D');
                        stringBuffer.append(i6);
                        stringBuffer.append(str.charAt(i6));
                    } else if (length > 0 && length2 > 0 && iArr[length - 1][length2 - 1] == i) {
                        length--;
                    } else if (length <= 0 || iArr[length - 1][length2] != i) {
                        if (length2 <= 0 || iArr2[length2 - 1] != i) {
                        }
                    }
                    length--;
                }
                length2--;
            }
        }
    }

    public static String decodeShortestEditScript(String str, String str2) {
        StringBuffer stringBufferReverse = new StringBuffer(str).reverse();
        int i = 0;
        while (str2.length() > i) {
            char cCharAt = str2.charAt(i);
            Logger logger2 = logger;
            if (logger2.isTraceEnabled()) {
                logger2.trace("-> NextOP: {}", Character.valueOf(cCharAt));
            }
            int i2 = i + 1;
            if (cCharAt == 'R') {
                int i4 = Integer.parseInt(Character.toString(str2.charAt(i2)));
                char cCharAt2 = str2.charAt(i + 2);
                char cCharAt3 = str2.charAt(i + 3);
                if (stringBufferReverse.length() <= i4) {
                    return str;
                }
                if (stringBufferReverse.charAt(i4) == cCharAt2) {
                    stringBufferReverse.setCharAt(i4, cCharAt3);
                }
                if (logger2.isTraceEnabled()) {
                    logger2.trace("-> ROP: {}", stringBufferReverse);
                }
                i += 4;
            } else if (cCharAt == 'I') {
                int i5 = Integer.parseInt(Character.toString(str2.charAt(i2)));
                char cCharAt4 = str2.charAt(i + 2);
                if (stringBufferReverse.length() < i5) {
                    return str;
                }
                stringBufferReverse.insert(i5, cCharAt4);
                if (logger2.isTraceEnabled()) {
                    logger2.trace("-> IOP {}", stringBufferReverse);
                }
                i += 3;
            } else if (cCharAt == 'D') {
                int i6 = Integer.parseInt(Character.toString(str2.charAt(i2)));
                if (stringBufferReverse.length() <= i6) {
                    return str;
                }
                stringBufferReverse.deleteCharAt(i6);
                i += 3;
            } else {
                i = i2;
            }
        }
        return stringBufferReverse.reverse().toString();
    }

    public static String getShortestEditScript(String str, String str2) {
        String string = new StringBuffer(str.toLowerCase()).reverse().toString();
        String string2 = new StringBuffer(str2.toLowerCase()).reverse().toString();
        StringBuffer stringBuffer = new StringBuffer();
        if (string.equals(string2)) {
            return "O";
        }
        computeShortestEditScript(string, string2, levenshteinDistance(string, string2), stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.getType(c) == 12;
    }

    public static int[][] levenshteinDistance(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int i = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length + 1, length2 + 1);
        if (length != 0 && length2 != 0) {
            for (int i2 = 0; i2 <= length; i2++) {
                iArr[i2][0] = i2;
            }
            for (int i4 = 0; i4 <= length2; i4++) {
                iArr[0][i4] = i4;
            }
            int i5 = 1;
            while (i5 <= length) {
                int i6 = i5 - 1;
                char cCharAt = str.charAt(i6);
                int i7 = 1;
                while (i7 <= length2) {
                    int i8 = i7 - 1;
                    int i9 = cCharAt == str2.charAt(i8) ? i : 1;
                    int[] iArr2 = iArr[i5];
                    int[] iArr3 = iArr[i6];
                    iArr2[i7] = minimum(iArr3[i7] + 1, iArr2[i8] + 1, iArr3[i8] + i9);
                    i7++;
                    i = 0;
                }
                i5++;
                i = 0;
            }
        }
        return iArr;
    }

    private static int minimum(int i, int i2, int i4) {
        if (i2 < i) {
            i = i2;
        }
        return i4 < i ? i4 : i;
    }

    public static String toLowerCase(CharSequence charSequence) {
        int[] array = charSequence.codePoints().map(new C13651a()).toArray();
        return new String(array, 0, array.length);
    }

    public static CharBuffer toLowerCaseCharBuffer(CharSequence charSequence) {
        CharBuffer charBufferAllocate = CharBuffer.allocate(charSequence.length());
        for (int i : charSequence.codePoints().toArray()) {
            for (char c : Character.toChars(Character.toLowerCase(i))) {
                charBufferAllocate.append(c);
            }
        }
        return charBufferAllocate;
    }

    public static String toUpperCase(CharSequence charSequence) {
        char[] cArr = new char[charSequence.length()];
        for (int i = 0; i < charSequence.length(); i++) {
            cArr[i] = Character.toUpperCase(charSequence.charAt(i));
        }
        return new String(cArr);
    }

    public static boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || Character.getType(i) == 12;
    }
}
