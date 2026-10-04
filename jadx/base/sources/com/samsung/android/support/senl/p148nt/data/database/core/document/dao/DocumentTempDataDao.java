package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class DocumentTempDataDao implements BaseDao<DocumentTempDataEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteByUuidsInChunk(list);
        return new ArrayList();
    }

    @Query("DELETE FROM document_temp_data WHERE UUID=:docUuid")
    public abstract void deleteByUuid(String str);

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 17)).execute(collection);
    }

    @Query("DELETE FROM document_temp_data WHERE UUID IN (:docUuids)")
    public abstract void deleteByUuidsInChunk(Collection<String> collection);

    @Query("DELETE FROM document_temp_data WHERE UUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("SELECT * FROM document_temp_data WHERE tempData LIKE '%' || :key || '%'")
    public abstract List<DocumentTempDataEntity> getEntities(String str);

    @Query("SELECT * FROM document_temp_data WHERE UUID=:docUuid")
    public abstract DocumentTempDataEntity getEntity(String str);
}
