package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzapo extends zzyt {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zzf()).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final zzza zza(zzyq zzyqVar) {
        return zzf().zza(zzyqVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final zzabl zzb() {
        return zzf().zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final ScheduledExecutorService zzc() {
        return zzf().zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final void zzd() {
        zzf().zzd();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public void zze(zzwz zzwzVar, zzzb zzzbVar) {
        throw null;
    }

    public abstract zzyt zzf();
}
