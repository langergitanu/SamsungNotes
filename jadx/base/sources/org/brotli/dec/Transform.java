package org.brotli.dec;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Transform {
    static final Transform[] TRANSFORMS = {new Transform("", 0, ""), new Transform("", 0, " "), new Transform(" ", 0, " "), new Transform("", 12, ""), new Transform("", 10, " "), new Transform("", 0, " the "), new Transform(" ", 0, ""), new Transform("s ", 0, " "), new Transform("", 0, " of "), new Transform("", 10, ""), new Transform("", 0, " and "), new Transform("", 13, ""), new Transform("", 1, ""), new Transform(SQLKeyword.COMMA, 0, " "), new Transform("", 0, SQLKeyword.COMMA), new Transform(" ", 10, " "), new Transform("", 0, " in "), new Transform("", 0, " to "), new Transform("e ", 0, " "), new Transform("", 0, "\""), new Transform("", 0, Extension.DOT), new Transform("", 0, "\">"), new Transform("", 0, "\n"), new Transform("", 3, ""), new Transform("", 0, "]"), new Transform("", 0, " for "), new Transform("", 14, ""), new Transform("", 2, ""), new Transform("", 0, " a "), new Transform("", 0, " that "), new Transform(" ", 10, ""), new Transform("", 0, ". "), new Transform(Extension.DOT, 0, ""), new Transform(" ", 0, SQLKeyword.COMMA), new Transform("", 15, ""), new Transform("", 0, " with "), new Transform("", 0, "'"), new Transform("", 0, " from "), new Transform("", 0, " by "), new Transform("", 16, ""), new Transform("", 17, ""), new Transform(" the ", 0, ""), new Transform("", 4, ""), new Transform("", 0, ". The "), new Transform("", 11, ""), new Transform("", 0, " on "), new Transform("", 0, " as "), new Transform("", 0, " is "), new Transform("", 7, ""), new Transform("", 1, "ing "), new Transform("", 0, "\n\t"), new Transform("", 0, ":"), new Transform(" ", 0, ". "), new Transform("", 0, "ed "), new Transform("", 20, ""), new Transform("", 18, ""), new Transform("", 6, ""), new Transform("", 0, "("), new Transform("", 10, SQLKeyword.COMMA), new Transform("", 8, ""), new Transform("", 0, " at "), new Transform("", 0, "ly "), new Transform(" the ", 0, " of "), new Transform("", 5, ""), new Transform("", 9, ""), new Transform(" ", 10, SQLKeyword.COMMA), new Transform("", 10, "\""), new Transform(Extension.DOT, 0, "("), new Transform("", 11, " "), new Transform("", 10, "\">"), new Transform("", 0, "=\""), new Transform(" ", 0, Extension.DOT), new Transform(".com/", 0, ""), new Transform(" the ", 0, " of the "), new Transform("", 10, "'"), new Transform("", 0, ". This "), new Transform("", 0, ","), new Transform(Extension.DOT, 0, " "), new Transform("", 10, "("), new Transform("", 10, Extension.DOT), new Transform("", 0, " not "), new Transform(" ", 0, "=\""), new Transform("", 0, "er "), new Transform(" ", 11, " "), new Transform("", 0, "al "), new Transform(" ", 11, ""), new Transform("", 0, "='"), new Transform("", 11, "\""), new Transform("", 10, ". "), new Transform(" ", 0, "("), new Transform("", 0, "ful "), new Transform(" ", 10, ". "), new Transform("", 0, "ive "), new Transform("", 0, "less "), new Transform("", 11, "'"), new Transform("", 0, "est "), new Transform(" ", 10, Extension.DOT), new Transform("", 11, "\">"), new Transform(" ", 0, "='"), new Transform("", 10, ","), new Transform("", 0, "ize "), new Transform("", 11, Extension.DOT), new Transform("Â ", 0, ""), new Transform(" ", 0, ","), new Transform("", 10, "=\""), new Transform("", 11, "=\""), new Transform("", 0, "ous "), new Transform("", 11, SQLKeyword.COMMA), new Transform("", 10, "='"), new Transform(" ", 10, ","), new Transform(" ", 11, "=\""), new Transform(" ", 11, SQLKeyword.COMMA), new Transform("", 11, ","), new Transform("", 11, "("), new Transform("", 11, ". "), new Transform(" ", 11, Extension.DOT), new Transform("", 11, "='"), new Transform(" ", 11, ". "), new Transform(" ", 10, "=\""), new Transform(" ", 11, "='"), new Transform(" ", 10, "='")};
    private final byte[] prefix;
    private final byte[] suffix;
    private final int type;

    public Transform(String str, int i, String str2) {
        this.prefix = readUniBytes(str);
        this.type = i;
        this.suffix = readUniBytes(str2);
    }

    public static byte[] readUniBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static int transformDictionaryWord(byte[] bArr, int i, byte[] bArr2, int i2, int i4, Transform transform) {
        int i5 = i;
        for (byte b : transform.prefix) {
            bArr[i5] = b;
            i5++;
        }
        int i6 = transform.type;
        int omitFirst = WordTransformType.getOmitFirst(i6);
        if (omitFirst > i4) {
            omitFirst = i4;
        }
        int i7 = i2 + omitFirst;
        int omitLast = (i4 - omitFirst) - WordTransformType.getOmitLast(i6);
        int i8 = omitLast;
        while (i8 > 0) {
            bArr[i5] = bArr2[i7];
            i8--;
            i5++;
            i7++;
        }
        if (i6 == 11 || i6 == 10) {
            int i9 = i5 - omitLast;
            if (i6 == 10) {
                omitLast = 1;
            }
            while (omitLast > 0) {
                byte b5 = bArr[i9];
                int i10 = b5 & 255;
                if (i10 < 192) {
                    if (i10 >= 97 && i10 <= 122) {
                        bArr[i9] = (byte) (b5 ^ 32);
                    }
                    i9++;
                    omitLast--;
                } else if (i10 < 224) {
                    int i11 = i9 + 1;
                    bArr[i11] = (byte) (bArr[i11] ^ 32);
                    i9 += 2;
                    omitLast -= 2;
                } else {
                    int i12 = i9 + 2;
                    bArr[i12] = (byte) (bArr[i12] ^ 5);
                    i9 += 3;
                    omitLast -= 3;
                }
            }
        }
        for (byte b6 : transform.suffix) {
            bArr[i5] = b6;
            i5++;
        }
        return i5 - i;
    }
}
