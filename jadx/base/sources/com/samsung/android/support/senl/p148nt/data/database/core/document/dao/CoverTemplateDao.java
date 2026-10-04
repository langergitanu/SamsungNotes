package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverTemplateEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class CoverTemplateDao implements BaseDao<CoverTemplateEntity> {
    private static final String TAG = DataLogger.createTag("CoverTemplateDao");

    @Query("SELECT * FROM cover_template WHERE UUID=:uuid")
    public abstract CoverTemplateEntity getEntity(String str);

    @Query("SELECT UUID FROM cover_template WHERE UUID LIKE '%:///'")
    public abstract List<String> getPredefinedUuids();

    @Transaction
    public void insertIfNotExists(String str) {
        if (getEntity(str) == null) {
            DataLogger.m12307i(TAG, "insertIfNotExists, templateUuid: " + str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            CoverTemplateEntity coverTemplateEntity = new CoverTemplateEntity();
            coverTemplateEntity.setUuid(str);
            coverTemplateEntity.setType(0);
            coverTemplateEntity.setCreatedAt(jCurrentTimeMillis);
            coverTemplateEntity.setLastModifiedAt(jCurrentTimeMillis);
            insert(coverTemplateEntity);
        }
    }
}
