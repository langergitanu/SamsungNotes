package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesDocumentPageDao implements BaseDao<NotesDocumentPageEntity> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByDocumentUuid$0(List list) {
        deleteAll((List<String>) list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$removeInvalidPages$2(String str, List list) {
        removePages(str, list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$replaceBookmarkList$1(String str, List list) {
        updateFavoritesWithExcludedPages(str, list, 0);
        updateFavorites(str, list, 1);
        return new ArrayList();
    }

    @Query("DELETE FROM document_page WHERE documentUUID=:documentUuid")
    public abstract void deleteAll(String str);

    @Query("DELETE FROM document_page WHERE documentUUID IN (:documentUuids)")
    public abstract void deleteAll(List<String> list);

    @Transaction
    public void deleteByDocumentUuid(Collection<String> collection) {
        new SplitTaskExecutor(new C8886c(this, 26)).execute(collection);
    }

    @Query("DELETE FROM document_page WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("SELECT * FROM document_page WHERE UUID=:pageUuid AND documentUUID=:docUuid")
    public abstract NotesDocumentPageEntity getEntity(String str, String str2);

    @Query("SELECT * FROM document_page WHERE documentUUID=:documentUuid AND favorite=1 AND isDeleted != 1")
    public abstract List<NotesDocumentPageEntity> getFavoriteList(String str);

    @Query("SELECT UUID FROM document_page WHERE documentUUID=:documentUuid AND favorite=1 AND isDeleted != 1")
    public abstract List<String> getFavoritePageUuids(String str);

    @Query("SELECT UUID FROM document_page WHERE documentUUID=:documentUuid")
    public abstract List<String> getPageIDs(String str);

    @Query("SELECT * FROM document_page WHERE documentUUID=:documentUuid")
    public abstract LiveData<List<NotesDocumentPageEntity>> observe(String str);

    @Query("DELETE FROM document_page WHERE documentUUID=:docUuid AND isDeleted = 1")
    public abstract void removeDeletedPages(String str);

    @Transaction
    public void removeInvalidPages(String str, List<String> list) {
        new SplitTaskExecutor(new C11249f(this, str, 1)).execute(list);
    }

    @Query("DELETE FROM document_page WHERE documentUUID=:docUuid AND UUID IN (:pageIds)")
    public abstract void removePages(String str, Collection<String> collection);

    @Transaction
    public void replaceBookmarkList(String str, List<String> list) {
        new SplitTaskExecutor(new C11249f(this, str, 0)).execute(list);
        List<String> favoritePageUuids = getFavoritePageUuids(str);
        ArrayList<String> arrayList = new ArrayList(list);
        arrayList.removeAll(favoritePageUuids);
        for (String str2 : arrayList) {
            NotesDocumentPageEntity notesDocumentPageEntity = new NotesDocumentPageEntity();
            notesDocumentPageEntity.setPageUuid(str2);
            notesDocumentPageEntity.setDocumentUuid(str);
            notesDocumentPageEntity.setFavorite(1);
            insert(notesDocumentPageEntity);
        }
    }

    @Transaction
    public void updateDelete(String str, String str2, int i, int i2) {
        NotesDocumentPageEntity entity = getEntity(str, str2);
        if (entity == null) {
            entity = new NotesDocumentPageEntity();
            entity.setPageUuid(str2);
            entity.setDocumentUuid(str);
        }
        entity.setIndex(i);
        entity.setIsDeleted(i2);
        upsert(entity);
    }

    @Query("UPDATE OR ABORT document_page SET isDirty=:dirty WHERE documentUUID=:documentUuid")
    public abstract void updateDirtyByDocumentUuid(String str, int i);

    @Transaction
    public void updateDirtyByDocumentUuid(Collection<String> collection, int i) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            updateDirtyByDocumentUuid(it.next(), i);
        }
    }

    @Transaction
    public void updateFavorite(String str, String str2, int i, boolean z) {
        NotesDocumentPageEntity entity = getEntity(str2, str);
        if (entity == null) {
            entity = new NotesDocumentPageEntity();
            entity.setPageUuid(str);
            entity.setDocumentUuid(str2);
        }
        entity.setIndex(i);
        entity.setFavorite(z ? 1 : 0);
        upsert(entity);
    }

    @Query("UPDATE OR ABORT document_page SET favorite=:isFavorite WHERE documentUUID=:documentUuid AND UUID IN (:pages)")
    public abstract void updateFavorites(String str, List<String> list, int i);

    @Query("UPDATE OR ABORT document_page SET favorite=:isFavorite WHERE documentUUID=:documentUuid AND UUID NOT IN (:excludedPages)")
    public abstract void updateFavoritesWithExcludedPages(String str, List<String> list, int i);
}
