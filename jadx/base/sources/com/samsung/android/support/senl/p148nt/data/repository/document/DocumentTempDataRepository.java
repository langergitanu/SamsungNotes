package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentTempDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentTempDataRepository {
    private static final String TAG = DataLogger.createTag("DocumentTempDataRepository");
    private final DocumentTempDataDao mDao = NotesDatabaseManager.getInstance().getDocumentTempDataDao();

    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, docUuid: ", str, TAG);
        this.mDao.deleteByUuid(str);
    }

    public void deleteByUuids(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuids, docUuid: "), TAG);
        this.mDao.deleteByUuids(collection);
    }

    public void deleteDummy() {
        this.mDao.deleteDummy();
    }

    public List<DocumentTempDataEntity> getEntities(@NonNull String str) {
        DataLogger.m12307i(TAG, "getEntities");
        return this.mDao.getEntities(str);
    }

    public DocumentTempDataEntity getEntity(@NonNull String str) {
        AbstractC0000a.m2C("getEntity, uuid: ", str, TAG);
        return this.mDao.getEntity(str);
    }

    public void insert(DocumentTempDataEntity documentTempDataEntity) {
        DataLogger.m12307i(TAG, "insert, uuid: " + documentTempDataEntity.getUuid());
        this.mDao.upsert(documentTempDataEntity);
    }

    public void update(DocumentTempDataEntity documentTempDataEntity) {
        DataLogger.m12307i(TAG, "update, uuid: " + documentTempDataEntity.getUuid());
        this.mDao.update(documentTempDataEntity);
    }
}
