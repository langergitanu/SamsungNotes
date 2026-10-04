package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "SignResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class SignResponseData extends ResponseData {

    @NonNull
    public static final Parcelable.Creator<SignResponseData> CREATOR = new zzl();

    @NonNull
    @VisibleForTesting
    public static final String JSON_RESPONSE_DATA_CLIENT_DATA = "clientData";

    @NonNull
    @VisibleForTesting
    public static final String JSON_RESPONSE_DATA_KEY_HANDLE = "keyHandle";

    @NonNull
    @VisibleForTesting
    public static final String JSON_RESPONSE_DATA_SIGNATURE_DATA = "signatureData";

    @SafeParcelable.Field(getter = "getKeyHandle", m3227id = 2)
    private final byte[] zza;

    @SafeParcelable.Field(getter = "getClientDataString", m3227id = 3)
    private final String zzb;

    @SafeParcelable.Field(getter = "getSignatureData", m3227id = 4)
    private final byte[] zzc;

    @SafeParcelable.Field(getter = "getApplication", m3227id = 5)
    private final byte[] zzd;

    @Deprecated
    public SignResponseData(@NonNull byte[] bArr, @NonNull String str, @NonNull byte[] bArr2) {
        this(bArr, str, bArr2, new byte[0]);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignResponseData)) {
            return false;
        }
        SignResponseData signResponseData = (SignResponseData) obj;
        return Arrays.equals(this.zza, signResponseData.zza) && Objects.equal(this.zzb, signResponseData.zzb) && Arrays.equals(this.zzc, signResponseData.zzc) && Arrays.equals(this.zzd, signResponseData.zzd);
    }

    @NonNull
    public String getClientDataString() {
        return this.zzb;
    }

    @NonNull
    public byte[] getKeyHandle() {
        return this.zza;
    }

    @NonNull
    public byte[] getSignatureData() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    @Override // com.google.android.gms.fido.u2f.api.common.ResponseData
    @NonNull
    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_RESPONSE_DATA_KEY_HANDLE, Base64.encodeToString(this.zza, 11));
            jSONObject.put(JSON_RESPONSE_DATA_CLIENT_DATA, Base64.encodeToString(this.zzb.getBytes(), 11));
            jSONObject.put(JSON_RESPONSE_DATA_SIGNATURE_DATA, Base64.encodeToString(this.zzc, 11));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.zza;
        zzamVarZza.zzb(JSON_RESPONSE_DATA_KEY_HANDLE, zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzamVarZza.zzb("clientDataString", this.zzb);
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.zzc;
        zzamVarZza.zzb(JSON_RESPONSE_DATA_SIGNATURE_DATA, zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.zzd;
        zzamVarZza.zzb("application", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeString(parcel, 3, getClientDataString(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getSignatureData(), false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public SignResponseData(@NonNull @SafeParcelable.Param(m3228id = 2) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 3) String str, @NonNull @SafeParcelable.Param(m3228id = 4) byte[] bArr2, @NonNull @SafeParcelable.Param(m3228id = 5) byte[] bArr3) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzd = (byte[]) Preconditions.checkNotNull(bArr3);
    }
}
