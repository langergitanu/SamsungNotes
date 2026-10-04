package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjk implements zzjv {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/state/ThinCoDoingUpdateProcessor");
    private final zzjr zzb;
    private final Consumer zzc;
    private final zzgg zzd;
    private final zzip zze;

    public zzjk(zzjr zzjrVar, final Consumer consumer, zzgg zzggVar, zzip zzipVar) {
        Preconditions.checkNotNull(zzjrVar, consumer);
        this.zzb = zzjrVar;
        this.zzc = consumer;
        this.zzd = zzggVar;
        this.zze = zzipVar;
        zzipVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzjj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(consumer);
            }
        });
    }

    public final /* synthetic */ void zza(Consumer consumer) {
        consumer.accept((zzqd) this.zzb.zzg().zzb());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjv
    public final void zzb(zzpx zzpxVar) {
        zzqd zzqdVarZza = zzpxVar.zzf().zza();
        if (this.zzb.zzh(zzqdVarZza, zzjn.zza, (zzpxVar.zzr() || this.zzd.zzc()) ? 2 : 1) == 2) {
            if (this.zze.zzd()) {
                ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/state/ThinCoDoingUpdateProcessor", "processInboundUpdate", 59, "ThinCoDoingUpdateProcessor.java")).zzo("Application of an update to LSA skipped due to suspension.");
            } else {
                this.zzc.accept(zzqdVarZza);
            }
        }
    }
}
