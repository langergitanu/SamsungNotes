package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesHashtagDao implements BaseDao<NotesHashtagEntity> {
    @Query("DELETE FROM hashtag")
    public abstract void deleteAll();

    @Query("DELETE FROM hashtag WHERE UUID=:hashtagUuid")
    public abstract int deleteByUuid(String str);

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            deleteByUuid(it.next());
        }
    }

    @Query("SELECT *  FROM hashtag")
    public abstract List<NotesHashtagEntity> getAll();

    @Query("SELECT * FROM hashtag WHERE UUID=:tagUuid LIMIT 1")
    public abstract NotesHashtagEntity getEntity(String str);

    public String getHashTagUuid(String str, boolean z, boolean z2) {
        return z ? z2 ? getHashTagUuidWithDeletedIgnoreCase(str) : getHashTagUuidWithDeleted(str) : z2 ? getHashTagUuidWithoutDeletedIgnoreCase(str) : getHashTagUuidWithoutDeleted(str);
    }

    @Query("SELECT UUID FROM hashtag WHERE name=:hashTagName LIMIT 1")
    public abstract String getHashTagUuidWithDeleted(String str);

    @Query("SELECT UUID FROM hashtag WHERE name=:hashTagName COLLATE NOCASE LIMIT 1")
    public abstract String getHashTagUuidWithDeletedIgnoreCase(String str);

    @Query("SELECT UUID FROM hashtag WHERE name=:hashTagName AND isDeleted=0 LIMIT 1")
    public abstract String getHashTagUuidWithoutDeleted(String str);

    @Query("SELECT UUID FROM hashtag WHERE name=:hashTagName COLLATE NOCASE AND isDeleted=0 LIMIT 1")
    public abstract String getHashTagUuidWithoutDeletedIgnoreCase(String str);

    @RawQuery(observedEntities = {NotesHashtagEntity.class})
    public abstract List<NotesHashtagEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesHashtagEntity.class})
    public abstract LiveData<List<NotesHashtagEntity>> rawQuery_LiveData(SupportSQLiteQuery supportSQLiteQuery);

    @Query("UPDATE hashtag SET isDirty =:dirtyFlag  WHERE UUID=:hashtagUUID")
    public abstract void updateDirtyByHashtagUuid(String str, int i);

    @Query("UPDATE hashtag SET serverTimestamp =:timestamp  WHERE UUID=:hashtagUUID")
    public abstract void updateServerTimestampByHashtagUuid(String str, long j);
}
