package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.FeedSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncDocumentDao extends NotesDocumentDao {
    protected static final String FEED_SYNC_ENTRY_LIST = " sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.msLastSyncTime, sdoc.msSyncAccountId, sdoc.msSyncDocumentUuid, sdoc.createdAt ";
    private static final String ORDER_BY_DELETED_AND_SERVER_TIMESTAMP = " ORDER BY CASE isDeleted   WHEN 1 THEN 0   WHEN 0 THEN 1   WHEN 2 THEN 2  END,  CASE WHEN :isDesc=1 THEN serverTimestamp END DESC, CASE WHEN :isDesc=0 THEN serverTimestamp END ASC";
    protected static final String SHARE_SYNC_ENTRY_LIST = " sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.mdeSpaceId, sdoc.mdeItemId, sdoc.createdAt ";
    public static final String SYNC_DOC_INFO_LIST = " sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty ";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UuidServerTimestampTuple {

        @ColumnInfo(name = "serverTimestamp")
        public long serverTimestamp;

        @ColumnInfo(name = "UUID")
        public String uuid;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UuidTimeTuple {

        @ColumnInfo(name = DBSchema.Document.CATEGORY_SERVER_TIMESTAMP)
        public long categoryServerTimestamp;

        @ColumnInfo(name = "UUID")
        public String uuid;
    }

    @Query("SELECT * FROM sdoc ORDER BY UUID ASC")
    public abstract List<NotesDocumentEntity> dumpDocument();

    @Query("SELECT categoryserverTimestamp FROM sdoc WHERE UUID=:docUuid")
    public abstract Long getCategoryServerTimestamp(String str);

    @Query("SELECT  sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.mdeSpaceId, sdoc.mdeItemId, sdoc.createdAt  FROM sdoc WHERE sdoc.categoryUUID ='coedit:///'")
    public abstract List<ShareSyncEntry> getCoeditDocUuidList();

    @Query("SELECT sdoc.corrupted FROM sdoc  WHERE sdoc.UUID =:docUuid")
    public abstract int getCorruptedValue(String str);

    @Query("SELECT COUNT(*) FROM sdoc WHERE isDirty=:dirtyFlag AND mdeSpaceId=:mdeSpaceId")
    public abstract int getCountIsDirty(int i, String str);

    @Query("SELECT sdoc.UUID AS uUid,  '' AS parentFolderNodeId,  sdoc.isDeleted AS isDeleted,  sdoc.categoryserverTimestamp AS syncModifiedTime,  sdoc.createdAt AS createdTime,  sdoc.lastModifiedAt AS lastModifiedTime,  sdoc.recycle_bin_time_moved AS recycleBinMovedTime,  sdoc.absolutePath AS restorePath,  0 AS isSyncWithMS,  -1 AS displayNameColor,  0 AS deleted,  999999 AS reorder,  0 AS isDirty,  0 AS isCategoryDirty,  sdoc.categoryUUID AS categoryUuid  FROM sdoc WHERE mdeSpaceId='' AND categoryisDirty=1 AND categoryUUID !='coedit:///' AND UUID NOT LIKE '%_COEDIT' AND filePath LIKE '%.sdocx'")
    public abstract List<FolderNodeItem> getDirtyFolderNodeItemList();

    @Query("SELECT  sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  FROM sdoc WHERE sdoc.UUID =:docUuid")
    public abstract DocSyncEntry getDocSyncEntry(String str);

    @Query("SELECT sdoc.mdeOwnerId FROM sdoc  WHERE sdoc.UUID =:docUuid")
    public abstract String getGcsOwnerId(String str);

    @Query("SELECT * FROM sdoc WHERE categoryisDirty=:dirtyFlag AND mdeSpaceId=:mdeSpaceId ORDER BY CASE isDeleted   WHEN 1 THEN 0   WHEN 0 THEN 1   WHEN 2 THEN 2  END,  CASE WHEN :isDesc=1 THEN serverTimestamp END DESC, CASE WHEN :isDesc=0 THEN serverTimestamp END ASC")
    public abstract List<NotesDocumentEntity> getIsCategoryDirtyDocList(int i, boolean z, String str);

    @Query("SELECT * FROM sdoc WHERE isDirty=:dirtyFlag AND mdeSpaceId=:mdeSpaceId ORDER BY CASE isDeleted   WHEN 1 THEN 0   WHEN 0 THEN 1   WHEN 2 THEN 2  END,  CASE WHEN :isDesc=1 THEN serverTimestamp END DESC, CASE WHEN :isDesc=0 THEN serverTimestamp END ASC")
    public abstract List<NotesDocumentEntity> getIsDirtyDocList(int i, boolean z, String str);

    @Query("SELECT lockAccountGuid FROM sdoc WHERE UUID=:uuid")
    public abstract String getLockAccountGuid(String str);

    @Query("SELECT MAX(categoryserverTimestamp) FROM sdoc WHERE mdeSpaceId=='' AND filePath LIKE '%.sdocx'")
    public abstract long getMaxSyncModifiedTimeFromNotes();

    @Query("SELECT sdoc.mdeExtra FROM sdoc  WHERE sdoc.UUID =:docUuid")
    public abstract String getMdeExtra(String str);

    @Query("SELECT UUID FROM sdoc WHERE filePath LIKE '%.sdocx' AND mdeSpaceId=''")
    public abstract List<String> getNormalSdocxUuidList();

    @Query("SELECT UUID FROM sdoc WHERE filePath LIKE '%.sdocx' AND mdeSpaceId='' AND isDeleted!=1 AND isDirty=1 AND corrupted=0")
    public abstract List<String> getNormalSyncablSdocxUuidList();

    @Query("SELECT isDeleted FROM sdoc WHERE UUID=:uuid")
    public abstract int getNoteDeleted(String str);

    @Query("SELECT  sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.msLastSyncTime, sdoc.msSyncAccountId, sdoc.msSyncDocumentUuid, sdoc.createdAt  FROM sdoc  WHERE sdoc.UUID =:uuid")
    public abstract FeedSyncEntry getNoteFeedEntryByUuid(String str);

    @Query("SELECT  sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.msLastSyncTime, sdoc.msSyncAccountId, sdoc.msSyncDocumentUuid, sdoc.createdAt  FROM sdoc  WHERE sdoc.categoryUUID =:categoryUuid")
    public abstract List<FeedSyncEntry> getNoteFeedListByCategoryUuid(String str);

    @Query("SELECT COUNT(*) FROM sdoc  WHERE filePath LIKE '%.sdoc' AND categoryisDirty=1 AND mdeSpaceId=''")
    public abstract int getOldDirtyCountOfNoteCategory();

    @Query("SELECT UUID , categoryserverTimestamp FROM sdoc WHERE filePath LIKE '%.sdoc'")
    public abstract List<UuidTimeTuple> getOldUuidAndNoteCategoryTimeList();

    @Query("SELECT serverTimestamp FROM sdoc WHERE UUID=:docUuid")
    public abstract Long getServerTimestamp(String str);

    @Query("SELECT  sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  ,sdoc.mdeSpaceId, sdoc.mdeItemId, sdoc.createdAt  FROM sdoc WHERE sdoc.UUID =:docUuid")
    public abstract ShareSyncEntry getShareSyncEntry(String str);

    @Query("SELECT title FROM sdoc WHERE UUID=:uuid")
    public abstract String getTitle(String str);

    @Query("SELECT COUNT(*) FROM sdoc WHERE mdeSpaceId=='' AND filePath LIKE '%.sdocx'")
    public abstract int getTotalNumberOfSDocx();

    @Query("SELECT sdoc.UUID, sdoc.serverTimestamp  FROM sdoc WHERE (sdoc.filePath LIKE '%.sdoc')")
    public abstract List<UuidServerTimestampTuple> getUuidAndNoteTimeList();

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId=:spaceId AND mdeItemId=:itemId LIMIT 1")
    public abstract String getUuidByItemId(String str, String str2);

    @Query("SELECT sdoc.UUID FROM sdoc  WHERE categoryUUID =:categoryUuid AND sdoc.isDeleted = 0")
    public abstract List<String> getUuidListByCategory(String str);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND categoryisDirty =:dirty AND mdeSpaceId=''")
    public abstract List<String> getUuidListByCategoryDirty(int i);

    @Query("SELECT sdoc.UUID FROM sdoc  WHERE categoryUUID =:categoryUuid")
    public abstract List<String> getUuidListByCategoryIncludeDeleted(String str);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND isDeleted=:deleted AND mdeSpaceId=''")
    public abstract List<String> getUuidListByDeleted(int i);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND isDirty =:dirty AND mdeSpaceId=''")
    public abstract List<String> getUuidListByDirty(int i);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND isLock=:lockType AND sdoc.isDeleted = 0 AND  mdeSpaceId=''")
    public abstract List<String> getUuidListLockedNote(@LockType int i);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND isLock=:lockType AND isDeleted!=1 AND mdeSpaceId=''")
    public abstract List<String> getUuidListLockedNoteIncludeDeleted(@LockType int i);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE filePath LIKE '%.sdoc' AND mdeSpaceId=''")
    public abstract List<String> getUuidListOldSync();

    @Query("SELECT 1 from sdoc WHERE UUID=:docUuid")
    public abstract boolean isExist(String str);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID='uncategorized:///' WHERE categoryUUID != 'trash:///'")
    public abstract void moveAllToRoot();

    @RawQuery(observedEntities = {NotesDocumentEntity.class})
    public abstract List<DocSyncEntry> rawQueryForDocSyncEntryList(SupportSQLiteQuery supportSQLiteQuery);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID='shared:///' WHERE categoryUUID != 'shared:///' AND mdeSpaceId != '' AND categoryUUID !='coedit:///'")
    public abstract void repairOldSharedNotesCategoryUuid();

    @Query("UPDATE OR ABORT sdoc SET lastMappedAt=:lastMappedAt  WHERE UUID=:uuid")
    public abstract int setLastMappedAtList(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET mdeExtra=:mdeExtra WHERE UUID=:uuid")
    public abstract void setMdeExtra(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET mdeItemId=:itemId WHERE UUID=:docUuid")
    public abstract void setMdeItemId(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:folderUuid WHERE UUID=:docUuid")
    public abstract void setNoteFolder(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET absolutePath=:absolutePath WHERE UUID=:docUuid AND filePath LIKE '%.sdoc'")
    public abstract void updateAbsolutePath(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET firstOpendAt=:firstOpendAt WHERE categoryUUID='coedit:///'")
    public abstract void updateAllCoeditNotesAsRead(long j);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:toCategoryUuid , categoryisDirty=1  , categoryserverTimestamp=:serverTimestamp WHERE categoryUUID=:fromCategoryUuid")
    public abstract void updateCategoryByCategoryUuidWithCategoryServerTimestamp(String str, String str2, long j);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:toCategoryUuid , categoryisDirty=1  , categoryserverTimestamp=:serverTimestamp WHERE categoryUUID=:fromCategoryUuid")
    public abstract void updateCategoryByCategoryUuidWithCategoryServerTimestampIncrease(String str, String str2, long j);

    @Query("UPDATE OR ABORT sdoc SET categoryserverTimestamp=:serverTime WHERE UUID=:docUuid")
    public abstract void updateCategoryServerTimestamp(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET createdAt=:createdAt WHERE UUID=:docUuid")
    public abstract void updateCreatedAt(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET isDirty=:isDirty WHERE UUID=:uuid")
    public abstract void updateDirty(String str, int i);

    @Query("UPDATE OR ABORT sdoc SET isDirty=:isDirty , serverTimestamp=:serverTimestamp WHERE UUID=:uuid")
    public abstract void updateDirtyAndTimestamp(String str, int i, long j);

    @Query("UPDATE OR ABORT sdoc SET categoryisDirty=:categoryIsDirty WHERE UUID=:uuid")
    public abstract void updateDirtyCategory(String str, int i);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:serverDeleted , isDirty=:isDirty , serverTimestamp=:serverTimestamp , categoryisDirty=:categoryIsDirty , categoryserverTimestamp=:categoryServerTimestamp WHERE UUID=:serverUuid")
    public abstract void updateEntityByDeleteSdocToDelete(String str, int i, int i2, long j, int i4, long j2);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:serverDeleted , recycle_bin_time_moved=:recycleBinTimeMoved , categoryUUID=:categoryUuid , absolutePath=:absolutePath , categoryisDirty=:categoryIsDirty , categoryserverTimestamp=:categoryServerTimestamp WHERE UUID=:serverUuid")
    public abstract void updateEntityByDeleteSdocToRecycleBin(String str, int i, long j, String str2, String str3, int i2, long j2);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:serverDeleted , recycle_bin_time_moved=:recycleBinTimeMoved , categoryUUID=:categoryUuid , absolutePath=:absolutePath WHERE UUID=:serverUuid")
    public abstract void updateEntityByDeleteSdocToRecycleBinInSync(String str, int i, long j, String str2, String str3);

    @Query("UPDATE OR ABORT sdoc SET isDirty=:dirtyFlag , serverTimestamp=:serverTime , isDeleted=:isDeleted , categoryUUID=:categoryUuid WHERE UUID=:docUuid")
    public abstract void updateEntityByRecoverySDoc(String str, int i, long j, int i2, String str2);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:isDeleted , recycle_bin_time_moved=:recyclerMovedTime , categoryisDirty=:categoryIsDirty , categoryserverTimestamp=:currentTime , categoryUUID=:categoryUuid WHERE UUID=:serverUuid")
    public abstract void updateEntityByRestoreSDoc(String str, int i, int i2, int i4, long j, String str2);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:isDeleted , recycle_bin_time_moved=:recyclerMovedTime , categoryUUID=:categoryUuid , absolutePath='' WHERE UUID=:serverUuid")
    public abstract void updateEntityByRestoreSDocInSync(String str, int i, int i2, String str2);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:isDeleted , categoryUUID=:folderUuid , categoryserverTimestamp=:syncModifiedTime , categoryisDirty=:dirtyFlag , recycle_bin_time_moved=:recyclerBinTimeMoved , absolutePath=:restorePath WHERE UUID=:docUuid")
    public abstract void updateEntityBySetNoteFolder(String str, int i, String str2, long j, int i2, long j2, String str3);

    @Query("UPDATE OR ABORT sdoc SET firstOpendAt=:firstOpenedAt WHERE UUID=:docUuid")
    public abstract void updateFirstOpenedAt(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:serverDeleted WHERE UUID=:serverUuid")
    public abstract void updateIsDeleted(String str, int i);

    @Query("UPDATE OR ABORT sdoc SET lastModifiedAt=:modifiedTime WHERE UUID=:docUuid")
    public abstract void updateModifiedTime(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET msSyncAccountId=:accountId , msSyncDocumentUuid=:connectedNotesId , msLastSyncTime=serverTimestamp , categoryisDirty=:isCategoryDirty WHERE UUID=:docUuid")
    public abstract void updateMsConnectedNotes(String str, String str2, String str3, int i);

    @Query("UPDATE OR ABORT sdoc SET msSyncAccountId=:accountId , msSyncDocumentUuid=:connectedNotesId WHERE UUID=:docUuid")
    public abstract void updateMsConnectedNotesId(String str, String str2, String str3);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:categoryUuid WHERE UUID=:docUuid AND filePath LIKE '%.sdoc'")
    public abstract void updateNoteCategory(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:categoryUuid , categoryisDirty=:dirtyFlag , categoryserverTimestamp=:categoryServerTime WHERE UUID=:docUuid")
    public abstract void updateNoteCategory(String str, String str2, int i, long j);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:categoryUuid , categoryisDirty=:dirtyFlag , categoryserverTimestamp=:categoryServerTime , absolutePath=:absPath WHERE UUID=:docUuid")
    public abstract void updateNoteCategory(String str, String str2, int i, long j, String str3);

    @Query("UPDATE OR ABORT sdoc SET isFavorite=:favorite , categoryserverTimestamp=:currentTime  , categoryisDirty=1 WHERE UUID=:uuid")
    public abstract int updateNoteFavoriteAndCategoryDirtyTimestamp(String str, int i, long j);

    @Query("UPDATE OR ABORT sdoc SET isFavorite=:favorite WHERE UUID=:uuid")
    public abstract int updateNoteFavoriteInSync(String str, int i);

    @Query("UPDATE OR ABORT sdoc SET recycle_bin_time_moved=:recyclerBinMovedTime WHERE UUID=:uuid")
    public abstract void updateRecycleBinResolverUpdateTimeMoved(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET serverTimestamp=:serverTime WHERE UUID=:docUuid")
    public abstract void updateServerTimestamp(String str, long j);
}
