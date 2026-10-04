package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaig implements Runnable {
    final /* synthetic */ zzaey zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzais zzc;

    public zzaig(zzais zzaisVar, zzaey zzaeyVar, boolean z) {
        this.zza = zzaeyVar;
        this.zzb = z;
        this.zzc = zzaisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzr.zzc(this.zza, this.zzb);
    }
}
