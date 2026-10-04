package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ConvertSettingDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("ConvertSettingDialogPresenter");
    private final DialogContract.IDialogCreator mCreator;
    private boolean mIsBodyTextOnly = false;
    private boolean mIsFilteredByTranslationLanguageList = false;
    private final WritingToolManager mWritingToolManager;

    public ConvertSettingDialogPresenter(DialogContract.IDialogCreator iDialogCreator, WritingToolManager writingToolManager) {
        this.mCreator = iDialogCreator;
        this.mWritingToolManager = writingToolManager;
    }

    public void dismissConvertSettingDialog() {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11003i(TAG, "dismissConvertSettingDialog# isNotAvailableActivity" + this.mActivity);
            return;
        }
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity);
        if (dialogFragmentFindFragmentByTag == null) {
            return;
        }
        Logger.m11003i(TAG, "dismissConvertSettingDialog");
        dialogFragmentFindFragmentByTag.dismiss();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    public boolean isBodyTextOnly() {
        return this.mIsBodyTextOnly;
    }

    public boolean isFilteredByTranslationLanguageList() {
        return this.mIsFilteredByTranslationLanguageList;
    }

    public boolean isFloatingViewShown() {
        return this.mWritingToolManager.isFloatingViewShown();
    }

    public void showConvertSettingDialog(boolean z, boolean z2) {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11003i(TAG, "showConvertSettingDialog# " + this.mActivity);
            return;
        }
        this.mIsBodyTextOnly = !z;
        this.mIsFilteredByTranslationLanguageList = z2;
        ((AppCompatActivity) this.mActivity).getSupportFragmentManager().beginTransaction().add(this.mCreator.createConvertSettingDialogFragment(), TAG).commitAllowingStateLoss();
        ((AppCompatActivity) this.mActivity).getSupportFragmentManager().executePendingTransactions();
    }

    public void updateLanguage(String str) {
        this.mWritingToolManager.updateLanguage(str);
    }
}
