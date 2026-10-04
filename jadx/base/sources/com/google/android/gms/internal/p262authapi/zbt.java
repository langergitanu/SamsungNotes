package com.google.android.gms.internal.p262authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbt extends zba implements IInterface {
    public zbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zbc(zbs zbsVar, zbp zbpVar) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbsVar);
        zbc.zbc(parcelZba, zbpVar);
        zbb(3, parcelZba);
    }

    public final void zbd(zbs zbsVar, CredentialRequest credentialRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbsVar);
        zbc.zbc(parcelZba, credentialRequest);
        zbb(1, parcelZba);
    }

    public final void zbe(zbs zbsVar, zbu zbuVar) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbsVar);
        zbc.zbc(parcelZba, zbuVar);
        zbb(2, parcelZba);
    }

    public final void zbf(zbs zbsVar) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbsVar);
        zbb(4, parcelZba);
    }
}
