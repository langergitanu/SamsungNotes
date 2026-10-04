package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhm {
    private static final zzhk zza;

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
        zza = new zzhl();
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i4 = i2 - i;
        if (i4 == 0) {
            if (b > -12) {
                return -1;
            }
            return b;
        }
        if (i4 == 1) {
            byte b5 = bArr[i];
            if (b > -12 || b5 > -65) {
                return -1;
            }
            return (b5 << 8) ^ b;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        byte b6 = bArr[i];
        byte b7 = bArr[i + 1];
        if (b > -12 || b6 > -65 || b7 > -65) {
            return -1;
        }
        return (b7 << 16) ^ ((b6 << 8) ^ b);
    }

    public static String zzb(byte[] bArr, int i, int i2) throws zzfa {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = bArr[i];
            if (!zzhj.zzd(b)) {
                break;
            }
            i++;
            cArr[i5] = (char) b;
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b5 = bArr[i];
            if (zzhj.zzd(b5)) {
                cArr[i6] = (char) b5;
                i6++;
                i = i7;
                while (i < i4) {
                    byte b6 = bArr[i];
                    if (!zzhj.zzd(b6)) {
                        break;
                    }
                    i++;
                    cArr[i6] = (char) b6;
                    i6++;
                }
            } else if (b5 < -32) {
                if (i7 >= i4) {
                    throw zzfa.zzb();
                }
                i += 2;
                zzhj.zzc(b5, bArr[i7], cArr, i6);
                i6++;
            } else if (b5 < -16) {
                if (i7 >= i4 - 1) {
                    throw zzfa.zzb();
                }
                int i8 = i + 2;
                i += 3;
                zzhj.zzb(b5, bArr[i7], bArr[i8], cArr, i6);
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw zzfa.zzb();
                }
                int i9 = i + 2;
                int i10 = i + 3;
                i += 4;
                zzhj.zza(b5, bArr[i7], bArr[i9], bArr[i10], cArr, i6);
                i6 += 2;
            }
        }
        return new String(cArr, 0, i6);
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
