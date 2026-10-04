package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.text.TextUtils;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ModeObserver implements Observer {
    public static final int SIP_DELAY_MILLIS = 500;
    protected ComposerViewPresenter mCompViewPresenter;
    private ComposerModel mComposerModel;
    protected ControllerManager mControllerManager;
    protected MenuPresenterManager mMenuPresenterManager;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ModeObserver$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C99531 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$model$mode$Mode */
        static final /* synthetic */ int[] f7066xb41f9be;

        static {
            int[] iArr = new int[Mode.values().length];
            f7066xb41f9be = iArr;
            try {
                iArr[Mode.ReadOnly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7066xb41f9be[Mode.Text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7066xb41f9be[Mode.Writing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7066xb41f9be[Mode.Search.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7066xb41f9be[Mode.View.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private boolean canUseMoveOnlyMode() {
        return DeviceInfo.isVSTModel() || this.mComposerModel.isPDFReader();
    }

    private void changeFromViewSearch(ModeManager modeManager) {
        if (modeManager.getPrevMode() == Mode.View || modeManager.getPrevMode() == Mode.Search) {
            if (this.mMenuPresenterManager.getSearchModePresenter() != null) {
                this.mMenuPresenterManager.getSearchModePresenter().hide();
            }
            this.mMenuPresenterManager.invalidateOptionsMenu();
        }
    }

    private void showSoftInput(Object obj) {
        if (obj == null) {
            this.mControllerManager.getSoftInputManager().show((View) null);
            return;
        }
        if (obj instanceof ModeManager.SIPShowType) {
            if (obj == ModeManager.SIPShowType.NOT) {
                return;
            }
            if (obj == ModeManager.SIPShowType.FORCE) {
                this.mControllerManager.getSoftInputManager().forceToShow(null, 500L);
                return;
            } else if (obj == ModeManager.SIPShowType.DELAY) {
                this.mControllerManager.getSoftInputManager().delayForceToShow(null, 500L);
                return;
            }
        }
        this.mControllerManager.getSoftInputManager().show((View) null);
    }

    private void updateBySubMode(ModeManager modeManager) {
        this.mMenuPresenterManager.invalidateOptionsMenu();
        this.mMenuPresenterManager.updateDeleteOnlyState(modeManager.isDeleteOnlyMode());
        if (canUseMoveOnlyMode() && modeManager.isEditMode() && (!DeviceInfo.isVSTModel() || modeManager.isMode(Mode.Writing))) {
            this.mCompViewPresenter.getHWToolbarPresenter().updateMoveOnlyMode(modeManager.isMoveOnlyMode());
            this.mMenuPresenterManager.updateMoveOnlyState(modeManager.isMoveOnlyMode());
        }
        if (!modeManager.isSubModeEnabled()) {
            this.mControllerManager.getClipboardController().setClipboardFilter(ClipboardManagerCompat.INSTANCE.getInstance().getTypeAll(), "updateBySubMode");
        } else {
            this.mMenuPresenterManager.getQuickNotePresenter().onChangedNotAvailableMode(modeManager.getMode());
            this.mControllerManager.getClipboardController().setClipboardFilter(ClipboardManagerCompat.INSTANCE.getInstance().getTypeText(), "updateBySubMode, sub mode");
        }
    }

    private void updateInputFormMode(ModeManager modeManager) {
        this.mCompViewPresenter.setInputFormEnabled(modeManager.isInputFormMode());
        this.mMenuPresenterManager.invalidateOptionsMenu();
    }

    public void init(ComposerViewPresenter composerViewPresenter, MenuPresenterManager menuPresenterManager, ControllerManager controllerManager, ModeManager modeManager) {
        this.mCompViewPresenter = composerViewPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mMenuPresenterManager = menuPresenterManager;
        this.mControllerManager = controllerManager;
        modeManager.addObserver(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        boolean z;
        boolean zIsInputMethodShown;
        if (!(observable instanceof ModeManager)) {
            return;
        }
        if (obj instanceof ModeManager.SubMode) {
            updateBySubMode((ModeManager) observable);
            return;
        }
        if (obj instanceof ModeManager.ExtraMode) {
            updateInputFormMode((ModeManager) observable);
            return;
        }
        ModeManager modeManager = (ModeManager) observable;
        Mode prevMode = modeManager.getPrevMode();
        if (FeatureInfo.isSearchSTTInComposerEnabled() && modeManager.isPreModeComposerSearchMode() && modeManager.getMode() != Mode.Search) {
            this.mMenuPresenterManager.getSearchModePresenter().clearSearchSTT();
        }
        if (modeManager.isPreModeComposerViewMode() && modeManager.isEditModeWithoutReadOnly() && !this.mComposerModel.getCoeditAdapter().takeServerWritePermission()) {
            modeManager.setMode(prevMode, "coedit no server write permission", false);
            return;
        }
        int i = C99531.f7066xb41f9be[modeManager.getMode().ordinal()];
        if (i != 1) {
            if (i == 2) {
                changeFromViewSearch(modeManager);
                this.mControllerManager.getProgressController().enableToHideNavigationBar(false);
                zIsInputMethodShown = prevMode == Mode.Init ? this.mControllerManager.getSoftInputManager().isInputMethodShown() : true;
                if ((obj instanceof String) && ComposerConstants.TAG_NO_CURSOR.equals((String) obj)) {
                    zIsInputMethodShown = false;
                    z = true;
                } else {
                    z = false;
                }
                if (prevMode == Mode.ReadOnly) {
                    this.mMenuPresenterManager.invalidateOptionsMenu();
                }
                this.mMenuPresenterManager.getQuickNotePresenter().onChangedAvailableMode(prevMode);
            } else if (i == 3) {
                this.mControllerManager.getProgressController().enableToHideNavigationBar(true);
                this.mControllerManager.getSoftInputManager().hide((View) null);
                changeFromViewSearch(modeManager);
                if (prevMode == Mode.ReadOnly) {
                    this.mMenuPresenterManager.invalidateOptionsMenu();
                }
                this.mMenuPresenterManager.getQuickNotePresenter().onChangedAvailableMode(prevMode);
            } else if (i == 4) {
                String str = obj instanceof String ? (String) obj : "";
                if (FeatureInfo.isSearchSTTInComposerEnabled()) {
                    this.mMenuPresenterManager.getSearchModePresenter().showWithChangeMode(str);
                } else {
                    this.mMenuPresenterManager.getAiMenuManager().hideResultView();
                    this.mMenuPresenterManager.invalidateOptionsMenu();
                    this.mMenuPresenterManager.getSearchModePresenter().show(str);
                }
                if (TextUtils.isEmpty(str)) {
                    z = false;
                    zIsInputMethodShown = true;
                }
            } else if (i == 5) {
                modeManager.setInputFormMode(false);
                this.mControllerManager.getSoftInputManager().hide((View) null);
                this.mControllerManager.getProgressController().enableToHideNavigationBar(false);
                if (modeManager.isEditModeWithReadOnly(prevMode)) {
                    this.mMenuPresenterManager.invalidateOptionsMenu();
                    this.mComposerModel.getCoeditAdapter().requestServerReadPermission();
                } else {
                    changeFromViewSearch(modeManager);
                }
                this.mMenuPresenterManager.getQuickNotePresenter().onChangedNotAvailableMode(modeManager.getMode());
            }
            this.mMenuPresenterManager.getQuickToolPresenter().setVisibility(modeManager.getMode() != Mode.Writing ? 0 : 8);
            this.mMenuPresenterManager.onChangeMode(modeManager.getMode());
            this.mMenuPresenterManager.updateToolbarByMode(false);
            if (z) {
                this.mCompViewPresenter.getComposerControllerManager().getComposerModeController().setBlockingSelectBodyText(true);
            }
            this.mCompViewPresenter.onChangeMode(modeManager);
            if (z) {
                this.mCompViewPresenter.getComposerControllerManager().getComposerModeController().setBlockingSelectBodyText(false);
            }
            this.mMenuPresenterManager.getRtToolbarPresenter().updateFontSize();
            this.mMenuPresenterManager.getVoiceRecordMenuPresenter().changeMode(modeManager.isEditMode());
            if (zIsInputMethodShown) {
                return;
            }
            showSoftInput(obj);
            return;
        }
        this.mControllerManager.getSoftInputManager().hide((View) null);
        changeFromViewSearch(modeManager);
        this.mMenuPresenterManager.getQuickNotePresenter().onChangedNotAvailableMode(modeManager.getMode());
        zIsInputMethodShown = false;
        z = false;
        this.mMenuPresenterManager.getQuickToolPresenter().setVisibility(modeManager.getMode() != Mode.Writing ? 0 : 8);
        this.mMenuPresenterManager.onChangeMode(modeManager.getMode());
        this.mMenuPresenterManager.updateToolbarByMode(false);
        if (z) {
        }
        this.mCompViewPresenter.onChangeMode(modeManager);
        if (z) {
        }
        this.mMenuPresenterManager.getRtToolbarPresenter().updateFontSize();
        this.mMenuPresenterManager.getVoiceRecordMenuPresenter().changeMode(modeManager.isEditMode());
        if (zIsInputMethodShown) {
        }
    }
}
