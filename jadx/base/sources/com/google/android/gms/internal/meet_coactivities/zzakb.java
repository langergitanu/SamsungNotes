package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakb implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzakd zzb;

    public zzakb(zzakd zzakdVar, Runnable runnable) {
        this.zza = runnable;
        this.zzb = zzakdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzakd zzakdVar = this.zzb;
        zzakc zzakcVar = new zzakc(zzakdVar);
        zzabl zzablVar = zzakdVar.zzd.zza.zzd;
        zzablVar.zzc(zzakcVar);
        zzablVar.zzb();
    }
}
