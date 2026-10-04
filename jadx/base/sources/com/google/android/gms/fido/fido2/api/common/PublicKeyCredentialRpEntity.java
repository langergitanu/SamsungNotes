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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "PublicKeyCredentialRpEntityCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRpEntity> CREATOR = new zzap();

    @NonNull
    @SafeParcelable.Field(getter = "getId", m3227id = 2)
    private final String zza;

    @NonNull
    @SafeParcelable.Field(getter = "getName", m3227id = 3)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getIcon", m3227id = 4)
    private final String zzc;

    @SafeParcelable.Constructor
    public PublicKeyCredentialRpEntity(@NonNull @SafeParcelable.Param(m3228id = 2) String str, @NonNull @SafeParcelable.Param(m3228id = 3) String str2, @Nullable @SafeParcelable.Param(m3228id = 4) String str3) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        this.zzc = str3;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        return Objects.equal(this.zza, publicKeyCredentialRpEntity.zza) && Objects.equal(this.zzb, publicKeyCredentialRpEntity.zzb) && Objects.equal(this.zzc, publicKeyCredentialRpEntity.zzc);
    }

    @Nullable
    public String getIcon() {
        return this.zzc;
    }

    @NonNull
    public String getId() {
        return this.zza;
    }

    @NonNull
    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIcon(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
