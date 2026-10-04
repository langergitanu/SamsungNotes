package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakc implements Runnable {
    final /* synthetic */ zzakd zza;

    public zzakc(zzakd zzakdVar) {
        this.zza = zzakdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakd zzakdVar = this.zza;
        zzakn zzaknVar = zzakdVar.zzd.zza;
        if (zzaknVar.zzI != null) {
            zzaknVar.zzI.remove(zzakdVar);
            if (this.zza.zzd.zza.zzI.isEmpty()) {
                zzakn zzaknVar2 = this.zza.zzd.zza;
                zzaknVar2.zze.zzc(zzaknVar2.zzJ, false);
                this.zza.zzd.zza.zzI = null;
                if (this.zza.zzd.zza.zzN.get()) {
                    zzakm zzakmVar = this.zza.zzd.zza.zzM;
                    Object obj = zzakmVar.zza;
                    zzabd zzabdVar = zzakn.zzb;
                    synchronized (obj) {
                        try {
                            if (zzakmVar.zzc != null) {
                                return;
                            }
                            zzakmVar.zzc = zzabdVar;
                            boolean zIsEmpty = zzakmVar.zzb.isEmpty();
                            if (zIsEmpty) {
                                zzakmVar.zzd.zzL.zzm(zzabdVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }
    }
}
