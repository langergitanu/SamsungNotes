package com.microsoft.identity.common.java.commands;

import com.google.gson.annotations.SerializedName;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AcquirePrtSsoTokenResult {

    @SerializedName("accountAuthority")
    @Nullable
    private final String mAccountAuthority;

    @SerializedName("accountName")
    private final String mAccountName;

    @SerializedName("ssoToken")
    @Nullable
    private final String mCookieContent;

    @SerializedName("cookieName")
    @Nullable
    private final String mCookieName;

    @SerializedName("error")
    @Nullable
    private final String mError;

    @SerializedName("homeAccountId")
    private final String mHomeAccountId;

    @SerializedName("localAccountId")
    private final String mLocalAccountId;

    @SerializedName("telemetry")
    @NonNull
    private final Map<String, Object> mTelemetry;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AcquirePrtSsoTokenResultBuilder {
        private String accountAuthority;
        private String accountName;
        private String cookieContent;
        private String cookieName;
        private String error;
        private String homeAccountId;
        private String localAccountId;
        private Map<String, Object> telemetry;

        public AcquirePrtSsoTokenResultBuilder accountAuthority(@Nullable String str) {
            this.accountAuthority = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder accountName(String str) {
            this.accountName = str;
            return this;
        }

        public AcquirePrtSsoTokenResult build() {
            return new AcquirePrtSsoTokenResult(this.homeAccountId, this.localAccountId, this.accountName, this.error, this.accountAuthority, this.cookieName, this.cookieContent, this.telemetry);
        }

        public AcquirePrtSsoTokenResultBuilder cookieContent(@Nullable String str) {
            this.cookieContent = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder cookieName(@Nullable String str) {
            this.cookieName = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder error(@Nullable String str) {
            this.error = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder homeAccountId(String str) {
            this.homeAccountId = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder localAccountId(String str) {
            this.localAccountId = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder telemetry(@NonNull Map<String, Object> map) {
            if (map == null) {
                throw new NullPointerException("telemetry is marked non-null but is null");
            }
            this.telemetry = map;
            return this;
        }

        public String toString() {
            return "AcquirePrtSsoTokenResult.AcquirePrtSsoTokenResultBuilder(homeAccountId=" + this.homeAccountId + ", localAccountId=" + this.localAccountId + ", accountName=" + this.accountName + ", error=" + this.error + ", accountAuthority=" + this.accountAuthority + ", cookieName=" + this.cookieName + ", cookieContent=" + this.cookieContent + ", telemetry=" + this.telemetry + ")";
        }
    }

    public AcquirePrtSsoTokenResult(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NonNull Map<String, Object> map) {
        if (map == null) {
            throw new NullPointerException("telemetry is marked non-null but is null");
        }
        this.mHomeAccountId = str;
        this.mLocalAccountId = str2;
        this.mAccountName = str3;
        this.mError = str4;
        this.mAccountAuthority = str5;
        this.mCookieName = str6;
        this.mCookieContent = str7;
        this.mTelemetry = map;
    }

    public static AcquirePrtSsoTokenResultBuilder builder() {
        return new AcquirePrtSsoTokenResultBuilder();
    }

    @Nullable
    public String getAccountAuthority() {
        return this.mAccountAuthority;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    @Nullable
    public String getCookieContent() {
        return this.mCookieContent;
    }

    @Nullable
    public String getCookieName() {
        return this.mCookieName;
    }

    @Nullable
    public String getError() {
        return this.mError;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    @NonNull
    public Map<String, Object> getTelemetry() {
        return this.mTelemetry;
    }
}
