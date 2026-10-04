package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.lifecycle.LifecycleOwner;
import androidx.work.impl.RunnableC4054d;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenInvalidCacheException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RunnableC8501g;
import com.samsung.android.support.senl.p148nt.base.common.MemoryLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncDocumentState;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.DeveloperMode;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.CoeditStarter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerSubContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.RestoreNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.restore.RestoreSaveFailedNote;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceContractImpl implements ServiceContract<SpenWordDocument>, CoeditStarter.Contract {
    private static final String TAG = Logger.createTag("ServiceContractImpl");
    private final ComposerCloser mComposerCloser;
    private final Contract mContract;
    private Runnable mPendingReload;
    private final boolean mRestoreEnabled;
    protected final BaseSubManager mSubManager;
    private String mChangingUuid = null;
    private SchedulerDataSource.WorkingState mChangingNoteWorkingState = null;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C99541 implements RestoreNote.ResultCallback {
        final /* synthetic */ Activity val$activity;

        public C99541(Activity activity) {
            this.val$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fail$0(Activity activity, String str) {
            if (CommonUtil.isNotAvailableActivity(activity)) {
                return;
            }
            ToastHandler.show(activity, C9086R.string.unable_to_open_note, 1);
            ServiceContractImpl.this.mComposerCloser.finish(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.RestoreNote.ResultCallback
        public void fail(String str) {
            if (CommonUtil.isNotAvailableActivity(this.val$activity)) {
                return;
            }
            Activity activity = this.val$activity;
            activity.runOnUiThread(new RunnableC9960d(this, 0, activity, str));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.RestoreNote.ResultCallback
        public void success(String str, String str2) {
            ServiceContractImpl.this.mContract.openDocument(str, str2);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C99552 implements RestoreSaveFailedNote.Callback {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ComposerModel val$composerModel;
        final /* synthetic */ String val$path;
        final /* synthetic */ String val$uuid;

        public C99552(ComposerModel composerModel, String str, String str2, Activity activity) {
            this.val$composerModel = composerModel;
            this.val$uuid = str;
            this.val$path = str2;
            this.val$activity = activity;
        }

        private void fail() {
            if (CommonUtil.isNotAvailableActivity(this.val$activity)) {
                return;
            }
            final Activity activity = this.val$activity;
            final ComposerModel composerModel = this.val$composerModel;
            final String str = this.val$uuid;
            activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7080a.lambda$fail$0(activity, composerModel, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fail$0(Activity activity, ComposerModel composerModel, String str) {
            if (CommonUtil.isNotAvailableActivity(activity)) {
                return;
            }
            composerModel.getEntityManager().setCorruptedState(str);
            ToastHandler.show(activity, C9086R.string.unable_to_open_note, 1);
            ServiceContractImpl.this.mComposerCloser.finish("failed to RestoreSaveFailedNote");
        }

        private void success() {
            ServiceContractImpl.this.mContract.openDocument(this.val$uuid, this.val$path);
            this.val$composerModel.setIsRecoveredOnCorrupted(true);
            this.val$composerModel.setCanShowRecoveredOnCorrupted(false);
        }

        @Override // com.samsung.android.support.senl.nt.model.documents.restore.RestoreSaveFailedNote.Callback
        public void onPostRestore(boolean z) {
            this.val$composerModel.setIsRecoveringNote(false);
            if (z) {
                success();
            } else {
                fail();
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.documents.restore.RestoreSaveFailedNote.Callback
        public void onPreRestore() {
            this.val$composerModel.setIsRecoveringNote(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void attachLoadedDoc(NotesDocument<SpenWordDocument> notesDocument);

        void closeOldDoc();

        void connectCoeditService(boolean z);

        ComposerSubContract.IView getView();

        void openDocument(String str, String str2);

        void resetOldNote();

        void setUuidToHandoffSender();
    }

    public ServiceContractImpl(BaseSubManager baseSubManager, ComposerCloser composerCloser, Contract contract) {
        this.mSubManager = baseSubManager;
        this.mComposerCloser = composerCloser;
        this.mRestoreEnabled = baseSubManager.getConfig().isRestoreEnabled();
        this.mContract = contract;
    }

    private void changeNote(NotesDocument<SpenWordDocument> notesDocument, boolean z, Runnable runnable) {
        Logger.m10999d(TAG, "changeNote# closed: " + ((SpenWordDocument) notesDocument.getDoc()).isClosed());
        runnable.run();
        if (z) {
            this.mSubManager.getCompViewPresenter().getHandler().post(new RunnableC9959c(this, notesDocument, 1));
        }
    }

    private boolean controlDocServiceException(Throwable th, Activity activity) {
        if (!(th instanceof DocumentServiceConstants.DocumentServiceAlreadyClosedException)) {
            return false;
        }
        ToastHandler.show(activity.getApplicationContext(), C9086R.string.updating_note_try_again_later, 1);
        this.mComposerCloser.finish("DocumentServiceAlreadyClosedException");
        return true;
    }

    private boolean controlSpenDocException(Throwable th, boolean z, Activity activity) {
        if (th == null) {
            return false;
        }
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        String uuid = this.mSubManager.getComposerModel().getDocInfo().getUuid();
        if (this.mRestoreEnabled && isSpenBoundFileNotFoundException(th) && UUIDUtils.isCoeditUuid(uuid)) {
            composerModel.getMdeManager().deleteCoeditNoteDataAndDownload(this.mSubManager.getComposerLifeState().getActivity(), composerModel.getMdeInfo().getSpaceId(), uuid);
            this.mComposerCloser.finish("E_BOUND_FILE_NOT_FOUND in coeditNote");
            return true;
        }
        composerModel.getEntityManager().setCorruptedState(uuid);
        if ((th instanceof SpenUnsupportedVersionException) || "E_UNSUPPORTED_VERSION".equals(th.getMessage())) {
            ToastHandler.show(activity.getApplicationContext(), C9086R.string.unsupported_format_note, 1);
            if (!SyncState.isAppUpdateNeeded(activity)) {
                SyncState.setAppUpdateNeeded(activity, true);
            }
            finishComposer(z);
            return true;
        }
        if (isSpenBoundFileNotFoundException(th)) {
            if (this.mRestoreEnabled && !composerModel.getMdeInfo().isMde() && !composerModel.isRecoveredOnCorrupted()) {
                restoreNoteSaveFailed(activity, composerModel);
                return true;
            }
        } else if (isSpenInvalidCacheException(th) && this.mRestoreEnabled && !composerModel.getMdeInfo().isMde() && !composerModel.isRecoveredOnCorrupted()) {
            restoreNote(activity, composerModel);
            return true;
        }
        return false;
    }

    private void executeFinishComposerBySyncForDeletedFromServer(@NonNull Activity activity) {
        activity.runOnUiThread(new RunnableC9844c(this, activity, 9));
    }

    private void initMdeInfo(NotesDocument<SpenWordDocument> notesDocument) {
        int i;
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        NotesDocumentEntity notesDocumentEntity = composerModel.getNotesDocEntityManager().getNotesDocumentRepository().get(notesDocument.getUuid());
        if (notesDocumentEntity == null) {
            Logger.m11004w(TAG, "initMdeInfo# entity is null");
            return;
        }
        boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(notesDocument.getUuid());
        composerModel.getCoeditAdapter().setCoeditNote(zIsCoeditUuid);
        if (TextUtils.isEmpty(notesDocumentEntity.getMdeOwnerId())) {
            i = 0;
        } else {
            composerModel.getMdeManager().initMdeInfoResolver(zIsCoeditUuid);
            i = composerModel.getMdeManager().isCreator(notesDocumentEntity.getMdeOwnerId()) ? 1 : 2;
        }
        composerModel.getMdeInfo().setData(notesDocumentEntity.getMdeSpaceId(), notesDocumentEntity.getMdeGroupId(), notesDocumentEntity.getMdeOwnerId(), i);
    }

    private void initStateToChangeDoc(NotesDocument<SpenWordDocument> notesDocument, boolean z) {
        if (z && this.mSubManager.getComposerModel().getDoc() != null) {
            this.mSubManager.getCompViewPresenter().getPageManager().clearData(this.mSubManager.getComposerModel().getDoc());
        }
        this.mSubManager.getComposerLifeState().setSavedInstanceState(null);
        this.mSubManager.getComposerLifeState().setChangingDocState(true);
        this.mSubManager.getComposerModel().setDocInfo(new DocInfo(DocInfo.OpenType.Open, notesDocument.getPath(), notesDocument.getUuid()));
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11004w(TAG, "initStateToChangeDoc# activity is null");
            return;
        }
        activity.getIntent().putExtra("new_doc", false);
        boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(notesDocument.getUuid());
        this.mSubManager.getCompViewPresenter().getPageManager().setCacheDirPath(PageCacheUtils.getCacheDirectory(activity, notesDocument.getUuid(), this.mSubManager.getOpenPageWidth(zIsCoeditUuid)), PageCacheUtils.createPageThumbnailCacheDirectory(activity, notesDocument.getUuid(), this.mSubManager.getOpenPageWidth(zIsCoeditUuid)));
    }

    private boolean isSpenBoundFileNotFoundException(Throwable th) {
        return (th instanceof SpenBoundFileNotFoundException) || "E_BOUND_FILE_NOT_FOUND".equals(th.getMessage());
    }

    private boolean isSpenInvalidCacheException(Throwable th) {
        return (th instanceof SpenInvalidCacheException) || "E_INVALID_CACHE".equals(th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeNote$2(NotesDocument notesDocument) {
        this.mContract.attachLoadedDoc(notesDocument);
        clearStateForChangeDoc(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeFinishComposerBySyncForDeletedFromServer$6(Activity activity) {
        this.mSubManager.getControllerManager().getProgressController().hideProgressToCancelOfChangingConflictNote();
        if (CommonUtil.isAvailableActivity(activity)) {
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.note_already_deleted), 1);
        }
        this.mSubManager.getComposerModel().setUpToFinishWithoutSave();
        this.mSubManager.getMenuPresenterManager().finish("executeFinishComposerBySyncForDeletedFromServer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onChangedDoc$1(boolean z, NotesDocument notesDocument, boolean z2) {
        if (z) {
            initStateToChangeDoc(notesDocument, true);
            initMdeInfo(notesDocument);
            this.mContract.setUuidToHandoffSender();
            this.mSubManager.getComposerModel().getLastPenInfoOnlyOnce();
        }
        if (z2) {
            if (this.mChangingNoteWorkingState != null) {
                Logger.m10999d(TAG, "onChangedDoc, newNoteWorkingState: " + this.mChangingNoteWorkingState);
                this.mSubManager.getComposerModel().getComposerSaveModel().setDocServiceWorkingState(this.mChangingNoteWorkingState);
            }
            this.mSubManager.getComposerModel().changeDocState((LifecycleOwner) this.mContract.getView(), notesDocument);
            updateUuidData();
        } else {
            Logger.m10999d(TAG, "onChangedDoc# same docState");
        }
        if (z) {
            this.mContract.getView().showComposerCover();
        } else {
            Logger.m10999d(TAG, "onChangedDoc# same doc");
            clearStateForChangeDoc(false, false);
        }
        clearChangingInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReadyReload$3(Runnable runnable) {
        Logger.m11003i(TAG, "reloadPendingJobWrapper#");
        readyReload(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReloadedDocument$5(NotesDocument notesDocument) {
        this.mContract.attachLoadedDoc(notesDocument);
        this.mSubManager.getMenuPresenterManager().getVoiceRecordMenuPresenter().reloadVoiceMenu();
        this.mSubManager.getControllerManager().getProgressController().hideProgress(3, true);
        this.mSubManager.getControllerManager().getQuickSaveTimer().reset("reload");
        this.mContract.getView().removeCaptureComposerView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readyReload$4(Runnable runnable) {
        this.mContract.getView().releaseComposerView(null);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreNoteSaveFailed$0(ComposerModel composerModel, String str, String str2, Activity activity) {
        C99552 c99552;
        RestoreSaveFailedNote restoreSaveFailedNote;
        C99552 c995522 = new C99552(composerModel, str, str2, activity);
        try {
            restoreSaveFailedNote = new RestoreSaveFailedNote(activity.getApplicationContext(), str, str2, 1000, c995522);
            c99552 = c995522;
        } catch (Exception unused) {
            c99552 = c995522;
        }
        try {
            restoreSaveFailedNote.setDiscardSnapSavedData(true).setCreateThumbnail(true).setIsPdfReader(composerModel.isPDFReader()).call();
        } catch (Exception unused2) {
            Logger.m11000e(TAG, "fail to call RestoreSaveFailedNote");
            c99552.onPostRestore(false);
        }
    }

    private void notifyInvalidDocInfo() {
        Logger.m11000e(TAG, "notifyInvalidDocInfo");
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (CommonUtil.isAvailableActivity(activity)) {
            ToastHandler.show(activity, C9086R.string.unable_to_open_note, 1);
        }
        this.mComposerCloser.finish("notifyInvalidDocInfo");
    }

    private void printLoadDocCompleted(Activity activity, String str) {
        Logger.m11002f(TAG, "onLoadDocCompleted. action: " + activity.getIntent().getAction() + ", isNew: " + activity.getIntent().getBooleanExtra("new_doc", false) + ", changeDoc: " + this.mSubManager.getComposerLifeState().isChangingDoc() + this.mSubManager.getComposerModel().getState(false) + ", wind:" + WindowManagerCompat.getInstance().getMultiWindowMode(activity) + ", NHeap: " + Logger.getNativeHeapAllocatedSize() + " MB, night: " + ContextUtils.isNightMode(activity) + str);
    }

    private void readyReload(Runnable runnable) {
        int i;
        if (this.mSubManager.getControllerManager().getSoftInputManager().isInputMethodShown() || this.mSubManager.getMenuPresenterManager().getListPresenter().isShowing()) {
            Logger.m11003i(TAG, "readyReload# delay");
            i = 500;
        } else {
            i = 0;
        }
        readyReload();
        this.mSubManager.getCompViewPresenter().getView().postDelayed(new RunnableC9958b(this, runnable, 0), i);
    }

    private void restoreNoteSaveFailed(Activity activity, ComposerModel composerModel) {
        String uuid = composerModel.getDocInfo().getUuid();
        String docPath = composerModel.getDocInfo().getDocPath();
        Executors.newSingleThreadExecutor(new SenlThreadFactory(AbstractC0622a.m1170p(TAG, "_restore", new StringBuilder()))).execute(new RunnableC4054d(this, composerModel, uuid, docPath, activity));
    }

    private void updateUuidData() {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11004w(TAG, "updateUuidData# activity is null");
        } else {
            activity.getIntent().putExtra("sdoc_uuid", this.mSubManager.getComposerModel().getDocState().getUuid());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.Contract
    public void attachLoadedDoc(Activity activity, NotesDocument<SpenWordDocument> notesDocument) {
        this.mContract.attachLoadedDoc(notesDocument);
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        Pair<String, Boolean> pairUpdateCorruptedState = composerModel.getEntityManager().updateCorruptedState(composerModel.getDocInfo().getUuid());
        if (((Boolean) pairUpdateCorruptedState.second).booleanValue()) {
            ToastHandler.show(activity, C9086R.string.too_many_pen_strokes, 1);
        }
        printLoadDocCompleted(activity, (String) pairUpdateCorruptedState.first);
        Logger.midTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "onLoadDocCompleted# end");
    }

    public boolean checkFailToLoad(NotesDocument<SpenWordDocument> notesDocument, Activity activity) {
        if (notesDocument != null && notesDocument.getDoc() != null) {
            return false;
        }
        ToastHandler.show(activity, "Fail to load the document.", 1);
        Logger.m11002f(TAG, "onLoadDocCompleted# Fail to load the document.");
        this.mComposerCloser.finish("checkFailToLoad");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void clearChangingInfo() {
        this.mChangingUuid = null;
        this.mChangingNoteWorkingState = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.Contract
    public void clearStateForChangeDoc(boolean z, boolean z2) {
        if (z) {
            this.mContract.closeOldDoc();
        } else if (z2) {
            this.mContract.resetOldNote();
        }
        this.mSubManager.getControllerManager().getProgressController().hideProgress(3, true);
        this.mSubManager.getControllerManager().getProgressController().hideProgress(1, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.Contract
    public void connectCoeditService(boolean z) {
        this.mContract.connectCoeditService(z);
    }

    public DocInfo createByIntent(Activity activity) {
        return new FactoryDocInfo().createByIntent(activity);
    }

    public void doPendingReload() {
        Runnable runnable = this.mPendingReload;
        if (runnable != null) {
            onReadyReload(runnable);
            this.mPendingReload = null;
        }
    }

    public void finishComposer(boolean z) {
        if (z) {
            this.mSubManager.getControllerManager().getProgressController().hideProgress(3, true);
        } else {
            this.mComposerCloser.finish("failed to load doc. doc is null or already closed.");
        }
    }

    public DocInfo getDocInfo() {
        DocInfo docInfo = this.mSubManager.getComposerModel().getDocInfo(this.mSubManager.getComposerLifeState().getSavedInstanceState());
        if (docInfo != null) {
            return docInfo;
        }
        DocInfo docInfoCreateByIntent = createByIntent(this.mSubManager.getComposerLifeState().getActivity());
        this.mSubManager.getComposerModel().setDocInfo(docInfoCreateByIntent);
        return docInfoCreateByIntent;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public OpenParam getOpenParam(boolean z) {
        SpenWNote.Orientation orientation;
        OpenParam.Builder builder = new OpenParam.Builder();
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11004w(TAG, "getOpenParam# activity is null");
            return builder.done();
        }
        Intent intent = activity.getIntent();
        int pageType = getPageType(intent);
        if (intent.hasExtra(SettingsConstants.SETTINGS_PAGE_SIZE)) {
            DocumentPageRatio.PageRatioType pageRatioTypeConvertFromSettings = DocumentPageRatio.convertFromSettings(intent.getIntExtra(SettingsConstants.SETTINGS_PAGE_SIZE, 0));
            orientation = pageRatioTypeConvertFromSettings == DocumentPageRatio.PageRatioType.A4_LANDSCAPE ? SpenWNote.Orientation.LANDSCAPE_NEW : SpenWNote.Orientation.PORTRAIT;
            Logger.m11003i(TAG, "getOpenParam with template: " + pageRatioTypeConvertFromSettings);
        } else {
            orientation = getOrientation();
        }
        SpenWNote.Orientation orientation2 = SpenWNote.Orientation.LANDSCAPE_NEW;
        if (orientation == orientation2) {
            if (this.mSubManager.getComposerModel().getMdeInfo().isMde()) {
                orientation = SpenWNote.Orientation.PORTRAIT;
                intent.putExtra(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
                intent.putExtra(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
                intent.putExtra(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
            } else if (pageType == 0) {
                orientation = SpenWNote.Orientation.PORTRAIT;
            }
        }
        int openPageWidth = this.mSubManager.getOpenPageWidth(z);
        return builder.setLockAccountGuid(intent.getStringExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID)).setPageWidth(openPageWidth).setPageHeight((int) (orientation == orientation2 ? openPageWidth / 1.4142857f : openPageWidth * 1.4142857f)).setPageType(pageType).setOrientation(orientation).done();
    }

    public SpenWNote.Orientation getOrientation() {
        return 2 == SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0) ? SpenWNote.Orientation.LANDSCAPE_NEW : SpenWNote.Orientation.PORTRAIT;
    }

    public int getPageType(Intent intent) {
        if (this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote()) {
            return 1;
        }
        return intent.getIntExtra(ComposerConstants.ARG_PAGE_TYPE, new DocumentStyleRepository().getPageStyle());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public String getUuid() {
        if (this.mSubManager.getComposerModel().getDocInfo() != null) {
            return this.mSubManager.getComposerModel().getDocInfo().getUuid();
        }
        Logger.m11000e(TAG, "getUuid# doc info null");
        return "";
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.Contract
    public ComposerSubContract.IView getView() {
        return this.mContract.getView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public boolean isAttachedToActivity() {
        return CommonUtil.isAvailableActivity(this.mSubManager.getComposerLifeState().getActivity());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public boolean isInProgressNoteChange() {
        return this.mChangingUuid != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public boolean needToConflictSyncForComposerEdit(String str) {
        if (this.mSubManager.getComposerModel() != null) {
            return this.mSubManager.getComposerModel().needToConflictSyncForComposerEdit(str);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public boolean needToPendingSyncForComposerBusy(String str) {
        if (this.mSubManager.getComposerModel() != null) {
            return this.mSubManager.getComposerModel().needToPendingSyncForComposerBusy(str);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onChangedDoc(NotesDocument<SpenWordDocument> notesDocument) {
        NotesDocument<SpenWordDocument> docState = this.mSubManager.getComposerModel().getDocState();
        boolean z = true;
        boolean z2 = docState == null || !docState.equals(notesDocument);
        if (!z2 || (docState != null && docState.getDoc() == notesDocument.getDoc())) {
            z = false;
        }
        RunnableC8501g runnableC8501g = new RunnableC8501g(this, z, notesDocument, z2);
        if (z && UUIDUtils.isCoeditUuid(notesDocument.getUuid())) {
            new CoeditStarter(this.mSubManager, this.mComposerCloser, this).startCoeditWithChangedNote(notesDocument, runnableC8501g);
        } else {
            changeNote(notesDocument, z, runnableC8501g);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onChangedWorkingState(@NonNull String str, SchedulerDataSource.WorkingState workingState, DocumentSubscriptionId documentSubscriptionId) {
        if (this.mSubManager.getComposerModel().getDocInfo() == null) {
            Logger.m11000e(TAG, "onChangedWorkingState docInfo is null");
        } else if (str.equals(getUuid())) {
            this.mSubManager.getComposerModel().getComposerSaveModel().setDocServiceWorkingState(workingState);
        } else if (str.equals(this.mChangingUuid)) {
            this.mChangingNoteWorkingState = workingState;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onLoadDocCompleted(NotesDocument<SpenWordDocument> notesDocument) {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11004w(TAG, "onLoadDocCompleted# activity is null");
            return;
        }
        Logger.midTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "onLoadDocCompleted# start");
        if (checkFailToLoad(notesDocument, activity)) {
            return;
        }
        if (this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote() && new CoeditStarter(this.mSubManager, this.mComposerCloser, this).startCoedit(activity, notesDocument)) {
            return;
        }
        attachLoadedDoc(activity, notesDocument);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onLoadDocFailed(Throwable th, boolean z) {
        Logger.m11002f(TAG, "onLoadDocFailed# failed to load doc " + th);
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (controlDocServiceException(th, activity) || controlSpenDocException(th, z, activity)) {
            return;
        }
        ToastHandler.show(activity, C9086R.string.unable_to_open_note, 1);
        finishComposer(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onReadyReload(Runnable runnable) {
        if (this.mSubManager.getComposerModel().isReloading()) {
            Logger.m11000e(TAG, "Composer is already reloading");
            return;
        }
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (this.mSubManager.getComposerModel().getDocState() == null || (activity != null && activity.isFinishing())) {
            Logger.m11004w(TAG, "onReadyReload# model or docState is null");
            if (this.mSubManager.getComposerLifeState().isInitialized()) {
                this.mPendingReload = runnable;
                return;
            }
            return;
        }
        if (this.mSubManager.getControllerManager().getTaskController().isAvailableToReload()) {
            readyReload(runnable);
        } else {
            this.mSubManager.getControllerManager().getTaskController().addPendingJob(new RunnableC9958b(this, runnable, 1), 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11000e(TAG, "activity is null");
            return;
        }
        if (this.mSubManager.getComposerModel().getDocInfo().getUuid().equals(intent.getStringExtra("sdocx_uuid"))) {
            int intExtra = intent.getIntExtra(SyncDocumentState.DOCUMENT_STATE_TYPE, -1);
            Logger.m11004w(TAG, "onReceiveBroadcastMessage : documentStateType = " + intExtra);
            if (intExtra == 1) {
                this.mSubManager.getMenuPresenterManager().executeSyncConflictInvalidVersionType();
            } else if (intExtra == 2) {
                executeFinishComposerBySyncForDeletedFromServer(activity);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onReloadedDocument(NotesDocument<SpenWordDocument> notesDocument) {
        this.mSubManager.getComposerModel().getComposerSaveModel().setBlockedSave(false);
        this.mSubManager.getComposerModel().getNotesDocEntityManager().setOnRemovedListener(null);
        if (notesDocument == null) {
            this.mSubManager.getDialogPresenterManager().hideSyncWaitingProgressDialog();
            this.mSubManager.getControllerManager().getProgressController().hideProgress(3, true);
            this.mSubManager.getControllerManager().getQuickSaveTimer().reset("reload");
            return;
        }
        String str = TAG;
        Logger.m11002f(str, "onReloadedDocument");
        if (notesDocument.getDocumentEntityContainer().getEntity().getIsDeleted() != 2) {
            initStateToChangeDoc(notesDocument, false);
            this.mSubManager.getComposerModel().setDocState(notesDocument);
            updateUuidData();
            this.mSubManager.getCompViewPresenter().getView().post(new RunnableC9959c(this, notesDocument, 0));
            return;
        }
        Logger.m11000e(str, "onReloadedDocument# deleted note finish");
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity != null) {
            ToastHandler.show(activity, activity.getString(C9086R.string.composer_sync_delete_note), 1);
        }
        ((SpenWordDocument) notesDocument.getDoc()).clearChangedFlag();
        this.mSubManager.getComposerModel().setUpToFinishWithoutSave();
        this.mComposerCloser.finish("onReloadedDocument# deleted note finish");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onServiceConnected() {
        if (CommonUtil.isNotAvailableActivity(this.mSubManager.getComposerLifeState().getActivity())) {
            Logger.m11000e(TAG, "onServiceConnected# activity is invalid");
            return;
        }
        DocInfo docInfo = getDocInfo();
        if (docInfo == null || docInfo.isInvalid() || TextUtils.isEmpty(docInfo.getUuid())) {
            notifyInvalidDocInfo();
        } else {
            this.mContract.openDocument(docInfo.getUuid(), docInfo.getDocPath());
        }
    }

    public void restoreNote(Activity activity, ComposerModel composerModel) {
        new RestoreNote(composerModel, new C99541(activity)).runRestoreNoteOnThread(activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void setChangingUuid(String str) {
        this.mChangingUuid = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void showDebugMessageToast(String str) {
        Activity activity;
        if (DeveloperMode.isOnDeveloperMode() && Looper.getMainLooper().getThread() == Thread.currentThread() && (activity = this.mSubManager.getComposerLifeState().getActivity()) != null) {
            Context applicationContext = activity.getApplicationContext();
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(MemoryLogger.getTotalPss());
            sbM1324q.append("MB");
            Toast.makeText(applicationContext, sbM1324q.toString(), 0).show();
        }
    }

    private void readyReload() {
        Logger.m11003i(TAG, "onReadyReload#");
        this.mSubManager.getComposerModel().setReloadingState(true);
        this.mSubManager.getComposerModel().setIsInitLayoutFinishedOneSecond(false);
        this.mSubManager.getCompViewPresenter().getHandoffManager().disableHandoffTemporary();
        if (!this.mSubManager.getDialogPresenterManager().isShowingSyncWaitingProgressDialog()) {
            this.mSubManager.getControllerManager().getProgressController().showProgress(0, 3);
        }
        this.mSubManager.getControllerManager().getSoftInputManager().hide((View) null);
        this.mSubManager.getMenuPresenterManager().onReadyReload();
        this.mSubManager.getCompViewPresenter().getPageManager().clearData(this.mSubManager.getComposerModel().getDoc());
        this.mSubManager.getControllerManager().getQuickSaveTimer().pause("reload");
        this.mSubManager.getComposerModel().getVoiceModel().stopPlaying();
        this.mSubManager.getCompViewPresenter().getThumbnailUpdateHandler().setBlockToUpdate(true, true);
        this.mSubManager.getMenuPresenterManager().hideStickyMemo(null, true);
        this.mSubManager.getMenuPresenterManager().invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.Contract
    public void attachLoadedDoc(NotesDocument<SpenWordDocument> notesDocument) {
        this.mContract.attachLoadedDoc(notesDocument);
    }
}
