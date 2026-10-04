package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.common.constants.RetryState;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesRetryDao implements BaseDao<NotesRetryEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        deleteByUuids(list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteEntities$1(List list) {
        delete((Collection<? extends NotesRetryEntity>) list);
        return new ArrayList();
    }

    @Delete
    public abstract int delete(Collection<? extends NotesRetryEntity> collection);

    @Query("DELETE FROM retry WHERE sdocUUID=:docUuid")
    public abstract int deleteByUuid(String str);

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C11251h(this, 1)).execute(collection);
    }

    @Query("DELETE FROM retry WHERE sdocUUID IN (:docUuids)")
    public abstract int deleteByUuids(Collection<String> collection);

    @Query("DELETE FROM retry WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Transaction
    public void deleteEntities(Collection<NotesRetryEntity> collection) {
        new SplitTaskExecutor(new C11251h(this, 0)).execute(collection);
    }

    @Query("SELECT COUNT(*) FROM retry WHERE state=:retryState")
    public abstract int getCountInState(@RetryState int i);

    @Query("SELECT * FROM retry WHERE state=:retryState")
    public abstract List<NotesRetryEntity> getStateInReadyList(@RetryState int i);

    @Query("SELECT retry.version FROM retry WHERE sdocUUID=:docUuid")
    public abstract int getVersion(String str);

    @Query("UPDATE OR ABORT retry SET state=:retryState WHERE sdocUUID=:sDocUUID")
    public abstract int updateState(String str, @RetryState int i);
}
