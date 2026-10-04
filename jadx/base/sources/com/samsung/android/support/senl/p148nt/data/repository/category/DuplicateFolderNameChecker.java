package com.samsung.android.support.senl.p148nt.data.repository.category;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DuplicateFolderNameChecker {
    private final NotesCategoryTreeClosureRepository mFolderTreeRepository;

    public DuplicateFolderNameChecker(NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepository) {
        this.mFolderTreeRepository = notesCategoryTreeClosureRepository;
    }

    public boolean hasDuplicateName(@NonNull String str, @NonNull String str2) {
        return this.mFolderTreeRepository.hasDuplicateName(str, str2);
    }
}
