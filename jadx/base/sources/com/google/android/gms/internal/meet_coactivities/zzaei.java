package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaei {
    private final zzaow zza;
    private final zzaiw zzb = zzaix.zza();
    private final zzaiw zzc = zzaix.zza();
    private final zzaiw zzd = zzaix.zza();
    private volatile long zze;

    public zzaei(zzaow zzaowVar) {
        this.zza = zzaowVar;
    }

    public final void zza(boolean z) {
        if (z) {
            this.zzc.zza(1L);
        } else {
            this.zzd.zza(1L);
        }
    }

    public final void zzb() {
        this.zzb.zza(1L);
        this.zze = this.zza.zza();
    }
}
