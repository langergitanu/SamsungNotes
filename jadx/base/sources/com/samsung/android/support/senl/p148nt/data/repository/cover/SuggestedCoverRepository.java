package com.samsung.android.support.senl.p148nt.data.repository.cover;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SuggestedCoverRepository {
    private static final String TAG = DataLogger.createTag("SuggestedCoverRepository");
    private final SuggestedCoverDao mSuggestedCoverDao = NotesDatabaseManager.getInstance().getSuggestedCoverDao();

    public void deleteByUuids(List<String> list) {
        DataLogger.m12307i(TAG, "deleteByUuids, docUuids : " + list.size());
        this.mSuggestedCoverDao.deleteByUuids(list);
    }

    public void deleteDummy() {
        this.mSuggestedCoverDao.deleteDummy();
    }

    @Nullable
    public SuggestedCoverEntity getEntity(String str) {
        return this.mSuggestedCoverDao.getEntity(str);
    }

    public void update(SuggestedCoverEntity suggestedCoverEntity) {
        DataLogger.m12307i(TAG, "update, entity: " + suggestedCoverEntity.getDocUuid());
        try {
            this.mSuggestedCoverDao.upsert(suggestedCoverEntity);
        } catch (SQLiteConstraintException e) {
            throw new NotesSQLiteConstraintException(e);
        }
    }

    public void updateState(String str, @CoverConstants.SuggestedState int i, @CoverConstants.SuggestedState int i2) {
        this.mSuggestedCoverDao.updateState(str, i, i2);
    }
}
