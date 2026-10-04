package com.samsung.android.support.senl.p148nt.model.folder;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.DuplicateFolderNameChecker;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeRepository;
import com.samsung.android.support.senl.p148nt.data.repository.category.ParentFolderChecker;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FolderManager {
    private static final String TAG = ModelLogger.createTag("FolderManager");
    private static FolderManager sInstance;
    private final DuplicateFolderNameChecker mDuplicateNameChecker;
    private final ParentFolderChecker mParentFolderChecker;
    private final FolderReadResolver mReadResolver;
    private final Map<String, Set<String>> mReservedFolderNames = new HashMap();
    private final FolderWriteResolver mWriteResolver;

    private FolderManager() {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(DataUtils.getContext());
        NotesCategoryTreeRepository notesCategoryTreeRepositoryCreateDocumentCategoryTreeRepository = notesDataRepositoryFactoryNewInstance.createDocumentCategoryTreeRepository();
        NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository = notesDataRepositoryFactoryNewInstance.createCategoryTreeClosureRepository();
        this.mReadResolver = new FolderReadResolver(notesCategoryTreeRepositoryCreateDocumentCategoryTreeRepository);
        this.mWriteResolver = new FolderWriteResolver(notesCategoryTreeRepositoryCreateDocumentCategoryTreeRepository, notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository);
        this.mParentFolderChecker = new ParentFolderChecker(notesCategoryTreeRepositoryCreateDocumentCategoryTreeRepository, notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository);
        this.mDuplicateNameChecker = new DuplicateFolderNameChecker(notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository);
    }

    public static synchronized FolderManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new FolderManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$addReservedFolderName$0(String str) {
        return new HashSet();
    }

    public boolean addReservedFolderName(@NonNull String str) {
        return addReservedFolderName("uncategorized:///", str);
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        this.mWriteResolver.deleteByUuid(collection);
    }

    public void deleteByUuidWithDeleteExpiredFolder(@NonNull Collection<String> collection) {
        this.mWriteResolver.deleteByUuidWithDeleteExpiredFolder(collection);
    }

    public void executeOperation(Runnable runnable) {
        this.mWriteResolver.executeOperation(runnable);
    }

    public String findAndMakeCategory(DocumentCategoryTree documentCategoryTree, String str, int i) {
        return this.mWriteResolver.findAndMakeCategory(documentCategoryTree, str, i);
    }

    public List<String> findUuidListByDisplayName(String str, boolean z) {
        return this.mReadResolver.findUuidListByDisplayName(str, z);
    }

    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z) {
        return this.mReadResolver.getAllDocumentCategoryTree(z);
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(boolean z) {
        return this.mReadResolver.getAllDocumentCategoryTree_LiveData(z);
    }

    public List<NotesFolder> getAllNotesFolders(boolean z) {
        return this.mReadResolver.getAllNotesFolders(z);
    }

    public NotesCategoryTreeEntity getCategoryEntity(String str) {
        return this.mReadResolver.getCategoryEntity(str);
    }

    public int getChildrenCount(@NonNull String str, @NonNull Set<String> set) {
        return this.mReadResolver.getChildrenCount(str, set);
    }

    @NonNull
    public List<String> getChildrenUuids(@NonNull String str) {
        return this.mReadResolver.getChildrenUuids(str);
    }

    public List<NotesCategoryTreeEntity> getEntities() {
        return this.mReadResolver.getEntities();
    }

    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        return this.mReadResolver.getExpiredRecycleBinDataNotInFolder(j);
    }

    public NotesFolder getNotesFolder(String str, boolean z) {
        return this.mReadResolver.getNotesFolder(str, z);
    }

    public ParentFolderChecker getParentFolderChecker() {
        return this.mParentFolderChecker;
    }

    public List<String> getUuidsByDisplayName(String str) {
        return this.mReadResolver.getUuidsByDisplayName(str);
    }

    public FolderWriteResolver getWriteResolver() {
        return this.mWriteResolver;
    }

    public boolean hasDuplicateName(@NonNull String str, @NonNull String str2) {
        boolean z;
        synchronized (this.mReservedFolderNames) {
            try {
                z = isReservedFolderName(str2) || this.mDuplicateNameChecker.hasDuplicateName(str, str2);
            } finally {
            }
        }
        return z;
    }

    public boolean hasReservedFolderName() {
        return hasReservedFolderName("uncategorized:///");
    }

    public void initializeCoverDownloadedCategories(List<Pair<String, String>> list) {
        this.mWriteResolver.initializeCoverDownloadedStickers(list);
    }

    public void initializePredefined(int i) {
        this.mWriteResolver.initializePredefined(i);
    }

    public void insert(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.mWriteResolver.insert(notesCategoryTreeEntity);
    }

    public void insertPredefinedCategory(String str) {
        this.mWriteResolver.insertPredefinedCategory(str);
    }

    public boolean isReservedFolderName(@NonNull String str, @NonNull String str2) {
        int length = str2.length();
        boolean z = false;
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str2.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                synchronized (this.mReservedFolderNames) {
                    try {
                        Set<String> set = this.mReservedFolderNames.get(str);
                        if (set != null && set.contains(str2)) {
                            z = true;
                        }
                        DataLogger.m12302d(TAG, "isReservedFolderName, isReserved: " + z);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return z;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        DataLogger.m12309w(TAG, "isReservedFolderName, blank name");
        return false;
    }

    public boolean move(String str, String str2) {
        return this.mWriteResolver.move(str, str2);
    }

    public boolean moveToRecycleBin(DocumentCategoryTree documentCategoryTree, @NonNull Collection<String> collection) {
        return this.mWriteResolver.moveToRecycleBin(documentCategoryTree, collection);
    }

    public void reorder(String str, Collection<? extends NotesCategoryTreeEntity> collection) {
        this.mWriteResolver.reorder(str, collection);
    }

    public String restore(@NonNull String str) {
        return this.mWriteResolver.restore(str);
    }

    public void runInTransaction(Runnable runnable) {
        this.mWriteResolver.runInTransaction(runnable);
    }

    public void update(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.mWriteResolver.update(notesCategoryTreeEntity);
    }

    public void updateFolderModifiedTime(Collection<String> collection, long j) {
        this.mWriteResolver.updateFolderModifiedTime(collection, j);
    }

    public void updateFolderServerTimestampUpward(Collection<String> collection, long j) {
        this.mWriteResolver.updateFolderServerTimestampUpward(collection, j);
    }

    public boolean addReservedFolderName(@NonNull String str, @NonNull String str2) {
        boolean zAdd;
        synchronized (this.mReservedFolderNames) {
            zAdd = this.mReservedFolderNames.computeIfAbsent(str, new C11419a(2)).add(str2);
        }
        return zAdd;
    }

    public <T> T executeOperation(Callable<T> callable) {
        return (T) this.mWriteResolver.executeOperation(callable);
    }

    public String findAndMakeCategory(String str) {
        return this.mWriteResolver.findAndMakeCategory(str);
    }

    public LiveData<DocumentCategoryTree> getAllDocumentCategoryTree_LiveData(@NonNull Collection<String> collection, boolean z) {
        return this.mReadResolver.getAllDocumentCategoryTree_LiveData(collection, z);
    }

    public boolean hasReservedFolderName(@NonNull String str) {
        boolean z;
        synchronized (this.mReservedFolderNames) {
            try {
                Set<String> set = this.mReservedFolderNames.get(str);
                z = (set == null || set.isEmpty()) ? false : true;
            } finally {
            }
        }
        return z;
    }

    public void insert(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        this.mWriteResolver.insert(collection);
    }

    public boolean move(@NonNull Collection<String> collection, String str) {
        return this.mWriteResolver.move(collection, str);
    }

    public boolean moveToRecycleBin(@NonNull Collection<String> collection) {
        return this.mWriteResolver.moveToRecycleBin(collection);
    }

    public void update(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        this.mWriteResolver.update(collection);
    }

    public boolean isReservedFolderName(@NonNull String str) {
        return isReservedFolderName("uncategorized:///", str);
    }
}
