package com.samsung.android.sdk.mobileservice;

import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
final class VersionExchangeInfo {
    private static final String AGENT_STATUS = "agent_status";
    static final int AGENT_STATUS_AGENT_NOT_AVAILABLE = 4;
    static final int AGENT_STATUS_AGENT_UPDATE_NEEDED = 3;
    static final int AGENT_STATUS_MAX = 4;
    static final int AGENT_STATUS_OK = 0;
    static final int AGENT_STATUS_PARTIAL_OK = 1;
    static final int AGENT_STATUS_SDK_UPDATE_NEEDED = 2;
    static final int AGENT_STATUS_UNDEFINED = 99;
    private static final String API_VERSION = "api_version";
    private static final String APP_ID = "app_id";
    static final int DEFAULT_VERSION = 0;
    private static final String FORCE_UPDATE_ACTIVITY_INFO = "force_update_activity_info";
    private static final String LATEST_VERSION_IN_MARKET = "lastest_version_in_market";
    private static final String SA_AGENT_STATUS = "sa_agent_status";
    private static final String SA_AGENT_VERSION = "sa_agent_version";
    private static final String SA_LATEST_VERSION_IN_MARKET_SA = "sa_lastest_version_in_market";
    private static final String SDK_VERSION = "sdk_version";
    private static final String SEMS_VERSION = "sems_version";
    private static final String SERVICE_STATUS = "service_status";
    static final int SERVICE_STATUS_BLOCKED_BY_POLICY = 4;
    static final int SERVICE_STATUS_FORCE_UPDATE_REQUIRED = 2;
    static final int SERVICE_STATUS_MAX = 4;
    static final int SERVICE_STATUS_NOT_SUPPORTED = 1;
    static final int SERVICE_STATUS_NOT_SUPPORT_SDK_VERSION = 3;
    static final int SERVICE_STATUS_OK = 0;
    static final int SERVICE_STATUS_UNDEFINED = 99;
    private static final String SERVICE_VERSION = "service_version";
    private long mAgentLastestVersionInGalaxyApps;
    private long mSaAgentLastestVersionInGalaxyApps;
    private HashMap<String, Integer> mServiceVersion = new HashMap<>();
    private HashMap<String, Integer> mApiVersion = new HashMap<>();
    private HashMap<String, Integer> mServiceStatus = new HashMap<>();
    private int mSdkVersion = 0;
    private int mAgentVersion = 0;
    private int mSaAgentVersion = 0;
    private int mAgentStatus = 4;
    private int mSaAgentStatus = 4;
    private String mForceUpdateActivityInfo = null;
    private String mAppId = null;

    public void addService(String... strArr) {
        for (String str : strArr) {
            this.mServiceVersion.put(str, 0);
        }
    }

    public void addSupportedApiVersion(String str, int i) {
        this.mApiVersion.put(str, Integer.valueOf(i));
    }

    public synchronized void clear() {
        this.mServiceVersion.clear();
        this.mApiVersion.clear();
        this.mSdkVersion = 0;
        this.mAgentVersion = 0;
        this.mSaAgentVersion = 0;
        this.mAgentStatus = 4;
        this.mSaAgentStatus = 4;
        this.mServiceStatus.clear();
    }

    public long getAgentLastestVersionInGalaxyApps() {
        return this.mAgentLastestVersionInGalaxyApps;
    }

    public int getAgentStatus() {
        return this.mAgentStatus;
    }

    public HashMap<String, Integer> getAllServiceStatus() {
        return this.mServiceStatus;
    }

    public int getApiVersion(String str) {
        if (this.mApiVersion.containsKey(str)) {
            return this.mApiVersion.get(str).intValue();
        }
        return 0;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getForceUpdateActivityInfo() {
        return this.mForceUpdateActivityInfo;
    }

    public String[] getRequestedServices() {
        return (String[]) this.mServiceVersion.keySet().toArray(new String[0]);
    }

    public long getSaAgentLastestVersionInGalaxyApps() {
        return this.mSaAgentLastestVersionInGalaxyApps;
    }

    public int getSaAgentStatus() {
        return this.mSaAgentStatus;
    }

    public int getSaAgentVersion() {
        return this.mSaAgentVersion;
    }

    public int getSdkVersion() {
        return this.mSdkVersion;
    }

    public int getServiceStatus(String str) {
        if (this.mServiceStatus.containsKey(str)) {
            return this.mServiceStatus.get(str).intValue();
        }
        return 1;
    }

    public int getServiceVersion(String str) {
        if (this.mServiceVersion.containsKey(str)) {
            return this.mServiceVersion.get(str).intValue();
        }
        return 0;
    }

    public int getSesVersion() {
        return this.mAgentVersion;
    }

    public synchronized void put(Bundle bundle, boolean z, String... strArr) {
        HashMap map;
        HashMap map2;
        if (bundle == null) {
            return;
        }
        try {
            if (bundle.containsKey("sdk_version")) {
                this.mSdkVersion = bundle.getInt("sdk_version");
            }
            if (bundle.containsKey(SEMS_VERSION)) {
                this.mAgentVersion = bundle.getInt(SEMS_VERSION);
            }
            if (bundle.containsKey(SA_AGENT_VERSION)) {
                this.mSaAgentVersion = bundle.getInt(SA_AGENT_VERSION);
            } else if (!z) {
                this.mSaAgentVersion = this.mAgentVersion;
            }
            if (bundle.containsKey(SERVICE_VERSION) && (map2 = (HashMap) bundle.getSerializable(SERVICE_VERSION)) != null) {
                for (String str : strArr) {
                    map2.remove(str);
                }
                this.mServiceVersion.putAll(map2);
            }
            if (bundle.containsKey("api_version")) {
                this.mApiVersion.putAll((HashMap) bundle.getSerializable("api_version"));
            }
            if (bundle.containsKey(AGENT_STATUS)) {
                this.mAgentStatus = bundle.getInt(AGENT_STATUS);
            }
            if (bundle.containsKey(SA_AGENT_STATUS)) {
                this.mSaAgentStatus = bundle.getInt(SA_AGENT_STATUS);
            } else if (!z) {
                this.mSaAgentStatus = this.mAgentStatus;
            }
            if (bundle.containsKey(SERVICE_STATUS) && (map = (HashMap) bundle.getSerializable(SERVICE_STATUS)) != null) {
                for (String str2 : strArr) {
                    map.remove(str2);
                }
                this.mServiceStatus.putAll(map);
            }
            if (bundle.containsKey(FORCE_UPDATE_ACTIVITY_INFO)) {
                this.mForceUpdateActivityInfo = bundle.getString(FORCE_UPDATE_ACTIVITY_INFO);
            }
            if (bundle.containsKey(LATEST_VERSION_IN_MARKET)) {
                this.mAgentLastestVersionInGalaxyApps = bundle.getLong(LATEST_VERSION_IN_MARKET, 0L);
            }
            if (bundle.containsKey(SA_LATEST_VERSION_IN_MARKET_SA)) {
                this.mSaAgentLastestVersionInGalaxyApps = bundle.getLong(SA_LATEST_VERSION_IN_MARKET_SA, 0L);
            } else if (z) {
                this.mSaAgentLastestVersionInGalaxyApps = this.mAgentLastestVersionInGalaxyApps;
            }
            if (bundle.containsKey("app_id")) {
                this.mAppId = bundle.getString("app_id", "");
            }
            if (this.mAgentStatus > 4) {
                this.mAgentStatus = 99;
            }
            if (this.mSaAgentStatus > 4) {
                this.mSaAgentStatus = 99;
            }
            for (String str3 : this.mServiceStatus.keySet()) {
                if (this.mServiceStatus.get(str3).intValue() > 4) {
                    this.mServiceStatus.put(str3, 99);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setAgentLastestVersionInGalaxyApps(long j) {
        this.mAgentLastestVersionInGalaxyApps = j;
    }

    public void setAgentStatus(int i) {
        this.mAgentStatus = i;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setForceUpdateActivityInfo(String str) {
        this.mForceUpdateActivityInfo = str;
    }

    public void setSaAgentLastestVersionInGalaxyApps(long j) {
        this.mSaAgentLastestVersionInGalaxyApps = j;
    }

    public void setSaAgentStatus(int i) {
        this.mSaAgentStatus = i;
    }

    public void setSaAgentVersion(int i) {
        this.mSaAgentVersion = i;
    }

    public void setSdkVersion(int i) {
        this.mSdkVersion = i;
    }

    public void setSemsVersion(int i) {
        this.mAgentVersion = i;
    }

    public void setServiceStatus(String str, int i) {
        this.mServiceStatus.put(str, Integer.valueOf(i));
    }

    public void setServiceVersion(String str, int i) {
        if (this.mServiceVersion.containsKey(str)) {
            this.mServiceVersion.put(str, Integer.valueOf(i));
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("sdk_version", this.mSdkVersion);
        bundle.putInt(SEMS_VERSION, this.mAgentVersion);
        bundle.putInt(SA_AGENT_VERSION, this.mSaAgentVersion);
        bundle.putSerializable(SERVICE_VERSION, this.mServiceVersion);
        bundle.putSerializable("api_version", this.mApiVersion);
        bundle.putInt(AGENT_STATUS, this.mAgentStatus);
        bundle.putInt(SA_AGENT_STATUS, this.mSaAgentStatus);
        bundle.putString("app_id", this.mAppId);
        bundle.putSerializable(SERVICE_STATUS, this.mServiceStatus);
        String str = this.mForceUpdateActivityInfo;
        if (str != null) {
            bundle.putString(FORCE_UPDATE_ACTIVITY_INFO, str);
        }
        bundle.putLong(LATEST_VERSION_IN_MARKET, this.mAgentLastestVersionInGalaxyApps);
        bundle.putLong(SA_LATEST_VERSION_IN_MARKET_SA, this.mSaAgentLastestVersionInGalaxyApps);
        return bundle;
    }
}
