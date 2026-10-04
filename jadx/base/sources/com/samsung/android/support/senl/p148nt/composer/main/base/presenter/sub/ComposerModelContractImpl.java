package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.DocumentServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import com.samsung.android.support.senl.p148nt.model.importer.utils.ImportUtils;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerModelContractImpl implements DocContract {
    private static final int DELAY_TIME_SHOW_PROGRESS_TO_SAVE = 1000;
    private static final String TAG = Logger.createTag("ComposerModelContractImpl");
    private ComposerViewPresenter mCompViewPresenter;
    private final ComposerLifeState mComposerLifeState;
    private final ComposerModel mComposerModel;
    private final ControllerManager mControllerManager;
    private final DocumentServiceManager mDMServiceManager;
    private ImportTask<SpenWNote, ImportSdocXParam> mImportTask;
    private final MenuPresenterManager mMenuPresenterManager;
    private Runnable mRunnableAfterCompletedSave;
    private NotesDocumentCompletionListener<SpenWordDocument> mSavingListener;
    private final BOOLEAN mIsSavingState = new BOOLEAN(false);
    private boolean mShouldCallRequestSyncFirst = false;
    private boolean mInitialized = true;
    private final List<DocContract.SavedListener> mSaveListeners = new ArrayList();

    public ComposerModelContractImpl(DocumentServiceManager documentServiceManager, BaseSubManager baseSubManager) {
        this.mDMServiceManager = documentServiceManager;
        this.mComposerLifeState = baseSubManager.getComposerLifeState();
        this.mControllerManager = baseSubManager.getControllerManager();
        ComposerModel composerModel = baseSubManager.getComposerModel();
        this.mComposerModel = composerModel;
        composerModel.getComposerSaveModel().setContract(this);
        this.mMenuPresenterManager = baseSubManager.getMenuPresenterManager();
    }

    private String getDetailScrollDirection() {
        return !this.mCompViewPresenter.getPageManager().getDocPageInfo().isScrollVertical() ? this.mCompViewPresenter.getPageManager().getDocPageInfo().getPageLayoutColumn() == 1 ? "2" : "3" : "1";
    }

    private NotesDocumentCompletionListener<SpenWordDocument> getSavingListener() {
        NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener = this.mSavingListener;
        if (notesDocumentCompletionListener != null) {
            return notesDocumentCompletionListener;
        }
        NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener2 = new NotesDocumentCompletionListener<SpenWordDocument>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerModelContractImpl.3
            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(@NonNull NotesDocument<SpenWordDocument> notesDocument, @NonNull String str) {
                Logger.m10999d(ComposerModelContractImpl.TAG, "completed# getSavingListener");
                ComposerModelContractImpl.this.handleCompletedSave();
                ComposerModelContractImpl.this.mMenuPresenterManager.onSaveCompleted();
                if (ComposerModelContractImpl.this.mShouldCallRequestSyncFirst) {
                    RequestToSyncManager.INSTANCE.requestSyncUpFirst(str);
                    ComposerModelContractImpl.this.mShouldCallRequestSyncFirst = false;
                }
                if (ComposerModelContractImpl.this.mInitialized) {
                    ComposerModelContractImpl.this.mCompViewPresenter.getHandoffManager().sendHandoffData();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                Logger.m11002f(ComposerModelContractImpl.TAG, "failed# getSavingListener exc : " + th);
                ComposerModelContractImpl.this.handleFailedSave();
                ComposerModelContractImpl.this.mMenuPresenterManager.onSaveFailed(th, str);
            }
        };
        this.mSavingListener = notesDocumentCompletionListener2;
        return notesDocumentCompletionListener2;
    }

    private NotesDocumentCompletionListener<SpenWordDocument> getSavingTempListener() {
        NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener = this.mSavingListener;
        if (notesDocumentCompletionListener != null) {
            return notesDocumentCompletionListener;
        }
        NotesDocumentCompletionListener<SpenWordDocument> notesDocumentCompletionListener2 = new NotesDocumentCompletionListener<SpenWordDocument>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerModelContractImpl.4
            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(@NonNull NotesDocument<SpenWordDocument> notesDocument, @NonNull String str) {
                Logger.m10999d(ComposerModelContractImpl.TAG, "completed# getSavingTempListener");
                ComposerModelContractImpl.this.handleCompletedSave();
                ComposerModelContractImpl.this.mMenuPresenterManager.onSaveCompleted();
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                Logger.m11002f(ComposerModelContractImpl.TAG, "failed# getSavingTempListener exc : " + th);
                ComposerModelContractImpl.this.handleFailedSave();
                ComposerModelContractImpl.this.mMenuPresenterManager.onSaveFailed(th, str);
            }
        };
        this.mSavingListener = notesDocumentCompletionListener2;
        return notesDocumentCompletionListener2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompletedSave() {
        Runnable runnable = this.mRunnableAfterCompletedSave;
        if (runnable != null) {
            runnable.run();
            this.mRunnableAfterCompletedSave = null;
        }
        setSavingState(false);
        if (this.mInitialized) {
            this.mComposerModel.getEntityManager().updateDataRepository(this.mComposerLifeState.getFragment());
            if (!this.mSaveListeners.isEmpty()) {
                Iterator<DocContract.SavedListener> it = this.mSaveListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSuccess();
                }
                this.mSaveListeners.clear();
            }
            this.mControllerManager.getProgressController().hideProgress(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailedSave() {
        setSavingState(false);
        if (this.mInitialized) {
            if (!this.mSaveListeners.isEmpty()) {
                this.mSaveListeners.clear();
            }
            this.mControllerManager.getProgressController().hideProgress(2, true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void addSavedListener(DocContract.SavedListener savedListener) {
        this.mSaveListeners.add(savedListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void cancelSaveToDevice() {
        ImportTask<SpenWNote, ImportSdocXParam> importTask = this.mImportTask;
        if (importTask != null) {
            importTask.cancel();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void changeDocument(String str, String str2) {
        DocumentServiceManager documentServiceManager = this.mDMServiceManager;
        if (documentServiceManager != null) {
            documentServiceManager.changeDocument(str, str2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public boolean isSavingState() {
        boolean value;
        synchronized (this.mIsSavingState) {
            value = this.mIsSavingState.getValue();
        }
        return value;
    }

    public void onDestroy() {
        this.mInitialized = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void requestDiscard() {
        DocumentServiceManager documentServiceManager = this.mDMServiceManager;
        if (documentServiceManager != null) {
            documentServiceManager.discard();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void requestSave(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2) {
        this.mCompViewPresenter.requestReadyForSave();
        setSavingState(true);
        this.mDMServiceManager.save(notesDocument, getSavingListener(), z);
        if (z2) {
            this.mControllerManager.getProgressController().showProgress(1000, 2);
        }
        ComposerSA.insertLog((String) null, "9995", getDetailScrollDirection());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void requestSaveCache(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2) {
        this.mCompViewPresenter.updateBodyTextPage();
        setSavingState(true);
        this.mDMServiceManager.saveCache(notesDocument, z, getSavingListener());
        if (z2) {
            this.mControllerManager.getProgressController().showProgress(1000, 2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void requestSaveToDevice(final ExecuteCallback executeCallback, @Nullable String str) {
        Activity activity = this.mComposerLifeState.getActivity();
        if (activity == null) {
            Logger.m11004w(TAG, "requestSaveToDevice, context is null");
            return;
        }
        String path = this.mComposerModel.getDocState().getPath();
        if (TextUtils.isEmpty(str)) {
            str = ImportUtils.createNewUuid(activity, path);
        }
        ImportTask<SpenWNote, ImportSdocXParam> importTaskListener = new ImportSdocXTask(new ImportSdocXParam().setContext(activity).setUuid(str).setExternalPath(path).setIsCoEditNote(this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()).setCaller(TAG)).setImported(true).setImportTaskListener(new ImportTask.ListerImpl() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerModelContractImpl.1
            @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
            public void onFail(@NonNull String str2, @NonNull String str3, int i, @Nullable String str4) {
                Logger.m11003i(ComposerModelContractImpl.TAG, "requestSaveToDevice# onError: " + i + " / errMsg: " + str4);
                ExecuteCallback executeCallback2 = executeCallback;
                if (executeCallback2 != null) {
                    executeCallback2.onFail();
                }
                ComposerModelContractImpl.this.mImportTask = null;
            }

            @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
            public void onSuccess(@NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Pair<String, String> pair) {
                AbstractC8014b.m7197C("requestSaveToDevice# onEnd, uuid: ", str3, ComposerModelContractImpl.TAG);
                ExecuteCallback executeCallback2 = executeCallback;
                if (executeCallback2 != null) {
                    executeCallback2.onSuccess();
                }
                ComposerModelContractImpl.this.mImportTask = null;
            }
        });
        this.mImportTask = importTaskListener;
        DataRepositoryScheduler.callable(importTaskListener).executeOn(Executors.newFixedThreadPool(1, new SenlThreadFactory("saveToDevice"))).observe(new OnCompletionListener<Boolean>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerModelContractImpl.2
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable Boolean bool) {
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                Logger.m11003i(ComposerModelContractImpl.TAG, "requestSaveToDevice#, onFail, e: " + exc.getMessage());
                ExecuteCallback executeCallback2 = executeCallback;
                if (executeCallback2 != null) {
                    executeCallback2.onFail();
                }
                ComposerModelContractImpl.this.mImportTask = null;
            }
        }).execute();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void requestSnapSave(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2) {
        notesDocument.getDocumentRepository().removeSaveStrategy(8);
        notesDocument.getDocumentRepository().removeSaveStrategy(2048);
        notesDocument.getDocumentRepository().addSaveStrategy(1024);
        notesDocument.getDocumentRepository().addSaveStrategy(4096);
        this.mCompViewPresenter.updateBodyTextPage();
        setSavingState(true);
        this.mDMServiceManager.snapSave(notesDocument, z, getSavingTempListener());
        if (z2) {
            this.mControllerManager.getProgressController().showProgress(1000, 2);
        }
    }

    public void setComposerViewPresenter(ComposerViewPresenter composerViewPresenter) {
        this.mCompViewPresenter = composerViewPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract
    public void setRunnableAfterCompletedSave(Runnable runnable) {
        this.mRunnableAfterCompletedSave = runnable;
    }

    public void setSavingState(boolean z) {
        synchronized (this.mIsSavingState) {
            this.mIsSavingState.setValue(z);
            this.mRunnableAfterCompletedSave = null;
        }
    }

    public void setShouldCallRequestSyncFirst(boolean z) {
        this.mShouldCallRequestSyncFirst = z;
    }
}
