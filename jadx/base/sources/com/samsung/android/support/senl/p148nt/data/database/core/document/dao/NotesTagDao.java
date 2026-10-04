package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.data.common.constants.TagSortType;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesTagDocCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.tag.TagBoardQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesTagDao implements BaseDao<NotesTagEntity> {
    private static final String ORDER_BY = " ORDER BY CASE WHEN :tagSortType=0 THEN normalizeName END ASC, CASE WHEN :tagSortType=1 THEN docCount END DESC,  CASE WHEN :tagSortType=2 THEN _id END DESC";
    private static final String sAllOldTagListQuery = "SELECT hashtagContent.serverTimestamp AS sortTime, hashtagContent._id AS _id, LOWER(hashtag.name) AS normalizeName, hashtagContent.sdocUUID AS docUUID, hashtag.name as displayName, COUNT(*) AS docCountOri FROM hashtag JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID JOIN hashtagContent ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON sdoc.UUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND mapped_document.UUID IS NULL  GROUP BY hashtag.UUID ";
    private static final String sAllTagListQuery = "SELECT sdoc.serverTimestamp AS sortTime, tag_list._id AS _id, tag_list.normalizeName AS normalizeName, tag_list.docUUID AS docUUID, tag_list.displayName as displayName, count(tag_list.docUUID) AS docCountOri FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 GROUP BY tag_list.normalizeName ";
    private static final String sAllUnionTagListQuery = "SELECT SUM(docCountOri) AS docCount, _id, normalizeName, docUUID, displayName FROM (SELECT sdoc.serverTimestamp AS sortTime, tag_list._id AS _id, tag_list.normalizeName AS normalizeName, tag_list.docUUID AS docUUID, tag_list.displayName as displayName, count(tag_list.docUUID) AS docCountOri FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 GROUP BY tag_list.normalizeName  UNION ALL SELECT hashtagContent.serverTimestamp AS sortTime, hashtagContent._id AS _id, LOWER(hashtag.name) AS normalizeName, hashtagContent.sdocUUID AS docUUID, hashtag.name as displayName, COUNT(*) AS docCountOri FROM hashtag JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID JOIN hashtagContent ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON sdoc.UUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND mapped_document.UUID IS NULL  GROUP BY hashtag.UUID ) GROUP BY displayName  ORDER BY CASE WHEN :tagSortType=0 THEN normalizeName END ASC, CASE WHEN :tagSortType=1 THEN docCount END DESC,  CASE WHEN :tagSortType=2 THEN _id END DESC";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuid$0(List list) {
        deleteByUuids(list);
        return new ArrayList();
    }

    @Transaction
    public boolean addTagsByDocUuid(List<String> list, String str) {
        List<String> tagNormalizeNameListByDocUuid = getTagNormalizeNameListByDocUuid(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (tagNormalizeNameListByDocUuid == null || !tagNormalizeNameListByDocUuid.contains(str2.toLowerCase())) {
                NotesTagEntity notesTagEntity = new NotesTagEntity();
                notesTagEntity.setNormalizeName(str2.toLowerCase());
                notesTagEntity.setDisplayName(str2);
                notesTagEntity.setDocUuid(str);
                arrayList.add(notesTagEntity);
            }
        }
        upsert((Collection) arrayList);
        return true;
    }

    @Transaction
    public boolean addTagsByDocUuidList(List<List<String>> list, List<String> list2) {
        for (int i = 0; i < list2.size(); i++) {
            addTagsByDocUuid(list.get(i), list2.get(i));
        }
        return true;
    }

    @Query("DELETE FROM tag_list")
    public abstract void deleteAll();

    @Query("DELETE FROM tag_list WHERE docUUID=:docUuid")
    public abstract void deleteByUuid(String str);

    @Transaction
    public void deleteByUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C11253j(this, 0)).execute(collection);
    }

    @Query("DELETE FROM tag_list WHERE docUUID IN (:docUuids)")
    public abstract void deleteByUuids(Collection<String> collection);

    @Query("DELETE FROM tag_list WHERE docUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("SELECT *  FROM tag_list")
    public abstract List<NotesTagEntity> getAll();

    @Query(sAllUnionTagListQuery)
    public abstract List<NotesTagDocCountEntry> getAllTagListWithDocCount(@TagSortType int i);

    @Query(sAllUnionTagListQuery)
    public abstract LiveData<List<NotesTagDocCountEntry>> getAllTagListWithDocCount_LiveData(@TagSortType int i);

    public LiveData<List<NotesTagDocCountEntry>> getAllTagListWithDocCount_LiveDataFiltered(@TagSortType int i) {
        return Transformations.distinctUntilChanged(getAllTagListWithDocCount_LiveData(i));
    }

    @Query("SELECT name FROM (SELECT tag_list.displayName AS name FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 GROUP BY tag_list.normalizeName  UNION SELECT hashtag.name AS name FROM hashtag LEFT JOIN hashtagContent ON hashtag.UUID = hashtagContent.hashtagUUID LEFT JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID LEFT OUTER JOIN mapped_document ON hashtagContent.sdocUUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mapped_document.UUID IS NULL GROUP BY LOWER(hashtag.name)) GROUP BY LOWER(name) ORDER BY LOWER(name) ASC")
    public abstract List<String> getAllTagsInUse();

    public Cursor getDataForTagBoard(String str, String[] strArr, String str2) {
        return rawQueryForTagBoard(new SimpleSQLiteQuery(new TagBoardQuery().getQuery(str, str2), strArr));
    }

    @Query("SELECT COUNT(*) FROM(SELECT docUUID FROM tag_list UNION SELECT sdocUUID FROM hashtagContent)")
    public abstract int getNotesCountUsingTag();

    @Query("SELECT MAX(tag_list._id), tag_list.normalizeName, tag_list.docUUID, tag_list.displayName FROM tag_list INNER JOIN sdoc ON (tag_list.docUUID=sdoc.UUID) WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 GROUP BY tag_list.normalizeName  ORDER BY tag_list._id DESC  LIMIT :limit")
    public abstract List<NotesTagEntity> getRecentTagList(int i);

    @Query("SELECT tag_list.* FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND tag_list.docUUID IN (SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName=:tagName GROUP BY tag_list.docUUID) GROUP BY tag_list.normalizeName  ORDER BY tag_list.normalizeName ASC")
    public abstract List<NotesTagEntity> getRelatedTagList(String str);

    @Query("SELECT name FROM(SELECT tag_list.displayName AS name FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND tag_list.docUUID IN (SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName IN (:normalizeNames) GROUP BY tag_list.docUUID HAVING COUNT(*)=:size) GROUP BY tag_list.normalizeName  UNION SELECT hashtag.name AS name FROM hashtag JOIN hashtagContent ON hashtag.UUID = hashtagContent.hashtagUUID JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND hashtagContent.sdocUUID IN (SELECT hashtagContent.sdocUUID FROM hashtagContent JOIN hashtag ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON hashtagContent.sdocUUID = mapped_document.UUID  WHERE mapped_document.UUID IS NULL AND LOWER(hashtag.name) IN (:normalizeNames) GROUP BY hashtagContent.sdocUUID HAVING COUNT(*)=:size) GROUP BY LOWER(hashtag.name)) GROUP BY LOWER(name) ORDER BY LOWER(name) ASC")
    public abstract List<String> getRelatedTags(Collection<String> collection, int i);

    @Query("SELECT * FROM tag_list WHERE docUUID=:docUuid  ORDER BY displayName ASC")
    public abstract List<NotesTagEntity> getTagListByDocUuid(String str);

    @Query("SELECT normalizeName FROM tag_list WHERE docUUID=:docUuid  ORDER BY displayName ASC")
    public abstract List<String> getTagNormalizeNameListByDocUuid(String str);

    @Query("SELECT _id, normalizeName FROM tag_list WHERE normalizeName=:tagNormalizedName LIMIT 1")
    public abstract boolean isTagExistByNormalizedName(String str);

    @Query("SELECT 1 FROM tag_list WHERE docUUID=:docUuid")
    public abstract boolean isTagsExistByDocUuid(String str);

    @Query("SELECT 1 FROM tag_list WHERE docUUID IN (:docUuid)")
    public abstract boolean isTagsExistByDocUuid(List<String> list);

    @RawQuery(observedEntities = {NotesTagEntity.class})
    public abstract List<NotesTagEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesTagEntity.class})
    public abstract Cursor rawQueryForTagBoard(SupportSQLiteQuery supportSQLiteQuery);

    @Update
    public abstract int update(Collection<NotesTagEntity> collection);

    @Transaction
    public boolean updateTagsByDocUuid(Collection<String> collection, String str) {
        deleteByUuid(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : collection) {
            NotesTagEntity notesTagEntity = new NotesTagEntity();
            notesTagEntity.setNormalizeName(str2.toLowerCase());
            notesTagEntity.setDisplayName(str2);
            notesTagEntity.setDocUuid(str);
            arrayList.add(notesTagEntity);
        }
        upsert((Collection) arrayList);
        return true;
    }
}
