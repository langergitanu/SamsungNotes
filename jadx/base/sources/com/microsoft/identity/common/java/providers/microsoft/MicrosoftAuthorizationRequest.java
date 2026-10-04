package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.DefaultStateGenerator;
import com.microsoft.identity.common.java.providers.oauth2.PkceChallenge;
import java.net.URL;
import java.util.UUID;
import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MicrosoftAuthorizationRequest<T extends MicrosoftAuthorizationRequest<T>> extends AuthorizationRequest<T> {
    public static final String INSTANCE_AWARE = "instance_aware";
    private static final String TAG = "MicrosoftAuthorizationRequest";
    private static final long serialVersionUID = 6873634931996113294L;
    private final transient URL mAuthority;

    @SerializedName("client-request-id")
    @Expose
    private final UUID mCorrelationId;

    @SerializedName("x-client-CPU")
    @Expose
    private final String mDiagnosticCPU;

    @SerializedName("x-client-DM")
    @Expose
    private final String mDiagnosticDM;

    @SerializedName("x-client-OS")
    @Expose
    private final String mDiagnosticOS;

    @SerializedName("x-client-SKU")
    @Expose
    private final String mLibraryName;

    @SerializedName("x-client-Ver")
    @Expose
    private final String mLibraryVersion;

    @SerializedName("login_hint")
    private final String mLoginHint;

    @SerializedName("instance_aware")
    @Expose
    private final Boolean mMultipleCloudAware;

    @SerializedName("code_challenge")
    private final String mPkceCodeChallenge;

    @SerializedName("code_challenge_method")
    private final String mPkceCodeChallengeMethod;
    private final transient String mPkceCodeVerifier;

    @SerializedName("pc")
    @Expose
    private final String mPreferredAuthMethodCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Builder<B extends Builder<B>> extends AuthorizationRequest.Builder<B> {
        private URL mAuthority;
        private UUID mCorrelationId;
        private String mLibraryName;
        private String mLibraryVersion;
        private String mLoginHint;
        private Boolean mMultipleCloudAware;
        private PkceChallenge mPkceChallenge;
        private PreferredAuthMethod mPreferredAuthMethod;

        public Builder() {
            setState(new DefaultStateGenerator().generate());
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public abstract B self();

        public B setAuthority(URL url) {
            this.mAuthority = url;
            return (B) self();
        }

        public B setCorrelationId(UUID uuid) {
            this.mCorrelationId = uuid;
            return (B) self();
        }

        public B setLibraryName(String str) {
            this.mLibraryName = str;
            return (B) self();
        }

        public B setLibraryVersion(String str) {
            this.mLibraryVersion = str;
            return (B) self();
        }

        public B setLoginHint(String str) {
            this.mLoginHint = str;
            return (B) self();
        }

        public B setMultipleCloudAware(boolean z) {
            this.mMultipleCloudAware = Boolean.valueOf(z);
            return (B) self();
        }

        public B setPkceChallenge(@NonNull PkceChallenge pkceChallenge) {
            if (pkceChallenge == null) {
                throw new NullPointerException("pkceChallenge is marked non-null but is null");
            }
            this.mPkceChallenge = pkceChallenge;
            return (B) self();
        }

        public B setPreferredAuthMethod(@Nullable PreferredAuthMethod preferredAuthMethod) {
            this.mPreferredAuthMethod = preferredAuthMethod;
            return (B) self();
        }
    }

    public MicrosoftAuthorizationRequest(Builder builder) {
        super(builder);
        this.mAuthority = builder.mAuthority;
        this.mLoginHint = builder.mLoginHint;
        this.mCorrelationId = builder.mCorrelationId;
        PkceChallenge pkceChallengeNewPkceChallenge = builder.mPkceChallenge == null ? PkceChallenge.newPkceChallenge() : builder.mPkceChallenge;
        this.mPkceCodeChallengeMethod = pkceChallengeNewPkceChallenge.getCodeChallengeMethod();
        this.mPkceCodeChallenge = pkceChallengeNewPkceChallenge.getCodeChallenge();
        this.mPkceCodeVerifier = pkceChallengeNewPkceChallenge.getCodeVerifier();
        this.mMultipleCloudAware = builder.mMultipleCloudAware;
        this.mLibraryVersion = builder.mLibraryVersion;
        this.mLibraryName = builder.mLibraryName;
        this.mPreferredAuthMethodCode = builder.mPreferredAuthMethod == null ? null : String.valueOf(builder.mPreferredAuthMethod.code);
        this.mDiagnosticOS = Device.getOsForEsts();
        this.mDiagnosticDM = Device.getModel();
        this.mDiagnosticCPU = Device.getCpu();
    }

    public URL getAuthority() {
        return this.mAuthority;
    }

    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getDiagnosticCPU() {
        return this.mDiagnosticCPU;
    }

    public String getDiagnosticDM() {
        return this.mDiagnosticDM;
    }

    public String getDiagnosticOS() {
        return this.mDiagnosticOS;
    }

    public String getLibraryName() {
        return this.mLibraryName;
    }

    public String getLibraryVersion() {
        return this.mLibraryVersion;
    }

    public String getLoginHint() {
        return this.mLoginHint;
    }

    public Boolean getMultipleCloudAware() {
        return this.mMultipleCloudAware;
    }

    public String getPkceCodeChallenge() {
        return this.mPkceCodeChallenge;
    }

    public String getPkceCodeChallengeMethod() {
        return this.mPkceCodeChallengeMethod;
    }

    public String getPkceCodeVerifier() {
        return this.mPkceCodeVerifier;
    }

    public String getPreferredAuthMethodCode() {
        return this.mPreferredAuthMethodCode;
    }
}
