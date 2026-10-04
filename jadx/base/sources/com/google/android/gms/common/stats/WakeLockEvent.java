package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "getTimeMillis", m3227id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getEventType", m3227id = 11)
    private final int zzc;

    @SafeParcelable.Field(getter = "getWakeLockName", m3227id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", m3227id = 10)
    private final String zze;

    @SafeParcelable.Field(getter = "getCodePackage", m3227id = 17)
    private final String zzf;

    @SafeParcelable.Field(getter = "getWakeLockType", m3227id = 5)
    private final int zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackages", m3227id = 6)
    private final List zzh;

    @SafeParcelable.Field(getter = "getEventKey", m3227id = 12)
    private final String zzi;

    @SafeParcelable.Field(getter = "getElapsedRealtime", m3227id = 8)
    private final long zzj;

    @SafeParcelable.Field(getter = "getDeviceState", m3227id = 14)
    private final int zzk;

    @SafeParcelable.Field(getter = "getHostPackage", m3227id = 13)
    private final String zzl;

    @SafeParcelable.Field(getter = "getBeginPowerPercentage", m3227id = 15)
    private final float zzm;

    @SafeParcelable.Field(getter = "getTimeout", m3227id = 16)
    private final long zzn;

    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", m3227id = 18)
    private final boolean zzo;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) long j, @SafeParcelable.Param(m3228id = 11) int i2, @SafeParcelable.Param(m3228id = 4) String str, @SafeParcelable.Param(m3228id = 5) int i4, @SafeParcelable.Param(m3228id = 6) @Nullable List list, @SafeParcelable.Param(m3228id = 12) String str2, @SafeParcelable.Param(m3228id = 8) long j2, @SafeParcelable.Param(m3228id = 14) int i5, @SafeParcelable.Param(m3228id = 10) String str3, @SafeParcelable.Param(m3228id = 13) String str4, @SafeParcelable.Param(m3228id = 15) float f, @SafeParcelable.Param(m3228id = 16) long j3, @SafeParcelable.Param(m3228id = 17) String str5, @SafeParcelable.Param(m3228id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i4;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i5;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzc() {
        List list = this.zzh;
        String str = this.zzd;
        int i = this.zzg;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.zzm;
        String str4 = this.zzf;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.zzo;
        StringBuilder sbM780v = AbstractC0541b.m780v("\t", i, str, "\t", "\t");
        sbM780v.append(strJoin);
        sbM780v.append("\t");
        sbM780v.append(i2);
        sbM780v.append("\t");
        AbstractC2821a.m2207B(sbM780v, str2, "\t", str3, "\t");
        sbM780v.append(f);
        sbM780v.append("\t");
        sbM780v.append(str5);
        sbM780v.append("\t");
        sbM780v.append(z);
        return sbM780v.toString();
    }
}
