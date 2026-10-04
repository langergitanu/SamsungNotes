package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.text.TextUtils;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesHashtagContentDao implements BaseDao<NotesHashtagContentEntity> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HashTagExtra {
        public static final int DELETE = 2;
        public static final int INSERT = 0;
        public static final int UPDATE = 1;
        public static final int UPDATE_LAST_ADDED_TIME = 3;
        private final NotesHashtagContentEntity mContentEntity;
        private final NotesHashtagEntity mEntity;
        private final int mOperation;

        public HashTagExtra(int i, NotesHashtagContentEntity notesHashtagContentEntity, NotesHashtagEntity notesHashtagEntity) {
            this.mOperation = i;
            this.mContentEntity = notesHashtagContentEntity;
            this.mEntity = notesHashtagEntity;
        }

        public NotesHashtagContentEntity getContentEntity() {
            return this.mContentEntity;
        }

        public NotesHashtagEntity getEntity() {
            return this.mEntity;
        }

        public int getOperation() {
            return this.mOperation;
        }
    }

    private void updateLastAddedTimeOperation(NotesHashtagContentEntity notesHashtagContentEntity) {
        if (notesHashtagContentEntity != null) {
            updateLastAddedTime(notesHashtagContentEntity.getSdocUuid(), notesHashtagContentEntity.getServerTimestamp().longValue());
        }
    }

    @Query("DELETE FROM hashtagContent WHERE hashtagUUID=:hashtagUuid")
    public abstract void deleteByHashtagUuid(String str);

    @Query("DELETE FROM hashtagContent WHERE sdocUUID=:sdocUuid AND hashtagUUID=:hashtagUuid")
    public abstract void deleteBySdocUuidAndContentUuid(String str, String str2);

    @Query("DELETE FROM hashtagContent WHERE sdocUUID=:sdocUuid")
    public abstract int deleteByUuid(String str);

    @Query("DELETE FROM hashtagContent WHERE sdocUUID IN (:sdocUuids)")
    public abstract int deleteByUuid(Collection<String> collection);

    @Transaction
    public int deleteByUuids(Collection<String> collection) {
        return SplitTaskExecutor.getInt(new C11250g(this), collection);
    }

    @Query("DELETE FROM hashtagContent WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    public void deleteOperation(NotesHashtagContentEntity notesHashtagContentEntity) {
        if (notesHashtagContentEntity != null) {
            String hashtagUuid = notesHashtagContentEntity.getHashtagUuid();
            String sdocUuid = notesHashtagContentEntity.getSdocUuid();
            boolean zIsEmpty = TextUtils.isEmpty(hashtagUuid);
            boolean zIsEmpty2 = TextUtils.isEmpty(sdocUuid);
            if (!zIsEmpty && !zIsEmpty2) {
                deleteBySdocUuidAndContentUuid(sdocUuid, hashtagUuid);
            } else if (!zIsEmpty) {
                deleteByHashtagUuid(hashtagUuid);
            } else {
                if (zIsEmpty2) {
                    return;
                }
                deleteByUuid(sdocUuid);
            }
        }
    }

    @Query("SELECT * FROM hashtagContent WHERE sdocUUID=:sdocUuid AND hashtagUUID=:hashtagUuid")
    public abstract NotesHashtagContentEntity getEntityBySdocUuidAndContentUuid(String str, String str2);

    @Query("SELECT 1 FROM hashtagContent WHERE sdocUUID in (:sdocUuids)")
    public abstract boolean hashTagContentExists(Collection<String> collection);

    @Transaction
    public boolean hashTagExists(List<String> list) {
        return SplitTaskExecutor.getBoolean(new C11250g(this), list);
    }

    public void insertOperation(NotesHashtagDao notesHashtagDao, NotesHashtagContentEntity notesHashtagContentEntity, NotesHashtagEntity notesHashtagEntity) {
        if (notesHashtagContentEntity != null) {
            upsert(notesHashtagContentEntity);
        }
        if (notesHashtagEntity != null) {
            notesHashtagDao.upsert(notesHashtagEntity);
        }
    }

    @Query("UPDATE hashtagContent SET serverTimestamp=:timestamp, lastModifiedAt=:lastModifiedAt, isDirty=:dirtyFlag, extraInfo=:extraInfo WHERE sdocUUID=:sdocUuid AND hashtagUUID=:hashtagUuid")
    public abstract void updateBySdocUuidAndContentUuid(String str, String str2, long j, long j2, int i, String str3);

    @Transaction
    public void updateBySdocUuidAndContentUuid(ArrayList<NotesHashtagContentEntity> arrayList) {
        for (NotesHashtagContentEntity notesHashtagContentEntity : arrayList) {
            updateBySdocUuidAndContentUuid(notesHashtagContentEntity.getSdocUuid(), notesHashtagContentEntity.getHashtagUuid(), notesHashtagContentEntity.getServerTimestamp().longValue(), notesHashtagContentEntity.getLastModifiedAt(), notesHashtagContentEntity.getIsDirty(), notesHashtagContentEntity.getExtraInfo());
        }
    }

    @Query("UPDATE hashtagContent SET isDirty=:dirtyFlag WHERE sdocUUID=:sdocUuid")
    public abstract void updateDirtyBySdocUuid(String str, int i);

    @Transaction
    public void updateHashTagsBySdocUuid(NotesHashtagDao notesHashtagDao, ArrayList<HashTagExtra> arrayList) {
        for (HashTagExtra hashTagExtra : arrayList) {
            int operation = hashTagExtra.getOperation();
            if (operation == 0) {
                insertOperation(notesHashtagDao, hashTagExtra.getContentEntity(), hashTagExtra.getEntity());
            } else if (operation == 1) {
                updateOperation(notesHashtagDao, hashTagExtra.getContentEntity(), hashTagExtra.getEntity());
            } else if (operation == 2) {
                deleteOperation(hashTagExtra.getContentEntity());
            } else if (operation == 3) {
                updateLastAddedTimeOperation(hashTagExtra.getContentEntity());
            }
        }
    }

    @Query("UPDATE hashtagContent SET serverTimestamp=:serverTimestamp  WHERE sdocUUID=:sdocUuid")
    public abstract void updateLastAddedTime(String str, long j);

    public void updateOperation(NotesHashtagDao notesHashtagDao, NotesHashtagContentEntity notesHashtagContentEntity, NotesHashtagEntity notesHashtagEntity) {
        if (notesHashtagContentEntity != null) {
            update(notesHashtagContentEntity);
        }
        if (notesHashtagEntity != null) {
            notesHashtagDao.update(notesHashtagEntity);
        }
    }
}
