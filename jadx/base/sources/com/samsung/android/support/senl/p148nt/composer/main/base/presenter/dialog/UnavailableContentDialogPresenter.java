package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UnavailableContentDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("UnavailableContentDialogPresenter");
    private final DialogContract.IDialogCreator mCreator;

    public UnavailableContentDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void show() {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            show(this.mActivity, str, this.mCreator.createUnavailableContentDialogFragment());
        }
    }
}
