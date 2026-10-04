package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzw extends zza implements IInterface {
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fido.u2f.internal.regular.IU2fAppService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(zzv zzvVar, RegisterRequestParams registerRequestParams) {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzvVar);
        zzc.zzd(parcelZza, registerRequestParams);
        zzb(1, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzv zzvVar, SignRequestParams signRequestParams) {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzvVar);
        zzc.zzd(parcelZza, signRequestParams);
        zzb(2, parcelZza);
    }
}
