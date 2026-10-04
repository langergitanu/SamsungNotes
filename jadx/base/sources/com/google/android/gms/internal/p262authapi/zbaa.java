package com.google.android.gms.internal.p262authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbaa extends zba implements IInterface {
    public zbaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbz zbzVar, AuthorizationRequest authorizationRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbzVar);
        zbc.zbc(parcelZba, authorizationRequest);
        zbb(1, parcelZba);
    }
}
