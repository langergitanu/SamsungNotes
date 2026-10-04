package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalv extends zzzb {
    final /* synthetic */ zzalw zza;
    private final zzza zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzalv(zzalw zzalwVar, zzza zzzaVar) {
        this.zza = zzalwVar;
        this.zzb = (zzza) Preconditions.checkNotNull(zzzaVar, "subchannel");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzb
    public final zzyv zza(zzyw zzywVar) {
        if (this.zzc.compareAndSet(false, true)) {
            zzabl zzablVarZzb = this.zza.zze.zzb();
            zzablVarZzb.zzc(new zzalu(this));
            zzablVarZzb.zzb();
        }
        return zzyv.zzc();
    }
}
