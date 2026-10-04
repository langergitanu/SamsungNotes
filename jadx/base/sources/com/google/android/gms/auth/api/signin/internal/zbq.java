package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zbq extends com.google.android.gms.internal.p262authapi.zbb implements zbr {
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.p262authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.internal.p262authapi.zbc.zba(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) com.google.android.gms.internal.p262authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p262authapi.zbc.zbb(parcel);
                zbd(googleSignInAccount, status);
                break;
            case 102:
                Status status2 = (Status) com.google.android.gms.internal.p262authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p262authapi.zbc.zbb(parcel);
                zbc(status2);
                break;
            case 103:
                Status status3 = (Status) com.google.android.gms.internal.p262authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p262authapi.zbc.zbb(parcel);
                zbb(status3);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
