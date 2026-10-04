package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AuthenticatorSelectionCriteriaCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorSelectionCriteria extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorSelectionCriteria> CREATOR = new zzm();

    @Nullable
    @SafeParcelable.Field(getter = "getAttachmentAsString", m3227id = 2, type = "java.lang.String")
    private final Attachment zza;

    @Nullable
    @SafeParcelable.Field(getter = "getRequireResidentKey", m3227id = 3)
    private final Boolean zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getRequireUserVerificationAsString", m3227id = 4, type = "java.lang.String")
    private final zzay zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getResidentKeyRequirementAsString", m3227id = 5, type = "java.lang.String")
    private final ResidentKeyRequirement zzd;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Attachment zza;
        private Boolean zzb;
        private ResidentKeyRequirement zzc;

        @NonNull
        public AuthenticatorSelectionCriteria build() {
            Attachment attachment = this.zza;
            String string = attachment == null ? null : attachment.toString();
            Boolean bool = this.zzb;
            ResidentKeyRequirement residentKeyRequirement = this.zzc;
            return new AuthenticatorSelectionCriteria(string, bool, null, residentKeyRequirement == null ? null : residentKeyRequirement.toString());
        }

        @NonNull
        public Builder setAttachment(@Nullable Attachment attachment) {
            this.zza = attachment;
            return this;
        }

        @NonNull
        public Builder setRequireResidentKey(@Nullable Boolean bool) {
            this.zzb = bool;
            return this;
        }

        @NonNull
        public Builder setResidentKeyRequirement(@Nullable ResidentKeyRequirement residentKeyRequirement) {
            this.zzc = residentKeyRequirement;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public AuthenticatorSelectionCriteria(@Nullable @SafeParcelable.Param(m3228id = 2) String str, @Nullable @SafeParcelable.Param(m3228id = 3) Boolean bool, @Nullable @SafeParcelable.Param(m3228id = 4) String str2, @Nullable @SafeParcelable.Param(m3228id = 5) String str3) {
        Attachment attachmentFromString;
        ResidentKeyRequirement residentKeyRequirementFromString = null;
        if (str == null) {
            attachmentFromString = null;
        } else {
            try {
                attachmentFromString = Attachment.fromString(str);
            } catch (Attachment.UnsupportedAttachmentException | ResidentKeyRequirement.UnsupportedResidentKeyRequirementException | zzax e) {
                throw new IllegalArgumentException(e);
            }
        }
        this.zza = attachmentFromString;
        this.zzb = bool;
        this.zzc = str2 == null ? null : zzay.zza(str2);
        if (str3 != null) {
            residentKeyRequirementFromString = ResidentKeyRequirement.fromString(str3);
        }
        this.zzd = residentKeyRequirementFromString;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        return Objects.equal(this.zza, authenticatorSelectionCriteria.zza) && Objects.equal(this.zzb, authenticatorSelectionCriteria.zzb) && Objects.equal(this.zzc, authenticatorSelectionCriteria.zzc) && Objects.equal(getResidentKeyRequirement(), authenticatorSelectionCriteria.getResidentKeyRequirement());
    }

    @Nullable
    public Attachment getAttachment() {
        return this.zza;
    }

    @Nullable
    public String getAttachmentAsString() {
        Attachment attachment = this.zza;
        if (attachment == null) {
            return null;
        }
        return attachment.toString();
    }

    @Nullable
    public Boolean getRequireResidentKey() {
        return this.zzb;
    }

    @Nullable
    public ResidentKeyRequirement getResidentKeyRequirement() {
        ResidentKeyRequirement residentKeyRequirement = this.zzd;
        if (residentKeyRequirement != null) {
            return residentKeyRequirement;
        }
        Boolean bool = this.zzb;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return ResidentKeyRequirement.RESIDENT_KEY_REQUIRED;
    }

    @Nullable
    public String getResidentKeyRequirementAsString() {
        if (getResidentKeyRequirement() == null) {
            return null;
        }
        return getResidentKeyRequirement().toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, getResidentKeyRequirement());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAttachmentAsString(), false);
        SafeParcelWriter.writeBooleanObject(parcel, 3, getRequireResidentKey(), false);
        zzay zzayVar = this.zzc;
        SafeParcelWriter.writeString(parcel, 4, zzayVar == null ? null : zzayVar.toString(), false);
        SafeParcelWriter.writeString(parcel, 5, getResidentKeyRequirementAsString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
