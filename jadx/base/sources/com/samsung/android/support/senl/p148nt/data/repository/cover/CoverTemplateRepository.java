package com.samsung.android.support.senl.p148nt.data.repository.cover;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverTemplateEntity;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverTemplateRepository {
    private static final String TAG = DataLogger.createTag("CoverTemplateRepository");
    private final CoverTemplateDao mCoverTemplateDao = NotesDatabaseManager.getInstance().getCoverTemplateDao();

    public List<String> getPredefinedUuids() {
        return this.mCoverTemplateDao.getPredefinedUuids();
    }

    public void insert(List<CoverTemplateEntity> list) {
        DataLogger.m12307i(TAG, "insert, entities: " + list.size());
        this.mCoverTemplateDao.upsert((Collection) list);
    }

    public void insertIfNotExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCoverTemplateDao.insertIfNotExists(str);
    }
}
