package com.samsung.android.ocr.stride.lang;

import com.samsung.android.ocr.MOCRLang;
import java.lang.Character;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class UnicodeLangDetector extends LanguageDetector {
    private static final String TAG = "UnicodeLangDetector";

    public static boolean isArabic(CharSequence charSequence) {
        for (char c : charSequence.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC_EXTENDED_A || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC_SUPPLEMENT || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChinese(CharSequence charSequence) {
        for (char c : charSequence.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_STROKES) {
                return true;
            }
            Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(c);
            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION;
            if (unicodeBlockOf == unicodeBlock || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ENCLOSED_IDEOGRAPHIC_SUPPLEMENT || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KANGXI_RADICALS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS || Character.UnicodeBlock.of(c) == unicodeBlock) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCyrillic(CharSequence charSequence) {
        for (char c : charSequence.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC_EXTENDED_A || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC_EXTENDED_B || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC_SUPPLEMENTARY) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJapanese(CharSequence charSequence) {
        for (char c : charSequence.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HIRAGANA || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA) {
                return true;
            }
            Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(c);
            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
            if (unicodeBlockOf == unicodeBlock || Character.UnicodeBlock.of(c) == unicodeBlock || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKorean(CharSequence charSequence) {
        for (char c : charSequence.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_JAMO || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.ocr.stride.lang.LanguageDetector
    public int detectLanguage(String str, int i) {
        if (MOCRLang.isKorean(i) && isKorean(str)) {
            return 40;
        }
        if (MOCRLang.isChinese(i) && isChinese(str)) {
            return 60;
        }
        if (MOCRLang.isJapanese(i) && isJapanese(str)) {
            return 70;
        }
        if (MOCRLang.isCyrillic(i) && isCyrillic(str)) {
            return 50;
        }
        if (MOCRLang.isArabic(i) && isArabic(str)) {
            return 80;
        }
        if (MOCRLang.isLatin(i)) {
            return i;
        }
        return 1;
    }
}
