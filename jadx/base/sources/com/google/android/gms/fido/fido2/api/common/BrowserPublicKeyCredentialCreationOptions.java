package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "BrowserPublicKeyCredentialCreationOptionsCreator")
@SafeParcelable.Reserved({1})
public class BrowserPublicKeyCredentialCreationOptions extends BrowserRequestOptions {

    @NonNull
    public static final Parcelable.Creator<BrowserPublicKeyCredentialCreationOptions> CREATOR = new zzn();

    @NonNull
    @SafeParcelable.Field(getter = "getPublicKeyCredentialCreationOptions", m3227id = 2)
    private final PublicKeyCredentialCreationOptions zza;

    @NonNull
    @SafeParcelable.Field(getter = "getOrigin", m3227id = 3)
    private final Uri zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getClientDataHash", m3227id = 4)
    private final byte[] zzc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private PublicKeyCredentialCreationOptions zza;
        private Uri zzb;
        private byte[] zzc;

        @NonNull
        public BrowserPublicKeyCredentialCreationOptions build() {
            return new BrowserPublicKeyCredentialCreationOptions(this.zza, this.zzb, this.zzc);
        }

        @NonNull
        public Builder setClientDataHash(@NonNull byte[] bArr) {
            BrowserPublicKeyCredentialCreationOptions.zzb(bArr);
            this.zzc = bArr;
            return this;
        }

        @NonNull
        public Builder setOrigin(@NonNull Uri uri) {
            BrowserPublicKeyCredentialCreationOptions.zza(uri);
            this.zzb = uri;
            return this;
        }

        @NonNull
        public Builder setPublicKeyCredentialCreationOptions(@NonNull PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions) {
            this.zza = publicKeyCredentialCreationOptions;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public BrowserPublicKeyCredentialCreationOptions(@NonNull @SafeParcelable.Param(m3228id = 2) PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, @NonNull @SafeParcelable.Param(m3228id = 3) Uri uri, @Nullable @SafeParcelable.Param(m3228id = 4) byte[] bArr) {
        this.zza = (PublicKeyCredentialCreationOptions) Preconditions.checkNotNull(publicKeyCredentialCreationOptions);
        zzc(uri);
        this.zzb = uri;
        zzd(bArr);
        this.zzc = bArr;
    }

    @NonNull
    public static BrowserPublicKeyCredentialCreationOptions deserializeFromBytes(@NonNull byte[] bArr) {
        return (BrowserPublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public static /* bridge */ /* synthetic */ Uri zza(Uri uri) {
        zzc(uri);
        return uri;
    }

    public static /* bridge */ /* synthetic */ byte[] zzb(byte[] bArr) {
        zzd(bArr);
        return bArr;
    }

    private static Uri zzc(Uri uri) {
        Preconditions.checkNotNull(uri);
        Preconditions.checkArgument(uri.getScheme() != null, "origin scheme must be non-empty");
        Preconditions.checkArgument(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] zzd(byte[] bArr) {
        boolean z = true;
        if (bArr != null && bArr.length != 32) {
            z = false;
        }
        Preconditions.checkArgument(z, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof BrowserPublicKeyCredentialCreationOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions = (BrowserPublicKeyCredentialCreationOptions) obj;
        return Objects.equal(this.zza, browserPublicKeyCredentialCreationOptions.zza) && Objects.equal(this.zzb, browserPublicKeyCredentialCreationOptions.zzb);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zza.getAuthenticationExtensions();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] getChallenge() {
        return this.zza.getChallenge();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.BrowserRequestOptions
    @Nullable
    public byte[] getClientDataHash() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.BrowserRequestOptions
    @NonNull
    public Uri getOrigin() {
        return this.zzb;
    }

    @NonNull
    public PublicKeyCredentialCreationOptions getPublicKeyCredentialCreationOptions() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Integer getRequestId() {
        return this.zza.getRequestId();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public Double getTimeoutSeconds() {
        return this.zza.getTimeoutSeconds();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @Nullable
    public TokenBinding getTokenBinding() {
        return this.zza.getTokenBinding();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getPublicKeyCredentialCreationOptions(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getOrigin(), i, false);
        SafeParcelWriter.writeByteArray(parcel, 4, getClientDataHash(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
