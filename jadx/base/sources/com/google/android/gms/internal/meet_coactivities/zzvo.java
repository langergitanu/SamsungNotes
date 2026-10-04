package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzvo {
    static {
        if (zzvl.zzx() && zzvl.zzy()) {
            int i = zzrd.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        int i4 = i2 - i;
        byte b = bArr[i - 1];
        if (i4 == 0) {
            if (b <= -12) {
                return b;
            }
            return -1;
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

    public static int zzb(String str, byte[] bArr, int i, int i2) {
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int length = str.length();
        int i7 = 0;
        while (true) {
            i4 = i + i2;
            if (i7 >= length || (i6 = i7 + i) >= i4 || (cCharAt = str.charAt(i7)) >= 128) {
                break;
            }
            bArr[i6] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 128 && i8 < i4) {
                bArr[i8] = (byte) cCharAt2;
                i8++;
            } else if (cCharAt2 < 2048 && i8 <= i4 - 2) {
                bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i8 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i8 > i4 - 3) {
                    if (i8 > i4 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i5 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i5)))) {
                            throw new zzvn(i7, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                    }
                    int i9 = i7 + 1;
                    if (i9 != str.length()) {
                        char cCharAt3 = str.charAt(i9);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i10 = i8 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 += 4;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                            i7 = i9;
                        } else {
                            i7 = i9;
                        }
                    }
                    throw new zzvn(i7 - 1, length);
                }
                bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i8 += 3;
            }
            i7++;
        }
        return i8;
    }

    public static int zzc(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i4 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                int length2 = str.length();
                while (i2 < length2) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) < 65536) {
                                throw new zzvn(i2, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i4) + 4294967296L));
    }

    public static String zzd(byte[] bArr, int i, int i2) throws zzti {
        int i4;
        int length = bArr.length;
        if ((((length - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i5 = i + i2;
        char[] cArr = new char[i2];
        int i6 = 0;
        while (i < i5) {
            byte b = bArr[i];
            if (!zzvm.zzd(b)) {
                break;
            }
            i++;
            cArr[i6] = (char) b;
            i6++;
        }
        int i7 = i6;
        while (i < i5) {
            int i8 = i + 1;
            byte b5 = bArr[i];
            if (zzvm.zzd(b5)) {
                cArr[i7] = (char) b5;
                i7++;
                i = i8;
                while (i < i5) {
                    byte b6 = bArr[i];
                    if (zzvm.zzd(b6)) {
                        i++;
                        cArr[i7] = (char) b6;
                        i7++;
                    }
                }
            } else {
                if (b5 < -32) {
                    if (i8 >= i5) {
                        throw zzti.zzd();
                    }
                    i4 = i7 + 1;
                    i += 2;
                    zzvm.zzc(b5, bArr[i8], cArr, i7);
                } else if (b5 < -16) {
                    if (i8 >= i5 - 1) {
                        throw zzti.zzd();
                    }
                    i4 = i7 + 1;
                    int i9 = i + 2;
                    i += 3;
                    zzvm.zzb(b5, bArr[i8], bArr[i9], cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw zzti.zzd();
                    }
                    byte b7 = bArr[i8];
                    int i10 = i + 3;
                    byte b8 = bArr[i + 2];
                    i += 4;
                    zzvm.zza(b5, b7, b8, bArr[i10], cArr, i7);
                    i7 += 2;
                }
                i7 = i4;
            }
        }
        return new String(cArr, 0, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zze(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return true;
        }
        while (i < i2) {
            int i4 = i + 1;
            int iZza = bArr[i];
            if (iZza >= 0) {
                i = i4;
            } else if (iZza < -32) {
                if (i4 >= i2) {
                    return iZza == 0;
                }
                if (iZza < -62) {
                    return false;
                }
                i += 2;
                if (bArr[i4] > -65) {
                    return false;
                }
            } else if (iZza < -16) {
                if (i4 >= i2 - 1) {
                    iZza = zza(bArr, i4, i2);
                    if (iZza == 0) {
                    }
                } else {
                    int i5 = i + 2;
                    char c = bArr[i4];
                    if (c > -65) {
                        return false;
                    }
                    if (iZza == -32 && c < -96) {
                        return false;
                    }
                    if (iZza == -19 && c >= -96) {
                        return false;
                    }
                    i += 3;
                    if (bArr[i5] > -65) {
                        return false;
                    }
                }
            } else if (i4 >= i2 - 2) {
                iZza = zza(bArr, i4, i2);
                if (iZza == 0) {
                }
            } else {
                int i6 = i + 2;
                int i7 = bArr[i4];
                if (i7 > -65) {
                    return false;
                }
                if ((((i7 + 112) + (iZza << 28)) >> 30) != 0) {
                    return false;
                }
                int i8 = i + 3;
                if (bArr[i6] > -65) {
                    return false;
                }
                i += 4;
                if (bArr[i8] > -65) {
                    return false;
                }
            }
        }
        return true;
    }
}
