package com.samsung.android.ocr.stride.postocr.entity;

import android.graphics.Point;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PhoneNumberCorrection extends CorrectionBase {
    private static final int GROUP_COMMA_PHONE = 1;
    private static final int GROUP_ZERO_BRACKETS = 3;
    private static final int PHONE_CNTRY_CODE_MAX_DIGITS = 15;
    private static final int PHONE_CNTRY_CODE_MIN_DIGITS = 11;
    private static final int PHONE_MAX_DIGITS = 12;
    private static final int PHONE_MIN_DIGITS = 10;
    private static final String PHONE_PREFIX = "mobile|mob|m\\.p\\.|m\\.p|phone|ph|phn|tel|fax";
    private static final String TAG = "PhoneNumberCorrection";
    private static final String REGEX_NO_SPACE_CORRECTION = "(?:^|\\s)([mft](:?))(\\+)(\\d{1,3})\\s*([()0O\\[\\]]{3})\\s*(\\d+)\\s";
    private static final Pattern PAT_REGEX_NO_SPACE_CORRECTION = Pattern.compile(REGEX_NO_SPACE_CORRECTION, 2);
    private static final String REGEX_COMMA_PHONE = "(?:mobile|mob|m\\.p\\.|m\\.p|phone|ph|phn|tel|fax)(?:\\s*:?\\s*)(\\+(\\d){1,3}\\s*(\\.|,)(([\\s0-9]+)\\s*(\\.|,)\\s*){2}\\d+)(?:$|\\s|,|\\.)";
    private static final Pattern PAT_COMMA_PHONE = Pattern.compile(REGEX_COMMA_PHONE, 2);
    private static final String REGEX_PHONE_BASIC1 = "(?<!\\d)(\\+\\s*)?(\\d){1,3}\\s*(-|\\.)\\s*(\\d){1,3}\\s*(-|\\.)\\s*(\\d)+";
    private static final Pattern PAT_REGEX_PHONE_BASIC1 = Pattern.compile(REGEX_PHONE_BASIC1, 2);
    private static final String REGEX_PHONE_BASIC2 = "(\\+)\\s*(\\d){1,3}\\s*([()0O\\[\\]]{3})\\s*(\\d)+\\s*(\\d)+";
    private static final Pattern PAT_REGEX_PHONE_BASIC2 = Pattern.compile(REGEX_PHONE_BASIC2, 2);
    private static final String REGEX_PHONE_BASIC3 = "(?<!\\d)(((\\d{1,3})(\\s\\d)?(-))(\\d{2,4})((-)?)(\\d{2,6}))(?!\\d)";
    private static final Pattern PAT_REGEX_PHONE_BASIC3 = Pattern.compile(REGEX_PHONE_BASIC3, 2);
    private static final String REGEX_PHONE_BASIC4 = "(?<![\\d-])(\\d{1,3})(-)(\\d{1,2})(-)((\\d|\\s){3,5})(-)((\\d|\\s){3,6})";
    private static final Pattern PAT_REGEX_PHONE_BASIC4 = Pattern.compile(REGEX_PHONE_BASIC4, 2);

    private static void correctPhoneNumberZeroBracket(MOCRResult.Line line, Matcher matcher, int i, int i2) {
        String strGroup = matcher.group(3);
        if (strGroup == null || strGroup.equals("(0)")) {
            return;
        }
        while (i <= i2) {
            MOCRResult.Word word = line.words[i];
            if (word.wordText.contains(strGroup)) {
                int iIndexOf = word.wordText.indexOf(strGroup);
                String str = TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(iIndexOf, "Zero correction at pos ", " in word ");
                sbM778t.append(word.wordText);
                MOCRLog.m5683d(str, sbM778t.toString());
                if (iIndexOf != -1) {
                    String str2 = word.wordText.substring(0, iIndexOf) + "(0)" + word.wordText.substring(iIndexOf + 3);
                    word.wordText = str2;
                    if (word.chars == null) {
                        word.charCount = str2.length();
                    } else {
                        ArrayList arrayList = new ArrayList(Arrays.asList(word.chars));
                        ((MOCRResult.Char) arrayList.get(iIndexOf)).unicode = 40;
                        ((MOCRResult.Char) arrayList.get(iIndexOf + 1)).unicode = 48;
                        ((MOCRResult.Char) arrayList.get(iIndexOf + 2)).unicode = 41;
                        MOCRResult.Char[] charArr = (MOCRResult.Char[]) arrayList.toArray(new MOCRResult.Char[0]);
                        word.chars = charArr;
                        word.charCount = charArr.length;
                    }
                    MOCRLog.m5683d(str, "Post OCR Phone Zero bracket correction");
                    return;
                }
                return;
            }
            i++;
        }
    }

    private static void splitPhonePrefix(MOCRResult.Line line, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(line.words[i2]);
        }
        MOCRResult.Word word = line.words[i];
        boolean z = word.chars != null;
        String str = word.wordText;
        int iIndexOf = str.indexOf(43);
        if (iIndexOf != -1) {
            int i4 = word.charCount;
            MOCRResult.Word word2 = new MOCRResult.Word();
            word2.wordText = str.substring(0, iIndexOf);
            MOCRResult.Word word3 = new MOCRResult.Word();
            word3.wordText = str.substring(iIndexOf);
            if (z) {
                word2.wRect = new Point[]{charArr[0].cRect[0], charArr[i].cRect[1], charArr[i].cRect[2], charArr[0].cRect[3]};
                MOCRResult.Char[] charArr = word.chars;
                int i5 = iIndexOf - 1;
                word3.wRect = new Point[]{charArr[iIndexOf].cRect[0], charArr[i].cRect[1], charArr[i].cRect[2], charArr[iIndexOf].cRect[3]};
                int i6 = i4 - 1;
            } else {
                word2.wRect = (Point[]) word.wRect.clone();
                word3.wRect = (Point[]) word.wRect.clone();
            }
            float f = word.conf / word.charCount;
            word2.conf = word2.wordText.length() * f;
            word3.conf = word3.wordText.length() * f;
            if (z) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i7 = 0; i7 < i4; i7++) {
                    MOCRResult.Char r13 = word.chars[i7];
                    if (i7 < iIndexOf) {
                        arrayList2.add(r13);
                    } else {
                        arrayList3.add(r13);
                    }
                }
                word2.chars = (MOCRResult.Char[]) arrayList2.toArray(new MOCRResult.Char[0]);
                MOCRResult.Char[] charArr2 = (MOCRResult.Char[]) arrayList3.toArray(new MOCRResult.Char[0]);
                word3.chars = charArr2;
                word2.charCount = word2.chars.length;
                word3.charCount = charArr2.length;
            } else {
                word2.chars = null;
                word3.chars = null;
                word2.charCount = word2.wordText.length();
                word3.charCount = word3.wordText.length();
            }
            arrayList.add(word2);
            arrayList.add(word3);
        }
        for (int i8 = i + 1; i8 < line.wordCount; i8++) {
            arrayList.add(line.words[i8]);
        }
        MOCRResult.Word[] wordArr = (MOCRResult.Word[]) arrayList.toArray(new MOCRResult.Word[0]);
        line.words = wordArr;
        line.wordCount = wordArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void validatePhoneLine(MOCRResult.Page page) {
        boolean z;
        boolean z2;
        int[] matchingIds;
        int i;
        int i2;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_COMMA_PHONE.matcher(text);
                while (true) {
                    z = false;
                    while (matcher.find()) {
                        String str = TAG;
                        StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_COMMA_PHONE match: ");
                        sbM2227r.append(matcher.group(1));
                        MOCRLog.m5683d(str, sbM2227r.toString());
                        if (validatePhoneNumber(matcher.group().replaceAll("\\D", "").length(), true)) {
                            int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher, line, 1);
                            int i4 = matchingIds2[2];
                            int i5 = matchingIds2[3];
                            if (i4 <= i5) {
                                CorrectionBase.joinWords(line, i4, i5, CorrectionBase.RegexActions.REPLACE_COMMA_IN_PHONE_NUMBER);
                                MOCRLog.m5685i(str, "Post OCR Entity Validation");
                            }
                            z = true;
                        }
                    }
                }
                if (!z) {
                    Matcher matcher2 = PAT_REGEX_PHONE_BASIC1.matcher(text);
                    while (matcher2.find()) {
                        String str2 = TAG;
                        StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_REGEX_PHONE_BASIC1 match: ");
                        sbM2227r2.append(matcher2.group());
                        MOCRLog.m5683d(str2, sbM2227r2.toString());
                        if (validatePhoneNumber(matcher2.group().replaceAll("\\D", "").length(), true)) {
                            int[] matchingIds3 = CorrectionBase.getMatchingIds(matcher2, line);
                            int i6 = matchingIds3[2];
                            int i7 = matchingIds3[3];
                            if (i6 < i7) {
                                CorrectionBase.joinWords(line, i6, i7);
                                MOCRLog.m5685i(str2, "Post OCR Entity Validation");
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
                if (!z) {
                    Matcher matcher3 = PAT_REGEX_PHONE_BASIC2.matcher(text);
                    if (matcher3.find()) {
                        String str3 = TAG;
                        StringBuilder sbM2227r3 = AbstractC2821a.m2227r("Original line :: ", text, str3, "PAT_REGEX_PHONE_BASIC2 match: ");
                        sbM2227r3.append(matcher3.group());
                        MOCRLog.m5683d(str3, sbM2227r3.toString());
                        int[] matchingIds4 = CorrectionBase.getMatchingIds(matcher3, line);
                        correctPhoneNumberZeroBracket(line, matcher3, matchingIds4[2], matchingIds4[3]);
                        MOCRLog.m5685i(str3, "Post OCR Entity Validation");
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                if (!z2) {
                    Matcher matcher4 = PAT_REGEX_PHONE_BASIC3.matcher(text);
                    if (matcher4.find()) {
                        String str4 = TAG;
                        StringBuilder sbM2227r4 = AbstractC2821a.m2227r("Original line :: ", text, str4, "PAT_REGEX_PHONE_BASIC3 match: ");
                        sbM2227r4.append(matcher4.group());
                        MOCRLog.m5683d(str4, sbM2227r4.toString());
                        z2 = false;
                        if (validatePhoneNumber(matcher4.group().replaceAll("\\D", "").length(), false)) {
                            int[] matchingIds5 = CorrectionBase.getMatchingIds(matcher4, line);
                            int i8 = matchingIds5[2];
                            int i9 = matchingIds5[3];
                            if (i8 < i9) {
                                CorrectionBase.joinWords(line, i8, i9);
                                MOCRLog.m5685i(str4, "Post OCR Entity Validation");
                            }
                            z2 = true;
                        }
                    }
                }
                if (!z2) {
                    Matcher matcher5 = PAT_REGEX_PHONE_BASIC4.matcher(text);
                    if (matcher5.find()) {
                        String str5 = TAG;
                        StringBuilder sbM2227r5 = AbstractC2821a.m2227r("Original line :: ", text, str5, "PAT_REGEX_PHONE_BASIC4 match: ");
                        sbM2227r5.append(matcher5.group());
                        MOCRLog.m5683d(str5, sbM2227r5.toString());
                        if (validatePhoneNumber(matcher5.group().replaceAll("\\D", "").length(), true) && (i = (matchingIds = CorrectionBase.getMatchingIds(matcher5, line))[2]) < (i2 = matchingIds[3])) {
                            CorrectionBase.joinWords(line, i, i2);
                            MOCRLog.m5685i(str5, "Post OCR Entity Validation");
                        }
                    }
                }
            }
        }
    }

    private static boolean validatePhoneNumber(int i, boolean z) {
        return z ? i >= 11 && i <= 15 : i >= 10 && i <= 12;
    }
}
