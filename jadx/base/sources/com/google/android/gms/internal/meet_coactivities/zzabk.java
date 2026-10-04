package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabk {
    private final zzabi zza;
    private final ScheduledFuture zzb;

    public /* synthetic */ zzabk(zzabi zzabiVar, ScheduledFuture scheduledFuture, zzabj zzabjVar) {
        this.zza = (zzabi) Preconditions.checkNotNull(zzabiVar, "runnable");
        this.zzb = (ScheduledFuture) Preconditions.checkNotNull(scheduledFuture, "future");
    }

    public final void zza() {
        this.zza.zzb = true;
        this.zzb.cancel(false);
    }

    public final boolean zzb() {
        zzabi zzabiVar = this.zza;
        return (zzabiVar.zzc || zzabiVar.zzb) ? false : true;
    }
}
