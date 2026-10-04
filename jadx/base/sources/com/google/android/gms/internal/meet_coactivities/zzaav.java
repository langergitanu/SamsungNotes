package com.google.android.gms.internal.meet_coactivities;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaav implements Comparator {
    final /* synthetic */ zzaaw zza;

    public zzaav(zzaaw zzaawVar) {
        this.zza = zzaawVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.zza.zza(obj);
        this.zza.zza(obj2);
        return obj.getClass().getName().compareTo(obj2.getClass().getName());
    }
}
