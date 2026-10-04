package com.google.android.gms.internal.meet_coactivities;

import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
public abstract class zzzd {
    public static final zzvw zza = zzvw.zza("internal:health-checking-config");
    public static final zzyo zzb = zzyo.zza("internal:health-check-consumer-listener");
    public static final zzvw zzc = zzvw.zza("internal:has-health-check-producer-listener");
    public static final zzvw zzd = zzvw.zza("io.grpc.IS_PETIOLE_POLICY");
    private int zze;

    public zzabd zza(zzyz zzyzVar) {
        throw null;
    }

    public abstract void zzb(zzabd zzabdVar);

    public void zzc(zzyz zzyzVar) {
        int i = this.zze;
        this.zze = i + 1;
        if (i == 0) {
            zza(zzyzVar);
        }
        this.zze = 0;
    }

    public abstract void zze();

    public void zzd() {
    }
}
