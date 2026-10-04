package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zznd {
    private static final zzmz zza = new zznb();
    private static final zzmy zzb = new zznc();

    public static zzmv zza(Set set) {
        zzmv zzmvVar = new zzmv(zza, null);
        zzmvVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzmvVar.zzf((zzlt) it.next());
        }
        return zzmvVar;
    }
}
