package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "UserMetadataCreator")
@SafeParcelable.Reserved({1})
public class UserMetadata extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzt();

    @SafeParcelable.Field(m3227id = 2)
    private final String zzbo;

    @Nullable
    @SafeParcelable.Field(m3227id = 3)
    private final String zzbp;

    @Nullable
    @SafeParcelable.Field(m3227id = 4)
    private final String zzbq;

    @SafeParcelable.Field(m3227id = 5)
    private final boolean zzbr;

    @Nullable
    @SafeParcelable.Field(m3227id = 6)
    private final String zzbs;

    @SafeParcelable.Constructor
    public UserMetadata(@SafeParcelable.Param(m3228id = 2) String str, @Nullable @SafeParcelable.Param(m3228id = 3) String str2, @Nullable @SafeParcelable.Param(m3228id = 4) String str3, @SafeParcelable.Param(m3228id = 5) boolean z, @Nullable @SafeParcelable.Param(m3228id = 6) String str4) {
        this.zzbo = str;
        this.zzbp = str2;
        this.zzbq = str3;
        this.zzbr = z;
        this.zzbs = str4;
    }

    public String toString() {
        String str = this.zzbo;
        String str2 = this.zzbp;
        String str3 = this.zzbq;
        boolean z = this.zzbr;
        String str4 = this.zzbs;
        StringBuilder sbM16m = AbstractC0000a.m16m("Permission ID: '", str, "', Display Name: '", str2, "', Picture URL: '");
        sbM16m.append(str3);
        sbM16m.append("', Authenticated User: ");
        sbM16m.append(z);
        sbM16m.append(", Email: '");
        return AbstractC0622a.m1170p(str4, "'", sbM16m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbo, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbp, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbq, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbr);
        SafeParcelWriter.writeString(parcel, 6, this.zzbs, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
