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
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "PublicKeyCredentialRequestOptionsCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialRequestOptions extends RequestOptions {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzao();

    @NonNull
    @SafeParcelable.Field(getter = "getChallenge", m3227id = 2)
    private final byte[] zza;

    @Nullable
    @SafeParcelable.Field(getter = "getTimeoutSeconds", m3227id = 3)
    private final Double zzb;

    @NonNull
    @SafeParcelable.Field(getter = "getRpId", m3227id = 4)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getAllowList", m3227id = 5)
    private final List zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getRequestId", m3227id = 6)
    private final Integer zze;

    @Nullable
    @SafeParcelable.Field(getter = "getTokenBinding", m3227id = 7)
    private final TokenBinding zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getUserVerificationAsString", m3227id = 8, type = "java.lang.String")
    private final zzay zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getAuthenticationExtensions", m3227id = 9)
    private final AuthenticationExtensions zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getLongRequestId", m3227id = 10)
    private final Long zzi;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private byte[] zza;
        private Double zzb;
        private String zzc;
        private List zzd;
        private Integer zze;
        private TokenBinding zzf;
        private zzay zzg;
        private AuthenticationExtensions zzh;

        public Builder() {
        }

        @NonNull
        public PublicKeyCredentialRequestOptions build() {
            byte[] bArr = this.zza;
            Double d = this.zzb;
            String str = this.zzc;
            List list = this.zzd;
            Integer num = this.zze;
            TokenBinding tokenBinding = this.zzf;
            zzay zzayVar = this.zzg;
            return new PublicKeyCredentialRequestOptions(bArr, d, str, list, num, tokenBinding, zzayVar == null ? null : zzayVar.toString(), this.zzh, null);
        }

        @NonNull
        public Builder setAllowList(@Nullable List<PublicKeyCredentialDescriptor> list) {
            this.zzd = list;
            return this;
        }

        @NonNull
        public Builder setAuthenticationExtensions(@Nullable AuthenticationExtensions authenticationExtensions) {
            this.zzh = authenticationExtensions;
            return this;
        }

        @NonNull
        public Builder setChallenge(@NonNull byte[] bArr) {
            this.zza = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        @NonNull
        public Builder setRequestId(@Nullable Integer num) {
            this.zze = num;
            return this;
        }

        @NonNull
        public Builder setRpId(@NonNull String str) {
            this.zzc = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @NonNull
        public Builder setTimeoutSeconds(@Nullable Double d) {
            this.zzb = d;
            return this;
        }

        @NonNull
        public Builder setTokenBinding(@Nullable TokenBinding tokenBinding) {
            this.zzf = tokenBinding;
            return this;
        }

        public Builder(@Nullable PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
            if (publicKeyCredentialRequestOptions != null) {
                this.zza = publicKeyCredentialRequestOptions.getChallenge();
                this.zzb = publicKeyCredentialRequestOptions.getTimeoutSeconds();
                this.zzc = publicKeyCredentialRequestOptions.getRpId();
                this.zzd = publicKeyCredentialRequestOptions.getAllowList();
                this.zze = publicKeyCredentialRequestOptions.getRequestId();
                this.zzf = publicKeyCredentialRequestOptions.getTokenBinding();
                this.zzg = publicKeyCredentialRequestOptions.zza();
                this.zzh = publicKeyCredentialRequestOptions.getAuthenticationExtensions();
            }
        }
    }

    @SafeParcelable.Constructor
    public PublicKeyCredentialRequestOptions(@NonNull @SafeParcelable.Param(m3228id = 2) byte[] bArr, @Nullable @SafeParcelable.Param(m3228id = 3) Double d, @NonNull @SafeParcelable.Param(m3228id = 4) String str, @Nullable @SafeParcelable.Param(m3228id = 5) List list, @Nullable @SafeParcelable.Param(m3228id = 6) Integer num, @Nullable @SafeParcelable.Param(m3228id = 7) TokenBinding tokenBinding, @Nullable @SafeParcelable.Param(m3228id = 8) String str2, @Nullable @SafeParcelable.Param(m3228id = 9) AuthenticationExtensions authenticationExtensions, @Nullable @SafeParcelable.Param(m3228id = 10) Long l) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = d;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = list;
        this.zze = num;
        this.zzf = tokenBinding;
        this.zzi = l;
        if (str2 != null) {
            try {
                this.zzg = zzay.zza(str2);
            } catch (zzax e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = authenticationExtensions;
    }

    @NonNull
    public static PublicKeyCredentialRequestOptions deserializeFromBytes(@Nullable byte[] bArr) {
        return (PublicKeyCredentialRequestOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        return Arrays.equals(this.zza, publicKeyCredentialRequestOptions.zza) && Objects.equal(this.zzb, publicKeyCredentialRequestOptions.zzb) && Objects.equal(this.zzc, publicKeyCredentialRequestOptions.zzc) && (((list = this.zzd) == null && publicKeyCredentialRequestOptions.zzd == null) || (list != null && (list2 = publicKeyCredentialRequestOptions.zzd) != null && list.containsAll(list2) && publicKeyCredentialRequestOptions.zzd.containsAll(this.zzd))) && Objects.equal(this.zze, publicKeyCredentialRequestOptions.zze) && Objects.equal(this.zzf, publicKeyCredentialRequestOptions.zzf) && Objects.equal(this.zzg, publicKeyCredentialRequestOptions.zzg) && Objects.equal(this.zzh, publicKeyCredentialRequestOptions.zzh) && Objects.equal(this.zzi, publicKeyCredentialRequestOptions.zzi);
    }

    @Nullable
    public List<PublicKeyCredentialDescriptor> getAllowList() {
        return this.zzd;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzh;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] getChallenge() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Integer getRequestId() {
        return this.zze;
    }

    @NonNull
    public String getRpId() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public TokenBinding getTokenBinding() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeString(parcel, 4, getRpId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getAllowList(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getTokenBinding(), i, false);
        zzay zzayVar = this.zzg;
        SafeParcelWriter.writeString(parcel, 8, zzayVar == null ? null : zzayVar.toString(), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getAuthenticationExtensions(), i, false);
        SafeParcelWriter.writeLongObject(parcel, 10, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Nullable
    public final zzay zza() {
        return this.zzg;
    }
}
