package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbs extends zzaz {
    static final zzaz zza = new zzbs(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzbs(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzap.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzaz, com.google.android.gms.internal.fido.zzav
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final Object[] zze() {
        return this.zzb;
    }
}
