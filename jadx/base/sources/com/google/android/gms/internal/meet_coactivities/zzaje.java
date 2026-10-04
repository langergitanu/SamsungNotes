package com.google.android.gms.internal.meet_coactivities;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaje extends zzanr {
    final /* synthetic */ zzaab zza;
    final /* synthetic */ zzwd zzb;
    final /* synthetic */ zzxe zzc;
    final /* synthetic */ zzajg zzd;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzaje(zzajg zzajgVar, zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzans zzansVar, zzahw zzahwVar, zzxe zzxeVar) {
        this.zza = zzaabVar;
        this.zzb = zzwdVar;
        this.zzc = zzxeVar;
        this.zzd = zzajgVar;
        zzakn zzaknVar = zzajgVar.zzb;
        super(zzaabVar, zzzvVar, zzaknVar.zzaa, zzaknVar.zzab, zzaknVar.zzac, zzakn.zzI(zzaknVar, zzwdVar), zzajgVar.zzb.zzp.zzb(), zzansVar, zzahwVar, zzajgVar.zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzanr
    public final zzabd zzo() {
        zzakm zzakmVar = this.zzd.zzb.zzM;
        synchronized (zzakmVar.zza) {
            try {
                zzabd zzabdVar = zzakmVar.zzc;
                if (zzabdVar != null) {
                    return zzabdVar;
                }
                zzakmVar.zzb.add(this);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzanr
    public final zzaes zzp(zzzv zzzvVar, zzwn zzwnVar, int i, boolean z) {
        zzwd zzwdVarZzf = this.zzb.zzf(zzwnVar);
        zzwq[] zzwqVarArrZzh = zzahv.zzh(zzwdVarZzf, zzzvVar, i, z);
        zzxe zzxeVarZza = this.zzc.zza();
        try {
            return this.zzd.zzb.zzL.zzd(this.zza, zzzvVar, zzwdVarZzf, zzwqVarArrZzh);
        } finally {
            this.zzc.zze(zzxeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzanr
    public final void zzq() {
        zzabd zzabdVar;
        zzakm zzakmVar = this.zzd.zzb.zzM;
        synchronized (zzakmVar.zza) {
            try {
                zzakmVar.zzb.remove(this);
                if (zzakmVar.zzb.isEmpty()) {
                    zzabdVar = zzakmVar.zzc;
                    zzakmVar.zzb = new HashSet();
                } else {
                    zzabdVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzabdVar != null) {
            zzakmVar.zzd.zzL.zzm(zzabdVar);
        }
    }
}
