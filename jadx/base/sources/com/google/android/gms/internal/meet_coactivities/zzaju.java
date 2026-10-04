package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaju implements Runnable {
    final /* synthetic */ zzabd zza;
    final /* synthetic */ zzajw zzb;

    public zzaju(zzajw zzajwVar, zzabd zzabdVar) {
        this.zza = zzabdVar;
        this.zzb = zzajwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = zzakn.zza;
        Level level = Level.WARNING;
        zzajw zzajwVar = this.zzb;
        zzyi zzyiVarZzc = zzajwVar.zzc.zzc();
        zzabd zzabdVar = this.zza;
        logger.logp(level, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "handleErrorInSyncContext", "[{0}] Failed to resolve name. status={1}", new Object[]{zzyiVarZzc, zzabdVar});
        zzajwVar.zzc.zzW.zzf();
        zzakn zzaknVar = zzajwVar.zzc;
        if (zzaknVar.zzah != 3) {
            zzaknVar.zzU.zzb(3, "Failed to resolve name: {0}", zzabdVar);
            zzajwVar.zzc.zzah = 3;
        }
        zzajt zzajtVar = zzajwVar.zza;
        if (zzajtVar != zzajwVar.zzc.zzE) {
            return;
        }
        zzajtVar.zza.zza().zzb(zzabdVar);
    }
}
