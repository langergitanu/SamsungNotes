package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import java.util.Collection;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentExtraRepository {
    private static final String TAG = DataLogger.createTag("DocumentExtraRepository");
    private final DocumentExtraDao mDao = NotesDatabaseManager.getInstance().getDocumentExtraDao();

    public void deleteByUuids(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuids, size: "), TAG);
        this.mDao.deleteByUuids(collection);
    }

    public void deleteDummy() {
        this.mDao.deleteDummy();
    }

    public DocumentExtraEntity getEntity(@NonNull String str) {
        AbstractC0000a.m2C("getEntity, uuid: ", str, TAG);
        return this.mDao.getEntity(str);
    }

    public void insert(@NonNull DocumentExtraEntity documentExtraEntity) {
        DataLogger.m12307i(TAG, "insert, uuid: " + documentExtraEntity.getUuid());
        this.mDao.upsert(documentExtraEntity);
    }

    public void updateFormatVersion(@NonNull String str, int i) {
        DataLogger.m12307i(TAG, "updateFormatVersion: " + str + " / " + i);
        this.mDao.updateFormatVersion(str, i);
    }
}
