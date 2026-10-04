package com.samsung.android.sdk.scs.p142ai.language;

import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AppInfo {
    public static final String ACCOUNT_TYPE_B2B = "B2B";
    public static final String ACCOUNT_TYPE_B2C = "B2C";
    private static final String TAG = "AppInfo";
    private final String accessToken;
    private final String accountType;
    private final String apiKey;
    private final String appId;
    private final boolean enableStreaming;
    private final RequestType requestType;
    private final String serverUrl;
    private final String signingKey;
    private final String userId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AccountType {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private String apiKey = "";
        private String signingKey = "";
        private String AppId = "";
        private String accessToken = "";
        private String userId = "";
        private String serverUrl = "";
        private String accountType = "B2C";
        private RequestType requestType = RequestType.CLOUD;
        private boolean enableStreaming = false;

        public AppInfo build() {
            return new AppInfo(this, 0);
        }

        public Builder setAccessToken(String str) {
            this.accessToken = str;
            return this;
        }

        public Builder setAccountType(String str) {
            this.accountType = str;
            return this;
        }

        public Builder setApiKey(String str) {
            this.apiKey = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.AppId = str;
            return this;
        }

        public Builder setRequestType(RequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder setServerUrl(String str) {
            this.serverUrl = str;
            return this;
        }

        public Builder setSigningKey(String str) {
            this.signingKey = str;
            return this;
        }

        public Builder setStreamingMode(boolean z) {
            this.enableStreaming = z;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestType {
        CLOUD,
        ONDEVICE,
        ONDEVICE_EXTERNAL
    }

    public /* synthetic */ AppInfo(Builder builder, int i) {
        this(builder);
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getAppId() {
        return this.appId;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public String getServerUrl() {
        if ("B2B".equals(this.accountType)) {
            Log.m6489i(TAG, "B2B account is set");
            return "";
        }
        Log.m6489i(TAG, "B2B account is not set");
        return this.serverUrl;
    }

    public String getSigningKey() {
        return this.signingKey;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isStreamingMode() {
        return this.enableStreaming;
    }

    private AppInfo(Builder builder) {
        this.apiKey = builder.apiKey;
        this.serverUrl = builder.serverUrl;
        this.appId = builder.AppId;
        this.signingKey = builder.signingKey;
        this.accessToken = builder.accessToken;
        this.userId = builder.userId;
        this.accountType = builder.accountType;
        this.requestType = builder.requestType;
        this.enableStreaming = builder.enableStreaming;
    }
}
