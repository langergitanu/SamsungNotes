package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncCategoryTreeDao extends NotesCategoryTreeDao {
    @Query("DELETE FROM category_tree WHERE UUID = :uuid")
    public abstract void deleteCategory(String str);

    @Query("DELETE FROM category_tree_closure WHERE descendant = :uuid")
    public abstract void deleteCategoryClosure(String str);

    @Query("UPDATE OR ABORT category_tree SET isDirty=:dirtyFlag  , serverTimestamp=:categoryServerTime , isDeleted=1  WHERE UUID=:categoryUuid")
    public abstract void deleteOldCategory(String str, long j, int i);

    @Query("DELETE FROM category_tree WHERE UUID != 'uncategorized:///' OR UUID != 'trash:///'")
    public abstract void deleteUserFolder_CategoryTree();

    @Query("DELETE FROM category_tree_closure WHERE descendant != 'uncategorized:///' OR descendant != 'trash:///'")
    public abstract void deleteUserFolder_CategoryTreeClosure();

    @Query("SELECT * FROM category_tree_closure ORDER BY descendant,ancestor ASC")
    public abstract List<NotesCategoryTreeClosureEntity> dumpCategoryTreeClosure();

    @Query("SELECT * FROM category_tree WHERE isDeleted=1 AND UUID NOT IN (SELECT descendant FROM category_tree_closure WHERE ancestor = 'old:///')")
    public abstract List<NotesCategoryTreeEntity> getAllDeletedCategoryEntityForSync();

    @Query("SELECT * FROM category_tree WHERE isDirty=1 AND UUID NOT IN (SELECT descendant FROM category_tree_closure WHERE ancestor = 'old:///')")
    public abstract List<NotesCategoryTreeEntity> getAllDirtyCategoryEntityForSync();

    @Query("SELECT tree.*, clo.depth, (SELECT COUNT(*) FROM sdoc WHERE sdoc.categoryUUID=tree.UUID) AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE clo.ancestor IN (SELECT uuid FROM category_tree WHERE parentUUID IS NULL) GROUP BY tree.UUID, clo.depth ORDER BY clo.depth ASC")
    public abstract List<NotesFolder> getAllNotesFoldersForSync();

    @Query("SELECT * FROM category_tree WHERE isDirty = :dirtyFlag AND (parentUUID != '' AND parentUUID != 'old:///')")
    public abstract List<NotesCategoryTreeEntity> getDirtyList(int i);

    @Query("SELECT * FROM category_tree WHERE displayName=:name AND parentUUID=:parentUuid AND UUID!=:uuid AND category_tree.isDeleted = 0 LIMIT 1")
    public abstract NotesCategoryTreeEntity getEntityByParentUuidAndName(String str, String str2, String str3);

    @Query("SELECT * FROM category_tree  WHERE parentUUID=:parentUuid")
    public abstract List<NotesCategoryTreeEntity> getEntityListByParentUuid(String str);

    @Query("SELECT COUNT(*) FROM category_tree  WHERE isSyncWithMS=1")
    public abstract int getFeedEnabledFolderCount();

    @Query("SELECT UUID FROM category_tree  WHERE isSyncWithMS=1")
    public abstract List<String> getFeedEnabledFolders();

    @Query("SELECT isSyncWithMS FROM category_tree WHERE UUID =:uuid")
    public abstract int getIsSyncWithMS(String str);

    @Query("SELECT MAX(serverTimestamp) FROM category_tree WHERE (parentUUID != '' AND parentUUID != 'old:///')")
    public abstract long getMaxSyncModifiedTimeFromFolders();

    @Query("SELECT UUID FROM category_tree WHERE (parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///')")
    public abstract List<String> getOldCategoryUuidList();

    @Query("SELECT UUID FROM category_tree WHERE isDirty = :dirtyFlag AND (parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///')")
    public abstract List<String> getOldCategoryUuidListByDirty(int i);

    @Query("SELECT UUID FROM category_tree WHERE (parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///') ORDER BY displayName ASC")
    public abstract List<String> getOldCategoryUuidListIncludeDeletedOrderByAsc();

    @Query("SELECT UUID FROM category_tree WHERE ( category_tree.isDeleted = 0 AND parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///') ORDER BY displayName ASC")
    public abstract List<String> getOldCategoryUuidListOrderByAsc();

    @Query("SELECT orderBy FROM category_tree WHERE (parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///') ORDER BY orderBy ASC")
    public abstract int getOldLastOrder();

    @Query("SELECT UUID, serverTimestamp, isDirty, isDeleted, lastModifiedAt, recycle_bin_time_moved, displayNameColor, orderBy FROM category_tree WHERE UUID =:uuid")
    public abstract SyncCategoryTreeInfo getSyncEntity(String str);

    @Query("SELECT UUID, serverTimestamp, isDirty, isDeleted, lastModifiedAt, recycle_bin_time_moved, displayNameColor, orderBy FROM category_tree WHERE (parentUUID != '' AND parentUUID != 'old:///')")
    public abstract List<SyncCategoryTreeInfo> getSyncEntityList();

    @Query("SELECT COUNT(*) FROM category_tree WHERE (parentUUID != '' AND parentUUID != 'old:///')")
    public abstract int getTotalNumberOfFolders();

    @Query("SELECT UUID FROM category_tree  WHERE (parentUUID = 'uncategorized:///') AND isDeleted=2")
    public abstract List<String> getUuidListByTrashedUnCategorized();

    @Query("SELECT UUID FROM category_tree  WHERE (parentUUID = 'old:///' AND UUID != '1' AND UUID != '2' AND UUID != 'old:///')ORDER BY orderBy DESC")
    public abstract List<String> getUuidListWithOrder();

    @Query("UPDATE OR ABORT category_tree SET isDirty=:dirty , serverTimestamp=:serverTimestamp , orderBy=:reorder  , isDeleted=:isDeleted  WHERE UUID=:folderUuid")
    public abstract void recoveryCategoryForOldCategory(String str, int i, long j, int i2, int i4);

    @Query("UPDATE OR ABORT category_tree SET displayName=:folderName  , displayNameColor=:folderNameColor  WHERE UUID=:folderUuid")
    public abstract void setDisplayNameAndColorForOldCategory(String str, String str2, int i);

    @Query("UPDATE OR ABORT category_tree SET displayNameColor=:color  WHERE UUID=:uuid")
    public abstract void setDisplayNameColor(String str, int i);

    @Query("UPDATE OR ABORT category_tree SET orderBy=:orderBy  WHERE UUID=:categoryUuid")
    public abstract void setOldCategoryOrder(String str, int i);

    @Query("UPDATE OR ABORT category_tree SET orderBy=:order  WHERE UUID=:uuid")
    public abstract void setOrderBy(String str, int i);

    @Query("UPDATE OR ABORT category_tree SET serverTimestamp=:serverTimestamp  , isDirty=:dirty  WHERE UUID=:folderUuid")
    public abstract void setTimestampAndDirtyForOldCategory(String str, long j, int i);

    @Query("UPDATE OR ABORT category_tree SET isDirty=:dirtyFlag  WHERE UUID=:categoryTreeUuid")
    public abstract void updateIsDirty(String str, int i);

    @Query("UPDATE OR ABORT category_tree SET isDirty=:isDirty  , parentUUID=:parentFolderUuid  , serverTimestamp=:serverTimestamp WHERE UUID=:folderUuid")
    public abstract void updateParentFolder(String str, String str2, long j, int i);
}
