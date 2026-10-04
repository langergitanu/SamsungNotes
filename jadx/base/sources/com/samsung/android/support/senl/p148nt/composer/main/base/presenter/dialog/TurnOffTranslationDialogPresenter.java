package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TurnOffTranslationDialogPresenter extends AbsDialogFragmentPresenter {
    public static final String KEY_TURN_OFF_TRANSLATION_TYPE = "KEY_TURN_OFF_TRANSLATION_TYPE";
    private static final String TAG = Logger.createTag("TurnOffTranslationDialogPresenter");
    public static final int TYPE_ADD_TO_NOTE = 3;
    public static final int TYPE_COPY = 5;
    public static final int TYPE_CUT = 4;
    public static final int TYPE_NORMAL = 6;
    public static final int TYPE_PRINT = 2;
    public static final int TYPE_SAVE = 0;
    public static final int TYPE_SHARE = 1;
    private final DialogContract.IDialogCreator mCreator;
    private final MenuPresenterManager mMenuPresenterManager;

    public TurnOffTranslationDialogPresenter(DialogContract.IDialogCreator iDialogCreator, MenuPresenterManager menuPresenterManager) {
        this.mCreator = iDialogCreator;
        this.mMenuPresenterManager = menuPresenterManager;
    }

    private DialogFragment createDialogFragment(int i) {
        DialogFragment dialogFragmentCreateTurnOffTranslationDialogFragment = this.mCreator.createTurnOffTranslationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TURN_OFF_TRANSLATION_TYPE, i);
        dialogFragmentCreateTurnOffTranslationDialogFragment.setArguments(bundle);
        return dialogFragmentCreateTurnOffTranslationDialogFragment;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void show(int i) {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            show(this.mActivity, str, createDialogFragment(i));
        }
    }

    public void turnOff() {
        Logger.m10999d(TAG, "turnOff#");
        this.mMenuPresenterManager.hideOverlayTranslation();
    }
}
