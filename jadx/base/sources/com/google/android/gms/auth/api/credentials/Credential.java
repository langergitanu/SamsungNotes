package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.microsoft.identity.common.java.AuthenticationConstants;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "CredentialCreator")
@SafeParcelable.Reserved({1000, 1001, 1002})
@Deprecated
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Credential> CREATOR = new zba();

    @NonNull
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";

    @Nonnull
    @SafeParcelable.Field(getter = "getId", m3227id = 1)
    private final String zba;

    @Nullable
    @SafeParcelable.Field(getter = "getName", m3227id = 2)
    private final String zbb;

    @Nullable
    @SafeParcelable.Field(getter = "getProfilePictureUri", m3227id = 3)
    private final Uri zbc;

    @Nonnull
    @SafeParcelable.Field(getter = "getIdTokens", m3227id = 4)
    private final List zbd;

    @Nullable
    @SafeParcelable.Field(getter = "getPassword", m3227id = 5)
    private final String zbe;

    @Nullable
    @SafeParcelable.Field(getter = "getAccountType", m3227id = 6)
    private final String zbf;

    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", m3227id = 9)
    private final String zbg;

    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", m3227id = 10)
    private final String zbh;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static class Builder {
        private final String zba;

        @Nullable
        private String zbb;

        @Nullable
        private Uri zbc;
        private List zbd;

        @Nullable
        private String zbe;

        @Nullable
        private String zbf;

        @Nullable
        private String zbg;

        @Nullable
        private String zbh;

        public Builder(@NonNull String str) {
            this.zba = str;
        }

        @NonNull
        public Credential build() {
            return new Credential(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
        }

        @NonNull
        public Builder setAccountType(@NonNull String str) {
            this.zbf = str;
            return this;
        }

        @NonNull
        public Builder setName(@NonNull String str) {
            this.zbb = str;
            return this;
        }

        @NonNull
        public Builder setPassword(@Nullable String str) {
            this.zbe = str;
            return this;
        }

        @NonNull
        public Builder setProfilePictureUri(@NonNull Uri uri) {
            this.zbc = uri;
            return this;
        }

        public Builder(@NonNull Credential credential) {
            this.zba = credential.zba;
            this.zbb = credential.zbb;
            this.zbc = credential.zbc;
            this.zbd = credential.zbd;
            this.zbe = credential.zbe;
            this.zbf = credential.zbf;
            this.zbg = credential.zbg;
            this.zbh = credential.zbh;
        }
    }

    @SafeParcelable.Constructor
    public Credential(@SafeParcelable.Param(m3228id = 1) String str, @Nullable @SafeParcelable.Param(m3228id = 2) String str2, @Nullable @SafeParcelable.Param(m3228id = 3) Uri uri, @SafeParcelable.Param(m3228id = 4) List list, @Nullable @SafeParcelable.Param(m3228id = 5) String str3, @Nullable @SafeParcelable.Param(m3228id = 6) String str4, @Nullable @SafeParcelable.Param(m3228id = 9) String str5, @Nullable @SafeParcelable.Param(m3228id = 10) String str6) {
        Boolean boolValueOf;
        String strTrim = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(strTrim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            if (TextUtils.isEmpty(str4)) {
                boolValueOf = Boolean.FALSE;
            } else {
                Uri uri2 = Uri.parse(str4);
                if (!uri2.isAbsolute() || !uri2.isHierarchical() || TextUtils.isEmpty(uri2.getScheme()) || TextUtils.isEmpty(uri2.getAuthority())) {
                    boolValueOf = Boolean.FALSE;
                } else {
                    boolean z = true;
                    if (!"http".equalsIgnoreCase(uri2.getScheme()) && !AuthenticationConstants.HTTPS_PROTOCOL_STRING.equalsIgnoreCase(uri2.getScheme())) {
                        z = false;
                    }
                    boolValueOf = Boolean.valueOf(z);
                }
            }
            if (!boolValueOf.booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.zbb = str2;
        this.zbc = uri;
        this.zbd = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
        this.zba = strTrim;
        this.zbe = str3;
        this.zbf = str4;
        this.zbg = str5;
        this.zbh = str6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zba, credential.zba) && TextUtils.equals(this.zbb, credential.zbb) && Objects.equal(this.zbc, credential.zbc) && TextUtils.equals(this.zbe, credential.zbe) && TextUtils.equals(this.zbf, credential.zbf);
    }

    @Nullable
    public String getAccountType() {
        return this.zbf;
    }

    @Nullable
    public String getFamilyName() {
        return this.zbh;
    }

    @Nullable
    public String getGivenName() {
        return this.zbg;
    }

    @Nonnull
    public String getId() {
        return this.zba;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zbd;
    }

    @Nullable
    public String getName() {
        return this.zbb;
    }

    @Nullable
    public String getPassword() {
        return this.zbe;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zbc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbe, this.zbf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
