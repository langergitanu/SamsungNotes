package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class DocumentExtraDao implements BaseDao<DocumentExtraEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuids$0(List list) {
        deleteUuidsInChunk(list);
        return new ArrayList();
    }

    @Transaction
    public void deleteByUuids(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 16)).execute(collection);
    }

    @Query("DELETE FROM document_extra WHERE UUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM document_extra WHERE UUID IN (:docUuids)")
    public abstract void deleteUuidsInChunk(Collection<String> collection);

    @Query("SELECT * FROM document_extra WHERE UUID = :uuid")
    public abstract DocumentExtraEntity getEntity(String str);

    @Query("UPDATE OR ABORT document_extra SET formatVersion = (:formatVersion) WHERE UUID = :uuid")
    public abstract void updateFormatVersion(String str, int i);
}
