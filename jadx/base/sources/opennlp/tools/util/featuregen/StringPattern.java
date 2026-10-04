package opennlp.tools.util.featuregen;

import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.lang.Character;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringPattern {
    private static final int ALL_CAPITAL_LETTER = 2;
    private static final int ALL_DIGIT = 16;
    private static final int ALL_HIRAGANA = 32;
    private static final int ALL_KATAKANA = 64;
    private static final int ALL_LETTERS = 8;
    private static final int ALL_LOWERCASE_LETTER = 4;
    private static final int CONTAINS_COMMA = 256;
    private static final int CONTAINS_DIGIT = 1024;
    private static final int CONTAINS_HYPHEN = 2048;
    private static final int CONTAINS_LETTERS = 4096;
    private static final int CONTAINS_PERIOD = 128;
    private static final int CONTAINS_SLASH = 512;
    private static final int CONTAINS_UPPERCASE = 8192;
    private static final int INITAL_CAPITAL_LETTER = 1;
    private final int digits;
    private final int pattern;

    private StringPattern(int i, int i2) {
        this.pattern = i;
        this.digits = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringPattern recognize(String str) {
        int i = 126;
        int i2 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            int type = Character.getType(cCharAt);
            if (type != 1 && type != 2 && type != 3 && type != 4 && type != 5) {
                int i5 = i & (-15);
                if (type == 9) {
                    i = (i5 | 1024) & (-97);
                    i2++;
                } else {
                    i &= -31;
                }
                switch (cCharAt) {
                    case ',':
                        i |= 256;
                        break;
                    case '-':
                        i |= 2048;
                        break;
                    case '.':
                        i |= 128;
                        break;
                    case '/':
                        i |= 512;
                        break;
                }
            } else {
                int i6 = i | 4096;
                int i7 = i6 & (-17);
                if (type == 1) {
                    if (i4 == 0) {
                        i7 |= 1;
                    }
                    i = (i7 | 8192) & (-5);
                } else {
                    i = i6 & (-19);
                }
            }
            Character.UnicodeScript unicodeScriptOf = Character.UnicodeScript.of(str.codePointAt(i4));
            if (unicodeScriptOf != Character.UnicodeScript.COMMON) {
                if (unicodeScriptOf == Character.UnicodeScript.LATIN) {
                    i &= -97;
                } else if (unicodeScriptOf == Character.UnicodeScript.HAN) {
                    i &= LttEngineErrors.ERROR_INPAINTING_FAILED;
                } else if (unicodeScriptOf == Character.UnicodeScript.HIRAGANA) {
                    i &= -69;
                } else if (unicodeScriptOf == Character.UnicodeScript.KATAKANA) {
                    i &= -37;
                }
            } else if (cCharAt == 12539 || cCharAt == 12540 || cCharAt == 12316) {
            }
        }
        return new StringPattern(i, i2);
    }

    public boolean containsComma() {
        return (this.pattern & 256) > 0;
    }

    public boolean containsDigit() {
        return (this.pattern & 1024) > 0;
    }

    public boolean containsHyphen() {
        return (this.pattern & 2048) > 0;
    }

    public boolean containsLetters() {
        return (this.pattern & 4096) > 0;
    }

    public boolean containsPeriod() {
        return (this.pattern & 128) > 0;
    }

    public boolean containsSlash() {
        return (this.pattern & 512) > 0;
    }

    public int digits() {
        return this.digits;
    }

    public boolean isAllCapitalLetter() {
        return (this.pattern & 2) > 0;
    }

    public boolean isAllDigit() {
        return (this.pattern & 16) > 0;
    }

    public boolean isAllHiragana() {
        return (this.pattern & 32) > 0;
    }

    public boolean isAllKatakana() {
        return (this.pattern & 64) > 0;
    }

    public boolean isAllLetter() {
        return (this.pattern & 8) > 0;
    }

    public boolean isAllLowerCaseLetter() {
        return (this.pattern & 4) > 0;
    }

    public boolean isInitialCapitalLetter() {
        return (this.pattern & 1) > 0;
    }
}
