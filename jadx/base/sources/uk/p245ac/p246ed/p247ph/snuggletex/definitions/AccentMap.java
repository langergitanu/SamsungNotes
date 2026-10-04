package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class AccentMap {
    private static final int MAX_CODEPOINT = 128;
    private static final int MIN_CODEPOINT = 32;
    private final char[] textAccentByCodePoint = new char[96];
    private final char[] mathSafeAccentByCodePoint = new char[96];

    public AccentMap(char[] cArr, String str) {
        int i = 0;
        while (i < cArr.length) {
            int i2 = i + 1;
            char c = cArr[i];
            i += 2;
            char c2 = cArr[i2];
            int iCharToIndex = charToIndex(c);
            if (iCharToIndex != -1) {
                this.textAccentByCodePoint[iCharToIndex] = c2;
                if (str.indexOf(c) == -1) {
                    this.mathSafeAccentByCodePoint[iCharToIndex] = c2;
                }
            }
        }
    }

    private int charToIndex(int i) {
        int i2 = i - 32;
        if (i2 < 0 || i2 >= 128) {
            return -1;
        }
        return i2;
    }

    public char getAccentedMathChar(int i) {
        int iCharToIndex = charToIndex(i);
        if (iCharToIndex != -1) {
            return this.mathSafeAccentByCodePoint[iCharToIndex];
        }
        return (char) 0;
    }

    public char getAccentedTextChar(int i) {
        int iCharToIndex = charToIndex(i);
        if (iCharToIndex != -1) {
            return this.textAccentByCodePoint[iCharToIndex];
        }
        return (char) 0;
    }
}
