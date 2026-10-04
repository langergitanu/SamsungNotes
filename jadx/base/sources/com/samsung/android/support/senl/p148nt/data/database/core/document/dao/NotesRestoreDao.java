package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesRestoreDao {
    private static final String TAG = DataLogger.createTag("NotesRestoreDao");

    private void deleteDummyNewFolders(List<String> list) {
        new SplitTaskExecutor(new C8886c(this, 28)).execute(list);
    }

    private List<String> getExclusionFolders() {
        ArrayList arrayList = new ArrayList();
        for (PredefinedCategory predefinedCategory : PredefinedCategory.values()) {
            arrayList.add(predefinedCategory.getUuid());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteDummyNewFolders$0(List list) {
        deleteDummyNewFoldersInCategoryTree(list);
        deleteDummyNewFoldersInCategoryTreeClosure(list);
        return new ArrayList();
    }

    @Query("DELETE FROM category_tree WHERE UUID IN (:uuids)")
    public abstract void deleteDummyNewFoldersInCategoryTree(List<String> list);

    @Query("DELETE FROM category_tree_closure WHERE descendant IN (:uuids)")
    public abstract void deleteDummyNewFoldersInCategoryTreeClosure(List<String> list);

    @Query("SELECT sdoc.* FROM sdoc WHERE sdoc.isDeleted = 0 AND ( isFavorite NOT IN (0, 1) OR  isLock > 5 OR isLock < -2 ) ")
    public abstract List<NotesDocumentEntity> getCorruptNotes();

    @Query("SELECT UUID FROM category_tree WHERE parentUUID = 'uncategorized:///' AND UUID NOT IN (SELECT ancestor FROM category_tree_closure WHERE depth > 0) AND UUID NOT IN (SELECT categoryUUID FROM sdoc) AND category_tree.isDeleted = 0")
    public abstract List<String> getDummyFolders();

    @Query("SELECT * FROM sdoc WHERE sdoc.categoryUUID IN (SELECT category_tree.UUID FROM category_tree WHERE category_tree.parentUUID = 'old:///') AND sdoc.filePath LIKE '%.sdocx'")
    public abstract List<NotesDocumentEntity> getSdocXInOldFolder();

    @Query("SELECT parentUUID FROM category_tree WHERE UUID='uncategorized:///'")
    public abstract String getUncategorizedFolderParentUuid();

    @Query("INSERT OR REPLACE INTO external_shared_documents (UUID, timestamp) SELECT UUID, lastModifiedAt FROM sdoc WHERE isDeleted != 1 AND mdeSpaceId = ''")
    public abstract void insertToExternalSharedDocuments();

    @Transaction
    public void repairUncategorizedFolder() {
        if (getUncategorizedFolderParentUuid() == null) {
            return;
        }
        List<String> dummyFolders = getDummyFolders();
        dummyFolders.removeAll(getExclusionFolders());
        String str = TAG;
        DataLogger.m12305f(str, "repairUncategorizedFolder, dummyNewFolders, count: " + dummyFolders.size() + ", list: " + dummyFolders);
        deleteDummyNewFolders(dummyFolders);
        resetUncategorizedFolderParentUuid();
        DataLogger.m12305f(str, "repairUncategorizedFolder, uncategorized parentUuid: " + getUncategorizedFolderParentUuid());
    }

    @Query("UPDATE OR ABORT category_tree SET parentUUID = NULL WHERE UUID='uncategorized:///'")
    public abstract void resetUncategorizedFolderParentUuid();

    @Query("UPDATE OR ABORT sdoc SET displayContent=:displayContent WHERE LENGTH(displayContent) > :maxSize")
    public abstract void restoreDisplayContent(byte[] bArr, int i);

    @Update
    public abstract int update(NotesDocumentEntity notesDocumentEntity);

    @Update
    public abstract int update(List<NotesDocumentEntity> list);
}
