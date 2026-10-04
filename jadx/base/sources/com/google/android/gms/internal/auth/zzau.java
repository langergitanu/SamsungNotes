package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzau extends zza implements IInterface {
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzat zzatVar, zzaq zzaqVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzatVar);
        zzc.zzd(parcelZza, zzaqVar);
        zzc(7, parcelZza);
    }

    public final void zze(zzat zzatVar, zzbb zzbbVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzatVar);
        zzc.zzd(parcelZza, zzbbVar);
        zzc(8, parcelZza);
    }

    public final void zzf(zzat zzatVar, zzav zzavVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzatVar);
        zzc.zzd(parcelZza, zzavVar);
        zzc(9, parcelZza);
    }

    public final void zzg(zzat zzatVar, zzax zzaxVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzatVar);
        zzc.zzd(parcelZza, zzaxVar);
        zzc(6, parcelZza);
    }

    public final void zzh(zzat zzatVar, zzaz zzazVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzatVar);
        zzc.zzd(parcelZza, zzazVar);
        zzc(5, parcelZza);
    }
}
