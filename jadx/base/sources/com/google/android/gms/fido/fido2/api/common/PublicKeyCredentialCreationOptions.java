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
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "PublicKeyCredentialCreationOptionsCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialCreationOptions extends RequestOptions {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzak();

    @NonNull
    @SafeParcelable.Field(getter = "getRp", m3227id = 2)
    private final PublicKeyCredentialRpEntity zza;

    @NonNull
    @SafeParcelable.Field(getter = "getUser", m3227id = 3)
    private final PublicKeyCredentialUserEntity zzb;

    @NonNull
    @SafeParcelable.Field(getter = "getChallenge", m3227id = 4)
    private final byte[] zzc;

    @NonNull
    @SafeParcelable.Field(getter = "getParameters", m3227id = 5)
    private final List zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getTimeoutSeconds", m3227id = 6)
    private final Double zze;

    @Nullable
    @SafeParcelable.Field(getter = "getExcludeList", m3227id = 7)
    private final List zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getAuthenticatorSelection", m3227id = 8)
    private final AuthenticatorSelectionCriteria zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getRequestId", m3227id = 9)
    private final Integer zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getTokenBinding", m3227id = 10)
    private final TokenBinding zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getAttestationConveyancePreferenceAsString", m3227id = 11, type = "java.lang.String")
    private final AttestationConveyancePreference zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getAuthenticationExtensions", m3227id = 12)
    private final AuthenticationExtensions zzk;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private PublicKeyCredentialRpEntity zza;
        private PublicKeyCredentialUserEntity zzb;
        private byte[] zzc;
        private List zzd;
        private Double zze;
        private List zzf;
        private AuthenticatorSelectionCriteria zzg;
        private Integer zzh;
        private TokenBinding zzi;
        private AttestationConveyancePreference zzj;
        private AuthenticationExtensions zzk;

        @NonNull
        public PublicKeyCredentialCreationOptions build() {
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.zza;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
            byte[] bArr = this.zzc;
            List list = this.zzd;
            Double d = this.zze;
            List list2 = this.zzf;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
            Integer num = this.zzh;
            TokenBinding tokenBinding = this.zzi;
            AttestationConveyancePreference attestationConveyancePreference = this.zzj;
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d, list2, authenticatorSelectionCriteria, num, tokenBinding, attestationConveyancePreference == null ? null : attestationConveyancePreference.toString(), this.zzk);
        }

        @NonNull
        public Builder setAttestationConveyancePreference(@Nullable AttestationConveyancePreference attestationConveyancePreference) {
            this.zzj = attestationConveyancePreference;
            return this;
        }

        @NonNull
        public Builder setAuthenticationExtensions(@Nullable AuthenticationExtensions authenticationExtensions) {
            this.zzk = authenticationExtensions;
            return this;
        }

        @NonNull
        public Builder setAuthenticatorSelection(@Nullable AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.zzg = authenticatorSelectionCriteria;
            return this;
        }

        @NonNull
        public Builder setChallenge(@NonNull byte[] bArr) {
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        @NonNull
        public Builder setExcludeList(@Nullable List<PublicKeyCredentialDescriptor> list) {
            this.zzf = list;
            return this;
        }

        @NonNull
        public Builder setParameters(@NonNull List<PublicKeyCredentialParameters> list) {
            this.zzd = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @NonNull
        public Builder setRequestId(@Nullable Integer num) {
            this.zzh = num;
            return this;
        }

        @NonNull
        public Builder setRp(@NonNull PublicKeyCredentialRpEntity publicKeyCredentialRpEntity) {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
            return this;
        }

        @NonNull
        public Builder setTimeoutSeconds(@Nullable Double d) {
            this.zze = d;
            return this;
        }

        @NonNull
        public Builder setTokenBinding(@Nullable TokenBinding tokenBinding) {
            this.zzi = tokenBinding;
            return this;
        }

        @NonNull
        public Builder setUser(@NonNull PublicKeyCredentialUserEntity publicKeyCredentialUserEntity) {
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public PublicKeyCredentialCreationOptions(@NonNull @SafeParcelable.Param(m3228id = 2) PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, @NonNull @SafeParcelable.Param(m3228id = 3) PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, @NonNull @SafeParcelable.Param(m3228id = 4) byte[] bArr, @NonNull @SafeParcelable.Param(m3228id = 5) List list, @Nullable @SafeParcelable.Param(m3228id = 6) Double d, @Nullable @SafeParcelable.Param(m3228id = 7) List list2, @Nullable @SafeParcelable.Param(m3228id = 8) AuthenticatorSelectionCriteria authenticatorSelectionCriteria, @Nullable @SafeParcelable.Param(m3228id = 9) Integer num, @Nullable @SafeParcelable.Param(m3228id = 10) TokenBinding tokenBinding, @Nullable @SafeParcelable.Param(m3228id = 11) String str, @Nullable @SafeParcelable.Param(m3228id = 12) AuthenticationExtensions authenticationExtensions) {
        this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
        this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzd = (List) Preconditions.checkNotNull(list);
        this.zze = d;
        this.zzf = list2;
        this.zzg = authenticatorSelectionCriteria;
        this.zzh = num;
        this.zzi = tokenBinding;
        if (str != null) {
            try {
                this.zzj = AttestationConveyancePreference.fromString(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.zzj = null;
        }
        this.zzk = authenticationExtensions;
    }

    @NonNull
    public static PublicKeyCredentialCreationOptions deserializeFromBytes(@NonNull byte[] bArr) {
        return (PublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        return Objects.equal(this.zza, publicKeyCredentialCreationOptions.zza) && Objects.equal(this.zzb, publicKeyCredentialCreationOptions.zzb) && Arrays.equals(this.zzc, publicKeyCredentialCreationOptions.zzc) && Objects.equal(this.zze, publicKeyCredentialCreationOptions.zze) && this.zzd.containsAll(publicKeyCredentialCreationOptions.zzd) && publicKeyCredentialCreationOptions.zzd.containsAll(this.zzd) && (((list = this.zzf) == null && publicKeyCredentialCreationOptions.zzf == null) || (list != null && (list2 = publicKeyCredentialCreationOptions.zzf) != null && list.containsAll(list2) && publicKeyCredentialCreationOptions.zzf.containsAll(this.zzf))) && Objects.equal(this.zzg, publicKeyCredentialCreationOptions.zzg) && Objects.equal(this.zzh, publicKeyCredentialCreationOptions.zzh) && Objects.equal(this.zzi, publicKeyCredentialCreationOptions.zzi) && Objects.equal(this.zzj, publicKeyCredentialCreationOptions.zzj) && Objects.equal(this.zzk, publicKeyCredentialCreationOptions.zzk);
    }

    @Nullable
    public AttestationConveyancePreference getAttestationConveyancePreference() {
        return this.zzj;
    }

    @Nullable
    public String getAttestationConveyancePreferenceAsString() {
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzk;
    }

    @Nullable
    public AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.zzg;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] getChallenge() {
        return this.zzc;
    }

    @Nullable
    public List<PublicKeyCredentialDescriptor> getExcludeList() {
        return this.zzf;
    }

    @NonNull
    public List<PublicKeyCredentialParameters> getParameters() {
        return this.zzd;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Integer getRequestId() {
        return this.zzh;
    }

    @NonNull
    public PublicKeyCredentialRpEntity getRp() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Double getTimeoutSeconds() {
        return this.zze;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public TokenBinding getTokenBinding() {
        return this.zzi;
    }

    @NonNull
    public PublicKeyCredentialUserEntity getUser() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getRp(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getUser(), i, false);
        SafeParcelWriter.writeByteArray(parcel, 4, getChallenge(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getParameters(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 6, getTimeoutSeconds(), false);
        SafeParcelWriter.writeTypedList(parcel, 7, getExcludeList(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getAuthenticatorSelection(), i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 9, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 10, getTokenBinding(), i, false);
        SafeParcelWriter.writeString(parcel, 11, getAttestationConveyancePreferenceAsString(), false);
        SafeParcelWriter.writeParcelable(parcel, 12, getAuthenticationExtensions(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
