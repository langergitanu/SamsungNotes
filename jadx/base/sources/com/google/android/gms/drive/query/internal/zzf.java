package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "FieldWithSortOrderCreator")
@SafeParcelable.Reserved({1000})
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    @SafeParcelable.Field(m3227id = 1)
    private final String fieldName;

    @SafeParcelable.Field(m3227id = 2)
    private final boolean zzmc;

    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(m3228id = 1) String str, @SafeParcelable.Param(m3228id = 2) boolean z) {
        this.fieldName = str;
        this.zzmc = z;
    }

    public final String toString() {
        Locale locale = Locale.US;
        return AbstractC0541b.m775q("FieldWithSortOrder[", this.fieldName, " ", this.zzmc ? "ASC" : "DESC", "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.fieldName, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzmc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
