package com.samsung.scsp.framework.core.identity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class IdentityApiContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Header {
        public static final String USER_AGENT = "User-Agent";
        public static final String X_SC_ACCESS_TOKEN = "x-sc-access-token";
        public static final String X_SC_APP_ID = "x-sc-app-id";
        public static final String X_SC_APP_VERSION = "x-sc-app-version";
        public static final String X_SC_CDID = "x-sc-cdid";
        public static final String X_SC_DVC_ID = "x-sc-dvc-id";
        public static final String X_SC_PDID = "x-sc-pdid";
        public static final String X_SC_SDID = "x-sc-sdid";
        public static final String X_SC_SSDID = "x-sc-ssdid";
        public static final String X_SC_UID = "x-sc-uid";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameter {
        public static final String ALIAS = "alias";
        public static final String APP = "app";
        public static final String COUNTRY_CODE = "countryCode";
        public static final String CSC = "csc";
        public static final String DEVICE = "device";
        public static final String E2EE_TYPE = "e2eeType";
        public static final String MODEL_CODE = "modelCode";
        public static final String MODEL_NAME = "modelName";
        public static final String OS_TYPE = "osType";
        public static final String OS_USER_ID = "osUserId";
        public static final String OS_USER_INFO_FLAG = "osUserInfoFlag";
        public static final String OS_VERSION = "osVersion";
        public static final String PLATFORM_VERSION = "platformVersion";
        public static final String PREVIOUS_TOKEN = "previousToken";
        public static final String PUSHES = "pushes";
        public static final String SDK_VERSION = "sdkVersion";
        public static final String SIM_MCC = "simMcc";
        public static final String SIM_MNC = "simMnc";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Query {
        public static final String DEVICE_CURRENT_TIME = "deviceCurrentTime";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Token {
        public static final String ACCESS_TOKEN = "accessToken";
        public static final String BEARER_ = "Bearer ";
        public static final String DEVICE = "device";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String TYPE = "type";
        public static final String USER = "user";
    }
}
