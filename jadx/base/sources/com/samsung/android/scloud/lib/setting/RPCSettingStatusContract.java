package com.samsung.android.scloud.lib.setting;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface RPCSettingStatusContract {
    public static final String AUTHORITY = "com.samsung.android.scloud.statusprovider";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Method {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.scloud.statusprovider");
        public static final String GET_STATUS_BY_ID = "get_status_by_id";
        public static final String GET_STATUS_BY_TAG = "get_status_by_tag";
        public static final String GET_STATUS_CHANGED_URI = "get_status_changed_uri";
        public static final String GET_STATUS_IDS = "get_status_ids";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameter {
        public static final String STATUS_BY_ID = "status_by_id";
        public static final String STATUS_BY_TAG = "status_by_tag";
        public static final String STATUS_CHANGED_URI = "status_changed_uri";
        public static final String STATUS_ID = "status_id";
        public static final String STATUS_IDS = "status_ids";
        public static final String TAG_ID = "tag_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tag {
        public static final String BACKUP = "backup";
        public static final String LINK = "link";
        public static final String SYNC = "sync";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Value {
        public static final int NOT_SUPPORT = -1;
        public static final int OFF = 0;

        /* JADX INFO: renamed from: ON */
        public static final int f4846ON = 1;
    }
}
