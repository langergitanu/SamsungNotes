package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzga implements zzgh {
    private final zzfw zza;
    private final zzgy zzb;
    private final zzel zzc;

    private zzga(zzgy zzgyVar, zzel zzelVar, zzfw zzfwVar) {
        this.zzb = zzgyVar;
        this.zzc = zzelVar;
        this.zza = zzfwVar;
    }

    public static zzga zzb(zzgy zzgyVar, zzel zzelVar, zzfw zzfwVar) {
        return new zzga(zzgyVar, zzelVar, zzfwVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        return this.zzb.zza(obj).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzes) ((zzeu) this.zza).zzi(5, null, null)).zzg();
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        this.zzb.zze(obj);
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        zzgj.zzf(this.zzb, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) {
        zzeu zzeuVar = (zzeu) obj;
        if (zzeuVar.zzc == zzgz.zza()) {
            zzeuVar.zzc = zzgz.zzc();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        return this.zzb.zza(obj).equals(this.zzb.zza(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        this.zzc.zza(obj);
        throw null;
    }
}
