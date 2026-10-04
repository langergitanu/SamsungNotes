package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSipController implements SoftInputManager.OnSipListener {
    private static final String TAG = Logger.createTag("CVP$ComposerSipController");
    private ComposerModel mComposerModel;
    private ControllerManager mControllerManager;
    private FocusManager mFocusManager;
    private ObjectManager mObjectManager;
    private Runnable mRunnableHideKeyboard;
    private Runnable mRunnableShowKeyboard;
    private ComposerControllerContract mView;
    private WritingToolManager mWritingToolManager;

    private Runnable getRunnableHideKeyboard(boolean z) {
        AbstractC8014b.m7224z("getRunnableHideKeyboard#", TAG, z);
        if (this.mRunnableHideKeyboard == null && z) {
            this.mRunnableHideKeyboard = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerSipController.2
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(ComposerSipController.TAG, "mRunnableHideKeyboard#");
                    if (ComposerSipController.this.mView == null || ComposerSipController.this.mComposerModel == null) {
                        return;
                    }
                    Mode mode = ComposerSipController.this.mComposerModel.getModeManager().getMode();
                    if (mode == Mode.Text && ComposerSipController.this.mObjectManager.isFocusedTextBox()) {
                        Logger.m11003i(ComposerSipController.TAG, "mRunnableHideKeyboard# isFocusedTextBox()");
                        return;
                    }
                    if (mode == Mode.Search) {
                        Logger.m11003i(ComposerSipController.TAG, "mRunnableHideKeyboard# Search mode on");
                    } else if (ComposerSipController.this.mWritingToolManager.isFloatingViewShown()) {
                        Logger.m11003i(ComposerSipController.TAG, "mRunnableHideKeyboard# isFloatingViewShown is true.");
                    } else {
                        ComposerSipController.this.mControllerManager.getSoftInputManager().hide(ComposerSipController.this.mView.getView());
                    }
                }
            };
        }
        return this.mRunnableHideKeyboard;
    }

    private Runnable getRunnableShowKeyboard(boolean z) {
        if (this.mRunnableShowKeyboard == null && z) {
            this.mRunnableShowKeyboard = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerSipController.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(ComposerSipController.TAG, "mRunnableShowKeyboard#");
                    if (ComposerSipController.this.mView == null || ComposerSipController.this.mComposerModel == null || !ComposerSipController.this.mComposerModel.getModeManager().isSipMode()) {
                        return;
                    }
                    ComposerSipController.this.mControllerManager.getSoftInputManager().show(ComposerSipController.this.mView.getView());
                }
            };
        }
        return this.mRunnableShowKeyboard;
    }

    public void init(ComposerModel composerModel, ControllerManager controllerManager, ModelManager modelManager) {
        this.mComposerModel = composerModel;
        this.mControllerManager = controllerManager;
        this.mObjectManager = modelManager.getObjectManager();
        this.mWritingToolManager = modelManager.getWritingToolManager();
        controllerManager.getSoftInputManager().addOnSipListener(this);
    }

    public boolean isKeyboardShowing(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        return currentFocus instanceof EditText ? ((EditText) currentFocus).isCursorVisible() : (this.mComposerModel.getModeManager().isMode(Mode.Text) && this.mObjectManager.isFocusedTextBox()) || this.mWritingToolManager.isEditing();
    }

    public void onGetWindowFocus(Activity activity) {
        if (this.mView == null) {
            Logger.m11000e(TAG, "onGetWindowFocus mView is null");
            return;
        }
        ModeManager modeManager = this.mComposerModel.getModeManager();
        FocusManager focusManager = this.mFocusManager;
        if (focusManager != null && focusManager.hasFocus(focusManager.mainTarget)) {
            Logger.m11004w(TAG, "onGetWindowFocus skip by FocusManager");
            return;
        }
        if (InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mView.getView().getContext())) {
            if (modeManager.isMode(Mode.View)) {
                this.mView.getView().postDelayed(getRunnableHideKeyboard(true), 200L);
                return;
            } else {
                this.mView.getView().postDelayed(getRunnableShowKeyboard(true), 200L);
                return;
            }
        }
        if (this.mControllerManager.getSoftInputManager().isClearSkip()) {
            Logger.m11004w(TAG, "onGetWindowFocus skip");
            this.mControllerManager.getSoftInputManager().setClearSkip(false);
            return;
        }
        boolean lastSipState = this.mControllerManager.getSoftInputManager().getLastSipState();
        this.mControllerManager.getSoftInputManager().clearLastState();
        if (lastSipState && isKeyboardShowing(activity)) {
            this.mView.getView().postDelayed(getRunnableShowKeyboard(true), 200L);
            return;
        }
        if (activity.getCurrentFocus() instanceof EditText ? !((EditText) r6).isCursorVisible() : true) {
            this.mView.getView().postDelayed(getRunnableHideKeyboard(true), 200L);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
    }

    public void releaseKeyboardRunnable() {
        if (this.mView != null) {
            if (getRunnableHideKeyboard(false) != null) {
                this.mView.getView().removeCallbacks(this.mRunnableHideKeyboard);
            }
            if (getRunnableShowKeyboard(false) != null) {
                this.mView.getView().removeCallbacks(this.mRunnableShowKeyboard);
            }
        }
    }

    public void setFocusManager(FocusManager focusManager) {
        this.mFocusManager = focusManager;
    }

    public void setSIPInputModeHidden(Activity activity, boolean z, int i) {
        boolean zIsKeyboardConnected;
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager != null) {
            controllerManager.getSoftInputManager().setWindowMode(i);
        }
        ComposerControllerContract composerControllerContract = this.mView;
        int i2 = 16;
        if (composerControllerContract == null || composerControllerContract.getView() == null) {
            zIsKeyboardConnected = false;
        } else {
            zIsKeyboardConnected = InputMethodCompat.getInstance().isKeyboardConnected(this.mView.getView().getContext());
            if (!FeatureInfo.isWindowInsetsAnimationWithSipEnabled() || ((FeatureInfo.isSoftInputModeAdjustResizeEnabled() && i != 0) || zIsKeyboardConnected)) {
                ControllerManager controllerManager2 = this.mControllerManager;
                if (controllerManager2 != null && (!zIsKeyboardConnected || !z)) {
                    controllerManager2.getSoftInputManager().initBottomPadding(activity);
                }
            } else {
                i2 = 32;
            }
        }
        Logger.m10999d(TAG, "setSIPInputModeHidden# mode : " + Integer.toHexString(i2) + ", windowMode : " + i + ", isKeyboardConnected : " + zIsKeyboardConnected + ", needSIPControl : " + z);
        if (z) {
            activity.getWindow().setSoftInputMode(i2);
        } else {
            activity.getWindow().setSoftInputMode(i2 | SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK);
        }
    }

    public void setTemporarySoftInputMode(int i) {
        this.mControllerManager.getSoftInputManager().setTemporarySoftInputMode(i);
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        ControllerManager controllerManager;
        this.mView = composerControllerContract;
        if (composerControllerContract != null || (controllerManager = this.mControllerManager) == null) {
            return;
        }
        controllerManager.getSoftInputManager().removeOnSipListener(this);
    }

    public void updateClipboardFilter(boolean z, String str) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract == null || !composerControllerContract.getView().isFocused()) {
            return;
        }
        if (z) {
            this.mControllerManager.getClipboardController().clearFilter(str);
        } else {
            this.mControllerManager.getClipboardController().setClipboardFilter(ClipboardManagerCompat.INSTANCE.getInstance().getTypeAll(), str);
        }
    }
}
