package com.google.android.gms.internal.meet_coactivities;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaen extends zzafb {
    final /* synthetic */ zzaot zza;
    final /* synthetic */ zzaeq zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaen(zzaeq zzaeqVar, zzapy zzapyVar, zzaot zzaotVar) {
        super(zzaeqVar.zza.zzg);
        this.zza = zzaotVar;
        this.zzb = zzaeqVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzafb
    public final void zza() {
        int i = zzapz.zza;
        if (this.zzb.zzc != null) {
            zzahv.zze(this.zza);
            return;
        }
        while (true) {
            try {
                InputStream inputStreamZzf = this.zza.zzf();
                if (inputStreamZzf == null) {
                    return;
                }
                try {
                    zzaeq zzaeqVar = this.zzb;
                    zzaeqVar.zzb.zzc(zzaeqVar.zza.zzc.zzd(inputStreamZzf));
                    inputStreamZzf.close();
                } catch (Throwable th) {
                    zzahv.zzf(inputStreamZzf);
                    throw th;
                }
            } catch (Throwable th2) {
                zzahv.zze(this.zza);
                zzaeq.zzc(this.zzb, zzabd.zzb.zzd(th2).zze("Failed to read message."));
                return;
            }
        }
    }
}
