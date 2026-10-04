package com.google.android.gms.internal.drive;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;

/* JADX INFO: loaded from: classes5.dex */
final class zznk extends zznh {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zznf.zzay(i);
        }
        if (i2 == 1) {
            return zznf.zzr(i, zznd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zznf.zzc(i, zznd.zza(bArr, j), zznd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0094, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.drive.zznh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(int i, byte[] bArr, int i2, int i4) {
        int i5;
        long j;
        if ((i2 | i4 | (bArr.length - i4)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
        long j2 = i2;
        int i6 = (int) (((long) i4) - j2);
        byte b = 0;
        long j3 = 1;
        if (i6 >= 16) {
            long j5 = j2;
            i5 = 0;
            while (true) {
                if (i5 >= i6) {
                    i5 = i6;
                    break;
                }
                long j6 = j5 + 1;
                if (zznd.zza(bArr, j5) < 0) {
                    break;
                }
                i5++;
                j5 = j6;
            }
        } else {
            i5 = 0;
        }
        int i7 = i6 - i5;
        long j7 = j2 + ((long) i5);
        while (true) {
            byte bZza = b;
            while (true) {
                if (i7 <= 0) {
                    break;
                }
                long j8 = j7 + j3;
                bZza = zznd.zza(bArr, j7);
                if (bZza < 0) {
                    j7 = j8;
                    break;
                }
                i7--;
                j7 = j8;
            }
            if (i7 == 0) {
                return b;
            }
            int i8 = i7 - 1;
            if (bZza >= -32) {
                if (bZza >= -16) {
                    j = j3;
                    if (i8 >= 3) {
                        i7 -= 4;
                        long j9 = j7 + j;
                        byte bZza2 = zznd.zza(bArr, j7);
                        if (bZza2 > -65) {
                            break;
                        }
                        if ((((bZza2 + SprAttributeBase.TYPE_SHADOW) + (bZza << 28)) >> 30) != 0) {
                            break;
                        }
                        long j10 = 2 + j7;
                        if (zznd.zza(bArr, j9) > -65) {
                            break;
                        }
                        j7 += 3;
                        if (zznd.zza(bArr, j10) > -65) {
                            break;
                        }
                    } else {
                        return zza(bArr, bZza, j7, i8);
                    }
                } else {
                    if (i8 < 2) {
                        return zza(bArr, bZza, j7, i8);
                    }
                    i7 -= 3;
                    j = j3;
                    long j11 = j7 + j;
                    byte bZza3 = zznd.zza(bArr, j7);
                    if (bZza3 > -65 || ((bZza == -32 && bZza3 < -96) || (bZza == -19 && bZza3 >= -96))) {
                        break;
                    }
                    j7 += 2;
                    if (zznd.zza(bArr, j11) > -65) {
                        break;
                    }
                }
            } else if (i8 != 0) {
                i7 -= 2;
                if (bZza < -62) {
                    break;
                }
                long j12 = j7 + j3;
                if (zznd.zza(bArr, j7) > -65) {
                    break;
                }
                j = j3;
                j7 = j12;
            } else {
                return bZza;
            }
            j3 = j;
            b = 0;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.drive.zznh
    public final String zzg(byte[] bArr, int i, int i2) throws zzkq {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte bZza = zznd.zza(bArr, i);
            if (!zzng.zzd(bZza)) {
                break;
            }
            i++;
            zzng.zza(bZza, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte bZza2 = zznd.zza(bArr, i);
            if (zzng.zzd(bZza2)) {
                int i8 = i6 + 1;
                zzng.zza(bZza2, cArr, i6);
                while (i7 < i4) {
                    byte bZza3 = zznd.zza(bArr, i7);
                    if (!zzng.zzd(bZza3)) {
                        break;
                    }
                    i7++;
                    zzng.zza(bZza3, cArr, i8);
                    i8++;
                }
                i6 = i8;
                i = i7;
            } else if (zzng.zze(bZza2)) {
                if (i7 >= i4) {
                    throw zzkq.zzdn();
                }
                i += 2;
                zzng.zza(bZza2, zznd.zza(bArr, i7), cArr, i6);
                i6++;
            } else if (zzng.zzf(bZza2)) {
                if (i7 >= i4 - 1) {
                    throw zzkq.zzdn();
                }
                int i9 = i + 2;
                i += 3;
                zzng.zza(bZza2, zznd.zza(bArr, i7), zznd.zza(bArr, i9), cArr, i6);
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw zzkq.zzdn();
                }
                byte bZza4 = zznd.zza(bArr, i7);
                int i10 = i + 3;
                byte bZza5 = zznd.zza(bArr, i + 2);
                i += 4;
                zzng.zza(bZza2, bZza4, bZza5, zznd.zza(bArr, i10), cArr, i6);
                i6 += 2;
            }
        }
        return new String(cArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.drive.zznh
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        int i4;
        char cCharAt;
        long j5 = i;
        long j6 = ((long) i2) + j5;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            j = 1;
            if (i5 >= length || (cCharAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            zznd.zza(bArr, j5, (byte) cCharAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 == length) {
            return (int) j5;
        }
        while (i5 < length) {
            char cCharAt3 = charSequence.charAt(i5);
            if (cCharAt3 < 128 && j5 < j6) {
                zznd.zza(bArr, j5, (byte) cCharAt3);
                j3 = j6;
                j2 = j;
                j5 += j;
            } else if (cCharAt3 >= 2048 || j5 > j6 - 2) {
                j2 = j;
                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j5 > j6 - 3) {
                    j3 = j6;
                    if (j5 <= j3 - 4) {
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char cCharAt4 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                zznd.zza(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                zznd.zza(bArr, j5 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j7 = j5 + 3;
                                zznd.zza(bArr, j5 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j5 += 4;
                                zznd.zza(bArr, j7, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new zznj(i5 - 1, length);
                    }
                    if (55296 > cCharAt3 || cCharAt3 > 57343 || ((i4 = i5 + 1) != length && Character.isSurrogatePair(cCharAt3, charSequence.charAt(i4)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j5);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    throw new zznj(i5, length);
                }
                zznd.zza(bArr, j5, (byte) ((cCharAt3 >>> '\f') | 480));
                long j8 = j5 + 2;
                j3 = j6;
                zznd.zza(bArr, j5 + j2, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                j5 += 3;
                zznd.zza(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
            } else {
                j2 = j;
                long j9 = j5 + j2;
                zznd.zza(bArr, j5, (byte) ((cCharAt3 >>> 6) | 960));
                j5 += 2;
                zznd.zza(bArr, j9, (byte) ((cCharAt3 & '?') | 128));
                j3 = j6;
            }
            i5++;
            j = j2;
            j6 = j3;
        }
        return (int) j5;
    }
}
