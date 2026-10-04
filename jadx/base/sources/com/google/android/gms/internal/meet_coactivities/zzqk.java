package com.google.android.gms.internal.meet_coactivities;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqk extends zzss implements zzuf {
    private zzqk() {
        throw null;
    }

    public final zzqk zza(Map map) {
        zzo();
        zzqp.zzf((zzqp) this.zza).putAll(map);
        return this;
    }

    public final zzqk zzb(zzql zzqlVar) {
        zzo();
        ((zzqp) this.zza).zzh = zzqlVar.zza();
        return this;
    }

    public final zzqk zzc(zzqi zzqiVar) {
        zzo();
        zzqp.zzh((zzqp) this.zza, (zzqj) zzqiVar.zzk());
        return this;
    }

    public final zzqk zzd(zzqj zzqjVar) {
        zzo();
        zzqp.zzh((zzqp) this.zza, zzqjVar);
        return this;
    }

    public /* synthetic */ zzqk(zzpv zzpvVar) {
        super(zzqp.zzb);
    }
}
