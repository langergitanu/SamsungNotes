package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesTemplateDao implements BaseDao<NotesTemplateEntity> {
    public static final String ORDER_BY = " ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC";

    @Query("DELETE FROM document_template WHERE _data=:path")
    public abstract void deleteByPath(String str);

    @Transaction
    public void deleteByPath(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            deleteByPath(it.next());
        }
    }

    @Query("SELECT *  FROM document_template")
    public abstract List<NotesTemplateEntity> getAll();

    @Query("SELECT * FROM document_template ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC")
    public abstract LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z);

    @Query("SELECT * FROM document_template WHERE type=:type ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC")
    public abstract LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z, int i);

    @Query("SELECT *  FROM document_template WHERE UUID=:uuid")
    public abstract NotesTemplateEntity getEntity(String str);

    @Query("UPDATE OR ABORT document_template SET title=:title WHERE UUID=:uuid")
    public abstract void updateTitle(String str, String str2);
}
