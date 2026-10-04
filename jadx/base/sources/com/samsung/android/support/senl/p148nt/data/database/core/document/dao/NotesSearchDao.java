package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.DocumentTextData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesSearchDao implements BaseDao<NotesDocumentTextSearchEntity> {
    private static final String TAG = DataLogger.createTag("NotesSearchDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        deleteByUuids(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C11252i(this, 0)).execute(collection);
    }

    @Query("DELETE FROM text_search WHERE sdocUUID IN (:docUuids)")
    public abstract void deleteByUuids(Collection<String> collection);

    @Query("DELETE FROM text_search WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Transaction
    public List<DocumentTextData> getDocumentTextData(Collection<String> collection) {
        return new SplitTaskExecutor(new C11252i(this, 1)).execute(collection);
    }

    @Query("SELECT UUID, title, strippedContent FROM (SELECT UUID, title FROM sdoc WHERE UUID IN (:docUuids) AND sdoc.isDeleted = 0) JOIN text_search ON UUID = text_search.sdocUUID")
    public abstract List<DocumentTextData> getDocumentTextDataWithDocUuids(List<String> list);

    @Query("SELECT * FROM text_search WHERE sdocUUID IN (:uuids)")
    public abstract List<NotesDocumentTextSearchEntity> getEntities(Collection<String> collection);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class})
    public abstract List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @Query("SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = ''")
    public abstract boolean isEmptyForSearchLatestNotes();

    @NonNull
    public List<MainListDocumentData> rawQuery(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return new ArrayList();
        }
    }

    @RawQuery(observedEntities = {NotesCategoryTreeEntity.class})
    public abstract List<NotesCategoryTreeEntity> rawQueryForFolder(SupportSQLiteQuery supportSQLiteQuery);

    public List<MainListDocumentData> search(String str, String[] strArr) {
        return rawQuery(new SimpleSQLiteQuery(str, strArr));
    }

    public List<NotesCategoryTreeEntity> searchFolder(String str, String[] strArr) {
        return rawQueryForFolder(new SimpleSQLiteQuery(str, strArr));
    }

    @Query("SELECT * FROM category_tree WHERE category_tree.isDeleted = 0 AND UUID NOT IN (:restrictedFolders) ORDER BY lastModifiedAt DESC LIMIT (:maxCount)")
    public abstract List<NotesCategoryTreeEntity> searchLatestFolders(int i, Collection<String> collection);

    public List<MainListDocumentData> searchLatestNotes(int i) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and("mdeSpaceId = ''").orderBy("lastModifiedAt", SQLKeyword.SortingOrder.DESC).limit(i).build()));
    }

    @Query("SELECT sdoc.UUID, sdoc.title, text_search.strippedContent FROM sdoc JOIN text_search ON sdoc.UUID = text_search.sdocUUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = '' ORDER BY sdoc.lastModifiedAt DESC LIMIT (:maxCount)")
    public abstract List<DocumentTextData> searchLatestNotes2(int i);
}
