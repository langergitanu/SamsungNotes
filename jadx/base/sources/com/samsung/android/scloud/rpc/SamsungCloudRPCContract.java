package com.samsung.android.scloud.rpc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SamsungCloudRPCContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EdpState {
        public static final int NONE = -1;
        public static final int OFF = 0;

        /* JADX INFO: renamed from: ON */
        public static final int f4860ON = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InterfaceType {
        public static final String PRIVATE = "private";
        public static final String PUBLIC = "public";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Meta {
        public static final String DIGITAL_LEGACY_USER_ID = "digitalLegacyUserId";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NetworkOption {
        public static final int MOBILE_OR_WIFI = 0;
        public static final int WIFI_ONLY = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameter {
        public static final String PRECONDITION = "precondition";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Policy {
        public static final String FORCE_SYNC = "forceSync";
        public static final String IGNORE_NETWORK_SETTING = "ignoreNetworkSetting";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Precodition {
        public static final int NO_ACCOUNT = 1;
        public static final int NO_CONSENT_TO_USE_NETWORK = 4096;
        public static final int NO_PERMISSION = 16;
        public static final int NO_PERSONAL_INFO = 256;
        public static final int NO_PRECONDITION = 0;
        public static final int NO_PRIVACY_NOTICE = 512;
        public static final int NO_SYNC_IN_EDP = 768;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Property {
        public static final String APP_INITIALIZATION_COMPLTED = "app_initialization_completed";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RecordInfo {
        public static final String LOCAL_RECORD_ID = "localRecordId";
        public static final String SYNC_RECORD_ID = "syncRecordId";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface State {
        public static final String CANCEL = "cancel";
        public static final String COMPLETE = "complete";
        public static final String PROGRESS = "progress";
        public static final String START = "start";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Status {
        public static final int NOT_SUPPORT = -1;
        public static final int OFF = 0;

        /* JADX INFO: renamed from: ON */
        public static final int f4861ON = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TagId {
        public static final String BACKUP = "backup";
        public static final String LINK = "link";
        public static final String SYNC = "sync";
    }
}
