package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesOrganizedDocumentDao implements BaseDao<NotesOrganizedDocumentEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 27)).execute(collection);
    }

    @Query("DELETE FROM organized_document WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM organized_document WHERE documentUUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT * FROM organized_document WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND organized_document.documentUUID = sdoc.UUID)  ORDER BY modified_time DESC")
    public abstract List<NotesOrganizedDocumentEntity> getAll();

    @Query("SELECT * FROM organized_document WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND organized_document.documentUUID = sdoc.UUID)  ORDER BY modified_time DESC")
    public abstract LiveData<List<NotesOrganizedDocumentEntity>> getAll_LiveData();

    @Query("SELECT * FROM organized_document WHERE documentUUID in (:docUuids)")
    public abstract List<NotesOrganizedDocumentEntity> getEntities(Collection<String> collection);

    @Query("SELECT * FROM organized_document WHERE documentUUID=:uuid")
    public abstract NotesOrganizedDocumentEntity getEntity(String str);
}
