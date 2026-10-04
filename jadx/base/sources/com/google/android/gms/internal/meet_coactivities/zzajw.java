package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajw extends zzaai {
    final zzajt zza;
    final zzaam zzb;
    final /* synthetic */ zzakn zzc;

    public zzajw(zzakn zzaknVar, zzajt zzajtVar, zzaam zzaamVar) {
        this.zzc = zzaknVar;
        this.zza = (zzajt) Preconditions.checkNotNull(zzajtVar, "helperImpl");
        this.zzb = (zzaam) Preconditions.checkNotNull(zzaamVar, "resolver");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaai
    public final void zza(zzabd zzabdVar) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "the error status must not be OK");
        zzaju zzajuVar = new zzaju(this, zzabdVar);
        zzabl zzablVar = this.zzc.zzd;
        zzablVar.zzc(zzajuVar);
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaai
    public final void zzb(zzaak zzaakVar) {
        zzajv zzajvVar = new zzajv(this, zzaakVar);
        zzabl zzablVar = this.zzc.zzd;
        zzablVar.zzc(zzajvVar);
        zzablVar.zzb();
    }
}
