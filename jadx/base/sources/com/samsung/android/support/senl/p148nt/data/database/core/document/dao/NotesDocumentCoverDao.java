package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesDocumentCoverDao implements BaseDao<NotesDocumentCoverEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 25)).execute(collection);
    }

    @Query("DELETE FROM document_cover WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM document_cover WHERE documentUUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT document_cover.*, state FROM document_cover JOIN suggested_cover ON document_cover.documentUUID = suggested_cover.documentUUID WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND document_cover.documentUUID = sdoc.UUID)")
    public abstract LiveData<List<DocumentCoverStateTuple>> getAllTuples_LiveData();

    @Query("SELECT document_cover.*, state FROM document_cover JOIN suggested_cover ON document_cover.documentUUID = suggested_cover.documentUUID WHERE document_cover.documentUUID = :docUuid")
    public abstract DocumentCoverStateTuple getCoverStateTuple(String str);

    @Query("SELECT * FROM document_cover WHERE documentUUID=:uuid")
    public abstract NotesDocumentCoverEntity getEntity(String str);

    @Query("SELECT UUID FROM sdoc WHERE UUID IN (SELECT documentUUID FROM document_cover WHERE categoryUUID=:categoryUuid AND isEnabled = 1) AND isDeleted=:deleteType AND sdoc.isLock = 0")
    public abstract List<String> getUuidList(String str, int i);

    @Query("UPDATE OR ABORT document_cover SET isEnabled=:enabled WHERE documentUUID=:docUuid")
    public abstract void updateEnabled(String str, int i);
}
