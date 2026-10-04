package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalp {
    private final zzza zza;
    private zzwz zzb;
    private final zzalj zzc;
    private boolean zzd = false;

    public zzalp(zzza zzzaVar, zzwz zzwzVar, zzalj zzaljVar) {
        this.zza = zzzaVar;
        this.zzb = zzwzVar;
        this.zzc = zzaljVar;
    }

    public static /* bridge */ /* synthetic */ zzwz zzb(zzalp zzalpVar) {
        return zzalpVar.zzc.zzb.zza();
    }

    public static /* bridge */ /* synthetic */ void zzg(zzalp zzalpVar, zzwz zzwzVar) {
        boolean z;
        zzalpVar.zzb = zzwzVar;
        if (zzwzVar == zzwz.READY || zzwzVar == zzwz.TRANSIENT_FAILURE) {
            z = true;
        } else if (zzwzVar != zzwz.IDLE) {
            return;
        } else {
            z = false;
        }
        zzalpVar.zzd = z;
    }

    public final zzwz zzc() {
        return this.zzb;
    }

    public final zzza zze() {
        return this.zza;
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
