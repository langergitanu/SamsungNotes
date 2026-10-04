package com.samsung.android.support.senl.p148nt.app.common.data;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.converted.NotesConvertedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesLockDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOldDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOrganizedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015J\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u0004\u0018\u00010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/data/RepositoryManager;", "", "<init>", "()V", "mDocumentCategoryTree", "Lcom/samsung/android/support/senl/nt/data/database/core/document/folder/DocumentCategoryTree;", "mNotesDocumentRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/NotesDocumentRepository;", "mMainListRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;", "mNotesOldDocumentRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/NotesOldDocumentRepository;", "mNotesConvertedDocumentRepository", "Lcom/samsung/android/support/senl/nt/data/repository/converted/NotesConvertedDocumentRepository;", "mNotesLockDocumentRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/NotesLockDocumentRepository;", "mTagRepository", "Lcom/samsung/android/support/senl/nt/data/repository/tag/NotesTagRepository;", "mSyncNoteDataRepository", "Lcom/samsung/android/support/senl/nt/data/repository/sync/SyncNoteDataRepository;", "mNotesOrganizedDocumentRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/NotesOrganizedDocumentRepository;", "mNotesSearchRepository", "Lcom/samsung/android/support/senl/nt/data/repository/search/NotesSearchRepository;", "getNoteRepository", "getMainListRepository", "getOldNoteRepository", "getConvertedNoteRepository", "getNoteLockRepository", "getHashTagRepository", "getSyncNoteDataRepository", "getNotesOrganizedDocumentRepository", "getDocumentCategoryTree", "getNoteSearchRepository", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RepositoryManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static RepositoryManager sInstance;

    @Nullable
    private DocumentCategoryTree mDocumentCategoryTree;

    @Nullable
    private MainListDocumentDataRepository mMainListRepository;

    @Nullable
    private NotesConvertedDocumentRepository mNotesConvertedDocumentRepository;

    @Nullable
    private NotesDocumentRepository mNotesDocumentRepository;

    @Nullable
    private NotesLockDocumentRepository mNotesLockDocumentRepository;

    @Nullable
    private NotesOldDocumentRepository mNotesOldDocumentRepository;

    @Nullable
    private NotesOrganizedDocumentRepository mNotesOrganizedDocumentRepository;

    @Nullable
    private NotesSearchRepository mNotesSearchRepository;

    @Nullable
    private SyncNoteDataRepository mSyncNoteDataRepository;

    @Nullable
    private NotesTagRepository mTagRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/data/RepositoryManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/app/common/data/RepositoryManager;", "getInstance", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized RepositoryManager getInstance() {
            RepositoryManager repositoryManager;
            try {
                if (RepositoryManager.sInstance == null) {
                    RepositoryManager.sInstance = new RepositoryManager();
                }
                repositoryManager = RepositoryManager.sInstance;
                Intrinsics.checkNotNull(repositoryManager);
            } catch (Throwable th) {
                throw th;
            }
            return repositoryManager;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized RepositoryManager getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final NotesConvertedDocumentRepository getConvertedNoteRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesConvertedDocumentRepository == null) {
            this.mNotesConvertedDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesConvertedDocumentRepository();
        }
        return this.mNotesConvertedDocumentRepository;
    }

    @NotNull
    public final DocumentCategoryTree getDocumentCategoryTree() {
        if (this.mDocumentCategoryTree == null) {
            this.mDocumentCategoryTree = FolderManager.getInstance().getAllDocumentCategoryTree(false);
        }
        DocumentCategoryTree documentCategoryTree = this.mDocumentCategoryTree;
        Intrinsics.checkNotNull(documentCategoryTree);
        return documentCategoryTree;
    }

    @Nullable
    public final NotesTagRepository getHashTagRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mTagRepository == null) {
            this.mTagRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTagRepository();
        }
        return this.mTagRepository;
    }

    @Nullable
    public final MainListDocumentDataRepository getMainListRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mMainListRepository == null) {
            this.mMainListRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createMainListDocumentDataRepository();
        }
        return this.mMainListRepository;
    }

    @Nullable
    public final NotesLockDocumentRepository getNoteLockRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesLockDocumentRepository == null) {
            this.mNotesLockDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesLockDocumentRepository();
        }
        return this.mNotesLockDocumentRepository;
    }

    @Nullable
    public final NotesDocumentRepository getNoteRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesDocumentRepository == null) {
            this.mNotesDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
        }
        return this.mNotesDocumentRepository;
    }

    @Nullable
    public final NotesSearchRepository getNoteSearchRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesSearchRepository == null) {
            this.mNotesSearchRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createSearchRepository();
        }
        return this.mNotesSearchRepository;
    }

    @Nullable
    public final NotesOrganizedDocumentRepository getNotesOrganizedDocumentRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesOrganizedDocumentRepository == null) {
            this.mNotesOrganizedDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createOrganizedDocumentRepository();
        }
        return this.mNotesOrganizedDocumentRepository;
    }

    @Nullable
    public final NotesOldDocumentRepository getOldNoteRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mNotesOldDocumentRepository == null) {
            this.mNotesOldDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesOldDocumentRepository();
        }
        return this.mNotesOldDocumentRepository;
    }

    @NotNull
    public final SyncNoteDataRepository getSyncNoteDataRepository() {
        if (this.mSyncNoteDataRepository == null) {
            this.mSyncNoteDataRepository = new SyncNoteDataRepository();
        }
        SyncNoteDataRepository syncNoteDataRepository = this.mSyncNoteDataRepository;
        Intrinsics.checkNotNull(syncNoteDataRepository);
        return syncNoteDataRepository;
    }
}
