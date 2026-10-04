package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskLock extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskLock");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private ComposerSaveModel mComposerSaveModel;
        private Context mContext;
        private DocInfo mDocInfo;
        private boolean mIsLock;
        private NotesDocEntityManager mNotesDocEntityManager;
        private SpenWNote mSpenWNote;

        public InputValues(Context context, SpenWNote spenWNote, ComposerSaveModel composerSaveModel, DocInfo docInfo, NotesDocEntityManager notesDocEntityManager, boolean z) {
            this.mContext = context;
            this.mComposerSaveModel = composerSaveModel;
            this.mDocInfo = docInfo;
            this.mNotesDocEntityManager = notesDocEntityManager;
            this.mIsLock = z;
            this.mSpenWNote = spenWNote;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private String mPath;
        private String mUuid;

        public ResultValues(String str, String str2) {
            this.mUuid = str;
            this.mPath = str2;
        }

        public String getPath() {
            return this.mPath;
        }

        public String getUuid() {
            return this.mUuid;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpenWNoteAndEntity(SpenWNote spenWNote, NotesDocEntityManager notesDocEntityManager, boolean z, String str) {
        boolean z2 = spenWNote.isChanged() && !spenWNote.isChangedOnlyThumbnail();
        try {
            if (z) {
                spenWNote.setOwnerId(str);
                spenWNote.setDocumentType(SpenWNote.DocumentType.LOCKED_WDOC);
            } else {
                spenWNote.setOwnerId("");
                spenWNote.setDocumentType(SpenWNote.DocumentType.UNLOCKED_DOC);
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("updateSpenWNote e = "), TAG);
        }
        if (!z2) {
            spenWNote.clearChangedFlag();
        }
        notesDocEntityManager.updateLockEntity(z, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskLock.1
            @Override // java.lang.Runnable
            public void run() {
                if (inputValues.mComposerSaveModel.isSavingState()) {
                    Logger.m11000e(TaskLock.TAG, "isSavingState is true ");
                    TaskLock.this.notifyCallback(false, null);
                    return;
                }
                boolean zIsLocked = inputValues.mNotesDocEntityManager.isLocked();
                String lockAccountGuid = inputValues.mNotesDocEntityManager.getLockAccountGuid();
                TaskLock.this.updateSpenWNoteAndEntity(inputValues.mSpenWNote, inputValues.mNotesDocEntityManager, inputValues.mIsLock, RequestToSyncManager.INSTANCE.getAccountGuid(inputValues.mContext));
                boolean zExecute = DocumentLockResolver.execute(inputValues.mContext, inputValues.mDocInfo.getUuid(), inputValues.mIsLock);
                if (zExecute) {
                    TaskLock.this.notifyCallback(zExecute, new ResultValues(inputValues.mDocInfo.getUuid(), inputValues.mDocInfo.getDocPath()));
                    return;
                }
                Logger.m11002f(TaskLock.TAG, "fail lock ");
                TaskLock.this.updateSpenWNoteAndEntity(inputValues.mSpenWNote, inputValues.mNotesDocEntityManager, zIsLocked, lockAccountGuid);
                TaskLock.this.notifyCallback(zExecute, null);
            }
        });
    }
}
