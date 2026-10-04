package com.samsung.android.support.senl.p148nt.model.domain.folder;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeleteFolderUseCase {
    private final NotesCategoryTreeClosureRepository mClosureRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private final Set<String> mDeletedFolders;

        public Result(Set<String> set) {
            HashSet hashSet = new HashSet();
            this.mDeletedFolders = hashSet;
            hashSet.addAll(set);
        }

        @NonNull
        public Set<String> getDeletedFolders() {
            return this.mDeletedFolders;
        }

        public boolean isSucceed() {
            return !this.mDeletedFolders.isEmpty();
        }
    }

    public DeleteFolderUseCase(NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepository) {
        this.mClosureRepository = notesCategoryTreeClosureRepository;
    }

    private Set<String> getDeletableFoldersUuids(Collection<String> collection) {
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet(hashSet);
        HashSet hashSet3 = new HashSet();
        Iterator<String> it = getFoldersOpenedByComposer().iterator();
        while (it.hasNext()) {
            hashSet3.addAll(this.mClosureRepository.getFoldersWithRelationShip(hashSet, it.next()));
        }
        hashSet2.removeAll(PredefinedCategory.RESTRICTED_FOLDERS);
        hashSet2.removeAll(hashSet3);
        return hashSet2;
    }

    private Set<String> getFoldersOpenedByComposer() {
        return ComposerManager.getInstance().getFolderIdsInUse();
    }

    public Result execute(@NonNull Collection<String> collection) {
        Set<String> deletableFoldersUuids = getDeletableFoldersUuids(collection);
        if (!deletableFoldersUuids.isEmpty()) {
            FolderManager.getInstance().moveToRecycleBin(deletableFoldersUuids);
        }
        return new Result(deletableFoldersUuids);
    }
}
