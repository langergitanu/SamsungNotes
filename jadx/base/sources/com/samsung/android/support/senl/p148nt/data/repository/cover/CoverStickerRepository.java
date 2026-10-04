package com.samsung.android.support.senl.p148nt.data.repository.cover;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerRepository {
    private static final String TAG = DataLogger.createTag("CoverStickerRepository");
    private final CoverStickerDao mCoverStickerDao = NotesDatabaseManager.getInstance().getCoverStickerDao();

    public List<String> getPredefinedUuids() {
        return this.mCoverStickerDao.getPredefinedUuids();
    }

    public List<CoverStickerEntity> getUsedEntities() {
        DataLogger.m12307i(TAG, "getUsedEntities");
        return this.mCoverStickerDao.getUsedEntities(CoverConstants.getCoverTemplateUuidsWithSummaryAndCategory());
    }

    public void insert(List<CoverStickerEntity> list) {
        DataLogger.m12307i(TAG, "insert, entities: " + list.size());
        this.mCoverStickerDao.upsert((Collection) list);
    }

    public void insertIfNotExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCoverStickerDao.insertIfNotExists(str);
    }
}
