package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbh extends zza implements IInterface {
    public zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zzd(zzbg zzbgVar) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzbgVar);
        zzc(3, parcelZza);
    }

    public final void zze(zzbg zzbgVar, ProxyRequest proxyRequest) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzbgVar);
        zzc.zzd(parcelZza, proxyRequest);
        zzc(1, parcelZza);
    }
}
