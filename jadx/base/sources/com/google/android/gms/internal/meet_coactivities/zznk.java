package com.google.android.gms.internal.meet_coactivities;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zznk extends zzno {
    private final zzmr zza;
    private final zzmr zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zznk(zzmr zzmrVar, zzmr zzmrVar2, zznj zznjVar) {
        super(null);
        this.zza = zzmrVar;
        this.zzb = zzmrVar2;
        int iZza = zzmrVar2.zza();
        zzpi.zzc(iZza <= 28, "metadata size too large");
        int[] iArr = new int[iZza];
        this.zzc = iArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            zzlt zzltVarZzi = zzi(i);
            long jZzc = zzltVarZzi.zzc() | j;
            if (jZzc == j) {
                int i4 = 0;
                while (true) {
                    if (i4 >= i2) {
                        i4 = -1;
                        break;
                    } else if (zzltVarZzi.equals(zzi(iArr[i4] & 31))) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 != -1) {
                    iArr[i4] = zzltVarZzi.zzi() ? iArr[i4] | (1 << (i + 4)) : i;
                } else {
                    iArr[i2] = i;
                    i2++;
                }
            }
            i++;
            j = jZzc;
        }
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzlt zzi(int i) {
        return (i >= 0 ? this.zzb : this.zza).zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzj(int i) {
        return (i >= 0 ? this.zzb : this.zza).zzd(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final Set zzb() {
        return new zzng(this);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final void zzc(zzna zznaVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzlt zzltVarZzi = zzi(i2 & 31);
            if (zzltVarZzi.zzi()) {
                zznaVar.zzb(zzltVarZzi, new zzni(this, zzltVarZzi, i2, null), obj);
            } else {
                zznaVar.zza(zzltVarZzi, zzltVarZzi.zze(zzj(i2)), obj);
            }
        }
    }
}
