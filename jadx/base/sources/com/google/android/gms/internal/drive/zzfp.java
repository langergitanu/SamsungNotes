package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "OnEventResponseCreator")
@SafeParcelable.Reserved({1, 4, 8})
public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();

    @SafeParcelable.Field(m3227id = 2)
    private final int zzda;

    @SafeParcelable.Field(m3227id = 3)
    private final ChangeEvent zzib;

    @SafeParcelable.Field(m3227id = 5)
    private final CompletionEvent zzic;

    @SafeParcelable.Field(m3227id = 6)
    private final com.google.android.gms.drive.events.zzo zzid;

    @SafeParcelable.Field(m3227id = 7)
    private final com.google.android.gms.drive.events.zzb zzie;

    @SafeParcelable.Field(m3227id = 9)
    private final com.google.android.gms.drive.events.zzv zzif;

    @SafeParcelable.Field(m3227id = 10)
    private final com.google.android.gms.drive.events.zzr zzig;

    @SafeParcelable.Constructor
    public zzfp(@SafeParcelable.Param(m3228id = 2) int i, @SafeParcelable.Param(m3228id = 3) ChangeEvent changeEvent, @SafeParcelable.Param(m3228id = 5) CompletionEvent completionEvent, @SafeParcelable.Param(m3228id = 6) com.google.android.gms.drive.events.zzo zzoVar, @SafeParcelable.Param(m3228id = 7) com.google.android.gms.drive.events.zzb zzbVar, @SafeParcelable.Param(m3228id = 9) com.google.android.gms.drive.events.zzv zzvVar, @SafeParcelable.Param(m3228id = 10) com.google.android.gms.drive.events.zzr zzrVar) {
        this.zzda = i;
        this.zzib = changeEvent;
        this.zzic = completionEvent;
        this.zzid = zzoVar;
        this.zzie = zzbVar;
        this.zzif = zzvVar;
        this.zzig = zzrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzib, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzic, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzid, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzie, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzif, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final DriveEvent zzat() {
        int i = this.zzda;
        if (i == 1) {
            return this.zzib;
        }
        if (i == 2) {
            return this.zzic;
        }
        if (i == 3) {
            return this.zzid;
        }
        if (i == 4) {
            return this.zzie;
        }
        if (i == 7) {
            return this.zzif;
        }
        if (i == 8) {
            return this.zzig;
        }
        throw new IllegalStateException(AbstractC4539a.m3197g(33, this.zzda, "Unexpected event type "));
    }
}
