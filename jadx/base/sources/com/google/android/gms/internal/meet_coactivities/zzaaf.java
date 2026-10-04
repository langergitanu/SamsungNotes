package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaaf {
    private final int zza;
    private final zzaat zzb;
    private final zzabl zzc;
    private final zzaal zzd;

    @Nullable
    private final ScheduledExecutorService zze;

    @Nullable
    private final zzwg zzf;

    @Nullable
    private final Executor zzg;

    public /* synthetic */ zzaaf(Integer num, zzaat zzaatVar, zzabl zzablVar, zzaal zzaalVar, ScheduledExecutorService scheduledExecutorService, zzwg zzwgVar, Executor executor, String str, zzaae zzaaeVar) {
        this.zza = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
        this.zzb = (zzaat) Preconditions.checkNotNull(zzaatVar, "proxyDetector not set");
        this.zzc = (zzabl) Preconditions.checkNotNull(zzablVar, "syncContext not set");
        this.zzd = (zzaal) Preconditions.checkNotNull(zzaalVar, "serviceConfigParser not set");
        this.zze = scheduledExecutorService;
        this.zzf = zzwgVar;
        this.zzg = executor;
    }

    public static zzaad zzb() {
        return new zzaad();
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("defaultPort", this.zza).add("proxyDetector", this.zzb).add("syncContext", this.zzc).add("serviceConfigParser", this.zzd).add("scheduledExecutorService", this.zze).add("channelLogger", this.zzf).add("executor", this.zzg).add("overrideAuthority", (Object) null).toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzaal zzc() {
        return this.zzd;
    }

    public final zzaat zzd() {
        return this.zzb;
    }

    public final zzabl zze() {
        return this.zzc;
    }

    @Nullable
    public final Executor zzf() {
        return this.zzg;
    }

    public final ScheduledExecutorService zzg() {
        ScheduledExecutorService scheduledExecutorService = this.zze;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        throw new IllegalStateException("ScheduledExecutorService not set in Builder");
    }
}
