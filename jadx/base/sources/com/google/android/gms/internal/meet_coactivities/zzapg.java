package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzapg extends zzapf {
    private final zzwi zza;
    private final boolean zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzapg(zzwi zzwiVar, boolean z) {
        this.zza = zzwiVar;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final void zza() {
        this.zza.zzb();
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final void zzb(Throwable th) {
        this.zza.zza("Cancelled by client with StreamObserver.onError()", th);
        this.zzc = true;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final void zzc(Object obj) {
        Preconditions.checkState(!this.zzc, "Stream was terminated by error, no further calls are allowed");
        Preconditions.checkState(!this.zzd, "Stream is already completed, no further calls are allowed");
        this.zza.zzd(obj);
    }

    public final void zzd(int i) {
        if (this.zzb) {
            this.zza.zzc(1);
        } else {
            this.zza.zzc(2);
        }
    }
}
