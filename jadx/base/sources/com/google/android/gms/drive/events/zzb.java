package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "ChangesAvailableEventCreator")
@SafeParcelable.Reserved({1, 2})
public final class zzb extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    @SafeParcelable.Field(m3227id = 3)
    private final zze zzbv;

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(m3228id = 3) zze zzeVar) {
        this.zzbv = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzb.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzbv, ((zzb) obj).zzbv);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 4;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbv);
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "ChangesAvailableEvent [changesAvailableOptions=" + this.zzbv + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzbv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
