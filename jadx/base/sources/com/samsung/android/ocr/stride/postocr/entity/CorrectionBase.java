package com.samsung.android.ocr.stride.postocr.entity;

import android.graphics.Point;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CorrectionBase {
    private static final String TAG = "CorrectionBase";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RegexActions {
        REPLACE_COMMA_IN_PHONE_NUMBER,
        REPLACE_COMMA_IN_EMAIL_OR_URL,
        REPLACE_DOUBLE_IN_EMAIL,
        REPLACE_DOUBLE_IN_URL,
        REPLACE_COMMA_MULTIPLE_IN_URL,
        REPLACE_SQUARE_BRACKET_IN_PHONE_NUMBER,
        ADD_SPACE_IN_TELPHONE_FAX,
        ADD_SPACE_IN_PHONE,
        REPLACE_O_IN_DATETIME,
        REPLACE_SUPERSCRIPT_2_IN_UNITS,
        REPLACE_SUPERSCRIPT_3_IN_UNITS
    }

    public static int[] getMatchingIds(Matcher matcher, MOCRResult.Line line) {
        return getMatchingIds(matcher, line, 0);
    }

    public static void joinWords(MOCRResult.Line line, int i, int i2) {
        joinWords(line, i, i2, null);
    }

    public static void replaceCharInWord(MOCRResult.Line line, int i, RegexActions regexActions) {
        replaceCharInWord(line, i, regexActions, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] getMatchingIds(Matcher matcher, MOCRResult.Line line, int i) {
        int i2;
        int i4;
        int iIndexOf;
        int length;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (i != 0) {
            String strGroup = matcher.group(i);
            if (strGroup != null) {
                iIndexOf = line.getText().indexOf(strGroup);
                if (strGroup.isEmpty()) {
                    i2 = iIndexOf;
                } else {
                    length = strGroup.length() + iIndexOf;
                }
            } else {
                i2 = -1;
            }
            i4 = i2;
            i5 = 0;
            i6 = 0;
            while (true) {
                if (i5 < line.wordCount) {
                    i7 = -1;
                    i8 = -1;
                    break;
                }
                i13 = line.words[i5].charCount;
                if (i13 + i6 >= i2) {
                    i8 = i2 - i6;
                    i7 = i5;
                    break;
                }
                i6 = i6 + i13 + 1;
                i5++;
            }
            i9 = i7;
            while (true) {
                if (i9 < line.wordCount) {
                    i10 = -1;
                    i11 = -1;
                    break;
                }
                i12 = line.words[i9].charCount;
                if (i12 + i6 >= i4) {
                    i10 = i9;
                    i11 = i4 - i6;
                    break;
                }
                i6 = i6 + i12 + 1;
                i9++;
            }
            MOCRLog.m5683d(TAG, i2 + " - " + i4 + " - " + i7 + " " + i10);
            return new int[]{i2, i4, i7, i10, i8, i11};
        }
        iIndexOf = matcher.start();
        length = matcher.end();
        i4 = length;
        i2 = iIndexOf;
        i5 = 0;
        i6 = 0;
        while (true) {
            if (i5 < line.wordCount) {
            }
            i6 = i6 + i13 + 1;
            i5++;
        }
        i9 = i7;
        while (true) {
            if (i9 < line.wordCount) {
            }
            i6 = i6 + i12 + 1;
            i9++;
        }
        MOCRLog.m5683d(TAG, i2 + " - " + i4 + " - " + i7 + " " + i10);
        return new int[]{i2, i4, i7, i10, i8, i11};
    }

    public static void joinWords(MOCRResult.Line line, int i, int i2, RegexActions regexActions) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < i; i4++) {
            arrayList.add(line.words[i4]);
        }
        boolean z = line.words[i].chars != null;
        MOCRResult.Word word = new MOCRResult.Word();
        word.wRect = new Point[]{pointArr[0], pointArr[1], pointArr[2], pointArr[3]};
        MOCRResult.Word[] wordArr = line.words;
        MOCRResult.Word word2 = wordArr[i];
        MOCRResult.Word word3 = wordArr[i2];
        Point[] pointArr = word2.wRect;
        Point[] pointArr2 = word3.wRect;
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        float f = 0.0f;
        for (int i5 = i; i5 <= i2; i5++) {
            MOCRResult.Word word4 = line.words[i5];
            sb.append(word4.wordText);
            f += word4.conf;
            if (z) {
                arrayList2.addAll(Arrays.asList(word4.chars));
            }
        }
        if (regexActions == RegexActions.REPLACE_COMMA_IN_PHONE_NUMBER) {
            for (int iIndexOf4 = sb.indexOf(","); iIndexOf4 >= 0; iIndexOf4 = sb.indexOf(",", iIndexOf4 + 1)) {
                if (iIndexOf4 != 0 && iIndexOf4 != sb.length() - 1) {
                    sb.setCharAt(iIndexOf4, '.');
                    if (z) {
                        ((MOCRResult.Char) arrayList2.get(iIndexOf4)).unicode = 46;
                    }
                }
            }
        }
        if (regexActions == RegexActions.REPLACE_SQUARE_BRACKET_IN_PHONE_NUMBER && (iIndexOf3 = sb.indexOf("]")) != -1) {
            sb.setCharAt(iIndexOf3, PropertyUtils.MAPPED_DELIM2);
            if (z) {
                ((MOCRResult.Char) arrayList2.get(iIndexOf3)).unicode = 41;
            }
        }
        if (regexActions == RegexActions.REPLACE_COMMA_IN_EMAIL_OR_URL && (iIndexOf2 = sb.indexOf(",")) != -1) {
            sb.setCharAt(iIndexOf2, '.');
            if (z) {
                ((MOCRResult.Char) arrayList2.get(iIndexOf2)).unicode = 46;
            }
        }
        if (regexActions == RegexActions.REPLACE_DOUBLE_IN_EMAIL && (iIndexOf = sb.indexOf("..")) != -1) {
            sb.deleteCharAt(iIndexOf);
            if (z) {
                arrayList2.remove(iIndexOf);
            }
        }
        if (regexActions == RegexActions.REPLACE_DOUBLE_IN_URL) {
            int iIndexOf5 = sb.indexOf("..");
            if (iIndexOf5 != -1) {
                sb.deleteCharAt(iIndexOf5);
                if (z) {
                    arrayList2.remove(iIndexOf5);
                }
            }
            int iIndexOf6 = sb.indexOf("::");
            if (iIndexOf6 != -1) {
                sb.deleteCharAt(iIndexOf6);
                if (z) {
                    arrayList2.remove(iIndexOf6);
                }
            }
        }
        if (regexActions == RegexActions.REPLACE_COMMA_MULTIPLE_IN_URL) {
            for (int iIndexOf7 = sb.indexOf(","); iIndexOf7 >= 0; iIndexOf7 = sb.indexOf(",", iIndexOf7 + 1)) {
                if (iIndexOf7 != 0 && iIndexOf7 != sb.length() - 1) {
                    sb.setCharAt(iIndexOf7, '.');
                    if (z) {
                        ((MOCRResult.Char) arrayList2.get(iIndexOf7)).unicode = 46;
                    }
                }
            }
        }
        if (regexActions == RegexActions.REPLACE_O_IN_DATETIME) {
            for (int iIndexOf8 = sb.indexOf("O"); iIndexOf8 >= 0; iIndexOf8 = sb.indexOf("O", iIndexOf8 + 1)) {
                if (iIndexOf8 != 0 && iIndexOf8 != sb.length() - 1) {
                    sb.setCharAt(iIndexOf8, '0');
                    if (z) {
                        ((MOCRResult.Char) arrayList2.get(iIndexOf8)).unicode = 48;
                    }
                }
            }
            for (int iIndexOf9 = sb.indexOf("o"); iIndexOf9 >= 0; iIndexOf9 = sb.indexOf("o", iIndexOf9 + 1)) {
                sb.setCharAt(iIndexOf9, '0');
                if (z) {
                    ((MOCRResult.Char) arrayList2.get(iIndexOf9)).unicode = 48;
                }
            }
        }
        String string = sb.toString();
        word.wordText = string;
        word.conf = f / ((i2 - i) + 1);
        if (z) {
            MOCRResult.Char[] charArr = (MOCRResult.Char[]) arrayList2.toArray(new MOCRResult.Char[0]);
            word.chars = charArr;
            word.charCount = charArr.length;
        } else {
            word.chars = null;
            word.charCount = string.length();
        }
        arrayList.add(word);
        for (int i6 = i2 + 1; i6 < line.wordCount; i6++) {
            arrayList.add(line.words[i6]);
        }
        MOCRResult.Word[] wordArr2 = (MOCRResult.Word[]) arrayList.toArray(new MOCRResult.Word[0]);
        line.words = wordArr2;
        line.wordCount = wordArr2.length;
    }

    public static void replaceCharInWord(MOCRResult.Line line, int i, RegexActions regexActions, String str) {
        int iLastIndexOf;
        MOCRResult.Word word = line.words[i];
        boolean z = word.chars != null;
        StringBuilder sb = new StringBuilder(word.wordText);
        if (regexActions == RegexActions.REPLACE_SUPERSCRIPT_2_IN_UNITS) {
            if (str == null || str.isEmpty()) {
                str = "2";
            }
            int iLastIndexOf2 = sb.lastIndexOf(str);
            if (iLastIndexOf2 != -1) {
                sb.setCharAt(iLastIndexOf2, (char) 178);
                line.words[i].wordText = sb.toString();
                if (z) {
                    line.words[i].chars[iLastIndexOf2].unicode = 178;
                }
            }
        }
        if (regexActions != RegexActions.REPLACE_SUPERSCRIPT_3_IN_UNITS || (iLastIndexOf = sb.lastIndexOf("3")) == -1) {
            return;
        }
        sb.setCharAt(iLastIndexOf, (char) 179);
        line.words[i].wordText = sb.toString();
        if (z) {
            line.words[i].chars[iLastIndexOf].unicode = 179;
        }
    }
}
