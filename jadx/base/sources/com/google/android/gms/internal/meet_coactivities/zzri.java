package com.google.android.gms.internal.meet_coactivities;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzri extends zzrj {
    final /* synthetic */ zzrq zza;
    private int zzb = 0;
    private final int zzc;

    public zzri(zzrq zzrqVar) {
        this.zza = zzrqVar;
        this.zzc = zzrqVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrl
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
