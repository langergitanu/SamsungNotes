package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AccountChangeEventsResponseCreator")
public class AccountChangeEventsResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zza;

    @SafeParcelable.Field(m3227id = 2)
    final List zzb;

    @SafeParcelable.Constructor
    public AccountChangeEventsResponse(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) List list) {
        this.zza = i;
        this.zzb = (List) Preconditions.checkNotNull(list);
    }

    @NonNull
    public List<AccountChangeEvent> getEvents() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public AccountChangeEventsResponse(@NonNull List<AccountChangeEvent> list) {
        this.zza = 1;
        this.zzb = (List) Preconditions.checkNotNull(list);
    }
}
