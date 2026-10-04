package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SttContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SttContentRepository {
    private static final String TAG = DataLogger.createTag("SttContentRepository");
    private final SttContentDao mDao = NotesDatabaseManager.getInstance().getSttContentDao();

    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, docUuid : ", str, TAG);
        this.mDao.deleteByUuid(str);
    }

    public void deleteByUuids(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuids, docUuids : "), TAG);
        this.mDao.deleteByUuids(collection);
    }

    public void deleteDummy() {
        this.mDao.deleteDummy();
    }

    public List<SttContentEntity> getEntities(@NonNull String str) {
        AbstractC0000a.m2C("getEntities, docUuid: ", str, TAG);
        return this.mDao.getEntities(str);
    }

    public void insert(SttContentEntity sttContentEntity) {
        DataLogger.m12307i(TAG, "insert, uuid: " + sttContentEntity.getDocumentUuid());
        this.mDao.upsert(sttContentEntity);
    }

    public void insert(List<SttContentEntity> list) {
        DataLogger.m12307i(TAG, "insert, entities: " + list.size());
        this.mDao.upsert((Collection) list);
    }

    public List<SttContentEntity> getEntities(@NonNull String str, String str2) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("getEntities, docUuid: ", str, ", filePath: ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str3, sbM15l.toString());
        return this.mDao.getEntities(str, str2);
    }

    public List<SttContentEntity> getEntities(@NonNull String str, String str2, int i) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("getEntities, docUuid: ", str, ", filePath: ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", type: ");
        sbM15l.append(i);
        DataLogger.m12307i(str3, sbM15l.toString());
        return this.mDao.getEntities(str, str2, i);
    }
}
