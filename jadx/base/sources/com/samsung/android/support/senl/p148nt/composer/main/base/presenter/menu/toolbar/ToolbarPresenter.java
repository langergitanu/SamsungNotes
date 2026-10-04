package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExternalKeyboardManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToolbarPresenter {
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final DialogPresenterManager mDialogManager;
    private final ExternalKeyboardManager mExternalKeyboardManager;
    private final ProgressController mProgressController;
    private final SoftInputManager mSoftInputManager;
    private ToolShareControl mToolShareControl;
    private ToolbarContract.IView mView;

    public ToolbarPresenter(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager) {
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mExternalKeyboardManager = controllerManager.getExternalKeyboardManager();
        this.mProgressController = controllerManager.getProgressController();
        this.mDialogManager = dialogPresenterManager;
    }

    public void addOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        this.mExternalKeyboardManager.addListener(onExternalKeyboardConnectedListener);
    }

    public void addOnSipListener(SoftInputManager.OnSipListener onSipListener) {
        this.mSoftInputManager.addOnSipListener(onSipListener);
    }

    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(preTouchListener);
    }

    public boolean canNotChangeMode() {
        return this.mProgressController.isShowingProgressCircle();
    }

    public void clearSelectedButtonsOfHandWritingToolbarItem() {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.clearSelectedButtonsOfHandWritingToolbarItem();
        }
    }

    public void close() {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.close();
        }
    }

    public int getBackgroundColor() {
        return this.mComposerViewPresenter.getBackgroundColor();
    }

    @Nullable
    public SpenPreTouchListenerImpl.PreTouchListener getPreTouchListener() {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            return iView.getPreTouchListener();
        }
        return null;
    }

    public View getToolbarView() {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            return iView.getToolbarView();
        }
        return null;
    }

    public boolean hasBackgroundImage() {
        return this.mComposerViewPresenter.hasBackgroundImage();
    }

    public void hide(boolean z) {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.hide(z);
        }
    }

    public boolean isBackgroundColorInverted() {
        return this.mComposerViewPresenter.isBackgroundColorInverted();
    }

    public boolean isPDFReader() {
        return this.mComposerModel.isPDFReader();
    }

    public boolean isSIPShowing() {
        return this.mSoftInputManager.isSipShowing();
    }

    public boolean isTabletLayout() {
        return this.mComposerModel.isTabletLayout();
    }

    public boolean isToolbarShowing() {
        ToolbarContract.IView iView = this.mView;
        return iView != null && iView.isToolbarShowing();
    }

    public void onClickHwToggleFab() {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.onClickHwToggleFab();
        }
    }

    public void release() {
        this.mView = null;
    }

    public void removeOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        this.mExternalKeyboardManager.removeListener(onExternalKeyboardConnectedListener);
    }

    public void removeOnSipListener(SoftInputManager.OnSipListener onSipListener) {
        this.mSoftInputManager.removeOnSipListener(onSipListener);
    }

    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().removePreTouchListener(preTouchListener);
    }

    public void requestCancelTouch() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl == null || !toolShareControl.getIsTouching()) {
            this.mComposerViewPresenter.requestCancelTouch();
        } else {
            this.mToolShareControl.requestToCancelTouch();
        }
    }

    public void setEnableToolTip(boolean z) {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.setEnableToolTip(z);
        }
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    public void setView(ToolbarContract.IView iView) {
        this.mView = iView;
    }

    public void show(boolean z) {
        ToolbarContract.IView iView = this.mView;
        if (iView != null) {
            iView.show(z);
        }
    }

    public void showCanNotUseSpenDialog() {
        this.mDialogManager.showCanNotUseSpenDialog();
    }
}
