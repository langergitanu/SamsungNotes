package com.samsung.android.ocr.stride.postocr;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCRResult;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PostProcessCorrection {
    private static final String TAG = "PostProcessCorrection";
    private static List<Character> slashSurroundingChars = Arrays.asList('.', ',', '\"', '\'');
    private static String[] findAndReplaceWords = {"l'd", "lt"};
    private static String[] toReplaceWords = {"I'd", "It"};
    private static final String REGEX_CURR_KO = "^₩[A-Za-z]+";
    private static final Pattern PAT_CURR_KO = Pattern.compile(REGEX_CURR_KO, 2);

    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void correctCharI(MOCRResult.Word word, MOCRResult.Line line, int i) {
        int i2;
        boolean z;
        int i4 = 0;
        if (word.charCount != 1) {
            if (word.wordText.contains("|")) {
                MOCRLog.m5683d(TAG, "Pipe replaced with I - condition 2");
                word.wordText = word.wordText.replaceAll("\\|", "I");
                MOCRResult.Char[] charArr = word.chars;
                if (charArr == null || charArr.length <= 0) {
                    return;
                }
                while (i4 < word.wordText.length()) {
                    if (word.wordText.charAt(i4) == '|') {
                        word.chars[i4].unicode = 73;
                    }
                    i4++;
                }
                return;
            }
            if (word.wordText.contains("\\")) {
                int iIndexOf = word.wordText.indexOf(92);
                int i5 = iIndexOf - 1;
                if (i5 >= 0) {
                    if (slashSurroundingChars.contains(Character.valueOf(word.wordText.charAt(i5)))) {
                        i4 = 1;
                    }
                }
                int i6 = iIndexOf + 1;
                if (i6 < word.wordText.length()) {
                    i = slashSurroundingChars.contains(Character.valueOf(word.wordText.charAt(i6))) ? 1 : i4;
                }
                if (i != 0) {
                    word.wordText = word.wordText.replace('\\', 'I');
                    MOCRResult.Char[] charArr2 = word.chars;
                    if (charArr2 == null || charArr2.length <= 0) {
                        return;
                    }
                    charArr2[iIndexOf].unicode = 73;
                    return;
                }
                return;
            }
            return;
        }
        String str = word.wordText;
        str.getClass();
        switch (str) {
            case "\":
                int i7 = i + 1;
                MOCRResult.Word[] wordArr = line.words;
                if (i7 < wordArr.length) {
                    char cCharAt = wordArr[i7].wordText.charAt(0);
                    i2 = (Character.isLowerCase(cCharAt) || slashSurroundingChars.contains(Character.valueOf(cCharAt))) ? 1 : 0;
                }
                int i8 = i - 1;
                if (i8 >= 0) {
                    char cM4a = AbstractC0000a.m4a(1, line.words[i8].wordText);
                    if (!Character.isLowerCase(cM4a) && !slashSurroundingChars.contains(Character.valueOf(cM4a))) {
                        i = i2;
                    }
                }
                if (i != 0) {
                    MOCRLog.m5683d(TAG, "\\ replaced with I - 1 char");
                    word.wordText = "I";
                    MOCRResult.Char[] charArr3 = word.chars;
                    if (charArr3 != null && charArr3.length > 0) {
                        charArr3[0].unicode = 73;
                        break;
                    }
                }
                break;
            case "l":
                MOCRLog.m5683d(TAG, "l replaced with I - 1 char");
                word.wordText = "I";
                MOCRResult.Char[] charArr4 = word.chars;
                if (charArr4 != null && charArr4.length > 0) {
                    charArr4[0].unicode = 73;
                    break;
                }
                break;
            case "|":
                int i9 = i + 1;
                MOCRResult.Word[] wordArr2 = line.words;
                if (i9 < wordArr2.length) {
                    char cCharAt2 = wordArr2[i9].wordText.charAt(0);
                    z = (Character.isUpperCase(cCharAt2) || Character.isDigit(cCharAt2)) ? false : true;
                }
                int i10 = i - 1;
                if (i10 >= 0) {
                    char cM4a2 = AbstractC0000a.m4a(1, line.words[i10].wordText);
                    if (Character.isUpperCase(cM4a2) || Character.isDigit(cM4a2)) {
                        z = false;
                    }
                }
                if (z) {
                    MOCRLog.m5683d(TAG, "Pipe replaced with I - 1 char");
                    word.wordText = "I";
                    MOCRResult.Char[] charArr5 = word.chars;
                    if (charArr5 != null && charArr5.length > 0) {
                        charArr5[0].unicode = 73;
                        break;
                    }
                }
                break;
        }
    }

    public static void process(MOCRResult.Page page) {
        for (MOCRResult.Block block : page.blocks) {
            for (MOCRResult.Line line : block.lines) {
                int i = 0;
                while (true) {
                    MOCRResult.Word[] wordArr = line.words;
                    if (i < wordArr.length) {
                        MOCRResult.Word word = wordArr[i];
                        correctCharI(word, line, i);
                        replaceWord(word);
                        replaceInvalidCurrency(word);
                        i++;
                    }
                }
            }
        }
    }

    private static void replaceInvalidCurrency(MOCRResult.Word word) {
        String str = word.wordText;
        if (PAT_CURR_KO.matcher(str).find()) {
            word.wordText = AbstractC4539a.m3198h(new StringBuilder("W"), str, 1);
            MOCRResult.Char[] charArr = word.chars;
            if (charArr == null || charArr.length <= 0) {
                return;
            }
            charArr[0].unicode = 87;
        }
    }

    private static void replaceWord(MOCRResult.Word word) {
        int i = 0;
        while (true) {
            String[] strArr = findAndReplaceWords;
            if (i >= strArr.length) {
                return;
            }
            if (word.wordText.equals(strArr[i])) {
                word.wordText = toReplaceWords[i];
                MOCRResult.Char[] charArr = word.chars;
                if (charArr != null && charArr.length > 0) {
                    for (int i2 = 0; i2 < word.wordText.length(); i2++) {
                        word.chars[i2].unicode = word.wordText.charAt(i2);
                    }
                }
            }
            i++;
        }
    }
}
