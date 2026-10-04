package com.microsoft.identity.client.configuration;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LoggerConfiguration {

    @SerializedName(SerializedNames.LOG_LEVEL)
    private Logger.LogLevel mLogLevel;

    @SerializedName(SerializedNames.LOGCAT_ENABLED)
    private boolean mLogcatEnabled;

    @SerializedName("pii_enabled")
    private boolean mPiiEnabled;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SerializedNames {
        public static final String LOGCAT_ENABLED = "logcat_enabled";
        public static final String LOG_LEVEL = "log_level";
        public static final String PII_ENABLED = "pii_enabled";
    }

    public Logger.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public boolean isLogcatEnabled() {
        return this.mLogcatEnabled;
    }

    public boolean isPiiEnabled() {
        return this.mPiiEnabled;
    }
}
