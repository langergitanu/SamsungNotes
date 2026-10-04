package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesContentRepository {
    private static final String TAG = DataLogger.createTag("NotesContentRepository");
    private final NotesContentDao mNotesContentDao = NotesDatabaseManager.getInstance().getContentDao();
    private final NotesDocumentDao mDocumentDao = NotesDatabaseManager.getInstance().getDocumentDao();

    public void deleteBySDocUuid(@NonNull Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteBySDocUuid, docUuids : "), TAG);
        this.mNotesContentDao.deleteBySDocUuid(collection);
    }

    public void deleteDummy() {
        DataLogger.m12307i(TAG, "deleteDummy");
        this.mNotesContentDao.deleteDummy();
    }

    public List<NotesContentEntity> getAllDataList() {
        DataLogger.m12307i(TAG, "getAllDataList, getAllDataList");
        return this.mNotesContentDao.getAll();
    }

    public List<ContentFileData> getContentFileDataByQuery(@DataConstants.MIME_TYPE String str, String str2) {
        AbstractC0000a.m2C("getContentFileDataByQuery, type: ", str, TAG);
        return this.mNotesContentDao.getContentFileDataByQuery(str, str2);
    }

    public List<NotesContentEntity> getEntitiesWithNonMatchingVersion(String str, int i) {
        return this.mNotesContentDao.getEntitiesWithNonMatchingVersion(str, i);
    }

    public LiveData<List<ContentFileData>> getLiveContentFileDataByMimeType(@DataConstants.MIME_TYPE String str) {
        AbstractC0000a.m2C("getContentFileDataByMimeType, type: ", str, TAG);
        return this.mNotesContentDao.getLiveContentFileDataByMimeType(str);
    }

    public byte[] getStrippedContent(@NonNull String str) {
        return this.mDocumentDao.getStrippedContent(str);
    }

    public void insert(@NonNull NotesContentEntity notesContentEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesContentEntity);
        this.mNotesContentDao.upsert(notesContentEntity);
    }

    public void update(List<NotesContentEntity> list) {
        this.mNotesContentDao.update((Collection<NotesContentEntity>) list);
    }

    public void updateIsDeleted(@NonNull String str, int i) {
        DataLogger.m12307i(TAG, "updateIsDeleted");
        this.mNotesContentDao.updateIsDeleted(str, i);
    }

    public void updateIsDirtyAndIsDeleted(@NonNull String str, int i, int i2) {
        DataLogger.m12307i(TAG, "updateIsDirtyAndIsDeleted");
        this.mNotesContentDao.updateIsDirtyAndIsDeleted(str, i, i2);
    }

    public void updateStrippedContent(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.mDocumentDao.updateStrippedContents(str, str2, DisplayDataConverter.trimMaxIndexContentString(str3).trim());
    }

    public void insert(@NonNull Collection<? extends NotesContentEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities : "), TAG);
        this.mNotesContentDao.upsert((Collection) collection);
    }

    public void deleteBySDocUuid(@NonNull String str, Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteBySDocUuid, sdocUuid: " + str + ", excludedTypes: " + collection);
        this.mNotesContentDao.deleteBySDocUuid(str, collection);
    }
}
