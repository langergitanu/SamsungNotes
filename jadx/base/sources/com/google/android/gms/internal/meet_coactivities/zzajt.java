package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajt extends zzyt {
    zzadu zza;
    final /* synthetic */ zzakn zzb;

    public /* synthetic */ zzajt(zzakn zzaknVar, zzajs zzajsVar) {
        this.zzb = zzaknVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final /* bridge */ /* synthetic */ zzza zza(zzyq zzyqVar) {
        this.zzb.zzd.zzd();
        Preconditions.checkState(!this.zzb.zzO, "Channel is being terminated");
        return new zzakk(this.zzb, zzyqVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final zzabl zzb() {
        return this.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final ScheduledExecutorService zzc() {
        return this.zzb.zzq;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final void zzd() {
        this.zzb.zzd.zzd();
        zzajq zzajqVar = new zzajq(this);
        zzabl zzablVar = this.zzb.zzd;
        zzablVar.zzc(zzajqVar);
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzyt
    public final void zze(zzwz zzwzVar, zzzb zzzbVar) {
        this.zzb.zzd.zzd();
        Preconditions.checkNotNull(zzwzVar, "newState");
        Preconditions.checkNotNull(zzzbVar, "newPicker");
        zzajr zzajrVar = new zzajr(this, zzzbVar, zzwzVar);
        zzabl zzablVar = this.zzb.zzd;
        zzablVar.zzc(zzajrVar);
        zzablVar.zzb();
    }
}
