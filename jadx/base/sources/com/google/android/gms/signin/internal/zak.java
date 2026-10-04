package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zaa;

    @SafeParcelable.Field(getter = "getConnectionResult", m3227id = 2)
    private final ConnectionResult zab;

    @Nullable
    @SafeParcelable.Field(getter = "getResolveAccountResponse", m3227id = 3)
    private final zav zac;

    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) ConnectionResult connectionResult, @Nullable @SafeParcelable.Param(m3228id = 3) zav zavVar) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    @Nullable
    public final zav zab() {
        return this.zac;
    }
}
