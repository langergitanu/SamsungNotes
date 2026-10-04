package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzaik extends zzahk {
    private final zzaey zza;
    private final zzaei zzb;

    public /* synthetic */ zzaik(zzaey zzaeyVar, zzaei zzaeiVar, zzaij zzaijVar) {
        this.zza = zzaeyVar;
        this.zzb = zzaeiVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzahk
    public final zzaey zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzahk, com.google.android.gms.internal.meet_coactivities.zzaev
    public final zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) {
        return new zzaii(this, this.zza.zzd(zzaabVar, zzzvVar, zzwdVar, zzwqVarArr));
    }
}
