package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentPageDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentPageRepository {
    private static final String TAG = DataLogger.createTag("NotesDocumentPageRepository");
    private final NotesDocumentPageDao mNotesDocumentPageDao = NotesDatabaseManager.getInstance().getDocumentPageDao();

    public void deleteByDocumentUuid(List<String> list) {
        DataLogger.m12307i(TAG, "deleteByDocumentUuid, documentUuidList : " + list);
        this.mNotesDocumentPageDao.deleteByDocumentUuid(list);
    }

    public void deleteDummy() {
        this.mNotesDocumentPageDao.deleteDummy();
    }

    public List<NotesDocumentPageEntity> getFavoriteList(@NonNull String str) {
        AbstractC0000a.m2C("getFavoriteList, documentUuid: ", str, TAG);
        return this.mNotesDocumentPageDao.getFavoriteList(str);
    }

    public List<String> getPageIDs(@NonNull String str) {
        AbstractC0000a.m2C("getPageIDs, documentUuid: ", str, TAG);
        return this.mNotesDocumentPageDao.getPageIDs(str);
    }

    public void insert(List<NotesDocumentPageEntity> list) {
        DataLogger.m12307i(TAG, "insert, entities: " + list.size());
        this.mNotesDocumentPageDao.upsert((Collection) list);
    }

    public LiveData<List<NotesDocumentPageEntity>> observe(@NonNull String str) {
        AbstractC0000a.m2C("observe, uuid : ", str, TAG);
        return this.mNotesDocumentPageDao.observe(str);
    }

    public void removeDeletedPages(String str) {
        this.mNotesDocumentPageDao.removeDeletedPages(str);
    }

    public void removeInvalidPages(String str, List<String> list) {
        AbstractC0000a.m2C("removeInvalidPages, docUuid: ", str, TAG);
        this.mNotesDocumentPageDao.removeInvalidPages(str, list);
    }

    public void replaceBookmarkList(String str, List<String> list) {
        DataLogger.m12307i(TAG, "replaceBookmarkList, pageUuidList : " + list + ", documentUuid : " + str);
        this.mNotesDocumentPageDao.replaceBookmarkList(str, list);
    }

    public void updateDelete(String str, String str2, int i, int i2) {
        DataLogger.m12307i(TAG, "updateDelete, pageId : " + str2 + ", isDeleted : " + i2);
        this.mNotesDocumentPageDao.updateDelete(str, str2, i, i2);
    }

    public void updateFavorite(String str, String str2, int i, boolean z) {
        String str3 = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("updateFavorite, pageUuid : ", str, ", documentUuid : ", str2, ", index : ");
        sbM16m.append(i);
        sbM16m.append(", isFavorite : ");
        sbM16m.append(z);
        DataLogger.m12307i(str3, sbM16m.toString());
        this.mNotesDocumentPageDao.updateFavorite(str, str2, i, z);
    }
}
