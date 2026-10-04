package com.samsung.android.support.senl.p148nt.data.repository.restore;

import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesRestoreRepository {
    private static final String TAG = DataLogger.createTag("NotesRestoreRepository");
    private final NotesRestoreDao mNotesRestoreDao = NotesDatabaseManager.getInstance().getRestoreDao();

    public List<NotesDocumentEntity> getCorruptNotes() {
        return this.mNotesRestoreDao.getCorruptNotes();
    }

    public List<NotesDocumentEntity> getSdocXInOldFolder() {
        return this.mNotesRestoreDao.getSdocXInOldFolder();
    }

    public void repairUncategorizedFolder() {
        DataLogger.m12307i(TAG, "repairUncategorizedFolder");
        this.mNotesRestoreDao.repairUncategorizedFolder();
    }

    public void restoreDisplayContent(int i) {
        DataLogger.m12307i(TAG, "restoreDisplayContent");
        this.mNotesRestoreDao.restoreDisplayContent(new byte[0], i);
    }

    public void update(NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12307i(TAG, "update, entity : " + notesDocumentEntity);
        this.mNotesRestoreDao.update(notesDocumentEntity);
    }

    public void update(List<NotesDocumentEntity> list) {
        DataLogger.m12307i(TAG, "update, entities : " + list.size());
        this.mNotesRestoreDao.update(list);
    }
}
