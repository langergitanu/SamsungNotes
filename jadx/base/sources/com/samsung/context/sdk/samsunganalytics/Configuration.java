package com.samsung.context.sdk.samsunganalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Configuration {
    private DBOpenHelper dbOpenHelper;
    private String deviceId;
    private String trackingId;
    private UserAgreement userAgreement;
    private String version;
    private boolean enableAutoDeviceId = false;
    private boolean enableUseInAppLogging = false;
    private int networkType = -1;
    private boolean isAlwaysRunningApp = false;
    private boolean enableFastReady = false;
    private int auidType = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NetworkType {
        public static final int ANY = 0;
        public static final int NOT_SET = -1;
        public static final int WIFI = 1;
    }

    public Configuration enableAutoDeviceId() {
        this.enableAutoDeviceId = true;
        return this;
    }

    @Deprecated
    public Configuration enableFastReady(boolean z) {
        this.enableFastReady = z;
        return this;
    }

    public Configuration enableUseInAppLogging(UserAgreement userAgreement) {
        enableUseInAppLogging(userAgreement, 0);
        return this;
    }

    public int getAuidType() {
        return this.auidType;
    }

    public DBOpenHelper getDbOpenHelper() {
        return this.dbOpenHelper;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public String getTrackingId() {
        return this.trackingId;
    }

    public UserAgreement getUserAgreement() {
        return this.userAgreement;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isAlwaysRunningApp() {
        return this.isAlwaysRunningApp;
    }

    public boolean isEnableAutoDeviceId() {
        return this.enableAutoDeviceId;
    }

    @Deprecated
    public boolean isEnableFastReady() {
        return this.enableFastReady;
    }

    public boolean isEnableUseInAppLogging() {
        return this.enableUseInAppLogging;
    }

    public Configuration setAlwaysRunningApp(boolean z) {
        this.isAlwaysRunningApp = z;
        return this;
    }

    public void setAuidType(int i) {
        this.auidType = i;
    }

    public Configuration setDbOpenHelper(DBOpenHelper dBOpenHelper) {
        this.dbOpenHelper = dBOpenHelper;
        return this;
    }

    public Configuration setDeviceId(String str) {
        this.deviceId = str;
        return this;
    }

    public Configuration setTrackingId(String str) {
        this.trackingId = str;
        return this;
    }

    public Configuration setUserAgreement(UserAgreement userAgreement) {
        this.userAgreement = userAgreement;
        return this;
    }

    public Configuration setVersion(String str) {
        this.version = str;
        return this;
    }

    public Configuration enableUseInAppLogging(UserAgreement userAgreement, int i) {
        setUserAgreement(userAgreement);
        this.enableUseInAppLogging = true;
        this.networkType = i;
        return this;
    }
}
