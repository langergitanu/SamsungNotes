package com.samsung.android.support.senl.p148nt.data.repository.document;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.arch.core.util.Function;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.LiveData;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.CategoryTimeTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.category.FolderTimeUtils;
import com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentRepository extends NotesDataRepository<NotesDocumentEntity> {
    private static final String TAG = DataLogger.createTag("NotesDocumentRepository");
    private final NotesCategoryTreeDao mNotesCategoryTreeDao;
    private final NotesDocumentDao mNotesDocumentDao;

    public NotesDocumentRepository(@NonNull Context context) {
        super(context);
        this.mNotesDocumentDao = getDatabase().getDocumentDao();
        this.mNotesCategoryTreeDao = getDatabase().getCategoryTreeDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$updateFavorites$0(boolean z, long j, List list) {
        this.mNotesDocumentDao.updateFavorites(list, z, j);
        return new ArrayList();
    }

    private void moveDocument(@NonNull Collection<String> collection, String str, long j, long j2) {
        Set<String> categoryUuids = this.mNotesDocumentDao.getCategoryUuids(collection);
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, categoryUuids, j);
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, categoryUuids, j2);
        this.mNotesDocumentDao.updateCategory(collection, str, j2);
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, Collections.singletonList(new CategoryTimeTuple(Long.valueOf(j), str)));
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, Collections.singletonList(new CategoryTimeTuple(Long.valueOf(j2), str)));
    }

    public SyncInfoEntity createOrUpdateSyncInfoEntity(@NonNull String str) {
        DataLogger.m12307i(TAG, "createOrUpdateSyncInfoEntity");
        SyncInfoEntity entity = getDatabase().getSyncInfoDao().getEntity(str);
        if (entity != null) {
            return entity;
        }
        SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
        syncInfoEntity.setNoteClientId(str);
        return syncInfoEntity;
    }

    public Collection<SyncInfoEntity> createSyncInfoEntities(@NonNull Collection<? extends NotesDocumentEntity> collection) {
        DataLogger.m12307i(TAG, "createSyncInfoEntities");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends NotesDocumentEntity> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(createOrUpdateSyncInfoEntity(it.next().getUuid()));
        }
        return arrayList;
    }

    public void deleteAll() {
        DataLogger.m12305f(TAG, "deleteAll#");
        this.mNotesDocumentDao.deleteAll();
        getDatabase().getSyncInfoDao().deleteAll();
        getDatabase().getTagDao().deleteAll();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, uuid : ", str, TAG);
        this.mNotesDocumentDao.deleteByUuid(str);
    }

    public void deleteByUuidDb(@NonNull String str) {
        DataLogger.m12305f(TAG, "[Delete] deleteByUuidDb, uuid : " + str);
        this.mNotesDocumentDao.deleteByUuidDb(str);
        getDatabase().getSyncInfoDao().deleteByUuid(str);
    }

    public void deleteByUuidWithTimestampIncrease(@NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteByUuidWithTimestampIncrease, uuidList : " + collection);
        this.mNotesDocumentDao.deleteByUuidListWithTimestampIncrease(collection);
    }

    @NonNull
    public List<String> fetchActiveFilePaths(@NonNull List<String> list) {
        DataLogger.m12302d(TAG, "fetchActiveFilePaths");
        return this.mNotesDocumentDao.fetchActiveFilePaths(list);
    }

    public NotesDocumentEntity get(@NonNull String str) {
        AbstractC0000a.m2C("get, uuid : ", str, TAG);
        return this.mNotesDocumentDao.getEntity(str);
    }

    @Nullable
    public String getAbsoluteFolderPath(@NonNull String str) {
        AbstractC11014a.m12334s("getAbsoluteFolderPath, uuid: ", str, TAG);
        return this.mNotesDocumentDao.getAbsoluteFolderPath(str);
    }

    public List<NotesDocumentEntity> getAllDataList(boolean z) {
        return getAllDataList(z, true);
    }

    public Cursor getAllDocument(String str, String str2, String str3) {
        DataLogger.m12307i(TAG, "getAllDocument");
        return this.mNotesDocumentDao.getAllDocument(str, str2, str3);
    }

    public List<String> getAllPathList() {
        return this.mNotesDocumentDao.getAllPathList();
    }

    public Set<String> getCategoryUuids(Collection<String> collection) {
        return this.mNotesDocumentDao.getCategoryUuids(collection);
    }

    public int getCorrupted(String str) {
        DataLogger.m12309w(TAG, "getCorrupted, uuid : " + str);
        return this.mNotesDocumentDao.getCorrupted(str);
    }

    public List<String> getCorruptedUuid() {
        DataLogger.m12309w(TAG, "getCorruptedUuid");
        return this.mNotesDocumentDao.getCorruptedUuid();
    }

    public DocumentData getDocumentData(String str) {
        AbstractC0000a.m2C("getDocumentData, uuid : ", str, TAG);
        return this.mNotesDocumentDao.getDocumentData(str);
    }

    public List<DocumentData> getDocumentDataList(List<String> list) {
        DataLogger.m12307i(TAG, "getDocumentDataList, uuidList : " + list);
        return this.mNotesDocumentDao.getDocumentDataList(list);
    }

    public List<NotesDocumentEntity> getEntitiesByUuids(Collection<String> collection) {
        List<NotesDocumentEntity> entitiesByUuids = this.mNotesDocumentDao.getEntitiesByUuids(collection);
        DataLogger.m12302d(TAG, "getEntitiesByUuids, req/res: " + collection.size() + "/" + entitiesByUuids.size());
        return entitiesByUuids;
    }

    public NotesDocumentEntity getEntityFromPath(@NonNull String str) {
        return this.mNotesDocumentDao.getEntityFromPath(str);
    }

    public List<String> getExpiredRecycleBinDataList(long j) {
        return this.mNotesDocumentDao.getExpiredRecycleBinDataList(j);
    }

    @NonNull
    public List<NotesDocumentEntity> getNotesForBackup() {
        DataLogger.m12302d(TAG, "getNotesForBackup");
        return this.mNotesDocumentDao.getNotesForBackup();
    }

    @NonNull
    public List<NotesDocumentEntity> getNotesForBackupExceptGenAi() {
        DataLogger.m12302d(TAG, "getNotesForBackupExceptGenAi");
        return this.mNotesDocumentDao.getNotesForBackupExceptGenAi();
    }

    public String getPath(@NonNull String str) {
        AbstractC0000a.m2C("getPath, uuid : ", str, TAG);
        return this.mNotesDocumentDao.getPath(str);
    }

    public List<String> getPathList(@DeleteType int i) {
        return this.mNotesDocumentDao.getPathList(i);
    }

    public List<NotesDocumentEntity> getSaveFailedEntities(int i) {
        DataLogger.m12307i(TAG, "getSaveFailedEntities, currentPid: " + i);
        return this.mNotesDocumentDao.getSaveFailedEntities(i);
    }

    public List<String> getUnlockedNormalNotes(Collection<String> collection) {
        DataLogger.m12302d(TAG, "getUnlockedNormalNotes, size: " + collection.size());
        return this.mNotesDocumentDao.getUnlockedNormalNotes(collection);
    }

    public List<String> getUpdatableNotes(Collection<String> collection) {
        DataLogger.m12302d(TAG, "getUpdatableNotes, size: " + collection.size());
        return this.mNotesDocumentDao.getUpdatableNotes(collection);
    }

    public String getUuid(@NonNull String str) {
        return this.mNotesDocumentDao.getUuid(str);
    }

    public LiveData<NotesDocumentEntity> get_LiveData(@NonNull String str) {
        AbstractC0000a.m2C("getLiveData, uuid : ", str, TAG);
        return this.mNotesDocumentDao.get_LiveData(str);
    }

    public void internalUpdateFolderTimeByKeepServerTimestampFlag(@NonNull Collection<NotesDocumentEntity> collection) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : collection) {
            if (!notesDocumentEntity.getKeepServerTimestamp()) {
                String categoryUuid = notesDocumentEntity.getCategoryUuid();
                arrayList.add(new CategoryTimeTuple(Long.valueOf(notesDocumentEntity.getLastModifiedAt()), categoryUuid));
                arrayList2.add(new CategoryTimeTuple(notesDocumentEntity.getServerTimestamp(), categoryUuid));
            }
        }
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, arrayList);
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, arrayList2);
    }

    public boolean isSaving(@NonNull String str, int i) {
        boolean z = this.mNotesDocumentDao.getIsSavingByWhichPid(str) == i;
        AbstractC11014a.m12335t("isSaving, ", TAG, z);
        return z;
    }

    public void moveToRecycleBinByUuid(Collection<String> collection) {
        DataLogger.m12307i(TAG, "moveToRecycleBinByUuid, doc count : " + collection.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        DocumentCategoryTree allDocumentCategoryTree = this.mNotesCategoryTreeDao.getAllDocumentCategoryTree(false);
        this.mNotesDocumentDao.moveToRecycleBin(collection, jCurrentTimeMillis, currentTime, allDocumentCategoryTree);
        Set<String> categoryUuids = this.mNotesDocumentDao.getCategoryUuids(collection);
        FolderTimeUtils.updateModifiedTime(allDocumentCategoryTree, this.mNotesCategoryTreeDao, categoryUuids, jCurrentTimeMillis);
        FolderTimeUtils.updateServerTimeUpward(allDocumentCategoryTree, this.mNotesCategoryTreeDao, categoryUuids, currentTime);
    }

    public Cursor query(String str, Object[] objArr) {
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(str, objArr);
        DataLogger.m12307i(TAG, "query, : " + simpleSQLiteQuery);
        return this.mNotesDocumentDao.rawQueryForDocument(simpleSQLiteQuery);
    }

    public void restoreByUuidWithSyncTimestampUpdate(Collection<String> collection) {
        long currentTime = TimeManager.getCurrentTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        restoreByUuids(collection, currentTime);
        DataUpdateManager.getInstance().onDataUpdated(3);
        Set<String> categoryUuids = this.mNotesDocumentDao.getCategoryUuids(collection);
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, categoryUuids, jCurrentTimeMillis);
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, categoryUuids, currentTime);
    }

    public void restoreByUuids(Collection<String> collection, long j) {
        DataLogger.m12305f(TAG, "#restoreByUuids, doc count: " + collection.size() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        this.mNotesDocumentDao.restoreByUuids(getContext(), this.mNotesCategoryTreeDao, collection, j);
    }

    public void setDisplayContent(String str, byte[] bArr) {
        DataLogger.m12302d(TAG, "setDisplayContent, uuid: " + str);
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        this.mNotesDocumentDao.setDisplayContent(str, bArr);
    }

    public void setOpenedTime(@NonNull String str) {
        AbstractC11014a.m12334s("setOpenedTime, uuid : ", str, TAG);
        this.mNotesDocumentDao.setOpenedTime(str);
    }

    public void updateCategory(String str, String str2) {
        updateCategory(Collections.singletonList(str), str2);
    }

    public void updateCorrupted(String str, int i) {
        DataLogger.m12309w(TAG, "updateCorrupted, uuid : " + str + ", corrupted : " + i);
        this.mNotesDocumentDao.updateCorrupted(str, i);
    }

    public int updateFavorite(String str, boolean z) {
        DataLogger.m12307i(TAG, "updateFavorite, uuid : " + str + ", isFavorite : " + z);
        int iUpdateFavorite = this.mNotesDocumentDao.updateFavorite(str, z, TimeManager.getCurrentTime());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessHandler.getWidgetAccessContract().sendUpdateUuidListWidgetBroadcast(getContext(), Collections.singletonList(str));
        }
        return iUpdateFavorite;
    }

    public void updateFavorites(List<String> list, final boolean z) {
        DataLogger.m12307i(TAG, "updateFavorite, uuids : " + list.size() + ", isFavorite : " + z);
        final long currentTime = TimeManager.getCurrentTime();
        new SplitTaskExecutor(new Function() { // from class: com.samsung.android.support.senl.nt.data.repository.document.a
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: apply */
            public final Object mo22196apply(Object obj) {
                return this.f7424a.lambda$updateFavorites$0(z, currentTime, (List) obj);
            }
        }).execute(list);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessHandler.getWidgetAccessContract().sendUpdateUuidListWidgetBroadcast(getContext(), list);
        }
    }

    public void updateFolderTimeByKeepServerTimestampFlag(NotesDocumentEntity notesDocumentEntity) {
        internalUpdateFolderTimeByKeepServerTimestampFlag(Collections.singletonList(notesDocumentEntity));
    }

    public int updateRecommendedTitle(String str, String str2) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateRecommendedTitle, uuid : ", str, ", recommendedTitle : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str3, sbM15l.toString());
        if (str2 == null) {
            str2 = "";
        }
        return this.mNotesDocumentDao.updateRecommendedTitle(str, str2);
    }

    public void updateRecycleBinTimeMoved(@NonNull String str, long j) {
        this.mNotesDocumentDao.updateRecycleBinTimeMoved(str, j);
    }

    public void updateSaving(String str, int i, long j) {
        String str2 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateSaving, uuid : ", i, str, ", flag : ", ", size : ");
        sbM780v.append(j);
        DataLogger.m12309w(str2, sbM780v.toString());
        this.mNotesDocumentDao.updateSaving(str, i, j);
    }

    public int updateTitle(String str, String str2, byte[] bArr) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateTitle, uuid : ", str, ", title : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str3, sbM15l.toString());
        if (str2 == null) {
            str2 = "";
        }
        return this.mNotesDocumentDao.updateTitle(str, str2, bArr);
    }

    public List<NotesDocumentEntity> getAllDataList(boolean z, boolean z2) {
        return getAllDataList(0, z, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void insert(@NonNull NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesDocumentEntity);
        this.mNotesDocumentDao.upsert(notesDocumentEntity);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void update(@NonNull NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12307i(TAG, "update, entity : " + notesDocumentEntity);
        this.mNotesDocumentDao.update(notesDocumentEntity);
        updateFolderTimeByKeepServerTimestampFlag(notesDocumentEntity);
    }

    public void updateCategory(Collection<String> collection, String str) {
        DataLogger.m12305f(TAG, "updateCategory, uuids : " + collection + ", categoryUuid : " + str);
        if (collection.isEmpty()) {
            return;
        }
        moveDocument(collection, str, System.currentTimeMillis(), TimeManager.getCurrentTime());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public List<NotesDocumentEntity> getAllDataList(@DeleteType int i, boolean z, boolean z2) {
        AbstractC11014a.m12340y(AbstractC2821a.m2226q("getAllDataList, deleteType : ", i, ", isDesc : ", z, ", exceptConverted : "), z2, TAG);
        return z2 ? this.mNotesDocumentDao.getAll(i, z) : this.mNotesDocumentDao.getAll_NotConsideringMappingTable(i, z);
    }

    public List<String> getCorruptedUuid(int i) {
        DataLogger.m12309w(TAG, "getCorruptedUuid, corrupted : " + i);
        return this.mNotesDocumentDao.getCorruptedUuid(i);
    }

    public void insert(@NonNull Collection<NotesDocumentEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities : "), TAG);
        this.mNotesDocumentDao.upsert((Collection) collection);
    }

    public void update(@NonNull Collection<NotesDocumentEntity> collection) {
        update(collection, true);
    }

    public void update(@NonNull Collection<NotesDocumentEntity> collection, boolean z) {
        DataLogger.m12307i(TAG, "update, entities : " + collection.size() + ", updateTime: " + z);
        this.mNotesDocumentDao.update(collection);
        if (z) {
            internalUpdateFolderTimeByKeepServerTimestampFlag(collection);
        }
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteByUuid, uuidList : " + collection);
        this.mNotesDocumentDao.deleteByUuid(collection, TimeManager.getCurrentTime());
    }
}
