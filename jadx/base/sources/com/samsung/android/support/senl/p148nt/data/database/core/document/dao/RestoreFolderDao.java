package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class RestoreFolderDao {
    private static final String TAG = DataLogger.createTag("RestoreFolderDao");

    @Query("UPDATE OR ABORT category_tree SET path = REPLACE(path, :wrongPath, :correctPath) WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :parentUuid) AND path NOT LIKE '%' || :correctPath || '%'")
    public abstract void fixRestorePath(String str, String str2, String str3);

    @Query("SELECT * FROM category_tree WHERE path LIKE '%\u200b' AND isDeleted != 1 AND parentUUID != 'uncategorized:///'")
    public abstract List<NotesCategoryTreeEntity> getInvalidReservedFolders();

    @Transaction
    public void restoreReservedFolder(String str, NotesDocumentDao notesDocumentDao) {
        DataLogger.m12307i(TAG, "#restoreReservedFolder, uuid: " + str);
        long currentTime = TimeManager.getCurrentTime();
        restoreReservedFolderFromTrash(str, currentTime);
        notesDocumentDao.restoreByCategoryUuid(str, currentTime);
    }

    @Query("UPDATE OR ABORT category_tree SET parentUUID='uncategorized:///' , isDeleted=0 , recycle_bin_time_moved=0 , path='' , serverTimestamp=:serverTimestamp , isDirty=1 WHERE UUID=:uuid")
    public abstract void restoreReservedFolderFromTrash(String str, long j);
}
