package com.samsung.android.support.senl.p148nt.app.common.data;

import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/data/SearchUseCaseManager;", "", "<init>", "()V", "createSearchNoteUseCase", "Lcom/samsung/android/support/senl/nt/model/domain/search/SearchNoteUseCase;", "createSearchFolderUseCase", "Lcom/samsung/android/support/senl/nt/model/domain/search/SearchFolderUseCase;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchUseCaseManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static SearchUseCaseManager sInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/data/SearchUseCaseManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/app/common/data/SearchUseCaseManager;", "getInstance", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized SearchUseCaseManager getInstance() {
            SearchUseCaseManager searchUseCaseManager;
            try {
                if (SearchUseCaseManager.sInstance == null) {
                    SearchUseCaseManager.sInstance = new SearchUseCaseManager();
                }
                searchUseCaseManager = SearchUseCaseManager.sInstance;
                Intrinsics.checkNotNull(searchUseCaseManager);
            } catch (Throwable th) {
                throw th;
            }
            return searchUseCaseManager;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized SearchUseCaseManager getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final SearchFolderUseCase createSearchFolderUseCase() {
        NotesSearchRepository noteSearchRepository = RepositoryManager.INSTANCE.getInstance().getNoteSearchRepository();
        if (noteSearchRepository == null) {
            return null;
        }
        return new SearchFolderUseCase(noteSearchRepository);
    }

    @Nullable
    public final SearchNoteUseCase createSearchNoteUseCase() {
        MainListDocumentDataRepository mainListRepository;
        RepositoryManager.Companion companion = RepositoryManager.INSTANCE;
        NotesSearchRepository noteSearchRepository = companion.getInstance().getNoteSearchRepository();
        if (noteSearchRepository == null || (mainListRepository = companion.getInstance().getMainListRepository()) == null) {
            return null;
        }
        return new SearchNoteUseCase(noteSearchRepository, mainListRepository);
    }
}
