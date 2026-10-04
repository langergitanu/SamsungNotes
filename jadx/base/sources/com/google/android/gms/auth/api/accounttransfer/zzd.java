package com.google.android.gms.auth.api.accounttransfer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzd extends zzj {
    final /* synthetic */ zze zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzd(zze zzeVar, zzl zzlVar) {
        super(zzlVar);
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzb(byte[] bArr) {
        this.zza.zzb.setResult(bArr);
    }
}
