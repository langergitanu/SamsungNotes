package com.samsung.android.support.senl.p148nt.data.database.core.schema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class DBSchema {
    private static final String CATEGORY_TREE_CLOSURE_TABLE_NAME = "category_tree_closure";
    private static final String CATEGORY_TREE_TABLE_NAME = "category_tree";
    private static final String CONTENT_TABLE_NAME = "content";
    private static final String DOCUMENT_TEMPLATE_TABLE_NAME = "document_template";
    public static final String MAIN_LIST_DOCUMENT_JOINED_STATEMENT = " LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID";
    public static final String MAIN_LIST_DOCUMENT_JOINED_TABLE = "sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID";
    public static final String MAIN_LIST_DOCUMENT_MAPPED_JOINED_STATEMENT = " LEFT JOIN mapped_document AS map ON sdoc.UUID = map.UUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID";
    public static final String MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE = "sdoc LEFT JOIN mapped_document AS map ON sdoc.UUID = map.UUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID";
    private static final String RETRY_TABLE_NAME = "retry";
    private static final String STROKE_TABLE_NAME = "stroke";
    private static final String TEXT_SEARCH_TABLE_NAME = "text_search";
    private static final String UUID_STRING = "UUID";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CategoryTree {
        public static final String CREATED_AT = "createdAt";
        public static final String DISPLAY_NAME = "displayName";
        public static final String DISPLAY_NAME_COLOR = "displayNameColor";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String IS_SYNC_WITH_MS = "isSyncWithMS";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String ORDER_BY = "orderBy";
        public static final String PARENT_UUID = "parentUUID";
        public static final String PATH = "path";
        public static final String RECYCLE_BIN_TIME_MOVED = "recycle_bin_time_moved";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String TABLE_NAME = "category_tree";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CategoryTreeClosure {
        public static final String ANCESTOR = "ancestor";
        public static final String DEPTH = "depth";
        public static final String DESCENDANT = "descendant";
        public static final String DOCUMENT_COUNT = "documentCount";
        public static final String TABLE_NAME = "category_tree_closure";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Content {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String CONTENT_SECURE_VERSION = "contentSecureVersion";
        public static final String CREATED_AT = "createdAt";
        public static final String DATA = "data";
        public static final String DISPLAY_NAME = "displayName";
        public static final String FILEPATH = "filePath";

        /* JADX INFO: renamed from: ID */
        public static final String f7406ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String MIME_TYPE = "mime_type";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String SIZE = "size";
        public static final String SRCID = "srcID";
        public static final String TABLE_NAME = "content";
        public static final String UUID = "UUID";
        public static final String _DATA = "_data";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CoverSticker {
        public static final String CREATED_AT = "createdAt";
        public static final String ICON_PATH = "icon_path";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String NAME = "name";
        public static final String TABLE_NAME = "cover_category";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CoverTemplate {
        public static final String CREATED_AT = "createdAt";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String PATH = "path";
        public static final String TABLE_NAME = "cover_template";
        public static final String TYPE = "type";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Document {
        public static final String ABSOLUTE_PATH = "absolutePath";
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String BACKGROUND_COLOR_INVERTED = "backgroundColorInverted";
        public static final String CATEGORY_IS_DIRTY = "categoryisDirty";
        public static final String CATEGORY_SERVER_TIMESTAMP = "categoryserverTimestamp";
        public static final String CATEGORY_UUID = "categoryUUID";
        public static final String CONTENT = "content";
        public static final String CONTENT_SECURE_VERSION = "contentSecureVersion";
        public static final String CONTENT_UUID = "contentUUID";
        public static final String CORRUPTED = "corrupted";
        public static final String CREATED_AT = "createdAt";
        public static final String DELETE_RECOMMENDED = "deleteRecommended";
        public static final String DISPLAY_CONTENT = "displayContent";
        public static final String DISPLAY_TITLE = "displayTitle";
        public static final String FILEPATH = "filePath";
        public static final String FIRST_CONTENT_TYPE = "firstContentType";
        public static final String FIRST_HANDWRITING_HEIGHT = "firstHandwritingHeight";
        public static final String FIRST_OPEND_AT = "firstOpendAt";

        /* JADX INFO: renamed from: ID */
        public static final String f7407ID = "_id";
        public static final String IMPORTED_AT = "importedAt";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String IS_FAVORITE = "isFavorite";
        public static final String IS_LOCK = "isLock";
        public static final String IS_SAVING = "isSaving";
        public static final String LAST_MAPPED_AT = "lastMappedAt";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String LAST_OPENED_AT = "lastOpenedAt";
        public static final String LOCK_ACCOUNT_GUID = "lockAccountGuid";
        public static final String MATH_MODE = "mathMode";
        public static final String MDE_EXTRA = "mdeExtra";
        public static final String MDE_GROUP_ID = "mdeGroupId";
        public static final String MDE_ITEM_ID = "mdeItemId";
        public static final String MDE_OWNER_ID = "mdeOwnerId";
        public static final String MDE_SPACE_ID = "mdeSpaceId";
        public static final String MS_LAST_SYNC_TIME = "msLastSyncTime";
        public static final String MS_SYNC_ACCOUNT_ID = "msSyncAccountId";
        public static final String MS_SYNC_DOCUMENT_UUID = "msSyncDocumentUuid";
        public static final String NOTENAME = "noteName";
        public static final String PAGE_MODE = "pageMode";
        public static final String RECOMMENDED_AT = "recommendedAt";
        public static final String RECOMMENDED_TITLE = "recommendedTitle";
        public static final String RECYCLE_BIN_TIME_MOVED = "recycle_bin_time_moved";
        public static final String REMINDER_REQUEST_CODE = "reminderRequestCode";
        public static final String REMINDER_TRIGGER_TIME = "reminderTriggerTime";
        public static final String SAVE_TYPE = "saveType";
        public static final String SECOND_CONTENT_TYPE = "secondContentType";
        public static final String SECOND_OPENED_AT = "secondOpenedAt";
        public static final String SERVER_TIMESTAMP = "serverTimestamp";
        public static final String SIZE = "size";
        public static final String STRIPPED_CONTENT = "strippedContent";
        public static final String STROKE_RATIO = "strokeRatio";
        public static final String STROKE_UUID = "strokeUUID";
        public static final String TABLE_NAME = "sdoc";
        public static final String TITLE = "title";
        public static final String UUID = "UUID";
        public static final String VR_UUID = "vrUUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentCover {
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String CATEGORY_UUID = "categoryUUID";
        public static final String CREATED_AT = "createdAt";
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String ENABLED = "isEnabled";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String SUMMARY = "summary";
        public static final String SUMMARY_ALIGNMENT = "summary_alignment";
        public static final String TABLE_NAME = "document_cover";
        public static final String TEMPLATE_UUID = "templateUUID";
        public static final String TITLE = "title";
        public static final String TITLE_ALIGNMENT = "title_alignment";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentExtra {
        public static final String FORMAT_VERSION = "formatVersion";
        public static final String HAS_IMAGE = "hasImage";
        public static final String HAS_PDF = "hasPdf";
        public static final String HAS_STICKY = "hasSticky";
        public static final String HAS_STROKE = "hasStroke";
        public static final String TABLE_NAME = "document_extra";
        public static final String UNKNOWN_MIN_VERSION = "unknownMinVersion";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentPage {
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String FAVORITE = "favorite";

        /* JADX INFO: renamed from: ID */
        public static final String f7408ID = "_id";
        public static final String INDEX = "index";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String TABLE_NAME = "document_page";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentProjection {
        public static final String ALL_PROJECTION = "`sdoc`.*";
        public static final String MAIN_LIST_DOCUMENT_PROJECTION = "`sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime`";
        public static final String SDOC_COUNT_PROJECTION = "`sdoc`.`_id` AS `_id`, `sdoc`.`isLock` AS `isLock`";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentTempData {
        public static final String TABLE_NAME = "document_temp_data";
        public static final String TEMP_DATA = "tempData";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentTemplate {
        public static final String CREATED_AT = "createdAt";
        public static final String DATA = "_data";
        public static final String DISPLAY_NAME = "_display_name";
        public static final String HEIGHT = "height";

        /* JADX INFO: renamed from: ID */
        public static final String f7409ID = "_id";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String MIME_TYPE = "mime_type";
        public static final String SIZE = "_size";
        public static final String TABLE_NAME = "document_template";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final String UUID = "UUID";
        public static final String WIDTH = "width";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentThumbnail {
        public static final String BACKGROUND_TYPE = "backgroundType";
        public static final String IMAGE_PATH = "imagePath";
        public static final String LAYOUT = "layout";
        public static final String PLAY_TIME = "playTime";
        public static final String TABLE_NAME = "document_thumbnail";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ExternalSharedDocument {
        public static final String TABLE_NAME = "external_shared_documents";
        public static final String TIMESTAMP = "timestamp";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MappedDocument {
        public static final String CONVERTED = "converted";

        /* JADX INFO: renamed from: ID */
        public static final String f7410ID = "_id";
        public static final String IS_DELETED = "isDeleted";
        public static final String IS_DIRTY = "isDirty";
        public static final String MAPPED_AT = "mappedAt";
        public static final String MAPPED_UUID = "mappedUUID";
        public static final String TABLE_NAME = "mapped_document";
        public static final String UUID = "UUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OrganizedDocument {
        public static final String CONTENTS = "contents";
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String MODIFIED_TIME = "modified_time";
        public static final String RECOGNIZED_LANGUAGE = "recognized_language";
        public static final String RECOGNIZER_DB_VERSION = "recognizerDBVersion";
        public static final String TABLE_NAME = "organized_document";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PageSearchInfo {
        public static final String DOCUMENT_UUID = "sdocUUID";

        /* JADX INFO: renamed from: ID */
        public static final String f7411ID = "_id";
        public static final String IS_DIRTY = "isDirty";
        public static final String LAST_CONTENT_MODIFIED_AT = "lastContentModifiedAt";
        public static final String LAST_SEARCH_MODIFIED_AT = "lastSearchModifiedAt";
        public static final String PAGE_CONTENT_SOURCE = "contentSource";
        public static final String PAGE_UUID = "pageUuid";
        public static final String SEARCH_SOURCE = "searchSource";
        public static final String TABLE_NAME = "page_search_info";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Retry {

        /* JADX INFO: renamed from: ID */
        public static final String f7412ID = "_id";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String RECOGNITION_COUNT = "recognitionCount";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String STATE = "state";
        public static final String STROKE_FILEPATH = "strokeFilePath";
        public static final String TABLE_NAME = "retry";
        public static final String VERSION = "version";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Sticky {
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String FILEPATH = "filePath";
        public static final String HEIGHT = "height";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String OBJECT_ID = "objectId";
        public static final String PAGE_UUID = "pageUuid";
        public static final String TABLE_NAME = "sticky";
        public static final String WIDTH = "width";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StickyStroke {
        public static final String ACTION_LINK_DATA = "actionLinkData";
        public static final String BOTTOM = "bottom";

        /* JADX INFO: renamed from: ID */
        public static final String f7413ID = "_id";
        public static final String LEFT = "left";
        public static final String OBJECT_ID = "objectId";
        public static final String PAGE_WIDTH = "pageWidth";
        public static final String RIGHT = "right";
        public static final String TABLE_NAME = "sticky_stroke";
        public static final String TEXT = "text";
        public static final String TOP = "top";
        public static final String TYPE = "type";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StickyText {
        public static final String OBJECT_ID = "objectId";
        public static final String TABLE_NAME = "sticky_text";
        public static final String TEXT = "text";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StrokeSearch {
        public static final String ACTION_LINK_DATA = "actionLinkData";
        public static final String BOTTOM = "bottom";
        public static final String FILEPATH = "filePath";
        public static final String HAS_VISUALCUE = "hasVisualCue";

        /* JADX INFO: renamed from: ID */
        public static final String f7414ID = "_id";
        public static final String LEFT = "left";
        public static final String PAGE_UUID = "pageUuid";
        public static final String PAGE_WIDTH = "pageWidth";
        public static final String RECOGNIZER_DB_VERSION = "recognizerDBVersion";
        public static final String RIGHT = "right";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String TABLE_NAME = "stroke";
        public static final String TEXT = "text";
        public static final String TOP = "top";
        public static final String TYPE = "type";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SttContent {
        public static final String CONTENT = "content";
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String FILE_PATH = "filePath";

        /* JADX INFO: renamed from: ID */
        public static final String f7415ID = "_id";
        public static final String INDEX = "index";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String TABLE_NAME = "stt_content";
        public static final String TYPE = "type";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SuggestedCover {
        public static final String DOCUMENT_UUID = "documentUUID";
        public static final String STATE = "state";
        public static final String TABLE_NAME = "suggested_cover";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TagList {
        public static final String DISPLAY_NAME = "displayName";
        public static final String DOC_COUNT = "docCount";
        public static final String DOC_UUID = "docUUID";

        /* JADX INFO: renamed from: ID */
        public static final String f7416ID = "_id";
        public static final String NORMALIZE_NAME = "normalizeName";
        public static final String TABLE_NAME = "tag_list";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TextSearch {
        public static final String FILEPATH = "filePath";
        public static final String SDOC_UUID = "sdocUUID";
        public static final String STRIPPED_CONTENT = "strippedContent";
        public static final String TABLE_NAME = "text_search";
    }
}
