package com.google.android.gms.internal.meet_coactivities;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzos extends AbstractSet {
    final int zza;
    final /* synthetic */ zzot zzb;

    public zzos(zzot zzotVar, int i) {
        this.zzb = zzotVar;
        this.zza = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return Arrays.binarySearch(this.zzb.zzb, zzb(), zza(), obj, this.zza == -1 ? zzot.zza : zzov.zza) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzor(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }

    public final int zza() {
        return this.zzb.zzc[this.zza + 1];
    }

    public final int zzb() {
        int i = this.zza;
        if (i == -1) {
            return 0;
        }
        return this.zzb.zzc[i];
    }

    public final Object zzc(int i) {
        return this.zzb.zzb[zzb() + i];
    }
}
