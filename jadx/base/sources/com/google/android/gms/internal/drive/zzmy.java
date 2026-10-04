package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class zzmy {
    private static final zzmy zzvr = new zzmy(0, new int[0], new Object[0], false);
    private int count;
    private boolean zznh;
    private int zzrr;
    private Object[] zzue;
    private int[] zzvs;

    private zzmy() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzmy zza(zzmy zzmyVar, zzmy zzmyVar2) {
        int i = zzmyVar.count + zzmyVar2.count;
        int[] iArrCopyOf = Arrays.copyOf(zzmyVar.zzvs, i);
        System.arraycopy(zzmyVar2.zzvs, 0, iArrCopyOf, zzmyVar.count, zzmyVar2.count);
        Object[] objArrCopyOf = Arrays.copyOf(zzmyVar.zzue, i);
        System.arraycopy(zzmyVar2.zzue, 0, objArrCopyOf, zzmyVar.count, zzmyVar2.count);
        return new zzmy(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzmy zzfa() {
        return zzvr;
    }

    public static zzmy zzfb() {
        return new zzmy();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmy)) {
            return false;
        }
        zzmy zzmyVar = (zzmy) obj;
        int i = this.count;
        if (i == zzmyVar.count) {
            int[] iArr = this.zzvs;
            int[] iArr2 = zzmyVar.zzvs;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzue;
                    Object[] objArr2 = zzmyVar.zzue;
                    int i4 = this.count;
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
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzvs;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzue;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }

    public final void zzb(zzns zznsVar) {
        if (this.count == 0) {
            return;
        }
        if (zznsVar.zzcd() == zzkk.zze.zzsi) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzvs[i], this.zzue[i], zznsVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzvs[i2], this.zzue[i2], zznsVar);
        }
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final int zzcx() {
        int iZze;
        int i = this.zzrr;
        if (i != -1) {
            return i;
        }
        int iZzcx = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            int i4 = this.zzvs[i2];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzjr.zze(i5, ((Long) this.zzue[i2]).longValue());
            } else if (i6 == 1) {
                iZze = zzjr.zzg(i5, ((Long) this.zzue[i2]).longValue());
            } else if (i6 == 2) {
                iZze = zzjr.zzc(i5, (zzjc) this.zzue[i2]);
            } else if (i6 == 3) {
                iZzcx = ((zzmy) this.zzue[i2]).zzcx() + (zzjr.zzab(i5) << 1) + iZzcx;
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzkq.zzdl());
                }
                iZze = zzjr.zzj(i5, ((Integer) this.zzue[i2]).intValue());
            }
            iZzcx = iZze + iZzcx;
        }
        this.zzrr = iZzcx;
        return iZzcx;
    }

    public final int zzfc() {
        int i = this.zzrr;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iZzd += zzjr.zzd(this.zzvs[i2] >>> 3, (zzjc) this.zzue[i2]);
        }
        this.zzrr = iZzd;
        return iZzd;
    }

    private zzmy(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzrr = -1;
        this.count = i;
        this.zzvs = iArr;
        this.zzue = objArr;
        this.zznh = z;
    }

    private static void zzb(int i, Object obj, zzns zznsVar) {
        int i2 = i >>> 3;
        int i4 = i & 7;
        if (i4 == 0) {
            zznsVar.zzi(i2, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            zznsVar.zzc(i2, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            zznsVar.zza(i2, (zzjc) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zznsVar.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkq.zzdl());
        }
        if (zznsVar.zzcd() == zzkk.zze.zzsi) {
            zznsVar.zzak(i2);
            ((zzmy) obj).zzb(zznsVar);
            zznsVar.zzal(i2);
        } else {
            zznsVar.zzal(i2);
            ((zzmy) obj).zzb(zznsVar);
            zznsVar.zzak(i2);
        }
    }

    public final void zza(zzns zznsVar) {
        if (zznsVar.zzcd() == zzkk.zze.zzsj) {
            for (int i = this.count - 1; i >= 0; i--) {
                zznsVar.zza(this.zzvs[i] >>> 3, this.zzue[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zznsVar.zza(this.zzvs[i2] >>> 3, this.zzue[i2]);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzlt.zza(sb, i, String.valueOf(this.zzvs[i2] >>> 3), this.zzue[i2]);
        }
    }

    public final void zzb(int i, Object obj) {
        if (this.zznh) {
            int i2 = this.count;
            int[] iArr = this.zzvs;
            if (i2 == iArr.length) {
                int i4 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzvs = Arrays.copyOf(iArr, i4);
                this.zzue = Arrays.copyOf(this.zzue, i4);
            }
            int[] iArr2 = this.zzvs;
            int i5 = this.count;
            iArr2[i5] = i;
            this.zzue[i5] = obj;
            this.count = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
