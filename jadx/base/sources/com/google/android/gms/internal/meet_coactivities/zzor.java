package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzor implements Iterator {
    final /* synthetic */ zzos zza;
    private int zzb = 0;

    public zzor(zzos zzosVar) {
        this.zza = zzosVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzos zzosVar = this.zza;
        return i < zzosVar.zza() - zzosVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzos zzosVar = this.zza;
        if (i >= zzosVar.zza() - zzosVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzos zzosVar2 = this.zza;
        Object obj = zzosVar2.zzb.zzb[zzosVar2.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
