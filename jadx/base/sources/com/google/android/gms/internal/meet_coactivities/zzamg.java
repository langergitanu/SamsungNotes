package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamg implements Runnable {
    final /* synthetic */ zzamh zza;

    public /* synthetic */ zzamg(zzamh zzamhVar, zzamf zzamfVar) {
        this.zza = zzamhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamh zzamhVar = this.zza;
        zzabl zzablVar = (zzabl) zzamhVar.zzb;
        zzablVar.zzc(new zzame(zzamhVar, null));
        zzablVar.zzb();
    }
}
