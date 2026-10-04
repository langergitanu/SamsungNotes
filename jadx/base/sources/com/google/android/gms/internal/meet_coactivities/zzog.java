package com.google.android.gms.internal.meet_coactivities;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzog extends zznv {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzna zzd;
    private final int zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzog(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        Set set = zzoi.zza;
        zzna zznaVar = zzoi.zzb;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zznaVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    public final void zzc(zzml zzmlVar) {
        String strZzb = (String) zzmlVar.zzi().zzc(zzmf.zza);
        if (strZzb == null) {
            strZzb = zza();
        }
        if (strZzb == null) {
            strZzb = zzmlVar.zzf().zzb();
            int iIndexOf = strZzb.indexOf(36, strZzb.lastIndexOf(46));
            if (iIndexOf >= 0) {
                strZzb = strZzb.substring(0, iIndexOf);
            }
        }
        String str = this.zza;
        zzoi.zzi(zzmlVar, zznz.zza(str, strZzb, true), 2, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    public final boolean zzd(Level level) {
        return true;
    }
}
