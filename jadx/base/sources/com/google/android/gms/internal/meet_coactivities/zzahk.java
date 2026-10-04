package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzahk implements zzaey {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zza()).toString();
    }

    public abstract zzaey zza();

    @Override // com.google.android.gms.internal.meet_coactivities.zzym
    public final zzyi zzc() {
        return zza().zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaev
    public zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    public final Runnable zze(zzalb zzalbVar) {
        return zza().zze(zzalbVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    public void zzm(zzabd zzabdVar) {
        zza().zzm(zzabdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaey
    public final zzvy zzo() {
        return zza().zzo();
    }
}
