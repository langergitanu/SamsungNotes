package com.google.android.gms.internal.p262authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbad extends zba implements IInterface {
    public zbad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbaj zbajVar, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbajVar);
        zbc.zbc(parcelZba, saveAccountLinkingTokenRequest);
        zbb(1, parcelZba);
    }

    public final void zbd(zbal zbalVar, SavePasswordRequest savePasswordRequest) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbalVar);
        zbc.zbc(parcelZba, savePasswordRequest);
        zbb(2, parcelZba);
    }
}
