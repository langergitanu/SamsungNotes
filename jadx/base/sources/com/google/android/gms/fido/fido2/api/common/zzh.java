package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticationExtensionsPrfOutputsCreator")
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    @SafeParcelable.Field(getter = "getSupported", m3227id = 1)
    private final boolean zza;

    @Nullable
    @SafeParcelable.Field(getter = "getOutputs", m3227id = 2)
    private final byte[] zzb;

    @SafeParcelable.Constructor
    public zzh(@NonNull @SafeParcelable.Param(m3228id = 1) boolean z, @Nullable @SafeParcelable.Param(m3228id = 2) byte[] bArr) {
        this.zza = z;
        this.zzb = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        return this.zza == zzhVar.zza && Arrays.equals(this.zzb, zzhVar.zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enabled", this.zza);
            JSONObject jSONObject2 = new JSONObject();
            byte[] bArr = this.zzb;
            if (bArr != null) {
                jSONObject2.put("first", Base64.encodeToString(Arrays.copyOfRange(bArr, 0, 31), 11));
                byte[] bArr2 = this.zzb;
                if (bArr2.length == 64) {
                    jSONObject2.put("second", Base64.encodeToString(Arrays.copyOfRange(bArr2, 32, 64), 11));
                }
            }
            jSONObject.put("results", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsPrfOutputs to JSON object", e);
        }
    }
}
