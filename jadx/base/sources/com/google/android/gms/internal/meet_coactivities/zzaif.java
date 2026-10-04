package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaif implements Runnable {
    final /* synthetic */ zzais zza;

    public zzaif(zzais zzaisVar) {
        this.zza = zzaisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzh.zza(2, "Terminated");
        zzais zzaisVar = this.zza;
        zzaki zzakiVar = (zzaki) zzaisVar.zzc;
        zzakiVar.zzb.zzj.zzH.remove(zzaisVar);
        zzakiVar.zzb.zzj.zzV.zzg(zzaisVar);
        zzakn.zzP(zzakiVar.zzb.zzj);
    }
}
