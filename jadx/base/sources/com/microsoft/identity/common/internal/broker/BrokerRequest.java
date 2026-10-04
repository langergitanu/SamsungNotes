package com.microsoft.identity.common.internal.broker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.request.SdkType;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerRequest implements Serializable {
    private static final long serialVersionUID = -543392127065130474L;

    @NonNull
    @SerializedName("client_app_name")
    private String mApplicationName;

    @NonNull
    @SerializedName("client_app_version")
    private String mApplicationVersion;

    @Nullable
    @SerializedName(ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME)
    private AbstractAuthenticationScheme mAuthenticationScheme;

    @NonNull
    @SerializedName("authority")
    private String mAuthority;

    @Nullable
    @SerializedName("authorization_agent")
    private String mAuthorizationAgent;

    @SerializedName("child_client_id")
    private String mChildClientId;

    @SerializedName("child_redirect_uri")
    private String mChildRedirectUri;

    @Nullable
    @SerializedName("claims")
    private String mClaims;

    @NonNull
    @SerializedName("client_id")
    private String mClientId;

    @NonNull
    @SerializedName("correlation_id")
    private String mCorrelationId;

    @NonNull
    @SerializedName("environment")
    private String mEnvironment;

    @Nullable
    @SerializedName("extra_options")
    private String mExtraOptions;

    @Nullable
    @SerializedName("extra_query_param")
    private String mExtraQueryStringParameter;

    @Nullable
    @SerializedName("force_refresh")
    private boolean mForceRefresh;

    @Nullable
    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @SerializedName(AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID)
    private String mLocalAccountId;

    @NonNull
    @SerializedName("client_version")
    private String mMsalVersion;

    @NonNull
    @SerializedName("multiple_clouds_supported")
    private boolean mMultipleCloudsSupported;

    @Nullable
    @SerializedName("power_opt_check_enabled")
    private boolean mPowerOptCheckEnabled;

    @Nullable
    @SerializedName("preferred_auth_method")
    private PreferredAuthMethod mPreferredAuthMethod;

    @Nullable
    @SerializedName("preferred_browser")
    private BrowserDescriptor mPreferredBrowser;

    @Nullable
    @SerializedName(AuthenticationConstants.AAD.QUERY_PROMPT)
    private String mPrompt;

    @NonNull
    @SerializedName("redirect_uri")
    private String mRedirect;

    @NonNull
    @SerializedName("scopes")
    private String mScope;

    @NonNull
    @SerializedName("client_sdk_type")
    private SdkType mSdkType;

    @Nullable
    @SerializedName("span_context")
    private SerializableSpanContext mSpanContext;

    @Nullable
    @SerializedName("username")
    private String mUserName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BrokerRequestBuilder {
        private String applicationName;
        private String applicationVersion;
        private AbstractAuthenticationScheme authenticationScheme;
        private String authority;
        private String authorizationAgent;
        private String childClientId;
        private String childRedirectUri;
        private String claims;
        private String clientId;
        private String correlationId;
        private String environment;
        private String extraOptions;
        private String extraQueryStringParameter;
        private boolean forceRefresh;
        private String homeAccountId;
        private String localAccountId;
        private String msalVersion;
        private boolean multipleCloudsSupported;
        private boolean powerOptCheckEnabled;
        private PreferredAuthMethod preferredAuthMethod;
        private BrowserDescriptor preferredBrowser;
        private String prompt;
        private String redirect;
        private String scope;
        private SdkType sdkType;
        private SerializableSpanContext spanContext;
        private String userName;

        public BrokerRequestBuilder applicationName(@NonNull String str) {
            this.applicationName = str;
            return this;
        }

        public BrokerRequestBuilder applicationVersion(@NonNull String str) {
            this.applicationVersion = str;
            return this;
        }

        public BrokerRequestBuilder authenticationScheme(@Nullable AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return this;
        }

        public BrokerRequestBuilder authority(@NonNull String str) {
            this.authority = str;
            return this;
        }

        public BrokerRequestBuilder authorizationAgent(@Nullable String str) {
            this.authorizationAgent = str;
            return this;
        }

        public BrokerRequest build() {
            return new BrokerRequest(this.authority, this.scope, this.redirect, this.clientId, this.userName, this.homeAccountId, this.localAccountId, this.extraQueryStringParameter, this.extraOptions, this.correlationId, this.prompt, this.childRedirectUri, this.childClientId, this.claims, this.forceRefresh, this.applicationName, this.applicationVersion, this.msalVersion, this.sdkType, this.environment, this.multipleCloudsSupported, this.authorizationAgent, this.authenticationScheme, this.powerOptCheckEnabled, this.spanContext, this.preferredBrowser, this.preferredAuthMethod);
        }

        public BrokerRequestBuilder childClientId(String str) {
            this.childClientId = str;
            return this;
        }

        public BrokerRequestBuilder childRedirectUri(String str) {
            this.childRedirectUri = str;
            return this;
        }

        public BrokerRequestBuilder claims(@Nullable String str) {
            this.claims = str;
            return this;
        }

        public BrokerRequestBuilder clientId(@NonNull String str) {
            this.clientId = str;
            return this;
        }

        public BrokerRequestBuilder correlationId(@NonNull String str) {
            this.correlationId = str;
            return this;
        }

        public BrokerRequestBuilder environment(@NonNull String str) {
            this.environment = str;
            return this;
        }

        public BrokerRequestBuilder extraOptions(@Nullable String str) {
            this.extraOptions = str;
            return this;
        }

        public BrokerRequestBuilder extraQueryStringParameter(@Nullable String str) {
            this.extraQueryStringParameter = str;
            return this;
        }

        public BrokerRequestBuilder forceRefresh(@Nullable boolean z) {
            this.forceRefresh = z;
            return this;
        }

        public BrokerRequestBuilder homeAccountId(@Nullable String str) {
            this.homeAccountId = str;
            return this;
        }

        public BrokerRequestBuilder localAccountId(String str) {
            this.localAccountId = str;
            return this;
        }

        public BrokerRequestBuilder msalVersion(@NonNull String str) {
            this.msalVersion = str;
            return this;
        }

        public BrokerRequestBuilder multipleCloudsSupported(@NonNull boolean z) {
            this.multipleCloudsSupported = z;
            return this;
        }

        public BrokerRequestBuilder powerOptCheckEnabled(@Nullable boolean z) {
            this.powerOptCheckEnabled = z;
            return this;
        }

        public BrokerRequestBuilder preferredAuthMethod(@Nullable PreferredAuthMethod preferredAuthMethod) {
            this.preferredAuthMethod = preferredAuthMethod;
            return this;
        }

        public BrokerRequestBuilder preferredBrowser(@Nullable BrowserDescriptor browserDescriptor) {
            this.preferredBrowser = browserDescriptor;
            return this;
        }

        public BrokerRequestBuilder prompt(@Nullable String str) {
            this.prompt = str;
            return this;
        }

        public BrokerRequestBuilder redirect(@NonNull String str) {
            this.redirect = str;
            return this;
        }

        public BrokerRequestBuilder scope(@NonNull String str) {
            this.scope = str;
            return this;
        }

        public BrokerRequestBuilder sdkType(@NonNull SdkType sdkType) {
            this.sdkType = sdkType;
            return this;
        }

        public BrokerRequestBuilder spanContext(@Nullable SerializableSpanContext serializableSpanContext) {
            this.spanContext = serializableSpanContext;
            return this;
        }

        public String toString() {
            return "BrokerRequest.BrokerRequestBuilder(authority=" + this.authority + ", scope=" + this.scope + ", redirect=" + this.redirect + ", clientId=" + this.clientId + ", userName=" + this.userName + ", homeAccountId=" + this.homeAccountId + ", localAccountId=" + this.localAccountId + ", extraQueryStringParameter=" + this.extraQueryStringParameter + ", extraOptions=" + this.extraOptions + ", correlationId=" + this.correlationId + ", prompt=" + this.prompt + ", childRedirectUri=" + this.childRedirectUri + ", childClientId=" + this.childClientId + ", claims=" + this.claims + ", forceRefresh=" + this.forceRefresh + ", applicationName=" + this.applicationName + ", applicationVersion=" + this.applicationVersion + ", msalVersion=" + this.msalVersion + ", sdkType=" + this.sdkType + ", environment=" + this.environment + ", multipleCloudsSupported=" + this.multipleCloudsSupported + ", authorizationAgent=" + this.authorizationAgent + ", authenticationScheme=" + this.authenticationScheme + ", powerOptCheckEnabled=" + this.powerOptCheckEnabled + ", spanContext=" + this.spanContext + ", preferredBrowser=" + this.preferredBrowser + ", preferredAuthMethod=" + this.preferredAuthMethod + ")";
        }

        public BrokerRequestBuilder userName(@Nullable String str) {
            this.userName = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SerializedNames {
        static final String AUTHENTICATION_SCHEME = "authentication_scheme";
        static final String AUTHORITY = "authority";
        static final String AUTHORIZATION_AGENT = "authorization_agent";
        static final String CHILD_CLIENT_ID = "child_client_id";
        static final String CHILD_REDIRECT_URI = "child_redirect_uri";
        static final String CLAIMS = "claims";
        static final String CLIENT_APP_NAME = "client_app_name";
        static final String CLIENT_APP_VERSION = "client_app_version";
        static final String CLIENT_ID = "client_id";
        static final String CLIENT_SDK_TYPE = "client_sdk_type";
        static final String CLIENT_VERSION = "client_version";
        static final String CORRELATION_ID = "correlation_id";
        static final String ENVIRONMENT = "environment";
        static final String EXTRA_OPTIONS = "extra_options";
        static final String EXTRA_QUERY_STRING_PARAMETER = "extra_query_param";
        static final String FORCE_REFRESH = "force_refresh";
        static final String HOME_ACCOUNT_ID = "home_account_id";
        static final String LOCAL_ACCOUNT_ID = "local_account_id";
        static final String MULTIPLE_CLOUDS_SUPPORTED = "multiple_clouds_supported";
        static final String POWER_OPT_CHECK_ENABLED = "power_opt_check_enabled";
        static final String PREFERRED_AUTH_METHOD = "preferred_auth_method";
        static final String PREFERRED_BROWSER = "preferred_browser";
        static final String PROMPT = "prompt";
        static final String REDIRECT = "redirect_uri";
        static final String SCOPE = "scopes";
        static final String SPAN_CONTEXT = "span_context";
        static final String USERNAME = "username";

        private SerializedNames() {
        }
    }

    public BrokerRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable String str6, String str7, @Nullable String str8, @Nullable String str9, @NonNull String str10, @Nullable String str11, String str12, String str13, @Nullable String str14, @Nullable boolean z, @NonNull String str15, @NonNull String str16, @NonNull String str17, @NonNull SdkType sdkType, @NonNull String str18, @NonNull boolean z2, @Nullable String str19, @Nullable AbstractAuthenticationScheme abstractAuthenticationScheme, @Nullable boolean z3, @Nullable SerializableSpanContext serializableSpanContext, @Nullable BrowserDescriptor browserDescriptor, @Nullable PreferredAuthMethod preferredAuthMethod) {
        if (str == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("scope is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("redirect is marked non-null but is null");
        }
        if (str4 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str10 == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (str15 == null) {
            throw new NullPointerException("applicationName is marked non-null but is null");
        }
        if (str16 == null) {
            throw new NullPointerException("applicationVersion is marked non-null but is null");
        }
        if (str17 == null) {
            throw new NullPointerException("msalVersion is marked non-null but is null");
        }
        if (sdkType == null) {
            throw new NullPointerException("sdkType is marked non-null but is null");
        }
        if (str18 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        this.mAuthority = str;
        this.mScope = str2;
        this.mRedirect = str3;
        this.mClientId = str4;
        this.mUserName = str5;
        this.mHomeAccountId = str6;
        this.mLocalAccountId = str7;
        this.mExtraQueryStringParameter = str8;
        this.mExtraOptions = str9;
        this.mCorrelationId = str10;
        this.mPrompt = str11;
        this.mChildRedirectUri = str12;
        this.mChildClientId = str13;
        this.mClaims = str14;
        this.mForceRefresh = z;
        this.mApplicationName = str15;
        this.mApplicationVersion = str16;
        this.mMsalVersion = str17;
        this.mSdkType = sdkType;
        this.mEnvironment = str18;
        this.mMultipleCloudsSupported = z2;
        this.mAuthorizationAgent = str19;
        this.mAuthenticationScheme = abstractAuthenticationScheme;
        this.mPowerOptCheckEnabled = z3;
        this.mSpanContext = serializableSpanContext;
        this.mPreferredBrowser = browserDescriptor;
        this.mPreferredAuthMethod = preferredAuthMethod;
    }

    public static BrokerRequestBuilder builder() {
        return new BrokerRequestBuilder();
    }

    @NonNull
    public String getApplicationName() {
        return this.mApplicationName;
    }

    @NonNull
    public String getApplicationVersion() {
        return this.mApplicationVersion;
    }

    @Nullable
    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    @NonNull
    public String getAuthority() {
        return this.mAuthority;
    }

    @Nullable
    public String getAuthorizationAgent() {
        return this.mAuthorizationAgent;
    }

    public String getChildClientId() {
        return this.mChildClientId;
    }

    public String getChildRedirectUri() {
        return this.mChildRedirectUri;
    }

    @Nullable
    public String getClaims() {
        return this.mClaims;
    }

    @NonNull
    public String getClientId() {
        return this.mClientId;
    }

    @NonNull
    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    @NonNull
    public String getEnvironment() {
        return this.mEnvironment;
    }

    @Nullable
    public String getExtraOptions() {
        return this.mExtraOptions;
    }

    @Nullable
    public String getExtraQueryStringParameter() {
        return this.mExtraQueryStringParameter;
    }

    @Nullable
    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    @NonNull
    public String getMsalVersion() {
        return this.mMsalVersion;
    }

    @Nullable
    public PreferredAuthMethod getPreferredAuthMethod() {
        return this.mPreferredAuthMethod;
    }

    @Nullable
    public BrowserDescriptor getPreferredBrowser() {
        return this.mPreferredBrowser;
    }

    @Nullable
    public String getPrompt() {
        return this.mPrompt;
    }

    @NonNull
    public String getRedirect() {
        return this.mRedirect;
    }

    @NonNull
    public String getScope() {
        return this.mScope;
    }

    @NonNull
    public SdkType getSdkType() {
        return this.mSdkType;
    }

    @Nullable
    public SerializableSpanContext getSpanContext() {
        return this.mSpanContext;
    }

    @Nullable
    public String getUserName() {
        return this.mUserName;
    }

    @Nullable
    public boolean isForceRefresh() {
        return this.mForceRefresh;
    }

    @NonNull
    public boolean isMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }

    @Nullable
    public boolean isPowerOptCheckEnabled() {
        return this.mPowerOptCheckEnabled;
    }
}
