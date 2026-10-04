package com.samsung.android.ocr.stride.postocr.entity;

import android.graphics.Point;
import androidx.glance.AbstractC2821a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EmailCorrection extends CorrectionBase {
    private static final String DOMAIN_EXTNS = "(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|ac)";
    private static final String TAG = "EmailCorrection";
    private static final String REGEX_SPACE_BW_NAME = "([a-zA-Z0-9]+)(\\s)*(\\.)(\\s)*([a-zA-Z0-9]+)(\\s)*@(\\s)*([a-zA-Z0-9]+)(\\s)*(\\.)(\\s)*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|ac)";
    private static final Pattern PAT_SPACE_BW_NAMES = Pattern.compile(REGEX_SPACE_BW_NAME, 2);
    private static final String REGEX_EMAIL_BASIC = "([a-zA-Z0-9-._]+)(\\s)*@(\\s)*([a-zA-Z0-9]+)(\\s)*(\\.)(\\s)*(\\.)?(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|ac)";
    private static final Pattern PAT_EMAIL_BASIC = Pattern.compile(REGEX_EMAIL_BASIC, 2);
    private static final String REGEX_EMAIL_COMMA = "([a-zA-Z0-9-._]+)(\\s)*@(\\s)*([a-zA-Z0-9]+)(\\s)*(,)(\\s)*(com|in|kr|se|org|net|io|gle|mil|tk|cn|de|uk|nl|icu|ru|ir|au|ua|us|fr|es|ca|it|sg|gov|edu|co|ms|at|ac)";
    private static final Pattern PAT_EMAIL_COMMA = Pattern.compile(REGEX_EMAIL_COMMA, 2);
    private static final String REGEX_EMAIL_SPACE = "([a-zA-Z0-9-._]+)@([a-zA-Z0-9]+)(\\s)(kr)(?=($|\\s))";
    private static final Pattern PAT_EMAIL_SPACE = Pattern.compile(REGEX_EMAIL_SPACE, 2);

    private static void joinWordByDot(MOCRResult.Line line, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(line.words[i2]);
        }
        MOCRResult.Word word = new MOCRResult.Word();
        word.wRect = new Point[]{pointArr[0], pointArr[1], pointArr[2], pointArr[3]};
        MOCRResult.Word[] wordArr = line.words;
        MOCRResult.Word word2 = wordArr[i];
        MOCRResult.Word word3 = wordArr[i + 1];
        Point[] pointArr = word2.wRect;
        Point[] pointArr2 = word3.wRect;
        String str = word2.wordText + Extension.DOT + word3.wordText;
        word.wordText = str;
        word.conf = (word2.conf + word3.conf) / 2.0f;
        if (word2.chars != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(Arrays.asList(word2.chars));
            MOCRResult.Char r6 = new MOCRResult.Char();
            r6.unicode = 46;
            r6.cRect = (Point[]) word2.chars[word2.charCount - 1].cRect.clone();
            arrayList2.add(r6);
            arrayList2.addAll(Arrays.asList(word3.chars));
            MOCRResult.Char[] charArr = (MOCRResult.Char[]) arrayList2.toArray(new MOCRResult.Char[0]);
            word.chars = charArr;
            word.charCount = charArr.length;
        } else {
            word.charCount = str.length();
        }
        arrayList.add(word);
        for (int i4 = i + 2; i4 < line.wordCount; i4++) {
            arrayList.add(line.words[i4]);
        }
        MOCRResult.Word[] wordArr2 = (MOCRResult.Word[]) arrayList.toArray(new MOCRResult.Word[0]);
        line.words = wordArr2;
        line.wordCount = wordArr2.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void validateEmailLine(MOCRResult.Page page) {
        char c;
        boolean z;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_SPACE_BW_NAMES.matcher(text);
                boolean z2 = true;
                if (matcher.find()) {
                    String str = TAG;
                    StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_SPACE_BW_NAMES match: ");
                    c = 3;
                    sbM2227r.append(matcher.group());
                    MOCRLog.m5683d(str, sbM2227r.toString());
                    int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line);
                    int i = matchingIds[2];
                    int i2 = matchingIds[3];
                    if (i < i2) {
                        CorrectionBase.joinWords(line, i, i2);
                        MOCRLog.m5685i(str, "Post OCR Entity Validation");
                    }
                    z = true;
                } else {
                    c = 3;
                    z = false;
                }
                if (!z) {
                    Matcher matcher2 = PAT_EMAIL_BASIC.matcher(text);
                    if (matcher2.find()) {
                        String str2 = TAG;
                        StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_EMAIL_BASIC match: ");
                        sbM2227r2.append(matcher2.group());
                        MOCRLog.m5683d(str2, sbM2227r2.toString());
                        int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher2, line);
                        int i4 = matchingIds2[2];
                        int i5 = matchingIds2[c];
                        if (i4 < i5) {
                            CorrectionBase.joinWords(line, i4, i5, CorrectionBase.RegexActions.REPLACE_DOUBLE_IN_EMAIL);
                            MOCRLog.m5685i(str2, "Post OCR Entity Validation");
                        }
                        z = true;
                    }
                }
                if (!z) {
                    Matcher matcher3 = PAT_EMAIL_COMMA.matcher(text);
                    if (matcher3.find()) {
                        String str3 = TAG;
                        StringBuilder sbM2227r3 = AbstractC2821a.m2227r("Original line :: ", text, str3, "PAT_EMAIL_COMMA match: ");
                        sbM2227r3.append(matcher3.group());
                        MOCRLog.m5683d(str3, sbM2227r3.toString());
                        int[] matchingIds3 = CorrectionBase.getMatchingIds(matcher3, line);
                        int i6 = matchingIds3[2];
                        int i7 = matchingIds3[c];
                        if (i6 < i7) {
                            CorrectionBase.joinWords(line, i6, i7, CorrectionBase.RegexActions.REPLACE_COMMA_IN_EMAIL_OR_URL);
                            MOCRLog.m5685i(str3, "Post OCR Entity Validation");
                        }
                    } else {
                        z2 = z;
                    }
                }
                if (!z2) {
                    Matcher matcher4 = PAT_EMAIL_SPACE.matcher(text);
                    if (matcher4.find()) {
                        String str4 = TAG;
                        StringBuilder sbM2227r4 = AbstractC2821a.m2227r("Original line :: ", text, str4, "PAT_EMAIL_SPACE match: ");
                        sbM2227r4.append(matcher4.group());
                        MOCRLog.m5683d(str4, sbM2227r4.toString());
                        int[] matchingIds4 = CorrectionBase.getMatchingIds(matcher4, line);
                        int i8 = matchingIds4[2];
                        if (i8 + 1 == matchingIds4[c]) {
                            joinWordByDot(line, i8);
                            MOCRLog.m5685i(str4, "Post OCR Entity Validation");
                        }
                    }
                }
            }
        }
    }
}
