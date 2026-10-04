package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzch;
import com.microsoft.identity.common.java.constants.FidoConstants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticatorAssertionResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorAssertionResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorAssertionResponse> CREATOR = new zzj();

    @NonNull
    @SafeParcelable.Field(getter = "getKeyHandle", m3227id = 2)
    private final byte[] zza;

    @NonNull
    @SafeParcelable.Field(getter = "getClientDataJSON", m3227id = 3)
    private final byte[] zzb;

    @NonNull
    @SafeParcelable.Field(getter = "getAuthenticatorData", m3227id = 4)
    private final byte[] zzc;

    @NonNull
    @SafeParcelable.Field(getter = "getSignature", m3227id = 5)
    private final byte[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getUserHandle", m3227id = 6)
    private final byte[] zze;

    @SafeParcelable.Constructor
    public AuthenticatorAssertionResponse(@NonNull @SafeParcelable.Param(m3228id = 2) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 3) byte[] bArr2, @NonNull @SafeParcelable.Param(m3228id = 4) byte[] bArr3, @NonNull @SafeParcelable.Param(m3228id = 5) byte[] bArr4, @Nullable @SafeParcelable.Param(m3228id = 6) byte[] bArr5) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr3);
        this.zzd = (byte[]) Preconditions.checkNotNull(bArr4);
        this.zze = bArr5;
    }

    @NonNull
    public static AuthenticatorAssertionResponse deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticatorAssertionResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorAssertionResponse)) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) obj;
        return Arrays.equals(this.zza, authenticatorAssertionResponse.zza) && Arrays.equals(this.zzb, authenticatorAssertionResponse.zzb) && Arrays.equals(this.zzc, authenticatorAssertionResponse.zzc) && Arrays.equals(this.zzd, authenticatorAssertionResponse.zzd) && Arrays.equals(this.zze, authenticatorAssertionResponse.zze);
    }

    @NonNull
    public byte[] getAuthenticatorData() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    @NonNull
    public byte[] getClientDataJSON() {
        return this.zzb;
    }

    @NonNull
    @Deprecated
    public byte[] getKeyHandle() {
        return this.zza;
    }

    @NonNull
    public byte[] getSignature() {
        return this.zzd;
    }

    @Nullable
    public byte[] getUserHandle() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zze)));
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @NonNull
    public String toString() {
        com.google.android.gms.internal.fido.zzam zzamVarZza = com.google.android.gms.internal.fido.zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.zza;
        zzamVarZza.zzb(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.zzb;
        zzamVarZza.zzb(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.zzc;
        zzamVarZza.zzb(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzch zzchVarZzf4 = zzch.zzf();
        byte[] bArr4 = this.zzd;
        zzamVarZza.zzb(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, zzchVarZzf4.zzg(bArr4, 0, bArr4.length));
        byte[] bArr5 = this.zze;
        if (bArr5 != null) {
            zzamVarZza.zzb(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, zzch.zzf().zzg(bArr5, 0, bArr5.length));
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAuthenticatorData(), false);
        SafeParcelWriter.writeByteArray(parcel, 5, getSignature(), false);
        SafeParcelWriter.writeByteArray(parcel, 6, getUserHandle(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @NonNull
    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(this.zzb));
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(this.zzc));
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(this.zzd));
            byte[] bArr = this.zze;
            if (bArr == null) {
                return jSONObject;
            }
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(bArr));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding AuthenticatorAssertionResponse to JSON object", e);
        }
    }
}
