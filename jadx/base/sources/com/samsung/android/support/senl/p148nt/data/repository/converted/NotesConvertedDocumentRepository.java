package com.samsung.android.support.senl.p148nt.data.repository.converted;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesConvertedDocumentRepository {
    private static final String TAG = DataLogger.createTag("NotesConvertedDocumentRepository");
    private final NotesConvertedDocumentDao mNotesConvertedDocumentDao = NotesDatabaseManager.getInstance().getConvertedDocumentDao();

    public List<MainListDocumentData> getAll_Converted(@DeleteType int i, SortParam sortParam) {
        DataLogger.m12302d(TAG, "getAll_Converted, deleteType : " + i + ", sortParam : " + sortParam);
        return this.mNotesConvertedDocumentDao.getAll_Converted(i, sortParam);
    }

    public int getAll_ConvertedCount(@DeleteType int i) {
        DataLogger.m12302d(TAG, "getAll_ConvertedCount, deleteType : " + i);
        return this.mNotesConvertedDocumentDao.getAll_ConvertedCount(i);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_Converted_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        DataLogger.m12302d(TAG, "getAll_Converted_LiveData, deleteType : " + i + ", sortParam : " + sortParam);
        return this.mNotesConvertedDocumentDao.getAll_Converted_LiveData(i, sortParam);
    }

    public List<String> getOldNotesWithConvertedNotesInUse(@NonNull Collection<String> collection) {
        DataLogger.m12302d(TAG, "getOldNotesWithConvertedNotesInUse: " + collection.size());
        return this.mNotesConvertedDocumentDao.getOldNotesWithConvertedNotesInUse(collection);
    }

    public boolean hasConvertedOldNote(@NonNull Collection<String> collection) {
        DataLogger.m12302d(TAG, "hasConvertedOldNote: " + collection.size());
        return this.mNotesConvertedDocumentDao.hasConvertedOldNote(collection);
    }
}
