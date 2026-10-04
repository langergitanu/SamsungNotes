package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalj implements zzzc {
    final /* synthetic */ zzalq zza;
    private zzxa zzb = zzxa.zzb(zzwz.IDLE);
    private zzalp zzc;

    public /* synthetic */ zzalj(zzalq zzalqVar, zzali zzaliVar) {
        this.zza = zzalqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzc
    public final void zza(zzxa zzxaVar) {
        zzalq.zze.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Received health status {0} for subchannel {1}", new Object[]{zzxaVar, this.zzc.zza});
        this.zzb = zzxaVar;
        try {
            zzalq zzalqVar = this.zza;
            zzalp zzalpVar = (zzalp) zzalqVar.zzg.get(zzalqVar.zzh.zzc());
            if (zzalpVar == null || zzalpVar.zzc != this) {
                return;
            }
            this.zza.zzp(this.zzc);
        } catch (IllegalStateException unused) {
            zzalq.zze.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Health listener received state change after subchannel was removed");
        }
    }
}
