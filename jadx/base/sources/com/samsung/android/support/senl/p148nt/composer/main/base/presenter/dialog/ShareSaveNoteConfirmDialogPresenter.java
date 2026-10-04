package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareSaveNoteConfirmDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("ShareSaveNoteConfirmDialogPresenter");
    private final DialogContract.IDialogCreator mCreator;
    private int mMessageId;
    protected Runnable mSavePostAction;

    public ShareSaveNoteConfirmDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    public void dismiss() {
        this.mSavePostAction = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public int getMessageId() {
        return this.mMessageId;
    }

    public void save() {
        Runnable runnable = this.mSavePostAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void show(boolean z, Runnable runnable) {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            this.mMessageId = z ? C9086R.string.composer_share_save : C9086R.string.composer_save_as_file_save;
            show(this.mActivity, str, this.mCreator.createShareSaveNoteConfirmDialogFragment());
            this.mSavePostAction = runnable;
        }
    }

    public void show(int i, Runnable runnable) {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            this.mMessageId = i;
            show(this.mActivity, str, this.mCreator.createShareSaveNoteConfirmDialogFragment());
            this.mSavePostAction = runnable;
        }
    }
}
