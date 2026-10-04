package com.google.android.gms.internal.meet_coactivities;

import java.net.SocketAddress;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakq extends zzaam {
    final /* synthetic */ zzakr zza;

    public zzakq(zzakr zzakrVar) {
        this.zza = zzakrVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final String zza() {
        return this.zza.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzd(zzaai zzaaiVar) {
        SocketAddress socketAddress = this.zza.zza;
        zzaaj zzaajVarZzc = zzaak.zzc();
        zzvy zzvyVar = zzvy.zza;
        zzaajVarZzc.zza(Collections.singletonList(new zzxm(Collections.singletonList(socketAddress), zzvyVar)));
        zzaajVarZzc.zzb(zzvyVar);
        zzaaiVar.zzb(zzaajVarZzc.zzd());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzc() {
    }
}
