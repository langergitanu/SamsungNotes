package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaic implements Runnable {
    final /* synthetic */ zzaid zza;

    public zzaic(zzaid zzaidVar) {
        this.zza = zzaidVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzais zzaisVar = this.zza.zzb;
        zzalc zzalcVar = zzaisVar.zzp;
        zzaisVar.zzo = null;
        this.zza.zzb.zzp = null;
        zzalcVar.zzm(zzabd.zzk.zze("InternalSubchannel closed transport due to address change"));
    }
}
