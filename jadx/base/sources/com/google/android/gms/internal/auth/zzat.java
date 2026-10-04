package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface zzat extends IInterface {
    void zzb(byte[] bArr);

    void zzc(DeviceMetaData deviceMetaData);

    void zzd(Status status);

    void zze();

    void zzf(Status status, com.google.android.gms.auth.api.accounttransfer.zzw zzwVar);

    void zzg(Status status, com.google.android.gms.auth.api.accounttransfer.zzo zzoVar);

    void zzh(Status status);
}
