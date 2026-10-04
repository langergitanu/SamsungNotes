package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoDoingState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjz implements zzkm {
    private zzjz() {
        throw null;
    }

    public static zzjz zzb() {
        return zzjx.zza;
    }

    public static final CoDoingState zzc(zzqd zzqdVar) {
        CoDoingState.Builder builder = CoDoingState.builder();
        builder.setState(zzqdVar.zzd().zzn());
        return builder.build();
    }

    public static final zzqd zzd(CoDoingState coDoingState) {
        zzqc zzqcVarZza = zzqd.zza();
        byte[] bArrState = coDoingState.state();
        zzrq zzrqVar = zzrq.zzb;
        zzqcVarZza.zza(zzrq.zzk(bArrState, 0, bArrState.length));
        return (zzqd) zzqcVarZza.zzk();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        return zzc((zzqd) obj);
    }

    public /* synthetic */ zzjz(zzjy zzjyVar) {
    }
}
