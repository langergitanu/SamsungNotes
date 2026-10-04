package com.samsung.android.support.senl.p148nt.data.repository.sync;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.FeedSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncNoteDataRepository {
    private static final String TAG = DataLogger.createTag("SyncNoteDataRepository");
    private final SyncDocumentDao mSyncDocumentDao = NotesDatabaseManager.getInstance().getSyncDocumentDao();
    private final SyncMdeDao mSyncMdeDao = NotesDatabaseManager.getInstance().getSyncMdeDao();
    private final SyncInfoDao mSyncInfoDao = NotesDatabaseManager.getInstance().getSyncInfoDao();
    private final NotesMappedDocumentDao mNotesMappedDocumentDao = NotesDatabaseManager.getInstance().getMappedDocumentDao();

    public void addNoteSyncStateFlag(String str, long j) {
        Debugger.m8614f(TAG, "addNoteSyncState, uuid: " + str + ", syncState: " + j);
        this.mSyncInfoDao.addSyncStateFlag(str, j);
    }

    public List<NotesDocumentEntity> dumpDocument() {
        return this.mSyncDocumentDao.dumpDocument();
    }

    public List<SyncInfoEntity> dumpSyncInfo() {
        return this.mSyncInfoDao.dumpSyncInfo();
    }

    public SyncInfoEntity get(@NonNull String str) {
        return this.mSyncInfoDao.getEntity(str);
    }

    public String getAbsolutePath(String str) {
        return this.mSyncDocumentDao.getAbsolutePath(str);
    }

    public LiveData<List<MainListDocumentData>> getAllCoeditStandAloneNoteList_LiveData(SortParam sortParam) {
        Debugger.m8615i(TAG, "getAllCoeditStandAloneNoteList_LiveData");
        return this.mSyncMdeDao.getAllCoeditStandAloneNoteList_LiveData(0, sortParam);
    }

    public List<DocSyncEntry> getCacheSyncDocInfoList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        StringBuilder sbM12325j = AbstractC11014a.m12325j("SELECT ", " sdoc.UUID, sdoc.filePath, sdoc.serverTimestamp, sdoc.categoryserverTimestamp,  sdoc.title, sdoc.isFavorite, sdoc.categoryUUID, sdoc.isDeleted, sdoc.lastMappedAt,  sdoc.lastModifiedAt, sdoc.isLock, sdoc.lockAccountGuid, sdoc.categoryisDirty, sdoc.isDirty  FROM sdoc WHERE sdoc.UUID in(");
        for (String str : list) {
            sbM12325j.append('\'');
            sbM12325j.append(str);
            sbM12325j.append("',");
        }
        sbM12325j.setLength(sbM12325j.length() - 1);
        sbM12325j.append(PropertyUtils.MAPPED_DELIM2);
        return this.mSyncDocumentDao.rawQueryForDocSyncEntryList(new SimpleSQLiteQuery(sbM12325j.toString()));
    }

    public String getCategoryUuid(String str) {
        return this.mSyncDocumentDao.getCategoryUuid(str);
    }

    public long getCheckpoint(String str) {
        return this.mSyncInfoDao.getCheckPoint(str);
    }

    public List<ShareSyncEntry> getCoeditDocUuidList() {
        return this.mSyncDocumentDao.getCoeditDocUuidList();
    }

    public List<MainListDocumentData> getCoeditMainListEntryListBySpaceIdList(@NonNull List<String> list, SortParam sortParam) {
        return this.mSyncMdeDao.getCoeditEntryBySpaceId(list, sortParam);
    }

    public String getCommitId(String str) {
        return this.mSyncInfoDao.getCommitId(str);
    }

    @SyncInfoEntity.ConflictStrategy
    public int getConflictStrategy(String str) {
        return this.mSyncInfoDao.getConflictStrategy(str);
    }

    public int getCorrupted(String str) {
        return this.mSyncDocumentDao.getCorruptedValue(str);
    }

    public int getCountIsDirty(int i, String str) {
        return this.mSyncDocumentDao.getCountIsDirty(i, str);
    }

    public String getDeviceName(String str) {
        return this.mSyncInfoDao.getDeviceName(str);
    }

    public int getDirtyCountOfNoteExtraInfo() {
        return this.mSyncInfoDao.getDirtyCountOfNoteExtraInfo();
    }

    public List<FolderNodeItem> getDirtyFolderNodeItemList() {
        return this.mSyncDocumentDao.getDirtyFolderNodeItemList();
    }

    public DocSyncEntry getDocSyncEntry(@NonNull String str) {
        return this.mSyncDocumentDao.getDocSyncEntry(str);
    }

    public String getGcsOwnerId(String str) {
        return this.mSyncDocumentDao.getGcsOwnerId(str);
    }

    public int getGcsOwnerNoteCount(String str, String str2) {
        return this.mSyncMdeDao.getMdeOwnerNoteCount(str, str2);
    }

    public List<NotesDocumentEntity> getIsCategoryDirtyList(int i, boolean z) {
        return this.mSyncDocumentDao.getIsCategoryDirtyDocList(i, z, "");
    }

    public List<NotesDocumentEntity> getIsDirtyList(int i) {
        return this.mSyncDocumentDao.getIsDirtyDocList(i, false, "");
    }

    public List<String> getLocalGroupIdListCoedit() {
        return this.mSyncMdeDao.getLocalGroupIdListCoedit();
    }

    public List<String> getLocalGroupIdListOldSharedNote() {
        return this.mSyncMdeDao.getLocalGroupIdListOldSharedNote();
    }

    public List<String> getLocalSpaceIdListCoedit() {
        return this.mSyncMdeDao.getLocalSpaceIdListCoedit();
    }

    public List<String> getLocalSpaceIdListOldSharedNote() {
        return this.mSyncMdeDao.getLocalSpaceIdListOldSharedNote();
    }

    public String getLockAccountGuid(String str) {
        return this.mSyncDocumentDao.getLockAccountGuid(str);
    }

    public long getMaxSyncModifiedTimeFromNotes() {
        return this.mSyncDocumentDao.getMaxSyncModifiedTimeFromNotes();
    }

    public String getMdeExtra(String str) {
        return this.mSyncDocumentDao.getMdeExtra(str);
    }

    @NonNull
    public List<String> getNormalSdocxUuidList() {
        return this.mSyncDocumentDao.getNormalSdocxUuidList();
    }

    public List<String> getNormalSyncablSdocxUuidList() {
        return this.mSyncDocumentDao.getNormalSyncablSdocxUuidList();
    }

    public Long getNoteCategoryServerTimestamp(String str) {
        return this.mSyncDocumentDao.getCategoryServerTimestamp(str);
    }

    public int getNoteDeleted(String str) {
        return this.mSyncDocumentDao.getNoteDeleted(str);
    }

    public FeedSyncEntry getNoteFeedEntryByUuid(String str) {
        return this.mSyncDocumentDao.getNoteFeedEntryByUuid(str);
    }

    public List<FeedSyncEntry> getNoteFeedListByCategoryUuid(String str) {
        return this.mSyncDocumentDao.getNoteFeedListByCategoryUuid(str);
    }

    public Long getNoteServerTimestamp(String str) {
        return this.mSyncDocumentDao.getServerTimestamp(str);
    }

    public long getNoteSyncState(String str) {
        return this.mSyncInfoDao.getSyncStateFlag(str);
    }

    public int getOldDirtyCountOfNoteCategory() {
        return this.mSyncDocumentDao.getOldDirtyCountOfNoteCategory();
    }

    public HashMap<String, Long> getOldUuidAndNoteCategoryTimeList() {
        HashMap<String, Long> map = new HashMap<>();
        for (SyncDocumentDao.UuidTimeTuple uuidTimeTuple : this.mSyncDocumentDao.getOldUuidAndNoteCategoryTimeList()) {
            if (getNoteDeleted(uuidTimeTuple.uuid) == 0) {
                if (SyncState.getDontSyncOldNote(uuidTimeTuple.uuid) != 0) {
                    SyncState.removeDontSyncOldNote(uuidTimeTuple.uuid);
                }
                map.put(uuidTimeTuple.uuid, Long.valueOf(uuidTimeTuple.categoryServerTimestamp));
            } else if (SyncState.getDontSyncOldNote(uuidTimeTuple.uuid) == 0) {
                map.put(uuidTimeTuple.uuid, Long.valueOf(uuidTimeTuple.categoryServerTimestamp));
            }
        }
        return map;
    }

    public String getReferenceResourceId(String str) {
        return this.mSyncInfoDao.getResourceId(str);
    }

    public String getServerId(String str) {
        return this.mSyncInfoDao.getServerId(str);
    }

    public ShareSyncEntry getShareSyncEntry(@NonNull String str) {
        return this.mSyncDocumentDao.getShareSyncEntry(str);
    }

    public int getStrokeGrouped(String str) {
        return this.mSyncInfoDao.getStrokeGrouped(str);
    }

    public String getTitle(String str) {
        return this.mSyncDocumentDao.getTitle(str);
    }

    public int getTotalNumberOfSDocx() {
        return this.mSyncDocumentDao.getTotalNumberOfSDocx();
    }

    public int getUnreadCoeditNoteCount() {
        return this.mSyncMdeDao.getUnreadCoeditNoteCount();
    }

    public int getUnreadMdeNoteCount() {
        return this.mSyncMdeDao.getUnreadMdeNoteCount();
    }

    public HashMap<String, Long> getUuidAndNoteTimeList() {
        HashMap<String, Long> map = new HashMap<>();
        List<SyncDocumentDao.UuidServerTimestampTuple> uuidAndNoteTimeList = this.mSyncDocumentDao.getUuidAndNoteTimeList();
        if (uuidAndNoteTimeList != null) {
            for (SyncDocumentDao.UuidServerTimestampTuple uuidServerTimestampTuple : uuidAndNoteTimeList) {
                if (getNoteDeleted(uuidServerTimestampTuple.uuid) == 0 || SyncState.getDontSyncOldNote(uuidServerTimestampTuple.uuid) == 0) {
                    map.put(uuidServerTimestampTuple.uuid, Long.valueOf(uuidServerTimestampTuple.serverTimestamp));
                }
            }
        }
        return map;
    }

    public String getUuidByGroupIdStandAlone(String str) {
        List<String> uuidListByGroupIdCoedit = this.mSyncMdeDao.getUuidListByGroupIdCoedit(str);
        return (uuidListByGroupIdCoedit == null || uuidListByGroupIdCoedit.isEmpty()) ? "" : uuidListByGroupIdCoedit.get(0);
    }

    public String getUuidByItemId(String str, String str2) {
        return this.mSyncDocumentDao.getUuidByItemId(str, str2);
    }

    public List<String> getUuidListByCategory(String str, boolean z) {
        return z ? this.mSyncDocumentDao.getUuidListByCategoryIncludeDeleted(str) : this.mSyncDocumentDao.getUuidListByCategory(str);
    }

    public List<String> getUuidListByCategoryDirty(int i) {
        return this.mSyncDocumentDao.getUuidListByCategoryDirty(i);
    }

    public List<String> getUuidListByConflictStrategy(@SyncInfoEntity.ConflictStrategy int i) {
        return this.mSyncInfoDao.getUuidListByConflictStrategy(i);
    }

    public List<String> getUuidListByDeleted(int i) {
        return this.mSyncDocumentDao.getUuidListByDeleted(i);
    }

    public List<String> getUuidListByDirty(int i) {
        return this.mSyncDocumentDao.getUuidListByDirty(i);
    }

    public List<String> getUuidListByDirtyForExtraInfo(int i) {
        return this.mSyncInfoDao.getUuidListByDirtyForExtraInfo(i);
    }

    public List<String> getUuidListByGroupIdAndOwnerIdOld(String str, String str2) {
        return this.mSyncMdeDao.getUuidListByGroupIdAndOwnerIdOld(str, str2);
    }

    public List<String> getUuidListByGroupIdCoedit(String str) {
        return this.mSyncMdeDao.getUuidListByGroupIdCoedit(str);
    }

    public List<String> getUuidListByGroupIdOld(String str) {
        return this.mSyncMdeDao.getUuidListByGroupIdOld(str);
    }

    public List<String> getUuidListBySpaceIdCoedit(String str) {
        return this.mSyncMdeDao.getUuidListBySpaceIdCoedit(str);
    }

    public List<String> getUuidListBySpaceIdOld(String str) {
        return this.mSyncMdeDao.getUuidListBySpaceIdOld(str);
    }

    public List<String> getUuidListBySyncState(long j) {
        Debugger.m8615i(TAG, "getUuidListBySyncState, syncState = " + j);
        return this.mSyncInfoDao.getUuidListBySyncState(j);
    }

    public List<String> getUuidListCoedit() {
        return this.mSyncMdeDao.getUuidListCoedit();
    }

    public List<String> getUuidListInvalidSharedNote() {
        return this.mSyncMdeDao.getUuidListInvalidSharedNote();
    }

    public List<String> getUuidListLockedNote(boolean z) {
        return z ? this.mSyncDocumentDao.getUuidListLockedNoteIncludeDeleted(1) : this.mSyncDocumentDao.getUuidListLockedNote(1);
    }

    public List<String> getUuidListMde() {
        return this.mSyncMdeDao.getUuidListMde();
    }

    public List<String> getUuidListOldSync() {
        return this.mSyncDocumentDao.getUuidListOldSync();
    }

    public void insert(@NonNull SyncInfoEntity syncInfoEntity) {
        Debugger.m8615i(TAG, "insert, entity : " + syncInfoEntity);
        this.mSyncInfoDao.upsert(syncInfoEntity);
    }

    public void insertLastMappedAtList(HashMap<String, Long> map) {
        this.mNotesMappedDocumentDao.insert(map);
    }

    public int isConflicted(String str) {
        return this.mSyncInfoDao.isConflicted(str);
    }

    public LiveData<Integer> isConflicted_LiveData(String str) {
        return this.mSyncInfoDao.isConflicted_LiveData(str);
    }

    public boolean isExist(String str) {
        return this.mSyncDocumentDao.isExist(str);
    }

    public void removeNoteSyncStateFlag(String str, long j) {
        this.mSyncInfoDao.removeSyncStateFlag(str, j);
    }

    public void repairOldSharedNotesCategoryUuid() {
        this.mSyncDocumentDao.repairOldSharedNotesCategoryUuid();
    }

    public void resetDeletedNoteInServer(String str) {
        this.mSyncInfoDao.resetDeletedNoteInServer(str);
    }

    public void resetIsSyncFailed(int i) {
        this.mSyncInfoDao.resetAllIsSyncFailed(i);
    }

    @Transaction
    public boolean setLastMappedAt(String str, long j) {
        return this.mSyncDocumentDao.setLastMappedAtList(str, j) > 0;
    }

    @Transaction
    public boolean setLastMappedAtList(HashMap<String, Long> map) {
        int lastMappedAtList = 0;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            lastMappedAtList += this.mSyncDocumentDao.setLastMappedAtList(entry.getKey(), entry.getValue().longValue());
        }
        return lastMappedAtList > 0;
    }

    public void setMdeExtra(String str, String str2) {
        Debugger.m8615i(TAG, "setMdeExtra, uuid: " + str + ", mdeExtra: " + str2);
        this.mSyncDocumentDao.setMdeExtra(str, str2);
    }

    public void setMdeItemId(String str, String str2) {
        this.mSyncDocumentDao.setMdeItemId(str, str2);
    }

    public void setNoteDeleted(String str, int i) {
        Debugger.m8614f(TAG, "setNoteDeleted, uuid: " + str + ", isDeleted: " + i);
        this.mSyncDocumentDao.updateIsDeleted(str, i);
    }

    public void setNoteFolder(@NonNull String str, @NonNull String str2) {
        this.mSyncDocumentDao.setNoteFolder(str, str2);
    }

    public void setNoteSyncState(String str, long j) {
        Debugger.m8614f(TAG, "setNoteSyncState, uuid: " + str + ", syncState: " + j);
        this.mSyncInfoDao.updateSyncState(str, j);
    }

    public void setReferenceResourceId(String str, String str2) {
        this.mSyncInfoDao.updateResourceId(str, str2);
    }

    public void setStrokeGrouped(String str, int i) {
        this.mSyncInfoDao.setStrokeGrouped(str, i);
    }

    public void trashDeletedNoteInServer(String str, long j) {
        this.mSyncDocumentDao.updateServerTimestamp(str, j);
        this.mSyncInfoDao.resetDeletedNoteInServer(str);
    }

    public void updateAbsolutePath(String str, String str2) {
        Debugger.m8614f(TAG, "updateAbsolutePath, uuid: " + str + ", absolutePath: " + str2);
        this.mSyncDocumentDao.updateAbsolutePath(str, str2);
    }

    public void updateAllCoeditNotesAsRead(long j) {
        this.mSyncDocumentDao.updateAllCoeditNotesAsRead(j);
    }

    public void updateCategoryServerTimestamp(String str, long j) {
        this.mSyncDocumentDao.updateCategoryServerTimestamp(str, j);
    }

    public void updateCommitId(String str, String str2) {
        this.mSyncInfoDao.updateCommitId(str, str2);
    }

    public void updateConflict(String str, int i, String str2, @SyncInfoEntity.ConflictStrategy int i2) {
        this.mSyncInfoDao.updateConflict(str, i, str2, i2);
    }

    public void updateConflictStrategy(String str, @SyncInfoEntity.ConflictStrategy int i) {
        this.mSyncInfoDao.updateConflictStrategy(str, i);
    }

    public void updateCreatedAt(String str, long j) {
        Debugger.m8615i(TAG, "updateCreatedAt, uuid: " + str + ", createdAt: " + j);
        this.mSyncDocumentDao.updateCreatedAt(str, j);
    }

    public void updateDirty(String str, int i) {
        this.mSyncDocumentDao.updateDirty(str, i);
    }

    public void updateDirtyAndTimestamp(String str, int i, long j) {
        this.mSyncDocumentDao.updateDirtyAndTimestamp(str, i, j);
    }

    @Transaction
    public void updateDirtyAndTimestampByUuidList(Collection<String> collection, int i, long j) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            updateDirtyAndTimestamp(it.next(), i, j);
        }
    }

    public void updateDirtyCategory(String str, int i) {
        this.mSyncDocumentDao.updateDirtyCategory(str, i);
    }

    public void updateEntityByDeleteSdocToDelete(String str, int i, int i2, long j, int i4, long j2) {
        Debugger.m8614f(TAG, "updateEntityByDeleteSdocToDelete, uuid: " + str + ", isDeleted: " + i);
        this.mSyncDocumentDao.updateEntityByDeleteSdocToDelete(str, i, i2, j, i4, j2);
    }

    public void updateEntityByDeleteSdocToRecycleBin(String str, int i, long j, String str2, String str3, int i2, long j2) {
        String str4 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateEntityByDeleteSdocToRecycleBin, uuid: ", i, str, ", isDeleted: ", ", folderUuid: ");
        sbM780v.append(str2);
        Debugger.m8614f(str4, sbM780v.toString());
        this.mSyncDocumentDao.updateEntityByDeleteSdocToRecycleBin(str, i, j, str2, str3, i2, j2);
    }

    public void updateEntityByDeleteSdocToRecycleBinInSync(String str, int i, long j, String str2, String str3) {
        String str4 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateEntityByDeleteSdocToRecycleBinInSync, uuid: ", i, str, ", isDeleted: ", ", folderUuid: ");
        sbM780v.append(str2);
        Debugger.m8614f(str4, sbM780v.toString());
        this.mSyncDocumentDao.updateEntityByDeleteSdocToRecycleBinInSync(str, i, j, str2, str3);
    }

    public void updateEntityByRecoverySDoc(String str, int i, long j, int i2, String str2) {
        Debugger.m8614f(TAG, "updateEntityByRecoverySDoc, uuid: " + str + ", folderUuid: " + str2);
        this.mSyncDocumentDao.updateEntityByRecoverySDoc(str, i, j, i2, str2);
    }

    public void updateEntityByRestoreSDoc(String str, int i, int i2, int i4, long j, String str2) {
        String str3 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateEntityByRestoreSDoc, uuid: ", i, str, ", isDeleted: ", ", folderUuid: ");
        sbM780v.append(str2);
        Debugger.m8614f(str3, sbM780v.toString());
        this.mSyncDocumentDao.updateEntityByRestoreSDoc(str, i, i2, i4, j, str2);
    }

    public void updateEntityByRestoreSDocInSync(String str, int i, int i2, String str2) {
        String str3 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateEntityByRestoreSDocInSync, uuid: ", i, str, ", isDeleted: ", ", folderUuid: ");
        sbM780v.append(str2);
        Debugger.m8614f(str3, sbM780v.toString());
        this.mSyncDocumentDao.updateEntityByRestoreSDocInSync(str, i, i2, str2);
    }

    public void updateEntityBySetNoteFolder(String str, int i, String str2, long j, int i2, long j2, String str3) {
        String str4 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateEntityBySetNoteFolder, uuid: ", i, str, ", isDeleted: ", ", folderUuid: ");
        sbM780v.append(str2);
        Debugger.m8614f(str4, sbM780v.toString());
        this.mSyncDocumentDao.updateEntityBySetNoteFolder(str, i, str2, j, i2, j2, str3);
        if (i == 2) {
            DataUpdateManager.getInstance().onDocumentMovedToTrash(Collections.singleton(str));
        }
    }

    public void updateFirstOpenedAt(String str, long j) {
        Debugger.m8615i(TAG, "updateFirstOpenedAt, uuid: " + str + ", openedTime: " + j);
        this.mSyncDocumentDao.updateFirstOpenedAt(str, j);
    }

    public void updateIsDirtyByIsSyncFailed(int i, int i2) {
        this.mSyncInfoDao.updateIsDirtyByIsSyncFailed(i, i2);
    }

    public void updateIsSyncFailed(String str, int i) {
        this.mSyncInfoDao.updateIsSyncFailed(str, i);
    }

    public void updateModifiedTime(String str, long j) {
        Debugger.m8615i(TAG, "updateModifiedTime, uuid: " + str + ", modifiedTime: " + j);
        this.mSyncDocumentDao.updateModifiedTime(str, j);
    }

    public void updateMsConnectedNotes(String str, String str2, String str3, int i) {
        this.mSyncDocumentDao.updateMsConnectedNotes(str, str2, str3, i);
    }

    public void updateMsConnectedNotesId(String str, String str2, String str3) {
        this.mSyncDocumentDao.updateMsConnectedNotesId(str, str2, str3);
    }

    public void updateNoteCategory(String str, String str2, int i, long j) {
        String str3 = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("updateNoteCategory, uuid: ", str, ", folderUuid: ", str2, ", categoryServerTime: ");
        sbM16m.append(j);
        Debugger.m8614f(str3, sbM16m.toString());
        this.mSyncDocumentDao.updateNoteCategory(str, str2, i, j);
    }

    public void updateNoteCategoryAndAbsolutePath(String str, String str2, int i, long j, String str3) {
        Debugger.m8614f(TAG, "updateNoteCategoryAndAbsolutePath, uuid: " + str + ", folderUuid: " + str2);
        this.mSyncDocumentDao.updateNoteCategory(str, str2, i, j, str3);
    }

    public int updateNoteFavorite(String str, int i) {
        return this.mSyncDocumentDao.updateNoteFavoriteInSync(str, i);
    }

    public int updateNoteFavoriteAndCategoryDirtyTimestamp(String str, int i, long j) {
        return this.mSyncDocumentDao.updateNoteFavoriteAndCategoryDirtyTimestamp(str, i, j);
    }

    public void updateNoteServerId(String str, String str2) {
        this.mSyncInfoDao.updateServerId(str, str2);
    }

    public void updateNoteServerIdAndDirty(String str, String str2, int i) {
        updateDirty(str, i);
        this.mSyncInfoDao.updateServerId(str, str2);
    }

    public void updateRecycleBinResolverUpdateTimeMoved(String str, long j) {
        this.mSyncDocumentDao.updateRecycleBinResolverUpdateTimeMoved(str, j);
    }

    public void updateServerId(String str, String str2) {
        this.mSyncInfoDao.updateServerId(str, str2);
    }

    public void updateServerTimestamp(String str, long j) {
        this.mSyncDocumentDao.updateServerTimestamp(str, j);
    }

    public List<NotesDocumentEntity> getIsDirtyList(int i, boolean z) {
        return this.mSyncDocumentDao.getIsDirtyDocList(i, z, "");
    }

    public int getUnreadCoeditNoteCount(String str) {
        return this.mSyncMdeDao.getUnreadCoeditNoteCount(str);
    }

    public int getUnreadMdeNoteCount(String str) {
        return this.mSyncMdeDao.getUnreadMdeNoteCount(str);
    }

    public void updateNoteCategory(String str, String str2) {
        Debugger.m8614f(TAG, "updateNoteCategory, uuid: " + str + ", folderUuid: " + str2);
        this.mSyncDocumentDao.updateNoteCategory(str, str2);
    }
}
