package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
public class MethodInvocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();

    @SafeParcelable.Field(getter = "getMethodKey", m3227id = 1)
    private final int zaa;

    @SafeParcelable.Field(getter = "getResultStatusCode", m3227id = 2)
    private final int zab;

    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", m3227id = 3)
    private final int zac;

    @SafeParcelable.Field(getter = "getStartTimeMillis", m3227id = 4)
    private final long zad;

    @SafeParcelable.Field(getter = "getEndTimeMillis", m3227id = 5)
    private final long zae;

    @Nullable
    @SafeParcelable.Field(getter = "getCallingModuleId", m3227id = 6)
    private final String zaf;

    @Nullable
    @SafeParcelable.Field(getter = "getCallingEntryPoint", m3227id = 7)
    private final String zag;

    @SafeParcelable.Field(defaultValue = "0", getter = "getServiceId", m3227id = 8)
    private final int zah;

    @SafeParcelable.Field(defaultValue = "-1", getter = "getLatencyMillis", m3227id = 9)
    private final int zai;

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i, int i2, int i4, long j, long j2, @Nullable String str, @Nullable String str2, int i5) {
        this(i, i2, i4, j, j2, str, str2, i5, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeLong(parcel, 4, this.zad);
        SafeParcelWriter.writeLong(parcel, 5, this.zae);
        SafeParcelWriter.writeString(parcel, 6, this.zaf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zag, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zah);
        SafeParcelWriter.writeInt(parcel, 9, this.zai);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) int i2, @SafeParcelable.Param(m3228id = 3) int i4, @SafeParcelable.Param(m3228id = 4) long j, @SafeParcelable.Param(m3228id = 5) long j2, @Nullable @SafeParcelable.Param(m3228id = 6) String str, @Nullable @SafeParcelable.Param(m3228id = 7) String str2, @SafeParcelable.Param(m3228id = 8) int i5, @SafeParcelable.Param(m3228id = 9) int i6) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i4;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = i5;
        this.zai = i6;
    }
}
