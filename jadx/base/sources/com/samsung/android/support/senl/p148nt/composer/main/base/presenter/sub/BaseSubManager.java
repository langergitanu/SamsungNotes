package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseSubManager {
    private static final String TAG = Logger.createTag("BaseSubManager");
    private ComposerViewPresenter mCompViewPresenter;
    private final ComponentFactory mComponentFactory;
    private final ComposerLifeState mComposerLifeState = new ComposerLifeState();
    private ComposerModel mComposerModel;
    private ControllerManager mControllerManager;
    private DialogPresenterManager mDialogPresenterManager;
    private MenuPresenterManager mMenuPresenterManager;
    private ModeObserver mModeObserver;
    private Runnable mPendingAction;
    private Runnable mResumePendingAction;
    private int mScreenWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ConfigurationFactory {
        @NonNull
        ComposerModel createComposerModel(@NonNull Activity activity);

        @NonNull
        ComposerViewPresenter createComposerViewPresenter(@NonNull KeyguardPresenter keyguardPresenter);

        @NonNull
        DialogPresenterManager createDialogPresenterManager();

        @NonNull
        MenuPresenterManager createMenuPresenterManager(@NonNull MenuPresenterContract.IMenuParent iMenuParent);

        @NonNull
        ModeObserver createModeObserver();
    }

    public BaseSubManager(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
    }

    private void fixLockStateMismatched() {
        if (this.mComposerModel.isLockStateMismatched()) {
            DocumentLockResolver.unlock(this.mComposerLifeState.getActivity(), this.mComposerModel.getDocInfo().getUuid());
            Logger.m11002f(TAG, "isLockStateMismatched");
        }
    }

    private void initFullScreenMode(Activity activity) {
        boolean booleanExtra = activity.getIntent().getBooleanExtra(ComposerConstants.ARG_FULLSCREEN_MODE, false);
        if (booleanExtra) {
            activity.getIntent().putExtra(ComposerConstants.ARG_FULLSCREEN_MODE, false);
            this.mComposerModel.getComposerState().setIsFullScreenMode(booleanExtra);
        }
    }

    private void initRestrict(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null || ((SpenWordDocument) notesDocument.getDoc()).getTitleText() == null) {
            return;
        }
        int length = ((SpenWordDocument) notesDocument.getDoc()).getTitleText().length();
        String str = TAG;
        AbstractC8014b.m7217s(length, "initRestrict title length = ", str);
        if (length > this.mComposerModel.getComposerState().getTitleMaxLength()) {
            Logger.m11002f(str, "setTitleMaxLength# " + length);
            this.mComposerModel.getComposerState().setTitleMaxLength(length);
        }
    }

    private boolean isBlockToShowSip() {
        if (this.mMenuPresenterManager.getListPresenter().isShowing() || this.mComposerModel.isRunningDrawing()) {
            return true;
        }
        if (this.mCompViewPresenter.getObjectManager().isFocusedTextBox() || this.mComposerModel.getModeManager().isMode(Mode.Search)) {
            return this.mMenuPresenterManager.getAiMenuManager().isShowingMenu();
        }
        return true;
    }

    private boolean isCoeditInitializing() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || composerModel.getDocInfo() == null || !this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() || !CoeditHandlerManager.getInstance().isCoeditInitializing(this.mComposerModel.getDocInfo().getUuid())) {
            return false;
        }
        Logger.m11003i(TAG, "onBackPressed# ignored by coedit initializing");
        return true;
    }

    private boolean isTaskRunning() {
        return this.mControllerManager.getTaskController() != null && this.mControllerManager.getTaskController().isRunning();
    }

    private void setFingerDrawingInfo(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra(ComposerConstants.ARG_FINGERDRAWING);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if ("on".equalsIgnoreCase(stringExtra) || "off".equalsIgnoreCase(stringExtra)) {
            SharedPreferences.Editor editorEdit = SharedPreferencesCompat.getInstance("Settings").edit();
            editorEdit.putBoolean("settings_spen_only_mode", "off".equalsIgnoreCase(stringExtra));
            editorEdit.apply();
        } else {
            AbstractC8014b.m7198D("setFingerDrawingInfo error type = ", stringExtra, TAG);
        }
        activity.getIntent().removeExtra(ComposerConstants.ARG_FINGERDRAWING);
    }

    private void setFolderInfo(Activity activity) {
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("category_id");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.mComposerModel.getNotesDocEntityManager().setFolderUuid(stringExtra);
        intent.removeExtra("category_id");
    }

    private void setStartParamInfo(Activity activity) {
        setFolderInfo(activity);
        setWidgetInfo(activity);
        initFullScreenMode(activity);
        setFingerDrawingInfo(activity);
    }

    private void setWidgetInfo(Activity activity) {
        Intent intent = activity.getIntent();
        int intExtra = intent.getIntExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, -1);
        if (intExtra != -1) {
            getComposerModel().setWidgetId(intExtra);
            intent.removeExtra(ComposerConstants.NEW_MEMO_FROM_PICKER);
        }
    }

    public void cancelTaskController() {
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager == null || controllerManager.getTaskController() == null) {
            return;
        }
        this.mControllerManager.getTaskController().cancel();
    }

    public void checkToUseTextOnlyMode() {
        if (!this.mComposerLifeState.isInitLayoutFinished() && FeatureInfo.isTextOnlyEnabledFeature()) {
            boolean zIsBodyTextOnlyNote = this.mComposerModel.getComposerSpenDocModel().isBodyTextOnlyNote();
            this.mComposerModel.getTextOnlyModeState().setIsStartWithTextOnly(zIsBodyTextOnlyNote);
            if (zIsBodyTextOnlyNote && DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(this.mComposerLifeState.getActivity()) == 5) {
                this.mMenuPresenterManager.getOptionMenuPresenter().setCanUseTextOnlyMode(true);
                this.mMenuPresenterManager.getOptionMenuPresenter().showGuideDialogForTextOnlyMode();
            }
        }
    }

    public void createCompViewPresenter() {
        this.mCompViewPresenter = this.mComponentFactory.createComposerViewPresenter(this.mMenuPresenterManager.getKeyguardPresenter());
    }

    public void createObject(Activity activity, @NonNull MenuPresenterContract.IMenuParent iMenuParent) {
        this.mScreenWidth = SpenDocumentDisplayUtils.getScreenWidth(activity);
        this.mComposerModel = this.mComponentFactory.createComposerModel(activity);
        this.mMenuPresenterManager = this.mComponentFactory.createMenuPresenterManager(iMenuParent);
        this.mDialogPresenterManager = this.mComponentFactory.createDialogPresenterManager();
        this.mControllerManager = new ControllerManager(this.mComposerLifeState.getViewState());
        this.mModeObserver = this.mComponentFactory.createModeObserver();
    }

    public void executePendingAction() {
        if (this.mPendingAction != null) {
            Logger.m11003i(TAG, "executePendingAction# ");
            this.mPendingAction.run();
            this.mPendingAction = null;
        }
    }

    public void executeResumePendingAction() {
        if (this.mResumePendingAction != null) {
            Logger.m11003i(TAG, "executeResumePendingAction# ");
            this.mResumePendingAction.run();
            this.mResumePendingAction = null;
        }
    }

    public ComposerViewPresenter getCompViewPresenter() {
        return this.mCompViewPresenter;
    }

    public ComposerLifeState getComposerLifeState() {
        return this.mComposerLifeState;
    }

    public ComposerModel getComposerModel() {
        return this.mComposerModel;
    }

    @NonNull
    public Config getConfig() {
        return this.mComponentFactory.getConfig();
    }

    public ControllerManager getControllerManager() {
        return this.mControllerManager;
    }

    public DialogPresenterManager getDialogPresenterManager() {
        return this.mDialogPresenterManager;
    }

    public MenuPresenterManager getMenuPresenterManager() {
        return this.mMenuPresenterManager;
    }

    public int getOpenPageWidth(boolean z) {
        if (z) {
            return 2160;
        }
        return this.mScreenWidth;
    }

    public void initComposerViewPresenter(ComposerViewPresenter.OnInitFinishedListener onInitFinishedListener) {
        Activity activity = this.mComposerLifeState.getActivity();
        if (this.mComposerLifeState.isInitialized()) {
            this.mCompViewPresenter.init(activity, this.mComposerModel.getDoc(), this.mComposerLifeState.isChangingDoc());
            return;
        }
        this.mCompViewPresenter.setContainerControllers(this.mControllerManager, this.mDialogPresenterManager, this.mComposerModel, onInitFinishedListener);
        this.mCompViewPresenter.init(activity, this.mComposerModel.getDoc(), this.mComposerModel.getDocState().getUuid(), this.mComposerLifeState.getSavedInstanceState());
        fixLockStateMismatched();
    }

    public void initManager(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, LiveSharingContract liveSharingContract) {
        this.mControllerManager.init(this.mCompViewPresenter.getSearchController(), this.mCompViewPresenter.getObjectManager(), this.mCompViewPresenter.getNoteManager(), this.mCompViewPresenter.getTextManager(), this.mCompViewPresenter.getPdfManager(), this.mCompViewPresenter.getPageManager(), this.mComposerModel, this.mMenuPresenterManager.getAiMenuManager());
        this.mDialogPresenterManager.init(iParent, iDialogCreator, this.mControllerManager, this.mCompViewPresenter, this.mMenuPresenterManager, this.mComposerModel);
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        menuPresenterManager.init(composerViewPresenter, this.mControllerManager, this.mComposerModel, composerViewPresenter.getPageManager(), this.mDialogPresenterManager, liveSharingContract);
        this.mModeObserver.init(this.mCompViewPresenter, this.mMenuPresenterManager, this.mControllerManager, this.mComposerModel.getModeManager());
    }

    public void initModel(Activity activity, LifecycleOwner lifecycleOwner) {
        initRestrict(this.mComposerModel.getDocState());
        this.mComposerModel.getEntityManager().initDataRepository(lifecycleOwner, this.mComposerModel.getDocState());
        this.mComposerModel.initMdeInfo();
        this.mComposerModel.initFirstBackgroundColorInverted();
        activity.getIntent().putExtra("doc_path", this.mComposerModel.getDocState().getLoadPath());
        setStartParamInfo(activity);
        this.mComposerModel.restoreStateOnlyData(getComposerLifeState().getSavedInstanceState());
    }

    public boolean isEditableState() {
        return this.mComposerModel.isEditable() && !isTaskRunning() && this.mComposerModel.getMdeInfo().hasWritePermission() && !this.mComposerModel.getNotesDocEntityManager().isLocked();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getMenuPresenterManager().onActivityResult(i, i2, intent)) {
            List<Fragment> fragments = this.mComposerLifeState.getFragment().getChildFragmentManager().getFragments();
            if (!fragments.isEmpty()) {
                fragments.get(0).onActivityResult(i, i2, intent);
            }
        }
        getComposerModel().getComposerState().clearLastRequestCode();
    }

    public boolean onBackPressed() {
        if (isCoeditInitializing()) {
            return true;
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null && composerModel.isRecoveringNote()) {
            return true;
        }
        if (this.mControllerManager != null && isTaskRunning()) {
            return true;
        }
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null && menuPresenterManager.onBackPressedBeforeComposerView()) {
            return true;
        }
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter != null && composerViewPresenter.onBackPressed()) {
            return true;
        }
        MenuPresenterManager menuPresenterManager2 = this.mMenuPresenterManager;
        return menuPresenterManager2 != null && menuPresenterManager2.onBackPressed();
    }

    public void onChangeLayoutBefore() {
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.getObjectManager().clearSelectObject();
            if (isTaskRunning()) {
                this.mControllerManager.getTaskController().clearTask();
            }
            this.mCompViewPresenter.getWritingToolManager().clearControl();
            if (this.mComposerModel.getModeManager().isMode(Mode.Text)) {
                this.mCompViewPresenter.getTextManager().setCursorBlink(true);
            }
            this.mControllerManager.onChangeLayoutBefore();
        }
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onChangeLayoutBefore();
        }
    }

    public void onPause() {
        this.mComposerLifeState.onPause();
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.onPause();
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager != null) {
            controllerManager.onPause();
        }
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onPause();
        }
    }

    public void onProvideAssistContent(@NonNull Activity activity, AssistContent assistContent) {
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter == null) {
            return;
        }
        composerViewPresenter.onProvideAssistContent(activity, assistContent);
    }

    public void onResume() {
        this.mComposerLifeState.onResume();
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.onResume();
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager != null) {
            controllerManager.onResume();
        }
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onResume();
        }
        executeResumePendingAction();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle, boolean z, boolean z2) {
        if (!this.mComposerLifeState.isInitialized()) {
            Logger.m11000e(TAG, "onSaveInstanceState# not initialized");
            bundle.putBoolean("not_initialized", true);
            return;
        }
        bundle.putBoolean("not_initialized", false);
        this.mMenuPresenterManager.onSaveInstanceState(bundle);
        this.mComposerModel.onSaveInstanceState(getComposerLifeState().getActivity(), bundle, isBlockToShowSip());
        this.mCompViewPresenter.onSaveInstanceState(bundle);
        if (z2) {
            this.mCompViewPresenter.requestReadyForSave();
        }
        if (!z || isTaskRunning()) {
            return;
        }
        this.mComposerModel.saveCache(false);
    }

    public void onStart(Activity activity) {
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onStart(activity);
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null) {
            composerModel.getMdeManager().connectSession();
        }
    }

    public void onStop() {
        this.mComposerLifeState.onStop();
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onStop();
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null) {
            composerModel.getMdeManager().clearSession();
        }
    }

    public boolean onWindowFocusChanged(boolean z) {
        MenuPresenterManager menuPresenterManager;
        MenuPresenterManager menuPresenterManager2 = this.mMenuPresenterManager;
        if (menuPresenterManager2 != null && menuPresenterManager2.onWindowFocusChanged(z)) {
            return true;
        }
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter == null) {
            return false;
        }
        composerViewPresenter.onWindowFocusChanged(z);
        if (!this.mCompViewPresenter.updateSpenOnlyModeWithPreference(z) || (menuPresenterManager = this.mMenuPresenterManager) == null) {
            return false;
        }
        menuPresenterManager.invalidateOptionsMenu();
        return false;
    }

    public void onWindowModeChanged(int i) {
        MenuPresenterManager menuPresenterManager = this.mMenuPresenterManager;
        if (menuPresenterManager != null) {
            menuPresenterManager.onWindowModeChanged(i);
        }
        ComposerViewPresenter composerViewPresenter = this.mCompViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.onWindowModeChanged(i);
        }
    }

    public void restoreEntity() {
        this.mComposerModel.getEntityManager().restoreEntity(this.mComposerLifeState.getSavedInstanceState());
    }

    public void restoreTempBrushData() {
        if (this.mComposerModel.isRunningDrawing()) {
            return;
        }
        if (CommonUtils.isNotAvailableActivity(this.mComposerLifeState.getActivity())) {
            Logger.m11000e(TAG, "restoreTempBrushData# isNotAvailableActivity ");
        } else {
            this.mControllerManager.getExecuteOtherActivityController().updateBrushFileInfo(this.mComposerLifeState.getActivity(), this.mComposerModel.getDocInfo().getUuid(), this.mComposerModel.getDoc(), this.mCompViewPresenter.getObjectManager());
        }
    }

    public void setCompViewPresenter(ComposerViewPresenter composerViewPresenter) {
        this.mCompViewPresenter = composerViewPresenter;
    }

    public void setPendingAction(Runnable runnable) {
        this.mPendingAction = runnable;
    }

    public void setResumePendingAction(Runnable runnable) {
        this.mResumePendingAction = runnable;
    }
}
