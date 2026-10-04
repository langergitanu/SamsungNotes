package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.engine.SpenRemoverListener;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.HWToolbarPolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.RemoteHwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskChangeStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskEraseAll;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarPresenter implements HwToolbarPresenterImpl, ComposerViewContract.HWToolbarContract, NoteManager.ObserverBackgroundColor {
    private static final String TAG = Logger.createTag("HwToolbarPresenter");
    private AiMenuManager mAiMenuManager;
    private WritingToolManager.BeautifierLanguageListener mBeautifierLanguageListener;
    private List<Integer> mCollaborationViewSupportedMenuIdList;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogManager;
    private HWToolbarPolicyManager mHWToolbarPolicyManager;
    private HwSettingPresenter mHwSettingPresenter;
    private boolean mIsAlignmentRunning = false;
    private boolean mIsConvertToTextRunning = false;
    private boolean mIsDockingMode;
    private int mIsShowingSnackBarForRemoveSkip;
    private final KeyguardPresenter mKeyguardPresenter;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    protected final ObjectManager mObjectManager;
    private ComposerViewPresenter.ObserverConfigurationChanged mObserverConfigurationChanged;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private HwToolbarContract.QtHwToolbarStateListener mQTListener;
    private SpenObjectSelectListener mSpenObjectSelectListener;
    private SpenRemoverListener mSpenRemoverListener;

    @Nullable
    private IStickyMemoManager mStickyMemoManager;
    private final TaskController mTaskController;
    private ToolShareControl mToolShareControl;
    private HistoryEventListenerImpl.UndoRedoListener mUndoRedoListener;

    @Nullable
    private HwToolbarContract.IView mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C98975 implements SpenRemoverListener {
        public C98975() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onHighlighterRemoverTouchesNormalStroke$0(View view) {
            Logger.m11003i(HwToolbarPresenter.TAG, "onHighlighterRemoverTouchesNormalStroke onClick ");
            SpenSettingRemoverInfo settingRemoverInfoSelected = HwToolbarPresenter.this.mHwSettingPresenter.getSettingInfoManager().getRemoverInfoData().getSettingRemoverInfoSelected();
            settingRemoverInfoSelected.target = 0;
            HwToolbarPresenter.this.mHwSettingPresenter.setRemoverSettingInfo(settingRemoverInfoSelected);
            HwToolbarPresenter.this.mHwSettingPresenter.getSettingView().setRemoverSettingInfo(settingRemoverInfoSelected);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenRemoverListener
        public void onHighlighterRemoverTouchesNormalStroke() {
            Logger.m11003i(HwToolbarPresenter.TAG, "onHighlighterRemoverTouchesNormalStroke : " + HwToolbarPresenter.this.mIsShowingSnackBarForRemoveSkip);
            if (HwToolbarPresenter.this.mIsShowingSnackBarForRemoveSkip >= 2) {
                return;
            }
            HwToolbarPresenter.this.mIsShowingSnackBarForRemoveSkip++;
            if (HwToolbarPresenter.this.mIsShowingSnackBarForRemoveSkip <= 1) {
                return;
            }
            SnackbarHelper.show(HwToolbarPresenter.this.mComposerViewPresenter.getActivity(), HwToolbarPresenter.this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.hw_toolbar_erase_highlighter_only_on), HwToolbarPresenter.this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.hw_toolbar_turn_off), 0, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f7060a.lambda$onHighlighterRemoverTouchesNormalStroke$0(view);
                }
            }, new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.5.1
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public void onDismissed(Snackbar snackbar, int i) {
                    super.onDismissed(snackbar, i);
                    HwToolbarPresenter.this.mIsShowingSnackBarForRemoveSkip = 0;
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IStickyMemoManager {
        void setBlockCommitListener(boolean z);
    }

    public HwToolbarPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mMenuManager = iMenuManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTaskController = controllerManager.getTaskController();
        composerViewPresenter.getNoteManager().addBackgroundColorObserver(this);
        this.mHwSettingPresenter = new HwSettingPresenter(composerViewPresenter, this, composerViewPresenter.getComponentFactory());
        this.mControllerManager = controllerManager;
        this.mDialogManager = dialogPresenterManager;
        this.mKeyguardPresenter = keyguardPresenter;
        initListener();
        initRemoverListener();
        initPolicyManager();
    }

    private void addComposerViewListeners() {
        if (this.mView == null) {
            return;
        }
        this.mComposerViewPresenter.getListenerManager().addFocusChangeListener(this.mOnFocusChangeListener);
        this.mComposerViewPresenter.getListenerManager().registerHistoryEventListener(this.mUndoRedoListener);
        this.mComposerViewPresenter.getListenerManager().addSpenObjectSelectListener(this.mSpenObjectSelectListener);
        this.mComposerViewPresenter.getWritingToolManager().setRemoverListener(this.mSpenRemoverListener);
        this.mComposerViewPresenter.getWritingToolManager().addBeautifierLanguageListener(this.mBeautifierLanguageListener);
    }

    private void blockingCommitListenerForStickyMemo(Runnable runnable) {
        IStickyMemoManager iStickyMemoManager = this.mStickyMemoManager;
        if (iStickyMemoManager != null) {
            iStickyMemoManager.setBlockCommitListener(true);
        }
        runnable.run();
        IStickyMemoManager iStickyMemoManager2 = this.mStickyMemoManager;
        if (iStickyMemoManager2 != null) {
            iStickyMemoManager2.setBlockCommitListener(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canUpdateUndoRedoMenu() {
        return !this.mAiMenuManager.getAiContextMenuPresenter().isTranslating();
    }

    @NonNull
    private Task.Callback<TaskEraseAll.ResultValues> getCallbackTaskEraseAll() {
        return new Task.Callback<TaskEraseAll.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskEraseAll.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskEraseAll.ResultValues resultValues) {
                if (HwToolbarPresenter.this.mView != null) {
                    HwToolbarPresenter.this.mView.updateSelectionState(2, true, true);
                }
            }
        };
    }

    private void initListener() {
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (HwToolbarPresenter.this.mView == null || z) {
                    return;
                }
                Logger.m11003i(HwToolbarPresenter.TAG, "onFocusChange# false dismissSmartTip");
                HwToolbarPresenter.this.mView.dismissSmartTip();
            }
        };
        this.mSpenObjectSelectListener = new SpenObjectSelectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.2
            @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
            public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
                super.onObjectSelected(arrayList, arrayList2, z);
                if (z || !HwToolbarPresenter.this.mHwSettingPresenter.isShownSettingViews(64)) {
                    return;
                }
                HwToolbarPresenter.this.mHwSettingPresenter.hideSettingView(64);
            }
        };
        this.mUndoRedoListener = new HistoryEventListenerImpl.UndoRedoListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
            public void onObjectChanged() {
                HwToolbarPresenter.this.getSettingInstance().onObjectChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
            public void onRedoable(boolean z) {
                if (HwToolbarPresenter.this.canUpdateUndoRedoMenu()) {
                    HwToolbarPresenter.this.getSettingInstance().onRedoable(z);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
            public void onUndoable(boolean z) {
                if (HwToolbarPresenter.this.canUpdateUndoRedoMenu()) {
                    HwToolbarPresenter.this.getSettingInstance().onUndoable(z);
                }
            }
        };
        this.mBeautifierLanguageListener = new WritingToolManager.BeautifierLanguageListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.a
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.WritingToolManager.BeautifierLanguageListener
            public final void onLanguageChanged(String str) {
                this.f7056a.lambda$initListener$0(str);
            }
        };
        registerConfigurationChangedObserver();
    }

    private void initPolicyManager() {
        this.mHWToolbarPolicyManager = new HWToolbarPolicyManager();
    }

    private void initRemoverListener() {
        this.mIsShowingSnackBarForRemoveSkip = 1;
        this.mSpenRemoverListener = new C98975();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeWritingMode$1() {
        this.mComposerModel.getModeManager().setMode(Mode.Writing, "hwToolbar text change mode", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeWritingMode$2() {
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        blockingCommitListenerForStickyMemo(new RunnableC9899b(this, 2));
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null) {
            toolShareControl.changeHwMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(String str) {
        getSettingInstance().onBeautifierLanguage(str, SPenHwrBeautifierManager.getBeautifierSupportedLanguages(ApplicationManager.getInstance().getAppContext()).contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerConfigurationChangedObserver$5(Configuration configuration, boolean z) {
        updateSettingPopupOfLaserPen(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAiAssistMenu$4(View view, AnchorPosition anchorPosition) {
        if (this.mView != null) {
            this.mAiMenuManager.showAiContextMenu(view, anchorPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCleanUpAndCTT$3() {
        this.mAiMenuManager.showHwContextMenu();
    }

    private void preventUnexpectedAutoScrollToCursor(Runnable runnable) {
        boolean zIsShowingMenu = this.mAiMenuManager.isShowingMenu();
        if (zIsShowingMenu) {
            this.mComposerViewPresenter.setAutoScrollEnabled(false);
        }
        runnable.run();
        if (zIsShowingMenu) {
            this.mComposerViewPresenter.setAutoScrollEnabled(true);
        }
    }

    private void registerConfigurationChangedObserver() {
        if (this.mObserverConfigurationChanged != null) {
            return;
        }
        Logger.m10999d(TAG, "registerConfigurationChangedObserver");
        ComposerViewPresenter.ObserverConfigurationChanged observerConfigurationChanged = new ComposerViewPresenter.ObserverConfigurationChanged() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.c
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.ObserverConfigurationChanged
            public final void onConfigurationChanged(Configuration configuration, boolean z) {
                this.f7059a.lambda$registerConfigurationChangedObserver$5(configuration, z);
            }
        };
        this.mObserverConfigurationChanged = observerConfigurationChanged;
        this.mComposerViewPresenter.addConfigurationObserverChanged(observerConfigurationChanged);
    }

    private void removeComposerViewListeners() {
        this.mComposerViewPresenter.getListenerManager().removeFocusChangeListener(this.mOnFocusChangeListener);
        this.mComposerViewPresenter.getListenerManager().releaseHistoryEventListener(this.mUndoRedoListener);
        this.mComposerViewPresenter.getListenerManager().removeSpenObjectSelectListener(this.mSpenObjectSelectListener);
        this.mComposerViewPresenter.getWritingToolManager().setRemoverListener(null);
        this.mComposerViewPresenter.getWritingToolManager().removeBeautifierLanguageListener(this.mBeautifierLanguageListener);
    }

    private void unregisterConfigurationChangedObserver() {
        if (this.mObserverConfigurationChanged == null) {
            return;
        }
        Logger.m10999d(TAG, "unregisterConfigurationChangedObserver");
        this.mComposerViewPresenter.removeConfigurationObserverChanged(this.mObserverConfigurationChanged);
        this.mObserverConfigurationChanged = null;
    }

    private void updateSettingPopupOfLaserPen(Configuration configuration) {
        if (!this.mComposerModel.isTabletLayout() && getSettingInstance().isShownSettingViews(32768) && this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
            View viewFindViewById = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.floating_layout_container);
            int iMax = configuration.orientation == 2 ? Math.max(viewFindViewById.getWidth(), viewFindViewById.getHeight()) : Math.min(viewFindViewById.getWidth(), viewFindViewById.getHeight());
            this.mHwSettingPresenter.updateAnchorSettingView(0, 32768, new AnchorInfo(new Rect(iMax - 1, 0, iMax, 1), viewFindViewById));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(preTouchListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean canShowAiContextMenu() {
        return this.mAiMenuManager.canShowAiContextMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void changeTextMode() {
        this.mComposerViewPresenter.setForceShowKeyboard();
        getWritingToolManager().clearControl();
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mComposerViewPresenter.getNoteManager().setCursorOnScreen(this.mComposerViewPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex());
        this.mComposerModel.getModeManager().setMode(Mode.Text, "hw toolbar change mode - Text", true);
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null) {
            toolShareControl.changeTextMode();
            if (this.mToolShareControl.getEnabled()) {
                return;
            }
        }
        requestFocusToComposerView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void changeWritingMode() {
        preventUnexpectedAutoScrollToCursor(new RunnableC9899b(this, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void clearContextMenu() {
        this.mComposerViewPresenter.setContextMenu(false);
    }

    public RemoteHwSettingPresenter convertToRemoteTypePresenter(RemoteFunctionContract.PresenterContract presenterContract) {
        RemoteHwSettingPresenter remoteHwSettingPresenter = new RemoteHwSettingPresenter(this.mHwSettingPresenter, presenterContract, this.mComposerViewPresenter.getComponentFactory());
        this.mHwSettingPresenter = remoteHwSettingPresenter;
        return remoteHwSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void dismissDirectWriteSettingDialog() {
        this.mComposerViewPresenter.getDialogPresenterManager().dismissDirectWriteSettingDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void enableDockingMode(boolean z) {
        this.mIsDockingMode = z;
    }

    public void enableMenus(boolean z, List<Integer> list) {
        if (this.mView != null) {
            this.mHwSettingPresenter.setEnableMenus(z, list);
        }
    }

    public void executeAiAssist() {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.executeAiAssist();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeEraseAllOnAllPages() {
        Logger.m11003i(TAG, "executeEraseAllOnAllPages");
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.eraseAll();
        } else {
            this.mTaskController.execute(new TaskEraseAll(), new TaskEraseAll.InputValues(this.mObjectManager), getCallbackTaskEraseAll(), false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeEraseAllOnCurrentPage(int i) {
        int currentPageIndex = this.mComposerViewPresenter.getCurrentPageIndex();
        if (i == 1) {
            currentPageIndex = this.mComposerViewPresenter.getTwoPageLeftIndex(currentPageIndex);
        } else if (i == 2) {
            currentPageIndex = this.mComposerViewPresenter.getTwoPageRightIndex(currentPageIndex);
        }
        Logger.m11003i(TAG, "executeEraseAllOnCurrentPage type = " + i + " / pageIndex =" + currentPageIndex);
        this.mTaskController.execute(new TaskEraseAll(), new TaskEraseAll.InputValues(this.mObjectManager, Integer.valueOf(currentPageIndex), Integer.valueOf(currentPageIndex)), getCallbackTaskEraseAll(), false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executePenSetting() {
        Logger.m10999d(TAG, "executePenSetting");
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.executePenSetting();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeRemoteEraser() {
        Logger.m10999d(TAG, "executeRemoteEraser");
        if (this.mView == null || !this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
            return;
        }
        this.mView.executeRemoteEraser();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeRemoteFavoritePen(boolean z) {
        String str = TAG;
        Logger.m10999d(str, "executeRemoteFavoritePen");
        if (this.mView == null || this.mHwSettingPresenter == null || !this.mComposerViewPresenter.isFocusable()) {
            Logger.m11003i(str, "executeRemoteFavoritePen# mView or mHwSettingPresenter is null");
            return;
        }
        if (isDeleteOnlyState()) {
            Logger.m11003i(str, "executeRemoteFavoritePen# skip because delete only");
        } else if (this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
            this.mView.updateRemoteFavoritePen(this.mHwSettingPresenter.executeRemoteFavoritePen(z), getColorTheme());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeSelectedChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        Logger.m11003i(TAG, "executeSelectedChangeStyle# " + spenSettingUIChangeStyleInfo.toString());
        this.mTaskController.execute(new TaskChangeStyle(), new TaskChangeStyle.InputValues(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getWritingToolManager(), this.mObjectManager, spenSettingUIChangeStyleInfo), null, false);
    }

    public AiMenuManager getAiMenuManager() {
        return this.mAiMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public int getBackgroundThemeColor() {
        return this.mComposerViewPresenter.getBackgroundThemeColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public List<Integer> getCollaborationViewSupportedMenuIdList() {
        return this.mCollaborationViewSupportedMenuIdList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public int getColorTheme() {
        return this.mComposerViewPresenter.isComposerViewDarkTheme() ? 1 : 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public String getCurrentPageInfo() {
        String strConvertToArabicNumber = LocaleUtils.convertToArabicNumber(this.mComposerViewPresenter.getWritingToolManager().getPageCount() - 1);
        String strConvertToArabicNumber2 = LocaleUtils.convertToArabicNumber(this.mComposerViewPresenter.getCurrentPageIndex() + 1);
        return LocaleUtils.isRTLMode() ? AbstractC0541b.m775q("(", strConvertToArabicNumber, "/", strConvertToArabicNumber2, ")") : AbstractC0541b.m775q("(", strConvertToArabicNumber2, "/", strConvertToArabicNumber, ")");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public HWToolbarPolicyManager getHWToolbarPolicyManager() {
        return this.mHWToolbarPolicyManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public ObjectManager getObjectManager() {
        return this.mObjectManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public HwSettingPresenter getSettingInstance() {
        return this.mHwSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @Nullable
    public HwToolbarContract.IView getView() {
        return this.mView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public WritingToolManager getWritingToolManager() {
        return this.mComposerViewPresenter.getWritingToolManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hide() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.hide();
        removeComposerViewListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideAiSuggestionView() {
        AiMenuManager aiMenuManager = this.mAiMenuManager;
        if (aiMenuManager != null) {
            aiMenuManager.hideAiSuggestionView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hidePopupsWithSpoid() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.hidePopupsWithSpoid();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideSettingPenMini() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.hideSettingPenMini();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideSoftInput() {
        this.mControllerManager.getSoftInputManager().hide(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void hideToolbar() {
        if (this.mView == null || !this.mComposerModel.getModeManager().isEditMode()) {
            return;
        }
        Logger.m10999d(TAG, "hideToolbar# ");
        hide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void initFirstCase() {
        this.mComposerModel.getComposerState().setLastStateLockCanvas(this.mComposerViewPresenter.getPageManager().getDocPageInfo().isZoomLocked());
    }

    public boolean isAssistanceSelected() {
        return this.mHwSettingPresenter.isAssistanceSelected();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isDeleteOnlyState() {
        return this.mComposerModel.getModeManager().isDeleteOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isDockingMode() {
        return this.mIsDockingMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEasyWritingPadEnabled() {
        return this.mComposerViewPresenter.isEasyWritingPadEnabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEnableUndoRedoMenu() {
        return (this.mIsAlignmentRunning || this.mIsConvertToTextRunning || this.mAiMenuManager.getAiContextMenuPresenter().isTranslating()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEraseCurrentTwoPage() {
        if (this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage()) {
            return (this.mComposerViewPresenter.getWritingToolManager().getPageCount() % 2 == 0 && this.mComposerViewPresenter.getWritingToolManager().getPageCount() + (-2) == this.mComposerViewPresenter.getCurrentPageIndex()) ? false : true;
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isIdleWorkingState() {
        return this.mComposerModel.getComposerSaveModel().isIdleWorkingState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isLastStateLockCanvas() {
        return this.mComposerModel.isLastStateLockCanvas();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isMoveOnlyMode() {
        return this.mComposerModel.getModeManager().isMoveOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isMoveOnlyState() {
        return this.mComposerModel.getModeManager().isMoveOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isPdfReader() {
        return this.mComposerViewPresenter.getComposerModel().isPDFReader();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isRedoable() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isRedoable() && this.mAiMenuManager.isNotScanningAnimating();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public boolean isSelected(int i) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            return iView.isSelected(i);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isShowing() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return false;
        }
        return iView.isShowing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isShownSoftInput() {
        return this.mControllerManager.getSoftInputManager().isInputMethodShown();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSolveMathEnabled() {
        return this.mAiMenuManager.getSolveMathPresenter().isEnabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSupportEraseCurrentPage() {
        return (this.mComposerViewPresenter.getWritingToolManager().isSinglePageMode() || this.mComposerViewPresenter.getWritingToolManager().getPageCount() == 2 || this.mComposerViewPresenter.getWritingToolManager().getPageCount() - 1 == this.mComposerViewPresenter.getCurrentPageIndex()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSupportedAiMenu() {
        return this.mComposerViewPresenter.getComposerModel().getComposerState().isSupportedAiMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTabletLayout() {
        return this.mComposerModel.isTabletLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTaskRunningInUndoRedoPresenter() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isTaskRunning();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTextButtonEnabled() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTextMode() {
        return this.mComposerModel.getModeManager().isMode(Mode.Text);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isUndoable() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isUndoable() && this.mAiMenuManager.isNotScanningAnimating();
    }

    public boolean isWritingMode() {
        return this.mComposerModel.getModeManager().isMode(Mode.Writing);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isZoomLocked() {
        return this.mComposerViewPresenter.isZoomLocked();
    }

    public void notifyOnUndoRedo() {
        if (this.mView != null) {
            getSettingInstance().onObjectChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void offEasyWritingPad() {
        this.mHwSettingPresenter.setEasyWritingPad(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onAlignmentProgress(boolean z) {
        Logger.m11003i(TAG, "onAlignmentProgress " + z);
        if (getSettingInstance().isShownSettingViews(8192)) {
            getSettingInstance().setEnabledSettingView(8192, !z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onAlignmentRunning(boolean z) {
        AbstractC8014b.m7224z("onAlignmentRunning ", TAG, z);
        this.mIsAlignmentRunning = z;
        updateEnableUndoRedoMenu();
        if (z || !getSettingInstance().isShownSettingViews(8192)) {
            return;
        }
        getSettingInstance().hideSettingView(8192);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onAlignmentUpdateResult(ArrayList<RectF> arrayList) {
        Logger.m11003i(TAG, "onAlignmentUpdateResult " + arrayList);
        if (FeatureInfo.isBeautifierFeatureEnabled()) {
            RectF rectF = new RectF();
            for (RectF rectF2 : arrayList) {
                if (!rectF2.isEmpty()) {
                    rectF.union(rectF2);
                }
            }
            Rect rect = new Rect();
            rectF.round(rect);
            int dimension = (int) this.mComposerViewPresenter.getView().getResources().getDimension(C9086R.dimen.comp_hw_alignment_anchor_margin);
            ViewGroup viewGroup = (ViewGroup) this.mComposerViewPresenter.getActivity().getWindow().getDecorView();
            View viewFindViewById = viewGroup.findViewById(C9086R.id.comp_list_container_border);
            if (viewFindViewById != null) {
                rect.offset((int) viewFindViewById.getX(), 0);
            }
            View viewFindViewById2 = viewGroup.findViewById(C9086R.id.start_docker);
            if (viewFindViewById2 != null) {
                rect.offset(viewFindViewById2.getWidth(), 0);
            }
            View viewFindViewById3 = viewGroup.findViewById(C9086R.id.floating_layout_container);
            Rect rect2 = new Rect((int) viewFindViewById3.getX(), (int) viewFindViewById3.getY(), viewFindViewById3.getWidth(), viewFindViewById3.getHeight());
            View viewFindViewById4 = viewGroup.findViewById(C9086R.id.bottom_docker);
            if (viewFindViewById4 != null) {
                rect2.bottom -= viewFindViewById4.getHeight();
            }
            AnchorInfo anchorInfo = new AnchorInfo(rect, viewFindViewById3, rect2, dimension);
            anchorInfo.setPriorityArea(ViewAnchorUtil.Area.BOTTOM);
            if (getSettingInstance().isShownSettingViews(8192)) {
                getSettingInstance().updateAnchorSettingView(128, 8192, anchorInfo);
            } else {
                getSettingInstance().showAnchorSettingView(128, 8192, anchorInfo);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean onBackPressed() {
        if (!isEasyWritingPadEnabled()) {
            return false;
        }
        offEasyWritingPad();
        Logger.m10999d(TAG, "onBackPressed : cancel EasyWritingPad");
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        int colorTheme = getColorTheme(i, z, z2);
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.setColorTheme(colorTheme);
            this.mView.updateBackgroundColor(i, z, z2);
        }
        this.mHwSettingPresenter.onColorThemeChanged(colorTheme);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onConvertToTextRunning(boolean z) {
        AbstractC8014b.m7224z("onConvertToTextRunning ", TAG, z);
        this.mIsConvertToTextRunning = z;
        updateEnableUndoRedoMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onDetachView() {
        this.mView = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onHideSolveMathContextMenu() {
        this.mAiMenuManager.getSolveMathPresenter().onHideContextMenu();
    }

    public void onItemSelected(int i) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.onItemSelected(i);
        }
    }

    public void onNoteAssistClick(Runnable runnable) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.onNoteAssistClick(runnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onPageCountChanged() {
        this.mHwSettingPresenter.setPageCount(this.mComposerViewPresenter.getWritingToolManager().getPageCount());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onPageIndexChanged() {
        this.mHwSettingPresenter.setPageIndex(this.mComposerViewPresenter.getCurrentPageIndex());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void onPageLayoutChanged() {
        this.mHwSettingPresenter.setTwoPageView(this.mComposerViewPresenter.getComposerModel().getTextOnlyModeState().getLastPageColumn() == 2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @SuppressLint({"SuspiciousIndentation"})
    public boolean onPreClick(int i) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mHwSettingPresenter.onSaveInstanceState(bundle);
        if (this.mView == null || !this.mComposerModel.getModeManager().isEditMode()) {
            return;
        }
        this.mView.onSaveInstanceState(bundle);
    }

    public void onSelected(int i) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.callOnSelected(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerModeController.HwToolbarContract
    public boolean onTouchOutside() {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            return iView.onTouchOutside();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void openSelectionChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo) {
        this.mHwSettingPresenter.openSelectionChangeStyle(spenSettingUIChangeStyleInfo, z, anchorInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void reboundSettingPenMiniVI() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.reboundSettingPenMiniVI();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void redo() {
        this.mComposerViewPresenter.redo();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void release() {
        removeComposerViewListeners();
        unregisterConfigurationChangedObserver();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void releaseAssistPopup() {
        this.mAiMenuManager.releaseAiDrawingPopup(TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().removePreTouchListener(preTouchListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void requestFocusToComposerView() {
        this.mComposerViewPresenter.requestFocus();
    }

    @UiThread
    public void restoreFromRemoteTypePresenter() {
        Logger.m11003i(TAG, "restoreFromRemoteTypePresenter");
        this.mHwSettingPresenter.reloadHwToolbarState();
        HwSettingPresenter hwSettingPresenter = this.mHwSettingPresenter;
        if (hwSettingPresenter instanceof RemoteHwSettingPresenter) {
            this.mHwSettingPresenter = ((RemoteHwSettingPresenter) hwSettingPresenter).getSuperClass();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void restoreHwToolbarState(HwToolbarState hwToolbarState) {
        this.mHwSettingPresenter.restoreHwToolbarState(hwToolbarState);
    }

    public void restoreSettingState(Bundle bundle) {
        this.mHwSettingPresenter.restore(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void restoreViewState(Bundle bundle) {
        if (this.mView == null || !this.mComposerModel.getModeManager().isEditMode()) {
            return;
        }
        this.mView.restore(bundle);
    }

    public void setAiMenuManager(AiMenuManager aiMenuManager) {
        this.mAiMenuManager = aiMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setBlockContextMenu(boolean z) {
        this.mComposerViewPresenter.getListenerManager().getContextMenuListener().blockContextMenu(TAG, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setCollaborationViewSupportedMenuIdList(List<Integer> list) {
        this.mCollaborationViewSupportedMenuIdList = list;
    }

    public void setConnectionStickyMemo(boolean z) {
        this.mHwSettingPresenter.setConnectionStickyMemo(z);
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.onFocusStickyMemo(!z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setEasyWritingPadEnabled(boolean z) {
        this.mComposerViewPresenter.setEasyWritingPadEnabled(z);
    }

    public void setEyedropperEnabled(boolean z) {
        getSettingInstance().getSettingInfoManager().setEyedropperEnabled(z);
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.onEyeDropperChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setLastStateLockCanvas(boolean z) {
        this.mComposerModel.setLastStateLockCanvas(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setMenuDirty() {
        this.mComposerModel.setMenuDirty("HwToolbar");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setModelZoomLock(boolean z) {
        if (this.mComposerModel.getModeManager().isMode(Mode.View)) {
            return;
        }
        this.mComposerViewPresenter.getPageManager().getDocPageInfo().setZoomLocked(z);
    }

    public void setQtHwToolbarStateListener(HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener) {
        this.mQTListener = qtHwToolbarStateListener;
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.setQtHwToolbarStateListener(qtHwToolbarStateListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void setSelectedEraserButton() {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateSelectionState(4, true, false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void setSelectedLaserPenButton() {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateSelectionState(262144, true, false);
        }
    }

    public void setSolveMathEnabled(boolean z) {
        this.mHwSettingPresenter.setSolveMathEnabled(z);
        ComposerSA.insertLog("401", "3521", z ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setSpenGestureControllerListener(SpenGestureControllerImpl spenGestureControllerImpl) {
        this.mComposerViewPresenter.getListenerManager().setSpenGestureControllerListener(spenGestureControllerImpl);
    }

    public void setStickyMemoManager(@Nullable IStickyMemoManager iStickyMemoManager) {
        this.mStickyMemoManager = iStickyMemoManager;
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setToolbarPosition(Rect rect, boolean z) {
        this.mComposerViewPresenter.setToolbarPosition(rect, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void setUnselectedDirectWriteButton() {
        unselect(8192);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setView(@Nullable HwToolbarContract.IView iView) {
        this.mView = iView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setZoomLock(boolean z) {
        this.mComposerViewPresenter.setZoomLock(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void show() {
        HwToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.show();
        addComposerViewListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showAiAssistMenu(View view, AnchorPosition anchorPosition) {
        HwToolbarContract.IView iView;
        if (view == null) {
            return;
        }
        boolean z = (this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated() && this.mAiMenuManager.getAiContextMenuPresenter().isAiMenuForTranslation()) ? false : true;
        if (this.mAiMenuManager.isShowingContextMenu()) {
            this.mAiMenuManager.hideContextMenu(z);
        } else if (this.mAiMenuManager.isShowingResultView()) {
            this.mAiMenuManager.releaseSelectionForResultView();
        }
        boolean zIsMode = this.mComposerModel.getModeManager().isMode(Mode.Writing);
        this.mAiMenuManager.setIsStartTextMode(!zIsMode);
        if (zIsMode) {
            getWritingToolManager().clearControl();
            getSettingInstance().setEasyWritingPad(false);
            if (isPdfReader() && (iView = this.mView) != null) {
                iView.updateSelectionState(1024, false, false);
            }
            if (!this.mComposerViewPresenter.getPdfManager().hasSelectedText() && !this.mObjectManager.getSelectedObjectManager().isPureStrokeSelectedOnly()) {
                this.mObjectManager.clearSelection();
            }
        }
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.hideSoftInputAndExecute(new RunnableC8928b(this, 10, view, anchorPosition));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showCleanUpAndCTT() {
        this.mMenuManager.hideStickyMemo("3");
        getWritingToolManager().clearControl();
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mComposerViewPresenter.clearSmoothScrollAndScaleToFitPage();
        this.mComposerViewPresenter.hideSoftInputAndExecute(new RunnableC9899b(this, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showLanguageSettingDialog() {
        this.mDialogManager.showHwBeautifierLanguageDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showLockCanvasToolTip() {
        this.mComposerViewPresenter.showLockCanvasToolTip();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showSettingPenMini() {
        if (this.mView == null || isDeleteOnlyState()) {
            return;
        }
        this.mView.showSettingPenMini();
    }

    public void showSettingPopupOfLaserPen(boolean z, View.OnClickListener onClickListener) {
        if (this.mView == null || this.mComposerViewPresenter.getActivity() == null) {
            return;
        }
        this.mView.showSettingPopupOfLaserPen(z, onClickListener);
        View viewFindViewById = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.floating_layout_container);
        this.mHwSettingPresenter.showAnchorSettingView(0, 32768, new AnchorInfo(new Rect(viewFindViewById.getRight() - 1, viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getTop() + 1), viewFindViewById));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showSoftInput() {
        if (!this.mComposerViewPresenter.getObjectManager().isFocusedTextBox()) {
            this.mComposerViewPresenter.getObjectManager().selectObject(this.mComposerViewPresenter.getObjectManager().getTextManager().getTextBox());
        }
        this.mComposerViewPresenter.setForceShowKeyboard();
        this.mControllerManager.getSoftInputManager().show(true);
        this.mComposerViewPresenter.requestFocus();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void showToolbar() {
        if (this.mView == null || !this.mComposerModel.getModeManager().isEditMode()) {
            return;
        }
        Logger.m10999d(TAG, "showToolbar# ");
        show();
    }

    public void toggleZoomLock() {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.toggleZoomLock();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void undo() {
        this.mComposerViewPresenter.undo();
    }

    public void unselect(int i) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.unselect(i);
        }
    }

    public void updateDeleteOnlyState(boolean z) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateDeleteOnlyState(z);
        }
    }

    public void updateEnableUndoRedoMenu() {
        if (isEnableUndoRedoMenu()) {
            updateUndoRedoMenu();
        } else {
            getSettingInstance().onUndoable(false);
            getSettingInstance().onRedoable(false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void updateMoveOnlyMode(boolean z) {
        HwToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateMoveOnlyState(z);
        }
    }

    public void updateMoveOnlyState(boolean z) {
        this.mComposerViewPresenter.getComposerControllerManager().getComposerModeController().updateMoveOnlyModeState(z, this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getHWToolbarPresenter());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public HwToolbarState updateSelectionMode() {
        HwToolbarState hwToolbarState = new HwToolbarState();
        hwToolbarState.copyData(this.mHwSettingPresenter.getHwToolbarState());
        Mode mode = this.mComposerModel.getModeManager().getMode();
        Mode prevMode = this.mComposerModel.getModeManager().getPrevMode();
        if (mode == Mode.Text) {
            Mode mode2 = Mode.Writing;
            if (prevMode == mode2 && hwToolbarState.getSelectedMenu().contains(8192)) {
                hwToolbarState.addSelectedMenu(Integer.valueOf(hwToolbarState.getLastPenType()));
                hwToolbarState.removeSelectedMenu(8192);
                hwToolbarState.removeSelectedMenu(65536);
            } else {
                hwToolbarState.addSelectedMenu(65536);
            }
            this.mComposerModel.getModeManager().setMode(mode2, "updateSelectionMode", true);
        }
        this.mHwSettingPresenter.updateSelectionMode();
        return hwToolbarState;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerModeController.HwToolbarContract
    public void updateToolTypeAction() {
        if (isDeleteOnlyState() || isMoveOnlyState()) {
            return;
        }
        getSettingInstance().updateToolTypeAction();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.HWToolbarContract
    public void updateToolbarItemList() {
        this.mView.updateToolbarItemList();
    }

    public void updateUndoRedo(boolean z, boolean z2) {
        if (this.mView != null) {
            getSettingInstance().onRedoable(z);
            getSettingInstance().onUndoable(z2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void updateUndoRedoMenu() {
        getSettingInstance().onUndoable(this.mComposerViewPresenter.getUndoRedoPresenter().isUndoable());
        getSettingInstance().onRedoable(this.mComposerViewPresenter.getUndoRedoPresenter().isRedoable());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void updatedLastPenInfo() {
        SpenSettingUIPenInfo lastPenInfoInNote = this.mComposerModel.getLastPenInfoInNote();
        if (lastPenInfoInNote != null) {
            this.mHwSettingPresenter.setAllTypePenSettingInfo(lastPenInfoInNote);
            this.mComposerModel.clearLastPenInfoInNote();
        }
    }

    private int getColorTheme(int i, boolean z, boolean z2) {
        return BackgroundColorUtil.isComposerViewDarkTheme(this.mComposerViewPresenter.getActivity(), i, z, z2) ? 1 : 0;
    }
}
