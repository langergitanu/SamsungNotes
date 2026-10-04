package com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity.DeletedNoteEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class DeletedNoteDao implements BaseDao<DeletedNoteEntity> {
    @Query("DELETE FROM deleted_notes WHERE filePath = :filePath")
    public abstract void delete(String str);

    @Query("DELETE FROM deleted_notes WHERE filePath = :filePath")
    public abstract void deleteInChunk(String str);

    @Query("SELECT * FROM deleted_notes")
    public abstract List<DeletedNoteEntity> getEntities();
}
