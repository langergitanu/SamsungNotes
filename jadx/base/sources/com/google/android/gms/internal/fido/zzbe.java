package com.google.android.gms.internal.fido;

import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbe extends zzaz {
    final /* synthetic */ zzbf zza;

    public zzbe(zzbf zzbfVar) {
        this.zza = zzbfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return new AbstractMap.SimpleImmutableEntry(this.zza.zza.zze.zzd.get(i), this.zza.zza.zzf.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zza.size();
    }
}
