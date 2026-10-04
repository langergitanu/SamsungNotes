package com.samsung.android.ocr.stride.postocr.entity;

import androidx.glance.AbstractC2821a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TimeCorrection extends CorrectionBase {
    private static final int GROUP_REPLACE_O_IN_TIME = 1;
    private static final int GROUP_REPLACE_O_IN_TIME1 = 1;
    private static final String TAG = "TimeCorrection";
    private static final String TIME_POSTFIX = "(?i:(AM|PM))";
    private static final String REGEX_TIME_REPLACE_O = "\\b([\\dO]{1,2})(\\.|:)([\\dO]{1,2})(\\s?)(?i:(AM|PM))\\b";
    private static final Pattern PAT_TIME_REPLACE_O = Pattern.compile(REGEX_TIME_REPLACE_O);
    private static final String REGEX_TIME1_REPLACE_O = "\\b(\\d{1}(\\s+)\\d{1})(\\s?)(o'(\\s?)clock)";
    private static final Pattern PAT_TIME1_REPLACE_0 = Pattern.compile(REGEX_TIME1_REPLACE_O);

    public static void validateTimeFormat(MOCRResult.Page page) {
        char c;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_TIME_REPLACE_O.matcher(text);
                while (true) {
                    c = 3;
                    if (!matcher.find()) {
                        break;
                    }
                    String str = TAG;
                    StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_TIME_REPLACE_O match: ");
                    sbM2227r.append(matcher.group());
                    MOCRLog.m5683d(str, sbM2227r.toString());
                    int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line, 1);
                    int i = matchingIds[2];
                    int i2 = matchingIds[3];
                    if (i <= i2) {
                        CorrectionBase.joinWords(line, i, i2, CorrectionBase.RegexActions.REPLACE_O_IN_DATETIME);
                    }
                    MOCRLog.m5685i(str, "Post OCR Entity Validation");
                }
                Matcher matcher2 = PAT_TIME1_REPLACE_0.matcher(text);
                while (matcher2.find()) {
                    String str2 = TAG;
                    StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_TIME1_REPLACE_O match: ");
                    char c2 = c;
                    sbM2227r2.append(matcher2.group());
                    MOCRLog.m5683d(str2, sbM2227r2.toString());
                    int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher2, line, 1);
                    int i4 = matchingIds2[2];
                    int i5 = matchingIds2[c2];
                    if (i4 < i5) {
                        CorrectionBase.joinWords(line, i4, i5);
                    }
                    MOCRLog.m5685i(str2, "Post OCR Entity Validation");
                    c = c2;
                }
            }
        }
    }
}
