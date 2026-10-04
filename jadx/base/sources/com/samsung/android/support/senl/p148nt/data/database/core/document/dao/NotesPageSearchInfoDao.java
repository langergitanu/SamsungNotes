package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesPageSearchInfoDao implements BaseDao<NotesPageSearchInfoEntity> {
    @Delete
    public abstract int delete(Collection<? extends NotesPageSearchInfoEntity> collection);

    @Query("DELETE FROM page_search_info WHERE sdocUUID IN (:documentIds)")
    public abstract void deleteByUuid(List<String> list);

    @Query("DELETE FROM page_search_info WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("SELECT * FROM page_search_info WHERE sdocUUID=:documentId")
    public abstract List<NotesPageSearchInfoEntity> getEntities(String str);

    @Query("SELECT * FROM page_search_info WHERE sdocUUID=:documentId AND pageUuid=:pageId")
    public abstract NotesPageSearchInfoEntity getEntity(String str, String str2);
}
