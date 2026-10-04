package com.samsung.android.support.senl.p148nt.data.repository;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeRepository;
import com.samsung.android.support.senl.p148nt.data.repository.converted.NotesConvertedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.CoverStickerRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.CoverTemplateRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.SuggestedCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentExtraRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentThumbnailRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.ExternalSharedDocumentsRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesLockDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesMappedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOldDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOrganizedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesRecycleBinRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.SttContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesRetryRepository;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesStrokeRepository;
import com.samsung.android.support.senl.p148nt.data.repository.restore.NotesRestoreRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesPageSearchInfoRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sticky.StickyNoteRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sticky.StickyStrokeRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sticky.StickyTextRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.data.repository.template.NotesTemplateRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesDataRepositoryFactory {
    private final Context mAppContext;

    private NotesDataRepositoryFactory(@NonNull Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static NotesDataRepositoryFactory newInstance(@NonNull Context context) {
        return new NotesDataRepositoryFactory(context);
    }

    @NonNull
    public NotesCategoryTreeClosureRepository createCategoryTreeClosureRepository() {
        return new NotesCategoryTreeClosureRepository();
    }

    @NonNull
    public CoverStickerRepository createCoverStickerRepository() {
        return new CoverStickerRepository();
    }

    @NonNull
    public CoverTemplateRepository createCoverTemplateRepository() {
        return new CoverTemplateRepository();
    }

    @NonNull
    public NotesCategoryTreeRepository createDocumentCategoryTreeRepository() {
        return new NotesCategoryTreeRepository(this.mAppContext);
    }

    @NonNull
    public NotesContentRepository createDocumentContentRepository() {
        return new NotesContentRepository();
    }

    @NonNull
    public NotesDocumentCoverRepository createDocumentCoverRepository() {
        return new NotesDocumentCoverRepository();
    }

    @NonNull
    public NotesDocumentRepository createDocumentDataRepository() {
        return new NotesDocumentRepository(this.mAppContext);
    }

    @NonNull
    public DocumentExtraRepository createDocumentExtraRepository() {
        return new DocumentExtraRepository();
    }

    @NonNull
    public NotesRetryRepository createDocumentRetryRepository() {
        return new NotesRetryRepository();
    }

    @NonNull
    public NotesStrokeRepository createDocumentStrokeRepository() {
        return new NotesStrokeRepository();
    }

    @NonNull
    public NotesTagRepository createDocumentTagRepository() {
        return new NotesTagRepository(this.mAppContext);
    }

    @NonNull
    public DocumentTempDataRepository createDocumentTempDataRepository() {
        return new DocumentTempDataRepository();
    }

    @NonNull
    public DocumentThumbnailRepository createDocumentThumbnailRepository() {
        return new DocumentThumbnailRepository();
    }

    @NonNull
    public ExternalSharedDocumentsRepository createExternalSharedDocumentsRepository() {
        return new ExternalSharedDocumentsRepository();
    }

    public MainListDocumentDataRepository createMainListDocumentDataRepository() {
        return new MainListDocumentDataRepository();
    }

    @NonNull
    public NotesMappedDocumentRepository createMappedDocumentRepository() {
        return new NotesMappedDocumentRepository();
    }

    @NonNull
    public NotesConvertedDocumentRepository createNotesConvertedDocumentRepository() {
        return new NotesConvertedDocumentRepository();
    }

    @NonNull
    public NotesDocumentPageRepository createNotesDocumentPageRepository() {
        return new NotesDocumentPageRepository();
    }

    @NonNull
    public NotesLockDocumentRepository createNotesLockDocumentRepository() {
        return new NotesLockDocumentRepository();
    }

    @NonNull
    public NotesOldDocumentRepository createNotesOldDocumentRepository() {
        return new NotesOldDocumentRepository();
    }

    @NonNull
    public NotesRecycleBinRepository createNotesRecycleBinRepository() {
        return new NotesRecycleBinRepository();
    }

    @NonNull
    public NotesRestoreRepository createNotesRestoreRepository() {
        return new NotesRestoreRepository();
    }

    @NonNull
    public NotesOrganizedDocumentRepository createOrganizedDocumentRepository() {
        return new NotesOrganizedDocumentRepository();
    }

    @NonNull
    public NotesPageSearchInfoRepository createPageSearchInfoRepository() {
        return new NotesPageSearchInfoRepository();
    }

    @NonNull
    public NotesSearchRepository createSearchRepository() {
        return new NotesSearchRepository();
    }

    @NonNull
    public StickyNoteRepository createStickyNoteRepository() {
        return new StickyNoteRepository();
    }

    @NonNull
    public StickyStrokeRepository createStickyStrokeRepository() {
        return new StickyStrokeRepository();
    }

    @NonNull
    public StickyTextRepository createStickyTextRepository() {
        return new StickyTextRepository();
    }

    @NonNull
    public SttContentRepository createSttContentRepository() {
        return new SttContentRepository();
    }

    @NonNull
    public SuggestedCoverRepository createSuggestedCoverRepository() {
        return new SuggestedCoverRepository();
    }

    @NonNull
    public SyncNoteDataRepository createSyncNoteDataRepository() {
        return new SyncNoteDataRepository();
    }

    @NonNull
    public NotesTemplateRepository createTemplateRepository() {
        return new NotesTemplateRepository();
    }
}
