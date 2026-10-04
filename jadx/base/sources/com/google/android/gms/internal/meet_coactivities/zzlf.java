package com.google.android.gms.internal.meet_coactivities;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzlf extends zzmr {
    private Object[] zza = new Object[8];
    private int zzb = 0;

    private final int zzh(zzlt zzltVar) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i + i].equals(zzltVar)) {
                return i;
            }
        }
        return -1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i = 0; i < this.zzb; i++) {
            sb.append(" '");
            sb.append(zzb(i));
            sb.append("': ");
            sb.append(zzd(i));
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmr
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmr
    public final zzlt zzb(int i) {
        if (i < this.zzb) {
            return (zzlt) this.zza[i + i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmr
    public final Object zzc(zzlt zzltVar) {
        int iZzh = zzh(zzltVar);
        if (iZzh != -1) {
            return zzltVar.zze(this.zza[iZzh + iZzh + 1]);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmr
    public final Object zzd(int i) {
        if (i < this.zzb) {
            return this.zza[i + i + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public final void zze(zzlt zzltVar, Object obj) {
        int iZzh;
        if (!zzltVar.zzi() && (iZzh = zzh(zzltVar)) != -1) {
            zzpi.zza(obj, "metadata value");
            this.zza[iZzh + iZzh + 1] = obj;
            return;
        }
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i + i > length) {
            this.zza = Arrays.copyOf(objArr, length + length);
        }
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        zzpi.zza(zzltVar, "metadata key");
        objArr2[i2 + i2] = zzltVar;
        Object[] objArr3 = this.zza;
        int i4 = this.zzb;
        zzpi.zza(obj, "metadata value");
        objArr3[i4 + i4 + 1] = obj;
        this.zzb++;
    }

    public final void zzf(zzlt zzltVar) {
        int i;
        int iZzh = zzh(zzltVar);
        if (iZzh >= 0) {
            int i2 = iZzh + iZzh;
            int i4 = i2 + 2;
            while (true) {
                i = this.zzb;
                if (i4 >= i + i) {
                    break;
                }
                Object obj = this.zza[i4];
                if (!obj.equals(zzltVar)) {
                    Object[] objArr = this.zza;
                    objArr[i2] = obj;
                    objArr[i2 + 1] = objArr[i4 + 1];
                    i2 += 2;
                }
                i4 += 2;
            }
            this.zzb = i - ((i4 - i2) >> 1);
            while (i2 < i4) {
                this.zza[i2] = null;
                i2++;
            }
        }
    }
}
