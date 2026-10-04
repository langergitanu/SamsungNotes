package com.google.android.gms.internal.meet_coactivities;

import java.util.AbstractList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzte extends AbstractList {
    private final zztc zza;
    private final zztd zzb;

    public zzte(zztc zztcVar, zztd zztdVar) {
        this.zza = zztcVar;
        this.zzb = zztdVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zza(this.zza.zze(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
