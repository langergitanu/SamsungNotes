package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzch;
import com.google.android.gms.internal.fido.zzcl;
import com.google.android.gms.internal.fido.zzcz;
import com.google.android.gms.internal.fido.zzdl;
import com.google.android.gms.internal.fido.zzdo;
import com.google.android.gms.internal.fido.zzdq;
import com.google.android.gms.internal.fido.zzdr;
import com.microsoft.identity.common.java.constants.FidoConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticatorAttestationResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();

    @NonNull
    @SafeParcelable.Field(getter = "getKeyHandle", m3227id = 2)
    private final byte[] zza;

    @NonNull
    @SafeParcelable.Field(getter = "getClientDataJSON", m3227id = 3)
    private final byte[] zzb;

    @NonNull
    @SafeParcelable.Field(getter = "getAttestationObject", m3227id = 4)
    private final byte[] zzc;

    @NonNull
    @SafeParcelable.Field(getter = "getTransports", m3227id = 5)
    private final String[] zzd;

    @SafeParcelable.Constructor
    public AuthenticatorAttestationResponse(@NonNull @SafeParcelable.Param(m3228id = 2) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 3) byte[] bArr2, @NonNull @SafeParcelable.Param(m3228id = 4) byte[] bArr3, @NonNull @SafeParcelable.Param(m3228id = 5) String[] strArr) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr3);
        this.zzd = (String[]) Preconditions.checkNotNull(strArr);
    }

    @NonNull
    public static AuthenticatorAttestationResponse deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticatorAttestationResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        return Arrays.equals(this.zza, authenticatorAttestationResponse.zza) && Arrays.equals(this.zzb, authenticatorAttestationResponse.zzb) && Arrays.equals(this.zzc, authenticatorAttestationResponse.zzc);
    }

    @NonNull
    public byte[] getAttestationObject() {
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
    public String[] getTransports() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)));
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
        zzamVarZza.zzb("attestationObject", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzamVarZza.zzb("transports", Arrays.toString(this.zzd));
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAttestationObject(), false);
        SafeParcelWriter.writeStringArray(parcel, 5, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x011b A[Catch: JSONException -> 0x0015, zzdq -> 0x0184, TRY_LEAVE, TryCatch #2 {zzdq -> 0x0184, blocks: (B:33:0x00ea, B:39:0x0109, B:41:0x011b, B:46:0x012f, B:49:0x0151, B:51:0x0167, B:53:0x016d, B:56:0x0187, B:57:0x018c, B:58:0x018d, B:59:0x0192, B:64:0x019d, B:66:0x01ad, B:68:0x01bb, B:69:0x01ce, B:70:0x01d3, B:71:0x01d4, B:72:0x01d9, B:77:0x01f8, B:78:0x01fd), top: B:109:0x00ea, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f8 A[Catch: JSONException -> 0x0015, zzdq -> 0x0184, TRY_ENTER, TryCatch #2 {zzdq -> 0x0184, blocks: (B:33:0x00ea, B:39:0x0109, B:41:0x011b, B:46:0x012f, B:49:0x0151, B:51:0x0167, B:53:0x016d, B:56:0x0187, B:57:0x018c, B:58:0x018d, B:59:0x0192, B:64:0x019d, B:66:0x01ad, B:68:0x01bb, B:69:0x01ce, B:70:0x01d3, B:71:0x01d4, B:72:0x01d9, B:77:0x01f8, B:78:0x01fd), top: B:109:0x00ea, outer: #1 }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject zza() {
        zzdr zzdrVar;
        byte[] bArrZza;
        try {
            JSONObject jSONObject = new JSONObject();
            byte[] bArr = this.zzb;
            if (bArr != null) {
                jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(bArr));
            }
            byte[] bArr2 = this.zzc;
            if (bArr2 != null) {
                jSONObject.put("attestationObject", Base64Utils.encodeUrlSafeNoPadding(bArr2));
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                String[] strArr = this.zzd;
                if (i >= strArr.length) {
                    break;
                }
                if (strArr[i].equals(Transport.HYBRID.toString())) {
                    jSONArray.put(i, "hybrid");
                } else {
                    jSONArray.put(i, this.zzd[i]);
                }
                i++;
            }
            jSONObject.put("transports", jSONArray);
            try {
                try {
                    zzdr zzdrVar2 = (zzdr) zzdr.zzj(this.zzc).zzh().zzc().get(zzdr.zzi("authData"));
                    if (zzdrVar2 == null) {
                        throw new IllegalArgumentException("attestation object missing authData");
                    }
                    zzcz zzczVarZzc = zzdrVar2.zze().zzc();
                    ByteBuffer byteBufferZzi = zzczVarZzc.zzi();
                    try {
                        byteBufferZzi.position(byteBufferZzi.position() + 32);
                        if ((byteBufferZzi.get() & 64) == 0) {
                            throw new IllegalArgumentException("authData does not include credential data");
                        }
                        byteBufferZzi.position(byteBufferZzi.position() + 4);
                        byteBufferZzi.position(byteBufferZzi.position() + 16);
                        byteBufferZzi.position(byteBufferZzi.position() + byteBufferZzi.getShort());
                        try {
                            zzdo zzdoVarZzh = zzdr.zzk(zzczVarZzc.zzg(byteBufferZzi.position(), zzczVarZzc.zzd()).zzh()).zzh();
                            zzdr zzdrVar3 = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(3L));
                            zzdr zzdrVar4 = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(1L));
                            if (zzdrVar3 == null || zzdrVar4 == null) {
                                throw new IllegalArgumentException("COSE key missing required fields");
                            }
                            try {
                                long jZzc = zzdrVar3.zzf().zzc();
                                long jZzc2 = zzdrVar4.zzf().zzc();
                                if (jZzc2 == 1) {
                                    zzdrVar = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(-1L));
                                    if (zzdrVar != null) {
                                        throw new IllegalArgumentException("COSE key missing required fields");
                                    }
                                    long jZzc3 = zzdrVar.zzf().zzc();
                                    if (jZzc2 == 2 && jZzc3 == 1) {
                                        zzdr zzdrVar5 = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(-2L));
                                        zzdr zzdrVar6 = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(-3L));
                                        if (zzdrVar5 == null || zzdrVar6 == null) {
                                            throw new IllegalArgumentException("COSE key missing required fields");
                                        }
                                        zzcz zzczVarZzc2 = zzdrVar5.zze().zzc();
                                        zzcz zzczVarZzc3 = zzdrVar6.zze().zzc();
                                        if (zzczVarZzc2.zzd() != 32 || zzczVarZzc3.zzd() != 32) {
                                            throw new IllegalArgumentException("COSE coordinates are the wrong size");
                                        }
                                        bArrZza = zzcl.zza(Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE", 0), zzczVarZzc2.zzm(), zzczVarZzc3.zzm());
                                    } else if (jZzc2 == 1 && jZzc3 == 6) {
                                        zzdr zzdrVar7 = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(-2L));
                                        if (zzdrVar7 == null) {
                                            throw new IllegalArgumentException("COSE key missing required fields");
                                        }
                                        zzcz zzczVarZzc4 = zzdrVar7.zze().zzc();
                                        if (zzczVarZzc4.zzd() != 32) {
                                            throw new IllegalArgumentException("COSE coordinates are the wrong size");
                                        }
                                        bArrZza = zzcl.zza(Base64.decode("MCowBQYDK2VwAyEA", 0), zzczVarZzc4.zzm());
                                    } else {
                                        bArrZza = null;
                                    }
                                } else {
                                    if (jZzc2 == 2) {
                                        jZzc2 = 2;
                                        zzdrVar = (zzdr) zzdoVarZzh.zzc().get(zzdr.zzg(-1L));
                                        if (zzdrVar != null) {
                                        }
                                    }
                                    bArrZza = null;
                                }
                                jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, Base64Utils.encodeUrlSafeNoPadding(zzczVarZzc.zzm()));
                                jSONObject.put("publicKeyAlgorithm", jZzc);
                                if (bArrZza != null) {
                                    jSONObject.put("publicKey", Base64Utils.encodeUrlSafeNoPadding(bArrZza));
                                }
                                return jSONObject;
                            } catch (zzdq e) {
                                throw new IllegalArgumentException("COSE key ill-formed", e);
                            }
                        } catch (zzdl e2) {
                            e = e2;
                            throw new IllegalArgumentException("failed to parse COSE key", e);
                        } catch (zzdq e3) {
                            e = e3;
                            throw new IllegalArgumentException("failed to parse COSE key", e);
                        }
                    } catch (IllegalArgumentException e5) {
                        throw new IllegalArgumentException("ill-formed authenticator data", e5);
                    }
                } catch (zzdq e6) {
                    throw new IllegalArgumentException("authData value has wrong type", e6);
                }
            } catch (zzdl e7) {
                e = e7;
                throw new IllegalArgumentException("failed to parse attestation object", e);
            } catch (zzdq e8) {
                e = e8;
                throw new IllegalArgumentException("failed to parse attestation object", e);
            }
        } catch (JSONException e9) {
            throw new RuntimeException("Error encoding AuthenticatorAttestationResponse to JSON object", e9);
        }
    }
}
