package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzw extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        Parcel parcelZzB = zzB(2, zza());
        Account account = (Account) com.google.android.gms.internal.common.zzc.zza(parcelZzB, Account.CREATOR);
        parcelZzB.recycle();
        return account;
    }
}
