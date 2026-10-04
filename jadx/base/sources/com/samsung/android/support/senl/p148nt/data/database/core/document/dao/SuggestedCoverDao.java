package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SuggestedCoverDao implements BaseDao<SuggestedCoverEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C11253j(this, 4)).execute(collection);
    }

    @Query("DELETE FROM suggested_cover WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM suggested_cover WHERE documentUUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT * FROM suggested_cover WHERE documentUUID=:uuid")
    public abstract SuggestedCoverEntity getEntity(String str);

    @Query("UPDATE OR ABORT suggested_cover SET state=:state WHERE documentUUID=:docUuid")
    public abstract void updateState(String str, int i);

    @Query("UPDATE OR ABORT suggested_cover SET state=:to WHERE documentUUID=:docUuid AND state=:from")
    public abstract void updateState(String str, int i, int i2);
}
