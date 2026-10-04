package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import io.grpc.internal.GrpcUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaad {
    private Integer zza;
    private zzaat zzb;
    private zzabl zzc;
    private zzaal zzd;
    private ScheduledExecutorService zze;
    private zzwg zzf;
    private Executor zzg;

    public final zzaad zza(zzwg zzwgVar) {
        this.zzf = (zzwg) Preconditions.checkNotNull(zzwgVar);
        return this;
    }

    public final zzaad zzb(int i) {
        this.zza = Integer.valueOf(GrpcUtil.DEFAULT_PORT_SSL);
        return this;
    }

    public final zzaad zzc(Executor executor) {
        this.zzg = executor;
        return this;
    }

    public final zzaad zzd(zzaat zzaatVar) {
        this.zzb = (zzaat) Preconditions.checkNotNull(zzaatVar);
        return this;
    }

    public final zzaad zze(ScheduledExecutorService scheduledExecutorService) {
        this.zze = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        return this;
    }

    public final zzaad zzf(zzaal zzaalVar) {
        this.zzd = (zzaal) Preconditions.checkNotNull(zzaalVar);
        return this;
    }

    public final zzaad zzg(zzabl zzablVar) {
        this.zzc = (zzabl) Preconditions.checkNotNull(zzablVar);
        return this;
    }

    public final zzaaf zzh() {
        return new zzaaf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null, null);
    }
}
