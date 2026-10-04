package com.samsung.android.support.senl.p148nt.data.repository.category;

import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ParentFolderChecker {
    private final NotesCategoryTreeClosureRepository mCategoryTreeClosureRepository;
    private final NotesCategoryTreeRepository mCategoryTreeRepository;

    public ParentFolderChecker(NotesCategoryTreeRepository notesCategoryTreeRepository, NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepository) {
        this.mCategoryTreeRepository = notesCategoryTreeRepository;
        this.mCategoryTreeClosureRepository = notesCategoryTreeClosureRepository;
    }

    public boolean isInvalidRelationShip(String str, String str2) throws InvalidParentFolderException {
        InvalidParentFolderException.Info infoCheckRelationShip = this.mCategoryTreeClosureRepository.checkRelationShip(str, str2);
        if (infoCheckRelationShip == null) {
            return false;
        }
        throw new InvalidParentFolderException(infoCheckRelationShip);
    }

    public boolean isUsed(String str) throws InvalidParentFolderException {
        if (this.mCategoryTreeRepository.isUsed(str)) {
            return true;
        }
        throw new InvalidParentFolderException(new InvalidParentFolderException.Info("", str, 102));
    }

    public boolean isInvalidRelationShip(Collection<? extends NotesCategoryTreeEntity> collection) throws InvalidParentFolderException {
        InvalidParentFolderException.Info infoCheckRelationShip = this.mCategoryTreeClosureRepository.checkRelationShip(collection);
        if (infoCheckRelationShip == null) {
            return false;
        }
        throw new InvalidParentFolderException(infoCheckRelationShip);
    }

    public boolean isInvalidRelationShip(Collection<? extends NotesCategoryTreeEntity> collection, String str) throws InvalidParentFolderException {
        InvalidParentFolderException.Info infoCheckRelationShip = this.mCategoryTreeClosureRepository.checkRelationShip(collection, str);
        if (infoCheckRelationShip == null) {
            return false;
        }
        throw new InvalidParentFolderException(infoCheckRelationShip);
    }

    public boolean isInvalidRelationShip(String str, Collection<String> collection) throws InvalidParentFolderException {
        InvalidParentFolderException.Info infoCheckRelationShipByUuids = this.mCategoryTreeClosureRepository.checkRelationShipByUuids(collection, str);
        if (infoCheckRelationShipByUuids == null) {
            return false;
        }
        throw new InvalidParentFolderException(infoCheckRelationShipByUuids);
    }
}
