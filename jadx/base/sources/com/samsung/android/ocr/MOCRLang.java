package com.samsung.android.ocr;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRLang {
    public static final int AFRIKAANS = 32;
    public static final int ALBANIAN = 2;
    public static final int ARABIC = 80;
    public static final int ARMENIAN = 210;
    public static final int AUTO = 1001;
    public static final int BASQUE = 3;
    public static final int BENGALI = 140;
    public static final int BULGARIAN = 51;
    public static final int CATALAN = 4;
    public static final int CHINESE = 60;
    public static final int CROATIAN = 5;
    public static final int CYRILLIC = 50;
    public static final int CZECH = 6;
    public static final int DANISH = 7;
    public static final int DEVANAGARI = 90;
    public static final int DUTCH = 8;
    public static final int ENGLISH = 1;
    public static final int ESTONIAN = 9;
    public static final int FINNISH = 10;
    public static final int FRENCH = 11;
    public static final int GALICIAN = 12;
    public static final int GERMAN = 13;
    public static final int GREEK = 190;
    public static final int GUJARATI = 150;
    public static final int GURMUKHI = 160;
    public static final int HEBREW = 200;
    public static final int HINDI = 91;
    public static final int HUNGARIAN = 14;
    public static final int ICELANDIC = 15;
    public static final int INDONESIAN = 16;
    public static final int IRISH = 17;
    public static final int ITALIAN = 18;
    public static final int JAPANESE = 70;
    public static final int KANNADA = 120;
    public static final int KHMER = 180;
    public static final int KOREAN = 40;
    public static final int LAO = 220;
    public static final int LATIN = 0;
    public static final int LATVIAN = 19;
    public static final int LITHUANIAN = 20;
    public static final int MACEDONIAN = 52;
    public static final int MALAY = 21;
    public static final int MALAYALAM = 170;
    public static final int MARATHI = 92;
    public static final int NEPALI = 93;
    public static final int NORWEGIAN = 22;
    public static final int POLISH = 23;
    public static final int PORTUGUESE = 24;
    public static final int PUNJABI = 161;
    public static final int ROMANIAN = 25;
    public static final int RUSSIAN = 53;
    public static final int SERBIAN = 54;
    public static final int SLOVAK = 27;
    public static final int SLOVENIAN = 28;
    public static final int SPANISH = 26;
    public static final int SWEDISH = 29;
    public static final int TAMIL = 100;
    public static final int TELUGU = 110;
    public static final int THAI = 130;
    public static final int TURKISH = 30;
    public static final int UKRAINIAN = 55;
    public static final int UZBEK = 31;
    public static final int VIETNAMESE = 34;
    private static Map<String, Integer> localeMap = new HashMap<String, Integer>() { // from class: com.samsung.android.ocr.MOCRLang.1
        {
            AbstractC6670b.m4745f(0, this, "la", 1, "en");
            AbstractC6670b.m4745f(2, this, "sq", 3, "eu");
            AbstractC6670b.m4745f(4, this, "ca", 5, "hr");
            AbstractC6670b.m4745f(6, this, "cs", 7, "da");
            AbstractC6670b.m4745f(8, this, "nl", 9, "et");
            AbstractC6670b.m4745f(10, this, "fi", 11, LangPackConfigConstants.LANGUAGE_CODE_FR);
            AbstractC6670b.m4745f(12, this, "gl", 13, LangPackConfigConstants.LANGUAGE_CODE_DE);
            AbstractC6670b.m4745f(14, this, "hu", 15, "is");
            AbstractC6670b.m4745f(16, this, "id", 17, "ga");
            AbstractC6670b.m4745f(18, this, LangPackConfigConstants.LANGUAGE_CODE_IT, 19, "lv");
            AbstractC6670b.m4745f(20, this, "lt", 21, "ms");
            put(BooleanUtils.f9757NO, 22);
            put("nb", 22);
            put("nn", 22);
            AbstractC6670b.m4745f(23, this, LangPackConfigConstants.LANGUAGE_CODE_PL, 24, LangPackConfigConstants.LANGUAGE_CODE_PT);
            AbstractC6670b.m4745f(25, this, "ro", 26, LangPackConfigConstants.LANGUAGE_CODE_ES);
            AbstractC6670b.m4745f(27, this, "sk", 28, "sl");
            AbstractC6670b.m4745f(29, this, "sv", 30, "tr");
            AbstractC6670b.m4745f(31, this, "uz", 32, "af");
            AbstractC6670b.m4745f(34, this, LangPackConfigConstants.LANGUAGE_CODE_VI, 40, LangPackConfigConstants.LANGUAGE_CODE_KO);
            AbstractC6670b.m4745f(51, this, MarketingConstants.PopupConst.COLOR_BACKGROUND, 52, "mk");
            AbstractC6670b.m4745f(53, this, LangPackConfigConstants.LANGUAGE_CODE_RU, 54, "sr");
            AbstractC6670b.m4745f(55, this, "uk", 60, "zh");
            AbstractC6670b.m4745f(70, this, LangPackConfigConstants.LANGUAGE_CODE_JA, 80, "ar");
            AbstractC6670b.m4745f(130, this, "th", 91, "hi");
            AbstractC6670b.m4745f(92, this, "mr", 93, "ne");
            AbstractC6670b.m4745f(161, this, "pa", 100, "ta");
            AbstractC6670b.m4745f(110, this, "te", 120, "kn");
            AbstractC6670b.m4745f(140, this, "bn", 150, "gu");
            AbstractC6670b.m4745f(170, this, "ml", 180, "km");
            put("el", 190);
            put(VPathDataCmd.SmoothLine, 200);
            put("iw", 200);
            put("hy", 210);
            put("lo", 220);
        }
    };

    public static int getLangFromLocale(Locale locale) {
        if (locale == null) {
            return 0;
        }
        String language = locale.getLanguage();
        String script = locale.getScript();
        for (Map.Entry<String, Integer> entry : localeMap.entrySet()) {
            if (isLocaleEquals(language, entry.getKey())) {
                return entry.getValue().intValue();
            }
        }
        if (script.equals("Kore") || script.equals("Hang")) {
            return 40;
        }
        if (script.equals("Jpan") || script.equals("Hani") || script.equals("Hira") || script.equals("Kana")) {
            return 70;
        }
        if (script.equals("Hans") || script.equals("Hant")) {
            return 60;
        }
        if (script.equals("Cyrl")) {
            return 50;
        }
        if (script.equals("Arab")) {
            return 80;
        }
        if (script.equals("Thai")) {
            return 130;
        }
        if (script.equals("Deva")) {
            return 90;
        }
        if (script.equals("Taml")) {
            return 100;
        }
        if (script.equals("Telu")) {
            return 110;
        }
        if (script.equals("Knda")) {
            return 120;
        }
        if (script.equals("Beng")) {
            return 140;
        }
        if (script.equals("Gujr")) {
            return 150;
        }
        if (script.equals("Guru")) {
            return 160;
        }
        if (script.equals("Mlym")) {
            return 170;
        }
        if (script.equals("Khmr")) {
            return 180;
        }
        if (script.equals("Grek")) {
            return 190;
        }
        if (script.equals("Hebr")) {
            return 200;
        }
        if (script.equals("Armn")) {
            return 210;
        }
        return script.equals("Laoo") ? 220 : 0;
    }

    public static int getLangScript(int i) {
        if (i >= 0 && i < 40) {
            return 0;
        }
        if (i >= 40 && i < 50) {
            return 40;
        }
        if (i >= 50 && i < 60) {
            return 50;
        }
        if (i >= 60 && i < 70) {
            return 60;
        }
        if (i >= 70 && i < 80) {
            return 70;
        }
        if (i >= 80 && i < 90) {
            return 80;
        }
        if (i >= 90 && i < 100) {
            return 90;
        }
        if (i >= 100 && i < 110) {
            return 100;
        }
        if (i >= 110 && i < 120) {
            return 110;
        }
        if (i >= 120 && i < 130) {
            return 120;
        }
        if (i >= 130 && i < 140) {
            return 130;
        }
        if (i >= 140 && i < 150) {
            return 140;
        }
        if (i >= 150 && i < 160) {
            return 150;
        }
        if (i >= 160 && i < 170) {
            return 160;
        }
        if (i >= 170 && i < 180) {
            return 170;
        }
        if (i >= 180 && i < 190) {
            return 180;
        }
        if (i >= 190 && i < 200) {
            return 190;
        }
        if (i >= 200 && i < 210) {
            return 200;
        }
        if (i < 210 || i >= 220) {
            return (i < 220 || i >= 230) ? -1 : 220;
        }
        return 210;
    }

    public static boolean isArabic(int i) {
        return getLangScript(i) == 80;
    }

    public static boolean isChinese(int i) {
        return getLangScript(i) == 60;
    }

    public static boolean isCyrillic(int i) {
        return getLangScript(i) == 50;
    }

    public static boolean isDevanagari(int i) {
        return getLangScript(i) == 91;
    }

    public static boolean isJapanese(int i) {
        return getLangScript(i) == 70;
    }

    public static boolean isKorean(int i) {
        return getLangScript(i) == 40;
    }

    public static boolean isLatin(int i) {
        return getLangScript(i) == 0;
    }

    private static boolean isLocaleEquals(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.startsWith(str2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("_");
        return str.startsWith(sb.toString());
    }
}
