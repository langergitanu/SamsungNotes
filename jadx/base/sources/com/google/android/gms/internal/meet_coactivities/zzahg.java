package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzahg implements zzaev {

    @VisibleForTesting
    final zzabd zza;
    private final zzaet zzb;

    public zzahg(zzabd zzabdVar, zzaet zzaetVar) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "error must not be OK");
        this.zza = zzabdVar;
        this.zzb = zzaetVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzym
    public final zzyi zzc() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaev
    public final zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) {
        return new zzahf(this.zza, this.zzb, zzwqVarArr);
    }
}
