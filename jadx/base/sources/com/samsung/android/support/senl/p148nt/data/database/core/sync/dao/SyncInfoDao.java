package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.work.multiprocess.C4148a;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncInfoDao implements BaseDao<SyncInfoEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$updateDeletedBy$0(int i, List list) {
        updateDeletedByInChunk(list, i);
        return Collections.EMPTY_LIST;
    }

    @Query("UPDATE OR ABORT sync_info SET syncState= (syncState | :addState) WHERE clientId=:clientId")
    public abstract void addSyncStateFlag(String str, long j);

    @Query("DELETE FROM sync_info")
    public abstract void deleteAll();

    @Query("DELETE FROM sync_info WHERE clientId=:clientId")
    public abstract int deleteByUuid(String str);

    @Query("SELECT * FROM sync_info ORDER BY clientId ASC")
    public abstract List<SyncInfoEntity> dumpSyncInfo();

    @Query("SELECT coeditCheckPoint FROM sync_info WHERE clientId=:clientId")
    public abstract long getCheckPoint(String str);

    @Query("SELECT commitId FROM sync_info WHERE clientId=:clientId")
    public abstract String getCommitId(String str);

    @Query("SELECT conflictStrategy FROM sync_info WHERE clientId=:clientId")
    public abstract int getConflictStrategy(String str);

    @Query("SELECT deviceName FROM sync_info WHERE clientId=:clientId")
    public abstract String getDeviceName(String str);

    @Query("SELECT COUNT(*)  FROM sdoc LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId WHERE isExtraInfoDirty=1 AND (sdoc.filePath LIKE '%.sdoc')")
    public abstract int getDirtyCountOfNoteExtraInfo();

    @Query("SELECT * FROM sync_info WHERE clientId=:clientId")
    public abstract SyncInfoEntity getEntity(String str);

    @Query("SELECT coeditResourceId FROM sync_info WHERE clientId=:clientId")
    public abstract String getResourceId(String str);

    @Query("SELECT serverId FROM sync_info WHERE clientId=:clientId")
    public abstract String getServerId(String str);

    @Query("SELECT strokeGrouped FROM sync_info WHERE clientId=:clientId")
    public abstract int getStrokeGrouped(String str);

    @Query("SELECT syncState FROM sync_info WHERE clientId=:clientId")
    public abstract long getSyncStateFlag(String str);

    @Query("SELECT clientId FROM sync_info WHERE `conflict`=1 AND conflictStrategy=:conflictStrategy")
    public abstract List<String> getUuidListByConflictStrategy(int i);

    @Query("SELECT sdoc.UUID  FROM sdoc LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId WHERE isExtraInfoDirty=:dirty  AND (sdoc.filePath LIKE '%.sdoc')")
    public abstract List<String> getUuidListByDirtyForExtraInfo(int i);

    @Query("SELECT clientId FROM sync_info WHERE (syncState & :syncState)")
    public abstract List<String> getUuidListBySyncState(long j);

    @Query("SELECT `conflict` FROM sync_info WHERE clientId=:clientId")
    public abstract int isConflicted(String str);

    @Query("SELECT `conflict` FROM sync_info WHERE clientId=:clientId")
    public abstract LiveData<Integer> isConflicted_LiveData(String str);

    @Query("SELECT 1 FROM sync_info WHERE clientId=:clientId")
    public abstract boolean isExistByClientId(String str);

    @RawQuery(observedEntities = {SyncInfoEntity.class})
    public abstract Cursor rawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @Query("UPDATE OR ABORT sync_info SET syncState=(syncState & ~:removeState) WHERE clientId=:clientId")
    public abstract void removeSyncStateFlag(String str, long j);

    @Query("UPDATE sync_info SET isSyncFailed=:value ")
    public abstract void resetAllIsSyncFailed(int i);

    @Query("UPDATE OR ABORT sync_info SET serverId='' , commitId='' , `conflict`=0 , conflictStrategy=0 WHERE clientId=:clientId")
    public abstract void resetDeletedNoteInServer(String str);

    @Query("UPDATE sync_info SET isExtraInfoDirty=:dirty  WHERE clientId=:docUuid")
    public abstract void setExtraInfoDirty(String str, int i);

    @Query("UPDATE OR ABORT sync_info SET strokeGrouped=:strokeGrouped WHERE clientId=:clientId")
    public abstract void setStrokeGrouped(String str, int i);

    @Query("UPDATE OR ABORT sync_info SET coeditCheckPoint=:checkPoint WHERE clientId=:clientId")
    public abstract void updateCheckPoint(String str, long j);

    @Query("UPDATE OR ABORT sync_info SET commitId=:commitId WHERE clientId=:clientId")
    public abstract void updateCommitId(String str, String str2);

    @Query("UPDATE OR ABORT sync_info SET `conflict`=:isConflicted , deviceName=:deviceName , conflictStrategy=:conflictStrategy WHERE clientId=:clientId")
    public abstract void updateConflict(String str, int i, String str2, int i2);

    @Query("UPDATE OR ABORT sync_info SET conflictStrategy=:conflictStrategy WHERE clientId=:clientId")
    public abstract void updateConflictStrategy(String str, int i);

    @Transaction
    public void updateDeletedBy(List<String> list, @DataBaseConstants.DeletedBy int i) {
        new SplitTaskExecutor(new C4148a(this, i, 5)).execute(list);
    }

    @Query("UPDATE OR ABORT sync_info SET deletedBy=:deletedBy WHERE clientId IN (:uuids)")
    public abstract void updateDeletedByInChunk(List<String> list, @DataBaseConstants.DeletedBy int i);

    @Query("UPDATE sdoc SET isDirty=:isDirtyFlag  WHERE UUID IN (SELECT clientId FROM sync_info WHERE isSyncFailed=:isSyncFailedFlag)")
    public abstract void updateIsDirtyByIsSyncFailed(int i, int i2);

    @Query("UPDATE sync_info SET isSyncFailed=:isSyncFailed  WHERE clientId=:docUuid")
    public abstract void updateIsSyncFailed(String str, int i);

    @Query("UPDATE OR ABORT sync_info SET coeditResourceId=:resourceId WHERE clientId=:clientId")
    public abstract void updateResourceId(String str, String str2);

    @Query("UPDATE OR ABORT sync_info SET serverId=:serverId WHERE clientId=:clientId")
    public abstract void updateServerId(String str, String str2);

    @Query("UPDATE OR ABORT sync_info SET syncState=:syncState WHERE clientId=:clientId")
    public abstract void updateSyncState(String str, long j);
}
