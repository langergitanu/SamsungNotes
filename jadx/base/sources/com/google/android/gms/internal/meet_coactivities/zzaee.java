package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaee implements zzant {
    private static final Logger zza = Logger.getLogger(zzaee.class.getName());
    private final ScheduledExecutorService zzb;
    private final zzabl zzc;
    private zzabk zzd;
    private zzahe zze;

    public zzaee(zzahd zzahdVar, ScheduledExecutorService scheduledExecutorService, zzabl zzablVar) {
        this.zzb = scheduledExecutorService;
        this.zzc = zzablVar;
    }

    public final /* synthetic */ void zza() {
        zzabk zzabkVar = this.zzd;
        if (zzabkVar != null && zzabkVar.zzb()) {
            this.zzd.zza();
        }
        this.zze = null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzant
    public final void zzb() {
        this.zzc.zzd();
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzaed
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        };
        zzabl zzablVar = this.zzc;
        zzablVar.zzc(runnable);
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzant
    public final void zzc(Runnable runnable) {
        this.zzc.zzd();
        if (this.zze == null) {
            this.zze = new zzahe();
        }
        zzabk zzabkVar = this.zzd;
        if (zzabkVar == null || !zzabkVar.zzb()) {
            long jZza = this.zze.zza();
            this.zzd = this.zzc.zza(runnable, jZza, TimeUnit.NANOSECONDS, this.zzb);
            zza.logp(Level.FINE, "io.grpc.internal.BackoffPolicyRetryScheduler", "schedule", "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jZza));
        }
    }
}
