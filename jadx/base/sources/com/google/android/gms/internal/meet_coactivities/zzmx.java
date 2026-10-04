package com.google.android.gms.internal.meet_coactivities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzmx extends zzna {
    private final Map zza;
    private final Map zzb;
    private final zzmy zzc;

    public /* synthetic */ zzmx(zzmv zzmvVar, zzmw zzmwVar) {
        HashMap map = new HashMap();
        this.zza = map;
        HashMap map2 = new HashMap();
        this.zzb = map2;
        map.putAll(zzmvVar.zzc);
        map2.putAll(zzmvVar.zzd);
        this.zzc = zzmvVar.zzf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.meet_coactivities.zzna
    public final void zza(zzlt zzltVar, Object obj, Object obj2) {
        zzmz zzmzVar = (zzmz) this.zza.get(zzltVar);
        if (zzmzVar != null) {
            zzmzVar.zza(zzltVar, obj, obj2);
        } else {
            zzltVar.zzg(obj, obj2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.meet_coactivities.zzna
    public final void zzb(zzlt zzltVar, Iterator it, Object obj) {
        zzmy zzmyVar = (zzmy) this.zzb.get(zzltVar);
        if (zzmyVar != null) {
            zzmyVar.zza(zzltVar, it, obj);
        } else if (this.zzc != null && !this.zza.containsKey(zzltVar)) {
            zzltVar.zzh(it, obj);
        } else {
            while (it.hasNext()) {
                zza(zzltVar, it.next(), obj);
            }
        }
    }
}
