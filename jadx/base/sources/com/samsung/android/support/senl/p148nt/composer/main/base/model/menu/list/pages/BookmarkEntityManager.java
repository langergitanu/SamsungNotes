package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.common.IModelParent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentDBSaver;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BookmarkEntityManager {
    private static final String TAG = "BookmarkEntityManager";
    private final BookmarkModel mBookmarkModel;
    private boolean mIsObserving;
    private final NotesDocumentPageRepository mNotesDocumentPageRepository;
    private final IModelParent mParent;
    private final NotesDataRepositoryFactory mRepositoryFactory;

    public BookmarkEntityManager(final IModelParent iModelParent, @NonNull final NotesDataRepositoryFactory notesDataRepositoryFactory, LifecycleOwner lifecycleOwner) {
        BookmarkModel bookmarkModel = new BookmarkModel();
        this.mBookmarkModel = bookmarkModel;
        this.mIsObserving = false;
        this.mParent = iModelParent;
        this.mRepositoryFactory = notesDataRepositoryFactory;
        this.mNotesDocumentPageRepository = notesDataRepositoryFactory.createNotesDocumentPageRepository();
        loadPageRepository(lifecycleOwner);
        bookmarkModel.addListener(new BookmarkModel.IBookmarkUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.BookmarkEntityManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.BookmarkModel.IBookmarkUpdateListener
            public void onBookmarkPageUpdated(String str, int i, boolean z) {
                if (iModelParent.getDocState() == null) {
                    Logger.m11000e(BookmarkEntityManager.TAG, "onBookmarkPageUpdated# null");
                } else {
                    BookmarkEntityManager.this.mNotesDocumentPageRepository.updateDelete(iModelParent.getDocState().getUuid(), str, i, z ? 1 : 0);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.BookmarkModel.IBookmarkUpdateListener
            public void onBookmarkUpdated(String str, int i, boolean z, boolean z2) {
                if (z2) {
                    return;
                }
                String uuid = BookmarkEntityManager.this.mParent.getDocState().getUuid();
                BookmarkEntityManager.this.mNotesDocumentPageRepository.updateFavorite(str, uuid, i, z);
                NotesDocumentEntity notesDocumentEntity = BookmarkEntityManager.this.mRepositoryFactory.createDocumentDataRepository().get(uuid);
                if (notesDocumentEntity != null) {
                    notesDocumentEntity.setIsDirty(1);
                    notesDocumentEntity.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime()));
                    DocumentDBSaver.saveSDocX(notesDataRepositoryFactory, null, notesDocumentEntity, -1);
                }
                RequestToSyncManager.INSTANCE.requestSyncByModification();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePageRepositoryObserver$0(List list) {
        Logger.m11003i(TAG, "updatePageRepositoryObserver#");
        updateBookmarks(list);
    }

    private void loadPageRepository(LifecycleOwner lifecycleOwner) {
        updateBookmarks(this.mNotesDocumentPageRepository.getFavoriteList(this.mParent.getDocState().getUuid()));
        updatePageRepositoryObserver(lifecycleOwner);
    }

    private void updateBookmarks(List<NotesDocumentPageEntity> list) {
        for (NotesDocumentPageEntity notesDocumentPageEntity : list) {
            BookmarkModel bookmarkModel = this.mBookmarkModel;
            String pageUuid = notesDocumentPageEntity.getPageUuid();
            int index = notesDocumentPageEntity.getIndex();
            boolean z = false;
            boolean z2 = notesDocumentPageEntity.getFavorite() == 1;
            if (notesDocumentPageEntity.getIsDeleted() == 1) {
                z = true;
            }
            bookmarkModel.update(pageUuid, index, z2, z, true);
        }
    }

    public BookmarkModel getBookmarkModel() {
        return this.mBookmarkModel;
    }

    public void resetPageRepository(LifecycleOwner lifecycleOwner) {
        this.mIsObserving = false;
        this.mBookmarkModel.clear();
        loadPageRepository(lifecycleOwner);
    }

    public void updatePageRepositoryObserver(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Logger.m11003i(TAG, "updatePageRepositoryObserver, lifeCyclerOwner is null");
        } else {
            if (this.mIsObserving) {
                return;
            }
            this.mIsObserving = true;
            this.mNotesDocumentPageRepository.observe(this.mParent.getDocState().getUuid()).observe(lifecycleOwner, new C9152a(this, 0));
        }
    }
}
