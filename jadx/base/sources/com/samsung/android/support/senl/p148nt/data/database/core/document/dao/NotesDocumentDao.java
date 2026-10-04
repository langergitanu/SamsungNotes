package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.arch.core.util.Function;
import androidx.compose.runtime.AbstractC1974b;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesDocumentDao implements BaseDao<NotesDocumentEntity> {
    private static final String ORDER_BY = " ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC";
    private static final String TAG = DataLogger.createTag("NotesDocumentDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(long j, List list) {
        deleteInChunk(list, j);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidListWithTimestampIncrease$1(List list) {
        deleteInternalWithServerTimestampIncrease(list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$restoreFromTrash$4(String str, long j, List list) {
        updateDocuments(list, 0, str, "", 0L, j);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$updateCategory$5(String str, long j, List list) {
        updateCategory(str, list, j);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$updateTargets$2(String str) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$updateToRecycleBin$3(String str, long j, long j2, List list) {
        updateDocuments(list, 2, "trash:///", str, j, j2);
        return new ArrayList();
    }

    private void printDeletedDocumentsByFolder(List<DocumentData> list, @DeleteType int i) {
        for (DocumentData documentData : list) {
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "#deleteByFolder, isDeleted: ", ", uuid: ");
            sbM778t.append(documentData.getUuid());
            DataLogger.m12305f(str, sbM778t.toString());
        }
    }

    private void printRestoreDocumentsByFolder(String str) {
        for (String str2 : getRestoredUuidsByCategory(str)) {
            DataLogger.m12305f(TAG, "#restoreByFolder, uuid: " + str2);
        }
    }

    private void restoreFromTrash(Collection<String> collection, String str, long j) {
        new SplitTaskExecutor(new C11248e(this, str, j, 1)).execute(collection);
    }

    private void updateTargets(Map<String, List<String>> map, String str, String str2) {
        map.computeIfAbsent(str, new C4662f(29)).add(str2);
    }

    private void updateToRecycleBin(Collection<String> collection, final String str, final long j, final long j2) {
        new SplitTaskExecutor(new Function() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.c
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: apply */
            public final Object mo22196apply(Object obj) {
                return this.f7364a.lambda$updateToRecycleBin$3(str, j, j2, (List) obj);
            }
        }).execute(collection);
    }

    @Query("DELETE FROM sdoc")
    public abstract void deleteAll();

    public int deleteByCategoryUuid(NotesMappedDocumentDao notesMappedDocumentDao, String str, long j) {
        List<DocumentData> documentDataByCategoryUuid = getDocumentDataByCategoryUuid(str);
        notesMappedDocumentDao.delete(this, documentDataByCategoryUuid);
        printDeletedDocumentsByFolder(documentDataByCategoryUuid, 1);
        return deleteByCategoryUuid(str, j);
    }

    @Query("UPDATE OR ABORT sdoc SET isDeleted=1 , isDirty=1 , categoryisDirty=1 , categoryServerTimestamp=:serverTimestamp WHERE categoryUUID=:categoryUuid")
    public abstract int deleteByCategoryUuid(String str, long j);

    @Transaction
    public int deleteByUuid(String str) {
        DataLogger.m12305f(TAG, "###deleteByUuid, isDeleted: 1, uuid: " + str);
        return deleteInChunk(Collections.singleton(str), 0L);
    }

    @Query("DELETE FROM sdoc WHERE UUID = :uuid")
    public abstract int deleteByUuidDb(String str);

    @Transaction
    public void deleteByUuidListWithTimestampIncrease(Collection<String> collection) {
        new SplitTaskExecutor(new C11245b(this, 2)).execute(collection);
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            sb.append("\n##deleteByUuid, isDeleted: 1, uuid: ");
            sb.append(str);
        }
        DataLogger.m12305f(TAG, sb.toString());
    }

    @Query("UPDATE OR ABORT sdoc SET isDeleted=1 , mdeSpaceId='' , mdeItemId='' , isDirty=1 , categoryisDirty=1 , categoryserverTimestamp= :categoryServerTimestamp WHERE UUID IN (:uuids)")
    public abstract int deleteInChunk(Collection<String> collection, long j);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=1 , mdeSpaceId='' , mdeItemId='' , isDirty=1 , categoryisDirty=1 , categoryserverTimestamp= categoryserverTimestamp+1 WHERE UUID IN (:uuids)")
    public abstract int deleteInternalWithServerTimestampIncrease(Collection<String> collection);

    @Transaction
    public List<String> fetchActiveFilePaths(List<String> list) {
        return new SplitTaskExecutor(new C11245b(this, 3)).execute(list);
    }

    @Query("SELECT sdoc.filePath FROM sdoc WHERE sdoc.filePath IN (:paths) AND sdoc.isDeleted != 1")
    public abstract List<String> fetchActiveFilePathsInChunk(List<String> list);

    @Query("SELECT GROUP_CONCAT(category_tree.displayName, '/') FROM category_tree WHERE category_tree.UUID IN (SELECT ancestor FROM category_tree_closure WHERE descendant = (SELECT categoryUUID FROM sdoc WHERE UUID = :docUuid) ORDER BY depth DESC) AND category_tree.parentUUID IS NOT NULL")
    public abstract String getAbsoluteFolderPath(String str);

    @Query("SELECT absolutePath FROM sdoc WHERE UUID=:uuid")
    public abstract String getAbsolutePath(String str);

    @Query("SELECT `sdoc`.* FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted=:deleteType AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC")
    public abstract List<NotesDocumentEntity> getAll(@DeleteType int i, boolean z);

    public Cursor getAllDocument(String str, String str2, String str3) {
        StringBuilder sbM16m = AbstractC0000a.m16m("SELECT ", str2, SQLKeyword.FROM, str, " LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE ");
        sbM16m.append(str3);
        return rawQueryForDocument(new SimpleSQLiteQuery(sbM16m.toString(), null));
    }

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted, category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1) AS documentCount FROM category_tree ORDER BY category_tree.orderBy ASC")
    public abstract LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData();

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc LEFT OUTER JOIN mapped_document AS map ON doc.UUID = map.UUID WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1 AND map.UUID IS NULL) AS documentCount FROM category_tree WHERE category_tree.parentUUID=:parentUuid ORDER BY category_tree.orderBy ASC")
    public abstract LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(String str);

    @Transaction
    public List<String> getAllDocumentsInFolderTree(Collection<String> collection) {
        return new SplitTaskExecutor(new C11245b(this, 6)).execute(collection);
    }

    @Query("SELECT UUID FROM sdoc WHERE categoryUUID IN (SELECT DISTINCT(descendant) FROM category_tree_closure WHERE ancestor IN (:uuids))")
    public abstract List<String> getAllDocumentsInFolderTreeInChunk(Collection<String> collection);

    @Query("SELECT filePath FROM sdoc WHERE isDeleted!=1")
    public abstract List<String> getAllPathList();

    @Query("SELECT `sdoc`.* FROM sdoc WHERE sdoc.isDeleted=:deleteType AND sdoc.mdeSpaceId='' ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC")
    public abstract List<NotesDocumentEntity> getAll_NotConsideringMappingTable(@DeleteType int i, boolean z);

    @Query("SELECT categoryUUID FROM sdoc WHERE UUID=:uuid")
    public abstract String getCategoryUuid(String str);

    @Query("SELECT categoryUUID FROM sdoc WHERE UUID IN (:docUuids)")
    public abstract List<String> getCategoryUuidList(Collection<String> collection);

    @Transaction
    public Set<String> getCategoryUuids(Collection<String> collection) {
        return new HashSet(new SplitTaskExecutor(new C11245b(this, 5)).execute(collection));
    }

    @Query("SELECT UUID FROM sdoc WHERE UUID=:uuid AND corrupted IS 1")
    public abstract int getCorrupted(String str);

    @Query("SELECT UUID FROM sdoc WHERE corrupted IS NOT 0")
    public abstract List<String> getCorruptedUuid();

    @Query("SELECT UUID FROM sdoc WHERE corrupted=:corrupted")
    public abstract List<String> getCorruptedUuid(int i);

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc WHERE sdoc.categoryUUID=category_tree.UUID AND sdoc.isDeleted IS NOT 1) AS documentCount FROM category_tree WHERE category_tree.UUID=:categoryUuid")
    public abstract NotesDocumentCountEntry getDocumentCountEntry_NotConsideringMappingTable(String str);

    @Query("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE UUID=:uuid")
    public abstract DocumentData getDocumentData(String str);

    @Query("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE UUID IN (:uuids)")
    public abstract List<DocumentData> getDocumentData(Collection<String> collection);

    @Query("SELECT _id, UUID, categoryUUID, filePath FROM sdoc WHERE categoryUUID=:categoryUuid")
    public abstract List<DocumentData> getDocumentDataByCategoryUuid(String str);

    @Transaction
    public List<DocumentData> getDocumentDataList(Collection<String> collection) {
        return new SplitTaskExecutor(new C11245b(this, 4)).execute(collection);
    }

    @Query("SELECT `sdoc`.* FROM sdoc WHERE UUID IN (:uuids)")
    public abstract List<NotesDocumentEntity> getEntities(Collection<String> collection);

    @Transaction
    public List<NotesDocumentEntity> getEntitiesByUuids(Collection<String> collection) {
        return new SplitTaskExecutor(new C11245b(this, 1)).execute(collection);
    }

    @Query("SELECT `sdoc`.* FROM sdoc WHERE UUID=:uuid")
    public abstract NotesDocumentEntity getEntity(String str);

    @Query("SELECT `sdoc`.* FROM sdoc WHERE filePath=:path")
    public abstract NotesDocumentEntity getEntityFromPath(String str);

    @Query("SELECT UUID FROM sdoc WHERE recycle_bin_time_moved<:expiredTime AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2")
    public abstract List<String> getExpiredRecycleBinDataList(long j);

    @Query("SELECT isSaving FROM sdoc WHERE UUID=:uuid")
    public abstract int getIsSavingByWhichPid(String str);

    @Query("SELECT `sdoc`.* FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted != 1 AND sdoc.mdeSpaceId='' AND isLock != 1 AND map.UUID IS NULL")
    public abstract List<NotesDocumentEntity> getNotesForBackup();

    @Query("SELECT `sdoc`.* FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted != 1 AND sdoc.mdeSpaceId='' AND isLock != 1 AND map.UUID IS NULL AND sdoc.UUID NOT LIKE '%_GEN%'")
    public abstract List<NotesDocumentEntity> getNotesForBackupExceptGenAi();

    @Query("SELECT filePath FROM sdoc WHERE UUID=:uuid")
    public abstract String getPath(String str);

    @Query("SELECT filePath FROM sdoc WHERE isDeleted=:deleteType")
    public abstract List<String> getPathList(@DeleteType int i);

    @Query("SELECT UUID FROM sdoc WHERE categoryUUID=:categoryUuid AND isDeleted=2")
    public abstract List<String> getRestoredUuidsByCategory(String str);

    @Query("SELECT `sdoc`.* FROM sdoc WHERE sdoc.isDeleted != 1 AND sdoc.isSaving != 0 AND sdoc.isSaving != :currentPid")
    public abstract List<NotesDocumentEntity> getSaveFailedEntities(int i);

    @Query("SELECT serverTimestamp FROM sdoc WHERE UUID=:uuid")
    public abstract Long getServerTimeStamp(String str);

    @Query("SELECT strippedContent FROM text_search WHERE sdocUUID=:uuid")
    public abstract byte[] getStrippedContent(String str);

    @Transaction
    public List<String> getUnlockedNormalNotes(Collection<String> collection) {
        return new SplitTaskExecutor(new C11245b(this, 0)).execute(collection);
    }

    @Query("SELECT UUID FROM sdoc WHERE UUID IN (:uuids) AND sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND sdoc.mdeSpaceId=''")
    public abstract List<String> getUnlockedNormalUuids(Collection<String> collection);

    @Transaction
    public List<String> getUpdatableNotes(Collection<String> collection) {
        return new SplitTaskExecutor(new C11245b(this, 7)).execute(collection);
    }

    @Query("SELECT UUID FROM sdoc WHERE UUID IN (:uuids) AND sdoc.filePath LIKE '%.sdocx' AND sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND sdoc.mdeSpaceId=''")
    public abstract List<String> getUpdatableUuids(Collection<String> collection);

    @Query("SELECT UUID FROM sdoc WHERE filePath=:filePath")
    public abstract String getUuid(String str);

    @Query("SELECT `sdoc`.* FROM sdoc WHERE UUID=:uuid")
    public abstract LiveData<NotesDocumentEntity> get_LiveData(String str);

    @Transaction
    public void moveToRecycleBin(Collection<String> collection, long j, long j2, DocumentCategoryTree documentCategoryTree) {
        String absolutePath;
        List<NotesDocumentEntity> entitiesByUuids = getEntitiesByUuids(collection);
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (NotesDocumentEntity notesDocumentEntity : entitiesByUuids) {
            if (notesDocumentEntity.isSdoc()) {
                boolean zEquals = "uncategorized:///".equals(notesDocumentEntity.getCategoryUuid());
                absolutePath = CategoryConstants.OldUncategorized.PATH;
                if (zEquals) {
                    DataLogger.m12305f(TAG, "moveToRecycleBin, category of " + notesDocumentEntity.getUuid() + " is set to OldUncategorized");
                } else {
                    NotesFolder folder = documentCategoryTree.getFolder(notesDocumentEntity.getCategoryUuid());
                    if (folder != null) {
                        absolutePath = folder.getAbsolutePath();
                    } else {
                        DataLogger.m12305f(TAG, "moveToRecycleBin, category " + notesDocumentEntity.getCategoryUuid() + " of " + notesDocumentEntity.getUuid() + " is set to OldUncategorized");
                    }
                }
            } else {
                NotesFolder folder2 = documentCategoryTree.getFolder(notesDocumentEntity.getCategoryUuid());
                absolutePath = folder2 != null ? folder2.getAbsolutePath() : PredefinedCategory.UNCATEGORIZED.getPath();
            }
            updateTargets(map, absolutePath, notesDocumentEntity.getUuid());
            sb.append("\n#delete, isDeleted: 2, ");
            sb.append(notesDocumentEntity.getUuid());
        }
        for (Map.Entry entry : map.entrySet()) {
            updateToRecycleBin((Collection) entry.getValue(), (String) entry.getKey(), j, j2);
        }
        DataLogger.m12305f(TAG, sb.toString());
    }

    @Query("UPDATE OR ABORT sdoc SET isDeleted=2 , recycle_bin_time_moved= :recyclerBinTimeMoved , absolutePath=:absolutePath , categoryisDirty=1 , categoryServerTimestamp=:serverTimestamp WHERE categoryUUID=:categoryUuid")
    public abstract void moveToRecycleBinByCategory(String str, long j, long j2, String str2);

    @Transaction
    public void moveToRecycleBinByCategoryUuid(String str, long j, long j2, String str2) {
        printDeletedDocumentsByFolder(getDocumentDataByCategoryUuid(str), 2);
        moveToRecycleBinByCategory(str, j, j2, str2);
    }

    @RawQuery(observedEntities = {NotesDocumentEntity.class})
    public abstract Cursor rawQueryForDocument(SupportSQLiteQuery supportSQLiteQuery);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=0 , isDirty=1 , categoryserverTimestamp=:serverTimestamp   , categoryisDirty=1 WHERE categoryUUID=:categoryUuid AND isDeleted=2")
    public abstract void restoreByCategory(String str, long j);

    @Transaction
    public void restoreByCategoryUuid(String str, long j) {
        printRestoreDocumentsByFolder(str);
        restoreByCategory(str, j);
    }

    @Transaction
    public void restoreByUuids(Context context, NotesCategoryTreeDao notesCategoryTreeDao, Collection<String> collection, long j) {
        List<NotesDocumentEntity> entitiesByUuids = getEntitiesByUuids(collection);
        boolean zIsSdoc = false;
        DocumentCategoryTree allDocumentCategoryTree = notesCategoryTreeDao.getAllDocumentCategoryTree(false);
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (NotesDocumentEntity notesDocumentEntity : entitiesByUuids) {
            if (notesDocumentEntity.getIsDeleted() != 2) {
                DataLogger.m12309w(TAG, "#restore, invalid entity: " + notesDocumentEntity.getUuid() + " / " + notesDocumentEntity.getIsDeleted());
            } else {
                String absolutePath = notesDocumentEntity.getAbsolutePath();
                if (TextUtils.isEmpty(absolutePath)) {
                    DataLogger.m12309w(TAG, "#restore, invalid absolute path : " + absolutePath);
                }
                arrayList.addAll(notesCategoryTreeDao.updateDocumentAndCreateFolderForRestore(notesDocumentEntity, context, allDocumentCategoryTree, absolutePath, -1, false));
                updateTargets(map, notesDocumentEntity.getCategoryUuid(), notesDocumentEntity.getUuid());
                if (!zIsSdoc) {
                    zIsSdoc = notesDocumentEntity.isSdoc();
                }
                sb.append("\n#restore, uuid: ");
                sb.append(notesDocumentEntity.getUuid());
            }
        }
        notesCategoryTreeDao.insertFolder(arrayList);
        for (Map.Entry entry : map.entrySet()) {
            restoreFromTrash((Collection) entry.getValue(), (String) entry.getKey(), j);
        }
        if (zIsSdoc) {
            DataUpdateManager.getInstance().onOldNoteRestored();
        }
        DataLogger.m12305f(TAG, sb.toString());
    }

    @Query("UPDATE OR ABORT sdoc SET displayContent =:displayContent  WHERE UUID=:uuid")
    public abstract void setDisplayContent(String str, byte[] bArr);

    public void setOpenedTime(@NonNull String str) {
        NotesDocumentEntity entity = getEntity(str);
        if (entity == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long firstOpendAt = entity.getFirstOpendAt() != 0 ? entity.getFirstOpendAt() : jCurrentTimeMillis;
        long secondOpenedAt = (entity.getFirstOpendAt() == 0 || entity.getSecondOpenedAt() != 0) ? entity.getSecondOpenedAt() : jCurrentTimeMillis;
        if (entity.getFirstOpendAt() == 0 || entity.getSecondOpenedAt() == 0) {
            jCurrentTimeMillis = entity.getLastOpenedAt();
        }
        long j = jCurrentTimeMillis;
        updateOpenedTime(str, firstOpendAt, secondOpenedAt, j);
        String str2 = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(firstOpendAt, "setOpenedTime, first : ", ", second : ");
        sbM1323p.append(secondOpenedAt);
        sbM1323p.append(", last : ");
        sbM1323p.append(j);
        DataLogger.m12307i(str2, sbM1323p.toString());
    }

    @Update
    public abstract int update(Collection<NotesDocumentEntity> collection);

    @Query("UPDATE OR ABORT sdoc SET lockAccountGuid=:accountGuid WHERE UUID=:docUuid")
    public abstract void updateAccountGuidByUuid(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:categoryUuid , categoryserverTimestamp=:folderTimestamp , categoryisDirty=1 , isDirty=1 WHERE UUID IN (:uuids)")
    public abstract void updateCategory(String str, Collection<String> collection, long j);

    @Transaction
    public void updateCategory(Collection<String> collection, String str, long j) {
        new SplitTaskExecutor(new C11248e(this, str, j, 0)).execute(collection);
    }

    @Query("UPDATE OR ABORT sdoc SET categoryUUID=:toCategoryUuid WHERE categoryUUID=:fromCategoryUuid")
    public abstract void updateCategoryByCategoryUuid(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET corrupted=:corrupted WHERE UUID=:uuid")
    public abstract void updateCorrupted(String str, int i);

    @Query("UPDATE OR ABORT sdoc SET isDeleted=:deleteType , categoryUUID=:folderUuid , recycle_bin_time_moved=:movedTimeToRecycleBin , absolutePath=:absolutePath , isDirty=1 , categoryisDirty=1 , categoryServerTimestamp=:categoryServerTimestamp WHERE UUID IN (:uuids)")
    public abstract void updateDocuments(Collection<String> collection, @DeleteType int i, String str, String str2, long j, long j2);

    @Query("UPDATE OR ABORT sdoc SET isFavorite=:isFavorite , isDirty=1 , serverTimestamp=:timestamp WHERE UUID=:uuid")
    public abstract int updateFavorite(String str, boolean z, long j);

    @Query("UPDATE OR ABORT sdoc SET isFavorite=:isFavorite , isDirty=1 , serverTimestamp=:timestamp WHERE UUID IN (:uuids)")
    public abstract void updateFavorites(Collection<String> collection, boolean z, long j);

    @Query("UPDATE OR ABORT sdoc SET lastMappedAt=:mappedAt WHERE UUID=:uuid")
    public abstract void updateLastMappedAt(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET firstOpendAt=:first , secondOpenedAt=:second , lastOpenedAt=:last WHERE UUID=:uuid")
    public abstract void updateOpenedTime(String str, long j, long j2, long j3);

    @Query("UPDATE OR ABORT sdoc SET recommendedTitle=:recommendedTitle WHERE UUID=:uuid")
    public abstract int updateRecommendedTitle(String str, String str2);

    @Query("UPDATE OR ABORT sdoc SET recycle_bin_time_moved=:movedTime WHERE UUID=:docUUID")
    public abstract void updateRecycleBinTimeMoved(String str, long j);

    @Query("UPDATE OR ABORT sdoc SET isSaving=:flag, size=:size WHERE UUID=:uuid")
    public abstract void updateSaving(String str, int i, long j);

    @Query("INSERT OR REPLACE INTO text_search (sdocUUID, strippedContent, filePath) VALUES  (:uuid, :strippedContent, :path)")
    public abstract void updateStrippedContents(String str, String str2, String str3);

    @Query("UPDATE OR ABORT sdoc SET title=:title , displayTitle=:displayTitle WHERE UUID=:uuid")
    public abstract int updateTitle(String str, String str2, byte[] bArr);

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    @Transaction
    public int delete(NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12305f(TAG, "#delete, isDeleted: 1, uuid: " + notesDocumentEntity.getUuid() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        return deleteInChunk(Collections.singleton(notesDocumentEntity.getUuid()), notesDocumentEntity.getServerTimestamp().longValue());
    }

    @Transaction
    public void deleteByUuid(Collection<String> collection, final long j) {
        new SplitTaskExecutor(new Function() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.d
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: apply */
            public final Object mo22196apply(Object obj) {
                return this.f7368a.lambda$deleteByUuid$0(j, (List) obj);
            }
        }).execute(collection);
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            sb.append("\n#deleteByUuid, isDeleted: 1, uuid: ");
            sb.append(str);
        }
        DataLogger.m12305f(TAG, sb.toString());
    }

    @Transaction
    public int deleteByCategoryUuid(NotesMappedDocumentDao notesMappedDocumentDao, Collection<String> collection, long j) {
        int iDeleteByCategoryUuid = 0;
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                iDeleteByCategoryUuid += deleteByCategoryUuid(notesMappedDocumentDao, it.next(), j);
            }
        }
        return iDeleteByCategoryUuid;
    }
}
