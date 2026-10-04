package com.google.android.gms.internal.meet_coactivities;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaka implements Runnable {
    final /* synthetic */ zzakd zza;
    final /* synthetic */ zzakf zzb;

    public zzaka(zzakf zzakfVar, zzakd zzakdVar) {
        this.zza = zzakdVar;
        this.zzb = zzakfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzb.get() != zzakn.zzg) {
            this.zza.zzl();
            return;
        }
        zzakf zzakfVar = this.zzb;
        if (zzakfVar.zza.zzI == null) {
            zzakfVar.zza.zzI = new LinkedHashSet();
            zzakn zzaknVar = this.zzb.zza;
            zzaknVar.zze.zzc(zzaknVar.zzJ, true);
        }
        zzakf zzakfVar2 = this.zzb;
        zzakfVar2.zza.zzI.add(this.zza);
    }
}
