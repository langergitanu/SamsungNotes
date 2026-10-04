package com.samsung.android.support.senl.p148nt.model.folder;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCoverSticker;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeRepository;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.cover.CoverStickerRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.CoverTemplateRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FolderWriteResolver {
    private static final String TAG = ModelLogger.createTag("FolderWriteResolver");
    private static Context mAppContext;
    private final NotesCategoryTreeRepository mRepository;
    private final NotesCategoryTreeClosureRepository mTreeRepository;

    public FolderWriteResolver(@NonNull NotesCategoryTreeRepository notesCategoryTreeRepository, @NonNull NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepository) {
        this.mRepository = notesCategoryTreeRepository;
        this.mTreeRepository = notesCategoryTreeClosureRepository;
        mAppContext = DataUtils.getContext();
    }

    private synchronized void callInitializePredefined(int i) {
        createDefaultFolders(i);
        createScreenOffMemoFolder(i);
        createMathFolder(i);
        createOldNoteFolders(i);
    }

    private void createDefaultFolders(int i) {
        if (isTargetType(i, 1)) {
            for (PredefinedCategory predefinedCategory : PredefinedCategory.DEFAULT_PREDEFINED_CATEGORY_ARRAY) {
                NotesCategoryTreeEntity entity = this.mRepository.getEntity(predefinedCategory.getUuid());
                if (entity == null || entity.getIsDeleted() == 1) {
                    try {
                        this.mRepository.insert(new NotesCategoryTreeEntity(predefinedCategory.getUuid(), (String) null, predefinedCategory.getDisplayName(), predefinedCategory.getPath(), 0));
                    } catch (InvalidParentFolderException e) {
                        DataLogger.m12303e(TAG, "createDefaultFolders, e : " + e.getMessage());
                    }
                }
            }
        }
    }

    private void createMathFolder(int i) {
        if (isTargetType(i, 8)) {
            try {
                NotesCategoryTreeEntity entity = this.mRepository.getEntity(PredefinedCategory.MATH_NOTES.getUuid());
                if (entity != null && entity.getIsDeleted() != 1 && this.mTreeRepository.exists(entity.getUuid())) {
                    if (entity.getIsDeleted() != 0 || "Math notes\u200b".equals(entity.getRestorePath())) {
                        return;
                    }
                    entity.setRestorePath("Math notes\u200b");
                    this.mRepository.update(entity);
                    return;
                }
                this.mRepository.deleteFromTable(CategoryConstants.Math.UUID);
                this.mRepository.insert(new NotesCategoryTreeEntity(CategoryConstants.Math.UUID, PredefinedCategory.UNCATEGORIZED.getUuid(), "Math notes\u200b", "Math notes\u200b", 1));
            } catch (InvalidParentFolderException e) {
                DataLogger.m12303e(TAG, "createMathFolder, e : " + e.getMessage());
            }
        }
    }

    private void createOldNoteFolders(int i) {
        if (isTargetType(i, 2)) {
            try {
                for (String[] strArr : PredefinedCategory.DEFAULT_OLD_NOTES_PREDEFINED_CATEGORY) {
                    NotesCategoryTreeEntity entity = this.mRepository.getEntity(strArr[0]);
                    if (entity == null || entity.getIsDeleted() == 1) {
                        this.mRepository.insert(new NotesCategoryTreeEntity(strArr[0], PredefinedCategory.OLD_NOTES.getUuid(), strArr[1], (String) null, Integer.valueOf(strArr[2]), 0));
                    }
                }
            } catch (InvalidParentFolderException e) {
                DataLogger.m12303e(TAG, "createOldNoteFolders, e : " + e.getMessage());
            }
        }
    }

    private void createScreenOffMemoFolder(int i) {
        if (isTargetType(i, 4)) {
            try {
                NotesCategoryTreeEntity entity = this.mRepository.getEntity(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
                if (entity != null && entity.getIsDeleted() != 1 && this.mTreeRepository.exists(entity.getUuid())) {
                    boolean zEquals = "Screen off memo\u200b".equals(entity.getDisplayName());
                    boolean zEquals2 = "Screen off memo\u200b".equals(entity.getRestorePath());
                    if (!zEquals) {
                        entity.setDisplayName("Screen off memo\u200b");
                    }
                    if (!zEquals2) {
                        entity.setRestorePath("Screen off memo\u200b");
                    }
                    if (zEquals && zEquals2) {
                        return;
                    }
                    this.mRepository.update(entity);
                    return;
                }
                this.mRepository.deleteFromTable(CategoryConstants.ScreenOffMemo.UUID);
                this.mRepository.insert(new NotesCategoryTreeEntity(CategoryConstants.ScreenOffMemo.UUID, PredefinedCategory.UNCATEGORIZED.getUuid(), "Screen off memo\u200b", "Screen off memo\u200b", 1));
            } catch (InvalidParentFolderException e) {
                DataLogger.m12303e(TAG, "createScreenOffMemoFolder, e : " + e.getMessage());
            }
        }
    }

    private void initializeCoverStickers() {
        CoverStickerRepository coverStickerRepositoryCreateCoverStickerRepository = NotesDataRepositoryFactory.newInstance(mAppContext).createCoverStickerRepository();
        List<String> predefinedUuids = coverStickerRepositoryCreateCoverStickerRepository.getPredefinedUuids();
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (PredefinedCoverSticker predefinedCoverSticker : PredefinedCoverSticker.DEFAULT_STICKERS) {
            if (!predefinedUuids.contains(predefinedCoverSticker.getUuid())) {
                CoverStickerEntity coverStickerEntity = new CoverStickerEntity();
                coverStickerEntity.setUuid(predefinedCoverSticker.getUuid());
                coverStickerEntity.setName(predefinedCoverSticker.getName());
                coverStickerEntity.setCreatedAt(jCurrentTimeMillis);
                coverStickerEntity.setLastModifiedAt(jCurrentTimeMillis);
                arrayList.add(coverStickerEntity);
            }
        }
        coverStickerRepositoryCreateCoverStickerRepository.insert(arrayList);
    }

    private void initializeCoverTemplates() {
        CoverTemplateRepository coverTemplateRepositoryCreateCoverTemplateRepository = NotesDataRepositoryFactory.newInstance(mAppContext).createCoverTemplateRepository();
        List<String> predefinedCoverTemplates = CoverConstants.getPredefinedCoverTemplates();
        predefinedCoverTemplates.removeAll(coverTemplateRepositoryCreateCoverTemplateRepository.getPredefinedUuids());
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (String str : predefinedCoverTemplates) {
            CoverTemplateEntity coverTemplateEntity = new CoverTemplateEntity();
            coverTemplateEntity.setUuid(str);
            coverTemplateEntity.setType(1);
            coverTemplateEntity.setCreatedAt(jCurrentTimeMillis);
            coverTemplateEntity.setLastModifiedAt(jCurrentTimeMillis);
            arrayList.add(coverTemplateEntity);
        }
        coverTemplateRepositoryCreateCoverTemplateRepository.insert(arrayList);
    }

    private void initializePredefinedCoverData(int i) {
        if (isTargetType(i, 16)) {
            initializeCoverStickers();
            initializeCoverTemplates();
        }
    }

    private boolean isTargetType(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePredefined$0(int i) {
        initializePredefinedCoverData(i);
        callInitializePredefined(i);
    }

    public synchronized void deleteByUuid(@NonNull Collection<String> collection) {
        this.mRepository.deleteByUuid(collection);
    }

    public synchronized void deleteByUuidWithDeleteExpiredFolder(@NonNull Collection<String> collection) {
        this.mRepository.deleteByUuidWithDeleteExpiredFolder(collection);
    }

    public synchronized void executeOperation(Runnable runnable) {
        runnable.run();
    }

    public synchronized String findAndMakeCategory(DocumentCategoryTree documentCategoryTree, String str, int i) {
        return this.mRepository.findAndMakeCategory(documentCategoryTree, str, i);
    }

    public synchronized void initializeCoverDownloadedStickers(List<Pair<String, String>> list) {
        try {
            CoverStickerRepository coverStickerRepositoryCreateCoverStickerRepository = NotesDataRepositoryFactory.newInstance(mAppContext).createCoverStickerRepository();
            List<String> predefinedUuids = coverStickerRepositoryCreateCoverStickerRepository.getPredefinedUuids();
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (Pair<String, String> pair : list) {
                if (!predefinedUuids.contains(pair.first)) {
                    CoverStickerEntity coverStickerEntity = new CoverStickerEntity();
                    coverStickerEntity.setUuid((String) pair.first);
                    coverStickerEntity.setName((String) pair.second);
                    coverStickerEntity.setCreatedAt(jCurrentTimeMillis);
                    coverStickerEntity.setLastModifiedAt(jCurrentTimeMillis);
                    arrayList.add(coverStickerEntity);
                }
            }
            coverStickerRepositoryCreateCoverStickerRepository.insert(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void initializePredefined(int i) {
        DataRepositoryScheduler.runnable(new RunnableC0050f(this, i, 24)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    public synchronized void insert(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.mRepository.insert(notesCategoryTreeEntity);
    }

    public synchronized void insertPredefinedCategory(String str) {
        PredefinedCategory predefinedCategoryFind = PredefinedCategory.find(str);
        if (predefinedCategoryFind != null && this.mRepository.getEntity(predefinedCategoryFind.getUuid()) == null) {
            this.mRepository.insert(new NotesCategoryTreeEntity(predefinedCategoryFind.getUuid(), PredefinedCategory.UNCATEGORIZED.getUuid(), predefinedCategoryFind.getDisplayName(), predefinedCategoryFind.getPath()));
        }
    }

    public synchronized boolean move(String str, String str2) {
        return this.mRepository.move(str, str2);
    }

    public synchronized void moveInTrash(@NonNull Collection<String> collection, @NonNull String str) {
        this.mRepository.moveInTrash(collection, str);
    }

    public synchronized boolean moveToRecycleBin(DocumentCategoryTree documentCategoryTree, @NonNull Collection<String> collection) {
        return this.mRepository.moveToRecycleBin(documentCategoryTree, collection);
    }

    public synchronized void reorder(String str, Collection<? extends NotesCategoryTreeEntity> collection) {
        this.mRepository.reorder(str, collection);
    }

    public synchronized String restore(@NonNull String str) {
        return this.mRepository.restore(str);
    }

    public synchronized void runInTransaction(Runnable runnable) {
        this.mRepository.runInTransaction(runnable);
    }

    public synchronized void update(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.mRepository.update(notesCategoryTreeEntity);
    }

    public synchronized void updateFolderModifiedTime(Collection<String> collection, long j) {
        this.mRepository.updateFolderModifiedTime(collection, j);
    }

    public synchronized void updateFolderServerTimestampUpward(Collection<String> collection, long j) {
        this.mRepository.updateFolderServerTimestampUpward(collection, j);
    }

    public synchronized String findAndMakeCategory(String str) {
        NotesCategoryTreeRepository notesCategoryTreeRepository;
        notesCategoryTreeRepository = this.mRepository;
        return notesCategoryTreeRepository.findAndMakeCategory(notesCategoryTreeRepository.getAllDocumentCategoryTree(false), str);
    }

    public synchronized boolean move(@NonNull Collection<String> collection, String str) {
        return this.mRepository.move(collection, str);
    }

    public synchronized boolean moveToRecycleBin(@NonNull Collection<String> collection) {
        NotesCategoryTreeRepository notesCategoryTreeRepository;
        notesCategoryTreeRepository = this.mRepository;
        return notesCategoryTreeRepository.moveToRecycleBin(notesCategoryTreeRepository.getAllDocumentCategoryTree(false), collection);
    }

    public synchronized <T> T executeOperation(Callable<T> callable) {
        try {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return callable.call();
    }

    public synchronized void insert(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        this.mRepository.insert(collection);
    }

    public synchronized void update(@NonNull Collection<NotesCategoryTreeEntity> collection) {
        this.mRepository.update(collection);
    }
}
