package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.FontSizeUtil;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RemoteRtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtTableAndCellStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtTextStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.KeyboardUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import java.util.List;
import p237r3.RunnableC14448a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtToolbarPresenter implements RtToolbarContract.IPresenter, TextManager.OnCurrentTextStateListener, NoteManager.ObserverBackgroundColor {
    private static final String TAG = Logger.createTag("RtToolbarPresenter");
    private final ActionManager mActionManager;
    private AiMenuManager mAiMenuManager;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogManager;
    private final Handler mHandler;
    private boolean mIsDockingMode;
    private final KeyguardPresenter mKeyguardPresenter;
    private SpanStates mLastRtState;
    private final ListenerManager mListenerManager;
    private final ObjectManager mObjectManager;
    private RtSettingPresenter mRtSettingPresenter;
    private final RtTableAndCellStylePresenter mRtTableAndCellStylePresenter;
    private final RtTextStylePresenter mRtTextStylePresenter;
    private final SoftInputManager mSoftInputManager;
    private final TextManager mTextManager;
    private ToolShareControl mToolShareControl;
    private Runnable mUpdateRunnable;

    @Nullable
    private RtToolbarContract.IView mView;

    public RtToolbarPresenter(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull ActionManager actionManager, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
        TextManager textManager = composerViewPresenter.getTextManager();
        this.mTextManager = textManager;
        textManager.setListener(this);
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mListenerManager = composerViewPresenter.getListenerManager();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        composerViewPresenter.getNoteManager().addBackgroundColorObserver(this);
        this.mDialogManager = dialogPresenterManager;
        this.mHandler = new Handler();
        this.mRtSettingPresenter = new RtSettingPresenter(composerViewPresenter, this);
        this.mActionManager = actionManager;
        this.mKeyguardPresenter = keyguardPresenter;
        this.mControllerManager = controllerManager;
        this.mRtTextStylePresenter = new RtTextStylePresenter(composerViewPresenter);
        this.mRtTableAndCellStylePresenter = new RtTableAndCellStylePresenter(composerViewPresenter, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShowWindow$1() {
        if (this.mView != null) {
            this.mTextManager.setAutoBlinkOffOnWindowFocusChanged(true);
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl == null || !toolShareControl.getEnabled()) {
                return;
            }
            this.mToolShareControl.setAutoBlinkOffOnWindowFocusChanged(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAiMenu$2(View view) {
        if (this.mView != null) {
            this.mAiMenuManager.showAiContextMenu(view, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateState$0() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.lambda$update$3(this.mLastRtState);
        this.mUpdateRunnable = null;
    }

    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(preTouchListener);
    }

    public void addTextBox() {
        this.mControllerManager.getClipboardController().closeClipboard();
        this.mObjectManager.addTextBox(this.mComposerViewPresenter.getCurrentPageIndex());
    }

    public boolean canShowAiContextMenu() {
        return this.mAiMenuManager.canShowAiContextMenu();
    }

    public void changeWritingMode() {
        hideAiMenu(false);
        this.mComposerModel.getModeManager().setMode(Mode.Writing, "rich text change mode", true);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mDialogManager.showCanNotUseSpenDialog();
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null) {
            toolShareControl.changeHwMode();
        }
    }

    public void consumeCursorEvent() {
        this.mListenerManager.consumeDelayedCursorChangeEvent();
    }

    public RemoteRtSettingPresenter convertToRemoteTypePresenter(RemoteFunctionContract.PresenterContract presenterContract) {
        Logger.m11003i(TAG, "convertToRemoteTypePresenter");
        RemoteRtSettingPresenter remoteRtSettingPresenter = new RemoteRtSettingPresenter(this.mRtSettingPresenter, presenterContract);
        this.mRtSettingPresenter = remoteRtSettingPresenter;
        return remoteRtSettingPresenter;
    }

    public void enableDockingMode(boolean z) {
        this.mIsDockingMode = z;
    }

    public void enableMenus(boolean z, List<Integer> list) {
        if (this.mView != null) {
            this.mRtSettingPresenter.setEnableMenus(z, list);
        }
    }

    public void executeAiAssist() {
        Logger.m10999d(TAG, "executeAiAssist");
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.executeAiAssist();
        }
    }

    public void executeTextStyle() {
        Logger.m10999d(TAG, "executeTextStyle");
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.executeTextStyle();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public int getBackgroundColor() {
        return this.mComposerViewPresenter.getBackgroundThemeColor();
    }

    public int getColorTheme() {
        return isComposerViewDarkTheme() ? 1 : 0;
    }

    public ComposerViewPresenter getComposerViewPresenter() {
        return this.mComposerViewPresenter;
    }

    public int getCurrentViewFontSize() {
        return this.mTextManager.getCurrentViewFontSize();
    }

    public int[] getFontSizeList() {
        RtToolbarContract.IView iView = this.mView;
        return (iView == null || iView.getView() == null) ? new int[0] : FontSizeUtil.getFontSizeList(this.mView.getView().getContext());
    }

    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public SpanStates getLastRtState() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            SpanStates lastState = this.mToolShareControl.getLastState();
            if (lastState != null) {
                return lastState;
            }
            Logger.m10999d(TAG, "getLastRtState# return value of memo is null");
        }
        return this.mTextManager.getLastTextState();
    }

    public RtSettingPresenter getRtSettingPresenter() {
        return this.mRtSettingPresenter;
    }

    public RtTableAndCellStylePresenter getRtTableAndCellStylePresenter() {
        return this.mRtTableAndCellStylePresenter;
    }

    public RtTextStylePresenter getRtTextStylePresenter() {
        return this.mRtTextStylePresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    @Nullable
    public RtToolbarContract.IView getView() {
        return this.mView;
    }

    public void hide() {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.hide();
        }
    }

    public void hideAiMenu(boolean z) {
        if (this.mAiMenuManager.isShowingContextMenu()) {
            this.mAiMenuManager.hideContextMenu(z);
        } else if (this.mAiMenuManager.isShowingResultView()) {
            this.mAiMenuManager.releaseSelectionForResultView();
        }
        if (!z) {
            if (this.mComposerViewPresenter.getComposerModel().isTabletLayout() && this.mAiMenuManager.isShowingMenu()) {
                this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText();
            }
            this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
        }
        this.mAiMenuManager.hideAiSuggestionView();
    }

    public void hideAll() {
        Logger.m11003i(TAG, "hideAll");
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.hideAll();
        }
        this.mAiMenuManager.hideContextMenu(true);
    }

    public void hideSoftInput() {
        this.mSoftInputManager.hide(true);
    }

    public boolean isAiMenuForTranslationAndTranslated() {
        return this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated() && this.mAiMenuManager.getAiContextMenuPresenter().isAiMenuForTranslation();
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public boolean isComposerViewDarkTheme() {
        return this.mComposerViewPresenter.isComposerViewDarkTheme();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public boolean isDirectWriteRecognizing() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return false;
        }
        return iView.isDirectWriteRecognizing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public boolean isDirectWriteUsing() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return false;
        }
        return iView.isDirectWriteUsing();
    }

    public boolean isDockingMode() {
        return this.mIsDockingMode;
    }

    public boolean isEnableUndoRedoMenu() {
        return !this.mAiMenuManager.getAiContextMenuPresenter().isTranslating();
    }

    public boolean isIdleWorkingState() {
        return this.mComposerModel.getComposerSaveModel().isIdleWorkingState();
    }

    public boolean isMde() {
        return this.mComposerModel.getMdeManager().getMdeInfo().isMde();
    }

    public boolean isPDFReader() {
        return this.mComposerModel.isPDFReader();
    }

    public boolean isRedoable() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isRedoable() && this.mAiMenuManager.isNotScanningAnimating();
    }

    public boolean isShowingAiMenu() {
        return false;
    }

    public boolean isShowingAiResultWorking() {
        AiMenuManager aiMenuManager = this.mAiMenuManager;
        if (aiMenuManager == null) {
            return false;
        }
        boolean zIsShowingAiResultWorking = aiMenuManager.isShowingAiResultWorking();
        AbstractC8014b.m7220v("isShowingAiResultWorking : ", TAG, zIsShowingAiResultWorking);
        return zIsShowingAiResultWorking;
    }

    public boolean isSupportedAutoFormat() {
        return FeatureInfo.isAiFeatureEnabled() && this.mComposerModel.getComposerState().isSupportedAiMenu() && DeviceInfo.isVSTModel();
    }

    public boolean isTabletLayout() {
        return this.mComposerModel.isTabletLayout();
    }

    public boolean isTaskRunningInUndoRedoPresenter() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isTaskRunning();
    }

    public boolean isTextMode() {
        return this.mComposerModel.getModeManager().isMode(Mode.Text);
    }

    public boolean isUndoable() {
        return this.mComposerViewPresenter.getUndoRedoPresenter().isUndoable() && this.mAiMenuManager.isNotScanningAnimating();
    }

    public boolean isValid() {
        return true;
    }

    public boolean needToUpdateFontSize() {
        com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.SpanStates lastTextState = this.mTextManager.getLastTextState();
        if (lastTextState.getFontSize().isEnable()) {
            return false;
        }
        lastTextState.getFontSize().setEnable(true);
        return true;
    }

    public void notifyOnUndoRedo() {
        if (this.mView == null || !DeviceInfo.isVSTModel()) {
            return;
        }
        this.mView.onObjectChanged();
    }

    public void onAttachView() {
        this.mTextManager.setListener(this);
        this.mTextManager.setAutoBlinkOffOnWindowFocusChanged(true);
        this.mRtSettingPresenter.updateViewTheme(isComposerViewDarkTheme());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        boolean zIsComposerViewDarkTheme = BackgroundColorUtil.isComposerViewDarkTheme(this.mComposerViewPresenter.getActivity(), i, z, z2);
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateFontBgColor(zIsComposerViewDarkTheme ? 1 : 0);
            this.mView.updateBackgroundColor(i, z, z2);
        }
        this.mRtSettingPresenter.updateBackgroundColor(i);
        this.mRtSettingPresenter.updateViewTheme(zIsComposerViewDarkTheme);
    }

    public void onDetachView() {
        this.mTextManager.setListener(null);
        RtToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.onDetach();
        this.mView = null;
        Runnable runnable = this.mUpdateRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        RtToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.onSaveInstanceState(bundle);
        }
    }

    public void onShowWindow() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null || iView.getView() == null) {
            return;
        }
        this.mTextManager.setAutoBlinkOffOnWindowFocusChanged(false);
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setAutoBlinkOffOnWindowFocusChanged(false);
        }
        this.mView.getView().postDelayed(new RunnableC14448a(this, 1), 400L);
    }

    public void redo() {
        this.mComposerViewPresenter.redo();
    }

    public void registerHistoryEventListener() {
        this.mComposerViewPresenter.getListenerManager().registerHistoryEventListener(this.mView);
    }

    public void releaseAiDrawingPopup() {
        this.mAiMenuManager.releaseAiDrawingPopup(TAG);
    }

    public void releaseHistoryEventListener() {
        this.mComposerViewPresenter.getListenerManager().releaseHistoryEventListener(this.mView);
    }

    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().removePreTouchListener(preTouchListener);
    }

    @UiThread
    public void restoreFromRemoteTypePresenter() {
        Logger.m11003i(TAG, "restoreFromRemoteTypePresenter");
        RtSettingPresenter rtSettingPresenter = this.mRtSettingPresenter;
        if (rtSettingPresenter instanceof RemoteRtSettingPresenter) {
            this.mRtSettingPresenter = ((RemoteRtSettingPresenter) rtSettingPresenter).getSuperClass();
        }
    }

    public void restoreState(Bundle bundle) {
        RtToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.lambda$restore$4(bundle);
        }
    }

    public void setAiMenuManager(AiMenuManager aiMenuManager) {
        this.mAiMenuManager = aiMenuManager;
    }

    public void setAlign(int i) {
        hideAiMenu(false);
        this.mObjectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setAlign(i, true);
        this.mObjectManager.commitHistory();
    }

    public void setFontSize(int i) {
        boolean z;
        this.mObjectManager.commitHistory();
        if (this.mComposerModel.getDoc().isGroupingHistory()) {
            z = false;
        } else {
            this.mComposerModel.getDoc().beginHistoryGroup();
            z = true;
        }
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setFontSize(i);
        if (z) {
            this.mComposerModel.getDoc().endHistoryGroup();
        }
    }

    public void setFontSizeAndUpdate(int i) {
        hideAiMenu(false);
        setFontSize(i);
        update(this.mTextManager.getLastTextState());
    }

    public void setFontSizeWithTask(int i) {
        this.mControllerManager.getTaskController().execute(new TaskFontSize(), new TaskFontSize.InputValues(this, i), null, false);
    }

    public void setIndent(boolean z) {
        hideAiMenu(false);
        this.mActionManager.doAction(z ? ActionManager.ActionType.TextIndent : ActionManager.ActionType.TextOutdent, TAG);
    }

    public void setMenuDirty() {
        this.mComposerModel.setMenuDirty("RtToolbar");
    }

    public void setTask(int i, boolean z) {
        hideAiMenu(false);
        this.mObjectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setTask(i, z);
        this.mObjectManager.commitHistory();
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.onUpdateTask(i);
        }
    }

    public void setTextBgColor(int i) {
        this.mRtSettingPresenter.setTextBgColor(i);
    }

    public void setTextColor(int i) {
        this.mRtSettingPresenter.setTextColor(i);
    }

    public void setTextFormat(int i) {
        hideAiMenu(false);
        this.mObjectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setTextFormat(i, true);
        this.mObjectManager.commitHistory();
    }

    public void setTextStyle(int i, boolean z) {
        hideAiMenu(false);
        this.mObjectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setStyle(i, z);
        this.mObjectManager.commitHistory();
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    public void setToolTypeAction(int i, int i2) {
        this.mComposerViewPresenter.getWritingToolManager().setToolTypeAction(i, i2);
    }

    public void setView(@Nullable RtToolbarContract.IView iView) {
        this.mView = iView;
    }

    public boolean shouldAlwaysShowInTextMode() {
        return Build.VERSION.SDK_INT < 30 || KeyboardUtils.INSTANCE.isExternalKeyboardConnected(this.mComposerViewPresenter.getActivity()) || DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mComposerViewPresenter.getActivity());
    }

    public void show() {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.show();
        }
    }

    public void showAiMenu(View view) {
        this.mComposerViewPresenter.setContextMenu(false);
        this.mAiMenuManager.setIsStartTextMode(true);
        if (this.mSoftInputManager.isInputMethodShown()) {
            long j = this.mComposerModel.isSingleMode() ? 800L : 500L;
            this.mSoftInputManager.hide((View) null);
            this.mHandler.postDelayed(new RunnableC10960a(this, view, 29), j);
        } else if (this.mView != null) {
            this.mAiMenuManager.showAiContextMenu(view, null);
        }
    }

    public void showAlignSetting(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.showAlignPopup(view, onClickValueListener);
        }
    }

    public void showFontColorSetting(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.showFontColorSetting(view, onClickValueListener);
        }
    }

    public void showFontSizeSetting(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.showFontSize(view, onClickValueListener);
        }
    }

    public void showSoftInput() {
        if (!this.mObjectManager.isFocusedTextBox()) {
            this.mObjectManager.selectObject(this.mTextManager.getTextBox());
        }
        if (isDirectWriteUsing()) {
            Logger.m11003i(TAG, "skip SoftInput cause DirectWrite using");
        } else {
            this.mSoftInputManager.show(true);
        }
    }

    public void showTextColor(boolean z) {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.showTextColor(z);
    }

    public void toggleTask(int i) {
        setTask(i, this.mLastRtState.getTask().getValue() != i);
    }

    public void undo() {
        this.mComposerViewPresenter.undo();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.TextManager.OnCurrentTextStateListener
    public void update(com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.SpanStates spanStates) {
        updateState(spanStates);
    }

    public void updateEnableUndoRedoMenu() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.updateEnableUndoRedoMenu(isEnableUndoRedoMenu());
    }

    public void updateFontSize() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.updateFontSize();
    }

    public void updateRichTextState() {
        this.mTextManager.updateRichTextState();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IPresenter
    public void updateState(SpanStates spanStates) {
        this.mLastRtState = spanStates;
        if (this.mView == null) {
            return;
        }
        Runnable runnable = this.mUpdateRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mUpdateRunnable = null;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            RunnableC14448a runnableC14448a = new RunnableC14448a(this, 0);
            this.mUpdateRunnable = runnableC14448a;
            this.mHandler.post(runnableC14448a);
        } else {
            this.mView.lambda$update$3(spanStates);
            AiMenuManager aiMenuManager = this.mAiMenuManager;
            if (aiMenuManager != null) {
                aiMenuManager.hideAiSuggestionView();
            }
        }
        this.mRtSettingPresenter.updateFontColor(spanStates.getFontColor().getValue());
        this.mRtSettingPresenter.updateFontBgColor(spanStates.getFontBgColor().getValue());
    }

    public void updateTextStyles() {
        RtToolbarContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.updateTextStyles();
    }

    public void updateUndoRedo(boolean z, boolean z2) {
        RtToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateUndoRedo(z, z2);
        }
    }
}
