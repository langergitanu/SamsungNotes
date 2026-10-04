package com.samsung.android.support.senl.p148nt.data.database.core.schema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SyncDBSchema {
    private static final String UUID_STRING = "UUID";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncDelayInfo {
        public static final String APP_VERSION = "appVersion";
        public static final String EXTRA = "extra";
        public static final String REASON = "reason";
        public static final String RETRY_COUNT = "retryCount";
        public static final String SERVER_ID = "serverId";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String TABLE_NAME = "sync_delay_info";
        public static final String UP_SYNC = "upSync";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncFolderInfo {
        public static final String DELETED_BY = "deletedBy";
        public static final String TABLE_NAME = "sync_folder_info";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncInfo {
        public static final String CLIENT_ID = "clientId";
        public static final String CLIENT_MODIFIED_TIME = "clientModifiedTime";
        public static final String CLIENT_MODIFIED_TIME_FOLDER = "clientModifiedTimeFolder";
        public static final String COEDIT_CHECKPOINT = "coeditCheckPoint";
        public static final String COEDIT_RESOURCE_ID = "coeditResourceId";
        public static final String COMMIT_ID = "commitId";
        public static final String CONFLICT = "conflict";
        public static final String CONFLICT_STRATEGY = "conflictStrategy";
        public static final String DELETED_BY = "deletedBy";
        public static final String DEVICE_NAME = "deviceName";

        /* JADX INFO: renamed from: ID */
        public static final String f7418ID = "_id";
        public static final String IS_DIRTY_FOLDER = "isDirtyFolder";
        public static final String IS_EXTRA_INFO_DIRTY = "isExtraInfoDirty";
        public static final String IS_SYNC_FAILED = "isSyncFailed";
        public static final String LAST_MODIFIED_TIME_FOLDER = "lastModifiedTimeFolder";
        public static final String SERVER_ID = "serverId";
        public static final String STROKE_GROUPED = "strokeGrouped";
        public static final String SYNC_STATE = "syncState";
        public static final String TABLE_NAME = "sync_info";
    }
}
