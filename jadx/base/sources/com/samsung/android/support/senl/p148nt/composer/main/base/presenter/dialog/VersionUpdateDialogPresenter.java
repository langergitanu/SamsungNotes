package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VersionUpdateDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("VersionUpdateDialogPresenter");
    private final DialogContract.IDialogCreator mCreator;
    protected Runnable mExitAction;
    protected Runnable mUpdateAction;

    public VersionUpdateDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    public void dismiss() {
        this.mExitAction = null;
        this.mUpdateAction = null;
    }

    public void exit() {
        Runnable runnable = this.mExitAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void show(Runnable runnable, Runnable runnable2) {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            show(this.mActivity, str, this.mCreator.createVersionUpdateDialogFragment());
            this.mExitAction = runnable;
            this.mUpdateAction = runnable2;
        }
    }

    public void update() {
        Runnable runnable = this.mUpdateAction;
        if (runnable != null) {
            runnable.run();
        }
    }
}
