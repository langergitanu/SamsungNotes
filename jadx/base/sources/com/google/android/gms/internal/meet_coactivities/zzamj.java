package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamj implements Runnable {
    final /* synthetic */ zzamk zza;

    public zzamj(zzamk zzamkVar) {
        this.zza = zzamkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzf.zzD = true;
        zzanr zzanrVar = this.zza.zzf;
        zzanrVar.zzy.zzd(zzanrVar.zzw.zza, this.zza.zzf.zzw.zzb, this.zza.zzf.zzw.zzc);
    }
}
