package com.samsung.android.support.senl.p148nt.data.repository.category;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesCategoryTreeClosureRepository {
    private static final String TAG = DataLogger.createTag("NotesCategoryTreeClosureRepository");
    private final NotesCategoryTreeClosureDao mCategoryTreeClosureDao = NotesDatabaseManager.getInstance().getCategoryTreeClosureDao();

    @Nullable
    public InvalidParentFolderException.Info checkRelationShip(String str, String str2) {
        return this.mCategoryTreeClosureDao.checkRelationShip(str, str2);
    }

    @Nullable
    public InvalidParentFolderException.Info checkRelationShipByUuids(Collection<String> collection, String str) {
        return this.mCategoryTreeClosureDao.checkRelationShipByUuids(collection, str);
    }

    public void deleteDummy() {
        this.mCategoryTreeClosureDao.deleteDummy();
    }

    public boolean exists(@NonNull String str) {
        AbstractC0000a.m2C("exists: ", str, TAG);
        return this.mCategoryTreeClosureDao.exists(str);
    }

    public List<NotesCategoryTreeClosureEntity> getEntities(String str) {
        return this.mCategoryTreeClosureDao.getEntities(str);
    }

    @NonNull
    public Collection<String> getFoldersWithRelationShip(Collection<String> collection, String str) {
        Collection<String> foldersWithRelationShip = this.mCategoryTreeClosureDao.getFoldersWithRelationShip(collection, str);
        DataLogger.m12302d(TAG, "getFoldersWithRelationShip, input/output: " + collection.size() + "/" + foldersWithRelationShip.size());
        return foldersWithRelationShip;
    }

    public boolean hasDuplicateName(@NonNull String str, @NonNull String str2) {
        DataLogger.m12307i(TAG, "hasDuplicateName: " + DataLogger.getEncode(str2));
        return this.mCategoryTreeClosureDao.hasDuplicateName(str, str2);
    }

    public boolean hasRelationShip(String str, String str2) {
        return this.mCategoryTreeClosureDao.hasRelationShip(str, str2);
    }

    @Nullable
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection) {
        return this.mCategoryTreeClosureDao.checkRelationShip(collection);
    }

    @Nullable
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection, String str) {
        return this.mCategoryTreeClosureDao.checkRelationShip(collection, str);
    }
}
