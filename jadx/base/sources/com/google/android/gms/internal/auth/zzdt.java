package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdt {
    public static int zza(byte[] bArr, int i, zzds zzdsVar) {
        int iZzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzfa.zzf();
        }
        if (i2 == 0) {
            zzdsVar.zzc = zzee.zzb;
            return iZzj;
        }
        zzdsVar.zzc = zzee.zzk(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzc(zzgh zzghVar, byte[] bArr, int i, int i2, int i4, zzds zzdsVar) {
        zzfz zzfzVar = (zzfz) zzghVar;
        Object objZzd = zzfzVar.zzd();
        int iZzb = zzfzVar.zzb(objZzd, bArr, i, i2, i4, zzdsVar);
        zzfzVar.zze(objZzd);
        zzdsVar.zzc = objZzd;
        return iZzb;
    }

    public static int zzd(zzgh zzghVar, byte[] bArr, int i, int i2, zzds zzdsVar) {
        int iZzk = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iZzk = zzk(i4, bArr, iZzk, zzdsVar);
            i4 = zzdsVar.zza;
        }
        int i5 = iZzk;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzfa.zzf();
        }
        Object objZzd = zzghVar.zzd();
        int i6 = i5 + i4;
        zzghVar.zzg(objZzd, bArr, i5, i6, zzdsVar);
        zzghVar.zze(objZzd);
        zzdsVar.zzc = objZzd;
        return i6;
    }

    public static int zze(zzgh zzghVar, int i, byte[] bArr, int i2, int i4, zzey zzeyVar, zzds zzdsVar) {
        int iZzd = zzd(zzghVar, bArr, i2, i4, zzdsVar);
        zzeyVar.add(zzdsVar.zzc);
        while (iZzd < i4) {
            int iZzj = zzj(bArr, iZzd, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            iZzd = zzd(zzghVar, bArr, iZzj, i4, zzdsVar);
            zzeyVar.add(zzdsVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int iZzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzfa.zzf();
    }

    public static int zzg(byte[] bArr, int i, zzds zzdsVar) throws zzfa {
        int iZzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 == 0) {
            zzdsVar.zzc = "";
            return iZzj;
        }
        zzdsVar.zzc = new String(bArr, iZzj, i2, zzez.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzds zzdsVar) throws zzfa {
        int iZzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 == 0) {
            zzdsVar.zzc = "";
            return iZzj;
        }
        zzdsVar.zzc = zzhm.zzb(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i4, zzgz zzgzVar, zzds zzdsVar) {
        if ((i >>> 3) == 0) {
            throw zzfa.zza();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int iZzm = zzm(bArr, i2, zzdsVar);
            zzgzVar.zzf(i, Long.valueOf(zzdsVar.zzb));
            return iZzm;
        }
        if (i5 == 1) {
            zzgzVar.zzf(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i5 == 2) {
            int iZzj = zzj(bArr, i2, zzdsVar);
            int i6 = zzdsVar.zza;
            if (i6 < 0) {
                throw zzfa.zzc();
            }
            if (i6 > bArr.length - iZzj) {
                throw zzfa.zzf();
            }
            if (i6 == 0) {
                zzgzVar.zzf(i, zzee.zzb);
            } else {
                zzgzVar.zzf(i, zzee.zzk(bArr, iZzj, i6));
            }
            return iZzj + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw zzfa.zza();
            }
            zzgzVar.zzf(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i7 = (i & (-8)) | 4;
        zzgz zzgzVarZzc = zzgz.zzc();
        int i8 = 0;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzdsVar);
            i8 = zzdsVar.zza;
            if (i8 == i7) {
                i2 = iZzj2;
                break;
            }
            i2 = zzi(i8, bArr, iZzj2, i4, zzgzVarZzc, zzdsVar);
        }
        if (i2 > i4 || i8 != i7) {
            throw zzfa.zzd();
        }
        zzgzVar.zzf(i, zzgzVarZzc);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzds zzdsVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzdsVar);
        }
        zzdsVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzds zzdsVar) {
        int i4 = i & 127;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdsVar.zza = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & 127) << 7);
        int i7 = i2 + 2;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzdsVar.zza = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & 127) << 14);
        int i9 = i2 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzdsVar.zza = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & 127) << 21);
        int i11 = i2 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzdsVar.zza = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzdsVar.zza = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i4, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int iZzj = zzj(bArr, i2, zzdsVar);
        zzevVar.zze(zzdsVar.zza);
        while (iZzj < i4) {
            int iZzj2 = zzj(bArr, iZzj, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zzds zzdsVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdsVar.zzb = j;
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
        zzdsVar.zzb = j2;
        return i4;
    }

    public static long zzn(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
