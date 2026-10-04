package com.google.android.gms.internal.meet_coactivities;

import java.time.Duration;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzji {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/state/DesiredPositionTracker");
    private Duration zzb = Duration.ZERO;
    private Instant zzc = null;

    public zzji(zzpq zzpqVar) {
    }

    public final Duration zza(zzqj zzqjVar) {
        Instant instant = this.zzc;
        if (instant == null) {
            ((zzkv) zza.zze().zzh("com/google/android/meet/addons/internal/state/DesiredPositionTracker", "getDesiredPosition", 67, "DesiredPositionTracker.java")).zzo("Did not expect markBaselineDesiredPosition to not be called.");
            return zzvt.zzb(zzqjVar.zzf());
        }
        Duration durationBetween = Duration.between(instant, Instant.now());
        int iZzo = zzqjVar.zzo();
        if (iZzo == 5 || iZzo == 6) {
            return zzvt.zzb(zzqjVar.zzf());
        }
        double dZza = zzqjVar.zza();
        if (dZza == 0.0d) {
            ((zzkv) zza.zze().zzh("com/google/android/meet/addons/internal/state/DesiredPositionTracker", "getDesiredPosition", 86, "DesiredPositionTracker.java")).zzo("Did not expect playoutRate to ever be zero, yet here we are.");
            dZza = 1.0d;
        }
        return this.zzb.plus(zzpn.zza(durationBetween, dZza));
    }

    public final void zzb(Duration duration) {
        this.zzc = Instant.now();
        this.zzb = duration;
    }
}
