package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentTempDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentTempDataDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.ExternalSharedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.ExternalSharedDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentPageDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentPageDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesLockDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesLockDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRetryDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRetryDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyTextDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyTextDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SttContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SttContentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.external.ExternalDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.external.ExternalDataDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao_Impl;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesDatabase_Impl extends NotesDatabase {
    private volatile CoverStickerDao _coverStickerDao;
    private volatile CoverTemplateDao _coverTemplateDao;
    private volatile DocumentExtraDao _documentExtraDao;
    private volatile DocumentTempDataDao _documentTempDataDao;
    private volatile DocumentThumbnailDao _documentThumbnailDao;
    private volatile ExternalDataDao _externalDataDao;
    private volatile ExternalSharedDocumentDao _externalSharedDocumentDao;
    private volatile MainListDocumentDataDao _mainListDocumentDataDao;
    private volatile NotesCategoryTreeClosureDao _notesCategoryTreeClosureDao;
    private volatile NotesCategoryTreeDao _notesCategoryTreeDao;
    private volatile NotesContentDao _notesContentDao;
    private volatile NotesConvertedDocumentDao _notesConvertedDocumentDao;
    private volatile NotesDebugDao _notesDebugDao;
    private volatile NotesDocumentCoverDao _notesDocumentCoverDao;
    private volatile NotesDocumentDao _notesDocumentDao;
    private volatile NotesDocumentPageDao _notesDocumentPageDao;
    private volatile NotesHashtagContentDao _notesHashtagContentDao;
    private volatile NotesHashtagDao _notesHashtagDao;
    private volatile NotesLockDocumentDao _notesLockDocumentDao;
    private volatile NotesMappedDocumentDao _notesMappedDocumentDao;
    private volatile NotesOldDocumentDao _notesOldDocumentDao;
    private volatile NotesOrganizedDocumentDao _notesOrganizedDocumentDao;
    private volatile NotesPageSearchInfoDao _notesPageSearchInfoDao;
    private volatile NotesRecycleBinDocumentDao _notesRecycleBinDocumentDao;
    private volatile NotesRestoreDao _notesRestoreDao;
    private volatile NotesRetryDao _notesRetryDao;
    private volatile NotesSearchDao _notesSearchDao;
    private volatile NotesStrokeDao _notesStrokeDao;
    private volatile NotesTagDao _notesTagDao;
    private volatile NotesTemplateDao _notesTemplateDao;
    private volatile RestoreFolderDao _restoreFolderDao;
    private volatile StickyNoteDao _stickyNoteDao;
    private volatile StickyStrokeDao _stickyStrokeDao;
    private volatile StickyTextDao _stickyTextDao;
    private volatile SttContentDao _sttContentDao;
    private volatile SuggestedCoverDao _suggestedCoverDao;
    private volatile SyncCategoryTreeDao _syncCategoryTreeDao;
    private volatile SyncDelayInfoDao _syncDelayInfoDao;
    private volatile SyncDocumentDao _syncDocumentDao;
    private volatile SyncFolderInfoDao _syncFolderInfoDao;
    private volatile SyncInfoDao _syncInfoDao;
    private volatile SyncMdeDao _syncMdeDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `sdoc`");
            writableDatabase.execSQL("DELETE FROM `content`");
            writableDatabase.execSQL("DELETE FROM `category_tree`");
            writableDatabase.execSQL("DELETE FROM `category_tree_closure`");
            writableDatabase.execSQL("DELETE FROM `sync_info`");
            writableDatabase.execSQL("DELETE FROM `tag_list`");
            writableDatabase.execSQL("DELETE FROM `retry`");
            writableDatabase.execSQL("DELETE FROM `stroke`");
            writableDatabase.execSQL("DELETE FROM `document_template`");
            writableDatabase.execSQL("DELETE FROM `mapped_document`");
            writableDatabase.execSQL("DELETE FROM `document_page`");
            writableDatabase.execSQL("DELETE FROM `hashtag`");
            writableDatabase.execSQL("DELETE FROM `hashtagContent`");
            writableDatabase.execSQL("DELETE FROM `text_search`");
            writableDatabase.execSQL("DELETE FROM `document_thumbnail`");
            writableDatabase.execSQL("DELETE FROM `page_search_info`");
            writableDatabase.execSQL("DELETE FROM `cover_template`");
            writableDatabase.execSQL("DELETE FROM `cover_category`");
            writableDatabase.execSQL("DELETE FROM `suggested_cover`");
            writableDatabase.execSQL("DELETE FROM `document_cover`");
            writableDatabase.execSQL("DELETE FROM `organized_document`");
            writableDatabase.execSQL("DELETE FROM `stt_content`");
            writableDatabase.execSQL("DELETE FROM `document_temp_data`");
            writableDatabase.execSQL("DELETE FROM `sync_delay_info`");
            writableDatabase.execSQL("DELETE FROM `document_extra`");
            writableDatabase.execSQL("DELETE FROM `sticky`");
            writableDatabase.execSQL("DELETE FROM `sticky_text`");
            writableDatabase.execSQL("DELETE FROM `sticky_stroke`");
            writableDatabase.execSQL("DELETE FROM `external_shared_documents`");
            writableDatabase.execSQL("DELETE FROM `sync_folder_info`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "sdoc", "content", DBSchema.CategoryTree.TABLE_NAME, DBSchema.CategoryTreeClosure.TABLE_NAME, SyncDBSchema.SyncInfo.TABLE_NAME, "tag_list", "retry", "stroke", DBSchema.DocumentTemplate.TABLE_NAME, DBSchema.MappedDocument.TABLE_NAME, DBSchema.DocumentPage.TABLE_NAME, OldDBSchema.HashTag.TABLE_NAME, OldDBSchema.HashTagContent.TABLE_NAME, DBSchema.TextSearch.TABLE_NAME, DBSchema.DocumentThumbnail.TABLE_NAME, DBSchema.PageSearchInfo.TABLE_NAME, DBSchema.CoverTemplate.TABLE_NAME, DBSchema.CoverSticker.TABLE_NAME, "suggested_cover", "document_cover", DBSchema.OrganizedDocument.TABLE_NAME, DBSchema.SttContent.TABLE_NAME, DBSchema.DocumentTempData.TABLE_NAME, SyncDBSchema.SyncDelayInfo.TABLE_NAME, DBSchema.DocumentExtra.TABLE_NAME, DBSchema.Sticky.TABLE_NAME, DBSchema.StickyText.TABLE_NAME, DBSchema.StickyStroke.TABLE_NAME, DBSchema.ExternalSharedDocument.TABLE_NAME, SyncDBSchema.SyncFolderInfo.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(67) { // from class: com.samsung.android.support.senl.nt.data.database.access.NotesDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `sdoc` (`accountType` TEXT, `accountName` TEXT DEFAULT '', `strippedContent` BLOB NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `categoryserverTimestamp` INTEGER DEFAULT 1464416139847, `categoryisDirty` INTEGER NOT NULL DEFAULT 1, `noteName` TEXT NOT NULL DEFAULT '', `msSyncAccountId` TEXT, `msSyncDocumentUuid` TEXT, `msLastSyncTime` INTEGER NOT NULL DEFAULT 0, `mathMode` INTEGER NOT NULL DEFAULT 0, `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `title` TEXT NOT NULL DEFAULT '', `recommendedTitle` TEXT NOT NULL DEFAULT '', `content` BLOB NOT NULL, `displayContent` BLOB NOT NULL, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `vrUUID` TEXT DEFAULT '', `contentUUID` TEXT DEFAULT '', `firstContentType` INTEGER DEFAULT 0, `secondContentType` INTEGER DEFAULT 0, `strokeUUID` TEXT DEFAULT '', `strokeRatio` REAL DEFAULT 0.0, `categoryUUID` TEXT NOT NULL DEFAULT 'uncategorized:///', `filePath` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL DEFAULT 0, `isLock` INTEGER NOT NULL DEFAULT 0, `isSaving` INTEGER NOT NULL DEFAULT 0, `reminderTriggerTime` INTEGER NOT NULL DEFAULT 0, `reminderRequestCode` INTEGER NOT NULL DEFAULT 0, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `contentSecureVersion` INTEGER NOT NULL DEFAULT 0, `size` INTEGER NOT NULL DEFAULT 0, `displayTitle` BLOB, `saveType` INTEGER NOT NULL DEFAULT 0, `firstOpendAt` INTEGER NOT NULL DEFAULT 0, `secondOpenedAt` INTEGER NOT NULL DEFAULT 0, `lastOpenedAt` INTEGER NOT NULL DEFAULT 0, `importedAt` INTEGER NOT NULL DEFAULT 0, `recommendedAt` INTEGER NOT NULL DEFAULT 0, `lastMappedAt` INTEGER NOT NULL DEFAULT 0, `mdeSpaceId` TEXT NOT NULL DEFAULT '', `mdeItemId` TEXT NOT NULL DEFAULT '', `mdeExtra` TEXT NOT NULL DEFAULT '', `mdeGroupId` TEXT NOT NULL DEFAULT '', `mdeOwnerId` TEXT NOT NULL DEFAULT '', `firstHandwritingHeight` INTEGER NOT NULL DEFAULT 0, `deleteRecommended` INTEGER NOT NULL DEFAULT 0, `absolutePath` TEXT, `backgroundColor` INTEGER NOT NULL DEFAULT 0, `backgroundColorInverted` INTEGER NOT NULL DEFAULT 0, `lockAccountGuid` TEXT, `corrupted` INTEGER NOT NULL DEFAULT 0, `pageMode` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_sdoc_UUID` ON `sdoc` (`UUID`)", "CREATE INDEX IF NOT EXISTS `index_sdoc_filePath` ON `sdoc` (`filePath`)", "CREATE INDEX IF NOT EXISTS `index_sdoc_isFavorite` ON `sdoc` (`isFavorite`)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE INDEX IF NOT EXISTS `index_sdoc_categoryUUID_isDeleted` ON `sdoc` (`categoryUUID`, `isDeleted`)", "CREATE INDEX IF NOT EXISTS `index_sdoc_importedAt` ON `sdoc` (`importedAt`)", "CREATE TABLE IF NOT EXISTS `content` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `sdocUUID` TEXT NOT NULL, `mime_type` TEXT NOT NULL DEFAULT 'application/octet-stream', `displayName` TEXT NOT NULL DEFAULT '', `srcID` INTEGER NOT NULL, `data` BLOB, `_data` TEXT DEFAULT '', `filePath` TEXT NOT NULL DEFAULT '', `contentSecureVersion` INTEGER NOT NULL DEFAULT 0, `createdAt` INTEGER NOT NULL DEFAULT 0, `size` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_content_UUID` ON `content` (`UUID`)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE INDEX IF NOT EXISTS `index_content_sdocUUID` ON `content` (`sdocUUID`)", "CREATE TABLE IF NOT EXISTS `category_tree` (`UUID` TEXT NOT NULL, `parentUUID` TEXT, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `displayName` TEXT NOT NULL, `path` TEXT, `orderBy` INTEGER, `displayNameColor` INTEGER NOT NULL DEFAULT -1, `isSyncWithMS` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))", "CREATE TABLE IF NOT EXISTS `category_tree_closure` (`ancestor` TEXT NOT NULL DEFAULT '', `descendant` TEXT NOT NULL DEFAULT '', `depth` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`ancestor`, `descendant`), FOREIGN KEY(`ancestor`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`descendant`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sync_info` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `serverId` TEXT, `clientId` TEXT NOT NULL, `clientModifiedTime` INTEGER NOT NULL DEFAULT 0, `isDirtyFolder` INTEGER NOT NULL DEFAULT 1, `clientModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0, `lastModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0, `isSyncFailed` INTEGER NOT NULL DEFAULT 0, `isExtraInfoDirty` INTEGER NOT NULL DEFAULT 0, `commitId` TEXT, `deviceName` TEXT, `conflict` INTEGER NOT NULL DEFAULT 0, `conflictStrategy` INTEGER NOT NULL DEFAULT 0, `coeditResourceId` TEXT, `coeditCheckPoint` INTEGER NOT NULL DEFAULT -1, `syncState` INTEGER NOT NULL DEFAULT 0, `strokeGrouped` INTEGER NOT NULL DEFAULT 0, `deletedBy` INTEGER NOT NULL DEFAULT 0)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_sync_info_clientId` ON `sync_info` (`clientId`)", "CREATE TABLE IF NOT EXISTS `tag_list` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `normalizeName` TEXT NOT NULL, `docUUID` TEXT NOT NULL, `displayName` TEXT NOT NULL)", "CREATE INDEX IF NOT EXISTS `index_tag_list_normalizeName` ON `tag_list` (`normalizeName`)", "CREATE TABLE IF NOT EXISTS `retry` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `sdocUUID` TEXT NOT NULL, `strokeFilePath` TEXT NOT NULL, `state` INTEGER NOT NULL DEFAULT 0, `recognitionCount` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL, `version` INTEGER NOT NULL DEFAULT 0)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE INDEX IF NOT EXISTS `index_retry_state` ON `retry` (`state`)", "CREATE TABLE IF NOT EXISTS `stroke` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `hasVisualCue` INTEGER DEFAULT 0, `text` TEXT DEFAULT '', `left` INTEGER DEFAULT 0, `top` INTEGER DEFAULT 0, `right` INTEGER DEFAULT 0, `bottom` INTEGER DEFAULT 0, `filePath` TEXT NOT NULL, `sdocUUID` TEXT NOT NULL, `pageWidth` INTEGER DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, `pageUuid` TEXT DEFAULT '', `actionLinkData` TEXT DEFAULT '', `recognizerDBVersion` TEXT NOT NULL DEFAULT '0')", "CREATE INDEX IF NOT EXISTS `index_stroke_sdocUUID_type` ON `stroke` (`sdocUUID`, `type`)", "CREATE TABLE IF NOT EXISTS `document_template` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT, `_data` TEXT, `_size` INTEGER NOT NULL DEFAULT 0, `_display_name` TEXT DEFAULT '', `title` TEXT DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `mime_type` TEXT, `width` INTEGER NOT NULL DEFAULT 0, `height` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 3)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_document_template_UUID` ON `document_template` (`UUID`)", "CREATE TABLE IF NOT EXISTS `mapped_document` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `mappedUUID` TEXT NOT NULL DEFAULT '', `converted` INTEGER NOT NULL DEFAULT 1, `mappedAt` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_mapped_document_mappedUUID` ON `mapped_document` (`mappedUUID`)", "CREATE TABLE IF NOT EXISTS `document_page` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `documentUUID` TEXT NOT NULL DEFAULT '', `index` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1)");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_document_page_documentUUID_UUID` ON `document_page` (`documentUUID`, `UUID`)", "CREATE TABLE IF NOT EXISTS `hashtag` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `extraInfo` TEXT NOT NULL DEFAULT '', `lastModifiedAt` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `serverTimestamp` INTEGER DEFAULT 1464416139847, `UUID` TEXT NOT NULL)", "CREATE TABLE IF NOT EXISTS `hashtagContent` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `sdocUUID` TEXT NOT NULL, `extraInfo` TEXT NOT NULL DEFAULT '', `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `serverTimestamp` INTEGER DEFAULT 1464416139847, `isSyncFailed` INTEGER DEFAULT 0, `hashtagUUID` TEXT NOT NULL, `lastModifiedAt` INTEGER NOT NULL)", "CREATE TABLE IF NOT EXISTS `text_search` (`sdocUUID` TEXT NOT NULL, `strippedContent` BLOB NOT NULL, `filePath` TEXT NOT NULL, PRIMARY KEY(`sdocUUID`), FOREIGN KEY(`sdocUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE )");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `document_thumbnail` (`UUID` TEXT NOT NULL, `backgroundType` INTEGER NOT NULL DEFAULT 0, `layout` INTEGER NOT NULL DEFAULT 0, `imagePath` TEXT NOT NULL DEFAULT '', `playTime` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`UUID`), FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `page_search_info` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sdocUUID` TEXT NOT NULL DEFAULT '', `pageUuid` TEXT NOT NULL DEFAULT '', `contentSource` INTEGER NOT NULL DEFAULT 0, `searchSource` INTEGER NOT NULL DEFAULT 0, `lastContentModifiedAt` INTEGER NOT NULL DEFAULT 0, `lastSearchModifiedAt` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 0)", "CREATE INDEX IF NOT EXISTS `index_page_search_info_sdocUUID` ON `page_search_info` (`sdocUUID`)", "CREATE TABLE IF NOT EXISTS `cover_template` (`UUID` TEXT NOT NULL, `path` TEXT NOT NULL DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `cover_category` (`UUID` TEXT NOT NULL, `name` TEXT NOT NULL DEFAULT '', `icon_path` TEXT NOT NULL DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))", "CREATE TABLE IF NOT EXISTS `suggested_cover` (`documentUUID` TEXT NOT NULL, `state` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`documentUUID`), FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `document_cover` (`documentUUID` TEXT NOT NULL, `templateUUID` TEXT NOT NULL DEFAULT 'DEFAULT:///', `title` TEXT NOT NULL DEFAULT '', `title_alignment` INTEGER NOT NULL DEFAULT 0, `summary` TEXT NOT NULL DEFAULT '', `summary_alignment` INTEGER NOT NULL DEFAULT 0, `categoryUUID` TEXT NOT NULL DEFAULT 'NONE:///', `backgroundColor` TEXT NOT NULL DEFAULT 'DEFAULT:///', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `isEnabled` INTEGER NOT NULL DEFAULT 1, PRIMARY KEY(`documentUUID`), FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`templateUUID`) REFERENCES `cover_template`(`UUID`) ON UPDATE NO ACTION ON DELETE SET DEFAULT , FOREIGN KEY(`categoryUUID`) REFERENCES `cover_category`(`UUID`) ON UPDATE NO ACTION ON DELETE SET DEFAULT )", "CREATE TABLE IF NOT EXISTS `organized_document` (`documentUUID` TEXT NOT NULL, `contents` TEXT NOT NULL DEFAULT '', `recognized_language` TEXT NOT NULL DEFAULT '', `recognizerDBVersion` TEXT NOT NULL DEFAULT '0', `modified_time` INTEGER NOT NULL, PRIMARY KEY(`documentUUID`), FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `stt_content` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `documentUUID` TEXT NOT NULL DEFAULT '', `filePath` TEXT NOT NULL DEFAULT '', `type` INTEGER NOT NULL DEFAULT 0, `index` INTEGER NOT NULL DEFAULT 0, `content` TEXT NOT NULL DEFAULT '', `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_stt_content_documentUUID_filePath_type` ON `stt_content` (`documentUUID`, `filePath`, `type`)", "CREATE TABLE IF NOT EXISTS `document_temp_data` (`UUID` TEXT NOT NULL, `tempData` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`UUID`), FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sync_delay_info` (`UUID` TEXT NOT NULL, `serverId` TEXT NOT NULL DEFAULT '', `appVersion` TEXT NOT NULL DEFAULT '', `reason` INTEGER NOT NULL DEFAULT 0, `retryCount` INTEGER NOT NULL DEFAULT 0, `serverTimestamp` INTEGER NOT NULL DEFAULT 1464416139847, `upSync` INTEGER NOT NULL DEFAULT 0, `extra` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`UUID`))");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `document_extra` (`UUID` TEXT NOT NULL, `hasSticky` INTEGER NOT NULL DEFAULT 0, `hasImage` INTEGER NOT NULL DEFAULT 0, `hasStroke` INTEGER NOT NULL DEFAULT 0, `hasPdf` INTEGER NOT NULL DEFAULT 0, `unknownMinVersion` INTEGER NOT NULL DEFAULT 0, `formatVersion` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`), FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sticky` (`objectId` TEXT NOT NULL, `documentUUID` TEXT NOT NULL DEFAULT '', `pageUuid` TEXT NOT NULL DEFAULT '', `width` INTEGER NOT NULL DEFAULT 0, `height` INTEGER NOT NULL DEFAULT 0, `filePath` TEXT NOT NULL DEFAULT '', `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`objectId`), FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sticky_text` (`objectId` TEXT NOT NULL, `text` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`objectId`), FOREIGN KEY(`objectId`) REFERENCES `sticky`(`objectId`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sticky_stroke` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `objectId` TEXT NOT NULL DEFAULT '', `text` TEXT NOT NULL DEFAULT '', `left` INTEGER NOT NULL DEFAULT 0, `top` INTEGER NOT NULL DEFAULT 0, `right` INTEGER NOT NULL DEFAULT 0, `bottom` INTEGER NOT NULL DEFAULT 0, `pageWidth` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, `actionLinkData` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`objectId`) REFERENCES `sticky`(`objectId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE INDEX IF NOT EXISTS `index_sticky_stroke_objectId` ON `sticky_stroke` (`objectId`)", "CREATE TABLE IF NOT EXISTS `external_shared_documents` (`UUID` TEXT NOT NULL, `timestamp` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`), FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sync_folder_info` (`UUID` TEXT NOT NULL, `deletedBy` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))", RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b15c28e7f3a125e093837742c7dab1a0')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `sdoc`", "DROP TABLE IF EXISTS `content`", "DROP TABLE IF EXISTS `category_tree`", "DROP TABLE IF EXISTS `category_tree_closure`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `sync_info`", "DROP TABLE IF EXISTS `tag_list`", "DROP TABLE IF EXISTS `retry`", "DROP TABLE IF EXISTS `stroke`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `document_template`", "DROP TABLE IF EXISTS `mapped_document`", "DROP TABLE IF EXISTS `document_page`", "DROP TABLE IF EXISTS `hashtag`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `hashtagContent`", "DROP TABLE IF EXISTS `text_search`", "DROP TABLE IF EXISTS `document_thumbnail`", "DROP TABLE IF EXISTS `page_search_info`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `cover_template`", "DROP TABLE IF EXISTS `cover_category`", "DROP TABLE IF EXISTS `suggested_cover`", "DROP TABLE IF EXISTS `document_cover`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `organized_document`", "DROP TABLE IF EXISTS `stt_content`", "DROP TABLE IF EXISTS `document_temp_data`", "DROP TABLE IF EXISTS `sync_delay_info`");
                AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS `document_extra`", "DROP TABLE IF EXISTS `sticky`", "DROP TABLE IF EXISTS `sticky_text`", "DROP TABLE IF EXISTS `sticky_stroke`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `external_shared_documents`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sync_folder_info`");
                if (((RoomDatabase) NotesDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) NotesDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) NotesDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                NotesDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) NotesDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesDatabase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(58);
                map.put("accountType", new TableInfo.Column("accountType", "TEXT", false, 0, null, 1));
                map.put("accountName", new TableInfo.Column("accountName", "TEXT", false, 0, "''", 1));
                map.put("strippedContent", new TableInfo.Column("strippedContent", "BLOB", true, 0, null, 1));
                map.put("serverTimestamp", new TableInfo.Column("serverTimestamp", "INTEGER", false, 0, "1464416139847", 1));
                map.put(DBSchema.Document.CATEGORY_SERVER_TIMESTAMP, new TableInfo.Column(DBSchema.Document.CATEGORY_SERVER_TIMESTAMP, "INTEGER", false, 0, "1464416139847", 1));
                map.put(DBSchema.Document.CATEGORY_IS_DIRTY, new TableInfo.Column(DBSchema.Document.CATEGORY_IS_DIRTY, "INTEGER", true, 0, "1", 1));
                map.put(DBSchema.Document.NOTENAME, new TableInfo.Column(DBSchema.Document.NOTENAME, "TEXT", true, 0, "''", 1));
                map.put(DBSchema.Document.MS_SYNC_ACCOUNT_ID, new TableInfo.Column(DBSchema.Document.MS_SYNC_ACCOUNT_ID, "TEXT", false, 0, null, 1));
                map.put(DBSchema.Document.MS_SYNC_DOCUMENT_UUID, new TableInfo.Column(DBSchema.Document.MS_SYNC_DOCUMENT_UUID, "TEXT", false, 0, null, 1));
                map.put(DBSchema.Document.MS_LAST_SYNC_TIME, new TableInfo.Column(DBSchema.Document.MS_LAST_SYNC_TIME, "INTEGER", true, 0, "0", 1));
                map.put(DBSchema.Document.MATH_MODE, new TableInfo.Column(DBSchema.Document.MATH_MODE, "INTEGER", true, 0, "0", 1));
                map.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 0, null, 1));
                map.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                map.put("isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1));
                map.put("title", new TableInfo.Column("title", "TEXT", true, 0, "''", 1));
                map.put(DBSchema.Document.RECOMMENDED_TITLE, new TableInfo.Column(DBSchema.Document.RECOMMENDED_TITLE, "TEXT", true, 0, "''", 1));
                map.put("content", new TableInfo.Column("content", "BLOB", true, 0, null, 1));
                map.put("displayContent", new TableInfo.Column("displayContent", "BLOB", true, 0, null, 1));
                map.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                map.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, null, 1));
                map.put(DBSchema.Document.VR_UUID, new TableInfo.Column(DBSchema.Document.VR_UUID, "TEXT", false, 0, "''", 1));
                map.put(DBSchema.Document.CONTENT_UUID, new TableInfo.Column(DBSchema.Document.CONTENT_UUID, "TEXT", false, 0, "''", 1));
                map.put("firstContentType", new TableInfo.Column("firstContentType", "INTEGER", false, 0, "0", 1));
                map.put("secondContentType", new TableInfo.Column("secondContentType", "INTEGER", false, 0, "0", 1));
                map.put("strokeUUID", new TableInfo.Column("strokeUUID", "TEXT", false, 0, "''", 1));
                map.put("strokeRatio", new TableInfo.Column("strokeRatio", "REAL", false, 0, "0.0", 1));
                map.put("categoryUUID", new TableInfo.Column("categoryUUID", "TEXT", true, 0, "'uncategorized:///'", 1));
                map.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, null, 1));
                map.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, "0", 1));
                map.put("isLock", new TableInfo.Column("isLock", "INTEGER", true, 0, "0", 1));
                map.put("isSaving", new TableInfo.Column("isSaving", "INTEGER", true, 0, "0", 1));
                map.put("reminderTriggerTime", new TableInfo.Column("reminderTriggerTime", "INTEGER", true, 0, "0", 1));
                map.put("reminderRequestCode", new TableInfo.Column("reminderRequestCode", "INTEGER", true, 0, "0", 1));
                map.put("recycle_bin_time_moved", new TableInfo.Column("recycle_bin_time_moved", "INTEGER", true, 0, "0", 1));
                map.put("contentSecureVersion", new TableInfo.Column("contentSecureVersion", "INTEGER", true, 0, "0", 1));
                map.put("size", new TableInfo.Column("size", "INTEGER", true, 0, "0", 1));
                map.put("displayTitle", new TableInfo.Column("displayTitle", "BLOB", false, 0, null, 1));
                map.put("saveType", new TableInfo.Column("saveType", "INTEGER", true, 0, "0", 1));
                map.put("firstOpendAt", new TableInfo.Column("firstOpendAt", "INTEGER", true, 0, "0", 1));
                map.put("secondOpenedAt", new TableInfo.Column("secondOpenedAt", "INTEGER", true, 0, "0", 1));
                map.put("lastOpenedAt", new TableInfo.Column("lastOpenedAt", "INTEGER", true, 0, "0", 1));
                map.put("importedAt", new TableInfo.Column("importedAt", "INTEGER", true, 0, "0", 1));
                map.put("recommendedAt", new TableInfo.Column("recommendedAt", "INTEGER", true, 0, "0", 1));
                map.put(DBSchema.Document.LAST_MAPPED_AT, new TableInfo.Column(DBSchema.Document.LAST_MAPPED_AT, "INTEGER", true, 0, "0", 1));
                map.put("mdeSpaceId", new TableInfo.Column("mdeSpaceId", "TEXT", true, 0, "''", 1));
                map.put("mdeItemId", new TableInfo.Column("mdeItemId", "TEXT", true, 0, "''", 1));
                map.put("mdeExtra", new TableInfo.Column("mdeExtra", "TEXT", true, 0, "''", 1));
                map.put("mdeGroupId", new TableInfo.Column("mdeGroupId", "TEXT", true, 0, "''", 1));
                map.put("mdeOwnerId", new TableInfo.Column("mdeOwnerId", "TEXT", true, 0, "''", 1));
                map.put("firstHandwritingHeight", new TableInfo.Column("firstHandwritingHeight", "INTEGER", true, 0, "0", 1));
                map.put("deleteRecommended", new TableInfo.Column("deleteRecommended", "INTEGER", true, 0, "0", 1));
                map.put(DBSchema.Document.ABSOLUTE_PATH, new TableInfo.Column(DBSchema.Document.ABSOLUTE_PATH, "TEXT", false, 0, null, 1));
                map.put("backgroundColor", new TableInfo.Column("backgroundColor", "INTEGER", true, 0, "0", 1));
                map.put(DBSchema.Document.BACKGROUND_COLOR_INVERTED, new TableInfo.Column(DBSchema.Document.BACKGROUND_COLOR_INVERTED, "INTEGER", true, 0, "0", 1));
                map.put(DBSchema.Document.LOCK_ACCOUNT_GUID, new TableInfo.Column(DBSchema.Document.LOCK_ACCOUNT_GUID, "TEXT", false, 0, null, 1));
                map.put(DBSchema.Document.CORRUPTED, new TableInfo.Column(DBSchema.Document.CORRUPTED, "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v = AbstractC2821a.m2231v(map, DBSchema.Document.PAGE_MODE, new TableInfo.Column(DBSchema.Document.PAGE_MODE, "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet = new HashSet(5);
                hashSet.add(new TableInfo.Index("index_sdoc_UUID", true, Arrays.asList("UUID"), Arrays.asList("ASC")));
                hashSet.add(new TableInfo.Index("index_sdoc_filePath", false, Arrays.asList("filePath"), Arrays.asList("ASC")));
                hashSet.add(new TableInfo.Index("index_sdoc_isFavorite", false, Arrays.asList("isFavorite"), Arrays.asList("ASC")));
                hashSet.add(new TableInfo.Index("index_sdoc_categoryUUID_isDeleted", false, Arrays.asList("categoryUUID", "isDeleted"), Arrays.asList("ASC", "ASC")));
                hashSet.add(new TableInfo.Index("index_sdoc_importedAt", false, Arrays.asList("importedAt"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("sdoc", map, hashSetM2231v, hashSet);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "sdoc");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sdoc(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesDocumentEntity).\n Expected:\n", tableInfo, "\n Found:\n", tableInfo2));
                }
                HashMap map2 = new HashMap(16);
                map2.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map2.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 0, null, 1));
                map2.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                map2.put("isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1));
                map2.put("accountType", new TableInfo.Column("accountType", "TEXT", false, 0, null, 1));
                map2.put("accountName", new TableInfo.Column("accountName", "TEXT", false, 0, "''", 1));
                map2.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 0, null, 1));
                map2.put("mime_type", new TableInfo.Column("mime_type", "TEXT", true, 0, "'application/octet-stream'", 1));
                map2.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, "''", 1));
                map2.put("srcID", new TableInfo.Column("srcID", "INTEGER", true, 0, null, 1));
                map2.put("data", new TableInfo.Column("data", "BLOB", false, 0, null, 1));
                map2.put("_data", new TableInfo.Column("_data", "TEXT", false, 0, "''", 1));
                map2.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, "''", 1));
                map2.put("contentSecureVersion", new TableInfo.Column("contentSecureVersion", "INTEGER", true, 0, "0", 1));
                map2.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v2 = AbstractC2821a.m2231v(map2, "size", new TableInfo.Column("size", "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_content_UUID", true, Arrays.asList("UUID"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_content_sdocUUID", false, Arrays.asList("sdocUUID"), Arrays.asList("ASC")));
                TableInfo tableInfo3 = new TableInfo("content", map2, hashSetM2231v2, hashSet2);
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "content");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("content(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesContentEntity).\n Expected:\n", tableInfo3, "\n Found:\n", tableInfo4));
                }
                HashMap map3 = new HashMap(13);
                map3.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map3.put(DBSchema.CategoryTree.PARENT_UUID, new TableInfo.Column(DBSchema.CategoryTree.PARENT_UUID, "TEXT", false, 0, null, 1));
                map3.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                map3.put("isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1));
                map3.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                map3.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, null, 1));
                map3.put("serverTimestamp", new TableInfo.Column("serverTimestamp", "INTEGER", false, 0, "1464416139847", 1));
                map3.put("recycle_bin_time_moved", new TableInfo.Column("recycle_bin_time_moved", "INTEGER", true, 0, "0", 1));
                map3.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, 1));
                map3.put("path", new TableInfo.Column("path", "TEXT", false, 0, null, 1));
                map3.put("orderBy", new TableInfo.Column("orderBy", "INTEGER", false, 0, null, 1));
                map3.put("displayNameColor", new TableInfo.Column("displayNameColor", "INTEGER", true, 0, "-1", 1));
                TableInfo tableInfo5 = new TableInfo(DBSchema.CategoryTree.TABLE_NAME, map3, AbstractC2821a.m2231v(map3, DBSchema.CategoryTree.IS_SYNC_WITH_MS, new TableInfo.Column(DBSchema.CategoryTree.IS_SYNC_WITH_MS, "INTEGER", true, 0, "0", 1), 0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, DBSchema.CategoryTree.TABLE_NAME);
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("category_tree(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesCategoryTreeEntity).\n Expected:\n", tableInfo5, "\n Found:\n", tableInfo6));
                }
                HashMap map4 = new HashMap(3);
                map4.put(DBSchema.CategoryTreeClosure.ANCESTOR, new TableInfo.Column(DBSchema.CategoryTreeClosure.ANCESTOR, "TEXT", true, 1, "''", 1));
                map4.put(DBSchema.CategoryTreeClosure.DESCENDANT, new TableInfo.Column(DBSchema.CategoryTreeClosure.DESCENDANT, "TEXT", true, 2, "''", 1));
                HashSet hashSetM2231v3 = AbstractC2821a.m2231v(map4, DBSchema.CategoryTreeClosure.DEPTH, new TableInfo.Column(DBSchema.CategoryTreeClosure.DEPTH, "INTEGER", true, 0, "0", 1), 2);
                hashSetM2231v3.add(new TableInfo.ForeignKey(DBSchema.CategoryTree.TABLE_NAME, "CASCADE", "CASCADE", Arrays.asList(DBSchema.CategoryTreeClosure.ANCESTOR), Arrays.asList("UUID")));
                hashSetM2231v3.add(new TableInfo.ForeignKey(DBSchema.CategoryTree.TABLE_NAME, "CASCADE", "CASCADE", Arrays.asList(DBSchema.CategoryTreeClosure.DESCENDANT), Arrays.asList("UUID")));
                TableInfo tableInfo7 = new TableInfo(DBSchema.CategoryTreeClosure.TABLE_NAME, map4, hashSetM2231v3, new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, DBSchema.CategoryTreeClosure.TABLE_NAME);
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("category_tree_closure(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity).\n Expected:\n", tableInfo7, "\n Found:\n", tableInfo8));
                }
                HashMap map5 = new HashMap(18);
                map5.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map5.put("serverId", new TableInfo.Column("serverId", "TEXT", false, 0, null, 1));
                map5.put(SyncDBSchema.SyncInfo.CLIENT_ID, new TableInfo.Column(SyncDBSchema.SyncInfo.CLIENT_ID, "TEXT", true, 0, null, 1));
                map5.put(SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME, new TableInfo.Column(SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME, "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.IS_DIRTY_FOLDER, new TableInfo.Column(SyncDBSchema.SyncInfo.IS_DIRTY_FOLDER, "INTEGER", true, 0, "1", 1));
                map5.put(SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME_FOLDER, new TableInfo.Column(SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME_FOLDER, "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.LAST_MODIFIED_TIME_FOLDER, new TableInfo.Column(SyncDBSchema.SyncInfo.LAST_MODIFIED_TIME_FOLDER, "INTEGER", true, 0, "0", 1));
                map5.put("isSyncFailed", new TableInfo.Column("isSyncFailed", "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.IS_EXTRA_INFO_DIRTY, new TableInfo.Column(SyncDBSchema.SyncInfo.IS_EXTRA_INFO_DIRTY, "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.COMMIT_ID, new TableInfo.Column(SyncDBSchema.SyncInfo.COMMIT_ID, "TEXT", false, 0, null, 1));
                map5.put("deviceName", new TableInfo.Column("deviceName", "TEXT", false, 0, null, 1));
                map5.put("conflict", new TableInfo.Column("conflict", "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.CONFLICT_STRATEGY, new TableInfo.Column(SyncDBSchema.SyncInfo.CONFLICT_STRATEGY, "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.COEDIT_RESOURCE_ID, new TableInfo.Column(SyncDBSchema.SyncInfo.COEDIT_RESOURCE_ID, "TEXT", false, 0, null, 1));
                map5.put(SyncDBSchema.SyncInfo.COEDIT_CHECKPOINT, new TableInfo.Column(SyncDBSchema.SyncInfo.COEDIT_CHECKPOINT, "INTEGER", true, 0, "-1", 1));
                map5.put(SyncDBSchema.SyncInfo.SYNC_STATE, new TableInfo.Column(SyncDBSchema.SyncInfo.SYNC_STATE, "INTEGER", true, 0, "0", 1));
                map5.put(SyncDBSchema.SyncInfo.STROKE_GROUPED, new TableInfo.Column(SyncDBSchema.SyncInfo.STROKE_GROUPED, "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v4 = AbstractC2821a.m2231v(map5, "deletedBy", new TableInfo.Column("deletedBy", "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.Index("index_sync_info_clientId", true, Arrays.asList(SyncDBSchema.SyncInfo.CLIENT_ID), Arrays.asList("ASC")));
                TableInfo tableInfo9 = new TableInfo(SyncDBSchema.SyncInfo.TABLE_NAME, map5, hashSetM2231v4, hashSet3);
                TableInfo tableInfo10 = TableInfo.read(supportSQLiteDatabase, SyncDBSchema.SyncInfo.TABLE_NAME);
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sync_info(com.samsung.android.support.senl.nt.data.database.core.sync.entity.SyncInfoEntity).\n Expected:\n", tableInfo9, "\n Found:\n", tableInfo10));
                }
                HashMap map6 = new HashMap(4);
                map6.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map6.put(DBSchema.TagList.NORMALIZE_NAME, new TableInfo.Column(DBSchema.TagList.NORMALIZE_NAME, "TEXT", true, 0, null, 1));
                map6.put("docUUID", new TableInfo.Column("docUUID", "TEXT", true, 0, null, 1));
                HashSet hashSetM2231v5 = AbstractC2821a.m2231v(map6, "displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, 1), 0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_tag_list_normalizeName", false, Arrays.asList(DBSchema.TagList.NORMALIZE_NAME), Arrays.asList("ASC")));
                TableInfo tableInfo11 = new TableInfo("tag_list", map6, hashSetM2231v5, hashSet4);
                TableInfo tableInfo12 = TableInfo.read(supportSQLiteDatabase, "tag_list");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("tag_list(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesTagEntity).\n Expected:\n", tableInfo11, "\n Found:\n", tableInfo12));
                }
                HashMap map7 = new HashMap(7);
                map7.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map7.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 0, null, 1));
                map7.put("strokeFilePath", new TableInfo.Column("strokeFilePath", "TEXT", true, 0, null, 1));
                map7.put("state", new TableInfo.Column("state", "INTEGER", true, 0, "0", 1));
                map7.put("recognitionCount", new TableInfo.Column("recognitionCount", "INTEGER", true, 0, "0", 1));
                map7.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, null, 1));
                HashSet hashSetM2231v6 = AbstractC2821a.m2231v(map7, "version", new TableInfo.Column("version", "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.Index("index_retry_state", false, Arrays.asList("state"), Arrays.asList("ASC")));
                TableInfo tableInfo13 = new TableInfo("retry", map7, hashSetM2231v6, hashSet5);
                TableInfo tableInfo14 = TableInfo.read(supportSQLiteDatabase, "retry");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("retry(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesRetryEntity).\n Expected:\n", tableInfo13, "\n Found:\n", tableInfo14));
                }
                HashMap map8 = new HashMap(14);
                map8.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map8.put(DBSchema.StrokeSearch.HAS_VISUALCUE, new TableInfo.Column(DBSchema.StrokeSearch.HAS_VISUALCUE, "INTEGER", false, 0, "0", 1));
                map8.put("text", new TableInfo.Column("text", "TEXT", false, 0, "''", 1));
                map8.put("left", new TableInfo.Column("left", "INTEGER", false, 0, "0", 1));
                map8.put("top", new TableInfo.Column("top", "INTEGER", false, 0, "0", 1));
                map8.put("right", new TableInfo.Column("right", "INTEGER", false, 0, "0", 1));
                map8.put("bottom", new TableInfo.Column("bottom", "INTEGER", false, 0, "0", 1));
                map8.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, null, 1));
                map8.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 0, null, 1));
                map8.put("pageWidth", new TableInfo.Column("pageWidth", "INTEGER", false, 0, "0", 1));
                map8.put("type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1));
                map8.put("pageUuid", new TableInfo.Column("pageUuid", "TEXT", false, 0, "''", 1));
                map8.put("actionLinkData", new TableInfo.Column("actionLinkData", "TEXT", false, 0, "''", 1));
                HashSet hashSetM2231v7 = AbstractC2821a.m2231v(map8, "recognizerDBVersion", new TableInfo.Column("recognizerDBVersion", "TEXT", true, 0, "'0'", 1), 0);
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_stroke_sdocUUID_type", false, Arrays.asList("sdocUUID", "type"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo15 = new TableInfo("stroke", map8, hashSetM2231v7, hashSet6);
                TableInfo tableInfo16 = TableInfo.read(supportSQLiteDatabase, "stroke");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("stroke(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesStrokeSearchEntity).\n Expected:\n", tableInfo15, "\n Found:\n", tableInfo16));
                }
                HashMap map9 = new HashMap(12);
                map9.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map9.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0, null, 1));
                map9.put("_data", new TableInfo.Column("_data", "TEXT", false, 0, null, 1));
                map9.put("_size", new TableInfo.Column("_size", "INTEGER", true, 0, "0", 1));
                map9.put("_display_name", new TableInfo.Column("_display_name", "TEXT", false, 0, "''", 1));
                map9.put("title", new TableInfo.Column("title", "TEXT", false, 0, "''", 1));
                map9.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, "0", 1));
                map9.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1));
                map9.put("mime_type", new TableInfo.Column("mime_type", "TEXT", false, 0, null, 1));
                map9.put("width", new TableInfo.Column("width", "INTEGER", true, 0, "0", 1));
                map9.put("height", new TableInfo.Column("height", "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v8 = AbstractC2821a.m2231v(map9, "type", new TableInfo.Column("type", "INTEGER", true, 0, "3", 1), 0);
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.Index("index_document_template_UUID", true, Arrays.asList("UUID"), Arrays.asList("ASC")));
                TableInfo tableInfo17 = new TableInfo(DBSchema.DocumentTemplate.TABLE_NAME, map9, hashSetM2231v8, hashSet7);
                TableInfo tableInfo18 = TableInfo.read(supportSQLiteDatabase, DBSchema.DocumentTemplate.TABLE_NAME);
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_template(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesTemplateEntity).\n Expected:\n", tableInfo17, "\n Found:\n", tableInfo18));
                }
                HashMap map10 = new HashMap(5);
                map10.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map10.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 0, "''", 1));
                map10.put(DBSchema.MappedDocument.MAPPED_UUID, new TableInfo.Column(DBSchema.MappedDocument.MAPPED_UUID, "TEXT", true, 0, "''", 1));
                map10.put("converted", new TableInfo.Column("converted", "INTEGER", true, 0, "1", 1));
                HashSet hashSetM2231v9 = AbstractC2821a.m2231v(map10, DBSchema.MappedDocument.MAPPED_AT, new TableInfo.Column(DBSchema.MappedDocument.MAPPED_AT, "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_mapped_document_mappedUUID", true, Arrays.asList(DBSchema.MappedDocument.MAPPED_UUID), Arrays.asList("ASC")));
                TableInfo tableInfo19 = new TableInfo(DBSchema.MappedDocument.TABLE_NAME, map10, hashSetM2231v9, hashSet8);
                TableInfo tableInfo20 = TableInfo.read(supportSQLiteDatabase, DBSchema.MappedDocument.TABLE_NAME);
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("mapped_document(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesMappedDocumentEntity).\n Expected:\n", tableInfo19, "\n Found:\n", tableInfo20));
                }
                HashMap map11 = new HashMap(7);
                map11.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map11.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 0, "''", 1));
                map11.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 0, "''", 1));
                map11.put("index", new TableInfo.Column("index", "INTEGER", true, 0, null, 1));
                map11.put(DBSchema.DocumentPage.FAVORITE, new TableInfo.Column(DBSchema.DocumentPage.FAVORITE, "INTEGER", true, 0, null, 1));
                map11.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v10 = AbstractC2821a.m2231v(map11, "isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1), 0);
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_document_page_documentUUID_UUID", true, Arrays.asList("documentUUID", "UUID"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo21 = new TableInfo(DBSchema.DocumentPage.TABLE_NAME, map11, hashSetM2231v10, hashSet9);
                TableInfo tableInfo22 = TableInfo.read(supportSQLiteDatabase, DBSchema.DocumentPage.TABLE_NAME);
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_page(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesDocumentPageEntity).\n Expected:\n", tableInfo21, "\n Found:\n", tableInfo22));
                }
                HashMap map12 = new HashMap(8);
                map12.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map12.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map12.put("extraInfo", new TableInfo.Column("extraInfo", "TEXT", true, 0, "''", 1));
                map12.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, null, 1));
                map12.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                map12.put("isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1));
                map12.put("serverTimestamp", new TableInfo.Column("serverTimestamp", "INTEGER", false, 0, "1464416139847", 1));
                TableInfo tableInfo23 = new TableInfo(OldDBSchema.HashTag.TABLE_NAME, map12, AbstractC2821a.m2231v(map12, "UUID", new TableInfo.Column("UUID", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                TableInfo tableInfo24 = TableInfo.read(supportSQLiteDatabase, OldDBSchema.HashTag.TABLE_NAME);
                if (!tableInfo23.equals(tableInfo24)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("hashtag(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesHashtagEntity).\n Expected:\n", tableInfo23, "\n Found:\n", tableInfo24));
                }
                HashMap map13 = new HashMap(9);
                map13.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map13.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 0, null, 1));
                map13.put("extraInfo", new TableInfo.Column("extraInfo", "TEXT", true, 0, "''", 1));
                map13.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, "0", 1));
                map13.put("isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "1", 1));
                map13.put("serverTimestamp", new TableInfo.Column("serverTimestamp", "INTEGER", false, 0, "1464416139847", 1));
                map13.put("isSyncFailed", new TableInfo.Column("isSyncFailed", "INTEGER", false, 0, "0", 1));
                map13.put(OldDBSchema.HashTagContent.HASHTAG_UUID, new TableInfo.Column(OldDBSchema.HashTagContent.HASHTAG_UUID, "TEXT", true, 0, null, 1));
                TableInfo tableInfo25 = new TableInfo(OldDBSchema.HashTagContent.TABLE_NAME, map13, AbstractC2821a.m2231v(map13, "lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, null, 1), 0), new HashSet(0));
                TableInfo tableInfo26 = TableInfo.read(supportSQLiteDatabase, OldDBSchema.HashTagContent.TABLE_NAME);
                if (!tableInfo25.equals(tableInfo26)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("hashtagContent(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesHashtagContentEntity).\n Expected:\n", tableInfo25, "\n Found:\n", tableInfo26));
                }
                HashMap map14 = new HashMap(3);
                map14.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 1, null, 1));
                map14.put("strippedContent", new TableInfo.Column("strippedContent", "BLOB", true, 0, null, 1));
                HashSet hashSetM2231v11 = AbstractC2821a.m2231v(map14, "filePath", new TableInfo.Column("filePath", "TEXT", true, 0, null, 1), 1);
                hashSetM2231v11.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "CASCADE", Arrays.asList("sdocUUID"), Arrays.asList("UUID")));
                TableInfo tableInfo27 = new TableInfo(DBSchema.TextSearch.TABLE_NAME, map14, hashSetM2231v11, new HashSet(0));
                TableInfo tableInfo28 = TableInfo.read(supportSQLiteDatabase, DBSchema.TextSearch.TABLE_NAME);
                if (!tableInfo27.equals(tableInfo28)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("text_search(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesDocumentTextSearchEntity).\n Expected:\n", tableInfo27, "\n Found:\n", tableInfo28));
                }
                HashMap map15 = new HashMap(5);
                map15.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map15.put(DBSchema.DocumentThumbnail.BACKGROUND_TYPE, new TableInfo.Column(DBSchema.DocumentThumbnail.BACKGROUND_TYPE, "INTEGER", true, 0, "0", 1));
                map15.put(DBSchema.DocumentThumbnail.LAYOUT, new TableInfo.Column(DBSchema.DocumentThumbnail.LAYOUT, "INTEGER", true, 0, "0", 1));
                map15.put(DBSchema.DocumentThumbnail.IMAGE_PATH, new TableInfo.Column(DBSchema.DocumentThumbnail.IMAGE_PATH, "TEXT", true, 0, "''", 1));
                HashSet hashSetM2231v12 = AbstractC2821a.m2231v(map15, DBSchema.DocumentThumbnail.PLAY_TIME, new TableInfo.Column(DBSchema.DocumentThumbnail.PLAY_TIME, "TEXT", true, 0, "''", 1), 1);
                hashSetM2231v12.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("UUID"), Arrays.asList("UUID")));
                TableInfo tableInfo29 = new TableInfo(DBSchema.DocumentThumbnail.TABLE_NAME, map15, hashSetM2231v12, new HashSet(0));
                TableInfo tableInfo30 = TableInfo.read(supportSQLiteDatabase, DBSchema.DocumentThumbnail.TABLE_NAME);
                if (!tableInfo29.equals(tableInfo30)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_thumbnail(com.samsung.android.support.senl.nt.data.database.core.document.entity.DocumentThumbnailEntity).\n Expected:\n", tableInfo29, "\n Found:\n", tableInfo30));
                }
                HashMap map16 = new HashMap(8);
                map16.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map16.put("sdocUUID", new TableInfo.Column("sdocUUID", "TEXT", true, 0, "''", 1));
                map16.put("pageUuid", new TableInfo.Column("pageUuid", "TEXT", true, 0, "''", 1));
                map16.put(DBSchema.PageSearchInfo.PAGE_CONTENT_SOURCE, new TableInfo.Column(DBSchema.PageSearchInfo.PAGE_CONTENT_SOURCE, "INTEGER", true, 0, "0", 1));
                map16.put(DBSchema.PageSearchInfo.SEARCH_SOURCE, new TableInfo.Column(DBSchema.PageSearchInfo.SEARCH_SOURCE, "INTEGER", true, 0, "0", 1));
                map16.put(DBSchema.PageSearchInfo.LAST_CONTENT_MODIFIED_AT, new TableInfo.Column(DBSchema.PageSearchInfo.LAST_CONTENT_MODIFIED_AT, "INTEGER", true, 0, "0", 1));
                map16.put(DBSchema.PageSearchInfo.LAST_SEARCH_MODIFIED_AT, new TableInfo.Column(DBSchema.PageSearchInfo.LAST_SEARCH_MODIFIED_AT, "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v13 = AbstractC2821a.m2231v(map16, "isDirty", new TableInfo.Column("isDirty", "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_page_search_info_sdocUUID", false, Arrays.asList("sdocUUID"), Arrays.asList("ASC")));
                TableInfo tableInfo31 = new TableInfo(DBSchema.PageSearchInfo.TABLE_NAME, map16, hashSetM2231v13, hashSet10);
                TableInfo tableInfo32 = TableInfo.read(supportSQLiteDatabase, DBSchema.PageSearchInfo.TABLE_NAME);
                if (!tableInfo31.equals(tableInfo32)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("page_search_info(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesPageSearchInfoEntity).\n Expected:\n", tableInfo31, "\n Found:\n", tableInfo32));
                }
                HashMap map17 = new HashMap(5);
                map17.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map17.put("path", new TableInfo.Column("path", "TEXT", true, 0, "''", 1));
                map17.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, "0", 1));
                map17.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo33 = new TableInfo(DBSchema.CoverTemplate.TABLE_NAME, map17, AbstractC2821a.m2231v(map17, "type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1), 0), new HashSet(0));
                TableInfo tableInfo34 = TableInfo.read(supportSQLiteDatabase, DBSchema.CoverTemplate.TABLE_NAME);
                if (!tableInfo33.equals(tableInfo34)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("cover_template(com.samsung.android.support.senl.nt.data.database.core.document.entity.CoverTemplateEntity).\n Expected:\n", tableInfo33, "\n Found:\n", tableInfo34));
                }
                HashMap map18 = new HashMap(5);
                map18.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map18.put("name", new TableInfo.Column("name", "TEXT", true, 0, "''", 1));
                map18.put(DBSchema.CoverSticker.ICON_PATH, new TableInfo.Column(DBSchema.CoverSticker.ICON_PATH, "TEXT", true, 0, "''", 1));
                map18.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo35 = new TableInfo(DBSchema.CoverSticker.TABLE_NAME, map18, AbstractC2821a.m2231v(map18, "lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1), 0), new HashSet(0));
                TableInfo tableInfo36 = TableInfo.read(supportSQLiteDatabase, DBSchema.CoverSticker.TABLE_NAME);
                if (!tableInfo35.equals(tableInfo36)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("cover_category(com.samsung.android.support.senl.nt.data.database.core.document.entity.CoverStickerEntity).\n Expected:\n", tableInfo35, "\n Found:\n", tableInfo36));
                }
                HashMap map19 = new HashMap(2);
                map19.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 1, null, 1));
                HashSet hashSetM2231v14 = AbstractC2821a.m2231v(map19, "state", new TableInfo.Column("state", "INTEGER", true, 0, "0", 1), 1);
                hashSetM2231v14.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("documentUUID"), Arrays.asList("UUID")));
                TableInfo tableInfo37 = new TableInfo("suggested_cover", map19, hashSetM2231v14, new HashSet(0));
                TableInfo tableInfo38 = TableInfo.read(supportSQLiteDatabase, "suggested_cover");
                if (!tableInfo37.equals(tableInfo38)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("suggested_cover(com.samsung.android.support.senl.nt.data.database.core.document.entity.SuggestedCoverEntity).\n Expected:\n", tableInfo37, "\n Found:\n", tableInfo38));
                }
                HashMap map20 = new HashMap(11);
                map20.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 1, null, 1));
                map20.put(DBSchema.DocumentCover.TEMPLATE_UUID, new TableInfo.Column(DBSchema.DocumentCover.TEMPLATE_UUID, "TEXT", true, 0, "'DEFAULT:///'", 1));
                map20.put("title", new TableInfo.Column("title", "TEXT", true, 0, "''", 1));
                map20.put(DBSchema.DocumentCover.TITLE_ALIGNMENT, new TableInfo.Column(DBSchema.DocumentCover.TITLE_ALIGNMENT, "INTEGER", true, 0, "0", 1));
                map20.put(DBSchema.DocumentCover.SUMMARY, new TableInfo.Column(DBSchema.DocumentCover.SUMMARY, "TEXT", true, 0, "''", 1));
                map20.put(DBSchema.DocumentCover.SUMMARY_ALIGNMENT, new TableInfo.Column(DBSchema.DocumentCover.SUMMARY_ALIGNMENT, "INTEGER", true, 0, "0", 1));
                map20.put("categoryUUID", new TableInfo.Column("categoryUUID", "TEXT", true, 0, "'NONE:///'", 1));
                map20.put("backgroundColor", new TableInfo.Column("backgroundColor", "TEXT", true, 0, "'DEFAULT:///'", 1));
                map20.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, "0", 1));
                map20.put("lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v15 = AbstractC2821a.m2231v(map20, "isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, "1", 1), 3);
                hashSetM2231v15.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("documentUUID"), Arrays.asList("UUID")));
                hashSetM2231v15.add(new TableInfo.ForeignKey(DBSchema.CoverTemplate.TABLE_NAME, "SET DEFAULT", "NO ACTION", Arrays.asList(DBSchema.DocumentCover.TEMPLATE_UUID), Arrays.asList("UUID")));
                hashSetM2231v15.add(new TableInfo.ForeignKey(DBSchema.CoverSticker.TABLE_NAME, "SET DEFAULT", "NO ACTION", Arrays.asList("categoryUUID"), Arrays.asList("UUID")));
                TableInfo tableInfo39 = new TableInfo("document_cover", map20, hashSetM2231v15, new HashSet(0));
                TableInfo tableInfo40 = TableInfo.read(supportSQLiteDatabase, "document_cover");
                if (!tableInfo39.equals(tableInfo40)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_cover(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesDocumentCoverEntity).\n Expected:\n", tableInfo39, "\n Found:\n", tableInfo40));
                }
                HashMap map21 = new HashMap(5);
                map21.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 1, null, 1));
                map21.put("contents", new TableInfo.Column("contents", "TEXT", true, 0, "''", 1));
                map21.put(DBSchema.OrganizedDocument.RECOGNIZED_LANGUAGE, new TableInfo.Column(DBSchema.OrganizedDocument.RECOGNIZED_LANGUAGE, "TEXT", true, 0, "''", 1));
                map21.put("recognizerDBVersion", new TableInfo.Column("recognizerDBVersion", "TEXT", true, 0, "'0'", 1));
                HashSet hashSetM2231v16 = AbstractC2821a.m2231v(map21, "modified_time", new TableInfo.Column("modified_time", "INTEGER", true, 0, null, 1), 1);
                hashSetM2231v16.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("documentUUID"), Arrays.asList("UUID")));
                TableInfo tableInfo41 = new TableInfo(DBSchema.OrganizedDocument.TABLE_NAME, map21, hashSetM2231v16, new HashSet(0));
                TableInfo tableInfo42 = TableInfo.read(supportSQLiteDatabase, DBSchema.OrganizedDocument.TABLE_NAME);
                if (!tableInfo41.equals(tableInfo42)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("organized_document(com.samsung.android.support.senl.nt.data.database.core.document.entity.NotesOrganizedDocumentEntity).\n Expected:\n", tableInfo41, "\n Found:\n", tableInfo42));
                }
                HashMap map22 = new HashMap(7);
                map22.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map22.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 0, "''", 1));
                map22.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, "''", 1));
                map22.put("type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1));
                map22.put("index", new TableInfo.Column("index", "INTEGER", true, 0, "0", 1));
                map22.put("content", new TableInfo.Column("content", "TEXT", true, 0, "''", 1));
                HashSet hashSetM2231v17 = AbstractC2821a.m2231v(map22, "lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1), 1);
                hashSetM2231v17.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("documentUUID"), Arrays.asList("UUID")));
                HashSet hashSet11 = new HashSet(1);
                hashSet11.add(new TableInfo.Index("index_stt_content_documentUUID_filePath_type", false, Arrays.asList("documentUUID", "filePath", "type"), Arrays.asList("ASC", "ASC", "ASC")));
                TableInfo tableInfo43 = new TableInfo(DBSchema.SttContent.TABLE_NAME, map22, hashSetM2231v17, hashSet11);
                TableInfo tableInfo44 = TableInfo.read(supportSQLiteDatabase, DBSchema.SttContent.TABLE_NAME);
                if (!tableInfo43.equals(tableInfo44)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("stt_content(com.samsung.android.support.senl.nt.data.database.core.document.entity.SttContentEntity).\n Expected:\n", tableInfo43, "\n Found:\n", tableInfo44));
                }
                HashMap map23 = new HashMap(2);
                map23.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                HashSet hashSetM2231v18 = AbstractC2821a.m2231v(map23, DBSchema.DocumentTempData.TEMP_DATA, new TableInfo.Column(DBSchema.DocumentTempData.TEMP_DATA, "TEXT", true, 0, "''", 1), 1);
                hashSetM2231v18.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("UUID"), Arrays.asList("UUID")));
                TableInfo tableInfo45 = new TableInfo(DBSchema.DocumentTempData.TABLE_NAME, map23, hashSetM2231v18, new HashSet(0));
                TableInfo tableInfo46 = TableInfo.read(supportSQLiteDatabase, DBSchema.DocumentTempData.TABLE_NAME);
                if (!tableInfo45.equals(tableInfo46)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_temp_data(com.samsung.android.support.senl.nt.data.database.core.document.entity.DocumentTempDataEntity).\n Expected:\n", tableInfo45, "\n Found:\n", tableInfo46));
                }
                HashMap map24 = new HashMap(8);
                map24.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map24.put("serverId", new TableInfo.Column("serverId", "TEXT", true, 0, "''", 1));
                map24.put("appVersion", new TableInfo.Column("appVersion", "TEXT", true, 0, "''", 1));
                map24.put("reason", new TableInfo.Column("reason", "INTEGER", true, 0, "0", 1));
                map24.put(SyncDBSchema.SyncDelayInfo.RETRY_COUNT, new TableInfo.Column(SyncDBSchema.SyncDelayInfo.RETRY_COUNT, "INTEGER", true, 0, "0", 1));
                map24.put("serverTimestamp", new TableInfo.Column("serverTimestamp", "INTEGER", true, 0, "1464416139847", 1));
                map24.put(SyncDBSchema.SyncDelayInfo.UP_SYNC, new TableInfo.Column(SyncDBSchema.SyncDelayInfo.UP_SYNC, "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo47 = new TableInfo(SyncDBSchema.SyncDelayInfo.TABLE_NAME, map24, AbstractC2821a.m2231v(map24, "extra", new TableInfo.Column("extra", "TEXT", true, 0, "''", 1), 0), new HashSet(0));
                TableInfo tableInfo48 = TableInfo.read(supportSQLiteDatabase, SyncDBSchema.SyncDelayInfo.TABLE_NAME);
                if (!tableInfo47.equals(tableInfo48)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sync_delay_info(com.samsung.android.support.senl.nt.data.database.core.sync.entity.SyncDelayInfoEntity).\n Expected:\n", tableInfo47, "\n Found:\n", tableInfo48));
                }
                HashMap map25 = new HashMap(7);
                map25.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                map25.put(DBSchema.DocumentExtra.HAS_STICKY, new TableInfo.Column(DBSchema.DocumentExtra.HAS_STICKY, "INTEGER", true, 0, "0", 1));
                map25.put("hasImage", new TableInfo.Column("hasImage", "INTEGER", true, 0, "0", 1));
                map25.put("hasStroke", new TableInfo.Column("hasStroke", "INTEGER", true, 0, "0", 1));
                map25.put("hasPdf", new TableInfo.Column("hasPdf", "INTEGER", true, 0, "0", 1));
                map25.put(DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION, new TableInfo.Column(DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION, "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v19 = AbstractC2821a.m2231v(map25, DBSchema.DocumentExtra.FORMAT_VERSION, new TableInfo.Column(DBSchema.DocumentExtra.FORMAT_VERSION, "INTEGER", true, 0, "0", 1), 1);
                hashSetM2231v19.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("UUID"), Arrays.asList("UUID")));
                TableInfo tableInfo49 = new TableInfo(DBSchema.DocumentExtra.TABLE_NAME, map25, hashSetM2231v19, new HashSet(0));
                TableInfo tableInfo50 = TableInfo.read(supportSQLiteDatabase, DBSchema.DocumentExtra.TABLE_NAME);
                if (!tableInfo49.equals(tableInfo50)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("document_extra(com.samsung.android.support.senl.nt.data.database.core.document.entity.DocumentExtraEntity).\n Expected:\n", tableInfo49, "\n Found:\n", tableInfo50));
                }
                HashMap map26 = new HashMap(7);
                map26.put("objectId", new TableInfo.Column("objectId", "TEXT", true, 1, null, 1));
                map26.put("documentUUID", new TableInfo.Column("documentUUID", "TEXT", true, 0, "''", 1));
                map26.put("pageUuid", new TableInfo.Column("pageUuid", "TEXT", true, 0, "''", 1));
                map26.put("width", new TableInfo.Column("width", "INTEGER", true, 0, "0", 1));
                map26.put("height", new TableInfo.Column("height", "INTEGER", true, 0, "0", 1));
                map26.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, "''", 1));
                HashSet hashSetM2231v20 = AbstractC2821a.m2231v(map26, "lastModifiedAt", new TableInfo.Column("lastModifiedAt", "INTEGER", true, 0, "0", 1), 1);
                hashSetM2231v20.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("documentUUID"), Arrays.asList("UUID")));
                TableInfo tableInfo51 = new TableInfo(DBSchema.Sticky.TABLE_NAME, map26, hashSetM2231v20, new HashSet(0));
                TableInfo tableInfo52 = TableInfo.read(supportSQLiteDatabase, DBSchema.Sticky.TABLE_NAME);
                if (!tableInfo51.equals(tableInfo52)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sticky(com.samsung.android.support.senl.nt.data.database.core.document.entity.StickyNoteEntity).\n Expected:\n", tableInfo51, "\n Found:\n", tableInfo52));
                }
                HashMap map27 = new HashMap(2);
                map27.put("objectId", new TableInfo.Column("objectId", "TEXT", true, 1, null, 1));
                HashSet hashSetM2231v21 = AbstractC2821a.m2231v(map27, "text", new TableInfo.Column("text", "TEXT", true, 0, "''", 1), 1);
                hashSetM2231v21.add(new TableInfo.ForeignKey(DBSchema.Sticky.TABLE_NAME, "CASCADE", "NO ACTION", Arrays.asList("objectId"), Arrays.asList("objectId")));
                TableInfo tableInfo53 = new TableInfo(DBSchema.StickyText.TABLE_NAME, map27, hashSetM2231v21, new HashSet(0));
                TableInfo tableInfo54 = TableInfo.read(supportSQLiteDatabase, DBSchema.StickyText.TABLE_NAME);
                if (!tableInfo53.equals(tableInfo54)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sticky_text(com.samsung.android.support.senl.nt.data.database.core.document.entity.StickyTextEntity).\n Expected:\n", tableInfo53, "\n Found:\n", tableInfo54));
                }
                HashMap map28 = new HashMap(10);
                map28.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map28.put("objectId", new TableInfo.Column("objectId", "TEXT", true, 0, "''", 1));
                map28.put("text", new TableInfo.Column("text", "TEXT", true, 0, "''", 1));
                map28.put("left", new TableInfo.Column("left", "INTEGER", true, 0, "0", 1));
                map28.put("top", new TableInfo.Column("top", "INTEGER", true, 0, "0", 1));
                map28.put("right", new TableInfo.Column("right", "INTEGER", true, 0, "0", 1));
                map28.put("bottom", new TableInfo.Column("bottom", "INTEGER", true, 0, "0", 1));
                map28.put("pageWidth", new TableInfo.Column("pageWidth", "INTEGER", true, 0, "0", 1));
                map28.put("type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1));
                HashSet hashSetM2231v22 = AbstractC2821a.m2231v(map28, "actionLinkData", new TableInfo.Column("actionLinkData", "TEXT", true, 0, "''", 1), 1);
                hashSetM2231v22.add(new TableInfo.ForeignKey(DBSchema.Sticky.TABLE_NAME, "CASCADE", "NO ACTION", Arrays.asList("objectId"), Arrays.asList("objectId")));
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_sticky_stroke_objectId", false, Arrays.asList("objectId"), Arrays.asList("ASC")));
                TableInfo tableInfo55 = new TableInfo(DBSchema.StickyStroke.TABLE_NAME, map28, hashSetM2231v22, hashSet12);
                TableInfo tableInfo56 = TableInfo.read(supportSQLiteDatabase, DBSchema.StickyStroke.TABLE_NAME);
                if (!tableInfo55.equals(tableInfo56)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sticky_stroke(com.samsung.android.support.senl.nt.data.database.core.document.entity.StickyStrokeSearchEntity).\n Expected:\n", tableInfo55, "\n Found:\n", tableInfo56));
                }
                HashMap map29 = new HashMap(2);
                map29.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                HashSet hashSetM2231v23 = AbstractC2821a.m2231v(map29, "timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, "0", 1), 1);
                hashSetM2231v23.add(new TableInfo.ForeignKey("sdoc", "CASCADE", "NO ACTION", Arrays.asList("UUID"), Arrays.asList("UUID")));
                TableInfo tableInfo57 = new TableInfo(DBSchema.ExternalSharedDocument.TABLE_NAME, map29, hashSetM2231v23, new HashSet(0));
                TableInfo tableInfo58 = TableInfo.read(supportSQLiteDatabase, DBSchema.ExternalSharedDocument.TABLE_NAME);
                if (!tableInfo57.equals(tableInfo58)) {
                    return new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("external_shared_documents(com.samsung.android.support.senl.nt.data.database.core.document.entity.ExternalSharedDocumentEntity).\n Expected:\n", tableInfo57, "\n Found:\n", tableInfo58));
                }
                HashMap map30 = new HashMap(2);
                map30.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 1, null, 1));
                TableInfo tableInfo59 = new TableInfo(SyncDBSchema.SyncFolderInfo.TABLE_NAME, map30, AbstractC2821a.m2231v(map30, "deletedBy", new TableInfo.Column("deletedBy", "INTEGER", true, 0, "0", 1), 0), new HashSet(0));
                TableInfo tableInfo60 = TableInfo.read(supportSQLiteDatabase, SyncDBSchema.SyncFolderInfo.TABLE_NAME);
                return !tableInfo59.equals(tableInfo60) ? new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("sync_folder_info(com.samsung.android.support.senl.nt.data.database.core.sync.entity.SyncFolderInfoEntity).\n Expected:\n", tableInfo59, "\n Found:\n", tableInfo60)) : new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "b15c28e7f3a125e093837742c7dab1a0", "c39ab3e8781a71d248042aec4c2ee877")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesCategoryTreeClosureDao getCategoryTreeClosureDao() {
        NotesCategoryTreeClosureDao notesCategoryTreeClosureDao;
        if (this._notesCategoryTreeClosureDao != null) {
            return this._notesCategoryTreeClosureDao;
        }
        synchronized (this) {
            try {
                if (this._notesCategoryTreeClosureDao == null) {
                    this._notesCategoryTreeClosureDao = new NotesCategoryTreeClosureDao_Impl(this);
                }
                notesCategoryTreeClosureDao = this._notesCategoryTreeClosureDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesCategoryTreeClosureDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesCategoryTreeDao getCategoryTreeDao() {
        NotesCategoryTreeDao notesCategoryTreeDao;
        if (this._notesCategoryTreeDao != null) {
            return this._notesCategoryTreeDao;
        }
        synchronized (this) {
            try {
                if (this._notesCategoryTreeDao == null) {
                    this._notesCategoryTreeDao = new NotesCategoryTreeDao_Impl(this);
                }
                notesCategoryTreeDao = this._notesCategoryTreeDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesCategoryTreeDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesContentDao getContentDao() {
        NotesContentDao notesContentDao;
        if (this._notesContentDao != null) {
            return this._notesContentDao;
        }
        synchronized (this) {
            try {
                if (this._notesContentDao == null) {
                    this._notesContentDao = new NotesContentDao_Impl(this);
                }
                notesContentDao = this._notesContentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesContentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesConvertedDocumentDao getConvertedDocumentDao() {
        NotesConvertedDocumentDao notesConvertedDocumentDao;
        if (this._notesConvertedDocumentDao != null) {
            return this._notesConvertedDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesConvertedDocumentDao == null) {
                    this._notesConvertedDocumentDao = new NotesConvertedDocumentDao_Impl(this);
                }
                notesConvertedDocumentDao = this._notesConvertedDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesConvertedDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public CoverStickerDao getCoverStickerDao() {
        CoverStickerDao coverStickerDao;
        if (this._coverStickerDao != null) {
            return this._coverStickerDao;
        }
        synchronized (this) {
            try {
                if (this._coverStickerDao == null) {
                    this._coverStickerDao = new CoverStickerDao_Impl(this);
                }
                coverStickerDao = this._coverStickerDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return coverStickerDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public CoverTemplateDao getCoverTemplateDao() {
        CoverTemplateDao coverTemplateDao;
        if (this._coverTemplateDao != null) {
            return this._coverTemplateDao;
        }
        synchronized (this) {
            try {
                if (this._coverTemplateDao == null) {
                    this._coverTemplateDao = new CoverTemplateDao_Impl(this);
                }
                coverTemplateDao = this._coverTemplateDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return coverTemplateDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesDebugDao getDebugDao() {
        NotesDebugDao notesDebugDao;
        if (this._notesDebugDao != null) {
            return this._notesDebugDao;
        }
        synchronized (this) {
            try {
                if (this._notesDebugDao == null) {
                    this._notesDebugDao = new NotesDebugDao_Impl(this);
                }
                notesDebugDao = this._notesDebugDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesDebugDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesDocumentCoverDao getDocumentCoverDao() {
        NotesDocumentCoverDao notesDocumentCoverDao;
        if (this._notesDocumentCoverDao != null) {
            return this._notesDocumentCoverDao;
        }
        synchronized (this) {
            try {
                if (this._notesDocumentCoverDao == null) {
                    this._notesDocumentCoverDao = new NotesDocumentCoverDao_Impl(this);
                }
                notesDocumentCoverDao = this._notesDocumentCoverDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesDocumentCoverDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesDocumentDao getDocumentDao() {
        NotesDocumentDao notesDocumentDao;
        if (this._notesDocumentDao != null) {
            return this._notesDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesDocumentDao == null) {
                    this._notesDocumentDao = new NotesDocumentDao_Impl(this);
                }
                notesDocumentDao = this._notesDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public DocumentExtraDao getDocumentExtraDao() {
        DocumentExtraDao documentExtraDao;
        if (this._documentExtraDao != null) {
            return this._documentExtraDao;
        }
        synchronized (this) {
            try {
                if (this._documentExtraDao == null) {
                    this._documentExtraDao = new DocumentExtraDao_Impl(this);
                }
                documentExtraDao = this._documentExtraDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return documentExtraDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesDocumentPageDao getDocumentPageDao() {
        NotesDocumentPageDao notesDocumentPageDao;
        if (this._notesDocumentPageDao != null) {
            return this._notesDocumentPageDao;
        }
        synchronized (this) {
            try {
                if (this._notesDocumentPageDao == null) {
                    this._notesDocumentPageDao = new NotesDocumentPageDao_Impl(this);
                }
                notesDocumentPageDao = this._notesDocumentPageDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesDocumentPageDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public DocumentTempDataDao getDocumentTempDataDao() {
        DocumentTempDataDao documentTempDataDao;
        if (this._documentTempDataDao != null) {
            return this._documentTempDataDao;
        }
        synchronized (this) {
            try {
                if (this._documentTempDataDao == null) {
                    this._documentTempDataDao = new DocumentTempDataDao_Impl(this);
                }
                documentTempDataDao = this._documentTempDataDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return documentTempDataDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public DocumentThumbnailDao getDocumentThumbnailDao() {
        DocumentThumbnailDao documentThumbnailDao;
        if (this._documentThumbnailDao != null) {
            return this._documentThumbnailDao;
        }
        synchronized (this) {
            try {
                if (this._documentThumbnailDao == null) {
                    this._documentThumbnailDao = new DocumentThumbnailDao_Impl(this);
                }
                documentThumbnailDao = this._documentThumbnailDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return documentThumbnailDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public ExternalDataDao getExternalDataDao() {
        ExternalDataDao externalDataDao;
        if (this._externalDataDao != null) {
            return this._externalDataDao;
        }
        synchronized (this) {
            try {
                if (this._externalDataDao == null) {
                    this._externalDataDao = new ExternalDataDao_Impl(this);
                }
                externalDataDao = this._externalDataDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return externalDataDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public ExternalSharedDocumentDao getExternalSharedDocumentDao() {
        ExternalSharedDocumentDao externalSharedDocumentDao;
        if (this._externalSharedDocumentDao != null) {
            return this._externalSharedDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._externalSharedDocumentDao == null) {
                    this._externalSharedDocumentDao = new ExternalSharedDocumentDao_Impl(this);
                }
                externalSharedDocumentDao = this._externalSharedDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return externalSharedDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesHashtagContentDao getHashtagContentDao() {
        NotesHashtagContentDao notesHashtagContentDao;
        if (this._notesHashtagContentDao != null) {
            return this._notesHashtagContentDao;
        }
        synchronized (this) {
            try {
                if (this._notesHashtagContentDao == null) {
                    this._notesHashtagContentDao = new NotesHashtagContentDao_Impl(this);
                }
                notesHashtagContentDao = this._notesHashtagContentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesHashtagContentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesHashtagDao getHashtagDao() {
        NotesHashtagDao notesHashtagDao;
        if (this._notesHashtagDao != null) {
            return this._notesHashtagDao;
        }
        synchronized (this) {
            try {
                if (this._notesHashtagDao == null) {
                    this._notesHashtagDao = new NotesHashtagDao_Impl(this);
                }
                notesHashtagDao = this._notesHashtagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesHashtagDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesLockDocumentDao getLockDocumentDao() {
        NotesLockDocumentDao notesLockDocumentDao;
        if (this._notesLockDocumentDao != null) {
            return this._notesLockDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesLockDocumentDao == null) {
                    this._notesLockDocumentDao = new NotesLockDocumentDao_Impl(this);
                }
                notesLockDocumentDao = this._notesLockDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesLockDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public MainListDocumentDataDao getMainListDocumentDataDao() {
        MainListDocumentDataDao mainListDocumentDataDao;
        if (this._mainListDocumentDataDao != null) {
            return this._mainListDocumentDataDao;
        }
        synchronized (this) {
            try {
                if (this._mainListDocumentDataDao == null) {
                    this._mainListDocumentDataDao = new MainListDocumentDataDao_Impl(this);
                }
                mainListDocumentDataDao = this._mainListDocumentDataDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mainListDocumentDataDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesMappedDocumentDao getMappedDocumentDao() {
        NotesMappedDocumentDao notesMappedDocumentDao;
        if (this._notesMappedDocumentDao != null) {
            return this._notesMappedDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesMappedDocumentDao == null) {
                    this._notesMappedDocumentDao = new NotesMappedDocumentDao_Impl(this);
                }
                notesMappedDocumentDao = this._notesMappedDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesMappedDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesSearchDao getNotesSearchDao() {
        NotesSearchDao notesSearchDao;
        if (this._notesSearchDao != null) {
            return this._notesSearchDao;
        }
        synchronized (this) {
            try {
                if (this._notesSearchDao == null) {
                    this._notesSearchDao = new NotesSearchDao_Impl(this);
                }
                notesSearchDao = this._notesSearchDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesSearchDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesTemplateDao getNotesTemplateDao() {
        NotesTemplateDao notesTemplateDao;
        if (this._notesTemplateDao != null) {
            return this._notesTemplateDao;
        }
        synchronized (this) {
            try {
                if (this._notesTemplateDao == null) {
                    this._notesTemplateDao = new NotesTemplateDao_Impl(this);
                }
                notesTemplateDao = this._notesTemplateDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesTemplateDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesOldDocumentDao getOldDocumentDao() {
        NotesOldDocumentDao notesOldDocumentDao;
        if (this._notesOldDocumentDao != null) {
            return this._notesOldDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesOldDocumentDao == null) {
                    this._notesOldDocumentDao = new NotesOldDocumentDao_Impl(this);
                }
                notesOldDocumentDao = this._notesOldDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesOldDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesOrganizedDocumentDao getOrganizedDocumentDao() {
        NotesOrganizedDocumentDao notesOrganizedDocumentDao;
        if (this._notesOrganizedDocumentDao != null) {
            return this._notesOrganizedDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesOrganizedDocumentDao == null) {
                    this._notesOrganizedDocumentDao = new NotesOrganizedDocumentDao_Impl(this);
                }
                notesOrganizedDocumentDao = this._notesOrganizedDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesOrganizedDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesPageSearchInfoDao getPageSearchInfoDao() {
        NotesPageSearchInfoDao notesPageSearchInfoDao;
        if (this._notesPageSearchInfoDao != null) {
            return this._notesPageSearchInfoDao;
        }
        synchronized (this) {
            try {
                if (this._notesPageSearchInfoDao == null) {
                    this._notesPageSearchInfoDao = new NotesPageSearchInfoDao_Impl(this);
                }
                notesPageSearchInfoDao = this._notesPageSearchInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesPageSearchInfoDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesRecycleBinDocumentDao getRecycleBinDocumentDao() {
        NotesRecycleBinDocumentDao notesRecycleBinDocumentDao;
        if (this._notesRecycleBinDocumentDao != null) {
            return this._notesRecycleBinDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._notesRecycleBinDocumentDao == null) {
                    this._notesRecycleBinDocumentDao = new NotesRecycleBinDocumentDao_Impl(this);
                }
                notesRecycleBinDocumentDao = this._notesRecycleBinDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesRecycleBinDocumentDao;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(NotesDocumentDao.class, NotesDocumentDao_Impl.getRequiredConverters());
        map.put(MainListDocumentDataDao.class, MainListDocumentDataDao_Impl.getRequiredConverters());
        map.put(DocumentExtraDao.class, DocumentExtraDao_Impl.getRequiredConverters());
        map.put(DocumentThumbnailDao.class, DocumentThumbnailDao_Impl.getRequiredConverters());
        map.put(NotesMappedDocumentDao.class, NotesMappedDocumentDao_Impl.getRequiredConverters());
        map.put(NotesDocumentPageDao.class, NotesDocumentPageDao_Impl.getRequiredConverters());
        map.put(NotesContentDao.class, NotesContentDao_Impl.getRequiredConverters());
        map.put(NotesCategoryTreeDao.class, NotesCategoryTreeDao_Impl.getRequiredConverters());
        map.put(NotesCategoryTreeClosureDao.class, NotesCategoryTreeClosureDao_Impl.getRequiredConverters());
        map.put(RestoreFolderDao.class, RestoreFolderDao_Impl.getRequiredConverters());
        map.put(NotesDebugDao.class, NotesDebugDao_Impl.getRequiredConverters());
        map.put(NotesTagDao.class, NotesTagDao_Impl.getRequiredConverters());
        map.put(NotesRetryDao.class, NotesRetryDao_Impl.getRequiredConverters());
        map.put(NotesStrokeDao.class, NotesStrokeDao_Impl.getRequiredConverters());
        map.put(NotesPageSearchInfoDao.class, NotesPageSearchInfoDao_Impl.getRequiredConverters());
        map.put(NotesTemplateDao.class, NotesTemplateDao_Impl.getRequiredConverters());
        map.put(NotesOldDocumentDao.class, NotesOldDocumentDao_Impl.getRequiredConverters());
        map.put(NotesConvertedDocumentDao.class, NotesConvertedDocumentDao_Impl.getRequiredConverters());
        map.put(NotesLockDocumentDao.class, NotesLockDocumentDao_Impl.getRequiredConverters());
        map.put(NotesRecycleBinDocumentDao.class, NotesRecycleBinDocumentDao_Impl.getRequiredConverters());
        map.put(NotesSearchDao.class, NotesSearchDao_Impl.getRequiredConverters());
        map.put(NotesHashtagDao.class, NotesHashtagDao_Impl.getRequiredConverters());
        map.put(NotesHashtagContentDao.class, NotesHashtagContentDao_Impl.getRequiredConverters());
        map.put(NotesRestoreDao.class, NotesRestoreDao_Impl.getRequiredConverters());
        map.put(SyncCategoryTreeDao.class, SyncCategoryTreeDao_Impl.getRequiredConverters());
        map.put(SyncDocumentDao.class, SyncDocumentDao_Impl.getRequiredConverters());
        map.put(SyncInfoDao.class, SyncInfoDao_Impl.getRequiredConverters());
        map.put(SyncDelayInfoDao.class, SyncDelayInfoDao_Impl.getRequiredConverters());
        map.put(SyncFolderInfoDao.class, SyncFolderInfoDao_Impl.getRequiredConverters());
        map.put(SyncMdeDao.class, SyncMdeDao_Impl.getRequiredConverters());
        map.put(NotesDocumentCoverDao.class, NotesDocumentCoverDao_Impl.getRequiredConverters());
        map.put(CoverStickerDao.class, CoverStickerDao_Impl.getRequiredConverters());
        map.put(CoverTemplateDao.class, CoverTemplateDao_Impl.getRequiredConverters());
        map.put(SuggestedCoverDao.class, SuggestedCoverDao_Impl.getRequiredConverters());
        map.put(NotesOrganizedDocumentDao.class, NotesOrganizedDocumentDao_Impl.getRequiredConverters());
        map.put(ExternalDataDao.class, ExternalDataDao_Impl.getRequiredConverters());
        map.put(SttContentDao.class, SttContentDao_Impl.getRequiredConverters());
        map.put(DocumentTempDataDao.class, DocumentTempDataDao_Impl.getRequiredConverters());
        map.put(StickyNoteDao.class, StickyNoteDao_Impl.getRequiredConverters());
        map.put(StickyTextDao.class, StickyTextDao_Impl.getRequiredConverters());
        map.put(StickyStrokeDao.class, StickyStrokeDao_Impl.getRequiredConverters());
        map.put(ExternalSharedDocumentDao.class, ExternalSharedDocumentDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesRestoreDao getRestoreDao() {
        NotesRestoreDao notesRestoreDao;
        if (this._notesRestoreDao != null) {
            return this._notesRestoreDao;
        }
        synchronized (this) {
            try {
                if (this._notesRestoreDao == null) {
                    this._notesRestoreDao = new NotesRestoreDao_Impl(this);
                }
                notesRestoreDao = this._notesRestoreDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesRestoreDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public RestoreFolderDao getRestoreFolderDao() {
        RestoreFolderDao restoreFolderDao;
        if (this._restoreFolderDao != null) {
            return this._restoreFolderDao;
        }
        synchronized (this) {
            try {
                if (this._restoreFolderDao == null) {
                    this._restoreFolderDao = new RestoreFolderDao_Impl(this);
                }
                restoreFolderDao = this._restoreFolderDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return restoreFolderDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesRetryDao getRetryDao() {
        NotesRetryDao notesRetryDao;
        if (this._notesRetryDao != null) {
            return this._notesRetryDao;
        }
        synchronized (this) {
            try {
                if (this._notesRetryDao == null) {
                    this._notesRetryDao = new NotesRetryDao_Impl(this);
                }
                notesRetryDao = this._notesRetryDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesRetryDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public StickyNoteDao getStickyNoteDao() {
        StickyNoteDao stickyNoteDao;
        if (this._stickyNoteDao != null) {
            return this._stickyNoteDao;
        }
        synchronized (this) {
            try {
                if (this._stickyNoteDao == null) {
                    this._stickyNoteDao = new StickyNoteDao_Impl(this);
                }
                stickyNoteDao = this._stickyNoteDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return stickyNoteDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public StickyStrokeDao getStickyStrokeDao() {
        StickyStrokeDao stickyStrokeDao;
        if (this._stickyStrokeDao != null) {
            return this._stickyStrokeDao;
        }
        synchronized (this) {
            try {
                if (this._stickyStrokeDao == null) {
                    this._stickyStrokeDao = new StickyStrokeDao_Impl(this);
                }
                stickyStrokeDao = this._stickyStrokeDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return stickyStrokeDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public StickyTextDao getStickyTextDao() {
        StickyTextDao stickyTextDao;
        if (this._stickyTextDao != null) {
            return this._stickyTextDao;
        }
        synchronized (this) {
            try {
                if (this._stickyTextDao == null) {
                    this._stickyTextDao = new StickyTextDao_Impl(this);
                }
                stickyTextDao = this._stickyTextDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return stickyTextDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesStrokeDao getStrokeDao() {
        NotesStrokeDao notesStrokeDao;
        if (this._notesStrokeDao != null) {
            return this._notesStrokeDao;
        }
        synchronized (this) {
            try {
                if (this._notesStrokeDao == null) {
                    this._notesStrokeDao = new NotesStrokeDao_Impl(this);
                }
                notesStrokeDao = this._notesStrokeDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesStrokeDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SttContentDao getSttContentDao() {
        SttContentDao sttContentDao;
        if (this._sttContentDao != null) {
            return this._sttContentDao;
        }
        synchronized (this) {
            try {
                if (this._sttContentDao == null) {
                    this._sttContentDao = new SttContentDao_Impl(this);
                }
                sttContentDao = this._sttContentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sttContentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SuggestedCoverDao getSuggestedCoverDao() {
        SuggestedCoverDao suggestedCoverDao;
        if (this._suggestedCoverDao != null) {
            return this._suggestedCoverDao;
        }
        synchronized (this) {
            try {
                if (this._suggestedCoverDao == null) {
                    this._suggestedCoverDao = new SuggestedCoverDao_Impl(this);
                }
                suggestedCoverDao = this._suggestedCoverDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return suggestedCoverDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncCategoryTreeDao getSyncCategoryTreeDao() {
        SyncCategoryTreeDao syncCategoryTreeDao;
        if (this._syncCategoryTreeDao != null) {
            return this._syncCategoryTreeDao;
        }
        synchronized (this) {
            try {
                if (this._syncCategoryTreeDao == null) {
                    this._syncCategoryTreeDao = new SyncCategoryTreeDao_Impl(this);
                }
                syncCategoryTreeDao = this._syncCategoryTreeDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncCategoryTreeDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncDelayInfoDao getSyncDelayInfoDao() {
        SyncDelayInfoDao syncDelayInfoDao;
        if (this._syncDelayInfoDao != null) {
            return this._syncDelayInfoDao;
        }
        synchronized (this) {
            try {
                if (this._syncDelayInfoDao == null) {
                    this._syncDelayInfoDao = new SyncDelayInfoDao_Impl(this);
                }
                syncDelayInfoDao = this._syncDelayInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncDelayInfoDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncDocumentDao getSyncDocumentDao() {
        SyncDocumentDao syncDocumentDao;
        if (this._syncDocumentDao != null) {
            return this._syncDocumentDao;
        }
        synchronized (this) {
            try {
                if (this._syncDocumentDao == null) {
                    this._syncDocumentDao = new SyncDocumentDao_Impl(this);
                }
                syncDocumentDao = this._syncDocumentDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncDocumentDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncFolderInfoDao getSyncFolderInfoDao() {
        SyncFolderInfoDao syncFolderInfoDao;
        if (this._syncFolderInfoDao != null) {
            return this._syncFolderInfoDao;
        }
        synchronized (this) {
            try {
                if (this._syncFolderInfoDao == null) {
                    this._syncFolderInfoDao = new SyncFolderInfoDao_Impl(this);
                }
                syncFolderInfoDao = this._syncFolderInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncFolderInfoDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncInfoDao getSyncInfoDao() {
        SyncInfoDao syncInfoDao;
        if (this._syncInfoDao != null) {
            return this._syncInfoDao;
        }
        synchronized (this) {
            try {
                if (this._syncInfoDao == null) {
                    this._syncInfoDao = new SyncInfoDao_Impl(this);
                }
                syncInfoDao = this._syncInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncInfoDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public SyncMdeDao getSyncMdeDao() {
        SyncMdeDao syncMdeDao;
        if (this._syncMdeDao != null) {
            return this._syncMdeDao;
        }
        synchronized (this) {
            try {
                if (this._syncMdeDao == null) {
                    this._syncMdeDao = new SyncMdeDao_Impl(this);
                }
                syncMdeDao = this._syncMdeDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return syncMdeDao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase
    public NotesTagDao getTagDao() {
        NotesTagDao notesTagDao;
        if (this._notesTagDao != null) {
            return this._notesTagDao;
        }
        synchronized (this) {
            try {
                if (this._notesTagDao == null) {
                    this._notesTagDao = new NotesTagDao_Impl(this);
                }
                notesTagDao = this._notesTagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return notesTagDao;
    }
}
