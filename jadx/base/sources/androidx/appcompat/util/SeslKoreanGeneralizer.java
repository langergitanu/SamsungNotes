package androidx.appcompat.util;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class SeslKoreanGeneralizer {
    private static final String NON_PRONOUNCEABLE_CHARACTERS = "()[]<>{};:|`'\"\\.=!?&。 ♡♥…«»‘’‚‛“”„‟‹›❛❜❝❞〝〞〟＂＇";
    private Map<String, Pair<String, String>> JOSA_KOREAN_MAP = new HashMap() { // from class: androidx.appcompat.util.SeslKoreanGeneralizer.1
        {
            put("은(는)", new Pair("은", "는"));
            put("(은)는", new Pair("은", "는"));
            put("이(가)", new Pair("이", "가"));
            put("(이)가", new Pair("이", "가"));
            put("을(를)", new Pair("을", "를"));
            put("(을)를", new Pair("을", "를"));
            put("와(과)", new Pair("과", "와"));
            put("(와)과", new Pair("과", "와"));
            put("아(야)", new Pair("아", "야"));
            put("(아)야", new Pair("아", "야"));
            put("(이)여", new Pair("이여", "여"));
            put("(으)로", new Pair("으로", "로"));
            put("(이)라", new Pair("이라", "라"));
            put("(이에)예", new Pair("이에", "예"));
            put("이에(예)", new Pair("이에", "예"));
            put("(이었)였", new Pair("이었", "였"));
            put("이었(였)", new Pair("이었", "였"));
            put("(이)네", new Pair("이네", "네"));
        }
    };
    private final Map<Character, Pair<Boolean, Boolean>> PRONOUNCEABLE_SYMBOLS = new HashMap() { // from class: androidx.appcompat.util.SeslKoreanGeneralizer.2
        {
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = Boolean.FALSE;
            put('0', new Pair(bool, bool2));
            put('1', new Pair(bool, bool));
            put('2', new Pair(bool2, bool2));
            put('3', new Pair(bool, bool2));
            put('4', new Pair(bool2, bool2));
            put('5', new Pair(bool2, bool2));
            put('6', new Pair(bool, bool2));
            put('7', new Pair(bool, bool));
            put('8', new Pair(bool, bool));
            put('9', new Pair(bool2, bool2));
            put('%', new Pair(bool2, bool2));
            put((char) 65285, new Pair(bool2, bool2));
            put('$', new Pair(bool2, bool2));
            put('#', new Pair(bool, bool2));
            put((char) 8451, new Pair(bool2, bool2));
            put((char) 8457, new Pair(bool2, bool2));
            put((char) 13221, new Pair(bool2, bool2));
            put('+', new Pair(bool2, bool2));
            put(Character.valueOf(Typography.degree), new Pair(bool2, bool2));
            put((char) 186, new Pair(bool2, bool2));
            put((char) 13252, new Pair(bool2, bool2));
            put((char) 13206, new Pair(bool2, bool2));
            put((char) 8467, new Pair(bool2, bool2));
            put((char) 13256, new Pair(bool, bool));
            put((char) 13189, new Pair(bool2, bool2));
            put((char) 13190, new Pair(bool2, bool2));
            put((char) 13191, new Pair(bool2, bool2));
            put((char) 13268, new Pair(bool2, bool2));
        }
    };
    private static final String HAS_JOSA_REGEX = "(?s)(.*)\\((.+)\\)(.*)";
    private static final Pattern HAS_JOSA_PATTERN = Pattern.compile(HAS_JOSA_REGEX);

    private Boolean checkIfEndsWithKoreanJongSung(int i, Boolean bool) {
        if (44032 > i || i > 55203) {
            return null;
        }
        int i2 = (i - 44032) % 28;
        if (bool.booleanValue() && (i2 == 0 || i2 == 8)) {
            i2 = 0;
        }
        return Boolean.valueOf(i2 > 0);
    }

    private Boolean checkIfEndsWithPronounceableSymbols(char c, Boolean bool) {
        Pair<Boolean, Boolean> pair = this.PRONOUNCEABLE_SYMBOLS.get(Character.valueOf(c));
        if (pair == null) {
            return null;
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        if (((Boolean) pair.second).booleanValue() && bool.booleanValue()) {
            zBooleanValue = !zBooleanValue;
        }
        return Boolean.valueOf(zBooleanValue);
    }

    private Boolean hasJosaInString(String str) {
        return Boolean.valueOf(HAS_JOSA_PATTERN.matcher(str).matches());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c3 A[SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String naturalize(@NonNull String str) {
        String next;
        String str2;
        String str3;
        boolean z;
        char cCharAt;
        Boolean boolCheckIfEndsWithKoreanJongSung;
        if (str.isEmpty()) {
            return "";
        }
        if (!hasJosaInString(str).booleanValue()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = 0;
        char c = 0;
        while (length < str.length()) {
            String strSubstring = str.substring(length);
            Iterator<String> it = this.JOSA_KOREAN_MAP.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (strSubstring.startsWith(next)) {
                    break;
                }
            }
            if (next == null || next.isEmpty()) {
                str2 = "";
                next = str2;
                str3 = next;
            } else {
                str2 = (String) this.JOSA_KOREAN_MAP.get(next).first;
                str3 = (String) this.JOSA_KOREAN_MAP.get(next).second;
                if (next.equals("(으)로")) {
                    z = true;
                }
                cCharAt = str.charAt(length);
                if (str2.isEmpty() || !str3.isEmpty()) {
                    boolCheckIfEndsWithKoreanJongSung = checkIfEndsWithKoreanJongSung(c, Boolean.valueOf(z));
                    if (boolCheckIfEndsWithKoreanJongSung == null) {
                        boolCheckIfEndsWithKoreanJongSung = checkIfEndsWithPronounceableSymbols(c, Boolean.valueOf(z));
                    }
                    if (boolCheckIfEndsWithKoreanJongSung == null) {
                        if (!boolCheckIfEndsWithKoreanJongSung.booleanValue()) {
                            str2 = str3;
                        }
                        sb.append(str2);
                        length += next.length() - 1;
                        cCharAt = AbstractC0000a.m4a(1, str2);
                    } else {
                        sb.append(cCharAt);
                    }
                } else {
                    sb.append(cCharAt);
                }
                if (NON_PRONOUNCEABLE_CHARACTERS.indexOf(cCharAt) >= 0) {
                    c = cCharAt;
                }
                length++;
            }
            z = false;
            cCharAt = str.charAt(length);
            if (str2.isEmpty()) {
                boolCheckIfEndsWithKoreanJongSung = checkIfEndsWithKoreanJongSung(c, Boolean.valueOf(z));
                if (boolCheckIfEndsWithKoreanJongSung == null) {
                }
                if (boolCheckIfEndsWithKoreanJongSung == null) {
                }
            }
            if (NON_PRONOUNCEABLE_CHARACTERS.indexOf(cCharAt) >= 0) {
            }
            length++;
        }
        return sb.toString();
    }

    @NonNull
    public String naturalizeText(@NonNull String str) {
        return naturalize(str);
    }
}
