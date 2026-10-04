package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    public zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzd(zzb zzbVar, String str) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.auth.zzc.zze(parcelZza, zzbVar);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zze(zzb zzbVar, Account account) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.auth.zzc.zze(parcelZza, zzbVar);
        com.google.android.gms.internal.auth.zzc.zzd(parcelZza, account);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf(boolean z) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.auth.zzc.zzc(parcelZza, z);
        zzc(1, parcelZza);
    }
}
