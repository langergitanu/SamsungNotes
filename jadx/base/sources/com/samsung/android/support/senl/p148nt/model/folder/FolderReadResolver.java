package com.samsung.android.support.senl.p148nt.model.folder;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class FolderReadResolver {
    private final NotesCategoryTreeRepository mRepository;

    public FolderReadResolver(NotesCategoryTreeRepository notesCategoryTreeRepository) {
        this.mRepository = notesCategoryTreeRepository;
    }

    public List<String> findUuidListByDisplayName(String str, boolean z) {
        return this.mRepository.findUuidListByDisplayName(str, z);
    }

    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z) {
        return this.mRepository.getAllDocumentCategoryTree(z);
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(boolean z) {
        return this.mRepository.getAllDocumentCategoryTree_LiveData(z);
    }

    public List<NotesFolder> getAllNotesFolders(boolean z) {
        return this.mRepository.getAllNotesFolders(z);
    }

    public NotesCategoryTreeEntity getCategoryEntity(String str) {
        return this.mRepository.getEntity(str);
    }

    public int getChildrenCount(@NonNull String str, @NonNull Set<String> set) {
        return this.mRepository.getChildrenCount(str, set);
    }

    @NonNull
    public List<String> getChildrenUuids(@NonNull String str) {
        return this.mRepository.getChildrenUuids(str);
    }

    public List<NotesCategoryTreeEntity> getEntities() {
        return this.mRepository.getEntities();
    }

    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        return this.mRepository.getExpiredRecycleBinDataNotInFolder(j);
    }

    public NotesFolder getNotesFolder(String str, boolean z) {
        return this.mRepository.getNotesFolder(str, z);
    }

    public List<String> getUuidsByDisplayName(String str) {
        return this.mRepository.getUuidsByDisplayName(str);
    }

    public boolean isParentUsed(String str) {
        return this.mRepository.isParentUsed(str);
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(@NonNull Collection<String> collection, boolean z) {
        return this.mRepository.getAllDocumentCategoryTree_LiveData(collection, z);
    }
}
