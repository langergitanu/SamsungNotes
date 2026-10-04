package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbs extends com.google.android.gms.internal.p262authapi.zba implements IInterface {
    public zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbrVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p262authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p262authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(103, parcelZba);
    }

    public final void zbd(zbr zbrVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p262authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p262authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void zbe(zbr zbrVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p262authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p262authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(101, parcelZba);
    }
}
