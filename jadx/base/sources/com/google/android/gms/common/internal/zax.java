package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zaa;

    @SafeParcelable.Field(getter = "getButtonSize", m3227id = 2)
    private final int zab;

    @SafeParcelable.Field(getter = "getColorScheme", m3227id = 3)
    private final int zac;

    @Nullable
    @SafeParcelable.Field(getter = "getScopes", m3227id = 4)
    @Deprecated
    private final Scope[] zad;

    @SafeParcelable.Constructor
    public zax(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) int i2, @SafeParcelable.Param(m3228id = 3) int i4, @Nullable @SafeParcelable.Param(m3228id = 4) Scope[] scopeArr) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i4;
        this.zad = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zad, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
