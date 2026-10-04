package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzku extends zzlg implements zzlq {
    public zzku(Level level, boolean z) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlg
    public final zzpe zza() {
        return zzpc.zza();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlg
    public final boolean zzb(zzll zzllVar) {
        zzmr zzmrVarZzi = zzi();
        int iZza = zzmrVarZzi.zza();
        int i = 0;
        while (true) {
            if (i >= iZza) {
                break;
            }
            if (zzmrVarZzi.zzb(i).zzf() != "eye3tag") {
                i++;
            } else if (zzmrVarZzi.zzc(zzle.zza) == null) {
                zzlt zzltVar = zzle.zzi;
                if (zzmrVarZzi.zzc(zzltVar) == null) {
                    zzm(zzltVar, zzme.SMALL);
                }
            }
        }
        return super.zzb(zzllVar);
    }
}
