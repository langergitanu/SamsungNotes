package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjm implements zzjv {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/state/ThinCoWatchingUpdateProcessor");
    private final zzjr zzb;
    private final Consumer zzc;
    private final zzgg zzd;
    private final zzip zze;

    public zzjm(zzjr zzjrVar, final Consumer consumer, zzgg zzggVar, zzip zzipVar) {
        Preconditions.checkNotNull(zzjrVar, consumer);
        this.zzb = zzjrVar;
        this.zzc = consumer;
        this.zzd = zzggVar;
        this.zze = zzipVar;
        zzipVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzjl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(consumer);
            }
        });
    }

    public final /* synthetic */ void zza(Consumer consumer) {
        consumer.accept((zzqj) this.zzb.zzg().zzb());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjv
    public final void zzb(zzpx zzpxVar) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Iterator it = zzpxVar.zzg().zzg().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            zzql zzqlVar = iIntValue != 0 ? iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? iIntValue != 5 ? null : zzql.ALTER_QUEUE : zzql.ALTER_SPEED : zzql.ALTER_PLAYBACK_STATE : zzql.ALTER_POSITION : zzql.SWITCH_MEDIA : zzql.INVALID;
            if (zzqlVar == null) {
                zzqlVar = zzql.INVALID;
            }
            builder.put(zzqlVar, (zzqo) entry.getValue());
        }
        zzqj zzqjVarZza = zzpxVar.zzg().zza();
        if (this.zzb.zzh(zzqjVarZza, new zzjf(builder.buildOrThrow()), (zzpxVar.zzr() || this.zzd.zzc()) ? 2 : 1) == 2) {
            if (this.zze.zzd()) {
                ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/state/ThinCoWatchingUpdateProcessor", "processInboundUpdate", 72, "ThinCoWatchingUpdateProcessor.java")).zzo("Application of an update to LSA skipped due to suspension.");
            } else {
                this.zzc.accept(zzqjVarZza);
            }
        }
    }
}
