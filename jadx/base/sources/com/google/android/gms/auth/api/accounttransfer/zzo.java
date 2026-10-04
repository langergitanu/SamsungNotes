package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import com.microsoft.identity.common.java.constants.FidoConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AccountTransferMsgCreator")
public final class zzo extends zzbz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    private static final HashMap zzc;

    @SafeParcelable.Indicator
    final Set zza;

    @SafeParcelable.VersionField(m3230id = 1)
    final int zzb;

    @SafeParcelable.Field(getter = "getAuthenticatorDatas", m3227id = 2)
    private ArrayList zzd;

    @SafeParcelable.Field(getter = "getRequestType", m3227id = 3)
    private int zze;

    @SafeParcelable.Field(getter = "getProgress", m3227id = 4)
    private zzs zzf;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, FastJsonResponse.Field.forConcreteTypeArray(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, 2, zzu.class));
        map.put("progress", FastJsonResponse.Field.forConcreteType("progress", 4, zzs.class));
    }

    public zzo() {
        this.zza = new HashSet(1);
        this.zzb = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(safeParcelableFieldId), arrayList.getClass().getCanonicalName()));
        }
        this.zzd = arrayList;
        this.zza.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.zzf = (zzs) fastJsonResponse;
        this.zza.add(Integer.valueOf(safeParcelableFieldId));
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
        if (safeParcelableFieldId == 4) {
            return this.zzf;
        }
        throw new IllegalStateException(AbstractC0000a.m11h(field.getSafeParcelableFieldId(), "Unknown SafeParcelable id="));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zza.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.zza;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeTypedList(parcel, 2, this.zzd, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zze);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzf, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Indicator Set set, @SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) ArrayList arrayList, @SafeParcelable.Param(m3228id = 3) int i2, @SafeParcelable.Param(m3228id = 4) zzs zzsVar) {
        this.zza = set;
        this.zzb = i;
        this.zzd = arrayList;
        this.zze = i2;
        this.zzf = zzsVar;
    }
}
