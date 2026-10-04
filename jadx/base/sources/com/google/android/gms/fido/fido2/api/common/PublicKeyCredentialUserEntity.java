package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "PublicKeyCredentialUserEntityCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzar();

    @NonNull
    @SafeParcelable.Field(getter = "getId", m3227id = 2)
    private final byte[] zza;

    @NonNull
    @SafeParcelable.Field(getter = "getName", m3227id = 3)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getIcon", m3227id = 4)
    private final String zzc;

    @NonNull
    @SafeParcelable.Field(getter = "getDisplayName", m3227id = 5)
    private final String zzd;

    @SafeParcelable.Constructor
    public PublicKeyCredentialUserEntity(@NonNull @SafeParcelable.Param(m3228id = 2) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 3) String str, @NonNull @SafeParcelable.Param(m3228id = 4) String str2, @NonNull @SafeParcelable.Param(m3228id = 5) String str3) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zzc = str2;
        this.zzd = (String) Preconditions.checkNotNull(str3);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        return Arrays.equals(this.zza, publicKeyCredentialUserEntity.zza) && Objects.equal(this.zzb, publicKeyCredentialUserEntity.zzb) && Objects.equal(this.zzc, publicKeyCredentialUserEntity.zzc) && Objects.equal(this.zzd, publicKeyCredentialUserEntity.zzd);
    }

    @NonNull
    public String getDisplayName() {
        return this.zzd;
    }

    @Nullable
    public String getIcon() {
        return this.zzc;
    }

    @NonNull
    public byte[] getId() {
        return this.zza;
    }

    @NonNull
    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIcon(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
