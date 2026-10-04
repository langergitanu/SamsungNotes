package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.CategoryTimeTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.FolderFinder;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesCategoryTreeDao implements BaseDao<NotesCategoryTreeEntity> {
    private static final String TAG = DataLogger.createTag("NotesCategoryTreeDao");

    private String findAndMakeCategory(@NonNull Context context, @NonNull DocumentCategoryTree documentCategoryTree, @NonNull String str, int i, boolean z, boolean z2) {
        PredefinedCategory predefinedCategory = z2 ? PredefinedCategory.UNCATEGORIZED : PredefinedCategory.RECYCLE_BIN;
        FolderFinder.Result resultFind = new FolderFinder(predefinedCategory).find(str);
        if (!resultFind.getFolderUuid().isEmpty()) {
            return resultFind.getFolderUuid();
        }
        PredefinedCategory rootFolder = resultFind.getRootFolder();
        String[] pathArray = resultFind.getPathArray();
        int length = pathArray.length;
        if (z) {
            length--;
        }
        StringBuilder sb = new StringBuilder(rootFolder.getPath());
        String uuid = rootFolder.getUuid();
        long currentTime = TimeManager.getCurrentTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String uuid2 = uuid;
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = pathArray[i2];
            if (i2 > 0) {
                sb.append(File.separator);
            }
            sb.append(str2);
            if (documentCategoryTree.existPath(sb.toString())) {
                NotesFolder notesFolderFind = documentCategoryTree.find(sb.toString());
                uuid2 = notesFolderFind != null ? notesFolderFind.getUuid() : predefinedCategory.getUuid();
            } else {
                String strNewUUID = UUIDUtils.newUUID(context);
                insertFolder(strNewUUID, uuid2, str2, i, null, currentTime, jCurrentTimeMillis, z2);
                uuid2 = strNewUUID;
            }
        }
        return uuid2;
    }

    private Set<String> getUpdateServerTimestampTargetFolders(NotesFolder notesFolder) {
        HashSet hashSet = new HashSet();
        while (!PredefinedCategory.isRootFolder(notesFolder.getUuid())) {
            hashSet.add(notesFolder.getUuid());
            notesFolder = notesFolder.getParent();
        }
        return hashSet;
    }

    private boolean isMovable(String str, @Nullable NotesFolder notesFolder, @NonNull NotesFolder notesFolder2) {
        if (notesFolder == null) {
            AbstractC11014a.m12314C("isMovable, source folder not exist. uuid: ", str, TAG);
            return false;
        }
        if (!Objects.equals(notesFolder.getParentUuid(), notesFolder2.getUuid())) {
            return true;
        }
        DataLogger.m12303e(TAG, "isMovable, not need to move this folder");
        return false;
    }

    private void moveInTrash(String str, String str2, long j, long j2, String str3) {
        if (Objects.equals(str, str2)) {
            return;
        }
        deleteMovingCategory(str);
        moveToParent(str, str2);
        changeParentUuid(str, str2, j, j2, str3);
    }

    private void restoreDocsOfCurrentFolder(@NonNull NotesDocumentDao notesDocumentDao, String str, long j) {
        notesDocumentDao.restoreByCategoryUuid(str, j);
    }

    private String restoreToTargetFolder(@NonNull Context context, @NonNull NotesDocumentDao notesDocumentDao, String str, long j, long j2, DocumentCategoryTree documentCategoryTree, NotesFolder notesFolder) {
        NotesFolder notesFolderFind = documentCategoryTree.find(notesFolder.getRestorePath());
        if (notesFolderFind == null || notesFolderFind.getIsDeleted() != 0) {
            String strFindAndMakeParentCategory = findAndMakeParentCategory(context, documentCategoryTree, notesFolder.getRestorePath());
            move(str, strFindAndMakeParentCategory, j, j2);
            return strFindAndMakeParentCategory;
        }
        String uuid = notesFolderFind.getUuid();
        merge(notesDocumentDao, documentCategoryTree, notesFolderFind, notesFolder, j, j2);
        return uuid;
    }

    private String updateRestorePath(@Nullable String str, @NonNull String str2) {
        if (str == null || str2.isEmpty()) {
            return str;
        }
        String str3 = "uncategorized:///";
        if (!str.startsWith("uncategorized:///")) {
            str3 = CategoryConstants.OldUncategorized.PATH;
            if (!str.startsWith(CategoryConstants.OldUncategorized.PATH)) {
                str3 = CategoryConstants.OldScreenOffMemo.PATH;
                if (!str.startsWith(CategoryConstants.OldScreenOffMemo.PATH)) {
                    return str;
                }
            }
        }
        return str2.replace("trash:///", str3);
    }

    @Query("UPDATE OR ABORT category_tree SET parentUUID=:parentUuid , isDirty=1 , serverTimeStamp=:serverTimestamp , lastModifiedAt=:lastModifiedAt WHERE UUID=:uuid")
    public abstract void changeParentUuid(String str, String str2, long j, long j2);

    @Query("UPDATE OR ABORT category_tree SET parentUUID=:parentUuid , isDirty=1 , serverTimeStamp=:serverTimestamp , lastModifiedAt=:lastModifiedAt , path=:restorePath WHERE UUID=:uuid")
    public abstract void changeParentUuid(String str, String str2, long j, long j2, String str3);

    @Transaction
    public int delete(NotesFolder notesFolder, long j, long j2) {
        String uuid = notesFolder.getUuid();
        String str = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("#deleteInternal, isDeleted: 1, folderUuid: ", uuid, ", backtrace : ");
        sbM15l.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        DataLogger.m12305f(str, sbM15l.toString());
        moveToTrash(uuid, notesFolder.getAbsolutePath(), 0L, j);
        int iUpdateDelete = updateDelete(uuid, j, j2);
        deleteCategoryTreeClosureSubTree(uuid);
        return iUpdateDelete;
    }

    @Query("DELETE FROM category_tree WHERE UUID = :uuid")
    public abstract void delete(String str);

    @Query("UPDATE OR ABORT category_tree SET isDeleted=1 , serverTimestamp=:serverTimestamp , isDirty=1 WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :uuid)")
    public abstract void deleteAllCategorySubTree(String str, long j);

    @Transaction
    public void deleteByUuidWithDocumentDelete(NotesDocumentDao notesDocumentDao, NotesMappedDocumentDao notesMappedDocumentDao, long j, Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            delete(it.next(), j);
        }
        notesDocumentDao.deleteByCategoryUuid(notesMappedDocumentDao, collection, j);
    }

    @Query("DELETE FROM category_tree_closure WHERE descendant IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :folderUuid)")
    public abstract void deleteCategoryTreeClosureSubTree(String str);

    @Transaction
    public void deleteFromTable(String str) {
        delete(str);
        deleteCategoryTreeClosureSubTree(str);
    }

    @Query("DELETE FROM category_tree_closure WHERE descendant IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :targetUuid) AND ancestor IN (SELECT ancestor FROM category_tree_closure WHERE descendant = :targetUuid AND ancestor != descendant)")
    public abstract void deleteMovingCategory(String str);

    public String findAndMakeParentCategory(@NonNull Context context, @NonNull DocumentCategoryTree documentCategoryTree, @NonNull String str) {
        return findAndMakeCategory(context, documentCategoryTree, str, -1, true, true);
    }

    @Query("SELECT UUID FROM category_tree WHERE displayName = :name AND category_tree.isDeleted = 0")
    public abstract List<String> findUuidListByDisplayName(String str);

    @Query("SELECT UUID FROM category_tree WHERE displayName = :name")
    public abstract List<String> findUuidListByDisplayNameIncludeDeleted(String str);

    @Query("SELECT UUID FROM category_tree WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :uuid)")
    public abstract List<String> getAllCategorySubTreeUuid(String str);

    @Query("SELECT tree.*, clo.depth, CASE :includeDocumentCount  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL AND UUID NOT IN (:excludedUuidList)) AND tree.UUID NOT IN (:excludedUuidList) ORDER BY clo.depth ASC")
    public abstract LiveData<List<NotesFolder>> getAllCategory_LiveData(Collection<String> collection, boolean z);

    @Query("SELECT tree.*, clo.depth, CASE :includeDocumentCount  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL) ORDER BY clo.depth ASC")
    public abstract LiveData<List<NotesFolder>> getAllCategory_LiveData(boolean z);

    @Transaction
    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z) {
        return new DocumentCategoryTree(getAllNotesFolders(z));
    }

    @Query("SELECT tree.*, clo.depth, CASE :includeDocumentCount  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL) ORDER BY clo.depth ASC")
    public abstract List<NotesFolder> getAllNotesFolders(boolean z);

    @Query("SELECT COUNT(*) FROM category_tree WHERE parentUUID = :parentUuid AND category_tree.isDeleted = 0 AND UUID NOT IN (:excludedFolders)")
    public abstract int getChildrenCount(String str, Set<String> set);

    @Query("SELECT UUID FROM category_tree WHERE parentUUID = :uuid AND isDeleted != 1")
    public abstract List<String> getChildrenUuids(String str);

    @Query("SELECT * FROM category_tree ORDER BY UUID ASC")
    public abstract List<NotesCategoryTreeEntity> getEntities();

    @Transaction
    public List<NotesCategoryTreeEntity> getEntities(Collection<String> collection) {
        return new SplitTaskExecutor(new C8886c(this, 21)).execute(collection);
    }

    @Query("SELECT * FROM category_tree WHERE UUID IN (:uuids) ORDER BY UUID ASC")
    public abstract List<NotesCategoryTreeEntity> getEntitiesInChunk(Collection<String> collection);

    @Query("SELECT * FROM category_tree WHERE UUID = :targetUuid")
    public abstract NotesCategoryTreeEntity getEntity(String str);

    @Query("SELECT UUID FROM category_tree WHERE recycle_bin_time_moved<:expiredTime AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2 AND parentUUID='trash:///'")
    public abstract List<String> getExpiredRecycleBinDataNotInFolder(long j);

    @Query("SELECT tree.*, clo.depth, CASE :includeDocumentCount  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc                 WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON (tree.UUID = clo.descendant) WHERE clo.ancestor = :targetUuid ORDER BY clo.depth ASC LIMIT 1")
    public abstract NotesFolder getNotesFolder(String str, boolean z);

    @Query("SELECT tree.*, clo.depth, CASE :includeDocumentCount  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc                 WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON (tree.UUID = clo.descendant) WHERE clo.ancestor = :targetUuid ORDER BY clo.depth ASC")
    public abstract List<NotesFolder> getNotesFolders(String str, boolean z);

    @Query("SELECT UUID, serverTimestamp FROM category_tree WHERE UUID IN (SELECT ancestor FROM category_tree_closure WHERE descendant = :uuid)")
    public abstract List<CategoryTimeTuple> getParentsCategoryUuidList(String str);

    @NonNull
    public String getTargetPath(NotesFolder notesFolder, NotesFolder notesFolder2) {
        StringBuilder sb = new StringBuilder();
        sb.append(notesFolder2.getAbsolutePath());
        if (PredefinedCategory.find(notesFolder2.getUuid()) == null) {
            sb.append(File.separator);
        }
        sb.append(notesFolder.getDisplayName());
        return sb.toString();
    }

    @Query("SELECT UUID FROM category_tree WHERE REPLACE(LOWER(displayName), ' ', '') LIKE '%' || (:name) || '%' AND category_tree.isDeleted = 0")
    public abstract List<String> getUuidsByDisplayName(String str);

    @Query("INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) SELECT ancestor, (:folderUuid), depth + 1 FROM category_tree_closure WHERE descendant = (:parentFolderUuid) UNION ALL SELECT (:folderUuid), (:folderUuid), 0")
    public abstract long insertCategoryClosure(String str, String str2);

    public void insertCategoryClosure(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        long jInsertCategoryClosure = insertCategoryClosure(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid() == null ? "" : notesCategoryTreeEntity.getParentUuid());
        DataLogger.m12307i(TAG, "insertCategoryClosure, result: " + jInsertCategoryClosure);
    }

    @Transaction
    public void insertFolder(String str, @Nullable String str2, String str3, int i, @Nullable String str4, long j, long j2, boolean z) {
        NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(str, str2, str3, i, str4);
        notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(j));
        notesCategoryTreeEntity.setLastModifiedAt(j2);
        notesCategoryTreeEntity.setCreatedAt(j2);
        notesCategoryTreeEntity.setIsDeleted(z ? 0 : 2);
        notesCategoryTreeEntity.setRecycleBinTimeMoved(z ? 0L : j2);
        insertFolder(notesCategoryTreeEntity);
    }

    @Query("SELECT 1 FROM category_tree WHERE UUID = :uuid AND category_tree.isDeleted = 0")
    public abstract boolean isUsed(String str);

    public void merge(NotesDocumentDao notesDocumentDao, @NonNull DocumentCategoryTree documentCategoryTree, @NonNull NotesFolder notesFolder, NotesFolder notesFolder2, long j, long j2) {
        if (notesFolder2 == null) {
            return;
        }
        for (NotesFolder notesFolder3 : notesFolder2.getChildren()) {
            NotesFolder notesFolderFind = documentCategoryTree.find(notesFolder3.getRestorePath());
            if (notesFolderFind == null || notesFolderFind.getIsDeleted() != 0) {
                move(notesFolder3.getUuid(), notesFolder.getUuid(), j, j2);
            } else {
                merge(notesDocumentDao, documentCategoryTree, notesFolderFind, notesFolder3, j, j2);
            }
        }
        deleteMovingCategory(notesFolder2.getUuid());
        delete(notesFolder2, j, j2);
        notesDocumentDao.updateCategoryByCategoryUuid(notesFolder2.getUuid(), notesFolder.getUuid());
    }

    public void move(String str, String str2, long j, long j2) {
        if (Objects.equals(str, str2)) {
            return;
        }
        deleteMovingCategory(str);
        moveToParent(str, str2);
        changeParentUuid(str, str2, j, j2);
    }

    @Query("INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) SELECT supertree.ancestor, subtree.descendant, supertree.depth + subtree.depth + 1 FROM category_tree_closure AS supertree CROSS JOIN category_tree_closure AS subtree WHERE supertree.descendant = :parentUuid AND subtree.ancestor = :targetUuid")
    public abstract void moveToParent(String str, String str2);

    public void moveToRecycleBin(NotesFolder notesFolder, long j, long j2, @NonNull NotesDocumentDao notesDocumentDao) {
        moveToRecycleBin(notesFolder, j, j2, notesDocumentDao, 1);
    }

    @Query("UPDATE OR ABORT category_tree SET path=:path , isDeleted=2 , recycle_bin_time_moved=:recyclerMovedTime , serverTimestamp=:serverTimestamp , isDirty=1 WHERE UUID=:uuid")
    public abstract void moveToTrash(String str, String str2, long j, long j2);

    @RawQuery(observedEntities = {NotesCategoryTreeEntity.class})
    public abstract List<NotesCategoryTreeEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @Transaction
    public void reorder(String str, Collection<? extends NotesCategoryTreeEntity> collection, long j, long j2) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : collection) {
            if (notesCategoryTreeEntity != null && Objects.equals(str, notesCategoryTreeEntity.getParentUuid())) {
                if (notesCategoryTreeEntity.getCreatedAt() == 0) {
                    notesCategoryTreeEntity.setCreatedAt(j2);
                }
                notesCategoryTreeEntity.setLastModifiedAt(j2);
                notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(j));
                notesCategoryTreeEntity.setIsDirty(1);
                arrayList.add(notesCategoryTreeEntity);
            }
        }
        insertFolder(arrayList);
    }

    public void restore(NotesFolder notesFolder, @NonNull NotesDocumentDao notesDocumentDao, long j) {
        restore(notesFolder, notesDocumentDao, j, 1);
    }

    @Query("UPDATE OR ABORT category_tree SET path=:path , isDeleted=0 , recycle_bin_time_moved=:recyclerMovedTime , serverTimestamp=:serverTimestamp , isDirty=1 WHERE UUID=:uuid")
    public abstract void restoreFromTrash(String str, String str2, long j, long j2);

    public void setRestorePathToMerge(@NonNull String str, NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        notesFolder.setRestorePath(str);
        for (NotesFolder notesFolder2 : notesFolder.getChildren()) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(File.separator);
            sbM1324q.append(notesFolder2.getDisplayName());
            setRestorePathToMerge(sbM1324q.toString(), notesFolder2);
        }
    }

    @Update
    public abstract int update(Collection<? extends NotesCategoryTreeEntity> collection);

    @Query("UPDATE OR ABORT category_tree SET isDeleted=1 , serverTimestamp=:serverTimestamp WHERE UUID=:uuid")
    public abstract int updateDelete(String str, long j);

    @Query("UPDATE OR ABORT category_tree SET isDeleted=1 , parentUUID='trash:///' , serverTimestamp=:serverTimestamp , lastModifiedAt=:lastModifiedAt , isDirty=1 WHERE UUID=:uuid")
    public abstract int updateDelete(String str, long j, long j2);

    public List<NotesCategoryTreeEntity> updateDocumentAndCreateFolderForRestore(@NonNull NotesDocumentEntity notesDocumentEntity, @NonNull Context context, @NonNull DocumentCategoryTree documentCategoryTree, @NonNull String str, int i, boolean z) {
        String strNewUUID;
        ArrayList arrayList = new ArrayList();
        FolderFinder.Result resultFind = new FolderFinder(PredefinedCategory.UNCATEGORIZED).find(str);
        if (!resultFind.getFolderUuid().isEmpty()) {
            notesDocumentEntity.setCategoryUuid(resultFind.getFolderUuid());
            return arrayList;
        }
        PredefinedCategory rootFolder = resultFind.getRootFolder();
        String[] pathArray = resultFind.getPathArray();
        int length = pathArray.length;
        if (z) {
            length--;
        }
        StringBuilder sb = new StringBuilder(rootFolder.getPath());
        String uuid = rootFolder.getUuid();
        long currentTime = TimeManager.getCurrentTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (i2 < length) {
            String str2 = pathArray[i2];
            if (i2 > 0) {
                sb.append(File.separator);
            }
            sb.append(str2);
            if (documentCategoryTree.existPath(sb.toString())) {
                NotesFolder notesFolderFind = documentCategoryTree.find(sb.toString());
                strNewUUID = notesFolderFind != null ? notesFolderFind.getUuid() : PredefinedCategory.UNCATEGORIZED.getUuid();
            } else {
                strNewUUID = UUIDUtils.newUUID(context);
                NotesFolder notesFolder = new NotesFolder(strNewUUID, uuid, str2, null);
                notesFolder.setDisplayNameColor(i);
                notesFolder.setCreatedAt(jCurrentTimeMillis);
                notesFolder.setLastModifiedAt(jCurrentTimeMillis);
                notesFolder.setServerTimeStamp(Long.valueOf(currentTime));
                arrayList.add(notesFolder);
                documentCategoryTree.addFolder(notesFolder);
            }
            notesDocumentEntity.setCategoryUuid(strNewUUID);
            i2++;
            uuid = strNewUUID;
        }
        return arrayList;
    }

    @Query("UPDATE OR ABORT category_tree SET lastModifiedAt =:modifiedAt WHERE UUID=:uuid")
    public abstract void updateModifiedTime(String str, long j);

    @Transaction
    public void updateModifiedTimeWithUuidList(Collection<CategoryTimeTuple> collection) {
        for (CategoryTimeTuple categoryTimeTuple : collection) {
            updateModifiedTime(categoryTimeTuple.categoryUuid, categoryTimeTuple.time.longValue());
        }
    }

    @Query("UPDATE OR ABORT category_tree SET serverTimestamp =:serverTimestamp , isDirty=1  WHERE UUID=:uuid")
    public abstract void updateServerTimestamp(String str, long j);

    @Transaction
    public void updateServerTimestampWithUuidList(Collection<CategoryTimeTuple> collection) {
        for (CategoryTimeTuple categoryTimeTuple : collection) {
            updateServerTimestamp(categoryTimeTuple.categoryUuid, categoryTimeTuple.time.longValue());
        }
    }

    public void moveToRecycleBin(NotesFolder notesFolder, long j, long j2, @NonNull NotesDocumentDao notesDocumentDao, int i) {
        if (notesFolder == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "#delete, isDeleted: 2, depth: ", ", folderUuid: ");
        sbM778t.append(notesFolder.getUuid());
        DataLogger.m12305f(str, sbM778t.toString());
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            moveToRecycleBin(it.next(), j, j2, notesDocumentDao, i + 1);
        }
        moveToTrash(notesFolder.getUuid(), notesFolder.getAbsolutePath(), j, j2);
        notesDocumentDao.moveToRecycleBinByCategoryUuid(notesFolder.getUuid(), j, j2, notesFolder.getAbsolutePath());
    }

    public void restore(NotesFolder notesFolder, @NonNull NotesDocumentDao notesDocumentDao, long j, int i) {
        if (notesFolder == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "#restore, depth: ", ", folderUuid: ");
        sbM778t.append(notesFolder.getUuid());
        DataLogger.m12305f(str, sbM778t.toString());
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            restore(it.next(), notesDocumentDao, j, i + 1);
        }
        restoreFromTrash(notesFolder.getUuid(), "", 0L, j);
        restoreDocsOfCurrentFolder(notesDocumentDao, notesFolder.getUuid(), j);
    }

    @Transaction
    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z, boolean z2) {
        return new DocumentCategoryTree(getAllNotesFolders(z), z2);
    }

    @Transaction
    public DocumentCategoryTree getAllDocumentCategoryTree(String str, boolean z) {
        return new DocumentCategoryTree(getNotesFolders(str, z));
    }

    @Transaction
    public boolean move(Context context, NotesDocumentDao notesDocumentDao, String str, String str2, long j, long j2) {
        DocumentCategoryTree allDocumentCategoryTree = getAllDocumentCategoryTree(false);
        NotesFolder folder = allDocumentCategoryTree.getFolder(str);
        NotesFolder folder2 = allDocumentCategoryTree.getFolder(str2);
        if (folder2 == null) {
            AbstractC11014a.m12314C("move, target folder does not exist. uuid : ", str2, TAG);
            return false;
        }
        if (!isMovable(str, folder, folder2)) {
            return false;
        }
        String targetPath = getTargetPath(folder, folder2);
        NotesFolder notesFolderFind = allDocumentCategoryTree.find(targetPath);
        if (notesFolderFind != null && notesFolderFind.getIsDeleted() == 0) {
            setRestorePathToMerge(targetPath, folder);
            merge(notesDocumentDao, allDocumentCategoryTree, notesFolderFind, folder, j, j2);
            return true;
        }
        move(str, findAndMakeCategory(context, allDocumentCategoryTree, -1, folder2.getAbsolutePath()), j, j2);
        return true;
    }

    @Transaction
    public boolean moveInTrash(Context context, Collection<String> collection, NotesDocumentDao notesDocumentDao, String str, long j, long j2) {
        long j3;
        DocumentCategoryTree allDocumentCategoryTree = getAllDocumentCategoryTree(false, true);
        NotesFolder folder = allDocumentCategoryTree.getFolder(str);
        if (folder == null) {
            AbstractC11014a.m12314C("isMovable, target folder does not exist. uuid : ", str, TAG);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : getEntities(collection)) {
            NotesFolder folder2 = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid());
            if (isMovable(notesCategoryTreeEntity.getUuid(), folder2, folder)) {
                NotesFolder folder3 = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getParentUuid());
                String targetPath = getTargetPath(folder2, folder);
                NotesFolder notesFolderFind = allDocumentCategoryTree.find(targetPath);
                if (notesFolderFind == null) {
                    DocumentCategoryTree documentCategoryTree = allDocumentCategoryTree;
                    moveInTrash(notesCategoryTreeEntity.getUuid(), findAndMakeCategory(context, documentCategoryTree, folder.getAbsolutePath(), -1, false, false), j, j2, updateRestorePath(notesCategoryTreeEntity.getRestorePath(), targetPath));
                    allDocumentCategoryTree = documentCategoryTree;
                    j3 = j2;
                } else {
                    setRestorePathToMerge(targetPath, folder2);
                    j3 = j2;
                    merge(notesDocumentDao, allDocumentCategoryTree, notesFolderFind, folder2, j, j3);
                }
                updateModifiedTime(folder3.getUuid(), j3);
                updateModifiedTime(folder.getUuid(), j3);
                hashSet.addAll(getUpdateServerTimestampTargetFolders(folder3));
                hashSet.addAll(getUpdateServerTimestampTargetFolders(folder3));
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            updateServerTimestamp((String) it.next(), j);
        }
        return true;
    }

    @Transaction
    public void insertFolder(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        Pair<AtomicInteger, AtomicInteger> pairUpsert = upsert(notesCategoryTreeEntity);
        DataLogger.m12307i(TAG, "insert, result: " + pairUpsert.toString());
        if (((AtomicInteger) pairUpsert.first).get() > 0) {
            insertCategoryClosure(notesCategoryTreeEntity);
        }
    }

    @Transaction
    public void insertFolder(Collection<? extends NotesCategoryTreeEntity> collection) {
        Iterator<? extends NotesCategoryTreeEntity> it = collection.iterator();
        while (it.hasNext()) {
            insertFolder(it.next());
        }
    }

    @Transaction
    public int delete(String str, long j) {
        DataLogger.m12305f(TAG, "#delete, isDeleted: 1, folderUuid: " + str);
        int iUpdateDelete = updateDelete(str, j);
        deleteAllCategorySubTree(str, j);
        deleteCategoryTreeClosureSubTree(str);
        return iUpdateDelete;
    }

    @Transaction
    public boolean moveToRecycleBin(String str, long j, long j2, NotesDocumentDao notesDocumentDao, DocumentCategoryTree documentCategoryTree) {
        NotesFolder folder = documentCategoryTree.getFolder(str);
        if (folder == null) {
            AbstractC11014a.m12314C("moveToRecycleBin, Target category not exist. uuid : ", str, TAG);
            return false;
        }
        moveToRecycleBin(folder, j, j2, notesDocumentDao);
        changeParentUuid(folder.getUuid(), "trash:///", j2, j);
        deleteMovingCategory(str);
        moveToParent(str, "trash:///");
        return true;
    }

    @Transaction
    public void restore(Collection<? extends NotesCategoryTreeEntity> collection, Collection<? extends NotesCategoryTreeEntity> collection2) {
        update(collection);
        Iterator<? extends NotesCategoryTreeEntity> it = collection2.iterator();
        while (it.hasNext()) {
            insertCategoryClosure(it.next());
        }
    }

    @Transaction
    public String restore(Context context, NotesDocumentDao notesDocumentDao, String str, long j, long j2) {
        if (str == null) {
            DataLogger.m12303e(TAG, "restore, folderUuid is null!");
            return null;
        }
        DocumentCategoryTree allDocumentCategoryTree = getAllDocumentCategoryTree(false);
        NotesFolder folder = allDocumentCategoryTree.getFolder(str);
        if (folder == null) {
            DataLogger.m12303e(TAG, "restore, folder entity not exist. uuid : ".concat(str));
            return null;
        }
        restore(folder, notesDocumentDao, j);
        return restoreToTargetFolder(context, notesDocumentDao, str, j, j2, allDocumentCategoryTree, folder);
    }

    public String findAndMakeCategory(@NonNull Context context, @NonNull DocumentCategoryTree documentCategoryTree, int i, @NonNull String str) {
        return findAndMakeCategory(context, documentCategoryTree, str, i, false, true);
    }
}
