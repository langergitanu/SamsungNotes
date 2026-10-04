package com.microsoft.identity.common.internal.broker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerResult {
    private static final long serialVersionUID = 8606631820514878489L;

    @Nullable
    @SerializedName("access_token")
    private String mAccessToken;

    @Nullable
    @SerializedName("authority")
    private String mAuthority;

    @Nullable
    @SerializedName(Credential.SerializedNames.CACHED_AT)
    private long mCachedAt;

    @Nullable
    @SerializedName("cli_telem_error_code")
    private String mCliTelemErrorCode;

    @Nullable
    @SerializedName("cli_telem_suberror_code")
    private String mCliTelemSubErrorCode;

    @Nullable
    @SerializedName("client_id")
    private String mClientId;

    @Nullable
    @SerializedName("client_info")
    private String mClientInfo;

    @Nullable
    @SerializedName("correlation_id")
    private String mCorrelationId;

    @Nullable
    @SerializedName("environment")
    private String mEnvironment;

    @Nullable
    @SerializedName("broker_error_code")
    private String mErrorCode;

    @Nullable
    @SerializedName("broker_error_message")
    private String mErrorMessage;

    @Nullable
    @SerializedName("broker_exception_type")
    private final String mExceptionType;

    @Nullable
    @SerializedName(Credential.SerializedNames.EXPIRES_ON)
    private long mExpiresOn;

    @Nullable
    @SerializedName("ext_expires_on")
    private long mExtendedExpiresOn;

    @Nullable
    @SerializedName("family_id")
    private String mFamilyId;

    @Nullable
    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @Nullable
    @SerializedName("http_response_body")
    private String mHttpResponseBody;

    @Nullable
    @SerializedName("http_response_headers")
    private String mHttpResponseHeaders;

    @Nullable
    @SerializedName("http_response_code")
    private int mHttpStatusCode;

    @Nullable
    @SerializedName("id_token")
    private String mIdToken;

    @Nullable
    @SerializedName(AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID)
    private String mLocalAccountId;

    @Nullable
    @SerializedName("refresh_token")
    private String mRefreshToken;

    @Nullable
    @SerializedName("refresh_token_age")
    private String mRefreshTokenAge;

    @Nullable
    @SerializedName("scopes")
    private String mScope;

    @SerializedName("serviced_from_cache")
    private boolean mServicedFromCache;

    @Nullable
    @SerializedName("spe_ring")
    private String mSpeRing;

    @Nullable
    @SerializedName("oauth_sub_error")
    private String mSubErrorCode;

    @NonNull
    @SerializedName("success")
    private boolean mSuccess;

    @Nullable
    @SerializedName("tenant_id")
    private String mTenantId;

    @Nullable
    @SerializedName("tenant_profile_cache_records")
    private final List<ICacheRecord> mTenantProfileData;

    @Nullable
    @SerializedName("token_type")
    private String mTokenType;

    @Nullable
    @SerializedName("username")
    private String mUserName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private String mAccessToken;
        private String mAuthority;
        private long mCachedAt;
        private String mCliTelemErrorCode;
        private String mCliTelemSubErrorCode;
        private String mClientId;
        private String mClientInfo;
        private String mCorrelationId;
        private String mEnvironment;
        private String mErrorCode;
        private String mErrorMessage;
        private String mExceptionType;
        private long mExpiresOn;
        private long mExtendedExpiresOn;
        private String mFamilyId;
        private String mHomeAccountId;
        private String mHttpResponseBody;
        private String mHttpResponseHeaders;
        private int mHttpStatusCode;
        private String mIdToken;
        private String mLocalAccountId;
        private String mNegotiatedBrokerProtocolVersion;
        private String mRefreshToken;
        private String mRefreshTokenAge;
        private String mScope;
        private boolean mServicedFromCache;
        private String mSpeRing;
        private String mSubErrorCode;
        private boolean mSuccess;
        private String mTenantId;
        private List<ICacheRecord> mTenantProfileData;
        private String mTokenType;
        private String mUserName;

        public Builder accessToken(@Nullable String str) {
            this.mAccessToken = str;
            return this;
        }

        public Builder authority(@Nullable String str) {
            this.mAuthority = str;
            return this;
        }

        public BrokerResult build() {
            return new BrokerResult(this);
        }

        public Builder cachedAt(long j) {
            this.mCachedAt = j;
            return this;
        }

        public Builder cliTelemErrorCode(String str) {
            this.mCliTelemErrorCode = str;
            return this;
        }

        public Builder cliTelemSubErrorCode(String str) {
            this.mCliTelemSubErrorCode = str;
            return this;
        }

        public Builder clientId(@Nullable String str) {
            this.mClientId = str;
            return this;
        }

        public Builder clientInfo(@Nullable String str) {
            this.mClientInfo = str;
            return this;
        }

        public Builder correlationId(String str) {
            this.mCorrelationId = str;
            return this;
        }

        public Builder environment(@Nullable String str) {
            this.mEnvironment = str;
            return this;
        }

        public Builder errorCode(String str) {
            this.mErrorCode = str;
            return this;
        }

        public Builder errorMessage(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public Builder exceptionType(String str) {
            this.mExceptionType = str;
            return this;
        }

        public Builder expiresOn(long j) {
            this.mExpiresOn = j;
            return this;
        }

        public Builder extendedExpiresOn(long j) {
            this.mExtendedExpiresOn = j;
            return this;
        }

        public Builder familyId(@Nullable String str) {
            this.mFamilyId = str;
            return this;
        }

        public Builder homeAccountId(@Nullable String str) {
            this.mHomeAccountId = str;
            return this;
        }

        public Builder httpResponseBody(String str) {
            this.mHttpResponseBody = str;
            return this;
        }

        public Builder httpResponseHeaders(String str) {
            this.mHttpResponseHeaders = str;
            return this;
        }

        public Builder httpStatusCode(int i) {
            this.mHttpStatusCode = i;
            return this;
        }

        public Builder idToken(@Nullable String str) {
            this.mIdToken = str;
            return this;
        }

        public Builder localAccountId(@Nullable String str) {
            this.mLocalAccountId = str;
            return this;
        }

        @SuppressFBWarnings({"URF_UNREAD_FIELD"})
        public Builder negotiatedBrokerProtocolVersion(String str) {
            this.mNegotiatedBrokerProtocolVersion = str;
            return this;
        }

        public Builder oauthSubErrorCode(String str) {
            this.mSubErrorCode = str;
            return this;
        }

        public Builder refreshToken(@Nullable String str) {
            this.mRefreshToken = str;
            return this;
        }

        public Builder refreshTokenAge(String str) {
            this.mRefreshTokenAge = str;
            return this;
        }

        public Builder scope(@Nullable String str) {
            this.mScope = str;
            return this;
        }

        public Builder servicedFromCache(boolean z) {
            this.mServicedFromCache = z;
            return this;
        }

        public Builder speRing(String str) {
            this.mSpeRing = str;
            return this;
        }

        public Builder success(boolean z) {
            this.mSuccess = z;
            return this;
        }

        public Builder tenantId(@Nullable String str) {
            this.mTenantId = str;
            return this;
        }

        public Builder tenantProfileRecords(List<ICacheRecord> list) {
            if (list != null) {
                this.mTenantProfileData = new ArrayList(list);
            }
            return this;
        }

        public Builder tokenType(@Nullable String str) {
            this.mTokenType = str;
            return this;
        }

        public Builder userName(@Nullable String str) {
            this.mUserName = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames {
        static final String ACCESS_TOKEN = "access_token";
        static final String AUTHORITY = "authority";
        static final String BROKER_ERROR_CODE = "broker_error_code";
        static final String BROKER_ERROR_MESSAGE = "broker_error_message";
        static final String BROKER_EXCEPTION_TYPE = "broker_exception_type";
        static final String CACHED_AT = "cached_at";
        static final String CLIENT_ID = "client_id";
        static final String CLIENT_INFO = "client_info";
        static final String CLI_TELEM_ERRORCODE = "cli_telem_error_code";
        static final String CLI_TELEM_SUB_ERROR_CODE = "cli_telem_suberror_code";
        static final String CORRELATION_ID = "correlation_id";
        static final String ENVIRONMENT = "environment";
        static final String EXPIRES_ON = "expires_on";
        static final String EXTENDED_EXPIRES_ON = "ext_expires_on";
        static final String FAMILY_ID = "family_id";
        static final String HOME_ACCOUNT_ID = "home_account_id";
        static final String HTTP_HEADERS = "http_response_headers";
        static final String HTTP_RESPONSE_BODY = "http_response_body";
        static final String HTTP_RESPONSE_CODE = "http_response_code";
        static final String ID_TOKEN = "id_token";
        static final String LOCAL_ACCOUNT_ID = "local_account_id";
        static final String OAUTH_SUB_ERROR = "oauth_sub_error";
        static final String REFRESH_TOKEN = "refresh_token";
        static final String REFRESH_TOKEN_AGE = "refresh_token_age";
        static final String SCOPES = "scopes";
        static final String SERVICED_FROM_CACHE = "serviced_from_cache";
        static final String SPE_RING = "spe_ring";
        static final String SUCCESS = "success";
        static final String TENANT_ID = "tenant_id";
        static final String TENANT_PROFILE_CACHE_RECORDS = "tenant_profile_cache_records";
        static final String TOKEN_TYPE = "token_type";
        static final String USERNAME = "username";

        private SerializedNames() {
        }
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public long getCachedAt() {
        return this.mCachedAt;
    }

    public String getCliTelemErrorCode() {
        return this.mCliTelemErrorCode;
    }

    public String getCliTelemSubErrorCode() {
        return this.mCliTelemSubErrorCode;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getClientInfo() {
        return this.mClientInfo;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getExceptionType() {
        return this.mExceptionType;
    }

    public long getExpiresOn() {
        return this.mExpiresOn;
    }

    public long getExtendedExpiresOn() {
        return this.mExtendedExpiresOn;
    }

    public String getFamilyId() {
        return this.mFamilyId;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getHttpResponseBody() {
        return this.mHttpResponseBody;
    }

    public String getHttpResponseHeaders() {
        return this.mHttpResponseHeaders;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String getIdToken() {
        return this.mIdToken;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public String getSubErrorCode() {
        return this.mSubErrorCode;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public List<ICacheRecord> getTenantProfileData() {
        if (this.mTenantProfileData == null) {
            return null;
        }
        return new ArrayList(this.mTenantProfileData);
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public boolean isServicedFromCache() {
        return this.mServicedFromCache;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    private BrokerResult(@NonNull Builder builder) {
        this.mAccessToken = builder.mAccessToken;
        this.mIdToken = builder.mIdToken;
        this.mRefreshToken = builder.mRefreshToken;
        this.mHomeAccountId = builder.mHomeAccountId;
        this.mLocalAccountId = builder.mLocalAccountId;
        this.mUserName = builder.mUserName;
        this.mTokenType = builder.mTokenType;
        this.mClientId = builder.mClientId;
        this.mFamilyId = builder.mFamilyId;
        this.mScope = builder.mScope;
        this.mClientInfo = builder.mClientInfo;
        this.mAuthority = builder.mAuthority;
        this.mEnvironment = builder.mEnvironment;
        this.mTenantId = builder.mTenantId;
        this.mExpiresOn = builder.mExpiresOn;
        this.mExtendedExpiresOn = builder.mExtendedExpiresOn;
        this.mCachedAt = builder.mCachedAt;
        this.mSpeRing = builder.mSpeRing;
        this.mRefreshTokenAge = builder.mRefreshTokenAge;
        this.mSuccess = builder.mSuccess;
        this.mTenantProfileData = builder.mTenantProfileData;
        this.mServicedFromCache = builder.mServicedFromCache;
        this.mErrorCode = builder.mErrorCode;
        this.mErrorMessage = builder.mErrorMessage;
        this.mCorrelationId = builder.mCorrelationId;
        this.mSubErrorCode = builder.mSubErrorCode;
        this.mHttpStatusCode = builder.mHttpStatusCode;
        this.mHttpResponseBody = builder.mHttpResponseBody;
        this.mHttpResponseHeaders = builder.mHttpResponseHeaders;
        this.mCliTelemErrorCode = builder.mCliTelemErrorCode;
        this.mCliTelemSubErrorCode = builder.mCliTelemSubErrorCode;
        this.mExceptionType = builder.mExceptionType;
    }
}
