package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzahj implements zzaeu {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zza()).toString();
    }

    public abstract zzaeu zza();

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public void zzd(zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zze(zzzv zzzvVar) {
        zza().zze(zzzvVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzf(zzaot zzaotVar) {
        zza().zzf(zzaotVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzg() {
        zza().zzg();
    }
}
