package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.work.multiprocess.C4148a;
import com.samsung.android.livetranslation.util.C7182m;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncFolderInfoEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncFolderInfoDao implements BaseDao<SyncFolderInfoEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$updateDeletedBy$0(int i, List list) {
        updateDeletedByInChunk(list, i);
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDeletedBy$1(int i, String str) {
        SyncFolderInfoEntity syncFolderInfoEntity = new SyncFolderInfoEntity();
        syncFolderInfoEntity.setUuid(str);
        syncFolderInfoEntity.setDeletedBy(i);
        insert(syncFolderInfoEntity);
    }

    @Query("SELECT UUID FROM sync_folder_info WHERE UUID IN (:uuids)")
    public abstract List<String> getUuidsInChunk(List<String> list);

    @Transaction
    public void updateDeletedBy(List<String> list, @DataBaseConstants.DeletedBy int i) {
        List listExecute = new SplitTaskExecutor(new C11253j(this, 5)).execute(list);
        new SplitTaskExecutor(new C4148a(this, i, 4)).execute(listExecute);
        list.removeAll(listExecute);
        list.forEach(new C7182m(this, i, 1));
    }

    @Query("UPDATE OR ABORT sync_folder_info SET deletedBy=:deletedBy WHERE UUID IN (:uuids)")
    public abstract void updateDeletedByInChunk(List<String> list, @DataBaseConstants.DeletedBy int i);
}
