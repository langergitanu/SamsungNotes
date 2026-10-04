package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahe {
    private final Random zza = new Random();
    private final long zzb;
    private final long zzc;
    private long zzd;

    public zzahe() {
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        this.zzb = nanos;
        this.zzc = TimeUnit.MINUTES.toNanos(2L);
        this.zzd = nanos;
    }

    public final long zza() {
        long j = this.zzd;
        double d = j;
        this.zzd = Math.min((long) (1.6d * d), this.zzc);
        double d2 = 0.2d * d;
        double d3 = d * (-0.2d);
        Preconditions.checkArgument(d2 >= d3);
        return j + ((long) ((this.zza.nextDouble() * (d2 - d3)) + d3));
    }
}
