package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbs extends zzbz {
    private zzca zza;
    private zzl zzb;
    private zzc zzc;

    @Override // com.google.android.gms.internal.meet_coactivities.zzbz
    public final zzbz zza(zzc zzcVar) {
        this.zzc = zzcVar;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbz
    public final zzbz zzb(zzl zzlVar) {
        this.zzb = zzlVar;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbz
    public final zzbz zzc(zzca zzcaVar) {
        if (zzcaVar == null) {
            throw new NullPointerException("Null state");
        }
        this.zza = zzcaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbz
    public final zzcb zzd() {
        if (this.zza != null) {
            return new zzbt(this.zza, this.zzb, this.zzc, null);
        }
        throw new IllegalStateException("Missing required properties: state");
    }
}
