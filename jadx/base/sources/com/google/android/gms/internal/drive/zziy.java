package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zziy {
    public static int zza(byte[] bArr, int i, zziz zzizVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzizVar);
        }
        zzizVar.zznk = b;
        return i2;
    }

    public static int zzb(byte[] bArr, int i, zziz zzizVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzizVar.zznl = j;
            return i2;
        }
        int i4 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i5 = 7;
        while (b < 0) {
            int i6 = i4 + 1;
            byte b5 = bArr[i4];
            i5 += 7;
            j2 |= ((long) (b5 & 127)) << i5;
            b = b5;
            i4 = i6;
        }
        zzizVar.zznl = j2;
        return i4;
    }

    public static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    public static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    public static int zze(byte[] bArr, int i, zziz zzizVar) {
        int iZza = zza(bArr, i, zzizVar);
        int i2 = zzizVar.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        }
        if (i2 > bArr.length - iZza) {
            throw zzkq.zzdi();
        }
        if (i2 == 0) {
            zzizVar.zznm = zzjc.zznq;
            return iZza;
        }
        zzizVar.zznm = zzjc.zzb(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zzc(byte[] bArr, int i, zziz zzizVar) {
        int iZza = zza(bArr, i, zzizVar);
        int i2 = zzizVar.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        }
        if (i2 == 0) {
            zzizVar.zznm = "";
            return iZza;
        }
        zzizVar.zznm = new String(bArr, iZza, i2, zzkm.UTF_8);
        return iZza + i2;
    }

    public static int zzd(byte[] bArr, int i, zziz zzizVar) {
        int iZza = zza(bArr, i, zzizVar);
        int i2 = zzizVar.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        }
        if (i2 == 0) {
            zzizVar.zznm = "";
            return iZza;
        }
        zzizVar.zznm = zznf.zzg(bArr, iZza, i2);
        return iZza + i2;
    }

    public static int zza(int i, byte[] bArr, int i2, zziz zzizVar) {
        int i4 = i & 127;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzizVar.zznk = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & 127) << 7);
        int i7 = i2 + 2;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzizVar.zznk = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & 127) << 14);
        int i9 = i2 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzizVar.zznk = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & 127) << 21);
        int i11 = i2 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzizVar.zznk = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzizVar.zznk = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zza(zzmf zzmfVar, byte[] bArr, int i, int i2, zziz zzizVar) {
        int iZza = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iZza = zza(i4, bArr, iZza, zzizVar);
            i4 = zzizVar.zznk;
        }
        int i5 = iZza;
        if (i4 >= 0 && i4 <= i2 - i5) {
            Object objNewInstance = zzmfVar.newInstance();
            int i6 = i5 + i4;
            zzmfVar.zza(objNewInstance, bArr, i5, i6, zzizVar);
            zzmfVar.zzd(objNewInstance);
            zzizVar.zznm = objNewInstance;
            return i6;
        }
        throw zzkq.zzdi();
    }

    public static int zza(zzmf zzmfVar, byte[] bArr, int i, int i2, int i4, zziz zzizVar) {
        zzlu zzluVar = (zzlu) zzmfVar;
        Object objNewInstance = zzluVar.newInstance();
        int iZza = zzluVar.zza(objNewInstance, bArr, i, i2, i4, zzizVar);
        zzluVar.zzd(objNewInstance);
        zzizVar.zznm = objNewInstance;
        return iZza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i4, zzkp<?> zzkpVar, zziz zzizVar) {
        zzkl zzklVar = (zzkl) zzkpVar;
        int iZza = zza(bArr, i2, zzizVar);
        zzklVar.zzam(zzizVar.zznk);
        while (iZza < i4) {
            int iZza2 = zza(bArr, iZza, zzizVar);
            if (i != zzizVar.zznk) {
                break;
            }
            iZza = zza(bArr, iZza2, zzizVar);
            zzklVar.zzam(zzizVar.zznk);
        }
        return iZza;
    }

    public static int zza(byte[] bArr, int i, zzkp<?> zzkpVar, zziz zzizVar) {
        zzkl zzklVar = (zzkl) zzkpVar;
        int iZza = zza(bArr, i, zzizVar);
        int i2 = zzizVar.zznk + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzizVar);
            zzklVar.zzam(zzizVar.zznk);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzkq.zzdi();
    }

    public static int zza(zzmf<?> zzmfVar, int i, byte[] bArr, int i2, int i4, zzkp<?> zzkpVar, zziz zzizVar) {
        int iZza = zza(zzmfVar, bArr, i2, i4, zzizVar);
        zzkpVar.add(zzizVar.zznm);
        while (iZza < i4) {
            int iZza2 = zza(bArr, iZza, zzizVar);
            if (i != zzizVar.zznk) {
                break;
            }
            iZza = zza(zzmfVar, bArr, iZza2, i4, zzizVar);
            zzkpVar.add(zzizVar.zznm);
        }
        return iZza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i4, zzmy zzmyVar, zziz zzizVar) {
        if ((i >>> 3) == 0) {
            throw zzkq.zzdk();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int iZzb = zzb(bArr, i2, zzizVar);
            zzmyVar.zzb(i, Long.valueOf(zzizVar.zznl));
            return iZzb;
        }
        if (i5 == 1) {
            zzmyVar.zzb(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i5 == 2) {
            int iZza = zza(bArr, i2, zzizVar);
            int i6 = zzizVar.zznk;
            if (i6 >= 0) {
                if (i6 > bArr.length - iZza) {
                    throw zzkq.zzdi();
                }
                if (i6 == 0) {
                    zzmyVar.zzb(i, zzjc.zznq);
                } else {
                    zzmyVar.zzb(i, zzjc.zzb(bArr, iZza, i6));
                }
                return iZza + i6;
            }
            throw zzkq.zzdj();
        }
        if (i5 != 3) {
            if (i5 == 5) {
                zzmyVar.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
            throw zzkq.zzdk();
        }
        zzmy zzmyVarZzfb = zzmy.zzfb();
        int i7 = (i & (-8)) | 4;
        int i8 = 0;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzizVar);
            i8 = zzizVar.zznk;
            if (i8 == i7) {
                i2 = iZza2;
                break;
            }
            i2 = zza(i8, bArr, iZza2, i4, zzmyVarZzfb, zzizVar);
        }
        if (i2 <= i4 && i8 == i7) {
            zzmyVar.zzb(i, zzmyVarZzfb);
            return i2;
        }
        throw zzkq.zzdm();
    }

    public static int zza(int i, byte[] bArr, int i2, int i4, zziz zzizVar) {
        if ((i >>> 3) == 0) {
            throw zzkq.zzdk();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            return zzb(bArr, i2, zzizVar);
        }
        if (i5 == 1) {
            return i2 + 8;
        }
        if (i5 == 2) {
            return zza(bArr, i2, zzizVar) + zzizVar.zznk;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i2 + 4;
            }
            throw zzkq.zzdk();
        }
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i4) {
            i2 = zza(bArr, i2, zzizVar);
            i7 = zzizVar.zznk;
            if (i7 == i6) {
                break;
            }
            i2 = zza(i7, bArr, i2, i4, zzizVar);
        }
        if (i2 > i4 || i7 != i6) {
            throw zzkq.zzdm();
        }
        return i2;
    }
}
