package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesCategoryTreeClosureDao {
    @Transaction
    public InvalidParentFolderException.Info checkRelationShip(String str, String str2) {
        if (hasRelationShip(str, str2)) {
            return new InvalidParentFolderException.Info(str, str2, 100);
        }
        if (isDepthBiggerThanLimit(str, str2)) {
            return new InvalidParentFolderException.Info(str, str2, 101);
        }
        return null;
    }

    @Nullable
    @Transaction
    public InvalidParentFolderException.Info checkRelationShipByUuids(Collection<String> collection, String str) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            InvalidParentFolderException.Info infoCheckRelationShip = checkRelationShip(it.next(), str);
            if (infoCheckRelationShip != null) {
                return infoCheckRelationShip;
            }
        }
        return null;
    }

    @Query("DELETE FROM category_tree_closure WHERE descendant NOT IN (SELECT UUID FROM category_tree WHERE isDeleted != 1)")
    public abstract void deleteDummy();

    @Query("SELECT 1 FROM category_tree_closure WHERE descendant = :uuid")
    public abstract boolean exists(String str);

    @Query("SELECT * FROM category_tree_closure WHERE descendant = :descendantUuid")
    public abstract List<NotesCategoryTreeClosureEntity> getEntities(String str);

    @Transaction
    public Collection<String> getFoldersWithRelationShip(Collection<String> collection, String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : collection) {
            if (hasRelationShip(str2, str)) {
                hashSet.add(str2);
            }
        }
        return hashSet;
    }

    @Query("SELECT MAX(depth) FROM category_tree_closure WHERE ancestor = :folderUuid")
    public abstract int getMaxChildDepth(String str);

    @Query("SELECT MAX(depth) FROM category_tree_closure WHERE descendant = :folderUuid")
    public abstract int getMaxDepth(String str);

    @Query("SELECT 1 FROM category_tree WHERE category_tree.isDeleted = 0 AND category_tree.UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = :parentUuid AND depth = 1) AND category_tree.displayName = :folderName")
    public abstract boolean hasDuplicateName(String str, String str2);

    @Query("SELECT 1 FROM category_tree_closure WHERE ancestor = :ancestorUuid AND descendant = :descendantUuid")
    public abstract boolean hasRelationShip(String str, String str2);

    @Transaction
    public boolean isDepthBiggerThanLimit(String str, String str2) {
        return getMaxDepth(str2) + Math.max((getMaxChildDepth(str) - getMaxDepth(str)) + 1, 1) > 50;
    }

    @Nullable
    @Transaction
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection) {
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : collection) {
            InvalidParentFolderException.Info infoCheckRelationShip = checkRelationShip(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid());
            if (infoCheckRelationShip != null) {
                return infoCheckRelationShip;
            }
        }
        return null;
    }

    @Nullable
    @Transaction
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection, String str) {
        Iterator<? extends NotesCategoryTreeEntity> it = collection.iterator();
        while (it.hasNext()) {
            InvalidParentFolderException.Info infoCheckRelationShip = checkRelationShip(it.next().getUuid(), str);
            if (infoCheckRelationShip != null) {
                return infoCheckRelationShip;
            }
        }
        return null;
    }
}
