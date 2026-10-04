package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class StickyStrokeDao implements BaseDao<StickyStrokeSearchEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        deleteByUuids(list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidAndPageIds$1(String str, List list) {
        deleteByUuidAndPageIdsInChunk(str, list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C11253j(this, 1)).execute(collection);
    }

    @Transaction
    public void deleteByUuidAndPageIds(String str, List<String> list) {
        new SplitTaskExecutor(new C0287e(this, str, 23)).execute(list);
    }

    @Query("DELETE FROM sticky_stroke WHERE objectId IN (SELECT objectId FROM sticky WHERE documentUUID = :docUuid AND pageUuid IN (:pageIds))")
    public abstract void deleteByUuidAndPageIdsInChunk(String str, List<String> list);

    @Query("DELETE FROM sticky_stroke WHERE objectId IN (SELECT objectId FROM sticky WHERE documentUUID IN (:docUuids))")
    public abstract void deleteByUuids(Collection<String> collection);
}
