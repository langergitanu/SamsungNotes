package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzld extends zzlt {
    public zzld(String str, Class cls, boolean z) {
        super("tags", cls, false);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlt
    public final /* bridge */ /* synthetic */ void zzb(Object obj, zzls zzlsVar) {
        for (Map.Entry entry : ((zzov) obj).zzd().entrySet()) {
            if (((Set) entry.getValue()).isEmpty()) {
                zzlsVar.zza((String) entry.getKey(), null);
            } else {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    zzlsVar.zza((String) entry.getKey(), it.next());
                }
            }
        }
    }
}
