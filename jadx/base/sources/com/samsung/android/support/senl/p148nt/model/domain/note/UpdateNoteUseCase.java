package com.samsung.android.support.senl.p148nt.model.domain.note;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.DocumentObjectInserter;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.domain.common.DomainUtils;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.helper.UpdateDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UpdateNoteUseCase {
    private static final String TAG = ModelLogger.createTag("UpdateNoteUseCase");
    private final Callback mCallback;
    private final NotesDocumentRepository mRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void handleOpenedNote(@NonNull UpdateNoteParam updateNoteParam);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private final Set<String> mUpdatedNotes = new HashSet();

        public Result addUpdatedNotes(@NonNull Collection<String> collection) {
            this.mUpdatedNotes.addAll(collection);
            return this;
        }

        @NonNull
        public Set<String> getUpdatedNotes() {
            return this.mUpdatedNotes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UpdateNoteParam {
        private String mBodyText;
        private final String mDocUuid;
        private String mFolderUuid;
        private ArrayList<String> mMimeTypes;
        private long mTimeout;
        private String mTitle;
        private ArrayList<Uri> mUris;

        public UpdateNoteParam(@NonNull String str) {
            this.mDocUuid = str;
        }

        @Nullable
        public String getBodyText() {
            return this.mBodyText;
        }

        @NonNull
        public String getDocUuid() {
            return this.mDocUuid;
        }

        @Nullable
        public String getFolderUuid() {
            return this.mFolderUuid;
        }

        @Nullable
        public ArrayList<String> getMimeTypes() {
            return this.mMimeTypes;
        }

        public long getTimeout() {
            return this.mTimeout;
        }

        @Nullable
        public String getTitle() {
            return this.mTitle;
        }

        @Nullable
        public ArrayList<Uri> getUris() {
            return this.mUris;
        }

        public UpdateNoteParam setBodyText(@Nullable String str) {
            this.mBodyText = str;
            return this;
        }

        public UpdateNoteParam setFolderUuid(@NonNull String str) {
            this.mFolderUuid = str;
            return this;
        }

        public UpdateNoteParam setMimeTypes(@NonNull ArrayList<String> arrayList) {
            this.mMimeTypes = arrayList;
            return this;
        }

        public UpdateNoteParam setTimeout(long j) {
            this.mTimeout = j;
            return this;
        }

        public UpdateNoteParam setTitle(@Nullable String str) {
            this.mTitle = str;
            return this;
        }

        public UpdateNoteParam setUris(@NonNull ArrayList<Uri> arrayList) {
            this.mUris = arrayList;
            return this;
        }
    }

    public UpdateNoteUseCase(@NonNull NotesDocumentRepository notesDocumentRepository, @Nullable Callback callback) {
        this.mRepository = notesDocumentRepository;
        this.mCallback = callback;
    }

    @NonNull
    private String getValidFolderUuid(@Nullable String str) {
        return str == null ? "" : (TextUtils.isEmpty(str) || FolderManager.getInstance().getCategoryEntity(str) != null) ? str : "";
    }

    @WorkerThread
    public Result execute(@NonNull final Context context, @NonNull UpdateNoteParam updateNoteParam) {
        final UpdateNoteParam updateNoteParam2;
        if (ComposerManager.getInstance().isOpen(updateNoteParam.getDocUuid(), null)) {
            DataLogger.m12302d(TAG, "getUpdatableUuids, isOpened: " + updateNoteParam.getDocUuid());
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.handleOpenedNote(updateNoteParam);
                updateNoteParam2 = updateNoteParam;
                return new Result().addUpdatedNotes(Collections.singleton(updateNoteParam2.getDocUuid()));
            }
            return new Result();
        }
        if (!this.mRepository.getUpdatableNotes(Collections.singleton(updateNoteParam.getDocUuid())).isEmpty()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String strApplyTitleMaxLimit = DomainUtils.applyTitleMaxLimit(updateNoteParam.getTitle());
            final String validFolderUuid = getValidFolderUuid(updateNoteParam.getFolderUuid());
            updateNoteParam2 = updateNoteParam;
            new UpdateDocumentHelper(context, DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID).setUuid(updateNoteParam.getDocUuid()).setListener(new BaseDocumentHelper.Listener() { // from class: com.samsung.android.support.senl.nt.model.domain.note.UpdateNoteUseCase.1
                @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                public void onFailed(@NonNull String str) {
                    countDownLatch.countDown();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                public void onOpen(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                    ISpenDocument doc = notesDocument.getDoc();
                    String str2 = strApplyTitleMaxLimit;
                    if (str2 != null) {
                        doc.insertTitle(str2);
                    }
                    if (!TextUtils.isEmpty(updateNoteParam2.getBodyText())) {
                        new MarkdownConverter().insertMarkdown((SpenWNote) doc, updateNoteParam2.getBodyText());
                    }
                    if (!validFolderUuid.isEmpty()) {
                        notesDocument.getDocumentEntityContainer().getEntity().setCategoryUuid(validFolderUuid);
                    }
                    try {
                        new DocumentObjectInserter().insert(context, updateNoteParam2.getMimeTypes(), updateNoteParam2.getUris(), (SpenWNote) doc);
                    } catch (Exception e) {
                        AbstractC11014a.m12333r(e, new StringBuilder("insert, e : "), UpdateNoteUseCase.TAG);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                public void onSave(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                    countDownLatch.countDown();
                }
            }).execute();
            try {
                if (updateNoteParam2.getTimeout() > 0) {
                    boolean zAwait = countDownLatch.await(updateNoteParam2.getTimeout(), TimeUnit.MILLISECONDS);
                    DataLogger.m12302d(TAG, "execute, finished before timeout: " + zAwait);
                } else {
                    countDownLatch.await();
                }
            } catch (InterruptedException e) {
                DataLogger.m12303e(TAG, "execute, e: " + e.getMessage());
            }
            return new Result().addUpdatedNotes(Collections.singleton(updateNoteParam2.getDocUuid()));
        }
        return new Result();
    }
}
