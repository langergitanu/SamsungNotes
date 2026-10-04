package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahf extends zzald {
    private boolean zzb;
    private final zzabd zzc;
    private final zzaet zzd;
    private final zzwq[] zze;

    public zzahf(zzabd zzabdVar, zzaet zzaetVar, zzwq[] zzwqVarArr) {
        Preconditions.checkArgument(!zzabdVar.zzj(), "error must not be OK");
        this.zzc = zzabdVar;
        this.zzd = zzaetVar;
        this.zze = zzwqVarArr;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzald, com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zza(zzahy zzahyVar) {
        zzahyVar.zzb("error", this.zzc);
        zzahyVar.zzb("progress", this.zzd);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzald, com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzl(zzaeu zzaeuVar) {
        Preconditions.checkState(!this.zzb, "already started");
        this.zzb = true;
        int i = 0;
        while (true) {
            zzwq[] zzwqVarArr = this.zze;
            if (i >= zzwqVarArr.length) {
                zzaeuVar.zzd(this.zzc, this.zzd, new zzzv());
                return;
            } else {
                zzwq zzwqVar = zzwqVarArr[i];
                i++;
            }
        }
    }
}
