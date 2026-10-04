package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzabh implements Runnable {
    final /* synthetic */ zzabi zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzabl zzc;

    public zzabh(zzabl zzablVar, zzabi zzabiVar, Runnable runnable) {
        this.zza = zzabiVar;
        this.zzb = runnable;
        this.zzc = zzablVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzabl zzablVar = this.zzc;
        zzablVar.zzc(this.zza);
        zzablVar.zzb();
    }

    public final String toString() {
        return String.valueOf(this.zzb.toString()).concat("(scheduled in SynchronizationContext)");
    }
}
