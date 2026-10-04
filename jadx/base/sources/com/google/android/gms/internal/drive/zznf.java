package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zznf {
    private static final zznh zzwt;

    static {
        zzwt = (zznd.zzfd() && zznd.zzfe() && !zzix.zzbr()) ? new zznk() : new zzni();
    }

    public static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i4 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zznj(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i4 += i;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i4) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzay(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzc(int i, int i2, int i4) {
        if (i > -12 || i2 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i4 << 16);
    }

    public static boolean zzd(byte[] bArr) {
        return zzwt.zze(bArr, 0, bArr.length);
    }

    public static boolean zze(byte[] bArr, int i, int i2) {
        return zzwt.zze(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzf(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i4 = i2 - i;
        if (i4 == 0) {
            return zzay(b);
        }
        if (i4 == 1) {
            return zzr(b, bArr[i]);
        }
        if (i4 == 2) {
            return zzc(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static String zzg(byte[] bArr, int i, int i2) {
        return zzwt.zzg(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzr(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzwt.zzb(charSequence, bArr, i, i2);
    }
}
