package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyResponseCreator")
public class ProxyResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();
    public static final int STATUS_CODE_NO_CONNECTION = -1;

    @NonNull
    @SafeParcelable.Field(m3227id = 5)
    public final byte[] body;

    @SafeParcelable.Field(m3227id = 1)
    public final int googlePlayServicesStatusCode;

    @NonNull
    @SafeParcelable.Field(m3227id = 2)
    public final PendingIntent recoveryAction;

    @SafeParcelable.Field(m3227id = 3)
    public final int statusCode;

    @SafeParcelable.VersionField(m3230id = 1000)
    final int zza;

    @SafeParcelable.Field(m3227id = 4)
    final Bundle zzb;

    @SafeParcelable.Constructor
    public ProxyResponse(@SafeParcelable.Param(m3228id = 1000) int i, @SafeParcelable.Param(m3228id = 1) int i2, @SafeParcelable.Param(m3228id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(m3228id = 3) int i4, @SafeParcelable.Param(m3228id = 4) Bundle bundle, @SafeParcelable.Param(m3228id = 5) byte[] bArr) {
        this.zza = i;
        this.googlePlayServicesStatusCode = i2;
        this.statusCode = i4;
        this.zzb = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    @NonNull
    public static ProxyResponse createErrorProxyResponse(int i, @NonNull PendingIntent pendingIntent, int i2, @NonNull Map<String, String> map, @NonNull byte[] bArr) {
        return new ProxyResponse(1, i, pendingIntent, i2, zza(map), bArr);
    }

    private static Bundle zza(Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return bundle;
    }

    @NonNull
    public Map<String, String> getHeaders() {
        if (this.zzb == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        for (String str : this.zzb.keySet()) {
            map.put(str, this.zzb.getString(str));
        }
        return map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.googlePlayServicesStatusCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.recoveryAction, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.body, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public ProxyResponse(int i, @NonNull PendingIntent pendingIntent, int i2, @NonNull Bundle bundle, @NonNull byte[] bArr) {
        this(1, i, pendingIntent, i2, bundle, bArr);
    }

    public ProxyResponse(int i, @NonNull Map<String, String> map, @NonNull byte[] bArr) {
        this(1, 0, null, i, zza(map), bArr);
    }
}
