package com.samsung.android.support.senl.p148nt.data.repository.sticky;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StickyNoteRepository {
    private static final String TAG = DataLogger.createTag("StickyNoteRepository");
    private final StickyNoteDao mDao = NotesDatabaseManager.getInstance().getStickyNoteDao();

    public void deleteByDocUuids(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByDocUuids, size: "), TAG);
        this.mDao.deleteByDocUuids(collection);
    }

    public void deleteByUuidAndPageIds(@NonNull String str, @NonNull List<String> list) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidAndPageIds, uuid : ", str, ", removedPages : ");
        sbM15l.append(list.size());
        DataLogger.m12307i(str2, sbM15l.toString());
        this.mDao.deleteByUuidAndPageIds(str, list);
    }

    public void deleteDummy() {
        this.mDao.deleteDummy();
    }

    public List<StickyNoteEntity> getEntities(@NonNull String str) {
        AbstractC0000a.m2C("getEntity, docUuid: ", str, TAG);
        return this.mDao.getEntities(str);
    }

    public StickyNoteEntity getEntity(@NonNull String str) {
        AbstractC0000a.m2C("getEntity, objectId: ", str, TAG);
        return this.mDao.getEntity(str);
    }

    public void insert(@NonNull Collection<StickyNoteEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities, size: "), TAG);
        this.mDao.upsert((Collection) collection);
    }

    public void retainOnly(@NonNull Map<String, StickyNoteEntity> map) {
        DataLogger.m12307i(TAG, "retainOnly, size: " + map.size());
        this.mDao.retainOnly(map);
    }
}
