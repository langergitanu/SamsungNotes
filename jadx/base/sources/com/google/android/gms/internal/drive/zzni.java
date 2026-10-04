package com.google.android.gms.internal.drive;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;

/* JADX INFO: loaded from: classes5.dex */
final class zzni extends zznh {
    @Override // com.google.android.gms.internal.drive.zznh
    public final int zzb(int i, byte[] bArr, int i2, int i4) {
        while (i2 < i4 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i4) {
            return 0;
        }
        while (i2 < i4) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i5 >= i4) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 += 2;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i5 >= i4 - 1) {
                        return zznf.zzf(bArr, i5, i4);
                    }
                    int i6 = i2 + 2;
                    byte b5 = bArr[i5];
                    if (b5 <= -65 && ((b != -32 || b5 >= -96) && (b != -19 || b5 < -96))) {
                        i2 += 3;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                if (i5 >= i4 - 2) {
                    return zznf.zzf(bArr, i5, i4);
                }
                int i7 = i2 + 2;
                byte b6 = bArr[i5];
                if (b6 <= -65) {
                    if ((((b6 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0) {
                        int i8 = i2 + 3;
                        if (bArr[i7] <= -65) {
                            i2 += 4;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i2 = i5;
        }
        return 0;
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
            byte b = bArr[i];
            if (!zzng.zzd(b)) {
                break;
            }
            i++;
            zzng.zza(b, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b5 = bArr[i];
            if (zzng.zzd(b5)) {
                int i8 = i6 + 1;
                zzng.zza(b5, cArr, i6);
                int i9 = i7;
                while (i9 < i4) {
                    byte b6 = bArr[i9];
                    if (!zzng.zzd(b6)) {
                        break;
                    }
                    i9++;
                    zzng.zza(b6, cArr, i8);
                    i8++;
                }
                i6 = i8;
                i = i9;
            } else if (zzng.zze(b5)) {
                if (i7 >= i4) {
                    throw zzkq.zzdn();
                }
                i += 2;
                zzng.zza(b5, bArr[i7], cArr, i6);
                i6++;
            } else if (zzng.zzf(b5)) {
                if (i7 >= i4 - 1) {
                    throw zzkq.zzdn();
                }
                int i10 = i + 2;
                i += 3;
                zzng.zza(b5, bArr[i7], bArr[i10], cArr, i6);
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw zzkq.zzdn();
                }
                byte b7 = bArr[i7];
                int i11 = i + 3;
                byte b8 = bArr[i + 2];
                i += 4;
                zzng.zza(b5, b7, b8, bArr[i11], cArr, i6);
                i6 += 2;
            }
        }
        return new String(cArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.drive.zznh
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i4;
        int i5;
        char cCharAt;
        int length = charSequence.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char cCharAt2 = charSequence.charAt(i7);
            if (cCharAt2 < 128 && i8 < i6) {
                bArr[i8] = (byte) cCharAt2;
                i8++;
            } else if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                i8 += 2;
                bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                    if (i8 <= i6 - 4) {
                        int i10 = i7 + 1;
                        if (i10 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i10);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i11 = i8 + 3;
                                bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i8 += 4;
                                bArr[i11] = (byte) ((codePoint & 63) | 128);
                                i7 = i10;
                            } else {
                                i7 = i10;
                            }
                        }
                        throw new zznj(i7 - 1, length);
                    }
                    if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                        throw new zznj(i7, length);
                    }
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Failed writing ");
                    sb.append(cCharAt2);
                    sb.append(" at index ");
                    sb.append(i8);
                    throw new ArrayIndexOutOfBoundsException(sb.toString());
                }
                bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i12 = i8 + 2;
                bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i8 += 3;
                bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
            }
            i7++;
        }
        return i8;
    }
}
