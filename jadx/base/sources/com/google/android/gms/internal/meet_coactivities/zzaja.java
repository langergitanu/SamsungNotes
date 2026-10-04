package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaja extends zzzb {
    final /* synthetic */ Throwable zza;
    private final zzyv zzb;

    public zzaja(zzakn zzaknVar, Throwable th) {
        this.zza = th;
        this.zzb = zzyv.zza(zzabd.zzj.zze("Panic! This is a bug!").zzd(th));
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Class<?>) zzaja.class).add("panicPickResult", this.zzb).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzb
    public final zzyv zza(zzyw zzywVar) {
        return this.zzb;
    }
}
