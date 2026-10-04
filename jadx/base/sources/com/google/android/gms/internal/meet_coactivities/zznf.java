package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zznf implements Iterator {
    final /* synthetic */ zzng zza;
    private int zzb = 0;

    public zznf(zzng zzngVar) {
        this.zza = zzngVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zza.zzd;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zznk zznkVar = this.zza.zza;
        int[] iArr = zznkVar.zzc;
        int i = this.zzb;
        this.zzb = i + 1;
        return zznkVar.zzi(iArr[i] & 31);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
