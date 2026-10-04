package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajr implements Runnable {
    final /* synthetic */ zzzb zza;
    final /* synthetic */ zzwz zzb;
    final /* synthetic */ zzajt zzc;

    public zzajr(zzajt zzajtVar, zzzb zzzbVar, zzwz zzwzVar) {
        this.zza = zzzbVar;
        this.zzb = zzwzVar;
        this.zzc = zzajtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzajt zzajtVar = this.zzc;
        zzakn zzaknVar = zzajtVar.zzb;
        if (zzajtVar != zzaknVar.zzE) {
            return;
        }
        zzaknVar.zzag(this.zza);
        zzwz zzwzVar = this.zzb;
        if (zzwzVar != zzwz.SHUTDOWN) {
            this.zzc.zzb.zzU.zzb(2, "Entering {0} state with picker: {1}", zzwzVar, this.zza);
            zzajt zzajtVar2 = this.zzc;
            zzajtVar2.zzb.zzz.zza(this.zzb);
        }
    }
}
