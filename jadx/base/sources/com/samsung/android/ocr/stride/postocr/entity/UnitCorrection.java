package com.samsung.android.ocr.stride.postocr.entity;

import androidx.glance.AbstractC2821a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.entity.CorrectionBase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class UnitCorrection extends CorrectionBase {
    private static final int GROUP_REPLACE_SUPERSCRIPT_2 = 4;
    private static final String TAG = "UnitCorrection";
    private static final String UNITS_WITH_CUBE = "(cm|ft|in|m|km|mm|g\\/cm|m\\/s)";
    private static final String UNITS_WITH_SQUARE = "(cm|ft|in|m|km|mm|g\\/cm|m\\/s)";
    private static final String REGEX_DIGIT_WITH_UNITS_2 = "(\\d)+(\\s)?(cm|ft|in|m|km|mm|g\\/cm|m\\/s)((2\\b)|(\\?))";
    private static final Pattern PAT_DIGIT_WITH_UNITS_2 = Pattern.compile(REGEX_DIGIT_WITH_UNITS_2, 2);
    private static final String REGEX_DIGIT_WITH_UNITS_3 = "(\\d)+(\\s)?(cm|ft|in|m|km|mm|g\\/cm|m\\/s)(3)\\b";
    private static final Pattern PAT_DIGIT_WITH_UNITS_3 = Pattern.compile(REGEX_DIGIT_WITH_UNITS_3, 2);

    public static void validateUnits(MOCRResult.Page page) {
        char c;
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                String text = line.getText();
                Matcher matcher = PAT_DIGIT_WITH_UNITS_2.matcher(text);
                while (true) {
                    c = 3;
                    if (!matcher.find()) {
                        break;
                    }
                    String str = TAG;
                    StringBuilder sbM2227r = AbstractC2821a.m2227r("Original line :: ", text, str, "PAT_DIGIT_WITH_UNITS_2 match: ");
                    sbM2227r.append(matcher.group());
                    MOCRLog.m5683d(str, sbM2227r.toString());
                    int[] matchingIds = CorrectionBase.getMatchingIds(matcher, line);
                    int i = matchingIds[2];
                    int i2 = matchingIds[3];
                    if (i <= i2) {
                        CorrectionBase.replaceCharInWord(line, i2, CorrectionBase.RegexActions.REPLACE_SUPERSCRIPT_2_IN_UNITS, matcher.group(4));
                        MOCRLog.m5683d(str, "Post OCR Entity Validation");
                    }
                }
                Matcher matcher2 = PAT_DIGIT_WITH_UNITS_3.matcher(text);
                while (matcher2.find()) {
                    String str2 = TAG;
                    StringBuilder sbM2227r2 = AbstractC2821a.m2227r("Original line :: ", text, str2, "PAT_DIGIT_WITH_UNITS_3 match: ");
                    char c2 = c;
                    sbM2227r2.append(matcher2.group());
                    MOCRLog.m5683d(str2, sbM2227r2.toString());
                    int[] matchingIds2 = CorrectionBase.getMatchingIds(matcher2, line, 4);
                    int i4 = matchingIds2[2];
                    int i5 = matchingIds2[c2];
                    if (i4 <= i5) {
                        CorrectionBase.replaceCharInWord(line, i5, CorrectionBase.RegexActions.REPLACE_SUPERSCRIPT_3_IN_UNITS);
                        MOCRLog.m5683d(str2, "Post OCR Entity Validation");
                    }
                    c = c2;
                }
            }
        }
    }
}
