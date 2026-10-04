package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SttContentDao implements BaseDao<SttContentEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Query("DELETE FROM stt_content WHERE documentUUID=:docUuid")
    public abstract void deleteByUuid(String str);

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C11253j(this, 3)).execute(collection);
    }

    @Query("DELETE FROM stt_content WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM stt_content WHERE documentUUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT * FROM stt_content WHERE documentUUID=:docUuid")
    public abstract List<SttContentEntity> getEntities(String str);

    @Query("SELECT * FROM stt_content WHERE documentUUID=:docUuid AND filePath=:filePath")
    public abstract List<SttContentEntity> getEntities(String str, String str2);

    @Query("SELECT * FROM stt_content WHERE documentUUID=:docUuid AND filePath=:filePath AND type=:type")
    public abstract List<SttContentEntity> getEntities(String str, String str2, int i);
}
