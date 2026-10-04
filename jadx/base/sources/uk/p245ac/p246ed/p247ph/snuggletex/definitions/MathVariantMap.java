package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathVariantMap {
    private static final int MAX_CODEPOINT = 128;
    private static final int MIN_CODEPOINT = 32;
    private final char[] accentByCodePoint = new char[96];
    private final String mathVariantName;

    public MathVariantMap(String str, char[] cArr) {
        this.mathVariantName = str;
        int i = 0;
        while (i < cArr.length) {
            int i2 = i + 1;
            char c = cArr[i];
            i += 2;
            char c2 = cArr[i2];
            int iCharToIndex = charToIndex(c);
            if (iCharToIndex != -1) {
                this.accentByCodePoint[iCharToIndex] = c2;
            }
        }
    }

    private int charToIndex(char c) {
        int i = c - ' ';
        if (i < 0 || i >= 128) {
            return -1;
        }
        return i;
    }

    public char getAccentedChar(char c) {
        int iCharToIndex = charToIndex(c);
        if (iCharToIndex != -1) {
            return this.accentByCodePoint[iCharToIndex];
        }
        return (char) 0;
    }

    public String getMathVariantName() {
        return this.mathVariantName;
    }
}
