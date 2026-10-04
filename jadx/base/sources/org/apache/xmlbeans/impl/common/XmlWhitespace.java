package org.apache.xmlbeans.impl.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlWhitespace {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    public static String collapse(String str) {
        return collapse(str, 3);
    }

    public static boolean isAllSpace(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        if (r1.charAt(r4 - 1) == ' ') goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String collapse(String str, int i) {
        int length;
        int i2;
        int i4;
        if (i == 1 || i == 0) {
            return str;
        }
        if (str.indexOf(10) >= 0) {
            str = str.replace('\n', ' ');
        }
        if (str.indexOf(9) >= 0) {
            str = str.replace('\t', ' ');
        }
        if (str.indexOf(13) >= 0) {
            str = str.replace('\r', ' ');
        }
        String str2 = str;
        if (i != 2 && (length = str2.length()) != 0) {
            if (str2.charAt(0) != ' ') {
                i2 = 2;
                while (true) {
                    if (i2 < length) {
                        if (str2.charAt(i2) == ' ') {
                            if (str2.charAt(i2 - 1) == ' ' || i2 == length - 1) {
                                break;
                            }
                            i2++;
                            if (str2.charAt(i2) == ' ') {
                                break;
                            }
                        }
                        i2 += 2;
                    } else if (i2 == length) {
                    }
                }
                i4 = i2;
            } else {
                i2 = 0;
                while (true) {
                    int i5 = i2 + 1;
                    if (i5 >= str2.length() || str2.charAt(i5) != ' ') {
                        break;
                    }
                    i2 = i5;
                }
                i4 = 0;
            }
            char[] charArray = str2.toCharArray();
            loop1: while (true) {
                i2++;
                if (i2 >= length) {
                    break;
                }
                if (str2.charAt(i2) != ' ') {
                    while (true) {
                        int i6 = i4 + 1;
                        int i7 = i2 + 1;
                        charArray[i4] = charArray[i2];
                        if (i7 >= length) {
                            i4 = i6;
                            break loop1;
                        }
                        char c = charArray[i7];
                        if (c == ' ') {
                            i4 += 2;
                            i2 += 2;
                            charArray[i6] = c;
                            if (i2 >= length) {
                                break loop1;
                            }
                            if (charArray[i2] == ' ') {
                                break;
                            }
                        } else {
                            i4 = i6;
                            i2 = i7;
                        }
                    }
                }
            }
            if (i4 != 0) {
                int i8 = i4 - 1;
                if (charArray[i8] == ' ') {
                    i4 = i8;
                }
            }
            return new String(charArray, 0, i4);
        }
        return str2;
    }

    public static boolean isAllSpace(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
