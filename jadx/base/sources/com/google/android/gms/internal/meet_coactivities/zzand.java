package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzand implements Runnable {
    final zzanb zza;
    final /* synthetic */ zzanr zzb;

    public zzand(zzanr zzanrVar, zzanb zzanbVar) {
        this.zzb = zzanrVar;
        this.zza = zzanbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzanp zzanpVarZzae = this.zzb.zzae(this.zzb.zzs.zze, false);
        if (zzanpVarZzae == null) {
            return;
        }
        this.zzb.zzd.execute(new zzanc(this, zzanpVarZzae));
    }
}
