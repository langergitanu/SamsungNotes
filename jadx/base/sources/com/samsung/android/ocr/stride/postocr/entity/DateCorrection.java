package com.samsung.android.ocr.stride.postocr.entity;

import androidx.glance.AbstractC2821a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DateCorrection extends CorrectionBase {
    private static final String DATE_SUFFIX = "(st|nd|rd|th)";
    private static final int GROUP_REPLACE_O_IN_DATE = 1;
    private static final int GROUP_REPLACE_O_IN_DATE1 = 3;
    private static final String MONTH_NAMES = "(January|February|March|April|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";
    private static final String TAG = "DateCorrection";
    private static final String REGEX_DATE_BASIC1 = "\\b(\\d)([0-9\\s]{0,1})(-)([0-9\\s]{1,3})(-)(\\d{2}|\\d{4})\\b";
    private static final Pattern PAT_DATE_BASIC1 = Pattern.compile(REGEX_DATE_BASIC1, 2);
    private static final String REGEX_DATE_REPLACE_O = "\\b(?!O[^\\d])([\\dO]{1,2})(\\s?)(?i:(st|nd|rd|th))?(\\s+)(?i:(January|February|March|April|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))(\\s+(\\d{2}|\\d{4}))?\\b";
    private static final Pattern PAT_DATE_REPLACE_O = Pattern.compile(REGEX_DATE_REPLACE_O);
    private static final String REGEX_DATE1_REPLACE_O = "\\b(January|February|March|April|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(\\s+)([\\dOo]{1,2})(\\s?)(st|nd|rd|th)((\\s+)(\\d{4}))?\\b";
    private static final Pattern PAT_DATE1_REPLACE_O = Pattern.compile(REGEX_DATE1_REPLACE_O, 2);

    public static void validateDateFormat(MOCRResult.Page page) {
        char c;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_DATE_BASIC1.matcher(text);
                while (true) {
                    c = 2;
                    if (!matcher.find()) {
                        break;
                    }
                    String str = TAG;
                    StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_DATE_BASIC1 match: ");
                    sbM2227r.append(matcher.group());
                    MOCRLog.m5683d(str, sbM2227r.toString());
                    int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line);
                    int i = matchingIds[2];
                    int i2 = matchingIds[3];
                    if (i < i2) {
                        CorrectionBase.joinWords(line, i, i2);
                        MOCRLog.m5685i(str, "Post OCR Entity Validation");
                    }
                }
                Matcher matcher2 = PAT_DATE_REPLACE_O.matcher(text);
                while (matcher2.find()) {
                    String str2 = TAG;
                    StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_DATE_REPLACE_O match: ");
                    sbM2227r2.append(matcher2.group());
                    MOCRLog.m5683d(str2, sbM2227r2.toString());
                    int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher2, line, 1);
                    int i4 = matchingIds2[c];
                    int i5 = matchingIds2[3];
                    char c2 = c;
                    if (i4 <= i5) {
                        CorrectionBase.joinWords(line, i4, i5, CorrectionBase.RegexActions.REPLACE_O_IN_DATETIME);
                    }
                    MOCRLog.m5685i(str2, "Post OCR Entity Validation");
                    c = c2;
                }
                char c4 = c;
                Matcher matcher3 = PAT_DATE1_REPLACE_O.matcher(text);
                while (matcher3.find()) {
                    String str3 = TAG;
                    StringBuilder sbM2227r3 = AbstractC2821a.m2227r("Original line :: ", text, str3, "PAT_DATE1_REPLACE_O match: ");
                    sbM2227r3.append(matcher3.group());
                    MOCRLog.m5683d(str3, sbM2227r3.toString());
                    int[] matchingIds3 = CorrectionBase.getMatchingIds(matcher3, line, 3);
                    int i6 = matchingIds3[c4];
                    int i7 = matchingIds3[3];
                    if (i6 <= i7) {
                        CorrectionBase.joinWords(line, i6, i7, CorrectionBase.RegexActions.REPLACE_O_IN_DATETIME);
                    }
                    MOCRLog.m5685i(str3, "Post OCR Entity Validation");
                }
            }
        }
    }
}
