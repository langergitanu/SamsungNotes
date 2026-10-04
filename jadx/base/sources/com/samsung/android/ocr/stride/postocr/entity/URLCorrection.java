package com.samsung.android.ocr.stride.postocr.entity;

import android.graphics.Point;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p075S.C0255g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class URLCorrection extends CorrectionBase {
    private static final String DOMAIN_EXTNS = "(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)";
    private static final String HTTP_SYMBOL_VARIATIONS = "(([.:;\\s]{1,3})([/1l])?(/))";
    private static final String HTTP_VARIATIONS = "((http|nttp|ntip|htip|htto|httr|htp)(s)?)";
    private static final String TAG = "URLCorrection";
    private static final String WWW_VARIATIONS = "(www|vww)";
    private static final String REGEX_HTTP_SPACE_COMMA = "((http|nttp|ntip|htip|htto|httr|htp)(s)?)(([.:;\\s]{1,3})([/1l])?(/))(www)(\\.|\\s)+((([a-zA-Z0-9-]+)(\\s)*(,)(\\s)*)+)(\\s)*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)";
    private static final Pattern PAT_HTTP_SPACE_COMMA = Pattern.compile(REGEX_HTTP_SPACE_COMMA, 2);
    private static final String REGEX_URL_COMMA_WO_SPACE = "((www)\\s*(,)\\s*([a-zA-Z0-9-.]+)\\s*([,.])\\s*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog))|((www)\\s*([,.])\\s*([a-zA-Z0-9-._]+)\\s*(,)\\s*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog))";
    private static final Pattern PAT_URL_COMMA_WO_SPACE = Pattern.compile(REGEX_URL_COMMA_WO_SPACE, 2);
    private static final String REGEX_URL_COMMA = "(www)(\\s)*(,)(\\s)*([a-zA-Z0-9-.]+)(\\s)*(,)(\\s)*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)";
    private static final Pattern PAT_URL_COMMA = Pattern.compile(REGEX_URL_COMMA, 2);
    private static final String REGEX_URL_HTTP_BASIC = "((http|nttp|ntip|htip|htto|httr|htp)(s)?)(([.:;\\s]{1,3})([/1l])?(/))(((([a-zA-Z0-9-]+)\\s*(\\.)\\s*(\\.)?\\s*)+)(\\s)*(\\.)?(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog))";
    private static final Pattern PAT_URL_HTTP_BASIC = Pattern.compile(REGEX_URL_HTTP_BASIC, 2);
    private static final String REGEX_URL_WWW_BASIC = "(www|vww)(\\s)*(.)+(\\s)*((([a-zA-Z0-9-]+)\\s*(\\.)\\s*(\\.)?\\s*)+)(\\s)*(\\.)?(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)";
    private static final Pattern PAT_URL_WWW_BASIC = Pattern.compile(REGEX_URL_WWW_BASIC, 2);
    private static final String REGEX_URL_BASIC = "\b((([a-zA-Z0-9-]+)\\s*(\\.)\\s*(\\.)?\\s*){2,3})(\\s)*(\\.)?(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)";
    private static final Pattern PAT_URL_BASIC = Pattern.compile(REGEX_URL_BASIC, 2);
    private static final String REGEX_STRICT_DOMAIN = "(?<=^|\\s)((([a-zA-Z0-9-]+)\\s*(\\.)\\s*(\\.)?\\s*)+)(\\s)*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|blog)(?=($|\\s|/))";
    private static final Pattern PAT_STRICT_DOMAIN = Pattern.compile(REGEX_STRICT_DOMAIN, 2);
    private static final String REGEX_WEB_PAGE_URL = "(?<!\\/)((\\s*\\/\\s*([a-zA-Z0-9-_]+))+)((\\s*(\\.)\\s*[a-zA-Z]{2,4})|(\\s*(\\?)\\s*)[A-Za-z0-9-_#=+&$%();\\p{InHangul_Syllables}\\p{InCJK_Unified_Ideographs}]+)?";
    private static final Pattern PAT_WEB_PAGE_URL = Pattern.compile(REGEX_WEB_PAGE_URL, 2);
    private static String[] FIND_DOMAIN = {"Inkd.in", "inkd.in"};
    private static String[] REPLACE_DOMAIN = {"lnkd.in", "lnkd.in"};
    private static int GROUP_URL_HTTP = 1;
    private static int GROUP_URL_HTTP_SYMBOLS = 4;
    private static int GROUP_URL_HTTP_POPULAR_DOMAIN = 8;

    private static void correctDomainName(MOCRResult.Line line, int i, Matcher matcher, int i2) {
        int iIndexOf;
        if (matcher == null) {
            return;
        }
        MOCRResult.Word[] wordArr = line.words;
        if (i >= wordArr.length) {
            return;
        }
        MOCRResult.Word word = wordArr[i];
        String strGroup = matcher.group(i2);
        if (strGroup == null || (iIndexOf = word.wordText.indexOf(strGroup)) == -1) {
            return;
        }
        int length = strGroup.length() + iIndexOf;
        StringBuilder sb = new StringBuilder();
        sb.append(word.wordText.substring(0, iIndexOf));
        int i4 = 0;
        while (true) {
            String[] strArr = FIND_DOMAIN;
            if (i4 >= strArr.length) {
                return;
            }
            if (strGroup.equals(strArr[i4])) {
                sb.append(REPLACE_DOMAIN[i4]);
                word.wordText = AbstractC4539a.m3198h(sb, word.wordText, length);
                MOCRResult.Char[] charArr = word.chars;
                if (charArr != null && charArr.length > 0) {
                    for (int i5 = 0; i5 < word.wordText.length(); i5++) {
                        word.chars[i5].unicode = word.wordText.charAt(i5);
                    }
                }
                MOCRLog.m5683d(TAG, "Domain corrected :: " + word.getText());
                return;
            }
            i4++;
        }
    }

    private static void correctHttpPrefix(MOCRResult.Line line, int i, Matcher matcher) {
        if (matcher == null) {
            return;
        }
        MOCRResult.Word[] wordArr = line.words;
        if (i >= wordArr.length) {
            return;
        }
        MOCRResult.Word word = wordArr[i];
        String strGroup = matcher.group(GROUP_URL_HTTP);
        if (strGroup == null) {
            return;
        }
        int iIndexOf = word.wordText.indexOf(strGroup);
        int length = strGroup.length() + iIndexOf;
        if (!strGroup.equalsIgnoreCase("http") && !strGroup.equalsIgnoreCase(AuthenticationConstants.HTTPS_PROTOCOL_STRING) && iIndexOf != -1) {
            String str = TAG;
            MOCRLog.m5683d(str, strGroup + " " + iIndexOf + " " + length);
            String str2 = word.wordText;
            String str3 = strGroup.endsWith("s") ? AuthenticationConstants.HTTPS_PROTOCOL_STRING : "http";
            StringBuilder sb = new StringBuilder();
            sb.append(str2.substring(0, iIndexOf));
            sb.append(str3);
            String strM3198h = AbstractC4539a.m3198h(sb, str2, length);
            word.wordText = strM3198h;
            word.charCount = strM3198h.length();
            MOCRLog.m5683d(str, "Http Word Correction :: " + line.getText());
        }
        String strGroup2 = matcher.group(GROUP_URL_HTTP_SYMBOLS);
        if (strGroup2 == null) {
            return;
        }
        String strReplaceAll = strGroup2.replaceAll("\\s", "");
        int iIndexOf2 = word.wordText.indexOf(strReplaceAll);
        int length2 = strReplaceAll.length() + iIndexOf2;
        if (strReplaceAll.equalsIgnoreCase("://") || iIndexOf2 == -1) {
            return;
        }
        MOCRLog.m5683d(TAG, strReplaceAll + " " + iIndexOf2 + " " + length2);
        int iCount = length2 - ((int) strReplaceAll.chars().filter(new C0255g(1)).count());
        String str4 = word.wordText;
        int length3 = strReplaceAll.length();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4.substring(0, iIndexOf2));
        sb2.append("://");
        String strM3198h2 = AbstractC4539a.m3198h(sb2, str4, iCount);
        word.wordText = strM3198h2;
        if (word.chars == null) {
            word.charCount = strM3198h2.length();
        } else {
            ArrayList arrayList = new ArrayList(Arrays.asList(word.chars));
            MOCRResult.Char r2 = (MOCRResult.Char) arrayList.get(iIndexOf2);
            MOCRResult.Char r32 = (MOCRResult.Char) arrayList.get(iIndexOf2 + 1);
            int i2 = iIndexOf2 + 2;
            MOCRResult.Char r5 = (MOCRResult.Char) arrayList.get(i2);
            if (length3 < 3) {
                r2.unicode = 58;
                r32.unicode = 47;
                MOCRResult.Char r13 = new MOCRResult.Char();
                r13.unicode = 47;
                r13.cRect = (Point[]) r32.cRect.clone();
                arrayList.add(i2, r13);
            } else if (length3 == 3) {
                r2.unicode = 58;
                r32.unicode = 47;
                r5.unicode = 47;
            } else {
                r2.unicode = 58;
                r32.unicode = 47;
                r5.unicode = 47;
                for (int i4 = 0; i4 < length3 - 3; i4++) {
                    arrayList.remove(iIndexOf2 + 3 + i4);
                }
            }
            MOCRResult.Char[] charArr = (MOCRResult.Char[]) arrayList.toArray(new MOCRResult.Char[0]);
            word.chars = charArr;
            word.charCount = charArr.length;
        }
        MOCRLog.m5683d(TAG, "Http Symbol Correction :: " + line.getText());
    }

    private static void correctWwwDot(MOCRResult.Line line, int i) {
        int iIndexOf;
        MOCRResult.Word word = line.words[i];
        String str = word.wordText;
        if (str.indexOf("www.") == -1 && (iIndexOf = str.indexOf("www")) != -1) {
            StringBuilder sb = new StringBuilder();
            int i2 = iIndexOf + 3;
            sb.append(str.substring(0, i2));
            sb.append(Extension.DOT);
            String strM3198h = AbstractC4539a.m3198h(sb, str, i2);
            word.wordText = strM3198h;
            if (word.chars == null) {
                word.charCount = strM3198h.length();
                return;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(word.chars));
            MOCRResult.Char r02 = (MOCRResult.Char) arrayList.get(iIndexOf + 2);
            MOCRResult.Char r12 = new MOCRResult.Char();
            r12.unicode = 46;
            r12.cRect = (Point[]) r02.cRect.clone();
            arrayList.add(i2, r12);
            MOCRResult.Char[] charArr = (MOCRResult.Char[]) arrayList.toArray(new MOCRResult.Char[0]);
            word.chars = charArr;
            word.charCount = charArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$correctHttpPrefix$0(int i) {
        return i == 32;
    }

    private static void validatePageURL(MOCRResult.Line line, int i) {
        String text = line.getText();
        validateWwwCase(line.words[i]);
        Matcher matcher = PAT_WEB_PAGE_URL.matcher(text);
        if (matcher.find()) {
            String str = TAG;
            StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_WEB_PAGE_URL match: ");
            sbM2227r.append(matcher.group());
            MOCRLog.m5683d(str, sbM2227r.toString());
            int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line);
            int i2 = matchingIds[2];
            int i4 = matchingIds[3];
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, "Page ids: ", " ", " ");
            sbM1173s.append(i);
            MOCRLog.m5683d(str, sbM1173s.toString());
            if ((i2 == i || i2 == i + 1) && i2 <= i4) {
                CorrectionBase.joinWords(line, i, i4);
            }
            MOCRLog.m5683d(str, "Updated line :: " + line.getText());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void validateURLLine(MOCRResult.Page page) {
        char c;
        char c2;
        boolean z;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_HTTP_SPACE_COMMA.matcher(text);
                boolean z2 = true;
                if (matcher.find()) {
                    String str = TAG;
                    StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_HTTP_SPACE_COMMA match: ");
                    c2 = 3;
                    sbM2227r.append(matcher.group());
                    MOCRLog.m5683d(str, sbM2227r.toString());
                    int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line);
                    int i = matchingIds[2];
                    int i2 = matchingIds[3];
                    c = 2;
                    if (i <= i2) {
                        CorrectionBase.joinWords(line, i, i2, CorrectionBase.RegexActions.REPLACE_COMMA_IN_EMAIL_OR_URL);
                    }
                    correctHttpPrefix(line, i, matcher);
                    correctWwwDot(line, i);
                    validatePageURL(line, i);
                    MOCRLog.m5685i(str, "Post OCR Entity Validation");
                    z = true;
                } else {
                    c = 2;
                    c2 = 3;
                    z = false;
                }
                if (!z) {
                    Matcher matcher2 = PAT_URL_COMMA_WO_SPACE.matcher(text);
                    if (matcher2.find()) {
                        String str2 = TAG;
                        StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_URL_COMMA_WO_SPACE match: ");
                        sbM2227r2.append(matcher2.group());
                        MOCRLog.m5683d(str2, sbM2227r2.toString());
                        int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher2, line);
                        int i4 = matchingIds2[c];
                        int i5 = matchingIds2[c2];
                        if (i4 <= i5) {
                            CorrectionBase.joinWords(line, i4, i5, CorrectionBase.RegexActions.REPLACE_COMMA_MULTIPLE_IN_URL);
                        }
                        validatePageURL(line, i4);
                        MOCRLog.m5685i(str2, "Post OCR Entity Validation");
                        z = true;
                    }
                }
                if (!z) {
                    Matcher matcher3 = PAT_URL_COMMA.matcher(text);
                    if (matcher3.find()) {
                        String str3 = TAG;
                        StringBuilder sbM2227r3 = AbstractC2821a.m2227r("Original line :: ", text, str3, "PAT_URL_COMMA match: ");
                        sbM2227r3.append(matcher3.group());
                        MOCRLog.m5683d(str3, sbM2227r3.toString());
                        int[] matchingIds3 = CorrectionBase.getMatchingIds(matcher3, line);
                        int i6 = matchingIds3[c];
                        int i7 = matchingIds3[c2];
                        if (i6 <= i7) {
                            CorrectionBase.joinWords(line, i6, i7, CorrectionBase.RegexActions.REPLACE_COMMA_IN_EMAIL_OR_URL);
                            MOCRLog.m5685i(str3, "Post OCR Entity Validation");
                        }
                        validatePageURL(line, i6);
                        z = true;
                    }
                }
                if (!z) {
                    Matcher matcher4 = PAT_URL_HTTP_BASIC.matcher(text);
                    if (matcher4.find()) {
                        String str4 = TAG;
                        StringBuilder sbM2227r4 = AbstractC2821a.m2227r("Original line :: ", text, str4, "PAT_URL_HTTP_BASIC match: ");
                        sbM2227r4.append(matcher4.group());
                        MOCRLog.m5683d(str4, sbM2227r4.toString());
                        int[] matchingIds4 = CorrectionBase.getMatchingIds(matcher4, line);
                        int i8 = matchingIds4[c];
                        int i9 = matchingIds4[c2];
                        if (i8 <= i9) {
                            CorrectionBase.joinWords(line, i8, i9, CorrectionBase.RegexActions.REPLACE_DOUBLE_IN_URL);
                        }
                        correctHttpPrefix(line, i8, matcher4);
                        correctWwwDot(line, i8);
                        correctDomainName(line, i8, matcher4, GROUP_URL_HTTP_POPULAR_DOMAIN);
                        MOCRLog.m5685i(str4, "Post OCR Entity Validation");
                        validatePageURL(line, i8);
                        z = true;
                    }
                }
                if (!z) {
                    Matcher matcher5 = PAT_URL_WWW_BASIC.matcher(text);
                    if (matcher5.find()) {
                        String str5 = TAG;
                        StringBuilder sbM2227r5 = AbstractC2821a.m2227r("Original line :: ", text, str5, "PAT_URL_WWW_BASIC match: ");
                        sbM2227r5.append(matcher5.group());
                        MOCRLog.m5683d(str5, sbM2227r5.toString());
                        int[] matchingIds5 = CorrectionBase.getMatchingIds(matcher5, line);
                        int i10 = matchingIds5[c];
                        int i11 = matchingIds5[c2];
                        if (i10 <= i11) {
                            CorrectionBase.joinWords(line, i10, i11, CorrectionBase.RegexActions.REPLACE_DOUBLE_IN_URL);
                            MOCRLog.m5685i(str5, "Post OCR Entity Validation");
                        }
                        validatePageURL(line, i10);
                        z = true;
                    }
                }
                if (!z) {
                    Matcher matcher6 = PAT_URL_BASIC.matcher(text);
                    if (matcher6.find() && validateUrl(matcher6.group())) {
                        String str6 = TAG;
                        StringBuilder sbM2227r6 = AbstractC2821a.m2227r("Original line :: ", text, str6, "PAT_URL_BASIC match: ");
                        sbM2227r6.append(matcher6.group());
                        MOCRLog.m5683d(str6, sbM2227r6.toString());
                        int[] matchingIds6 = CorrectionBase.getMatchingIds(matcher6, line);
                        int i12 = matchingIds6[c];
                        int i13 = matchingIds6[c2];
                        if (i12 <= i13) {
                            CorrectionBase.joinWords(line, i12, i13, CorrectionBase.RegexActions.REPLACE_DOUBLE_IN_URL);
                            MOCRLog.m5685i(str6, "Post OCR Entity Validation");
                        }
                        validatePageURL(line, i12);
                    } else {
                        z2 = z;
                    }
                }
                if (!z2) {
                    Matcher matcher7 = PAT_STRICT_DOMAIN.matcher(text);
                    if (matcher7.find() && validateUrl(matcher7.group())) {
                        String str7 = TAG;
                        StringBuilder sbM2227r7 = AbstractC2821a.m2227r("Original line :: ", text, str7, "PAT_STRICT_DOMAIN match: ");
                        sbM2227r7.append(matcher7.group());
                        MOCRLog.m5683d(str7, sbM2227r7.toString());
                        int[] matchingIds7 = CorrectionBase.getMatchingIds(matcher7, line);
                        int i14 = matchingIds7[c];
                        int i15 = matchingIds7[c2];
                        if (i14 <= i15) {
                            CorrectionBase.joinWords(line, i14, i15, CorrectionBase.RegexActions.REPLACE_DOUBLE_IN_URL);
                            MOCRLog.m5685i(str7, "Post OCR Entity Validation");
                        }
                        validatePageURL(line, i14);
                    }
                }
            }
        }
    }

    private static boolean validateUrl(String str) {
        String strTrim = str.toLowerCase().trim();
        return (strTrim.endsWith(". in") || strTrim.endsWith(". it") || strTrim.endsWith(". at")) ? false : true;
    }

    private static void validateWwwCase(MOCRResult.Word word) {
        String str = word.wordText;
        int iIndexOf = str.toLowerCase().indexOf("www");
        if (iIndexOf == -1) {
            iIndexOf = str.toLowerCase().indexOf("vww");
        }
        if (iIndexOf != -1) {
            int i = iIndexOf + 3;
            if (str.substring(iIndexOf, i).equals("www") || str.toUpperCase().equals(str)) {
                return;
            }
            MOCRLog.m5683d(TAG, "www correction");
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, iIndexOf));
            sb.append("www");
            word.wordText = AbstractC4539a.m3198h(sb, str, i);
            MOCRResult.Char[] charArr = word.chars;
            if (charArr != null) {
                charArr[iIndexOf].unicode = 119;
                charArr[iIndexOf + 1].unicode = 119;
                charArr[iIndexOf + 2].unicode = 119;
            }
        }
    }
}
