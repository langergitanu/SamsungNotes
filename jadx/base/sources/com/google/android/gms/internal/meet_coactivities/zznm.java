package com.google.android.gms.internal.meet_coactivities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zznm extends zzno {
    private final Map zza;

    public /* synthetic */ zznm(zzmr zzmrVar, zzmr zzmrVar2, zznl zznlVar) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzd(linkedHashMap, zzmrVar);
        zzd(linkedHashMap, zzmrVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zzlt) entry.getKey()).zzi()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.zza = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void zzd(Map map, zzmr zzmrVar) {
        for (int i = 0; i < zzmrVar.zza(); i++) {
            zzlt zzltVarZzb = zzmrVar.zzb(i);
            Object obj = map.get(zzltVarZzb);
            if (zzltVarZzb.zzi()) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(zzltVarZzb, arrayList);
                }
                arrayList.add(zzltVarZzb.zze(zzmrVar.zzd(i)));
            } else {
                map.put(zzltVarZzb, zzltVarZzb.zze(zzmrVar.zzd(i)));
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final int zza() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final Set zzb() {
        return this.zza.keySet();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzno
    public final void zzc(zzna zznaVar, Object obj) {
        for (Map.Entry entry : this.zza.entrySet()) {
            zzlt zzltVar = (zzlt) entry.getKey();
            Object value = entry.getValue();
            if (zzltVar.zzi()) {
                zznaVar.zzb(zzltVar, ((List) value).iterator(), obj);
            } else {
                zznaVar.zza(zzltVar, value, obj);
            }
        }
    }
}
