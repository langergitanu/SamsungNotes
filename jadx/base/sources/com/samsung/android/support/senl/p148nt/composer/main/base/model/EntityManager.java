package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.common.IModelParent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EntityManager {
    private static final String KEY_INSTANCE_STATE = "key_instance_entity";
    private static final String TAG = Logger.createTag("EntityManager");
    private BookmarkEntityManager mBookmarkEntityManager;
    private final IModelParent mModelParent;
    private final NotesDocEntityManager mNotesDocEntityManager;

    public EntityManager(Context context, IModelParent iModelParent) {
        this.mNotesDocEntityManager = new NotesDocEntityManager(NotesDataRepositoryFactory.newInstance(context));
        this.mModelParent = iModelParent;
    }

    public void changeDocState(LifecycleOwner lifecycleOwner, NotesDocument<SpenWordDocument> notesDocument) {
        Logger.m10999d(TAG, "changeDocState#");
        this.mNotesDocEntityManager.initNoteDocEntity(notesDocument.getUuid(), lifecycleOwner);
        this.mNotesDocEntityManager.connectObserver(notesDocument.getUuid(), lifecycleOwner);
        BookmarkEntityManager bookmarkEntityManager = this.mBookmarkEntityManager;
        if (bookmarkEntityManager != null) {
            bookmarkEntityManager.resetPageRepository(lifecycleOwner);
        }
    }

    public BookmarkModel getBookmarkModel() {
        BookmarkEntityManager bookmarkEntityManager = this.mBookmarkEntityManager;
        if (bookmarkEntityManager != null) {
            return bookmarkEntityManager.getBookmarkModel();
        }
        return null;
    }

    public NotesDocEntityManager getNotesDocEntityManager() {
        return this.mNotesDocEntityManager;
    }

    public void initDataRepository(LifecycleOwner lifecycleOwner, NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null) {
            return;
        }
        this.mNotesDocEntityManager.setDocState(notesDocument);
        if (lifecycleOwner != null) {
            this.mNotesDocEntityManager.connectObserver(notesDocument.getUuid(), lifecycleOwner);
        }
        if (this.mBookmarkEntityManager == null) {
            this.mBookmarkEntityManager = new BookmarkEntityManager(this.mModelParent, this.mNotesDocEntityManager.getRepositoryFactory(), lifecycleOwner);
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putParcelable(KEY_INSTANCE_STATE, this.mNotesDocEntityManager.getNotesDocumentEntity());
    }

    public void release() {
        this.mNotesDocEntityManager.release();
    }

    public void restoreEntity(@Nullable Bundle bundle) {
        NotesDocumentEntity notesDocumentEntity;
        if (bundle == null || (notesDocumentEntity = (NotesDocumentEntity) bundle.getParcelable(KEY_INSTANCE_STATE)) == null || this.mNotesDocEntityManager.getNotesDocumentRepository().get(notesDocumentEntity.getUuid()) != null) {
            return;
        }
        Logger.m11000e(TAG, "restoreEntity#");
        this.mNotesDocEntityManager.getNotesDocumentEntity().setWidgetId(notesDocumentEntity.getWidgetId());
        this.mNotesDocEntityManager.setFolderUuid(notesDocumentEntity.getCategoryUuid());
    }

    public void setCorruptedState(String str) {
        this.mNotesDocEntityManager.setNotesDocumentEntity(str);
        if (this.mNotesDocEntityManager.getNotesDocumentEntity() == null) {
            Logger.m11000e(TAG, "setCorruptedState fail");
            return;
        }
        int corrupted = this.mNotesDocEntityManager.getNotesDocumentEntity().getCorrupted();
        if ((corrupted & 1) != 1) {
            this.mNotesDocEntityManager.getNotesDocumentRepository().updateCorrupted(str, corrupted | 1);
        }
    }

    public void setDocState(NotesDocument<SpenWordDocument> notesDocument) {
        this.mNotesDocEntityManager.setDocState(notesDocument);
    }

    public Pair<String, Boolean> updateCorruptedState(String str) {
        String strM756B = "";
        if (this.mNotesDocEntityManager.getNotesDocumentEntity() == null) {
            Logger.m11000e(TAG, "updateCorruptedState fail");
            return new Pair<>("", Boolean.FALSE);
        }
        int corrupted = this.mNotesDocEntityManager.getNotesDocumentEntity().getCorrupted();
        boolean z = true;
        if ((corrupted & 1) == 1) {
            this.mNotesDocEntityManager.getNotesDocumentRepository().updateCorrupted(str, corrupted & (-2));
            strM756B = " removed CORRUPTED_OCCURED ";
        }
        if ((this.mNotesDocEntityManager.getSyncConflictManager().getNoteSyncState() & 512) == 512) {
            strM756B = AbstractC0541b.m756B(strM756B, " SyncState.MAX_OBJECT_LIMIT ");
        } else {
            z = false;
        }
        return new Pair<>(strM756B, Boolean.valueOf(z));
    }

    public void updateDataRepository(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null || this.mNotesDocEntityManager.isObserving() || !this.mNotesDocEntityManager.isExist()) {
            return;
        }
        Logger.m10999d(TAG, "updateDataRepository# set observer for new document ");
        this.mNotesDocEntityManager.connectObserver(this.mModelParent.getDocState().getUuid(), lifecycleOwner);
        BookmarkEntityManager bookmarkEntityManager = this.mBookmarkEntityManager;
        if (bookmarkEntityManager != null) {
            bookmarkEntityManager.updatePageRepositoryObserver(lifecycleOwner);
        }
    }

    public void initDataRepository(String str) {
        this.mNotesDocEntityManager.setNotesDocumentEntity(str);
    }
}
