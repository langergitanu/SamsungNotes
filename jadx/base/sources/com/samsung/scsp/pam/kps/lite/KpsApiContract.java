package com.samsung.scsp.pam.kps.lite;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface KpsApiContract {
    public static final int MAX_JOIN_TIMEOUT = 60000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CODE {
        public static final int GET_SERVICE_KEY_TIMEOUT = 40805001;
        public static final int MAY_RETRY_KEYSYNC = 40805002;
        public static final int SHOULD_GET_SERVICE_KEY = 40305006;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Control {
        public static final String JOIN = "JOIN";
        public static final String LEAVE = "LEAVE";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Header {
        public static final String SERVICE_KEY_ID = "x-sc-service-key-id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameter {
        public static final String CERTIFICATE_CHAIN = "certificateChain";
        public static final String CHALLENGE = "challenge";
        public static final String E2EE_GROUP_ID = "e2eeGroupId";
        public static final String KEY_MANAGEMENT = "keyManagement";
        public static final String RECOVERY_CODE = "recoveryCode";
        public static final String SDID = "sdid";
        public static final String SERVICE_ID = "serviceId";
    }
}
