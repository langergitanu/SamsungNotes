package com.samsung.android.ocr;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRScript {
    public static final int ARABIC = 4;
    public static final int ARMENIAN = 16;
    public static final int BENGALI = 11;
    public static final int CHINESE = 2;
    public static final int CYRILLIC = 9;
    public static final int DEVANAGARI = 5;
    public static final int GREEK = 19;
    public static final int GUJARATI = 12;
    public static final int GURUMUKHI = 13;
    public static final int HEBREW = 17;
    public static final int JAPANESE = 3;
    public static final int KANNADA = 8;
    public static final int KHMER = 15;
    public static final int KOREAN = 1;
    public static final int LAO = 18;
    public static final int LATIN = 0;
    public static final int MALAYALAM = 14;
    public static final int SUPPORTED_COUNT = 20;
    public static final int TAMIL = 6;
    public static final int TELUGU = 7;
    public static final int THAI = 10;

    public static List<Integer> getColors() {
        return Arrays.asList(-8388608, -1697461, -344364, -6659292, -687567, -10063, -8355840, -7911, -1336, -4198587, -12798901, -5570621, -12150384, -12397324, -12360744, -16777099, -7266636, -2310401, -1035546, -5658199, -16777216);
    }

    public static int getScriptID(int i) {
        if (i >= 0 && i < 40) {
            return 0;
        }
        if (i >= 40 && i < 50) {
            return 1;
        }
        if (i >= 50 && i < 60) {
            return 9;
        }
        if (i >= 60 && i < 70) {
            return 2;
        }
        if (i >= 70 && i < 80) {
            return 3;
        }
        if (i >= 80 && i < 90) {
            return 4;
        }
        if (i < 90 || i >= 100) {
            return (i < 130 || i >= 140) ? -1 : 10;
        }
        return 5;
    }

    public static String getString(int i) {
        return i == 0 ? "Latin" : i == 1 ? "Korean" : i == 2 ? "Chinese" : i == 3 ? "Japanese" : i == 4 ? "Arabic" : i == 5 ? "Devanagari" : i == 6 ? "Tamil" : i == 7 ? "Telugu" : i == 8 ? "Kannada" : i == 9 ? "Cyrillic" : i == 10 ? "Thai" : i == 11 ? "Bengali" : i == 12 ? "Gujarati" : i == 13 ? "Gurumukhi" : i == 15 ? "Khmer" : i == 14 ? "Malayalam" : i == 19 ? "Greek" : i == 17 ? "Hebrew" : i == 16 ? "Armenian" : i == 18 ? "Lao" : "NoScript";
    }
}
