package com.samsung.android.scloud.rpc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SamsungCloudRPCStatus {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Key {
        public static final String RCODE = "rcode";
        public static final String RMSG = "rmsg";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ServiceType {
        public static final String SYNC = "SYNC";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Value {
        public static final int FAILED_CONSENT_TO_USE_NETWORK = 80300002;
        public static final int FAILED_CONSENT_TO_USE_PERSONAL_INFORMATION = 80300001;
        public static final int FAILED_DEVICE_OVERHEAT = 70000006;
        public static final int FAILED_EXCEED_UPLOAD_SIZE = 70000005;
        public static final int FAILED_FDS_EXCEED_DEVICE = 40300007;
        public static final int FAILED_FDS_EXCEED_LOGIN = 40300006;
        public static final int FAILED_FDS_INVALID_SOFTWARE = 40300008;
        public static final int FAILED_GDPR_DELETED = 40300005;
        public static final int FAILED_GDPR_RESTRICTED = 40300004;
        public static final int FAILED_INSUFFICIENT_STORAGE_ON_DEVICE = 90700000;
        public static final int FAILED_INTERNAL_AGENT_ERROR = 90000000;
        public static final int FAILED_INTERNAL_SERVER_ERROR = 50000000;
        public static final int FAILED_NO_ACCOUNT = 70000003;
        public static final int FAILED_NO_NETWORK = 60000001;
        public static final int FAILED_PERMISSION = 70000002;
        public static final int FAILED_QUOTA_EXCEEDED = 40300009;
        public static final int NONE = 0;
        public static final int SUCCESS = 20000000;
    }

    String getServiceType();

    void onBind(boolean z);
}
