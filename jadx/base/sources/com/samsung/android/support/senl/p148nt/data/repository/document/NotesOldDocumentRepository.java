package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesOldDocumentRepository {
    private static final String TAG = DataLogger.createTag("NotesOldDocumentRepository");
    private final NotesOldDocumentDao mNotesOldDocumentDao = NotesDatabaseManager.getInstance().getOldDocumentDao();

    public List<MainListDocumentData> getAll_OldNotes(@DeleteType int i, SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_OldNotes, deleteType : " + i + ", sortParam : " + sortParam);
        return this.mNotesOldDocumentDao.getAll_OldNotes(i, sortParam);
    }

    public int getAll_OldNotesCount(@DeleteType int i) {
        DataLogger.m12307i(TAG, "getAll_OldNotesCount, deleteType : " + i);
        return this.mNotesOldDocumentDao.getAll_OldNotes_Count(i);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_OldNotes_LiveData(@DeleteType int i, SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_OldNotes_LiveData, sortParam : " + sortParam);
        return this.mNotesOldDocumentDao.getAll_OldNotes_LiveData(i, sortParam);
    }

    public boolean hasOldNoteInUse() {
        DataLogger.m12307i(TAG, "hasOldNoteInUse");
        return this.mNotesOldDocumentDao.hasOldNoteInUse();
    }

    public boolean includeOldNotes(@NonNull List<String> list) {
        DataLogger.m12307i(TAG, "includeOldNotes");
        return this.mNotesOldDocumentDao.includeOldNotes(list);
    }
}
