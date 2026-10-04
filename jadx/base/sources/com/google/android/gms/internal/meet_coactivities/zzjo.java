package com.google.android.gms.internal.meet_coactivities;

import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjo extends zzjs {
    public zzjo(String str, long j) {
        super(str, j, zzqd.zzc(), zzjn.zza);
    }

    public final zzju zza(UnaryOperator unaryOperator) {
        zzjh zzjhVar;
        synchronized (this.zza) {
            int iZzk = zzk((zzqd) unaryOperator.apply((zzqd) this.zzd), 1);
            zzpw zzpwVarZzc = zzpx.zzc();
            zzpwVarZzc.zzb(this.zzb);
            zzpwVarZzc.zzd(this.zzc);
            zzqe zzqeVarZzb = zzqf.zzb();
            zzqeVarZzb.zza((zzqd) this.zzd);
            zzpwVarZzc.zze(zzqeVarZzb);
            zzjhVar = new zzjh(iZzk, (zzpx) zzpwVarZzc.zzk());
        }
        return zzjhVar;
    }

    public final zzpx zzb() {
        zzpx zzpxVar;
        synchronized (this.zza) {
            zzpw zzpwVarZzc = zzpx.zzc();
            zzpwVarZzc.zzb(this.zzb);
            zzpwVarZzc.zzg(true);
            zzqe zzqeVarZzb = zzqf.zzb();
            zzqeVarZzb.zza((zzqd) this.zzd);
            zzpwVarZzc.zze(zzqeVarZzb);
            zzpxVar = (zzpx) zzpwVarZzc.zzk();
        }
        return zzpxVar;
    }
}
