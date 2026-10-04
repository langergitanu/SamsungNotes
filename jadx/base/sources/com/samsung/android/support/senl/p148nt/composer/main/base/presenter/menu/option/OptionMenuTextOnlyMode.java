package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieResource;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.TextOnlyModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuTextOnlyMode {
    private static final String TAG = Logger.createTag("OptionMenuTextOnlyMode");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private AlertDialog mFTUDialog = null;
    private TextOnlyModeController.OnTextOnlyModeDisabledListener mOnTextOnlyModeDisabledListener;

    public OptionMenuTextOnlyMode(ComposerModel composerModel, ComposerViewPresenter composerViewPresenter) {
        this.mComposerModel = composerModel;
        this.mComposerViewPresenter = composerViewPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideGuideDialogForTextOnlyMode(boolean z) {
        if (this.mFTUDialog == null) {
            return;
        }
        if (z) {
            SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_MODE_TEXT_ONLY_GUIDE_TIP, true);
        }
        this.mFTUDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateOptionsMenu(Activity activity) {
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }

    private boolean isShowGuideDialogForTextOnlyMode() {
        return this.mFTUDialog != null;
    }

    private void setOnTextOnlyModeDisabledListener(final Activity activity, boolean z) {
        if (!z) {
            this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setOnTextOnlyModeDisabledListener(null);
            return;
        }
        if (this.mOnTextOnlyModeDisabledListener == null) {
            this.mOnTextOnlyModeDisabledListener = new TextOnlyModeController.OnTextOnlyModeDisabledListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuTextOnlyMode.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.TextOnlyModeController.OnTextOnlyModeDisabledListener
                public void onTextOnlyModeDisabled(int i) {
                    AbstractC8014b.m7217s(i, "onTextOnlyModeDisabled# ", OptionMenuTextOnlyMode.TAG);
                    if (i == 2) {
                        OptionMenuTextOnlyMode.this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setOnTextOnlyModeDisabledListener(null);
                        OptionMenuTextOnlyMode.this.invalidateOptionsMenu(activity);
                        ToastHelper.show((Context) activity, C9086R.string.composer_text_scale_disable_for_objects, 0, false);
                    }
                }
            };
        }
        this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setOnTextOnlyModeDisabledListener(this.mOnTextOnlyModeDisabledListener);
    }

    public boolean isStartWithTextOnly() {
        boolean zIsBodyTextOnlyNote;
        if (this.mComposerModel.isPDFReader() || this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            return false;
        }
        boolean zIsStartWithTextOnly = this.mComposerModel.getTextOnlyModeState().isStartWithTextOnly();
        if (!zIsStartWithTextOnly || (zIsBodyTextOnlyNote = this.mComposerModel.getComposerSpenDocModel().isBodyTextOnlyNote())) {
            return zIsStartWithTextOnly;
        }
        Logger.m11003i(TAG, "isStartWithTextOnly# isBodyTextOnlyNote = false");
        this.mComposerModel.getTextOnlyModeState().setIsStartWithTextOnly(zIsBodyTextOnlyNote);
        return zIsBodyTextOnlyNote;
    }

    public void setCanUseTextOnlyMode(Activity activity, boolean z, boolean z2) {
        if (this.mComposerModel.getTextOnlyModeState().canUseTextOnlyMode() == z) {
            if (z) {
                if (this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode() && !z2) {
                    this.mComposerModel.getTextOnlyModeState().setIsEnableTextOnlyMode(false);
                }
                this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setTextOnlyEnable(this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode());
                return;
            }
            return;
        }
        this.mComposerModel.getTextOnlyModeState().setCanUseTextOnlyMode(z);
        setOnTextOnlyModeDisabledListener(activity, z);
        boolean z3 = SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_MODE_TEXT_ONLY, false);
        Logger.m11003i(TAG, "setIsShownTextOnlyMode# isShown = " + z + " / " + z3);
        this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setTextOnlyEnable(z && z3 && z2);
        if (z || !isShowGuideDialogForTextOnlyMode()) {
            return;
        }
        hideGuideDialogForTextOnlyMode(false);
    }

    public void setDisableTextOnlyModeToHandwriting(Activity activity) {
        if (this.mComposerModel.getTextOnlyModeState().canUseTextOnlyMode() && this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode()) {
            this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setTextOnlyEnable(false);
            invalidateOptionsMenu(activity);
            ToastHelper.show((Context) activity, C9086R.string.composer_text_scale_disable_for_handwriting, 0, false);
        }
    }

    public void showGuideDialogForTextOnlyMode(final Activity activity) {
        if (!SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_MODE_TEXT_ONLY_GUIDE_TIP, false) && DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(activity) == DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
            if (layoutInflaterFrom == null) {
                return;
            }
            View viewInflate = layoutInflaterFrom.inflate(C9086R.layout.comp_ftu_dialog_fit_text_to_screen, (ViewGroup) null);
            builder.setView(viewInflate).setCancelable(false).setPositiveButton(activity.getResources().getString(C9086R.string.f6715OK), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuTextOnlyMode.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_MODE_TEXT_ONLY_GUIDE_TIP, true);
                    if (!OptionMenuTextOnlyMode.this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode()) {
                        OptionMenuTextOnlyMode.this.toggleForTextOnlyMode(activity);
                    }
                    AbstractC8014b.m7217s(i, "showFitToTextScreenFTUDialog:onClick# ", OptionMenuTextOnlyMode.TAG);
                    View viewFindViewById = activity.findViewById(C9086R.id.action_text_only_mode);
                    if (viewFindViewById == null) {
                        Logger.m11000e(OptionMenuTextOnlyMode.TAG, "showFitToTextScreenFTUDialog:action_text_only_mode view is null ");
                        return;
                    }
                    try {
                        new SmartTipPopup(viewFindViewById, activity.getResources().getString(C9086R.string.composer_fit_text_to_screen_smart_tip)).show();
                    } catch (InstantiationException e) {
                        Logger.m11000e(OptionMenuTextOnlyMode.TAG, "showFitToTextScreenFTUDialog:guideTipPopup " + e.getMessage());
                    }
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.mFTUDialog = alertDialogCreate;
            alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuTextOnlyMode.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    OptionMenuTextOnlyMode.this.mFTUDialog = null;
                }
            });
            this.mFTUDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuTextOnlyMode.4
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    OptionMenuTextOnlyMode.this.hideGuideDialogForTextOnlyMode(true);
                    return true;
                }
            });
            this.mFTUDialog.getWindow().setGravity(17);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(C9086R.id.lottie_view);
            lottieAnimationView.setAnimation(new LottieResource().setAssetName(ContextUtils.isNightMode(activity) ? "fit_text_to_screen_ftu_dark.json" : "fit_text_to_screen_ftu_light.json").getAssetName());
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
            this.mFTUDialog.show();
        }
    }

    public void toggleForTextOnlyMode(Activity activity) {
        boolean zIsEnableTextOnlyMode = this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode();
        boolean z = !zIsEnableTextOnlyMode;
        AbstractC8014b.m7224z("toggleForTextOnlyMode# enable = ", TAG, z);
        this.mComposerViewPresenter.getComposerControllerManager().getTextOnlyModeController().setTextOnlyEnable(z);
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_MODE_TEXT_ONLY, z);
        if (!zIsEnableTextOnlyMode) {
            if (this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
                this.mComposerModel.getModeManager().setMode(Mode.Text, "toggleForTextOnlyMode", true, Boolean.TRUE);
            } else if (this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
                this.mComposerModel.getModeManager().setPrevMode(Mode.Text);
            }
        }
        invalidateOptionsMenu(activity);
    }
}
