package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.DirectWriteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteSettingDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("DirectWriteSettingDialogPresenter");
    private final DialogContract.IDialogCreator mCreator;
    private final DirectWriteManager mDirectWriteManager;
    private final WritingToolManager mWritingToolManager;

    public DirectWriteSettingDialogPresenter(DialogContract.IDialogCreator iDialogCreator, WritingToolManager writingToolManager, ComposerModel composerModel) {
        this.mCreator = iDialogCreator;
        this.mWritingToolManager = writingToolManager;
        this.mDirectWriteManager = composerModel.getDirectWriteManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public String getKeyboardLanguage() {
        return this.mDirectWriteManager.getKeyboardLanguage();
    }

    public String getLanguage() {
        return this.mDirectWriteManager.getDirectWriteLanguage();
    }

    public int getTextType() {
        return this.mDirectWriteManager.getDirectWriteTextType();
    }

    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    public boolean isLanguageMatched() {
        return this.mDirectWriteManager.isLanguageMatched();
    }

    public void setLanguage(String str) {
        this.mDirectWriteManager.setDirectWriteLanguage(str);
        ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_STT_LANGUAGE_SETTINGS, str);
    }

    public void setLanguageMatching(boolean z) {
        this.mDirectWriteManager.setLanguageMatching(z);
    }

    public void setTextType(int i) {
        this.mDirectWriteManager.setDirectWriteTextType(i);
        this.mWritingToolManager.setSPenToTextTargetMode(i);
        ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_STT_INSERT_TEXT_SETTINGS, i == 0 ? "a" : "b");
    }

    public void showDirectWriteSettingDialog() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && !this.mActivity.isDestroyed()) {
            ((AppCompatActivity) this.mActivity).getSupportFragmentManager().beginTransaction().add(this.mCreator.createDirectWriteSettingDialogFragment(), TAG).commitAllowingStateLoss();
            ((AppCompatActivity) this.mActivity).getSupportFragmentManager().executePendingTransactions();
        } else {
            Logger.m10999d(TAG, "showDirectWriteSettingDialog# " + this.mActivity);
        }
    }

    public void updateLanguage(String str) {
        this.mWritingToolManager.updateSTTRecognitionLanguage(str);
    }
}
