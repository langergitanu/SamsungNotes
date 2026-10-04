package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaji extends zzxp {
    private final zzye zza;
    private final zzwe zzb;
    private final Executor zzc;
    private final zzaab zzd;
    private final zzxe zze;
    private zzwd zzf;
    private zzwi zzg;

    public zzaji(zzye zzyeVar, zzwe zzweVar, Executor executor, zzaab zzaabVar, zzwd zzwdVar) {
        this.zza = zzyeVar;
        this.zzb = zzweVar;
        this.zzd = zzaabVar;
        executor = zzwdVar.zzn() != null ? zzwdVar.zzn() : executor;
        this.zzc = executor;
        this.zzf = zzwdVar.zzb(executor);
        this.zze = zzxe.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaar, com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        zzwi zzwiVar = this.zzg;
        if (zzwiVar != null) {
            zzwiVar.zza(str, th);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzxp, com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zze(zzwh zzwhVar, zzzv zzzvVar) {
        zzyd zzydVarZza = this.zza.zza(new zzaly(this.zzd, zzzvVar, this.zzf, zzakn.zzh));
        zzabd zzabdVarZzb = zzydVarZza.zzb();
        if (!zzabdVarZzb.zzj()) {
            this.zzc.execute(new zzajh(this, zzwhVar, zzahv.zza(zzabdVarZzb)));
            this.zzg = zzakn.zzi;
        } else {
            zzakx zzakxVarZzb = ((zzala) zzydVarZza.zzc()).zzb(this.zzd);
            if (zzakxVarZzb != null) {
                this.zzf = this.zzf.zze(zzakx.zza, zzakxVarZzb);
            }
            zzwi zzwiVarZza = this.zzb.zza(this.zzd, this.zzf);
            this.zzg = zzwiVarZza;
            zzwiVarZza.zze(zzwhVar, zzzvVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzxp, com.google.android.gms.internal.meet_coactivities.zzaar
    public final zzwi zzf() {
        return this.zzg;
    }
}
