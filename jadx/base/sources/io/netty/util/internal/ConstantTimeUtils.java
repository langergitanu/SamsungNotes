package io.netty.util.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ConstantTimeUtils {
    private ConstantTimeUtils() {
    }

    public static int equalsConstantTime(int i, int i2) {
        int i4 = ~(i ^ i2);
        int i5 = i4 & (i4 >> 16);
        int i6 = i5 & (i5 >> 8);
        int i7 = i6 & (i6 >> 4);
        int i8 = i7 & (i7 >> 2);
        return i8 & (i8 >> 1) & 1;
    }

    public static int equalsConstantTime(long j, long j2) {
        long j3 = ~(j ^ j2);
        long j5 = j3 & (j3 >> 32);
        long j6 = j5 & (j5 >> 16);
        long j7 = j6 & (j6 >> 8);
        long j8 = j7 & (j7 >> 4);
        long j9 = j8 & (j8 >> 2);
        return (int) (j9 & (j9 >> 1) & 1);
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i4) {
        int i5 = i4 + i;
        int i6 = 0;
        while (i < i5) {
            i6 |= bArr[i] ^ bArr2[i2];
            i++;
            i2++;
        }
        return equalsConstantTime(i6, 0);
    }

    public static int equalsConstantTime(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return 0;
        }
        int iCharAt = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            iCharAt |= charSequence.charAt(i) ^ charSequence2.charAt(i);
        }
        return equalsConstantTime(iCharAt, 0);
    }
}
