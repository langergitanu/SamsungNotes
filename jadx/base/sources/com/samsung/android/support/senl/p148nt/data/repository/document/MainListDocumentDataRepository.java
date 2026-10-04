package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MainListDocumentDataRepository {
    private static final String TAG = DataLogger.createTag("MainListDocumentDataRepository");
    private final MainListDocumentDataDao mMainListDocumentDao;
    private final NotesConvertedDocumentDao mNotesConvertedDocumentDao;
    private final NotesOldDocumentDao mNotesOldDocumentDao;

    public MainListDocumentDataRepository() {
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        this.mNotesOldDocumentDao = notesDatabaseManager.getOldDocumentDao();
        this.mNotesConvertedDocumentDao = notesDatabaseManager.getConvertedDocumentDao();
        this.mMainListDocumentDao = notesDatabaseManager.getMainListDocumentDataDao();
    }

    public MainListDocumentData get(@NonNull String str) {
        AbstractC0000a.m2C("get, uuid : ", str, TAG);
        return this.mMainListDocumentDao.getEntity(str);
    }

    public List<MainListDocumentData> getAll(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll: " + sortParam);
        return this.mMainListDocumentDao.getAll(0, sortParam);
    }

    public List<MainListDocumentData> getAllByTagNormalizedNames(SortParam sortParam, @NonNull Set<String> set) {
        DataLogger.m12302d(TAG, "getAllByTagNormalizedNames");
        return this.mMainListDocumentDao.getAllByTagNormalizedNames(sortParam, set);
    }

    public List<MainListDocumentData> getAllContentShare(SortParam sortParam, String str) {
        DataLogger.m12307i(TAG, "getAllContentShare");
        return this.mMainListDocumentDao.getAllContentShare(0, sortParam, str);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllContentShare_LiveData(SortParam sortParam, String str) {
        DataLogger.m12307i(TAG, "getAllContentShare_LiveData");
        return this.mMainListDocumentDao.getAllContentShare_LiveData(0, sortParam, str);
    }

    public LiveData<Map<String, NotesDocumentCountEntry>> getAllDocumentCountEntryMap_LiveData(boolean z) {
        AbstractC11014a.m12335t("getAllDocumentCountEntryMap_LiveData, includeConvertedNote : ", TAG, z);
        return this.mMainListDocumentDao.getAllDocumentCountEntryMap_LiveData(this.mNotesOldDocumentDao, this.mNotesConvertedDocumentDao, z);
    }

    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(boolean z, String str) {
        DataLogger.m12307i(TAG, "getAllDocumentCountEntry_LiveData, includeConvertedNote : " + z + ", parentUuid : " + str);
        return this.mMainListDocumentDao.getAllDocumentCountEntry_LiveData(this.mNotesOldDocumentDao, this.mNotesConvertedDocumentDao, str, z);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllForImportContentShare_LiveData(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAllForImportContentShare_LiveData with param");
        return this.mMainListDocumentDao.getAllForImportContentShare_LiveData(0, sortParam);
    }

    public int getAllNoteCount(@DeleteType int i, boolean z) {
        return this.mMainListDocumentDao.getAllNoteCount(i, z);
    }

    public List<MainListDocumentData> getAllRecycleBinDataList(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAllRecycleBinDataList, sortParam : " + sortParam);
        return this.mMainListDocumentDao.getAllRecycleBinDataList(2, sortParam);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllRecycleBinData_LiveData(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAllRecycleBinData_LiveData, sortParam : " + sortParam);
        return this.mMainListDocumentDao.getAllRecycleBinData_LiveData(2, sortParam);
    }

    public List<MainListDocumentData> getAllWithCover(SortParam sortParam, @NonNull String str, int i) {
        DataLogger.m12302d(TAG, "getAllWithCover");
        return this.mMainListDocumentDao.getAllWithCover(sortParam, str, i);
    }

    public List<MainListDocumentData> getAllWithTag(SortParam sortParam) {
        DataLogger.m12302d(TAG, "getAllWithTag");
        return this.mMainListDocumentDao.getAllWithTag(new DocumentSortQuery().createQuery(sortParam));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllWithTag_LiveData(SortParam sortParam) {
        DataLogger.m12302d(TAG, "getAllWithTag_LiveData");
        return this.mMainListDocumentDao.getAllWithTag_LiveData(new DocumentSortQuery().createQuery(sortParam));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_LiveData(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_LiveData with param: " + sortParam);
        return this.mMainListDocumentDao.getAll_LiveData(0, sortParam);
    }

    public List<MainListDocumentData> getAll_OldNotes(@DeleteType int i, SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_OldNotes, deleteType : " + i + ", sortParam : " + sortParam);
        return this.mMainListDocumentDao.getAll_OldNotes(i, sortParam);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_OldNotes_LiveData(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_OldNotes_LiveData, sortParam : " + sortParam);
        return this.mMainListDocumentDao.getAll_OldNotes_LiveData(sortParam);
    }

    public List<MainListDocumentData> getCoEditMainListEntryListBySpaceIdList(@NonNull List<String> list, SortParam sortParam) {
        DataLogger.m12307i(TAG, "getCoEditMainListEntryListBySpaceIdList");
        return this.mMainListDocumentDao.getCoEditEntryBySpaceId(list, sortParam);
    }

    public List<MainListDocumentData> getEntities(@NonNull Collection<String> collection, @NonNull String str) {
        DataLogger.m12307i(TAG, "getEntities, uuids: " + collection.size() + ", folderUuid: " + str);
        return this.mMainListDocumentDao.getEntities(collection, str);
    }

    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        return this.mMainListDocumentDao.getExpiredRecycleBinDataNotInFolder(j);
    }

    public int getFavoriteItemCount(@DeleteType int i) {
        DataLogger.m12307i(TAG, "getFavoriteItemCount, deleteType : " + i);
        return this.mMainListDocumentDao.getFavoriteItemCount(i);
    }

    public int getNoteCountWithTitle() {
        DataLogger.m12307i(TAG, "getNoteCountWithTitle");
        return this.mMainListDocumentDao.getNoteCountWithTitle();
    }

    public int getNoteCountWithVoiceData() {
        DataLogger.m12307i(TAG, "getNoteCountWithVoiceData");
        return this.mMainListDocumentDao.getNoteCountWithVoiceData();
    }

    public String getPath(@NonNull String str) {
        AbstractC0000a.m2C("getPath, uuid : ", str, TAG);
        return this.mMainListDocumentDao.getPath(str);
    }

    public int getRecentlyImportedNoteCount(long j) {
        return this.mMainListDocumentDao.getRecentlyImportedNoteCount(j);
    }

    public LiveData<MainListDocumentData> get_LiveData(@NonNull String str) {
        AbstractC0000a.m2C("getLiveData, uuid : ", str, TAG);
        return this.mMainListDocumentDao.get_LiveData(str);
    }

    public List<MainListDocumentData> rawQuery(@NonNull SimpleSQLiteQuery simpleSQLiteQuery) {
        return this.mMainListDocumentDao.rawQuery(simpleSQLiteQuery);
    }

    public List<MainListDocumentData> search(String str, String[] strArr) {
        DataLogger.m12307i(TAG, "search");
        return this.mMainListDocumentDao.search(str, strArr);
    }

    public List<MainListDocumentData> searchLatestNotes(int i) {
        DataLogger.m12307i(TAG, "searchLatestNotes");
        return this.mMainListDocumentDao.searchLatestNotes(i);
    }
}
