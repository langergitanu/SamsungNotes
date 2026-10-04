package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajk implements zzalb {
    final /* synthetic */ zzakn zza;

    public /* synthetic */ zzajk(zzakn zzaknVar, zzajj zzajjVar) {
        this.zza = zzaknVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzb(boolean z) {
        zzakn zzaknVar = this.zza;
        zzaknVar.zze.zzc(zzaknVar.zzL, z);
        if (z) {
            this.zza.zzU();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzd(zzabd zzabdVar) {
        Preconditions.checkState(this.zza.zzN.get(), "Channel must have been shut down");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zze() {
        Preconditions.checkState(this.zza.zzN.get(), "Channel must have been shut down");
        this.zza.zzO = true;
        this.zza.zzaf(false);
        zzakn.zzP(this.zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final zzvy zza(zzvy zzvyVar) {
        return zzvyVar;
    }
}
