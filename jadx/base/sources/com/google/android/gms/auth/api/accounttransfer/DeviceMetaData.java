package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "isLockScreenSolved", m3227id = 2)
    private boolean zzb;

    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", m3227id = 3)
    private long zzc;

    @SafeParcelable.Field(getter = "isChallengeAllowed", m3227id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    public DeviceMetaData(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) boolean z, @SafeParcelable.Param(m3228id = 3) long j, @SafeParcelable.Param(m3228id = 4) boolean z2) {
        this.zza = i;
        this.zzb = z;
        this.zzc = j;
        this.zzd = z2;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzc;
    }

    public boolean isChallengeAllowed() {
        return this.zzd;
    }

    public boolean isLockScreenSolved() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
