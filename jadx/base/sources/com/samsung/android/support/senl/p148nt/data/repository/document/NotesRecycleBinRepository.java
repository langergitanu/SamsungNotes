package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesRecycleBinRepository {
    private static final String TAG = DataLogger.createTag("NotesRecycleBinRepository");
    private final NotesRecycleBinDocumentDao mNotesRecycleBinDocumentDao = NotesDatabaseManager.getInstance().getRecycleBinDocumentDao();

    public int correctRecycleBinTime(long j, long j2) {
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "correctRecycleBinTime, currentTimestamp : ", ", serverTimestamp : ");
        sbM1323p.append(j2);
        DataLogger.m12307i(str, sbM1323p.toString());
        return this.mNotesRecycleBinDocumentDao.correctRecycleBinTime(j, j2);
    }

    public List<String> getAllFilePathsInRecycleBin() {
        DataLogger.m12307i(TAG, "getAllFilePathsInRecycleBin");
        return this.mNotesRecycleBinDocumentDao.getAllFilePathsInRecycleBin(2);
    }

    public List<NotesDocumentEntity> getAllRecycleBinDataList(boolean z) {
        AbstractC11014a.m12335t("getAllRecycleBinDataList, isDesc : ", TAG, z);
        return this.mNotesRecycleBinDocumentDao.getAll(2, z);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_LiveData(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAll_LiveData, sortParam : " + sortParam);
        return this.mNotesRecycleBinDocumentDao.getAll_LiveData(2, sortParam);
    }

    public List<String> getDocumentsInRecycleBin(Collection<String> collection) {
        NotesRecycleBinDocumentDao notesRecycleBinDocumentDao = this.mNotesRecycleBinDocumentDao;
        Objects.requireNonNull(notesRecycleBinDocumentDao);
        return new SplitTaskExecutor(new C11386c(notesRecycleBinDocumentDao, 1)).execute(collection);
    }

    public List<String> getFoldersInRecycleBin(Collection<String> collection) {
        NotesRecycleBinDocumentDao notesRecycleBinDocumentDao = this.mNotesRecycleBinDocumentDao;
        Objects.requireNonNull(notesRecycleBinDocumentDao);
        return new SplitTaskExecutor(new C11386c(notesRecycleBinDocumentDao, 0)).execute(collection);
    }

    public int getItemCount() {
        DataLogger.m12307i(TAG, "getItemCount");
        return this.mNotesRecycleBinDocumentDao.getItemCount(2);
    }

    public boolean isEmpty() {
        return this.mNotesRecycleBinDocumentDao.isEmpty();
    }

    public List<MainListDocumentData> getAllRecycleBinDataList(SortParam sortParam) {
        DataLogger.m12307i(TAG, "getAllRecycleBinDataList, sortParam : " + sortParam);
        return this.mNotesRecycleBinDocumentDao.getAll(2, sortParam);
    }
}
