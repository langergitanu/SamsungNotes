package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.sqlite.SQLiteConstraintException;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class DocumentThumbnailDao implements BaseDao<DocumentThumbnailEntity> {
    private static final String TAG = DataLogger.createTag("DocumentThumbnailDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$delete$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Transaction
    public void delete(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 18)).execute(collection);
    }

    @Query("DELETE FROM document_thumbnail WHERE UUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM document_thumbnail WHERE UUID IN (:docUuids)")
    public abstract void deleteInChunk(Collection<String> collection);

    @Query("SELECT * FROM document_thumbnail WHERE UUID = :uuid")
    public abstract DocumentThumbnailEntity getEntity(String str);

    @Transaction
    public void upsert2(Collection<DocumentThumbnailEntity> collection) {
        Iterator<DocumentThumbnailEntity> it = collection.iterator();
        while (it.hasNext()) {
            try {
                upsert(it.next());
            } catch (SQLiteConstraintException e) {
                DataLogger.m12303e(TAG, "upsert2, e: " + e.getMessage());
            }
        }
    }
}
