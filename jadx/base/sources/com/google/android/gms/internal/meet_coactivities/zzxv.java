package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxv {
    private String zza;
    private zzxw zzb;
    private Long zzc;
    private zzym zzd;

    public final zzxv zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzxv zzb(zzxw zzxwVar) {
        this.zzb = zzxwVar;
        return this;
    }

    public final zzxv zzc(zzym zzymVar) {
        this.zzd = zzymVar;
        return this;
    }

    public final zzxv zzd(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzxy zze() {
        Preconditions.checkNotNull(this.zza, "description");
        Preconditions.checkNotNull(this.zzb, "severity");
        Preconditions.checkNotNull(this.zzc, "timestampNanos");
        Preconditions.checkState(true, "at least one of channelRef and subchannelRef must be null");
        return new zzxy(this.zza, this.zzb, this.zzc.longValue(), null, this.zzd, null);
    }
}
