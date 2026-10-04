package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncDelayInfoDao implements BaseDao<SyncDelayInfoEntity> {
    @Query("DELETE FROM sync_delay_info WHERE UUID = :uuid")
    public abstract void delete(String str);

    @Query("SELECT * FROM sync_delay_info WHERE UUID = :uuid")
    public abstract SyncDelayInfoEntity getEntity(String str);

    @Query("SELECT * FROM sync_delay_info")
    public abstract List<SyncDelayInfoEntity> getEntityList();

    @Query("SELECT * FROM sync_delay_info WHERE appVersion != :appVersion OR (appVersion = :appVersion AND retryCount < :retryLimit)")
    public abstract List<SyncDelayInfoEntity> getEntityList(String str, int i);
}
