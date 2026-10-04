package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzanx extends zzaai {
    final /* synthetic */ zzany zza;
    private final zzaai zzb;

    public zzanx(zzany zzanyVar, zzaai zzaaiVar) {
        this.zza = zzanyVar;
        this.zzb = zzaaiVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaai
    public final void zza(zzabd zzabdVar) {
        this.zzb.zza(zzabdVar);
        zzabl zzablVar = this.zza.zzc;
        zzablVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzanw
            @Override // java.lang.Runnable
            public final void run() {
                zzany zzanyVar = this.zza.zza;
                zzanyVar.zzb.zzc(new zzanu(zzanyVar));
            }
        });
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaai
    public final void zzb(zzaak zzaakVar) {
        zzvy zzvyVarZza = zzaakVar.zza();
        zzvw zzvwVar = zzany.zza;
        if (zzvyVarZza.zzc(zzvwVar) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        zzaai zzaaiVar = this.zzb;
        zzaaj zzaajVarZzd = zzaakVar.zzd();
        zzvv zzvvVarZzb = zzaakVar.zza().zzb();
        zzvvVarZzb.zzb(zzvwVar, new zzanv(this.zza));
        zzaajVarZzd.zzb(zzvvVarZzb.zzc());
        zzaaiVar.zzb(zzaajVarZzd.zzd());
    }
}
