package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerModeController {
    private static final String TAG = Logger.createTag("CpV$ComposerModeController");
    protected ComposerModel mComposerModel;
    private ControllerManager mControllerManager;
    private NoteManager mNoteManager;
    protected ObjectManager mObjectManager;
    private ComposerSearchController mSearchController;
    private SettingsContentObserver.SettingsContentChangedCallback mSettingsContentChangedCallback;
    private TextManager mTextManager;
    protected ComposerControllerContract mView;
    protected WritingToolManager mWritingToolManager;
    private boolean mIsBlockingSelectBodyText = false;
    private final HyperTextUpdateController mHyperTextUpdateController = new HyperTextUpdateController();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HwToolbarContract {
        boolean isZoomLocked();

        boolean onTouchOutside();

        void setZoomLock(boolean z);

        void updateToolTypeAction();
    }

    private void addObserverInMdeInfo() {
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            this.mComposerModel.getMdeInfo().addObserver(new MdeInfo.ObserverAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerModeController.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.ObserverAdapter, com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
                public void onPermissionChanged(MdeInfo mdeInfo) {
                    ComposerModeController composerModeController = ComposerModeController.this;
                    composerModeController.setViewMode(composerModeController.mComposerModel.getModeManager());
                }
            });
        }
    }

    private void registerSpenActivationObserver() {
        if (DeviceUtils.isSpenModel()) {
            if (this.mSettingsContentChangedCallback == null) {
                this.mSettingsContentChangedCallback = new SettingsContentObserver.SettingsContentChangedCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerModeController.2
                    @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
                    public void onChanged(boolean z, Uri uri) {
                        boolean zIsSpenActivated = SpenUtils.isSpenActivated();
                        Logger.m10999d(ComposerModeController.TAG, "onChanged, uri/isSpenActivated " + uri + "/" + zIsSpenActivated);
                        WritingToolManager writingToolManager = ComposerModeController.this.mWritingToolManager;
                        writingToolManager.setToolTypeAction(2, writingToolManager.getToolTypeAction(2));
                    }
                };
            }
            unregisterSpenActivationObserver();
            SettingsContentObserver.INSTANCE.getInstance().addSettingsContentChangedCallback(this.mSettingsContentChangedCallback, SpenUtils.SETTINGS_SPEN_ACTIVATED, 0);
        }
    }

    private void setEditMode() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setEditMode();
        }
    }

    private void setMoveOnlyMode() {
        updateReadModeState();
        this.mWritingToolManager.setToolTypeAction(2, 1);
        this.mWritingToolManager.setToolTypeAction(6, 0);
    }

    private void unregisterSpenActivationObserver() {
        if (DeviceUtils.isSpenModel()) {
            SettingsContentObserver.INSTANCE.getInstance().removeSettingsContentChangedCallback(this.mSettingsContentChangedCallback);
        }
    }

    private void updateEditModeFromOtherMode(ModeManager modeManager) {
        if (modeManager.isEditModeWithoutReadOnly(modeManager.getPrevMode())) {
            return;
        }
        stopParsingHyperText();
        if (!TextUtils.isEmpty(this.mComposerModel.getSearchKeyword())) {
            this.mSearchController.search("", false);
        }
        setEditMode();
    }

    private void updateEditModeState(ModeManager modeManager, Activity activity, HwToolbarContract hwToolbarContract) {
        if (modeManager.isMode(Mode.ReadOnly)) {
            updateReadModeState();
            return;
        }
        updateEditModeFromOtherMode(modeManager);
        if (modeManager.isMode(Mode.Text)) {
            updateTextModeState(modeManager, activity);
        } else if (modeManager.isMode(Mode.Writing)) {
            updateWritingModeState(modeManager, activity, hwToolbarContract);
        }
    }

    private void updateReadModeState() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setModeOfSpenComposerView(false, 3);
        }
        this.mObjectManager.clearSelectObject();
        this.mControllerManager.getClipboardController().closeClipboard();
    }

    private void updateTextModeState(ModeManager modeManager, Activity activity) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setEditModeType(1);
        }
        if (this.mComposerModel.getDirectWriteManager().getDirectWriteEnableState()) {
            this.mWritingToolManager.setToolTypeAction(2, 16);
        } else {
            this.mWritingToolManager.setToolTypeAction(2, 1);
        }
        this.mWritingToolManager.setToolTypeAction(6, 0);
        if (!this.mIsBlockingSelectBodyText) {
            if (modeManager.getPrevMode() == Mode.View) {
                this.mNoteManager.getNote().selectObject(this.mNoteManager.getNote().getBodyText());
            } else if (modeManager.getPrevMode() == Mode.Search) {
                this.mTextManager.setAutoScrollToCursorOnLayoutChanged(false);
                this.mNoteManager.getNote().selectObject(this.mNoteManager.getNote().getBodyText());
                this.mTextManager.setAutoScrollToCursorOnLayoutChanged(true);
            } else {
                this.mNoteManager.getNote().selectObject(this.mTextManager.getFocusedObject());
            }
        }
        NavigationBarUtil.clearHideNavigationBarFlag(activity);
        updateDisallowTouchDownArea(false, activity);
    }

    private void updateViewModeState(ModeManager modeManager, Activity activity) {
        this.mWritingToolManager.setToolTypeAction(2, 1);
        this.mWritingToolManager.setToolTypeAction(6, 0);
        setViewMode(modeManager);
        if (!modeManager.isMode(Mode.View) || modeManager.getPrevMode().equals(Mode.Search)) {
            return;
        }
        NavigationBarUtil.clearHideNavigationBarFlag(activity);
        updateDisallowTouchDownArea(false, activity);
    }

    public void enableSelectionOnlyMode(boolean z) {
        AbstractC8014b.m7220v("enableSelectionOnlyMode# ", TAG, z);
        if (z) {
            this.mView.setModeOfSpenComposerView(false, 6);
        } else {
            this.mView.setEditMode();
            this.mView.setEditModeType(this.mComposerModel.getModeManager().isMode(Mode.Writing) ? 2 : 1);
        }
    }

    public HyperTextUpdateController getHyperTextUpdateController() {
        return this.mHyperTextUpdateController;
    }

    public void init(ComposerModel composerModel, ControllerManager controllerManager, ModelManager modelManager, ComposerSearchController composerSearchController) {
        this.mNoteManager = modelManager.getNoteManager();
        this.mObjectManager = modelManager.getObjectManager();
        this.mTextManager = modelManager.getTextManager();
        this.mWritingToolManager = modelManager.getWritingToolManager();
        this.mComposerModel = composerModel;
        this.mControllerManager = controllerManager;
        this.mSearchController = composerSearchController;
        registerSpenActivationObserver();
        addObserverInMdeInfo();
        this.mHyperTextUpdateController.init(composerModel, controllerManager, modelManager);
    }

    public void onChangeMode(ModeManager modeManager, Activity activity, HwToolbarContract hwToolbarContract) {
        String str = TAG;
        Logger.m10999d(str, "onChangeMode " + modeManager.getMode());
        if (this.mNoteManager != null) {
            Mode mode = Mode.Init;
            if (modeManager.isMode(mode)) {
                return;
            }
            this.mObjectManager.setHwMode(modeManager.isMode(Mode.Writing));
            if (modeManager.isComposerViewMode()) {
                updateViewModeState(modeManager, activity);
            } else if (modeManager.isEditModeWithReadOnly()) {
                updateEditModeState(modeManager, activity, hwToolbarContract);
            } else {
                Logger.m11000e(str, "onChangeMode " + modeManager.getMode());
            }
            ComposerControllerContract composerControllerContract = this.mView;
            if (composerControllerContract != null) {
                boolean zIsHyperTextEnabled = composerControllerContract.isHyperTextEnabled();
                boolean zIsComposerViewMode = this.mComposerModel.isSupportedViewMode() ? modeManager.isComposerViewMode() : modeManager.isMode(Mode.ReadOnly);
                if (!FeatureInfo.isSupportHyperTextInEditMode()) {
                    if (zIsHyperTextEnabled) {
                        zIsHyperTextEnabled = zIsComposerViewMode;
                    }
                    if (zIsHyperTextEnabled) {
                        this.mHyperTextUpdateController.parseHyperText(activity);
                    }
                } else if (zIsHyperTextEnabled && (zIsComposerViewMode || modeManager.getPrevMode() == mode)) {
                    this.mHyperTextUpdateController.parseHyperText(activity);
                }
                this.mView.setHyperLinkAndActionLink(zIsHyperTextEnabled, zIsComposerViewMode);
            }
        }
    }

    public void release() {
        this.mHyperTextUpdateController.release();
        unregisterSpenActivationObserver();
    }

    public void setBlockingSelectBodyText(boolean z) {
        this.mIsBlockingSelectBodyText = z;
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
        if (composerControllerContract != null) {
            this.mHyperTextUpdateController.setContext(composerControllerContract.getView().getContext());
        } else {
            this.mHyperTextUpdateController.setContext(null);
        }
    }

    public void setViewMode(ModeManager modeManager) {
        if (this.mView == null) {
            return;
        }
        this.mView.setModeOfSpenComposerView(modeManager.isMode(Mode.View), !this.mComposerModel.getMdeInfo().hasWritePermission() || !this.mComposerModel.isEditable() ? 5 : 2);
    }

    public void stopParsingHyperText() {
        this.mHyperTextUpdateController.stopParsingHyperText();
    }

    public void updateDisallowTouchDownArea(boolean z, Activity activity) {
        if (WindowManagerCompat.getInstance().isMultiWindowMode(activity)) {
            return;
        }
        int navigationBarHeight = InputMethodCompat.getInstance().getNavigationBarHeight(activity);
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.updateDisallowTouchDownArea(z, navigationBarHeight);
        }
    }

    public void updateMoveOnlyModeState(boolean z, Activity activity, HwToolbarContract hwToolbarContract) {
        AbstractC8014b.m7220v("updateMoveOnlyModeState: ", TAG, z);
        if (!z) {
            setEditMode();
            updateWritingModeState(this.mComposerModel.getModeManager(), activity, hwToolbarContract);
        } else {
            boolean zIsZoomLocked = hwToolbarContract.isZoomLocked();
            setMoveOnlyMode();
            hwToolbarContract.setZoomLock(zIsZoomLocked);
        }
    }

    public void updateWritingModeState(ModeManager modeManager, Activity activity, HwToolbarContract hwToolbarContract) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setEditModeType(2);
        }
        if (modeManager.getPrevMode() == Mode.Text) {
            this.mObjectManager.commitHistory();
        }
        this.mObjectManager.clearSelectObject(true);
        if (hwToolbarContract != null) {
            hwToolbarContract.updateToolTypeAction();
        }
        this.mWritingToolManager.setToolTypeAction(6, 8);
        if (NavigationBarUtil.hideNavigationBar(activity)) {
            updateDisallowTouchDownArea(true, activity);
        }
    }
}
