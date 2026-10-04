package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "SavePasswordResultCreator")
public class SavePasswordResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SavePasswordResult> CREATOR = new zbs();

    @SafeParcelable.Field(getter = "getPendingIntent", m3227id = 1)
    private final PendingIntent zba;

    @SafeParcelable.Constructor
    public SavePasswordResult(@NonNull @SafeParcelable.Param(m3228id = 1) PendingIntent pendingIntent) {
        this.zba = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SavePasswordResult) {
            return Objects.equal(this.zba, ((SavePasswordResult) obj).zba);
        }
        return false;
    }

    @NonNull
    public PendingIntent getPendingIntent() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPendingIntent(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
