package com.google.android.gms.internal.fido;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzax extends zzaz {
    private final transient zzaz zza;

    public zzax(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    private final int zzl(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.fido.zzaz, com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzap.zza(i, this.zza.size(), "index");
        return this.zza.get(zzl(i));
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzl(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzl(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.fido.zzaz
    public final zzaz zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    /* JADX INFO: renamed from: zzg */
    public final zzaz subList(int i, int i2) {
        zzap.zze(i, i2, this.zza.size());
        zzaz zzazVar = this.zza;
        return zzazVar.subList(zzazVar.size() - i2, this.zza.size() - i).zzf();
    }
}
