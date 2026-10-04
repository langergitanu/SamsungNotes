package com.samsung.android.support.senl.p148nt.data.repository.sticky;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StickyStrokeRepository {
    private static final String TAG = DataLogger.createTag("StickyStrokeRepository");
    private final StickyStrokeDao mDao = NotesDatabaseManager.getInstance().getStickyStrokeDao();

    public void deleteByUuid(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuid, docUuids: "), TAG);
        this.mDao.deleteByUuid(collection);
    }

    public void deleteByUuidAndPageIds(String str, List<String> list) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidAndPageIds, uuid : ", str, ", removedPages : ");
        sbM15l.append(list.size());
        DataLogger.m12307i(str2, sbM15l.toString());
        this.mDao.deleteByUuidAndPageIds(str, list);
    }

    public void insert(@NonNull Collection<StickyStrokeSearchEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, size : "), TAG);
        this.mDao.upsert((Collection) collection);
    }
}
