package com.samsung.android.support.senl.p148nt.data.repository.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesPageSearchInfoRepository {
    private static final String TAG = DataLogger.createTag("NotesPageSearchInfoRepository");
    private final NotesPageSearchInfoDao mPageSearchInfoDao = NotesDatabaseManager.getInstance().getPageSearchInfoDao();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        this.mPageSearchInfoDao.deleteByUuid(list);
        return new ArrayList();
    }

    public void delete(@NonNull NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        DataLogger.m12307i(TAG, "delete, entity : " + notesPageSearchInfoEntity);
        this.mPageSearchInfoDao.delete(notesPageSearchInfoEntity);
    }

    public void deleteByUuid(List<String> list) {
        DataLogger.m12307i(TAG, "deleteByUuid, doc count: " + list.size());
        new SplitTaskExecutor(new C0061b(this, 10)).execute(list);
    }

    public void deleteDummy() {
        this.mPageSearchInfoDao.deleteDummy();
    }

    public List<NotesPageSearchInfoEntity> getEntities(String str) {
        return this.mPageSearchInfoDao.getEntities(str);
    }

    @Nullable
    public NotesPageSearchInfoEntity getEntity(String str, String str2) {
        return this.mPageSearchInfoDao.getEntity(str, str2);
    }

    public void insert(@NonNull NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesPageSearchInfoEntity);
        this.mPageSearchInfoDao.upsert(notesPageSearchInfoEntity);
    }

    public void update(@NonNull NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        DataLogger.m12307i(TAG, "update, entity : " + notesPageSearchInfoEntity);
        this.mPageSearchInfoDao.update(notesPageSearchInfoEntity);
    }

    public void delete(@NonNull Collection<? extends NotesPageSearchInfoEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("delete, entities : "), TAG);
        this.mPageSearchInfoDao.delete(collection);
    }

    public void insert(@NonNull Collection<? extends NotesPageSearchInfoEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities : "), TAG);
        this.mPageSearchInfoDao.upsert((Collection) collection);
    }
}
