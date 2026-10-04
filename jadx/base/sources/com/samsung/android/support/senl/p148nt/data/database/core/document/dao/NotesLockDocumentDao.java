package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesLockDocumentDao extends NotesDocumentDao {
    public static final String ORDER_BY = " ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC";

    @Query("SELECT sdoc.UUID FROM sdoc WHERE sdoc.isLock IS NOT 0 AND sdoc.categoryUUID IN (:folderUuid)")
    public abstract List<String> find(Collection<String> collection);

    @Query("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted=:deleteType AND sdoc.isLock IS NOT 0 AND map.UUID IS NULL")
    public abstract int getAllLockedDataCount(@DeleteType int i);

    @Query("SELECT sdoc.* FROM sdoc WHERE sdoc.isLock IN (:lockTypes) AND sdoc.UUID IN (:docUuids)")
    public abstract List<NotesDocumentEntity> getEntities(List<String> list, List<Integer> list2);

    @Query("SELECT COUNT(*) FROM sdoc WHERE sdoc.isLock IN (:lockTypes) AND sdoc.UUID IN (:uuids)")
    public abstract int getLockNoteCount(Collection<String> collection, List<Integer> list);

    @Query("SELECT isLock FROM sdoc WHERE UUID=:uuid")
    public abstract int getLockType(String str);

    @Query("SELECT sdoc.* FROM sdoc WHERE sdoc.isLock NOT IN (:excludeTypes) AND sdoc.UUID IN (:docUuids)")
    public abstract List<NotesDocumentEntity> getLockedEntitiesWithExcludeTypes(Collection<String> collection, List<Integer> list);

    @Query("SELECT sdoc.UUID FROM sdoc WHERE sdoc.isLock NOT IN (:excludeTypes) AND sdoc.UUID IN (:docUuids)")
    public abstract List<String> getLockedNoteUuidsWithExcludeTypes(Collection<String> collection, List<Integer> list);

    @Query("SELECT sdoc.filePath FROM sdoc WHERE sdoc.isDeleted != 1 AND (sdoc.lockAccountGuid IS NULL OR sdoc.lockAccountGuid = '')  AND sdoc.isLock IN (:lockTypes)")
    public abstract List<String> getPathListWithEmptyGuid(@LockType int... iArr);

    @Query("UPDATE OR ABORT sdoc SET isLock=:lockType WHERE UUID=:uuid")
    public abstract void lockByUuid(String str, @LockType int i);

    @Query("UPDATE OR ABORT sdoc SET lockAccountGuid=:lockAccountGuid WHERE sdoc.isDeleted != 1 AND (sdoc.lockAccountGuid IS NULL OR sdoc.lockAccountGuid = '')  AND sdoc.isLock IN (:lockTypes)")
    public abstract void updateLockGuidForUndefined(String str, @LockType int... iArr);
}
