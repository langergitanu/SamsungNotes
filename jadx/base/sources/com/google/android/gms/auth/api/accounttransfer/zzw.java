package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
public final class zzw extends zzbz {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    private static final HashMap zzc;

    @SafeParcelable.Indicator
    final Set zza;

    @SafeParcelable.VersionField(m3230id = 1)
    final int zzb;

    @SafeParcelable.Field(getter = "getAccountType", m3227id = 2)
    private String zzd;

    @SafeParcelable.Field(getter = "getStatus", m3227id = 3)
    private int zze;

    @SafeParcelable.Field(getter = "getTransferBytes", m3227id = 4)
    private byte[] zzf;

    @SafeParcelable.Field(getter = "getPendingIntent", m3227id = 5)
    private PendingIntent zzg;

    @SafeParcelable.Field(getter = "getDeviceMetaData", m3227id = 6)
    private DeviceMetaData zzh;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        map.put("status", FastJsonResponse.Field.forInteger("status", 3));
        map.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    public zzw() {
        this.zza = new ArraySet(3);
        this.zzb = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return zzc;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.zzb);
        }
        if (safeParcelableFieldId == 2) {
            return this.zzd;
        }
        if (safeParcelableFieldId == 3) {
            return Integer.valueOf(this.zze);
        }
        if (safeParcelableFieldId == 4) {
            return this.zzf;
        }
        throw new IllegalStateException(AbstractC0000a.m11h(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zza.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 4) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(safeParcelableFieldId, "Field with id=", " is not known to be an byte array."));
        }
        this.zzf = bArr;
        this.zza.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 3) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(safeParcelableFieldId, "Field with id=", " is not known to be an int."));
        }
        this.zze = i;
        this.zza.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
        }
        this.zzd = str2;
        this.zza.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.zza;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.zzd, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zze);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzf, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzg, i, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzh, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Indicator Set set, @SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) String str, @SafeParcelable.Param(m3228id = 3) int i2, @SafeParcelable.Param(m3228id = 4) byte[] bArr, @SafeParcelable.Param(m3228id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(m3228id = 6) DeviceMetaData deviceMetaData) {
        this.zza = set;
        this.zzb = i;
        this.zzd = str;
        this.zze = i2;
        this.zzf = bArr;
        this.zzg = pendingIntent;
        this.zzh = deviceMetaData;
    }
}
