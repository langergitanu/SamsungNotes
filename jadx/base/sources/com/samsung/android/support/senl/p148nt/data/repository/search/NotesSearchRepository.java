package com.samsung.android.support.senl.p148nt.data.repository.search;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.DocumentTextData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.impl.repository.search.SemanticSearchRepositoryImpl;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSearchRepository {
    private static final String TAG = DataLogger.createTag("NotesSearchRepository");
    private final NotesDatabase mDatabase;
    private final NotesSearchDao mNotesSearchDao;

    public NotesSearchRepository() {
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        this.mDatabase = notesDatabaseManager;
        this.mNotesSearchDao = notesDatabaseManager.getNotesSearchDao();
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuid, uuids : "), TAG);
        this.mNotesSearchDao.deleteByUuid(collection);
    }

    public void deleteDummy() {
        DataLogger.m12307i(TAG, "deleteDummy");
        this.mNotesSearchDao.deleteDummy();
    }

    public List<DocumentTextData> getDocumentTextData(Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("getDocumentTextData, size: "), TAG);
        return this.mNotesSearchDao.getDocumentTextData(collection);
    }

    public List<NotesDocumentTextSearchEntity> getEntities(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("getEntities, size: "), TAG);
        return this.mNotesSearchDao.getEntities(collection);
    }

    public SemanticSearchRepository getSemanticSearchRepository() {
        return new SemanticSearchRepositoryImpl();
    }

    public boolean isEmptyForSearchLatestNotes() {
        DataLogger.m12307i(TAG, "isEmptyForSearchLatestNotes");
        return this.mNotesSearchDao.isEmptyForSearchLatestNotes();
    }

    public Cursor query(@NonNull String str) {
        DataLogger.m12307i(TAG, "query, trace: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        return this.mDatabase.query(new SimpleSQLiteQuery(str));
    }

    public List<MainListDocumentData> search(String str, String[] strArr) {
        DataLogger.m12307i(TAG, "search");
        return this.mNotesSearchDao.search(str, strArr);
    }

    public List<NotesCategoryTreeEntity> searchFolder(String str, String[] strArr) {
        DataLogger.m12307i(TAG, "searchFolder");
        return this.mNotesSearchDao.searchFolder(str, strArr);
    }

    public List<NotesCategoryTreeEntity> searchLatestFolders(int i, @NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "searchLatestFolders");
        return this.mNotesSearchDao.searchLatestFolders(i, collection);
    }

    public List<MainListDocumentData> searchLatestNotes(int i) {
        DataLogger.m12307i(TAG, "searchLatestNotes");
        return this.mNotesSearchDao.searchLatestNotes(i);
    }

    public List<DocumentTextData> searchLatestNotes2(int i) {
        DataLogger.m12307i(TAG, "searchLatestNotes2");
        return this.mNotesSearchDao.searchLatestNotes2(i);
    }
}
