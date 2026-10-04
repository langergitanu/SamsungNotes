package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzha extends zzgy {
    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ Object zza(Object obj) {
        return ((zzeu) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Object obj2) {
        zzgz zzgzVar = (zzgz) obj2;
        return zzgzVar.equals(zzgz.zza()) ? obj : zzgz.zzb((zzgz) obj, zzgzVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ Object zzc() {
        return zzgz.zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzgz) obj).zzf(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zze(Object obj) {
        ((zzeu) obj).zzc.zzd();
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzeu) obj).zzc = (zzgz) obj2;
    }
}
