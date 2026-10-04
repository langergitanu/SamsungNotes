package com.samsung.android.sdk.scs.p142ai.visual;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class VisualAppInfo {
    public static final String ACCOUNT_TYPE_B2B = "B2B";
    public static final String ACCOUNT_TYPE_B2C = "B2C";
    private static final String TAG = "VisualAppInfo";
    private final String accessToken;
    private final String accountType;
    private final String apiKey;
    private final String appId;
    private final String packageName;
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
        private String appId = "";
        private String packageName = "";
        private String accessToken = "";
        private String userId = "";
        private String serverUrl = "";
        private String accountType = "B2C";

        public VisualAppInfo build() {
            return new VisualAppInfo(this, 0);
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
            this.appId = str;
            return this;
        }

        public Builder setPackageName(String str) {
            this.packageName = str;
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

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    public /* synthetic */ VisualAppInfo(Builder builder, int i) {
        this(builder);
    }

    public static void appInfoToBundle(Bundle bundle, VisualAppInfo visualAppInfo) {
        bundle.putString("api-key", visualAppInfo.getApiKey());
        bundle.putString("package-signing-key", visualAppInfo.getSigningKey());
        bundle.putString("ssp-app-id", visualAppInfo.getAppId());
        if (Build.VERSION.SDK_INT < 35) {
            bundle.putString("package-name", visualAppInfo.getPackageName());
        }
        bundle.putString("ssp-access-token", visualAppInfo.getAccessToken());
        bundle.putString("ssp-user-id", visualAppInfo.getUserId());
        bundle.putString("ssp-server-url", visualAppInfo.getServerUrl());
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

    public String getPackageName() {
        return this.packageName;
    }

    public String getServerUrl() {
        if ("B2B".equals(this.accountType)) {
            Log.i(TAG, "B2B account is set");
            return "";
        }
        Log.i(TAG, "B2B account is not set");
        return this.serverUrl;
    }

    public String getSigningKey() {
        return this.signingKey;
    }

    public String getUserId() {
        return this.userId;
    }

    private VisualAppInfo(Builder builder) {
        this.apiKey = builder.apiKey;
        this.serverUrl = builder.serverUrl;
        this.appId = builder.appId;
        this.packageName = builder.packageName;
        this.signingKey = builder.signingKey;
        this.accessToken = builder.accessToken;
        this.userId = builder.userId;
        this.accountType = builder.accountType;
    }
}
