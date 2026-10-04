package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class StickyNoteDao implements BaseDao<StickyNoteEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByDocUuids$0(List list) {
        deleteByDocUuidsInChunk(list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidAndPageIds$1(String str, List list) {
        deleteByUuidAndPageIdsInChunk(str, list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$retainOnly$2(List list) {
        deleteNotIncluded(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByDocUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C11254k(this, 0)).execute(collection);
    }

    @Query("DELETE FROM sticky WHERE documentUUID IN (:docUuids)")
    public abstract void deleteByDocUuidsInChunk(Collection<String> collection);

    @Transaction
    public void deleteByUuidAndPageIds(String str, List<String> list) {
        new SplitTaskExecutor(new C0287e(this, str, 22)).execute(list);
    }

    @Query("DELETE FROM sticky WHERE documentUUID = :docUuid AND pageUuid IN (:pageUuids)")
    public abstract void deleteByUuidAndPageIdsInChunk(String str, Collection<String> collection);

    @Query("DELETE FROM sticky WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM sticky WHERE objectId NOT IN (:retainedObjectIds)")
    public abstract void deleteNotIncluded(Collection<String> collection);

    @Query("SELECT * FROM sticky WHERE documentUUID = :docUuid")
    public abstract List<StickyNoteEntity> getEntities(String str);

    @Query("SELECT * FROM sticky WHERE objectId = :objectId")
    public abstract StickyNoteEntity getEntity(String str);

    @Transaction
    public void retainOnly(Map<String, StickyNoteEntity> map) {
        if (map.isEmpty()) {
            deleteNotIncluded(new ArrayList());
        } else {
            new SplitTaskExecutor(new C11254k(this, 1)).execute(map.keySet());
            upsert((Collection) map.values());
        }
    }
}
