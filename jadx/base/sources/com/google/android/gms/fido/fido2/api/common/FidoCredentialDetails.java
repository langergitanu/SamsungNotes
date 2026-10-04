package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "FidoCredentialDetailsCreator")
public class FidoCredentialDetails extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();

    @Nullable
    @SafeParcelable.Field(getter = "getUserName", m3227id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getUserDisplayName", m3227id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getUserId", m3227id = 3)
    private final byte[] zzc;

    @NonNull
    @SafeParcelable.Field(getter = "getCredentialId", m3227id = 4)
    private final byte[] zzd;

    @SafeParcelable.Field(getter = "getIsDiscoverable", m3227id = 5)
    private final boolean zze;

    @SafeParcelable.Field(getter = "getIsPaymentCredential", m3227id = 6)
    private final boolean zzf;

    @SafeParcelable.Field(defaultValue = "0", getter = "getLastUsedTime", m3227id = 7)
    private final long zzg;

    @SafeParcelable.Constructor
    public FidoCredentialDetails(@Nullable @SafeParcelable.Param(m3228id = 1) String str, @Nullable @SafeParcelable.Param(m3228id = 2) String str2, @Nullable @SafeParcelable.Param(m3228id = 3) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 4) byte[] bArr2, @SafeParcelable.Param(m3228id = 5) boolean z, @SafeParcelable.Param(m3228id = 6) boolean z2, @SafeParcelable.Param(m3228id = 7) long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = j;
    }

    @NonNull
    public static FidoCredentialDetails deserializeFromBytes(@NonNull byte[] bArr) {
        return (FidoCredentialDetails) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        return Objects.equal(this.zza, fidoCredentialDetails.zza) && Objects.equal(this.zzb, fidoCredentialDetails.zzb) && Arrays.equals(this.zzc, fidoCredentialDetails.zzc) && Arrays.equals(this.zzd, fidoCredentialDetails.zzd) && this.zze == fidoCredentialDetails.zze && this.zzf == fidoCredentialDetails.zzf && this.zzg == fidoCredentialDetails.zzg;
    }

    @NonNull
    public byte[] getCredentialId() {
        return this.zzd;
    }

    public boolean getIsDiscoverable() {
        return this.zze;
    }

    public boolean getIsPaymentCredential() {
        return this.zzf;
    }

    public long getLastUsedTime() {
        return this.zzg;
    }

    @Nullable
    public String getUserDisplayName() {
        return this.zzb;
    }

    @Nullable
    public byte[] getUserId() {
        return this.zzc;
    }

    @Nullable
    public String getUserName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Long.valueOf(this.zzg));
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUserName(), false);
        SafeParcelWriter.writeString(parcel, 2, getUserDisplayName(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getUserId(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getCredentialId(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getIsDiscoverable());
        SafeParcelWriter.writeBoolean(parcel, 6, getIsPaymentCredential());
        SafeParcelWriter.writeLong(parcel, 7, getLastUsedTime());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
