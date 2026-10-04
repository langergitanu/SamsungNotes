package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzrf {
    public static int zza(byte[] bArr, int i, zzre zzreVar) throws zzti {
        int iZzi = zzi(bArr, i, zzreVar);
        int i2 = zzreVar.zza;
        if (i2 < 0) {
            throw zzti.zzf();
        }
        if (i2 > bArr.length - iZzi) {
            throw zzti.zzi();
        }
        if (i2 == 0) {
            zzreVar.zzc = zzrq.zzb;
            return iZzi;
        }
        zzreVar.zzc = zzrq.zzk(bArr, iZzi, i2);
        return iZzi + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i4 = bArr[i + 1] & 255;
        int i5 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i4 << 8) | i2 | (i5 << 16);
    }

    public static int zzc(zzuq zzuqVar, byte[] bArr, int i, int i2, int i4, zzre zzreVar) {
        Object objZze = zzuqVar.zze();
        int iZzm = zzm(objZze, zzuqVar, bArr, i, i2, i4, zzreVar);
        zzuqVar.zzf(objZze);
        zzreVar.zzc = objZze;
        return iZzm;
    }

    public static int zzd(zzuq zzuqVar, byte[] bArr, int i, int i2, zzre zzreVar) throws zzti {
        Object objZze = zzuqVar.zze();
        int iZzn = zzn(objZze, zzuqVar, bArr, i, i2, zzreVar);
        zzuqVar.zzf(objZze);
        zzreVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzuq zzuqVar, int i, byte[] bArr, int i2, int i4, zztf zztfVar, zzre zzreVar) throws zzti {
        int iZzd = zzd(zzuqVar, bArr, i2, i4, zzreVar);
        zztfVar.add(zzreVar.zzc);
        while (iZzd < i4) {
            int iZzi = zzi(bArr, iZzd, zzreVar);
            if (i != zzreVar.zza) {
                break;
            }
            iZzd = zzd(zzuqVar, bArr, iZzi, i4, zzreVar);
            zztfVar.add(zzreVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zztf zztfVar, zzre zzreVar) throws zzti {
        zzsz zzszVar = (zzsz) zztfVar;
        int iZzi = zzi(bArr, i, zzreVar);
        int i2 = zzreVar.zza + iZzi;
        while (iZzi < i2) {
            iZzi = zzi(bArr, iZzi, zzreVar);
            zzszVar.zzh(zzreVar.zza);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzti.zzi();
    }

    public static int zzg(byte[] bArr, int i, zzre zzreVar) throws zzti {
        int iZzi = zzi(bArr, i, zzreVar);
        int i2 = zzreVar.zza;
        if (i2 < 0) {
            throw zzti.zzf();
        }
        if (i2 == 0) {
            zzreVar.zzc = "";
            return iZzi;
        }
        zzreVar.zzc = zzvo.zzd(bArr, iZzi, i2);
        return iZzi + i2;
    }

    public static int zzh(int i, byte[] bArr, int i2, int i4, zzvf zzvfVar, zzre zzreVar) throws zzti {
        if ((i >>> 3) == 0) {
            throw zzti.zzc();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int iZzl = zzl(bArr, i2, zzreVar);
            zzvfVar.zzj(i, Long.valueOf(zzreVar.zzb));
            return iZzl;
        }
        if (i5 == 1) {
            zzvfVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i5 == 2) {
            int iZzi = zzi(bArr, i2, zzreVar);
            int i6 = zzreVar.zza;
            if (i6 < 0) {
                throw zzti.zzf();
            }
            if (i6 > bArr.length - iZzi) {
                throw zzti.zzi();
            }
            if (i6 == 0) {
                zzvfVar.zzj(i, zzrq.zzb);
            } else {
                zzvfVar.zzj(i, zzrq.zzk(bArr, iZzi, i6));
            }
            return iZzi + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw zzti.zzc();
            }
            zzvfVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i7 = (i & (-8)) | 4;
        zzvf zzvfVarZzf = zzvf.zzf();
        int i8 = 0;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            int iZzi2 = zzi(bArr, i2, zzreVar);
            i8 = zzreVar.zza;
            if (i8 == i7) {
                i2 = iZzi2;
                break;
            }
            i2 = zzh(i8, bArr, iZzi2, i4, zzvfVarZzf, zzreVar);
        }
        if (i2 > i4 || i8 != i7) {
            throw zzti.zzg();
        }
        zzvfVar.zzj(i, zzvfVarZzf);
        return i2;
    }

    public static int zzi(byte[] bArr, int i, zzre zzreVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzreVar);
        }
        zzreVar.zza = b;
        return i2;
    }

    public static int zzj(int i, byte[] bArr, int i2, zzre zzreVar) {
        byte b = bArr[i2];
        int i4 = i2 + 1;
        int i5 = i & 127;
        if (b >= 0) {
            zzreVar.zza = i5 | (b << 7);
            return i4;
        }
        int i6 = i5 | ((b & 127) << 7);
        int i7 = i2 + 2;
        byte b5 = bArr[i4];
        if (b5 >= 0) {
            zzreVar.zza = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & 127) << 14);
        int i9 = i2 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzreVar.zza = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & 127) << 21);
        int i11 = i2 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzreVar.zza = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzreVar.zza = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int zzk(int i, byte[] bArr, int i2, int i4, zztf zztfVar, zzre zzreVar) {
        zzsz zzszVar = (zzsz) zztfVar;
        int iZzi = zzi(bArr, i2, zzreVar);
        zzszVar.zzh(zzreVar.zza);
        while (iZzi < i4) {
            int iZzi2 = zzi(bArr, iZzi, zzreVar);
            if (i != zzreVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzreVar);
            zzszVar.zzh(zzreVar.zza);
        }
        return iZzi;
    }

    public static int zzl(byte[] bArr, int i, zzre zzreVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzreVar.zzb = j;
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
        zzreVar.zzb = j2;
        return i4;
    }

    public static int zzm(Object obj, zzuq zzuqVar, byte[] bArr, int i, int i2, int i4, zzre zzreVar) {
        int iZzc = ((zzuh) zzuqVar).zzc(obj, bArr, i, i2, i4, zzreVar);
        zzreVar.zzc = obj;
        return iZzc;
    }

    public static int zzn(Object obj, zzuq zzuqVar, byte[] bArr, int i, int i2, zzre zzreVar) throws zzti {
        int iZzj = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iZzj = zzj(i4, bArr, iZzj, zzreVar);
            i4 = zzreVar.zza;
        }
        int i5 = iZzj;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzti.zzi();
        }
        int i6 = i5 + i4;
        zzuqVar.zzi(obj, bArr, i5, i6, zzreVar);
        zzreVar.zzc = obj;
        return i6;
    }

    public static int zzo(int i, byte[] bArr, int i2, int i4, zzre zzreVar) throws zzti {
        if ((i >>> 3) == 0) {
            throw zzti.zzc();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            return zzl(bArr, i2, zzreVar);
        }
        if (i5 == 1) {
            return i2 + 8;
        }
        if (i5 == 2) {
            return zzi(bArr, i2, zzreVar) + zzreVar.zza;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i2 + 4;
            }
            throw zzti.zzc();
        }
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i4) {
            i2 = zzi(bArr, i2, zzreVar);
            i7 = zzreVar.zza;
            if (i7 == i6) {
                break;
            }
            i2 = zzo(i7, bArr, i2, i4, zzreVar);
        }
        if (i2 > i4 || i7 != i6) {
            throw zzti.zzg();
        }
        return i2;
    }

    public static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
