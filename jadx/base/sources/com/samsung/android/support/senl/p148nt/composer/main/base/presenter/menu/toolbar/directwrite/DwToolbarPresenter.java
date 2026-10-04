package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.DirectWriteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DwToolbarPresenter {
    public static final String TAG = "DwToolbarPresenter";
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogManager;
    private final DirectWriteManager mDirectWriteManager;
    private DwKeyboardLanguage mDwKeyboardLanguage;
    private Handler mHandler;
    private boolean mHasFocus;
    private boolean mIsFistTime;
    private boolean mIsRecognizing;
    private final ObjectManager mObjectManager;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private SPenSTTListener mSPenSTTListener;
    private SpenObjectSelectListener mSpenObjectSelectListener;

    @Nullable
    private DwToolbarContract.IView mView;
    private final WritingToolManager mWritingToolManager;

    public DwToolbarPresenter(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager) {
        ComposerModel composerModel = composerViewPresenter.getComposerModel();
        this.mComposerModel = composerModel;
        this.mComposerViewPresenter = composerViewPresenter;
        DirectWriteManager directWriteManager = composerModel.getDirectWriteManager();
        this.mDirectWriteManager = directWriteManager;
        this.mControllerManager = controllerManager;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        WritingToolManager writingToolManager = composerViewPresenter.getWritingToolManager();
        this.mWritingToolManager = writingToolManager;
        this.mDialogManager = dialogPresenterManager;
        setRecognizingState(false);
        this.mHandler = new Handler();
        this.mDwKeyboardLanguage = new DwKeyboardLanguage(composerViewPresenter.getActivity(), writingToolManager, directWriteManager, dialogPresenterManager);
        initListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTextBoxByPosition(float f, float f4, int i) {
        if (i != 1) {
            return;
        }
        blockSoftInput(true);
        this.mObjectManager.addTextBox(new PointF(f, f4));
        setRecognizingState(true);
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                DwToolbarPresenter.this.blockSoftInput(false);
            }
        });
    }

    private void initKeyboardFunction() {
        this.mHasFocus = true;
        this.mIsRecognizing = false;
    }

    private void initListeners() {
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                DwToolbarPresenter.this.setFocusState(z);
            }
        };
        this.mSPenSTTListener = new SPenSTTListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter.2
            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
            public void onPenDrawingStarted(float f, float f4, int i) {
                super.onPenDrawingStarted(f, f4, i);
                if (DwToolbarPresenter.this.mIsFistTime) {
                    DwToolbarPresenter.this.mIsFistTime = false;
                    if (DwToolbarPresenter.this.mObjectManager.isSelectedBodyText() || !DwToolbarPresenter.this.mObjectManager.isFocusedTextBox()) {
                        DwToolbarPresenter.this.addTextBoxByPosition(f, f4, i);
                    }
                    ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_HW_STT_ENTERED, i == 1 ? "b" : "a");
                } else {
                    DwToolbarPresenter.this.addTextBoxByPosition(f, f4, i);
                }
                if (DwToolbarPresenter.this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
                    if (i == 0) {
                        DwToolbarPresenter.this.blockSoftInput(true);
                    }
                    DwToolbarPresenter.this.mComposerModel.getModeManager().setMode(Mode.Text, "onSpenToTextPenDrawingStarted#", true);
                    if (i == 0) {
                        DwToolbarPresenter.this.blockSoftInput(false);
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
            public void onRecognitionFailed() {
                super.onRecognitionFailed();
                DwToolbarPresenter.this.setRecognizingState(false);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
            public void onRecognitionStarted() {
                super.onRecognitionStarted();
                DwToolbarPresenter.this.setRecognizingState(true);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
            public void onResultInserted() {
                super.onResultInserted();
                DwToolbarPresenter.this.setRecognizingState(false);
                if (DwToolbarPresenter.this.mControllerManager.getSoftInputManager().isInputMethodShown()) {
                    DwToolbarPresenter.this.hideSoftInput();
                }
                if (DwToolbarPresenter.this.mView == null || !DwToolbarPresenter.this.isMainThread()) {
                    return;
                }
                DwToolbarPresenter.this.mView.onSpenToTextResultInserted();
            }
        };
        this.mSpenObjectSelectListener = new SpenObjectSelectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter.3
            @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
            public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
                super.onObjectSelected(arrayList, arrayList2, z);
                if (DwToolbarPresenter.this.mDirectWriteManager == null || !DwToolbarPresenter.this.mDirectWriteManager.getDirectWriteEnableState()) {
                    return;
                }
                if (DwToolbarPresenter.this.mObjectManager == null || DwToolbarPresenter.this.mView == null || !DwToolbarPresenter.this.isMainThread()) {
                    Logger.m11003i(DwToolbarPresenter.TAG, "onSelectedObject ## prevent null access");
                } else {
                    DwToolbarPresenter dwToolbarPresenter = DwToolbarPresenter.this;
                    dwToolbarPresenter.setFocusState(dwToolbarPresenter.mObjectManager.isSelectedTextBox());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusState(boolean z) {
        AbstractC8014b.m7224z("setFocusState ", TAG, z);
        this.mHasFocus = z;
        updateKeyboardFunction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecognizingState(boolean z) {
        AbstractC8014b.m7224z("setRecognizingState ", TAG, z);
        this.mIsRecognizing = z;
        updateKeyboardFunction();
    }

    private void updateKeyboardFunction() {
        if (this.mView != null) {
            StringBuilder sb = new StringBuilder("updateKeyboardFunction# isRecognizing ");
            sb.append(this.mIsRecognizing);
            sb.append(", hasFocus ");
            AbstractC8014b.m7222x(sb, this.mHasFocus, TAG);
            this.mView.setKeyboardFunctionKeyEnable(!this.mIsRecognizing && this.mHasFocus);
        }
    }

    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(preTouchListener);
    }

    public void blockSoftInput(boolean z) {
        this.mControllerManager.getSoftInputManager().blockToShow(TAG, z, "Direct Write");
    }

    public void hideSoftInput() {
        this.mControllerManager.getSoftInputManager().hide(true);
    }

    public void initDirectWriteEnable() {
        int directWriteTextType = this.mDirectWriteManager.getDirectWriteTextType();
        AbstractC8014b.m7217s(directWriteTextType, "setDirectWritingTargetMode ", TAG);
        this.mWritingToolManager.setSPenToTextTargetMode(directWriteTextType);
        this.mDwKeyboardLanguage.applyRecognitionLanguage();
        initKeyboardFunction();
        updateKeyboardFunction();
    }

    public boolean isDirectWriteEnable() {
        return this.mDirectWriteManager.getDirectWriteEnableState();
    }

    public boolean isDirectWriteRecognizing() {
        return this.mIsRecognizing;
    }

    public boolean isShownSoftInput() {
        return this.mControllerManager.getSoftInputManager().isInputMethodShown();
    }

    public boolean isSupportEmoji() {
        String string;
        if ((!DeviceInfo.isSemDevice() && Build.VERSION.SDK_INT <= 30) || this.mComposerViewPresenter.getView() == null || (string = Settings.Secure.getString(this.mComposerViewPresenter.getView().getContext().getContentResolver(), "default_input_method")) == null) {
            return false;
        }
        return string.contains(DirectWriteConstant.SAMSUNG_HONEYBOARD_PKG_NAME);
    }

    public boolean isSupportSoftKeyboard() {
        if (this.mComposerViewPresenter.getView() == null) {
            return false;
        }
        Context context = this.mComposerViewPresenter.getView().getContext();
        if (InputMethodCompat.getInstance().isKeyboardConnected(context)) {
            return InputMethodCompat.getInstance().isShowImeWithHardKeyboardEnabled(context);
        }
        return true;
    }

    public void onAttachView() {
        initKeyboardFunction();
        this.mComposerViewPresenter.getListenerManager().addFocusChangeListener(this.mOnFocusChangeListener);
        this.mComposerViewPresenter.getListenerManager().addSpenSTTListener(this.mSPenSTTListener);
        this.mComposerViewPresenter.getListenerManager().addSpenObjectSelectListener(this.mSpenObjectSelectListener);
    }

    public void onDetachView() {
        this.mView = null;
        this.mComposerViewPresenter.getListenerManager().removeFocusChangeListener(this.mOnFocusChangeListener);
        this.mComposerViewPresenter.getListenerManager().removeSpenSTTListener(this.mSPenSTTListener);
        this.mComposerViewPresenter.getListenerManager().removeSpenObjectSelectListener(this.mSpenObjectSelectListener);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        DwToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.onSaveInstanceState(bundle);
        }
    }

    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mComposerViewPresenter.getListenerManager().removePreTouchListener(preTouchListener);
    }

    public void requestDirectWritingActionBackspace() {
        this.mWritingToolManager.requestSPenToTextAction(2);
    }

    public void requestDirectWritingActionEnter() {
        this.mWritingToolManager.requestSPenToTextAction(3);
    }

    public void requestDirectWritingActionSpace() {
        this.mWritingToolManager.requestSPenToTextAction(1);
    }

    public void restoreState(Bundle bundle) {
        DwToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.restore(bundle);
        }
    }

    public void setDirectWriteState(boolean z) {
        this.mDirectWriteManager.setDirectWriteEnableState(z);
        setDirectWritingEnable(z);
        if (z) {
            initDirectWriteEnable();
        } else {
            setRecognizingState(false);
        }
        this.mIsFistTime = z;
    }

    public void setDirectWritingEnable(boolean z) {
        AbstractC8014b.m7224z("setDirectWritingEnable ", TAG, z);
        this.mWritingToolManager.setSPenToTextEnable(z);
    }

    public void setDirectWritingTextColor(int i, int i2) {
        Logger.m11003i(TAG, "setDirectWritingTextColor " + Integer.toHexString(i));
        this.mWritingToolManager.setSPenToTextTextColor(i, i2);
    }

    public void setEmojiSIP() {
        Logger.m11003i(TAG, "emojiSIP with force show keyboard");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("board", "sticker");
            ((InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method")).sendAppPrivateCommand(this.mComposerViewPresenter.getView(), "com.samsung.android.honeyboard.action.SHOW_BOARD", bundle);
        } catch (NoSuchMethodError unused) {
            Logger.m11003i(TAG, "not support emoji keyboard");
        }
    }

    public void setFloatingSIP(int i) {
        Logger.m11003i(TAG, "floatingSIP with force show keyboard");
        try {
            Rect visibleRect = this.mView.getVisibleRect();
            Bundle bundle = new Bundle();
            bundle.putInt("x", i);
            bundle.putInt("y", visibleRect.top);
            bundle.putInt("width", visibleRect.right);
            bundle.putInt("height", visibleRect.bottom);
            ((InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method")).sendAppPrivateCommand(this.mComposerViewPresenter.getView(), DirectWriteConstant.DIRECT_WRITE_SHOW_FLOATING_KEYBOARD, bundle);
        } catch (NoSuchMethodError unused) {
            Logger.m11003i(TAG, "not support floating keyboard");
        }
    }

    public void setForceShowKeyboard() {
        Logger.m11003i(TAG, "STT with force show keyboard");
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 60000) {
            return;
        }
        try {
            ((InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method")).sendAppPrivateCommand(this.mComposerViewPresenter.getView(), DirectWriteConstant.DIRECT_WRITE_FORCE_SHOW_KEYBOARD, null);
        } catch (NoSuchMethodError unused) {
            Logger.m11003i(TAG, "not support emoji keyboard");
        }
    }

    public void setView(DwToolbarContract.IView iView) {
        this.mView = iView;
    }

    public void showDirectWriteSettingDialog() {
        this.mDialogManager.showDirectWriteSettingDialog();
    }

    public void showSoftInput() {
        if (!this.mComposerViewPresenter.getObjectManager().isFocusedTextBox()) {
            this.mComposerViewPresenter.getObjectManager().selectObject(this.mComposerViewPresenter.getObjectManager().getTextManager().getTextBox());
        }
        this.mControllerManager.getSoftInputManager().show(true);
        this.mComposerViewPresenter.requestFocus();
    }
}
