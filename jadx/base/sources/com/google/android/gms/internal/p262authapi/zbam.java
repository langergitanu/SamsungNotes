package com.google.android.gms.internal.p262authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbam extends zba implements IInterface {
    public zbam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbac zbacVar, BeginSignInRequest beginSignInRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbacVar);
        zbc.zbc(parcelZba, beginSignInRequest);
        zbb(1, parcelZba);
    }

    public final void zbd(zbaf zbafVar, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbafVar);
        zbc.zbc(parcelZba, getPhoneNumberHintIntentRequest);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbah zbahVar, GetSignInIntentRequest getSignInIntentRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbahVar);
        zbc.zbc(parcelZba, getSignInIntentRequest);
        zbb(3, parcelZba);
    }

    public final void zbf(IStatusCallback iStatusCallback, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, iStatusCallback);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
