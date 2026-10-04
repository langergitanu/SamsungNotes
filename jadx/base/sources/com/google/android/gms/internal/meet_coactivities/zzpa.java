package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpa extends zzoy {
    private static final Map zza;
    private final zzmh zzb;

    static {
        EnumMap enumMap = new EnumMap(zzmh.class);
        for (zzmh zzmhVar : zzmh.values()) {
            zzpa[] zzpaVarArr = new zzpa[10];
            for (int i = 0; i < 10; i++) {
                zzpaVarArr[i] = new zzpa(i, zzmhVar, zzmi.zzf());
            }
            enumMap.put(zzmhVar, zzpaVarArr);
        }
        zza = Collections.unmodifiableMap(enumMap);
    }

    private zzpa(int i, zzmh zzmhVar, zzmi zzmiVar) {
        super(zzmiVar, i);
        zzpi.zza(zzmhVar, "format char");
        this.zzb = zzmhVar;
        if (zzmiVar.zzj()) {
            zzmhVar.zze();
            return;
        }
        int iZza = zzmhVar.zza();
        iZza = zzmiVar.zzk() ? iZza & 65503 : iZza;
        StringBuilder sb = new StringBuilder("%");
        zzmiVar.zzh(sb);
        sb.append((char) iZza);
    }

    public static zzpa zza(int i, zzmh zzmhVar, zzmi zzmiVar) {
        return (i >= 10 || !zzmiVar.zzj()) ? new zzpa(i, zzmhVar, zzmiVar) : ((zzpa[]) zza.get(zzmhVar))[i];
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoy
    public final void zzb(zzoz zzozVar, Object obj) {
        zzozVar.zzd(obj, this.zzb, zzd());
    }
}
