package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesDebugDao {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteNotes$0(List list) {
        deleteNotesInChunk(list);
        deleteTextSearchInChunk(list);
        deleteStrokesInChunk(list);
        deleteRetryInChunk(list);
        return null;
    }

    @Transaction
    public void deleteAll() {
        deleteAllDocuments();
        deleteAllTextSearch();
        deleteAllStrokes();
        deleteAllRetry();
    }

    @Query("DELETE FROM sdoc")
    public abstract void deleteAllDocuments();

    @Query("DELETE FROM retry")
    public abstract void deleteAllRetry();

    @Query("DELETE FROM stroke")
    public abstract void deleteAllStrokes();

    @Query("DELETE FROM text_search")
    public abstract void deleteAllTextSearch();

    @Query("DELETE FROM sdoc WHERE UUID!=:exceptUuid AND filePath=:filePath")
    public abstract void deleteDocuments(String str, String str2);

    @Transaction
    public void deleteNotes(List<String> list) {
        new SplitTaskExecutor(new C8886c(this, 24)).execute(list);
    }

    @Query("DELETE FROM sdoc WHERE UUID IN (:uuids)")
    public abstract void deleteNotesInChunk(Collection<String> collection);

    @Query("DELETE FROM retry WHERE sdocUUID IN (:uuids)")
    public abstract void deleteRetryInChunk(Collection<String> collection);

    @Query("DELETE FROM stroke WHERE sdocUUID=:docUuid")
    public abstract void deleteStrokes(String str);

    @Query("DELETE FROM stroke WHERE sdocUUID IN (:uuids)")
    public abstract void deleteStrokesInChunk(Collection<String> collection);

    @Query("DELETE FROM text_search WHERE sdocUUID IN (:uuids)")
    public abstract void deleteTextSearchInChunk(Collection<String> collection);

    @Query("SELECT * FROM sdoc")
    public abstract List<NotesDocumentEntity> dumpDocumentTable();

    @Query("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE isDeleted != 1")
    public abstract List<DocumentData> dumpDocumentsForUsed();

    @Query("SELECT COUNT(*) > 1 AS count FROM sdoc GROUP BY filePath ORDER BY count DESC LIMIT 1")
    public abstract boolean existDirtyRows();

    @Query("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE filePath=:filePath ORDER BY lastModifiedAt DESC, isDeleted ASC")
    public abstract List<DocumentData> findRecentlyUsed(String str);

    @Query("SELECT tree.* FROM category_tree AS tree GROUP BY tree.UUID")
    public abstract List<NotesCategoryTreeEntity> getAllCategoryEntities();

    @Transaction
    public void insert(NotesDocumentEntity notesDocumentEntity, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity, List<NotesStrokeSearchEntity> list, NotesRetryEntity notesRetryEntity) {
        insertDocumentEntity(notesDocumentEntity);
        updateTextSearchEntity(notesDocumentTextSearchEntity.getDocUuid(), notesDocumentTextSearchEntity.getStrippedContent(), notesDocumentTextSearchEntity.getFilePath());
        Iterator<NotesStrokeSearchEntity> it = list.iterator();
        while (it.hasNext()) {
            insertStrokeEntity(it.next());
        }
        insertRetryEntity(notesRetryEntity);
    }

    @Insert(onConflict = 5)
    public abstract void insertDocumentEntity(NotesDocumentEntity notesDocumentEntity);

    @Insert(onConflict = 5)
    public abstract void insertRetryEntity(NotesRetryEntity notesRetryEntity);

    @Insert(onConflict = 5)
    public abstract void insertStrokeEntity(NotesStrokeSearchEntity notesStrokeSearchEntity);

    @Transaction
    public int update(NotesDocumentEntity notesDocumentEntity, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity, List<NotesStrokeSearchEntity> list) {
        int iUpdateDocumentEntity = updateDocumentEntity(notesDocumentEntity);
        updateTextSearchEntity(notesDocumentTextSearchEntity.getDocUuid(), notesDocumentTextSearchEntity.getStrippedContent(), notesDocumentTextSearchEntity.getFilePath());
        deleteStrokes(notesDocumentEntity.getUuid());
        Iterator<NotesStrokeSearchEntity> it = list.iterator();
        while (it.hasNext()) {
            insertStrokeEntity(it.next());
        }
        return iUpdateDocumentEntity;
    }

    @Update(onConflict = 5)
    public abstract int updateDocumentEntity(NotesDocumentEntity notesDocumentEntity);

    @Query("INSERT OR REPLACE INTO text_search (sdocUUID, strippedContent, filePath) VALUES (:uuid, :strippedContent, :path)")
    public abstract void updateTextSearchEntity(String str, String str2, String str3);
}
