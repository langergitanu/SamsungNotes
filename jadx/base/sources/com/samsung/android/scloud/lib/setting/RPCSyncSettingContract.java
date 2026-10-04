package com.samsung.android.scloud.lib.setting;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface RPCSyncSettingContract {
    public static final String AUTHORITY = "com.samsung.android.scloud.sync.rpc";
    public static final String PACKAGE = "com.samsung.android.scloud";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Action {
        public static final String SHOW_GALLERY_SETTING = "com.samsung.android.scloud.GALLERY_SETTING";
        public static final String SHOW_SETTING = "com.samsung.android.scloud.app.activity.LAUNCH_OTHER_PHONE_DATA";
        public static final String SHOW_SYNC_SETTING_DASHBOARD = "com.samsung.android.scloud.app.activity.LAUNCH_SYNC_SETTING_DASHBOARD";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ApplicationType {
        public static final int NATIVE_APP = 1;
        public static final int SETTING_APP = 2;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Authority {
        public static final String Gallery = "media";
        public static final String Setting = "setting";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MetaData {
        public static final String SETTING_LIB_PROVIDER = "scloud_setting_lib_provider_authority";
        public static final String SETTING_STANDALONE_PROVIDER = "scloud_setting_standalone_provider_authority";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Method {
        public static final String CANCEL_SYNC = "cancel_sync";
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.scloud.sync.rpc");
        public static final String GET_AUTO_SYNC = "get_auto_sync";
        public static final String GET_CONTENT_SYNC = "get_content_sync";
        public static final String GET_DENIED_PERMISSIONS = "get_denied_permissions";
        public static final String GET_EDP_STATE = "get_edp_state";
        public static final String GET_LAST_SUCCESS_TIME = "get_last_success_time";
        public static final String GET_NETWORK_OPTION = "get_network_option";
        public static final String GET_PERFORMANCE_POLICY = "get_performance_policy";
        public static final String GET_PROFILE = "get_profile";
        public static final String GET_SYNCABLE_APP_LIST = "get_syncable_app_list";
        public static final String IS_PERMISSION_GRANTED = "is_permission_granted";
        public static final String IS_SUPPORTED = "is_supported";
        public static final String IS_SYNCABLE = "is_syncable";
        public static final String IS_SYNC_ACTIVE = "is_sync_active";
        public static final String IS_SYNC_IN_EDP_SUPPORTED = "is_sync_in_edp_supported";
        public static final String NOTIFY_EDP_STATE = "notify_edp_state";
        public static final String NOTIFY_PERFORMANCE_POLICY = "notify_performance_policy";
        public static final String REQUEST_FAST_SYNC = "request_fast_sync";
        public static final String REQUEST_LOCAL_SYNC = "request_local_sync";
        public static final String REQUEST_SINGLE_RECORD_DOWNLOAD = "request_single_record_download";
        public static final String REQUEST_SYNC = "start_sync";
        public static final String REQUEST_SYNC_BY_CONTENT_ID = "start_sync_by_content_id";
        public static final String REQUEST_SYNC_FOR_DIGITAL_LEGACY = "start_sync_for_digital_legacy";
        public static final String SET_AUTO_SYNC = "set_auto_sync";
        public static final String SET_CONTENT_SYNC = "set_content_sync";
        public static final String SET_NETWORK_OPTION = "set_network_option";
        public static final String SET_SUPPORTED = "set_supported";
        public static final String SHOW_SETTING = "show_setting";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NetworkOption {
        public static final int MOBILE_OR_WIFI = 0;
        public static final int WIFI_ONLY = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameter {
        public static final String APPLICATION_TYPE = "application_type";
        public static final String AUTHORITY = "authority";
        public static final String AUTO_SYNC = "auto_sync";
        public static final String CALLBACK_URI = "callback_uri";
        public static final String CLOUD_NAME = "cloud_name";
        public static final String CONTENT_ID = "content_id";
        public static final String CONTENT_IDS = "content_ids";
        public static final String DENIED_PERMISSIONS = "denied_permissions";
        public static final String EDP_STATE = "edp_state";
        public static final String EXTRA_CONTENT_IDS = "extra_content_ids";
        public static final String FORCE_SYNC = "force_sync";
        public static final String IS_PERMISSION_GRANTED = "is_permission_granted";
        public static final String IS_SYNCABLE = "is_syncable";
        public static final String IS_SYNC_ACTIVE = "is_sync_active";
        public static final String IS_SYNC_SETTING_REQUIRED = "is_sync_setting_required";
        public static final String LAST_SUCCESS_TIME = "last_success_time";
        public static final String LIBRARY_VERSION = "library_version";
        public static final String LOCAL_REQUEST_INITIAL_INTERVAL = "local_request_initial_interval";
        public static final String LOCAL_REQUEST_INTERVAL = "local_request_interval";
        public static final String LOCAL_SYNC_FIRST_REQUEST_TIME = "local_sync_first_request_time";
        public static final String LOCAL_SYNC_LAST_REQUEST_TIME = "local_sync_last_request_time";
        public static final String NETWORK_OPTION = "network_option";
        public static final String PENDING_REQUEST_COUNTS = "pending_request_counts";
        public static final String POLICY_STATUS_LIST = "policy_status_list";
        public static final String PRECONDITION = "precondition";
        public static final String PROFILE = "profile";
        public static final String QUERIED_AUTHORITY = "queried_authority";
        public static final String SERVICE_NAME = "service_name";
        public static final String STATUS_ID = "status_id";
        public static final String SUPPORTED = "supported";
        public static final String SYNCABLE_APP_LIST = "syncable_app_list";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface State {
        public static final String CANCEL = "cancel";
        public static final String COMPLETE = "complete";
        public static final String PROGRESS = "progress";
        public static final String START = "start";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Version {
        public static final long EDP_SUPPORTED_VERSION = 20170;
    }
}
