package com.samsung.android.livetranslation.util;

import androidx.annotation.NonNull;
import java.lang.Character;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class CJDetector {
    public static boolean isCJLanguage(@NonNull String str) {
        String strReplaceAll = str.replaceAll("\\s", "");
        if (strReplaceAll.isEmpty()) {
            return false;
        }
        double d = 0.0d;
        for (char c : strReplaceAll.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HIRAGANA || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
                d += 1.0d;
            }
        }
        return d / ((double) strReplaceAll.length()) > 0.5d;
    }
}
