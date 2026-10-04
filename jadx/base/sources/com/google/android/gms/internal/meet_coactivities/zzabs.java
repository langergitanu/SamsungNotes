package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzabs implements zzakp {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzabv zzb;
    final /* synthetic */ zzabu zzc;

    public zzabs(zzabu zzabuVar, Context context, zzabv zzabvVar) {
        this.zza = context;
        this.zzb = zzabvVar;
        this.zzc = zzabuVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzakp
    public final zzaex zza() {
        zzabu zzabuVar = this.zzc;
        Executor executor = zzabuVar.zzb;
        zzale zzaleVar = zzabuVar.zzc;
        zzale zzaleVarZze = zzabuVar.zza.zze();
        zzabu zzabuVar2 = this.zzc;
        return new zzabt(this.zza, this.zzb, executor, zzaleVar, zzaleVarZze, zzabuVar2.zzd, null, zzabuVar2.zzf, zzabuVar2.zze);
    }
}
