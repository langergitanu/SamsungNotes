package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticatorErrorResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorErrorResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new zzl();

    @NonNull
    @SafeParcelable.Field(getter = "getErrorCodeAsInt", m3227id = 2, type = XmlErrorCodes.INT)
    private final ErrorCode zza;

    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", m3227id = 3)
    private final String zzb;

    @SafeParcelable.Field(defaultValue = "0", getter = "getInternalErrorCode", m3227id = 4, type = XmlErrorCodes.INT)
    private final int zzc;

    @SafeParcelable.Constructor
    public AuthenticatorErrorResponse(@NonNull @SafeParcelable.Param(m3228id = 2) int i, @Nullable @SafeParcelable.Param(m3228id = 3) String str, @SafeParcelable.Param(m3228id = 4) int i2) {
        try {
            this.zza = ErrorCode.toErrorCode(i);
            this.zzb = str;
            this.zzc = i2;
        } catch (ErrorCode.UnsupportedErrorCodeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @NonNull
    public static AuthenticatorErrorResponse deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticatorErrorResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        return Objects.equal(this.zza, authenticatorErrorResponse.zza) && Objects.equal(this.zzb, authenticatorErrorResponse.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(authenticatorErrorResponse.zzc));
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    @NonNull
    public byte[] getClientDataJSON() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeAsInt() {
        return this.zza.getCode();
    }

    @Nullable
    public String getErrorMessage() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc));
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @NonNull
    public String toString() {
        com.google.android.gms.internal.fido.zzam zzamVarZza = com.google.android.gms.internal.fido.zzan.zza(this);
        zzamVarZza.zza("errorCode", this.zza.getCode());
        String str = this.zzb;
        if (str != null) {
            zzamVarZza.zzb("errorMessage", str);
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCodeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getErrorMessage(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @NonNull
    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.zza.getCode());
            String str = this.zzb;
            if (str == null) {
                return jSONObject;
            }
            jSONObject.put("message", str);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding AuthenticatorErrorResponse to JSON object", e);
        }
    }
}
