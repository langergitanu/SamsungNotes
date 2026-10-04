package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.HWToolbarPolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface HwToolbarPresenterImpl {
    void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener);

    boolean canShowAiContextMenu();

    void changeTextMode();

    void changeWritingMode();

    void clearContextMenu();

    void dismissDirectWriteSettingDialog();

    void enableDockingMode(boolean z);

    void executeEraseAllOnAllPages();

    void executeEraseAllOnCurrentPage(int i);

    void executePenSetting();

    void executeRemoteEraser();

    void executeRemoteFavoritePen(boolean z);

    void executeSelectedChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo);

    int getBackgroundThemeColor();

    List<Integer> getCollaborationViewSupportedMenuIdList();

    int getColorTheme();

    String getCurrentPageInfo();

    HWToolbarPolicyManager getHWToolbarPolicyManager();

    KeyguardPresenter getKeyguardPresenter();

    ObjectManager getObjectManager();

    HwSettingPresenter getSettingInstance();

    HwToolbarContract.IView getView();

    WritingToolManager getWritingToolManager();

    void hide();

    void hideAiSuggestionView();

    void hidePopupsWithSpoid();

    void hideSettingPenMini();

    void hideSoftInput();

    void initFirstCase();

    boolean isCoeditNote();

    boolean isDeleteOnlyState();

    boolean isDockingMode();

    boolean isEasyWritingPadEnabled();

    boolean isEnableUndoRedoMenu();

    boolean isEraseCurrentTwoPage();

    boolean isIdleWorkingState();

    boolean isLastStateLockCanvas();

    boolean isMoveOnlyMode();

    boolean isMoveOnlyState();

    boolean isPdfReader();

    boolean isRedoable();

    boolean isShowing();

    boolean isShownSoftInput();

    boolean isSolveMathEnabled();

    boolean isSupportEraseCurrentPage();

    boolean isSupportedAiMenu();

    boolean isTabletLayout();

    boolean isTaskRunningInUndoRedoPresenter();

    boolean isTextButtonEnabled();

    boolean isTextMode();

    boolean isUndoable();

    boolean isZoomLocked();

    void offEasyWritingPad();

    boolean onBackPressed();

    void onDetachView();

    void onHideSolveMathContextMenu();

    boolean onPreClick(int i);

    void onSaveInstanceState(@NonNull Bundle bundle);

    void openSelectionChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo);

    void reboundSettingPenMiniVI();

    void redo();

    void release();

    void releaseAssistPopup();

    void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener);

    void requestFocusToComposerView();

    void restoreViewState(Bundle bundle);

    void setBlockContextMenu(boolean z);

    void setCollaborationViewSupportedMenuIdList(List<Integer> list);

    void setEasyWritingPadEnabled(boolean z);

    void setLastStateLockCanvas(boolean z);

    void setMenuDirty();

    void setModelZoomLock(boolean z);

    void setSpenGestureControllerListener(SpenGestureControllerImpl spenGestureControllerImpl);

    void setToolbarPosition(Rect rect, boolean z);

    void setView(HwToolbarContract.IView iView);

    void setZoomLock(boolean z);

    void show();

    void showAiAssistMenu(View view, AnchorPosition anchorPosition);

    void showCleanUpAndCTT();

    void showLanguageSettingDialog();

    void showLockCanvasToolTip();

    void showSettingPenMini();

    void showSoftInput();

    void undo();

    void updateUndoRedoMenu();

    void updatedLastPenInfo();
}
