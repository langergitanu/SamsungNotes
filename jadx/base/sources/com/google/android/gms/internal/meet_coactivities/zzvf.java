package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.common.data.AbstractC4539a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvf {
    private static final zzvf zza = new zzvf(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzvf(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzvf zzc() {
        return zza;
    }

    public static zzvf zze(zzvf zzvfVar, zzvf zzvfVar2) {
        int i = zzvfVar.zzb + zzvfVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzvfVar.zzc, i);
        System.arraycopy(zzvfVar2.zzc, 0, iArrCopyOf, zzvfVar.zzb, zzvfVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzvfVar.zzd, i);
        System.arraycopy(zzvfVar2.zzd, 0, objArrCopyOf, zzvfVar.zzb, zzvfVar2.zzb);
        return new zzvf(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzvf zzf() {
        return new zzvf(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i4 = (i2 / 2) + i2;
            if (i4 >= i) {
                i = i4;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzvf)) {
            return false;
        }
        zzvf zzvfVar = (zzvf) obj;
        int i = this.zzb;
        if (i == zzvfVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzvfVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzvfVar.zzd;
                    int i4 = this.zzb;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }

    public final int zza() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzz3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i4 = this.zzc[i2];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i2]).getClass();
                    iZzz2 = zzsb.zzz(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzrq zzrqVar = (zzrq) this.zzd[i2];
                    int iZzz4 = zzsb.zzz(i7);
                    int iZzd = zzrqVar.zzd();
                    iZzz3 = zzsb.zzz(iZzd) + iZzd + iZzz4 + iZzz3;
                } else if (i6 == 3) {
                    int iZzz5 = zzsb.zzz(i5 << 3);
                    iZzz = iZzz5 + iZzz5;
                    iZzA = ((zzvf) this.zzd[i2]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzti.zza());
                    }
                    ((Integer) this.zzd[i2]).getClass();
                    iZzz2 = zzsb.zzz(i5 << 3) + 4;
                }
                iZzz3 = iZzz2 + iZzz3;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzz = zzsb.zzz(i8);
                iZzA = zzsb.zzA(jLongValue);
            }
            iZzz3 = iZzA + iZzz + iZzz3;
        }
        this.zze = iZzz3;
        return iZzz3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM3191a = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i4 = this.zzc[i2] >>> 3;
            zzrq zzrqVar = (zzrq) this.zzd[i2];
            int iZzz = zzsb.zzz(8);
            int iZzz2 = zzsb.zzz(i4) + zzsb.zzz(16);
            int iZzz3 = zzsb.zzz(24);
            int iZzd = zzrqVar.zzd();
            iM3191a += iZzz + iZzz + iZzz2 + AbstractC4539a.m3191a(iZzd, iZzd, iZzz3);
        }
        this.zze = iM3191a;
        return iM3191a;
    }

    public final zzvf zzd(zzvf zzvfVar) {
        if (zzvfVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzvfVar.zzb;
        zzm(i);
        System.arraycopy(zzvfVar.zzc, 0, this.zzc, this.zzb, zzvfVar.zzb);
        System.arraycopy(zzvfVar.zzd, 0, this.zzd, this.zzb, zzvfVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzug.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzvr zzvrVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzvrVar.zzx(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzvr zzvrVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i4 = i2 & 7;
                int i5 = i2 >>> 3;
                if (i4 == 0) {
                    zzvrVar.zzt(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzvrVar.zzm(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzvrVar.zzd(i5, (zzrq) obj);
                } else if (i4 == 3) {
                    zzvrVar.zzG(i5);
                    ((zzvf) obj).zzl(zzvrVar);
                    zzvrVar.zzh(i5);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzti.zza());
                    }
                    zzvrVar.zzk(i5, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzvf() {
        this(0, new int[8], new Object[8], true);
    }
}
