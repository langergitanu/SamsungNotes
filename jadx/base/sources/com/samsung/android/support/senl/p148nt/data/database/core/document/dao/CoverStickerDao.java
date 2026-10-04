package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class CoverStickerDao implements BaseDao<CoverStickerEntity> {
    private static final String TAG = DataLogger.createTag("CoverStickerDao");

    @Query("SELECT * FROM cover_category WHERE UUID=:uuid")
    public abstract CoverStickerEntity getEntity(String str);

    @Query("SELECT UUID FROM cover_category WHERE UUID LIKE '%:///'")
    public abstract List<String> getPredefinedUuids();

    @Query("SELECT * FROM cover_category WHERE UUID IN (SELECT document_cover.categoryUUID FROM document_cover JOIN sdoc ON document_cover.documentUUID = sdoc.UUID WHERE document_cover.templateUUID IN (:templateUuidsWithCategory) AND document_cover.categoryUUID != 'NONE:///' AND document_cover.isEnabled = 1 AND sdoc.isDeleted = 0 AND sdoc.isLock = 0)")
    public abstract List<CoverStickerEntity> getUsedEntities(List<String> list);

    public void insertIfNotExists(String str) {
        if (getEntity(str) == null) {
            DataLogger.m12307i(TAG, "insertIfNotExists, categoryUuid: " + str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            CoverStickerEntity coverStickerEntity = new CoverStickerEntity();
            coverStickerEntity.setUuid(str);
            coverStickerEntity.setName(CoverStickerConstants.Category.NONE.NAME);
            coverStickerEntity.setCreatedAt(jCurrentTimeMillis);
            coverStickerEntity.setLastModifiedAt(jCurrentTimeMillis);
            insert(coverStickerEntity);
        }
    }
}
