package com.google.android.gms.internal.meet_coactivities;

import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoi extends zznv {
    private static final Set zza;
    private static final zzna zzb;
    private static final zzof zzc;
    private final String zzd;
    private final Level zze;
    private final Set zzf;
    private final zzna zzg;
    private final int zzh;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzle.zza, zzmf.zza)));
        zza = setUnmodifiableSet;
        zzb = zznd.zza(setUnmodifiableSet).zzc();
        zzc = new zzof();
    }

    public /* synthetic */ zzoi(String str, String str2, boolean z, int i, Level level, Set set, zzna zznaVar, zzoh zzohVar) {
        super(str2);
        this.zzd = zznz.zza("", str2, true);
        this.zzh = 2;
        this.zze = level;
        this.zzf = set;
        this.zzg = zznaVar;
    }

    public static zzof zzf() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzi(zzml zzmlVar, String str, int i, Level level, Set set, zzna zznaVar) {
        zzno zznoVarZzh = zzno.zzh(zznr.zzf(), zzmlVar.zzi());
        boolean z = zzmlVar.zzl().intValue() < level.intValue();
        if (!z) {
            int i2 = zznt.zza;
            if (zzmlVar.zzj() == null && zznoVarZzh.zza() <= set.size() && set.containsAll(zznoVarZzh.zzb())) {
                zzmp.zza(zzmlVar.zzk());
            } else {
                StringBuilder sb = new StringBuilder();
                if (zzmm.zza(2, zzmlVar.zzf(), sb)) {
                    sb.append(" ");
                }
                if (!z || zzmlVar.zzj() == null) {
                    zzmg.zzb(zzmlVar, sb);
                    int i4 = zznt.zza;
                    zzmk zzmkVar = new zzmk("[CONTEXT ", " ]", sb);
                    zznoVarZzh.zzc(zznaVar, zzmkVar);
                    zzmkVar.zzb();
                } else {
                    sb.append("(REDACTED) ");
                    sb.append(zzmlVar.zzj().zzb());
                }
            }
        }
        zznz.zzb(zzmlVar.zzl());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    public final void zzc(zzml zzmlVar) {
        zzi(zzmlVar, this.zzd, 2, this.zze, this.zzf, this.zzg);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    public final boolean zzd(Level level) {
        String str = this.zzd;
        int iZzb = zznz.zzb(level);
        return Log.isLoggable(str, iZzb) || Log.isLoggable("all", iZzb);
    }
}
