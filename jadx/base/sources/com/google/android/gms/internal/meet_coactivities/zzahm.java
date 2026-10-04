package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class zzahm extends zzaam {
    private final zzaam zza;

    public zzahm(zzaam zzaamVar) {
        Preconditions.checkNotNull(zzaamVar, "delegate can not be null");
        this.zza = zzaamVar;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.zza).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final String zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzb() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public void zzc() {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public void zzd(zzaai zzaaiVar) {
        this.zza.zzd(zzaaiVar);
    }
}
