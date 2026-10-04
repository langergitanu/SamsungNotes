package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesContentDao implements BaseDao<NotesContentEntity> {
    private static final String TAG = DataLogger.createTag("NotesContentDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteBySDocUuid$0(List list) {
        deleteInChunk(list);
        return new ArrayList();
    }

    @Query("DELETE FROM content WHERE sdocUUID=:sdocUuid AND mime_type NOT IN (:excludedTypes)")
    public abstract void deleteBySDocUuid(String str, Collection<String> collection);

    @Transaction
    public void deleteBySDocUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 22)).execute(collection);
    }

    @Query("DELETE FROM content WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("DELETE FROM content WHERE sdocUUID IN (:docUuids)")
    public abstract void deleteInChunk(List<String> list);

    @Query("SELECT * FROM content")
    public abstract List<NotesContentEntity> getAll();

    public List<ContentFileData> getContentFileDataByQuery(String str, String str2) {
        return rawQuery(new SimpleSQLiteQuery(AbstractC0541b.m774p("SELECT content.UUID, content.sdocUUID, sdoc.filePath, content.filePath AS `contentPath`, content.displayName,            content.mime_type, content.size, content.createdAt            FROM (SELECT * FROM content WHERE mime_type = '", str, "') AS content            JOIN sdoc ON content.sdocUUID = sdoc.UUID            WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = ''", str2)));
    }

    @Query("SELECT * FROM content WHERE sdocUUID=:docUuid AND contentSecureVersion != :contentSecureVersion")
    public abstract List<NotesContentEntity> getEntitiesWithNonMatchingVersion(String str, int i);

    @Query("SELECT content.UUID, content.sdocUUID, sdoc.filePath, content.filePath AS `contentPath`, content.displayName, content.mime_type, content.size, content.createdAt FROM (SELECT * FROM content WHERE mime_type = :mimeType) AS content JOIN sdoc ON content.sdocUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = ''")
    public abstract LiveData<List<ContentFileData>> getLiveContentFileDataByMimeType(String str);

    @RawQuery
    public abstract List<ContentFileData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @NonNull
    public List<ContentFileData> rawQuery(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return new ArrayList();
        }
    }

    @Update
    public abstract int update(Collection<NotesContentEntity> collection);

    @Query("UPDATE OR ABORT content SET isDeleted=:isDeleted WHERE UUID=:sdocUuid")
    public abstract void updateIsDeleted(String str, int i);

    @Query("UPDATE OR ABORT content SET isDirty=:isDirty , isDeleted=:isDeleted WHERE UUID=:sdocUuid")
    public abstract void updateIsDirtyAndIsDeleted(String str, int i, int i2);
}
