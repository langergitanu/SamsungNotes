package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
public class AccountChangeEventsRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zza;

    @SafeParcelable.Field(m3227id = 2)
    int zzb;

    @SafeParcelable.Field(m3227id = 3)
    @Deprecated
    String zzc;

    @SafeParcelable.Field(m3227id = 4)
    Account zzd;

    public AccountChangeEventsRequest() {
        this.zza = 1;
    }

    @NonNull
    public Account getAccount() {
        return this.zzd;
    }

    @NonNull
    @Deprecated
    public String getAccountName() {
        return this.zzc;
    }

    public int getEventIndex() {
        return this.zzb;
    }

    @NonNull
    public AccountChangeEventsRequest setAccount(@NonNull Account account) {
        this.zzd = account;
        return this;
    }

    @NonNull
    @Deprecated
    public AccountChangeEventsRequest setAccountName(@NonNull String str) {
        this.zzc = str;
        return this;
    }

    @NonNull
    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzb = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public AccountChangeEventsRequest(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) int i2, @SafeParcelable.Param(m3228id = 3) String str, @SafeParcelable.Param(m3228id = 4) Account account) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzd = account;
        } else {
            this.zzd = new Account(str, "com.google");
        }
    }
}
