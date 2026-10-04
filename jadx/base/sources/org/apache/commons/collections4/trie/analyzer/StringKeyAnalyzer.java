package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    @Deprecated
    public StringKeyAnalyzer() {
    }

    private static int mask(int i) {
        return 32768 >>> i;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitIndex(String str, int i, int i2, String str2, int i4, int i5) {
        if (i % 16 != 0 || i4 % 16 != 0 || i2 % 16 != 0 || i5 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        int i6 = i / 16;
        int i7 = i4 / 16;
        int i8 = (i2 / 16) + i6;
        int i9 = (i5 / 16) + i7;
        int iMax = Math.max(i8, i9);
        boolean z = true;
        for (int i10 = 0; i10 < iMax; i10++) {
            int i11 = i6 + i10;
            int i12 = i7 + i10;
            char cCharAt = i11 >= i8 ? (char) 0 : str.charAt(i11);
            if (cCharAt != ((str2 == null || i12 >= i9) ? (char) 0 : str2.charAt(i12))) {
                return (Integer.numberOfLeadingZeros(cCharAt ^ r5) + (i10 * 16)) - 16;
            }
            if (cCharAt != 0) {
                z = false;
            }
        }
        return z ? -1 : -2;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isBitSet(String str, int i, int i2) {
        if (str != null && i < i2) {
            if ((str.charAt(i / 16) & mask(i % 16)) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isPrefix(String str, int i, int i2, String str2) {
        if (i % 16 == 0 && i2 % 16 == 0) {
            return str2.startsWith(str.substring(i / 16, i2 / 16));
        }
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }
}
