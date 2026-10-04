package com.samsung.android.livetranslation.util;

import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class WordCountRule implements Rule {
    private static final int MIN_CHARACTER_COUNT_FOR_CJ = 10;
    private static final int MIN_WORD_COUNT = 3;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    @Override // com.samsung.android.livetranslation.util.Rule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double getScore(@NonNull List<LttOcrResult.BlockInfo> list) {
        double d = 0.0d;
        double d2 = 0.0d;
        for (LttOcrResult.BlockInfo blockInfo : list) {
            BrokenLineDetector brokenLineDetector = new BrokenLineDetector(blockInfo);
            for (LttOcrResult.LineInfo lineInfo : blockInfo.getLineInfo()) {
                if (CJDetector.isCJLanguage(lineInfo.getString())) {
                    if (lineInfo.getString().length() > 10) {
                        d2 += 1.0d;
                    }
                } else if (lineInfo.getWordInfo().size() > 3 || brokenLineDetector.isContinuousLine(lineInfo)) {
                }
                d += 1.0d;
            }
        }
        if (d > 0.0d) {
            return d2 / d;
        }
        return 0.0d;
    }
}
