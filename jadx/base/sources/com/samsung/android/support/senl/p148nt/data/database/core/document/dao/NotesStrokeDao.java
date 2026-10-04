package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesStrokeDao implements BaseDao<NotesStrokeSearchEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Query("DELETE FROM stroke WHERE sdocUUID=:docUuid")
    public abstract int deleteByUuid(String str);

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 29)).execute(collection);
    }

    @Query("DELETE FROM stroke WHERE sdocUUID=:uuid AND pageUuid IN (:pageIdList)")
    public abstract void deleteByUuidAndPageIds(String str, List<String> list);

    @Query("DELETE FROM stroke WHERE sdocUUID=:uuid AND pageUuid IN (:pageIds) AND type IN (:types)")
    public abstract void deleteByUuidAndPageIds(String str, List<String> list, int... iArr);

    @Query("DELETE FROM stroke WHERE sdocUUID=:uuid AND pageUuid IN (:pageIdList) AND type NOT IN (:excludedTypes)")
    public abstract void deleteByUuidAndPageIdsWithExcludedTypes(String str, List<String> list, int... iArr);

    @Query("DELETE FROM stroke WHERE sdocUUID=:uuid AND type IN (:types)")
    public abstract void deleteByUuidWithTypes(String str, int... iArr);

    @Query("DELETE FROM stroke WHERE sdocUUID IN (:docUuids)")
    public abstract void deleteByUuids(Collection<String> collection);

    @Query("DELETE FROM stroke WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM stroke WHERE sdocUUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT * FROM stroke WHERE sdocUUID=:uuid AND type =:type")
    public abstract List<NotesStrokeSearchEntity> getEntities(String str, int i);

    @Query("SELECT * FROM stroke WHERE sdocUUID=:uuid AND type NOT IN (:excludedTypes)")
    public abstract List<NotesStrokeSearchEntity> getEntityListWithExcludedTypes(String str, int... iArr);

    @Query("SELECT pageUuid FROM stroke WHERE sdocUUID=:uuid AND type IN (:searchDataTypes) GROUP BY pageUuid")
    public abstract List<String> getPageIdListByUuid(String str, int... iArr);
}
