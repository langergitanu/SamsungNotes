package com.samsung.android.support.senl.p148nt.data.repository.tag;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.TagSortType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesTagDocCountEntry;
import com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesTagRepository extends NotesDataRepository<NotesTagEntity> {
    private static final String TAG = DataLogger.createTag("NotesTagRepository");
    private final NotesTagDao mNotesTagDao;

    public NotesTagRepository(@NonNull Context context) {
        super(context);
        this.mNotesTagDao = NotesDatabaseManager.getInstance().getTagDao();
    }

    private boolean isTagsExistByDocUuid(String str) {
        return this.mNotesTagDao.isTagsExistByDocUuid(str);
    }

    public boolean addTagsByDocUuid(@NonNull List<String> list, String str) {
        DataLogger.m12307i(TAG, "updateTagsByDocUuid");
        boolean zAddTagsByDocUuid = this.mNotesTagDao.addTagsByDocUuid(list, str);
        notifyTagBoard();
        DataToSyncManager.getInstance().onTagUpdated(Collections.singletonList(str));
        return zAddTagsByDocUuid;
    }

    public boolean addTagsByDocUuidList(@NonNull List<List<String>> list, List<String> list2) {
        DataLogger.m12307i(TAG, "updateTagsByDocUuid");
        boolean zAddTagsByDocUuidList = this.mNotesTagDao.addTagsByDocUuidList(list, list2);
        DataToSyncManager.getInstance().onTagUpdated(list2);
        notifyTagBoard();
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        return zAddTagsByDocUuidList;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, uuid : ", str, TAG);
        this.mNotesTagDao.deleteByUuid(str);
        notifyTagBoard();
    }

    public void deleteDummy() {
        this.mNotesTagDao.deleteDummy();
    }

    public List<NotesTagEntity> getAll() {
        DataLogger.m12307i(TAG, "getAll");
        return this.mNotesTagDao.getAll();
    }

    public List<NotesTagDocCountEntry> getAllTagListWithDocCount(@TagSortType int i) {
        DataLogger.m12307i(TAG, "getAllTagListWithDocCount");
        return this.mNotesTagDao.getAllTagListWithDocCount(i);
    }

    public LiveData<List<NotesTagDocCountEntry>> getAllTagListWithDocCount_LiveData(@TagSortType int i) {
        DataLogger.m12307i(TAG, "getAllTagListWithDocCount_LiveData");
        return this.mNotesTagDao.getAllTagListWithDocCount_LiveDataFiltered(i);
    }

    public List<String> getAllTagsInUse() {
        DataLogger.m12302d(TAG, "getAllTagsInUse");
        return this.mNotesTagDao.getAllTagsInUse();
    }

    public Cursor getDataForTagBoard(String str, String[] strArr, String str2) {
        DataLogger.m12307i(TAG, "getDataForTagBoard");
        return this.mNotesTagDao.getDataForTagBoard(str, strArr, str2);
    }

    public int getNotesCountUsingTag() {
        return this.mNotesTagDao.getNotesCountUsingTag();
    }

    public List<NotesTagEntity> getRecentTagList(int i) {
        DataLogger.m12307i(TAG, "getRecentTagList");
        return this.mNotesTagDao.getRecentTagList(i);
    }

    public List<NotesTagEntity> getRelatedTagList(@NonNull String str) {
        DataLogger.m12302d(TAG, "getRelatedTagList");
        return this.mNotesTagDao.getRelatedTagList(str.toLowerCase());
    }

    public List<String> getRelatedTags(@NonNull Set<String> set) {
        DataLogger.m12302d(TAG, "getRelatedTags");
        return this.mNotesTagDao.getRelatedTags(set, set.size());
    }

    public List<NotesTagEntity> getTagListByDocUuid(@NonNull String str) {
        AbstractC0000a.m2C("getTagListByDocUuid, docUuid : ", str, TAG);
        return this.mNotesTagDao.getTagListByDocUuid(str);
    }

    public boolean isTagExistByNormalizedName(@NonNull String str) {
        DataLogger.m12307i(TAG, "isTagExistByNormalizedName");
        return this.mNotesTagDao.isTagExistByNormalizedName(str.toLowerCase());
    }

    public void notifyTagBoard() {
        try {
            if (DeviceUtils.isPowerManageMode(getContext())) {
                return;
            }
            getContext().getContentResolver().notifyChange(ExternalDataConstants.BASE_URI_NOTE_TAG, (ContentObserver) null, false);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("notifyTagBoard, e : "), TAG);
        }
    }

    public void notifyTagBoardByUuid(String str) {
        try {
            if (!isTagsExistByDocUuid(str) || DeviceUtils.isPowerManageMode(getContext())) {
                return;
            }
            getContext().getContentResolver().notifyChange(ExternalDataConstants.BASE_URI_NOTE_TAG, (ContentObserver) null, false);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("notifyTagBoardByUuid, e : "), TAG);
        }
    }

    public boolean updateTagsByDocUuid(@NonNull Set<String> set, @NonNull Set<String> set2, String str, boolean z) {
        DataLogger.m12307i(TAG, "updateTagsByDocUuid");
        if (set.equals(set2)) {
            return false;
        }
        boolean zUpdateTagsByDocUuid = this.mNotesTagDao.updateTagsByDocUuid(set2, str);
        notifyTagBoard();
        if (!z) {
            DataToSyncManager.getInstance().onTagUpdated(Collections.singletonList(str));
        }
        return zUpdateTagsByDocUuid;
    }

    private boolean isTagsExistByDocUuid(List<String> list) {
        return this.mNotesTagDao.isTagsExistByDocUuid(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void insert(@NonNull NotesTagEntity notesTagEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesTagEntity);
        this.mNotesTagDao.upsert(notesTagEntity);
        notifyTagBoard();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.NotesDataRepository
    public void update(@NonNull NotesTagEntity notesTagEntity) {
        DataLogger.m12307i(TAG, "update, entity : " + notesTagEntity);
        this.mNotesTagDao.update(notesTagEntity);
        notifyTagBoard();
    }

    public void insert(@NonNull Collection<NotesTagEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities : "), TAG);
        this.mNotesTagDao.upsert((Collection) collection);
        notifyTagBoard();
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteByUuid, uuidList : " + collection);
        this.mNotesTagDao.deleteByUuid(collection);
        notifyTagBoard();
    }

    public void notifyTagBoardByUuid(List<String> list) {
        try {
            if (list.isEmpty() || !isTagsExistByDocUuid(list) || DeviceUtils.isPowerManageMode(getContext())) {
                return;
            }
            getContext().getContentResolver().notifyChange(ExternalDataConstants.BASE_URI_NOTE_TAG, (ContentObserver) null, false);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("notifyTagBoardByUuid, e : "), TAG);
        }
    }
}
