package com.samsung.android.support.senl.p148nt.data.common.legacy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OldDBSchema {
    private static final String CATEGORY_TABLE_NAME = "category";
    private static final String CONTENT_TABLE_NAME = "content";
    private static final String HASHTAG_CONTENT_TABLE_NAME = "hashtagContent";
    private static final String HASHTAG_TABLE_NAME = "hashtag";
    private static final String RETRY_TABLE_NAME = "retry";
    private static final String SDOC_TABLE_NAME = "sdoc";
    private static final String STROKE_TABLE_NAME = "stroke";
    private static final String UUID_STRING = "UUID";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Category {
        public static final String DISPLAY_NAME = "displayName";
        public static final String DISPLAY_NAME_COLOR = "displayNameColor";

        /* JADX INFO: renamed from: ID */
        public static final String f7350ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String ORDER_BY = "orderBy";
        public static final String PREDEFINE = "predefine";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String TABLE_NAME = "category";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Content {
        public static final String CONTENT_SECURE_VERSION = "contentSecureVersion";
        public static final String DATA = "data";
        public static final String DISPLAY_NAME = "displayName";
        public static final String FILEPATH = "filePath";

        /* JADX INFO: renamed from: ID */
        public static final String f7351ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String MIME_TYPE = "mime_type";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String SRCID = "srcID";
        public static final String TABLE_NAME = "content";
        public static final String UUID = "UUID";
        public static final String _DATA = "_data";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HashTag {
        public static final String EXTRA_INFO = "extraInfo";

        /* JADX INFO: renamed from: ID */
        public static final String f7352ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String NAME = "name";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String TABLE_NAME = "hashtag";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HashTagContent {
        public static final String EXTRA_INFO = "extraInfo";
        public static final String HASHTAG_UUID = "hashtagUUID";

        /* JADX INFO: renamed from: ID */
        public static final String f7353ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String IS_SYNC_FAILED = "isSyncFailed";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String TABLE_NAME = "hashtagContent";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Retry {

        /* JADX INFO: renamed from: ID */
        public static final String f7354ID = "_id";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String RECOGNITION_COUNT = "recognitionCount";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String STATE = "state";
        public static final String STROKE_FILEPATH = "strokeFilePath";
        public static final String TABLE_NAME = "retry";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SDoc {
        public static final String CATEGORY_UUID = "categoryUUID";
        public static final String CONTENT = "content";
        public static final String CONTENT_SECURE_VERSION = "contentSecureVersion";
        public static final String DELETE_RECOMMENDED = "deleteRecommended";
        public static final String DISPLAY_CONTENT = "displayContent";
        public static final String DISPLAY_TITLE = "displayTitle";
        public static final String FILEPATH = "filePath";
        public static final String FIRST_CONTENT_TYPE = "firstContentType";
        public static final String FIRST_HANDWRITING_HEIGHT = "firstHandwritingHeight";
        public static final String FIRST_OPEND_AT = "firstOpendAt";
        public static final String IMPORTED_AT = "importedAt";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_LOCK = "isLock";
        public static final String IS_SAVING = "isSaving";
        public static final String LAST_OPENED_AT = "lastOpenedAt";
        public static final String MDE_EXTRA = "mdeExtra";
        public static final String MDE_GROUP_ID = "mdeGroupId";
        public static final String MDE_ITEM_ID = "mdeItemId";
        public static final String MDE_OWNER_ID = "mdeOwnerId";
        public static final String MDE_SPACE_ID = "mdeSpaceId";
        public static final String RECOMMENDED_AT = "recommendedAt";
        public static final String RECYCLE_BIN_TIME_MOVED = "recycle_bin_time_moved";
        public static final String REMINDER_REQUEST_CODE = "reminderRequestCode";
        public static final String REMINDER_TRIGGER_TIME = "reminderTriggerTime";
        public static final String SAVE_TYPE = "saveType";
        public static final String SECOND_CONTENT_TYPE = "secondContentType";
        public static final String SECOND_OPENED_AT = "secondOpenedAt";
        public static final String SIZE = "size";
        public static final String STRIPPED_CONTENT = "strippedContent";
        public static final String STROKE_RATIO = "strokeRatio";
        public static final String STROKE_UUID = "strokeUUID";
        public static final String TABLE_NAME = "sdoc";
        public static final String TITLE = "title";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StrokeSearch {
        public static final String BOTTOM = "bottom";
        public static final String FILEPATH = "filePath";

        /* JADX INFO: renamed from: ID */
        public static final String f7355ID = "_id";
        public static final String LEFT = "left";
        public static final String PAGE_WIDTH = "pageWidth";
        public static final String RIGHT = "right";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String TABLE_NAME = "stroke";
        public static final String TEXT = "text";
        public static final String TOP = "top";
    }
}
