package com.google.android.gms.internal.meet_coactivities;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaid implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzais zzb;

    public zzaid(zzais zzaisVar, List list) {
        this.zza = list;
        this.zzb = zzaisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalc zzalcVar;
        SocketAddress socketAddressZzb = this.zzb.zzk.zzb();
        this.zzb.zzk.zze(this.zza);
        this.zzb.zzl = this.zza;
        zzwz zzwzVarZza = this.zzb.zzu.zza();
        zzwz zzwzVar = zzwz.READY;
        if ((zzwzVarZza != zzwzVar && this.zzb.zzu.zza() != zzwz.CONNECTING) || this.zzb.zzk.zzh(socketAddressZzb)) {
            zzalcVar = null;
        } else if (this.zzb.zzu.zza() == zzwzVar) {
            zzais zzaisVar = this.zzb;
            zzalcVar = zzaisVar.zzt;
            zzaisVar.zzt = null;
            this.zzb.zzk.zzd();
            zzais.zzA(this.zzb, zzwz.IDLE);
        } else {
            this.zzb.zzs.zzm(zzabd.zzk.zze("InternalSubchannel closed pending transport due to address change"));
            this.zzb.zzs = null;
            this.zzb.zzk.zzd();
            zzais.zzE(this.zzb);
            zzalcVar = null;
        }
        if (zzalcVar != null) {
            zzais zzaisVar2 = this.zzb;
            if (zzaisVar2.zzo != null) {
                zzaisVar2.zzp.zzm(zzabd.zzk.zze("InternalSubchannel closed transport early due to address change"));
                this.zzb.zzo.zza();
                this.zzb.zzo = null;
                this.zzb.zzp = null;
            }
            this.zzb.zzp = zzalcVar;
            zzais zzaisVar3 = this.zzb;
            zzaisVar3.zzo = zzaisVar3.zzj.zza(new zzaic(this), 5L, TimeUnit.SECONDS, zzaisVar3.zze);
        }
    }
}
