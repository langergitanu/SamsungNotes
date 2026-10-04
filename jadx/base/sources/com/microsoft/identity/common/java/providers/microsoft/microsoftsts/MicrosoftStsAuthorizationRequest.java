package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAuthorizationRequest extends MicrosoftAuthorizationRequest<MicrosoftStsAuthorizationRequest> {
    private static final String AUTHORIZATION_ENDPOINT = "oAuth2/v2.0/authorize";
    public static final String HIDE_SWITCH_USER_QUERY_PARAMETER = "hsu";
    private static final Object TAG = "MicrosoftStsAuthorizationRequest";
    private static final long serialVersionUID = 6545759826515911472L;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    private final transient String mApplicationIdentifier;

    @SerializedName("cpVersion")
    @Expose
    private final String mCompanyPortalVersion;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    private final transient String mDisplayableId;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    protected transient Map<String, String> mFlightParameters;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    private final transient String mMamEnrollmentIdentifier;
    private final transient OpenIdProviderConfiguration mOpenIdProviderConfiguration;

    @SerializedName(AuthenticationConstants.AAD.QUERY_PROMPT)
    @Expose
    private final String mPrompt;
    protected transient AzureActiveDirectorySlice mSlice;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    private final transient String mTokenScope;

    @SerializedName("login_req")
    private final String mUid;

    @SerializedName("domain_req")
    private final String mUtid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        private String mApplicationIdentifier;
        private String mCompanyPortalVersion;
        private String mDisplayableId;
        private Map<String, String> mFlightParameters = new HashMap();
        private String mMamEnrollmentIdentifier;
        private OpenIdProviderConfiguration mOpenIdProviderConfiguration;
        private String mPrompt;
        private AzureActiveDirectorySlice mSlice;
        private String mTokenScope;
        private String mUid;
        private String mUtid;

        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        public Builder setApplicationIdentifier(String str) {
            this.mApplicationIdentifier = str;
            return self();
        }

        public Builder setDisplayableId(String str) {
            this.mDisplayableId = str;
            return self();
        }

        public Builder setFlightParameters(Map<String, String> map) {
            this.mFlightParameters = map;
            return self();
        }

        public Builder setInstalledCompanyPortalVersion(String str) {
            this.mCompanyPortalVersion = str;
            return self();
        }

        public Builder setMamEnrollmentIdentifier(String str) {
            this.mMamEnrollmentIdentifier = str;
            return self();
        }

        public Builder setOpenIdProviderConfiguration(OpenIdProviderConfiguration openIdProviderConfiguration) {
            this.mOpenIdProviderConfiguration = openIdProviderConfiguration;
            return self();
        }

        public Builder setPrompt(String str) {
            this.mPrompt = str;
            return self();
        }

        public Builder setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
            this.mSlice = azureActiveDirectorySlice;
            return self();
        }

        public Builder setTokenScope(String str) {
            this.mTokenScope = str;
            return self();
        }

        public Builder setUid(String str) {
            this.mUid = str;
            return self();
        }

        public Builder setUtid(String str) {
            this.mUtid = str;
            return self();
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public MicrosoftStsAuthorizationRequest build() {
            return new MicrosoftStsAuthorizationRequest(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Prompt {
        public static final String CONSENT = "consent";
        public static final String FORCE_LOGIN = "login";
        public static final String SELECT_ACCOUNT = "select_account";
    }

    public MicrosoftStsAuthorizationRequest(Builder builder) {
        super(builder);
        this.mPrompt = builder.mPrompt;
        this.mUid = builder.mUid;
        this.mUtid = builder.mUtid;
        this.mCompanyPortalVersion = builder.mCompanyPortalVersion;
        this.mDisplayableId = builder.mDisplayableId;
        this.mTokenScope = builder.mTokenScope;
        this.mSlice = builder.mSlice;
        this.mFlightParameters = builder.mFlightParameters;
        this.mApplicationIdentifier = builder.mApplicationIdentifier;
        this.mMamEnrollmentIdentifier = builder.mMamEnrollmentIdentifier;
        this.mOpenIdProviderConfiguration = builder.mOpenIdProviderConfiguration;
    }

    public String getApplicationIdentifier() {
        return this.mApplicationIdentifier;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() throws ClientException {
        OpenIdProviderConfiguration openIdProviderConfiguration = this.mOpenIdProviderConfiguration;
        if (openIdProviderConfiguration != null) {
            return openIdProviderConfiguration.getAuthorizationEndpoint();
        }
        if (getAuthority() != null) {
            try {
                return UrlUtil.appendPathToURL(getAuthority(), AUTHORIZATION_ENDPOINT).toString();
            } catch (MalformedURLException | URISyntaxException e) {
                throw new ClientException("malformed_url", e.getMessage(), e);
            }
        }
        Logger.error(TAG + ":getAuthorizationEndpoint", "Authority is null. cannot construct authorization endpoint URL.", null);
        throw new IllegalStateException("Authority is null.");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public URI getAuthorizationRequestAsHttpRequest() throws ClientException {
        CommonURIBuilder commonURIBuilder = new CommonURIBuilder(super.getAuthorizationRequestAsHttpRequest());
        commonURIBuilder.addParametersIfAbsent(this.mFlightParameters);
        AzureActiveDirectorySlice azureActiveDirectorySlice = this.mSlice;
        if (azureActiveDirectorySlice != null) {
            if (!StringUtil.isNullOrEmpty(azureActiveDirectorySlice.getSlice())) {
                commonURIBuilder.addParameterIfAbsent(AzureActiveDirectorySlice.SLICE_PARAMETER, this.mSlice.getSlice());
            }
            if (!StringUtil.isNullOrEmpty(this.mSlice.getDataCenter())) {
                commonURIBuilder.addParameterIfAbsent("dc", this.mSlice.getDataCenter());
            }
        }
        if (!StringUtil.isNullOrEmpty(getLoginHint())) {
            commonURIBuilder.addParameterIfAbsent(HIDE_SWITCH_USER_QUERY_PARAMETER, "1");
        }
        try {
            return commonURIBuilder.build();
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    public String getDisplayableId() {
        return this.mDisplayableId;
    }

    public String getMamEnrollmentIdentifier() {
        return this.mMamEnrollmentIdentifier;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public String getTokenScope() {
        return this.mTokenScope;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtid() {
        return this.mUtid;
    }
}
