package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "RegisterResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class RegisterResponseData extends ResponseData {

    @NonNull
    public static final Parcelable.Creator<RegisterResponseData> CREATOR = new zzi();

    @SafeParcelable.Field(getter = "getRegisterData", m3227id = 2)
    private final byte[] zza;

    @SafeParcelable.Field(getter = "getProtocolVersionAsString", m3227id = 3, type = "java.lang.String")
    private final ProtocolVersion zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getClientDataString", m3227id = 4)
    private final String zzc;

    public RegisterResponseData(@NonNull byte[] bArr) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = ProtocolVersion.V1;
        this.zzc = null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RegisterResponseData)) {
            return false;
        }
        RegisterResponseData registerResponseData = (RegisterResponseData) obj;
        return Objects.equal(this.zzb, registerResponseData.zzb) && Arrays.equals(this.zza, registerResponseData.zza) && Objects.equal(this.zzc, registerResponseData.zzc);
    }

    @NonNull
    public String getClientDataString() {
        return this.zzc;
    }

    @NonNull
    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    @NonNull
    public byte[] getRegisterData() {
        return this.zza;
    }

    public int getVersionCode() {
        ProtocolVersion protocolVersion = ProtocolVersion.UNKNOWN;
        int iOrdinal = this.zzb.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                return -1;
            }
        }
        return i;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zza)), this.zzc);
    }

    @Override // com.google.android.gms.fido.u2f.api.common.ResponseData
    @NonNull
    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("registrationData", Base64.encodeToString(this.zza, 11));
            jSONObject.put("version", this.zzb.toString());
            String str = this.zzc;
            if (str == null) {
                return jSONObject;
            }
            jSONObject.put(SignResponseData.JSON_RESPONSE_DATA_CLIENT_DATA, Base64.encodeToString(str.getBytes(), 11));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzamVarZza.zzb("protocolVersion", this.zzb);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.zza;
        zzamVarZza.zzb("registerData", zzchVarZzf.zzg(bArr, 0, bArr.length));
        String str = this.zzc;
        if (str != null) {
            zzamVarZza.zzb("clientDataString", str);
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getRegisterData(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb.toString(), false);
        SafeParcelWriter.writeString(parcel, 4, getClientDataString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public RegisterResponseData(@NonNull byte[] bArr, @NonNull ProtocolVersion protocolVersion, @Nullable String str) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        Preconditions.checkArgument(protocolVersion != ProtocolVersion.UNKNOWN);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(str == null);
            this.zzc = null;
        } else {
            this.zzc = (String) Preconditions.checkNotNull(str);
        }
    }

    @SafeParcelable.Constructor
    public RegisterResponseData(@SafeParcelable.Param(m3228id = 2) byte[] bArr, @SafeParcelable.Param(m3228id = 3) String str, @Nullable @SafeParcelable.Param(m3228id = 4) String str2) {
        this.zza = bArr;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
