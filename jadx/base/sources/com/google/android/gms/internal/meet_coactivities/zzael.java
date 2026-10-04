package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.MoreExecutors;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzael implements Runnable, zzxb {
    final /* synthetic */ zzaer zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private volatile ScheduledFuture zze;
    private volatile boolean zzf;

    public zzael(zzaer zzaerVar, zzxi zzxiVar, boolean z) {
        long jZzb;
        this.zza = zzaerVar;
        this.zzb = z;
        if (zzxiVar == null) {
            this.zzc = false;
            jZzb = 0;
        } else {
            this.zzc = true;
            jZzb = zzxiVar.zzb(TimeUnit.NANOSECONDS);
        }
        this.zzd = jZzb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzk.zzb(zzb());
    }

    public final zzabd zzb() {
        long jAbs = Math.abs(this.zzd);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit.toNanos(1L);
        long jAbs2 = Math.abs(this.zzd) % timeUnit.toNanos(1L);
        StringBuilder sb = new StringBuilder();
        sb.append(true != this.zzb ? "CallOptions" : AuthenticationConstants.Broker.CHALLENGE_RESPONSE_CONTEXT);
        sb.append(" deadline exceeded after ");
        if (this.zzd < 0) {
            sb.append('-');
        }
        sb.append(nanos);
        Locale locale = Locale.US;
        sb.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
        sb.append("s. ");
        sb.append(String.format(locale, "Name resolution delay %.9f seconds.", Double.valueOf(((Long) this.zza.zzj.zzl(zzwq.zza)) == null ? 0.0d : r1.longValue() / zzaer.zzb)));
        if (this.zza.zzk != null) {
            zzahy zzahyVar = new zzahy();
            this.zza.zzk.zza(zzahyVar);
            sb.append(" ");
            sb.append(zzahyVar);
        }
        return zzabd.zzd.zze(sb.toString());
    }

    public final void zzc() {
        if (this.zzf) {
            return;
        }
        if (this.zzc && !this.zzb) {
            zzaer zzaerVar = this.zza;
            if (zzaerVar.zzn != null) {
                this.zze = zzaerVar.zzn.schedule(new zzaiv(this), this.zzd, TimeUnit.NANOSECONDS);
            }
        }
        this.zza.zzg.zzd(this, MoreExecutors.directExecutor());
        if (this.zzf) {
            zzd();
        }
    }

    public final void zzd() {
        this.zzf = true;
        ScheduledFuture scheduledFuture = this.zze;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
