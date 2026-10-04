package com.samsung.android.support.senl.p148nt.data.repository.category;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.CategoryTimeTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import p001A.AbstractC0000a;
import p066P2.C0200b;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesCategoryTreeRepository extends NotesDataRepository<NotesCategoryTreeEntity> {
    private static final String TAG = DataLogger.createTag("NotesCategoryTreeRepository");
    private boolean mIsInner;
    private final NotesCategoryTreeDao mNotesCategoryTreeDao;
    private final NotesDocumentDao mNotesDocumentDao;
    private final NotesMappedDocumentDao mNotesMappedDocumentDao;
    private final ParentFolderChecker mParentFolderChecker;

    public NotesCategoryTreeRepository(@NonNull Context context) {
        super(context);
        this.mIsInner = false;
        this.mNotesCategoryTreeDao = getDatabase().getCategoryTreeDao();
        this.mNotesDocumentDao = getDatabase().getDocumentDao();
        this.mNotesMappedDocumentDao = getDatabase().getMappedDocumentDao();
        this.mParentFolderChecker = new ParentFolderChecker(new NotesCategoryTreeRepository(context, true), new NotesCategoryTreeClosureRepository());
        DataLogger.m12302d(TAG, "created - " + this.mIsInner);
    }

    private void addFolder(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity, long j, long j2) {
        notesCategoryTreeEntity.setCreatedAt(j);
        notesCategoryTreeEntity.setLastModifiedAt(j);
        notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(j2));
        notesCategoryTreeEntity.setIsDirty(1);
        this.mNotesCategoryTreeDao.insertFolder(notesCategoryTreeEntity);
        NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(notesCategoryTreeEntity.getParentUuid());
        updateModifiedTime(entity, j);
        updateServerTimeUpward(entity, j2);
    }

    private void moveFolder(@NonNull String str, @NonNull String str2, long j, long j2) {
        NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(str);
        if (entity == null) {
            DataLogger.m12303e(TAG, "moveFolder, sourceFolderEntity is null");
            return;
        }
        NotesCategoryTreeEntity entity2 = this.mNotesCategoryTreeDao.getEntity(entity.getParentUuid());
        this.mNotesCategoryTreeDao.move(getContext(), this.mNotesDocumentDao, str, str2, j2, j);
        updateModifiedTime(entity2, j);
        updateServerTimeUpward(entity2, j2);
        NotesCategoryTreeEntity entity3 = this.mNotesCategoryTreeDao.getEntity(str2);
        updateModifiedTime(entity3, j);
        updateServerTimeUpward(entity3, j2);
    }

    private String restoreFolder(@NonNull String str, long j, long j2) {
        return this.mNotesCategoryTreeDao.restore(getContext(), this.mNotesDocumentDao, str, j2, j);
    }

    private void trashFolder(@NonNull String str, long j, long j2, DocumentCategoryTree documentCategoryTree) {
        NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(str);
        if (entity == null || entity.getIsDeleted() != 0) {
            DataLogger.m12303e(TAG, "trashFolder, folderEntity is null or not in USED");
            return;
        }
        NotesCategoryTreeEntity entity2 = this.mNotesCategoryTreeDao.getEntity(entity.getParentUuid());
        this.mNotesCategoryTreeDao.moveToRecycleBin(str, j, j2, this.mNotesDocumentDao, documentCategoryTree);
        updateModifiedTime(entity2, j);
        updateServerTimeUpward(entity2, j2);
    }

    private void updateFolder(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity, long j, long j2) {
        notesCategoryTreeEntity.setLastModifiedAt(j);
        notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(j2));
        notesCategoryTreeEntity.setIsDirty(1);
        this.mNotesCategoryTreeDao.update(notesCategoryTreeEntity);
        NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(notesCategoryTreeEntity.getParentUuid());
        updateModifiedTime(entity, j);
        updateServerTimeUpward(entity, j2);
    }

    private void updateModifiedTime(NotesCategoryTreeEntity notesCategoryTreeEntity, long j) {
        if (notesCategoryTreeEntity == null || PredefinedCategory.isRootFolder(notesCategoryTreeEntity.getUuid())) {
            return;
        }
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, Collections.singletonList(new CategoryTimeTuple(Long.valueOf(j), notesCategoryTreeEntity.getUuid())));
    }

    private void updateServerTimeUpward(NotesCategoryTreeEntity notesCategoryTreeEntity, long j) {
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, notesCategoryTreeEntity, j);
    }

    public void deleteByUuid(@NonNull String str, boolean z) {
        long currentTime;
        AbstractC0000a.m2C("deleteByUuid, uuid : ", str, TAG);
        List<String> allCategorySubTreeUuid = this.mNotesCategoryTreeDao.getAllCategorySubTreeUuid(str);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = allCategorySubTreeUuid.iterator();
        while (it.hasNext()) {
            List<DocumentData> documentDataByCategoryUuid = this.mNotesDocumentDao.getDocumentDataByCategoryUuid(it.next());
            if (documentDataByCategoryUuid != null) {
                arrayList.addAll(documentDataByCategoryUuid);
            }
        }
        if (z) {
            NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(str);
            if (entity == null) {
                DataLogger.m12305f(TAG, "deleteByUuid, entity is null: " + str);
                return;
            }
            currentTime = entity.getServerTimeStamp().longValue() + 1;
        } else {
            currentTime = TimeManager.getCurrentTime();
        }
        long j = currentTime;
        int i = z ? 2 : 1;
        this.mNotesCategoryTreeDao.deleteByUuidWithDocumentDelete(this.mNotesDocumentDao, this.mNotesMappedDocumentDao, j, allCategorySubTreeUuid);
        DataToSyncManager.getInstance().deleteDocumentFile(getContext(), arrayList, i);
        DataUpdateManager.getInstance().onDocumentDeleted((List) arrayList.stream().map(new C0200b(8)).collect(Collectors.toList()), i);
        DataUpdateManager.getInstance().onFolderDeleted(allCategorySubTreeUuid, i);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public void deleteByUuidWithDeleteExpiredFolder(@NonNull Collection<String> collection) {
        deleteByUuid(collection, true);
    }

    public void deleteFromTable(@NonNull String str) {
        DataLogger.m12305f(TAG, "deleteFromTable, uuid: " + str);
        this.mNotesCategoryTreeDao.deleteFromTable(str);
    }

    public String findAndMakeCategory(DocumentCategoryTree documentCategoryTree, String str) {
        return findAndMakeCategory(documentCategoryTree, str, -1);
    }

    public List<String> findUuidListByDisplayName(String str, boolean z) {
        DataLogger.m12307i(TAG, "findUuidListByDisplayName");
        return !z ? this.mNotesCategoryTreeDao.findUuidListByDisplayName(str) : this.mNotesCategoryTreeDao.findUuidListByDisplayNameIncludeDeleted(str);
    }

    public LiveData<List<NotesFolder>> getAllCategoryTree_LiveData(boolean z) {
        AbstractC11014a.m12335t("getAllCategoryTree_LiveData, includeDocumentCount : ", TAG, z);
        return this.mNotesCategoryTreeDao.getAllCategory_LiveData(z);
    }

    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z) {
        AbstractC11014a.m12335t("getAllDocumentCategoryTree, includeDocumentCount : ", TAG, z);
        return this.mNotesCategoryTreeDao.getAllDocumentCategoryTree(z);
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(boolean z) {
        DataLogger.m12307i(TAG, "getAllDocumentCategoryTree_LiveData, includeDocumentCount : " + z);
        return makeAllDocumentCategoryTree_LiveData(getAllCategoryTree_LiveData(z));
    }

    public List<NotesFolder> getAllNotesFolders(boolean z) {
        AbstractC11014a.m12335t("getAllCategoryTree, includeDocumentCount : ", TAG, z);
        return this.mNotesCategoryTreeDao.getAllNotesFolders(z);
    }

    public int getChildrenCount(@NonNull String str, @NonNull Set<String> set) {
        DataLogger.m12307i(TAG, "getChildrenCount");
        return this.mNotesCategoryTreeDao.getChildrenCount(str, set);
    }

    @NonNull
    public List<String> getChildrenUuids(@NonNull String str) {
        AbstractC0000a.m2C("getChildrenUuids, uuid: ", str, TAG);
        return this.mNotesCategoryTreeDao.getChildrenUuids(str);
    }

    public List<NotesCategoryTreeEntity> getEntities() {
        DataLogger.m12307i(TAG, "getEntities");
        return this.mNotesCategoryTreeDao.getEntities();
    }

    public NotesCategoryTreeEntity getEntity(String str) {
        AbstractC0000a.m2C("getEntity, uuid : ", str, TAG);
        return this.mNotesCategoryTreeDao.getEntity(str);
    }

    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        return this.mNotesCategoryTreeDao.getExpiredRecycleBinDataNotInFolder(j);
    }

    public NotesFolder getNotesFolder(String str, boolean z) {
        DataLogger.m12307i(TAG, "getNotesFolder, targetUuid : " + str + ", includeDocumentCount : " + z);
        return this.mNotesCategoryTreeDao.getNotesFolder(str, z);
    }

    public List<String> getUuidsByDisplayName(String str) {
        return this.mNotesCategoryTreeDao.getUuidsByDisplayName(str.toLowerCase().replace(" ", ""));
    }

    public boolean isParentUsed(String str) {
        return this.mParentFolderChecker.isUsed(str);
    }

    public boolean isUsed(String str) {
        AbstractC0000a.m2C("isUsed, uuid: ", str, TAG);
        return this.mNotesCategoryTreeDao.isUsed(str);
    }

    public LiveData<DocumentCategoryTree> makeAllDocumentCategoryTree_LiveData(@NonNull LiveData<List<NotesFolder>> liveData) {
        DataLogger.m12307i(TAG, "makeAllDocumentCategoryTree_LiveData");
        return Transformations.map(liveData, new C0348a(0));
    }

    public boolean move(String str, String str2) {
        DataLogger.m12307i(TAG, "move, folderUuid : " + str + ", toParentUuid : " + str2);
        if (this.mParentFolderChecker.isInvalidRelationShip(str, str2)) {
            return false;
        }
        moveFolder(str, str2, System.currentTimeMillis(), TimeManager.getCurrentTime());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        return true;
    }

    public void moveInTrash(@NonNull Collection<String> collection, @NonNull String str) {
        DataLogger.m12307i(TAG, "moveInTrash, uuidList : " + collection.size() + ", toParentUuid : " + str);
        this.mNotesCategoryTreeDao.moveInTrash(getContext(), collection, this.mNotesDocumentDao, str, TimeManager.getCurrentTime(), System.currentTimeMillis());
    }

    public boolean moveToRecycleBin(DocumentCategoryTree documentCategoryTree, @NonNull Collection<String> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        DataLogger.m12305f(TAG, "#delete, isDeleted: 2, folder count: " + collection.size() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        List<String> allDocumentsInFolderTree = this.mNotesDocumentDao.getAllDocumentsInFolderTree(collection);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            trashFolder(it.next(), jCurrentTimeMillis, currentTime, documentCategoryTree);
        }
        DataUpdateManager.getInstance().onDocumentMovedToTrash(allDocumentsInFolderTree);
        DataUpdateManager.getInstance().onDataUpdated(1);
        return true;
    }

    public void reorder(String str, Collection<? extends NotesCategoryTreeEntity> collection) {
        DataLogger.m12307i(TAG, "reorder, parentUuid : " + str + ", sortedList : " + collection);
        if (!this.mParentFolderChecker.isUsed(str) || this.mParentFolderChecker.isInvalidRelationShip(collection, str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        this.mNotesCategoryTreeDao.reorder(str, collection, currentTime, jCurrentTimeMillis);
        NotesCategoryTreeEntity entity = this.mNotesCategoryTreeDao.getEntity(str);
        updateModifiedTime(entity, jCurrentTimeMillis);
        updateServerTimeUpward(entity, currentTime);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public String restore(@NonNull String str) {
        DataLogger.m12307i(TAG, "restore, folderUuid : " + str);
        return restoreFolder(str, System.currentTimeMillis(), TimeManager.getCurrentTime());
    }

    public void updateFolderModifiedTime(Collection<String> collection, long j) {
        FolderTimeUtils.updateModifiedTime(this.mNotesCategoryTreeDao, collection, j);
    }

    public void updateFolderServerTimestampUpward(Collection<String> collection, long j) {
        FolderTimeUtils.updateServerTimeUpward(this.mNotesCategoryTreeDao, collection, j);
    }

    public String findAndMakeCategory(DocumentCategoryTree documentCategoryTree, String str, int i) {
        DataLogger.m12307i(TAG, "findAndMakeCategory, folderPath : " + str);
        return TextUtils.isEmpty(str) ? PredefinedCategory.UNCATEGORIZED.getUuid() : this.mNotesCategoryTreeDao.findAndMakeCategory(getContext(), documentCategoryTree, i, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void insert(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesCategoryTreeEntity);
        if (this.mParentFolderChecker.isInvalidRelationShip(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid())) {
            return;
        }
        addFolder(notesCategoryTreeEntity, System.currentTimeMillis(), TimeManager.getCurrentTime());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void update(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        DataLogger.m12307i(TAG, "update, entity : " + notesCategoryTreeEntity);
        if (this.mParentFolderChecker.isInvalidRelationShip(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid())) {
            return;
        }
        updateFolder(notesCategoryTreeEntity, System.currentTimeMillis(), TimeManager.getCurrentTime());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(@NonNull Collection<String> collection, boolean z) {
        DataLogger.m12307i(TAG, "getAllDocumentCategoryTree_LiveData, excludedUuidList : " + collection + ", includeDocumentCount : " + z);
        return makeAllDocumentCategoryTree_LiveData(getAllCategoryTree_LiveData(collection, z));
    }

    public boolean move(@NonNull Collection<String> collection, String str) {
        DataLogger.m12307i(TAG, "move, uuidList : " + collection + ", toParentUuid : " + str);
        if (this.mParentFolderChecker.isInvalidRelationShip(str, collection)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            moveFolder(it.next(), str, jCurrentTimeMillis, currentTime);
        }
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        return true;
    }

    private NotesCategoryTreeRepository(@NonNull Context context, boolean z) {
        super(context);
        this.mIsInner = false;
        this.mNotesCategoryTreeDao = getDatabase().getCategoryTreeDao();
        this.mNotesDocumentDao = getDatabase().getDocumentDao();
        this.mNotesMappedDocumentDao = getDatabase().getMappedDocumentDao();
        this.mParentFolderChecker = null;
        this.mIsInner = z;
    }

    public void insert(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        if (this.mParentFolderChecker.isInvalidRelationShip(collection)) {
            return;
        }
        DataLogger.m12307i(TAG, "insert, entities : " + collection.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        StringBuilder sb = new StringBuilder();
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : collection) {
            sb.append('\n');
            sb.append(notesCategoryTreeEntity);
            addFolder(notesCategoryTreeEntity, jCurrentTimeMillis, currentTime);
        }
        DataLogger.m12307i(TAG, "insert, entities: " + ((Object) sb));
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public void update(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        if (this.mParentFolderChecker.isInvalidRelationShip(collection)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currentTime = TimeManager.getCurrentTime();
        Iterator<NotesCategoryTreeEntity> it = collection.iterator();
        while (it.hasNext()) {
            updateFolder(it.next(), jCurrentTimeMillis, currentTime);
        }
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    public LiveData<List<NotesFolder>> getAllCategoryTree_LiveData(@NonNull Collection<String> collection, boolean z) {
        DataLogger.m12307i(TAG, "getAllCategoryTree_LiveData, excludedUuidList : " + collection + ", includeDocumentCount : " + z);
        return this.mNotesCategoryTreeDao.getAllCategory_LiveData(collection, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void deleteByUuid(@NonNull String str) {
        deleteByUuid(str, false);
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        deleteByUuid(collection, false);
    }

    public void deleteByUuid(@NonNull Collection<String> collection, boolean z) {
        if (collection.isEmpty()) {
            return;
        }
        DataLogger.m12305f(TAG, "#delete, isDeleted: 1, folder count: " + collection.size() + ", backtrace: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            deleteByUuid(it.next(), z);
        }
        DataUpdateManager.getInstance().onDataUpdated(1);
    }
}
