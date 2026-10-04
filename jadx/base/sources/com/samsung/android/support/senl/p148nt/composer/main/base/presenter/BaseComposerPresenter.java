package com.samsung.android.support.senl.p148nt.composer.main.base.presenter;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.ScreenLockUtil;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffSendManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.CompContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.AppWidgetThumbnailTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CoeditServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.DocumentServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BixbyContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerCloser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerMemoryTrimmer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerModelContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ExternalListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.InitializationLoadingProgress;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.Initializer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.LiveSharingTasker;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.Iterator;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseComposerPresenter implements MenuPresenterContract.IMenuParent, ComposerViewPresenter.OnInitFinishedListener, CompContract.IPresenter, DialogContract.IParent {
    private static final String TAG = Logger.createTag("BaseComposerPresenter");
    private ActivityResult mActivityResult;
    private CoeditServiceManager mCoeditServiceManager;
    private final ComponentFactory mComponentFactory;
    protected ComposerCloser mComposerCloser;
    private ComposerMemoryTrimmer mComposerMemoryTrimmer;
    private ComposerModelContractImpl mComposerModelContractImpl;
    private ComposerResolver mComposerResolver;
    private DocumentServiceManager mDMServiceManager;
    private DialogContract.IDialogCreator mDialogCreator;
    private ExternalListenerManager mExternalListenerManager;
    private FoldStateCompat.FoldStateChangeListener mFoldStateListener;
    private final InitializationLoadingProgress mInitializationLoadingProgress;
    private final LiveSharingTasker mLiveSharingTasker;
    private MenuAttachManager mMenuAttachManager;
    protected ServiceContractImpl mServiceContractImpl;
    protected BaseSubManager mSubManager;
    protected String mUuidPostfix = "";
    protected CompContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends BaseSubManager.ComponentFactory, ControllerManager.ComponentFactory {
        @NonNull
        CustomSaveStrategy createCustomSaveStrategy();

        @NonNull
        DialogContract.IDialogCreator createDialogCreator();

        @NonNull
        MenuAttachManager createMenuAttachManager(BaseSubManager baseSubManager);
    }

    public BaseComposerPresenter(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
        this.mSubManager = new BaseSubManager(componentFactory);
        this.mLiveSharingTasker = new LiveSharingTasker(this.mSubManager);
        this.mInitializationLoadingProgress = new InitializationLoadingProgress(this.mSubManager);
    }

    private boolean canDelayActivityResult(int i) {
        if (this.mActivityResult == null) {
            return true;
        }
        Logger.m11000e(TAG, "onActivityResult# mActivityResult skip " + this.mActivityResult.getRequestCode() + " / " + i);
        return false;
    }

    private void checkIfNeedToRemoveDocInfo(boolean z) {
        if (z && this.mSubManager.getComposerModel().getDocInfo() != null) {
            Logger.m11002f(TAG, "checkIfNeedToRemoveDocInfo");
            this.mSubManager.getComposerModel().setDocInfo(null);
        }
    }

    private void clearChangedFlag() {
        SpenWNote doc;
        if (!this.mSubManager.getComposerLifeState().isNotRecreated() || this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote() || (doc = this.mSubManager.getComposerModel().getDoc()) == null) {
            return;
        }
        doc.clearChangedFlag();
    }

    private void connectService(Activity activity) {
        Logger.midTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "connectService# start");
        String stringExtra = activity.getIntent().getStringExtra("sdoc_uuid");
        if (this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote()) {
            this.mCoeditServiceManager.connect(activity, stringExtra);
        }
        this.mDMServiceManager.connect(activity);
    }

    private ComposerResolver.Contract createComposerResolverContract() {
        return new ComposerResolver.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerResolver.Contract
            public void callOnBackPressed() {
                BaseComposerPresenter.this.mView.callOnBackPressed();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerResolver.Contract
            public DocInfo getDocInfo() {
                return BaseComposerPresenter.this.mServiceContractImpl.getDocInfo();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerResolver.Contract
            public void setShouldCallRequestSyncFirst(boolean z) {
                BaseComposerPresenter.this.mComposerModelContractImpl.setShouldCallRequestSyncFirst(z);
            }
        };
    }

    private ServiceContractImpl.Contract createServiceContract() {
        return new ServiceContractImpl.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void attachLoadedDoc(NotesDocument<SpenWordDocument> notesDocument) {
                BaseComposerPresenter.this.attachLoadedDoc(notesDocument);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void closeOldDoc() {
                BaseComposerPresenter.this.mDMServiceManager.closeOldDoc();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void connectCoeditService(boolean z) {
                if (z) {
                    BaseComposerPresenter.this.mCoeditServiceManager.connect(BaseComposerPresenter.this.mSubManager.getComposerLifeState().getActivity(), BaseComposerPresenter.this.mSubManager.getComposerModel().getDocState().getUuid());
                } else {
                    BaseComposerPresenter.this.mCoeditServiceManager.disconnect(BaseComposerPresenter.this.mSubManager.getComposerLifeState().getActivity());
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void openDocument(String str, String str2) {
                BaseComposerPresenter.this.mDMServiceManager.openDocument(str, str2);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void resetOldNote() {
                BaseComposerPresenter.this.mDMServiceManager.resetOldNote();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public void setUuidToHandoffSender() {
                BaseComposerPresenter.this.setUuidToHandoffSender(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ServiceContractImpl.Contract
            public CompContract.IView getView() {
                return BaseComposerPresenter.this.mView;
            }
        };
    }

    private void destroyComposerViewPresenter(Activity activity, boolean z, boolean z2) {
        float zoomRatio;
        boolean zIsScrollVertical;
        int pageLayoutColumn;
        if (this.mSubManager.getCompViewPresenter() == null) {
            return;
        }
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        this.mSubManager.restoreTempBrushData();
        this.mSubManager.getMenuPresenterManager().onDestroy(z2, activity);
        this.mSubManager.getControllerManager().onDestroy();
        this.mSubManager.getCompViewPresenter().requestReadyForSave();
        if (this.mSubManager.getCompViewPresenter().getPageManager() == null || this.mSubManager.getCompViewPresenter().getPageManager().getDocPageInfo() == null) {
            zoomRatio = 1.0f;
            zIsScrollVertical = true;
            pageLayoutColumn = 1;
        } else {
            zoomRatio = this.mSubManager.getCompViewPresenter().getPageManager().getDocPageInfo().getZoomRatio();
            zIsScrollVertical = this.mSubManager.getCompViewPresenter().getPageManager().getDocPageInfo().isScrollVertical();
            pageLayoutColumn = this.mSubManager.getCompViewPresenter().getPageManager().getDocPageInfo().getPageLayoutColumn();
        }
        this.mSubManager.getCompViewPresenter().onDestroy();
        if (this.mComposerCloser.getUuid() != null && composerModel.getDocState() != null && composerModel.getDocState().isContentEmpty()) {
            Logger.m11004w(TAG, "mComposerCloser. block closeDoc: ");
            z2 = false;
        }
        AppWidgetThumbnailTask appWidgetThumbnailTask = this.mSubManager.getMenuPresenterManager().getOptionMenuPresenter().getAppWidgetThumbnailTask();
        boolean z3 = composerModel.isChangedRealContent() && (appWidgetThumbnailTask == null || appWidgetThumbnailTask.isWidgetUpdate(composerModel));
        boolean z4 = z2 && composerModel.getDocState() != null && composerModel.getDocState().isSaveCache();
        composerModel.setWidgetUpdateSaveStrategy(z3 || z4);
        BOOLEAN r9 = new BOOLEAN(false);
        composerModel.onDestroy(z, r9);
        String str = TAG;
        Logger.printFileLog(str);
        Logger.m11002f(str, "onDestroy. changeDoc: " + this.mSubManager.getComposerLifeState().isChangingDoc() + composerModel.getState(true) + ", wind:" + WindowManagerCompat.getInstance().getMultiWindowMode(activity) + ", Dex:" + DesktopModeCompat.INSTANCE.getInstance().isDexMode(activity));
        if (composerModel.insertSALogForDocument()) {
            ComposerSA.insertLog((String) null, "9994", ComposerSA.getDetailDeviceRatio(activity, zoomRatio));
            ComposerSA.insertLog("233", ComposerSAConstants.EVENT_SAVED_NOTE_STYLE_AND_SCROLL, composerModel.getComposerSpenDocModel().getDetailNoteStyleAndScrollType(zIsScrollVertical, pageLayoutColumn));
        }
        this.mComposerModelContractImpl.onDestroy();
        if ((r9.isTrue() && z3) || z4) {
            AppWidgetThumbnailTask.makeTask(activity, composerModel, appWidgetThumbnailTask);
        }
        if (z2) {
            this.mDMServiceManager.closeDoc(composerModel.getDocState());
        }
    }

    private void doActivityResultWithPending() {
        if (this.mActivityResult == null) {
            return;
        }
        this.mMenuAttachManager.addMenuTask(new RunnableC9169a(this, 0));
    }

    private void doPendingRequestToVerifyScreenLock(@NonNull Activity activity) {
        if (activity.getIntent().getBooleanExtra(ComposerConstants.ARG_REQUEST_TO_VERIFY_SCREENLOCK, false)) {
            if (activity.getIntent().getBooleanExtra(ComposerConstants.ARG_REQUEST_TO_LOCKMANAGER, false)) {
                activity.getIntent().putExtra(ComposerConstants.ARG_REQUEST_TO_VERIFY_SCREENLOCK, false);
            } else if (this.mSubManager.getMenuPresenterManager().verifyScreenLock()) {
                ScreenLockUtil.coverWindow(activity);
                activity.getIntent().putExtra(ComposerConstants.ARG_REQUEST_TO_VERIFY_SCREENLOCK, false);
            }
        }
    }

    private void executeEntryAction(Activity activity) {
        EntryAction entryAction = new EntryAction();
        entryAction.initSpenOnlyMode(activity);
        entryAction.executeWidgetSendActionDrawing(activity, this.mSubManager.getComposerModel());
        setUuidToHandoffSender(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doActivityResultWithPending$3() {
        ActivityResult activityResult = this.mActivityResult;
        if (activityResult == null) {
            Logger.m11003i(TAG, "doActivityResultWithPending# run : mActivityResult is null");
        } else {
            onActivityResult(activityResult.getRequestCode(), this.mActivityResult.getResultCode(), this.mActivityResult.getData());
            this.mActivityResult = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(Activity activity, Bundle bundle) {
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            onActivityCreated(activity, bundle);
            return;
        }
        Logger.m11004w(TAG, "onActivityCreated#pending# activity is invalid " + activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$4() {
        ActivityResult activityResult = this.mActivityResult;
        if (activityResult == null) {
            Logger.m11003i(TAG, "isDoingCoeditWorkThread# run : mActivityResult is null");
        } else {
            onActivityResult(activityResult.getRequestCode(), this.mActivityResult.getResultCode(), this.mActivityResult.getData());
            this.mActivityResult = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$5() {
        if (this.mActivityResult == null) {
            return;
        }
        Logger.m11003i(TAG, "setResumePendingAction# run");
        onActivityResult(this.mActivityResult.getRequestCode(), this.mActivityResult.getResultCode(), this.mActivityResult.getData());
        this.mActivityResult = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPostInitFinished$2() {
        if (this.mSubManager.getComposerModel().getNotesDocEntityManager().isDeleted()) {
            Logger.m11004w(TAG, "onBackPressed# mActivity is null");
        } else {
            this.mSubManager.getMenuPresenterManager().hideStickyMemo(null, true);
            this.mSubManager.getDialogPresenterManager().showConfirmSyncConflictDialog();
        }
    }

    private void logTransactionTooLargeException(@NonNull Bundle bundle) {
        Logger.startTime(String.valueOf(hashCode()), TAG, "onSaveInstanceState : check size");
        Parcel parcelObtain = Parcel.obtain();
        bundle.writeToParcel(parcelObtain, 0);
        int length = parcelObtain.marshall().length / 1024;
        if (length > 100) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(SQLKeyword.COMMA);
            }
            Logger.m10999d(TAG, "onSaveInstanceState# size: " + length + "  key list: " + ((Object) sb));
        }
        parcelObtain.recycle();
        Logger.endTime(String.valueOf(hashCode()), TAG, "onSaveInstanceState : check size end");
    }

    private boolean needToControlHideNavigationBar() {
        if (this.mSubManager.getComposerModel() == null || !this.mSubManager.getComposerModel().getModeManager().isMode(Mode.Writing)) {
            return false;
        }
        if (this.mSubManager.getComposerModel().isSingleMode()) {
            return true;
        }
        if (this.mSubManager.getMenuPresenterManager() == null || this.mSubManager.getMenuPresenterManager().getListPresenter() == null || this.mSubManager.getMenuPresenterManager().getListPresenter().getPageListPresenter() == null) {
            return false;
        }
        if (this.mSubManager.getComposerModel().isPDFReader() && this.mSubManager.getMenuPresenterManager().getAiMenuManager().isShowingResultView()) {
            return false;
        }
        return !this.mSubManager.getMenuPresenterManager().getListPresenter().getPageListPresenter().isShownWithPhoneLayout();
    }

    private void onPostInitFinished(@NonNull Activity activity) {
        this.mSubManager.getDialogPresenterManager().showAutoRestoredNoteNotiDialog();
        this.mSubManager.getDialogPresenterManager().showTranslatedPDFGuideDialog();
        EntryAction.executeBixbyAction(this.mSubManager.getComposerLifeState().getActivity(), new BixbyContractImpl(this.mSubManager));
        this.mServiceContractImpl.doPendingReload();
        doPendingRequestToVerifyScreenLock(activity);
        this.mSubManager.getComposerModel().setObserverIsConflicted((LifecycleOwner) this.mView, new RunnableC9169a(this, 1));
        this.mSubManager.restoreTempBrushData();
        onStartMahHelper(activity);
        onStartTranslate(activity);
        onStartEditMode(activity);
    }

    private void onStartEditMode(@NonNull Activity activity) {
        if (this.mSubManager.getComposerModel().isPDFReader() && ComposerConstants.ACTION_EDIT_MODE.equals(activity.getIntent().getAction())) {
            this.mSubManager.getComposerModel().getModeManager().setMode(Mode.Writing, "onStartEditMode", true);
        }
    }

    private void onStartMahHelper(@NonNull Activity activity) {
        if (CategoryConstants.Math.UUID.equals(this.mSubManager.getComposerModel().getNotesDocEntityManager().getFolderUuid()) && activity.getIntent().getBooleanExtra("new_doc", false)) {
            this.mSubManager.getMenuPresenterManager().getAiMenuManager().getAiContextMenuPresenter().getSolveMathPresenter().setEnabledTemporarily(true);
        }
    }

    private void onStartTranslate(@NonNull Activity activity) {
        if (FeatureInfo.isOneTouchPdfTranslationOverlayEnabled() && this.mSubManager.getComposerModel().isPDFReader() && ComposerConstants.ACTION_TRANSLATE.equals(activity.getIntent().getAction())) {
            this.mSubManager.getMenuPresenterManager().getAiMenuManager().getAiContextMenuPresenter().executeTranslateDirectly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUuidToHandoffSender(boolean z) {
        Activity activity;
        if (this.mComponentFactory.getConfig().isHandOffEnabled() && HandoffUtils.getInstance().isHandoffFixedStateEnabled() && (activity = this.mSubManager.getComposerLifeState().getActivity()) != null) {
            ComposerModel composerModel = this.mSubManager.getComposerModel();
            if ((composerModel != null && composerModel.isUnsupportedHandoff()) || UUIDUtils.isGenUuid(activity.getIntent().getStringExtra("sdoc_uuid"))) {
                CoHandoffSendManager.getInstance().clear(activity.getIntent().getStringExtra("sdoc_uuid"));
                return;
            }
            Intent intent = activity.getIntent();
            if (!z) {
                CoHandoffSendManager.getInstance().clear(intent.getStringExtra("sdoc_uuid"));
                return;
            }
            CoHandoffSendManager.getInstance().setUuid(intent.getStringExtra("sdoc_uuid"), (composerModel == null || composerModel.getComposerSaveModel().isAutoSaveOptionEnabled()) ? false : true);
            if (this.mSubManager.getCompViewPresenter() != null) {
                this.mSubManager.getCompViewPresenter().getHandoffManager().sendHandoffData();
            }
        }
    }

    private void updateStateToHideNavigationBar(boolean z) {
        if (this.mSubManager.getComposerLifeState().getActivity() != null && z && needToControlHideNavigationBar() && NavigationBarUtil.hideNavigationBar(this.mSubManager.getComposerLifeState().getActivity())) {
            updateDisallowTouchDownArea(true);
        }
    }

    public void attachLoadedDoc(NotesDocument<SpenWordDocument> notesDocument) {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11000e(TAG, "attachLoadedDoc, activity is null");
            return;
        }
        this.mSubManager.getComposerModel().setDocState(notesDocument);
        if (!this.mSubManager.getComposerLifeState().isInitialized()) {
            this.mSubManager.initModel(activity, (LifecycleOwner) this.mView);
            this.mSubManager.createCompViewPresenter();
            this.mSubManager.getControllerManager().createController(this.mComponentFactory);
            this.mComposerModelContractImpl.setComposerViewPresenter(this.mSubManager.getCompViewPresenter());
        } else if (this.mSubManager.getComposerLifeState().isChangingDoc()) {
            this.mSubManager.initModel(activity, (LifecycleOwner) this.mView);
        }
        this.mSubManager.restoreEntity();
        Logger.midTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "attachComposerView# start");
        this.mView.attachComposerView(this.mSubManager.getCompViewPresenter(), this.mSubManager.getComposerLifeState().isChangingDoc());
        Logger.midTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "initComposerViewPresenter# start");
        this.mSubManager.initComposerViewPresenter(this);
    }

    public void blockToHideSip(boolean z) {
        this.mSubManager.getControllerManager().getSoftInputManager().blockToHide(z);
    }

    public boolean canChangeLayout() {
        if (this.mSubManager.getComposerModel() == null || !this.mSubManager.getComposerModel().getMdeManager().isReopening()) {
            return true;
        }
        Logger.m11003i(TAG, "canChangeLayout# layout can't change during reopen");
        return false;
    }

    public boolean canWorkingDocument() {
        if (this.mSubManager.getComposerModel() == null || this.mSubManager.getComposerModel().getDocState() == null || !this.mSubManager.getComposerModel().getComposerSaveModel().isReloadingWorkingState()) {
            return true;
        }
        Logger.m11004w(TAG, "canWorkingDocument# isReloadingSate is true");
        return false;
    }

    public void changeNote(String str, String str2, boolean z) {
        if (z) {
            this.mSubManager.getComposerModel().saveAsync(true, true);
        }
        if (this.mDMServiceManager.changeDocument(str, str2) && z) {
            this.mSubManager.getControllerManager().getProgressController().showProgress(0, 3);
        }
    }

    public ServiceContractImpl createServiceContractImpl(ServiceContractImpl.Contract contract) {
        return new ServiceContractImpl(this.mSubManager, this.mComposerCloser, contract);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mSubManager.getControllerManager() != null && this.mSubManager.getControllerManager().getProgressController() != null && this.mSubManager.getControllerManager().getProgressController().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if ((keyEvent.getFlags() & 33554432) == 0) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            return onBLEShortcut(keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (this.mSubManager.getMenuPresenterManager() != null) {
            return this.mSubManager.getMenuPresenterManager().dispatchKeyEventPreIme(keyEvent);
        }
        return false;
    }

    public void displayProgressForInitialization() {
        this.mInitializationLoadingProgress.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuParent, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IParent
    public boolean finish(String str) {
        this.mComposerCloser.finish(str);
        return true;
    }

    public ComposerManager.IComposerResolver getComposerResolver() {
        return this.mComposerResolver;
    }

    public ContextMenuManager getContextMenuManager() {
        return this.mSubManager.getMenuPresenterManager().getContextMenuManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.CompContract.IPresenter
    public DialogContract.IFragmentPresenter getDialogFragmentPresenter(int i) {
        return this.mSubManager.getDialogPresenterManager().getDialogFragmentPresenter(i);
    }

    public KeyboardShortcutGroup getKeyboardShortcutGroup() {
        if (this.mSubManager.getMenuPresenterManager() == null || this.mSubManager.getMenuPresenterManager().getShortCutManager() == null) {
            return null;
        }
        return this.mSubManager.getMenuPresenterManager().getShortCutManager().getKeyboardShortcutGroup(this.mSubManager.getComposerLifeState().getActivity(), this.mSubManager.getComposerModel());
    }

    public OptionMenuPresenter getOptionMenuPresenter() {
        return this.mSubManager.getMenuPresenterManager().getOptionMenuPresenter();
    }

    public void initBackgroundColor() {
        this.mSubManager.getMenuPresenterManager().getTitleEditorPresenter().setBackgroundColor();
        this.mSubManager.getCompViewPresenter().setPageBackgroundColor(this.mSubManager.getCompViewPresenter().isComposerViewDarkTheme());
    }

    public boolean isChangedTabletLayout(boolean z) {
        if (this.mSubManager.getComposerModel() == null || this.mSubManager.getComposerModel().isTabletLayout() == z) {
            return false;
        }
        this.mSubManager.getComposerModel().setTabletLayout(z);
        Logger.m11003i(TAG, "isChangedTabletLayout# layout has changed to ".concat(z ? "Tablet" : "Phone"));
        return true;
    }

    public boolean isFullScreenMode() {
        if (this.mSubManager.getComposerModel() != null) {
            return this.mSubManager.getComposerModel().getComposerState().isFullScreenMode();
        }
        Logger.m11004w(TAG, "isFullScreenMode# ComposerModel is null");
        return false;
    }

    public boolean isLockVerified() {
        if (this.mSubManager.getMenuPresenterManager() != null) {
            return this.mSubManager.getMenuPresenterManager().isLockVerified();
        }
        return false;
    }

    public boolean isValidDocState() {
        if (this.mSubManager.getComposerModel() != null && this.mSubManager.getComposerModel().getDocState() != null) {
            return true;
        }
        Logger.m11004w(TAG, "isValidDocState# DocState is null");
        return false;
    }

    public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("onActivityCreated# ");
        sb.append(activity);
        sb.append(" : hasSavedInstance = ");
        sb.append(bundle != null);
        Logger.m10999d(str, sb.toString());
        setActivity(activity);
        if (!this.mSubManager.getComposerLifeState().isInitialized()) {
            checkIfNeedToRemoveDocInfo(setDocumentUuid(activity, bundle));
            if (!ComposerManager.getInstance().closeComposer(this.mSubManager.getComposerLifeState().getFragment(), activity.getIntent().getStringExtra("sdoc_uuid"), new RunnableC8928b(this, 7, activity, bundle))) {
                Logger.m10999d(str, "onActivityCreated# return " + activity);
                return;
            }
            executeEntryAction(activity);
        }
        this.mSubManager.getComposerModel().setTabletLayout(ResourceUtils.isTabletLayout(activity));
        this.mSubManager.getComposerLifeState().setSavedInstanceState(bundle);
        this.mSubManager.getComposerLifeState().setInitLayoutFinished(false);
        this.mSubManager.getControllerManager().onActivityCreated(activity);
        this.mExternalListenerManager.onActivityCreated(activity);
        this.mSubManager.getMenuPresenterManager().getQuickNotePresenter().onActivityCreated(activity, (Fragment) this.mView, this.mExternalListenerManager);
        this.mSubManager.getMenuPresenterManager().getInAppCollaborationPresenter().onActivityCreated(activity, (Fragment) this.mView, bundle);
        if (this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote() && SettingsCompat.getInstance().isUPSM(activity)) {
            ToastHandler.show(activity, C9086R.string.composer_open_fail_error_message_in_upsm, 1);
            this.mComposerCloser.finish("isUPSM");
            return;
        }
        if ((this.mSubManager.getComposerModel().isPDFReader() || Features.isSupportSimpleComposerForCoverDisplay()) && ComposerConstants.ACTION_SIMPLE_MODE.equals(activity.getIntent().getAction())) {
            this.mSubManager.getComposerModel().setSimpleModeState(2);
            if (Features.isSupportSimpleComposerForCoverDisplay()) {
                this.mFoldStateListener = new FoldStateCompat.FoldStateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.3
                    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener
                    public void onChanged(boolean z) {
                        AbstractC8014b.m7220v("FoldStateChangeListener#onChanged ", BaseComposerPresenter.TAG, z);
                        if (z || BaseComposerPresenter.this.mFoldStateListener == null) {
                            return;
                        }
                        FoldStateCompat.INSTANCE.getInstance().unregisterFoldStateListener(BaseComposerPresenter.this.mFoldStateListener);
                        BaseComposerPresenter.this.mFoldStateListener = null;
                        BaseComposerPresenter.this.mSubManager.getComposerModel().setSimpleModeState(1);
                        BaseComposerPresenter.this.mSubManager.getComposerModel().getModeManager().setMode(Mode.Text, "resetSimpleMode", true);
                        BaseComposerPresenter.this.mSubManager.getComposerModel().getModeManager().setMode(Mode.ReadOnly, "resetSimpleMode", true);
                    }
                };
                FoldStateCompat.INSTANCE.getInstance().registerFoldStateListener(this.mFoldStateListener);
            }
        }
        connectService(activity);
        SystemUi.setNavigationBarTheme(activity.getWindow(), !ContextUtils.isNightMode(activity.getApplicationContext()));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AiCommonUtil.onActivityResult(this.mSubManager.getComposerLifeState().getActivity(), i, i2, intent);
        if (PermissionHelper.onActivityResult(i, i2, null)) {
            finish("PermissionHelper# ");
            return;
        }
        if (i == 814) {
            this.mSubManager.getControllerManager().getSoftInputManager().clearLastState();
        } else if (i == ComposerRequestCode.ShareVia.getId() && i2 == 0) {
            ShareIntentCreationHelper.deleteSharedDataInIntent(this.mSubManager.getComposerLifeState().getActivity());
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onActivityResult# requestCode:", ", resultCode:", ", data:");
        sbM1173s.append(intent);
        Logger.m11003i(str, sbM1173s.toString());
        if (this.mSubManager.getComposerModel().getDocState() == null || !this.mSubManager.getComposerLifeState().isInitLayoutFinished()) {
            Logger.m11003i(str, "onActivityResult# isInitLayoutFinished: " + this.mSubManager.getComposerLifeState().isInitLayoutFinished());
            if (canDelayActivityResult(i)) {
                this.mActivityResult = new ActivityResult(i, i2, intent);
                if (this.mSubManager.getMenuPresenterManager() == null || this.mSubManager.getMenuPresenterManager().getListPresenter() == null) {
                    return;
                }
                this.mSubManager.getMenuPresenterManager().getListPresenter().hideForActivityResult();
                return;
            }
            return;
        }
        if (this.mSubManager.getComposerModel().isDoingCoeditWorkThread()) {
            Logger.m11003i(str, "onActivityResult# isDoingCoeditWorkThread: ");
            if (canDelayActivityResult(i)) {
                this.mActivityResult = new ActivityResult(i, i2, intent);
                this.mSubManager.setPendingAction(new RunnableC9169a(this, 2));
                return;
            }
            return;
        }
        if (i2 == -1 && !this.mSubManager.getComposerLifeState().getViewState().isResumed() && i == ComposerRequestCode.CoreTranslator.getId()) {
            Logger.m11003i(str, "onActivityResult# setResumePendingAction CoreTranslator ");
            if (canDelayActivityResult(i)) {
                this.mActivityResult = new ActivityResult(i, i2, intent);
                this.mSubManager.setResumePendingAction(new RunnableC9169a(this, 3));
                return;
            }
            return;
        }
        this.mActivityResult = null;
        this.mSubManager.onActivityResult(i, i2, intent);
        this.mComposerCloser.onActivityResult();
        Logger.m10999d(str, "onActivityResult# done " + i + " " + i2);
    }

    public boolean onBLEShortcut(KeyEvent keyEvent) {
        if (this.mSubManager.getMenuPresenterManager() == null || this.mSubManager.getMenuPresenterManager().getShortCutManager() == null) {
            return false;
        }
        return this.mSubManager.getMenuPresenterManager().getShortCutManager().onBLEShortcutFromActivity(keyEvent);
    }

    public boolean onBackPressed(boolean z) {
        if (this.mSubManager.getComposerLifeState().getActivity() == null) {
            Logger.m11004w(TAG, "onBackPressed# mActivity is null");
            return false;
        }
        if (this.mSubManager.onBackPressed()) {
            return true;
        }
        finish("onBackPressed# ");
        return true;
    }

    public void onChangeLayoutBefore(Bundle bundle) {
        if (isValidDocState()) {
            onSaveInstanceState(bundle, false, true);
            this.mSubManager.onChangeLayoutBefore();
            this.mMenuAttachManager.clear();
        }
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        this.mSubManager.getMenuPresenterManager().getAiMenuManager().onConfigurationChanged(configuration, z);
    }

    public void onConfigurationChangedForQuickNote() {
        this.mSubManager.getMenuPresenterManager().getQuickNotePresenter().onConfigurationChanged();
    }

    public void onCreated(Activity activity) {
        setActivity(activity);
        if (this.mComponentFactory.getConfig().isPostLaunchEnabled()) {
            PostLaunchManager.getInstance().executeBaseLogics();
        }
        ShareUtils.setDefaultNoteFilePath(activity);
        this.mSubManager.createObject(activity, this);
        this.mComposerCloser = new ComposerCloser(this.mSubManager);
        this.mServiceContractImpl = createServiceContractImpl(createServiceContract());
        this.mDMServiceManager = new DocumentServiceManager(this.mServiceContractImpl, this.mComponentFactory.createCustomSaveStrategy());
        this.mComposerModelContractImpl = new ComposerModelContractImpl(this.mDMServiceManager, this.mSubManager);
        this.mExternalListenerManager = new ExternalListenerManager(this.mSubManager);
        this.mDialogCreator = this.mComponentFactory.createDialogCreator();
        this.mComposerResolver = new ComposerResolver(this.mSubManager, this.mComposerCloser, createComposerResolverContract(), this.mComponentFactory.getConfig());
        this.mMenuAttachManager = this.mComponentFactory.createMenuAttachManager(this.mSubManager);
        this.mComposerMemoryTrimmer = new ComposerMemoryTrimmer(this.mSubManager, this.mComposerCloser);
        this.mCoeditServiceManager = new CoeditServiceManager();
        this.mSubManager.getComposerModel().getCoeditAdapter().setCoeditController(this.mCoeditServiceManager);
    }

    public void onDestroy(Activity activity) {
        onDestroy(activity, true, true);
    }

    public void onDetachView(Activity activity) {
        Logger.m10999d(TAG, "onDetachView");
        this.mInitializationLoadingProgress.release();
        this.mExternalListenerManager.onDetachView(activity);
        this.mSubManager.getDialogPresenterManager().onDetachView();
        this.mSubManager.getMenuPresenterManager().onDetachView(this.mView.getView());
        if (this.mSubManager.getCompViewPresenter() != null) {
            this.mSubManager.getCompViewPresenter().onDetachView();
        }
        this.mSubManager.getControllerManager().onDetachView();
        this.mComposerModelContractImpl.setSavingState(false);
        this.mCoeditServiceManager.disconnect(activity);
        this.mSubManager.getComposerModel().getMdeManager().setReopening(false);
        this.mSubManager.getComposerModel().getCoeditAdapter().clearCoeditCallback();
        this.mDMServiceManager.disconnect(activity);
        this.mSubManager.getComposerModel().setDocState(null);
        setActivity(null);
        this.mMenuAttachManager.clear();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.OnInitFinishedListener
    public void onInitFinished() {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        boolean z = false;
        boolean z2 = !this.mSubManager.getComposerLifeState().isInitialized() || this.mSubManager.getComposerLifeState().isChangingDoc();
        String str = TAG;
        Logger.m10999d(str, "onInitFinished# " + this.mSubManager.getComposerLifeState().isInitialized() + " needToInitialize :" + z2);
        if (activity == null) {
            Logger.m11000e(str, "onInitFinished# activity is null");
            return;
        }
        if (z2) {
            this.mSubManager.initManager(this, this.mDialogCreator, this.mLiveSharingTasker);
            this.mSubManager.getComposerModel().getMdeManager().init(activity, this.mSubManager.getComposerModel().getDocInfo().getUuid());
        }
        this.mExternalListenerManager.onPostComposerViewInitialized(activity);
        this.mSubManager.getControllerManager().onAttachView(activity, (Fragment) this.mView, this.mSubManager.getCompViewPresenter().getView());
        this.mSubManager.getDialogPresenterManager().onAttachView(activity);
        this.mSubManager.getMenuPresenterManager().onAttachView(activity, (Fragment) this.mView);
        if (!this.mSubManager.getComposerLifeState().isInitialized()) {
            this.mSubManager.getComposerModel().getLastPenInfoOnlyOnce();
        }
        this.mSubManager.getCompViewPresenter().getPageManager().getDocPageInfo().setRestoreFlag(true);
        this.mMenuAttachManager.attachViews();
        initBackgroundColor();
        clearChangedFlag();
        Initializer initializer = new Initializer(this.mSubManager);
        if (this.mSubManager.getComposerLifeState().isNotRecreated() || this.mSubManager.getComposerLifeState().isRecreatedBeforeInit()) {
            boolean booleanExtra = activity.getIntent().getBooleanExtra("new_doc", false);
            if (this.mSubManager.getComposerLifeState().isChangingDoc()) {
                initializer.initChangeNoteCase();
            } else {
                initializer.initFirstCase(booleanExtra);
            }
            if (!booleanExtra) {
                this.mSubManager.getCompViewPresenter().getHandoffManager().sendHandoffData();
            }
        } else {
            if (this.mActivityResult != null && !this.mSubManager.getComposerModel().isTabletLayout()) {
                z = true;
            }
            Bundle savedInstanceState = this.mSubManager.getComposerLifeState().getSavedInstanceState();
            initializer.restore((LifecycleOwner) this.mView, savedInstanceState, this.mSubManager.getComposerLifeState().isInitialized());
            this.mMenuAttachManager.addMenuTask(new RunnableC0202d(initializer, savedInstanceState, z, 6));
        }
        this.mSubManager.getComposerLifeState().setInitialized(true);
        this.mSubManager.getControllerManager().initQuickSaveTimer(this.mSubManager.getComposerModel());
        this.mInitializationLoadingProgress.hide();
        onPostInitFinished(activity);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.OnInitFinishedListener
    public void onInitLayoutFinished() {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity == null) {
            Logger.m11000e(TAG, "onInitLayoutFinished# activity is null");
            return;
        }
        this.mSubManager.checkToUseTextOnlyMode();
        if (!this.mSubManager.getComposerModel().getTextOnlyModeState().isEnableTextOnlyMode()) {
            this.mSubManager.getCompViewPresenter().getComposerControllerManager().getScrollController().restoreLastPosition(this.mSubManager.getComposerModel().getDoc());
            if (DeviceInfo.isVSTModel()) {
                this.mSubManager.getCompViewPresenter().getObjectManager().getNoteZoomScroller().setZoomScale(this.mSubManager.getCompViewPresenter().getObjectManager().getNoteZoomScroller().getMinZoomScale());
            }
        }
        this.mSubManager.getCompViewPresenter().getComposerControllerManager().getCompVoiceController().restoreVoiceSyncPlayAutoScroll();
        this.mSubManager.getComposerLifeState().setInitLayoutFinished(true);
        this.mSubManager.getCompViewPresenter().getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (BaseComposerPresenter.this.mSubManager.getComposerModel() != null) {
                    BaseComposerPresenter.this.mSubManager.getComposerModel().setIsInitLayoutFinishedOneSecond(true);
                }
            }
        }, 1000L);
        doActivityResultWithPending();
        this.mSubManager.getCompViewPresenter().getHandoffManager().updateStateFromHandoff();
        this.mSubManager.getMenuPresenterManager().getQuickNotePresenter().doPendingAction();
        PermissionHelper.noticeAppPermissionIfNeededs(activity);
        this.mLiveSharingTasker.runPending();
        Logger.endTime(String.valueOf(activity.hashCode()), Logger.START_TAG, "onInitLayoutFinished# ");
    }

    public void onLoadDocCompleted(Bundle bundle) {
        Logger.m10999d(TAG, "onLoadDocCompleted");
        if (isValidDocState()) {
            this.mSubManager.getControllerManager().getProgressController().onInitLayoutFinished();
            this.mSubManager.getComposerLifeState().setSavedInstanceState(bundle);
            attachLoadedDoc(this.mSubManager.getComposerModel().getDocState());
            this.mSubManager.getCompViewPresenter().onInitLayoutFinished();
        }
    }

    public void onNewIntent(Intent intent) {
        EntryAction.executeBixbyAction(this.mSubManager.getComposerLifeState().getActivity(), intent, new BixbyContractImpl(this.mSubManager));
    }

    public void onPause() {
        Logger.m10999d(TAG, "onPause");
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        this.mSubManager.onPause();
        ExternalListenerManager externalListenerManager = this.mExternalListenerManager;
        if (externalListenerManager != null) {
            externalListenerManager.onPause(activity);
        }
        if (activity != null) {
            setUuidToHandoffSender(false);
        }
    }

    public void onProvideAssistContent(@NonNull Activity activity, AssistContent assistContent) {
        this.mSubManager.onProvideAssistContent(activity, assistContent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length == 0 || strArr.length != iArr.length || !PermissionHelper.verifyRequestResult(this.mSubManager.getComposerLifeState().getActivity(), iArr, strArr) || this.mSubManager.getMenuPresenterManager().onRequestPermissionsResult(i, strArr, iArr)) {
            return;
        }
        this.mSubManager.getControllerManager().onRequestPermissionsResult(i);
    }

    public void onResume() {
        Logger.m10999d(TAG, "onResume");
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        this.mSubManager.onResume();
        ExternalListenerManager externalListenerManager = this.mExternalListenerManager;
        if (externalListenerManager != null) {
            externalListenerManager.onResume(activity);
        }
        if (activity != null) {
            setUuidToHandoffSender(true);
        }
        this.mLiveSharingTasker.onResume(this.mComposerCloser);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle, boolean z, boolean z2) {
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "onSaveInstanceState : " + z);
        this.mSubManager.onSaveInstanceState(bundle, z, z2);
        Logger.endTime(String.valueOf(hashCode()), str, NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE);
        logTransactionTooLargeException(bundle);
    }

    public void onStart() {
        BaseSubManager baseSubManager = this.mSubManager;
        baseSubManager.onStart(baseSubManager.getComposerLifeState().getActivity());
        this.mLiveSharingTasker.onStart(this.mSubManager.getComposerLifeState().getActivity());
    }

    public void onStop() {
        this.mSubManager.onStop();
    }

    public void onTrimMemory(int i) {
        this.mComposerMemoryTrimmer.trimMemory(i);
        if (this.mSubManager.getComposerModel() != null) {
            this.mSubManager.getComposerModel().getCoeditAdapter().trimMemory(i);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        updateStateToHideNavigationBar(z);
        if (this.mSubManager.onWindowFocusChanged(z) || this.mSubManager.getComposerLifeState().getActivity() == null || !z) {
            return;
        }
        setUuidToHandoffSender(true);
    }

    public void onWindowModeChanged(int i) {
        this.mSubManager.onWindowModeChanged(i);
        this.mSubManager.getMenuPresenterManager().getAiMenuManager().onWindowModeChanged();
    }

    public void resetLockVerified() {
        if (this.mSubManager.getMenuPresenterManager() != null) {
            this.mSubManager.getMenuPresenterManager().resetLockVerified();
        }
    }

    public void setActivity(Activity activity) {
        this.mSubManager.getComposerLifeState().setActivity(activity);
    }

    public boolean setDocumentUuid(Activity activity, @Nullable Bundle bundle) {
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        String stringExtra2 = intent.getStringExtra("doc_path");
        boolean z = false;
        boolean booleanExtra = intent.getBooleanExtra("new_doc", false);
        if (bundle != null) {
            String string = bundle.getString("sdoc_uuid");
            Logger.m10999d(TAG, "setDocumentUuid# savedInstanceState: uuid = " + string);
            if (!TextUtils.isEmpty(string)) {
                booleanExtra = bundle.getBoolean("new_doc");
                stringExtra2 = bundle.getString("doc_path");
                stringExtra = string;
            }
        }
        if (TextUtils.isEmpty(stringExtra)) {
            boolean zIsCoeditNote = this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote();
            StringBuilder sb = new StringBuilder();
            sb.append(UUIDUtils.newUUID(activity, zIsCoeditNote));
            sb.append(zIsCoeditNote ? "" : this.mUuidPostfix);
            stringExtra = sb.toString();
            String str = TAG;
            Logger.m10999d(str, "setDocumentUuid# newUUID ");
            z = true;
            if (!TextUtils.isEmpty(stringExtra2)) {
                Logger.m11002f(str, "remove a path in intent");
                stringExtra2 = null;
            }
            booleanExtra = true;
        }
        intent.putExtra("sdoc_uuid", stringExtra);
        intent.putExtra("new_doc", booleanExtra);
        intent.putExtra("doc_path", stringExtra2);
        return z;
    }

    public void setView(CompContract.IView iView) {
        this.mView = iView;
        this.mSubManager.getComposerLifeState().setFragment((Fragment) this.mView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IParent
    public void startInAppCollaboration(String str) {
        this.mSubManager.getMenuPresenterManager().getInAppCollaborationPresenter().startInAppCollaboration(str);
    }

    public void updateDisallowTouchDownArea(boolean z) {
        if (this.mSubManager.getCompViewPresenter() != null) {
            this.mSubManager.getCompViewPresenter().updateDisallowTouchDownArea(z);
        }
    }

    public boolean verifyScreenLock() {
        if (this.mSubManager.getMenuPresenterManager() != null) {
            return this.mSubManager.getMenuPresenterManager().verifyScreenLock();
        }
        return false;
    }

    public void onDestroy(Activity activity, boolean z, boolean z2) {
        String str = TAG;
        Logger.m10999d(str, "onDestroy " + activity);
        if (this.mFoldStateListener != null) {
            FoldStateCompat.INSTANCE.getInstance().unregisterFoldStateListener(this.mFoldStateListener);
            this.mFoldStateListener = null;
        }
        ExternalListenerManager externalListenerManager = this.mExternalListenerManager;
        if (externalListenerManager != null) {
            externalListenerManager.onDestroy(activity);
        }
        this.mInitializationLoadingProgress.release();
        AiCommonUtil.releaseActionStatus(activity);
        activity.setResult(-1, activity.getIntent());
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        this.mLiveSharingTasker.onDestroy(activity);
        if (composerModel == null) {
            Logger.m11000e(str, "onDestroy composerModel is null");
            setActivity(null);
            return;
        }
        this.mSubManager.getMenuPresenterManager().getInAppCollaborationPresenter().onDestroy();
        destroyComposerViewPresenter(activity, z, z2);
        composerModel.finish();
        this.mComposerCloser.onDestroy();
        setActivity(null);
        this.mMenuAttachManager.clear();
    }
}
